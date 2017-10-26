package aspect.chou.aric.com.mycalender.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * aspect.chou.aric.com.mycalender.fragment
 * Created by Aric on 下午3:32.
 */

public class BaseFragment extends Fragment{

    public static String TITLE;
    public static BaseFragment newInstance(String title) {

        Bundle args = new Bundle();

        args.putString(TITLE,title);

        BaseFragment fragment = new BaseFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        String fragmentTitle = getArguments().getString(TITLE);

        TextView textView = new TextView(getContext().getApplicationContext());

        textView.setTextColor(Color.RED);

        textView.setGravity(Gravity.CENTER);

        textView.setText(fragmentTitle);

        return textView;
    }
}
