package com.bytedance.apm.data.pipeline;

import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.CommonServiceName;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.data.BaseDataPipeline;
import com.bytedance.apm.data.ITypeData;
import com.bytedance.apm.data.type.ApiData;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.apm.samplers.SamplerHelper;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.apm.util.NetUtils;
import com.bytedance.apm.util.ParseUtils;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class NetDataPipeline extends BaseDataPipeline<ApiData> {
    private static final String TYPE_DOWNLOAD = "download";
    private static boolean sAttachNet = false;
    private static long sLaunchCollectExtraInfoTimeMs = 30000;
    private boolean isNetMonitorWithDisconnected;
    private boolean isNetWorkV2;
    private List<String> mAllowReportList;
    private List<Pattern> mAllowReportPatterns;
    private volatile List<String> mBlockReportList;
    private List<Pattern> mBlockReportPatterns;
    private double mEnableBaseApiAll;
    private boolean mEnableCancelErrorReport;
    private boolean mEnableHookNetSample;
    private volatile int mEnableReportApiError;
    private List<String> mImageHostAllowList;
    private INetSlaInnerListener mNetSlaListener;
    private int mReportSLA;
    private List<String> requestAllowHeader;
    private List<String> responseAllowHeader;

    /* JADX INFO: renamed from: com.bytedance.apm.data.pipeline.NetDataPipeline$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class Holder {
        private static final NetDataPipeline sInstance = null;

        private Holder() {
        }

        static /* synthetic */ NetDataPipeline access$000() {
            return sInstance;
        }

        static {
            sInstance = new NetDataPipeline(null);
        }
    }

    static {
    }

    /* synthetic */ NetDataPipeline(AnonymousClass1 r1) {
        this();
    }

    @Override // com.bytedance.apm.data.BaseDataPipeline
    protected /* bridge */ /* synthetic */ boolean checkValid(ITypeData r1) {
        return checkValid((ApiData) r1);
    }

    @Override // com.bytedance.apm.data.BaseDataPipeline
    protected /* bridge */ /* synthetic */ void handleAfterReady(ITypeData r1) {
        handleAfterReady((ApiData) r1);
    }

    @Override // com.bytedance.apm.data.BaseDataPipeline
    protected /* bridge */ /* synthetic */ void hookBeforeRealHandle(ITypeData r1) {
        hookBeforeRealHandle((ApiData) r1);
    }

    private NetDataPipeline() {
        this.mEnableHookNetSample = true;
        this.isNetWorkV2 = true;
        this.mEnableCancelErrorReport = false;
    }

    public static NetDataPipeline getInstance() {
        return Holder.access$000();
    }

    public void setNetSlaListener(INetSlaInnerListener r1) {
        this.mNetSlaListener = r1;
    }

    public void setNetMonitorWithDisconnected(boolean r1) {
        this.isNetMonitorWithDisconnected = r1;
    }

    @Override // com.bytedance.apm.data.BaseDataPipeline, com.bytedance.services.slardar.config.IConfigListener
    public void onRefresh(JSONObject r4, boolean r5) {
        JSONObject r6 = ParseUtils.getJsonObject(r4, SlardarSettingsConsts.SETTING_NETWORK_IMAGE_MODULES);
        if (r6 == null) goto L14;
        JSONObject r7 = ParseUtils.getJsonObject(r6, "network");
        if (r7 == null) goto L10;
        this.mBlockReportList = ParseUtils.parseList(r7, SlardarSettingsConsts.SETTING_NET_API_BLOCK_LIST);
        this.mBlockReportPatterns = ParseUtils.parsePatterns(r7, SlardarSettingsConsts.SETTING_NET_API_BLOCK_LIST);
        this.mAllowReportList = ParseUtils.parseMapList(r7, SlardarSettingsConsts.SETTING_NET_API_ALLOW_LIST);
        this.mAllowReportPatterns = ParseUtils.parseMapPatterns(r7, SlardarSettingsConsts.SETTING_NET_API_ALLOW_LIST);
        boolean r1 = false;
        this.mReportSLA = r7.optInt(SlardarSettingsConsts.SETTING_NET_ENABLE_API_ALL_UPLOAD, 0);
        this.mEnableHookNetSample = r7.optBoolean(SlardarSettingsConsts.SETTING_NET_ENABLE_HOOK_NET_SAMPLE, true);
        this.mEnableReportApiError = r7.optInt(SlardarSettingsConsts.SETTING_NET_ENABLE_API_ERROR_UPLOAD, 1);
        if (r7.optInt(SlardarSettingsConsts.SETTING_ENABLE_CANCEL_ERROR_REPORT) != 1) goto L9;
        r1 = true;
    L9:
        this.mEnableCancelErrorReport = r1;
        this.requestAllowHeader = ParseUtils.parseMapList(r7, SlardarSettingsConsts.SETTING_REQUEST_ALLOW_HEADER);
        this.responseAllowHeader = ParseUtils.parseMapList(r7, SlardarSettingsConsts.SETTING_RESPONSE_ALLOW_HEADER);
        this.mEnableBaseApiAll = r7.optDouble(SlardarSettingsConsts.SETTING_ENABLE_BASE_API_ALL, 0.0d);
    L10:
        JSONObject r8 = ParseUtils.getJsonObject(r6, SlardarSettingsConsts.SETTING_IMAGE);
        if (r8 == null) goto L15;
        this.mImageHostAllowList = ParseUtils.parseMapList(r8, SlardarSettingsConsts.SETTING_IMAGE_ALLOW_LIST);
        return;
    L15:
        return;
    }

    protected boolean checkValid(ApiData r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (TextUtils.isEmpty(r1.sendUrl) == true) goto L6;
        return true;
    }

    protected void hookBeforeRealHandle(ApiData r1) {
        if (isBackground() == true) goto L5;
        boolean r0 = true;
    L6:
        r1.appendFront(r0);     // Catch: JSONException -> L11
        if (isNeedNetInfo() == false) goto L9;
        r1.appendLaunchTraceInfo();     // Catch: JSONException -> L11
    L9:
        r1.appendConsumeType(ApmTrafficStats.KEY_TRAFFIC_SOURCE_TTNET);     // Catch: JSONException -> L11
        return;
    L5:
        r0 = false;
    }

    protected void handleAfterReady(ApiData r1) {
        handleNetSLA(r1);
    }

    private boolean isMatchAllowURI(String r2) {
        return ParseUtils.isMatch(r2, this.mAllowReportList, this.mAllowReportPatterns);
    }

    private boolean isMatchBlackURI(String r2) {
        return ParseUtils.isMatch(r2, this.mBlockReportList, this.mBlockReportPatterns);
    }

    private boolean matchImagePattern(String r1) {
        return ParseUtils.isHostEquals(r1, this.mImageHostAllowList);
    }

    private void handleNetSLA(ApiData r9) {
        String r0 = r9.sendUrl;
        if (matchImagePattern(r0) == false) goto L5;
        return;
    L5:
        if (NetUtils.isNetworkAvailable(ApmContext.getContext()) == true) goto L10;
        if (this.isNetMonitorWithDisconnected == true) goto L10;
        return;
    L10:
        if (isCancelErrorCode(r9.extJson) == true) goto L12;
    L14:
        String r4 = r9.apiType;
        JSONObject r5 = r9.packLog();
        JsonUtils.combineJson(r5, r9.extJson);
        if (r5 != null) goto L17;
        return;
    L17:
        boolean r3 = true;
        if (TextUtils.equals(r4, "api_all") == false) goto L28;
        if (isEnableBaseApiAll() == false) goto L24;
        handleApiAllSample(r0, r5);
    L22:
        boolean r7 = r3;
    L35:
        if (this.isNetWorkV2 == false) goto L37;
        addNetWorkV2Info(r5, r9.apiType);
    L37:
        checkWhiteHeader(r5);
        if (this.mNetSlaListener != null) goto L40;
    L44:
        logSend(r4, r4, r5, r7, true);
        return;
    L40:
        if ("api_all".equals(r4) == false) goto L44;
        if (r9.extJson.optBoolean(TYPE_DOWNLOAD, false) == true) goto L44;
        this.mNetSlaListener.deliver(r0, r9.extJson);
        goto L44
    L24:
        if (isMatchBlackURI(r0) == true) goto L33;
        r7 = handleApiAllSample(r0, r5);
    L33:
        r7 = false;
        goto L35
    L28:
        if (TextUtils.equals(r4, "api_error") == false) goto L33;
        if (this.mEnableReportApiError == 1) goto L22;
        r3 = false;
        goto L22
    L12:
        if (this.mEnableCancelErrorReport == true) goto L14;
    }

    private boolean isCancelErrorCode(JSONObject r2) {
        if (r2 != null) goto L12;
        return false;
    L12:
        String r1 = r2.optString(CommonServiceName.CRONET_INTERNAL_ERROR_CODE);     // Catch: Exception -> L11
        if (CommonServiceName.CRONET_ERROR_CODE_CANCEL.equals(r2.optString(CommonServiceName.CRONET_ERROR_CODE)) == false) goto L14;
        if (CommonServiceName.CRONET_INTERNAL_ERROR_CODE_CANCEL.equals(r1) == false) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    L16:
        return false;
    }

    private void checkWhiteHeader(JSONObject r3) {
        checkWhiteHeaderSetting(this.requestAllowHeader, r3, SlardarSettingsConsts.EXT_REQUEST_HEADER);
        checkWhiteHeaderSetting(this.responseAllowHeader, r3, SlardarSettingsConsts.EXT_RESPONSE_HEADER);
    }

    private void checkWhiteHeaderSetting(List<String> r5, JSONObject r6, String r7) {
        if (r5 == null) goto L31;
        if (r6 == null) goto L32;
    L19:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        if (TextUtils.isEmpty(r7) == true) goto L33;
        String r4 = r6.optString(r7);     // Catch: JSONException -> L16 Exception -> L19
        if (TextUtils.isEmpty(r4) == true) goto L34;
        JSONObject r0 = new JSONObject(r4);     // Catch: JSONException -> L16 Exception -> L19
        JSONObject r8 = new JSONObject();     // Catch: JSONException -> L16 Exception -> L19
        Iterator<String> r1 = r0.keys();     // Catch: JSONException -> L16 Exception -> L19
    L10:
        if (r1.hasNext() == false) goto L14;
        String r2 = r1.next();     // Catch: JSONException -> L16 Exception -> L19
        if (r5.contains(r2) == false) goto L10;
        r8.put(r2, r0.opt(r2));     // Catch: JSONException -> L16 Exception -> L19
        goto L10
    L14:
        r6.put(r7, r8.toString());     // Catch: JSONException -> L16 Exception -> L19
    L35:
        return;
    L34:
        return;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L19
        return;
    L33:
        return;
    L32:
        return;
    }

    private void addNetWorkV2Info(JSONObject r5, String r6) {
        if (r5 == null) goto L30;
    L25:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        if (TextUtils.equals(r6, "api_all") == false) goto L8;
        r5.put(CommonKey.KEY_NET_LOG_TYPE, CommonServiceName.MONITOR_TYPE_API_ALL_V2);     // Catch: Exception -> L25
    L12:
        if (isEnableBaseApiAll() == false) goto L17;
        if (isEnableHookNetSample() == false) goto L17;
        r5.put(CommonServiceName.MONITOR_INJECT_TRACE_LOG, "01");     // Catch: Exception -> L25
    L21:
        double r0 = this.mEnableBaseApiAll;     // Catch: Exception -> L25
        if (r0 == 0.0d) goto L31;
        r5.put(SlardarSettingsConsts.SETTING_ENABLE_BASE_API_ALL, r0);     // Catch: Exception -> L25
        return;
    L31:
        return;
    L17:
        if (getReportSLA() != 1) goto L21;
        if (isEnableHookNetSample() == false) goto L21;
        r5.put(CommonServiceName.MONITOR_INJECT_TRACE_LOG, "02");     // Catch: Exception -> L25
        goto L21
    L8:
        if (TextUtils.equals(r6, "api_error") == false) goto L12;
        r5.put(CommonKey.KEY_NET_LOG_TYPE, CommonServiceName.MONITOR_TYPE_API_ERROR_V2);     // Catch: Exception -> L25
        goto L12
    }

    private boolean handleApiSample(String r2, String r3, JSONObject r4) {
        if (TextUtils.equals(r2, "api_all") == false) goto L7;
        return handleApiAllSample(r3, r4);
    L7:
        if (TextUtils.equals(r2, "api_error") == true) goto L9;
        return false;
    L9:
        if (this.mEnableReportApiError == 1) goto L11;
        return false;
    L11:
        return true;
    }

    private boolean handleApiAllSample(String r5, JSONObject r6) {
        if (isEnableBaseApiAll() == false) goto L5;
    L10:
        int r4 = 1;
    L11:
        boolean r7 = SamplerHelper.getServiceSwitch(CommonServiceName.MONITOR_TYPE_SMART_TRAFFIC);
        if (r7 == false) goto L14;
        int r0 = r4 | 4;
    L21:
        r6.put("hit_rules", r0);     // Catch: JSONException -> L20
    L16:
        if (r4 != 0) goto L19;
        if (r7 == true) goto L19;
        return false;
    L19:
        return true;
    L14:
        r0 = r4;
        goto L21
    L5:
        if (this.mReportSLA != 0) goto L10;
        if (isMatchAllowURI(r5) == true) goto L10;
        r4 = 0;
        goto L11
    }

    public boolean isEnableBaseApiAll() {
        if (this.isNetWorkV2 == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mEnableBaseApiAll == 0.0d) goto L7;
        return true;
    }

    public int getReportSLA() {
        return this.mReportSLA;
    }

    public boolean isNetWorkV2() {
        return this.isNetWorkV2;
    }

    public boolean isEnableHookNetSample() {
        return this.mEnableHookNetSample;
    }

    public NetSampleResult checkSample(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return null;
    L7:
        if (isConfigReady() == true) goto L11;
        return NetSampleResult.UNKNOWN;
    L11:
        if (isEnableBaseApiAll() == true) goto L18;
        if (this.mReportSLA != 0) goto L18;
        return NetSampleResult.NOT_HIT;
    L18:
        return NetSampleResult.HIT;
    }

    public static void setLaunchCollectExtraInfoTimeMs(long r0) {
        sLaunchCollectExtraInfoTimeMs = r0;
    }

    public static void setLaunchCollectExtraInfoFlag(boolean r0) {
        sAttachNet = r0;
    }

    public static boolean isNeedNetInfo() {
        if (sAttachNet == true) goto L6;
        return false;
    L6:
        if (ApmContext.getAppLaunchStartTimestamp() != 0) goto L9;
        return false;
    L9:
        if ((System.currentTimeMillis() - ApmContext.getAppLaunchStartTimestamp()) <= sLaunchCollectExtraInfoTimeMs) goto L11;
        return false;
    L11:
        return true;
    }
}
