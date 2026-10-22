package tmsdkobf;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f88a = null;
    private static final byte[] b = null;

    static {
        byte[] r0 = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
        byte[] r2 = new byte[256];
        byte[] r3 = new byte[256];
        int r4 = 0;
    L3:
        if (r4 >= 256) goto L4;
        r2[r4] = r0[r4 >>> 4];
        r3[r4] = r0[r4 & 15];
        r4 = r4 + 1;
        goto L3
    L4:
        f88a = r2;
        b = r3;
    }

    public static boolean a(float r0, float r1) {
        if (r0 != r1) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean a(int r0, int r1) {
        if (r0 != r1) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean a(long r0, long r2) {
        if (r0 != r2) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean a(short r0, short r1) {
        if (r0 != r1) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean a(boolean r0, boolean r1) {
        if (r0 != r1) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean a(Object r0, Object r1) {
        return r0.equals(r1);
    }

    public static byte[] a(ByteBuffer r3) {
        int r0 = r3.position();
        byte[] r1 = new byte[r0];
        System.arraycopy(r3.array(), 0, r1, 0, r0);
        return r1;
    }
}
