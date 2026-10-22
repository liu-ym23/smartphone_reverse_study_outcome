package com.bytedance.bdinstall.d1;

import android.text.TextUtils;
import com.bytedance.bdinstall.i0;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.bdinstall.g f2731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private i0 f2732b;

    public j(com.bytedance.bdinstall.g r1) {
        this.f2731a = r1;
    }

    public j(i0 r1) {
        this.f2732b = r1;
    }

    public long a() {
        i0 r0 = this.f2732b;
        if (r0 == null) goto L7;
        int r2 = r0.j();
    L6:
        return r2;
    L7:
        com.bytedance.bdinstall.g r3 = this.f2731a;
        if (r3 == null) goto L10;
        r2 = r3.getAid();
        goto L6
    L10:
        return 0;
    }

    public String b() {
        i0 r0 = this.f2732b;
        if (r0 != null) goto L5;
        com.bytedance.bdinstall.g r1 = this.f2731a;
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.getAppName();
    L5:
        return r0.m();
    }

    public String c() {
        i0 r0 = this.f2732b;
        if (r0 == null) goto L7;
        String r1 = r0.F();
        if (TextUtils.isEmpty(r1) == true) goto L15;
        return r1;
    L15:
        return this.f2732b.r();
    L7:
        com.bytedance.bdinstall.g r2 = this.f2731a;
        if (r2 == null) goto L12;
        String r3 = r2.a();
        if (TextUtils.isEmpty(r3) == true) goto L17;
        return r3;
    L17:
        return this.f2731a.getChannel();
    L12:
        return null;
    }

    public long d() {
        i0 r0 = this.f2732b;
        if (r0 != null) goto L5;
        com.bytedance.bdinstall.g r2 = this.f2731a;
        if (r2 != null) goto L9;
        return 0;
    L9:
        return r2.getManifestVersionCode();
    L5:
        return r0.y();
    }

    public long e() {
        i0 r0 = this.f2732b;
        if (r0 != null) goto L5;
        com.bytedance.bdinstall.g r2 = this.f2731a;
        if (r2 != null) goto L9;
        return 0;
    L9:
        return r2.getUpdateVersionCode();
    L5:
        return r0.G();
    }

    public String f() {
        i0 r0 = this.f2732b;
        if (r0 != null) goto L5;
        com.bytedance.bdinstall.g r1 = this.f2731a;
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.getVersion();
    L5:
        return r0.I();
    }

    public long g() {
        i0 r0 = this.f2732b;
        if (r0 != null) goto L5;
        com.bytedance.bdinstall.g r2 = this.f2731a;
        if (r2 != null) goto L9;
        return 0;
    L9:
        return r2.getVersionCode();
    L5:
        return r0.J();
    }
}
