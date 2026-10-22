package com.obric.matrix.platform.sdk.ones.internal.monitor;

import a.a;
import android.content.Context;
import android.util.Log;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.securityserver.b;
import com.obric.matrix.platform.sdk.ones.BuildConfig;
import com.obric.matrix.platform.sdk.ones.IMatrixBridge;
import com.obric.matrix.platform.sdk.ones.MatrixOnesSdk;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SdkMonitorManager {

    @NotNull
    public static final SdkMonitorManager INSTANCE = null;

    @NotNull
    private static final String KEY_APP_VERSION = "app_version";

    @NotNull
    private static final String KEY_CHANNEL = "channel";

    @NotNull
    private static final String KEY_DEVICE_ID = "device_id";

    @NotNull
    private static final String KEY_HOST_ID = "host_aid";

    @NotNull
    private static final String KEY_OVERSEA = "oversea";

    @NotNull
    private static final String KEY_SDK_NAME = "sdk_name";

    @NotNull
    private static final String KEY_SDK_VERSION = "sdk_version";

    @NotNull
    private static final String KEY_SDK_VERSION_CODE = "sdk_version_code";

    @NotNull
    private static final String TAG = "SdkMonitorManager";

    @NotNull
    private static final String VALUE_IS_NOT_OVERSEA = "0";

    @NotNull
    private static final String VALUE_IS_OVERSEA = "1";
    private static boolean isInit;

    @NotNull
    private static String sdkName;

    static {
        INSTANCE = new SdkMonitorManager();
        sdkName = "ones_sdk";
    }

    private SdkMonitorManager() {
    }

    public static /* synthetic */ void a() {
        m25reportSdkInitSuccess$lambda1();
    }

    public static final /* synthetic */ boolean access$isOverSea(SdkMonitorManager r0) {
        return r0.isOverSea();
    }

    private final String getChannel() {
        return "release";
    }

    private final String getConfigUrl() {
        if (isOverSea() == false) goto L5;
        return SdkMonitorConstants.SDK_MONITOR_CONFIG_URL_OVERSEA;
    L5:
        return SdkMonitorConstants.SDK_MONITOR_CONFIG_URL_CN;
    }

    private final String getReportUrl() {
        if (isOverSea() == false) goto L5;
        return SdkMonitorConstants.SDK_MONITOR_REPORT_URL_OVERSEA;
    L5:
        return SdkMonitorConstants.SDK_MONITOR_REPORT_URL_CN;
    }

    private final String getSdkAid() {
        isOverSea();
        return "568500";
    }

    private final int getSdkVersionCode() {
        return BuildConfig.SDK_VERSION_CODE;
    }

    private final String getSdkVersionName() {
        return BuildConfig.SDK_VERSION_NAME;
    }

    private final boolean isOverSea() {
        IMatrixBridge r0 = MatrixOnesSdk.INSTANCE.getBridge$sdk_platform_ones_release();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isOverSea();
    }

    /* JADX INFO: renamed from: reportSdkInitSuccess$lambda-1, reason: not valid java name */
    private static final void m25reportSdkInitSuccess$lambda1() {
        Thread.sleep(1000);
        INSTANCE.sdkMonitorEvent("matrix_sdk_init_success", new JSONObject(), new JSONObject(), new JSONObject());
    }

    public final void initSDKMonitor(@NotNull Context r8) {
        Intrinsics.f(r8, "context");
        SDKMonitorUtils.setConfigUrl(getSdkAid(), CollectionsKt.j(getConfigUrl()));
        SDKMonitorUtils.setDefaultReportUrl(getSdkAid(), CollectionsKt.j(getReportUrl()));
        String r2 = null;
        MLog.d$default(TAG, "sdk aid " + getSdkAid() + " , config url " + getConfigUrl() + " \n , reporturl " + getReportUrl(), null, 4, null);
        JSONObject r0 = new JSONObject();
        MatrixOnesSdk r4 = MatrixOnesSdk.INSTANCE;
        IMatrixBridge r5 = r4.getBridge$sdk_platform_ones_release();
        if (r5 == null) goto L5;
        String r6 = r5.did();
    L6:
        MLog.d$default(TAG, a.A("device_id = ", r6), null, 4, null);
        if (r6 != null) goto L9;
    L20:
        isInit = false;
        return;
    L9:
        if (r6.length() == 0) goto L20;
        r0.put("device_id", r6);
        r0.put("sdk_version", getSdkVersionName());
        MLog.d$default(TAG, "sdk version = " + getSdkVersionName(), null, 4, null);
        IMatrixBridge r1 = r4.getBridge$sdk_platform_ones_release();
        if (r1 == null) goto L14;
        String r3 = r1.appId();
    L15:
        r0.put("host_aid", r3);
        IMatrixBridge r7 = r4.getBridge$sdk_platform_ones_release();
        if (r7 == null) goto L18;
        r2 = r7.appVersionCode();
    L18:
        r0.put("app_version", r2);
        r0.put("channel", getChannel());
        SDKMonitorUtils.initMonitor(r8, getSdkAid(), r0, new AnonymousClass1());
        isInit = true;
        return;
    L14:
        r3 = null;
        goto L15
    L5:
        r6 = null;
        goto L6
    }

    public final void reportSdkInitSuccess() {
        new Thread(new b(6)).start();     // Catch: Exception -> L4
        return;
    }

    public final void sdkMonitorEvent(@NotNull String r3, @NotNull JSONObject r4) {
        Intrinsics.f(r3, "eventName");
        Intrinsics.f(r4, CommonKey.KEY_CATEGORY);
        sdkMonitorEvent(r3, r4, new JSONObject(), new JSONObject());
    }

    public final void sdkMonitorEvent(@NotNull String r9, @NotNull JSONObject r10, @NotNull JSONObject r11, @NotNull JSONObject r12) {
        Intrinsics.f(r9, "eventName");
        Intrinsics.f(r10, CommonKey.KEY_CATEGORY);
        Intrinsics.f(r11, CommonKey.KEY_METRIC);
        Intrinsics.f(r12, "logExtr");
    L8:
        e = move-exception;
        MLog.d$default(TAG, "event report exception " + Log.getStackTraceString(e), null, 4, null);
        return;
    L4:
        if (isInit == true) goto L21;
        MatrixOnesSdk r5 = MatrixOnesSdk.INSTANCE;     // Catch: Exception -> L8
        IMatrixBridge r6 = r5.getBridge$sdk_platform_ones_release();     // Catch: Exception -> L8
        if (r6 == null) goto L10;
        String r7 = r6.did();     // Catch: Exception -> L8
    L11:
        MLog.d$default(TAG, "on event device_id = " + r7, null, 4, null);     // Catch: Exception -> L8
        if (r7 != null) goto L14;
    L19:
        isInit = false;     // Catch: Exception -> L8
        return;
    L14:
        if (r7.length() == 0) goto L19;
        Context r2 = r5.getContext$sdk_platform_ones_release();     // Catch: Exception -> L8
        if (r2 == null) goto L21;
        INSTANCE.initSDKMonitor(r2);     // Catch: Exception -> L8
        goto L21
    L10:
        r7 = null;
    L21:
        r10.put(KEY_SDK_VERSION_CODE, getSdkVersionCode());     // Catch: Exception -> L8
        r10.put(KEY_SDK_NAME, sdkName);     // Catch: Exception -> L8
        MLog.d$default(TAG, "event " + r9 + ", category: " + r10 + ", metric " + r11 + ", logExtr " + r12, null, 4, null);     // Catch: Exception -> L8
        SDKMonitorUtils.getInstance(getSdkAid()).monitorEvent(r9, r10, r11, r12);     // Catch: Exception -> L8
    }
}
