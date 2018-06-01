package com.shawn.todolist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 準備資料，塞50個項目到ArrayList裡
        ArrayList<String> mData = new ArrayList<String>();
        for(int i = 0; i < 50; i++) {

            mData.add("項目"+i);
        }

        //設定recycleView
        recyclerView = findViewById(R.id.todolist_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new todolistAdapter(mData));
    }
}
