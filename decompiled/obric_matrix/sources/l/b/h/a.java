package l.b.h;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: l.b.h.a$a, reason: collision with other inner class name */
    public static class C0598a<T> implements Iterator<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final T[] f22283f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f22284g;

        public C0598a(T[] r2) {
            this.f22284g = 0;
            this.f22283f = r2;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f22284g >= this.f22283f.length) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            int r0 = this.f22284g;
            T[] r1 = this.f22283f;
            if (r0 == r1.length) goto L7;
            this.f22284g = r0 + 1;
            return r1[r0];
        L7:
            throw new NoSuchElementException("Out of elements: " + this.f22284g);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Cannot remove element from an Array.");
        }
    }

    public static boolean a(byte[] r0, byte[] r1) {
        return Arrays.equals(r0, r1);
    }

    public static boolean b(char[] r0, char[] r1) {
        return Arrays.equals(r0, r1);
    }

    public static boolean c(short[] r0, short[] r1) {
        return Arrays.equals(r0, r1);
    }

    public static byte[] d(byte[] r0) {
        if (r0 != null) goto L5;
        return null;
    L5:
        return (byte[]) r0.clone();
    }

    public static short[] e(short[] r0) {
        if (r0 != null) goto L5;
        return null;
    L5:
        return (short[]) r0.clone();
    }

    public static byte[] f(byte[] r3, byte[] r4) {
        if (r3 == null) goto L4;
        if (r4 == null) goto L7;
        byte[] r0 = new byte[r3.length + r4.length];
        System.arraycopy(r3, 0, r0, 0, r3.length);
        System.arraycopy(r4, 0, r0, r3.length, r4.length);
        return r0;
    L7:
        return d(r3);
    L4:
        return d(r4);
    }

    public static byte[] g(byte[] r2, int r3, int r4) {
        int r5 = i(r3, r4);
        byte[] r0 = new byte[r5];
        System.arraycopy(r2, r3, r0, 0, Math.min(r2.length - r3, r5));
        return r0;
    }

    public static void h(byte[] r0, byte r1) {
        Arrays.fill(r0, r1);
    }

    private static int i(int r1, int r2) {
        int r0 = r2 - r1;
        if (r0 < 0) goto L5;
        return r0;
    L5:
        StringBuffer r3 = new StringBuffer(r1);
        r3.append(" > ");
        r3.append(r2);
        throw new IllegalArgumentException(r3.toString());
    }

    public static int j(byte[] r3) {
        if (r3 != null) goto L5;
        return 0;
    L5:
        int r0 = r3.length;
        int r1 = r0 + 1;
    L6:
        r0 = r0 - 1;
        if (r0 < 0) goto L9;
        r1 = (r1 * 257) ^ r3[r0];
        goto L6
    L9:
        return r1;
    }

    public static int k(byte[] r2, int r3, int r4) {
        if (r2 != null) goto L5;
        return 0;
    L5:
        int r0 = r4 + 1;
    L6:
        r4 = r4 - 1;
        if (r4 < 0) goto L9;
        r0 = (r0 * 257) ^ r2[r3 + r4];
        goto L6
    L9:
        return r0;
    }

    public static int l(char[] r3) {
        if (r3 != null) goto L5;
        return 0;
    L5:
        int r0 = r3.length;
        int r1 = r0 + 1;
    L6:
        r0 = r0 - 1;
        if (r0 < 0) goto L9;
        r1 = (r1 * 257) ^ r3[r0];
        goto L6
    L9:
        return r1;
    }

    public static int m(int[] r3) {
        if (r3 != null) goto L5;
        return 0;
    L5:
        int r0 = r3.length;
        int r1 = r0 + 1;
    L6:
        r0 = r0 - 1;
        if (r0 < 0) goto L9;
        r1 = (r1 * 257) ^ r3[r0];
        goto L6
    L9:
        return r1;
    }

    public static int n(short[] r3) {
        if (r3 != null) goto L5;
        return 0;
    L5:
        int r0 = r3.length;
        int r1 = r0 + 1;
    L6:
        r0 = r0 - 1;
        if (r0 < 0) goto L9;
        r1 = (r1 * 257) ^ (r3[r0] & 255);
        goto L6
    L9:
        return r1;
    }

    public static int o(short[][] r3) {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 == r3.length) goto L6;
        r1 = (r1 * 257) + n(r3[r0]);
        r0 = r0 + 1;
        goto L4
    L6:
        return r1;
    }

    public static int p(short[][][] r3) {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 == r3.length) goto L6;
        r1 = (r1 * 257) + o(r3[r0]);
        r0 = r0 + 1;
        goto L4
    L6:
        return r1;
    }

    public static boolean q(Object[] r5) {
        if (r5 != null) goto L5;
        return true;
    L5:
        int r1 = r5.length;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L11;
        if (r5[r3] == null) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        return true;
    L11:
        return false;
    }
}
