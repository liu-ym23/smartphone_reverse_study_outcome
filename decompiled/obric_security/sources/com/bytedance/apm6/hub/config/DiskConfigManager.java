package com.bytedance.apm6.hub.config;

import com.bytedance.apm.util.ParseUtils;
import com.bytedance.apm6.disk.Constants;
import com.bytedance.apm6.disk.DiskCollector;
import com.bytedance.apm6.disk.config.DiskConfig;
import com.bytedance.apm6.disk.config.DiskConfigService;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.hub.config.internal.ConfigManager;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.apm6.util.log.Logger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DiskConfigManager implements DiskConfigService {
    private static final int DEFAULT_EXCEPTION_DIR_COUNT = 50;
    private static final int DEFAULT_FILE_SIZE = 100;
    private static final int DEFAULT_OUTDATED_COUNT = 50;
    private static final int DEFAULT_TOP_FILE_COUNT = 20;
    private DiskConfig config;

    static /* synthetic */ void access$000(DiskConfigManager r0, JSONObject r1, boolean r2) {
        r0.parseConfig(r1, r2);
    }

    public DiskConfigManager() {
        ConfigManager.getInstance().init();
        ConfigManager.getInstance().registerConfigListener(new AnonymousClass1(this));
    }

    @Override // com.bytedance.apm6.disk.config.DiskConfigService
    public DiskConfig getConfig() {
        return this.config;
    }

    private void parseConfig(JSONObject r7, boolean r8) {
        JSONObject r9 = r7.optJSONObject("performance_modules");
        if (r9 != null) goto L5;
        return;
    L5:
        JSONObject r10 = r9.optJSONObject("disk");
        if (r10 != null) goto L9;
        return;
    L9:
        if (ApmContext.isDebugMode() == false) goto L11;
        Logger.d(Constants.TAG, "parseConfig:" + r10);
    L11:
        DiskConfig r11 = new DiskConfig();
        boolean r3 = false;
        r11.setEnable(r10.optBoolean("enable_collect_apm6", false));
        if (r10.optInt("enable_upload", 0) != 1) goto L14;
        r3 = true;
    L14:
        r11.setSample(r3);
        if (r10.optInt("dump_threshold") <= 0) goto L18;
        r11.setDiskThresholdBytes((((long) r10.optInt("dump_threshold")) * 1024) * 1024);
    L18:
        if (r10.optInt("abnormal_folder_size") <= 0) goto L20;
        r11.setFolderThresholdBytes((((long) r10.optInt("abnormal_folder_size")) * 1024) * 1024);
    L20:
        r11.setFileThresholdBytes(((long) r10.optInt(SlardarSettingsConstants.PERF_DISK_KEY_ABNORMAL_FILE_SIZE, 100)) * 1024);
        if (r10.optInt("dump_top_count") <= 0) goto L23;
        r11.setReportMaxCount(r10.optInt("dump_top_count"));
    L23:
        r11.setReportMaxOutdatedCount(r10.optInt(SlardarSettingsConstants.PERF_DISK_KEY_DUMP_OUTDATED_COUNT, 50));
        r11.setReportMaxTopCount(r10.optInt(SlardarSettingsConstants.PERF_DISK_KEY_DUMP_TOP_FILE_COUNT, 20));
        r11.setReportExceptionDirMaxCount(r10.optInt(SlardarSettingsConstants.PERF_DISK_KEY_DUMP_TOP_EXCEPTION_DIR_COUNT, 50));
        if (r10.optInt("outdated_days") <= 0) goto L26;
        r11.setOutdatedIntervalMs(((long) r10.optInt("outdated_days")) * 86400000);
    L26:
        r11.setCustomRelativePaths(ParseUtils.parseMapList(r10, "disk_customed_paths"));
        r11.setIgnoredRelativePaths(ParseUtils.parseList(r10, "ignored_relative_paths"));
        r11.setComplianceRelativePaths(ParseUtils.parseList(r10, "compliance_relative_paths"));
        this.config = r11;
        if (ApmContext.isDebugMode() == false) goto L29;
        Logger.d(Constants.TAG, "parseConfig:" + r10);
    L29:
        DiskCollector.getInstance().updateConfig(getConfig());
    }
}
