package com.bytedance.bdinstall.z0;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.bytedance.bdinstall.i0;
import com.bytedance.common.wschannel.WsConstants;
import org.json.JSONObject;
import os.teatracker.IBdInstall;

/* JADX INFO: loaded from: classes.dex */
class u extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f2940e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final i0 f2941f;

    u(Context r2, i0 r3) {
        super(false, false);
        this.f2940e = r2;
        this.f2941f = r3;
    }

    @Override // com.bytedance.bdinstall.z0.d
    protected boolean a(JSONObject r6) {
        String r0 = this.f2940e.getPackageName();
        if (TextUtils.isEmpty(this.f2941f.L()) == false) goto L6;
        r6.put("package", r0);
    L31:
        r6.put(WsConstants.KEY_APP_VERSION, this.f2941f.I());     // Catch: Throwable -> L26
        r6.put("app_version_minor", this.f2941f.K());     // Catch: Throwable -> L26
        r6.put("version_code", this.f2941f.J());     // Catch: Throwable -> L26
        r6.put("update_version_code", this.f2941f.G());     // Catch: Throwable -> L26
        r6.put("manifest_version_code", this.f2941f.y());     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(this.f2941f.m()) == true) goto L14;
        r6.put(IBdInstall.PARAM_APP_NAME, this.f2941f.m());     // Catch: Throwable -> L26
    L14:
        if (TextUtils.isEmpty(this.f2941f.F()) == true) goto L29;
        r6.put("tweaked_channel", this.f2941f.F());     // Catch: Throwable -> L26
    L29:
        ApplicationInfo r1 = this.f2940e.getPackageManager().getPackageInfo(r0, 0).applicationInfo;     // Catch: Throwable -> L22
        if (r1 == null) goto L33;
        int r2 = r1.labelRes;     // Catch: Throwable -> L22
        if (r2 <= 0) goto L34;
        r6.put("display_name", this.f2940e.getString(r2));     // Catch: Throwable -> L22
    L35:
        return true;
    L34:
        return true;
    L33:
        return true;
    L22:
        th = move-exception;
        com.bytedance.bdinstall.q.d("PackageLoader#getPackageInfo error", th);     // Catch: Throwable -> L26
        return true;
    L26:
        th = move-exception;
        com.bytedance.bdinstall.q.i(th);
        return false;
    L6:
        if (com.bytedance.bdinstall.q.b() == false) goto L8;
        com.bytedance.bdinstall.q.a("has zijie pkg");
    L8:
        r6.put("package", this.f2941f.L());
        r6.put("real_package_name", r0);
        goto L31
    }
}
