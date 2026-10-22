package d.b.h.a.a.h.s;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f13737f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f13738g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f13739h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f13740i;

    public b() {
        this(0);
    }

    public b(long r7) {
        this(r7, 0, "");
    }

    public b(long r1, long r3, String r5) {
        this.f13737f = r1;
        this.f13739h = r3;
        this.f13740i = r5;
        if (r3 <= 0) goto L6;
        this.f13738g = true;
        return;
    }

    public b(long r7, String r9) {
        this(r7, 0, r9);
    }

    public final long b() {
        return this.f13737f;
    }

    public final long c() {
        return this.f13739h;
    }

    public final String d() {
        return this.f13740i;
    }

    public final boolean e() {
        return this.f13738g;
    }
}
