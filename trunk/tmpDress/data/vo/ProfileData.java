package com.otiga.dress.data.vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

public class ProfileData {
	public String id;
	public String fbId;
	public String fbImagePath;
	public String name;
	public String email;
	public String city;
	public String horoscope;
	public boolean isBan;
	public Date createDate;
	public String star;
	public boolean enableFb;
	public String WeatherTipLocation;
	
	public void setParams(ConcurrentHashMap<String, Object> data) {
		String key = "";
		
		key = "id";
		if (data.containsKey(key))
			if (data.get(key) != null)
				id = data.get(key).toString();
		
		key = "FB_id";
		if (data.containsKey(key))
			if (data.get(key) != null)
				fbId = data.get(key).toString();
		
		key = "FB_image";
		if (data.containsKey(key))
			if (data.get(key) != null)
				fbImagePath = data.get(key).toString();
		
		key = "name";
		if (data.containsKey(key))
			if (data.get(key) != null)
				name = data.get(key).toString();
		
		key = "email";
		if (data.containsKey(key))
			if (data.get(key) != null)
				email = data.get(key).toString();
		
		key = "city";
		if (data.containsKey(key))
			if (data.get(key) != null)
				city = data.get(key).toString();
		
		key = "horoscope";
		if (data.containsKey(key))
			if (data.get(key) != null)
				horoscope = data.get(key).toString();
		
		key = "is_ban";
		if (data.containsKey(key))
			if (data.get(key) != null)
				isBan = data.get(key).toString().equals("1") ? true : false;
		
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
		
		key = "star";
		if (data.containsKey(key))
			if (data.get(key) != null)
				star = data.get(key).toString();
		
		key = "enable_FB";
		if (data.containsKey(key))
			if (data.get(key) != null)
				enableFb = data.get(key).toString().equals("1") ? true : false;
		
		key = "WeatherTip_location";
		if (data.containsKey(key))
			if (data.get(key) != null)
				WeatherTipLocation = data.get(key).toString();
		
	}
}
