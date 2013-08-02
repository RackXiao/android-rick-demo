package com.otiga.dress.utils;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.androidquery.AQuery;
import com.otiga.dress.data.vo.CoverItemData;
import com.otiga.dress.layout.LayoutManager;
import com.otiga.dress.layout.component.WardrobeItemView;


/**
 * 單品的刪除模組
 * @author TSD-Kevin
 *
 */
public class UtilsFunction {
	
	public interface SetDeleteViewCallback{
		void getResult(boolean result,List<Integer> itemIds);
	};
	
	/**
	 * 把View加上刪除Icon, 並設置點擊可刪除View
	 * 
	 * @param activity 
	 * @param dataItemList  List<CoverItemData>資料
 	 * @param viewItemList 	存View的List
	 * @param isShowIcon	是否顯示刪除圖案
	 * @param callback		告知是否被刪除,哪個東西被刪除
	 */
	public static void showDeleteIcon(
								final Activity activity, 
								final List<CoverItemData> dataItemList, 
								List<WardrobeItemView> viewItemList,
								boolean isShowIcon,
								final SetDeleteViewCallback callback){

		final AQuery aq = new AQuery(activity);
		
		if (viewItemList != null && viewItemList.size() > 0) {
			for (int i = 0; i < viewItemList.size(); i++) {
				final int index = i;
				viewItemList.get(i).itemImage.setClickable(isShowIcon);
				viewItemList.get(i).setDeleteIcon(isShowIcon);
				viewItemList.get(i).deleteImage.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						View layout = LayoutManager.getDeleteDialogView(activity);
						AlertDialog.Builder builder = new AlertDialog.Builder(activity);
						builder.setView(layout);
						final AlertDialog alertDialog = builder.create(); 
						alertDialog.show();
						final List<Integer> itemIds = new ArrayList<Integer>();
						itemIds.add(dataItemList.get(index).id);
						
						ImageView photo = (ImageView)layout.findViewById(LayoutManager.DeleteViewPhoto);
						aq.id(photo).image(String.format("%s_small.jpg", dataItemList.get(index).image));
						
						Button button = (Button)layout.findViewById(LayoutManager.DeleteViewButtonOK);
						button.setOnClickListener(new OnClickListener() {
							@Override
							public void onClick(View v) {
								alertDialog.dismiss();
								callback.getResult(true,itemIds);//刪除,回傳true,並給予id
							}
						});
						
						button = (Button)layout.findViewById(LayoutManager.DeleteViewButtonCancel);
						button.setOnClickListener(new OnClickListener() {
							@Override
							public void onClick(View v) {
								alertDialog.cancel();
								callback.getResult(false,null);
							}
						});
					}
				});
			}
		}
		
	}
	
}
