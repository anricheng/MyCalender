package aspect.chou.aric.com.mycalender;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import aspect.chou.aric.com.mycalender.Adapter.MyFragmentViewPagerAdapter;

public class TablayoutLayoutActivity extends BaseActivity  {

    private TabLayout tablayout;
    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout_layout);

        tablayout = (TabLayout) findViewById(R.id.tablayout);
        viewpager = (ViewPager) findViewById(R.id.viewpager);

        MyFragmentViewPagerAdapter myFragmentViewPagerAdapter = new MyFragmentViewPagerAdapter(getSupportFragmentManager(), this, getFragmentList());
        viewpager.setAdapter(myFragmentViewPagerAdapter);

        tablayout.setupWithViewPager(viewpager);

        tablayout.setTabMode(TabLayout.MODE_FIXED);

//        for (int i = 0; i < tablayout.getTabCount(); i++) {
//        TabLayout.Tab tab = tablayout.getTabAt(i);
////        tab.setCustomView(myFragmentViewPagerAdapter.getTabView(i));}
//
//
    }

}
