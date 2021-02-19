package com.example.adapterview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView1;
    String nation[]={"대한민국", "영국", "미국", "네덜란드","벨기에", "스페인", "독일", "일본","중국",
            "호주", "멕시코", "아르헨티나", "브라질", "프랑스"};
    String fifaRanking[]={"10위", "3위", "4위", "11위", "100위","98위", "76위", "35위", "66위", "2위",
            "39위", "37위", "22위", "66위"};
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView1=findViewById(R.id.listView1);
//        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice, nation);
        adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, nation);
        listView1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), nation[position]+"의 현재 피파랭킹 순위 "
                        + fifaRanking[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}