package obric.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;
import obric.widget.BHMDrawerItem;

/* JADX INFO: loaded from: classes5.dex */
public class BHMListAdapter<E extends BHMDrawerItem> extends BaseAdapter {
    private List<E> mItemList;

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return false;
    }

    public BHMListAdapter(List<E> list) {
        this.mItemList = new ArrayList();
        setItemList(list);
    }

    public BHMListAdapter() {
        this.mItemList = new ArrayList();
    }

    public void setItemList(List<E> list) {
        if (list == null) goto L5;
        this.mItemList.clear();
        this.mItemList.addAll(list);
        return;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mItemList.size();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (getItem(0) != null) goto L6;
        return 1;
    L6:
        return ((BHMDrawerItem) getItem(0)).getViewTypeCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int position) {
        if (getItem(position) != null) goto L5;
        return 0;
    L5:
        return ((BHMDrawerItem) getItem(position)).getViewType();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int position) {
        if (getItem(position) != null) goto L5;
    L7:
        return false;
    L5:
        if (((BHMDrawerItem) getItem(position)).isEnabled() == false) goto L7;
        return true;
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        if (position < this.mItemList.size()) goto L7;
        return null;
    L7:
        return this.mItemList.get(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        if (getItem(position) != null) goto L5;
        return 0;
    L5:
        return getItem(position).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        if (getItem(position) != null) goto L7;
        return null;
    L7:
        return ((BHMDrawerItem) getItem(position)).getView(convertView, parent);
    }
}
