package com.xhq.baseanimation.ui.canvas.chart.charts;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;

import com.xhq.baseanimation.R;

public class ChartMainActivity extends AppCompatActivity implements NaviDrawerFragment.NaviDrawerCallbacks{

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    private FragmentManager fm;
    private NaviDrawerFragment drawerFrgmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas_chart_main);
//        restoreActionBar();

        fm = getFragmentManager();
        // Fragment managing the behaviors, interactions and presentation of the navigation drawer.
//        NaviDrawerFragment drawerFrgmt = (NaviDrawerFragment)fm.findFragmentById(R.id.navi_drawer);

        drawerFrgmt = new NaviDrawerFragment();
        fm.beginTransaction().replace(R.id.navi_drawer, drawerFrgmt).commit();
        mTitle = getTitle();
        // Set up the drawer.
    }


    @Override
    protected void onResume(){
        super.onResume();
        drawerFrgmt.setUp(R.id.navi_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
    }


    @Override
    public void onNaviDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentTransaction ft = fm.beginTransaction();
        Fragment fragment = null;
            switch (position){
                case 0:
                    fragment = new LineFragment();
                    break;
                case 1:
                    fragment = new BarFragment();
                    break;
                case 2:
                    fragment = new ClockPieFragment();
                    break;
            }
        ft.replace(R.id.container, fragment).commit();
    }

    public void onSectionAttached(int number) {
    	
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

}
