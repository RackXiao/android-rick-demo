package tw.rackx.app.calc;

import tw.rackx.extend.ExtendActivity;
import tw.rackx.layout.LayoutCalc;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CalcActivity extends ExtendActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(LayoutCalc.getCalcMenuLayout(this));
		
		initBtnEvent();
	}
	
	private void initBtnEvent() {
		Button btn;
		btn = (Button) findViewById(LayoutCalc.BtnCalcCDP);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(CalcActivity.this, CalcCDPActivity.class);
	    		startActivity(intent);
			}
		});
	}
}
