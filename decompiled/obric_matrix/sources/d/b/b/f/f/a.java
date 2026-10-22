package d.b.b.f.f;

import android.util.Pair;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class a implements d.b.b.n.h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f12868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f12869b;

    /* JADX INFO: renamed from: d.b.b.f.f.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0337a {
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f12870a = null;

        static {
            f12870a = new a(null);
        }

        static /* synthetic */ a a() {
            return f12870a;
        }
    }

    private a() {
        this.f12868a = -1.0d;
        this.f12869b = -1.0d;
        new Pair(0L, new LinkedList());
        new Pair(0L, new LinkedList());
    }

    /* synthetic */ a(C0337a r1) {
        this();
    }

    public static a c() {
        return b.a();
    }

    @Override // d.b.b.n.h.a
    public double a() {
        return this.f12868a;
    }

    @Override // d.b.b.n.h.a
    public double b() {
        return this.f12869b;
    }

    public void d(double r1, double r3) {
        this.f12868a = r1;
        this.f12869b = r3;
    }

    public synchronized void e(LinkedList<d.b.b.n.h.a.C0344a> r4) {
        monitor-enter(this);
        new Pair(Long.valueOf(System.currentTimeMillis()), r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void f(LinkedList<d.b.b.n.h.a.C0344a> r4) {
        monitor-enter(this);
        new Pair(Long.valueOf(System.currentTimeMillis()), r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
