package com.otiga.dress.layout.component;

import java.util.ArrayList;
import android.content.Context;
import android.widget.RelativeLayout;

/**
 * 定義panel抽象類,使用父類操作子類方法
 * @author TSD-Kevin
 *
 */
public abstract class AbstractPanel extends RelativeLayout {
	
	// THEME
	public enum Theme{
		WHITE,
		BLACK,
		GREEN,
	};
	
	public AbstractPanel(Context context) {
		super(context);
	}

	public abstract ArrayList<RelativeLayout> getCategoryList();
	
	public abstract int getCategoryListCount();

	public abstract void setTheme(Theme theme);

	public abstract void setCategoryTitle(String title);
	
	
}
