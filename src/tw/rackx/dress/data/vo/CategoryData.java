package com.otiga.dress.data.vo;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;


public class CategoryData implements Serializable{
	private static final long serialVersionUID = 10002410311866660L;
	
	public int id;
	public String name;
	public int parent;
	
	public void setParams(ConcurrentHashMap<String, Object> data) {
		String key = "";
		
		key = "id";
		if (data.containsKey(key))
			if (data.get(key) != null)
				id = Integer.valueOf(data.get(key).toString());
		
		key = "name";
		if (data.containsKey(key))
			if (data.get(key) != null)
				name = data.get(key).toString();
		
		key = "parent";
		if (data.containsKey(key))
			if (data.get(key) != null)
				parent = Integer.valueOf(data.get(key).toString());
		
	}
}
