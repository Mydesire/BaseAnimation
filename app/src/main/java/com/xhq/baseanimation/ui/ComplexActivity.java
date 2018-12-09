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
 * 复杂动画页面
 * @author duguang
 * 博客地址:http://blog.csdn.net/duguang77
 */
public class ComplexActivity extends BaseActivity implements OnItemClickListener {

	private AnimationAdapter adapter;
	private ListView listView_anim_complex;

	@Override
	public void setView() {
		setContentView(R.layout.activity_anim_complex);
	}

	@Override
	public void initView() {
		listView_anim_complex = findViewById(R.id.lv_anim_complex);
		adapter = new AnimationAdapter(this, ConstantValue.animName);
	}

	@Override
	public void setListener() {
		listView_anim_complex.setAdapter(adapter);
		listView_anim_complex.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
		Animation anim = AnimationUtils.loadAnimation(this,ConstantValue.complex[position]);
		listView_anim_complex.startAnimation(anim);
	}

}
