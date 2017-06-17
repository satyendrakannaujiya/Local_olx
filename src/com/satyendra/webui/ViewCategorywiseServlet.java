package com.satyendra.webui;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.satyendra.authentication.*;

import com.satyendra.db.category.*;
import com.satyendra.db.item.*;
import com.satyendra.db.user.*;
import com.satyendra.db.util.*;
import com.satyendra.idgeneration.*;
import com.satyendra.logout.*;
import com.satyendra.validation.*;
import com.satyendra.webui.*;
import com.satyendra.webui.category.*;
import com.satyendra.webui.item.*;



public class ViewCategorywiseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCategorywiseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String str = request.getParameter("${list.title}");
		System.out.println(""+str);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
