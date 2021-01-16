package com.example.ismail.myapplication;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Ismail on 5/10/2017.
 */
public class Myaddapter extends BaseExpandableListAdapter {
    private List<String> mainchapter;
    private HashMap<String,List<String>> subchapter;
    private Context ctx;
    Myaddapter(Context ctx,List<String> mainchapter,HashMap<String,List<String>> subchapter){
        this.ctx = ctx;
        this.mainchapter =mainchapter;
        this.subchapter = subchapter;
    }
    @Override
    public int getGroupCount() {
        return mainchapter.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return subchapter.get(mainchapter.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mainchapter.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return subchapter.get(mainchapter.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String title = (String) this.getGroup(groupPosition);
        if(convertView == null)
        {
            LayoutInflater layoutinflater =(LayoutInflater) this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutinflater.inflate(R.layout.parent_layout,null);

        }
        TextView textview = (TextView) convertView.findViewById(R.id.hading_item);
        textview.setTypeface(null, Typeface.BOLD);
        textview.setText(title);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String title = (String) this.getChild(groupPosition,childPosition);
        if(convertView==null)
        {
            LayoutInflater layoutinflater =(LayoutInflater) this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutinflater.inflate(R.layout.child_layout,null);
        }
        TextView textview = (TextView) convertView.findViewById(R.id.child_item);
        textview.setText(title);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
