package com.android.setupwizardlib.items;

/* JADX INFO: loaded from: classes.dex */
public interface ItemHierarchy {

    public interface Observer {
        void onChanged(ItemHierarchy r1);

        void onItemRangeChanged(ItemHierarchy r1, int r2, int r3);

        void onItemRangeInserted(ItemHierarchy r1, int r2, int r3);

        void onItemRangeMoved(ItemHierarchy r1, int r2, int r3, int r4);

        void onItemRangeRemoved(ItemHierarchy r1, int r2, int r3);
    }

    ItemHierarchy findItemById(int r1);

    int getCount();

    IItem getItemAt(int r1);

    void registerObserver(Observer r1);

    void unregisterObserver(Observer r1);
}
