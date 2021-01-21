package com.hly.timeactivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private String[] data = {"Android", "Java", "C++", "PHP", "Python", "JS", "HTML", "CSS"};
    private ListView listView;
    ArrayList<String> arrayList = new ArrayList<>();
    SingleCheckAdapter adapter;

    private ListView listView1;
    ArrayList<String> arrayList1 = new ArrayList<>();
    List<String> list = new ArrayList<>();
    MultCheckAdapter adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 单选数据
        listView = findViewById(R.id.listView);
        arrayList.addAll(Arrays.asList(data));
        adapter = new SingleCheckAdapter(MainActivity.this, arrayList);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.v("----hxm", "您选择的是:" + arrayList.get(position));
            }
        });

        //多选数据
        listView1 = findViewById(R.id.listView1);
        arrayList1.addAll(Arrays.asList(data));
        adapter1 = new MultCheckAdapter(MainActivity.this, arrayList1);
        listView1.setAdapter(adapter1);
        listView1.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (list.contains(arrayList1.get(position))) {
                    list.remove(arrayList1.get(position));
                } else {
                    list.add(arrayList.get(position));
                }
                Log.v("----hxm", "您选择的是:" + list);

            }
        });

    }

}


