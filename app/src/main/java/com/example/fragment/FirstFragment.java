package com.example.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by MyPC on 03/08/2017.
 */

public class FirstFragment extends Fragment {
    private View rootView;
    private Button btnSecondFragment;
    private OnClickButtonListener listener;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_first, container, false);
        initView();
        return rootView;
    }

    public void setListener(OnClickButtonListener listener) {
        this.listener = listener;
    }

    private void initView() {
        btnSecondFragment = (Button) rootView.findViewById(R.id.btn_show_2nd_fragment);
        btnSecondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.clickButton();
            }
        });
    }
    public interface OnClickButtonListener{
        void clickButton();
    }

}
