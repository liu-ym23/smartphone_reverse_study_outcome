package com.google.crypto.tink.internal;

import com.google.common.primitives.SignedBytes;
import com.google.crypto.tink.subtle.Bytes;
import com.google.crypto.tink.subtle.EngineFactory;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class Ed25519 {
    private static final CachedXYT CACHED_NEUTRAL = null;
    static final byte[] GROUP_ORDER = null;
    private static final PartialXYZT NEUTRAL = null;
    public static final int PUBLIC_KEY_LEN = 32;
    public static final int SECRET_KEY_LEN = 32;
    public static final int SIGNATURE_LEN = 64;

    static class CachedXYT {
        final long[] t2d;
        final long[] yMinusX;
        final long[] yPlusX;

        CachedXYT() {
            this(new long[10], new long[10], new long[10]);
        }

        CachedXYT(long[] yPlusX, long[] yMinusX, long[] t2d) {
            this.yPlusX = yPlusX;
            this.yMinusX = yMinusX;
            this.t2d = t2d;
        }

        CachedXYT(CachedXYT other) {
            this.yPlusX = Arrays.copyOf(other.yPlusX, 10);
            this.yMinusX = Arrays.copyOf(other.yMinusX, 10);
            this.t2d = Arrays.copyOf(other.t2d, 10);
        }

        void multByZ(long[] output, long[] in) {
            System.arraycopy(in, 0, output, 0, 10);
        }

        void copyConditional(CachedXYT other, int icopy) {
            Curve25519.copyConditional(this.yPlusX, other.yPlusX, icopy);
            Curve25519.copyConditional(this.yMinusX, other.yMinusX, icopy);
            Curve25519.copyConditional(this.t2d, other.t2d, icopy);
        }
    }

    private static class CachedXYZT extends CachedXYT {
        private final long[] z;

        CachedXYZT() {
            this(new long[10], new long[10], new long[10], new long[10]);
        }

        CachedXYZT(XYZT xyzt) {
            this();
            Field25519.sum(this.yPlusX, xyzt.xyz.y, xyzt.xyz.x);
            Field25519.sub(this.yMinusX, xyzt.xyz.y, xyzt.xyz.x);
            System.arraycopy(xyzt.xyz.z, 0, this.z, 0, 10);
            Field25519.mult(this.t2d, xyzt.t, Ed25519Constants.D2);
        }

        CachedXYZT(long[] yPlusX, long[] yMinusX, long[] z, long[] t2d) {
            super(yPlusX, yMinusX, t2d);
            this.z = z;
        }

        @Override // com.google.crypto.tink.internal.Ed25519.CachedXYT
        public void multByZ(long[] output, long[] in) {
            Field25519.mult(output, in, this.z);
        }
    }

    private static class PartialXYZT {
        final long[] t;
        final XYZ xyz;

        PartialXYZT() {
            this(new XYZ(), new long[10]);
        }

        PartialXYZT(XYZ xyz, long[] t) {
            this.xyz = xyz;
            this.t = t;
        }

        PartialXYZT(PartialXYZT other) {
            this.xyz = new XYZ(other.xyz);
            this.t = Arrays.copyOf(other.t, 10);
        }
    }

    private static class XYZ {
        final long[] x;
        final long[] y;
        final long[] z;

        XYZ() {
            this(new long[10], new long[10], new long[10]);
        }

        XYZ(long[] x, long[] y, long[] z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        XYZ(XYZ xyz) {
            this.x = Arrays.copyOf(xyz.x, 10);
            this.y = Arrays.copyOf(xyz.y, 10);
            this.z = Arrays.copyOf(xyz.z, 10);
        }

        XYZ(PartialXYZT partialXYZT) {
            this();
            fromPartialXYZT(this, partialXYZT);
        }

        static XYZ fromPartialXYZT(XYZ out, PartialXYZT in) {
            Field25519.mult(out.x, in.xyz.x, in.t);
            Field25519.mult(out.y, in.xyz.y, in.xyz.z);
            Field25519.mult(out.z, in.xyz.z, in.t);
            return out;
        }

        byte[] toBytes() {
            long[] r1 = new long[10];
            long[] r2 = new long[10];
            long[] r0 = new long[10];
            Field25519.inverse(r1, this.z);
            Field25519.mult(r2, this.x, r1);
            Field25519.mult(r0, this.y, r1);
            byte[] r4 = Field25519.contract(r0);
            r4[31] = (byte) (r4[31] ^ (Ed25519.access$000(r2) << 7));
            return r4;
        }

        boolean isOnCurve() {
            long[] r1 = new long[10];
            Field25519.square(r1, this.x);
            long[] r2 = new long[10];
            Field25519.square(r2, this.y);
            long[] r3 = new long[10];
            Field25519.square(r3, this.z);
            long[] r5 = new long[10];
            Field25519.square(r5, r3);
            long[] r4 = new long[10];
            Field25519.sub(r4, r2, r1);
            Field25519.mult(r4, r4, r3);
            long[] r0 = new long[10];
            Field25519.mult(r0, r1, r2);
            Field25519.mult(r0, r0, Ed25519Constants.D);
            Field25519.sum(r0, r5);
            Field25519.reduce(r0, r0);
            return Bytes.equal(Field25519.contract(r4), Field25519.contract(r0));
        }
    }

    private static class XYZT {
        final long[] t;
        final XYZ xyz;

        static /* synthetic */ XYZT access$400(XYZT r0, PartialXYZT r1) {
            return fromPartialXYZT(r0, r1);
        }

        static /* synthetic */ XYZT access$500(byte[] r0) throws GeneralSecurityException {
            return fromBytesNegateVarTime(r0);
        }

        XYZT() {
            this(new XYZ(), new long[10]);
        }

        XYZT(XYZ xyz, long[] t) {
            this.xyz = xyz;
            this.t = t;
        }

        XYZT(PartialXYZT partialXYZT) {
            this();
            fromPartialXYZT(this, partialXYZT);
        }

        private static XYZT fromPartialXYZT(XYZT out, PartialXYZT in) {
            Field25519.mult(out.xyz.x, in.xyz.x, in.t);
            Field25519.mult(out.xyz.y, in.xyz.y, in.xyz.z);
            Field25519.mult(out.xyz.z, in.xyz.z, in.t);
            Field25519.mult(out.t, in.xyz.x, in.xyz.y);
            return out;
        }

        private static XYZT fromBytesNegateVarTime(byte[] s) throws GeneralSecurityException {
            long[] r1 = new long[10];
            long[] r2 = Field25519.expand(s);
            long[] r3 = new long[10];
            r3[0] = 1;
            long[] r4 = new long[10];
            long[] r5 = new long[10];
            long[] r6 = new long[10];
            long[] r7 = new long[10];
            long[] r8 = new long[10];
            Field25519.square(r5, r2);
            Field25519.mult(r6, r5, Ed25519Constants.D);
            Field25519.sub(r5, r5, r3);
            Field25519.sum(r6, r6, r3);
            long[] r0 = new long[10];
            Field25519.square(r0, r6);
            Field25519.mult(r0, r0, r6);
            Field25519.square(r1, r0);
            Field25519.mult(r1, r1, r6);
            Field25519.mult(r1, r1, r5);
            Ed25519.access$100(r1, r1);
            Field25519.mult(r1, r1, r0);
            Field25519.mult(r1, r1, r5);
            Field25519.square(r7, r1);
            Field25519.mult(r7, r7, r6);
            Field25519.sub(r8, r7, r5);
            if (Ed25519.access$200(r8) == false) goto L10;
            Field25519.sum(r8, r7, r5);
            if (Ed25519.access$200(r8) == true) goto L8;
            Field25519.mult(r1, r1, Ed25519Constants.SQRTM1);
            goto L10
        L8:
            throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. No square root exists for modulo 2^255-19");
        L10:
            if (Ed25519.access$200(r1) == true) goto L17;
            if (((s[31] & 255) >> 7) == 0) goto L17;
            throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. Computed x is zero and encoded x's least significant bit is not zero");
        L17:
            if (Ed25519.access$000(r1) != ((s[31] & 255) >> 7)) goto L19;
            Ed25519.access$300(r1, r1);
        L19:
            Field25519.mult(r4, r1, r2);
            return new XYZT(new XYZ(r1, r2, r3), r4);
        }
    }

    private static int eq(int a, int b) {
        int r0 = (~(a ^ b)) & 255;
        int r1 = r0 & (r0 << 4);
        int r2 = r1 & (r1 << 2);
        return ((r2 & (r2 << 1)) >> 7) & 1;
    }

    static /* synthetic */ int access$000(long[] r0) {
        return getLsb(r0);
    }

    static /* synthetic */ void access$100(long[] r0, long[] r1) {
        pow2252m3(r0, r1);
    }

    static /* synthetic */ boolean access$200(long[] r0) {
        return isNonZeroVarTime(r0);
    }

    static /* synthetic */ void access$300(long[] r0, long[] r1) {
        neg(r0, r1);
    }

    static {
        CACHED_NEUTRAL = new CachedXYT(new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        NEUTRAL = new PartialXYZT(new XYZ(new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}), new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        GROUP_ORDER = new byte[]{-19, -45, -11, 92, 26, 99, 18, 88, -42, -100, -9, -94, -34, -7, -34, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16};
    }

    private static void add(PartialXYZT partialXYZT, XYZT extended, CachedXYT cached) {
        long[] r0 = new long[10];
        Field25519.sum(partialXYZT.xyz.x, extended.xyz.y, extended.xyz.x);
        Field25519.sub(partialXYZT.xyz.y, extended.xyz.y, extended.xyz.x);
        Field25519.mult(partialXYZT.xyz.y, partialXYZT.xyz.y, cached.yMinusX);
        Field25519.mult(partialXYZT.xyz.z, partialXYZT.xyz.x, cached.yPlusX);
        Field25519.mult(partialXYZT.t, extended.t, cached.t2d);
        cached.multByZ(partialXYZT.xyz.x, extended.xyz.z);
        Field25519.sum(r0, partialXYZT.xyz.x, partialXYZT.xyz.x);
        Field25519.sub(partialXYZT.xyz.x, partialXYZT.xyz.z, partialXYZT.xyz.y);
        Field25519.sum(partialXYZT.xyz.y, partialXYZT.xyz.z, partialXYZT.xyz.y);
        Field25519.sum(partialXYZT.xyz.z, r0, partialXYZT.t);
        Field25519.sub(partialXYZT.t, r0, partialXYZT.t);
    }

    private static void sub(PartialXYZT partialXYZT, XYZT extended, CachedXYT cached) {
        long[] r0 = new long[10];
        Field25519.sum(partialXYZT.xyz.x, extended.xyz.y, extended.xyz.x);
        Field25519.sub(partialXYZT.xyz.y, extended.xyz.y, extended.xyz.x);
        Field25519.mult(partialXYZT.xyz.y, partialXYZT.xyz.y, cached.yPlusX);
        Field25519.mult(partialXYZT.xyz.z, partialXYZT.xyz.x, cached.yMinusX);
        Field25519.mult(partialXYZT.t, extended.t, cached.t2d);
        cached.multByZ(partialXYZT.xyz.x, extended.xyz.z);
        Field25519.sum(r0, partialXYZT.xyz.x, partialXYZT.xyz.x);
        Field25519.sub(partialXYZT.xyz.x, partialXYZT.xyz.z, partialXYZT.xyz.y);
        Field25519.sum(partialXYZT.xyz.y, partialXYZT.xyz.z, partialXYZT.xyz.y);
        Field25519.sub(partialXYZT.xyz.z, r0, partialXYZT.t);
        Field25519.sum(partialXYZT.t, r0, partialXYZT.t);
    }

    private static void doubleXYZ(PartialXYZT partialXYZT, XYZ p) {
        long[] r0 = new long[10];
        Field25519.square(partialXYZT.xyz.x, p.x);
        Field25519.square(partialXYZT.xyz.z, p.y);
        Field25519.square(partialXYZT.t, p.z);
        Field25519.sum(partialXYZT.t, partialXYZT.t, partialXYZT.t);
        Field25519.sum(partialXYZT.xyz.y, p.x, p.y);
        Field25519.square(r0, partialXYZT.xyz.y);
        Field25519.sum(partialXYZT.xyz.y, partialXYZT.xyz.z, partialXYZT.xyz.x);
        Field25519.sub(partialXYZT.xyz.z, partialXYZT.xyz.z, partialXYZT.xyz.x);
        Field25519.sub(partialXYZT.xyz.x, r0, partialXYZT.xyz.y);
        Field25519.sub(partialXYZT.t, partialXYZT.t, partialXYZT.xyz.z);
    }

    private static void doubleXYZT(PartialXYZT partialXYZT, XYZT p) {
        doubleXYZ(partialXYZT, p.xyz);
    }

    private static void select(CachedXYT t, int pos, byte b) {
        int r0 = (b & 255) >> 7;
        int r7 = b - (((-r0) & b) << 1);
        t.copyConditional(Ed25519Constants.B_TABLE[pos][0], eq(r7, 1));
        t.copyConditional(Ed25519Constants.B_TABLE[pos][1], eq(r7, 2));
        t.copyConditional(Ed25519Constants.B_TABLE[pos][2], eq(r7, 3));
        t.copyConditional(Ed25519Constants.B_TABLE[pos][3], eq(r7, 4));
        t.copyConditional(Ed25519Constants.B_TABLE[pos][4], eq(r7, 5));
        t.copyConditional(Ed25519Constants.B_TABLE[pos][5], eq(r7, 6));
        t.copyConditional(Ed25519Constants.B_TABLE[pos][6], eq(r7, 7));
        t.copyConditional(Ed25519Constants.B_TABLE[pos][7], eq(r7, 8));
        long[] r6 = Arrays.copyOf(t.yMinusX, 10);
        long[] r1 = Arrays.copyOf(t.yPlusX, 10);
        long[] r8 = Arrays.copyOf(t.t2d, 10);
        neg(r8, r8);
        t.copyConditional(new CachedXYT(r6, r1, r8), r0);
    }

    private static XYZ scalarMultWithBase(byte[] a) {
        byte[] r1 = new byte[64];
        int r2 = 0;
        int r3 = 0;
    L3:
        int r5 = 1;
        if (r3 >= 32) goto L6;
        int r4 = r3 * 2;
        r1[r4 + 0] = (byte) (((a[r3] & 255) >> 0) & 15);
        r1[r4 + 1] = (byte) (((a[r3] & 255) >> 4) & 15);
        r3 = r3 + 1;
        goto L3
    L6:
        int r8 = 0;
        int r6 = 0;
    L8:
        if (r8 >= 63) goto L10;
        byte r7 = (byte) (r1[r8] + r6);
        r1[r8] = r7;
        int r9 = (r7 + 8) >> 4;
        r1[r8] = (byte) (r7 - (r9 << 4));
        r8 = r8 + 1;
        r6 = r9;
        goto L8
    L10:
        r1[63] = (byte) (r1[63] + r6);
        PartialXYZT r10 = new PartialXYZT(NEUTRAL);
        XYZT r11 = new XYZT();
    L11:
        if (r5 >= 64) goto L13;
        CachedXYT r12 = new CachedXYT(CACHED_NEUTRAL);
        select(r12, r5 / 2, r1[r5]);
        add(r10, XYZT.access$400(r11, r10), r12);
        r5 = r5 + 2;
        goto L11
    L13:
        XYZ r13 = new XYZ();
        doubleXYZ(r10, XYZ.fromPartialXYZT(r13, r10));
        doubleXYZ(r10, XYZ.fromPartialXYZT(r13, r10));
        doubleXYZ(r10, XYZ.fromPartialXYZT(r13, r10));
        doubleXYZ(r10, XYZ.fromPartialXYZT(r13, r10));
    L14:
        if (r2 >= 64) goto L16;
        CachedXYT r14 = new CachedXYT(CACHED_NEUTRAL);
        select(r14, r2 / 2, r1[r2]);
        add(r10, XYZT.access$400(r11, r10), r14);
        r2 = r2 + 2;
        goto L14
    L16:
        XYZ r0 = new XYZ(r10);
        if (r0.isOnCurve() == false) goto L20;
        return r0;
    L20:
        throw new IllegalStateException("arithmetic error in scalar multiplication");
    }

    public static byte[] scalarMultWithBaseToBytes(byte[] a) {
        return scalarMultWithBase(a).toBytes();
    }

    private static byte[] slide(byte[] a) {
        byte[] r1 = new byte[256];
        int r3 = 0;
    L4:
        if (r3 >= 256) goto L6;
        r1[r3] = (byte) (1 & ((a[r3 >> 3] & 255) >> (r3 & 7)));
        r3 = r3 + 1;
        goto L4
    L6:
        int r10 = 0;
    L7:
        if (r10 >= 256) goto L30;
        if (r1[r10] == 0) goto L29;
        int r4 = 1;
    L12:
        if (r4 > 6) goto L29;
        int r5 = r10 + r4;
        if (r5 >= 256) goto L29;
        byte r6 = r1[r5];
        if (r6 == 0) goto L28;
        byte r7 = r1[r10];
        if (((r6 << r4) + r7) > 15) goto L21;
        r1[r10] = (byte) (r7 + (r6 << r4));
        r1[r5] = 0;
        goto L28
    L21:
        if ((r7 - (r6 << r4)) < (-15)) goto L29;
        r1[r10] = (byte) (r7 - (r6 << r4));
    L23:
        if (r5 >= 256) goto L28;
        if (r1[r5] == 0) goto L26;
        r1[r5] = 0;
        r5 = r5 + 1;
        goto L23
    L26:
        r1[r5] = 1;
    L28:
        r4 = r4 + 1;
    L29:
        r10 = r10 + 1;
        goto L7
    L30:
        return r1;
    }

    private static XYZ doubleScalarMultVarTime(byte[] a, XYZT pointA, byte[] b) {
        CachedXYZT[] r1 = new CachedXYZT[8];
        r1[0] = new CachedXYZT(pointA);
        PartialXYZT r2 = new PartialXYZT();
        doubleXYZT(r2, pointA);
        XYZT r7 = new XYZT(r2);
        int r3 = 1;
    L3:
        if (r3 >= 8) goto L5;
        add(r2, r7, r1[r3 - 1]);
        r1[r3] = new CachedXYZT(new XYZT(r2));
        r3 = r3 + 1;
        goto L3
    L5:
        byte[] r6 = slide(a);
        byte[] r8 = slide(b);
        PartialXYZT r9 = new PartialXYZT(NEUTRAL);
        XYZT r0 = new XYZT();
        int r4 = 255;
    L6:
        if (r4 < 0) goto L13;
        if (r6[r4] != 0) goto L13;
        if (r8[r4] != 0) goto L13;
        r4 = r4 - 1;
    L13:
        if (r4 < 0) goto L26;
        doubleXYZ(r9, new XYZ(r9));
        byte r5 = r6[r4];
        if (r5 <= 0) goto L17;
        add(r9, XYZT.access$400(r0, r9), r1[r6[r4] / 2]);
    L19:
        byte r10 = r8[r4];
        if (r10 <= 0) goto L22;
        add(r9, XYZT.access$400(r0, r9), Ed25519Constants.B2[r8[r4] / 2]);
    L24:
        r4 = r4 - 1;
        goto L13
    L22:
        if (r10 >= 0) goto L24;
        sub(r9, XYZT.access$400(r0, r9), Ed25519Constants.B2[(-r8[r4]) / 2]);
        goto L24
    L17:
        if (r5 >= 0) goto L19;
        sub(r9, XYZT.access$400(r0, r9), r1[(-r6[r4]) / 2]);
        goto L19
    L26:
        return new XYZ(r9);
    }

    private static boolean isNonZeroVarTime(long[] in) {
        long[] r0 = new long[in.length + 1];
        System.arraycopy(in, 0, r0, 0, in.length);
        Field25519.reduceCoefficients(r0);
        byte[] r5 = Field25519.contract(r0);
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        if (r5[r2] != 0) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    private static int getLsb(long[] in) {
        return Field25519.contract(in)[0] & 1;
    }

    private static void neg(long[] out, long[] in) {
        int r0 = 0;
    L4:
        if (r0 >= in.length) goto L6;
        out[r0] = -in[r0];
        r0 = r0 + 1;
        goto L4
    }

    private static void pow2252m3(long[] out, long[] in) {
        long[] r1 = new long[10];
        long[] r2 = new long[10];
        long[] r3 = new long[10];
        Field25519.square(r1, in);
        Field25519.square(r2, r1);
        Field25519.square(r2, r2);
        Field25519.mult(r2, in, r2);
        Field25519.mult(r1, r1, r2);
        Field25519.square(r1, r1);
        Field25519.mult(r1, r2, r1);
        Field25519.square(r2, r1);
        int r4 = 1;
        int r5 = 1;
    L4:
        if (r5 >= 5) goto L6;
        Field25519.square(r2, r2);
        r5 = r5 + 1;
        goto L4
    L6:
        Field25519.mult(r1, r2, r1);
        Field25519.square(r2, r1);
        int r6 = 1;
    L7:
        if (r6 >= 10) goto L9;
        Field25519.square(r2, r2);
        r6 = r6 + 1;
        goto L7
    L9:
        Field25519.mult(r2, r2, r1);
        Field25519.square(r3, r2);
        int r7 = 1;
    L11:
        if (r7 >= 20) goto L13;
        Field25519.square(r3, r3);
        r7 = r7 + 1;
        goto L11
    L13:
        Field25519.mult(r2, r3, r2);
        Field25519.square(r2, r2);
        int r8 = 1;
    L14:
        if (r8 >= 10) goto L16;
        Field25519.square(r2, r2);
        r8 = r8 + 1;
        goto L14
    L16:
        Field25519.mult(r1, r2, r1);
        Field25519.square(r2, r1);
        int r0 = 1;
    L18:
        if (r0 >= 50) goto L20;
        Field25519.square(r2, r2);
        r0 = r0 + 1;
        goto L18
    L20:
        Field25519.mult(r2, r2, r1);
        Field25519.square(r3, r2);
        int r9 = 1;
    L22:
        if (r9 >= 100) goto L24;
        Field25519.square(r3, r3);
        r9 = r9 + 1;
        goto L22
    L24:
        Field25519.mult(r2, r3, r2);
        Field25519.square(r2, r2);
    L25:
        if (r4 >= 50) goto L27;
        Field25519.square(r2, r2);
        r4 = r4 + 1;
        goto L25
    L27:
        Field25519.mult(r1, r2, r1);
        Field25519.square(r1, r1);
        Field25519.square(r1, r1);
        Field25519.mult(out, r1, in);
    }

    private static long load3(byte[] in, int idx) {
        long r0 = (((long) in[idx]) & 255) | (((long) (in[idx + 1] & 255)) << 8);
        return (((long) (in[idx + 2] & 255)) << 16) | r0;
    }

    private static long load4(byte[] in, int idx) {
        long r0 = load3(in, idx);
        return (((long) (in[idx + 3] & 255)) << 24) | r0;
    }

    private static void reduce(byte[] s) {
        long r1 = load3(s, 0) & 2097151;
        long r6 = (load4(s, 2) >> 5) & 2097151;
        long r9 = (load3(s, 5) >> 2) & 2097151;
        long r12 = (load4(s, 7) >> 7) & 2097151;
        long r15 = (load4(s, 10) >> 4) & 2097151;
        long r18 = (load3(s, 13) >> 1) & 2097151;
        long r21 = (load4(s, 15) >> 6) & 2097151;
        long r24 = (load3(s, 18) >> 3) & 2097151;
        long r27 = load3(s, 21) & 2097151;
        long r29 = (load4(s, 23) >> 5) & 2097151;
        long r31 = (load3(s, 26) >> 2) & 2097151;
        long r33 = (load4(s, 28) >> 7) & 2097151;
        long r35 = (load4(s, 31) >> 4) & 2097151;
        long r37 = (load3(s, 34) >> 1) & 2097151;
        long r39 = (load4(s, 36) >> 6) & 2097151;
        long r41 = (load3(s, 39) >> 3) & 2097151;
        long r43 = load3(s, 42) & 2097151;
        long r45 = (load4(s, 44) >> 5) & 2097151;
        long r47 = (load3(s, 47) >> 2) & 2097151;
        long r49 = (load4(s, 49) >> 7) & 2097151;
        long r51 = (load4(s, 52) >> 4) & 2097151;
        long r53 = (load3(s, 55) >> 1) & 2097151;
        long r3 = (load4(s, 57) >> 6) & 2097151;
        long r55 = load4(s, 60) >> 3;
        long r44 = r43 - (r55 * 683901);
        long r310 = ((r39 - (r55 * 997805)) + (r3 * 136657)) - (r53 * 683901);
        long r36 = ((((r35 + (r55 * 470296)) + (r3 * 654183)) - (r53 * 997805)) + (r51 * 136657)) - (r49 * 683901);
        long r22 = r21 + (r47 * 666643);
        long r25 = (r24 + (r49 * 666643)) + (r47 * 470296);
        long r28 = ((r27 + (r51 * 666643)) + (r49 * 470296)) + (r47 * 654183);
        long r210 = (((r29 + (r53 * 666643)) + (r51 * 470296)) + (r49 * 654183)) - (r47 * 997805);
        long r32 = ((((r31 + (r3 * 666643)) + (r53 * 470296)) + (r51 * 654183)) - (r49 * 997805)) + (r47 * 136657);
        long r34 = (((((r33 + (r55 * 666643)) + (r3 * 470296)) + (r53 * 654183)) - (r51 * 997805)) + (r49 * 136657)) - (r47 * 683901);
        long r48 = (r22 + 1048576) >> 21;
        long r26 = r25 + r48;
        long r23 = r22 - (r48 << 21);
        long r410 = (r28 + 1048576) >> 21;
        long r211 = r210 + r410;
        long r212 = r28 - (r410 << 21);
        long r411 = (r32 + 1048576) >> 21;
        long r38 = r34 + r411;
        long r311 = r32 - (r411 << 21);
        long r412 = (r36 + 1048576) >> 21;
        long r312 = ((((r37 + (r55 * 654183)) - (r3 * 997805)) + (r53 * 136657)) - (r51 * 683901)) + r412;
        long r313 = r36 - (r412 << 21);
        long r413 = (r310 + 1048576) >> 21;
        long r42 = ((r41 + (r55 * 136657)) - (r3 * 683901)) + r413;
        long r314 = r310 - (r413 << 21);
        long r414 = (r44 + 1048576) >> 21;
        long r46 = r45 + r414;
        long r415 = r44 - (r414 << 21);
        long r416 = (r26 + 1048576) >> 21;
        long r213 = r212 + r416;
        long r214 = r26 - (r416 << 21);
        long r417 = (r211 + 1048576) >> 21;
        long r315 = r311 + r417;
        long r215 = r211 - (r417 << 21);
        long r418 = (r38 + 1048576) >> 21;
        long r316 = r313 + r418;
        long r317 = r38 - (r418 << 21);
        long r419 = (r312 + 1048576) >> 21;
        long r318 = r314 + r419;
        long r319 = r312 - (r419 << 21);
        long r420 = (r42 + 1048576) >> 21;
        long r421 = r415 + r420;
        long r422 = r42 - (r420 << 21);
        long r320 = r315 - (r46 * 683901);
        long r216 = ((r213 - (r46 * 997805)) + (r421 * 136657)) - (r422 * 683901);
        long r217 = ((((r23 + (r46 * 470296)) + (r421 * 654183)) - (r422 * 997805)) + (r318 * 136657)) - (r319 * 683901);
        long r2 = r1 + (r316 * 666643);
        long r7 = (r6 + (r319 * 666643)) + (r316 * 470296);
        long r10 = ((r9 + (r318 * 666643)) + (r319 * 470296)) + (r316 * 654183);
        long r13 = (((r12 + (r422 * 666643)) + (r318 * 470296)) + (r319 * 654183)) - (r316 * 997805);
        long r16 = ((((r15 + (r421 * 666643)) + (r422 * 470296)) + (r318 * 654183)) - (r319 * 997805)) + (r316 * 136657);
        long r19 = (((((r18 + (r46 * 666643)) + (r421 * 470296)) + (r422 * 654183)) - (r318 * 997805)) + (r319 * 136657)) - (r316 * 683901);
        long r321 = (r2 + 1048576) >> 21;
        long r8 = r7 + r321;
        long r4 = r2 - (r321 << 21);
        long r322 = (r10 + 1048576) >> 21;
        long r14 = r13 + r322;
        long r11 = r10 - (r322 << 21);
        long r323 = (r16 + 1048576) >> 21;
        long r110 = r19 + r323;
        long r17 = r16 - (r323 << 21);
        long r324 = (r217 + 1048576) >> 21;
        long r218 = ((((r214 + (r46 * 654183)) - (r421 * 997805)) + (r422 * 136657)) - (r318 * 683901)) + r324;
        long r219 = r217 - (r324 << 21);
        long r325 = (r216 + 1048576) >> 21;
        long r220 = ((r215 + (r46 * 136657)) - (r421 * 683901)) + r325;
        long r221 = r216 - (r325 << 21);
        long r326 = (r320 + 1048576) >> 21;
        long r327 = r317 + r326;
        long r328 = r320 - (r326 << 21);
        long r329 = (r8 + 1048576) >> 21;
        long r20 = r11 + r329;
        long r30 = r8 - (r329 << 21);
        long r330 = (r14 + 1048576) >> 21;
        long r111 = r17 + r330;
        long r112 = r14 - (r330 << 21);
        long r331 = (r110 + 1048576) >> 21;
        long r222 = r219 + r331;
        long r113 = r110 - (r331 << 21);
        long r332 = (r218 + 1048576) >> 21;
        long r223 = r221 + r332;
        long r224 = r218 - (r332 << 21);
        long r333 = (r220 + 1048576) >> 21;
        long r334 = r328 + r333;
        long r225 = r220 - (r333 << 21);
        long r5 = (r327 + 1048576) >> 21;
        long r335 = r5 + 0;
        long r40 = r4 + (r335 * 666643);
        long r50 = r30 + (r335 * 470296);
        long r52 = r20 + (r335 * 654183);
        long r114 = r112 - (r335 * 997805);
        long r115 = r111 + (r335 * 136657);
        long r116 = r113 - (r335 * 683901);
        long r336 = r40 >> 21;
        long r54 = r50 + r336;
        long r56 = r40 - (r336 << 21);
        long r337 = r54 >> 21;
        long r57 = r52 + r337;
        long r58 = r54 - (r337 << 21);
        long r338 = r57 >> 21;
        long r117 = r114 + r338;
        long r59 = r57 - (r338 << 21);
        long r339 = r117 >> 21;
        long r118 = r115 + r339;
        long r119 = r117 - (r339 << 21);
        long r340 = r118 >> 21;
        long r120 = r116 + r340;
        long r121 = r118 - (r340 << 21);
        long r341 = r120 >> 21;
        long r226 = r222 + r341;
        long r122 = r120 - (r341 << 21);
        long r342 = r226 >> 21;
        long r227 = r224 + r342;
        long r228 = r226 - (r342 << 21);
        long r343 = r227 >> 21;
        long r229 = r223 + r343;
        long r230 = r227 - (r343 << 21);
        long r344 = r229 >> 21;
        long r231 = r225 + r344;
        long r232 = r229 - (r344 << 21);
        long r345 = r231 >> 21;
        long r346 = r334 + r345;
        long r233 = r231 - (r345 << 21);
        long r347 = r346 >> 21;
        long r348 = (r327 - (r5 << 21)) + r347;
        long r349 = r346 - (r347 << 21);
        long r350 = r348 >> 21;
        long r351 = r350 + 0;
        long r352 = r348 - (r350 << 21);
        long r60 = r56 + (666643 * r351);
        long r353 = r60 >> 21;
        long r61 = (r58 + (470296 * r351)) + r353;
        long r62 = r60 - (r353 << 21);
        long r354 = r61 >> 21;
        long r63 = (r59 + (654183 * r351)) + r354;
        long r64 = r61 - (r354 << 21);
        long r355 = r63 >> 21;
        long r123 = (r119 - (997805 * r351)) + r355;
        long r65 = r63 - (r355 << 21);
        long r356 = r123 >> 21;
        long r124 = (r121 + (136657 * r351)) + r356;
        long r125 = r123 - (r356 << 21);
        long r357 = r124 >> 21;
        long r126 = (r122 - (r351 * 683901)) + r357;
        long r127 = r124 - (r357 << 21);
        long r358 = r126 >> 21;
        long r234 = r228 + r358;
        long r128 = r126 - (r358 << 21);
        long r359 = r234 >> 21;
        long r235 = r230 + r359;
        long r236 = r234 - (r359 << 21);
        long r360 = r235 >> 21;
        long r237 = r232 + r360;
        long r238 = r235 - (r360 << 21);
        long r361 = r237 >> 21;
        long r239 = r233 + r361;
        long r129 = r237 - (r361 << 21);
        long r130 = r239 >> 21;
        long r362 = r349 + r130;
        long r240 = r239 - (r130 << 21);
        long r131 = r362 >> 21;
        long r363 = r352 + r131;
        long r364 = r362 - (r131 << 21);
        s[0] = (byte) r62;
        s[1] = (byte) (r62 >> 8);
        s[2] = (byte) ((r62 >> 16) | (r64 << 5));
        s[3] = (byte) (r64 >> 3);
        s[4] = (byte) (r64 >> 11);
        s[5] = (byte) ((r64 >> 19) | (r65 << 2));
        s[6] = (byte) (r65 >> 6);
        s[7] = (byte) ((r65 >> 14) | (r125 << 7));
        s[8] = (byte) (r125 >> 1);
        s[9] = (byte) (r125 >> 9);
        s[10] = (byte) ((r125 >> 17) | (r127 << 4));
        s[11] = (byte) (r127 >> 4);
        s[12] = (byte) (r127 >> 12);
        s[13] = (byte) ((r127 >> 20) | (r128 << 1));
        s[14] = (byte) (r128 >> 7);
        s[15] = (byte) ((r128 >> 15) | (r236 << 6));
        s[16] = (byte) (r236 >> 2);
        s[17] = (byte) (r236 >> 10);
        s[18] = (byte) ((r236 >> 18) | (r238 << 3));
        s[19] = (byte) (r238 >> 5);
        s[20] = (byte) (r238 >> 13);
        s[21] = (byte) r129;
        s[22] = (byte) (r129 >> 8);
        s[23] = (byte) ((r129 >> 16) | (r240 << 5));
        s[24] = (byte) (r240 >> 3);
        s[25] = (byte) (r240 >> 11);
        s[26] = (byte) ((r240 >> 19) | (r364 << 2));
        s[27] = (byte) (r364 >> 6);
        s[28] = (byte) ((r364 >> 14) | (r363 << 7));
        s[29] = (byte) (r363 >> 1);
        s[30] = (byte) (r363 >> 9);
        s[31] = (byte) (r363 >> 17);
    }

    private static void mulAdd(byte[] s, byte[] a, byte[] b, byte[] c) {
        long r4 = load3(a, 0) & 2097151;
        long r9 = (load4(a, 2) >> 5) & 2097151;
        long r12 = (load3(a, 5) >> 2) & 2097151;
        long r15 = (load4(a, 7) >> 7) & 2097151;
        long r17 = (load4(a, 10) >> 4) & 2097151;
        long r20 = (load3(a, 13) >> 1) & 2097151;
        long r23 = (load4(a, 15) >> 6) & 2097151;
        long r26 = (load3(a, 18) >> 3) & 2097151;
        long r29 = load3(a, 21) & 2097151;
        long r32 = (load4(a, 23) >> 5) & 2097151;
        long r34 = (load3(a, 26) >> 2) & 2097151;
        long r36 = load4(a, 28) >> 7;
        long r38 = load3(b, 0) & 2097151;
        long r40 = (load4(b, 2) >> 5) & 2097151;
        long r42 = (load3(b, 5) >> 2) & 2097151;
        long r44 = (load4(b, 7) >> 7) & 2097151;
        long r46 = (load4(b, 10) >> 4) & 2097151;
        long r48 = (load3(b, 13) >> 1) & 2097151;
        long r50 = (load4(b, 15) >> 6) & 2097151;
        long r52 = (load3(b, 18) >> 3) & 2097151;
        long r54 = load3(b, 21) & 2097151;
        long r56 = (load4(b, 23) >> 5) & 2097151;
        long r58 = (load3(b, 26) >> 2) & 2097151;
        long r0 = load4(b, 28) >> 7;
        long r60 = load3(c, 0) & 2097151;
        long r62 = (load4(c, 2) >> 5) & 2097151;
        long r64 = (load3(c, 5) >> 2) & 2097151;
        long r66 = (load4(c, 7) >> 7) & 2097151;
        long r68 = (load4(c, 10) >> 4) & 2097151;
        long r70 = (load3(c, 13) >> 1) & 2097151;
        long r72 = (load4(c, 15) >> 6) & 2097151;
        long r74 = (load3(c, 18) >> 3) & 2097151;
        long r76 = load3(c, 21) & 2097151;
        long r78 = (load4(c, 23) >> 5) & 2097151;
        long r61 = r60 + (r4 * r38);
        long r63 = (r62 + (r4 * r40)) + (r9 * r38);
        long r65 = ((r64 + (r4 * r42)) + (r9 * r40)) + (r12 * r38);
        long r67 = (((r66 + (r4 * r44)) + (r9 * r42)) + (r12 * r40)) + (r15 * r38);
        long r69 = ((((r68 + (r4 * r46)) + (r9 * r44)) + (r12 * r42)) + (r15 * r40)) + (r17 * r38);
        long r71 = (((((r70 + (r4 * r48)) + (r9 * r46)) + (r12 * r44)) + (r15 * r42)) + (r17 * r40)) + (r20 * r38);
        long r73 = ((((((r72 + (r4 * r50)) + (r9 * r48)) + (r12 * r46)) + (r15 * r44)) + (r17 * r42)) + (r20 * r40)) + (r23 * r38);
        long r75 = (((((((r74 + (r4 * r52)) + (r9 * r50)) + (r12 * r48)) + (r15 * r46)) + (r17 * r44)) + (r20 * r42)) + (r23 * r40)) + (r26 * r38);
        long r77 = ((((((((r76 + (r4 * r54)) + (r9 * r52)) + (r12 * r50)) + (r15 * r48)) + (r17 * r46)) + (r20 * r44)) + (r23 * r42)) + (r26 * r40)) + (r29 * r38);
        long r79 = (((((((((r78 + (r4 * r56)) + (r9 * r54)) + (r12 * r52)) + (r15 * r50)) + (r17 * r48)) + (r20 * r46)) + (r23 * r44)) + (r26 * r42)) + (r29 * r40)) + (r32 * r38);
        long r6 = ((((((((((((load3(c, 26) >> 2) & 2097151) + (r4 * r58)) + (r9 * r56)) + (r12 * r54)) + (r15 * r52)) + (r17 * r50)) + (r20 * r48)) + (r23 * r46)) + (r26 * r44)) + (r29 * r42)) + (r32 * r40)) + (r34 * r38);
        long r2 = ((((((((((((load4(c, 28) >> 7) + (r4 * r0)) + (r9 * r58)) + (r12 * r56)) + (r15 * r54)) + (r17 * r52)) + (r20 * r50)) + (r23 * r48)) + (r26 * r46)) + (r29 * r44)) + (r32 * r42)) + (r34 * r40)) + (r38 * r36);
        long r10 = ((((((((((r9 * r0) + (r12 * r58)) + (r15 * r56)) + (r17 * r54)) + (r20 * r52)) + (r23 * r50)) + (r26 * r48)) + (r29 * r46)) + (r32 * r44)) + (r34 * r42)) + (r40 * r36);
        long r13 = (((((((((r12 * r0) + (r15 * r58)) + (r17 * r56)) + (r20 * r54)) + (r23 * r52)) + (r26 * r50)) + (r29 * r48)) + (r32 * r46)) + (r34 * r44)) + (r42 * r36);
        long r16 = ((((((((r15 * r0) + (r17 * r58)) + (r20 * r56)) + (r23 * r54)) + (r26 * r52)) + (r29 * r50)) + (r32 * r48)) + (r34 * r46)) + (r44 * r36);
        long r18 = (((((((r17 * r0) + (r20 * r58)) + (r23 * r56)) + (r26 * r54)) + (r29 * r52)) + (r32 * r50)) + (r34 * r48)) + (r46 * r36);
        long r21 = ((((((r20 * r0) + (r23 * r58)) + (r26 * r56)) + (r29 * r54)) + (r32 * r52)) + (r34 * r50)) + (r48 * r36);
        long r24 = (((((r23 * r0) + (r26 * r58)) + (r29 * r56)) + (r32 * r54)) + (r34 * r52)) + (r50 * r36);
        long r27 = ((((r26 * r0) + (r29 * r58)) + (r32 * r56)) + (r34 * r54)) + (r52 * r36);
        long r210 = (((r29 * r0) + (r32 * r58)) + (r34 * r56)) + (r54 * r36);
        long r33 = ((r32 * r0) + (r34 * r58)) + (r56 * r36);
        long r35 = (r34 * r0) + (r58 * r36);
        long r37 = r36 * r0;
        long r5 = (r61 + 1048576) >> 21;
        long r610 = r63 + r5;
        long r611 = r61 - (r5 << 21);
        long r7 = (r65 + 1048576) >> 21;
        long r612 = r67 + r7;
        long r613 = r65 - (r7 << 21);
        long r8 = (r69 + 1048576) >> 21;
        long r710 = r71 + r8;
        long r614 = r69 - (r8 << 21);
        long r11 = (r73 + 1048576) >> 21;
        long r711 = r75 + r11;
        long r712 = r73 - (r11 << 21);
        long r14 = (r77 + 1048576) >> 21;
        long r713 = r79 + r14;
        long r714 = r77 - (r14 << 21);
        long r19 = (r6 + 1048576) >> 21;
        long r3 = r2 + r19;
        long r22 = r6 - (r19 << 21);
        long r25 = (r10 + 1048576) >> 21;
        long r110 = r13 + r25;
        long r28 = r10 - (r25 << 21);
        long r30 = (r16 + 1048576) >> 21;
        long r111 = r18 + r30;
        long r112 = r16 - (r30 << 21);
        long r31 = (r21 + 1048576) >> 21;
        long r211 = r24 + r31;
        long r212 = r21 - (r31 << 21);
        long r39 = (r27 + 1048576) >> 21;
        long r213 = r210 + r39;
        long r214 = r27 - (r39 << 21);
        long r41 = (r33 + 1048576) >> 21;
        long r310 = r35 + r41;
        long r311 = r33 - (r41 << 21);
        long r43 = (r37 + 1048576) >> 21;
        long r312 = r43 + 0;
        long r313 = r37 - (r43 << 21);
        long r45 = (r610 + 1048576) >> 21;
        long r615 = r613 + r45;
        long r616 = r610 - (r45 << 21);
        long r47 = (r612 + 1048576) >> 21;
        long r617 = r614 + r47;
        long r618 = r612 - (r47 << 21);
        long r49 = (r710 + 1048576) >> 21;
        long r715 = r712 + r49;
        long r716 = r710 - (r49 << 21);
        long r51 = (r711 + 1048576) >> 21;
        long r717 = r714 + r51;
        long r718 = r711 - (r51 << 21);
        long r53 = (r713 + 1048576) >> 21;
        long r55 = r22 + r53;
        long r719 = r713 - (r53 << 21);
        long r57 = (r3 + 1048576) >> 21;
        long r59 = r28 + r57;
        long r80 = r3 - (r57 << 21);
        long r81 = (r110 + 1048576) >> 21;
        long r113 = r112 + r81;
        long r114 = r110 - (r81 << 21);
        long r82 = (r111 + 1048576) >> 21;
        long r215 = r212 + r82;
        long r115 = r111 - (r82 << 21);
        long r83 = (r211 + 1048576) >> 21;
        long r216 = r214 + r83;
        long r217 = r211 - (r83 << 21);
        long r84 = (r213 + 1048576) >> 21;
        long r314 = r311 + r84;
        long r218 = r213 - (r84 << 21);
        long r85 = (r310 + 1048576) >> 21;
        long r315 = r313 + r85;
        long r316 = r310 - (r85 << 21);
        long r219 = r215 - (r312 * 683901);
        long r116 = ((r113 - (r312 * 997805)) + (r315 * 136657)) - (r316 * 683901);
        long r86 = ((((r59 + (r312 * 470296)) + (r315 * 654183)) - (r316 * 997805)) + (r314 * 136657)) - (r218 * 683901);
        long r720 = r715 + (r216 * 666643);
        long r721 = (r718 + (r218 * 666643)) + (r216 * 470296);
        long r722 = ((r717 + (r314 * 666643)) + (r218 * 470296)) + (r216 * 654183);
        long r723 = (((r719 + (r316 * 666643)) + (r314 * 470296)) + (r218 * 654183)) - (r216 * 997805);
        long r87 = ((((r55 + (r315 * 666643)) + (r316 * 470296)) + (r314 * 654183)) - (r218 * 997805)) + (r216 * 136657);
        long r88 = (((((r80 + (r312 * 666643)) + (r315 * 470296)) + (r316 * 654183)) - (r314 * 997805)) + (r218 * 136657)) - (r216 * 683901);
        long r220 = (r720 + 1048576) >> 21;
        long r724 = r721 + r220;
        long r725 = r720 - (r220 << 21);
        long r221 = (r722 + 1048576) >> 21;
        long r726 = r723 + r221;
        long r727 = r722 - (r221 << 21);
        long r222 = (r87 + 1048576) >> 21;
        long r89 = r88 + r222;
        long r90 = r87 - (r222 << 21);
        long r223 = (r86 + 1048576) >> 21;
        long r117 = ((((r114 + (r312 * 654183)) - (r315 * 997805)) + (r316 * 136657)) - (r314 * 683901)) + r223;
        long r91 = r86 - (r223 << 21);
        long r224 = (r116 + 1048576) >> 21;
        long r118 = ((r115 + (r312 * 136657)) - (r315 * 683901)) + r224;
        long r119 = r116 - (r224 << 21);
        long r225 = (r219 + 1048576) >> 21;
        long r226 = r217 + r225;
        long r227 = r219 - (r225 << 21);
        long r228 = (r724 + 1048576) >> 21;
        long r728 = r727 + r228;
        long r729 = r724 - (r228 << 21);
        long r229 = (r726 + 1048576) >> 21;
        long r92 = r90 + r229;
        long r730 = r726 - (r229 << 21);
        long r230 = (r89 + 1048576) >> 21;
        long r93 = r91 + r230;
        long r94 = r89 - (r230 << 21);
        long r231 = (r117 + 1048576) >> 21;
        long r120 = r119 + r231;
        long r121 = r117 - (r231 << 21);
        long r232 = (r118 + 1048576) >> 21;
        long r233 = r227 + r232;
        long r122 = r118 - (r232 << 21);
        long r95 = r92 - (r226 * 683901);
        long r731 = ((r728 - (r226 * 997805)) + (r233 * 136657)) - (r122 * 683901);
        long r732 = ((((r725 + (r226 * 470296)) + (r233 * 654183)) - (r122 * 997805)) + (r120 * 136657)) - (r121 * 683901);
        long r619 = r611 + (r93 * 666643);
        long r620 = (r616 + (r121 * 666643)) + (r93 * 470296);
        long r621 = ((r615 + (r120 * 666643)) + (r121 * 470296)) + (r93 * 654183);
        long r622 = (((r618 + (r122 * 666643)) + (r120 * 470296)) + (r121 * 654183)) - (r93 * 997805);
        long r623 = ((((r617 + (r233 * 666643)) + (r122 * 470296)) + (r120 * 654183)) - (r121 * 997805)) + (r93 * 136657);
        long r733 = (((((r716 + (r226 * 666643)) + (r233 * 470296)) + (r122 * 654183)) - (r120 * 997805)) + (r121 * 136657)) - (r93 * 683901);
        long r96 = (r619 + 1048576) >> 21;
        long r624 = r620 + r96;
        long r625 = r619 - (r96 << 21);
        long r97 = (r621 + 1048576) >> 21;
        long r626 = r622 + r97;
        long r627 = r621 - (r97 << 21);
        long r98 = (r623 + 1048576) >> 21;
        long r734 = r733 + r98;
        long r628 = r623 - (r98 << 21);
        long r99 = (r732 + 1048576) >> 21;
        long r735 = ((((r729 + (r226 * 654183)) - (r233 * 997805)) + (r122 * 136657)) - (r120 * 683901)) + r99;
        long r736 = r732 - (r99 << 21);
        long r100 = (r731 + 1048576) >> 21;
        long r737 = ((r730 + (r226 * 136657)) - (r233 * 683901)) + r100;
        long r738 = r731 - (r100 << 21);
        long r101 = (r95 + 1048576) >> 21;
        long r102 = r94 + r101;
        long r103 = r95 - (r101 << 21);
        long r104 = (r624 + 1048576) >> 21;
        long r629 = r627 + r104;
        long r630 = r624 - (r104 << 21);
        long r105 = (r626 + 1048576) >> 21;
        long r631 = r628 + r105;
        long r632 = r626 - (r105 << 21);
        long r106 = (r734 + 1048576) >> 21;
        long r739 = r736 + r106;
        long r740 = r734 - (r106 << 21);
        long r107 = (r735 + 1048576) >> 21;
        long r741 = r738 + r107;
        long r742 = r735 - (r107 << 21);
        long r108 = (r737 + 1048576) >> 21;
        long r109 = r103 + r108;
        long r743 = r737 - (r108 << 21);
        long r1 = (1048576 + r102) >> 21;
        long r123 = 0 + r1;
        long r633 = r625 + (r123 * 666643);
        long r634 = r630 + (r123 * 470296);
        long r635 = r629 + (r123 * 654183);
        long r636 = r632 - (r123 * 997805);
        long r637 = r631 + (r123 * 136657);
        long r744 = r740 - (r123 * 683901);
        long r124 = r633 >> 21;
        long r638 = r634 + r124;
        long r639 = r633 - (r124 << 21);
        long r125 = r638 >> 21;
        long r640 = r635 + r125;
        long r641 = r638 - (r125 << 21);
        long r126 = r640 >> 21;
        long r642 = r636 + r126;
        long r643 = r640 - (r126 << 21);
        long r127 = r642 >> 21;
        long r644 = r637 + r127;
        long r645 = r642 - (r127 << 21);
        long r128 = r644 >> 21;
        long r745 = r744 + r128;
        long r646 = r644 - (r128 << 21);
        long r129 = r745 >> 21;
        long r746 = r739 + r129;
        long r747 = r745 - (r129 << 21);
        long r130 = r746 >> 21;
        long r748 = r742 + r130;
        long r749 = r746 - (r130 << 21);
        long r131 = r748 >> 21;
        long r750 = r741 + r131;
        long r751 = r748 - (r131 << 21);
        long r132 = r750 >> 21;
        long r752 = r743 + r132;
        long r753 = r750 - (r132 << 21);
        long r133 = r752 >> 21;
        long r134 = r109 + r133;
        long r754 = r752 - (r133 << 21);
        long r135 = r134 >> 21;
        long r136 = (r102 - (r1 << 21)) + r135;
        long r137 = r134 - (r135 << 21);
        long r138 = r136 >> 21;
        long r139 = 0 + r138;
        long r140 = r136 - (r138 << 21);
        long r647 = r639 + (666643 * r139);
        long r141 = r647 >> 21;
        long r648 = (r641 + (470296 * r139)) + r141;
        long r142 = r647 - (r141 << 21);
        long r143 = r648 >> 21;
        long r649 = (r643 + (654183 * r139)) + r143;
        long r650 = r648 - (r143 << 21);
        long r144 = r649 >> 21;
        long r651 = (r645 - (997805 * r139)) + r144;
        long r652 = r649 - (r144 << 21);
        long r145 = r651 >> 21;
        long r653 = (r646 + (136657 * r139)) + r145;
        long r654 = r651 - (r145 << 21);
        long r146 = r653 >> 21;
        long r755 = (r747 - (r139 * 683901)) + r146;
        long r655 = r653 - (r146 << 21);
        long r147 = r755 >> 21;
        long r756 = r749 + r147;
        long r757 = r755 - (r147 << 21);
        long r148 = r756 >> 21;
        long r758 = r751 + r148;
        long r759 = r756 - (r148 << 21);
        long r149 = r758 >> 21;
        long r760 = r753 + r149;
        long r761 = r758 - (r149 << 21);
        long r150 = r760 >> 21;
        long r762 = r754 + r150;
        long r151 = r760 - (r150 << 21);
        long r152 = r762 >> 21;
        long r153 = r137 + r152;
        long r763 = r762 - (r152 << 21);
        long r154 = r153 >> 21;
        long r155 = r140 + r154;
        long r156 = r153 - (r154 << 21);
        s[0] = (byte) r142;
        s[1] = (byte) (r142 >> 8);
        s[2] = (byte) ((r142 >> 16) | (r650 << 5));
        s[3] = (byte) (r650 >> 3);
        s[4] = (byte) (r650 >> 11);
        s[5] = (byte) ((r650 >> 19) | (r652 << 2));
        s[6] = (byte) (r652 >> 6);
        s[7] = (byte) ((r652 >> 14) | (r654 << 7));
        s[8] = (byte) (r654 >> 1);
        s[9] = (byte) (r654 >> 9);
        s[10] = (byte) ((r654 >> 17) | (r655 << 4));
        s[11] = (byte) (r655 >> 4);
        s[12] = (byte) (r655 >> 12);
        s[13] = (byte) ((r655 >> 20) | (r757 << 1));
        s[14] = (byte) (r757 >> 7);
        s[15] = (byte) ((r757 >> 15) | (r759 << 6));
        s[16] = (byte) (r759 >> 2);
        s[17] = (byte) (r759 >> 10);
        s[18] = (byte) ((r759 >> 18) | (r761 << 3));
        s[19] = (byte) (r761 >> 5);
        s[20] = (byte) (r761 >> 13);
        s[21] = (byte) r151;
        s[22] = (byte) (r151 >> 8);
        s[23] = (byte) ((r151 >> 16) | (r763 << 5));
        s[24] = (byte) (r763 >> 3);
        s[25] = (byte) (r763 >> 11);
        s[26] = (byte) ((r763 >> 19) | (r156 << 2));
        s[27] = (byte) (r156 >> 6);
        s[28] = (byte) ((r156 >> 14) | (r155 << 7));
        s[29] = (byte) (r155 >> 1);
        s[30] = (byte) (r155 >> 9);
        s[31] = (byte) (r155 >> 17);
    }

    public static byte[] getHashedScalar(final byte[] privateKey) throws GeneralSecurityException {
        MessageDigest r0 = EngineFactory.MESSAGE_DIGEST.getInstance("SHA-512");
        r0.update(privateKey, 0, 32);
        byte[] r3 = r0.digest();
        r3[0] = (byte) (r3[0] & 248);
        byte r1 = (byte) (r3[31] & 127);
        r3[31] = r1;
        r3[31] = (byte) (r1 | SignedBytes.MAX_POWER_OF_TWO);
        return r3;
    }

    public static byte[] sign(final byte[] message, final byte[] publicKey, final byte[] hashedPrivateKey) throws GeneralSecurityException {
        byte[] r5 = Arrays.copyOfRange(message, 0, message.length);
        MessageDigest r0 = EngineFactory.MESSAGE_DIGEST.getInstance("SHA-512");
        r0.update(hashedPrivateKey, 32, 32);
        r0.update(r5);
        byte[] r3 = r0.digest();
        reduce(r3);
        byte[] r4 = Arrays.copyOfRange(scalarMultWithBase(r3).toBytes(), 0, 32);
        r0.reset();
        r0.update(r4);
        r0.update(publicKey);
        r0.update(r5);
        byte[] r6 = r0.digest();
        reduce(r6);
        byte[] r7 = new byte[32];
        mulAdd(r7, r6, hashedPrivateKey, r3);
        return Bytes.concat(new byte[][]{r4, r7});
    }

    private static boolean isSmallerThanGroupOrder(byte[] s) {
        int r0 = 31;
    L4:
        if (r0 < 0) goto L11;
        int r2 = s[r0] & 255;
        int r3 = GROUP_ORDER[r0] & 255;
        if (r2 != r3) goto L7;
        r0 = r0 - 1;
        goto L4
    L7:
        if (r2 >= r3) goto L14;
        return true;
    L14:
        return false;
    L11:
        return false;
    }

    public static boolean verify(final byte[] message, final byte[] signature, final byte[] publicKey) throws GeneralSecurityException {
        if (signature.length == 64) goto L5;
        return false;
    L5:
        byte[] r2 = Arrays.copyOfRange(signature, 32, 64);
        if (isSmallerThanGroupOrder(r2) == true) goto L8;
        return false;
    L8:
        MessageDigest r3 = EngineFactory.MESSAGE_DIGEST.getInstance("SHA-512");
        r3.update(signature, 0, 32);
        r3.update(publicKey);
        r3.update(message);
        byte[] r5 = r3.digest();
        reduce(r5);
        byte[] r6 = doubleScalarMultVarTime(r5, XYZT.access$500(publicKey), r2).toBytes();
        int r7 = 0;
    L9:
        if (r7 >= 32) goto L14;
        if (r6[r7] != signature[r7]) goto L12;
        r7 = r7 + 1;
        goto L9
    L12:
        return false;
    L14:
        return true;
    }

    public static void init() {
        if (Ed25519Constants.D == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("Could not initialize Ed25519.");
    }

    private Ed25519() {
    }
}
