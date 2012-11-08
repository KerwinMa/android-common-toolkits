package com.lurencun.android.system;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.TelephonyManager;
import android.widget.Toast;

/**
 * <ul>
 * <li><b>name : </b>       PhoneUtil      </li>
 * <li><b>description :</b> 电话类</li>
 * <li></b>author : </b>    桥下一粒砂           </li>
 * <li><b>e-mail : </b>     chenyoca@gmail.com  </li>
 * <li><b>weibo : </b>      @桥下一粒砂          </li>
 * <li><b>date : </b>       2012-7-21 上午8:41:34</li>
 * </ul>
 */
public class PhoneUtil {

	/**
	 * </br><b>title : </b>		打电话
	 * </br><b>description :</b>打电话
	 * </br><b>time :</b>		2012-7-21 上午8:43:02
	 * @param activity
	 * @param phoneNumber
	 */
	public static void call(Activity activity, String phoneNumber){
		Intent dialIntent = new Intent(Intent.ACTION_CALL,Uri.parse(String.format("tel:%s", phoneNumber)));
		try{
		    activity.startActivity(dialIntent);
	    }catch(Exception e){
	        Toast.makeText(activity, 
	                "无法呼叫！可能本应用呼叫功能已经系统或安全软件禁止！", Toast.LENGTH_SHORT).show();
	    }
	}
	 
	/**
	 * </br><b>title : </b>		发信息
	 * </br><b>description :</b>发信息
	 * </br><b>time :</b>		2012-7-21 上午8:54:28
	 * @param activity
	 * @param recver
	 * @param content
	 */
	public static void sms(Activity activity, String recver, String content){
		Intent sendIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms://")); 
		sendIntent.putExtra("address", recver); 
		sendIntent.putExtra("sms_body", content); 
		activity.startActivity(sendIntent);
	}
	
	/**
	 * <b>title : 	</b>		获取手机号码
	 * </br><b>description :</b>获取手机号码
	 * </br><b>time :</b>		2012-7-29 下午4:17:29
	 * @param context
	 */
	public static String getPhoneNum(Context context){
		TelephonyManager tm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
		return tm.getLine1Number();
	}
	
}
