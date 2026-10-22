package com.facebook.imagepipeline.nativecode;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class c implements d.c.i.s.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f6758b;

    public c(int r1, boolean r2) {
        this.f6757a = r1;
        this.f6758b = r2;
    }

    @Override // d.c.i.s.c
    @Nullable
    public d.c.i.s.b a(d.c.h.d r2, boolean r3) {
        if (r2 == d.c.h.c.f15819a) goto L7;
        return null;
    L7:
        return new NativeJpegTranscoder(r3, this.f6757a, this.f6758b);
    }
}
