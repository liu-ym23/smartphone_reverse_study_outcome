package com.bytedance.bdinstall;

import android.app.Application;
import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class p0 implements com.bytedance.bdinstall.b1.b, o0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h0 f2855a;

    p0() {
        q.a("OTHER PROCESS IMPL");
    }

    @Override // com.bytedance.bdinstall.b1.b
    public h0 a() {
        h0 r0 = this.f2855a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    @Override // com.bytedance.bdinstall.o0.b
    public void b(h0 r3) {
        q.a("install info changed : " + r3);
        this.f2855a = r3;
        com.bytedance.bdinstall.x0.b.b(new com.bytedance.bdinstall.x0.g.b(r3));
    }

    @Override // com.bytedance.bdinstall.b1.b
    public r c() {
        return null;
    }

    @Override // com.bytedance.bdinstall.b1.b
    public void d(Application r1) {
        throw new IllegalStateException("BdInstall process is wrong");
    }

    @Override // com.bytedance.bdinstall.b1.b
    public void e(Context r1, Map<String, String> r2, boolean r3, boolean r4) {
    }

    @Override // com.bytedance.bdinstall.b1.b
    public void f(Context r1, r r2, long r3, n0 r5) {
    }

    @Override // com.bytedance.bdinstall.b1.b
    public boolean g(JSONObject r1) {
        return false;
    }

    @Override // com.bytedance.bdinstall.b1.b
    public String getDid() {
        h0 r0 = this.f2855a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c();
    }

    @Override // com.bytedance.bdinstall.b1.b
    public void h(i0 r2, r r3) {
        new o0(r2.t()).d(r2.t(), this);
        l.d(r2.t());
        com.bytedance.bdinstall.b1.e.b(o.class, new m(r2.t()));
    }

    @Override // com.bytedance.bdinstall.b1.b
    public void start() {
    }
}
