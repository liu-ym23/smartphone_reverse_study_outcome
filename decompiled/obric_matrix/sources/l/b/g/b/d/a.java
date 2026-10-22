package l.b.g.b.d;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends l.b.b.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f22059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f22060b;

    public a(int r3, byte[] r4) {
        super(true);
        if (r4.length != c.b(r3)) goto L7;
        this.f22059a = r3;
        this.f22060b = l.b.h.a.d(r4);
        return;
    L7:
        throw new IllegalArgumentException("invalid key size for security category");
    }

    public byte[] a() {
        return l.b.h.a.d(this.f22060b);
    }

    public int b() {
        return this.f22059a;
    }
}
