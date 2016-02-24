package hunreally.king.hunreallyhttpdemo;

import hunreally.king.hunreallycomponents.activity.HunreallyActivity;
import hunreally.king.hunreallyhttp.request.requestor.HunreallyHttp;
import hunreally.king.hunreallyhttp.response.result.HunreallyGetJsonObjectResult;
import hunreally.king.hunreallyhttp.response.result.HunreallyGetStringResult;
import hunreally.king.hunreallyhttp.response.result.HunreallyPostJsonObjectResult;
import hunreally.king.hunreallyhttp.response.result.HunreallyPostStringResult;
import hunreally.king.hunreallyhttpdemo.bean.Info;
import hunreally.king.hunreallyhttpdemo.bean.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends HunreallyActivity implements OnClickListener {
	Context context = null;
	Button Get_Map_String;
	Button Get_Map_JsonObject;
	Button Post_Map_String;
	Button Post_JsonObj_String;
	Button Post_Map_JsonObject;
	Button Post_JsonObj_JsonObj;

	
	User user;
	public static int count = 0;
	public static String httpstart = "http://10.0.2.2:8080/HunreallyHttpServer/";

	@Override
	protected void getViewBysetContentView(Bundle arg0) {
	}

	@Override
	protected void onCreateAfterParent(Bundle arg0) {
		this.context = this;
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.Get_Map_String:
			/******************** 
			 * 
			 * get参数为map返回为String 
			 * 
			 * ******************/
			Map<String, String> getdata = new HashMap<String, String>();
			getdata.put("username", "hunreally");
			getdata.put("password", "hunreally");
			HunreallyHttp.Get_Map_String(httpstart + "GetMapForString", getdata, 0,
					null, new HunreallyGetStringResult() {

						@Override
						public void getRepResultString(String result) {
							System.out.println(result);
						}

						@Override
						public void getException(Exception e) {
							System.out.println(e.toString());
						}
					});
			break;
		case R.id.Get_Map_JsonObject:
			/********************
			 * 
			 *  get参数为map返回为jsonObj 
			 *  
			 *  ******************/
			Map<String, String> getdataforjson = new HashMap<String, String>();
			getdataforjson.put("username", "hunreally");
			getdataforjson.put("password", "hunreally");
			HunreallyHttp.Get_Map_JsonObject(httpstart + "GetMapForJsonObject",
					getdataforjson, 0, null,
					new HunreallyGetJsonObjectResult() {

						@Override
						public void getRepResultJsonObject(Object obj) {
							User user=(User) obj;
							System.out.println(user);
						}

						@Override
						public void getException(Exception e) {
							System.out.println(e.toString());
						}
					}, User.class);
			break;
		case R.id.Post_Map_String:
			/********************
			 * 
			 * post参数为map返回为String 
			 * 
			 * ******************/
			Map<String, String> postdata = new HashMap<String, String>();
			postdata.put("username", "hunreally");
			postdata.put("password", "hunreally");
			HunreallyHttp.Post_Map_String(httpstart + "PostMapForString", postdata,
					0, count++ + "", new HunreallyPostStringResult() {

						@Override
						public void getRepResultString(String result) {
							System.out.println(result);
						}

						@Override
						public void getException(Exception e) {
							System.out.println(e.toString());
						}
					});
			break;
		case R.id.Post_JsonObj_String:
			/******************** 
			 * 
			 * post参数为jsonObject返回为String 
			 * 
			 * ******************/
			user = new User();
			new AsyncTask<Void, Void, Void>() {

				@Override
				protected Void doInBackground(Void... params) {
					user.info = new ArrayList<Info>();
					Info info = new Info();
					for (int i = 0; i < 5; i++) {
						info = new Info();
						info.age = i;
						info.birthday = "好孩子" + i;
						user.info.add(info);
					}
					user.name = "hunreally";
					return null;
				}

				@Override
				protected void onPostExecute(Void result) {
					super.onPostExecute(result);
					HunreallyHttp.Post_JsonObj_String(httpstart
							+ "PostJsonObjectForString", user, 0, count++ + "",
							new HunreallyPostStringResult() {

								@Override
								public void getRepResultString(String result) {
									System.out.println(result);
								}

								@Override
								public void getException(Exception e) {
									System.out.println(e.toString());
								}
							});
				}
			}.execute();
			break;
		case R.id.Post_Map_JsonObject:
			/******************** 
			 * 
			 * post参数为map返回为 jsonObject 
			 * 
			 * ******************/
			Map<String, String> postbymapforjsondata = new HashMap<String, String>();
			postbymapforjsondata.put("username", "hunreally");
			postbymapforjsondata.put("password", "hunreally");
			HunreallyHttp.Post_Map_JsonObject(httpstart + "PostMapForJsonObject",
					postbymapforjsondata, 0, count++ + "",
					new HunreallyPostJsonObjectResult() {

						@Override
						public void getRepResultJsonObject(Object obj) {
							User user=(User) obj;
							System.out.println(user);
						}

						@Override
						public void getException(Exception e) {
							System.out.println(e.toString());
						}
					}, User.class);
			break;
		case R.id.Post_JsonObj_JsonObj:
			/******************** 
			 * 
			 * post参数为jsonObject返回为jsonObject
			 * 
			 *  ******************/
			user = new User();
			new AsyncTask<Void, Void, Void>() {

				@Override
				protected Void doInBackground(Void... params) {
					user.info = new ArrayList<Info>();
					Info info = new Info();
					for (int i = 0; i < 5; i++) {
						info = new Info();
						info.age = i;
						info.birthday = "好孩子" + i;
						user.info.add(info);
					}
					user.name = "hunreally";
					return null;
				}

				@Override
				protected void onPostExecute(Void result) {
					super.onPostExecute(result);
					HunreallyHttp.Post_JsonObj_JsonObj(httpstart
							+ "PostJsonOjectForJsonObject", user, 0, count++ + "",
							new HunreallyPostJsonObjectResult() {

								@Override
								public void getRepResultJsonObject(Object obj) {
									User user=(User) obj;
									System.out.println(user);
								}

								@Override
								public void getException(Exception e) {
									System.out.println(e.toString());
								}
							}, User.class);
				}
			}.execute();
			break;
		default:
			break;
		}
	}
}