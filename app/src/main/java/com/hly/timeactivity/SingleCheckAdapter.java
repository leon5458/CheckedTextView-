package com.hly.timeactivity;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;

public class SingleCheckAdapter extends BaseAdapter {
    private ArrayList<String> list;
    private Context mContext;
    private ArrayList<String> resultList = new ArrayList<>();

    public SingleCheckAdapter(Context context, ArrayList<String> list) {
        this.list = list;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.single_list_item_layout, null);
            holder.checkedTextView = convertView.findViewById(R.id.checkedTextView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.checkedTextView.setText(list.get(position));

        return convertView;

    }

    public static class ViewHolder {
        CheckedTextView checkedTextView;
    }


}
