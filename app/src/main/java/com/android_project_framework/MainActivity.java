package com.android_project_framework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android_project_framework.app.App;
import com.android_project_framework.bean.DataBean;
import com.android_project_framework.net.ResponseCallBack;
import com.android_project_framework.net.ResponseResult;
import com.android_project_framework.service.ApiService;


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
        authService.getData("1483abc92ac37198042b527e7667e0ff").enqueue(new ResponseCallBack<ResponseResult<DataBean>>() {
            @Override
            public void onSuccess(ResponseResult<DataBean> testBean) {
                textView.setText(testBean.getData().getActivity().getCategory());
                Toast.makeText(MainActivity.this,"success",Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(String msg) {
                Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNoResponse(int code, String msg) {
                Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();
            }
        });


    }


}
