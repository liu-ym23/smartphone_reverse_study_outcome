package com.bytedance.bdinstall.z0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.bdinstall.i0;
import com.bytedance.bdinstall.v0;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class z extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f2946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final i0 f2947f;

    z(Context r3, i0 r4) {
        super(true, false);
        this.f2946e = r3;
        this.f2947f = r4;
    }

    private static boolean c(@Nullable JSONArray r5) {
        if (r5 == null) goto L14;
        int r1 = r5.length();
        if (r1 <= 0) goto L19;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L21;
        JSONObject r3 = r5.optJSONObject(r2);
        if (r3 == null) goto L13;
        if (TextUtils.isEmpty(r3.optString("id")) == true) goto L13;
        return true;
    L13:
        r2 = r2 + 1;
        goto L7
    L21:
        return false;
    L19:
        return false;
    L14:
        return false;
    }

    @Override // com.bytedance.bdinstall.z0.d
    @SuppressLint({"HardwareIds"})
    protected boolean a(JSONObject r8) {
        if (this.f2947f.V() == true) goto L26;
        com.bytedance.bdinstall.b1.a r0 = (com.bytedance.bdinstall.b1.a) com.bytedance.bdinstall.b1.e.a(com.bytedance.bdinstall.b1.a.class);
        String[] r1 = null;
        if ((r0 instanceof com.bytedance.bdinstall.c1.c) == false) goto L9;
        com.bytedance.bdinstall.c1.c r2 = (com.bytedance.bdinstall.c1.c) r0;
        String r3 = r2.h();
        JSONArray r4 = r2.k();
        String r5 = r2.j();
        if (this.f2947f.W() == false) goto L12;
        r1 = r2.i();
    L12:
        v0.l(r8, "build_serial", r3);
        v0.l(r8, "pico_sn", r3);
        v0.l(r8, "aliyun_uuid", a.e().a());
        if (c(r4) == false) goto L15;
        r8.put("udid_list", r4);
    L15:
        String r6 = com.bytedance.bdinstall.d1.m.e(this.f2946e);
        if (TextUtils.isEmpty(r6) == true) goto L18;
        r8.put("mc", r6);
    L18:
        v0.l(r8, "udid", r5);
        v0.l(r8, "serial_number", r3);
        if (this.f2947f.W() == false) goto L26;
        if (r1 == null) goto L26;
        JSONArray r7 = new JSONArray();
        int r9 = r1.length;
        int r10 = 0;
    L23:
        if (r10 >= r9) goto L25;
        r7.put(new JSONObject().put("sim_serial_number", r1[r10]));
        r10 = r10 + 1;
        goto L23
    L25:
        r8.put("sim_serial_number", r7);
        goto L26
    L9:
        r3 = com.bytedance.bdinstall.d1.m.g(this.f2946e, this.f2947f);
        r4 = com.bytedance.bdinstall.d1.m.f(this.f2946e, this.f2947f);
        r5 = com.bytedance.bdinstall.d1.m.d(this.f2946e, this.f2947f);
        if (this.f2947f.W() == false) goto L12;
        r1 = com.bytedance.bdinstall.d1.m.h(this.f2946e, this.f2947f);
    L26:
        com.bytedance.bdinstall.a1.f.n();
        Map<String, String> r11 = com.bytedance.bdinstall.a1.b.l(this.f2946e).i(com.bytedance.bdinstall.i.g().a());
        com.bytedance.bdinstall.a1.f.m();
        com.bytedance.bdinstall.q.a("getOaid: returned=" + r11);
        r8.put("oaid_may_support", com.bytedance.bdinstall.a1.b.l(this.f2946e).m());
        if (r11 == null) goto L32;
        r8.put("oaid", new JSONObject(r11));
        return true;
    L32:
        return true;
    }
}
