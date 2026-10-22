package com.bytedance.bdinstall;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class j0 implements com.bytedance.bdinstall.b1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile i0 f2816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile g0 f2817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile com.bytedance.bdinstall.z0.k f2818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f2819d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bytedance.bdinstall.w0.a f2820e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f2821f;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ j0 f2822f;

        a(j0 r1) {
            this.f2822f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            j0.b(this.f2822f, false);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ r f2823f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ j0 f2824g;

        b(j0 r1, r r2) {
            this.f2824g = r1;
            this.f2823f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j0.j(this.f2824g).get() == false) goto L5;
            j0.i(this.f2824g).m(this.f2823f, true, false);
            return;
        L5:
            q.a("not start yet,start it " + this.f2823f);
            j0.i(this.f2824g).k(this.f2823f, false);
            j0.b(this.f2824g, true);
            j0.k(this.f2824g);
        }
    }

    j0() {
        this.f2819d = new AtomicBoolean(false);
        this.f2820e = new com.bytedance.bdinstall.w0.a();
        this.f2821f = new AtomicBoolean(false);
    }

    static /* synthetic */ void b(j0 r0, boolean r1) {
        r0.l(r1);
    }

    static /* synthetic */ g0 i(j0 r0) {
        return r0.f2817b;
    }

    static /* synthetic */ AtomicBoolean j(j0 r0) {
        return r0.f2819d;
    }

    static /* synthetic */ void k(j0 r0) {
        r0.n();
    }

    private void l(boolean r3) {
        if (m() == false) goto L13;
        if (this.f2819d.getAndSet(true) == false) goto L7;
        return;
    L7:
        com.bytedance.bdinstall.b1.c r0 = (com.bytedance.bdinstall.b1.c) com.bytedance.bdinstall.b1.e.a(com.bytedance.bdinstall.b1.c.class);
        if (r0 == null) goto L10;
        r0.start();
    L10:
        this.f2818c.B();
        this.f2817b.p(r3);
        new o0(this.f2816a.t()).e();
        return;
    L13:
        throw new RuntimeException("please init first");
    }

    private boolean m() {
        if (this.f2817b == null) goto L5;
        return true;
    L5:
        return false;
    }

    private void n() {
        if (com.bytedance.bdinstall.d1.h.a(this.f2816a.t()).getBoolean("_install_started_v2", false) == true) goto L6;
        com.bytedance.bdinstall.d1.h.a(this.f2816a.t()).edit().putBoolean("_install_started_v2", true).apply();
        return;
    }

    @Override // com.bytedance.bdinstall.b1.b
    public h0 a() {
        if (this.f2818c != null) goto L7;
        return null;
    L7:
        return this.f2818c.l();
    }

    @Override // com.bytedance.bdinstall.b1.b
    public r c() {
        return this.f2818c.h();
    }

    @Override // com.bytedance.bdinstall.b1.b
    public void d(Application r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.f2821f.compareAndSet(false, true) == false) goto L8;
        r4.registerActivityLifecycleCallbacks(this.f2820e);
        return;
    }

    @Override // com.bytedance.bdinstall.b1.b
    public void e(Context r5, Map<String, String> r6, boolean r7, boolean r8) {
        SharedPreferences r9 = com.bytedance.bdinstall.d1.h.a(r5);
        if (r7 == false) goto L5;
        SharedPreferences.Editor r10 = r9.edit();
    L6:
        boolean r0 = false;
        if (this.f2818c == null) goto L22;
        Iterator<Map.Entry<String, String>> r11 = r6.entrySet().iterator();
        boolean r12 = false;
    L10:
        if (r11.hasNext() == false) goto L19;
        Map.Entry<String, String> r1 = r11.next();
        String r2 = r1.getKey();
        String r3 = r1.getValue();
        if (this.f2818c.D(r2, r3) == true) goto L16;
        if (r12 == true) goto L16;
        r12 = false;
    L17:
        if (r10 == null) goto L10;
        r10.putString(r2, r3);
    L16:
        r12 = true;
        goto L17
    L19:
        if (r10 == null) goto L21;
        r10.apply();
    L21:
        r0 = r12;
    L22:
        if (r0 == false) goto L27;
        if (r8 == false) goto L27;
        if (this.f2817b == null) goto L27;
        this.f2817b.n();
    L27:
        if (r0 == false) goto L35;
        com.bytedance.bdinstall.x0.b.b(new com.bytedance.bdinstall.x0.g.a(this.f2818c.g()));
        return;
    L35:
        return;
    L5:
        r10 = null;
        goto L6
    }

    @Override // com.bytedance.bdinstall.b1.b
    public void f(Context r2, r r3, long r4, n0 r6) {
        q.a("install#resetInstallInfoWhenSwitchChildMode");
        if (this.f2817b == null) goto L5;
        q.a("resetInstallInfoWhenSwitchChildMode " + r3);
        com.bytedance.bdinstall.d1.r r5 = new com.bytedance.bdinstall.d1.r(r4, r6);
        i.b(false, r5);
        r5.d();
        t.e(new b(this, r3));
        return;
    L5:
        q.i(new RuntimeException("not init yet"));
    }

    @Override // com.bytedance.bdinstall.b1.b
    public boolean g(JSONObject r2) {
        if (this.f2818c == null) goto L8;
        JSONObject r1 = this.f2818c.j();
        if (r1 == null) goto L10;
        v0.c(r2, r1);
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    @Override // com.bytedance.bdinstall.b1.b
    public String getDid() {
        if (this.f2818c != null) goto L7;
        return null;
    L7:
        return this.f2818c.i();
    }

    @Override // com.bytedance.bdinstall.b1.b
    public void h(i0 r9, r r10) {
        long r0 = System.currentTimeMillis();
        q.a("main process install#init");
        monitor-enter(j0.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.f2817b != null) goto L15;
        this.f2816a = r9;     // Catch: Throwable -> L18
        q.f2856a = r9.P();     // Catch: Throwable -> L18
        if (r9.x() == null) goto L10;
        q.f(r9.x());     // Catch: Throwable -> L18
    L10:
        if (TextUtils.equals(r9.r(), "local_test") == true) goto L21;
    L14:
        this.f2818c = new com.bytedance.bdinstall.z0.p(r9.t(), r9, r10);     // Catch: Throwable -> L18
        this.f2817b = new g0(r9, this.f2818c, this.f2820e, r10);     // Catch: Throwable -> L18
        com.bytedance.bdinstall.b1.e.b(o.class, new p(r9.t(), r10));     // Catch: Throwable -> L18
        goto L15
    L21:
        com.bytedance.bdinstall.b1.e.b(com.bytedance.bdinstall.b1.c.class, (com.bytedance.bdinstall.b1.c) Class.forName("com.bytedance.bdinstall.nu.NUModeServiceImpl").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r9.t()}));     // Catch: Throwable -> L13
    L13:
        q.c("not find new user mode impl ,ignore");     // Catch: Throwable -> L18
    L15:
        monitor-exit(j0.class);     // Catch: Throwable -> L18
        q.a("init ：" + (System.currentTimeMillis() - r0));
    }

    @Override // com.bytedance.bdinstall.b1.b
    public void start() {
        if (m() == false) goto L7;
        q.a("install#start");
        t.e(new a(this));
        n();
        return;
    L7:
        throw new RuntimeException("please init first");
    }
}
