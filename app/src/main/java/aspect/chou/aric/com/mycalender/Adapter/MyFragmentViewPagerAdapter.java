package aspect.chou.aric.com.mycalender.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import aspect.chou.aric.com.mycalender.fragment.BaseFragment;

/**
 * aspect.chou.aric.com.mycalender.Adapter
 * FragmentPageAdapter 适合少量的fragment的情况下，因为在destroyItem里面只会讲fragment 的UI与 Activity的UI进行detach，而不会销毁这个fragment
 * FragmentStatePageAdapter适合大量的fragment的情况，因为会直接销魂所有的fragment，避免造成内存的泄漏
 * Created by Aric on 下午3:47.
 */

public class MyFragmentViewPagerAdapter extends FragmentPagerAdapter{

    List<BaseFragment> mBaseFragments;

    public MyFragmentViewPagerAdapter(FragmentManager fm,  List<BaseFragment> baseFragments) {
        super(fm);
        this.mBaseFragments=baseFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mBaseFragments.get(position);
    }

    @Override
    public int getCount() {
        return mBaseFragments.size();
    }
}
