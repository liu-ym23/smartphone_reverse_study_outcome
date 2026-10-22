package l.b.a;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes2.dex */
class c2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f21525a = 0;

    static {
        f21525a = Runtime.getRuntime().maxMemory();
    }

    static int a(int r2) {
        int r0 = 1;
        if (r2 <= 127) goto L11;
        int r1 = 1;
    L5:
        r2 = r2 >>> 8;
        if (r2 == 0) goto L8;
        r1 = r1 + 1;
        goto L5
    L8:
        int r3 = (r1 - 1) * 8;
    L9:
        if (r3 < 0) goto L11;
        r0 = r0 + 1;
        r3 = r3 - 8;
    L11:
        return r0;
    }

    static int b(int r6) {
        if (r6 >= 31) goto L5;
        return 1;
    L5:
        if (r6 >= 128) goto L7;
        return 2;
    L7:
        byte[] r3 = new byte[5];
        int r4 = 4;
    L8:
        r6 = r6 >> 7;
        r4 = r4 - 1;
        r3[r4] = (byte) ((r6 & 127) | 128);
        if (r6 > 127) goto L8;
        return 1 + (5 - r4);
    }

    static int c(InputStream r5) {
        if ((r5 instanceof a2) == false) goto L7;
        return ((a2) r5).a();
    L7:
        if ((r5 instanceof k) == false) goto L11;
        return ((k) r5).s();
    L11:
        if ((r5 instanceof ByteArrayInputStream) == false) goto L15;
        return ((ByteArrayInputStream) r5).available();
    L15:
        if ((r5 instanceof FileInputStream) == true) goto L32;
    L25:
        long r3 = f21525a;
        if (r3 <= 2147483647L) goto L30;
        return Integer.MAX_VALUE;
    L30:
        return (int) r3;
    L32:
        FileChannel r6 = ((FileInputStream) r5).getChannel();     // Catch: IOException -> L31
        if (r6 == null) goto L20;
        long r4 = r6.size();     // Catch: IOException -> L31
    L22:
        if (r4 >= 2147483647L) goto L25;
        return (int) r4;
    L20:
        r4 = 2147483647L;
        goto L22
    }
}
