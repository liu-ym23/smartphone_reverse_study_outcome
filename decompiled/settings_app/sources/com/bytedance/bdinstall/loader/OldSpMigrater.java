package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.util.LocalConstants;

/* JADX INFO: loaded from: classes3.dex */
class OldSpMigrater {
    OldSpMigrater() {
    }

    static void tryDoSDKMigrate(Context r2, Env r3, InstallOptions r4) {
        SharedPreferences r0 = LocalConstants.getCommonSp(r2);
        SharedPreferences r5 = r3.getEnvIsolateSp(r2);
        if (r0.getBoolean("dr_install_migrate", false) == false) goto L5;
        return;
    L5:
        migrateDidSp(r4, r5);
        r0.edit().putBoolean("dr_install_migrate", true).apply();
    }

    private static void migrateDidSp(InstallOptions r9, SharedPreferences r10) {
        SharedPreferences r11 = r9.getSp();
        String r2 = r11.getString("device_id", null);
        String r4 = r11.getString(Api.KEY_BD_DID, null);
        String r6 = r11.getString(Api.KEY_INSTALL_ID, null);
        String r12 = r11.getString("ssid", null);
        SharedPreferences.Editor r13 = r10.edit();
        boolean r8 = true;
        if (TextUtils.isEmpty(r2) == true) goto L5;
        r13.putString("device_id", r2);
        boolean r0 = true;
    L7:
        if (TextUtils.isEmpty(r4) == true) goto L10;
        r13.putString(Api.KEY_BD_DID, r4);
        r0 = true;
    L10:
        if (TextUtils.isEmpty(r6) == true) goto L13;
        r13.putString(Api.KEY_INSTALL_ID, r6);
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
}
