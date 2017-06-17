package com.satyendra.db.category;

import java.util.List;

public interface IDBCategories {
	public IDBCategory add(int id, String title, String image, String Description);

	public IDBCategory update_title(int id);

	public IDBCategory delete(int id);

	public List<DBCategory> fetch_all();

	public DBCategory fetchbyid(int x);
}
