package d.b.i.a.b.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final d.b.i.a.b.i.c.a<e, Runnable> f13889f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final d.b.i.a.b.i.c.a<Message, Runnable> f13890g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HandlerThread f13891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Queue<e> f13892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Queue<Message> f13893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile Handler f13894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f13895e;

    static class a implements d.b.i.a.b.i.c.a<e, Runnable> {
        a() {
        }

        @Override // d.b.i.a.b.i.c.a
        public /* bridge */ /* synthetic */ boolean a(e r1, Runnable r2) {
            return b(r1, r2);
        }

        public boolean b(e r2, Runnable r3) {
            if (r3 != null) goto L12;
            if (r2 == null) goto L20;
            Message r4 = r2.f13898a;
            if (r4 != null) goto L8;
            return true;
        L8:
            if (r4.getCallback() != null) goto L11;
            return true;
        L11:
            return false;
        L20:
            return true;
        L12:
            if (r2 == null) goto L19;
            Message r5 = r2.f13898a;
            if (r5 == null) goto L19;
            if (r3.equals(r5.getCallback()) == false) goto L19;
            return true;
        L19:
            return false;
        }
    }

    static class b implements d.b.i.a.b.i.c.a<Message, Runnable> {
        b() {
        }

        @Override // d.b.i.a.b.i.c.a
        public /* bridge */ /* synthetic */ boolean a(Message r1, Runnable r2) {
            return b(r1, r2);
        }

        public boolean b(Message r2, Runnable r3) {
            if (r3 != null) goto L10;
            if (r2 != null) goto L6;
            return true;
        L6:
            if (r2.getCallback() != null) goto L9;
            return true;
        L9:
            return false;
        L10:
            if (r2 == null) goto L15;
            if (r3.equals(r2.getCallback()) == false) goto L15;
            return true;
        L15:
            return false;
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f13896f;

        c(d r1) {
            this.f13896f = r1;
        }

        void b() {
        L3:
            if (d.e(this.f13896f).isEmpty() == true) goto L7;
            if (d.b(this.f13896f) == null) goto L3;
            d.b(this.f13896f).sendMessageAtFrontOfQueue((Message) d.e(this.f13896f).poll());
            goto L3
        }

        void c() {
        L3:
            if (d.d(this.f13896f).isEmpty() == true) goto L7;
            e r0 = (e) d.d(this.f13896f).poll();
            if (d.b(this.f13896f) == null) goto L3;
            d.b(this.f13896f).sendMessageAtTime(r0.f13898a, r0.f13899b);
            goto L3
        }

        @Override // java.lang.Runnable
        public void run() {
            b();
            c();
        }
    }

    /* JADX INFO: renamed from: d.b.i.a.b.h.d$d, reason: collision with other inner class name */
    class HandlerThreadC0368d extends HandlerThread {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f13897f;

        HandlerThreadC0368d(d r1, String r2) {
            this.f13897f = r1;
            super(r2);
        }

        /* JADX INFO: Infinite loop detected, blocks: 7, insns: 0 */
        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            Object r0 = d.a(this.f13897f);
            monitor-enter(r0);
            d.c(this.f13897f, new Handler());     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            d.b(this.f13897f).post(new c(this.f13897f));
        L13:
            Looper.loop();     // Catch: Throwable -> L12
        L9:
            th = move-exception;
            throw th;
        }
    }

    static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Message f13898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f13899b;

        e(Message r1, long r2) {
            this.f13898a = r1;
            this.f13899b = r2;
        }
    }

    static {
        f13889f = new a();
        f13890g = new b();
    }

    public d(String r2) {
        this.f13892b = new ConcurrentLinkedQueue();
        this.f13893c = new ConcurrentLinkedQueue();
        this.f13895e = new Object();
        this.f13891a = new HandlerThreadC0368d(this, r2);
    }

    static /* synthetic */ Object a(d r0) {
        return r0.f13895e;
    }

    static /* synthetic */ Handler b(d r0) {
        return r0.f13894d;
    }

    static /* synthetic */ Handler c(d r0, Handler r1) {
        r0.f13894d = r1;
        return r1;
    }

    static /* synthetic */ Queue d(d r0) {
        return r0.f13892b;
    }

    static /* synthetic */ Queue e(d r0) {
        return r0.f13893c;
    }

    private Message f(Runnable r1) {
        return Message.obtain(this.f13894d, r1);
    }

    public final boolean g(Runnable r3) {
        return k(f(r3), 0);
    }

    public final boolean h(Runnable r1, long r2) {
        return k(f(r1), r2);
    }

    public final void i(Runnable r3) {
        if (this.f13892b.isEmpty() == true) goto L5;
    L6:
        d.b.i.a.b.i.c.b(this.f13892b, r3, f13889f);
        d.b.i.a.b.i.c.b(this.f13893c, r3, f13890g);
    L8:
        if (this.f13894d == null) goto L11;
        this.f13894d.removeCallbacks(r3);
        return;
    L11:
        return;
    L5:
        if (this.f13893c.isEmpty() == true) goto L8;
        goto L6
    }

    public final boolean j(Message r3, long r4) {
        if (this.f13894d != null) goto L17;
        Object r0 = this.f13895e;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.f13894d != null) goto L11;
        this.f13892b.add(new e(r3, r4));     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
    L17:
        return this.f13894d.sendMessageAtTime(r3, r4);
    }

    public final boolean k(Message r4, long r5) {
        if (r5 >= 0) goto L6;
        r5 = 0;
    L6:
        return j(r4, SystemClock.uptimeMillis() + r5);
    }

    public void l() {
        this.f13891a.start();
    }
}
