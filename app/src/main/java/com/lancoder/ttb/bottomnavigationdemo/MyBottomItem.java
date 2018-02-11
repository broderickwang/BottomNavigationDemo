package com.lancoder.ttb.bottomnavigationdemo;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lancoder.ttb.bottomnavigation.item.BottomViewItem;

/**
 * Created by wangcd on 2018/2/11.
 */

public class MyBottomItem extends BottomViewItem {

    private Context mContext;

    private Builder mBuilder;

    private MyBottomItem(Context context) {
        super(context, R.layout.my_bottom_item_view);
        this.mContext = context;
    }

    private MyBottomItem(Builder builder){
        this(builder.context);
        this.mBuilder = builder;
    }

    @Override
    public void setSelected(boolean selected) {
        TextView textView = findView(R.id.tab_text);
        ImageView imageView = findView(R.id.tab_icon);

        textView.setSelected(selected);
        imageView.setSelected(selected);
    }

    @Override
    protected void initLayout() {
        TextView textView = findView(R.id.tab_text);
        if(!TextUtils.isEmpty(mBuilder.text)) {
            textView.setText(mBuilder.text);
            textView.setTextColor(mBuilder.color);
        }else{
            textView.setVisibility(View.GONE);
        }
        ImageView imageView = findView(R.id.tab_icon);
        imageView.setImageResource(mBuilder.iconId);
    }

    public static class Builder{
        private Context context;
        private int iconId;
        private CharSequence text;
        private int color;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder text(CharSequence sequence){
            text = sequence;
            return this;
        }

        public Builder icon(int id){
            this.iconId = id;
            return this;
        }

        public Builder textColor(int color){
            this.color = color;
            return this;
        }

        public MyBottomItem bulid(){
            if (iconId <= 0){
                throw new IllegalArgumentException("Please set icon for BottomNavigtionView!");
            }
            return  new MyBottomItem(this);
        }
    }

}
