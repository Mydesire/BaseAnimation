package com.xhq.baseanimation.ui.listivew.indexlistview;

import android.widget.ListAdapter;
import android.widget.ListView;

import com.xhq.baseanimation.R;
import com.xhq.baseanimation.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通讯录效果二
 * @author Administrator
 *
 */
public class IndexMainActivity extends BaseActivity {
	
	private ListView tweakedListView;
	
	@Override
	public void setView() {
		setContentView(R.layout.activity_listview_index_main);
		
	}

	@Override
	public void initView() {
		tweakedListView = (ListView) findViewById(R.id.tweaked_list);

		// 准备数据
		List<Map<String, String>> itemList = getData();
		ListAdapter adapter = new IndexAdapter(this, itemList,
				R.layout.item_index_tweake_list_, new String[] { "itemText" },
				new int[] { R.id.tweaked_item_text });
		tweakedListView.setAdapter(adapter);
		
	}

	@Override
	public void setListener() {
		// TODO Auto-generated method stub
		
	}
	
	 public List<Map<String, String>> getData(){
	        List<Map<String, String>> itemList = new ArrayList<Map<String, String>>();
	        String alphas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	        
	        Map<String, String> map = null;
	        for(char c:alphas.toCharArray()){
	            for(int i=0; i<10; i++){                
	                map = new HashMap<String, String>();
	                map.put("itemText", ""+c+i);
	                itemList.add(map);
	            }
	        }
	        return itemList;
	    }
}
