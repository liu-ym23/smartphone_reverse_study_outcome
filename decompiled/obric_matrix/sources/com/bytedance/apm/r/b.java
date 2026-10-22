package com.bytedance.apm.r;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.services.apm.api.IActivityLifeObserver;

/* JADX INFO: loaded from: classes.dex */
public class b extends a implements IActivityLifeObserver, com.bytedance.apm.i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private l f1819d;

    public b() {
        this.f1819d = l.v();
    }

    @Override // com.bytedance.apm.i
    public void b(com.bytedance.apm.config.e r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        long r0 = r8.b();
        long r2 = r8.c();
        boolean r4 = r8.h();
        boolean r5 = r8.e();
        this.f1819d.L(r4);
        this.f1819d.I(r0);
        this.f1819d.Q(r2);
        this.f1819d.K(r5);
        this.f1819d.O(r8.f());
        l r7 = this.f1819d;
        if (com.bytedance.apm.d.I() == false) goto L7;
    L10:
        boolean r9 = true;
    L11:
        r7.P(r9);
        return;
    L7:
        if (r8.i() == true) goto L10;
        r9 = false;
        goto L11
    }

    @Override // com.bytedance.apm.r.a
    public void c(String r2) {
        super.c(r2);
        if (this.f1818c == false) goto L6;
        this.f1819d.D(r2);
        return;
    }

    @Override // com.bytedance.apm.r.a
    public void d(long r1, long r3, long r5, long r7, boolean r9) {
        super.d(r1, r3, r5, r7, r9);
        if (this.f1818c == false) goto L6;
        this.f1819d.C(r9);
        return;
    }

    public void i() {
        ActivityLifeObserver.getInstance().register(this);
        com.bytedance.apm.j.a(this);
        this.f1819d.y();
        com.bytedance.apm.r.m.e.A().u(this);
        com.bytedance.apm.r.m.e.A().N();
        this.f1817b = true;
        if (com.bytedance.apm.d.C() == false) goto L6;
        com.bytedance.apm.x.e.b("BlockDetector", new String[]{"BlockDetector init: "});
        return;
    }

    public void j(com.bytedance.apm.w.c r1) {
        this.f1819d.J(r1);
    }

    public void k(long r1) {
        this.f1819d.I(r1);
    }

    public void l(boolean r1) {
        this.f1819d.N(r1);
    }

    public void m(boolean r1) {
        this.f1819d.R(r1);
    }

    public void n(boolean r1) {
        this.f1819d.S(r1);
    }

    public void o() {
        if (this.f1817b == true) goto L5;
        return;
    L5:
        if (this.f1818c == true) goto L13;
        this.f1818c = true;
        if (com.bytedance.apm.d.C() == false) goto L12;
        com.bytedance.apm.x.e.b("BlockDetector", new String[]{"BlockDetector start: "});
        return;
    L12:
        return;
    }

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
        p();
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onChange(Activity r1, Fragment r2) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r1) {
        o();
    }

    public void p() {
        if (this.f1818c == true) goto L5;
        return;
    L5:
        this.f1818c = false;
        this.f1819d.C(false);
        if (com.bytedance.apm.d.C() == false) goto L9;
        com.bytedance.apm.x.e.b("BlockDetector", new String[]{"BlockDetector stop: "});
        return;
    }
}
