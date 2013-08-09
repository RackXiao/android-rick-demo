package com.otiga.dress.data.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

import com.otiga.dress.data.ConstantTerm;



public class CoverInfoData implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public int id;
	public String userId;
	public String imagePath;
	public String area;
	public int priority;
	public boolean isBan;
	public boolean isIndex;
	public Date createDate;
	public Date updateDate;
	public Date banDate;
	public String username;
	public String city;
	public String fbImagePath;
	public boolean isLike;
	public boolean isBookmark;
	public boolean isDislike;
	public int hasComment;
	public int numOfLike;
	public int numOfBookmark;
	public int numOfDislike;
	public int numOfComments;
	//Event Look
	public boolean isEvent;
	public String name;
	public String link;
	
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
		
		key = "is_ban";
		if (data.containsKey(key))
			if (data.get(key) != null)
				isBan = data.get(key).toString().equals("1") ? true : false;
		
		key = "is_index";
		if (data.containsKey(key))
			if (data.get(key) != null)
				isIndex = data.get(key).toString().equals("1") ? true : false;
		
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
		
		key = "ban_date";
		if (data.containsKey(key))
			if (data.get(key) != null) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault());
				try {
					banDate = format.parse(data.get(key).toString());
				} catch (java.text.ParseException e) {
					e.printStackTrace();
				}
			}
		
		key = "User_name";
		if (data.containsKey(key))
			if (data.get(key) != null)
				username = data.get(key).toString();
		
		key = "city";
		if (data.containsKey(key))
			if (data.get(key) != null)
				city = data.get(key).toString();
		
		key = "FB_image";
		if (data.containsKey(key))
			if (data.get(key) != null)
				fbImagePath = data.get(key).toString();
		
		key = "is_like";
		if (data.containsKey(key))
			if (data.get(key) != null)
				isLike = data.get(key).toString().equals("1") ? true : false;
		
		key = "is_bookmark";
		if (data.containsKey(key))
			if (data.get(key) != null)
				isBookmark = data.get(key).toString().equals("1") ? true : false;

		key = "is_dislike";
		if (data.containsKey(key))
			if (data.get(key) != null)
				isDislike = data.get(key).toString().equals("1") ? true : false;
		
		key = "has_comment";
		if (data.containsKey(key))
			if (data.get(key) != null)
				hasComment = Integer.valueOf(data.get(key).toString());
		
		key = "num_of_like";
		if (data.containsKey(key))
			if (data.get(key) != null)
				numOfLike = Integer.valueOf(data.get(key).toString());
		
		key = "num_of_bookmark";
		if (data.containsKey(key))
			if (data.get(key) != null)
				numOfBookmark = Integer.valueOf(data.get(key).toString());

		key = "num_of_dislike";
		if (data.containsKey(key))
			if (data.get(key) != null)
				numOfDislike = Integer.valueOf(data.get(key).toString());
		
		key = "num_of_comments";
		if (data.containsKey(key))
			if (data.get(key) != null)
				numOfComments = Integer.valueOf(data.get(key).toString());
		
		key = "is_event";
		if (data.containsKey(key))
			if (data.get(key) != null)
				isEvent = data.get(key).toString().equals("1") ? true : false;
		
		key = "name";
		if (data.containsKey(key))
			if (data.get(key) != null)
				name = data.get(key).toString();
		
		key = "link";
		if (data.containsKey(key))
			if (data.get(key) != null)
				link = data.get(key).toString();
				
	}
}
