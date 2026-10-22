package com.bytedance.bdinstall.z0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import com.bytedance.bdlocation.client.LocationInfoConst;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class e extends d {
    e(Context r2) {
        super(true, false);
    }

    @Override // com.bytedance.bdinstall.z0.d
    @SuppressLint({"MissingPermission"})
    protected boolean a(JSONObject r3) {
        r3.put("os", LocationInfoConst.SYSTEM);
        r3.put("os_version", Build.VERSION.RELEASE);
        r3.put("os_api", Build.VERSION.SDK_INT);
        String r2 = Build.BRAND;
        if (r2.equals("Pico") == false) goto L5;
        Object r0 = com.bytedance.bdinstall.d1.l.j();
    L6:
        r3.put("device_model", r0);
        r3.put("device_brand", r2);
        r3.put("device_manufacturer", Build.MANUFACTURER);
        r3.put("cpu_abi", Build.CPU_ABI);
        return true;
    L5:
        r0 = Build.MODEL;
        goto L6
    }
}
