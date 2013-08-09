package com.otiga.dress.data.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


public class DailyTipsInfoData {

	public List<WeatherInfoData> weatherList;
	public HoroscopeData horoscope;
	
	public DailyTipsInfoData() {
		weatherList = new ArrayList<WeatherInfoData>();
		horoscope = new HoroscopeData();
	}
	
	@SuppressWarnings("unchecked")
	public void setParams(ConcurrentHashMap<String, Object> map) {
		String key = "";
		
		key = "weather";
		if (map.containsKey(key)) {
			if (map.get(key) != null) {
				List<ConcurrentHashMap<String, Object>> list = (List<ConcurrentHashMap<String, Object>>) map.get(key);
				for (ConcurrentHashMap<String, Object> detail : list) {
					WeatherInfoData info = new WeatherInfoData();
					info.setParams(detail);
					weatherList.add(info);
				}
			}
		}
		
		key = "horoscope";
		if (map.containsKey(key)) {
			if (map.get(key) != null) {
				ConcurrentHashMap<String, Object> data = (ConcurrentHashMap<String, Object>) map.get(key);
				horoscope.setParams(data);
			}
		}
	}
}
