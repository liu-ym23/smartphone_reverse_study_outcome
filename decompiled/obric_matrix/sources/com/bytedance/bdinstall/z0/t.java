package com.bytedance.bdinstall.z0;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.i0;
import com.bytedance.common.wschannel.WsConstants;

/* JADX INFO: loaded from: classes.dex */
class t {
    private static void a(i0 r9, SharedPreferences r10) {
        SharedPreferences r11 = r9.D();
        String r2 = r11.getString(WsConstants.KEY_DEVICE_ID, null);
        String r4 = r11.getString("bd_did", null);
        String r6 = r11.getString("install_id", null);
        String r12 = r11.getString("ssid", null);
        SharedPreferences.Editor r13 = r10.edit();
        boolean r8 = true;
        if (TextUtils.isEmpty(r2) == true) goto L5;
        r13.putString(WsConstants.KEY_DEVICE_ID, r2);
        boolean r0 = true;
    L7:
        if (TextUtils.isEmpty(r4) == true) goto L10;
        r13.putString("bd_did", r4);
        r0 = true;
    L10:
        if (TextUtils.isEmpty(r6) == true) goto L13;
        r13.putString("install_id", r6);
        r0 = true;
    L13:
        if (TextUtils.isEmpty(r12) == true) goto L15;
        r13.putString("ssid", r12);
    L16:
        if (r8 == false) goto L19;
        r13.apply();
        return;
    L19:
        return;
    L15:
        r8 = r0;
        goto L16
    L5:
        r0 = false;
        goto L7
    }

    static void b(Context r2, com.bytedance.bdinstall.r r3, i0 r4) {
        SharedPreferences r0 = com.bytedance.bdinstall.d1.h.a(r2);
        SharedPreferences r5 = r3.c(r2);
        if (r0.getBoolean("dr_install_migrate", false) == false) goto L5;
        return;
    L5:
        a(r4, r5);
        r0.edit().putBoolean("dr_install_migrate", true).apply();
    }
}
