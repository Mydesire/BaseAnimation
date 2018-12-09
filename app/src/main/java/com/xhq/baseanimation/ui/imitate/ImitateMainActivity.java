package com.xhq.baseanimation.ui.imitate;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.xhq.baseanimation.ConstantValue;
import com.xhq.baseanimation.R;
import com.xhq.baseanimation.adapter.AnimationAdapter;
import com.xhq.baseanimation.ui.base.BaseActivity;
import com.xhq.baseanimation.ui.imitate.TaoBaoPathButton.TaoBaoActivity;
import com.xhq.baseanimation.ui.imitate.addshopcartanim.AddShopCartMainActivity;
import com.xhq.baseanimation.ui.imitate.biaopan.BiaoPanMainActivity;
import com.xhq.baseanimation.ui.imitate.fang360.RootBlockMainActivity;
import com.xhq.baseanimation.ui.imitate.gallery.GalleryMainActivity;
import com.xhq.baseanimation.ui.imitate.taobaoPath2.PathMenuMainActivity;
import com.xhq.baseanimation.ui.imitate.titanic.TitanicMainActivity;
import com.xhq.baseanimation.ui.imitate.viberation.VibrateMainActivity;
import com.xhq.baseanimation.ui.imitate.waterfall.WaterfallMainActivity;
import com.xhq.baseanimation.ui.imitate.wave.WaveMainActivity;
import com.xhq.baseanimation.ui.imitate.weixin.WeiXinChatDemoActivity;
import com.xhq.baseanimation.ui.imitate.wheel.WheelMainActivity;
import com.xhq.baseanimation.ui.imitate.widget.WidgetMainActivity;

public class ImitateMainActivity extends BaseActivity implements OnItemClickListener {

	private AnimationAdapter adapter;
	private ListView lv_anim_complex;
	@Override
	public void setView() {
		setContentView(R.layout.activity_anim_complex);
	}

	@Override
	public void initView() {
		lv_anim_complex = findViewById(R.id.lv_anim_complex);

		adapter = new AnimationAdapter(this, ConstantValue.imitateName);
	}

	@Override
	public void setListener() {
		lv_anim_complex.setAdapter(adapter);
		lv_anim_complex.setOnItemClickListener(this);
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		switch (position) {
		case 0:
			startIntent(OutTicketActivity.class);
			break;
		case 1:
			startIntent(AddShopCartMainActivity.class);
			break;
		case 2:
			startIntent(YouKuActivity.class);
			break;
		case 3:
			startIntent(GalleryMainActivity.class);
			break;
		case 4:
			startIntent(SpinnerMainActivity.class);
			break;
		case 5:
			startIntent(RadarMainActivity.class);
			break;
		case 6:
			break;
		case 7:
			startIntent(BiaoPanMainActivity.class);
			break;
		case 8:
			startIntent(WaterfallMainActivity.class);
			break;
		case 9:
			startIntent(RootBlockMainActivity.class);
			break;
		case 10:
			startIntent(WheelMainActivity.class);
			break;
		case 11:
			startIntent(WidgetMainActivity.class);
			break;
		case 12:
			startIntent(WeiXinChatDemoActivity.class);
			break;
		case 13:
			startIntent(VibrateMainActivity.class);
			break;
		case 14:
			startIntent(SlidingDrawerMainActivity.class);
			break;
		case 15:
			startIntent(PathMenuMainActivity.class);
			break;
		case 16:
			startIntent(TaoBaoActivity.class);
			break;
		case 17:
			startIntent(WaveMainActivity.class);
			break;
		case 18:
			startIntent(TitanicMainActivity.class);
			break;

		default:
			break;
		}
		
	}
	
	/**
	 * 切换Activity
	 * @param class1
	 */
	public void startIntent(Class class1){
		Intent intent = new Intent(ImitateMainActivity.this,class1);
		startActivity(intent);
	}

}
