package com.satyendra.webui.item;

import java.util.ArrayList;
import java.util.List;
import com.satyendra.webui.*;

public class ItemModel {
	private final String name;
	private final String price;
	private final String image;
	private final String postedOn;

	public ItemModel(final String name, final String price, final String image, final String postedOn) {
		this.name = name;
		this.price = price;
		this.image = image;
		this.postedOn = postedOn;
	}

	public String getName() {
		return name;
	}

	/*
	 * public void setName(String name) { this.name = name; }
	 */

	public String getPrice() {
		return price;
	}

	/*
	 * public void setPrice(String price) { this.price = price; }
	 */

	public String getImage() {
		return image;
	}

	/*
	 * public void setImage(String image) { this.image = image; }
	 */

	public String getPostedon() {
		return postedOn;
	}

	/*
	 * public void setPostedon(String postedon) { this.postedon = postedon; }
	 * 
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "name = " + this.name + " ,price =" + this.price + ",image = " + this.image + ",postedOn ="
				+ this.postedOn;
	}

}
