package d.b.i.a.b.h;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f13882e = 5000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f13883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f13884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Runnable f13885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    CopyOnWriteArraySet<d.b.i.a.b.h.b> f13886d;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f13887f;

        a(c r1) {
            this.f13887f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator<d.b.i.a.b.h.b> r0 = this.f13887f.f13886d.iterator();     // Catch: OutOfMemoryError -> L10
        L4:
            if (r0.hasNext() == false) goto L7;
            r0.next().onTimeEvent(System.currentTimeMillis());     // Catch: OutOfMemoryError -> L10
            goto L4
        L7:
            if (c.a(this.f13887f) == false) goto L14;
            c.c(this.f13887f).h(this, c.b());     // Catch: OutOfMemoryError -> L10
            return;
        L14:
            return;
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final c f13888a = null;

        static {
            f13888a = new c(null);
        }
    }

    static {
    }

    private c() {
        this.f13884b = true;
        this.f13885c = new a(this);
        this.f13886d = new CopyOnWriteArraySet();
        d r0 = new d("LogSendManager-Thread");
        this.f13883a = r0;
        r0.l();
    }

    /* synthetic */ c(a r1) {
        this();
    }

    static /* synthetic */ boolean a(c r0) {
        return r0.f13884b;
    }

    static /* synthetic */ long b() {
        return f13882e;
    }

    static /* synthetic */ d c(c r0) {
        return r0.f13883a;
    }

    public static c e() {
        return b.f13888a;
    }

    public void d(d.b.i.a.b.h.b r3) {
        if (r3 == null) goto L10;
        this.f13886d.add(r3);     // Catch: Throwable -> L7
        if (this.f13884b == false) goto L11;
        this.f13883a.i(this.f13885c);     // Catch: Throwable -> L7
        this.f13883a.h(this.f13885c, f13882e);     // Catch: Throwable -> L7
        return;
    L11:
        return;
    L12:
        return;
    }
}
