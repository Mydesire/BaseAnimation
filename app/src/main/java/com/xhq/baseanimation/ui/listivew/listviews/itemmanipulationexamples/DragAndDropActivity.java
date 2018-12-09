package com.xhq.baseanimation.ui.listivew.listviews.itemmanipulationexamples;

import android.os.Bundle;
import android.widget.Toast;

import com.xhq.baseanimation.ui.listivew.listviews.MyListActivity;
import com.haarman.listviewanimations.ArrayAdapter;
import com.haarman.listviewanimations.swinginadapters.prepared.AlphaInAnimAdapter;
import com.haarman.listviewanimations.view.DynamicListView;

public class DragAndDropActivity extends MyListActivity {

	private DynamicListView mListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mListView = new DynamicListView(this);
		mListView.setDivider(null);
		setContentView(mListView);

		ArrayAdapter<Integer> adapter = createListAdapter();
		AlphaInAnimAdapter animAdapter = new AlphaInAnimAdapter(adapter);
		animAdapter.setAbsListView(mListView);
		mListView.setAdapter(animAdapter);

		Toast.makeText(this, "Long press an item to start dragging", Toast.LENGTH_LONG).show();
	}
}
