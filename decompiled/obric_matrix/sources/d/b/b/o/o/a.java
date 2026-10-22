package d.b.b.o.o;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f13058f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f13059g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f13060h;

    public a() {
        this(0);
    }

    public a(long r3) {
        this(r3, 0);
    }

    public a(long r1, long r3) {
        this.f13058f = r1;
        this.f13060h = r3;
        if (r3 <= 0) goto L6;
        this.f13059g = true;
        return;
    }

    public long b() {
        return this.f13058f;
    }

    public final long c() {
        return this.f13060h;
    }

    public final boolean d() {
        return this.f13059g;
    }

    public void e(long r1, long r3) {
        this.f13058f = r1;
        this.f13060h = r3;
        if (r3 <= 0) goto L6;
        this.f13059g = true;
        return;
    }
}
