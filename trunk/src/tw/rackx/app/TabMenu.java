package tw.rackx.app;

import tw.rackx.R;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

public class TabMenu extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabmenu);

		Resources res = getResources(); // Resource object to get Drawables
		TabHost tabHost = getTabHost(); // The activity TabHost
		TabHost.TabSpec spec; // Resusable TabSpec for each tab
		Intent intent; // Reusable Intent for each tab

//		// 將xml轉換為View且指定給TabContentView
//		LayoutInflater.from(this).inflate(R.layout.tabframe,
//				tabHost.getTabContentView(), true);
//
//		// 設定各tab頁面by指定View id
//		tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("TAB1")
//				.setContent(R.id.tab1));
//
//		tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("TAB2")
//				.setContent(R.id.tab2));

		// Create an Intent to launch an Activity for the tab (to be reused)
		intent = new Intent().setClass(this, AHome.class);

		// Initialize a TabSpec for each tab and add it to the TabHost
		spec = tabHost
				.newTabSpec("artists")
				.setIndicator("Artists",
						res.getDrawable(R.drawable.ic_tab_artists))
				.setContent(intent);
		tabHost.addTab(spec);

		// Do the same for the other tabs
		intent = new Intent().setClass(this, Dialog.class);
		spec = tabHost
				.newTabSpec("albums")
				.setIndicator("Albums",
						res.getDrawable(R.drawable.ic_tab_albums))
				.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, TabMenu.class);
		spec = tabHost
				.newTabSpec("songs")
				.setIndicator("Songs", res.getDrawable(R.drawable.ic_tab_songs))
				.setContent(intent);
		tabHost.addTab(spec);
		
		//
		// tabHost.setCurrentTab(2);
	}
}
