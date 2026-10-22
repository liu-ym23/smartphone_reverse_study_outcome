package l.b.g.b.h;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class a0 {

    private static class a extends ObjectInputStream {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final Set f22090h = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Class f22091f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f22092g;

        static {
            HashSet r0 = new HashSet();
            f22090h = r0;
            r0.add("java.util.TreeMap");
            r0.add("java.lang.Integer");
            r0.add("java.lang.Number");
            r0.add("org.bouncycastle.pqc.crypto.xmss.BDS");
            r0.add("java.util.ArrayList");
            r0.add("org.bouncycastle.pqc.crypto.xmss.XMSSNode");
            r0.add("[B");
            r0.add("java.util.LinkedList");
            r0.add("java.util.Stack");
            r0.add("java.util.Vector");
            r0.add("[Ljava.lang.Object;");
            r0.add("org.bouncycastle.pqc.crypto.xmss.BDSTreeHash");
        }

        a(Class r1, InputStream r2) {
            super(r2);
            this.f22092g = false;
            this.f22091f = r1;
        }

        @Override // java.io.ObjectInputStream
        protected Class<?> resolveClass(ObjectStreamClass r4) {
            if (this.f22092g == true) goto L10;
            if (r4.getName().equals(this.f22091f.getName()) == false) goto L8;
            this.f22092g = true;
        L12:
            return super.resolveClass(r4);
        L8:
            throw new InvalidClassException("unexpected class: ", r4.getName());
        L10:
            if (f22090h.contains(r4.getName()) == true) goto L12;
            throw new InvalidClassException("unexpected class: ", r4.getName());
        }
    }

    public static long a(byte[] r5, int r6, int r7) {
        Objects.requireNonNull(r5, "in == null");
        long r0 = 0;
        int r2 = r6;
    L4:
        if (r2 >= (r6 + r7)) goto L6;
        r0 = (r0 << 8) | ((long) (r5[r2] & 255));
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }

    public static int b(int r3, int r4) {
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L11;
        if (((r3 >> r1) & 1) == 0) goto L8;
        r1 = r1 + 1;
        goto L3
    L8:
        return r1;
    L11:
        return 0;
    }

    public static byte[] c(byte[] r3) {
        Objects.requireNonNull(r3, "in == null");
        byte[] r0 = new byte[r3.length];
        System.arraycopy(r3, 0, r0, 0, r3.length);
        return r0;
    }

    public static byte[][] d(byte[][] r6) {
        if (k(r6) == true) goto L10;
        byte[][] r0 = new byte[r6.length][];
        int r2 = 0;
    L6:
        if (r2 >= r6.length) goto L8;
        r0[r2] = new byte[r6[r2].length];
        System.arraycopy(r6[r2], 0, r0[r2], 0, r6[r2].length);
        r2 = r2 + 1;
        goto L6
    L8:
        return r0;
    L10:
        throw new NullPointerException("in has null pointers");
    }

    public static void e(byte[] r3, byte[] r4, int r5) {
        Objects.requireNonNull(r3, "dst == null");
        Objects.requireNonNull(r4, "src == null");
        if (r5 < 0) goto L14;
        if ((r4.length + r5) > r3.length) goto L12;
        int r0 = 0;
    L8:
        if (r0 >= r4.length) goto L10;
        r3[r5 + r0] = r4[r0];
        r0 = r0 + 1;
        goto L8
    L10:
        return;
    L12:
        throw new IllegalArgumentException("src length + offset must not be greater than size of destination");
    L14:
        throw new IllegalArgumentException("offset hast to be >= 0");
    }

    public static Object f(byte[] r1, Class r2) {
        a r3 = new a(r2, new ByteArrayInputStream(r1));
        Object r0 = r3.readObject();
        if (r3.available() != 0) goto L10;
        if (r2.isInstance(r0) == false) goto L8;
        return r0;
    L8:
        throw new IOException("unexpected class found in ObjectInputStream");
    L10:
        throw new IOException("unexpected data found at end of ObjectInputStream");
    }

    public static byte[] g(byte[] r3, int r4, int r5) {
        Objects.requireNonNull(r3, "src == null");
        if (r4 < 0) goto L16;
        if (r5 < 0) goto L14;
        if ((r4 + r5) > r3.length) goto L12;
        byte[] r0 = new byte[r5];
        int r1 = 0;
    L8:
        if (r1 >= r5) goto L10;
        r0[r1] = r3[r4 + r1];
        r1 = r1 + 1;
        goto L8
    L10:
        return r0;
    L12:
        throw new IllegalArgumentException("offset + length must not be greater then size of source array");
    L14:
        throw new IllegalArgumentException("length hast to be >= 0");
    L16:
        throw new IllegalArgumentException("offset hast to be >= 0");
    }

    public static int h(l.b.b.a r2) {
        Objects.requireNonNull(r2, "digest == null");
        String r0 = r2.e();
        if (r0.equals("SHAKE128") == false) goto L7;
        return 32;
    L7:
        if (r0.equals("SHAKE256") == false) goto L11;
        return 64;
    L11:
        return r2.f();
    }

    public static int i(long r4, int r6) {
        return (int) (r4 & ((1 << r6) - 1));
    }

    public static long j(long r0, int r2) {
        return r0 >> r2;
    }

    public static boolean k(byte[][] r4) {
        if (r4 != null) goto L5;
        return true;
    L5:
        int r2 = 0;
    L7:
        if (r2 >= r4.length) goto L12;
        if (r4[r2] == null) goto L10;
        r2 = r2 + 1;
        goto L7
    L10:
        return true;
    L12:
        return false;
    }

    public static boolean l(int r2, long r3) {
        if (r3 < 0) goto L10;
        if (r3 >= (1 << r2)) goto L7;
        return true;
    L7:
        return false;
    L10:
        throw new IllegalStateException("index must not be negative");
    }

    public static boolean m(long r6, int r8, int r9) {
        if (r6 != 0) goto L6;
        return false;
    L6:
        if (((r6 + 1) % ((long) Math.pow(1 << r8, r9))) == 0) goto L8;
        return false;
    L8:
        return true;
    }

    public static boolean n(long r6, int r8, int r9) {
        if (r6 != 0) goto L6;
        return false;
    L6:
        if ((r6 % ((long) Math.pow(1 << r8, r9 + 1))) == 0) goto L8;
        return false;
    L8:
        return true;
    }

    public static int o(int r1) {
        int r0 = 0;
    L3:
        r1 = r1 >> 1;
        if (r1 == 0) goto L6;
        r0 = r0 + 1;
        goto L3
    L6:
        return r0;
    }

    public static byte[] p(Object r2) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        ObjectOutputStream r1 = new ObjectOutputStream(r0);
        r1.writeObject(r2);
        r1.flush();
        return r0.toByteArray();
    }

    public static byte[] q(long r2, int r4) {
        byte[] r0 = new byte[r4];
        int r5 = r4 - 1;
    L3:
        if (r5 < 0) goto L5;
        r0[r5] = (byte) r2;
        r2 = r2 >>> 8;
        r5 = r5 - 1;
        goto L3
    L5:
        return r0;
    }
}
