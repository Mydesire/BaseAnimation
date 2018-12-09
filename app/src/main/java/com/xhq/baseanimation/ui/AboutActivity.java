package com.xhq.baseanimation.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.xhq.baseanimation.R;
import com.xhq.baseanimation.ui.base.BaseActivity;
import com.xhq.baseanimation.utils.ApkInfoTool;

/**
 * 关于页面
 * @author duguang
 * 博客地址:http://blog.csdn.net/duguang77
 */
public class AboutActivity extends BaseActivity implements OnClickListener {

	private TextView tv_address;
	@Override
	public void setView() {
		setContentView(R.layout.activity_about);
		
	}

	@Override
	public void initView() {
		TextView textView_VersionName = findViewById(R.id.textView_VersionName);
		tv_address = findViewById(R.id.tv_address);
		textView_VersionName.setText("版本号:"+ApkInfoTool.getVersionName(this));
	
	}

	@Override
	public void setListener() {
		tv_address.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_address:
			Intent intent = new Intent(Intent.ACTION_VIEW);
			intent.setData(Uri.parse("http://blog.csdn.net/duguang77"));
			startActivity(intent);
			break;

		default:
			break;
		}
		
	}
}
