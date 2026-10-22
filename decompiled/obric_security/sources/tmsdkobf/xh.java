package tmsdkobf;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes5.dex */
public abstract class xh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f623a = null;
    public static final ExecutorService b = null;

    static {
        f623a = Executors.newFixedThreadPool(5);
        b = Executors.newCachedThreadPool();
    }
}
