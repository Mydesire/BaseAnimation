package com.xhq.baseanimation.ui.customview.ribbomenu;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.xhq.baseanimation.R;
import com.xhq.baseanimation.ui.base.BaseActivity;

/**
 * 自定义LinearLayout侧边栏效果主页面
 * @author Administrator
 *
 */
public class RibbonMainActivity extends BaseActivity implements iRibbonMenuCallback {
	/** Called when the activity is first created. */

	private RibbonMenuView rbmView;

	@Override
	public void setView() {
		setContentView(R.layout.activity_custom_ribbon_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("自定义LL侧边栏");
        setSupportActionBar(toolbar);

		rbmView = findViewById(R.id.ribbonMenuView1);
		rbmView.setMenuClickCallback(this);
		rbmView.setMenuItems(R.menu.ribbon_menu);

//		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public void initView() {
	}

	@Override
	public void setListener() {
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();

		if (id == android.R.id.home) {
			rbmView.toggleMenu();
			return true;
		} else {
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public void RibbonMenuItemClick(int itemId) {
	}
}