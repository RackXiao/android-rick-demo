package com.otiga.dress.data.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


public class FBFriendData {

	public List<FBFriendInfo> useInfo;
	public List<FBFriendInfo> notUseInfo;
	
	public FBFriendData() {
		useInfo = new ArrayList<FBFriendInfo>();
		notUseInfo = new ArrayList<FBFriendInfo>();
	}
	
	@SuppressWarnings("unchecked")
	public void setParams(ConcurrentHashMap<String, Object> map) {
		String key = "";
		
		key = "use";
		if (map.containsKey(key))
			if (map.get(key) != null) {
				List<ConcurrentHashMap<String, Object>> list = (List<ConcurrentHashMap<String, Object>>) map.get(key);
				for (ConcurrentHashMap<String, Object> detail : list) {
					FBFriendInfo info = new FBFriendInfo();
					info.setParams(detail);
					useInfo.add(info);
				}
			}
		
		key = "not_use";
		if (map.containsKey(key))
			if (map.get(key) != null) {
				List<ConcurrentHashMap<String, Object>> list = (List<ConcurrentHashMap<String, Object>>) map.get(key);
				for (ConcurrentHashMap<String, Object> detail : list) {
					FBFriendInfo info = new FBFriendInfo();
					info.setParams(detail);
					notUseInfo.add(info);
				}
			}
	}
}
