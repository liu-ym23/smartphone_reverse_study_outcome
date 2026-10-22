package tmsdkobf;

/* JADX INFO: loaded from: classes5.dex */
public abstract class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f495a;

    public s0() {
    }

    public abstract Object a();

    public final Object b() {
        Object r0 = this.f495a;
        if (r0 != null) goto L13;
        monitor-enter(this);
        r0 = this.f495a;     // Catch: Throwable -> L10
        if (r0 != null) goto L8;
        r0 = a();     // Catch: Throwable -> L10
        this.f495a = r0;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L13:
        return r0;
    }
}
