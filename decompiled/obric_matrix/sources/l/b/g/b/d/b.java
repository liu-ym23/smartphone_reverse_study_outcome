package l.b.g.b.d;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends l.b.b.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f22061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f22062b;

    public b(int r3, byte[] r4) {
        super(false);
        if (r4.length != c.c(r3)) goto L7;
        this.f22061a = r3;
        this.f22062b = l.b.h.a.d(r4);
        return;
    L7:
        throw new IllegalArgumentException("invalid key size for security category");
    }

    public byte[] a() {
        return l.b.h.a.d(this.f22062b);
    }

    public int b() {
        return this.f22061a;
    }
}
