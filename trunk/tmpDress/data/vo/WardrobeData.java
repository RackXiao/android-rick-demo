package com.otiga.dress.data.vo;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

import com.otiga.dress.data.ConstantTerm;


public class WardrobeData implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public int id;
	public String type;
	public String brand;
	public String category;
	public String imagePath;
	public String title;
	public String link;
	public String whereYouBuy;
	public String description;
	public boolean shared;
	public boolean isOwner;
	
	public void setParams(ConcurrentHashMap<String, Object> data) {
		String key = "";
		
		key = "id";
		if (data.containsKey(key))
			if (data.containsKey(key))
				id = Integer.valueOf(data.get(key).toString());
		
		key = "type";
		if (data.containsKey(key))
			if (data.containsKey(key))
				type = data.get(key).toString();
		
		key = "brand";
		if (data.containsKey(key))
			if (data.containsKey(key))
				brand = data.get(key).toString();
		
		key = "category";
		if (data.containsKey(key))
			if (data.containsKey(key))
				category = data.get(key).toString();
		
		key = "image";
		if (data.containsKey(key))
			if (data.containsKey(key))
				imagePath = String.format("%s%s", ConstantTerm.IMAGE_SERVER_PATH, data.get(key).toString());
		
		key = "title";
		if (data.containsKey(key))
			if (data.containsKey(key))
				title = data.get(key).toString();
		
		key = "link";
		if (data.containsKey(key))
			if (data.containsKey(key))
				link = data.get(key).toString();
		
		key = "where_u_buy";
		if (data.containsKey(key))
			if (data.containsKey(key))
				whereYouBuy = data.get(key).toString();
		
		key = "description";
		if (data.containsKey(key))
			if (data.containsKey(key))
				description = data.get(key).toString();
		
		key = "shared";
		if (data.containsKey(key))
			if (data.containsKey(key))
				shared = data.get(key).toString().equals("1") ? true : false;
		
		key = "is_owner";
		if (data.containsKey(key))
			if (data.containsKey(key))
				isOwner = data.get(key).toString().equals("1") ? true : false;
	}
}
