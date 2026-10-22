package kotlin.s0.w.d.l0.i;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
class p extends d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected final byte[] f20369g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f20370h;

    static /* synthetic */ class a {
    }

    private class b implements d.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f20371f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f20372g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ p f20373h;

        private b(p r2) {
            this.f20373h = r2;
            this.f20371f = 0;
            this.f20372g = r2.size();
        }

        /* synthetic */ b(p r1, a r2) {
            this(r1);
        }

        @Override // kotlin.s0.w.d.l0.i.d.a
        public byte a() {
            byte[] r0 = this.f20373h.f20369g;     // Catch: ArrayIndexOutOfBoundsException -> L4
            int r1 = this.f20371f;     // Catch: ArrayIndexOutOfBoundsException -> L4
            this.f20371f = r1 + 1;     // Catch: ArrayIndexOutOfBoundsException -> L4
            return r0[r1];
        L4:
            e = move-exception;
            throw new NoSuchElementException(e.getMessage());
        }

        public Byte b() {
            return Byte.valueOf(a());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f20371f >= this.f20372g) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Byte next() {
            return b();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    p(byte[] r2) {
        this.f20370h = 0;
        this.f20369g = r2;
    }

    static int F(int r2, byte[] r3, int r4, int r5) {
        int r0 = r4;
    L4:
        if (r0 >= (r4 + r5)) goto L6;
        r2 = (r2 * 31) + r3[r0];
        r0 = r0 + 1;
        goto L4
    L6:
        return r2;
    }

    @Override // kotlin.s0.w.d.l0.i.d
    void B(OutputStream r2, int r3, int r4) {
        r2.write(this.f20369g, E() + r3, r4);
    }

    public byte C(int r1) {
        return this.f20369g[r1];
    }

    boolean D(p r4, int r5, int r6) {
        if (r6 <= r4.size()) goto L5;
        int r3 = size();
        StringBuilder r7 = new StringBuilder(40);
        r7.append("Length too large: ");
        r7.append(r6);
        r7.append(r3);
        throw new IllegalArgumentException(r7.toString());
    L5:
        if ((r5 + r6) > r4.size()) goto L15;
        byte[] r0 = this.f20369g;
        byte[] r1 = r4.f20369g;
        int r2 = E() + r6;
        int r8 = E();
        int r9 = r4.E() + r5;
    L7:
        if (r8 >= r2) goto L13;
        if (r0[r8] != r1[r9]) goto L10;
        r8 = r8 + 1;
        r9 = r9 + 1;
        goto L7
    L10:
        return false;
    L13:
        return true;
    L15:
        int r10 = r4.size();
        StringBuilder r11 = new StringBuilder(59);
        r11.append("Ran off end of other: ");
        r11.append(r5);
        r11.append(", ");
        r11.append(r6);
        r11.append(", ");
        r11.append(r10);
        throw new IllegalArgumentException(r11.toString());
    }

    protected int E() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L9;
        return false;
    L9:
        if (size() == ((d) r5).size()) goto L12;
        return false;
    L12:
        if (size() != 0) goto L15;
        return true;
    L15:
        if ((r5 instanceof p) == false) goto L19;
        return D((p) r5, 0, size());
    L19:
        if ((r5 instanceof u) == true) goto L21;
        String r6 = String.valueOf(String.valueOf(r5.getClass()));
        StringBuilder r0 = new StringBuilder(r6.length() + 49);
        r0.append("Has a new type of ByteString been created? Found ");
        r0.append(r6);
        throw new IllegalArgumentException(r0.toString());
    L21:
        return r5.equals(this);
    }

    public int hashCode() {
        int r0 = this.f20370h;
        if (r0 != 0) goto L8;
        int r1 = size();
        r0 = u(r1, 0, r1);
        if (r0 != 0) goto L7;
        r0 = 1;
    L7:
        this.f20370h = r0;
    L8:
        return r0;
    }

    @Override // kotlin.s0.w.d.l0.i.d, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
        return r();
    }

    @Override // kotlin.s0.w.d.l0.i.d
    protected void n(byte[] r1, int r2, int r3, int r4) {
        System.arraycopy(this.f20369g, r2, r1, r3, r4);
    }

    @Override // kotlin.s0.w.d.l0.i.d
    protected int o() {
        return 0;
    }

    @Override // kotlin.s0.w.d.l0.i.d
    protected boolean p() {
        return true;
    }

    @Override // kotlin.s0.w.d.l0.i.d
    public boolean q() {
        int r0 = E();
        return y.f(this.f20369g, r0, size() + r0);
    }

    @Override // kotlin.s0.w.d.l0.i.d
    public d.a r() {
        return new b(this, null);
    }

    @Override // kotlin.s0.w.d.l0.i.d
    public e s() {
        return e.h(this);
    }

    @Override // kotlin.s0.w.d.l0.i.d
    public int size() {
        return this.f20369g.length;
    }

    @Override // kotlin.s0.w.d.l0.i.d
    protected int u(int r2, int r3, int r4) {
        return F(r2, this.f20369g, E() + r3, r4);
    }

    @Override // kotlin.s0.w.d.l0.i.d
    protected int v(int r2, int r3, int r4) {
        int r0 = E() + r3;
        return y.g(r2, this.f20369g, r0, r4 + r0);
    }

    @Override // kotlin.s0.w.d.l0.i.d
    protected int w() {
        return this.f20370h;
    }

    @Override // kotlin.s0.w.d.l0.i.d
    public String y(String r4) {
        return new String(this.f20369g, E(), size(), r4);
    }
}
