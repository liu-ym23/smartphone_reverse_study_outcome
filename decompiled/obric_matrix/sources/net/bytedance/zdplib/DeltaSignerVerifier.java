package net.bytedance.zdplib;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class DeltaSignerVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f22658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f22659b;

    static {
        System.loadLibrary("delta");
    }

    public DeltaSignerVerifier(String r4) {
        byte[] r0 = Delta.e(r4);
        if (r0.length != 32) goto L7;
        this.f22658a = initPrivateKey(r0);
        this.f22659b = r0;
        return;
    L7:
        throw new Exception("invalid private key :" + r4);
    }

    public static String a() {
        byte[] r0 = new byte[32];
        int r1 = generatePrivateKey(r0);
        if (r1 < 0) goto L7;
        return Delta.d(r0);
    L7:
        throw new Exception("GeneratePrivateKey  error " + r1);
    }

    private static native void free(long r0);

    private static native int generatePrivateKey(byte[] r0);

    private static native int getPublicKey(byte[] r0, long r1);

    private static native int getPublicKeyUncompressed(byte[] r0, long r1);

    private static native long initPrivateKey(byte[] r0);

    private static native int sign(byte[] r0, long r1, byte[] r3);

    private static native int verify(byte[] r0, byte[] r1, byte[] r2);

    public byte[] b(byte[] r4) {
        byte[] r0 = new byte[72];
        int r3 = sign(r0, this.f22658a, r4);
        if (r3 < 0) goto L7;
        return Arrays.copyOfRange(r0, 0, r3);
    L7:
        throw new Exception(String.format("sign error ret=%d", new Object[]{Integer.valueOf(r3)}));
    }

    public Delta c(String r2) {
        return new Delta(this.f22659b, r2);
    }

    public String d() {
        byte[] r0 = new byte[65];
        int r3 = getPublicKeyUncompressed(r0, this.f22658a);
        if (r3 != 0) goto L7;
        return Delta.d(r0);
    L7:
        throw new Exception("getPublicKey error " + r3);
    }
}
