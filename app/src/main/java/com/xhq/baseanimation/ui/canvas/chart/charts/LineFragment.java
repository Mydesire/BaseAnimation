package com.xhq.baseanimation.ui.canvas.chart.charts;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.xhq.baseanimation.R;
import com.xhq.baseanimation.ui.canvas.chart.util.LineView;
import com.xhq.baseanimation.ui.canvas.chart.util.MyHori;
import com.xhq.baseanimation.ui.canvas.chart.util.MyHori.MyHoriListener;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Dacer on 11/15/13.
 */
public class LineFragment extends Fragment{

    private SeekBar sb;
	private int dragLenth;
	private LineView lineView;
	private MyHori hori;
	private GestureDetector gestureDetector;
	private float lastX;
	private float lastY;
	private int winWidth;
	private OnSeekBarChangeListener sbListener;
	private MyHoriListener myHoriListener;
	private OnTouchListener touch;

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_canvas_chart_line, container, false);
        lineView = rootView.findViewById(R.id.line_view);
        sb = rootView.findViewById(R.id.sb);
        hori = rootView.findViewById(R.id.horizontalScrollView);
        hori.setHorizontalScrollBarEnabled(false);
        set(lineView);
        sbListener = new OnSeekBarChangeListener() {
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			}
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				float x=((float)progress)*dragLenth/(dragLenth+winWidth);
				hori.smoothScrollTo(((int)(x+0.5)), 0);
			}
		};
		myHoriListener = new MyHoriListener() {
			@Override
			public void onScrollChanged(int dx) {
				int progress = sb.getProgress();
				sb.setProgress(progress+dx);
			}
		};
		touch= new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(v instanceof MyHori){
					sb.setOnSeekBarChangeListener(null);
					hori.setMyListener(myHoriListener);
				}else{
					hori.setMyListener(null);
					sb.setOnSeekBarChangeListener(sbListener);
				}
				return false;
			}
		};
		return rootView;
	}
	@Override
	public void onResume() {
		new Thread(){
			public void run() {
				WindowManager wm=(WindowManager)getActivity().getSystemService(Context.WINDOW_SERVICE);
				while(dragLenth==0||winWidth==0){
					SystemClock.sleep(10);
                    Point outSize = new Point();
                    Objects.requireNonNull(wm).getDefaultDisplay().getSize(outSize);
                    winWidth = outSize.x;
					dragLenth = hori.getWidth();
				}
				sb.setProgress(0);
				sb.setMax(dragLenth+winWidth);
				setEvent();
			}
		}.start();
		
		super.onResume();
	}
    private void setEvent() {
    	hori.setOnTouchListener(touch);
    	sb.setOnTouchListener(touch);
//		sb.setOnSeekBarChangeListener(sbListener);
//		hori.setMyListener(myHoriListener);
	}

	private void set(LineView lineView){
        ArrayList<String> test = new ArrayList<>();
        ArrayList<Integer> dataList1 = new ArrayList<>();
        dataList1.add(21);
        dataList1.add(22);
        dataList1.add(43);
        dataList1.add(25);
        dataList1.add(21);
        dataList1.add(21);
        dataList1.add(22);
        dataList1.add(43);
        dataList1.add(25);
        dataList1.add(2);
        ArrayList<Integer> dataList2 = new ArrayList<>();
        dataList2.add(65);
        dataList2.add(35);
        dataList2.add(25);
        dataList2.add(22);
        dataList2.add(2);
        dataList2.add(65);
        dataList2.add(35);
        dataList2.add(25);
        dataList2.add(22);
        dataList2.add(43);
        ArrayList<Integer> dataList3 = new ArrayList<>();
        dataList3.add(25);
        dataList3.add(20);
        dataList3.add(65);
        dataList3.add(35);
        dataList3.add(20);
        dataList3.add(25);
        dataList3.add(20);
        dataList3.add(65);
        dataList3.add(35);
        dataList3.add(20);
        ArrayList<Integer> dataList4 = new ArrayList<>();
        dataList4.add(1);
        dataList4.add(43);
        dataList4.add(25);
        dataList4.add(22);
        dataList4.add(65);
        dataList4.add(22);
        dataList4.add(100);
        dataList4.add(25);
        dataList4.add(22);
        dataList4.add(65);
        ArrayList<Integer> dataList5 = new ArrayList<>();
        dataList5.add(35);
        dataList5.add(22);
        dataList5.add(22);
        dataList5.add(43);
        dataList5.add(99);
        dataList5.add(35);
        dataList5.add(22);
        dataList5.add(22);
        dataList5.add(43);
        dataList5.add(25);
        dataList5.add(35);
        dataList5.add(22);
        dataList5.add(22);
        dataList5.add(43);
        dataList5.add(99);
        dataList5.add(35);
        dataList5.add(22);
        dataList5.add(22);
        dataList5.add(43);
        dataList5.add(25);
        dataList5.add(43);
        dataList5.add(99);
        dataList5.add(35);
        dataList5.add(22);
        dataList5.add(22);
        dataList5.add(43);
        dataList5.add(25);
        dataList5.add(35);
        dataList5.add(22);
        dataList5.add(22);
        dataList5.add(43);
        dataList5.add(99);
        dataList5.add(35);
        dataList5.add(22);
        dataList5.add(22);
        dataList5.add(43);
        dataList5.add(25);
        ArrayList<ArrayList<Integer>> aaa=new ArrayList<>();
        aaa.add(dataList5);
        aaa.add(dataList4);
        aaa.add(dataList3);
        aaa.add(dataList2);
        aaa.add(dataList1);
        for (int i=0; i<dataList5.size(); i++){
            test.add(String.valueOf(i+1));
        }
        lineView.setBottomTextList(test);
        lineView.addDataList(aaa);
    }
}