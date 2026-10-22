package net.bytedance.zdplib;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public class Delta {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f22654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f22655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f22656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ThreadLocal<MessageDigest> f22657d;

    class a extends ThreadLocal<MessageDigest> {
        a(Delta r1) {
        }

        protected MessageDigest a() {
            return MessageDigest.getInstance("SHA-256");
        L4:
            e = move-exception;
            throw new RuntimeException(e);
        }

        @Override // java.lang.ThreadLocal
        protected /* bridge */ /* synthetic */ MessageDigest initialValue() {
            return a();
        }
    }

    static {
        System.loadLibrary("delta");
    }

    public Delta(byte[] r5, String r6) {
        getClass().getSimpleName();
        this.f22657d = new a(this);
        byte[] r7 = e(r6);
        if (r7.length != 33) goto L5;
    L9:
        long r0 = initPubKey(r7);
        this.f22656c = r0;
        if (r0 == 0) goto L17;
        long r8 = initPrivateKey(r5);
        this.f22655b = r8;
        byte[] r1 = new byte[32];
        this.f22654a = r1;
        int r4 = generateAesKey(r1, r8, this.f22656c);
        if (r4 != 0) goto L15;
        return;
    L15:
        throw new Exception("generateAesKey error " + r4);
    L17:
        throw new Exception("other public key invalid");
    L5:
        if (r7.length == 65) goto L9;
        throw new Exception("other public key length error");
    }

    public static String d(byte[] r6) {
        char[] r0 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] r1 = new char[r6.length * 2];
        int r2 = 0;
    L4:
        if (r2 >= r6.length) goto L7;
        int r3 = r6[r2] & 255;
        int r4 = r2 * 2;
        r1[r4] = r0[r3 >>> 4];
        r1[r4 + 1] = r0[r3 & 15];
        r2 = r2 + 1;
        goto L4
    L7:
        return new String(r1);
    }

    private static native int decrypt(byte[] r0, byte[] r1, byte[] r2);

    public static byte[] e(String r7) {
        int r0 = r7.length();
        byte[] r1 = new byte[r0 / 2];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2 / 2] = (byte) ((Character.digit(r7.charAt(r2), 16) << 4) + Character.digit(r7.charAt(r2 + 1), 16));
        r2 = r2 + 2;
        goto L3
    L5:
        return r1;
    }

    private static native int encrypt(byte[] r0, byte[] r1, byte[] r2);

    private static native void free(long r0);

    private static native int generateAesKey(byte[] r0, long r1, long r3);

    private static native int generatePrivateKey(byte[] r0);

    private static native int getDecryptedLen(int r0);

    private static native int getEncryptedLen(int r0);

    private static native int getPublicKey(byte[] r0, long r1);

    private static native long initPrivateKey(byte[] r0);

    private static native long initPubKey(byte[] r0);

    public byte[] a(byte[] r3) {
        if (this.f22654a == null) goto L14;
        int r0 = getDecryptedLen(r3.length);
        if (r0 < 0) goto L12;
        byte[] r1 = new byte[r0];
        int r2 = decrypt(r1, r3, this.f22654a);
        if (r2 < 0) goto L10;
        return r1;
    L10:
        throw new Exception("decrypt error " + r2);
    L12:
        throw new Exception("encryptedMessage is too short");
    L14:
        throw new Exception("invalid aes key");
    }

    public byte[] b(byte[] r3) {
        if (this.f22654a == null) goto L13;
        int r0 = getEncryptedLen(r3.length);
        byte[] r1 = new byte[r0];
        int r2 = encrypt(r1, r3, this.f22654a);
        if (r2 < 0) goto L11;
        if (r2 != r0) goto L9;
        return r1;
    L9:
        throw new Exception("data length error");
    L11:
        throw new Exception("encrypt error " + r2);
    L13:
        throw new Exception("invalid aes key");
    }

    public String c() {
        byte[] r0 = new byte[33];
        int r3 = getPublicKey(r0, this.f22655b);
        if (r3 != 0) goto L7;
        return d(r0);
    L7:
        throw new Exception("getPublicKey error " + r3);
    }

    public byte[] f(byte[] r2) {
        MessageDigest r0 = this.f22657d.get();
        r0.update(this.f22654a);
        return r0.digest(r2);
    }

    public byte[] g() {
        return this.f22654a;
    }
}
