package com.bytedance.memory.g;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5044a = null;

        static {
            int[] r0 = new int[com.bytedance.memory.g.a.values().length];
            f5044a = r0;
            r0[com.bytedance.memory.g.a.f5025h.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            f5044a[com.bytedance.memory.g.a.f5026i.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            f5044a[com.bytedance.memory.g.a.f5027j.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            f5044a[com.bytedance.memory.g.a.f5028k.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            f5044a[com.bytedance.memory.g.a.f5029l.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            f5044a[com.bytedance.memory.g.a.m.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            f5044a[com.bytedance.memory.g.a.n.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            f5044a[com.bytedance.memory.g.a.o.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            f5044a[com.bytedance.memory.g.a.p.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    public static int a(InputStream r4) {
        int r0 = r4.read();
        int r1 = r4.read();
        int r2 = r4.read();
        int r5 = r4.read();
        if ((((r0 | r1) | r2) | r5) < 0) goto L7;
        return (((r0 << 24) + (r1 << 16)) + (r2 << 8)) + r5;
    L7:
        throw new EOFException();
    }

    public static long b(InputStream r6) {
        byte[] r1 = new byte[8];
        d(r6, r1, 0, 8);
        return (((((((((long) r1[0]) << 56) + (((long) (r1[1] & 255)) << 48)) + (((long) (r1[2] & 255)) << 40)) + (((long) (r1[3] & 255)) << 32)) + (((long) (r1[4] & 255)) << 24)) + ((long) ((r1[5] & 255) << 16))) + ((long) ((r1[6] & 255) << 8))) + ((long) (r1[7] & 255));
    }

    public static short c(InputStream r2) {
        int r0 = r2.read();
        int r3 = r2.read();
        if ((r0 | r3) < 0) goto L7;
        return (short) (r3 | (r0 << 8));
    L7:
        throw new EOFException();
    }

    public static void d(InputStream r3, byte[] r4, int r5, long r6) {
        int r7 = 0;
    L3:
        long r0 = r7;
        if (r0 >= r6) goto L10;
        int r1 = r3.read(r4, r7, (int) (r6 - r0));
        if (r1 < 0) goto L9;
        r7 = r7 + r1;
        goto L3
    L9:
        throw new EOFException();
    }

    public static e e(InputStream r3, int r4) {
        byte[] r0 = new byte[r4];
        d(r3, r0, 0, r4);
        return new e(r0);
    }

    public static String f(InputStream r3) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r3.read();
        int r2 = 0;
    L3:
        if (r1 == 0) goto L10;
        r0.append((char) r1);
        r2 = r2 + 1;
        if (r2 > 2048) goto L8;
        r1 = r3.read();
        goto L3
    L8:
        throw new IOException("Bad string data which causes result to be too long.");
    L10:
        return r0.toString();
    }

    public static String g(InputStream r2, long r3) {
        byte[] r0 = new byte[(int) r3];
        d(r2, r0, 0, r3);
        return new String(r0, Charset.forName("UTF-8"));
    }

    public static Object h(InputStream r1, com.bytedance.memory.g.a r2, int r3) {
        switch(a.f5044a[r2.ordinal()]) {
            case 1: goto L27;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L9;
            case 9: goto L7;
            default: goto L4;
        };
    L4:
        return null;
    L7:
        return Long.valueOf(b(r1));
    L9:
        return Integer.valueOf(a(r1));
    L11:
        return Short.valueOf(c(r1));
    L13:
        return Byte.valueOf((byte) r1.read());
    L15:
        return Double.valueOf(Double.longBitsToDouble(b(r1)));
    L17:
        return Float.valueOf(Float.intBitsToFloat(a(r1)));
    L19:
        return Character.valueOf((char) c(r1));
    L21:
        if (r1.read() == 0) goto L23;
        boolean r4 = true;
    L25:
        return Boolean.valueOf(r4);
    L23:
        r4 = false;
        goto L25
    L27:
        return e(r1, r3);
    }

    public static void i(InputStream r7, long r8) {
        long r2 = 0;
    L4:
        if (r2 >= r8) goto L10;
        long r4 = r7.skip(r8 - r2);
        if (r4 < 0) goto L9;
        r2 = r2 + r4;
        goto L4
    L9:
        throw new EOFException();
    }

    public static void j(OutputStream r7, long r8) {
        byte[] r0 = new byte[4096];
        int r2 = 0;
    L4:
        if (r2 >= (r8 >> 12)) goto L6;
        r7.write(r0);
        r2 = r2 + 1;
        goto L4
    L6:
        r7.write(r0, 0, (int) (r8 & 4095));
    }

    public static void k(OutputStream r1, int r2) {
        r1.write((r2 >>> 24) & 255);
        r1.write((r2 >>> 16) & 255);
        r1.write((r2 >>> 8) & 255);
        r1.write(r2 & 255);
    }

    public static void l(OutputStream r6, long r7) {
        r6.write(new byte[]{(byte) (r7 >>> 56), (byte) (r7 >>> 48), (byte) (r7 >>> 40), (byte) (r7 >>> 32), (byte) (r7 >>> 24), (byte) (r7 >>> 16), (byte) (r7 >>> 8), (byte) r7}, 0, 8);
    }

    public static void m(OutputStream r1, int r2) {
        r1.write((r2 >>> 8) & 255);
        r1.write(r2 & 255);
    }

    public static void n(OutputStream r0, e r1) {
        r0.write(r1.a());
    }

    public static void o(OutputStream r2, String r3) {
        byte[] r4 = r3.getBytes(Charset.forName("UTF-8"));
        r2.write(r4, 0, r4.length);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void p(OutputStream r2, Object r3) {
        if (r3 == null) goto L62;
        if ((r3 instanceof e) == false) goto L7;
        n(r2, (e) r3);
        return;
    L7:
        if ((r3 instanceof Boolean) == false) goto L9;
    L58:
        int r4 = ((Boolean) r3).booleanValue();
    L59:
        r2.write(r4);
        return;
    L9:
        if (Boolean.TYPE.isAssignableFrom(r3.getClass()) == true) goto L58;
        if ((r3 instanceof Character) == false) goto L14;
    L56:
        short r5 = ((Character) r3).charValue();
    L57:
        m(r2, r5);
        return;
    L14:
        if (Character.TYPE.isAssignableFrom(r3.getClass()) == true) goto L56;
        if ((r3 instanceof Float) == false) goto L19;
    L54:
        int r6 = Float.floatToRawIntBits(((Float) r3).floatValue());
    L55:
        k(r2, r6);
        return;
    L19:
        if (Float.TYPE.isAssignableFrom(r3.getClass()) == true) goto L54;
        if ((r3 instanceof Double) == false) goto L24;
    L52:
        long r0 = Double.doubleToRawLongBits(((Double) r3).doubleValue());
    L53:
        l(r2, r0);
        return;
    L24:
        if (Double.TYPE.isAssignableFrom(r3.getClass()) == true) goto L52;
        if ((r3 instanceof Byte) == false) goto L29;
    L51:
        r4 = ((Byte) r3).byteValue();
        goto L59
    L29:
        if (Byte.TYPE.isAssignableFrom(r3.getClass()) == true) goto L51;
        if ((r3 instanceof Short) == false) goto L34;
    L50:
        r5 = ((Short) r3).shortValue();
        goto L57
    L34:
        if (Short.TYPE.isAssignableFrom(r3.getClass()) == true) goto L50;
        if ((r3 instanceof Integer) == false) goto L39;
    L49:
        r6 = ((Integer) r3).intValue();
        goto L55
    L39:
        if (Integer.TYPE.isAssignableFrom(r3.getClass()) == true) goto L49;
        if ((r3 instanceof Long) == false) goto L44;
    L48:
        r0 = ((Long) r3).longValue();
        goto L53
    L44:
        if (Long.TYPE.isAssignableFrom(r3.getClass()) == true) goto L48;
        throw new IllegalArgumentException("bad value type: " + r3.getClass().getName());
    L62:
        throw new IllegalArgumentException("value is null.");
    }
}
