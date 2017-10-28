package aspect.chou.aric.com.mycalender;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * aspect.chou.aric.com.mycalender
 * Created by Aric on 下午7:02.
 */

public class CircleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_circle_menu);
    }

}
