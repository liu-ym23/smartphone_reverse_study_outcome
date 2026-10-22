package com.bytedance.perf.monitor;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class AnrEntry implements Comparable<AnrEntry> {
    public String stack;
    public long stackCost;
    public long startMs;

    public AnrEntry(String r1, long r2, long r4) {
        this.stack = r1;
        this.startMs = r2;
        this.stackCost = r4;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(@NonNull AnrEntry r1) {
        return compareTo2(r1);
    }

    public String toString() {
        return "AnrEntry{stack='" + this.stack + "', startMs=" + this.startMs + ", stackCost=" + this.stackCost + '}';
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(@NonNull AnrEntry r4) {
        long r0 = this.stackCost;
        long r3 = r4.stackCost;
        if (r0 <= r3) goto L7;
        return -1;
    L7:
        if (r0 >= r3) goto L10;
        return 1;
    L10:
        return 0;
    }
}
