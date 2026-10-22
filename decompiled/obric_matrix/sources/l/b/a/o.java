package l.b.a;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public class o extends t {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ConcurrentMap<a, o> f21640h = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f21641f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private byte[] f21642g;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f21643a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final byte[] f21644b;

        a(byte[] r2) {
            this.f21643a = l.b.h.a.j(r2);
            this.f21644b = r2;
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof a) == true) goto L5;
            return false;
        L5:
            return l.b.h.a.a(this.f21644b, ((a) r2).f21644b);
        }

        public int hashCode() {
            return this.f21643a;
        }
    }

    static {
        f21640h = new ConcurrentHashMap();
    }

    public o(String r3) {
        Objects.requireNonNull(r3, "'identifier' cannot be null");
        if (E(r3) == false) goto L7;
        this.f21641f = r3;
        return;
    L7:
        throw new IllegalArgumentException("string " + r3 + " not an OID");
    }

    o(o r2, String r3) {
        if (D(r3, 0) == false) goto L7;
        this.f21641f = r2.A() + "." + r3;
        return;
    L7:
        throw new IllegalArgumentException("string " + r3 + " not a valid OID branch");
    }

    o(byte[] r18) {
        StringBuffer r2 = new StringBuffer();
        boolean r3 = true;
        int r7 = 0;
        long r8 = 0;
        BigInteger r10 = null;
    L4:
        if (r7 == r18.length) goto L29;
        int r11 = r18[r7] & 255;
        if (r8 > 72057594037927808L) goto L20;
        long r9 = r8 + ((long) (r11 & 127));
        if ((r11 & 128) != 0) goto L19;
        if (r3 == true) goto L11;
    L18:
        r2.append('.');
        r2.append(r9);
        r8 = 0;
    L28:
        r7 = r7 + 1;
        goto L4
    L11:
        if (r9 >= 40) goto L14;
        r2.append('0');
    L17:
        r3 = false;
        goto L18
    L14:
        if (r9 >= 80) goto L16;
        r2.append('1');
        r9 = r9 - 40;
        goto L17
    L16:
        r2.append('2');
        r9 = r9 - 80;
        goto L17
    L19:
        r8 = r9 << 7;
        goto L28
    L20:
        if (r10 != null) goto L22;
        r10 = BigInteger.valueOf(r8);
    L22:
        BigInteger r5 = r10.or(BigInteger.valueOf(r11 & 127));
        if ((r11 & 128) != 0) goto L27;
        if (r3 == false) goto L26;
        r2.append('2');
        r5 = r5.subtract(BigInteger.valueOf(80));
        r3 = false;
    L26:
        r2.append('.');
        r2.append(r5);
        r8 = 0;
        r10 = null;
        goto L28
    L27:
        r10 = r5.shiftLeft(7);
        goto L28
    L29:
        this.f21641f = r2.toString();
        this.f21642g = l.b.h.a.d(r18);
    }

    public static o B(Object r3) {
        if (r3 == null) goto L23;
        if ((r3 instanceof o) == true) goto L23;
        if ((r3 instanceof e) == false) goto L13;
        t r0 = ((e) r3).b();
        if ((r0 instanceof o) == false) goto L13;
        return (o) r0;
    L13:
        if ((r3 instanceof byte[]) == false) goto L21;
        return (o) t.s((byte[]) r3);
    L17:
        e = move-exception;
        throw new IllegalArgumentException("failed to construct object identifier from byte[]: " + e.getMessage());
    L21:
        throw new IllegalArgumentException("illegal object in getInstance: " + r3.getClass().getName());
    L23:
        return (o) r3;
    }

    private static boolean D(String r7, int r8) {
        int r0 = r7.length();
    L3:
        int r2 = 0;
    L4:
        r0 = r0 - 1;
        if (r0 < r8) goto L18;
        char r5 = r7.charAt(r0);
        if (r5 == '.') goto L8;
        if ('0' > r5) goto L17;
        if (r5 > '9') goto L17;
        r2 = r2 + 1;
    L17:
        return false;
    L8:
        if (r2 == 0) goto L12;
        if (r2 <= 1) goto L3;
        if (r7.charAt(r0 + 1) != '0') goto L3;
    L12:
        return false;
    L18:
        if (r2 == 0) goto L24;
        if (r2 > 1) goto L21;
    L23:
        return true;
    L21:
        if (r7.charAt(r0 + 1) != '0') goto L23;
    L24:
        return false;
    }

    private static boolean E(String r3) {
        if (r3.length() >= 3) goto L5;
    L14:
        return false;
    L5:
        if (r3.charAt(1) != '.') goto L14;
        char r0 = r3.charAt(0);
        if (r0 < '0') goto L14;
        if (r0 > '2') goto L14;
        return D(r3, 2);
    }

    private void G(ByteArrayOutputStream r5, long r6) {
        byte[] r4 = new byte[9];
        int r1 = 8;
        r4[8] = (byte) (((int) r6) & 127);
    L4:
        if (r6 < 128) goto L6;
        r6 = r6 >> 7;
        r1 = r1 - 1;
        r4[r1] = (byte) ((((int) r6) & 127) | 128);
        goto L4
    L6:
        r5.write(r4, r1, 9 - r1);
    }

    private void H(ByteArrayOutputStream r7, BigInteger r8) {
        int r6 = (r8.bitLength() + 6) / 7;
        if (r6 != 0) goto L5;
        r7.write(0);
        return;
    L5:
        byte[] r2 = new byte[r6];
        int r3 = r6 - 1;
        int r4 = r3;
    L6:
        if (r4 < 0) goto L8;
        r2[r4] = (byte) ((r8.intValue() & 127) | 128);
        r8 = r8.shiftRight(7);
        r4 = r4 - 1;
        goto L6
    L8:
        r2[r3] = (byte) (r2[r3] & 127);
        r7.write(r2, 0, r6);
    }

    private void x(ByteArrayOutputStream r8) {
        b2 r0 = new b2(this.f21641f);
        int r1 = Integer.parseInt(r0.b()) * 40;
        String r2 = r0.b();
        if (r2.length() > 18) goto L5;
        G(r8, ((long) r1) + Long.parseLong(r2));
    L7:
        if (r0.a() == false) goto L12;
        String r3 = r0.b();
        if (r3.length() <= 18) goto L10;
        H(r8, new BigInteger(r3));
        goto L7
    L10:
        G(r8, Long.parseLong(r3));
        goto L7
    L12:
        return;
    L5:
        H(r8, new BigInteger(r2).add(BigInteger.valueOf(r1)));
        goto L7
    }

    static o y(byte[] r2) {
        a r0 = new a(r2);
        o r1 = f21640h.get(r0);
        if (r1 == null) goto L5;
        return r1;
    L5:
        return new o(r2);
    }

    private synchronized byte[] z() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f21642g != null) goto L6;
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();     // Catch: Throwable -> L9
        x(r0);     // Catch: Throwable -> L9
        this.f21642g = r0.toByteArray();     // Catch: Throwable -> L9
    L6:
        byte[] r1 = this.f21642g;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r1;
    }

    public String A() {
        return this.f21641f;
    }

    public o C() {
        a r0 = new a(z());
        ConcurrentMap<a, o> r1 = f21640h;
        o r2 = r1.get(r0);
        if (r2 != null) goto L9;
        o r3 = r1.putIfAbsent(r0, this);
        if (r3 != null) goto L10;
        return this;
    L10:
        return r3;
    L9:
        return r2;
    }

    public boolean F(o r3) {
        String r2 = A();
        String r4 = r3.A();
        if (r2.length() > r4.length()) goto L5;
    L9:
        return false;
    L5:
        if (r2.charAt(r4.length()) != '.') goto L9;
        if (r2.startsWith(r4) == false) goto L9;
        return true;
    }

    @Override // l.b.a.n
    public int hashCode() {
        return this.f21641f.hashCode();
    }

    @Override // l.b.a.t
    boolean n(t r2) {
        if (r2 != this) goto L6;
        return true;
    L6:
        if ((r2 instanceof o) == true) goto L10;
        return false;
    L10:
        return this.f21641f.equals(((o) r2).f21641f);
    }

    @Override // l.b.a.t
    void o(r r2, boolean r3) {
        r2.n(r3, 6, z());
    }

    @Override // l.b.a.t
    int p() {
        int r1 = z().length;
        return (c2.a(r1) + 1) + r1;
    }

    @Override // l.b.a.t
    boolean t() {
        return false;
    }

    public String toString() {
        return A();
    }

    public o w(String r2) {
        return new o(this, r2);
    }
}
