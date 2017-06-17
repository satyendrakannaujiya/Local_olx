package com.satyendra.webui;

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

public class ViewItemsServlet extends HttpServlet {
	String path;
	int count = 0;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewItemsServlet() {
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
		System.out.println("Home1");

		String action = request.getParameter("action");
		System.out.println(action);

		if (action.equals("plus")) {
			path = "/views/login/login.jsp";
		}

		else {
			  if(action.equals("viewcategorywise"))
					  {
				          String id=request.getParameter("categoryid");
				          int id1 = Integer.parseInt(id);
				         // System.out.println("iddddd::"+id1);
				          getItemsbycategories(request, response,id1);
				          path = "/views/item/item.jsp";
				          
					  }
			  else
			  {
			getItems(request, response);
			path = "/views/item/item.jsp";
			  }
		}
		forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	public void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(path);
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void getItems(final HttpServletRequest request, final HttpServletResponse response) {
		Connection conn = DBConnection.ConnectDb();
		DBItems items = new DBItems(conn);
		List<DBItem> itemList = items.fetchAll();

		List<ItemModel> viewitemlist = new ArrayList<>();

		for (DBItem dbItem : itemList) {
           
			
			 /* String name = dbitemss.itemname(); String price =
			  dbitemss.price(); String postedon = dbitemss.postedon(); String
			  image = dbitemss.image();*/
			 
			 ItemModel model = new ItemModel(dbItem.itemname(),
		 dbItem.price(), dbItem.postedon(),
			 dbItem.image());
			/*
			 * model.setName(name); model.setPrice(price);
			 * model.setPostedon(postedon);
			 */
			 viewitemlist.add(model);
			// count++;
			//dbItem.itemname();

		}
		DBConnection.closeConnection();
		request.setAttribute("allItems", viewitemlist);

	}
	public void getItemsbycategories(HttpServletRequest request, HttpServletResponse response,int id1)
	{
		Connection conn = DBConnection.ConnectDb();
		DBItems items = new DBItems(conn);
		List<DBItem> itemList = new ArrayList();
		try {
		//System.out.println("hellooooo");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT ITEM_ID FROM ITEMS WHERE CATEGORY_ID=" + id1 + "");
			while (rs.next()) {
                     //System.out.println("hellooooo");
			    	itemList.add(new DBItem(rs.getInt("ITEM_ID"), conn));
			//	System.out.println("hellooooo");
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();

		}
		List<ItemModel> viewitemlist = new ArrayList<>();
		if(itemList!=null)
		{
		for (DBItem dbItem : itemList) {
	           
			 ItemModel model = new ItemModel(dbItem.itemname(),
		 dbItem.price(), dbItem.postedon(),
			 dbItem.image());
			 viewitemlist.add(model);
			
		}
		}
		DBConnection.closeConnection();
		request.setAttribute("allItems", viewitemlist);
	}

}
