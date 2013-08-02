package com.otiga.dress.data.vo;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

import com.otiga.dress.data.ConstantTerm;

public class CoverItemData implements Serializable{

	private static final long serialVersionUID = 1L;
	public int id;
	public String type;
	public String brand;
	public int category;
	public String image;
	public String title;
	public String link;
	public String description;
	public String whereYouBuy;
	public String haveThis;
	public boolean shared;
	public boolean isOwner;
	public int insFromUser;
	
	public void setParams(ConcurrentHashMap<String, Object> data) {
		String key = "";

		key = "id";
		if (data.containsKey(key))
			if (data.get(key) != null)
				id = Integer.valueOf(data.get(key).toString());
		
		key = "type";
		if (data.containsKey(key))
			if (data.get(key) != null)
				type = data.get(key).toString();

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
				image = String.format("%s%s", ConstantTerm.IMAGE_SERVER_PATH, data
						.get(key).toString());

		key = "title";
		if (data.containsKey(key))
			if (data.get(key) != null)
				title = data.get(key).toString();

		key = "link";
		if (data.containsKey(key))
			if (data.get(key) != null)
				link = data.get(key).toString();

		key = "description";
		if (data.containsKey(key))
			if (data.get(key) != null)
				description = data.get(key).toString();
		
		key = "where_u_buy";
		if (data.containsKey(key))
			if (data.get(key) != null)
				whereYouBuy = data.get(key).toString();
		
		key = "have_this";
		if (data.containsKey(key))
			if (data.get(key) != null)
				haveThis = data.get(key).toString();

		key = "shared";
		if (data.containsKey(key))
			if (data.get(key) != null)
				shared = (Integer.valueOf(data.get(key).toString()) == 1 ? true : false);
		
		key = "is_owner";
		if (data.containsKey(key))
			if (data.get(key) != null)
				isOwner = (Integer.valueOf(data.get(key).toString()) == 1 ? true : false);
		
		key = "ins_from_user";
		if (data.containsKey(key))
			if (data.get(key) != null)
				id = Integer.valueOf(data.get(key).toString());
	}
}
