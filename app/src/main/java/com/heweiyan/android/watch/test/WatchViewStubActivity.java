package com.heweiyan.android.watch.test;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.WatchViewStub;
import android.widget.TextView;

public class WatchViewStubActivity extends WearableActivity {

    private WatchViewStub mContainerView;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watch_view_stub);
//        setAmbientEnabled();

        mContainerView = (WatchViewStub) findViewById(R.id.container);
        // 因为用的是WatchViewStub，所以需要设置UI绘制监听器，等UI绘制完成后再去获取控件才有用，不然获取到的都是空对象
        mContainerView.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub watchViewStub) {
                mTextView = (TextView) mContainerView.findViewById(R.id.text);

                mTextView.setText("改变");
            }
        });

//        // 这样获取到的对象是空的对象
//        mTextView = (TextView) mContainerView.findViewById(R.id.text);
    }

    @Override
    public void onEnterAmbient(Bundle ambientDetails) {
        super.onEnterAmbient(ambientDetails);
        updateDisplay();
    }

    @Override
    public void onUpdateAmbient() {
        super.onUpdateAmbient();
        updateDisplay();
    }

    @Override
    public void onExitAmbient() {
        updateDisplay();
        super.onExitAmbient();
    }

    private void updateDisplay() {
//        if (isAmbient()) {
//            mContainerView.setBackgroundColor(getResources().getColor(android.R.color.black));
//            mTextView.setTextColor(getResources().getColor(android.R.color.white));
//        } else {
//            mContainerView.setBackground(null);
//            mTextView.setTextColor(getResources().getColor(android.R.color.black));
//        }
    }
}
