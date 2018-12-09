/*
 * Copyright 2013 Niek Haarman
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.xhq.baseanimation.ui.listivew.listviews.appearanceexamples;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.OnNavigationListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.xhq.baseanimation.R;
import com.xhq.baseanimation.ui.listivew.listviews.BaseActivity;
import com.haarman.listviewanimations.ArrayAdapter;
import com.haarman.listviewanimations.swinginadapters.AnimAdapter;
import com.haarman.listviewanimations.swinginadapters.prepared.AlphaInAnimAdapter;
import com.haarman.listviewanimations.swinginadapters.prepared.ScaleInAnimAdapter;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimAdapter;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingLeftInAnimAdapter;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingRightInAnimAdapter;

import java.util.ArrayList;

public class AppearanceExamplesActivity extends BaseActivity implements OnNavigationListener {

	private BaseAdapter mAdapter;
	private ListView mCurrentLV;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listviews_appearance);

		mCurrentLV = findViewById(R.id.activity_appearance_lv);
		mAdapter = new MyAdapter(this, getItems());
		setAlphaAdapter();

//		getActionBar();
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		actionBar.setListNavigationCallbacks(new AnimSelectionAdapter(), this);
		actionBar.setDisplayShowTitleEnabled(false);
	}

	private void setAlphaAdapter() {
		AnimAdapter animAdapter = new AlphaInAnimAdapter(mAdapter);
		animAdapter.setAbsListView(mCurrentLV);
		mCurrentLV.setAdapter(animAdapter);
	}

	private void setLeftAdapter() {
		AnimAdapter animAdapter = new SwingLeftInAnimAdapter(mAdapter);
		animAdapter.setAbsListView(mCurrentLV);
		mCurrentLV.setAdapter(animAdapter);
	}

	private void setRightAdapter() {
		AnimAdapter animAdapter = new SwingRightInAnimAdapter(mAdapter);
		animAdapter.setAbsListView(mCurrentLV);
		mCurrentLV.setAdapter(animAdapter);
	}

	private void setBottomAdapter() {
		AnimAdapter animAdapter = new SwingBottomInAnimAdapter(mAdapter);
		animAdapter.setAbsListView(mCurrentLV);
		mCurrentLV.setAdapter(animAdapter);
	}

	private void setBottomRightAdapter() {
		AnimAdapter animAdapter = new SwingBottomInAnimAdapter(new SwingRightInAnimAdapter(mAdapter));
		animAdapter.setAbsListView(mCurrentLV);
		mCurrentLV.setAdapter(animAdapter);
	}

	private void setScaleAdapter() {
		AnimAdapter animAdapter = new ScaleInAnimAdapter(mAdapter);
		animAdapter.setAbsListView(mCurrentLV);
		mCurrentLV.setAdapter(animAdapter);
	}

	private static ArrayList<Integer> getItems() {
		ArrayList<Integer> items = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			items.add(i);
		}
		return items;
	}

	private static class MyAdapter extends ArrayAdapter<Integer> {

		private Context mContext;

		public MyAdapter(Context context, ArrayList<Integer> items) {
			super(items);
			mContext = context;
		}

		@Override
		public long getItemId(int position) {
			return getItem(position).hashCode();
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			TextView tv = (TextView) convertView;
			if (tv == null) {
				tv = (TextView) LayoutInflater.from(mContext).inflate(R.layout.item_lv_list_row, parent, false);
			}
			tv.setText("This is row number " + getItem(position));
			return tv;
		}
	}

	/* Non-ListViewAnimations related stuff below */

	@Override
	public boolean onNavigationItemSelected(int itemPosition, long itemId) {
		switch (itemPosition) {
		case 0:
			setAlphaAdapter();
			return true;
		case 1:
			setLeftAdapter();
			return true;
		case 2:
			setRightAdapter();
			return true;
		case 3:
			setBottomAdapter();
			return true;
		case 4:
			setBottomRightAdapter();
			return true;
		case 5:
			setScaleAdapter();
			return true;
		default:
			return false;
		}
	}

	private class AnimSelectionAdapter extends ArrayAdapter<String> {

		public AnimSelectionAdapter() {
			addAll("Alpha", "Left", "Right", "Bottom", "Bottom right", "Scale");
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			TextView tv = (TextView) convertView;
			if (tv == null) {
				tv = (TextView) LayoutInflater.from(AppearanceExamplesActivity.this).inflate(android.R.layout.simple_list_item_1, parent, false);
				tv.setTextColor(Color.BLACK);
			}

			tv.setText(getItem(position));
			return tv;
		}
	}
}
