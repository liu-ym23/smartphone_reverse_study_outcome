package com.slardaros.client.monitor;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Process;
import androidx.core.os.EnvironmentCompat;
import com.bytedance.apm.alog.AlogMonitor;
import com.obric.olog.OLog;
import com.slardaros.client.Constants;
import com.slardaros.client.MetricEvent;
import com.slardaros.client.SlardarAgent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class Util {
    public Util() {
    }

    private static String getCurProcessNameFromProc() {
        BufferedReader r3 = null;
        BufferedReader r4 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L16
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L14
    L5:
        int r5 = r4.read();     // Catch: Throwable -> L14
        if (r5 <= 0) goto L8;
        r2.append((char) r5);     // Catch: Throwable -> L14
        goto L5
    L8:
        String r6 = r2.toString();     // Catch: Throwable -> L14
        r4.close();     // Catch: Exception -> L11
    L13:
        return r6;
    L11:
        e = move-exception;
        OLog.e(Constants.TAG, "getCurProcessNameFromProc: " + e.getMessage());
    L14:
        th = th;
        r3 = r4;
    L38:
        OLog.e(Constants.TAG, "getCurProcessNameFromProc: " + th.getMessage());     // Catch: Throwable -> L25
        if (r3 == null) goto L45;
        r3.close();     // Catch: Exception -> L21
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L21:
        e = move-exception;
        OLog.e(Constants.TAG, "getCurProcessNameFromProc: " + e.getMessage());
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L45:
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L25:
        th = move-exception;
        if (r3 != null) goto L34;
    L31:
        throw th;
    L34:
        r3.close();     // Catch: Exception -> L29
    L29:
        e = move-exception;
        OLog.e(Constants.TAG, "getCurProcessNameFromProc: " + e.getMessage());
    L16:
        th = th;
        goto L38
    }

    private static void addCommonCategories(JSONObject r4) {
        Context r0 = SlardarAgent.getContext();     // Catch: Throwable -> L4
        PackageInfo r1 = r0.getPackageManager().getPackageInfo(r0.getPackageName(), 0);     // Catch: Throwable -> L4
        r4.put("app_name", r0.getPackageName());     // Catch: Throwable -> L4
        r4.put("app_version", String.valueOf(r1.versionCode));     // Catch: Throwable -> L4
        r4.put("process_name", getCurProcessNameFromProc());     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        OLog.d(Constants.TAG, "addCommonCategories: " + e.getMessage());
    }

    public static void sendMetricEvent(String r4, JSONObject r5, JSONObject r6, JSONObject r7) {
        if (SlardarAgent.getContext() != null) goto L5;
        return;
    L5:
        addCommonCategories(r5);
        JSONObject r1 = new JSONObject();
        r1.put("category", r5);     // Catch: Exception -> L8
        r1.put(MetricEvent.METRICS_KEY, r6);     // Catch: Exception -> L8
        r1.put(MetricEvent.TIMESTAMP_KEY, System.currentTimeMillis());     // Catch: Exception -> L8
        r1.put("log_type", "flexible");     // Catch: Exception -> L8
        r1.put(MetricEvent.EVENTNAME_KEY, r4);     // Catch: Exception -> L8
        r1.put("extra", r7);     // Catch: Exception -> L8
    L10:
        Intent r8 = new Intent(Constants.METRIC_EVENT_ACTION);
        r8.putExtra(AlogMonitor.ALOG_RESULT_CODE, 0);
        r8.putExtra(MetricEvent.EVENTNAME_KEY, r4);
        r8.putExtra("json_string", r1.toString());
        SlardarAgent.getContext().sendBroadcast(r8, Constants.METRIC_EVENT_PERMISSION);
        return;
    L8:
        e = move-exception;
        OLog.d(Constants.TAG, "generateTTNetMetricsObj: " + e.getMessage());
        goto L10
    }
}
