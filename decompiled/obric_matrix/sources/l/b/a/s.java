package l.b.a;

/* JADX INFO: loaded from: classes2.dex */
public class s extends IllegalStateException {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Throwable f21705f;

    public s(String r1) {
        super(r1);
    }

    public s(String r1, Throwable r2) {
        super(r1);
        this.f21705f = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f21705f;
    }
}
