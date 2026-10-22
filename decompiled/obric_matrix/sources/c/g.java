package c;

/* JADX INFO: loaded from: classes.dex */
public class g<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f<TResult> f453a;

    public g() {
        this.f453a = new f();
    }

    public f<TResult> a() {
        return this.f453a;
    }

    public void b() {
        if (e() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cannot cancel a completed task.");
    }

    public void c(Exception r1) {
        if (f(r1) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cannot set the error on a completed task.");
    }

    public void d(TResult r1) {
        if (g(r1) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cannot set the result of a completed task.");
    }

    public boolean e() {
        return this.f453a.p();
    }

    public boolean f(Exception r1) {
        return this.f453a.q(r1);
    }

    public boolean g(TResult r1) {
        return this.f453a.r(r1);
    }
}
