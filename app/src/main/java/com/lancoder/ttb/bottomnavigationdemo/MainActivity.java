package com.lancoder.ttb.bottomnavigationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.lancoder.ttb.bottomnavigation.view.BottomNavigationView;
import com.lancoder.ttb.bottomnavigation.item.BottomViewItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNavigationView = findViewById(R.id.bottom_view);
        List<BottomViewItem> bottomItems = new ArrayList<>();
        bottomItems.add(new MyBottomItem.Builder(this)
                .text("text1")
                .textColor(R.color.tab_color)
                .icon(R.drawable.tab_icon).bulid());
        bottomItems.add(new MyBottomItem.Builder(this)
                .text("text2")
                .textColor(R.color.tab_color)
                .icon(R.drawable.tab_icon).bulid());
        bottomItems.add(new MyBottomItem.Builder(this)
                .text("text3")
                .textColor(R.color.tab_color)
                .icon(R.drawable.tab_icon).bulid());
        MyBottomViewIterator iterator = new MyBottomViewIterator();
        iterator.addItem(new MyBottomItem.Builder(this)
                .textColor(R.color.tab_color)
                .icon(R.drawable.tab_icon).bulid());
        iterator.addItem(new MyBottomItem.Builder(this)
                .textColor(R.color.tab_color)
                .icon(R.drawable.tab_icon).bulid());
        iterator.addItem(new MyBottomItem.Builder(this)
                .textColor(R.color.tab_color)
                .icon(R.drawable.tab_icon).bulid());
        mBottomNavigationView.addItems(iterator);
        mBottomNavigationView.setOnItemSelectListner(new BottomNavigationView.OnItemSelectListner() {
            @Override
            public void selectItem(int position) {
                Toast.makeText(MainActivity.this,position+"",Toast.LENGTH_SHORT);
            }
        });
    }
}
