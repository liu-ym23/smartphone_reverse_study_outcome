package com.obric.matrix.platform.sdk.ones.internal.monitor;

import kotlin.Metadata;

/* JADX INFO: compiled from: SdkMonitorConstants.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/internal/monitor/SdkMonitorConstants;", "", "()V", "SDK_MONITOR_CONFIG_URL_CN", "", "SDK_MONITOR_CONFIG_URL_OVERSEA", "SDK_MONITOR_REPORT_URL_CN", "SDK_MONITOR_REPORT_URL_OVERSEA", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SdkMonitorConstants {
    public static final SdkMonitorConstants INSTANCE = null;
    public static final String SDK_MONITOR_CONFIG_URL_CN = "https://mon.snssdk.com/monitor/appmonitor/v2/settings";
    public static final String SDK_MONITOR_CONFIG_URL_OVERSEA = "https://mon.isnssdk.com/monitor/appmonitor/v2/settings";
    public static final String SDK_MONITOR_REPORT_URL_CN = "https://mon.snssdk.com/monitor/collect/";
    public static final String SDK_MONITOR_REPORT_URL_OVERSEA = "https://mon.isnssdk.com/monitor/collect/";

    static {
        INSTANCE = new SdkMonitorConstants();
    }

    private SdkMonitorConstants() {
    }
}
