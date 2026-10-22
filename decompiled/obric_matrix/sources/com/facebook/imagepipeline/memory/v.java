package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes2.dex */
public class v {
    static int a(int r0, int r1, int r2) {
        return Math.min(Math.max(0, r2 - r0), r1);
    }

    static void b(int r3, int r4, int r5, int r6, int r7) {
        boolean r0 = true;
        if (r6 < 0) goto L5;
        boolean r2 = true;
    L6:
        d.c.c.d.i.b(r2);
        if (r3 < 0) goto L9;
        boolean r8 = true;
    L10:
        d.c.c.d.i.b(r8);
        if (r5 < 0) goto L13;
        boolean r9 = true;
    L14:
        d.c.c.d.i.b(r9);
        if ((r3 + r6) > r7) goto L17;
        boolean r10 = true;
    L18:
        d.c.c.d.i.b(r10);
        if ((r5 + r6) <= r4) goto L22;
        r0 = false;
    L22:
        d.c.c.d.i.b(r0);
        return;
    L17:
        r10 = false;
        goto L18
    L13:
        r9 = false;
        goto L14
    L9:
        r8 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }
}
