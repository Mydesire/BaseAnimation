package com.xhq.baseanimation.ui.customview.titlelistview;

import com.xhq.baseanimation.R;
import com.xhq.baseanimation.ui.base.BaseActivity;

/**
 * ListView循环更换标题效果
 * @author Administrator
 *
 */
public class TitleListViewMainActivity extends BaseActivity {

	private TestAdapter adapter;
	private PinnedHeaderListView listView;

	@Override
	public void setView() {
		setContentView(R.layout.activity_custom_title_listview_main);
		
	}

	@Override
	public void initView() {
		adapter = new TestAdapter(getLayoutInflater());

		listView = (PinnedHeaderListView) findViewById(R.id.section_list_view);
		listView.setAdapter(adapter);
		listView.setOnScrollListener(adapter);
		listView.setPinnedHeaderView(getLayoutInflater().inflate(
				R.layout.activity_custom_title_listview_section, listView, false));
		
	}

	@Override
	public void setListener() {
		// TODO Auto-generated method stub
		
	}
}
