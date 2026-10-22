package com.bytedance.apm.t;

import android.text.TextUtils;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.k;
import com.bytedance.apm.t.b;
import com.bytedance.apm.util.h;
import com.bytedance.apm.x.e;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import d.b.b.d.c.d;
import d.b.v.a.c;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T extends com.bytedance.apm.t.b> implements IConfigListener {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f1956e = 1000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f1957f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedList<T> f1958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f1959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f1960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1961d;

    /* JADX INFO: renamed from: com.bytedance.apm.t.a$a, reason: collision with other inner class name */
    class RunnableC0062a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.bytedance.apm.t.b f1962f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ a f1963g;

        RunnableC0062a(a r1, com.bytedance.apm.t.b r2) {
            this.f1963g = r1;
            this.f1962f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(this.f1963g, this.f1962f);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f1964f;

        b(a r1) {
            this.f1964f = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            LinkedList r0 = a.b(this.f1964f);
            monitor-enter(r0);
            LinkedList r1 = new LinkedList(a.b(this.f1964f));     // Catch: Throwable -> L11
            a.b(this.f1964f).clear();     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            Iterator r2 = r1.iterator();
        L8:
            if (r2.hasNext() == false) goto L10;
            com.bytedance.apm.t.b r3 = (com.bytedance.apm.t.b) r2.next();
            this.f1964f.f(r3);
            goto L8
        L10:
            return;
        L11:
            th = move-exception;
            throw th;
        }
    }

    static {
    }

    protected a() {
        this.f1960c = false;
        this.f1961d = false;
        this.f1958a = new LinkedList();
    }

    static /* synthetic */ void a(a r0, com.bytedance.apm.t.b r1) {
        r0.h(r1);
    }

    static /* synthetic */ LinkedList b(a r0) {
        return r0.f1958a;
    }

    private void c(T r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        LinkedList<T> r0 = this.f1958a;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L7:
        if (this.f1958a.size() <= f1956e) goto L14;
        T r1 = this.f1958a.poll();     // Catch: Throwable -> L17
        if (f1957f == true) goto L11;
    L23:
        com.bytedance.apm.x.a.d("apm_debug", "apm_cache_buffer_full:" + r1.c().toString());     // Catch: Exception -> L20 Throwable -> L17
        goto L14
    L11:
        if (this.f1960c == true) goto L23;
        k.e().c("apm_cache_buffer_full");     // Catch: Throwable -> L17
        this.f1960c = true;     // Catch: Throwable -> L17
    L14:
        this.f1958a.add(r6);     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
    }

    private void g() {
        com.bytedance.apm.f0.b.f().i(new b(this));
    }

    private void h(T r2) {
        if (d(r2) == true) goto L5;
        return;
    L5:
        i(r2);
        if (this.f1959b == false) goto L8;
        f(r2);
        return;
    L8:
        c(r2);
    }

    protected static boolean k() {
        if (ActivityLifeObserver.getInstance() != null) goto L6;
        return true;
    L6:
        return !ActivityLifeObserver.getInstance().isForeground();
    }

    private void m(c r2) {
        if ("batch_tracing".equals(r2.a()) == false) goto L5;
        d.b.b.d.a.m(new d(d.b.v.a.a.a(r2.c())));
        return;
    L5:
        d.b.b.d.a.m(new d(r2.c()));
    }

    public static void n(int r0) {
        f1956e = r0;
    }

    public static void o(boolean r0) {
        f1957f = r0;
    }

    protected boolean d(T r1) {
        return true;
    }

    public final void e(T r3) {
        if (com.bytedance.apm.f0.b.f().g() == true) goto L5;
        com.bytedance.apm.f0.b.f().i(new RunnableC0062a(this, r3));
        return;
    L5:
        h(r3);
    }

    protected abstract void f(T r1);

    protected void i(T r1) {
    }

    public void j() {
        ((IConfigManager) com.bytedance.news.common.service.manager.d.a(IConfigManager.class)).registerConfigListener(this);
    }

    protected void l(String r5, String r6, JSONObject r7, boolean r8, boolean r9) {
        if (com.bytedance.apm.d.C() == false) goto L5;
        e.b("BaseDataPipeline", new String[]{"type:" + r5 + " isSaveUnSampleLog:" + r9 + "isSampled:" + r8 + " log:" + r7});
    L5:
        if (r8 == false) goto L19;
        if (this.f1961d == false) goto L9;
        JSONObject r10 = h.i(r7);
    L11:
        if (TextUtils.equals(r5, "tracing") == false) goto L14;
        m(new c(r10, null, false, r6));
    L28:
        com.bytedance.apm.z.a.b().c(r5, r6, r7);
        if (TextUtils.equals(r5, "ui_action") == false) goto L34;
        com.bytedance.apm.t.e.a.b().a(r7);
        return;
    L34:
        return;
    L14:
        if (TextUtils.equals(r5, "common_log") == false) goto L16;
        d.b.b.d.c.c r4 = new d.b.b.d.c.c(r6, r10);
    L17:
        d.b.b.d.a.i(r4);
        goto L28
    L16:
        r4 = new d.b.b.d.c.c(r5, r10);
        goto L17
    L9:
        r10 = h.b(r7);
        goto L11
    L19:
        if (com.bytedance.apm.d.C() == false) goto L21;
        com.bytedance.apm.doctor.a.b(r5, r7, false);
    L21:
        if (r9 == false) goto L28;
        if (com.bytedance.apm.x.a.f() == false) goto L28;
        com.bytedance.apm.x.a.g(r5, r7.toString());     // Catch: Exception -> L26
    L26:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "apm_unsampled_log_error");
        goto L28
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onReady() {
        this.f1959b = true;
        g();
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onRefresh(JSONObject r1, boolean r2) {
    }
}
