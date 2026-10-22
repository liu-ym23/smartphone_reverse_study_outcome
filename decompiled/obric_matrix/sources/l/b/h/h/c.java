package l.b.h.h;

/* JADX INFO: loaded from: classes2.dex */
public class c extends IllegalStateException {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Throwable f22295f;

    c(String r1, Throwable r2) {
        super(r1);
        this.f22295f = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f22295f;
    }
}
