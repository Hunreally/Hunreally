package hunreally.king.hunreallythreadpooldemo;

import hunreally.king.hunreallycomponents.activity.HunreallyActivity;
import hunreally.king.hunreallythreadpool.info.HunreallyThreadInfo;
import hunreally.king.hunreallythreadpool.pool.HunreallyThreadPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends HunreallyActivity implements OnClickListener {

	Button ThreadPoolTask;
	Button ThreadPoolTaskSize;

	@Override
	protected void getViewBysetContentView(Bundle arg0) {

	}

	@Override
	protected void onCreateAfterParent(Bundle arg0) {

	}
	
	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.ThreadPoolTask:
			for (int i = 0; i < 10; i++) {
				HunreallyThreadPool.addThreadOrInfo(new HunreallyThreadInfo() {
					
					@Override
					public void setNeedPost(boolean needPost) {
						
					}
					
					
					@Override
					public void getException(Exception e) {
						System.out.println(e.toString());
					}
					
					
					@Override
					public void runOnThread() throws Exception {
						System.out.println("在线程中运行的代码");
					}
				});
			}
			break;
		case R.id.ThreadPoolTaskSize:
			System.out.println(HunreallyThreadPool.getPoolSize()+":"+HunreallyThreadPool.getQueueSize());
			break;
		default:
			break;
		}
	}

}
