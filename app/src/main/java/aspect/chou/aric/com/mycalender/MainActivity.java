package aspect.chou.aric.com.mycalender;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import aric.mycomponent.MyViewPageIndicator;
import aspect.chou.aric.com.mycalender.Adapter.MyFragmentViewPagerAdapter;
import aspect.chou.aric.com.mycalender.fragment.BaseFragment;

public class MainActivity extends AppCompatActivity {





    Handler mHandler= new Handler();

    private ViewPager mViewPager;

    private MyViewPageIndicator mMyViewPageIndicator;

    private List<BaseFragment> mBaseFragments;


    private MyFragmentViewPagerAdapter mMyFragmentViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_fragment_container_layout);

        mViewPager = ((ViewPager) findViewById(R.id.fragment_container));
        mMyViewPageIndicator = ((MyViewPageIndicator) findViewById(R.id.my_viewpager_indicator));
        mBaseFragments = getFragmentList();
        mHandler.removeCallbacks();

        mMyFragmentViewPagerAdapter = new MyFragmentViewPagerAdapter(getSupportFragmentManager(), mBaseFragments);


        mViewPager.setAdapter(mMyFragmentViewPagerAdapter);


    }

    private List<BaseFragment> getFragmentList() {

        List<BaseFragment> baseFragments = new ArrayList<>();
        List<String> titles = Arrays.asList("新闻", "娱乐", "科技");
        for (String title : titles) {
            BaseFragment fragmentInstance = BaseFragment.newInstance(title);
            baseFragments.add(fragmentInstance);

        }

        return baseFragments;
    }





}
