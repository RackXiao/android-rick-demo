package com.otiga.dress.data.vo;

import java.util.concurrent.ConcurrentHashMap;

public class FollowerInfo {
	public String id;
	public String fbImagePath;
	public String name;
	public String city;
	public int numOfFollower;
	
	public void setParams(ConcurrentHashMap<String, Object> data) {
		String key = "";
		
		key = "id";
		if (data.containsKey(key))
			if (data.get(key) != null)
				id = data.get(key).toString();
		
		key = "FB_image";
		if (data.containsKey(key))
			if (data.get(key) != null)
				fbImagePath = data.get(key).toString();
		
		key = "name";
		if (data.containsKey(key))
			if (data.get(key) != null)
				name = data.get(key).toString();
		
		key = "city";
		if (data.containsKey(key))
			if (data.get(key) != null)
				city = data.get(key).toString();
		
		key = "num_of_follower";
		if (data.containsKey(key))
			if (data.get(key) != null)
				numOfFollower = Integer.valueOf(data.get(key).toString());
		
	}
}