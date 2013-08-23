package tw.rackx.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import tw.rackx.dao.GV;
import android.os.Environment;

public class FileManager {
	private static FileManager singleton;
	
	private boolean mExternalStorageAvailable = false;
	private boolean mExternalStorageWriteable = false;

	private File vSDCard;
	private File vPath;
	
	public static FileManager singleton(){
		if( null == singleton ){
			singleton = new FileManager();
		}
		return singleton;
	}

	private FileManager(){
		chkStorageAvailable();
		
		vSDCard = Environment.getExternalStorageDirectory();
        vPath = new File( vSDCard.getAbsolutePath() + "/" + GV.PACKAGE_NAME + "/" );
//        vFile = vPath.getAbsolutePath() + "/" + fileName;
	}
	
	private void chkStorageAvailable(){
		String state = Environment.getExternalStorageState();
		
		if (Environment.MEDIA_MOUNTED.equals(state)) {
		    // We can read and write the media
		    mExternalStorageAvailable = mExternalStorageWriteable = true;
		} else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
		    // We can only read the media
		    mExternalStorageAvailable = true;
		    mExternalStorageWriteable = false;
		} else {
		    // Something else is wrong. It may be one of many other states, but all we need
		    //  to know is we can neither read nor write
		    mExternalStorageAvailable = mExternalStorageWriteable = false;
		}
	}
	
	public void writeFile(String fileName, Object obj){
		if(!mExternalStorageWriteable) return;
		
		 // 判斷目錄是否存在
        if( !vPath.exists() )
           vPath.mkdirs();
        
        String vFile = vPath.getAbsolutePath() + "/" + fileName;
        // 寫入檔案
		try {
//			FileWriter vFile = new FileWriter( vPath.getAbsolutePath() + "/" + fileName );
//	        vFile.write(str);
//	        vFile.close();
	        
			FileOutputStream output = new FileOutputStream(vFile);
			ObjectOutputStream oo = new ObjectOutputStream(output);
			oo.writeObject(obj);
			oo.close();
			output.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Object readFile(String fileName){
		if(!mExternalStorageAvailable) return null;

		String vFile = vPath.getAbsolutePath() + "/" + fileName;
        File file = new File( vFile );
        
        if(!file.exists()) return null;
        
        Object tmp = null;
        
		try {
			FileInputStream input = new FileInputStream(vFile);
			ObjectInputStream oi = new ObjectInputStream(input);
			tmp = oi.readObject();
			oi.close();
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return tmp;
	}
}
