package com.obric.matrix.opush.d.f;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
class i {
    static boolean a(InputStream r5) {
        byte[] r1 = new byte[12];
        if (r5.read(r1, 0, 12) == 12) goto L5;
        return false;
    L5:
        if ("RIFF".equals(new String(r1, 0, 4, "US-ASCII")) == true) goto L7;
        return false;
    L7:
        if ("WEBP".equals(new String(r1, 8, 4, "US-ASCII")) == true) goto L9;
        return false;
    L9:
        return true;
    }

    static byte[] b(InputStream r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r1 = new byte[4096];
    L3:
        int r3 = r4.read(r1);
        if ((-1) == r3) goto L7;
        r0.write(r1, 0, r3);
        goto L3
    L7:
        return r0.toByteArray();
    }
}
