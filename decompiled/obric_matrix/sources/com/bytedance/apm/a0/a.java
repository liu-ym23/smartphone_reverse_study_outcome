package com.bytedance.apm.a0;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.services.apm.api.IActivityLifeObserver;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements IActivityLifeObserver, IConfigListener, com.bytedance.apm.f0.b.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1121d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected String f1122e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f1123f;

    public a() {
    }

    private final void l() {
        if (this.f1121d == true) goto L7;
        this.f1121d = true;
        if (f() == false) goto L7;
        com.bytedance.apm.f0.b.f().c(this);
    L7:
        i();
        this.f1123f = System.currentTimeMillis();
    }

    public final void b() {
        ActivityLifeObserver.getInstance().unregister(this);
        ((IConfigManager) com.bytedance.news.common.service.manager.d.a(IConfigManager.class)).unregisterConfigListener(this);
        g();
    }

    protected void c(JSONObject r1) {
    }

    public final void d() {
        if (this.f1120c == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(this.f1122e) == true) goto L12;
        this.f1120c = true;
        ActivityLifeObserver.getInstance().register(this);
        this.f1119b = !ActivityLifeObserver.getInstance().isForeground();
        h();
        ((IConfigManager) com.bytedance.news.common.service.manager.d.a(IConfigManager.class)).registerConfigListener(this);
        if (com.bytedance.apm.d.C() == false) goto L13;
        com.bytedance.apm.x.e.b("AbstractPerfCollector", new String[]{"perf init: " + this.f1122e});
        return;
    L13:
        return;
    L12:
        throw new IllegalStateException("Must set collector Setting key, before init");
    }

    protected boolean e() {
        return this.f1119b;
    }

    protected abstract boolean f();

    protected void g() {
    }

    protected void h() {
    }

    protected void i() {
    }

    protected void j() {
    }

    protected void k(com.bytedance.apm.t.d.e r1) {
        b.c(r1);
        b.a(r1, r1.j());
        com.bytedance.apm.t.c.a.p().e(r1);
    }

    public final void m() {
        if (this.f1121d == false) goto L7;
        this.f1121d = false;
        if (f() == false) goto L7;
        com.bytedance.apm.f0.b.f().m(this);
    L7:
        j();
    }

    protected abstract long n();

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityCreated(Activity r1, Bundle r2) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityPause(Activity r1) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityResume(Activity r1) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityStarted(Activity r1) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onBackground(Activity r1) {
        this.f1119b = true;
        if (com.bytedance.apm.d.J() == false) goto L6;
        m();
        return;
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onChange(Activity r1, Fragment r2) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r1) {
        this.f1119b = false;
        if (com.bytedance.apm.d.J() == true) goto L5;
        return;
    L5:
        if (this.f1118a == false) goto L9;
        l();
        return;
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onReady() {
        this.f1118a = true;
        l();
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onRefresh(JSONObject r1, boolean r2) {
        JSONObject r3 = r1.optJSONObject("performance_modules");
        if (r3 != null) goto L5;
        return;
    L5:
        JSONObject r4 = r3.optJSONObject(this.f1122e);
        if (r4 != null) goto L8;
        return;
    L8:
        c(r4);
    }

    @Override // com.bytedance.apm.f0.b.e
    public final void onTimeEvent(long r5) {
        long r0 = n();
        if (r0 > 0) goto L5;
        return;
    L5:
        if ((r5 - this.f1123f) > r0) goto L7;
        return;
    L7:
        if (this.f1118a == false) goto L12;
        i();
        this.f1123f = System.currentTimeMillis();
        return;
    }
}
