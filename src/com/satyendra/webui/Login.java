package com.satyendra.webui;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.satyendra.webui.item.*;
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
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String path;
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		if(action.equals("SIGNIN"))
			path="/views/post/post.jsp";
		else
			if(action.equals("SIGNUP"))
				path="/views/signup/signup.jsp";
			forward(request,response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void forward(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
