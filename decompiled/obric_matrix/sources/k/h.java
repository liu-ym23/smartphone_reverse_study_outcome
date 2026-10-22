package k;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class h implements Serializable, Comparable<h> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final h f18266i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f18267j = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient int f18268f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient String f18269g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final byte[] f18270h;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final h a(String r6) {
            kotlin.n0.d.o.g(r6, "$this$decodeHex");
            int r0 = 0;
            if ((r6.length() % 2) != 0) goto L5;
            boolean r5 = true;
        L6:
            if (r5 == false) goto L13;
            int r7 = r6.length() / 2;
            byte[] r2 = new byte[r7];
        L8:
            if (r0 >= r7) goto L11;
            int r3 = r0 * 2;
            r2[r0] = (byte) ((k.c0.b.b(r6.charAt(r3)) << 4) + k.c0.b.b(r6.charAt(r3 + 1)));
            r0 = r0 + 1;
            goto L8
        L11:
            return new h(r2);
        L13:
            throw new IllegalArgumentException(("Unexpected hex string: " + r6).toString());
        L5:
            r5 = false;
            goto L6
        }

        public final h b(String r1, Charset r2) {
            kotlin.n0.d.o.g(r1, "$this$encode");
            kotlin.n0.d.o.g(r2, "charset");
            byte[] r0 = r1.getBytes(r2);
            kotlin.n0.d.o.b(r0, "(this as java.lang.String).getBytes(charset)");
            return new h(r0);
        }

        public final h c(String r2) {
            kotlin.n0.d.o.g(r2, "$this$encodeUtf8");
            h r1 = new h(b.a(r2));
            r1.z(r2);
            return r1;
        }

        public final h d(byte... r1) {
            kotlin.n0.d.o.g(r1, "data");
            byte[] r0 = Arrays.copyOf(r1, r1.length);
            kotlin.n0.d.o.b(r0, "java.util.Arrays.copyOf(this, size)");
            return new h(r0);
        }

        public final h e(byte[] r7, int r8, int r9) {
            kotlin.n0.d.o.g(r7, "$this$toByteString");
            c.b(r7.length, r8, r9);
            return new h(kotlin.i0.i.i(r7, r8, r9 + r8));
        }
    }

    static {
        f18267j = new a(null);
        f18266i = new h(new byte[0]);
    }

    public h(byte[] r2) {
        kotlin.n0.d.o.g(r2, "data");
        this.f18270h = r2;
    }

    public static final h c(String r1) {
        return f18267j.a(r1);
    }

    public static final h j(String r1, Charset r2) {
        return f18267j.b(r1, r2);
    }

    public static final h k(String r1) {
        return f18267j.c(r1);
    }

    public static final h u(byte... r1) {
        return f18267j.d(r1);
    }

    public static final h v(byte[] r1, int r2, int r3) {
        return f18267j.e(r1, r2, r3);
    }

    public h A() {
        return g("SHA-1");
    }

    public h B() {
        return g("SHA-256");
    }

    public final boolean C(h r3) {
        kotlin.n0.d.o.g(r3, "prefix");
        return w(0, r3, 0, r3.size());
    }

    public h D() {
        int r0 = 0;
    L4:
        if (r0 >= m().length) goto L30;
        byte r1 = m()[r0];
        byte r2 = (byte) 65;
        if (r1 < r2) goto L20;
        byte r3 = (byte) 90;
        if (r1 > r3) goto L20;
        byte[] r5 = m();
        byte[] r6 = Arrays.copyOf(r5, r5.length);
        kotlin.n0.d.o.b(r6, "java.util.Arrays.copyOf(this, size)");
        int r4 = r0 + 1;
        r6[r0] = (byte) (r1 + 32);
    L12:
        if (r4 >= r6.length) goto L21;
        byte r7 = r6[r4];
        if (r7 < r2) goto L18;
        if (r7 > r3) goto L18;
        r6[r4] = (byte) (r7 + 32);
    L18:
        r4 = r4 + 1;
        goto L12
    L21:
        return new h(r6);
    L20:
        r0 = r0 + 1;
        goto L4
    L30:
        return this;
    }

    public byte[] E() {
        byte[] r1 = m();
        byte[] r2 = Arrays.copyOf(r1, r1.length);
        kotlin.n0.d.o.b(r2, "java.util.Arrays.copyOf(this, size)");
        return r2;
    }

    public String F() {
        String r0 = p();
        if (r0 != null) goto L6;
        String r1 = b.b(r());
        z(r1);
        return r1;
    L6:
        return r0;
    }

    public void G(e r2, int r3, int r4) {
        kotlin.n0.d.o.g(r2, "buffer");
        k.c0.b.d(this, r2, r3, r4);
    }

    public String a() {
        return k.a.b(m(), null, 1, null);
    }

    public int b(h r10) {
        kotlin.n0.d.o.g(r10, "other");
        int r0 = size();
        int r1 = r10.size();
        int r2 = Math.min(r0, r1);
        int r4 = 0;
    L4:
        if (r4 >= r2) goto L10;
        int r7 = l(r4) & 255;
        int r8 = r10.l(r4) & 255;
        if (r7 != r8) goto L8;
        r4 = r4 + 1;
        goto L4
    L8:
        if (r7 < r8) goto L18;
    L15:
        return 1;
    L18:
        return -1;
    L10:
        if (r0 == r1) goto L19;
        if (r0 >= r1) goto L15;
    L19:
        return 0;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(h r1) {
        return b(r1);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == false) goto L13;
        h r6 = (h) r5;
        if (r6.size() != m().length) goto L13;
        if (r6.x(0, m(), 0, m().length) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public h g(String r2) {
        kotlin.n0.d.o.g(r2, "algorithm");
        byte[] r1 = MessageDigest.getInstance(r2).digest(this.f18270h);
        kotlin.n0.d.o.b(r1, "MessageDigest.getInstance(algorithm).digest(data)");
        return new h(r1);
    }

    public int hashCode() {
        int r0 = n();
        if (r0 != 0) goto L7;
        int r1 = Arrays.hashCode(m());
        y(r1);
        return r1;
    L7:
        return r0;
    }

    public final byte l(int r1) {
        return s(r1);
    }

    public final byte[] m() {
        return this.f18270h;
    }

    public final int n() {
        return this.f18268f;
    }

    public int o() {
        return m().length;
    }

    public final String p() {
        return this.f18269g;
    }

    public String q() {
        char[] r0 = new char[m().length * 2];
        byte[] r8 = m();
        int r1 = r8.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L6;
        byte r4 = r8[r2];
        int r5 = r3 + 1;
        r0[r3] = k.c0.b.f()[(r4 >> 4) & 15];
        r3 = r5 + 1;
        r0[r5] = k.c0.b.f()[r4 & 15];
        r2 = r2 + 1;
        goto L3
    L6:
        return new String(r0);
    }

    public byte[] r() {
        return m();
    }

    public byte s(int r1) {
        return m()[r1];
    }

    public final int size() {
        return o();
    }

    public h t() {
        return g("MD5");
    }

    public String toString() {
        boolean r1 = true;
        if (m().length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return "[size=0]";
    L8:
        int r2 = k.c0.b.a(m(), 64);
        if (r2 == (-1)) goto L11;
        String r3 = F();
        if (r3 == null) goto L36;
        String r8 = r3.substring(0, r2);
        kotlin.n0.d.o.b(r8, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String r4 = kotlin.u0.k.w(kotlin.u0.k.w(kotlin.u0.k.w(r8, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
        if (r2 >= r3.length()) goto L33;
        StringBuilder r5 = new StringBuilder();
        r5.append("[size=");
        r5.append(m().length);
        r5.append(" text=");
        r5.append(r4);
    L25:
        r5.append("…]");
    L37:
        return r5.toString();
    L33:
        r5 = new StringBuilder();
        r5.append("[text=");
        r5.append(r4);
    L13:
        r5.append(']');
        goto L37
    L36:
        throw new kotlin.b0("null cannot be cast to non-null type java.lang.String");
    L11:
        if (m().length > 64) goto L15;
        r5 = new StringBuilder();
        r5.append("[hex=");
        r5.append(q());
        goto L13
    L15:
        r5 = new StringBuilder();
        r5.append("[size=");
        r5.append(m().length);
        r5.append(" hex=");
        if (64 <= m().length) goto L19;
        r1 = false;
    L19:
        if (r1 == false) goto L27;
        if (64 != m().length) goto L23;
        h r6 = this;
    L24:
        r5.append(r6.q());
        goto L25
    L23:
        r6 = new h(kotlin.i0.i.i(m(), 0, 64));
        goto L24
    L27:
        throw new IllegalArgumentException(("endIndex > length(" + m().length + ')').toString());
    L5:
        r0 = false;
        goto L6
    }

    public boolean w(int r2, h r3, int r4, int r5) {
        kotlin.n0.d.o.g(r3, "other");
        return r3.x(r4, m(), r2, r5);
    }

    public boolean x(int r2, byte[] r3, int r4, int r5) {
        kotlin.n0.d.o.g(r3, "other");
        if (r2 >= 0) goto L5;
    L12:
        return false;
    L5:
        if (r2 > (m().length - r5)) goto L12;
        if (r4 < 0) goto L12;
        if (r4 > (r3.length - r5)) goto L12;
        if (c.a(m(), r2, r3, r4, r5) == false) goto L12;
        return true;
    }

    public final void y(int r1) {
        this.f18268f = r1;
    }

    public final void z(String r1) {
        this.f18269g = r1;
    }
}
