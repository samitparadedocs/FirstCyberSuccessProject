package com.cybersuccess.demo.firstcybersuccessproject.viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.cybersuccess.demo.firstcybersuccessproject.R;

/**
 * Created by samit
 *
 * @SINCE : 29/5/18
 * FOR: Crest Venue & Entertainment Software Pvt Ltd, Pune.
 */

public class ActViewpagerDemo extends AppCompatActivity {
    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 5;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager_activity_demo);

        // Set the content of the activity to use the  activity_main.xml layout file
        setContentView(R.layout.activity_screen_slide);

        // Find the view pager that will allow the user to swipe between fragments
        mPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());

        // Set the adapter onto the view pager
        mPager.setAdapter(mPagerAdapter);
    }


   @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

   /* *
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.*/
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            ScreenSlidePageFragment screenSlidePageFragmen = new ScreenSlidePageFragment();
            Bundle bundle = new Bundle();
            bundle.putString("page_number", "" + position);
            screenSlidePageFragmen.setArguments(bundle);

            return screenSlidePageFragmen;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
