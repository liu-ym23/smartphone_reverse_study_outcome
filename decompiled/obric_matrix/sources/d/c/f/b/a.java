package d.c.f.b;

import android.os.Handler;
import android.os.Looper;
import d.c.c.d.i;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static a f15543d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<b> f15544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f15545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Runnable f15546c;

    /* JADX INFO: renamed from: d.c.f.b.a$a, reason: collision with other inner class name */
    class RunnableC0418a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f15547f;

        RunnableC0418a(a r1) {
            this.f15547f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a();
            Iterator r0 = a.b(this.f15547f).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((b) r0.next()).b();
            goto L4
        L6:
            a.b(this.f15547f).clear();
        }
    }

    public interface b {
        void b();
    }

    static {
    }

    public a() {
        this.f15546c = new RunnableC0418a(this);
        this.f15544a = new HashSet();
        this.f15545b = new Handler(Looper.getMainLooper());
    }

    static /* synthetic */ void a() {
        d();
    }

    static /* synthetic */ Set b(a r0) {
        return r0.f15544a;
    }

    private static void d() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        boolean r0 = true;
    L6:
        i.i(r0);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static synchronized a e() {
        monitor-enter(a.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f15543d != null) goto L7;
        f15543d = new a();     // Catch: Throwable -> L10
    L7:
        a r1 = f15543d;     // Catch: Throwable -> L10
        monitor-exit(a.class);
        return r1;
    }

    public void c(b r1) {
        d();
        this.f15544a.remove(r1);
    }

    public void f(b r2) {
        d();
        if (this.f15544a.add(r2) == true) goto L6;
        return;
    L6:
        if (this.f15544a.size() != 1) goto L9;
        this.f15545b.post(this.f15546c);
        return;
    }
}
