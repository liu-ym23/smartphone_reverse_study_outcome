package com.android.setupwizardlib.items;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class ItemInflater extends ReflectionInflater<ItemHierarchy> {

    public interface ItemParent {
        void addChild(ItemHierarchy r1);
    }

    @Override // com.android.setupwizardlib.items.SimpleInflater
    protected /* bridge */ /* synthetic */ void onAddChildItem(Object r1, Object r2) {
        onAddChildItem((ItemHierarchy) r1, (ItemHierarchy) r2);
    }

    public ItemInflater(Context r2) {
        super(r2);
        setDefaultPackage(Item.class.getPackage().getName() + ".");
    }

    protected void onAddChildItem(ItemHierarchy r2, ItemHierarchy r3) {
        if ((r2 instanceof ItemParent) == false) goto L7;
        ((ItemParent) r2).addChild(r3);
        return;
    L7:
        throw new IllegalArgumentException("Cannot add child item to " + r2);
    }
}
