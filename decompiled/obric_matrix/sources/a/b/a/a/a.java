package a.b.a.a;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.n0.d.e0;
import kotlin.n0.d.y;
import kotlin.s0.l;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ l[] f4a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final kotlin.h f5b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f6c = null;

    /* JADX INFO: renamed from: a.b.a.a.a$a, reason: collision with other inner class name */
    static final class C0000a extends kotlin.n0.d.q implements kotlin.n0.c.a<ThreadPoolExecutor> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final C0000a f7f = null;

        static {
            f7f = new C0000a();
        }

        public C0000a() {
            super(0);
        }

        @Override // kotlin.n0.c.a
        public ThreadPoolExecutor invoke() {
            return new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), s.f94f);
        }
    }

    static {
        f4a = new l[]{e0.g(new y(e0.b(a.class), "threadPoolExecutor", "getThreadPoolExecutor$initscheduler_release()Ljava/util/concurrent/ThreadPoolExecutor;"))};
        f6c = new a();
        f5b = kotlin.i.b(C0000a.f7f);
    }

    public a() {
    }

    public final ThreadPoolExecutor a() {
        kotlin.h r2 = f5b;
        l r0 = f4a[0];
        return (ThreadPoolExecutor) r2.getValue();
    }
}
