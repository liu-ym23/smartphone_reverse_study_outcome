package k;

import com.bytedance.bdlocation.exception.BDLocationException;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final boolean a(byte[] r4, int r5, byte[] r6, int r7, int r8) {
        kotlin.n0.d.o.g(r4, "a");
        kotlin.n0.d.o.g(r6, "b");
        int r1 = 0;
    L3:
        if (r1 >= r8) goto L8;
        if (r4[r1 + r5] != r6[r1 + r7]) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public static final void b(long r4, long r6, long r8) {
        if ((r6 | r8) < 0) goto L10;
        if (r6 > r4) goto L10;
        if ((r4 - r6) < r8) goto L10;
        return;
    L10:
        throw new ArrayIndexOutOfBoundsException("size=" + r4 + " offset=" + r6 + " byteCount=" + r8);
    }

    public static final int c(int r2) {
        int r0 = ((((-16777216) & r2) >>> 24) | ((16711680 & r2) >>> 8)) | ((65280 & r2) << 8);
        return ((r2 & 255) << 24) | r0;
    }

    public static final long d(long r8) {
        long r0 = ((((((((-72057594037927936L) & r8) >>> 56) | ((71776119061217280L & r8) >>> 40)) | ((280375465082880L & r8) >>> 24)) | ((1095216660480L & r8) >>> 8)) | ((4278190080L & r8) << 8)) | ((16711680 & r8) << 24)) | ((65280 & r8) << 40);
        return ((r8 & 255) << 56) | r0;
    }

    public static final short e(short r1) {
        int r2 = r1 & 65535;
        int r0 = (65280 & r2) >>> 8;
        return (short) (((r2 & 255) << 8) | r0);
    }

    public static final String f(byte r3) {
        return new String(new char[]{k.c0.b.f()[(r3 >> 4) & 15], k.c0.b.f()[r3 & 15]});
    }

    public static final String g(int r6) {
        if (r6 != 0) goto L5;
        return BDLocationException.ERROR_TIMEOUT;
    L5:
        int r3 = 0;
        char[] r1 = {k.c0.b.f()[(r6 >> 28) & 15], k.c0.b.f()[(r6 >> 24) & 15], k.c0.b.f()[(r6 >> 20) & 15], k.c0.b.f()[(r6 >> 16) & 15], k.c0.b.f()[(r6 >> 12) & 15], k.c0.b.f()[(r6 >> 8) & 15], k.c0.b.f()[(r6 >> 4) & 15], k.c0.b.f()[r6 & 15]};
    L6:
        if (r3 >= 8) goto L12;
        if (r1[r3] != '0') goto L12;
        r3 = r3 + 1;
    L12:
        return new String(r1, r3, 8 - r3);
    }
}
