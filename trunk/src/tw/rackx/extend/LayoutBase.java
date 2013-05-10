package tw.rackx.extend;

import tw.rackx.app.GV;
import android.widget.RelativeLayout;

public class LayoutBase {
	
	protected static int BaseId = 100;
	
	protected static RelativeLayout setBaseLayoutScreenResolution(RelativeLayout rLayout){
		RelativeLayout.LayoutParams rParams = new RelativeLayout.LayoutParams((int)(GV.targetResolution.x * GV.scaleX), (int)(GV.targetResolution.y * GV.scaleX));
		rParams.setMargins((int)(((float)GV.resolution.x - (GV.targetResolution.x * GV.scaleX)) / 2.0f), (int)(((float)GV.resolution.y - (GV.targetResolution.y * GV.scaleX)) / 2.0f), 0, 0);
		rLayout.setLayoutParams(rParams);
		return rLayout;
	}
}
