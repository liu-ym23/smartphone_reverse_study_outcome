package com.bytedance.bdinstall.z0;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.bytedance.bdinstall.v0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class y extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f2945e;

    y(Context r3) {
        super(true, false);
        this.f2945e = r3;
    }

    @Override // com.bytedance.bdinstall.z0.d
    protected boolean a(JSONObject r2) {
        v0.l(r2, "sim_region", ((TelephonyManager) this.f2945e.getSystemService("phone")).getSimCountryIso());
        return true;
    }
}
