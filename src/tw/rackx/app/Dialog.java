package tw.rackx.app;

import tw.rackx.R;
import tw.rackx.util.L;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Dialog extends Activity {
	private static final String TAG = Dialog.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// HIDDEN TITLE
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);

		setView();

		L.d(TAG, "onCreate");
	}

	private void setView() {
		setContentView(R.layout.dialog);

		Button btnShowDialog = (Button) findViewById(R.id.BtnShowDialog);
		btnShowDialog.setOnClickListener(lsBtnShowDialog);
		Button btnShowListDialog = (Button) findViewById(R.id.BtnShowListDialog);
		btnShowListDialog.setOnClickListener(lsBtnShowListDialog);

	}

	private OnClickListener lsBtnShowDialog = new OnClickListener() {
		@Override
		public void onClick(View v) {
			new AlertDialog.Builder(Dialog.this).setTitle("標題")
					.setMessage("我是內容").setPositiveButton("左邊按鈕", nothing)
					.setNeutralButton("中間按鈕", nothing)
					.setNegativeButton("右邊按鈕", nothing).show();
		}
	};

	private OnClickListener lsBtnShowListDialog = new OnClickListener() {

		@Override
		public void onClick(View v) {
			new AlertDialog.Builder(Dialog.this).setTitle("標題")
					.setItems(ListStr, listClick)
					.setNeutralButton("中間按鈕", nothing).show();
		}
	};

	private android.content.DialogInterface.OnClickListener nothing = new android.content.DialogInterface.OnClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which) {
		}
	};

	final String[] ListStr = { "1", "2", "3", "4", "5", "6", "7", "8" };
	private android.content.DialogInterface.OnClickListener listClick = new android.content.DialogInterface.OnClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			showMsgDialog(ListStr[which]);
		}
	};

	private void showMsgDialog(String string) {
		new AlertDialog.Builder(Dialog.this).setMessage(string)
				.setNeutralButton("確定", nothing).show();
	}

}
