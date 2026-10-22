package l.b.e;

/* JADX INFO: loaded from: classes2.dex */
public class d extends Exception {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Throwable f21886f;

    public d(String r1, Throwable r2) {
        super(r1);
        this.f21886f = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f21886f;
    }
}
