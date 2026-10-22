package p000j;

import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import k.d;
import p000j.k0.c;
import p000j.k0.g.j;
import p000j.k0.j.g;
import p000j.l0.f;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 implements e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final a0 f17680f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final j f17681g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final d f17682h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private s f17683i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final d0 f17684j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final boolean f17685k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f17686l;

    class a extends d {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ c0 f17687l;

        a(c0 r1) {
            this.f17687l = r1;
        }

        @Override // k.d
        protected void x() {
            this.f17687l.c(f.f18162b);
        }
    }

    final class b extends p000j.k0.b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final f f17688g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ c0 f17689h;

        static {
        }

        b(c0 r3, f r4) {
            this.f17689h = r3;
            super("OkHttp %s", new Object[]{r3.i()});
            this.f17688g = r4;
        }

        @Override // p000j.k0.b
        protected void l() {
            this.f17689h.f17682h.r();
            boolean r1 = true;
            this.f17688g.onResponse(this.f17689h, this.f17689h.f());     // Catch: Throwable -> L7 IOException -> L9
        L6:
            this.f17689h.f17680f.j().e(this);
            return;
        L9:
            IOException e2 = e;
        L19:
            IOException r0 = this.f17689h.k(e2);     // Catch: Throwable -> L25
            if (r1 == false) goto L22;
            g.m().t(4, "Callback failure for " + this.f17689h.m(), r0);     // Catch: Throwable -> L25
            goto L6
        L22:
            c0.a(this.f17689h).b(this.f17689h, r0);     // Catch: Throwable -> L25
            this.f17688g.onFailure(this.f17689h, r0);     // Catch: Throwable -> L25
        L7:
            Throwable th = th;
        L13:
            this.f17689h.cancel();     // Catch: Throwable -> L25
            if (r1 == true) goto L16;
            this.f17688g.onFailure(this.f17689h, new IOException("canceled due to " + th));     // Catch: Throwable -> L25
        L16:
            throw th;     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            this.f17689h.f17680f.j().e(this);
            throw th;
        L17:
            e = move-exception;
            r1 = false;
            e2 = e;
        L11:
            th = move-exception;
            r1 = false;
            th = th;
            goto L13
        }

        void m(ExecutorService r3) {
            r3.execute(this);     // Catch: Throwable -> L4 RejectedExecutionException -> L6
        L12:
            return;
        L4:
            th = move-exception;
            this.f17689h.f17680f.j().e(this);
            throw th;
        L6:
            e = move-exception;
            InterruptedIOException r0 = new InterruptedIOException("executor rejected");     // Catch: Throwable -> L4
            r0.initCause(e);     // Catch: Throwable -> L4
            c0.a(this.f17689h).b(this.f17689h, r0);     // Catch: Throwable -> L4
            this.f17688g.onFailure(this.f17689h, r0);     // Catch: Throwable -> L4
            this.f17689h.f17680f.j().e(this);
            goto L12
        }

        c0 n() {
            return this.f17689h;
        }

        String o() {
            return this.f17689h.f17684j.k().m();
        }
    }

    private c0(a0 r1, d0 r2, boolean r3) {
        this.f17680f = r1;
        this.f17684j = r2;
        this.f17685k = r3;
        this.f17681g = new j(r1, r3);
        a r4 = new a(this);
        this.f17682h = r4;
        r4.g(r1.c(), TimeUnit.MILLISECONDS);
    }

    static /* synthetic */ s a(c0 r0) {
        return r0.f17683i;
    }

    private void d() {
        Object r0 = g.m().p("response.body().close()");
        this.f17681g.q(r0);
    }

    static c0 h(a0 r1, d0 r2, boolean r3) {
        c0 r0 = new c0(r1, r2, r3);
        r0.f17683i = r1.n().a(r0);
        return r0;
    }

    @Override // p000j.e
    public d0 b() {
        return this.f17684j;
    }

    public void c(int r1) {
        this.f17681g.b(r1);
    }

    @Override // p000j.e
    public void cancel() {
        c(f.f18161a);
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return e();
    }

    public c0 e() {
        return h(this.f17680f, this.f17684j, this.f17685k);
    }

    @Override // p000j.e
    public f0 execute() {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if (this.f17686l == true) goto L22;
        this.f17686l = true;     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        d();
        this.f17682h.r();
        this.f17683i.d(this);
        this.f17680f.j().b(this);     // Catch: Throwable -> L14 IOException -> L16
        f0 r0 = f();     // Catch: Throwable -> L14 IOException -> L16
        if (r0 == null) goto L13;
        this.f17680f.j().f(this);
        return r0;
    L13:
        throw new IOException("Canceled");     // Catch: Throwable -> L14 IOException -> L16
    L16:
        e = move-exception;
        IOException r1 = k(e);     // Catch: Throwable -> L14
        this.f17683i.b(this, r1);     // Catch: Throwable -> L14
        throw r1;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        this.f17680f.j().f(this);
        throw th;
    L22:
        throw new IllegalStateException("Already Executed");     // Catch: Throwable -> L23
    }

    f0 f() {
        ArrayList r1 = new ArrayList();
        r1.addAll(this.f17680f.r());
        r1.add(this.f17681g);
        r1.add(new p000j.k0.g.a(this.f17680f.i()));
        r1.add(new p000j.k0.e.a(this.f17680f.t()));
        r1.add(new p000j.k0.f.a(this.f17680f));
        if (this.f17685k == true) goto L5;
        r1.addAll(this.f17680f.u());
    L5:
        r1.add(new p000j.k0.g.b(this.f17685k));
        f0 r0 = new p000j.k0.g.g(r1, null, null, null, 0, this.f17684j, this, this.f17683i, this.f17680f.e(), this.f17680f.G(), this.f17680f.L()).d(this.f17684j);
        if (this.f17681g.g() == true) goto L8;
        return r0;
    L8:
        c.g(r0);
        throw new IOException("Canceled#Reason=" + this.f17681g.c());
    }

    @Override // p000j.e
    public boolean g() {
        return this.f17681g.g();
    }

    String i() {
        return this.f17684j.k().B();
    }

    p000j.k0.f.g j() {
        return this.f17681g.t();
    }

    IOException k(IOException r2) {
        if (this.f17682h.s() == true) goto L5;
        return r2;
    L5:
        InterruptedIOException r1 = new InterruptedIOException(LocationMonitorConst.TIMEOUT);
        if (r2 == null) goto L8;
        r1.initCause(r2);
    L8:
        return r1;
    }

    String m() {
        StringBuilder r0 = new StringBuilder();
        if (g() == false) goto L5;
        String r1 = "canceled ";
    L6:
        r0.append(r1);
        if (this.f17685k == false) goto L9;
        String r2 = "web socket";
    L10:
        r0.append(r2);
        r0.append(" to ");
        r0.append(i());
        return r0.toString();
    L9:
        r2 = NotificationCompat.CATEGORY_CALL;
        goto L10
    L5:
        r1 = "";
        goto L6
    }

    @Override // p000j.e
    public void s(f r3) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f17686l == true) goto L10;
        this.f17686l = true;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        d();
        this.f17683i.d(this);
        this.f17680f.j().a(new b(this, r3));
        return;
    L10:
        throw new IllegalStateException("Already Executed");     // Catch: Throwable -> L11
    }
}
