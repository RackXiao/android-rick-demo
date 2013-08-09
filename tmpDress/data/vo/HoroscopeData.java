package com.otiga.dress.data.vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

public class HoroscopeData {

	public Date date;
	public String star;
	public String image;
	public String content;
	
	
	public void setParams(ConcurrentHashMap<String, Object> data) {
		String key = "";
		
		key = "date";
		if (data.containsKey(key)) {
			if (data.get(key) != null) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
				try {
					date = format.parse(data.get(key).toString());
				} catch (java.text.ParseException e) {
					e.printStackTrace();
				}
			}
		}
		
		key = "star";
		if (data.containsKey(key)) {
			if (data.get(key) != null)
				star = data.get(key).toString();
		}
		
		key = "image";
		if (data.containsKey(key)) {
			if (data.get(key) != null)
				image = data.get(key).toString();
		}
		
		key = "content";
		if (data.containsKey(key)) {
			if (data.get(key) != null) 
				content = data.get(key).toString();
		}
	}
}
