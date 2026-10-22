package com.bytedance.applog.u;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f2406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f2407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f2408e;

    public i(String r1, String r2) {
        this.f2404a = r1;
        this.f2405b = r2;
    }

    public i(String r1, String r2, String r3) {
        this(r1, r2);
        this.f2408e = r3;
    }

    public String a() {
        return this.f2404a;
    }

    public String b() {
        return this.f2405b;
    }

    public String c() {
        return this.f2406c;
    }

    public String d() {
        return this.f2407d;
    }

    public String e() {
        return this.f2408e;
    }

    public void f(String r1) {
        this.f2406c = r1;
    }

    public void g(String r1) {
        this.f2407d = r1;
    }
}
