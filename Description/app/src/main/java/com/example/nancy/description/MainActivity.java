package com.example.nancy.description;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity {

    private ViewPager viewPager_top , viewPager_bottom;
    private PagerAdapter_class pagerAdapter_class;
    private int[] swipable_top_layouts;
    private LinearLayout dots_top;
    private TextView[] dots_top_text;
    private TabLayout tabLayout_below;
    private DrawerLayout drawerLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager_top=(ViewPager)findViewById(R.id.viewpager_top);
        dots_top=(LinearLayout)findViewById(R.id.dots_top);

        viewPager_bottom = (ViewPager)findViewById(R.id.viewpager_bottom);
        tabLayout_below=(TabLayout)findViewById(R.id.Tabs_below);

        addTabs_atBottom(viewPager_bottom);
        tabLayout_below.setupWithViewPager(viewPager_bottom);


        swipable_top_layouts=new int[]{R.layout.swipable_one, R.layout.swipable_two , R.layout.swipable_three, R.layout.swipable_four, R.layout.swipable_five};
        addBottomDots_top(0);

        pagerAdapter_class=new PagerAdapter_class();
        viewPager_top.setAdapter(pagerAdapter_class);
        viewPager_top.addOnPageChangeListener(viewPagerPageListener_top);

    }

    private void addTabs_atBottom(ViewPager viewPager)
    {
        ViewPagerAdapter_bottom  adapter= new ViewPagerAdapter_bottom(getSupportFragmentManager());
        adapter.addFragment(new posture_description(),"Description");
        adapter.addFragment(new posture_description(), "3D Muscle Posture");
        adapter.addFragment(new posture_description(),"Wrong Posture");
        viewPager.setAdapter(adapter);
    }

    private void addBottomDots_top(int currentPage)
    {
        dots_top_text = new TextView[swipable_top_layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dots_top.removeAllViews();
        for (int i = 0; i < dots_top_text.length; i++) {
            dots_top_text[i] = new TextView(this);
            dots_top_text[i].setText(Html.fromHtml("&#8226;"));
            dots_top_text[i].setTextSize(35);
            dots_top_text[i].setTextColor(colorsInactive[currentPage]);
            dots_top.addView(dots_top_text[i]);
        }

        if (dots_top_text.length > 0)
            dots_top_text[currentPage].setTextColor(colorsActive[currentPage]);
    }
    private int getItem(int i)
    {
        return viewPager_top.getCurrentItem()+i;
    }

    ViewPager.OnPageChangeListener viewPagerPageListener_top = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots_top(position);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {//empty constructor
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {//empty constructor
        }
    };

    public class PagerAdapter_class extends PagerAdapter{

        private LayoutInflater layoutInflater;
        public PagerAdapter_class() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(swipable_top_layouts[position], container, false);
            container.addView(view);

            return view;
        }
        @Override
        public int getCount() {
            return swipable_top_layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }

} //end of class

    class ViewPagerAdapter_bottom extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter_bottom(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}


