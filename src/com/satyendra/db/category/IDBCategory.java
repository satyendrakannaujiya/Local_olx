package com.satyendra.db.category;
import java.util.List;
import com.satyendra.db.user.*;
import com.satyendra.db.category.*;
import com.satyendra.db.item.*;
public interface IDBCategory {
       public String title();
       public String image();
       public String description();
      
       public List<DBItem> items();
}
