package com.bytedance.apm6.java_alloc;

/* JADX INFO: loaded from: classes3.dex */
public interface IRecordReader {
    void onHeadInfo(String r1, long r2, long r4, int r6, JavaAllocConfig r7, long r8, long r10);

    boolean onItem(String r1, int r2, int r3, Trace r4, int r5);
}
