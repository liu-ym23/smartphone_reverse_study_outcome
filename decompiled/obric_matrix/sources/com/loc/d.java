package com.loc;

import android.content.Context;
import android.os.Build;
import com.bytedance.bdlocation.client.LocationInfoConst;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends f {
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    protected byte[] v;

    public d(Context r1) {
        super(r1);
    }

    @Override // com.loc.t0
    public final byte[] q() {
        byte[] r0 = this.v;
        if (r0 == null) goto L9;
        return r0;
    L9:
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L8
        r1.put("method", "remap");     // Catch: Throwable -> L8
        r1.put("package_name", i5.g(this.f7283l));     // Catch: Throwable -> L8
        r1.put("model", Build.MODEL);     // Catch: Throwable -> L8
        r1.put("os_version", Build.VERSION.RELEASE);     // Catch: Throwable -> L8
        r1.put("os_type", LocationInfoConst.SYSTEM);     // Catch: Throwable -> L8
        r1.put("sdk_version", "4.3.6");     // Catch: Throwable -> L8
        String r2 = b.a();     // Catch: Throwable -> L8
        this.m = r2;     // Catch: Throwable -> L8
        r1.put("t1", r2);     // Catch: Throwable -> L8
        r1.put("old_t1", v5.n(this.f7283l));     // Catch: Throwable -> L8
        String r3 = b.e();     // Catch: Throwable -> L8
        this.n = r3;     // Catch: Throwable -> L8
        r1.put("t2", r3);     // Catch: Throwable -> L8
        r1.put("old_t2", v5.p(this.f7283l));     // Catch: Throwable -> L8
        String r4 = b.h();     // Catch: Throwable -> L8
        this.o = r4;     // Catch: Throwable -> L8
        r1.put("t3", r4);     // Catch: Throwable -> L8
        r1.put("old_t3", v5.r(this.f7283l));     // Catch: Throwable -> L8
        String r5 = b.i();     // Catch: Throwable -> L8
        this.p = r5;     // Catch: Throwable -> L8
        r1.put("s1", r5);     // Catch: Throwable -> L8
        r1.put("old_s1", v5.t(this.f7283l));     // Catch: Throwable -> L8
        String r6 = b.j();     // Catch: Throwable -> L8
        this.q = r6;     // Catch: Throwable -> L8
        r1.put("s2", r6);     // Catch: Throwable -> L8
        r1.put("old_s2", v5.v(this.f7283l));     // Catch: Throwable -> L8
        String r7 = b.k();     // Catch: Throwable -> L8
        this.r = r7;     // Catch: Throwable -> L8
        r1.put("s3", r7);     // Catch: Throwable -> L8
        r1.put("old_s3", v5.x(this.f7283l));     // Catch: Throwable -> L8
        String r8 = b.l();     // Catch: Throwable -> L8
        this.s = r8;     // Catch: Throwable -> L8
        r1.put("s4", r8);     // Catch: Throwable -> L8
        r1.put("old_s4", v5.z(this.f7283l));     // Catch: Throwable -> L8
        r1.put("uuid", b.b(this.f7283l));     // Catch: Throwable -> L8
        r1.put("android_id", l5.G());     // Catch: Throwable -> L8
        r1.put("hostname", b.m());     // Catch: Throwable -> L8
        String r9 = l5.e0(this.f7283l);     // Catch: Throwable -> L8
        this.t = r9;     // Catch: Throwable -> L8
        r1.put("gaid", r9);     // Catch: Throwable -> L8
        r1.put("old_gaid", v5.B(this.f7283l));     // Catch: Throwable -> L8
        String r10 = l5.D(this.f7283l);     // Catch: Throwable -> L8
        this.u = r10;     // Catch: Throwable -> L8
        r1.put("oaid", r10);     // Catch: Throwable -> L8
        r1.put("old_oaid", v5.d(this.f7283l));     // Catch: Throwable -> L8
        r1.put("aaid", v5.f(this.f7283l));     // Catch: Throwable -> L8
        r1.put("resetToken", v5.l(this.f7283l));     // Catch: Throwable -> L8
        r1.put("uabc", v5.j(this.f7283l));     // Catch: Throwable -> L8
        byte[] r11 = u5.z(r1.toString().getBytes("utf-8"));     // Catch: Throwable -> L8
        b.d(r11, u5.u("YWDR1a2R2WEd0M3RXdHRocg==").getBytes());     // Catch: Throwable -> L8
        this.v = r11;     // Catch: Throwable -> L8
    L7:
        return this.v;
    }
}
