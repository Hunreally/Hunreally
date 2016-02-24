package hunreally.king.hunreallyimgloaderdemo;

import hunreally.king.hunreallycomponents.activity.HunreallyActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends HunreallyActivity implements OnClickListener {
	Button downLoadImg;
	ListView LVShow;
	ImageView ImgShow;
	
	@Override
	protected void getViewBysetContentView(Bundle arg0) {

	}

	@Override
	protected void onCreateAfterParent(Bundle arg0) {
		System.out.println(LVShow);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.downLoadImg:
			ImageAdapter adapter=new ImageAdapter("http://10.0.2.2:8080/HunreallyHttpServer/katong.jpg",this);
			LVShow.setAdapter(adapter);
		default:
			break;
		}
	}

}
