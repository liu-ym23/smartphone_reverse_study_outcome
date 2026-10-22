package com.bytedance.bdinstall.z0;

import android.content.Context;
import com.bytedance.bdinstall.i0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class c extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f2911e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final i0 f2912f;

    c(Context r3, i0 r4) {
        super(true, false);
        this.f2911e = r3;
        this.f2912f = r4;
    }

    @Override // com.bytedance.bdinstall.z0.d
    protected boolean a(JSONObject r4) {
        com.bytedance.bdinstall.y0.b r0 = this.f2912f.q();
        com.bytedance.bdinstall.q.a("IAppTraitCallback = " + r0);
        if (r0 == null) goto L7;
        String r3 = r0.a(this.f2911e);
        com.bytedance.bdinstall.q.a("IAppTraitCallback.get = " + r3);
        r4.put("app_trait", r3);
        return true;
    L7:
        return true;
    }
}
