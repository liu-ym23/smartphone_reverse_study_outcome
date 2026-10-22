package com.bytedance.memory.g;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputStream f5036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5037b;

    public f(InputStream r2) {
        this.f5037b = 0;
        this.f5036a = r2;
    }

    private int b(d r17) {
        e r4 = i.e(this.f5036a, this.f5037b);
        int r5 = i.a(this.f5036a);
        e r6 = i.e(this.f5036a, this.f5037b);
        e r7 = i.e(this.f5036a, this.f5037b);
        i.i(this.f5036a, this.f5037b << 2);
        int r8 = i.a(this.f5036a);
        int r1 = ((this.f5037b * 7) + 4) + 4;
        short r2 = i.c(this.f5036a);
        int r3 = r1 + 2;
        int r9 = 0;
        int r10 = 0;
    L3:
        if (r10 >= r2) goto L5;
        i.i(this.f5036a, 2);
        r3 = r3 + (u() + 2);
        r10 = r10 + 1;
        goto L3
    L5:
        int r11 = i.c(this.f5036a);
        c[] r12 = new c[r11];
        int r13 = r3 + 2;
        int r14 = 0;
    L6:
        if (r14 >= r11) goto L12;
        e r15 = i.e(this.f5036a, this.f5037b);
        int r16 = this.f5036a.read();
        a r18 = a.b(r16);
        if (r18 == null) goto L11;
        r12[r14] = new c(r16, r15, i.h(this.f5036a, r18, this.f5037b));
        int r19 = this.f5037b;
        r13 = r13 + ((r19 + 1) + r18.a(r19));
        r14 = r14 + 1;
        goto L6
    L11:
        throw new IllegalStateException("accept class failed, lost type def of typeId: " + r16);
    L12:
        int r20 = i.c(this.f5036a);
        c[] r110 = new c[r20];
        int r21 = r13 + 2;
    L13:
        if (r9 >= r20) goto L15;
        r110[r9] = new c(this.f5036a.read(), i.e(this.f5036a, this.f5037b), null);
        r21 = r21 + (this.f5037b + 1);
        r9 = r9 + 1;
        goto L13
    L15:
        r17.c(r4, r5, r6, r7, r8, r12, r110);
        return r21;
    }

    private void c(g r5) {
        String r0 = i.f(this.f5036a);
        int r1 = i.a(this.f5036a);
        if (r1 <= 0) goto L9;
        if (r1 >= 1073741823) goto L9;
        long r2 = i.b(this.f5036a);
        this.f5037b = r1;
        r5.b(r0, r1, r2);
        return;
    L9:
        throw new IOException("bad idSize: " + r1);
    }

    private int d(d r4) {
        r4.d(i.a(this.f5036a), i.e(this.f5036a, this.f5037b));
        return this.f5037b + 4;
    }

    private void e(int r3, int r4, long r5, g r7) {
        d r6 = r7.c(r3, r4, r5);
        if (r6 != null) goto L7;
        i.i(this.f5036a, r5);
        return;
    L7:
        if (r5 <= 0) goto L35;
        int r8 = this.f5036a.read();
        long r9 = r5 - 1;
        if (r8 != 144) goto L11;
    L28:
        r6.b(r8, i.e(this.f5036a, this.f5037b));
        int r10 = this.f5037b;
    L33:
        r5 = r9 - ((long) r10);
        goto L7
    L11:
        if (r8 != 195) goto L13;
    L22:
        r10 = m(r8, r6);
        goto L33
    L13:
        if (r8 != 254) goto L15;
        r10 = d(r6);
        goto L33
    L15:
        if (r8 == 255) goto L28;
        switch(r8) {
            case 1: goto L32;
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L29;
            case 5: goto L28;
            case 6: goto L27;
            case 7: goto L28;
            case 8: goto L26;
            default: goto L17;
        };
    L17:
        switch(r8) {
            case 32: goto L25;
            case 33: goto L24;
            case 34: goto L23;
            case 35: goto L22;
            default: goto L18;
        };
    L18:
        switch(r8) {
            case 137: goto L28;
            case 138: goto L28;
            case 139: goto L28;
            case 140: goto L28;
            case 141: goto L28;
            case 142: goto L21;
            default: goto L20;
        };
    L21:
        r10 = i(r6);
        goto L33
    L20:
        throw new IllegalArgumentException("acceptHeapDumpRecord loop with unknown tag " + r8 + " with " + this.f5036a.available() + " bytes possibly remaining");
    L23:
        r10 = l(r6);
        goto L33
    L24:
        r10 = f(r6);
        goto L33
    L25:
        r10 = b(r6);
        goto L33
    L26:
        r10 = s(r6);
        goto L33
    L27:
        r10 = r(r6);
        goto L33
    L29:
        r10 = k(r6);
        goto L33
    L30:
        r10 = g(r6);
        goto L33
    L31:
        r10 = h(r6);
        goto L33
    L32:
        r6.b(r8, i.e(this.f5036a, this.f5037b));
        i.i(this.f5036a, this.f5037b);
        r10 = this.f5037b << 1;
        goto L33
    L35:
        r6.a();
    }

    private int f(d r10) {
        e r0 = i.e(this.f5036a, this.f5037b);
        int r1 = i.a(this.f5036a);
        e r2 = i.e(this.f5036a, this.f5037b);
        int r3 = i.a(this.f5036a);
        byte[] r4 = new byte[r3];
        i.d(this.f5036a, r4, 0, r3);
        r10.e(r0, r1, r2, r4);
        int r9 = this.f5037b;
        return (((r9 + 4) + r9) + 4) + r3;
    }

    private int g(d r4) {
        r4.f(i.e(this.f5036a, this.f5037b), i.a(this.f5036a), i.a(this.f5036a));
        return (this.f5037b + 4) + 4;
    }

    private int h(d r4) {
        r4.g(i.e(this.f5036a, this.f5037b), i.a(this.f5036a), i.a(this.f5036a));
        return (this.f5037b + 4) + 4;
    }

    private int i(d r4) {
        r4.h(i.e(this.f5036a, this.f5037b), i.a(this.f5036a), i.a(this.f5036a));
        return (this.f5037b + 4) + 4;
    }

    private void j(int r10, long r11, g r13) {
        r13.d(i.a(this.f5036a), i.e(this.f5036a, this.f5037b), i.a(this.f5036a), i.e(this.f5036a, this.f5037b), r10, r11);
    }

    private int k(d r3) {
        r3.i(i.e(this.f5036a, this.f5037b), i.a(this.f5036a));
        return this.f5037b + 4;
    }

    private int l(d r11) {
        e r3 = i.e(this.f5036a, this.f5037b);
        int r4 = i.a(this.f5036a);
        int r5 = i.a(this.f5036a);
        e r6 = i.e(this.f5036a, this.f5037b);
        int r0 = this.f5037b * r5;
        byte[] r7 = new byte[r0];
        i.d(this.f5036a, r7, 0, r0);
        r11.j(r3, r4, r5, r6, r7);
        int r10 = this.f5037b;
        return (((r10 + 4) + 4) + r10) + r0;
    }

    private int m(int r12, d r13) {
        e r4 = i.e(this.f5036a, this.f5037b);
        int r5 = i.a(this.f5036a);
        int r6 = i.a(this.f5036a);
        int r7 = this.f5036a.read();
        a r0 = a.b(r7);
        if (r0 == null) goto L7;
        int r1 = r0.a(this.f5037b) * r6;
        byte[] r8 = new byte[r1];
        i.d(this.f5036a, r8, 0, r1);
        r13.k(r12, r4, r5, r6, r7, r8);
        return (((this.f5037b + 4) + 4) + 1) + r1;
    L7:
        throw new IllegalStateException("accept primitive array failed, lost type def of typeId: " + r7);
    }

    private void n(g r8) {
    L22:
        int r2 = this.f5036a.read();     // Catch: EOFException -> L21
        int r3 = i.a(this.f5036a);     // Catch: EOFException -> L21
        long r4 = 4294967295L & ((long) i.a(this.f5036a));     // Catch: EOFException -> L21
        if (r2 != 1) goto L5;
        q(r3, r4, r8);     // Catch: EOFException -> L21
        goto L22
    L5:
        if (r2 != 2) goto L7;
        j(r3, r4, r8);     // Catch: EOFException -> L21
        goto L22
    L7:
        if (r2 != 4) goto L9;
        o(r3, r4, r8);     // Catch: EOFException -> L21
        goto L22
    L9:
        if (r2 != 5) goto L11;
        p(r3, r4, r8);     // Catch: EOFException -> L21
        goto L22
    L11:
        if (r2 == 12) goto L15;
        if (r2 == 28) goto L15;
        t(r2, r3, r4, r8);     // Catch: EOFException -> L21
    L15:
        e(r2, r3, r4, r8);     // Catch: EOFException -> L21
    }

    private void o(int r14, long r15, g r17) {
        r17.e(i.e(this.f5036a, this.f5037b), i.e(this.f5036a, this.f5037b), i.e(this.f5036a, this.f5037b), i.e(this.f5036a, this.f5037b), i.a(this.f5036a), i.a(this.f5036a), r14, r15);
    }

    private void p(int r9, long r10, g r12) {
        int r2 = i.a(this.f5036a);
        int r3 = i.a(this.f5036a);
        int r0 = i.a(this.f5036a);
        e[] r4 = new e[r0];
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r4[r1] = i.e(this.f5036a, this.f5037b);
        r1 = r1 + 1;
        goto L3
    L5:
        r12.f(r2, r3, r4, r9, r10);
    }

    private void q(int r9, long r10, g r12) {
        r12.g(i.e(this.f5036a, this.f5037b), i.g(this.f5036a, r10 - ((long) this.f5037b)), r9, r10);
    }

    private int r(d r3) {
        r3.l(i.e(this.f5036a, this.f5037b), i.a(this.f5036a));
        return this.f5037b + 4;
    }

    private int s(d r4) {
        r4.m(i.e(this.f5036a, this.f5037b), i.a(this.f5036a), i.a(this.f5036a));
        return (this.f5037b + 4) + 4;
    }

    private void t(int r8, int r9, long r10, g r12) {
        byte[] r6 = new byte[(int) r10];
        i.d(this.f5036a, r6, 0, r10);
        r12.h(r8, r9, r10, r6);
    }

    private int u() {
        int r0 = this.f5036a.read();
        a r1 = a.b(r0);
        if (r1 == null) goto L7;
        int r2 = r1.a(this.f5037b);
        i.i(this.f5036a, r2);
        return r2 + 1;
    L7:
        throw new IllegalStateException("failure to skip type, cannot find type def of typeid: " + r0);
    }

    public void a(g r1) {
        c(r1);
        n(r1);
        r1.a();
    }
}
