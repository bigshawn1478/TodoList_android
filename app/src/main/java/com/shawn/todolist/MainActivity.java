package com.shawn.todolist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //測試資料
        todolistModel data = new todolistModel(getApplicationContext());
        data.insert(new todolistItem(-1, "hello world", null));
        data.insert(new todolistItem(-1, "lunch time", null));

        //設定recycleView
        recyclerView = findViewById(R.id.todolist_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new todolistAdapter(data.getAll()));
    }
}
