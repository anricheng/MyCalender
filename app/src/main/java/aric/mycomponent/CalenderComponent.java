package aric.mycomponent;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import aspect.chou.aric.com.mycalender.R;

/**
 * aric.mycomponent
 * Created by Aric on 上午10:28.
 */

public class CalenderComponent extends LinearLayout {


    private Drawable mLeftImageSrc;
    private boolean mLeftButtonVisibility;
    private RelativeLayout.LayoutParams mLeftLayoutParams;
    private ImageView mLeftImageView;
    private Drawable mRightImageSrc;
    private boolean mRightButtonVisibility;
    private RelativeLayout.LayoutParams mRightLayoutParams;
    private ImageView mRightImageView;

    private Calendar mCurrentDate;

    private TextView mTextView;
    private String mTitleDataFormat = "MMMM yyyy";
    private float mTitleSize;
    private int mTitleColor;
    private float mTitleDefaultSize = 0;
    private RelativeLayout.LayoutParams mTextLayoutParams;


    private RelativeLayout mTitleLayout;
    private LinearLayout mRootLayout;
    private LinearLayout.LayoutParams mTileLayoutParams;

    private GridLayoutManager mGridLayoutManager;
    private RecyclerView mRecyclerView;
    private MyAdapter mMyAdapter;

    public CalenderComponent(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initParams(context, attrs);
        initView(context);
        bindEvent(context);



    }

