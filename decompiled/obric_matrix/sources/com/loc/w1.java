package com.loc;

import android.os.SystemClock;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class w1 extends v1 {
    public w1() {
        super(2048);
    }

    private int b(long r18, List<i3> r20) {
        g(r20);
        int r1 = r20.size();
        if (r1 <= 0) goto L14;
        int[] r2 = new int[r1];
        int r4 = 0;
    L5:
        if (r4 >= r1) goto L19;
        i3 r6 = r20.get(r4);
        int r14 = this.f7889a.b(r6.f7374b);
        long r11 = r6.f7373a;
        if (r11 == r18) goto L9;
    L11:
        boolean r10 = false;
    L12:
        r2[r4] = t2.b(this.f7889a, r10, r11, (short) r6.f7375c, r14, r6.f7379g, (short) r6.f7376d);
        r4 = r4 + 1;
        goto L5
    L9:
        if (r11 == (-1)) goto L11;
        r10 = true;
        goto L12
    L19:
        return s2.b(this.f7889a, s2.c(this.f7889a, r2));
    L14:
        return -1;
    }

    private int c(z1.a r22) {
        e(r22.f8027f);
        int r2 = r22.f8027f.size();
        int[] r3 = new int[r2];
        int r5 = 0;
    L3:
        byte r6 = 2;
        if (r5 >= r2) goto L29;
        a3 r8 = r22.f8027f.get(r5);
        if ((r8 instanceof d3) == false) goto L13;
        d3 r7 = (d3) r8;
        if (r7.n == true) goto L10;
        int r9 = n2.b(this.f7889a, r7.o, r7.p, r7.f7141h, r7.q);
    L11:
        int r14 = r9;
        int r4 = -1;
        byte r13 = 1;
    L26:
        if (r14 == r4) goto L28;
        r3[r5] = k2.b(this.f7889a, r8.m ? 1 : 0, r8.n ? 1 : 0, (short) r8.f7145l, r13, r14);
        r5 = r5 + 1;
        goto L3
    L28:
        return r4;
    L10:
        r9 = n2.c(this.f7889a, r7.d(), r7.e(), r7.o, r7.p, r7.f7141h, r7.r, r7.s, r7.f7142i, r7.q);
        goto L11
    L13:
        if ((r8 instanceof e3) == false) goto L17;
        r6 = 3;
        e3 r10 = (e3) r8;
        int r11 = o2.b(this.f7889a, r10.d(), r10.e(), r10.o, r10.p, r10.q, r10.f7141h, r10.r, r10.f7142i);
    L15:
        r14 = r11;
        r13 = r6;
        r4 = -1;
        goto L26
    L17:
        if ((r8 instanceof c3) == false) goto L23;
        c3 r12 = (c3) r8;
        boolean r15 = r12.n;
        x1 r16 = this.f7889a;
        int r17 = r12.o;
        int r18 = r12.p;
        int r19 = r12.q;
        int r110 = r12.r;
        int r111 = r12.s;
        int r112 = r12.f7141h;
        if (r15 == true) goto L21;
        r11 = h2.b(r16, r17, r18, r19, r110, r111, r112);
        goto L15
    L21:
        r11 = h2.c(r16, r17, r18, r19, r110, r111, r112, r12.f7142i);
        goto L15
    L23:
        if ((r8 instanceof f3) == false) goto L25;
        r6 = 4;
        f3 r20 = (f3) r8;
        r11 = r2.b(this.f7889a, r20.d(), r20.e(), r20.o, r20.p, r20.q, r20.f7141h, r20.r, r20.f7142i);
        goto L15
    L25:
        r4 = -1;
        r13 = 0;
        r14 = -1;
        goto L26
    L29:
        int r21 = this.f7889a.b(r22.f8023b);
        int r23 = i2.c(this.f7889a, r3);
        int r24 = r22.f8028g.size();
        int[] r25 = new int[r24];
        int r26 = 0;
    L30:
        if (r26 >= r24) goto L52;
        a3 r27 = r22.f8028g.get(r26);
        long r28 = (SystemClock.elapsedRealtime() - r27.f7143j) / 1000;
        if (r28 <= 32767) goto L34;
    L35:
        r28 = 32767;
    L37:
        if ((r27 instanceof d3) == false) goto L41;
        d3 r29 = (d3) r27;
        x1 r113 = this.f7889a;
        int r114 = r29.o;
        int r30 = r29.p;
    L39:
        int r31 = q2.a(r113, r114, r30, (short) r28);
        int r32 = 1;
    L50:
        r25[r26] = j2.b(this.f7889a, (byte) r32, r31);
        r26 = r26 + 1;
        goto L30
    L41:
        if ((r27 instanceof e3) == false) goto L44;
        e3 r33 = (e3) r27;
        r113 = this.f7889a;
        r114 = r33.o;
        r30 = r33.p;
        goto L39
    L44:
        if ((r27 instanceof c3) == false) goto L47;
        c3 r34 = (c3) r27;
        r31 = p2.a(this.f7889a, r34.o, r34.p, r34.q, (short) r28);
        r32 = 2;
        goto L50
    L47:
        if ((r27 instanceof f3) == false) goto L49;
        f3 r35 = (f3) r27;
        r113 = this.f7889a;
        r114 = r35.o;
        r30 = r35.p;
        goto L39
    L49:
        r31 = 0;
        r32 = 0;
        goto L50
    L34:
        if (r28 >= 0) goto L37;
    L52:
        return i2.b(this.f7889a, r21, r22.f8022a, r23, i2.f(this.f7889a, r25));
    }

    private int d(h3 r13) {
        long r3 = r13.f7350i;
        return m2.b(this.f7889a, r13.f7318b, r3, (int) (r13.f7320d * 1000000.0d), (int) (r13.f7319c * 1000000.0d), (int) r13.f7321e, (int) r13.f7324h, (int) r13.f7322f, (short) r13.f7323g, r13.f7351j);
    }

    private static void e(List<a3> r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.size() == 0) goto L31;
        Iterator<a3> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L32;
        a3 r0 = r4.next();
        if ((r0 instanceof d3) == true) goto L11;
        if ((r0 instanceof e3) == true) goto L15;
        if ((r0 instanceof f3) == true) goto L18;
        if ((r0 instanceof c3) == false) goto L8;
        c3 r1 = (c3) r0;
        int r2 = r1.p;
        int r5 = r1.q;
    L12:
        r0.f7145l = w2.b(w2.a(r2, r5));
        goto L8
    L18:
        f3 r6 = (f3) r0;
        r2 = r6.o;
        r5 = r6.p;
        goto L12
    L15:
        e3 r7 = (e3) r0;
        r2 = r7.o;
        r5 = r7.p;
        goto L12
    L11:
        d3 r8 = (d3) r0;
        r2 = r8.o;
        r5 = r8.p;
        goto L12
    L32:
        return;
    }

    private static void g(List<i3> r3) {
        Iterator<i3> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        i3 r0 = r4.next();
        r0.f7379g = w2.d(r0.f7373a);
        goto L4
    }

    public final byte[] f(h3 r3, z1.a r4, long r5, List<i3> r7) {
        super.a();
        int r6 = d(r3);     // Catch: Throwable -> L22
        int r0 = -1;
        if (r4 == null) goto L10;
        List<a3> r1 = r4.f8027f;     // Catch: Throwable -> L22
        if (r1 == null) goto L10;
        if (r1.size() <= 0) goto L10;
        int r8 = c(r4);     // Catch: Throwable -> L22
    L11:
        if (r7 != null) goto L13;
    L15:
        f2.a(this.f7889a);     // Catch: Throwable -> L22
        f2.b(this.f7889a, r6);     // Catch: Throwable -> L22
        if (r8 <= 0) goto L18;
        f2.e(this.f7889a, r8);     // Catch: Throwable -> L22
    L18:
        if (r0 <= 0) goto L20;
        f2.d(this.f7889a, r0);     // Catch: Throwable -> L22
    L20:
        this.f7889a.w(f2.c(this.f7889a));     // Catch: Throwable -> L22
        return this.f7889a.z();
    L13:
        if (r7.size() <= 0) goto L15;
        r0 = b(r5, r7);     // Catch: Throwable -> L22
    L10:
        r8 = -1;
    L22:
        th = move-exception;
        l3.a(th);
        return null;
    }
}
