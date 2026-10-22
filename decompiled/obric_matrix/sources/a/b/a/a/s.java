package a.b.a.a;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public final class s implements ThreadFactory {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final s f94f = null;

    static {
        f94f = new s();
    }

    public s() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r2) {
        return new Thread(r2, "A-DelayTaskThread");
    }
}
