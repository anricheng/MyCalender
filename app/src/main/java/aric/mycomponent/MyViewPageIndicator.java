package aric.mycomponent;

import android.content.Context;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * aric.mycomponent
 * Created by Aric on 下午2:42.
 */

public class MyViewPageIndicator extends LinearLayout {

    private Paint mPaint;

    private String TRIANGLECOLOR = "#ffffff";

    private int mInitIndicatorPositionX;

    private int mIndicatorPositionX;

    private int mIndicatorHeight;

    private int mIndicatorWidth;


    public MyViewPageIndicator(Context context) {
        this(context, null);
    }

    public MyViewPageIndicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mPaint = new Paint();

        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.parseColor(TRIANGLECOLOR));
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setPathEffect(new CornerPathEffect(3));

    }




    /**
     * 在onFinishInflate 函数中
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * 在这个函数中获得整个控件的大小，以便设置每个item的大小，进而设置每个indicatior的位置；
     * 这个函数调用的时机：
     *
     * removeView(): 子onMeasure --> 父onMeasure -->子onLayout-->父onLayout
     *addView():子onMeasure --> 父onMeasure -->子onLayout-->父onLayout
     *
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {




    }
}




