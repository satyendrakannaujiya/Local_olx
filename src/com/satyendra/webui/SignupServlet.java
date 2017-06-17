package com.satyendra.webui;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import com.satyendra.db.util.*;
import com.satyendra.db.user.*;
/**
 * Servlet implementation class SignupServlet
 */
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private String city;
       private String name;
       private String mobile;
       private String email;
       private String password;
       private int id;
       private Connection dbConnection;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		city=request.getParameter("city");
		name=request.getParameter("name");
		mobile=request.getParameter("mobile");
		email=request.getParameter("email");
		password=request.getParameter("password");
		//get id from uniqueid
		dbConnection=DBConnection.ConnectDb();
		try
		{
			Statement stmt = dbConnection.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT ID FROM UNIQUE_ID");
			while (rs.next()) {

				id = rs.getInt("ID");
			}
			stmt.executeUpdate("UPDATE UNIQUE_ID SET ID="+(this.id+1)+"");
		}
		catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		DBUsers dbuser = new DBUsers(dbConnection);
		dbuser.add(id, city, name, mobile, email, password);
		forward(request,response);
	}
	public void forward(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
				getServletContext().getRequestDispatcher("/views/login/login.jsp").forward(request, response);
			}

	
	
}
