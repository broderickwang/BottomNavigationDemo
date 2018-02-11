package com.lancoder.ttb.bottomnavigation.item;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by wangcd on 2018/2/11.
 */

public abstract class BottomViewItem {

    protected Context mContext;

    protected int mLayoutId;

    protected View mBottomItemView;

    protected Builder mBuilder;

    public BottomViewItem(Context context, int layoutId) {
        mContext = context;
        mLayoutId = layoutId;

    }

    public <T> T findView(int id){
        return (T)mBottomItemView.findViewById(id);
    }

    private void setText(int id,CharSequence sequence){
        TextView textView = findView(id);
        textView.setText(sequence);
    }

    private void setIcon(int id, Drawable drawable){
        ImageView imageView = findView(id);
        imageView.setImageDrawable(drawable);
    }


    public abstract void setSelected(boolean selected);

    public View getView(){
        if (mBottomItemView == null){
            mBottomItemView = LayoutInflater.from(mContext).inflate(mLayoutId,null);
            initLayout();
        }
        return mBottomItemView;
    }

    protected abstract void initLayout();


    public abstract class Builder{
        private Context context;

        private int layoutId;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder layoutId(int layoutId){
            this.layoutId = layoutId;
            return this;
        }



    }

}
