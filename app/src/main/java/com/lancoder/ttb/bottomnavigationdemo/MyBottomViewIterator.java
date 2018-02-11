package com.lancoder.ttb.bottomnavigationdemo;

import com.lancoder.ttb.bottomnavigation.iterator.BottomViewIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangcd on 2018/2/11.
 */

public class MyBottomViewIterator extends BottomViewIterator<MyBottomItem> {

    int index = 0;

    @Override
    public boolean hasNext() {
        return index<mDatas.size();
    }

    @Override
    public MyBottomItem next() {
        return mDatas.get(index++);
    }

    @Override
    public void addItem(MyBottomItem item) {
        mDatas.add(item);
    }
}
