package com.otiga.dress.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import android.app.Activity;
import android.content.Context;

import com.otiga.dress.data.ConstantTerm;
import com.otiga.dress.data.handler.DressbookAPI;
import com.otiga.dress.data.vo.BrandData;
import com.otiga.dress.data.vo.CategoryData;

public class UtilsFile {
	
	/**
	 * 將最新分類存到file
	 * @param activity
	 */
	public static void updateCategory(final Activity activity){
		DressbookAPI.singleton().getCategory(ConstantTerm.act_user, new DressbookAPI.GetCategoryCallback() {
			@Override
			public void OnGetData(Exception exception, List<CategoryData> list) {
				try {
					activity.deleteFile(ConstantTerm.FILE_CATEGORY);
					FileOutputStream output = activity.openFileOutput(ConstantTerm.FILE_CATEGORY, Context.MODE_PRIVATE);
					ObjectOutputStream oo = new ObjectOutputStream(output);
					oo.writeObject(list);
					oo.close();
					output.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * 從file中取得最新分類
	 * @param activity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<CategoryData> getCategory(final Activity activity){
		try {
			FileInputStream input = activity.openFileInput(ConstantTerm.FILE_CATEGORY);
			ObjectInputStream oi = new ObjectInputStream(input);
			List<CategoryData> tmp = (List<CategoryData>) oi.readObject();
			oi.close();
			input.close();
			return tmp;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 將最新品牌資料存到file
	 * @param activity
	 */
	public static void updateBrand(final Activity activity){
		DressbookAPI.singleton().getBrand(ConstantTerm.act_user, new DressbookAPI.GetBrandCallback() {
			@Override
			public void OnGetData(Exception exception, List<BrandData> list) {
				try {
					activity.deleteFile(ConstantTerm.FILE_BRAND);
					FileOutputStream output = activity.openFileOutput(ConstantTerm.FILE_BRAND, Context.MODE_PRIVATE);
					ObjectOutputStream oo = new ObjectOutputStream(output);
					oo.writeObject(list);
					oo.close();
					output.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * 從file中取得最新品牌資料
	 * @param activity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<BrandData> getBrand(final Activity activity){
		try {
			FileInputStream input = activity.openFileInput(ConstantTerm.FILE_BRAND);
			ObjectInputStream oi = new ObjectInputStream(input);
			List<BrandData> tmp = (List<BrandData>) oi.readObject();
			oi.close();
			input.close();
			return tmp;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
