package com.bytedance.apm6.hub.config;

import a.a;
import android.text.TextUtils;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.SlardarHandler;
import com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfig;
import com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfigService;
import com.bytedance.apm6.foundation.safety.CustomExceptionHelper;
import com.bytedance.apm6.hub.config.internal.ConfigConstants;
import com.bytedance.apm6.hub.config.internal.ConfigManager;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.JsonUtils;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.log.Logger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SlardarHandlerConfigManager implements SlardarHandlerConfigService {
    public static final int DEFAULT_LOG_MAX_SAVE_DAYS = 5;
    public static final int DEFAULT_MAX_DB_SIZE_MB = 80;
    String BASE_KEY_ONCE_MAX_SIZE_KB;
    String BASE_KEY_REPORT_INTERVAL;
    String COMPRESS_TYPE;
    String LOG_MAX_SIZE_MB;
    String LOG_RESERVE_DAYS;
    String SETTING_GENERAL_API_REPORT;
    String SETTING_GENERAL_API_REPORT_ENCRYPT;
    String SETTING_GENERAL_API_REPORT_HOSTS;
    String SETTING_GENERAL_ENABLE_REPORT_INTERNAL_EXCEPTION;
    private volatile SlardarHandlerConfig config;
    private JSONObject outsideConfig;

    public SlardarHandlerConfigManager() {
        this.SETTING_GENERAL_API_REPORT = SlardarSettingsConsts.SETTING_GENERAL_API_REPORT;
        this.SETTING_GENERAL_API_REPORT_ENCRYPT = SlardarSettingsConsts.SETTING_GENERAL_API_REPORT_ENCRYPT;
        this.SETTING_GENERAL_API_REPORT_HOSTS = SlardarSettingsConsts.SETTING_GENERAL_API_REPORT_HOSTS;
        this.BASE_KEY_ONCE_MAX_SIZE_KB = "apm6_once_max_size_kb";
        this.BASE_KEY_REPORT_INTERVAL = "apm6_uploading_interval";
        this.SETTING_GENERAL_ENABLE_REPORT_INTERNAL_EXCEPTION = "enable_report_internal_exception";
        this.LOG_RESERVE_DAYS = SlardarSettingsConsts.LOG_RESERVE_DAYS;
        this.LOG_MAX_SIZE_MB = SlardarSettingsConsts.LOG_MAX_SIZE_MB;
        this.COMPRESS_TYPE = "compress_type";
        initConfig();
    }

    public static /* synthetic */ void access$000(SlardarHandlerConfigManager r0, JSONObject r1, boolean r2) {
        r0.parseConfig(r1, r2);
    }

    private void initConfig() {
        ConfigManager.getInstance().init();
        ConfigManager.getInstance().registerConfigListener(new AnonymousClass1(this));
    }

    private void parseConfig(JSONObject r14, boolean r15) {
        if (r14 != null) goto L4;
        return;
    L4:
        JSONObject r16 = JsonUtils.optJSONObject(r14, "general", "slardar_api_settings", this.SETTING_GENERAL_API_REPORT);
        if (r16 != null) goto L7;
        return;
    L7:
        List<String> r0 = parseReportHost(r16.optJSONArray(this.SETTING_GENERAL_API_REPORT_HOSTS));
        ArrayList r2 = new ArrayList();
        String r4 = null;
        if (ListUtils.isEmpty(r0) == true) goto L17;
        Iterator<String> r1 = r0.iterator();
        String r3 = null;
    L11:
        if (r1.hasNext() == false) goto L18;
        String r5 = r1.next();
        r2.add("https://" + r5 + "/monitor/collect/batch/");
        if (r4 != null) goto L15;
        r4 = a.k("https://", r5, "/monitor/collect/c/exception");
    L15:
        if (r3 != null) goto L11;
        r3 = a.k("https://", r5, "/monitor/collect/c/trace_collect");
    L18:
        boolean r6 = true;
        boolean r7 = r16.optBoolean(this.SETTING_GENERAL_API_REPORT_ENCRYPT, true);
        long r9 = r16.optLong(this.BASE_KEY_ONCE_MAX_SIZE_KB, -1) * 1024;
        long r8 = r16.optLong(this.BASE_KEY_REPORT_INTERVAL, -1) * 1000;
        if (JsonUtils.optInt(r14, "general", this.SETTING_GENERAL_ENABLE_REPORT_INTERNAL_EXCEPTION) == 1) goto L22;
        r6 = false;
    L22:
        SlardarHandlerConfig r10 = new SlardarHandlerConfig();
        r10.setReportUrlList(r2);
        r10.setExceptionUrl(r4);
        r10.setTraceReportUrl(r3);
        r10.setOnceReportMaxSizeBytes(r9);
        r10.setEncrypt(r7);
        r10.setReportInterval(r8);
        r10.setUploadInternalException(r6);
        JSONObject r11 = this.outsideConfig;
        if (r11 == null) goto L25;
        r10.setMaxSizeMBToday(r11.optInt(CommonKey.OUTSIDE_MAX_SIZE_MB_TODAY, -1));
    L25:
        r10.setCompressType(r16.optInt(this.COMPRESS_TYPE, 2));
        JSONObject r17 = r14.optJSONObject("general");
        if (r17 == null) goto L30;
        JSONObject r18 = r17.optJSONObject("cleanup");
        if (r18 == null) goto L30;
        r10.setMaxSizeMB(r18.optInt(this.LOG_MAX_SIZE_MB, 80));
        r10.setKeepDays(r18.optInt(this.LOG_RESERVE_DAYS, 5));
    L30:
        this.config = r10;
        if (ApmBaseContext.isDebugMode() == false) goto L33;
        Logger.d(ConfigConstants.LOG_TAG, "received reportSetting=" + r16);
        Logger.d(ConfigConstants.LOG_TAG, "parsed SlardarHandlerConfig=" + this.config);
    L33:
        CustomExceptionHelper.setEnableReport(r6);
        CustomExceptionHelper.setExceptionUrl(r4);
        SlardarHandler.getInstance().setSlardarHandlerConfig(getConfig());
        return;
    L17:
        r3 = null;
        goto L18
    }

    private static List<String> parseReportHost(JSONArray r6) {
        if (r6 == null) goto L23;
    L14:
        e = move-exception;
        Logger.e(Constants.TAG_SETTING, "parse setting host malformedurl exception", e);
    L16:
        e = move-exception;
        Logger.e(Constants.TAG_SETTING, "parse setting host json exception", e);
        goto L23
    L5:
        if (r6.length() <= 0) goto L23;
        ArrayList r1 = new ArrayList(2);     // Catch: MalformedURLException -> L14 JSONException -> L16
        int r2 = r6.length();     // Catch: MalformedURLException -> L14 JSONException -> L16
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L19;
        String r4 = new URL(r6.getString(r3)).getHost();     // Catch: MalformedURLException -> L14 JSONException -> L16
        if (TextUtils.isEmpty(r4) == true) goto L18;
        if (r4.indexOf(46) <= 0) goto L18;
        r1.add(r4);     // Catch: MalformedURLException -> L14 JSONException -> L16
    L18:
        r3 = r3 + 1;
        goto L7
    L19:
        return r1;
    L23:
        return Collections.emptyList();
    }

    @Override // com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfigService
    public SlardarHandlerConfig getConfig() {
        return this.config;
    }

    @Override // com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfigService
    public void setOutsideConfig(JSONObject r1) {
        this.outsideConfig = r1;
    }

    public SlardarHandlerConfigManager(JSONObject r2) {
        this.SETTING_GENERAL_API_REPORT = SlardarSettingsConsts.SETTING_GENERAL_API_REPORT;
        this.SETTING_GENERAL_API_REPORT_ENCRYPT = SlardarSettingsConsts.SETTING_GENERAL_API_REPORT_ENCRYPT;
        this.SETTING_GENERAL_API_REPORT_HOSTS = SlardarSettingsConsts.SETTING_GENERAL_API_REPORT_HOSTS;
        this.BASE_KEY_ONCE_MAX_SIZE_KB = "apm6_once_max_size_kb";
        this.BASE_KEY_REPORT_INTERVAL = "apm6_uploading_interval";
        this.SETTING_GENERAL_ENABLE_REPORT_INTERNAL_EXCEPTION = "enable_report_internal_exception";
        this.LOG_RESERVE_DAYS = SlardarSettingsConsts.LOG_RESERVE_DAYS;
        this.LOG_MAX_SIZE_MB = SlardarSettingsConsts.LOG_MAX_SIZE_MB;
        this.COMPRESS_TYPE = "compress_type";
        this.outsideConfig = r2;
        initConfig();
    }
}
