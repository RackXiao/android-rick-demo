package tw.rackx.extend;

import android.app.Activity;
import android.view.MenuItem;

public class ExtendActivity extends Activity {
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// TODO Auto-generated method stub
//			break;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
