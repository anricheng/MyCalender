package aric.mycomponent;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * aric.mycomponent
 * Created by Aric on 下午6:46.
 */

public class MyChart extends View {
    public MyChart(Context context) {
        this(context,null);
    }

    public MyChart(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public MyChart(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }
}
