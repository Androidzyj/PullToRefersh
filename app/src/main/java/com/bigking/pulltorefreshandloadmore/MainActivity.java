package com.bigking.pulltorefreshandloadmore;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

public class MainActivity extends Activity {
    private List<String> datalist;


    @InjectView(R.id.ultra_ptr_frame)
    PtrClassicFrameLayout  ptrFrame;

    @InjectView(R.id.list)
    ListView mList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        datalist = new ArrayList<>();

        datalist.add("1");
        datalist.add("2");
        datalist.add("3");
        datalist.add("4");
        datalist.add("5");
        datalist.add("6");
        datalist.add("7");
        datalist.add("8");
        datalist.add("1");
        datalist.add("2");
        datalist.add("3");
        datalist.add("4");
        datalist.add("5");
        datalist.add("6");
        datalist.add("7");
        datalist.add("8");




        mList.setAdapter(new MyAdapter(datalist));


        ptrFrame.setLastUpdateTimeRelateObject(this);

        //下拉刷新的阻力，下拉时，下拉距离和显示头部的距离比例，值越大，则越不容易滑动
        ptrFrame.setRatioOfHeaderHeightToRefresh(1.2f);

        ptrFrame.setDurationToClose(200);//返回到刷新的位置（暂未找到）

        ptrFrame.setDurationToCloseHeader(1000);//关闭头部时间，默认是false

        ptrFrame.setPullToRefresh(false);//当下拉到一定距离时，自动刷新（true）

        ptrFrame.setKeepHeaderWhenRefresh(true);//刷新时保持头部可见

        ptrFrame.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame,content,header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                //数据刷新的回调
                ptrFrame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ptrFrame.refreshComplete();
                    }
                },1500);
            }
        });
    }
}
