package tw.rackx.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import tw.rackx.app.GV;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.ImageView;
import android.widget.Toast;

public class UtilBase {
	
	/**
	 * 取得螢幕的解析參數
	 * @param context
	 */
	public static void loadScreenResolution(Context context) {
		Display display = ((Activity)context).getWindowManager().getDefaultDisplay();
		if (GV.resolution == null)
			GV.resolution = new Point();
		if (GV.displayMetrics == null)
			GV.displayMetrics = new DisplayMetrics();
		display.getSize(GV.resolution);
		display.getMetrics(GV.displayMetrics);
//		float scaleX = (float)(GV.resolution.x / GV.targetResolution.x);
//		float scaleY = (float)GV.resolution.y / GV.targetResolution.y;
//		scale = scaleX < scaleY ? scaleX : scaleY;
		GV.scaleX = (float)(GV.resolution.x / GV.targetResolution.x);
		GV.scaleY = (float)(GV.resolution.y / GV.targetResolution.y);
		GV.fontScale = GV.scaleX * (1.5f / GV.displayMetrics.density);
	}
	
	/**
	 * 計算縮圖的InSampleSize值
	 * @param options BitmapFactory.Options
	 * @param reqWidth int 預計縮圖的寬
	 * @param reqHeight int 預計縮圖的高
	 * @return
	 */
	public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
		final int height = options.outHeight;
		final int width = options.outWidth;
		int inSampleSize = 1;
		if (height > reqHeight || width > reqWidth) {
			final int heightRatio = Math.round((float) height / (float) reqHeight);
			final int widthRatio = Math.round((float) width / (float) reqWidth);
			inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
		}
		return inSampleSize;
	}

	/**
	 * 將JPEG File Path縮圖用
	 * @param path String FilePath
	 * @param reqWidth int 預計縮圖的寬
	 * @param reqHeight int 預計縮圖的高
	 * @return
	 */
	public static Bitmap decodeSampledBitmap(String path, int reqWidth, int reqHeight) {
	    final BitmapFactory.Options options = new BitmapFactory.Options();
	    options.inPurgeable = true;
	    options.inJustDecodeBounds = true;
	    //BitmapFactory.decodeFile(path, options);
	    
	    try {
			BitmapFactory.Options.class.getField("inNativeAlloc").setBoolean(options,true);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		
	    options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
	    options.inJustDecodeBounds = false;
	    return BitmapFactory.decodeFile(path, options);
	}
	
	/**
	 * 取得JSON字串
	 * @param URL 下載位置
	 * @return JSON String      
	 */
	public static String getContent(String url){
		HttpClient client = new DefaultHttpClient();
		
		HttpParams params = client.getParams();
		HttpConnectionParams.setConnectionTimeout(params, 3000);
		HttpConnectionParams.setSoTimeout(params, 5000);
		HttpGet httpGet = new HttpGet(url);
		
		try {
			HttpResponse response = client.execute(httpGet);			
			HttpEntity entity = response.getEntity();  
			if (entity != null) {  
				String result = EntityUtils.toString(entity, "UTF-8"); 
				return result;
			}			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		return null;
		
	}
	
	/**
	 * 經由JNI底層解碼圖片 ,避免out of memory 
	 * @return 圖片  
	 */
	public static Bitmap readBitMap(Context context, int resId){  
	      BitmapFactory.Options opt = new BitmapFactory.Options();  
	      opt.inPreferredConfig = Bitmap.Config.RGB_565;   
	      opt.inPurgeable = true;  
	      opt.inInputShareable = true;  
	      InputStream is = context.getResources().openRawResource(resId);  
	      return BitmapFactory.decodeStream(is,null,opt);  
	}

	/**
	 * 判斷網路是否可用
	 * @return 是否網路可用      
	 */
	public static boolean isNetCanUse(Context context){
		ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni=cm.getActiveNetworkInfo();
		if(ni!=null && ni.isConnected()){
			return ni.isConnected();
		}else{
			return false;
		}
	}
	
	/**
	 * 顯示無法連網
	 */
	public static void ShowNoNet(Context context){		
		new AlertDialog.Builder(context) 
		.setTitle("網路狀態")
        .setMessage("無法連接網路，請檢查連線。")  
        .setPositiveButton("確定",  
                new DialogInterface.OnClickListener() {  
                    public void onClick(DialogInterface dialog,  
                            int whichButton) { 
                    }  
                })
        .setCancelable(false)
        .show(); 
	}
	
	/**
	 * 顯示獲取數據失敗訊息
	 *    
	 */
	public static void ShowNoData(Context context){		
		Toast.makeText(context, "目前網路連線不穩定，請稍後再試", Toast.LENGTH_LONG).show();
	}
	
	/**
	 * 取得螢幕解析度的寬
	 * @return 螢幕解析度的寬
	 */
	public static int getPixelsWidth(Context context) {
	        DisplayMetrics dm = new DisplayMetrics();
	        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(dm);
	        return (int)dm.widthPixels;
	}
	
	/**
	 * 取得螢幕解析度的高
	 * @return 螢幕解析度的高      
	 */
	public static int getPixelsHeight(Context context) {
	        DisplayMetrics dm = new DisplayMetrics();
	        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(dm);
	        return (int)dm.heightPixels;
	}
	
	/**
	 * 製造button效果
	 * @param imageview 欲改變的圖片
	 * @param brightness 亮度 0(正常),-50(變灰)
	 */
	public static void changeLight(ImageView imageView, int brightness) {
        ColorMatrix cMatrix = new ColorMatrix();
        cMatrix.set(new float[] { 1, 0, 0, 0, brightness, 
        						  0, 1, 0, 0, brightness,// 改變亮度
        						  0, 0, 1, 0, brightness, 
        						  0, 0, 0, 1, 0 });
        imageView.setColorFilter(new ColorMatrixColorFilter(cMatrix));
	}
}
