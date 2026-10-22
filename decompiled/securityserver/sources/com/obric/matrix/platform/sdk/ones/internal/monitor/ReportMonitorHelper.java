package com.obric.matrix.platform.sdk.ones.internal.monitor;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import com.obric.matrix.proto.Response;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ReportMonitorHelper {

    @NotNull
    public static final ReportMonitorHelper INSTANCE = null;

    @NotNull
    public static final String TAG = "ReportMonitorHelper";

    static {
        INSTANCE = new ReportMonitorHelper();
    }

    private ReportMonitorHelper() {
    }

    public final void monitorBinderResult(@Nullable Boolean r3) {
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L5
        if (Intrinsics.a(r3, Boolean.TRUE) == false) goto L7;
        String r4 = "1";
    L8:
        r2.put("result", r4);     // Catch: Exception -> L5
        SdkMonitorManager.INSTANCE.sdkMonitorEvent(EventConstants.EVENT_BIND_RESULT, r2);     // Catch: Exception -> L5
        return;
    L7:
        r4 = "0";
    L5:
        e = move-exception;
        MLog.d$default(TAG, "report exception " + Log.getStackTraceString(e), null, 4, null);
    }

    public final void monitorSendCmdException(int r3, int r4, @NotNull String r5) {
        Intrinsics.f(r5, NotificationCompat.CATEGORY_MESSAGE);
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L5
        r2.put("status", EventConstants.STATUS_RECEIVER_RESULT);     // Catch: Exception -> L5
        r2.put(EventConstants.EVENT_KEY_CMD, r3);     // Catch: Exception -> L5
        r2.put("error_code", r4);     // Catch: Exception -> L5
        r2.put(EventConstants.EVENT_KEY_ERROR_MESSAGE, r5);     // Catch: Exception -> L5
        SdkMonitorManager.INSTANCE.sdkMonitorEvent(EventConstants.EVENT_SEND_CMD_RESULT, r2);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        MLog.d$default(TAG, "report exception " + Log.getStackTraceString(e), null, 4, null);
    }

    public final void monitorSendCmdResult(int r7, int r8, @Nullable String r9, @NotNull Response r10, @Nullable JSONObject r11) {
        Intrinsics.f(r10, ApmTrafficStats.TTNET_RESPONSE);
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L8
        r1.put("status", EventConstants.STATUS_RECEIVER_RESULT);     // Catch: Exception -> L8
        r1.put(EventConstants.EVENT_KEY_CMD, r7);     // Catch: Exception -> L8
        r1.put(EventConstants.EVENT_KEY_WAY, r8);     // Catch: Exception -> L8
        r1.put("package_name", r9);     // Catch: Exception -> L8
        Integer r12 = r10.statusCode;     // Catch: Exception -> L8
        Intrinsics.e(r12, "response.statusCode");     // Catch: Exception -> L8
        r1.put("error_code", r12.intValue());     // Catch: Exception -> L8
        r1.put(EventConstants.EVENT_KEY_ERROR_MESSAGE, r10.errorMsg);     // Catch: Exception -> L8
        JSONObject r13 = new JSONObject();     // Catch: Exception -> L8
        if (r11 == null) goto L15;
        String r14 = r11.optString(EventConstants.EVENT_KEY_START_CALLBACK_TIME);     // Catch: Exception -> L8
        Intrinsics.e(r14, "startCallbackTime");     // Catch: Exception -> L8
        long r2 = 0;
        if (r14.length() <= 0) goto L10;
        long r15 = System.currentTimeMillis() - Long.parseLong(r14);     // Catch: Exception -> L8
    L11:
        String r16 = r11.optString(EventConstants.EVENT_KEY_START_INTENT_USE_TIME);     // Catch: Exception -> L8
        String r4 = r11.optString("start_time");     // Catch: Exception -> L8
        Intrinsics.e(r4, "realStartTime");     // Catch: Exception -> L8
        if (r4.length() <= 0) goto L14;
        r2 = System.currentTimeMillis() - Long.parseLong(r4);     // Catch: Exception -> L8
    L14:
        String r17 = r11.optString(EventConstants.EVENT_KEY_PROCESS_TIME);     // Catch: Exception -> L8
        r13.put(EventConstants.EVENT_KEY_COST_TIME, r2);     // Catch: Exception -> L8
        r13.put(EventConstants.EVENT_KEY_START_INTENT_USE_TIME, r16);     // Catch: Exception -> L8
        r13.put(EventConstants.EVENT_KEY_PROCESS_TIME, r17);     // Catch: Exception -> L8
        r13.put(EventConstants.EVENT_KEY_CALLBACK_USE_TIME, r15);     // Catch: Exception -> L8
        goto L15
    L10:
        r15 = 0;
    L15:
        SdkMonitorManager.INSTANCE.sdkMonitorEvent(EventConstants.EVENT_SEND_CMD_RESULT, r1, r13, new JSONObject());     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        MLog.d$default(TAG, "report exception " + Log.getStackTraceString(e), null, 4, null);
    }

    public final void monitorStartSendCmd(int r3, int r4, @NotNull String r5) {
        Intrinsics.f(r5, "packageName");
        JSONObject r2 = new JSONObject();
        r2.put("status", EventConstants.STATUS_START);
        r2.put(EventConstants.EVENT_KEY_CMD, r3);
        r2.put(EventConstants.EVENT_KEY_WAY, r4);
        r2.put("package_name", r5);
        SdkMonitorManager.INSTANCE.sdkMonitorEvent(EventConstants.EVENT_SEND_CMD_START, r2);
    }
}
