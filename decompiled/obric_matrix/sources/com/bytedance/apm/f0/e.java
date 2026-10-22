package com.bytedance.apm.f0;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.apm.k;
import com.bytedance.apm.util.i;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final i.a<C0045e, Runnable> f1521f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final i.a<Message, Runnable> f1522g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HandlerThread f1523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Queue<C0045e> f1524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Queue<Message> f1525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile Handler f1526d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f1527e;

    static class a implements i.a<C0045e, Runnable> {
        a() {
        }

        @Override // com.bytedance.apm.util.i.a
        public /* bridge */ /* synthetic */ boolean a(C0045e r1, Runnable r2) {
            return b(r1, r2);
        }

        public boolean b(C0045e r2, Runnable r3) {
            if (r3 != null) goto L12;
            if (r2 == null) goto L20;
            Message r4 = r2.f1530a;
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
            Message r5 = r2.f1530a;
            if (r5 == null) goto L19;
            if (r3.equals(r5.getCallback()) == false) goto L19;
            return true;
        L19:
            return false;
        }
    }

    static class b implements i.a<Message, Runnable> {
        b() {
        }

        @Override // com.bytedance.apm.util.i.a
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
        final /* synthetic */ e f1528f;

        c(e r1) {
            this.f1528f = r1;
        }

        void b() {
        L3:
            if (e.c(this.f1528f).isEmpty() == true) goto L14;
            Object r0 = e.a(this.f1528f);
            monitor-enter(r0);
            if (this.f1528f.f1526d == null) goto L9;
            this.f1528f.f1526d.sendMessageAtFrontOfQueue((Message) e.c(this.f1528f).poll());     // Catch: Throwable -> L11
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        }

        void c() {
        L3:
            if (e.b(this.f1528f).isEmpty() == true) goto L14;
            Object r0 = e.a(this.f1528f);
            monitor-enter(r0);
            C0045e r1 = (C0045e) e.b(this.f1528f).poll();     // Catch: Throwable -> L11
            if (this.f1528f.f1526d == null) goto L9;
            this.f1528f.f1526d.sendMessageAtTime(r1.f1530a, r1.f1531b);     // Catch: Throwable -> L11
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.Runnable
        public void run() {
            b();
            c();
        }
    }

    class d extends HandlerThread {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f1529f;

        d(e r1, String r2) {
            this.f1529f = r1;
            super(r2);
        }

        /* JADX INFO: Infinite loop detected, blocks: 9, insns: 0 */
        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            Object r0 = e.a(this.f1529f);
            monitor-enter(r0);
            e r1 = this.f1529f;     // Catch: Throwable -> L11
            r1.f1526d = new Handler();     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            this.f1529f.f1526d.post(new c(this.f1529f));
        L16:
            Looper.loop();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            k.e().b(th, "apm_error");
        L11:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.apm.f0.e$e, reason: collision with other inner class name */
    static class C0045e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Message f1530a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f1531b;

        C0045e(Message r1, long r2) {
            this.f1530a = r1;
            this.f1531b = r2;
        }
    }

    static {
        f1521f = new a();
        f1522g = new b();
    }

    public e(String r2) {
        this.f1524b = new ConcurrentLinkedQueue();
        this.f1525c = new ConcurrentLinkedQueue();
        this.f1527e = new Object();
        this.f1523a = new d(this, r2);
    }

    static /* synthetic */ Object a(e r0) {
        return r0.f1527e;
    }

    static /* synthetic */ Queue b(e r0) {
        return r0.f1524b;
    }

    static /* synthetic */ Queue c(e r0) {
        return r0.f1525c;
    }

    public Message d(Runnable r1) {
        return Message.obtain(this.f1526d, r1);
    }

    public boolean e() {
        if (this.f1526d == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean f(Runnable r3) {
        return j(d(r3), 0);
    }

    public final boolean g(Runnable r1, long r2) {
        return j(d(r1), r2);
    }

    public final void h(Runnable r3) {
        if (this.f1524b.isEmpty() == true) goto L5;
    L6:
        i.d(this.f1524b, r3, f1521f);
        i.d(this.f1525c, r3, f1522g);
    L8:
        if (this.f1526d == null) goto L11;
        this.f1526d.removeCallbacks(r3);
        return;
    L11:
        return;
    L5:
        if (this.f1525c.isEmpty() == true) goto L8;
        goto L6
    }

    public final boolean i(Message r3, long r4) {
        if (this.f1526d != null) goto L17;
        Object r0 = this.f1527e;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.f1526d != null) goto L11;
        this.f1524b.add(new C0045e(r3, r4));     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
    L17:
        return this.f1526d.sendMessageAtTime(r3, r4);
    }

    public final boolean j(Message r4, long r5) {
        if (r5 >= 0) goto L6;
        r5 = 0;
    L6:
        return i(r4, SystemClock.uptimeMillis() + r5);
    }

    public void k() {
        this.f1523a.start();
    }
}
