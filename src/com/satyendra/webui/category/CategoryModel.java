package com.satyendra.webui.category;
import com.satyendra.webui.*;



import java.util.ArrayList;
import java.util.List;
public class CategoryModel {
        private String image;
        private String description;
        private String title;
        private int id;
        
        public CategoryModel()
        {
        	
        }
          
		public String getImage() {
			return image;
		}

		public String getDescription() {
			return description;
		}

		public String getTitle() {
			return title;
		}
		public int getId() {
			return id;
		}

		public void setImage(String image) {
			this.image = image;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public void setId(int id) {
			this.id = id;
		}
        
}
