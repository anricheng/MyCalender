package aspect.chou.aric.com.mycalender;

import android.os.Bundle;
import android.support.annotation.Nullable;

import aspect.chou.aric.com.mycalender.fragment.BaseFragment;

/**
 * aspect.chou.aric.com.mycalender
 * Created by Aric on 下午5:07.
 */

public class TestFragmentActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_layout);


        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,BaseFragment.newInstance("test")).commit();
    }
}
