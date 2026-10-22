package com.bytedance.apm.block;

import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.npth.NpthUtil;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.monitor.collector.PerfMonitorManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class FluencyMonitor {
    public static final int ASCRIBE = 101;
    public static final int NORMAL = 0;
    public static final int OFFLINE = 11;
    public static final int TURNOFF = 1001;
    private static volatile FluencyMonitor sInstance;
    private int mMode;

    private FluencyMonitor() {
        this.mMode = 0;
    }

    public static FluencyMonitor getInstance() {
        if (sInstance != null) goto L16;
        monitor-enter(FluencyMonitor.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new FluencyMonitor();     // Catch: Throwable -> L9
    L11:
        monitor-exit(FluencyMonitor.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    public static int getMode(int r1) {
        if (r1 != 11) goto L5;
        return 2;
    L5:
        if (r1 != 101) goto L7;
        return 3;
    L7:
        if (r1 == 1001) goto L10;
        return 1;
    L10:
        return 0;
    }

    public void init() {
        NpthUtil.addNpthUserData(new AnonymousClass1(this));
    }

    public void onReady() {
        PerfMonitorManager.getInstance().onReady();
    }

    public void onRefresh(int r1, boolean r2) {
        this.mMode = getMode(r1);
        PerfMonitorManager.getInstance().refreshMonitorConfig(this.mMode);
    }

    public static int getMode(JSONObject r3) {
        int r4 = JsonUtils.optInt(r3, "performance_modules", SlardarSettingsConsts.PERF_KEY_SMOOTH, SlardarSettingsConsts.PERF_SMOOTH_BLOCK_MONITOR_MODE);
        if (r4 != 11) goto L5;
        return 2;
    L5:
        if (r4 != 101) goto L7;
        return 3;
    L7:
        if (r4 == 1001) goto L10;
        return 1;
    L10:
        return 0;
    }
}
