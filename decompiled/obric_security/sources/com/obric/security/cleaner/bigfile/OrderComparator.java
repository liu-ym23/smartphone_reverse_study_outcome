package com.obric.security.cleaner.bigfile;

import java.util.Comparator;

/* JADX INFO: loaded from: classes4.dex */
public class OrderComparator implements Comparator<ItemCache> {
    public OrderComparator() {
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(ItemCache arg1, ItemCache arg2) {
        return compare2(arg1, arg2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(ItemCache arg1, ItemCache arg2) {
        if (arg1.getSize() <= arg2.getSize()) goto L7;
        return -1;
    L7:
        if (arg1.getSize() >= arg2.getSize()) goto L10;
        return 1;
    L10:
        return 0;
    }
}
