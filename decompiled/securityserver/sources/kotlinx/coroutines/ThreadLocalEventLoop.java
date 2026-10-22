package kotlinx.coroutines;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ThreadLocalEventLoop {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f379a = null;

    static {
        f379a = new ThreadLocal();
    }

    public static EventLoop a() {
        ThreadLocal r0 = f379a;
        EventLoop r1 = (EventLoop) r0.get();
        if (r1 != null) goto L7;
        BlockingEventLoop r2 = new BlockingEventLoop(Thread.currentThread());
        r0.set(r2);
        return r2;
    L7:
        return r1;
    }
}
