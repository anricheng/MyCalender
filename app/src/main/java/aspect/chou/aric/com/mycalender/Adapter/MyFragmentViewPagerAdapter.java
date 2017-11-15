package aspect.chou.aric.com.mycalender.Adapter;

import android.content.Context;
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

    Context mContext;

    public MyFragmentViewPagerAdapter(FragmentManager fm, Context context, List<BaseFragment> baseFragments) {
        super(fm);
        this.mBaseFragments=baseFragments;

        this.mContext=context;
    }

    @Override
    public Fragment getItem(int position) {
        return mBaseFragments.get(position);
    }

    @Override
    public int getCount() {
        return mBaseFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "TAB"+position;
    }

    //1.如果想要在tabview中加入图片的话 就使用如下的的复写
//    @Override
//    public CharSequence getPageTitle(int position) {
//        // Generate title based on item position
//        // return tabTitles[position];
//        Drawable image = context.getResources().getDrawable(imageResId[position]);
//        image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
//        SpannableString sb = new SpannableString(" ");
//        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
//        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        return sb;
//    }

//  同时需要在style中添加如下的代码：
//  <style name="MyCustomTabLayout" parent="Widget.Design.TabLayout">
//      <item name="tabTextAppearance">@style/MyCustomTextAppearance</item>
//</style>
//
//<style name="MyCustomTextAppearance" parent="TextAppearance.Design.Tab">
//      <item name="textAllCaps">false</item>
//</style>


    //2.如果要加入自定义的tabview布局的话需要重写如下的方法
//
//    public View getTabView(int position){
//
//
//        View view = LayoutInflater.from(mContext).inflate(R.layout.tabview_item, null);
//        TextView tv= (TextView) view.findViewById(R.id.textView);
//        tv.setText("TAB"+position);
//        ImageView img = (ImageView) view.findViewById(R.id.imageView);
//        img.setImageResource(R.mipmap.ic_launcher);
//        return view;
//    }
//

//
//    同时在使用的时候需要加入如下的代码：
//            tabLayout.setTabMode(TabLayout.MODE_FIXED);
//       for (int i = 0; i < tabLayout.getTabCount(); i++) {
//        TabLayout.Tab tab = tabLayout.getTabAt(i);
//        tab.setCustomView(pagerAdapter.getTabView(i));
//    }
}
