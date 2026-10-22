package com.slardaros.client.n;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Process;
import androidx.core.os.EnvironmentCompat;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.olog.OLog;
import com.slardaros.client.i;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import org.json.JSONObject;
import os.teatracker.IBdInstall;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static void a(JSONObject r4) {
        Context r0 = i.c();     // Catch: Throwable -> L4
        PackageInfo r1 = r0.getPackageManager().getPackageInfo(r0.getPackageName(), 0);     // Catch: Throwable -> L4
        r4.put(IBdInstall.PARAM_APP_NAME, r0.getPackageName());     // Catch: Throwable -> L4
        r4.put(WsConstants.KEY_APP_VERSION, String.valueOf(r1.versionCode));     // Catch: Throwable -> L4
        r4.put("process_name", b());     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        OLog.c("Slardaros_Agent", "addCommonCategories: " + e.getMessage());
    }

    private static String b() {
        BufferedReader r3 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L16
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L14
    L5:
        int r4 = r3.read();     // Catch: Throwable -> L14
        if (r4 <= 0) goto L8;
        r2.append((char) r4);     // Catch: Throwable -> L14
        goto L5
    L8:
        String r5 = r2.toString();     // Catch: Throwable -> L14
        r3.close();     // Catch: Exception -> L11
    L13:
        return r5;
    L11:
        e = move-exception;
        OLog.d("Slardaros_Agent", "getCurProcessNameFromProc: " + e.getMessage());
    L14:
        Throwable th = th;
    L39:
        OLog.d("Slardaros_Agent", "getCurProcessNameFromProc: " + th.getMessage());     // Catch: Throwable -> L26
        if (r3 == null) goto L46;
        r3.close();     // Catch: Exception -> L22
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L22:
        e = move-exception;
        OLog.d("Slardaros_Agent", "getCurProcessNameFromProc: " + e.getMessage());
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L46:
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L26:
        th = move-exception;
        if (r3 != null) goto L41;
    L32:
        throw th;
    L41:
        r3.close();     // Catch: Exception -> L30
    L30:
        e = move-exception;
        OLog.d("Slardaros_Agent", "getCurProcessNameFromProc: " + e.getMessage());
    L16:
        th = move-exception;
        r3 = null;
        th = th;
        goto L39
    }

    public static void c(String r4, JSONObject r5, JSONObject r6, JSONObject r7) {
        a(r5);
        JSONObject r1 = new JSONObject();
        r1.put("category", r5);     // Catch: Exception -> L5
        r1.put("metrics", r6);     // Catch: Exception -> L5
        r1.put("client_timestamp", System.currentTimeMillis());     // Catch: Exception -> L5
        r1.put("log_type", "flexible");     // Catch: Exception -> L5
        r1.put("event_name", r4);     // Catch: Exception -> L5
        r1.put(WsConstants.KEY_EXTRA, r7);     // Catch: Exception -> L5
    L7:
        Intent r8 = new Intent("com.slardaros.metricevent.action");
        r8.putExtra("code", 0);
        r8.putExtra("event_name", r4);
        r8.putExtra("json_string", r1.toString());
        i.c().sendBroadcast(r8, "com.slardaros.METRIC_EVENT_PERMISSION");
        return;
    L5:
        e = move-exception;
        OLog.c("Slardaros_Agent", "generateTTNetMetricsObj: " + e.getMessage());
        goto L7
    }
}
