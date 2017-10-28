package aric.mycomponent;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import aspect.chou.aric.com.mycalender.R;

/**
 * aric.mycomponent
 * Created by Aric on 下午2:42.
 */

public class MyViewPageIndicator extends LinearLayout {

    public static final int DEFAUT_INDICATOR_COUNT = 4;

    public static final int DEFAULT_INCATOR_TRIANGLE_WIDTH = 30;

    private Paint mPaint;

    private Context mContext;

    private String TRIANGLECOLOR = "#ffffff";

    private int mVisibleIndicatorCount;

    private int mInitIndicatorPositionX;

    private int mIndicatorPositionX;

    private int mIndicatorHeight;

    private int mIndicatorWidth;

    private Path mTrianglePath;

    private ViewPager mViewPager;

    private OnPageChangeListener mOnPageChangeListener;

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        mOnPageChangeListener = onPageChangeListener;
    }

    public MyViewPageIndicator(Context context) {
        this(context, null);
    }

    public MyViewPageIndicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyViewPageIndicator);
        mVisibleIndicatorCount = typedArray.getInteger(R.styleable.MyViewPageIndicator_visibleIndicatorCount, DEFAUT_INDICATOR_COUNT);
        typedArray.recycle();

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.parseColor(TRIANGLECOLOR));
        mPaint.setStyle(Paint.Style.FILL);
        mTrianglePath= new Path();


    }


    public void setVisibleIndicatorCount(){

    }


    /**
     * 在onFinishInflate 函数中可以获取到所有的子View并可以对子View进行参数等的相关测试；
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        setOnItemClickListener();


    }

    /**
     * 在OnSizeChange的方法中根据控件的宽高参数去确定indicator中的三角形的绘制参数
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {

        int mexpectSize = (int) (w / mVisibleIndicatorCount * 0.1);

        mIndicatorWidth = mexpectSize > DEFAULT_INCATOR_TRIANGLE_WIDTH ? DEFAULT_INCATOR_TRIANGLE_WIDTH : mexpectSize;

        mIndicatorHeight=mIndicatorWidth/2;

        //根据宽高的参数去设置整个三角形的path;

        mTrianglePath.moveTo(0,0);
        mTrianglePath.lineTo(mIndicatorWidth,0);
        mTrianglePath.lineTo(mIndicatorWidth/2,-mIndicatorHeight);
        mTrianglePath.close();
        setTextColor(0);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mInitIndicatorPositionX=getScreenWidth()/3/2-mIndicatorWidth/2;

        canvas.save();
        canvas.translate(mIndicatorPositionX+mInitIndicatorPositionX,getBottom());


        canvas.drawPath(mTrianglePath,mPaint);

        canvas.restore();
    }


    private void disableTextColor(){
        for (int i = 0; i < getChildCount(); i++) {
            ((TextView)getChildAt(i)).setTextColor(Color.WHITE);
        }
    }


    private void setTextColor(int position){

        disableTextColor();

        ((TextView) getChildAt(position)).setTextColor(Color.RED);

    }

    private int getScreenWidth() {

        WindowManager wms = (WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        wms.getDefaultDisplay().getMetrics(displayMetrics);

        return displayMetrics.widthPixels;
    }

    private void scrollTo(int position ,float offset ){

        mIndicatorPositionX = position*getScreenWidth()/3 + (int) (offset*getScreenWidth()/3);
        invalidate();

    }


    public interface OnPageChangeListener {

        void onPageScrolled(int position, float positionOffset, int positionOffsetPixels);

        void onPageSelected(int position);

        void onPageScrollStateChanged(int state);
    }


    public void setOnItemClickListener(){
        int childCount = getChildCount();
        for (int i = 0; i <childCount ; i++) {
            final int j=i;
            getChildAt(i).setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    mViewPager.setCurrentItem(j);
                    setTextColor(j);
                }
            });
        }
    }


    public void setViewPager(ViewPager viewPager){

        mViewPager=viewPager;

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                scrollTo(position,positionOffset);

                if (mOnPageChangeListener!=null)

                mOnPageChangeListener.onPageScrolled(position,positionOffset,positionOffsetPixels);

            }

            @Override
            public void onPageSelected(int position) {
                if (mOnPageChangeListener!=null)
                mOnPageChangeListener.onPageSelected(position);

                setTextColor(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (mOnPageChangeListener!=null)
                mOnPageChangeListener.onPageScrollStateChanged(state);

            }
        });

    }
}




