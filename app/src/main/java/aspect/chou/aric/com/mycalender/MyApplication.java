package aspect.chou.aric.com.mycalender;

import android.app.Application;

import java.util.ArrayList;

/**
 * aspect.chou.aric.com.mycalender
 * Created by Aric on 下午1:36.
 */

public class MyApplication extends Application {

    public  static ArrayList<BaseActivity> activityLists= new ArrayList<>();

    public static  String vinResult;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
