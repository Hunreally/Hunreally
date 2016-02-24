package hunreally.king.hunreallyjsondemo;

import hunreally.king.hunreallycomponents.activity.HunreallyActivity;
import hunreally.king.hunreallyjson.HunreallyJson;
import hunreally.king.hunreallyjsondemo.bean.HunreallyAddress;
import hunreally.king.hunreallyjsondemo.bean.HunreallyBean;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends HunreallyActivity implements OnClickListener {
	Button jsonToObj;
	Button objToJson;

	@Override
	protected void getViewBysetContentView(Bundle arg0) {

	}

	@Override
	protected void onCreateAfterParent(Bundle arg0) {

	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.jsonToObj:
			String jsonStr="{\"address\":[{\"country\":\"城市\",\"number\":100000},{\"country\":\"城市\",\"number\":100001},{\"country\":\"城市\",\"number\":100002},{\"country\":\"城市\",\"number\":100003},{\"country\":\"城市\",\"number\":100004}],\"name\":\"Hunreally\",\"age\":22,\"toal\":\"0\"}";
			HunreallyBean jsonStringToObject = HunreallyJson.JsonStringToObject(jsonStr, HunreallyBean.class);
			System.out.println(jsonStringToObject);
			break;
		case R.id.objToJson:
			HunreallyBean hunreallyBean=new HunreallyBean();
			hunreallyBean.name="Hunreally";
			hunreallyBean.age=22;
			hunreallyBean.address=new ArrayList<HunreallyAddress>();
			for(int i=0;i<5;i++){
				HunreallyAddress hunreallyAddress=new HunreallyAddress();
				hunreallyAddress.number=100000+i;
				hunreallyAddress.country="城市";
				hunreallyBean.address.add(hunreallyAddress);
			}
			String objectToJsonString = HunreallyJson.ObjectToJsonString(hunreallyBean);
			System.out.println(objectToJsonString);
			break;
		default:
			break;
		}
	}

}
