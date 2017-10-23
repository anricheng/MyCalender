package aric.mycomponent;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatTextView;

/**
 * aric.mycomponent
 * Created by Aric on 上午11:42.
 */

public class CalenderTextView extends AppCompatTextView{

    private Paint mPaint;
    public CalenderTextView(Context context) {
        super(context);
        mPaint=new Paint();
    }

//通过重写原来的onDraw方法给Text加上一个背景；
    @Override
    protected void onDraw(Canvas canvas) {
        int height = canvas.getHeight();
        int width = canvas.getWidth();
        super.onDraw(canvas);
    }
}
