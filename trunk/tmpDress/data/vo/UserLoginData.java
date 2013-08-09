package com.otiga.dress.data.vo;

import org.json.JSONException;
import org.json.JSONObject;

public class UserLoginData {
	
	public String returnCode;
	public String userId;
	public String userName;
	
	public void setParams(JSONObject jsonObject){
		try {
			returnCode =  jsonObject.getString("ret");
			userId = jsonObject.getString("User_id");
			userName= jsonObject.getString("name");
			
		} catch (JSONException e) {
			e.printStackTrace();
		}		
	}
}
