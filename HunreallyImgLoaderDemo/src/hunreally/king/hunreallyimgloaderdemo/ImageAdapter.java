package hunreally.king.hunreallyimgloaderdemo;

import hunreally.king.hunreallyimgloader.HunreallyImageLoader;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter{
	
	private String httpPath;
	private int index=0;
	private int size=6;
	private Context context;
	
	public ImageAdapter(String httpPath,Context context){
		this.httpPath=httpPath;
		this.context=context;
	}
	
	public class ImageHolder{
		ImageView ImgShow;
	}
	
	@Override
	public int getCount() {
		return size;
	}

	@Override
	public Object getItem(int arg0) {
		return httpPath;
	}

	@Override
	public long getItemId(int arg0) {
		return index;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		ImageHolder holder=null;
		if(arg1==null){
			holder=new ImageHolder();
			arg1 = LayoutInflater.from(context).inflate(R.layout.item, null);
			holder.ImgShow=(ImageView) arg1.findViewById(R.id.ImgShow);
			arg1.setTag(holder);
		}else{
			holder=(ImageHolder) arg1.getTag();
		}
		HunreallyImageLoader.getInstance(3, null).loadImage(httpPath, holder.ImgShow, 0);
		return arg1;
	}

}
