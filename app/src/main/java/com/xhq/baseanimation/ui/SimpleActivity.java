package com.xhq.baseanimation.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.xhq.baseanimation.ConstantValue;
import com.xhq.baseanimation.R;
import com.xhq.baseanimation.adapter.AnimationAdapter;
import com.xhq.baseanimation.ui.base.BaseActivity;

/**
 * 简单动画页面
 * @author duguang
 * 博客地址:http://blog.csdn.net/duguang77
 */
public class SimpleActivity extends BaseActivity implements OnItemClickListener {

	private AnimationAdapter adapter;
	private ListView listView_anim_simple;


	@Override
	public void setView() {
		setContentView(R.layout.activity_anim_simple);
	}
	
	@Override
	public void initView() {
		listView_anim_simple = findViewById(R.id.lv_anim_simple);
		adapter = new AnimationAdapter(this, ConstantValue.simpleName);
	}

	@Override
	public void setListener() {
		listView_anim_simple.setAdapter(adapter);
		listView_anim_simple.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Animation anim = AnimationUtils.loadAnimation(this, ConstantValue.simpleAnim[position]);
		listView_anim_simple.startAnimation(anim);
	}

}
