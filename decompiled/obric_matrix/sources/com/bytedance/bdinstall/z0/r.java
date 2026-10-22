package com.bytedance.bdinstall.z0;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bdinstall.i0;
import com.bytedance.bdinstall.v0;
import com.bytedance.common.wschannel.WsConstants;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
final class r {
    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    public static void b(Context r8, i0 r9, com.bytedance.bdinstall.r r10) {
        com.bytedance.bdinstall.d1.e.a(r8);
        v0.m(r9.D(), new String[]{WsConstants.KEY_DEVICE_ID, "bd_did", "install_id", "device_token"});
        v0.m(r10.c(r8), new String[]{WsConstants.KEY_DEVICE_ID, "bd_did", "install_id", "device_token"});
        v0.m(a(r8, "snssdk_openudid", 0), new String[]{"clientudid", "openudid", "serial_number"});     // Catch: Exception -> L6
    L4:
        v0.m(com.bytedance.bdinstall.d1.h.a(r8), new String[]{"clientudid", "openudid", "serial_number"});
        com.bytedance.bdinstall.l.c(r8);
        com.bytedance.bdinstall.a1.b.l(r8).g();
    }
}
