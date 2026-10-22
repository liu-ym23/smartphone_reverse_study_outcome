package com.bytedance.bdlocation.monitor;

import android.content.Context;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.framwork.core.sdkmonitor.k;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LocationMonitorUtil {
    private static final String CONFIG_URL = "https://mon.snssdk.com/monitor/appmonitor/v2/settings";
    private static final String DEFAULT_OVERSEA_REPORT_URL = "https://mon.isnssdk.com/monitor/collect/";
    private static final String DEFAULT_REPORT_URL = "https://mon.snssdk.com/monitor/collect/";
    private static final String OVERSEA_CONFIG_URL = "https://mon.isnssdk.com/monitor/appmonitor/v2/settings";
    private static boolean sIsInit;
    private static k sSDKMonitor;

    public LocationMonitorUtil() {
    }

    private static JSONObject getHeader() {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutString(r0, WsConstants.KEY_DEVICE_ID, BDLocationConfig.getDeviceId());
        JsonUtil.safePutString(r0, "host_aid", BDLocationConfig.getAppId());
        JsonUtil.safePutString(r0, "sdk_version", BDLocationConfig.getSdkVersion());
        JsonUtil.safePutString(r0, "channel", BDLocationConfig.getChannel());
        JsonUtil.safePutString(r0, WsConstants.KEY_APP_VERSION, BDLocationConfig.getAppVersion());
        JsonUtil.safePutString(r0, "update_version_code", BDLocationConfig.getUpdateVersionCode());
        JsonUtil.safePutString(r0, "package_name", BDLocationConfig.getPackageName());
        return r0;
    }

    public static void init(Context r3) {
        if (sIsInit == true) goto L12;
        if (r3 != null) goto L7;
        return;
    L7:
        if (BDLocationConfig.isOverSeas() == false) goto L9;
        SDKMonitorUtils.d(BDLocationConfig.getSlardarAid(), Arrays.asList(new String[]{OVERSEA_CONFIG_URL}));
        String r0 = BDLocationConfig.getSlardarAid();
        List r1 = Arrays.asList(new String[]{DEFAULT_OVERSEA_REPORT_URL});
    L10:
        SDKMonitorUtils.e(r0, r1);
        SDKMonitorUtils.c(r3, BDLocationConfig.getSlardarAid(), getHeader(), new AnonymousClass1());
        sSDKMonitor = SDKMonitorUtils.b(BDLocationConfig.getSlardarAid());
        sIsInit = true;
        return;
    L9:
        SDKMonitorUtils.d(BDLocationConfig.getSlardarAid(), Arrays.asList(new String[]{CONFIG_URL}));
        r0 = BDLocationConfig.getSlardarAid();
        r1 = Arrays.asList(new String[]{DEFAULT_REPORT_URL});
        goto L10
    }

    public static void monitorEvent(String r1) {
        monitorEvent(r1, null, null, null);
    }

    public static void monitorEvent(String r1, JSONObject r2, JSONObject r3) {
        monitorEvent(r1, r2, r3, null);
    }

    public static void monitorEvent(String r1, JSONObject r2, JSONObject r3, JSONObject r4) {
        k r0 = sSDKMonitor;
        if (r0 == null) goto L6;
        r0.X(r1, r2, r3, r4);
        return;
    }
}
