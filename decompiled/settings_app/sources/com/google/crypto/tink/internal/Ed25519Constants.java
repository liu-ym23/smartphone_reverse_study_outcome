package com.google.crypto.tink.internal;

import java.lang.reflect.Array;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes4.dex */
final class Ed25519Constants {
    static final Ed25519.CachedXYT[] B2 = null;
    static final Ed25519.CachedXYT[][] B_TABLE = null;
    static final long[] D = null;
    static final long[] D2 = null;
    private static final BigInteger D2_BI = null;
    private static final BigInteger D_BI = null;
    private static final BigInteger P_BI = null;
    static final long[] SQRTM1 = null;
    private static final BigInteger SQRTM1_BI = null;

    /* JADX INFO: renamed from: com.google.crypto.tink.internal.Ed25519Constants$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class Point {
        private BigInteger x;
        private BigInteger y;

        private Point() {
        }

        /* synthetic */ Point(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ BigInteger access$100(Point r0) {
            return r0.y;
        }

        static /* synthetic */ BigInteger access$102(Point r0, BigInteger r1) {
            r0.y = r1;
            return r1;
        }

        static /* synthetic */ BigInteger access$200(Point r0) {
            return r0.x;
        }

        static /* synthetic */ BigInteger access$202(Point r0, BigInteger r1) {
            r0.x = r1;
            return r1;
        }
    }

    static {
        BigInteger r2 = BigInteger.valueOf(2).pow(255).subtract(BigInteger.valueOf(19));
        P_BI = r2;
        BigInteger r3 = BigInteger.valueOf(-121665).multiply(BigInteger.valueOf(121666).modInverse(r2)).mod(r2);
        D_BI = r3;
        BigInteger r4 = BigInteger.valueOf(2).multiply(r3).mod(r2);
        D2_BI = r4;
        BigInteger r0 = BigInteger.valueOf(2).modPow(r2.subtract(BigInteger.ONE).divide(BigInteger.valueOf(4)), r2);
        SQRTM1_BI = r0;
        Point r1 = new Point(null);
        Point.access$102(r1, BigInteger.valueOf(4).multiply(BigInteger.valueOf(5).modInverse(r2)).mod(r2));
        Point.access$202(r1, recoverX(Point.access$100(r1)));
        D = Field25519.expand(toLittleEndian(r3));
        D2 = Field25519.expand(toLittleEndian(r4));
        SQRTM1 = Field25519.expand(toLittleEndian(r0));
        B_TABLE = (Ed25519.CachedXYT[][]) Array.newInstance(Ed25519.CachedXYT.class, new int[]{32, 8});
        int r5 = 0;
        int r6 = 0;
        Point r7 = r1;
    L4:
        if (r6 >= 32) goto L12;
        int r8 = 0;
        Point r9 = r7;
    L6:
        if (r8 >= 8) goto L8;
        B_TABLE[r6][r8] = getCachedXYT(r9);
        r9 = edwards(r9, r7);
        r8 = r8 + 1;
        goto L6
    L8:
        int r10 = 0;
    L9:
        if (r10 >= 8) goto L11;
        r7 = edwards(r7, r7);
        r10 = r10 + 1;
        goto L9
    L11:
        r6 = r6 + 1;
        goto L4
    L12:
        Point r11 = edwards(r1, r1);
        B2 = new Ed25519.CachedXYT[8];
    L13:
        if (r5 >= 8) goto L15;
        B2[r5] = getCachedXYT(r1);
        r1 = edwards(r1, r11);
        r5 = r5 + 1;
        goto L13
    }

    private static BigInteger recoverX(BigInteger y) {
        BigInteger r1 = y.pow(2).subtract(BigInteger.ONE);
        BigInteger r5 = D_BI.multiply(y.pow(2)).add(BigInteger.ONE);
        BigInteger r2 = P_BI;
        BigInteger r6 = r1.multiply(r5.modInverse(r2));
        BigInteger r3 = r6.modPow(r2.add(BigInteger.valueOf(3)).divide(BigInteger.valueOf(8)), r2);
        if (r3.pow(2).subtract(r6).mod(r2).equals(BigInteger.ZERO) == true) goto L6;
        r3 = r3.multiply(SQRTM1_BI).mod(r2);
    L6:
        if (r3.testBit(0) == true) goto L8;
        return r3;
    L8:
        return r2.subtract(r3);
    }

    private static Point edwards(Point a, Point b) {
        Point r0 = new Point(null);
        BigInteger r1 = D_BI.multiply(Point.access$200(a).multiply(Point.access$200(b)).multiply(Point.access$100(a)).multiply(Point.access$100(b)));
        BigInteger r2 = P_BI;
        BigInteger r3 = r1.mod(r2);
        Point.access$202(r0, Point.access$200(a).multiply(Point.access$100(b)).add(Point.access$200(b).multiply(Point.access$100(a))).multiply(BigInteger.ONE.add(r3).modInverse(r2)).mod(r2));
        Point.access$102(r0, Point.access$100(a).multiply(Point.access$100(b)).add(Point.access$200(a).multiply(Point.access$200(b))).multiply(BigInteger.ONE.subtract(r3).modInverse(r2)).mod(r2));
        return r0;
    }

    private static byte[] toLittleEndian(BigInteger n) {
        byte[] r1 = new byte[32];
        byte[] r4 = n.toByteArray();
        int r3 = 0;
        System.arraycopy(r4, 0, r1, 32 - r4.length, r4.length);
    L4:
        if (r3 >= 16) goto L6;
        byte r5 = r1[r3];
        int r0 = (32 - r3) - 1;
        r1[r3] = r1[r0];
        r1[r0] = r5;
        r3 = r3 + 1;
        goto L4
    L6:
        return r1;
    }

    private static Ed25519.CachedXYT getCachedXYT(Point p) {
        BigInteger r1 = Point.access$100(p).add(Point.access$200(p));
        BigInteger r2 = P_BI;
        return new Ed25519.CachedXYT(Field25519.expand(toLittleEndian(r1.mod(r2))), Field25519.expand(toLittleEndian(Point.access$100(p).subtract(Point.access$200(p)).mod(r2))), Field25519.expand(toLittleEndian(D2_BI.multiply(Point.access$200(p)).multiply(Point.access$100(p)).mod(r2))));
    }

    private Ed25519Constants() {
    }
}
