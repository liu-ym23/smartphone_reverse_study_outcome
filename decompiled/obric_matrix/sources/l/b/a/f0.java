package l.b.a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public class f0 extends p {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f21559g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final p[] f21560h;

    class a implements Enumeration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ f0 f21562b;

        a(f0 r1) {
            this.f21562b = r1;
            this.f21561a = 0;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            if (this.f21561a >= this.f21562b.f21659f.length) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            int r0 = this.f21561a;
            f0 r1 = this.f21562b;
            byte[] r2 = r1.f21659f;
            if (r0 >= r2.length) goto L7;
            int r3 = Math.min(r2.length - r0, f0.z(r1));
            byte[] r4 = new byte[r3];
            System.arraycopy(this.f21562b.f21659f, this.f21561a, r4, 0, r3);
            this.f21561a += r3;
            return new y0(r4);
        L7:
            throw new NoSuchElementException();
        }
    }

    class b implements Enumeration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21563a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ f0 f21564b;

        b(f0 r1) {
            this.f21564b = r1;
            this.f21563a = 0;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            if (this.f21563a >= f0.A(this.f21564b).length) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            if (this.f21563a >= f0.A(this.f21564b).length) goto L7;
            p[] r0 = f0.A(this.f21564b);
            int r1 = this.f21563a;
            this.f21563a = r1 + 1;
            return r0[r1];
        L7:
            throw new NoSuchElementException();
        }
    }

    public f0(byte[] r2) {
        this(r2, 1000);
    }

    public f0(byte[] r2, int r3) {
        this(r2, null, r3);
    }

    private f0(byte[] r1, p[] r2, int r3) {
        super(r1);
        this.f21560h = r2;
        this.f21559g = r3;
    }

    public f0(p[] r2) {
        this(r2, 1000);
    }

    public f0(p[] r2, int r3) {
        this(D(r2), r2, r3);
    }

    static /* synthetic */ p[] A(f0 r0) {
        return r0.f21560h;
    }

    static f0 B(u r4) {
        int r0 = r4.size();
        p[] r1 = new p[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L6;
        r1[r2] = p.w(r4.y(r2));
        r2 = r2 + 1;
        goto L3
    L6:
        return new f0(r1);
    }

    private static byte[] D(p[] r3) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        int r1 = 0;
    L4:
        if (r1 == r3.length) goto L11;
        r0.write(r3[r1].y());     // Catch: IOException -> L7
        r1 = r1 + 1;
    L7:
        e = move-exception;
        throw new IllegalArgumentException("exception converting octets " + e.toString());
    L11:
        return r0.toByteArray();
    }

    static /* synthetic */ int z(f0 r0) {
        return r0.f21559g;
    }

    public Enumeration C() {
        if (this.f21560h != null) goto L7;
        return new a(this);
    L7:
        return new b(this);
    }

    @Override // l.b.a.t
    void o(r r2, boolean r3) {
        r2.p(r3, 36, C());
    }

    @Override // l.b.a.t
    int p() {
        Enumeration r2 = C();
        int r0 = 0;
    L4:
        if (r2.hasMoreElements() == false) goto L7;
        r0 = r0 + ((e) r2.nextElement()).b().p();
        goto L4
    L7:
        return (r0 + 2) + 2;
    }

    @Override // l.b.a.t
    boolean t() {
        return true;
    }
}
