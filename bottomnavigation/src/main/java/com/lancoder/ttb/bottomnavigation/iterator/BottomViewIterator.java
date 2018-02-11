package com.lancoder.ttb.bottomnavigation.iterator;

import com.lancoder.ttb.bottomnavigation.item.BottomViewItem;
import com.lancoder.ttb.bottomnavigation.view.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangcd on 2018/2/11.
 */

public abstract class BottomViewIterator<T extends BottomViewItem> {

    protected List<T> mDatas = new ArrayList<>();

    public abstract boolean hasNext();

    public abstract T next();

    public abstract void addItem(T item);
}
