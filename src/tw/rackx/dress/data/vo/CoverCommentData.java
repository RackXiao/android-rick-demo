package com.otiga.dress.data.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.json.JSONException;
import org.json.JSONObject;


public class CoverCommentData {
	
	public int id;
	public String User_id;
	public String username;
	public String message;
	public String fbImagePath;
	public Date createDate;
	
	public void setParams(JSONObject jsonObject){
		try {
			id =  Integer.valueOf(jsonObject.getString("id"));
			User_id = jsonObject.getString("User_id");
			username= jsonObject.getString("User_name");
			message = jsonObject.getString("message");
			fbImagePath = jsonObject.getString("FB_image");		
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault());
			createDate = format.parse(jsonObject.getString("create_date"));
			
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	/*public void setParams(ConcurrentHashMap<String, Object> data) {
		String key = "";
		
		key = "id";
		if (data.containsKey(key))
			if (data.get(key) != null)
				id = Integer.valueOf(data.get(key).toString());
		
		key = "User_id";
		if (data.containsKey(key))
			if (data.get(key) != null)
				User_id = data.get(key).toString();
		
		key = "User_name";
		if (data.containsKey(key))
			if (data.get(key) != null)
				username = data.get(key).toString();
		
		key = "message";
		if (data.containsKey(key))
			if (data.get(key) != null)
				message = data.get(key).toString();
		
		key = "FB_image";
		if (data.containsKey(key))
			if (data.get(key) != null)
				fbImagePath = data.get(key).toString();
		
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
	}*/

}
