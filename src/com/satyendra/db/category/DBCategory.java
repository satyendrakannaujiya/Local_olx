package com.satyendra.db.category;
import com.satyendra.db.user.*;
import com.satyendra.db.category.*;
import com.satyendra.db.item.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBCategory implements IDBCategory {
	// private final String result;
	private final int id;
	private final Connection dbConnection;
	private ResultSet rs;
	private DBItems dbitems;

	public DBCategory(final int id, final Connection dbConnection) {
		this.id = id;
		this.dbConnection = dbConnection;
	}

	public DBCategory(int id, DBItems dbitems, Connection dbConnection) {
		this.id = id;
		this.dbConnection = dbConnection;
		this.dbitems = dbitems;
	}
       public int id()
       {
    	   return this.id;
       }
	public String title() {
		String result = "";
		try {
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT TITLE FROM CATEGORIES WHERE CATEGORIES_ID=" + this.id + "");
			while (rs.next()) {

				result = rs.getString("TITLE");
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return result;
	}

	public String image() {
		String result = "";
		try {
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT IMAGE FROM CATEGORIES WHERE CATEGORIES_ID=" + this.id + "");
			while (rs.next()) {

				result = rs.getString("IMAGE");
			}

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return result;
	}

	public String description() {
		String result = "";
		try {
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT DESCRIPTION FROM CATEGORIES WHERE CATEGORIES_ID=" + this.id + "");
			while (rs.next()) {

				result = rs.getString("DESCRIPTION");
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();

		}
		return result;
	}
	public List<DBItem> items() {
             return dbitems.fetchbycategoryid(this.id);
	}
}
