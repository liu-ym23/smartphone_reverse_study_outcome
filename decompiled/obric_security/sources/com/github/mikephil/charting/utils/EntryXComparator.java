package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.data.Entry;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public class EntryXComparator implements Comparator<Entry> {
    public EntryXComparator() {
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Entry r1, Entry r2) {
        return compare2(r1, r2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(Entry r1, Entry r2) {
        float r0 = r1.getX() - r2.getX();
        if (r0 != 0.0f) goto L6;
        return 0;
    L6:
        if (r0 <= 0.0f) goto L9;
        return 1;
    L9:
        return -1;
    }
}
