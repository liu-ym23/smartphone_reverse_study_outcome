package com.bytedance.bdturing.v;

import android.os.Looper;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f3189a;

    public b(a r2) {
        o.g(r2, "configProvider");
        this.f3189a = r2;
    }

    @Override // com.bytedance.bdturing.v.a
    public String a() {
        return this.f3189a.a();
    }

    @Override // com.bytedance.bdturing.v.a
    public String b() {
        return this.f3189a.b();
    }

    @Override // com.bytedance.bdturing.v.a
    public Looper c() {
        return this.f3189a.c();
    }

    @Override // com.bytedance.bdturing.v.a
    public com.bytedance.bdturing.ttnet.b d() {
        return this.f3189a.d();
    }

    @Override // com.bytedance.bdturing.v.a
    public f e() {
        return this.f3189a.e();
    }

    @Override // com.bytedance.bdturing.v.a
    public String f() {
        return this.f3189a.f();
    }

    @Override // com.bytedance.bdturing.v.a
    public String g() {
        return this.f3189a.g();
    }

    @Override // com.bytedance.bdturing.v.a
    public String getAppId() {
        return this.f3189a.getAppId();
    }

    @Override // com.bytedance.bdturing.v.a
    public String getAppName() {
        return this.f3189a.getAppName();
    }

    @Override // com.bytedance.bdturing.v.a
    public String getChannel() {
        return this.f3189a.getChannel();
    }

    @Override // com.bytedance.bdturing.v.a
    public String getDeviceId() {
        return this.f3189a.getDeviceId();
    }

    @Override // com.bytedance.bdturing.v.a
    public String getInstallId() {
        return this.f3189a.getInstallId();
    }

    @Override // com.bytedance.bdturing.v.a
    public String getRegion() {
        String r1 = this.f3189a.getRegion();
        if (o.a(r1, e.f3195g.a()) == false) goto L6;
    L19:
        return r1;
    L6:
        if (o.a(r1, e.f3196h.a()) == true) goto L19;
        if (o.a(r1, e.f3197i.a()) == true) goto L19;
        if (o.a(r1, e.f3198j.a()) == true) goto L19;
        if (o.a(r1, e.f3199k.a()) == true) goto L19;
        if (com.bytedance.bdturing.g.d() == false) goto L19;
        throw new RuntimeException("not support this region");
    }
}
