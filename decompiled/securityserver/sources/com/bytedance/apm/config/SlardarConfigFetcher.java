package com.bytedance.apm.config;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.block.FluencyMonitor;
import com.bytedance.apm.constant.ReportConsts;
import com.bytedance.apm.constant.ReportUrl;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.core.IQueryParams;
import com.bytedance.apm.core.MonitorSharedPreferences;
import com.bytedance.apm.doctor.DoctorConstants;
import com.bytedance.apm.impl.HttpRequest;
import com.bytedance.apm.internal.FunctionSwitcher;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.logging.DebugLogger;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.apm.util.NetUtils;
import com.bytedance.apm.util.UrlUtils;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.frameworks.baselib.log.SlardarLogConstants;
import com.bytedance.monitor.collector.LooperMonitor;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.slardar.config.IConfigListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SlardarConfigFetcher implements AsyncEventManager.IMonitorTimeTask {
    private static final long DEFAULT_FAILED_INTERVAL = 60000;
    private static final String PROCESS_NAME = "PROCESS_NAME";
    private static final String TAG = "SlardarConfigFetcher";
    private static final String UPDATE_SETTING_ACTION = "com.apm.setting.update.action";
    private boolean isMultiProcessUpdateSetting;
    private long lastCalculateTimestamp;
    private volatile JSONObject mAllowLogType;
    private volatile JSONObject mAllowService;
    private JSONObject mConfigData;
    private boolean mConfigFromLocal;
    private List<IConfigListener> mConfigListeners;
    private long mConfigNetFetchTimeTs;
    private long mConfigNetRefreshFailedInterval;
    private long mConfigNetRefreshSuccessLastTimeTs;
    private volatile boolean mExceptionEnableUpload;
    private volatile long mFetchSettingInterval;
    private volatile boolean mInitRegister;
    private boolean mIsMainProcess;
    private volatile JSONObject mMetricType;
    private IQueryParams mQueryParams;
    private List<String> mQueryUrls;
    private volatile boolean mReady;
    private volatile SharedPreferences mSharedPreferences;

    public static class FetchRequest {
        private Map<String, String> headerMap;
        private String url;

        public FetchRequest(String r1) {
            this.url = r1;
            this.headerMap = new HashMap();
        }

        private void addVerifyParams() {
        }

        private void appendQuery(Map<String, String> r3) {
            r3.put("minor_version", "1");
            this.url = UrlUtils.addParamsToURL(this.url, r3);
        }

        private void encrypt() {
            this.headerMap.put("Content-Type", "application/json; charset=utf-8");
        }

        public HttpRequest wrap(Map<String, String> r2) {
            appendQuery(r2);
            addVerifyParams();
            encrypt();
            return new HttpRequest(this.url, this.headerMap);
        }
    }

    public SlardarConfigFetcher() {
        this.mExceptionEnableUpload = false;
        this.mQueryUrls = ReportUrl.FETCH_SETTING_LIST;
        this.mFetchSettingInterval = 1200;
        this.mConfigNetRefreshSuccessLastTimeTs = -1;
        this.mConfigNetRefreshFailedInterval = 60000;
        this.mConfigNetFetchTimeTs = -1;
        this.mInitRegister = false;
    }

    public static /* synthetic */ boolean access$000(SlardarConfigFetcher r0) {
        return r0.updateFromLocal();
    }

    public static /* synthetic */ boolean access$100(SlardarConfigFetcher r0) {
        return r0.mIsMainProcess;
    }

    private List<String> convertHost(List<String> r6) {
        if (ListUtils.isEmpty(r6) == true) goto L14;
        ArrayList r5 = new ArrayList(2);     // Catch: MalformedURLException -> L15
        int r0 = r6.size();     // Catch: MalformedURLException -> L15
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L12;
        String r2 = new URL(r6.get(r1)).getHost();     // Catch: MalformedURLException -> L15
        if (TextUtils.isEmpty(r2) == true) goto L11;
        if (r2.indexOf(46) <= 0) goto L11;
        r5.add("https://" + r2 + ReportConsts.SETTING_PATH);     // Catch: MalformedURLException -> L15
    L11:
        r1 = r1 + 1;
        goto L5
    L12:
        return r5;
    L14:
        return Collections.emptyList();
    }

    private boolean handleFetchResult(HttpResponse r6) {
        if (r6 != null) goto L5;
    L20:
        return false;
    L5:
        if (r6.getStatusCode() != 200) goto L20;
        byte[] r7 = r6.getResponseBytes();
        if (r7 != null) goto L9;
        return false;
    L9:
        JSONObject r1 = new JSONObject(new String(r7));
        if (ApmContext.isDebugMode() == false) goto L12;
        Logger.d(TAG, "resultJSON:" + r1);
    L12:
        JSONObject r8 = r1.optJSONObject("data");
        if (r8 == null) goto L17;
        this.mConfigFromLocal = false;
        updateCurrentConfig(r8);
        notifyListenerRefresh(r8, false);
        notifyListenerReady();
        this.mConfigNetRefreshSuccessLastTimeTs = System.currentTimeMillis();
        ApmContext.extendHeader(Constants.KEY_CONFIG_TIME, this.mConfigNetRefreshSuccessLastTimeTs + "");
        com.bytedance.apm6.foundation.context.ApmContext.setConfigTime(this.mConfigNetRefreshSuccessLastTimeTs);
        saveToLocal(r8);
        sendBroadUpdateSetting();
        ApmAlogHelper.i(SlardarLogConstants.TAG_ALOG, DoctorConstants.APM_SETTING_READY);
        return true;
    L17:
        if (r1.optInt("code", -1) != 1) goto L20;
        this.mConfigNetRefreshSuccessLastTimeTs = System.currentTimeMillis();
        SharedPreferences.Editor r9 = this.mSharedPreferences.edit();
        r9.putLong("monitor_configure_refresh_time", this.mConfigNetRefreshSuccessLastTimeTs);
        r9.commit();
        return true;
    }

    private void initRegister() {
        if (this.mInitRegister == true) goto L9;
        this.mInitRegister = true;
        if (isCurrentProcessSupportRequestSetting() == false) goto L7;
        AsyncEventManager.getInstance().addTimeTask(this);
    L7:
        registerBroadUpdateSetting();
        return;
    }

    private void initSharedPreferences() {
        if (this.mSharedPreferences != null) goto L14;
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L6:
        if (this.mSharedPreferences != null) goto L10;
        this.mSharedPreferences = MonitorSharedPreferences.getSharedPreferences(ApmContext.getContext(), "monitor_config");     // Catch: Throwable -> L8
    L10:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    }

    private boolean isCurrentProcessSupportRequestSetting() {
        if (this.mIsMainProcess == false) goto L5;
    L8:
        return true;
    L5:
        if (this.isMultiProcessUpdateSetting == true) goto L8;
        return false;
    }

    private boolean isNeedRefreshFromNet(long r8) {
        long r0 = this.mConfigNetRefreshFailedInterval;
        if (r0 <= 60000) goto L9;
        if ((r8 - this.mConfigNetFetchTimeTs) > r0) goto L7;
        return false;
    L7:
        return true;
    L9:
        if ((r8 - this.mConfigNetRefreshSuccessLastTimeTs) > (this.mFetchSettingInterval * 1000)) goto L11;
        return false;
    L11:
        return true;
    }

    private void notifyListenerReady() {
        if (this.mReady == true) goto L17;
        this.mReady = true;
        List<IConfigListener> r2 = this.mConfigListeners;
        if (r2 == null) goto L24;
        Iterator<IConfigListener> r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L25;
        r3.next().onReady();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (ApmContext.isDebugMode() == false) goto L16;
        th.printStackTrace();
    L16:
        EnsureManager.ensureNotReachHere(th);
        goto L8
    L25:
        return;
    L24:
        return;
    }

    private void notifyListenerRefresh(JSONObject r3, boolean r4) {
        List<IConfigListener> r2 = this.mConfigListeners;
        if (r2 == null) goto L15;
        Iterator<IConfigListener> r5 = r2.iterator();
    L6:
        if (r5.hasNext() == false) goto L22;
        r5.next().onRefresh(r3, r4);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (ApmContext.isDebugMode() == false) goto L14;
        th.printStackTrace();
    L14:
        EnsureManager.ensureNotReachHere(th);
        goto L6
    L22:
        return;
    }

    private void queryFromNet(boolean r7) {
        if (isCurrentProcessSupportRequestSetting() == false) goto L44;
        if (r7 == true) goto L8;
        if (isNeedRefreshFromNet(System.currentTimeMillis()) == true) goto L8;
        return;
    L8:
        if (NetUtils.isNetworkAvailable(ApmContext.getContext()) == true) goto L10;
        return;
    L10:
        IQueryParams r8 = this.mQueryParams;
        if (r8 != null) goto L13;
        return;
    L13:
        if (r8.getQueryParams() != null) goto L15;
        return;
    L15:
        if (this.mQueryParams.getQueryParams().isEmpty() == false) goto L18;
        return;
    L18:
        if (this.lastCalculateTimestamp != 0) goto L20;
        this.lastCalculateTimestamp = this.mSharedPreferences.getLong(SlardarConfigConsts.MONITOR_CONFIG_CALCULATE_TIME, 0);
    L20:
        HashMap r9 = new HashMap(this.mQueryParams.getQueryParams());
        r9.put("last_calculate_timestamp", String.valueOf(this.lastCalculateTimestamp));
        r9.put("slardar_settings_v4", String.valueOf(1));
        if ((System.currentTimeMillis() - this.lastCalculateTimestamp) < 345600000) goto L24;
        r9.put("force_refresh", String.valueOf(1));
    L24:
        if (ApmContext.isDebugMode() == false) goto L26;
        Logger.d(TAG, "queryFromNet:" + r9);
    L26:
        this.mConfigNetFetchTimeTs = System.currentTimeMillis();
        Iterator<String> r0 = this.mQueryUrls.iterator();
        boolean r1 = false;
    L28:
        if (r0.hasNext() == false) goto L32;
        HttpRequest r2 = new FetchRequest(r0.next()).wrap(r9);     // Catch: Throwable -> L36
        r1 = handleFetchResult(ApmContext.doGet(r2.url, r2.headerMap));     // Catch: Throwable -> L36
        if (r1 == false) goto L28;
    L32:
        if (r1 == true) goto L34;
        this.mConfigNetRefreshFailedInterval = Math.min(this.mConfigNetRefreshFailedInterval * 2, 600000);
        return;
    L34:
        this.mConfigNetRefreshFailedInterval = 60000;
        return;
    }

    private long queryLastRefreshTime() {
        return this.mSharedPreferences.getLong("monitor_configure_refresh_time", 0);
    }

    private void registerBroadUpdateSetting() {
        IntentFilter r0 = new IntentFilter();
        r0.addAction(UPDATE_SETTING_ACTION);
        BroadcastReceiver r1 = new AnonymousClass1(this);
        if (ApmContext.getContext() == null) goto L6;
        ApmContext.getContext().registerReceiver(r1, r0);
        return;
    }

    private void saveLocalSwitch(JSONObject r7) {
        JSONObject r6 = r7.optJSONObject("general");
        boolean r0 = true;
        if (r6 == null) goto L5;
        FunctionSwitcher.updateSwitch(32, !r6.optBoolean(SlardarSettingsConsts.ENABLE_SALVAGE_LOG, true));
    L5:
        JSONObject r8 = JsonUtils.optJSONObject(r7, "performance_modules", SlardarSettingsConsts.PERF_KEY_SMOOTH);
        if (r8 != null) goto L8;
    L20:
        JSONObject r9 = JsonUtils.optJSONObject(r7, "performance_modules", "start_trace");
        if (r9 != null) goto L23;
    L35:
        if (r8 != null) goto L37;
        if (r9 != null) goto L37;
        return;
    L37:
        FunctionSwitcher.saveToSp();
        return;
    L23:
        if (r9.optInt(SlardarSettingsConsts.PERF_KEY_PERF_DATA_COLLECT, 0) != 1) goto L25;
        boolean r1 = true;
    L26:
        FunctionSwitcher.updateSwitch(4, r1);
        if (r9.optInt(SlardarSettingsConsts.PERF_KEY_LOCK_DATA_COLLECT, 0) != 1) goto L29;
        boolean r2 = true;
    L30:
        FunctionSwitcher.updateSwitch(8, r2);
        if (r9.optInt(SlardarSettingsConsts.PERF_KEY_LONG_SLEEP_DATA_COLLECT, 0) == 1) goto L34;
        r0 = false;
    L34:
        FunctionSwitcher.updateSwitch(16, r0);
        goto L35
    L29:
        r2 = false;
        goto L30
    L25:
        r1 = false;
        goto L26
    L8:
        if (r8.optInt(SlardarSettingsConsts.PERF_SMOOTH_BLOCK_ENABLE_UPLOAD, 0) != 1) goto L10;
        boolean r3 = true;
    L11:
        FunctionSwitcher.updateSwitch(1, r3);
        if (r8.optInt(SlardarSettingsConsts.PERF_TRACE_ENABLE, 0) != 1) goto L14;
        boolean r4 = true;
    L15:
        FunctionSwitcher.updateSwitch(2, r4);
        if (r8.optInt(SlardarSettingsConsts.PERF_SMOOTH_STACK_SAMPLING, 0) != 1) goto L18;
        boolean r5 = true;
    L19:
        FunctionSwitcher.updateSwitch(64, r5);
        FunctionSwitcher.updateAtraceFlags(r8.optLong(SlardarSettingsConsts.PERF_ATRACE_TAG, 0));
        FunctionSwitcher.updateSwitch(SlardarConfigConsts.MONITOR_RUN_MODE_MASK, FluencyMonitor.getMode(r7) << 29);
        goto L20
    L18:
        r5 = false;
        goto L19
    L14:
        r4 = false;
        goto L15
    L10:
        r3 = false;
        goto L11
    }

    @SuppressLint({"ApplySharedPref"})
    @WorkerThread
    private void saveToLocal(JSONObject r4) {
        saveLocalSwitch(r4);     // Catch: Exception -> L4
        SharedPreferences.Editor r0 = this.mSharedPreferences.edit();     // Catch: Exception -> L4
        r0.putString("monitor_net_config", r4.toString());     // Catch: Exception -> L4
        r0.putInt(SlardarConfigConsts.MONITOR_NET_CONFIG_VERSION, 3);     // Catch: Exception -> L4
        r0.putLong("monitor_configure_refresh_time", this.mConfigNetRefreshSuccessLastTimeTs);     // Catch: Exception -> L4
        long r1 = System.currentTimeMillis();     // Catch: Exception -> L4
        this.lastCalculateTimestamp = r1;     // Catch: Exception -> L4
        r0.putLong(SlardarConfigConsts.MONITOR_CONFIG_CALCULATE_TIME, r1);     // Catch: Exception -> L4
        r0.commit();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Logger.e(TAG, "saveToLocal", e);
    }

    private void sendBroadUpdateSetting() {
        AsyncEventManager.getInstance().postDelay(new AnonymousClass2(this), 1000);
    }

    private void updateCurrentConfig(JSONObject r5) {
        if (JsonUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        JSONObject r0 = JsonUtils.optJSONObject(r5, "general", "slardar_api_settings");
        if (r0 == null) goto L13;
        JSONObject r1 = r0.optJSONObject(SlardarSettingsConsts.SETTING_GENERAL_API_FETCH);
        if (r1 == null) goto L11;
        this.mFetchSettingInterval = r1.optLong(SlardarSettingsConsts.SETTING_GENERAL_API_FETCH_INTERVAL, 1200);
    L11:
        if (this.mFetchSettingInterval >= 600) goto L13;
        this.mFetchSettingInterval = 600;
    L13:
        JSONObject r2 = r5.optJSONObject("custom_event_settings");
        if (r2 == null) goto L16;
        this.mAllowLogType = r2.optJSONObject("allow_log_type");
        this.mMetricType = r2.optJSONObject(SlardarSettingsConsts.BASE_KEY_ALLOW_METRIC_TYPE);
        this.mAllowService = r2.optJSONObject(SlardarSettingsConsts.BASE_KEY_ALLOW_SERVICE_NAME);
    L16:
        this.mConfigData = r5;
        JSONObject r6 = getJson(SlardarSettingsConsts.SETTING_EXCEPTION_CUSTOM_EVENT);
        if (r6 == null) goto L26;
        JSONObject r7 = r6.optJSONObject("exception");
        if (r7 == null) goto L26;
        if (r7.optInt("enable_upload") != 1) goto L23;
        boolean r8 = true;
    L24:
        this.mExceptionEnableUpload = r8;
        goto L26
    L23:
        r8 = false;
    L26:
        if (getServiceSwitch("apm_cost") == false) goto L29;
        LooperMonitor.setReporter(new AnonymousClass3(this));
        LooperMonitor.enableLooperCostMonitor(true);
        return;
    }

    private boolean updateFromLocal() {
        String r1 = queryFromLocal();
        if (ApmAlogHelper.getInnerLogger() == null) goto L6;
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L19
        r2.put("updateFromLocal", TextUtils.isEmpty(r1));     // Catch: Exception -> L19
        ApmAlogHelper.getInnerLogger().d(TAG, r2.toString());     // Catch: Exception -> L19
    L6:
        if (ApmContext.isDebugMode() == false) goto L9;
        Logger.d(TAG, "configStr:" + r1);
    L9:
        if (TextUtils.isEmpty(r1) == true) goto L24;
        JSONObject r3 = new JSONObject(r1);     // Catch: Exception -> L17
        this.mConfigFromLocal = true;     // Catch: Exception -> L17
        if (this.mSharedPreferences.getInt(SlardarConfigConsts.MONITOR_NET_CONFIG_VERSION, 0) != 3) goto L25;
        this.mConfigNetRefreshSuccessLastTimeTs = queryLastRefreshTime();     // Catch: Exception -> L17
        this.lastCalculateTimestamp = this.mSharedPreferences.getLong(SlardarConfigConsts.MONITOR_CONFIG_CALCULATE_TIME, 0);     // Catch: Exception -> L17
        if (ApmContext.isDebugMode() == false) goto L15;
        Logger.d(TAG, "lastCalculateTimestamp:" + this.lastCalculateTimestamp);     // Catch: Exception -> L17
    L15:
        ApmContext.extendHeader(Constants.KEY_CONFIG_TIME, this.mConfigNetRefreshSuccessLastTimeTs + "");     // Catch: Exception -> L17
        com.bytedance.apm6.foundation.context.ApmContext.setConfigTime(this.mConfigNetRefreshSuccessLastTimeTs);     // Catch: Exception -> L17
        updateCurrentConfig(r3);     // Catch: Exception -> L17
        notifyListenerRefresh(r3, true);     // Catch: Exception -> L17
        notifyListenerReady();     // Catch: Exception -> L17
        return false;
    L25:
        return true;
    L17:
        com.bytedance.apm.logging.Logger.e(DebugLogger.TAG_SETTING, new String[]{"config read error"});
        return true;
    L24:
        return true;
    }

    public void addConfigListener(IConfigListener r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (this.mConfigListeners != null) goto L8;
        this.mConfigListeners = new CopyOnWriteArrayList();
    L8:
        if (this.mConfigListeners.contains(r2) == true) goto L11;
        this.mConfigListeners.add(r2);
    L11:
        if (this.mReady == false) goto L14;
        r2.onRefresh(this.mConfigData, this.mConfigFromLocal);
        r2.onReady();
        return;
    }

    @WorkerThread
    public void forceUpdateFromRemote(@Nullable IQueryParams r1, @Nullable List<String> r2) {
        updateFromLocal();
        if (r1 == null) goto L6;
        this.mQueryParams = r1;
    L6:
        if (ListUtils.isEmpty(r2) == true) goto L8;
        this.mQueryUrls = new ArrayList(r2);
    L8:
        queryFromNet(true);
    }

    public JSONObject getConfigData() {
        return this.mConfigData;
    }

    public int getInt(String r2, int r3) {
        if (TextUtils.isEmpty(r2) == true) goto L9;
        JSONObject r1 = this.mConfigData;
        if (r1 == null) goto L9;
        return r1.optInt(r2, r3);
    L9:
        return r3;
    }

    public JSONObject getJson(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L10;
        JSONObject r1 = this.mConfigData;
        if (r1 == null) goto L10;
        return r1.optJSONObject(r2);
    L10:
        return new JSONObject();
    }

    public boolean getLogTypeSwitch(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return false;
    L6:
        if (TextUtils.equals(r3, "block_monitor") == false) goto L9;
        r3 = "caton_monitor";
    L9:
        if (TextUtils.equals(r3, SlardarSettingsConsts.TYPE_ENSURE_MONITOR) == false) goto L13;
        return this.mExceptionEnableUpload;
    L13:
        if (this.mAllowLogType != null) goto L16;
        return false;
    L16:
        if (this.mAllowLogType.optInt(r3) == 1) goto L18;
        return false;
    L18:
        return true;
    }

    public boolean getMetricTypeSwitch(String r3) {
        if (this.mMetricType != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        if (this.mMetricType.optInt(r3) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean getServiceSwitch(String r3) {
        if (this.mAllowService != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        if (this.mAllowService.optInt(r3) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean getSwitch(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L9;
        JSONObject r1 = this.mConfigData;
        if (r1 != null) goto L8;
        return false;
    L8:
        return r1.optBoolean(r2);
    L9:
        return false;
    }

    @WorkerThread
    public void initConfig() {
        boolean r0 = updateFromLocal();
        if (ApmContext.isMainProcess() == true) goto L5;
        return;
    L5:
        if (this.mConfigNetRefreshSuccessLastTimeTs <= System.currentTimeMillis()) goto L7;
        r0 = true;
    L7:
        queryFromNet(r0);
    }

    public void initParams(boolean r1, IQueryParams r2, List<String> r3) {
        this.isMultiProcessUpdateSetting = r1;
        this.mIsMainProcess = ApmContext.isMainProcess();
        initSharedPreferences();
        this.mQueryParams = r2;
        if (ListUtils.isEmpty(r3) == true) goto L5;
        this.mQueryUrls = convertHost(r3);
    L5:
        initRegister();
    }

    public boolean isReady() {
        return this.mReady;
    }

    @Override // com.bytedance.apm.thread.AsyncEventManager.IMonitorTimeTask
    public void onTimeEvent(long r1) {
        queryFromNet(false);
    }

    public String queryFromLocal() {
        initSharedPreferences();
        return this.mSharedPreferences.getString("monitor_net_config", "");
    }

    public void removeConfigListener(IConfigListener r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        List<IConfigListener> r0 = this.mConfigListeners;
        if (r0 == null) goto L8;
        r0.remove(r1);
        return;
    }
}
