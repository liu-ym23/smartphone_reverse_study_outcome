package com.android.setupwizardlib.items;

import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractItem extends AbstractItemHierarchy implements IItem {
    @Override // com.android.setupwizardlib.items.ItemHierarchy
    public int getCount() {
        return 1;
    }

    @Override // com.android.setupwizardlib.items.ItemHierarchy
    public IItem getItemAt(int r1) {
        return this;
    }

    public AbstractItem() {
    }

    public AbstractItem(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // com.android.setupwizardlib.items.ItemHierarchy
    public ItemHierarchy findItemById(int r2) {
        if (r2 != getId()) goto L5;
        return this;
    L5:
        return null;
    }

    public void notifyItemChanged() {
        notifyItemRangeChanged(0, 1);
    }
}
