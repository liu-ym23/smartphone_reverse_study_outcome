package com.bytedance.bdinstall.z0;

import android.content.SharedPreferences;
import com.bytedance.bdinstall.i0;
import com.bytedance.bdinstall.v0;
import com.bytedance.common.wschannel.WsConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class w extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final i0 f2942e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.bytedance.bdinstall.r f2943f;

    w(i0 r3, com.bytedance.bdinstall.r r4) {
        super(true, false, false);
        this.f2942e = r3;
        this.f2943f = r4;
    }

    @Override // com.bytedance.bdinstall.z0.d
    protected boolean a(JSONObject r9) {
        SharedPreferences r8 = this.f2943f.c(this.f2942e.t());
        String r0 = ((com.bytedance.bdinstall.b1.a) com.bytedance.bdinstall.b1.e.a(com.bytedance.bdinstall.b1.a.class)).getDeviceId();
        String r3 = r8.getString("bd_did", null);
        String r5 = r8.getString("install_id", null);
        String r10 = r8.getString("ssid", null);
        if (com.bytedance.bdinstall.q.b() == false) goto L5;
        com.bytedance.bdinstall.q.a("load d=" + r0 + " i=" + r5 + " s=" + r10);
    L5:
        v0.l(r9, "install_id", r5);
        v0.l(r9, WsConstants.KEY_DEVICE_ID, r0);
        v0.l(r9, "ssid", r10);
        v0.l(r9, "bd_did", r3);
        return true;
    }

    @Override // com.bytedance.bdinstall.z0.d
    public void b(JSONObject r1) {
        r1.remove("bd_did");
        r1.remove("install_id");
        r1.remove("ssid");
        r1.remove(WsConstants.KEY_DEVICE_ID);
    }
}
