package com.paddy.desi.dime.app.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paddy.desi.dime.app.R;
import com.paddy.desi.dime.app.fragements.PopularFragment;
import com.paddy.desi.dime.app.fragements.TopFragment;
import cn.pedant.SweetAlert.SweetAlertDialog;


public class MainActivity extends ActionBarActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    // declare global variable
    public static String CurrentFragment="TopFragment" ;
    RelativeLayout rl_toptap, rl_populartap;
    View strip_top, strip_popular;
    ViewPager pager;
    MyPagerAdapter adapter;
    TextView txt_top, txt_popular;
    Toolbar toolbar;
    ImageView grid_img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findIdsFromXml();
        SetupUI();
    }
    // set up view pager and move to first page
    private void SetupUI() {
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(2);
        moveToPage(0);
    }

    // find resources component from xml
    private void findIdsFromXml() {
        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);
        grid_img = (ImageView) findViewById(R.id.img_menu);
        rl_toptap = (RelativeLayout) findViewById(R.id.rl_toptab);
        rl_populartap = (RelativeLayout) findViewById(R.id.rl_populartab);
        strip_top = findViewById(R.id.top_back_view);
        strip_popular = findViewById(R.id.popular_back_view);
        txt_top = (TextView) findViewById(R.id.text_top);
        txt_popular = (TextView) findViewById(R.id.txt_popular);
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setOnPageChangeListener(this);
        // set onclick listener to tab
        rl_toptap.setOnClickListener(this);
        rl_populartap.setOnClickListener(this);
        grid_img.setOnClickListener(this);

    }

    // switch to page
    public void switchToPage(int pos) {
        try {
            pager.setCurrentItem(pos, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void moveToPage(int pos) {
        callOnResumeOfRequiredFrag(pos);
        setTabSelection(pos);
    }

    // tab background selection method
    public void settabstrip(int pos) {
        try {
            if (pos == 0) {
                strip_top.setVisibility(View.VISIBLE);
                strip_popular.setVisibility(View.GONE);
                txt_top.setTextColor(getResources().getColor(R.color.white));
                txt_popular.setTextColor(getResources().getColor(R.color.black));
                CurrentFragment = "TopFragment";
            }
            if (pos == 1) {
                strip_top.setVisibility(View.GONE);
                strip_popular.setVisibility(View.VISIBLE);
                txt_top.setTextColor(getResources().getColor(R.color.black));
                txt_popular.setTextColor(getResources().getColor(R.color.white));
                CurrentFragment = "PopularFragment";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // call perticular fragemnt
    private void callOnResumeOfRequiredFrag(int pos) {
        try {
            if (pos == 0) {
                adapter.getTop_fragment();
                settabstrip(0);
            }
            if (pos == 1) {
                adapter.getPopularFragment();
                settabstrip(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // highlight perticular tab after click
    private void setTabSelection(int pos) {
        try {
            if (pos == 0) {
                rl_toptap.setSelected(true);
                rl_populartap.setSelected(false);

            } else if (pos == 1) {
                rl_toptap.setSelected(false);
                rl_populartap.setSelected(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        moveToPage(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        try {
            if (v == rl_toptap) {
                switchToPage(0);
                settabstrip(0);
            } else if (v == rl_populartap) {
                switchToPage(1);
                settabstrip(1);
            }
            else if (v == grid_img) {
                if (CurrentFragment.equalsIgnoreCase("TopFragment")){
                    TopFragment frag = (TopFragment) getSupportFragmentManager().findFragmentByTag(adapter.getFragmentTag(0));
                    frag.updateLayout();
                }else if(CurrentFragment.equalsIgnoreCase("PopularFragment")){
                    PopularFragment fragment = (PopularFragment) getSupportFragmentManager().findFragmentByTag(adapter.getFragmentTag(1));
                    fragment.updateLayout();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateGridImage(Boolean flag){
        if (flag){
            grid_img.setImageResource(R.drawable.ic_list);
        }else{
            grid_img.setImageResource(R.drawable.ic_menu);
        }
    }
    // View pager adapter
    public class MyPagerAdapter extends FragmentPagerAdapter {

        private TopFragment top_fragment = new TopFragment();
        private PopularFragment popular_fragment = new PopularFragment();

        public TopFragment getTop_fragment() {
            return top_fragment;
        }

        public void setTop_fragment(TopFragment top_fragment) {
            this.top_fragment = top_fragment;
        }

        public PopularFragment getPopularFragment() {
            return popular_fragment;
        }

        public void setPopularFragment(PopularFragment popular_fragment) {
            this.popular_fragment = popular_fragment;
        }
        private String getFragmentTag(int pos) {
            return "android:switcher:" + R.id.pager + ":" + pos;
        }

        public MyPagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        private final String[] TITLES = {"Top Fragment", "Popular Fragment"};

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show Top Fragment
                    return new TopFragment();
                case 1: // Fragment # 0 - This will show Popular different
                    // title
                    return new PopularFragment();

                default:
                    return null;
            }
        }
    }

    // Exit app functionality on back press
    @Override
    public void onBackPressed() {
        int backStackEntryCount = getSupportFragmentManager()
                .getBackStackEntryCount();
        if (backStackEntryCount == 0) {
            new SweetAlertDialog(MainActivity.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("Exit App?")
                    .setContentText("Are want to sure exit app?")
                    .setCancelText("No")
                    .setConfirmText("Yes")
                    .showCancelButton(true)
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.cancel();
                            finish();
                        }
                    })
                    .show();

        } else {
            super.onBackPressed();
        }
    }
}
