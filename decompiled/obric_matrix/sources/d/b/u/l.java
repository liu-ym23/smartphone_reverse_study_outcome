package d.b.u;

/* JADX INFO: loaded from: classes.dex */
public abstract class l<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile T f15056a;

    public l() {
    }

    protected abstract T a(Object... r1);

    public final T b(Object... r2) {
        if (this.f15056a != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f15056a != null) goto L8;
        this.f15056a = a(r2);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f15056a;
    }
}
