package com.bytedance.bdinstall.oaid;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.bdinstall.DrLog;

/* JADX INFO: loaded from: classes3.dex */
final class NubiaOaidImpl implements OaidApi {
    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "Nubia";
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public boolean support(Context r1) {
        return true;
    }

    NubiaOaidImpl() {
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public OaidApi.Result getOaid(Context r3) {
        Uri r2 = Uri.parse("content://cn.nubia.identity/identity");
        ContentProviderClient r4 = r3.getContentResolver().acquireContentProviderClient(r2);     // Catch: Exception -> L17
        if (r4 != null) goto L6;
        return null;
    L6:
        Bundle r5 = r4.call("getOAID", null, null);     // Catch: Exception -> L17
        r4.close();     // Catch: Exception -> L17
        if (r5 != null) goto L10;
        return null;
    L10:
        if (r5.getInt(AlogMonitor.ALOG_RESULT_CODE, -1) != 0) goto L13;
        OaidApi.Result r6 = new OaidApi.Result();     // Catch: Exception -> L17
        r6.oaid = r5.getString("id");     // Catch: Exception -> L17
        return r6;
    L13:
        String r7 = r5.getString("message");     // Catch: Exception -> L17
        if (TextUtils.isEmpty(r7) == true) goto L16;
        DrLog.e(r7);     // Catch: Exception -> L17
    L16:
        return null;
    L17:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
