package com.example.adapter_learn;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyCustomAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mItems;
    public MyCustomAdapter(Context mcontext, String[] mitems) {
        this.mContext = mcontext;
        this.mItems = mitems;
    }

    @Override
    public int getCount() {
        return mItems.length;
    }

    @Override
    public Object getItem(int position) {
        return mItems[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.my_list_item, null);
            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.item);
        }

        else{
            holder = (ViewHolder) convertView.getTag();
            holder.textView.setText(mItems[position]);
        }
        holder.textView.setText(mItems[position]);
        convertView.setTag(holder);
        return convertView;

    }
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return null;
    }
    static class ViewHolder {
        TextView textView;
    }
}
