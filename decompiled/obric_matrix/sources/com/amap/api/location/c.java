package com.amap.api.location;

import com.loc.s4;

/* JADX INFO: loaded from: classes.dex */
public class c implements Cloneable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f511f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f512g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f513h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f514i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f515j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f516k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    AMapLocationClientOption.b f517l;

    public c() {
        this.f511f = false;
        this.f512g = 2;
        this.f513h = 0;
        this.f514i = "UNKNOWN";
        this.f515j = 0;
        this.f516k = false;
        this.f517l = AMapLocationClientOption.b.f491h;
    }

    protected c a() {
        c r0 = new c();
        super.clone();     // Catch: Throwable -> L9
    L12:
        r0.d(this.f512g);     // Catch: Throwable -> L6
        r0.c(this.f513h);     // Catch: Throwable -> L6
        r0.j(this.f511f);     // Catch: Throwable -> L6
        r0.h(this.f515j);     // Catch: Throwable -> L6
        r0.i(this.f514i);     // Catch: Throwable -> L6
        r0.f(this.f517l);     // Catch: Throwable -> L6
        r0.e(this.f516k);     // Catch: Throwable -> L6
    L8:
        return r0;
    L6:
        th = move-exception;
        s4.h(th, "AMapLocationQualityReport", "clone");
        goto L8
    }

    public void c(int r1) {
        this.f513h = r1;
    }

    protected /* bridge */ /* synthetic */ Object clone() {
        return a();
    }

    public void d(int r1) {
        this.f512g = r1;
    }

    public void e(boolean r1) {
        this.f516k = r1;
    }

    public void f(AMapLocationClientOption.b r1) {
        this.f517l = r1;
    }

    public void h(long r1) {
        this.f515j = r1;
    }

    public void i(String r1) {
        this.f514i = r1;
    }

    public void j(boolean r1) {
        this.f511f = r1;
    }
}
