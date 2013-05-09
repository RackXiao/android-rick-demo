package tw.rackx.app.calc;

import tw.rackx.R;
import tw.rackx.app.GV;
import tw.rackx.extend.ExtendActivity;
import tw.rackx.layout.LayoutCalc;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalcCDPActivity extends ExtendActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(LayoutCalc.getCalcCDPLayout(this));
		
		initEditText();
		initBtnEvent();
		calc();
	}
	
	private void initEditText() {
		EditText et = null;
		// 設值
		et = (EditText) findViewById(LayoutCalc.ETOPEN);
		et.setText(String.valueOf(GV.SP.getInt("CDP_o", 0)));
		et = (EditText) findViewById(LayoutCalc.ETHIGH);
		et.setText(String.valueOf(GV.SP.getInt("CDP_h", 0)));
		et = (EditText) findViewById(LayoutCalc.ETLOW);
		et.setText(String.valueOf(GV.SP.getInt("CDP_l", 0)));
		et = (EditText) findViewById(LayoutCalc.ETCLOSE);
		et.setText(String.valueOf(GV.SP.getInt("CDP_c", 0)));
	}

	private void initBtnEvent() {
		Button btn;
		btn = (Button) findViewById(LayoutCalc.ETBtnCalcCDP);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				calc();
			}
		});
	}

	private void calc() {
		EditText et = null;
		TextView tv = null;
		int o = 0;
		int h = 0;
		int l = 0;
		int c = 0;
		
		// 取值
		et = (EditText) findViewById(LayoutCalc.ETOPEN);
		if(!"".equals(et.getText().toString()))
			o = Integer.valueOf(et.getText().toString());
		et = (EditText) findViewById(LayoutCalc.ETHIGH);
		if(!"".equals(et.getText().toString()))
			h = Integer.valueOf(et.getText().toString());
		et = (EditText) findViewById(LayoutCalc.ETLOW);
		if(!"".equals(et.getText().toString()))
			l = Integer.valueOf(et.getText().toString());
		et = (EditText) findViewById(LayoutCalc.ETCLOSE);
		if(!"".equals(et.getText().toString()))
			c = Integer.valueOf(et.getText().toString());

		Editor ed =  GV.SP.edit();
		ed.putInt("CDP_o", o);
		ed.putInt("CDP_h", h);
		ed.putInt("CDP_l", l);
		ed.putInt("CDP_c", c);
		ed.commit();
		
		if(0!=h&&0!=l&&0!=c){
			float hbop3 = 0;
			float hbop2 = 0;
			float hbop1 = 0;
			float bop = 0;
			float lbop1 = 0;
			float lbop2 = 0;
			float lbop3 = 0;
			
			// 運算
			bop = Math.round((h + l + c)/3 * 100) / 100;
			hbop3 = 2*bop + h - 2*l;
			hbop2 = bop + h - l;
			hbop1 = 2*bop - l;
			lbop1 = 2*bop - h;
			lbop2 = bop + l - h;
			lbop3 = 2*bop + l - 2*h;
			
			// 顯示
			tv = (TextView) findViewById(LayoutCalc.ETTVH3);
			tv.setText(getString(R.string.ret_h3) + "：" + String.valueOf(hbop3));
			tv = (TextView) findViewById(LayoutCalc.ETTVH2);
			tv.setText(getString(R.string.ret_h2) + "：" + String.valueOf(hbop2));
			tv = (TextView) findViewById(LayoutCalc.ETTVH1);
			tv.setText(getString(R.string.ret_h1) + "：" + String.valueOf(hbop1));
			tv = (TextView) findViewById(LayoutCalc.ETTVBOP);
			tv.setText(getString(R.string.ret_bop) + "：" + String.valueOf(bop));
			tv = (TextView) findViewById(LayoutCalc.ETTVL1);
			tv.setText(getString(R.string.ret_l1) + "：" + String.valueOf(lbop1));
			tv = (TextView) findViewById(LayoutCalc.ETTVL2);
			tv.setText(getString(R.string.ret_l2) + "：" + String.valueOf(lbop2));
			tv = (TextView) findViewById(LayoutCalc.ETTVL3);
			tv.setText(getString(R.string.ret_l3) + "：" + String.valueOf(lbop3));
		}
	}
}
