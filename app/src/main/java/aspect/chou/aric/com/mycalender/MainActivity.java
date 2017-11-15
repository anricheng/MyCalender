package aspect.chou.aric.com.mycalender;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;

import java.util.List;

import aric.mycomponent.MyViewPageIndicator;
import aspect.chou.aric.com.mycalender.Adapter.MyFragmentViewPagerAdapter;
import aspect.chou.aric.com.mycalender.fragment.BaseFragment;

public class MainActivity extends BaseActivity {





    Handler mHandler= new Handler();

    private ViewPager mViewPager;

    private MyViewPageIndicator mMyViewPageIndicator;

    private List<BaseFragment> mBaseFragments;


    private MyFragmentViewPagerAdapter mMyFragmentViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container_layout);

        mViewPager = ((ViewPager) findViewById(R.id.fragment_container));
        mMyViewPageIndicator = ((MyViewPageIndicator) findViewById(R.id.my_viewpager_indicator));
        mMyViewPageIndicator.setViewPager(mViewPager);
        mBaseFragments = getFragmentList();


        mMyFragmentViewPagerAdapter = new MyFragmentViewPagerAdapter(getSupportFragmentManager(), this, mBaseFragments);


        mViewPager.setAdapter(mMyFragmentViewPagerAdapter);



    }






}
