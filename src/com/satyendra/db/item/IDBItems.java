package com.satyendra.db.item;

import java.sql.*;
import java.util.List;

public interface IDBItems {
	public DBItem add(int itemid, String name, String price, String image, String postedon, int postedbyd,
			int categoryid);

	/*public DBItem delete(int id);

	public DBItem update_itemname(int id);

	public List<DBItem> fetchAll();
	public DBItem fetchbyid(int id);
	public List<DBItem> fetchbycategoryid(int id);
	public List<DBItem> fetchbyuserid(int id);*/
}
