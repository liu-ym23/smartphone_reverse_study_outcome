package kotlin.s0.w.d.l0.i;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
class c extends p {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f20300i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f20301j;

    static /* synthetic */ class a {
    }

    private class b implements d.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f20302f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f20303g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ c f20304h;

        private b(c r2) {
            this.f20304h = r2;
            int r0 = r2.E();
            this.f20302f = r0;
            this.f20303g = r0 + r2.size();
        }

        /* synthetic */ b(c r1, a r2) {
            this(r1);
        }

        @Override // kotlin.s0.w.d.l0.i.d.a
        public byte a() {
            int r0 = this.f20302f;
            if (r0 >= this.f20303g) goto L7;
            byte[] r1 = this.f20304h.f20369g;
            this.f20302f = r0 + 1;
            return r1[r0];
        L7:
            throw new NoSuchElementException();
        }

        public Byte b() {
            return Byte.valueOf(a());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f20302f >= this.f20303g) goto L5;
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

    c(byte[] r5, int r6, int r7) {
        super(r5);
        if (r6 < 0) goto L13;
        if (r7 >= 0) goto L6;
        StringBuilder r8 = new StringBuilder(29);
        r8.append("Length too small: ");
        r8.append(r6);
        throw new IllegalArgumentException(r8.toString());
    L6:
        if ((((long) r6) + ((long) r7)) > r5.length) goto L9;
        this.f20300i = r6;
        this.f20301j = r7;
        return;
    L9:
        StringBuilder r9 = new StringBuilder(48);
        r9.append("Offset+Length too large: ");
        r9.append(r6);
        r9.append("+");
        r9.append(r7);
        throw new IllegalArgumentException(r9.toString());
    L13:
        StringBuilder r10 = new StringBuilder(29);
        r10.append("Offset too small: ");
        r10.append(r6);
        throw new IllegalArgumentException(r10.toString());
    }

    @Override // kotlin.s0.w.d.l0.i.p
    public byte C(int r4) {
        if (r4 >= 0) goto L4;
        StringBuilder r0 = new StringBuilder(28);
        r0.append("Index too small: ");
        r0.append(r4);
        throw new ArrayIndexOutOfBoundsException(r0.toString());
    L4:
        if (r4 < size()) goto L6;
        int r3 = size();
        StringBuilder r1 = new StringBuilder(41);
        r1.append("Index too large: ");
        r1.append(r4);
        r1.append(", ");
        r1.append(r3);
        throw new ArrayIndexOutOfBoundsException(r1.toString());
    L6:
        return this.f20369g[this.f20300i + r4];
    }

    @Override // kotlin.s0.w.d.l0.i.p
    protected int E() {
        return this.f20300i;
    }

    @Override // kotlin.s0.w.d.l0.i.p, kotlin.s0.w.d.l0.i.d, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
        return r();
    }

    @Override // kotlin.s0.w.d.l0.i.p, kotlin.s0.w.d.l0.i.d
    protected void n(byte[] r2, int r3, int r4, int r5) {
        System.arraycopy(this.f20369g, E() + r3, r2, r4, r5);
    }

    @Override // kotlin.s0.w.d.l0.i.p, kotlin.s0.w.d.l0.i.d
    public d.a r() {
        return new b(this, null);
    }

    @Override // kotlin.s0.w.d.l0.i.p, kotlin.s0.w.d.l0.i.d
    public int size() {
        return this.f20301j;
    }
}
