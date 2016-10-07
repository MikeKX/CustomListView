package com.dic.kimxeang.customlistview;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Kim Xeang on 9/19/2016.
 */
public class CustomAdapter extends BaseAdapter implements View.OnClickListener {

    private Activity activity;
    private ArrayList data;
    private static LayoutInflater inflater = null;
    public Resources res;
    ListModel tempValues = null;
    int i = 0;

    public CustomAdapter(Activity a, ArrayList d, Resources resLocal) {
        activity = a;
        data = d;
        res = resLocal;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        if (data.size() <= 0)
            return 1;
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder {
        public TextView text, text1;
        public TextView textwide;
        public ImageView image;

    }

    public View getView(int position, View ConvertView, ViewGroup parent) {
        View vi = ConvertView;
        ViewHolder holder;
        if (ConvertView == null) {
            vi = inflater.inflate(R.layout.activity_main, null);
            holder = new ViewHolder();
            holder.text = (TextView) vi.findViewById(R.id.text);
            holder.text1 = (TextView) vi.findViewById(R.id.text1);
            holder.image = (ImageView) vi.findViewById(R.id.image);
            vi.setTag(holder);
        } else
            holder = (ViewHolder) vi.getTag();
        if (data.size() <= 0) {
            holder.text.setText("No Data");
        } else
            tempValues = null;
        tempValues = (ListModel) data.get(position);
        holder.text.setText(tempValues.getCompanyName());
        holder.text1.setText(tempValues.getUrl());
        holder.image.setImageResource(res.getIdentifier("com.dic.kimxeangcustomlistview:drawable/" + tempValues.getImage(), null, null));
        vi.setOnClickListener(new OnItemClickListener(position));

        return vi;
    }

    @Override
    public void onClick(View v) {
        Log.v("CustomAdapter", "========Row button clicked=====");
    }

    public class OnItemClickListener implements View.OnClickListener {
        private int mPosition;

        OnItemClickListener(int position) {
            mPosition = position;
        }

        @Override
        public void onClick(View arg0) {
            CustomListViewAndroid CustomList = (CustomListViewAndroid) activity;
            CustomList.onItemClick(mPosition);
        }

    }

}