package com.lancoder.ttb.bottomnavigation.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.lancoder.ttb.bottomnavigation.item.BottomViewItem;
import com.lancoder.ttb.bottomnavigation.iterator.BottomViewIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangcd on 2018/2/11.
 */

public class BottomNavigationView extends LinearLayout {

    /**
     * tab页面列表
     */
    private List<BottomViewItem> mBottomViewItems;

    /**
     * 当前tab的index
     */
    private int mCurrentIndex = -1;

    private OnItemSelectListner mOnItemSelectListner;

    public BottomNavigationView(Context context) {
        this(context,null);
    }

    public BottomNavigationView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BottomNavigationView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(HORIZONTAL);
        mBottomViewItems = new ArrayList<>();
    }


    public void addItems(BottomViewIterator iterator){
        mBottomViewItems.clear();
        int inx = 0;
        while (iterator.hasNext()){
            BottomViewItem item = iterator.next();
            View childView = item.getView();
            addView(childView);
            LinearLayout.LayoutParams params = (LayoutParams) childView.getLayoutParams();
            params.weight = 1;
            params.gravity = Gravity.CENTER;
            childView.setLayoutParams(params);

            setClickListner(childView,inx++);
            mBottomViewItems.add(item);
        }
        mBottomViewItems.get(0).setSelected(true);
        mCurrentIndex = 0;

        /*mBottomViewItems.addAll(bottomViewItems);

        for (int i = 0; i < bottomViewItems.size(); i++) {
            BottomViewItem item = bottomViewItems.get(i);
            View childView = item.getView();
            addView(childView);
            LinearLayout.LayoutParams params = (LayoutParams) childView.getLayoutParams();
            params.weight = 1;
            params.gravity = Gravity.CENTER;
            childView.setLayoutParams(params);

            setClickListner(childView,i);
        }
        mBottomViewItems.get(0).setSelected(true);
        mCurrentIndex = 0;*/

    }

    private void setClickListner(View childView, final int position) {
        childView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position!=mCurrentIndex){
                    mBottomViewItems.get(mCurrentIndex).setSelected(false);
                    mCurrentIndex = position;
                    mBottomViewItems.get(mCurrentIndex).setSelected(true);
                }
            }
        });
        if(mOnItemSelectListner !=null){
            mOnItemSelectListner.selectItem(position);
        }
    }

    public void setOnItemSelectListner(OnItemSelectListner onItemSelectListner) {
        mOnItemSelectListner = onItemSelectListner;
    }

    public interface OnItemSelectListner {
        void selectItem(int position);
    }
}
