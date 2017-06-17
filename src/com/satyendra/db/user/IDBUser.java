package com.satyendra.db.user;

import java.util.List;
import com.satyendra.db.user.*;
import com.satyendra.db.category.*;
import com.satyendra.db.item.*;
public interface IDBUser {
	  public String address();
	  public String name();
	  public String mobile();
	  public String email();
	  public String password();
	  public List<DBItem> items();
}
