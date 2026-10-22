package d.b.s.a.l0;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public abstract class j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f14856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f14857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile T f14858c;

    public j() {
        this.f14856a = false;
        this.f14857b = false;
    }

    private T d() {
        if (this.f14857b == true) goto L20;
        if (this.f14856a == true) goto L20;
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L9:
        if (this.f14857b == false) goto L13;
        T r0 = this.f14858c;     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        return r0;
    L13:
        this.f14858c = b();     // Catch: Throwable -> L16
        this.f14857b = true;     // Catch: Throwable -> L16
        T r1 = this.f14858c;     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        return r1;
    L20:
        return this.f14858c;
    }

    public T a() {
        if (this.f14858c == null) goto L7;
        return this.f14858c;
    L7:
        return d();
    }

    @NonNull
    protected abstract T b();

    public void c(T r1) {
        this.f14858c = r1;
        this.f14856a = true;
    }
}
