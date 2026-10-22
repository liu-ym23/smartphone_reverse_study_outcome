package com.facebook.imageutils;

import android.graphics.ColorSpace;
import android.util.Pair;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Pair<Integer, Integer> f6777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ColorSpace f6778b;

    public e(int r2, int r3, ColorSpace r4) {
        if (r2 == (-1)) goto L7;
        if (r3 == (-1)) goto L7;
        Pair<Integer, Integer> r0 = new Pair(Integer.valueOf(r2), Integer.valueOf(r3));
    L8:
        this.f6777a = r0;
        this.f6778b = r4;
        return;
    L7:
        r0 = null;
        goto L8
    }

    public ColorSpace a() {
        return this.f6778b;
    }

    public Pair<Integer, Integer> b() {
        return this.f6777a;
    }
}
