package aspect.chou.aric.com.mycalender;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        LinearLayout mRootLayout = new LinearLayout(this);
        mRootLayout.setOrientation(LinearLayout.HORIZONTAL);


        Toast.makeText(this, "进入initSubtitle", Toast.LENGTH_SHORT).show();
        String[] Week = new String[]{"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期天"};
        LinearLayout mWeekContainer = new LinearLayout(this);

        mWeekContainer.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams mWeekContainerParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);
        mWeekContainerParams.weight = 1;

        //添加一个 星期一到星期天的布局
        for (int i = 0; i < 7; i++) {
            TextView textView = new TextView(this);
            textView.setText(Week[i]);
            textView.setTextSize(15);
            mWeekContainer.removeView(textView);
            mWeekContainer.addView(textView, mWeekContainerParams);

        }

        LinearLayout.LayoutParams mTileLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mRootLayout.addView(mWeekContainer, mTileLayoutParams);
        mRootLayout.removeView(mWeekContainer);

        mRootLayout.addView(mWeekContainer, mTileLayoutParams);
    }



}
