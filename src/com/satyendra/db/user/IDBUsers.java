package com.satyendra.db.user;

import java.util.List;

public interface IDBUsers {
              public DBUser add(int id, String address, String name, String mobile,String email,String password);
              public DBUser delete(int id);
              public DBUser update_name(int id);
              public List<DBUser> fetch_all();
              public  DBUser fetchbyid(int id);
              
}
