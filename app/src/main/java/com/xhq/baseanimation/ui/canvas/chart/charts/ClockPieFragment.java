package com.xhq.baseanimation.ui.canvas.chart.charts;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.xhq.baseanimation.R;
import com.xhq.baseanimation.ui.canvas.chart.util.PieHelper;
import com.xhq.baseanimation.ui.canvas.chart.util.PieView;

import java.util.ArrayList;

/**
 * Created by Dacer on 11/16/13.
 */
public class ClockPieFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_canvas_chart_pie, container, false);
        final PieView pieView = rootView.findViewById(R.id.pie_view);
        Button button = rootView.findViewById(R.id.pie_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                randomSet(pieView);
            }
        });
        set(pieView);
        return rootView;
    }

    private void randomSet(PieView pieView){
        ArrayList<PieHelper> pieHelperArrayList = new ArrayList<>();
        for(int i=0; i<20; i++){
            int startHour = (int)(24*Math.random());
            int startMin = (int)(60*Math.random());
            int duration = (int)(50*Math.random());
            pieHelperArrayList.add(new PieHelper(startHour,startMin,0,startHour,startMin+duration,0));
        }
        pieHelperArrayList.add(new PieHelper(0,30));
        pieHelperArrayList.add(new PieHelper(30,90));
        pieView.setDate(pieHelperArrayList);
    }

    private void set(PieView pieView){
        ArrayList<PieHelper> pieHelperArrayList = new ArrayList<>();
        pieHelperArrayList.add(new PieHelper(0,30));
        pieHelperArrayList.add(new PieHelper(50,90));
        pieView.setDate(pieHelperArrayList);
    }
}