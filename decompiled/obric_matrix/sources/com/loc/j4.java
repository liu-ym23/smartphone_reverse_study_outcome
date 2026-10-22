package com.loc;

import com.amap.api.location.AMapLocation;

/* JADX INFO: loaded from: classes2.dex */
@a0(a = "c")
public class j4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @b0(a = "a2", b = 6)
    private String f7418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @b0(a = "a3", b = 5)
    private long f7419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @b0(a = "a4", b = 6)
    private String f7420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AMapLocation f7421d;

    public j4() {
    }

    public final AMapLocation a() {
        return this.f7421d;
    }

    public final void b(long r1) {
        this.f7419b = r1;
    }

    public final void c(AMapLocation r1) {
        this.f7421d = r1;
    }

    public final void d(String r1) {
        this.f7420c = r1;
    }

    public final String e() {
        return this.f7420c;
    }

    public final void f(String r1) {
        this.f7418a = r1;
    }

    public final String g() {
        return this.f7418a;
    }

    public final long h() {
        return this.f7419b;
    }
}
