package com.bytedance.bdinstall;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f2778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f2779d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f2780e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f2781f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.bytedance.bdinstall.d1.n<PackageInfo> f2782g;

    class a extends com.bytedance.bdinstall.d1.n<PackageInfo> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f2783b;

        a(h r1) {
            this.f2783b = r1;
        }

        @Override // com.bytedance.bdinstall.d1.n
        protected /* bridge */ /* synthetic */ PackageInfo a(Object[] r1) {
            return c(r1);
        }

        protected PackageInfo c(Object... r2) {
            return h.a(this.f2783b).getPackageManager().getPackageInfo(h.a(this.f2783b).getPackageName(), 0);
        L4:
            th = move-exception;
            q.d("AppVersionCompat#getPackageInfo error", th);
            return null;
        }
    }

    h(k r3) {
        this.f2782g = new a(this);
        this.f2781f = r3.n;
        this.f2776a = r3.q;
        if (TextUtils.isEmpty(r3.r) == false) goto L5;
        String r0 = "";
    L6:
        this.f2777b = r0;
        this.f2778c = r3.s;
        this.f2779d = r3.t;
        this.f2780e = r3.u;
        return;
    L5:
        r0 = r3.r;
        goto L6
    }

    static /* synthetic */ Context a(h r0) {
        return r0.f2781f;
    }

    public long b() {
        if (this.f2780e != 0) goto L9;
        PackageInfo r0 = this.f2782g.b(new Object[0]);
        if (r0 == null) goto L9;
        return r0.versionCode;
    L9:
        return this.f2780e;
    }

    public long c() {
        if (this.f2779d != 0) goto L9;
        PackageInfo r0 = this.f2782g.b(new Object[0]);
        if (r0 == null) goto L9;
        return r0.versionCode;
    L9:
        return this.f2779d;
    }

    public String d() {
        if (TextUtils.isEmpty(this.f2776a) == false) goto L9;
        PackageInfo r0 = this.f2782g.b(new Object[0]);
        if (r0 == null) goto L9;
        return r0.versionName;
    L9:
        return this.f2776a;
    }

    public long e() {
        if (this.f2778c != 0) goto L9;
        PackageInfo r0 = this.f2782g.b(new Object[0]);
        if (r0 == null) goto L9;
        return r0.versionCode;
    L9:
        return this.f2778c;
    }

    public String f() {
        return this.f2777b;
    }
}
