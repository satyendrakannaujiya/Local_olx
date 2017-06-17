package com.satyendra.db.item;
import com.satyendra.db.user.*;
import com.satyendra.db.category.*;
import com.satyendra.db.item.*;
public interface IDBItem {
	public String itemname();
	public String price();
	public String image();
	public String postedon();
	public DBUser postedby();
	public DBCategory categoryid();
}
