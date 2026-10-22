package d.b.p.a.d;

import android.os.Looper;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f14231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f14232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<i> f14233c;

    public b() {
        this.f14233c = new LinkedList();
    }

    private void b(Thread r2, Throwable r3) {
        Thread.UncaughtExceptionHandler r0 = this.f14232b;
        if (r0 == null) goto L7;
        if (r0 == this) goto L8;
        r0.uncaughtException(r2, r3);
        return;
    L8:
        return;
    }

    private boolean c(Thread r3, Throwable r4) {
        List<i> r0 = this.f14233c;     // Catch: Throwable -> L19
        monitor-enter(r0);     // Catch: Throwable -> L19
        Iterator<i> r2 = this.f14233c.iterator();     // Catch: Throwable -> L14
    L6:
        if (r2.hasNext() == false) goto L12;
        if (r2.next().a(r3, r4) == false) goto L6;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return true;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return false;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L25:
        return false;
    }

    private boolean d(Throwable r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        int r0 = 0;
    L6:
        if (r3 == null) goto L16;
        if ((r3 instanceof OutOfMemoryError) == true) goto L9;
        if (r0 > 20) goto L13;
        r0 = r0 + 1;     // Catch: Throwable -> L17
        r3 = r3.getCause();     // Catch: Throwable -> L17
    L13:
        return false;
    L9:
        return true;
    L16:
        return false;
    }

    public boolean a(i r2) {
        List<i> r0 = this.f14233c;
        monitor-enter(r0);
        boolean r1 = this.f14233c.add(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void e() {
        if (this.f14231a == false) goto L5;
        return;
    L5:
        Thread.UncaughtExceptionHandler r0 = Thread.getDefaultUncaughtExceptionHandler();
        this.f14232b = r0;
        if (r0 == this) goto L8;
        Thread.setDefaultUncaughtExceptionHandler(this);
    L9:
        this.f14231a = true;
        return;
    L8:
        this.f14232b = null;
        goto L9
    }

    public boolean f(i r2) {
        List<i> r0 = this.f14233c;
        monitor-enter(r0);
        boolean r1 = this.f14233c.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread r2, Throwable e2) {
    L18:
        th = move-exception;
        b(r2, th);
        return;
    L3:
        if (d(e2) == false) goto L5;
    L16:
        b(r2, e2);     // Catch: Throwable -> L18
        return;
    L5:
        if (c(r2, e2) == false) goto L16;
        if (r2 != null) goto L8;
        return;
    L8:
        if (r2.getName().equals("main") == false) goto L31;
    L21:
        Looper.loop();     // Catch: Exception -> L11 Throwable -> L18
    L11:
        e2 = e;
        if (d(e2) == true) goto L16;
        if (c(r2, e2) == true) goto L21;
    }
}
