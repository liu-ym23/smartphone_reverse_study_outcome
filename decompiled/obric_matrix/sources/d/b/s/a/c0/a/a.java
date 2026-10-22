package d.b.s.a.c0.a;

import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.k;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
class a extends Thread implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected static f f14671k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected static final AtomicInteger f14672l = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected WeakHandler f14673f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final BlockingQueue<e> f14674g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f14675h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile boolean f14676i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f14677j;

    static {
        f14671k = f.c();
        f14672l = new AtomicInteger();
    }

    public a(BlockingQueue<e> r2, String r3, String r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        r3 = "ApiDispatcher-Thread";
    L5:
        super(r3);
        this.f14673f = new WeakHandler(Looper.getMainLooper(), this);
        this.f14675h = false;
        this.f14676i = false;
        this.f14677j = "ApiDispatcher";
        this.f14674g = r2;
        this.f14677j = r4;
    }

    private void d(c r8) {
        String r2 = null;
        this.f14676i = true;     // Catch: Throwable -> L17
        a(r8);     // Catch: Throwable -> L17
        if (r8.n() == false) goto L7;
        this.f14676i = false;     // Catch: Throwable -> L17
        return;
    L7:
        String r0 = Thread.currentThread().getName();     // Catch: Throwable -> L17
        r2 = r8.m();     // Catch: Throwable -> L15
        if (k.c(r2) == false) goto L11;
    L13:
        d.b.s.a.a0.a.a(this.f14677j, "thread (inc) count: " + f14672l.incrementAndGet());     // Catch: Throwable -> L15
        r8.run();     // Catch: Throwable -> L15
        f();     // Catch: Throwable -> L15
    L20:
        this.f14676i = false;
        if (k.c(r2) == false) goto L23;
    L25:
        d.b.s.a.a0.a.a(this.f14677j, "thread (dec) count: " + f14672l.decrementAndGet());
        return;
    L23:
        if (k.c(r0) == true) goto L25;
        Thread.currentThread().setName(r0);
        goto L25
    L11:
        if (k.c(r0) == true) goto L13;
        Thread.currentThread().setName(r2);     // Catch: Throwable -> L15
    L15:
        th = th;
        String r6 = r2;
        r2 = r0;
        String r1 = r6;
    L19:
        d.b.s.a.a0.a.c(this.f14677j, "processLegacyApiThread: ", th);
        String r7 = r2;
        r2 = r1;
        r0 = r7;
    L17:
        th = th;
        r1 = null;
        goto L19
    }

    public void a(c r1) {
        if (r1 == null) goto L5;
        r1.k();
        return;
    }

    public void b() {
        this.f14673f.removeMessages(0);
    }

    public boolean c() {
        return this.f14676i;
    }

    public void e() {
        this.f14675h = true;
        interrupt();
    }

    public void f() {
        b();
        this.f14673f.sendEmptyMessageDelayed(0, 2000);
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r1) {
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.what != 0) goto L12;
        f14671k.h();     // Catch: Throwable -> L9
        return;
    L12:
        return;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
    L12:
        e r0 = this.f14674g.take();     // Catch: InterruptedException -> L9
        b();     // Catch: InterruptedException -> L9
        if (r0 == null) goto L12;
        if ((r0 instanceof c) == false) goto L12;
        d((c) r0);
    L10:
        if (this.f14675h == false) goto L12;
    }
}
