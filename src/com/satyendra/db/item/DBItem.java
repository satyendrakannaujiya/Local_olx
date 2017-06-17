package com.satyendra.db.item;
import com.satyendra.db.user.*;
import com.satyendra.db.category.*;
import com.satyendra.db.item.*;
import java.sql.*;
public class DBItem implements IDBItem {
	private int id;
	private Connection dbConnection;

	public DBItem(int id, Connection conn) {
		this.id = id;
		this.dbConnection = conn;
	}

	public String itemname() {
		String result = "";
		try {
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT ITEM_NAME FROM ITEMS WHERE ITEM_ID=" + this.id + "");
			while (rs.next()) {

				result = rs.getString("ITEM_NAME");
			}
			//dbConnection.close();
		} catch (Exception e) {
			System.out.println("Error occure while fetching item name"+ e.getMessage());
			//e.printStackTrace();
		}
		return result;
	}

	public String price() {
		String result = "";
		try {
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT PRICE FROM ITEMS WHERE ITEM_ID=" + this.id + "");
			while (rs.next()) {

				result = rs.getString("PRICE");
			}
//			dbConnection.close();
		} catch (Exception e) {
			System.out.println("Error occure while fetching item name"+ e.getMessage());
			//e.printStackTrace();
		}
		return result;
	}

	public String image() {
		String result = "";
		try {
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT IMAGE FROM ITEMS WHERE ITEM_ID=" + this.id + "");
			while (rs.next()) {

				result = rs.getString("IMAGE");
			}
//			dbConnection.close();
		} catch (Exception e) {
			System.out.println("Error occure while fetching item name"+ e.getMessage());
			//e.printStackTrace();
		}
		return result;
	}

	public String postedon() {
		String result = "";
		try {
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT POSTED_ON FROM ITEMS WHERE ITEM_ID=" + this.id + "");
			while (rs.next()) {

				result = rs.getString("POSTED_ON");
			}
//			dbConnection.close();
		} catch (Exception e) {
			System.out.println("Error occure while fetching item name"+ e.getMessage());
			//e.printStackTrace();
		}
		return result;
	}

	public DBUser postedby() {
		int id = 0;
		try {
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT POSTED_BY FROM ITEMS WHERE ITEM_ID=" + this.id + "");
			while (rs.next()) {

				id = rs.getInt("POSTED_BY");
			}

		} catch (Exception e) {
			System.out.println("Error occure while fetching item name"+ e.getMessage());
			//e.printStackTrace();
		}
		return new DBUser(id, dbConnection);
		// dbConnection.close();
	}

	public DBCategory categoryid() {
		int id = 0;
		try {
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT CATEGORY_ID FROM ITEMS WHERE ITEM_ID=" + this.id + "");
			while (rs.next()) {

				id = rs.getInt("CATEGORY_ID");
			}

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return new DBCategory (id, dbConnection);
		// dbConnection.close()
	}
}
