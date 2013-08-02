package com.otiga.dress.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.otiga.dress.data.ConstantTerm;
import com.otiga.dress.data.vo.CategoryData;
import com.otiga.dress.data.vo.CoverItemData;
import com.otiga.dress.layout.component.AbstractPanel;
import com.otiga.dress.layout.component.CollapsePanel;
import com.otiga.dress.layout.component.NewExpandPanel;
import com.otiga.dress.layout.component.AbstractPanel.Theme;
import com.otiga.dressbook.ItemDetailActivity;
import com.otiga.dressbook.SubListActivity;



public class UtilsComponentWithData {
	
	public interface SetCategoryCallback{
		List<CoverItemData> setData(String categoryKey, CollapsePanel coPanel, NewExpandPanel panel);
	};
	/**
	 * =======產生兩層menu=======
	 * 外層(coPanel)(父類)可收合,內層可點擊進入清單(exPanel)(子類)
	 * 先建立外層,在建立內層共有的  "所有XX"的項目,再建立其他子類	 
	 * @param activity
	 * @param scale
	 * @param width
	 * @param height
	 * @param layout
	 * @param callback
	 */
	public static void getCategoryExpandPanel(
			final Activity activity,
			final float scale,
			final int width,
			final int height,
			final RelativeLayout layout,
			final int type,
			SetCategoryCallback callback) {

		CollapsePanel coPanel = null;
		NewExpandPanel exPanel = null;
		int position = 0;	// for id setting
		// 取得所有類別
		List<CategoryData> category = UtilsFile.getCategory(activity);
		// parents父類別
		ArrayList<CategoryData> parents = getCategoryParent(category);
		for(final CategoryData fa : parents){
			// 建立父類別的 Collapse Panel
			RelativeLayout.LayoutParams rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			if (coPanel != null)
				rParams.addRule(RelativeLayout.BELOW, coPanel.getId());
			else
				rParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
			coPanel = new CollapsePanel(activity);
			coPanel.setId(1000000 * position + 1);
			coPanel.setCategoryTitle(fa.name);
			layout.addView(coPanel, rParams);
			
			// ==每一父類的子類別list ==
			ArrayList<AbstractPanel> childBarList = new ArrayList<AbstractPanel>();
			
			// 加入在此父類下的所有子類資料
			ArrayList<CategoryData> children = getCategoryChild(category, fa.id);		
			final ArrayList<CoverItemData> allChildren = new ArrayList<CoverItemData>();
						
			// 增加"所有XX"名稱的子類
			rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);			
			exPanel = new NewExpandPanel(activity);
			exPanel.setCategoryTitle("所有"+fa.name);
			
			//"所有XX"的內容
			for(final CategoryData child : children){
				final List<CoverItemData> childDataList = callback.setData("c"+child.id, coPanel, exPanel);
				if(childDataList != null){
					for(final CoverItemData child2 : childDataList){
						allChildren.add(child2);
					}
				}
				
			}
			setPanelContent(exPanel,Theme.GREEN, fa.name, 1000000 * position + 1,allChildren);

			//"所有XX"的點擊事件
			if(allChildren != null){
				if(allChildren.size() > 0){
					setPanelIntent(activity,exPanel,"所有"+fa.name,type,allChildren);
				}
			}
			childBarList.add(exPanel);	
			position++;	
			
			// 建立並加入子類別
			for(final CategoryData child : children){
						
				rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);			
				exPanel = new NewExpandPanel(activity);
				exPanel.setCategoryTitle(child.name);
				
				final List<CoverItemData> childDataList = callback.setData("c"+child.id, coPanel, exPanel);				
				setPanelContent(exPanel,Theme.GREEN, fa.name,1000000 * position + 1,childDataList);
				
				if(childDataList != null){
					if(childDataList.size() > 0){
						setPanelIntent(activity,exPanel,child.name,type,childDataList);
					}
				}
				
				childBarList.add(exPanel);				
				position++;
			}
			coPanel.setCategoryList(childBarList);
			position++;
		}
		
	}
	
	private static void setPanelContent(NewExpandPanel exPanel, Theme theme, String category, int id, List<CoverItemData> list){
		exPanel.setTheme(theme);
		exPanel.setMainCategory(category);
		exPanel.setId(id);		
		exPanel.setCategoryList(list);
	}
	
	private static void setPanelIntent(
			final Activity activity, 
			NewExpandPanel exPanel,
			final String title, 
			final int type,
			final List<CoverItemData> list){
		
		exPanel.setOnClickListener(new View.OnClickListener() {					
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(activity,SubListActivity.class);
				intent.putExtra("title",title);
				intent.putExtra("type",type);
				intent.putExtra(ConstantTerm.ListCoverItemData, (Serializable)list);
				activity.startActivityForResult(intent, ItemDetailActivity.ItemDetailIntent);
			}
		});
	}

	public static ArrayList<CategoryData> getCategoryChild(List<CategoryData> category, int parentId) {
		ArrayList<CategoryData> children = new ArrayList<CategoryData>();
		for(CategoryData cate : category){
			if(cate.parent == parentId)
				children.add(cate);
		}
		return children;
	}

	public static ArrayList<CategoryData> getCategoryParent(List<CategoryData> category) {
		return getCategoryChild(category, 0);
	}
}
