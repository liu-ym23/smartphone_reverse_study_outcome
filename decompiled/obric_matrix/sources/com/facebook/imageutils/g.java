package com.facebook.imageutils;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
class g {
    public static int a(InputStream r4, int r5, boolean r6) {
        int r0 = 0;
        int r1 = 0;
    L3:
        if (r0 >= r5) goto L12;
        int r2 = r4.read();
        if (r2 == (-1)) goto L11;
        if (r6 == false) goto L8;
        int r3 = (r2 & 255) << (r0 * 8);
    L9:
        r1 = r1 | r3;
        r0 = r0 + 1;
        goto L3
    L8:
        r1 = r1 << 8;
        r3 = r2 & 255;
        goto L9
    L11:
        throw new IOException("no more bytes");
    L12:
        return r1;
    }
}
