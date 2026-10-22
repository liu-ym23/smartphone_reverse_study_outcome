package d.b.h.a.a.g;

import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
class f implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static AtomicInteger f13312l;
    static f m;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private WeakHandler f13313f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ThreadPoolExecutor f13314g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ThreadPoolExecutor f13315h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ThreadPoolExecutor f13316i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ThreadPoolExecutor f13317j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ThreadPoolExecutor f13318k;

    class a extends b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d.b.h.a.a.g.c f13319g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ f f13320h;

        a(f r1, d.b.h.a.a.g.c r2, d.b.h.a.a.g.c r3) {
            this.f13320h = r1;
            this.f13319g = r3;
            super(r1, r2);
        }

        public int b(b r1) {
            d.b.h.a.a.g.c r0 = this.f13319g;
            if (r0 != null) goto L5;
            return 0;
        L5:
            return r0.compareTo(b.a(r1));
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(b r1) {
            return b(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f13319g.l() == false) goto L5;
            return;
        L5:
            if (this.f13319g.b() != d.a.f13310j) goto L7;
            ExecutorService r0 = f.a(this.f13320h);
        L8:
            r0.execute(this.f13319g);
            return;
        L7:
            r0 = f.b(this.f13320h);
            goto L8
        }
    }

    abstract class b implements Runnable, Comparable<b> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private d.b.h.a.a.g.c f13321f;

        public b(f r1, d.b.h.a.a.g.c r2) {
            this.f13321f = r2;
        }

        static /* synthetic */ d.b.h.a.a.g.c a(b r0) {
            return r0.f13321f;
        }
    }

    static class c implements ThreadFactory {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final AtomicInteger f13322f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f13323g;

        class a extends Thread {
            a(c r1, Runnable r2, String r3) {
                super(r2, r3);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                super.run();
            }
        }

        c(String r3) {
            this.f13322f = new AtomicInteger(1);
            this.f13323g = "ApiExecutor";
            if (TextUtils.isEmpty(r3) == true) goto L6;
            this.f13323g = r3;
            return;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r3) {
            a r1 = new a(this, r3, this.f13323g + "#" + this.f13322f.getAndIncrement());
            r1.setDaemon(false);
            return r1;
        }
    }

    static {
        f13312l = new AtomicInteger();
        m = new f();
    }

    private f() {
        this.f13313f = new WeakHandler(Looper.getMainLooper(), this);
    }

    static /* synthetic */ ExecutorService a(f r0) {
        return r0.g();
    }

    static /* synthetic */ ExecutorService b(f r0) {
        return r0.e();
    }

    private synchronized ExecutorService e() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f13315h != null) goto L8;
        ThreadPoolExecutor r0 = l().o();     // Catch: Throwable -> L11
        this.f13315h = r0;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        ThreadPoolExecutor r1 = new ThreadPoolExecutor(l().b(), l().m(), l().a(), TimeUnit.SECONDS, new PriorityBlockingQueue(), new c("NetNormal"));     // Catch: Throwable -> L11
        this.f13315h = r1;     // Catch: Throwable -> L11
        r1.allowCoreThreadTimeOut(g.d().p());     // Catch: Throwable -> L11
    L8:
        ThreadPoolExecutor r2 = this.f13315h;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r2;
    }

    private synchronized ExecutorService f() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f13316i != null) goto L8;
        ThreadPoolExecutor r0 = l().g();     // Catch: Throwable -> L11
        this.f13316i = r0;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        ThreadPoolExecutor r1 = new ThreadPoolExecutor(l().c(), l().n(), l().f(), TimeUnit.SECONDS, new PriorityBlockingQueue(), new c("NetDownload"));     // Catch: Throwable -> L11
        this.f13316i = r1;     // Catch: Throwable -> L11
        r1.allowCoreThreadTimeOut(g.d().p());     // Catch: Throwable -> L11
    L8:
        ThreadPoolExecutor r2 = this.f13316i;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r2;
    }

    private synchronized ExecutorService g() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f13314g != null) goto L8;
        ThreadPoolExecutor r0 = l().i();     // Catch: Throwable -> L11
        this.f13314g = r0;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        this.f13314g = new ThreadPoolExecutor(l().d(), Integer.MAX_VALUE, l().h(), TimeUnit.SECONDS, new SynchronousQueue(), new c("NetImmediate"));     // Catch: Throwable -> L11
    L8:
        ThreadPoolExecutor r1 = this.f13314g;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    }

    private synchronized ExecutorService h() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f13318k != null) goto L8;
        ThreadPoolExecutor r0 = l().j();     // Catch: Throwable -> L11
        this.f13318k = r0;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        this.f13318k = new ThreadPoolExecutor(1, 1, l().h(), TimeUnit.SECONDS, new PriorityBlockingQueue(), new c("NetLocal"));     // Catch: Throwable -> L11
    L8:
        ThreadPoolExecutor r1 = this.f13318k;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    }

    private synchronized ExecutorService i() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f13317j != null) goto L8;
        ThreadPoolExecutor r0 = l().l();     // Catch: Throwable -> L11
        this.f13317j = r0;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        ThreadPoolExecutor r1 = new ThreadPoolExecutor(l().e(), l().e(), l().k(), TimeUnit.SECONDS, new PriorityBlockingQueue(), new c("NetLowest"));     // Catch: Throwable -> L11
        this.f13317j = r1;     // Catch: Throwable -> L11
        r1.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L11
    L8:
        ThreadPoolExecutor r2 = this.f13317j;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r2;
    }

    private b j(d.b.h.a.a.g.c r2) {
        return new a(this, r2, r2);
    }

    private static int k() {
        return f13312l.incrementAndGet();
    }

    private h l() {
        return g.d();
    }

    private static void m(ThreadPoolExecutor r1, d.b.h.a.a.g.c r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if ((r2 instanceof d.b.h.a.a.g.a) == false) goto L8;
        ((d.b.h.a.a.g.a) r2).o(r1.getQueue().size());
        return;
    }

    void c(d.b.h.a.a.g.c r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.j() == true) goto L24;
        r5.m(k());
        if (r5.k() == false) goto L10;
        h().execute(j(r5));
        return;
    L10:
        if (r5.b() != d.a.f13310j) goto L14;
        ExecutorService r4 = g();
    L12:
        r4.execute(r5);
        return;
    L14:
        if (r5.b() != d.a.f13306f) goto L16;
        r4 = i();
        goto L12
    L16:
        long r0 = r5.g();
        if (r0 <= 0) goto L19;
        Message r2 = Message.obtain();
        r2.what = 0;
        r2.obj = r5;
        this.f13313f.sendMessageDelayed(r2, r0);
        return;
    L19:
        m(this.f13315h, r5);
        r4 = e();
        goto L12
    }

    void d(d.b.h.a.a.g.c r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.j() == true) goto L20;
        r5.m(k());
        if (r5.b() != d.a.f13310j) goto L11;
        ExecutorService r4 = g();
    L9:
        r4.execute(r5);
        return;
    L11:
        if (r5.b() != d.a.f13306f) goto L13;
        r4 = i();
        goto L9
    L13:
        long r0 = r5.g();
        if (r0 <= 0) goto L16;
        Message r2 = Message.obtain();
        r2.what = 1;
        r2.obj = r5;
        this.f13313f.sendMessageDelayed(r2, r0);
        return;
    L16:
        m(this.f13316i, r5);
        r4 = f();
        goto L9
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r4) {
        if (r4 == null) goto L15;
        Object r0 = r4.obj;
        if ((r0 instanceof Runnable) == false) goto L21;
        int r1 = r4.what;     // Catch: Throwable -> L16
        if (r1 != 0) goto L9;
        m(this.f13315h, (d.b.h.a.a.g.c) r0);     // Catch: Throwable -> L16
        ExecutorService r3 = e();     // Catch: Throwable -> L16
        Object r5 = r4.obj;     // Catch: Throwable -> L16
    L12:
        r3.execute((Runnable) r5);     // Catch: Throwable -> L16
        return;
    L9:
        if (r1 != 1) goto L19;
        m(this.f13316i, (d.b.h.a.a.g.c) r0);     // Catch: Throwable -> L16
        r3 = g();     // Catch: Throwable -> L16
        r5 = r4.obj;     // Catch: Throwable -> L16
        goto L12
    L19:
        return;
    L22:
        return;
    L21:
        return;
    }
}
