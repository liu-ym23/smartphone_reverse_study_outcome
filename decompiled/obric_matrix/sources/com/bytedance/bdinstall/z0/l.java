package com.bytedance.bdinstall.z0;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.bytedance.bdinstall.i0;
import com.bytedance.bdinstall.v0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class l extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f2935e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.bytedance.bdinstall.r f2936f;

    l(Context r2, i0 r3, com.bytedance.bdinstall.r r4) {
        super(false, true);
        this.f2935e = r2;
        this.f2936f = r4;
    }

    @Override // com.bytedance.bdinstall.z0.d
    protected boolean a(JSONObject r4) {
        TelephonyManager r0 = (TelephonyManager) this.f2935e.getSystemService("phone");
        if (r0 == null) goto L5;
        v0.l(r4, "carrier", r0.getNetworkOperatorName());
        v0.l(r4, "mcc_mnc", r0.getNetworkOperator());
    L5:
        com.bytedance.bdinstall.b1.a r1 = (com.bytedance.bdinstall.b1.a) com.bytedance.bdinstall.b1.e.a(com.bytedance.bdinstall.b1.a.class);
        v0.l(r4, "clientudid", r1.c());
        if (this.f2936f.e() == true) goto L8;
        v0.l(r4, "openudid", r1.b(true));
    L8:
        return true;
    }

    @Override // com.bytedance.bdinstall.z0.d
    public void b(JSONObject r1) {
        super.b(r1);
        r1.remove("carrier");
        r1.remove("mcc_mnc");
        r1.remove("clientudid");
        r1.remove("openudid");
    }
}
