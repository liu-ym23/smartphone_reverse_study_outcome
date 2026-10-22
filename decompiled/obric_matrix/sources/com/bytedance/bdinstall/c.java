package com.bytedance.bdinstall;

import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
class c extends j {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f2675h = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final i0 f2676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final r f2677g;

    static {
    }

    c(i0 r2, r r3) {
        super(r2.t());
        this.f2676f = r2;
        this.f2677g = r3;
    }

    private String n() {
        StringBuilder r1 = new StringBuilder(f.b(this.f2808a, new StringBuilder(this.f2677g.a().d()), null, true, m0.f2842f));
        float r0 = p();     // Catch: Throwable -> L20
        d.b(r1, "req_id", com.bytedance.bdinstall.d1.k.b());     // Catch: Throwable -> L20
        com.bytedance.bdinstall.y0.b r2 = this.f2676f.q();     // Catch: Throwable -> L20
        if (r2 == null) goto L6;
        d.b(r1, "app_trait", r2.a(this.f2676f.t()));     // Catch: Throwable -> L20
    L6:
        d.b(r1, "timezone", r0 + "");     // Catch: Throwable -> L20
        String r3 = this.f2676f.L();     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r3) == true) goto L26;
        d.b(r1, "package", r3);     // Catch: Throwable -> L20
        d.b(r1, "real_package_name", this.f2808a.getPackageName());     // Catch: Throwable -> L20
    L26:
        TelephonyManager r4 = (TelephonyManager) this.f2808a.getSystemService("phone");     // Catch: Exception -> L23 Throwable -> L20
        d.b(r1, "carrier", r4.getNetworkOperatorName());     // Catch: Exception -> L23 Throwable -> L20
        d.b(r1, "mcc_mnc", r4.getNetworkOperator());     // Catch: Exception -> L23 Throwable -> L20
        d.b(r1, "sim_region", r4.getSimCountryIso());     // Catch: Exception -> L23 Throwable -> L20
    L10:
        e.a(this.f2808a, this.f2676f, r1);     // Catch: Throwable -> L20
        d.b(r1, "app_version_minor", this.f2676f.K());     // Catch: Throwable -> L20
        d.b(r1, "custom_bt", String.valueOf(o()));     // Catch: Throwable -> L20
        a0 r5 = this.f2676f.h();     // Catch: Throwable -> L20
        if (r5 == null) goto L18;
        HashMap<String, String> r6 = r5.a(m0.f2842f);     // Catch: Throwable -> L20
        if (r6 == null) goto L18;
        Iterator<Map.Entry<String, String>> r7 = r6.entrySet().iterator();     // Catch: Throwable -> L20
    L16:
        if (r7.hasNext() == false) goto L18;
        Map.Entry<String, String> r8 = r7.next();     // Catch: Throwable -> L20
        d.b(r1, r8.getKey(), r8.getValue());     // Catch: Throwable -> L20
    L18:
        return r1.toString();
    L20:
        th = move-exception;
        q.i(th);
        return r1.toString();
    }

    private long o() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    private float p() {
        float r2 = (TimeZone.getDefault().getRawOffset() * 1.0f) / 3600000.0f;
        if (r2 >= (-12.0f)) goto L6;
        r2 = -12.0f;
    L6:
        if (r2 > 12.0f) goto L8;
        return r2;
    L8:
        return 12.0f;
    }

    @Override // com.bytedance.bdinstall.j
    protected boolean a() {
        String r0 = n();
        l0.a(true);     // Catch: Throwable -> L10
        boolean r1 = d.a(this.f2676f.z(), r0, this.f2676f.d(), this.f2676f.v(), f2675h);     // Catch: Throwable -> L10
        if (r1 == false) goto L6;
        f2675h = true;     // Catch: Throwable -> L10
    L6:
        l0.a(false);
        if (r1 == false) goto L9;
        l();
    L9:
        return r1;
    L10:
        th = move-exception;
        l0.a(false);
        throw th;
    }

    @Override // com.bytedance.bdinstall.j
    protected String b() {
        return "ac";
    }

    @Override // com.bytedance.bdinstall.j
    protected long[] d() {
        return s0.f2867l;
    }

    @Override // com.bytedance.bdinstall.j
    public boolean f() {
        return true;
    }

    @Override // com.bytedance.bdinstall.j
    protected boolean g() {
        return true;
    }

    @Override // com.bytedance.bdinstall.j
    protected long h() {
        return 0;
    }
}
