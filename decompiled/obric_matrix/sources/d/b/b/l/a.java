package d.b.b.l;

import android.os.Build;
import d.b.b.o.j;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<c> f13025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static List<d> f13026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final BlockingQueue<b> f13027c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f13028d;

    /* JADX INFO: renamed from: d.b.b.l.a$a, reason: collision with other inner class name */
    static class RunnableC0343a implements Runnable {
        RunnableC0343a() {
        }

        /* JADX INFO: Infinite loop detected, blocks: 58, insns: 0 */
        @Override // java.lang.Runnable
        public void run() {
        L2:
            j.a("APM-Consumers");
            b r6 = (b) a.a().take();     // Catch: Throwable -> L35
            boolean r0 = false;
            Iterator r1 = a.b().iterator();     // Catch: Throwable -> L35
        L6:
            if (r1.hasNext() == false) goto L18;
            d r2 = (d) r1.next();     // Catch: Throwable -> L35
        L14:
            th = move-exception;
            if (d.b.b.o.a.c() == false) goto L6;
            d.b.b.o.m.b.c("APM-Monitor", "interceptor throws a Throwable", th);     // Catch: Throwable -> L35
            goto L6
        L9:
            if (r2.a(r6) == false) goto L6;
            r0 = true;
            if (d.b.b.o.a.c() == false) goto L18;
            d.b.b.o.m.b.f("APM-Monitor", "monitorable intercepted by " + r2.getClass() + " content: " + r6);     // Catch: Throwable -> L14
        L18:
            if (r0 == true) goto L2;
            Iterator r3 = a.c().iterator();     // Catch: Throwable -> L35
        L22:
            if (r3.hasNext() == false) goto L37;
            c r4 = (c) r3.next();     // Catch: Throwable -> L35
            j.a("APM-Handler");     // Catch: Throwable -> L35
            if (r6.b() == false) goto L28;
            r4.a(r6);     // Catch: Throwable -> L31
        L33:
            j.b();     // Catch: Throwable -> L35
            goto L22
        L28:
            if (d.b.b.o.a.c() == false) goto L33;
            d.b.b.o.m.b.f("APM-Monitor", "monitorable invalid. ignored. " + r6);     // Catch: Throwable -> L31
            goto L33
        L31:
            th = move-exception;
            d.b.b.o.m.b.c("APM-Monitor", "monitorableHandler " + r4 + " handle monitorable " + r6 + "failed.", th);     // Catch: Throwable -> L35
        L37:
            j.b();
        L35:
            th = move-exception;
            d.b.b.o.m.b.c("APM", "record error", th);
            goto L37
        }
    }

    static {
        f13025a = new CopyOnWriteArrayList();
        f13026b = new CopyOnWriteArrayList();
        if (Build.VERSION.SDK_INT < 21) goto L5;
        BlockingQueue<b> r0 = new LinkedTransferQueue();
    L6:
        f13027c = r0;
        f13028d = false;
        return;
    L5:
        r0 = new LinkedBlockingQueue();
        goto L6
    }

    static /* synthetic */ BlockingQueue a() {
        return f13027c;
    }

    static /* synthetic */ List b() {
        return f13026b;
    }

    static /* synthetic */ List c() {
        return f13025a;
    }

    public static void d(b r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        f13027c.offer(r1);
        if (f13028d == true) goto L8;
        g();
        return;
    }

    public static void e(c r1) {
        if (f13025a.contains(r1) == true) goto L6;
        f13025a.add(r1);
        return;
    }

    public static void f(d r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (f13026b.contains(r1) == true) goto L8;
        f13026b.add(r1);
        return;
    }

    private static synchronized void g() {
        monitor-enter(a.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (f13028d == false) goto L9;
        monitor-exit(a.class);
        return;
    L9:
        f13028d = true;     // Catch: Throwable -> L12
        new Thread(new RunnableC0343a(), "APM-Monitor").start();     // Catch: Throwable -> L12
        monitor-exit(a.class);
    }
}
