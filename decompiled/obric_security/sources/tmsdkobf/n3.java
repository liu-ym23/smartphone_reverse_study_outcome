package tmsdkobf;

/* JADX INFO: loaded from: classes5.dex */
public abstract class n3 {
    static {
        byte[] r0 = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
        byte[] r2 = new byte[256];
        byte[] r3 = new byte[256];
        int r4 = 0;
    L3:
        if (r4 >= 256) goto L5;
        r2[r4] = r0[r4 >>> 4];
        r3[r4] = r0[r4 & 15];
        r4 = r4 + 1;
        goto L3
    }

    public static boolean a(int r0, int r1) {
        if (r0 != r1) goto L4;
        return true;
    L4:
        return false;
    }

    public static boolean a(long r0, long r2) {
        if (r0 != r2) goto L5;
        return true;
    L5:
        return false;
    }
}