    private void bindEvent(final Context context) {

        mLeftImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentDate.add(Calendar.MONTH, -1);
                renderCalendar(context);
            }
        });

        mRightImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentDate.add(Calendar.MONTH, 1);
                renderCalendar(context);
            }
        });
    }

    private void initView(Context context) {

        mRootLayout = new LinearLayout(context);
        mRootLayout.setOrientation(LinearLayout.HORIZONTAL);
        initHeader(context);
        initSubtitle(context);
        initCalendar(context);


    }

    private void initCalendar(Context context) {

        //使用recyfleView 作为日历的主要控件；
        mRecyclerView = new RecyclerView(context);
        //将这个recycleView添加到root 布局当中；
        mTileLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        removeView(mRecyclerView);
       addView(mRecyclerView, mTileLayoutParams);
        renderCalendar(context);

    }

    private void initSubtitle(Context context) {
        String[] Week = new String[]{"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期天"};
        LinearLayout mWeekContainer = new LinearLayout(context);

        mWeekContainer.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams mWeekContainerParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);
        mWeekContainerParams.weight = 1;

        //添加一个 星期一到星期天的布局
        for (int i = 0; i < 7; i++) {
            TextView textView = new TextView(context);
            textView.setText(Week[i]);
            textView.setTextSize(8);
            textView.setPadding(2,2,2,2);
            textView.setGravity(Gravity.CENTER);
            mWeekContainer.removeView(textView);
            mWeekContainer.addView(textView, mWeekContainerParams);


        }
        mRootLayout.removeView(mWeekContainer);

        addView(mWeekContainer, mTileLayoutParams);
        mWeekContainer.requestLayout();
    }

    private void initHeader(Context context) {
        mTextView = new TextView(context);
        mTitleLayout = new RelativeLayout(context);
        //使用代码将整个的Header布局添加进整个布局
        mLeftImageView = new ImageView(context);
        mLeftImageView.setImageDrawable(mLeftImageSrc);
        mLeftImageView.setVisibility(mLeftButtonVisibility ? VISIBLE : GONE);
        mLeftLayoutParams = new RelativeLayout.LayoutParams(50, 50);
        mLeftLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        mTitleLayout.removeView(mLeftImageView);
        mTitleLayout.addView(mLeftImageView, mLeftLayoutParams);


        mRightImageView = new ImageView(context);
        mRightImageView.setImageDrawable(mRightImageSrc);
        mRightImageView.setVisibility(mRightButtonVisibility ? VISIBLE : GONE);
        mRightLayoutParams = new RelativeLayout.LayoutParams(50, 50);
        mRightLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        mTitleLayout.removeView(mRightImageView);
        mTitleLayout.addView(mRightImageView, mRightLayoutParams);



        mTextView.setTextColor(mTitleColor);
        mTextView.setTextSize(mTitleSize);
        Date time = mCurrentDate.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(mTitleDataFormat);
        String title = simpleDateFormat.format(time);
        mTextView.setText(title);
        Toast.makeText(context, title, Toast.LENGTH_SHORT).show();

        mTextLayoutParams  = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mTextLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        mTitleLayout.removeView(mTextView);
        mTextView.setText(title);
        mTitleLayout.addView(mTextView, mTextLayoutParams);
        mTextView.setText(title);



        //将title布局填充到root布局当中；
        mTileLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mRootLayout.removeView(mTitleLayout);
        addView(mTitleLayout, mTileLayoutParams);

    }

    private void renderCalendar(Context context) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(mTitleDataFormat);
        mTextView.setText(simpleDateFormat.format(mCurrentDate.getTime()));

        mGridLayoutManager = new GridLayoutManager(context, 7);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        mMyAdapter = new MyAdapter(getCalenderDateList());
        mRecyclerView.setAdapter(mMyAdapter);

    }

    private ArrayList getCalenderDateList() {

        ArrayList<Date> days = new ArrayList<>();

        Calendar calendar = ((Calendar) mCurrentDate.clone());

        calendar.set(Calendar.DAY_OF_MONTH, 1);//将calendar变量设置为本月的第一天
        int dayInWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int realDayInWeek =dayInWeek-1==0?7:dayInWeek-1;
        int prevDays= realDayInWeek-1;
        calendar.add(Calendar.DAY_OF_MONTH,-prevDays);
        int maxDaysInMonth=6*7;
        while (days.size()<maxDaysInMonth){
            days.add(calendar.getTime());
            calendar.add(Calendar.DAY_OF_MONTH,1);
        }
        return days;
    }


    private void initParams(Context context, @Nullable AttributeSet attrs) {
        mCurrentDate = Calendar.getInstance();

        //get all the params from layout xml file
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CalenderComponent);
        mLeftImageSrc = typedArray.getDrawable(R.styleable.CalenderComponent_leftButtonDrawable);
        mLeftButtonVisibility = typedArray.getBoolean(R.styleable.CalenderComponent_leftButtonVisibility, true);
        mRightImageSrc = typedArray.getDrawable(R.styleable.CalenderComponent_rightButtonDrawable);
        mRightButtonVisibility = typedArray.getBoolean(R.styleable.CalenderComponent_rightButtonVisibility, true);
        mTitleDataFormat = typedArray.getString(R.styleable.CalenderComponent_titilDateFormat);
        mTitleColor = typedArray.getColor(R.styleable.CalenderComponent_titleTextColor, Color.BLACK);
        mTitleSize = typedArray.getDimension(R.styleable.CalenderComponent_titleTextSize, mTitleDefaultSize);
        typedArray.recycle();
    }


    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private ArrayList<Date> datas = null;
        Calendar instance;

        private MyAdapter(ArrayList<Date> data) {
            this.datas = data;
            instance = Calendar.getInstance();
        }

        //创建新View，被LayoutManager所调用
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

            TextView textView = new TextView(viewGroup.getContext());
            textView.setGravity(Gravity.CENTER);
            ViewHolder vh = new ViewHolder(textView);
            return vh;
        }

        //将数据与界面进行绑定的操作
        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int position) {
            Date date = datas.get(position);

            if (date.getYear()==mCurrentDate.getTime().getYear()&&date.getMonth()==mCurrentDate.getTime().getMonth()){
                viewHolder.mTextView.setText(datas.get(position).getDate()+"");
                viewHolder.mTextView.setTextColor(Color.RED);


            }


            if (date.getMonth()==instance.getTime().getMonth()&&date.getYear()==instance.getTime().getYear()&&date.getDate()==instance.getTime().getDate())
                viewHolder.mTextView.setTextColor(Color.BLUE);
            viewHolder.mTextView.setText(datas.get(position).getDate()+"");

        }



        //获取数据的数量
        @Override
        public int getItemCount() {
            return datas.size();
        }


        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView mTextView;

            public ViewHolder(View view) {
                super(view);
                mTextView= ((TextView) view);
            }
        }
    }

}
