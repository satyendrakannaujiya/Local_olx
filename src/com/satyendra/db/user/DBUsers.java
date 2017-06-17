package com.satyendra.db.user;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUsers implements IDBUsers {
	private Connection dbConnection;

	public DBUsers(Connection conn) {
		this.dbConnection = conn;
	}

	public DBUser add(int id, String address, String name, String mobile, String email, String password) {
		try {
			Statement stmt = dbConnection.createStatement();
			stmt.executeUpdate("INSERT INTO USERS (USERID,ADDRESS,NAME,MOBILE,EMAIL,PASSWORD) VALUES (" + id + ",'"
					+ address + "','" + name + "','" + mobile + "','" + email + "','" + password + "')");
			// return new DBCategory(id, DBConnections);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			// return new DBCategory(id, DBConnections);
		}
		return new DBUser(id, dbConnection);
	}

	public DBUser delete(int id) {
		DBUser db = new DBUser(0, dbConnection);
		try {
			Statement stmt = dbConnection.createStatement();
			stmt.executeUpdate("DELETE FROM USERS WHERE USERID=" + id + "");
			// while (rs.next()) {

			db = new DBUser(id, dbConnection);
			// }
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();

		}
		return db;
	}

	public DBUser update_name(int id) {
		DBUser db = new DBUser(0, dbConnection);
		try {
			Statement stmt = dbConnection.createStatement();
			stmt.executeUpdate("UPDATE USERS SET NAME='NEW NAME' WHERE USERID=" + id + "");

			db = new DBUser(id, dbConnection);

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();

		}
		return db;
	}

	public List<DBUser> fetch_all() {
		List<DBUser> list = new ArrayList<>();
		try {
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT USERID FROM USERS");
			while (rs.next()) {

				list.add(new DBUser(rs.getInt("USERID"), dbConnection));
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();

		}
		return list;

	}

	public DBUser fetchbyid(int id) {
		DBUser db = new DBUser(0, dbConnection);
		try {
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT USERID FROM USERS WHERE USERID=" + id + "");
			while (rs.next()) {

				db = new DBUser(rs.getInt("USERID"), dbConnection);
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();

		}
		return db;
	}

	
}
