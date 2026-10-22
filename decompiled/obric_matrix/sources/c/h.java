package c;

/* JADX INFO: loaded from: classes.dex */
class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f<?> f454a;

    public h(f<?> r1) {
        this.f454a = r1;
    }

    public void a() {
        this.f454a = null;
    }

    protected void finalize() {
        f<?> r0 = this.f454a;     // Catch: Throwable -> L9
        if (r0 == null) goto L7;
        f.d r1 = f.k();     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.a(r0, new i(r0.i()));     // Catch: Throwable -> L9
    L7:
        super.finalize();
        return;
    L9:
        th = move-exception;
        super.finalize();
        throw th;
    }
}
