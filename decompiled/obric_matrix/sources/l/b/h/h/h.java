package l.b.h.h;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final short[] f22300a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f22301b = null;

    static {
        f22300a = new short[128];
        byte[] r2 = new byte[112];
        f22301b = r2;
        byte[] r3 = new byte[128];
        int r4 = 0;
        a(r3, 0, 15, (byte) 1);
        a(r3, 16, 31, (byte) 2);
        a(r3, 32, 63, (byte) 3);
        a(r3, 64, 65, (byte) 0);
        a(r3, 66, 95, (byte) 4);
        a(r3, 96, 96, (byte) 5);
        a(r3, 97, 108, (byte) 6);
        a(r3, 109, 109, (byte) 7);
        a(r3, 110, 111, (byte) 6);
        a(r3, 112, 112, (byte) 8);
        a(r3, 113, 115, (byte) 9);
        a(r3, 116, 116, (byte) 10);
        a(r3, 117, 127, (byte) 0);
        a(r2, 0, r2.length - 1, (byte) -2);
        a(r2, 8, 11, (byte) -1);
        a(r2, 24, 27, (byte) 0);
        a(r2, 40, 43, (byte) 16);
        a(r2, 58, 59, (byte) 0);
        a(r2, 72, 73, (byte) 0);
        a(r2, 89, 91, (byte) 16);
        a(r2, 104, 104, (byte) 16);
        byte[] r5 = {0, 0, 0, 0, 31, 15, 15, 15, 7, 7, 7};
        byte[] r1 = {-2, -2, -2, -2, 0, 48, 16, 64, 80, 32, 96};
    L3:
        if (r4 >= 128) goto L5;
        byte r6 = r3[r4];
        int r7 = r5[r6] & r4;
        byte r8 = r1[r6];
        f22300a[r4] = (short) (r8 | (r7 << 8));
        r4 = r4 + 1;
        goto L3
    }

    private static void a(byte[] r0, int r1, int r2, byte r3) {
    L2:
        if (r1 > r2) goto L4;
        r0[r1] = r3;
        r1 = r1 + 1;
        goto L2
    }

    public static int b(byte[] r7, char[] r8) {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= r7.length) goto L31;
        int r2 = r0 + 1;
        byte r3 = r7[r0];
        if (r3 >= 0) goto L8;
        short r4 = f22300a[r3 & 127];
        int r5 = r4 >>> 8;
        byte r6 = (byte) r4;
    L12:
        if (r6 < 0) goto L18;
        if (r2 >= r7.length) goto L15;
        int r9 = r2 + 1;
        byte r10 = r7[r2];
        r5 = (r5 << 6) | (r10 & 63);
        r6 = f22301b[r6 + ((r10 & 255) >>> 4)];
        r2 = r9;
        goto L12
    L15:
        return -1;
    L18:
        if (r6 == (-2)) goto L19;
        if (r5 > 65535) goto L27;
        if (r1 >= r8.length) goto L24;
        r8[r1] = (char) r5;
        r1 = r1 + 1;
    L30:
        r0 = r2;
        goto L4
    L24:
        return -1;
    L27:
        if (r1 >= (r8.length - 1)) goto L28;
        int r11 = r1 + 1;
        r8[r1] = (char) ((r5 >>> 10) + 55232);
        r1 = r11 + 1;
        r8[r11] = (char) (56320 | (r5 & 1023));
        goto L30
    L28:
        return -1;
    L19:
        return -1;
    L8:
        if (r1 >= r8.length) goto L9;
        r8[r1] = (char) r3;
        r0 = r2;
        r1 = r1 + 1;
        goto L4
    L9:
        return -1;
    L31:
        return r1;
    }
}
