package com.tencent.tmf.gm;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static byte[] f33a;
    private static byte[] b;

    static {
        f33a = new byte[]{115, 66, 90, 85, 24, 8, 6, 92, 118, 112, 33, 112, 36, 36, 51, 41};
        b = new byte[]{31, 0, 89, 73, 58, 112, 50, 36, 83, 113, 8, 116, 26, 25, 93, 24};
    }

    public static byte[] a() {
        return f33a;
    }

    public static byte[] b(byte[] r1, byte[] r2) {
        if (r1 != null) goto L4;
        return r1;
    L4:
        if (r1.length == 0) goto L15;
        if (r2 != null) goto L8;
        r2 = a();
    L8:
        a.C0080a r3 = Sm4.a(r2, r1);
        if (r3.f32a == 0) goto L11;
        return null;
    L11:
        return r3.b;
    L15:
        return r1;
    }

    public static byte[] c(byte[] r1, byte[] r2) {
        if (r1 != null) goto L4;
        return r1;
    L4:
        if (r1.length == 0) goto L15;
        if (r2 != null) goto L8;
        r2 = a();
    L8:
        a.C0080a r3 = Sm4.b(r2, r1);
        if (r3.f32a == 0) goto L11;
        return null;
    L11:
        return r3.b;
    L15:
        return r1;
    }

    public static byte[] a(byte[] r4, byte[] r5) {
        if (r4 != null) goto L4;
    L17:
        return r4;
    L4:
        if (r4.length == 0) goto L17;
        if (r5 == null) goto L16;
        if (r5.length != 64) goto L16;
        byte[] r1 = new byte[32];
        byte[] r2 = new byte[32];
        System.arraycopy(r5, 0, r1, 0, 32);
        System.arraycopy(r5, 32, r2, 0, 32);
        a.C0080a r6 = Sm2.a(r1, r2, r4);
        if (r6.f32a == 0) goto L12;
        return null;
    L12:
        return r6.b;
    L16:
        throw new RuntimeException("sm2Encrypt: public key must be a byte[] with length of 64!");
    }
}
