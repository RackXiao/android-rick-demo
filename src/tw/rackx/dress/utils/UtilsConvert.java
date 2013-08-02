package com.otiga.dress.utils;

import java.util.List;

import com.otiga.dress.data.vo.CategoryData;

public class UtilsConvert {
	
	/**
     * 將子分類字串轉成其所屬id
     * @param cate
     * @return id
     */
    public static int subCategoryString2id(List<CategoryData> my_category_list, String cate){
    	int id = 0;
    	for(int i = 0; i<my_category_list.size(); i++){
    		final CategoryData data = my_category_list.get(i);
    		if(data.name.equals(cate)){
    			return data.id;
    		}
    	}
    	return id;
    }
    
    /**
     * 將id轉成其所屬子分類字串
     * @param id
     * @return String
     */
    public static String id2subCategoeyString(List<CategoryData> my_category_list, int id){
    	String tmp="";
    	for(int i = 0; i<my_category_list.size(); i++){
    		final CategoryData data = my_category_list.get(i);
    		if(data.id == id){
    			return data.name;
    		}
    	}
    	return tmp;
    }
    
    /**
     * 根據id轉成其所屬主分類字串
     * @param id
     * @return String 
     */
    public static String id2mainCategoeyString(List<CategoryData> my_category_list, int id){
    	String tmp = "";
    	int parent = 0;
    	for(int i = 0; i<my_category_list.size(); i++){
    		final CategoryData data = my_category_list.get(i);
    		if(data.id == id){
    			parent = data.parent;
    		}
    	}
    	for(int i = 0; i<my_category_list.size(); i++){
    		final CategoryData data = my_category_list.get(i);
    		if(data.id == parent){
    			return data.name;
    		}
    	}
    	return tmp;
    }
}
