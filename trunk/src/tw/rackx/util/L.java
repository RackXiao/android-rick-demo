package tw.rackx.util;

import android.util.Log;

public class L
{
	public static int displayLevel = Log.VERBOSE;

	public static void d(String tag, String msg){
		if(Log.DEBUG >= displayLevel) Log.d(tag, msg);
	}

	public static void i(String tag, String msg){
		if(Log.INFO >= displayLevel) Log.i(tag, msg);
	}

	public static void e(String tag, String msg){
		if(Log.ERROR >= displayLevel) Log.e(tag, msg);
	}

	public static void v(String tag, String msg){
		if(Log.VERBOSE >= displayLevel) Log.v(tag, msg);
	}

	public static void w(String tag, String msg){
		if(Log.WARN >= displayLevel) Log.w(tag, msg);
	}

	public static void d(String tag, String msg, Throwable tr){
		if(Log.DEBUG >= displayLevel) Log.d(tag, msg, tr);
	}

	public static void i(String tag, String msg, Throwable tr){
		if(Log.INFO >= displayLevel) Log.i(tag, msg, tr);
	}

	public static void e(String tag, String msg, Throwable tr){
		if(Log.ERROR >= displayLevel) Log.e(tag, msg, tr);
	}

	public static void v(String tag, String msg, Throwable tr){
		if(Log.VERBOSE >= displayLevel) Log.v(tag, msg, tr);
	}

	public static void w(String tag, String msg, Throwable tr){
		if(Log.WARN >= displayLevel) Log.w(tag, msg, tr);
	}
}
