package l.b.e;

/* JADX INFO: loaded from: classes2.dex */
public class e extends RuntimeException {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Throwable f21887f;

    public e(String r1, Throwable r2) {
        super(r1);
        this.f21887f = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f21887f;
    }
}
