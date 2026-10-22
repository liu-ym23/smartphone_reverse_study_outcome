package com.obric.matrix.platform.sdk.ones.internal.monitor;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SdkMonitorConstants {

    @NotNull
    public static final SdkMonitorConstants INSTANCE = null;

    @NotNull
    public static final String SDK_MONITOR_CONFIG_URL_CN = "https://mon.snssdk.com/monitor/appmonitor/v2/settings";

    @NotNull
    public static final String SDK_MONITOR_CONFIG_URL_OVERSEA = "https://mon.isnssdk.com/monitor/appmonitor/v2/settings";

    @NotNull
    public static final String SDK_MONITOR_REPORT_URL_CN = "https://mon.snssdk.com/monitor/collect/";

    @NotNull
    public static final String SDK_MONITOR_REPORT_URL_OVERSEA = "https://mon.isnssdk.com/monitor/collect/";

    static {
        INSTANCE = new SdkMonitorConstants();
    }

    private SdkMonitorConstants() {
    }
}
