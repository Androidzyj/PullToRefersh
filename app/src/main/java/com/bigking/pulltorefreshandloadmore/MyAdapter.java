package com.bigking.pulltorefreshandloadmore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 */

public class MyAdapter extends BaseAdapter {
    private List<String> list;
    public MyAdapter(List<String> data){
      this.list = data;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
          convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);

            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) convertView.findViewById(R.id.list_item);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
            viewHolder.textView.setText(list.get(position));

        return convertView;
    }

    class ViewHolder{
        TextView textView;
    }
}
