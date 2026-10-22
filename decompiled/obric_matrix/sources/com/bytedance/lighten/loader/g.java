package com.bytedance.lighten.loader;

/* JADX INFO: loaded from: classes.dex */
public class g implements d.c.c.d.l<d.c.i.e.r> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4944a;

    public g(int r1) {
        this.f4944a = r1;
    }

    private int b() {
        int r4 = this.f4944a;
        if (r4 <= 0) goto L5;
        return r4;
    L5:
        int r5 = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (r5 >= 16777216) goto L10;
        return 1048576;
    L10:
        if (r5 >= 33554432) goto L13;
        return 2097152;
    L13:
        return 4194304;
    }

    public d.c.i.e.r a() {
        int r3 = b();
        return new d.c.i.e.r(r3, Integer.MAX_VALUE, r3, Integer.MAX_VALUE, r3 / 8);
    }

    @Override // d.c.c.d.l
    public /* bridge */ /* synthetic */ d.c.i.e.r get() {
        return a();
    }
}
