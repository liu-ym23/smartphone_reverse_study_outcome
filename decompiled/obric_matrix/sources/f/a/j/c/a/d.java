package f.a.j.c.a;

/* JADX INFO: loaded from: classes2.dex */
public final class d<T> extends f.a.a<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Throwable f17066f;

    public d(Throwable r1) {
        this.f17066f = r1;
    }

    @Override // f.a.a
    protected void i(f.a.c<? super T> r2) {
        r2.c(f.a.g.c.a());
        r2.onError(this.f17066f);
    }
}
