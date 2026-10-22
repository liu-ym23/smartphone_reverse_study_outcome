package com.bytedance.applog.y;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected static final long[][] f2512j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.applog.q.b f2514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2517e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f2518f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f2519g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long[][] f2520h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.bytedance.applog.s.b f2521i;

    static {
        f2512j = new long[][]{new long[]{60000, 0, 12}, new long[]{120000, 5, 1}, new long[]{240000, 5, 1}, new long[]{480000, 4, 1}, new long[]{960000, 2, 1}};
    }

    public b(String r1, com.bytedance.applog.q.b r2, com.bytedance.applog.s.b r3) {
        this.f2514b = r2;
        this.f2513a = r1;
        this.f2521i = r3;
        e();
    }

    private void a() {
        long r0 = System.currentTimeMillis();
        this.f2515c++;
        this.f2516d = 1;
        this.f2517e = 0;
        this.f2518f = r0;
        this.f2519g = r0;
        this.f2514b.A().edit().putLong(this.f2513a + "downgrade_time", r0).putInt(this.f2513a + "downgrade_index", this.f2515c).apply();
    }

    private boolean b() {
        return this.f2514b.t().K();
    }

    private void h() {
        long r0 = System.currentTimeMillis();
        this.f2515c--;
        this.f2516d = 1;
        this.f2517e = 1;
        this.f2518f = r0;
        this.f2519g = r0;
        this.f2514b.A().edit().putLong(this.f2513a + "downgrade_time", r0).putInt(this.f2513a + "downgrade_index", this.f2515c).apply();
    }

    public void c() {
        if (b() == true) goto L6;
        return;
    L6:
        if (this.f2515c >= (this.f2520h.length - 1)) goto L8;
        a();
        return;
    L8:
        this.f2517e = 0;
    }

    public void d() {
        if (b() == true) goto L5;
        return;
    L5:
        long r0 = System.currentTimeMillis();
        int r2 = this.f2517e;
        long r3 = r2;
        long[][] r5 = this.f2520h;
        int r6 = this.f2515c;
        if (r3 < r5[r6][1]) goto L8;
    L11:
        if (r6 <= 0) goto L15;
        h();
        return;
    L15:
        return;
    L8:
        if ((r0 - this.f2519g) > 1800000) goto L11;
        this.f2517e = r2 + 1;
    }

    protected void e() {
        this.f2515c = 0;
        if ((System.currentTimeMillis() - this.f2514b.A().getLong(this.f2513a + "downgrade_time", 0)) >= 10800000) goto L5;
        this.f2515c = this.f2514b.A().getInt(this.f2513a + "downgrade_index", 0);
    L6:
        long[][] r1 = f2512j;
        this.f2520h = (long[][]) Array.newInstance(long.class, new int[]{r1.length, r1[0].length});
        int r2 = 0;
    L7:
        long[][] r3 = f2512j;
        if (r2 >= r3.length) goto L10;
        System.arraycopy(r3[r2], 0, this.f2520h[r2], 0, r3[r2].length);
        r2 = r2 + 1;
        goto L7
    L10:
        com.bytedance.applog.s.b r4 = this.f2521i;
        if (r4 == null) goto L28;
        int r5 = r4.f();
        if (r5 != 0) goto L16;
        this.f2520h[0][2] = 2147483647L;
    L18:
        long r6 = this.f2521i.c();
        if (r6 <= 0) goto L33;
        int r7 = 1;
    L21:
        long[][] r8 = this.f2520h;
        if (r7 >= r8.length) goto L34;
        if (r7 != 1) goto L26;
        r8[r7][0] = 2 * r6;
    L27:
        r7 = r7 + 1;
        goto L21
    L26:
        r8[r7][0] = r8[r7 - 1][0] * 2;
        goto L27
    L34:
        return;
    L33:
        return;
    L16:
        if ((-1) == r5) goto L18;
        this.f2520h[0][2] = 60;
        goto L18
    L28:
        return;
    L5:
        this.f2514b.A().edit().remove(this.f2513a + "downgrade_time").remove(this.f2513a + "downgrade_index").apply();
        goto L6
    }

    public boolean f() {
        if (b() == true) goto L5;
        return true;
    L5:
        long r2 = System.currentTimeMillis();
        long r4 = r2 - this.f2518f;
        long[][] r0 = this.f2520h;
        int r6 = this.f2515c;
        if (r4 < r0[r6][0]) goto L8;
        this.f2516d = 1;
        this.f2518f = r2;
    L11:
        return true;
    L8:
        int r3 = this.f2516d;
        if (r3 >= r0[r6][2]) goto L12;
        this.f2516d = r3 + 1;
        goto L11
    L12:
        return false;
    }

    public void g(int r3) {
        this.f2520h[0][2] = r3;
    }
}
