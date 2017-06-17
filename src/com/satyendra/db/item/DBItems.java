package com.satyendra.db.item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBItems implements IDBItems {
	Connection dbConnection;

	public DBItems(Connection conn) {
		this.dbConnection = conn;
	}

	public DBItem add(int itemid, String name, String price, String image, String postedon, int postedby,
			int categoryid) {
		try {
			Statement stmt = dbConnection.createStatement();
			stmt.executeUpdate(
					"INSERT INTO ITEMS (ITEM_ID,ITEM_NAME,PRICE,IMAGE,POSTED_ON,POSTED_BY,CATEGORY_ID) VALUES ("
							+ itemid + ",'" + name + "','" + price + "','" + image + "','" + postedon + "'," + postedby
							+ "," + categoryid + ")");

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();

		}
		return new DBItem(itemid, dbConnection);
	}

	public DBItem delete(int id) {
		DBItem db = new DBItem(0, dbConnection);
		try {
			Statement stmt = dbConnection.createStatement();
			stmt.executeUpdate("DELETE FROM ITEMS WHERE ITEM_ID=" + id + "");

			db = new DBItem(id, dbConnection);

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();

		}
		return db;
	}

	public DBItem update_itemname(int id) {
		DBItem db = new DBItem(0, dbConnection);
		try {
			Statement stmt = dbConnection.createStatement();
			stmt.executeUpdate("UPDATE ITEMS SET ITEM_NAME='NEW NAME' WHERE ITEM_ID=" + id + "");

			db = new DBItem(id, dbConnection);

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();

		}
		return db;
	}

	public List<DBItem> fetchAll() {
		List<DBItem> list = new ArrayList<>();
		try {
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT ITEM_ID FROM ITEMS");
			while (rs.next()) {

				list.add(new DBItem(rs.getInt("ITEM_ID"), dbConnection));
			}
		} catch (Exception e) {
			System.out.println("Error while fetching all item "+e.getMessage());
			//e.printStackTrace();

		}
		return list;

	}

	public DBItem fetchbyid(int id) {
		DBItem db = new DBItem(0, dbConnection);
		try {
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT ITEM_ID FROM ITEMS WHERE ITEM_ID=" + id + "");
			while (rs.next()) {

				db = new DBItem(rs.getInt("ITEM_ID"), dbConnection);
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();

		}
		return db;
	}
	public List<DBItem> fetchbycategoryid(int id)
	{
		List<DBItem> list = new ArrayList<>();
		try {
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT ITEM_ID FROM ITEMS WHERE CATEGORY_ID="+id+"");
			while (rs.next()) {

				list.add(new DBItem(rs.getInt("ITEM_ID"), dbConnection));
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();

		}
		return list;
		
	}
	public List<DBItem> fetchbyuserid(int id)
	{
		List<DBItem> list = new ArrayList<>();
		try {
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT ITEM_ID FROM ITEMS WHERE POSTED_BY="+id+"");
			while (rs.next()) {

				list.add(new DBItem(rs.getInt("ITEM_ID"), dbConnection));
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();

		}
		return list;
		
	}

}