package com.bytedance.bdturing.verify.b;

import android.app.Activity;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f3225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f3227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3228d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f3229e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f3230f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f3231g;

    public a() {
        this.f3229e = true;
        this.f3230f = true;
        this.f3231g = "";
    }

    public abstract void a(StringBuilder r1);

    public final Activity b() {
        return this.f3225a;
    }

    public abstract int c();

    public boolean d() {
        return this.f3226b;
    }

    public final boolean e() {
        return this.f3230f;
    }

    public final String f() {
        return this.f3231g;
    }

    public final boolean g() {
        return this.f3229e;
    }

    public final boolean h() {
        return this.f3228d;
    }

    public abstract String i();

    public abstract int j();

    public final String k() {
        StringBuilder r0 = com.bytedance.bdturing.s.b.f3140a.b(j(), i(), this.f3225a);
        if (this.f3227c == false) goto L5;
        com.bytedance.bdturing.x.e.b(r0, "preload", 1);
    L5:
        a(r0);
        String r4 = r0.toString();
        o.b(r4, "queryBuilder.toString()");
        return r4;
    }

    public final void l(Activity r1) {
        this.f3225a = r1;
    }

    public void m(boolean r1) {
        this.f3226b = r1;
    }

    public final void n(boolean r1) {
        this.f3230f = r1;
    }

    public final void o(String r2) {
        o.g(r2, "<set-?>");
        this.f3231g = r2;
    }

    public final void p(boolean r1) {
        this.f3229e = r1;
    }
}
