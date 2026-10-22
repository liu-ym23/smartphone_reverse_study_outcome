package com.bytedance.sdk.account.monitor.g;

import kotlin.i0.i;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5688a = null;

    static {
        f5688a = new a();
    }

    private a() {
    }

    private final int a(int r3) {
        int r2 = ((r3 >>> 16) ^ r3) * ((int) 2246822507L);
        int r4 = (r2 ^ (r2 >>> 13)) * ((int) 3266489909L);
        return r4 ^ (r4 >>> 16);
    }

    public static /* synthetic */ int c(a r0, byte[] r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        return r0.b(r1, r2);
    }

    private final int d(int r1, int r2) {
        return (r1 << r2) | (r1 >>> (32 - r2));
    }

    public final int b(byte[] r12, int r13) {
        o.g(r12, "data");
        int r0 = r12.length;
        int r1 = r0 >> 2;
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L6;
        int r8 = r3 << 2;
        r13 = (d(r13 ^ (d((((r12[r8 + 3] & 255) << 24) | (((r12[r8] & 255) | ((r12[r8 + 1] & 255) << 8)) | ((r12[r8 + 2] & 255) << 16))) * (-862048943), 15) * 461845907), 13) * 5) - 430675100;
        r3 = r3 + 1;
        goto L4
    L6:
        int r4 = r0 & 3;
        if (r4 <= 0) goto L19;
        int r5 = r1 << 2;
        if (r4 == 1) goto L16;
        if (r4 == 2) goto L14;
        if (r4 != 3) goto L17;
        int r6 = (0 ^ ((r12[r5 + 2] & 255) << 16)) ^ ((r12[r5 + 1] & 255) << 8);
        byte r14 = r12[r5];
    L15:
        r2 = r6 ^ (r14 & 255);
    L17:
        r13 = r13 ^ (d(r2 * (-862048943), 15) * 461845907);
        goto L19
    L14:
        r6 = 0 ^ ((r12[r5 + 1] & 255) << 8);
        r14 = r12[r5];
        goto L15
    L16:
        r2 = 0 ^ (r12[r5] & 255);
    L19:
        return a(r13 ^ r0);
    }

    public final byte[] e(byte[]... r12) {
        o.g(r12, "byteArrays");
        int r11 = r12.length;
        int r0 = 0;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r11) goto L5;
        r2 = r2 + r12[r1].length;
        r1 = r1 + 1;
        goto L3
    L5:
        byte[] r13 = new byte[r2];
        int r3 = r12.length;
        int r4 = 0;
    L6:
        if (r0 >= r3) goto L8;
        byte[] r10 = r12[r0];
        i.g(r10, r13, r4, 0, 0, 12, null);
        r4 = r4 + r10.length;
        r0 = r0 + 1;
        goto L6
    L8:
        return r13;
    }

    public final byte[] f(int r3) {
        return new byte[]{(byte) (r3 & 255), (byte) ((r3 >> 8) & 255), (byte) ((r3 >> 16) & 255), (byte) ((r3 >> 24) & 255)};
    }
}
