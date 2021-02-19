package com.example.gridview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    MyGridAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView=findViewById(R.id.GridView);
        adapter=new MyGridAdapter(this);
        gridView.setAdapter(adapter);
    }
    public class MyGridAdapter extends BaseAdapter {
        Context context;
        int posterIDs[]={R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
                R.drawable.mov06, R.drawable.mov07,R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
                R.drawable.mov06, R.drawable.mov07,R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
                R.drawable.mov06, R.drawable.mov07,R.drawable.mov08, R.drawable.mov09, R.drawable.mov10};
        String posterTitles[]={"써니", "완득이", "괴물", "라이오스타", "비열한 거리", "왕의 남자", "아일랜드", "웰컴 투 동막골",
                "헬보이", "백 투 더 퓨처","써니", "완득이", "괴물", "라이오스타", "비열한 거리", "왕의 남자", "아일랜드", "웰컴 투 동막골",
                "헬보이", "백 투 더 퓨처","써니", "완득이", "괴물", "라이오스타", "비열한 거리", "왕의 남자", "아일랜드", "웰컴 투 동막골",
                "헬보이", "백 투 더 퓨처"};
        public MyGridAdapter(Context context) {
            this.context=context;
        }
        @Override
        public int getCount() {
            return posterIDs.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView ivPoster=new ImageView(context);
            Display display=((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
            int x=display.getWidth()/gridView.getNumColumns();
            ivPoster.setLayoutParams(new GridView.LayoutParams(200, 300));
            ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER); //가운데로 정렬
            ivPoster.setPadding(5, 5, 5,5);
            ivPoster.setImageResource(posterIDs[position]);
            ivPoster.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialogView=View.inflate(MainActivity.this, R.layout.dialog, null);
                    AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                    ImageView dlgPoster=dialogView.findViewById(R.id.dlgPoster);
                    dlgPoster.setImageResource(posterIDs[position]);
                    builder.setTitle(posterTitles[position]);
                    builder.setView(dialogView);
                    builder.setPositiveButton("닫기", null);
                    AlertDialog dialog=builder.create();
                    dialog.show();
                }
            });
            return ivPoster;
        }
    }
}