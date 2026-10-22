package com.loc;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class y1 extends v1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static y1 f7984c;

    static {
        f7984c = new y1();
    }

    private y1() {
        super(5120);
    }

    private static String b(String r0) {
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0;
    }

    public static y1 d() {
        return f7984c;
    }

    public final byte[] c(byte[] r9, byte[] r10, List<? extends d2> r11) {
        if (r11 != null) goto L19;
        return null;
    L19:
        int r1 = r11.size();     // Catch: Throwable -> L16
        if (r1 <= 0) goto L22;
        if (r9 == null) goto L23;
        a();     // Catch: Throwable -> L16
        int r12 = g2.c(this.f7889a, r9);     // Catch: Throwable -> L16
        int[] r2 = new int[r1];     // Catch: Throwable -> L16
        int r3 = 0;
        int r4 = 0;
    L9:
        if (r4 >= r1) goto L11;
        d2 r5 = r11.get(r4);     // Catch: Throwable -> L16
        r2[r4] = l2.b(this.f7889a, (byte) r5.a(), l2.c(this.f7889a, r5.b()));     // Catch: Throwable -> L16
        r4 = r4 + 1;     // Catch: Throwable -> L16
        goto L9
    L11:
        int r13 = g2.d(this.f7889a, r2);     // Catch: Throwable -> L16
        if (r10 == null) goto L14;
        r3 = g2.f(this.f7889a, r10);     // Catch: Throwable -> L16
    L14:
        this.f7889a.w(g2.b(this.f7889a, r12, r3, r13));     // Catch: Throwable -> L16
        return this.f7889a.z();
    L23:
        return null;
    L22:
        return null;
    L16:
        th = move-exception;
        l3.a(th);
        return null;
    }

    public final byte[] e() {
        super.a();
        int r5 = this.f7889a.b(j3.m());     // Catch: Exception -> L5
        int r6 = this.f7889a.b(j3.g());     // Catch: Exception -> L5
        int r8 = this.f7889a.b(j3.s());     // Catch: Exception -> L5
        int r9 = this.f7889a.b(j3.q());     // Catch: Exception -> L5
        int r10 = this.f7889a.b(b(j3.o()));     // Catch: Exception -> L5
        int r11 = this.f7889a.b(b(j3.u()));     // Catch: Exception -> L5
        long r12 = i3.a(j3.C());     // Catch: Exception -> L5
        int r14 = this.f7889a.b(j3.y());     // Catch: Exception -> L5
        int r15 = this.f7889a.b(j3.w());     // Catch: Exception -> L5
        int r16 = this.f7889a.b(j3.i());     // Catch: Exception -> L5
        int r17 = this.f7889a.b(j3.k());     // Catch: Exception -> L5
        int r1 = k3.b(this.f7889a, j3.a(), r5, r6, (byte) j3.A(), r8, r9, r10, r11, r12, r14, r15, r16, r17);     // Catch: Exception -> L5
        this.f7889a.w(r1);     // Catch: Exception -> L5
        return this.f7889a.z();
    L5:
        e = move-exception;
        l3.a(e);
        return null;
    }
}
