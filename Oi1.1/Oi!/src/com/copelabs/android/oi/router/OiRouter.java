package com.copelabs.android.oi.router;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.copelabs.android.oi.*;

import android.content.Context;
import android.util.Log;

public class OiRouter {
	public static final String TAG = "OiRouter";
	
	
	public OiRouter (Context context) {
		
	}
	
	
	public static List<Integer> getListMsg(HashMap i, HashMap j, String macAddressPeer, List<GetMessages> listofmsg){
		
		
		
		List<Integer> msgtobesent = new ArrayList<Integer>();
		//SW & MAC from the device//
		HashMap<String,String> swFromDevice=i;
		//SW & MAC from the received data from announcement//
		HashMap<String,String> swOfReceivedPeer=j;
		
		String macAddressOfPeer=macAddressPeer;
		
		Log.d(TAG,"swFromDevice : "+swFromDevice);
		Log.d(TAG,"swOfReceivedPeer : "+swOfReceivedPeer);
		Log.d(TAG,"macAddressOfPeer : "+macAddressOfPeer);
		
		for(int a=0; a<listofmsg.size();a++)
		{
		Log.d(TAG,"Meaasge "+a+" : "+listofmsg.get(a).msgDest);
		}
		
		for(int x=0;x<listofmsg.size();x++)
		{
			Log.d(TAG,"listofmsg.get(x).msgDest: "+listofmsg.get(x).msgDest);
			Log.d(TAG,"swFromDevice.get(listofmsg.get(x).msgDest): "+swFromDevice.get(listofmsg.get(x).msgDest));
			Log.d(TAG,"swOfReceivedPeer.get(listofmsg.get(x).msgDest): "+swOfReceivedPeer.get(listofmsg.get(x).msgDest));
			Log.d(TAG,"Value of X : "+x);
			if(listofmsg.get(x).msgDest.equals(macAddressOfPeer) )
			{
				Log.d(MainActivity.TAG,"Value of X in first if condition: "+x);
				msgtobesent.add(listofmsg.get(x).msgId);
				Log.d(MainActivity.TAG,"Added msgId: "+listofmsg.get(x).msgId);
				
				
			}
			
			else if (Double.parseDouble(swFromDevice.get(listofmsg.get(x).msgDest)) < Double.parseDouble(swOfReceivedPeer.get(listofmsg.get(x).msgDest)))
			{
				Log.d(TAG,"Value of X in second if condition: "+x);
				msgtobesent.add(listofmsg.get(x).msgId);
				Log.d(TAG,"Added msgId: "+listofmsg.get(x).msgId);
				
			}
			
		}
	
	
		Log.e(TAG, "In OiRouter class. Msg to be sent: "+msgtobesent.toString());
		
		return(msgtobesent);
	}
	

}