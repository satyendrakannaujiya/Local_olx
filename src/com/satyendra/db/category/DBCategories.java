package com.satyendra.db.category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBCategories implements IDBCategories {
	// private int id;
	private static Connection DBConnections;

	public DBCategories(Connection DBConnection) {

		this.DBConnections = DBConnection;
	}

	public IDBCategory add(int id, String title, String image, String description) {
		try {
			Statement stmt = DBConnections.createStatement();
			stmt.executeUpdate("INSERT INTO CATEGORIES (CATEGORIES_ID,TITLE,IMAGE,DESCRIPTION) VALUES (" + id + ",'"
					+ title + "','" + image + "','" + description + "')");

			// stmt.executeUpdate("INSERT INTO TEST (NAME,ADDRESS) VALUES
			// ('"+title+"','"+image+"')");
			return new DBCategory(id, DBConnections);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return new DBCategory(id, DBConnections);
		}
	}

	public IDBCategory update_title(int id) {
		DBCategory db = new DBCategory(0, DBConnections);
		try {
			Statement stmt = DBConnections.createStatement();
			stmt.executeUpdate("UPDATE CATEGORIES SET TITLE='NEW TITLE' WHERE CATEGORIES_ID=" + id + "");
			// while (rs.next()) {

			db = new DBCategory(id, DBConnections);
			// }
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();

		}
		return db;
	}

	public IDBCategory delete(int id) {
		DBCategory db = new DBCategory(0, DBConnections);
		try {
			Statement stmt = DBConnections.createStatement();
			stmt.executeUpdate("DELETE FROM CATEGORIES WHERE CATEGORIES_ID=" + id + "");
			// while (rs.next()) {

			db = new DBCategory(id, DBConnections);
			// }
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();

		}
		return db;
	}

	public List<DBCategory> fetch_all() {
		List<DBCategory> list = new ArrayList<>();
		try {
			Statement stmt = DBConnections.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT CATEGORIES_ID FROM CATEGORIES");
			while (rs.next()) {

				list.add(new DBCategory(rs.getInt("CATEGORIES_ID"), DBConnections));
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();

		}
		return list;
	}
	public DBCategory fetchbyid(int id)
	{
		DBCategory db = new DBCategory(0, DBConnections);
		try {
			Statement stmt = DBConnections.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT CATEGORIES_ID FROM CATEGORIES WHERE CATEGORIES_ID=" + id + "");
			while (rs.next()) {

				db = new DBCategory(rs.getInt("CATEGORIES_ID"), DBConnections);
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();

		}
		return db;
	}
}
