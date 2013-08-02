package com.otiga.dress.data.vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

import com.otiga.dress.data.ConstantTerm;

public class WeatherInfoData {

	public Date date;
	public int location;
	public String temperature;
	public String weatherImage;
	public String weatherDescription;
	public String description;
	public String image;
	public String suggestion;
	
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
		
		key = "location";
		if (data.containsKey(key)) {
			if (data.get(key) != null) 
				location = Integer.valueOf(data.get(key).toString());
		}
		
		key = "temperateure";
		if (data.containsKey(key)) {
			if (data.get(key) != null) 
				temperature = data.get(key).toString();
		}
		
		key = "weather_image";
		if (data.containsKey(key)) {
			if (data.get(key) != null) 
				weatherImage = data.get(key).toString();
		}
		
		key = "weather_description";
		if (data.containsKey(key)) {
			if (data.get(key) != null)
				weatherDescription = data.get(key).toString();
		}
			
		key ="description";
		if (data.containsKey(key)) {
			if (data.get(key) != null) 
				description = data.get(key).toString();
		}
		
		key = "image";
		if (data.containsKey(key)) {
			if (data.get(key) != null)
				image = String.format("%s%s", ConstantTerm.IMAGE_SERVER_PATH, data.get(key).toString());
		}
		
		key = "suggestion";
		if (data.containsKey(key)) {
			if (data.get(key) != null)
				suggestion = data.get(key).toString();
		}
	}
}
