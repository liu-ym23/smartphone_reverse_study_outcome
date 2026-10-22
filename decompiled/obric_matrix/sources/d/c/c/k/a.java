package d.c.c.k;

/* JADX INFO: loaded from: classes.dex */
public class a extends Exception {
    public a(String r1) {
        super(r1);
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        monitor-enter(this);
        monitor-exit(this);
        return this;
    }
}
