package d.b.i.a.b.h;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f13875e = 30000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f13876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f13877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Runnable f13878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    CopyOnWriteArraySet<d.b.i.a.b.h.b> f13879d;

    /* JADX INFO: renamed from: d.b.i.a.b.h.a$a, reason: collision with other inner class name */
    class RunnableC0367a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f13880f;

        RunnableC0367a(a r1) {
            this.f13880f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator<d.b.i.a.b.h.b> r0 = this.f13880f.f13879d.iterator();     // Catch: OutOfMemoryError -> L10
        L4:
            if (r0.hasNext() == false) goto L7;
            r0.next().onTimeEvent(System.currentTimeMillis());     // Catch: OutOfMemoryError -> L10
            goto L4
        L7:
            if (a.a(this.f13880f) == false) goto L14;
            a.c(this.f13880f).h(this, a.b());     // Catch: OutOfMemoryError -> L10
            return;
        L14:
            return;
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final a f13881a = null;

        static {
            f13881a = new a(null);
        }
    }

    static {
    }

    private a() {
        this.f13877b = true;
        this.f13878c = new RunnableC0367a(this);
        this.f13879d = new CopyOnWriteArraySet();
        d r0 = new d("AsyncEventManager-Thread");
        this.f13876a = r0;
        r0.l();
    }

    /* synthetic */ a(RunnableC0367a r1) {
        this();
    }

    static /* synthetic */ boolean a(a r0) {
        return r0.f13877b;
    }

    static /* synthetic */ long b() {
        return f13875e;
    }

    static /* synthetic */ d c(a r0) {
        return r0.f13876a;
    }

    public static a e() {
        return b.f13881a;
    }

    public void d(d.b.i.a.b.h.b r3) {
        if (r3 == null) goto L10;
        this.f13879d.add(r3);     // Catch: Throwable -> L7
        if (this.f13877b == false) goto L11;
        this.f13876a.i(this.f13878c);     // Catch: Throwable -> L7
        this.f13876a.h(this.f13878c, f13875e);     // Catch: Throwable -> L7
        return;
    L11:
        return;
    L12:
        return;
    }

    public void f(Runnable r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.f13876a.g(r1);
    }

    public void g(Runnable r1, long r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.f13876a.h(r1, r2);
    }
}
