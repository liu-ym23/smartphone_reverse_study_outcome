package d.b.b.h;

import android.os.Process;
import com.bytedance.news.common.service.manager.d;
import com.bytedance.services.apm.api.IFdCheck;
import d.b.b.o.o.c;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static a f12935g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d.b.b.h.c.a f12936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f12937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f12938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f12939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d.b.b.o.o.a f12940e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private IFdCheck f12941f;

    /* JADX INFO: renamed from: d.b.b.h.a$a, reason: collision with other inner class name */
    class C0340a extends d.b.b.o.o.a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ a f12942i;

        C0340a(a r1, long r2) {
            this.f12942i = r1;
            super(r2);
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.b.o.o.b.a(c.f13067g).b(a.a(this.f12942i));
            a.b(this.f12942i, null);
            a.c(this.f12942i, true);
            a.d(this.f12942i);
        }
    }

    class b extends d.b.b.o.o.a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ a f12943i;

        b(a r1, long r2, long r4) {
            this.f12943i = r1;
            super(r2, r4);
        }

        @Override // java.lang.Runnable
        public void run() {
            a.e(this.f12943i);
        }
    }

    static {
        f12935g = new a();
    }

    public a() {
        this.f12939d = false;
    }

    static /* synthetic */ d.b.b.o.o.a a(a r0) {
        return r0.f12940e;
    }

    static /* synthetic */ d.b.b.o.o.a b(a r0, d.b.b.o.o.a r1) {
        r0.f12940e = r1;
        return r1;
    }

    static /* synthetic */ boolean c(a r0, boolean r1) {
        r0.f12939d = r1;
        return r1;
    }

    static /* synthetic */ void d(a r0) {
        r0.k();
    }

    static /* synthetic */ void e(a r0) {
        r0.f();
    }

    private void f() {
        if (this.f12936a != null) goto L5;
        return;
    L5:
        d.b.b.n.g.a r0 = (d.b.b.n.g.a) d.b.b.n.c.a(d.b.b.n.g.a.class);
        boolean r1 = false;
        if (r0 == null) goto L8;
        r1 = r0.isForeground();
    L8:
        int r2 = h();
        if (r2 > 0) goto L11;
    L14:
        IFdCheck r6 = g();
        if (r6 != null) goto L17;
        return;
    L17:
        d.b.b.l.a.d(new d.b.b.h.b(r2, r6.getFdList(), r1));
        return;
    L11:
        if (r2 >= this.f12936a.b()) goto L14;
        d.b.b.l.a.d(new d.b.b.h.b(r2, null, r1));
    }

    private IFdCheck g() {
        if (this.f12941f != null) goto L6;
        this.f12941f = (IFdCheck) d.a(IFdCheck.class);
    L6:
        return this.f12941f;
    }

    private int h() {
        return new File("/proc/" + Process.myPid() + "/fd").listFiles().length;
    L5:
        return 0;
    }

    public static a i() {
        return f12935g;
    }

    private synchronized void k() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.f12939d == false) goto L15;
        d.b.b.h.c.a r0 = this.f12936a;     // Catch: Throwable -> L17
        if (r0 == null) goto L15;
        if (r0.c() == false) goto L15;
        if (this.f12938c == true) goto L15;
        this.f12938c = true;     // Catch: Throwable -> L17
        d.b.b.o.o.b.a(c.f13067g).c(new b(this, 0, this.f12936a.a()));     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L15:
        monitor-exit(this);
    }

    public void j() {
        if (this.f12937b == false) goto L5;
        return;
    L5:
        this.f12937b = true;
        d.b.b.h.c.b r0 = (d.b.b.h.c.b) d.b.b.n.c.a(d.b.b.h.c.b.class);
        if (r0 == null) goto L8;
        l(r0.getConfig());
    L8:
        this.f12940e = new C0340a(this, 1200000);
        d.b.b.o.o.b.a(c.f13067g).c(this.f12940e);
    }

    public synchronized void l(d.b.b.h.c.a r4) {
        monitor-enter(this);
        if (r4 != null) goto L15;
        monitor-exit(this);
        return;
    L15:
        this.f12936a = r4;     // Catch: Throwable -> L12
        if (d.b.b.o.a.c() == false) goto L9;
        d.b.b.o.m.b.a("APM-FD", "updateConfig:" + r4);     // Catch: Throwable -> L12
    L9:
        k();     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
