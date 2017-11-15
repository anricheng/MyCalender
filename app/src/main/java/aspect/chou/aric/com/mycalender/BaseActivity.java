package aspect.chou.aric.com.mycalender;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import aspect.chou.aric.com.mycalender.fragment.BaseFragment;

/**
 * aspect.chou.aric.com.mycalender
 * Created by Aric on 下午1:34.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        MyApplication.activityLists.add(this);

        AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
    }


    protected void NavigatorTo(Class<? extends BaseActivity> clazz){
        startActivity(new Intent(this,clazz));
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

     List<BaseFragment> getFragmentList() {

        List<BaseFragment> baseFragments = new ArrayList<>();
         //, "科技","新闻1", "娱乐1", "科技1","新闻2", "娱乐2", "科技2","新闻3", "娱乐3", "科技3"
        List<String> titles = Arrays.asList("新闻", "娱乐");
        for (String title : titles) {
            BaseFragment fragmentInstance = BaseFragment.newInstance(title);
            baseFragments.add(fragmentInstance);

        }

        return baseFragments;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyApplication.activityLists.remove(this);
    }


    public boolean hasPermission(String... permissions) {
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }

        return true;
    }

    /**
     * request permissions from user
     *
     * @param code
     * @param permissions
     */
    public void requestPermission(int code, String... permissions) {
        ActivityCompat.requestPermissions(this, permissions, code);
    }
    //disable permission request
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case Constants.CAMERA_CODE:
                grantCamera(grantResults);
                break;
        }
    }

    public void grantCamera(int[] grantResults) {

    }
}
