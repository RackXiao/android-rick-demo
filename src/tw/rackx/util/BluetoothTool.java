package tw.rackx.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class BluetoothTool {
	
	private static BluetoothAdapter mBluetoothAdapter = null; // 用來搜尋、管理藍芽裝置
	private static BluetoothSocket mBluetoothSocket = null; // 用來連結藍芽裝置、以及傳送指令
	private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"); // 因為連線是用serial port，所以固定用這組。
	private static OutputStream mOutputStream = null;
	private final static int REQUEST_ENABLE_BT=1;
	
	public static void initBluetooth(Activity context){
		
		mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		if (mBluetoothAdapter == null) {
		    // 如果裝置不支援藍芽
		    Toast.makeText(context, "Device doesn't support bluetooth", Toast.LENGTH_SHORT).show();
		    return;
		}
		        
		// 如果藍芽沒有開啟
		if (!mBluetoothAdapter.isEnabled()) {
		    // 發出一個intent去開啟藍芽，
		        Intent mIntentOpenBT = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
		        context.startActivityForResult(mIntentOpenBT, REQUEST_ENABLE_BT);
		}
	}
	
	public static void getPairedDevices(){
		// 取得目前已經配對過的裝置
		Set<BluetoothDevice> setPairedDevices = mBluetoothAdapter.getBondedDevices();
		        
		// 如果已經有配對過的裝置
		if (setPairedDevices.size() > 0) {
		    // 把裝置名稱以及MAC Address印出來
		    for (BluetoothDevice device : setPairedDevices) {
//		        mArrayAdapter.add(device.getName() + "\n" + device.getAddress());
		    }
		}
	}
	
	public static void closeBluetooth(){
		try {
	        if (mBluetoothSocket.isConnected()){
	            mBluetoothSocket.close();
	        }
//	        unregisterReceiver(mReceiver);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
