package tmsdkobf;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ti implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicInteger f532a;

    static {
        f532a = new AtomicInteger();
    }

    public ti(String r1) {
        f532a.incrementAndGet();
    }

    protected abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        a();
    }

    public ti() {
        this("");
    }
}
