package com.bytedance.lighten.loader;

import android.app.ActivityManager;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class b implements d.c.c.d.l<d.c.i.e.r> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ActivityManager f4924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4925b;

    public b(ActivityManager r1, int r2) {
        this.f4924a = r1;
        this.f4925b = r2;
    }

    private int b() {
        int r0 = this.f4925b;
        if (r0 <= 0) goto L5;
        return r0;
    L5:
        int r2 = Math.min(this.f4924a.getMemoryClass() * 1048576, Integer.MAX_VALUE);
        if (r2 >= 33554432) goto L10;
        return 4194304;
    L10:
        if (r2 >= 67108864) goto L14;
        return 6291456;
    L14:
        if (Build.VERSION.SDK_INT >= 11) goto L18;
        return 8388608;
    L18:
        return r2 / 8;
    }

    public d.c.i.e.r a() {
        return new d.c.i.e.r(b(), 256, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Override // d.c.c.d.l
    public /* bridge */ /* synthetic */ d.c.i.e.r get() {
        return a();
    }
}
