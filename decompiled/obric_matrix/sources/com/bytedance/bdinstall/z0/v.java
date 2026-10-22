package com.bytedance.bdinstall.z0;

import android.os.Build;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class v extends d {
    v() {
        super(true, false);
    }

    @Override // com.bytedance.bdinstall.z0.d
    protected boolean a(JSONObject r3) {
        StringBuilder r2 = new StringBuilder(16);
        if (com.bytedance.bdinstall.d1.l.z() == false) goto L7;
        String r0 = "MIUI-";
    L5:
        r2.append(r0);
    L14:
        r2.append(Build.VERSION.INCREMENTAL);
        r3.put("rom", r2.toString());
        String r4 = com.bytedance.bdinstall.d1.l.k();
        if (TextUtils.isEmpty(r4) == true) goto L19;
        r3.put("rom_version", r4);
        return true;
    L19:
        return true;
    L7:
        if (com.bytedance.bdinstall.d1.l.t() == false) goto L9;
        r0 = "FLYME-";
        goto L5
    L9:
        String r1 = com.bytedance.bdinstall.d1.l.f();
        if (com.bytedance.bdinstall.d1.l.x(r1) == false) goto L14;
        r2.append("EMUI-");
        if (TextUtils.isEmpty(r1) == true) goto L14;
        r2.append(r1);
        r0 = "-";
        goto L5
    }
}
