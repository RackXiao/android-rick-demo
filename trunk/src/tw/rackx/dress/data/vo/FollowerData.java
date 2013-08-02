package com.otiga.dress.data.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;



public class FollowerData {
	public List<FollowerInfo> followerList;
	public int maxCount;
	
	public FollowerData() {
		followerList = new ArrayList<FollowerInfo>();
	}
	
	@SuppressWarnings("unchecked")
	public void setParams(ConcurrentHashMap<String, Object> data) {
		String key = "";
		
		key = "data";
		if (data.containsKey(key))
			if (data.get(key) != null) {
				List<ConcurrentHashMap<String, Object>> list = (List<ConcurrentHashMap<String, Object>>) data.get(key);
				for (ConcurrentHashMap<String, Object> detail : list) {
					FollowerInfo info = new FollowerInfo();
					info.setParams(detail);
					followerList.add(info);
				}
			}
		
		key = "max_count";
		if (data.containsKey(key))
			if (data.get(key) != null)
				maxCount = Integer.valueOf(data.get(key).toString());
	}
}

