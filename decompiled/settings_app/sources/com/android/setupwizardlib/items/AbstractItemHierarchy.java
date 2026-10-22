package com.android.setupwizardlib.items;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import com.android.setupwizardlib.R;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractItemHierarchy implements ItemHierarchy {
    private static final String TAG = "AbstractItemHierarchy";
    private int id;
    private final ArrayList<ItemHierarchy.Observer> observers;

    public AbstractItemHierarchy() {
        this.observers = new ArrayList();
        this.id = 0;
    }

    public AbstractItemHierarchy(Context r3, AttributeSet r4) {
        this.observers = new ArrayList();
        this.id = 0;
        TypedArray r5 = r3.obtainStyledAttributes(r4, R.styleable.SuwAbstractItem);
        this.id = r5.getResourceId(R.styleable.SuwAbstractItem_android_id, 0);
        r5.recycle();
    }

    public void setId(int r1) {
        this.id = r1;
    }

    public int getId() {
        return this.id;
    }

    public int getViewId() {
        return getId();
    }

    @Override // com.android.setupwizardlib.items.ItemHierarchy
    public void registerObserver(ItemHierarchy.Observer r1) {
        this.observers.add(r1);
    }

    @Override // com.android.setupwizardlib.items.ItemHierarchy
    public void unregisterObserver(ItemHierarchy.Observer r1) {
        this.observers.remove(r1);
    }

    public void notifyChanged() {
        Iterator<ItemHierarchy.Observer> r0 = this.observers.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onChanged(this);
        goto L4
    }

    public void notifyItemRangeChanged(int r3, int r4) {
        if (r3 >= 0) goto L6;
        Log.w(TAG, "notifyItemRangeChanged: Invalid position=" + r3);
        return;
    L6:
        if (r4 >= 0) goto L9;
        Log.w(TAG, "notifyItemRangeChanged: Invalid itemCount=" + r4);
        return;
    L9:
        Iterator<ItemHierarchy.Observer> r0 = this.observers.iterator();
    L11:
        if (r0.hasNext() == false) goto L13;
        r0.next().onItemRangeChanged(this, r3, r4);
        goto L11
    }

    public void notifyItemRangeInserted(int r3, int r4) {
        if (r3 >= 0) goto L6;
        Log.w(TAG, "notifyItemRangeInserted: Invalid position=" + r3);
        return;
    L6:
        if (r4 >= 0) goto L9;
        Log.w(TAG, "notifyItemRangeInserted: Invalid itemCount=" + r4);
        return;
    L9:
        Iterator<ItemHierarchy.Observer> r0 = this.observers.iterator();
    L11:
        if (r0.hasNext() == false) goto L13;
        r0.next().onItemRangeInserted(this, r3, r4);
        goto L11
    }

    public void notifyItemRangeMoved(int r3, int r4, int r5) {
        if (r3 >= 0) goto L6;
        Log.w(TAG, "notifyItemRangeMoved: Invalid fromPosition=" + r3);
        return;
    L6:
        if (r4 >= 0) goto L9;
        Log.w(TAG, "notifyItemRangeMoved: Invalid toPosition=" + r4);
        return;
    L9:
        if (r5 >= 0) goto L12;
        Log.w(TAG, "notifyItemRangeMoved: Invalid itemCount=" + r5);
        return;
    L12:
        Iterator<ItemHierarchy.Observer> r0 = this.observers.iterator();
    L14:
        if (r0.hasNext() == false) goto L16;
        r0.next().onItemRangeMoved(this, r3, r4, r5);
        goto L14
    }

    public void notifyItemRangeRemoved(int r3, int r4) {
        if (r3 >= 0) goto L6;
        Log.w(TAG, "notifyItemRangeInserted: Invalid position=" + r3);
        return;
    L6:
        if (r4 >= 0) goto L9;
        Log.w(TAG, "notifyItemRangeInserted: Invalid itemCount=" + r4);
        return;
    L9:
        Iterator<ItemHierarchy.Observer> r0 = this.observers.iterator();
    L11:
        if (r0.hasNext() == false) goto L13;
        r0.next().onItemRangeRemoved(this, r3, r4);
        goto L11
    }
}
