package com.satyendra.webui;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.satyendra.webui.category.CategoryModel;
import com.satyendra.db.category.*;
import com.satyendra.db.item.*;
import com.satyendra.db.user.*;
import com.satyendra.db.util.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method s;
		System.out.println("show error");
		
		Connection conn = DBConnection.ConnectDb();
		DBCategories dbcategories = new DBCategories(conn);
		List<DBCategory> categories = new ArrayList<>();
		categories = dbcategories.fetch_all();
		List<CategoryModel> viewcategorieslist = new ArrayList<>();
		for (DBCategory dbcat : categories) {
			CategoryModel model = new CategoryModel();
			String title = dbcat.title();
			String image = dbcat.image();
			String description = dbcat.description();
			int id = dbcat.id();
			model.setTitle(title);
			model.setImage(image);
			model.setDescription(description);
			model.setId(id);
			viewcategorieslist.add(model);
		}
		DBConnection.closeConnection();
		request.setAttribute("categories", viewcategorieslist);
		String action = request.getParameter("action");
		System.out.println("action : " + action);
		String target = "";
		if ("VIEW_HOME".equals(action)) {
			target = "/views/home/home.jsp";
		} else if ("VIEW_ITEMS".equals(action)) {
			target = "/viewItems";
		}
		System.out.println("target : " + target);
		
		forward(request, response, target);
		
		//response.sendRedirect("https://www.google.co.in/search?site=&source=hp&q=satyendra");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void forward(HttpServletRequest request, HttpServletResponse response, final String target)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher(target).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
