package com.xhq.baseanimation.ui.imitate.wave;

import android.app.Activity;
import android.os.Bundle;

import com.xhq.baseanimation.R;

/**
 * 高仿支付宝声波动画页面
 * @author Administrator
 *
 */
public class WaveMainActivity extends Activity  {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_imitate_wave_pay_wave);
		
		initView();
		
	}
	
	private void initView() {
		WaveAnimView search_animation_wave = findViewById(R.id.search_anim_wave);
		WaveAnimView search_animation_wave2 = findViewById(R.id.search_animation_wave2);
		search_animation_wave.startAnimation(true);
		search_animation_wave2.startAnimation(false);
	}
	


}
