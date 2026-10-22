package com.bytedance.bdinstall.z0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bytedance.bdinstall.i0;
import com.bytedance.bdinstall.q0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i0 f2920a;

    i(i0 r1) {
        this.f2920a = r1;
    }

    private void a(JSONObject r5) {
        Context r0 = this.f2920a.t();
        q0 r4 = this.f2920a.B();
        if (r4 == null) goto L17;
        r5.put("pre_installed_channel", r4.a(r0));
    L17:
        int r1 = 0;
        PackageInfo r6 = r0.getPackageManager().getPackageInfo(r0.getPackageName(), 0);     // Catch: Throwable -> L16
        if (r6 == null) goto L19;
        r5.put("apk_first_install_time", r6.firstInstallTime);     // Catch: Throwable -> L16
        if ((r6.applicationInfo.flags & 1) != 1) goto L10;
        boolean r7 = true;
    L12:
        if (r7 == false) goto L14;
        r1 = 1;
    L14:
        r5.put("is_system_app", r1);     // Catch: Throwable -> L16
        return;
    L10:
        r7 = false;
        goto L12
    L19:
        return;
    }

    protected boolean b(JSONObject r2, com.bytedance.bdinstall.r r3) {
        if (r3.e() == false) goto L5;
        r2.put("scene", 2);
    L5:
        r2.put("device_platform", "android");
        new o().a(r2);
        r2.put("git_hash", "f1c7cec");
        r2.put("sdk_version_code", com.bytedance.bdinstall.q.f2857b);
        r2.put("sdk_target_version", 30);
        r2.put("req_id", com.bytedance.bdinstall.d1.k.b());
        r2.put("sdk_version", "obric.cnInner-0.0.4-SNAPSHOT");
        r2.put("guest_mode", this.f2920a.V() ? 1 : 0);
        r2.put("sdk_flavor", "cnInner");
        if (com.bytedance.bdinstall.migrate.a.g(this.f2920a.t()) == false) goto L14;
        String r4 = com.bytedance.bdinstall.migrate.a.d(this.f2920a.t());
        if (TextUtils.isEmpty(r4) == false) goto L19;
        r4 = "";
    L19:
        r2.put("old_did", r4);     // Catch: JSONException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    L14:
        a(r2);
        com.bytedance.bdinstall.b1.c r1 = (com.bytedance.bdinstall.b1.c) com.bytedance.bdinstall.b1.e.a(com.bytedance.bdinstall.b1.c.class);
        if (r1 == null) goto L21;
        r1.a(r2);
        return true;
    L21:
        return true;
    }
}
