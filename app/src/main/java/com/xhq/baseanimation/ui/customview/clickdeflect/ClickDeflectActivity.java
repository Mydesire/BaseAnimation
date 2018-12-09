package com.xhq.baseanimation.ui.customview.clickdeflect;

import android.widget.Toast;

import com.xhq.baseanimation.R;
import com.xhq.baseanimation.ui.base.BaseActivity;

public class ClickDeflectActivity extends BaseActivity {
    /** Called when the activity is first created. */
	MyImageView joke;
	
	@Override
	public void setView() {
		 setContentView(R.layout.activity_custom_click_deflect_main);
		
	}
	@Override
	public void initView() {
		joke=(MyImageView) findViewById(R.id.c_joke);
		
	}
	@Override
	public void setListener() {
		   joke.setOnClickIntent(new MyImageView.OnViewClick() {
				
				@Override
				public void onClick() {
					// TODO Auto-generated method stub
					Toast.makeText(ClickDeflectActivity.this, "事件触发", 0).show();
					System.out.println("1");
				}
			});
		
	}
}