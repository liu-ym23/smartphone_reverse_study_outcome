package com.bytedance.bdinstall.z0;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class f extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f2917e;

    f(Context r2) {
        super(true, true);
        this.f2917e = r2;
    }

    @Override // com.bytedance.bdinstall.z0.d
    protected boolean a(JSONObject r2) {
        String r1 = com.bytedance.bdinstall.l.d(this.f2917e);
        if (TextUtils.isEmpty(r1) == true) goto L6;
        r2.put("cdid", r1);
        return true;
    L6:
        return false;
    }

    @Override // com.bytedance.bdinstall.z0.d
    public void b(JSONObject r1) {
        super.b(r1);
        r1.remove("cdid");
    }
}
