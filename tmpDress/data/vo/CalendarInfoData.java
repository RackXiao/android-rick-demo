package com.otiga.dress.data.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

import com.otiga.dress.data.ConstantTerm;

public class CalendarInfoData implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public int id;
	public Date date;
	public String type;
	public String brand;
	public int category;
	public String imagePath;
	public String title;
	public String link;
	public String whereYouBuy;
	public String description;
	public boolean shared;
	public boolean isOwner;
	
	public void setParams(ConcurrentHashMap<String, Object> data) {
		String key = "";
		
		key = "date";
		if (data.containsKey(key))
			if (data.get(key) != null) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
				try {
					date = format.parse(data.get(key).toString());
				} catch (java.text.ParseException e) {
				    e.printStackTrace();
				}
			}
		
		key = "type";
		if (data.containsKey(key))
			if (data.get(key) != null)
				type = data.get(key).toString();
		
		key = "id";
		if (data.containsKey(key))
			if (data.get(key) != null)
				id = Integer.valueOf(data.get(key).toString());
		
		key = "brand";
		if (data.containsKey(key))
			if (data.get(key) != null)
				brand = data.get(key).toString();
		
		key = "category";
		if (data.containsKey(key))
			if (data.get(key) != null)
				category = Integer.valueOf(data.get(key).toString());
		
		key = "image";
		if (data.containsKey(key))
			if (data.get(key) != null)
				imagePath = String.format("%s%s", ConstantTerm.IMAGE_SERVER_PATH, data.get(key).toString());
		
		key = "title";
		if (data.containsKey(key))
			if (data.get(key) != null)
				title = data.get(key).toString();
		
		key = "link";
		if (data.containsKey(key))
			if (data.get(key) != null)
				link = data.get(key).toString();
		
		key = "where_u_buy";
		if (data.containsKey(key))
			if (data.get(key) != null)
				whereYouBuy = data.get(key).toString();
		
		key = "description";
		if (data.containsKey(key))
			if (data.get(key) != null)
				description = data.get(key).toString();
		
		key = "shared";
		if (data.containsKey(key))
			if (data.get(key) != null)
				shared = data.get(key).toString().equals("1") ? true : false;
		
		key = "is_owner";
		if (data.containsKey(key))
			if (data.get(key) != null)
				isOwner = data.get(key).toString().equals("1") ? true : false;
		
	}

}
