package com.satyendra.webui;

import java.io.IOException;
import com.satyendra.validation.*;
import com.satyendra.idgeneration.*;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.sql.*;
import com.satyendra.authentication.*;
import com.satyendra.db.*;
import com.satyendra.db.user.DBUser;
import com.satyendra.db.util.DBConnection;
import java.util.Date;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.satyendra.db.category.*;
import com.satyendra.db.item.*;
import com.satyendra.db.user.*;

/**
 * Servlet implementation class PostAdsServlet
 */
public class PostAdsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int postedby;
	private int categoryid;
	private int id;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostAdsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.getWriter().append("Served at: ").append(request.getContextPath());

		String category = request.getParameter("category");
		String productName = request.getParameter("productname");
		String price = request.getParameter("price");
		String image = request.getParameter("pic");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String category = request.getParameter("category");
		String productName = request.getParameter("productname");
		String price = request.getParameter("price");
		String image = request.getParameter("pic");

		Part filePart = request.getPart("pic"); // Retrieves <input type="file"

		System.out.println("file part : " + filePart);

		String fileName = getFileName(filePart);
		System.out.println("file Name : " + fileName);

		String errorName = validateProductName(productName);
		String errorprice = validatePrice(price);
		String errorfile = validateImage(fileName);
        String message="";
		if (errorName != "")
		{
			message=message+errorName;
			request.setAttribute("productname", errorName);
		}
		
		if (errorprice != "")
		{
			message=message+errorprice;
			request.setAttribute("productprice", errorprice);
		}
		
		if (errorfile != "")
		{
			message=message+errorfile;
			request.setAttribute("productimage", errorfile);
		}
		if(message!="")
		{
		request.setAttribute("message", message);
		String path = "/views/post/post.jsp";
		forward(request,response,path);
		}
		filePart.write(fileName);
		// doGet(request, response);

		// ID for items
		Connection dbConnection = DBConnection.ConnectDb();
		try {
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT ID FROM UNIQUE_ID");
			while (rs.next()) {

				id = rs.getInt("ID");
			}
			stmt.executeUpdate("UPDATE UNIQUE_ID SET ID=" + (this.id + 1) + "");
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}

		// posted on

		Date date = new Date();
		String postedon = date.toString();

		// respective user id

		try {
			HttpSession session = request.getSession(true);
			String username = (String) session.getAttribute("userName");
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT USERID FROM USERS WHERE EMAIL='" + username + "'");
			while (rs.next()) {

				postedby = rs.getInt("USERID");
			}
			// return new DBCategory(id, DBConnections);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			// return new DBCategory(id, DBConnections);
		}

		// respective category id

		try {
			HttpSession session = request.getSession(true);
			String username = (String) session.getAttribute("userName");
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT CATEGORIES_ID FROM CATEGORIES WHERE TITLE='" + category + "'");
			while (rs.next()) {

				categoryid = rs.getInt("CATEGORIES_ID");
			}
			// return new DBCategory(id, DBConnections);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			// return new DBCategory(id, DBConnections);
		}

		// add to the item database
		System.out.println("itemid::" + this.id + "category::" + category + "productname::" + productName + "price::"
				+ price + "images::" + fileName + "postedon::" + postedon + "postedby::" + postedby + "catedoryid::"
				+ categoryid);

		DBItems items = new DBItems(dbConnection);
		items.add(this.id, productName, price, fileName, postedon, postedby, categoryid);
		// items.add(50, "productName", "price", "image", "postedon", 101, 20);
		forward(request, response);
	}

	private String getFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		System.out.println("content-disposition header= " + contentDisp);
		String[] tokens = contentDisp.split(";");
		for (String token : tokens) {
			if (token.trim().startsWith("filename")) {
				return token.substring(token.indexOf("=") + 2, token.length() - 1);
			}
		}
		return "";
	}

	private String validateProductName(String productName) {
		boolean result = Validator.isNullOrEmpty(productName);

		String msg = result ? "Please enter product name" : "";
		return msg;
	}

	private String validatePrice(String price) {
		boolean result = Validator.isValidNumber(price);

		String msg = result ? "" : "Please enter vaid price";
		return msg;
	}

	private String validateImage(String fileName) {
		boolean result = Validator.isNullOrEmpty(fileName);

		String msg = result ? "Please enter image" : "";
		return msg;
	}

	public void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/home?action=VIEW_HOME").forward(request, response);
	}
	public void forward(HttpServletRequest request, HttpServletResponse response,String path) throws ServletException, IOException {
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}
}
