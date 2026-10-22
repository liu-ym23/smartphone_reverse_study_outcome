package com.bytedance.frameworks.baselib.network.http.storeregion;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Response;
import org.apache.commons.math3.geometry.VectorFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class StoreRegionManager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String APP_INIT_REGION_HEADER = "x-tt-app-init-region";
    public static final String LOG_ID_HEADER = "x-tt-logid";
    private static final String RECEIVED_REGION_CONFIG = "received_region_config";
    private static final String REGION_SOURCE_LOCAL = "local";
    public static final String SET_COOKIE = "Set-Cookie";
    public static final String STORE_COUNTRY_CODE_COOKIE = "store-country-code=";
    public static final String STORE_COUNTRY_CODE_SOURCE_COOKIE = "store-country-code-src=";
    private static final String STORE_REGION = "store_region";
    public static final String STORE_REGION_COOKIE = "store-region=";
    private static final String STORE_REGION_DOMAIN = "add_store_idc_host_list";
    public static final String STORE_REGION_HEADER = "x-tt-store-region";
    private static final String STORE_REGION_PATH = "update_store_idc_path_list";
    public static final String STORE_REGION_SOURCE_COOKIE = "store-region-src=";
    private static final String STORE_REGION_SP_NAME = "ttnet_store_region";
    private static final String STORE_REGION_SRC = "store_region_src";
    public static final String STORE_REGION_SRC_HEADER = "x-tt-store-region-src";
    private static final String STORE_SEC_UID = "store_sec_uid";
    public static final String STORE_SEC_UID_HEADER = "x-tt-store-sec-uid";
    private static final String TAG = "StoreRegionManager";
    public static final String TNC_ATTR_HEADER = "x-tt-tnc-attr";
    public static final String TNC_CONFIG_HEADER = "x-tt-tnc-config";
    public static final String TNC_ETAG_HEADER = "x-ss-etag";
    private static final String UPDATE_REGION_INFO = "update_region_info";
    public static final String WITH_TNC_CONFIG_HEADER = "x-tt-with-tnc";
    private static boolean mUseDomesticStoreRegion;
    private static volatile StoreRegionManager sInstance;
    private Context mContext;
    private String mInitRegion;
    private boolean mReceivedTNCRegionConfig;
    private String mStoreRegion;
    private StoreRegionBridge mStoreRegionBridge;
    private List<String> mStoreRegionHostList;
    private String mStoreRegionLocal;
    private List<String> mStoreRegionPathList;
    private boolean mStoreRegionRuleEnabled;
    private String mStoreRegionSrc;
    private String mStoreSecUid;
    private String mUpdateRegionInfo;

    public interface StoreRegionCallback {
        void notifyStoreRegionUpdatedForCronet(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10);
    }

    static {
    }

    public static StoreRegionManager inst() {
        if (sInstance != null) goto L15;
        monitor-enter(StoreRegionManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new StoreRegionManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(StoreRegionManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private StoreRegionManager() {
        this.mStoreRegion = "";
        this.mStoreRegionSrc = "";
        this.mStoreSecUid = "";
        this.mStoreRegionLocal = "";
        this.mUpdateRegionInfo = "";
        this.mInitRegion = "";
        this.mStoreRegionPathList = new ArrayList();
        this.mStoreRegionHostList = new ArrayList();
    }

    public void setReceivedTNCRegionConfig() {
        if (this.mReceivedTNCRegionConfig == true) goto L6;
        this.mReceivedTNCRegionConfig = true;
        SharedPreferences.Editor r3 = this.mContext.getSharedPreferences(STORE_REGION_SP_NAME, 0).edit();
        r3.putBoolean(RECEIVED_REGION_CONFIG, true);
        r3.apply();
        return;
    }

    public boolean isStoreRegionRuleEnabled() {
        return this.mStoreRegionRuleEnabled;
    }

    public String getStoreRegion() {
        return this.mStoreRegion;
    }

    public String getStoreRegionSrc() {
        return this.mStoreRegionSrc;
    }

    public void initStoreRegionRuleConfig(String r6, String r7, String r8, Context r9, StoreRegionBridge r10) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "rule json: " + r7);
    L6:
        if (TextUtils.isEmpty(r7) == true) goto L44;
        if (r9 == null) goto L45;
        if (r10 == null) goto L48;
        JSONObject r0 = new JSONObject(r7);     // Catch: JSONException -> L33
        JSONArray r11 = r0.optJSONArray(STORE_REGION_PATH);     // Catch: JSONException -> L33
        int r1 = 0;
        int r2 = 0;
    L12:
        if (r2 >= r11.length()) goto L17;
        String r3 = r11.getString(r2);     // Catch: JSONException -> L33
        if (TextUtils.isEmpty(r3) == true) goto L16;
        this.mStoreRegionPathList.add(r3);     // Catch: JSONException -> L33
    L16:
        r2 = r2 + 1;     // Catch: JSONException -> L33
        goto L12
    L17:
        JSONArray r12 = r0.optJSONArray(STORE_REGION_DOMAIN);     // Catch: JSONException -> L33
    L19:
        if (r1 >= r12.length()) goto L24;
        String r4 = r12.getString(r1);     // Catch: JSONException -> L33
        if (TextUtils.isEmpty(r4) == true) goto L23;
        this.mStoreRegionHostList.add(r4);     // Catch: JSONException -> L33
    L23:
        r1 = r1 + 1;     // Catch: JSONException -> L33
        goto L19
    L24:
        this.mContext = r9;     // Catch: JSONException -> L33
        this.mStoreRegionBridge = r10;     // Catch: JSONException -> L33
        if (TextUtils.isEmpty(r6) == true) goto L28;
        this.mStoreRegionLocal = r6.toLowerCase();     // Catch: JSONException -> L33
    L28:
        if (this.mStoreRegionHostList.isEmpty() == false) goto L30;
        return;
    L30:
        if (this.mStoreRegionPathList.isEmpty() == true) goto L47;
        this.mStoreRegionRuleEnabled = true;     // Catch: JSONException -> L33
        this.mInitRegion = r8;     // Catch: JSONException -> L33
        loadLocalConfig();     // Catch: JSONException -> L33
        return;
    L47:
        return;
    L33:
        e = move-exception;
        e.printStackTrace();
        return;
    L48:
        return;
    L45:
        return;
    }

    private void loadLocalConfig() {
        SharedPreferences r0 = this.mContext.getSharedPreferences(STORE_REGION_SP_NAME, 0);
        this.mStoreRegion = r0.getString("store_region", "");
        this.mStoreRegionSrc = r0.getString(STORE_REGION_SRC, "");
        this.mStoreSecUid = r0.getString(STORE_SEC_UID, "");
        this.mUpdateRegionInfo = r0.getString(UPDATE_REGION_INFO, "");
        this.mReceivedTNCRegionConfig = r0.getBoolean(RECEIVED_REGION_CONFIG, false);
        if (TextUtils.isEmpty(this.mStoreRegion) == true) goto L5;
    L7:
        this.mStoreRegionBridge.onStoreIdcChanged("", this.mStoreRegion, this.mStoreRegionSrc, this.mStoreSecUid, "");
        if (Logger.debug() == false) goto L11;
        Logger.d(TAG, "Init region:" + this.mStoreRegion + " sec_uid:" + this.mStoreSecUid + " source:" + this.mStoreRegionSrc + " local:" + this.mStoreRegionLocal + " init region:" + this.mInitRegion + " region config:" + this.mReceivedTNCRegionConfig);
        return;
    L11:
        return;
    L5:
        if (TextUtils.isEmpty(this.mStoreRegionLocal) == true) goto L7;
        this.mStoreRegion = this.mStoreRegionLocal;
        this.mStoreRegionSrc = REGION_SOURCE_LOCAL;
        goto L7
    }

    private boolean addExtraParamsForDidAndUidPath(Request r5, Request.Builder r6) {
        if (TextUtils.isEmpty(r5.getPath()) == false) goto L6;
        return false;
    L6:
        if ("/get_domains/v5/".equals(r5.getPath()) == false) goto L8;
        return true;
    L8:
        Iterator<String> r4 = this.mStoreRegionPathList.iterator();
    L10:
        if (r4.hasNext() == false) goto L14;
        if (UrlUtils.matchPattern(r5.getPath(), r4.next()) == false) goto L10;
        boolean r7 = true;
    L15:
        if (r7 == true) goto L17;
        return false;
    L17:
        UrlBuilder r8 = new UrlBuilder(r5.getUrl());
        r8.addParam("okhttp_version", "4.2.211.1-rc.0");
        r8.addParam("use_store_region_cookie", "1");
        r6.url(r8.build());
        return true;
    L14:
        r7 = false;
        goto L15
    }

    public Request addStoreRegionHeaderForOkHttp(Request r7) {
        if (this.mStoreRegionRuleEnabled == true) goto L5;
    L47:
        return null;
    L5:
        if (TextUtils.isEmpty(r7.getHost()) == true) goto L47;
        if (r7.isPureRequest() == false) goto L10;
        return null;
    L10:
        Iterator<String> r0 = this.mStoreRegionHostList.iterator();
    L11:
        boolean r3 = true;
        if (r0.hasNext() == false) goto L16;
        if (UrlUtils.matchPattern(r7.getHost(), r0.next()) == false) goto L11;
        boolean r1 = true;
    L17:
        ArrayList r2 = new ArrayList();
        if (this.mReceivedTNCRegionConfig == false) goto L20;
    L22:
        r3 = r1;
    L23:
        if (r3 == true) goto L26;
        return null;
    L26:
        if (r7.getHeaders() == null) goto L28;
        r2.addAll(r7.getHeaders());
    L28:
        Request.Builder r4 = r7.newBuilder();
        if (addExtraParamsForDidAndUidPath(r7, r4) == false) goto L33;
        r4.headers(r2);
        return r4.build();
    L33:
        if (this.mStoreRegion.isEmpty() == true) goto L36;
        String r8 = this.mStoreRegion;
    L40:
        if (TextUtils.isEmpty(r8) == true) goto L43;
        r2.add(new Header(STORE_REGION_HEADER, r8));
    L43:
        if (TextUtils.isEmpty(this.mStoreRegionSrc) == true) goto L45;
        r2.add(new Header(STORE_REGION_SRC_HEADER, this.mStoreRegionSrc));
    L45:
        r4.headers(r2);
        return r4.build();
    L36:
        if (this.mStoreRegionLocal.isEmpty() == true) goto L38;
        r8 = this.mStoreRegionLocal;
        goto L40
    L38:
        r8 = "";
        goto L40
    L20:
        if (TextUtils.isEmpty(this.mInitRegion) == true) goto L22;
        r2.add(new Header(APP_INIT_REGION_HEADER, this.mInitRegion));
        goto L23
    L16:
        r1 = false;
        goto L17
    }

    public void addStoreIdcHeaderForGetDomain(Map<String, String> r2) {
        if (this.mStoreRegionRuleEnabled == false) goto L12;
        if (r2 != null) goto L7;
        return;
    L7:
        if (this.mReceivedTNCRegionConfig == false) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(this.mInitRegion) == true) goto L14;
        r2.put(APP_INIT_REGION_HEADER, this.mInitRegion);
        return;
    L14:
        return;
    }

    public void updateStoreRegionForOkHttp(Response r18, String r19, byte[] r20) {
        if (this.mStoreRegionRuleEnabled == true) goto L54;
        return;
    L54:
        URI r3 = UrlUtils.safeCreateUri(r19);     // Catch: Exception -> L51
        String r4 = r3.getHost() + r3.getPath();     // Catch: Exception -> L51
        if (r3 != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r3.getPath()) == false) goto L11;
        return;
    L11:
        if (canUpdateStoreRegionFromPath(r3.getPath()) == true) goto L13;
        return;
    L13:
        Pair<String, String> r5 = extractStoreRegionFromCookieHeaders(r18.headers("Set-Cookie"));
        String r6 = r18.header(TNC_ETAG_HEADER);
        String r7 = r18.header(TNC_ATTR_HEADER);
        String r0 = r18.header(WITH_TNC_CONFIG_HEADER);
        if (TextUtils.isEmpty(r0) == false) goto L16;
    L21:
        JSONObject r1 = null;
    L23:
        if (r5 != null) goto L27;
        if (r1 == null) goto L27;
        this.mStoreRegionBridge.updateTncConfig(r1, r6, r7, false);
        return;
    L27:
        if (r5 != null) goto L30;
        return;
    L30:
        if (Logger.debug() == false) goto L32;
        Logger.d(TAG, "origin region:" + this.mStoreRegion + " sec_uid:" + this.mStoreSecUid + " source:" + this.mStoreRegionSrc + " local:" + this.mStoreRegionLocal);
    L32:
        boolean r9 = !this.mStoreRegion.equals(r5.first);
        String r15 = r18.header(STORE_SEC_UID_HEADER);
        if (r15 != null) goto L35;
        r15 = "";
    L35:
        SharedPreferences.Editor r8 = this.mContext.getSharedPreferences(STORE_REGION_SP_NAME, 0).edit();
        if (this.mStoreRegion.equals(r5.first) == true) goto L38;
    L43:
        this.mStoreRegion = (String) r5.first;
        this.mStoreRegionSrc = (String) r5.second;
        this.mStoreSecUid = r15;
        r8.putString("store_region", this.mStoreRegion);
        r8.putString(STORE_REGION_SRC, this.mStoreRegionSrc);
        r8.putString(STORE_SEC_UID, this.mStoreSecUid);
        boolean r10 = true;
    L45:
        if (Logger.debug() == false) goto L47;
        Logger.d(TAG, "update region:" + this.mStoreRegion + " sec_uid:" + this.mStoreSecUid + " source:" + this.mStoreRegionSrc + " local:" + this.mStoreRegionLocal);
        Logger.d(TAG, "save config:" + r10 + " update tnc:" + r9);
    L47:
        boolean r2 = this.mStoreRegionBridge.updateTncConfig(r1, r6, r7, r9);
        if (r10 == false) goto L57;
        String r12 = r18.header("x-tt-logid");
        String r11 = r3.getPath() + "," + r12 + "," + ((String) r5.first) + "," + ((String) r5.second);
        this.mUpdateRegionInfo = r11;
        r8.putString(UPDATE_REGION_INFO, r11);
        r8.apply();
        this.mStoreRegionBridge.sendFeedbackLog(getStoreRegionChangeLog(r12, r4, r2), CronetDataStorageAccess.STORE_IDC);
        this.mStoreRegionBridge.onStoreIdcChanged("", this.mStoreRegion, this.mStoreRegionSrc, this.mStoreSecUid, r12);
        return;
    L57:
        return;
    L38:
        if (this.mStoreRegionSrc.equals(r5.second) == false) goto L43;
        if (r15.equals(this.mStoreSecUid) == false) goto L43;
        r10 = false;
        goto L45
    L16:
        if (r0.equals("1") == false) goto L21;
        r1 = new JSONObject(new String(r20)).getJSONObject("tnc_data");     // Catch: JSONException -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
    }

    public void saveStoreRegionForCronet(String r1, String r2, String r3, String r4, String r5) {
        if (this.mContext != null) goto L5;
        return;
    L5:
        if (this.mStoreRegionRuleEnabled == true) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty(r3) == false) goto L13;
        return;
    L13:
        if (this.mStoreRegion.equalsIgnoreCase(r2) == true) goto L15;
    L19:
        this.mStoreSecUid = r4;
        this.mStoreRegion = r2;
        this.mStoreRegionSrc = r3;
        if (Logger.debug() == false) goto L22;
        Logger.d(TAG, "saveStoreRegionForCronet region:" + this.mStoreRegion + " source:" + this.mStoreRegionSrc + " sec uid:" + this.mStoreSecUid);
    L22:
        SharedPreferences.Editor r6 = this.mContext.getSharedPreferences(STORE_REGION_SP_NAME, 0).edit();
        r6.putString("store_region", this.mStoreRegion);
        r6.putString(STORE_REGION_SRC, this.mStoreRegionSrc);
        r6.putString(STORE_SEC_UID, this.mStoreSecUid);
        r6.apply();
        return;
    L15:
        if (this.mStoreRegionSrc.equalsIgnoreCase(r3) == false) goto L19;
        if (this.mStoreSecUid.equalsIgnoreCase(r4) == false) goto L19;
    }

    private String getStoreRegionChangeLog(String r4, String r5, boolean r6) {
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();
        r1.put("url", r5);     // Catch: JSONException -> L5
        r1.put("logId", r4);     // Catch: JSONException -> L5
        r0.put("tnc", r6);     // Catch: JSONException -> L5
        r0.put(TraceStatsConsts.STATS_BASE_MODULE, r1);     // Catch: JSONException -> L5
        r0.put("report_time", System.currentTimeMillis());     // Catch: JSONException -> L5
        r0.put("store_region", this.mStoreRegion);     // Catch: JSONException -> L5
        r0.put("source", this.mStoreRegionSrc);     // Catch: JSONException -> L5
        r0.put(REGION_SOURCE_LOCAL, this.mStoreRegionLocal);     // Catch: JSONException -> L5
    L8:
        return r0.toString();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    private boolean canUpdateStoreRegionFromPath(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return false;
    L5:
        Iterator<String> r2 = this.mStoreRegionPathList.iterator();
    L7:
        if (r2.hasNext() == false) goto L12;
        if (UrlUtils.matchPattern(r3, r2.next()) == false) goto L7;
        return true;
    L12:
        return false;
    }

    private Pair<String, String> extractStoreRegionFromCookieHeaders(List<String> r9) {
        if (r9 != null) goto L5;
        return null;
    L5:
        if (r9.isEmpty() == false) goto L8;
        return null;
    L8:
        if (mUseDomesticStoreRegion == false) goto L10;
        String r0 = STORE_REGION_COOKIE;
        String r1 = STORE_REGION_SOURCE_COOKIE;
    L11:
        Iterator<String> r10 = r9.iterator();
        String r2 = "";
        String r3 = "";
        String r4 = r3;
    L13:
        if (r10.hasNext() == false) goto L21;
        String r5 = r10.next();
        if (r5.toLowerCase().startsWith(r0) == true) goto L16;
        if (r5.toLowerCase().startsWith(r1) == false) goto L13;
        r4 = r5;
        goto L13
    L16:
        r3 = r5;
        goto L13
    L21:
        if (TextUtils.isEmpty(r3) == false) goto L23;
        return null;
    L23:
        String[] r6 = r3.split(";");
        if (r6 != null) goto L26;
    L32:
        String r7 = "";
    L34:
        if (TextUtils.isEmpty(r4) == true) goto L45;
        String[] r11 = r4.split(";");
        if (r11 == null) goto L45;
        if (r11.length <= 0) goto L45;
        String[] r12 = r11[0].trim().split("=");
        if (r12 == null) goto L45;
        if (r12.length != 2) goto L45;
        r2 = r12[1];
    L45:
        if (r7.isEmpty() == false) goto L48;
        return null;
    L48:
        return new Pair(r7, r2);
    L26:
        if (r6.length <= 0) goto L32;
        String[] r8 = r6[0].trim().split("=");
        if (r8 == null) goto L32;
        if (r8.length != 2) goto L32;
        r7 = r8[1];
        goto L34
    L10:
        r0 = STORE_COUNTRY_CODE_COOKIE;
        r1 = STORE_COUNTRY_CODE_SOURCE_COOKIE;
        goto L11
    }

    public void updateStoreRegionForCronet(HttpURLConnection r18, byte[] r19, StoreRegionCallback r20) {
        if (r18 != null) goto L5;
        return;
    L5:
        if (this.mStoreRegionRuleEnabled == true) goto L8;
        return;
    L8:
        if (canUpdateStoreRegionFromPath(r18.getURL().getPath()) == true) goto L10;
        return;
    L10:
        Map<String, List<String>> r2 = r18.getHeaderFields();
        List<String> r4 = r2.get("Set-Cookie");
        if (r4 != null) goto L13;
    L14:
        r4 = r2.get("Set-Cookie".toLowerCase());
    L15:
        Pair<String, String> r3 = extractStoreRegionFromCookieHeaders(r4);
        String r0 = getHeaderValueIgnoreCase(r2, WITH_TNC_CONFIG_HEADER);
        String r5 = "";
        if (TextUtils.isEmpty(r0) == false) goto L18;
    L23:
        String r13 = "";
    L24:
        if (r3 == null) goto L26;
    L28:
        if (r3 != null) goto L30;
        r3 = new Pair("", "");
    L30:
        String r15 = getHeaderValueIgnoreCase(r2, STORE_SEC_UID_HEADER);
        String r1 = getHeaderValueIgnoreCase(r2, "x-tt-logid");
        String r10 = getHeaderValueIgnoreCase(r2, TNC_ATTR_HEADER);
        String r11 = getHeaderValueIgnoreCase(r2, TNC_ETAG_HEADER);
        String r12 = getHeaderValueIgnoreCase(r2, TNC_CONFIG_HEADER);
        JSONObject r6 = new JSONObject();
        r5 = r18.getURL().getPath();     // Catch: JSONException -> L33
        r6.put("url", r18.getURL().getHost() + r5);     // Catch: JSONException -> L33
        r6.put("store_region", ((String) r3.first) + "," + ((String) r3.second));     // Catch: JSONException -> L33
        r6.put("logId", r1);     // Catch: JSONException -> L33
    L35:
        r20.notifyStoreRegionUpdatedForCronet(r5, (String) r3.first, (String) r3.second, r10, r11, r12, r13, r6.toString(), r15, r1);
        return;
    L33:
        e = move-exception;
        e.printStackTrace();
        goto L35
    L26:
        if (TextUtils.isEmpty(r13) == false) goto L28;
        return;
    L18:
        if (r0.equals("1") == false) goto L23;
        r13 = "{\"data\": " + new JSONObject(new String(r19)).getString("tnc_data") + VectorFormat.DEFAULT_SUFFIX;     // Catch: JSONException -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L13:
        if (r4.isEmpty() == false) goto L15;
        goto L14
    }

    private static String getHeaderValueIgnoreCase(Map<String, List<String>> r4, String r5) {
        if (r4 != null) goto L5;
    L19:
        return "";
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L19;
        Iterator<String> r1 = r4.keySet().iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        String r2 = r1.next();
        if (r5.equalsIgnoreCase(r2) == false) goto L9;
        List<String> r6 = r4.get(r2);
    L14:
        if (r6 == null) goto L19;
        if (r6.size() <= 0) goto L19;
        return r6.get(r6.size() - 1);
    L13:
        r6 = null;
        goto L14
    }

    public JSONObject getStoreIdcInfo() {
        if (this.mStoreRegionRuleEnabled == true) goto L6;
        return null;
    L6:
        JSONObject r0 = new JSONObject();
        r0.put("region", this.mStoreRegion);     // Catch: JSONException -> L9
        r0.put("source", this.mStoreRegionSrc);     // Catch: JSONException -> L9
        r0.put("local_region", this.mStoreRegionLocal);     // Catch: JSONException -> L9
        r0.put("update_region", this.mUpdateRegionInfo);     // Catch: JSONException -> L9
    L11:
        return r0;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public static void useDomesticStoreRegion(boolean r0) {
        mUseDomesticStoreRegion = r0;
    }

    public static boolean isDomesticStoreRegion() {
        return mUseDomesticStoreRegion;
    }
}
