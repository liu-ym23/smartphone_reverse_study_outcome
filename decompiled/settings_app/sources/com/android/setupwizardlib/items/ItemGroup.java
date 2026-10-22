package com.android.setupwizardlib.items;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ItemGroup extends AbstractItemHierarchy implements ItemInflater.ItemParent, ItemHierarchy.Observer {
    private static final String TAG = "ItemGroup";
    private final List<ItemHierarchy> children;
    private int count;
    private boolean dirty;
    private final SparseIntArray hierarchyStart;

    private static int binarySearch(SparseIntArray r4, int r5) {
        int r0 = r4.size() - 1;
        int r1 = 0;
    L3:
        if (r1 > r0) goto L12;
        int r2 = (r1 + r0) >>> 1;
        int r3 = r4.valueAt(r2);
        if (r3 < r5) goto L6;
        if (r3 <= r5) goto L10;
        r0 = r2 - 1;
        goto L3
    L10:
        return r4.keyAt(r2);
    L6:
        r1 = r2 + 1;
        goto L3
    L12:
        return r4.keyAt(r1 - 1);
    }

    private static <T> int identityIndexOf(List<T> r3, T r4) {
        int r0 = r3.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (r3.get(r1) == r4) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return -1;
    }

    public ItemGroup() {
        this.children = new ArrayList();
        this.hierarchyStart = new SparseIntArray();
        this.count = 0;
        this.dirty = false;
    }

    public ItemGroup(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.children = new ArrayList();
        this.hierarchyStart = new SparseIntArray();
        this.count = 0;
        this.dirty = false;
    }

    @Override // com.android.setupwizardlib.items.ItemInflater.ItemParent
    public void addChild(ItemHierarchy r2) {
        this.dirty = true;
        this.children.add(r2);
        r2.registerObserver(this);
        int r0 = r2.getCount();
        if (r0 <= 0) goto L6;
        notifyItemRangeInserted(getChildPosition(r2), r0);
        return;
    }

    public boolean removeChild(ItemHierarchy r6) {
        int r0 = identityIndexOf(this.children, r6);
        int r1 = getChildPosition(r0);
        this.dirty = true;
        if (r0 == (-1)) goto L8;
        int r3 = r6.getCount();
        this.children.remove(r0);
        r6.unregisterObserver(this);
        if (r3 <= 0) goto L7;
        notifyItemRangeRemoved(r1, r3);
    L7:
        return true;
    L8:
        return false;
    }

    public void clear() {
        if (this.children.isEmpty() == false) goto L5;
        return;
    L5:
        int r0 = getCount();
        Iterator<ItemHierarchy> r1 = this.children.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r1.next().unregisterObserver(this);
        goto L7
    L9:
        this.dirty = true;
        this.children.clear();
        notifyItemRangeRemoved(0, r0);
    }

    @Override // com.android.setupwizardlib.items.ItemHierarchy
    public int getCount() {
        updateDataIfNeeded();
        return this.count;
    }

    @Override // com.android.setupwizardlib.items.ItemHierarchy
    public IItem getItemAt(int r3) {
        int r0 = getItemIndex(r3);
        return this.children.get(r0).getItemAt(r3 - this.hierarchyStart.get(r0));
    }

    @Override // com.android.setupwizardlib.items.ItemHierarchy.Observer
    public void onChanged(ItemHierarchy r1) {
        this.dirty = true;
        notifyChanged();
    }

    private int getChildPosition(ItemHierarchy r2) {
        return getChildPosition(identityIndexOf(this.children, r2));
    }

    private int getChildPosition(int r4) {
        updateDataIfNeeded();
        if (r4 == (-1)) goto L11;
        int r1 = this.children.size();
        int r2 = -1;
    L5:
        if (r2 >= 0) goto L8;
        if (r4 >= r1) goto L8;
        r2 = this.hierarchyStart.get(r4, -1);
        r4 = r4 + 1;
    L8:
        if (r2 < 0) goto L10;
        return r2;
    L10:
        return getCount();
    L11:
        return -1;
    }

    @Override // com.android.setupwizardlib.items.ItemHierarchy.Observer
    public void onItemRangeChanged(ItemHierarchy r2, int r3, int r4) {
        int r0 = getChildPosition(r2);
        if (r0 < 0) goto L5;
        notifyItemRangeChanged(r0 + r3, r4);
        return;
    L5:
        Log.e(TAG, "Unexpected child change " + r2);
    }

    @Override // com.android.setupwizardlib.items.ItemHierarchy.Observer
    public void onItemRangeInserted(ItemHierarchy r2, int r3, int r4) {
        this.dirty = true;
        int r0 = getChildPosition(r2);
        if (r0 < 0) goto L5;
        notifyItemRangeInserted(r0 + r3, r4);
        return;
    L5:
        Log.e(TAG, "Unexpected child insert " + r2);
    }

    @Override // com.android.setupwizardlib.items.ItemHierarchy.Observer
    public void onItemRangeMoved(ItemHierarchy r2, int r3, int r4, int r5) {
        this.dirty = true;
        int r0 = getChildPosition(r2);
        if (r0 < 0) goto L5;
        notifyItemRangeMoved(r3 + r0, r0 + r4, r5);
        return;
    L5:
        Log.e(TAG, "Unexpected child move " + r2);
    }

    @Override // com.android.setupwizardlib.items.ItemHierarchy.Observer
    public void onItemRangeRemoved(ItemHierarchy r2, int r3, int r4) {
        this.dirty = true;
        int r0 = getChildPosition(r2);
        if (r0 < 0) goto L5;
        notifyItemRangeRemoved(r0 + r3, r4);
        return;
    L5:
        Log.e(TAG, "Unexpected child remove " + r2);
    }

    @Override // com.android.setupwizardlib.items.ItemHierarchy
    public ItemHierarchy findItemById(int r2) {
        if (r2 != getId()) goto L5;
        return this;
    L5:
        Iterator<ItemHierarchy> r1 = this.children.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        ItemHierarchy r0 = r1.next().findItemById(r2);
        if (r0 == null) goto L7;
        return r0;
    L11:
        return null;
    }

    private void updateDataIfNeeded() {
        if (this.dirty == false) goto L16;
        this.count = 0;
        this.hierarchyStart.clear();
        int r1 = 0;
    L6:
        if (r1 >= this.children.size()) goto L11;
        ItemHierarchy r2 = this.children.get(r1);
        if (r2.getCount() <= 0) goto L10;
        this.hierarchyStart.put(r1, this.count);
    L10:
        this.count += r2.getCount();
        r1 = r1 + 1;
        goto L6
    L11:
        this.dirty = false;
        return;
    }

    private int getItemIndex(int r4) {
        updateDataIfNeeded();
        if (r4 < 0) goto L12;
        if (r4 >= this.count) goto L12;
        int r3 = binarySearch(this.hierarchyStart, r4);
        if (r3 < 0) goto L10;
        return r3;
    L10:
        throw new IllegalStateException("Cannot have item start index < 0");
    L12:
        throw new IndexOutOfBoundsException("size=" + this.count + "; index=" + r4);
    }
}
