package com.otiga.dress.data.vo;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

public class BrandData implements Serializable{
	private static final long serialVersionUID = 10002410311866660L;
	
	public String name;
	
	public void setParams(ConcurrentHashMap<String, Object> data) {
		String key = "";
		
		key = "name";
		if (data.containsKey(key))
			if (data.get(key) != null)
				name = data.get(key).toString();
	}
}
