package com.bytedance.bdinstall.z0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class x extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f2944e;

    x(Context r3) {
        super(true, false);
        this.f2944e = r3;
    }

    @Override // com.bytedance.bdinstall.z0.d
    protected boolean a(JSONObject r4) {
        String r1 = null;
        PackageInfo r3 = this.f2944e.getPackageManager().getPackageInfo(this.f2944e.getPackageName(), 64);     // Catch: PackageManager.NameNotFoundException -> L5
    L7:
        if (r3 == null) goto L15;
        Signature[] r5 = r3.signatures;
        if (r5 == null) goto L15;
        if (r5.length <= 0) goto L15;
        Signature r6 = r5[0];
        if (r6 == null) goto L15;
        r1 = com.bytedance.bdinstall.d1.c.a(r6.toByteArray());
    L15:
        if (r1 == null) goto L21;
        r4.put("sig_hash", r1);
        return true;
    L21:
        return true;
    L5:
        e = move-exception;
        com.bytedance.bdinstall.q.i(e);
        r3 = null;
        goto L7
    }
}
