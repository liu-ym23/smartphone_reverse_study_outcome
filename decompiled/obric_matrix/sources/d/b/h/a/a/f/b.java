package d.b.h.a.a.f;

import com.bytedance.common.utility.Logger;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f13275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f13276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AtomicReference<c> f13277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicReference<c> f13278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList<InterfaceC0356b> f13279e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f13280f;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f13281a = null;

        static {
            f13281a = new b();
        }
    }

    /* JADX INFO: renamed from: d.b.h.a.a.f.b$b, reason: collision with other inner class name */
    public interface InterfaceC0356b {
        void l(c r1);
    }

    protected b() {
        this.f13275a = new e(0.05d);
        this.f13276b = false;
        this.f13277c = new AtomicReference(c.f13286j);
        this.f13279e = new ArrayList();
    }

    public static b c() {
        return a.f13281a;
    }

    private c d(double r3) {
        if (r3 >= 0.0d) goto L7;
        return c.f13286j;
    L7:
        if (r3 >= 28.0d) goto L11;
        return c.f13282f;
    L11:
        if (r3 >= 112.0d) goto L15;
        return c.f13283g;
    L15:
        if (r3 >= 560.0d) goto L19;
        return c.f13284h;
    L19:
        return c.f13285i;
    }

    private void e() {
        int r0 = this.f13279e.size();     // Catch: Throwable -> L7
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        this.f13279e.get(r1).l(this.f13277c.get());     // Catch: Throwable -> L7
        r1 = r1 + 1;
        goto L3
    L11:
        return;
    }

    private boolean g() {
        if (this.f13275a != null) goto L28;
        return false;
    L28:
        c r0 = this.f13277c.get();     // Catch: Throwable -> L27
        double r3 = 560.0d;
        double r5 = 112.0d;
        if (c.f13282f != r0) goto L9;
        r5 = 0.0d;
        r3 = 28.0d;
    L17:
        double r7 = this.f13275a.b();     // Catch: Throwable -> L27
        if (r7 <= r3) goto L24;
        if (r7 <= (r3 * 1.25d)) goto L26;
        return true;
    L24:
        if (r7 >= (r5 * 0.8d)) goto L26;
    L25:
        return true;
    L9:
        if (c.f13283g != r0) goto L12;
        r3 = 112.0d;
        r5 = 28.0d;
        goto L17
    L12:
        if (c.f13284h == r0) goto L17;
        if (c.f13285i != r0) goto L25;
        r3 = 3.4028234663852886E38d;
        r5 = 560.0d;
    L26:
        return false;
    }

    public synchronized void a(long r5, long r7) {
        monitor-enter(this);
        double r6 = ((r5 * 1.0d) / r7) * 8.0d;
        if (r7 != 0) goto L6;
    L25:
        monitor-exit(this);
        return;
    L6:
        if (r6 < 3.0d) goto L25;
        Logger.debug();     // Catch: Throwable -> L27
        this.f13275a.a(r6);     // Catch: Throwable -> L27
        if (this.f13276b == false) goto L21;
        this.f13280f++;     // Catch: Throwable -> L27
        if (b() == this.f13278d.get()) goto L14;
        this.f13276b = false;     // Catch: Throwable -> L27
        this.f13280f = 1;     // Catch: Throwable -> L27
    L14:
        if (this.f13280f >= 5.0d) goto L16;
    L18:
        monitor-exit(this);
        return;
    L16:
        if (g() == false) goto L18;
        this.f13276b = false;     // Catch: Throwable -> L27
        this.f13280f = 1;     // Catch: Throwable -> L27
        this.f13277c.set(this.f13278d.get());     // Catch: Throwable -> L27
        e();     // Catch: Throwable -> L27
        goto L18
    L21:
        if (this.f13277c.get() == b()) goto L23;
        this.f13276b = true;     // Catch: Throwable -> L27
        this.f13278d = new AtomicReference(b());     // Catch: Throwable -> L27
    L23:
        monitor-exit(this);
    }

    public synchronized c b() {
        monitor-enter(this);
        e r0 = this.f13275a;     // Catch: Throwable -> L14
        if (r0 != null) goto L17;
        c r1 = c.f13286j;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r1;
    L17:
        c r2 = d(r0.b());     // Catch: Throwable -> L11
        monitor-exit(this);
        return r2;
    L13:
        return c.f13286j;
    L14:
        th = move-exception;
        throw th;
    }

    public c f(InterfaceC0356b r2) {
        if (r2 == null) goto L5;
        this.f13279e.add(r2);
    L5:
        return this.f13277c.get();
    }
}
