package com.android_project_framework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android_project_framework.app.App;
import com.android_project_framework.bean.DataBean;
import com.android_project_framework.net.ResponseCallBack;
import com.android_project_framework.service.ApiService;
import com.android_project_framwork.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity{
    @BindView(R.id.text)
    TextView textView;
    @Inject
    ApiService authService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        App.cmpt(this).inject(this);
    }

    @OnClick(R.id.btn)
    void click(View view){
        authService.getData("eda61a2c1dff70d56afb6348d5234627").enqueue(new ResponseCallBack<DataBean>() {
            @Override
            public void onSuccess(DataBean testBean) {
                textView.setText(testBean.getActivity().getCategory());
            }

            @Override
            public void onFailure(String msg) {
                Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();
            }
        });


    }


}
