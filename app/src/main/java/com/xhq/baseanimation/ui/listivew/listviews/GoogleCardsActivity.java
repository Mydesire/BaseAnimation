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
package com.xhq.baseanimation.ui.listivew.listviews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.xhq.baseanimation.R;
import com.xhq.baseanimation.ui.base.BaseActivity;
import com.haarman.listviewanimations.ArrayAdapter;
import com.haarman.listviewanimations.itemmanipulation.OnDismissCallback;
import com.haarman.listviewanimations.itemmanipulation.SwipeDismissAdapter;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimAdapter;

import java.util.ArrayList;
import java.util.Locale;

public class GoogleCardsActivity extends BaseActivity implements OnDismissCallback {

	private GoogleCardsAdapter mGoogleCardsAdapter;

	@Override
	public void setView() {
		setContentView(R.layout.activity_lv_google_cards);
	}

	@Override
	public void initView() {

		ListView listView = findViewById(R.id.lv_google_cards);
		mGoogleCardsAdapter = new GoogleCardsAdapter(this);
		SwingBottomInAnimAdapter adapter = new SwingBottomInAnimAdapter(new SwipeDismissAdapter(mGoogleCardsAdapter, this));
		adapter.setAbsListView(listView);
		listView.setAdapter(adapter);
		mGoogleCardsAdapter.addAll(getItems());
	}

	@Override
	public void setListener() {
	}

	private ArrayList<Integer> getItems() {
		ArrayList<Integer> items = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			items.add(i);
		}
		return items;
	}

	@Override
	public void onDismiss(AbsListView listView, int[] reverseSortedPositions) {
		for (int position : reverseSortedPositions) {
			mGoogleCardsAdapter.remove(position);
		}
	}

	private static class GoogleCardsAdapter extends ArrayAdapter<Integer> {

		private Context mContext;
		private LruCache<Integer, Bitmap> mMemoryCache;

		public GoogleCardsAdapter(Context context) {
			mContext = context;

			final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);

			// Use 1/8th of the available memory for this memory cache.
			final int cacheSize = maxMemory;
			mMemoryCache = new LruCache<Integer, Bitmap>(cacheSize) {
				@Override
				protected int sizeOf(Integer key, Bitmap bitmap) {
					// The cache size will be measured in kilobytes rather than
					// number of items.
					return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
				}
			};
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder;
			View view = convertView;
			if (view == null) {
				view = LayoutInflater.from(mContext).inflate(R.layout.item_lv_googlecards_card, parent, false);

				holder = new ViewHolder();
				holder.tv = view.findViewById(R.id.tv_googlecards_card);
				view.setTag(holder);

				holder.iv = view.findViewById(R.id.iv_googlecards_card);
			} else {
				holder = (ViewHolder) view.getTag();
			}

			holder.tv.setText(
					String.format(Locale.getDefault(), "This is card %d", getItem(position) + 1));
			setImageView(holder, position);

			return view;
		}

		private void setImageView(ViewHolder viewHolder, int position) {
			int imageResId;
			switch (getItem(position) % 5) {
			case 0:
				imageResId = R.drawable.img_nature1;
				break;
			case 1:
				imageResId = R.drawable.img_nature2;
				break;
			case 2:
				imageResId = R.drawable.img_nature3;
				break;
			case 3:
				imageResId = R.drawable.img_nature4;
				break;
			default:
				imageResId = R.drawable.img_nature5;
			}

			Bitmap bitmap = getBitmapFromMemCache(imageResId);
			if (bitmap == null) {
				bitmap = BitmapFactory.decodeResource(mContext.getResources(), imageResId);
				addBitmapToMemoryCache(imageResId, bitmap);
			}
			viewHolder.iv.setImageBitmap(bitmap);
		}

		private void addBitmapToMemoryCache(int key, Bitmap bitmap) {
			if (getBitmapFromMemCache(key) == null) {
				mMemoryCache.put(key, bitmap);
			}
		}

		private Bitmap getBitmapFromMemCache(int key) {
			return mMemoryCache.get(key);
		}

		private static class ViewHolder {
			TextView tv;
			ImageView iv;
		}
	}


}
