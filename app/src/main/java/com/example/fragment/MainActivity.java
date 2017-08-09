package com.example.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by MyPC on 03/08/2017.
 */

public class MainActivity extends AppCompatActivity {
    private FirstFragment mFirstFragment;
    private SecondFragment mSecondFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initFragment(); // cách này là add fragment
        // showFirstFragment();
        ///////////////////
    }

    // private void showFirstFragment() {
    //   getSupportFragmentManager().beginTransaction().show(mFirstFragment).hide(mSecondFragment).commit();
    //}
    //   private void showSecondFragment() {
    //      getSupportFragmentManager().beginTransaction().show(mSecondFragment).hide(mFirstFragment).addToBackStack(null).commit();
    //addtobackstack được dùng để khi ấn nút trở về thì sẽ ra lại fragment cũ nếu chọn null thì ra fragment trước đó
    // còn nếu muốn ra fragment nào cụ thể thì gõ tên fragment dó vào
    //  }
/////////////////////////////////////////////////////////////////////
    private void initFragment() {
        mFirstFragment = new FirstFragment();
        mFirstFragment.setListener(new FirstFragment.OnClickButtonListener() {
            @Override
            public void clickButton() {
                showSecondFragment();
            }
        });
        mSecondFragment = new SecondFragment();
        //nếu Fragment mà dùng support thì dùng getSupportFragmentManager
        // còn nếu Fragment không dùng support thì dùng getFragmentManager
        getSupportFragmentManager().beginTransaction()
                .add(R.id.main, mFirstFragment, FirstFragment.class.getName())
                .add(R.id.main, mSecondFragment, SecondFragment.class.getName())
                .commit();
    }
    private void showFirstFragment(){
        if(mFirstFragment == null){
            mFirstFragment = new FirstFragment();
            mFirstFragment.setListener(new FirstFragment.OnClickButtonListener() {
                @Override
                public void clickButton() {
                    showSecondFragment();
                }
            });
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main, mFirstFragment, FirstFragment.class.getName())
                .commit();
    }
    private void showSecondFragment(){
        if(mSecondFragment == null){
            mSecondFragment = new SecondFragment();
        }
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.anim_left_in, R.anim.anim_left_out, R.anim.anim_right_in, R.anim.anim_right_out)
                .replace(R.id.main, mSecondFragment, SecondFragment.class.getName())
                .addToBackStack(null)
                .commit();
    }
}
