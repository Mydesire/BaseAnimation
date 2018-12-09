package com.xhq.baseanimation.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xhq.baseanimation.R;

import java.util.Locale;

public class AnimationAdapter extends BaseAdapter {

	private static final String tag = "AnimationAdapter";
	private Context context;
	private String[] animName;
	
	public AnimationAdapter(Context context,String[] anim) {
		this.context = context;
		this.animName = new String[anim.length];
		for (int i = 0; i < anim.length; i++) {
			animName[i] = anim[i];
			System.out.println(animName[i]);
		}
	}

	@Override
	public int getCount() {
		Log.i(tag, String.valueOf(animName.length));
		return animName.length;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(convertView==null){
			holder = new ViewHolder();
			convertView = View.inflate(context, R.layout.item_listview_anim, null);
			holder.tv_name = convertView.findViewById(R.id.tv_name);
			holder.tv_num = convertView.findViewById(R.id.tv_num);
			holder.ll = convertView.findViewById(R.id.ll);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		if(position>8){
			holder.tv_num.setText(String.valueOf(position+1));
		}else{
			holder.tv_num.setText(String.format(Locale.getDefault(), "0%d", position + 1));
		}
		holder.tv_name.setText(animName[position]);
		
		if(position%2==0){
			holder.ll.setBackgroundResource(R.drawable.call_locate_gray);
		}else{
			holder.ll.setBackgroundResource(R.drawable.call_locate_green);
		}
		
		return convertView;
	}
	
	class ViewHolder{
		public TextView tv_num;
		public TextView tv_name;
		public LinearLayout ll;
	}

}
