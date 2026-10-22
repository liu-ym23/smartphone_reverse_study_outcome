package d.b.p.a.d;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.CoroutineLiveDataKt;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Class f14228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Object f14229b;

    /* JADX INFO: renamed from: d.b.p.a.d.a$a, reason: collision with other inner class name */
    static class RunnableC0385a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f14230f;

        RunnableC0385a(Object r1) {
            this.f14230f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(d.b.p.a.h.d.c(a.b(), "currentActivityThread", new Object[0]));     // Catch: Throwable -> L11 Exception -> L20
            Object r0 = this.f14230f;
            monitor-enter(r0);
            this.f14230f.notify();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        L11:
            th = move-exception;
            monitor-enter(this.f14230f);
            this.f14230f.notify();     // Catch: Throwable -> L17
            throw th;
        L17:
            th = move-exception;
            throw th;
        L21:
            monitor-enter(this.f14230f);
            this.f14230f.notify();     // Catch: Throwable -> L25
            return;
        L25:
            th = move-exception;
            throw th;
        }
    }

    private a() {
    }

    static /* synthetic */ Object a(Object r0) {
        f14229b = r0;
        return r0;
    }

    static /* synthetic */ Class b() {
        return f14228a;
    }

    public static Object c() {
        if (f14229b != null) goto L36;
        monitor-enter(a.class);     // Catch: Exception -> L33
    L30:
        th = move-exception;
        throw th;     // Catch: Exception -> L33
    L7:
        if (f14229b != null) goto L13;
        if (f14228a != null) goto L11;
        f14228a = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L30
    L11:
        f14229b = d.b.p.a.h.d.c(f14228a, "currentActivityThread", new Object[0]);     // Catch: Throwable -> L30
    L13:
        if (f14229b == null) goto L15;
    L28:
        monitor-exit(a.class);     // Catch: Throwable -> L30
        goto L36
    L15:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L28;
        Object r1 = new Object();     // Catch: Throwable -> L30
        new Handler(Looper.getMainLooper()).post(new RunnableC0385a(r1));     // Catch: Throwable -> L30
        if (f14229b != null) goto L28;
        monitor-enter(r1);     // Catch: Throwable -> L30
        r1.wait(CoroutineLiveDataKt.DEFAULT_TIMEOUT);     // Catch: Throwable -> L22 InterruptedException -> L37
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L24:
        monitor-exit(r1);     // Catch: Throwable -> L22
    L33:
        e = move-exception;
        e.printStackTrace();
    L36:
        return f14229b;
    }
}
