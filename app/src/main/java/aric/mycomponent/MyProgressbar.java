package aric.mycomponent;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/**
 * aric.mycomponent
 * Created by Aric on 下午6:48.
 */

public class MyProgressbar extends ProgressBar {
    public MyProgressbar(Context context) {
        this(context,null);
    }

    public MyProgressbar(Context context, AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public MyProgressbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
