package tw.rackx.app;

import tw.rackx.extend.ExtendActivity;
import tw.rackx.layout.LayoutDiscuss;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DiscussActivity extends ExtendActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(LayoutDiscuss.getDiscussLayout(this));
		
		initBtnEvent();
	}
	
	private void initBtnEvent() {
		Button btn;
		btn = (Button) findViewById(LayoutDiscuss.BtnSend);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
//				Intent intent = new Intent(CalcActivity.this, CalcCDPActivity.class);
//	    		startActivity(intent);
			}
		});
	}
}
