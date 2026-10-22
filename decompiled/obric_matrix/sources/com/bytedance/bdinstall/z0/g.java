package com.bytedance.bdinstall.z0;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.i0;
import com.bytedance.bdinstall.v0;
import com.bytedance.common.wschannel.WsConstants;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class g extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final i0 f2918e;

    g(Context r1, i0 r2, com.bytedance.bdinstall.r r3) {
        super(false, true);
        this.f2918e = r2;
    }

    @Override // com.bytedance.bdinstall.z0.d
    protected boolean a(JSONObject r7) {
        r7.put("channel", this.f2918e.r());
        r7.put("not_request_sender", 1);
        r7.put(WsConstants.KEY_APP_ID, this.f2918e.j());
        String r0 = this.f2918e.C();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        r7.put("release_build", r0);
        v0.l(r7, "user_agent", this.f2918e.H());
        v0.l(r7, "ab_version", this.f2918e.f());
        String r1 = this.f2918e.k();
        if (TextUtils.isEmpty(r1) == false) goto L8;
        r1 = this.f2918e.l();
    L8:
        v0.l(r7, "app_language", r1);
        String r2 = this.f2918e.n();
        if (TextUtils.isEmpty(r2) == false) goto L11;
        r2 = this.f2918e.o();
    L11:
        v0.l(r7, "app_region", r2);
        JSONObject r3 = this.f2918e.p();
        if (r3 != null) goto L37;
    L17:
        JSONObject r4 = r7.optJSONObject("custom");
        if (r4 != null) goto L21;
        r4 = new JSONObject();
    L21:
        if (TextUtils.isEmpty(this.f2918e.L()) == true) goto L35;
        r4.put("real_package_name", this.f2918e.t().getPackageName());
    L35:
        Map<String, Object> r6 = this.f2918e.u();     // Catch: Throwable -> L34
        if (r6 == null) goto L32;
        if (r6.size() <= 0) goto L32;
        Iterator<String> r5 = r6.keySet().iterator();     // Catch: Throwable -> L34
    L29:
        if (r5.hasNext() == false) goto L32;
        String r8 = r5.next();     // Catch: Throwable -> L34
        r4.put(r8, r6.get(r8));     // Catch: Throwable -> L34
    L32:
        r7.put("custom", r4);
        return true;
    L37:
        r7.put("app_track", r3);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        com.bytedance.bdinstall.q.i(th);
        goto L17
    }

    @Override // com.bytedance.bdinstall.z0.d
    public void b(JSONObject r1) {
        super.b(r1);
        r1.remove("channel");
        r1.remove("not_request_sender");
        r1.remove(WsConstants.KEY_APP_ID);
        r1.remove("release_build");
        r1.remove("user_agent");
        r1.remove("ab_version");
        r1.remove("app_language");
        r1.remove("app_region");
        r1.remove("app_track");
        r1.remove("custom");
    }
}
