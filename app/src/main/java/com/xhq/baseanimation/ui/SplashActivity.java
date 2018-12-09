package com.xhq.baseanimation.ui;

import android.view.Window;

import com.xhq.baseanimation.R;
import com.xhq.baseanimation.ui.base.BaseActivity;

public class SplashActivity extends BaseActivity {

	@Override
	public void setView() {
		getWindow().requestFeature(Window.FEATURE_PROGRESS); //去标题栏 
		setContentView(R.layout.activity_splash);
	}

	@Override
	public void initView() {
		
	}

	@Override
	public void setListener() {
	}
	
}
