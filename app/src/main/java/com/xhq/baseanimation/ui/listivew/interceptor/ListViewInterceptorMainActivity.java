package com.xhq.baseanimation.ui.listivew.interceptor;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.xhq.baseanimation.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ListView 中的item随意拖动
 * @author Administrator
 *
 */
public class ListViewInterceptorMainActivity extends ListActivity {
	/** Called when the activity is first created. */

	private MyAdapter adapter = null;
	private ArrayList<Map<String, Object>> array;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.activity_imitate_listview_interceptor_main);
		array = getData();
		adapter = new MyAdapter();
		setListAdapter(adapter);
		ListViewInterceptor tlv = (ListViewInterceptor) getListView();

		tlv.setDropListener(onDrop);

		tlv.getAdapter();
	}

	private ListViewInterceptor.DropListener onDrop = new ListViewInterceptor.DropListener() {
		@Override
		public void drop(int from, int to) {
			Map item = adapter.getItem(from);

			adapter.remove(item);
			adapter.insert(item, to);

		}
	};

	class MyAdapter extends ArrayAdapter<Map<String, Object>> {

		MyAdapter() {
			super(ListViewInterceptorMainActivity.this, R.layout.activity_imitate_listview_interceptor_mylist, array);
		}

		public ArrayList<Map<String, Object>> getList() {
			return array;
		}

		@NonNull
		@Override
		public View getView(int position, View convertView, @NonNull ViewGroup parent) {
			View row = convertView;
			if (row == null) {
				LayoutInflater inflater = getLayoutInflater();
				row = inflater.inflate(R.layout.activity_imitate_listview_interceptor_mylist, parent, false);
			}
			TextView label = row.findViewById(R.id.title);
			label.setText(array.get(position).get("title").toString());
			TextView info = row.findViewById(R.id.info);
			info.setText(array.get(position).get("info").toString());
			ImageView imageView = row.findViewById(R.id.img);
			imageView.setImageResource(Integer.valueOf(array.get(position)
					.get("img").toString()));
			return (row);
		}
	}

	private ArrayList<Map<String, Object>> getData() {
		ArrayList<Map<String, Object>> list = new ArrayList<>();

		Map<String, Object> map = new HashMap<>();
		map.put("title", "题目");
		map.put("info", "内容");
		map.put("img", R.drawable.listview_interceptor_fan);

		list.add(map);

		map = new HashMap<>();
		map.put("title", "题目");
		map.put("info", "内容");
		map.put("img", R.drawable.listview_interceptor_xue);

		list.add(map);

		map = new HashMap<>();
		map.put("title", "题目");
		map.put("info", "内容");
		map.put("img", R.drawable.listview_interceptor_shi);

		list.add(map);
		map = new HashMap<>();
		map.put("title", "题目");
		map.put("info", "内容");
		map.put("img", R.drawable.listview_interceptor_tie);

		list.add(map);

		map = new HashMap<>();
		map.put("title", "题目");
		map.put("info", "内容");
		map.put("img", R.drawable.listview_interceptor_ai);

		list.add(map);

		map = new HashMap<>();
		map.put("title", "题目");
		map.put("info", "内容");
		map.put("img", R.drawable.listview_interceptor_bei);
		list.add(map);
		return list;
	}
}