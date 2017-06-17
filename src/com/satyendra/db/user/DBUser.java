package com.satyendra.db.user;
import java.sql.*;
import java.util.List;
import com.satyendra.db.user.*;
import com.satyendra.db.category.*;
import com.satyendra.db.item.*;
public class DBUser implements IDBUser{
               private int id;
               private Connection dbConnection;
               private DBItems items;
               public DBUser(int id,Connection conn)
               {
            	   this.id=id;
            	   this.dbConnection=conn;
               }
               public DBUser(int id,DBItems items,Connection dbConnection)
               {
            	   this.id=id;
            	   this.items=items;
            	   this.dbConnection=dbConnection;
               }
 public String address() {
          		 String result = "";
          		try {
          			Statement stmt = dbConnection.createStatement();
          			ResultSet rs = stmt.executeQuery("SELECT ADDRESS FROM USERS WHERE USERID=" + this.id + "");
          			while (rs.next()) {

          				result = rs.getString("ADDRESS");
          			}
          		}
          			 catch (Exception e) {
          					System.out.println(e);
          					e.printStackTrace();
          				}
          		return result;
          	}
 public String name() {
		 String result = "";
		try {
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT NAME FROM USERS WHERE USERID=" + this.id + "");
			while (rs.next()) {

				result = rs.getString("NAME");
			}
		}
			 catch (Exception e) {
					System.out.println(e);
					e.printStackTrace();
				}
		return result;
	}
 public String mobile() {
		 String result = "";
		try {
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT MOBILE FROM USERS WHERE USERID=" + this.id + "");
			while (rs.next()) {

				result = rs.getString("MOBILE");
			}
		}
			 catch (Exception e) {
					System.out.println(e);
					e.printStackTrace();
				}
		return result;
	}
 public String email() {
		 String result = "";
		try {
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT EMAIL FROM USERS WHERE USERID=" + this.id + "");
			while (rs.next()) {

				result = rs.getString("EMAIL");
			}
		}
			 catch (Exception e) {
					System.out.println(e);
					e.printStackTrace();
				}
		return result;
	}
 public String password() {
		 String result = "";
		try {
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT PASSWORD FROM USERS WHERE USERID=" + this.id + "");
			while (rs.next()) {

				result = rs.getString("PASSWORD");
			}
		}
			 catch (Exception e) {
					System.out.println(e);
					e.printStackTrace();
				}
		return result;
	}
 public List<DBItem> items() {
                  return items.fetchbyuserid(this.id);
	}
}
