package com.otiga.dress.data.vo;

import java.util.concurrent.ConcurrentHashMap;

import com.otiga.dress.data.ConstantTerm;


public class CategoryListItemData {
	public int id;
	public String category;
	public String imagePath;
	
	public void setParams(ConcurrentHashMap<String, Object> data) {
		String key = "";
		
		key = "id";
		if (data.containsKey(key))
			if (data.get(key) != null)
				id = Integer.valueOf(data.get(key).toString());
		
		key = "category";
		if (data.containsKey(key))
			if (data.get(key) != null)
				category = data.get(key).toString();
		
		key = "image";
		if (data.containsKey(key))
			if (data.get(key) != null)
				imagePath = String.format("%s%s", ConstantTerm.IMAGE_SERVER_PATH, data.get(key).toString());
		
	}
}
