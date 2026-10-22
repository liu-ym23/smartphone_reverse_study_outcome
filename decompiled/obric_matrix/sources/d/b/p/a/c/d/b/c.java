package d.b.p.a.c.d.b;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static c f14218b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d.b.p.a.c.d.a f14219a;

    private c() {
    }

    public static c b() {
        if (f14218b != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f14218b != null) goto L9;
        f14218b = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f14218b;
    }

    public d.b.p.a.c.d.a a() {
        return this.f14219a;
    }

    public void c(d.b.p.a.c.d.a r1) {
        this.f14219a = r1;
    }
}
