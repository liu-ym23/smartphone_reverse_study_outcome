package okhttp3.internal;

/* JADX INFO: loaded from: classes5.dex */
public abstract class NamedRunnable implements Runnable {
    protected final String name;

    protected abstract void execute();

    public NamedRunnable(String r1, Object... r2) {
        this.name = Util.format(r1, r2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r0 = Thread.currentThread().getName();
        Thread.currentThread().setName(this.name);
        execute();     // Catch: Throwable -> L6
        Thread.currentThread().setName(r0);
        return;
    L6:
        th = move-exception;
        Thread.currentThread().setName(r0);
        throw th;
    }
}
