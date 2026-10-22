package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;

/* JADX INFO: loaded from: classes2.dex */
public class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseIntArray f6719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6720d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f6721e;

    public f0(int r8, int r9, SparseIntArray r10) {
        this(r8, r9, r10, 0, Integer.MAX_VALUE, -1);
    }

    public f0(int r1, int r2, SparseIntArray r3, int r4, int r5, int r6) {
        if (r1 < 0) goto L6;
        if (r2 < r1) goto L6;
        boolean r7 = true;
    L7:
        d.c.c.d.i.i(r7);
        this.f6718b = r1;
        this.f6717a = r2;
        this.f6719c = r3;
        this.f6721e = r6;
        return;
    L6:
        r7 = false;
        goto L7
    }
}
