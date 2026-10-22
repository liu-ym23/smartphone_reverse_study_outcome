package l.b.g.b.a;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c extends g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f21984f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f21985g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<h> f21986h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<j> f21987i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f21988j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f21989k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private d f21990l;

    private c(int r3, List<h> r4, List<j> r5, long r6, long r8, boolean r10) {
        super(true);
        this.f21989k = 0;
        this.f21984f = r3;
        this.f21986h = Collections.unmodifiableList(r4);
        this.f21987i = Collections.unmodifiableList(r5);
        this.f21989k = r6;
        this.f21988j = r8;
        this.f21985g = r10;
    }

    public static c a(Object r11) {
        if ((r11 instanceof c) == false) goto L7;
        return (c) r11;
    L7:
        if ((r11 instanceof DataInputStream) == false) goto L21;
        DataInputStream r0 = (DataInputStream) r11;
        if (r0.readInt() != 0) goto L19;
        int r3 = r0.readInt();
        long r6 = r0.readLong();
        long r8 = r0.readLong();
        boolean r10 = r0.readBoolean();
        ArrayList r4 = new ArrayList();
        ArrayList r5 = new ArrayList();
        int r1 = 0;
        int r2 = 0;
    L11:
        if (r2 >= r3) goto L14;
        r4.add(h.e(r11));
        r2 = r2 + 1;
    L14:
        if (r1 >= (r3 - 1)) goto L17;
        r5.add(j.a(r11));
        r1 = r1 + 1;
        goto L14
    L17:
        return new c(r3, r4, r5, r6, r8, r10);
    L19:
        throw new IllegalStateException("unknown version for hss private key");
    L21:
        if ((r11 instanceof byte[]) == false) goto L34;
        DataInputStream r7 = null;
        DataInputStream r9 = new DataInputStream(new ByteArrayInputStream((byte[]) r11));     // Catch: Throwable -> L29
        c r12 = a(r9);     // Catch: Throwable -> L27
        r9.close();
        return r12;
    L27:
        th = th;
        r7 = r9;
    L30:
        if (r7 == null) goto L32;
        r7.close();
    L32:
        throw th;
    L29:
        th = th;
        goto L30
    L34:
        if ((r11 instanceof InputStream) == false) goto L38;
        return a(l.b.h.i.a.b((InputStream) r11));
    L38:
        throw new IllegalArgumentException("cannot parse " + r11);
    }

    public static c b(byte[] r0, byte[] r1) {
        c r2 = a(r0);
        r2.f21990l = d.a(r1);
        return r2;
    }

    private static c f(c r2) {
        return a(r2.getEncoded());
    L4:
        e = move-exception;
        throw new RuntimeException(e.getMessage(), e);
    }

    public int c() {
        return this.f21984f;
    }

    protected Object clone() {
        return f(this);
    }

    public synchronized d d() {
        monitor-enter(this);
        d r0 = new d(this.f21984f, e().i());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    h e() {
        return this.f21986h.get(0);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if (r6 != null) goto L8;
    L27:
        return false;
    L8:
        if (c.class != r6.getClass()) goto L27;
        c r7 = (c) r6;
        if (this.f21984f == r7.f21984f) goto L14;
        return false;
    L14:
        if (this.f21985g == r7.f21985g) goto L17;
        return false;
    L17:
        if (this.f21988j == r7.f21988j) goto L20;
        return false;
    L20:
        if (this.f21989k == r7.f21989k) goto L23;
        return false;
    L23:
        if (this.f21986h.equals(r7.f21986h) == true) goto L26;
        return false;
    L26:
        return this.f21987i.equals(r7.f21987i);
    }

    @Override // l.b.g.b.a.g, l.b.h.c
    public synchronized byte[] getEncoded() {
        monitor-enter(this);
        a r0 = a.f();     // Catch: Throwable -> L14
        r0.i(0);     // Catch: Throwable -> L14
        r0.i(this.f21984f);     // Catch: Throwable -> L14
        r0.j(this.f21989k);     // Catch: Throwable -> L14
        r0.j(this.f21988j);     // Catch: Throwable -> L14
        r0.a(this.f21985g);     // Catch: Throwable -> L14
        Iterator<h> r1 = this.f21986h.iterator();     // Catch: Throwable -> L14
    L5:
        if (r1.hasNext() == false) goto L7;
        r0.c(r1.next());     // Catch: Throwable -> L14
        goto L5
    L7:
        Iterator<j> r2 = this.f21987i.iterator();     // Catch: Throwable -> L14
    L9:
        if (r2.hasNext() == false) goto L11;
        r0.c(r2.next());     // Catch: Throwable -> L14
        goto L9
    L11:
        byte[] r3 = r0.b();     // Catch: Throwable -> L14
        monitor-exit(this);
        return r3;
    L14:
        th = move-exception;
        throw th;
    }

    public int hashCode() {
        int r0 = ((((((this.f21984f * 31) + (this.f21985g ? 1 : 0)) * 31) + this.f21986h.hashCode()) * 31) + this.f21987i.hashCode()) * 31;
        long r1 = this.f21988j;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.f21989k;
        return r2 + ((int) (r3 ^ (r3 >>> 32)));
    }
}
