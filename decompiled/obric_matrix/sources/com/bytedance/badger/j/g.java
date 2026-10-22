package com.bytedance.badger.j;

import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f2620a = null;

    static {
        f2620a = new g();
    }

    private g() {
    }

    private final int a(int r1, int r2) {
        return (r1 << r2) | (r1 >>> (32 - r2));
    }

    public static int b(g r10, byte[] r11, int r12, int r13, Object r14) {
        int r0 = 0;
        if ((r13 & 2) == 0) goto L5;
        r12 = 0;
    L5:
        o.g(r11, "data");
        int r15 = r11.length;
        int r1 = r15 >> 2;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L9;
        int r7 = r2 << 2;
        r12 = (r10.a(r12 ^ (r10.a((((r11[r7 + 3] & 255) << 24) | (((r11[r7] & 255) | ((r11[r7 + 1] & 255) << 8)) | ((r11[r7 + 2] & 255) << 16))) * (-862048943), 15) * 461845907), 13) * 5) - 430675100;
        r2 = r2 + 1;
        goto L7
    L9:
        int r3 = r15 & 3;
        if (r3 <= 0) goto L21;
        int r4 = r1 << 2;
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L17;
        if (r3 != 3) goto L20;
        int r16 = (((r11[r4 + 2] & 255) << 16) ^ 0) ^ ((r11[r4 + 1] & 255) << 8);
        byte r17 = r11[r4];
    L18:
        r0 = r16 ^ (r17 & 255);
    L20:
        r12 = r12 ^ (r10.a(r0 * (-862048943), 15) * 461845907);
        goto L21
    L17:
        r16 = ((r11[r4 + 1] & 255) << 8) ^ 0;
        r17 = r11[r4];
        goto L18
    L19:
        r0 = 0 ^ (r11[r4] & 255);
    L21:
        int r18 = r12 ^ r15;
        int r19 = (r18 ^ (r18 >>> 16)) * ((int) 2246822507L);
        int r110 = (r19 ^ (r19 >>> 13)) * ((int) 3266489909L);
        return r110 ^ (r110 >>> 16);
    }
}
