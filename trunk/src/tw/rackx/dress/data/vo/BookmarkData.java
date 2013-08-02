package com.otiga.dress.data.vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

import com.otiga.dress.data.ConstantTerm;

public class BookmarkData {
	public int id;
	public String userId;
	public String imagePath;
	public String area;
	public int priority;
	public int isBan;
	public int isIndex;
	public Date createDate;
	public Date updateDate;
	public Date banDate;
	public String fbImagePath;
	public String name;
	public int numOfLike;
	
	public void setParams(ConcurrentHashMap<String, Object> data) {
		String key = "";
		
		key = "id";
		if (data.containsKey(key))
			if (data.get(key) != null)
				id = Integer.valueOf(data.get(key).toString());

		key = "User_id";
		if (data.containsKey(key))
			if (data.get(key) != null)
				userId = data.get(key).toString();
		
		key = "image";
		if (data.containsKey(key))
			if (data.get(key) != null)
				imagePath = String.format("%s%s", ConstantTerm.IMAGE_SERVER_PATH, data.get(key).toString());
		
		key = "area";
		if (data.containsKey(key))
			if (data.get(key) != null)
				area = data.get(key).toString();
		
		key = "priority";
		if (data.containsKey(key))
			if (data.get(key) != null)
				priority = Integer.valueOf(data.get(key).toString());
		
		key = "create_date";
		if (data.containsKey(key))
			if (data.get(key) != null) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault());
				try {
					createDate = format.parse(data.get(key).toString());
				} catch (java.text.ParseException e) {
				    e.printStackTrace();
				}
			}
		
		key = "update_date";
		if (data.containsKey(key))
			if (data.get(key) != null) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault());
				try {
					updateDate = format.parse(data.get(key).toString());
				} catch (java.text.ParseException e) {
				    e.printStackTrace();
				}
			}
		
		key = "FB_image";
		if (data.containsKey(key))
			if (data.get(key) != null)
				fbImagePath = data.get(key).toString();
		
		key = "name";
		if (data.containsKey(key))
			if (data.get(key) != null)
				name = data.get(key).toString();
		
		key = "num_of_like";
		if (data.containsKey(key))
			if (data.get(key) != null)
				numOfLike = Integer.valueOf(data.get(key).toString());
		
	}
}
