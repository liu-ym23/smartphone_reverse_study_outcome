package com.bytedance.applog.u.j;

import androidx.core.location.LocationRequestCompat;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f2409a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f2410b;

    /* JADX INFO: renamed from: com.bytedance.applog.u.j.a$a, reason: collision with other inner class name */
    private static class C0074a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f2411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f2412b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f2413c;

        C0074a(int r1, boolean r2) {
            this.f2411a = r1;
            this.f2412b = r2;
        }

        boolean a() {
            if (this.f2413c >= this.f2411a) goto L5;
            return true;
        L5:
            return false;
        }

        int b() {
            if (this.f2412b == true) goto L6;
            int r0 = this.f2413c;
            this.f2413c = r0 + 1;
            return r0;
        L6:
            int r1 = this.f2411a - 1;
            int r2 = this.f2413c;
            this.f2413c = r2 + 1;
            return r1 - r2;
        }
    }

    static {
        f2409a = !"little".equals(System.getProperty("sun.cpu.endian"));
        f2410b = new a();
    }

    public a() {
    }

    private byte[] a(String r1) {
        return r1.getBytes("UTF-8");
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private int b(byte[] r1, int r2) {
        return n(r1, r2);
    }

    private long c(byte[] r1, int r2) {
        return o(r1, r2);
    }

    public static a d() {
        return f2410b;
    }

    private long e(b r7) {
        long r0 = (r7.b() ^ r7.a()) * (-7070675565921424023L);
        long r1 = ((r0 ^ (r0 >>> 47)) ^ r7.a()) * (-7070675565921424023L);
        return ((r1 >>> 47) ^ r1) * (-7070675565921424023L);
    }

    private long f(String r29) {
        byte[] r8 = a(r29);
        int r9 = r8.length;
        if (r9 > 32) goto L11;
        if (r9 > 16) goto L9;
        return i(r8);
    L9:
        return l(r8);
    L11:
        if (r9 <= 64) goto L13;
        long r11 = c(r8, r9 - 40);
        long r13 = c(r8, r9 - 16) + c(r8, r9 - 56);
        long r3 = r9;
        long r15 = j(c(r8, r9 - 48) + r3, c(r8, r9 - 24));
        b r17 = s(r8, r9 - 64, r3, r15);
        b r0 = s(r8, r9 - 32, r13 - 5435081209227447693L, r11);
        long r12 = (r11 * (-5435081209227447693L)) + c(r8, 0);
        int r2 = (r9 - 1) & (-64);
        b r10 = r0;
        int r14 = 0;
        int r16 = r2;
        long r1 = r12;
    L15:
        long r4 = p(((r1 + r13) + r17.b()) + c(r8, r14 + 8), 37) * (-5435081209227447693L);
        long r5 = p((r13 + r17.a()) + c(r8, r14 + 48), 42) * (-5435081209227447693L);
        long r18 = r4 ^ r10.a();
        long r6 = r5 + (r17.b() + c(r8, r14 + 40));
        long r19 = p(r10.b() + r15, 33) * (-5435081209227447693L);
        r17 = s(r8, r14, r17.a() * (-5435081209227447693L), r18 + r10.b());
        r10 = s(r8, r14 + 32, r19 + r10.a(), r6 + c(r8, r14 + 16));
        r14 = r14 + 64;
        r16 = r16 - 64;
        if (r16 == 0) goto L18;
        r1 = r19;
        r15 = r18;
        r13 = r6;
        goto L15
    L18:
        return j((j(r17.b(), r10.b()) + (q(r6) * (-5435081209227447693L))) + r18, j(r17.a(), r10.a()) + r19);
    L13:
        return m(r8);
    }

    public static BigInteger g(String r1) {
        if (r1 != null) goto L5;
        r1 = "NULL";
    L5:
        return d().h(r1);
    }

    private long i(byte[] r14) {
        int r2 = r14.length;
        if (r2 < 8) goto L7;
        long r7 = ((long) (r2 * 2)) - 7286425919675154353L;
        long r9 = c(r14, 0) - 7286425919675154353L;
        long r1 = c(r14, r2 - 8);
        return k((p(r1, 37) * r7) + r9, (p(r9, 25) + r1) * r7, r7);
    L7:
        if (r2 >= 4) goto L9;
        if (r2 <= 0) goto L13;
        int r3 = r14[0] & 255;
        int r8 = r14[r2 >>> 1] & 255;
        return q((((long) (r2 + ((r14[r2 - 1] & 255) << 2))) * (-4348849565147123417L)) ^ (((long) (r3 + (r8 << 8))) * (-7286425919675154353L))) * (-7286425919675154353L);
    L13:
        return -7286425919675154353L;
    L9:
        return k(((((long) b(r14, 0)) & 4294967295L) << 3) + ((long) r2), ((long) b(r14, r2 - 4)) & 4294967295L, (-7286425919675154353L) + ((long) (r2 * 2)));
    }

    private long j(long r2, long r4) {
        return e(new b(r2, r4));
    }

    private long k(long r3, long r5, long r7) {
        long r2 = (r3 ^ r5) * r7;
        long r4 = ((r2 ^ (r2 >>> 47)) ^ r5) * r7;
        return (r4 ^ (r4 >>> 47)) * r7;
    }

    private long l(byte[] r18) {
        int r2 = r18.length;
        long r7 = ((long) (r2 * 2)) - 7286425919675154353L;
        long r3 = c(r18, 0) * (-5435081209227447693L);
        long r9 = c(r18, 8);
        long r11 = c(r18, r2 - 8) * r7;
        return k((c(r18, r2 - 16) * (-7286425919675154353L)) + (p(r3 + r9, 43) + p(r11, 30)), (r3 + p(r9 - 7286425919675154353L, 18)) + r11, r7);
    }

    private long m(byte[] r27) {
        int r2 = r27.length;
        long r3 = ((long) (r2 * 2)) - 7286425919675154353L;
        long r7 = c(r27, 0) * (-7286425919675154353L);
        long r9 = c(r27, 8);
        long r11 = c(r27, r2 - 24);
        long r13 = c(r27, r2 - 32);
        long r16 = c(r27, 16) * (-7286425919675154353L);
        long r5 = c(r27, 24) * 9;
        long r6 = c(r27, r2 - 8);
        long r1 = c(r27, r2 - 16) * r3;
        long r8 = r7 + r6;
        long r22 = p(r8, 43) + ((p(r9, 30) + r11) * 9);
        long r10 = ((r8 ^ r13) + r5) + 1;
        long r18 = Long.reverseBytes((r22 + r10) * r3) + r1;
        long r4 = r16 + r5;
        long r15 = p(r4, 42) + r11;
        long r12 = r4 + r11;
        return (q((((r12 + (Long.reverseBytes(((r15 + r12) * r3) + ((Long.reverseBytes((r10 + r18) * r3) + r6) * r3)) + r9)) * r3) + r13) + r1) * r3) + r15;
    }

    private int n(byte[] r4, int r5) {
        C0074a r3 = new C0074a(4, f2409a);
        int r0 = 0;
    L4:
        if (r3.a() == false) goto L6;
        int r1 = r3.b();
        r0 = r0 | ((r4[r1 + r5] & 255) << (r1 * 8));
        goto L4
    L6:
        return r0;
    }

    private long o(byte[] r9, int r10) {
        C0074a r8 = new C0074a(8, f2409a);
        long r2 = 0;
    L4:
        if (r8.a() == false) goto L6;
        int r0 = r8.b();
        r2 = r2 | ((((long) r9[r0 + r10]) & 255) << (r0 * 8));
        goto L4
    L6:
        return r2;
    }

    private long p(long r3, int r5) {
        if (r5 != 0) goto L5;
        return r3;
    L5:
        return (r3 >>> r5) | (r3 << (64 - r5));
    }

    private long q(long r3) {
        return r3 ^ (r3 >>> 47);
    }

    private b r(long r1, long r3, long r5, long r7, long r9, long r11) {
        long r10 = r9 + r1;
        long r4 = (r3 + r10) + r5;
        long r2 = p((r11 + r10) + r7, 21) + p(r4, 44);
        return new b(r4 + r7, r2 + r10);
    }

    private b s(byte[] r14, int r15, long r16, long r18) {
        return r(c(r14, r15), c(r14, r15 + 8), c(r14, r15 + 16), c(r14, r15 + 24), r16, r18);
    }

    public BigInteger h(String r3) {
        long r2 = f(r3);
        if (r2 < 0) goto L7;
        return BigInteger.valueOf(r2);
    L7:
        return BigInteger.valueOf(r2 & LocationRequestCompat.PASSIVE_INTERVAL).add(BigInteger.valueOf(LocationRequestCompat.PASSIVE_INTERVAL)).add(BigInteger.valueOf(1));
    }
}
