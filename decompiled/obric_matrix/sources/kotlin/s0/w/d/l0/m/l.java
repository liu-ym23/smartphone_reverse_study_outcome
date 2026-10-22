package kotlin.s0.w.d.l0.m;

/* JADX INFO: loaded from: classes2.dex */
class l<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f20937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Thread f20938b;

    l(T r1) {
        this.f20937a = r1;
        this.f20938b = Thread.currentThread();
    }

    public T a() {
        if (b() == false) goto L7;
        return this.f20937a;
    L7:
        throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
    }

    public boolean b() {
        if (this.f20938b != Thread.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }
}
