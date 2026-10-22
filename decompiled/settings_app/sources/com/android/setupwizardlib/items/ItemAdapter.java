package com.android.setupwizardlib.items;

import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/* JADX INFO: loaded from: classes.dex */
public class ItemAdapter extends BaseAdapter implements ItemHierarchy.Observer {
    private final ItemHierarchy itemHierarchy;
    private final ViewTypes viewTypes;

    /* JADX INFO: renamed from: com.android.setupwizardlib.items.ItemAdapter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class ViewTypes {
        private int nextPosition;
        private final SparseIntArray positionMap;

        private ViewTypes() {
            this.positionMap = new SparseIntArray();
            this.nextPosition = 0;
        }

        /* synthetic */ ViewTypes(AnonymousClass1 r1) {
            this();
        }

        public int add(int r3) {
            if (this.positionMap.indexOfKey(r3) >= 0) goto L6;
            this.positionMap.put(r3, this.nextPosition);
            this.nextPosition++;
        L6:
            return this.positionMap.get(r3);
        }

        public int size() {
            return this.positionMap.size();
        }

        public int get(int r1) {
            return this.positionMap.get(r1);
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        return r1;
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int r1) {
        return getItem(r1);
    }

    public ItemAdapter(ItemHierarchy r3) {
        this.viewTypes = new ViewTypes(null);
        this.itemHierarchy = r3;
        r3.registerObserver(this);
        refreshViewTypes();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.itemHierarchy.getCount();
    }

    @Override // android.widget.Adapter
    public IItem getItem(int r1) {
        return this.itemHierarchy.getItemAt(r1);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int r1) {
        int r2 = getItem(r1).getLayoutResource();
        return this.viewTypes.get(r2);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.viewTypes.size();
    }

    private void refreshViewTypes() {
        int r0 = 0;
    L4:
        if (r0 >= getCount()) goto L6;
        IItem r1 = getItem(r0);
        this.viewTypes.add(r1.getLayoutResource());
        r0 = r0 + 1;
        goto L4
    }

    @Override // android.widget.Adapter
    public View getView(int r2, View r3, ViewGroup r4) {
        IItem r1 = getItem(r2);
        if (r3 != null) goto L5;
        r3 = LayoutInflater.from(r4.getContext()).inflate(r1.getLayoutResource(), r4, false);
    L5:
        r1.onBindView(r3);
        return r3;
    }

    @Override // com.android.setupwizardlib.items.ItemHierarchy.Observer
    public void onChanged(ItemHierarchy r1) {
        refreshViewTypes();
        notifyDataSetChanged();
    }

    @Override // com.android.setupwizardlib.items.ItemHierarchy.Observer
    public void onItemRangeChanged(ItemHierarchy r1, int r2, int r3) {
        onChanged(r1);
    }

    @Override // com.android.setupwizardlib.items.ItemHierarchy.Observer
    public void onItemRangeInserted(ItemHierarchy r1, int r2, int r3) {
        onChanged(r1);
    }

    @Override // com.android.setupwizardlib.items.ItemHierarchy.Observer
    public void onItemRangeMoved(ItemHierarchy r1, int r2, int r3, int r4) {
        onChanged(r1);
    }

    @Override // com.android.setupwizardlib.items.ItemHierarchy.Observer
    public void onItemRangeRemoved(ItemHierarchy r1, int r2, int r3) {
        onChanged(r1);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int r1) {
        return getItem(r1).isEnabled();
    }

    public ItemHierarchy findItemById(int r1) {
        return this.itemHierarchy.findItemById(r1);
    }

    public ItemHierarchy getRootItemHierarchy() {
        return this.itemHierarchy;
    }
}
