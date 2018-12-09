package com.xhq.baseanimation.ui.canvas;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.xhq.baseanimation.ConstantValue;
import com.xhq.baseanimation.R;
import com.xhq.baseanimation.adapter.AnimationAdapter;
import com.xhq.baseanimation.ui.base.BaseActivity;
import com.xhq.baseanimation.ui.canvas.chart.charts.ChartMainActivity;
import com.xhq.baseanimation.ui.canvas.olympics.OlympicMainActivity;

/**
 * 画笔绘制效果集合主页面
 * @author Administrator
 *
 */
public class CanvasMainActivity extends BaseActivity implements OnItemClickListener {
	
	private AnimationAdapter adapter;
	private ListView listView_anim_complex;
	@Override
	public void setView() {
		setContentView(R.layout.activity_anim_complex);
		
	}

	@Override
	public void initView() {
		listView_anim_complex = (ListView) findViewById(R.id.lv_anim_complex);
		adapter = new AnimationAdapter(this, ConstantValue.CanvasName);
	}

	@Override
	public void setListener() {
		listView_anim_complex.setAdapter(adapter);
		listView_anim_complex.setOnItemClickListener(this);
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		switch (position) {
		case 0:
			startIntent(OlympicMainActivity.class);
			break;
		case 1:
			startIntent(ChartMainActivity.class);
			break;
		default:
			break;
		}
		
	}
	
	/**
	 * 切换Activity
	 * @param clazz
	 */
	public void startIntent(Class clazz){
		Intent intent = new Intent(this,clazz);
		startActivity(intent);
	}
}
