package com.bytedance.applog.n;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.bytedance.applog.l;
import com.bytedance.applog.m;
import com.bytedance.bdinstall.b0;
import com.bytedance.bdinstall.h0;
import com.bytedance.bdinstall.i;
import com.bytedance.bdinstall.i0;
import com.bytedance.bdinstall.k;
import com.bytedance.bdinstall.s;
import com.bytedance.bdinstall.u;
import com.bytedance.bdinstall.x;
import com.bytedance.bdinstall.y;
import com.bytedance.bdinstall.z;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a implements com.bytedance.applog.n.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private volatile k f2246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile i0 f2247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.applog.n.b f2248c;

    /* JADX INFO: renamed from: com.bytedance.applog.n.a$a, reason: collision with other inner class name */
    class ExecutorC0070a implements Executor {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Handler f2249f;

        ExecutorC0070a(a r1, Handler r2) {
            this.f2249f = r2;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r3) {
            if (this.f2249f.getLooper() != Looper.myLooper()) goto L5;
            r3.run();
            return;
        L5:
            this.f2249f.post(r3);
        }
    }

    class b implements z {
        b(a r1) {
        }

        @Override // com.bytedance.bdinstall.z
        public void onEvent(String r1, JSONObject r2) {
            com.bytedance.applog.a.F(r1, r2);
        }
    }

    class c implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f2250a;

        c(a r1, l r2) {
            this.f2250a = r2;
        }

        @Override // com.bytedance.bdinstall.y
        public byte[] a(byte[] r1, int r2) {
            d.b.m.a r0 = this.f2250a.l();
            if (r0 == null) goto L7;
            return r0.a(r1, r2);
        L7:
            return new byte[0];
        }
    }

    class d implements x {
        d(a r1) {
        }

        @Override // com.bytedance.bdinstall.x
        public void a(boolean r9, String r10, String r11, String r12, String r13, String r14, String r15) {
            com.bytedance.applog.util.a.g().a(r9, r10, r11, r12, r13, r14, r15);
        }

        @Override // com.bytedance.bdinstall.x
        public void b(String r1, String r2, String r3) {
            com.bytedance.applog.util.a.g().b(r1, r2, r3);
        }
    }

    private static class e implements b0, u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final f f2251a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private JSONObject f2252b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private h0 f2253c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f2254d;

        public e(f r2) {
            this.f2254d = false;
            this.f2251a = r2;
        }

        private void c() {
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L4:
            if (this.f2254d == false) goto L6;
            this.f2251a.a(this.f2252b, this.f2253c);     // Catch: Throwable -> L13
        L11:
            monitor-exit(this);     // Catch: Throwable -> L13
            return;
        L6:
            JSONObject r0 = this.f2252b;     // Catch: Throwable -> L13
            if (r0 == null) goto L11;
            h0 r1 = this.f2253c;     // Catch: Throwable -> L13
            if (r1 == null) goto L11;
            this.f2254d = true;     // Catch: Throwable -> L13
            this.f2251a.b(r0, r1);     // Catch: Throwable -> L13
            goto L11
        }

        @Override // com.bytedance.bdinstall.b0
        public void a(@NonNull h0 r1) {
            this.f2253c = r1;
            c();
        }

        @Override // com.bytedance.bdinstall.u
        public void b(JSONObject r1) {
            this.f2252b = r1;
            c();
        }
    }

    public interface f {
        void a(JSONObject r1, h0 r2);

        void b(JSONObject r1, h0 r2);
    }

    public a() {
        this.f2246a = new k();
    }

    @Override // com.bytedance.applog.n.c
    public h0 a() {
        return i.l();
    }

    @Override // com.bytedance.applog.n.c
    public void b(Application r1, String r2) {
        i.y(r1, r2);
    }

    @Override // com.bytedance.applog.n.c
    public i0 c() {
        return this.f2247b;
    }

    @Override // com.bytedance.applog.n.c
    public void d(f r1) {
        e r0 = new e(r1);
        i.a(true, r0);
        i.b(true, r0);
    }

    @Override // com.bytedance.applog.n.c
    public void e(Application r5, com.bytedance.applog.q.b r6, m r7, Looper r8, com.bytedance.applog.b r9) {
        l r0 = r6.t();
        this.f2248c = new com.bytedance.applog.n.b(r5);
        Handler r1 = new Handler(r8);
        s r2 = new s();
        r2.f2864a = new ExecutorC0070a(this, r1);
        r2.f2866c = r8;
        i.w(r2);
        k r10 = this.f2246a;
        r10.p(r5);
        r10.e(r0.c());
        r10.m(r0.I());
        r10.f(Integer.parseInt(r0.d()));
        r10.g(r0.e());
        r10.i(r0.n());
        r10.k(r0.v());
        r10.j(r0.f());
        r10.n(new b(this));
        r10.o(r0.i());
        r10.F(r0.z());
        r10.w(r0.o());
        r10.E(r0.Q());
        r10.B(r0.x());
        r10.d(r0.b());
        r10.s(false);
        r10.u(com.bytedance.applog.a.n());
        r10.r(r0.j());
        r10.y(r0.r());
        r10.x(r0.q());
        r10.I(r0.D());
        r10.J(r0.C());
        r10.G(r0.A());
        r10.H(r0.E());
        r10.A(r0.w());
        r10.C(r0.P());
        r10.D(r0.y());
        r10.K(r0.F());
        r10.h(r0.H());
        r10.c(r6.G());
        r10.z(r0.t());
        r10.q(this.f2248c);
        r10.l(r0.g());
        r10.b(r0.L());
        if (r0.l() == null) goto L6;
        this.f2246a.v(new c(this, r0));
    L6:
        if (r6.G() == false) goto L8;
        i.e(new d(this));
    L8:
        if (r9 == null) goto L11;
        r9.b(this.f2246a);
    L11:
        monitor-enter(a.class);
        i0 r11 = this.f2246a.a();     // Catch: Throwable -> L17
        i.o(r11, r7.c());     // Catch: Throwable -> L17
        this.f2246a = null;     // Catch: Throwable -> L17
        this.f2247b = r11;     // Catch: Throwable -> L17
        monitor-exit(a.class);     // Catch: Throwable -> L17
        if (r9 == null) goto L22;
        r9.a();
        return;
    L22:
        return;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.applog.n.c
    public String getDid() {
        return i.k();
    }

    @Override // com.bytedance.applog.n.c
    public void start() {
        i.z();
    }
}
