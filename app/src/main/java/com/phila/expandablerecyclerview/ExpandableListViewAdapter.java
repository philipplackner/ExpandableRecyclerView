package com.phila.expandablerecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import java.util.HashMap;
import java.util.List;

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> titles;
    private HashMap<String, List<String>> listHashMap;

    public ExpandableListViewAdapter(Context context,
                                     List<String> titles,
                                     HashMap<String, List<String>> listHashMap) {
        this.context = context;
        this.titles = titles;
        this.listHashMap = listHashMap;
    }

    //this returns how many parent items we have
    @Override
    public int getGroupCount() {
        return titles.size();
    }

    //this returns the size of the children list of parent item with index i
    @Override
    public int getChildrenCount(int i) {
        return listHashMap.get(titles.get(i)).size();
    }

    //this returns the parent object with index i
    @Override
    public Object getGroup(int i) {
        return titles.get(i);
    }

    //this returns a specific sub item
    @Override
    public Object getChild(int i, int i1) {
        //this is the parent item with index i
        String parentListItem = titles.get(i);

        //this is the list with all child items of parentListItem
        List<String> childrenList = listHashMap.get(parentListItem);

        //this is the specific sub item
        return childrenList.get(i1);
    }

    //this returns the index of our parent item
    @Override
    public long getGroupId(int i) {
        return i;
    }

    //this returns the index of our child item
    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    //returns the view of the parent with index i
    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                    .inflate(R.layout.parent_list_item, null);
        }
        TextView tvParentListItem = view.findViewById(R.id.tvParentListItem);
        tvParentListItem.setText((String) getGroup(i));
        return view;
    }

    //returns the view of the child with index i, i1
    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                    .inflate(R.layout.expandable_list_item, null);
        }
        TextView tvExpandedListTextView = view.findViewById(R.id.tvExpandableListItem);
        tvExpandedListTextView.setText((String) getChild(i, i1));
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
