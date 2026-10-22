package com.bytedance.bdinstall.d1;

/* JADX INFO: loaded from: classes.dex */
public abstract class n<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile T f2738a;

    public n() {
    }

    protected abstract T a(Object... r1);

    public final T b(Object... r2) {
        if (this.f2738a != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f2738a != null) goto L8;
        this.f2738a = a(r2);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f2738a;
    }
}
