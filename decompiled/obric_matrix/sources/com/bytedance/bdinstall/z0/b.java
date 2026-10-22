package com.bytedance.bdinstall.z0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f2910e;

    b(Context r3) {
        super(true, false);
        this.f2910e = r3;
    }

    @Override // com.bytedance.bdinstall.z0.d
    protected boolean a(JSONObject r3) {
        String r0 = this.f2910e.getPackageName();
        Bundle r2 = this.f2910e.getPackageManager().getApplicationInfo(r0, 128).metaData;     // Catch: PackageManager.NameNotFoundException -> L7
        if (r2 == null) goto L13;
        r3.put("appkey", r2.getString("UMENG_APPKEY"));     // Catch: PackageManager.NameNotFoundException -> L7
        return true;
    L13:
        return true;
    L7:
        e = move-exception;
        e.printStackTrace();
        return true;
    }
}
