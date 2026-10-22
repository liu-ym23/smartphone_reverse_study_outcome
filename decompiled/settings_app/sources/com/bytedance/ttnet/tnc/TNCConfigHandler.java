package com.bytedance.ttnet.tnc;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.TTDelayStateManager;
import com.bytedance.frameworks.baselib.network.config.InsecureRequestControlConfig;
import com.bytedance.frameworks.baselib.network.config.TTCookieConfig;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.HttpDns;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatcher;
import com.bytedance.frameworks.baselib.network.http.util.BoeUtils;
import com.bytedance.frameworks.baselib.network.http.util.ProcessUtils;
import com.bytedance.frameworks.baselib.network.queryfilter.QueryFilterStateListener;
import com.bytedance.retrofit2.mime.TTRequestCompressManager;
import com.bytedance.ttnet.config.AppConfig;
import com.bytedance.ttnet.config.JsonOptConfig;
import com.bytedance.ttnet.config.TTHttpCallThrottleControl;
import com.bytedance.ttnet.utils.MultiProcessFileUtils;
import java.util.HashMap;
import java.util.Iterator;
import okhttp3.ttnet.TTConfigManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TNCConfigHandler {
    private static final String TAG = "TNCConfigHandler";
    private Context mContext;
    private boolean mIsMainProcess;
    private String mStoreIdc;
    private String mStoreRegion;
    private String mStoreRegionSrc;
    private TNCConfig mTNCConfig;
    private String mTncAbTest;

    public TNCConfigHandler(Context r2, boolean r3) {
        this.mStoreRegion = "";
        this.mStoreIdc = "";
        this.mStoreRegionSrc = "";
        this.mTncAbTest = "";
        this.mContext = r2;
        this.mIsMainProcess = r3;
        this.mTNCConfig = new TNCConfig();
    }

    public boolean handleConfigChanged(Object r18, TNCManager.TNCUpdateSource r19, String r20, String r21, long r22) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "handleConfigChanged");
    L6:
        if (this.mIsMainProcess == false) goto L8;
        JSONObject r5 = JsonOptConfig.tncJSONObject(r18);
        URLDispatcher.inst().onServerConfigChanged(r5, r19.mValue, r20, this.mTncAbTest, r22);
        notifyTncConfigChanged(r5);
        TNCConfig r6 = parseConfigFromJson(r5);     // Catch: Throwable -> L47
        if (Logger.debug() == false) goto L19;
        StringBuilder r7 = new StringBuilder("handleConfigChanged, newConfig: ");     // Catch: Throwable -> L47
        if (r6 != null) goto L17;
        String r8 = "null";
    L18:
        Logger.d(TAG, r7.append(r8).toString());     // Catch: Throwable -> L47
        goto L19
    L17:
        r8 = r6.toString();     // Catch: Throwable -> L47
    L19:
        if (r6 != null) goto L28;
        SharedPreferences.Editor r0 = this.mContext.getSharedPreferences(TNCManager.TNC_SP_NAME, 0).edit();
        r0.putBoolean("is_full_config", false);
        r0.putString(TNCManager.TNC_CONFIG_STR, "").apply();
        MultiProcessFileUtils.saveData(this.mContext, 7, MultiProcessFileUtils.bool2Str(false));
        MultiProcessFileUtils.saveData(this.mContext, 4, "");
        if (TextUtils.isEmpty(r20) == true) goto L24;
        r0.putString(TNCManager.TNC_ETAG_NAME, r20).apply();
        MultiProcessFileUtils.saveData(this.mContext, 5, r20);
    L24:
        if (TextUtils.isEmpty(this.mTncAbTest) == false) goto L26;
        this.mTncAbTest = "";
    L26:
        r0.putString(TNCManager.TNC_ABTEST_NAME, this.mTncAbTest).apply();
        MultiProcessFileUtils.saveData(this.mContext, 6, this.mTncAbTest);
        return false;
    L28:
        String r9 = r20;
        String r10 = TNCManager.TNC_ABTEST_NAME;
        this.mTNCConfig = r6;     // Catch: Throwable -> L45
        if ((r18 instanceof JsonOptConfig.JsonWrapper) == true) goto L74;
        String r1 = r5.toString();     // Catch: Throwable -> L45
        boolean r11 = false;
    L37:
        SharedPreferences.Editor r12 = this.mContext.getSharedPreferences(TNCManager.TNC_SP_NAME, 0).edit();
        r12.putBoolean("is_full_config", r11);
        r12.putString(TNCManager.TNC_CONFIG_STR, r1).apply();
        MultiProcessFileUtils.saveData(this.mContext, 7, MultiProcessFileUtils.bool2Str(r11));
        MultiProcessFileUtils.saveData(this.mContext, 4, r1);
        if (TextUtils.isEmpty(r20) == true) goto L41;
        r12.putString(TNCManager.TNC_ETAG_NAME, r9).apply();
        MultiProcessFileUtils.saveData(this.mContext, 5, r9);
    L41:
        if (TextUtils.isEmpty(this.mTncAbTest) == false) goto L43;
        this.mTncAbTest = "";
    L43:
        r12.putString(r10, this.mTncAbTest).apply();
        MultiProcessFileUtils.saveData(this.mContext, 6, this.mTncAbTest);
        return true;
    L74:
        r1 = ((JsonOptConfig.JsonWrapper) r18).jsonStr();     // Catch: Throwable -> L33
        r11 = true;
    L33:
        th = th;
        boolean r13 = true;
    L72:
        th.printStackTrace();     // Catch: Throwable -> L59
        this.mTNCConfig = new TNCConfig();     // Catch: Throwable -> L59
        SharedPreferences.Editor r2 = this.mContext.getSharedPreferences(TNCManager.TNC_SP_NAME, 0).edit();
        r2.putBoolean("is_full_config", r13);
        r2.putString(TNCManager.TNC_CONFIG_STR, "").apply();
        MultiProcessFileUtils.saveData(this.mContext, 7, MultiProcessFileUtils.bool2Str(r13));
        MultiProcessFileUtils.saveData(this.mContext, 4, "");
        if (TextUtils.isEmpty(r20) == true) goto L55;
        r2.putString(TNCManager.TNC_ETAG_NAME, r9).apply();
        MultiProcessFileUtils.saveData(this.mContext, 5, r9);
    L55:
        if (TextUtils.isEmpty(this.mTncAbTest) == false) goto L57;
        this.mTncAbTest = "";
    L57:
        r2.putString(r10, this.mTncAbTest).apply();
        MultiProcessFileUtils.saveData(this.mContext, 6, this.mTncAbTest);
        return false;
    L59:
        th = move-exception;
        SharedPreferences.Editor r14 = this.mContext.getSharedPreferences(TNCManager.TNC_SP_NAME, 0).edit();
        r14.putBoolean("is_full_config", r13);
        r14.putString(TNCManager.TNC_CONFIG_STR, "").apply();
        MultiProcessFileUtils.saveData(this.mContext, 7, MultiProcessFileUtils.bool2Str(r13));
        MultiProcessFileUtils.saveData(this.mContext, 4, "");
        if (TextUtils.isEmpty(r20) == true) goto L64;
        r14.putString(TNCManager.TNC_ETAG_NAME, r9).apply();
        MultiProcessFileUtils.saveData(this.mContext, 5, r9);
    L64:
        if (TextUtils.isEmpty(this.mTncAbTest) == false) goto L66;
        this.mTncAbTest = "";
    L66:
        r14.putString(r10, this.mTncAbTest).apply();
        MultiProcessFileUtils.saveData(this.mContext, 6, this.mTncAbTest);
        throw th;
    L45:
        th = th;
    L49:
        r13 = false;
    L47:
        th = th;
        r9 = r20;
        r10 = TNCManager.TNC_ABTEST_NAME;
        goto L49
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d(TAG, "handleConfigChanged: no mainProc");
    L10:
        return false;
    }

    private String loadGetDomainDefaultJson() {
        if (TextUtils.isEmpty(TNCManager.getGetDomainDefaultJson()) == false) goto L13;
        Logger.d(TAG, "getGetDomainDefaultJson no existed");
        return null;
    L13:
        String r3 = new JSONObject(TNCManager.getGetDomainDefaultJson()).getString("data");     // Catch: JSONException -> L10
        if (Logger.debug() == false) goto L9;
        Logger.d(TAG, "use get domain default json.");     // Catch: JSONException -> L10
    L9:
        return r3;
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public void loadLocalConfig(long r17) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "load local config");
    L6:
        if (this.mIsMainProcess == true) goto L8;
        return;
    L8:
        boolean r5 = false;
        SharedPreferences r2 = this.mContext.getSharedPreferences(TNCManager.TNC_SP_NAME, 0);
        boolean r4 = r2.getBoolean("is_full_config", false);
        String r6 = r2.getString(TNCManager.TNC_CONFIG_STR, null);
        String r12 = r2.getString(TNCManager.TNC_ETAG_NAME, null);
        String r13 = r2.getString(TNCManager.TNC_ABTEST_NAME, null);
        if (TextUtils.isEmpty(r6) == false) goto L16;
        r6 = loadGetDomainDefaultJson();
        if (TextUtils.isEmpty(r6) == true) goto L13;
    L38:
        JSONObject r3 = new JSONObject(r6);     // Catch: Throwable -> L33
        if (r5 == false) goto L22;
        JSONObject r7 = r3.optJSONObject("data");     // Catch: Throwable -> L33
        if (r7 == null) goto L22;
        r3 = r7;
    L22:
        URLDispatcher.inst().onServerConfigChanged(r3, TNCManager.TNCUpdateSource.TTCACHE.mValue, r12, r13, r17);     // Catch: Throwable -> L33
        notifyTncConfigChanged(r3);     // Catch: Throwable -> L33
        TNCConfig r8 = parseConfigFromJson(r3);     // Catch: Throwable -> L33
        if (r8 == null) goto L26;
        this.mTNCConfig = r8;     // Catch: Throwable -> L33
    L26:
        if (Logger.debug() == false) goto L41;
        StringBuilder r0 = new StringBuilder("loadLocalConfig: ");     // Catch: Throwable -> L33
        if (r8 != null) goto L30;
        String r1 = "null";
    L31:
        Logger.d(TAG, r0.append(r1).toString());     // Catch: Throwable -> L33
        return;
    L30:
        r1 = r8.toString();     // Catch: Throwable -> L33
        goto L31
    L41:
        return;
    L33:
        th = move-exception;
        th.printStackTrace();
        if (Logger.debug() == false) goto L42;
        Logger.d(TAG, "loadLocalConfig: except: " + th.getMessage());
        return;
    L42:
        return;
    L13:
        if (Logger.debug() == false) goto L40;
        Logger.d(TAG, "load local config failed.");
        return;
    L40:
        return;
    L16:
        r5 = r4;
        goto L38
    }

    public void loadLocalConfigForOtherProcess(long r12) {
        boolean r2 = MultiProcessFileUtils.str2Bool(MultiProcessFileUtils.getData(this.mContext, 7));     // Catch: Throwable -> L27
        String r3 = MultiProcessFileUtils.getData(this.mContext, 4);     // Catch: Throwable -> L27
        if (TextUtils.isEmpty(r3) == false) goto L12;
        r3 = loadGetDomainDefaultJson();     // Catch: Throwable -> L27
        if (TextUtils.isEmpty(r3) == true) goto L8;
        r2 = false;
        goto L12
    L8:
        if (Logger.debug() == false) goto L33;
        Logger.d(TAG, "load local config failed.");     // Catch: Throwable -> L27
        return;
    L33:
        return;
    L12:
        JSONObject r4 = new JSONObject(r3);     // Catch: Throwable -> L27
        if (r2 == false) goto L17;
        JSONObject r5 = r4.optJSONObject("data");     // Catch: Throwable -> L27
        if (r5 == null) goto L17;
        r4 = r5;
    L17:
        JSONObject r9 = r4;
        TNCConfig r10 = parseConfigFromJson(r9);     // Catch: Throwable -> L27
        URLDispatcher.inst().onServerConfigChanged(r9, TNCManager.TNCUpdateSource.TTCACHE.mValue, MultiProcessFileUtils.getData(this.mContext, 5), MultiProcessFileUtils.getData(this.mContext, 6), r12);     // Catch: Throwable -> L27
        notifyTncConfigChanged(r9);     // Catch: Throwable -> L27
        if (Logger.debug() == false) goto L24;
        StringBuilder r13 = new StringBuilder("loadLocalConfigForOtherProcess, config: ");     // Catch: Throwable -> L27
        if (r10 != null) goto L22;
        String r14 = "null";
    L23:
        Logger.d(TAG, r13.append(r14).toString());     // Catch: Throwable -> L27
        goto L24
    L22:
        r14 = r10.toString();     // Catch: Throwable -> L27
    L24:
        if (r10 == null) goto L34;
        this.mTNCConfig = r10;     // Catch: Throwable -> L27
        return;
    L34:
        return;
    L27:
        th = move-exception;
        if (Logger.debug() == false) goto L35;
        Logger.d(TAG, "loadLocalConfigForOtherProcess, except: " + th.getMessage());
        return;
    }

    public TNCConfig getTNCConfig() {
        return this.mTNCConfig;
    }

    private TNCConfig parseConfigFromJson(JSONObject r9) {
        URLDispatcher.inst().getHostReplaceMap().clear();     // Catch: Throwable -> L48
        JSONObject r10 = r9.optJSONObject(MultiProcessFileUtils.KEY_TNC_CONFIG);     // Catch: Throwable -> L48
        TNCConfig r4 = new TNCConfig();     // Catch: Throwable -> L48
        if (r10 != null) goto L6;
        return r4;
    L6:
        boolean r6 = true;
        if (r10.has("local_enable") == false) goto L14;
        if (r10.getInt("local_enable") != 0) goto L11;
        boolean r2 = false;
    L12:
        r4.localEnable = r2;     // Catch: Throwable -> L48
        goto L14
    L11:
        r2 = true;
    L14:
        if (r10.has("probe_enable") == false) goto L20;
        if (r10.getInt("probe_enable") != 0) goto L18;
        r6 = false;
    L18:
        r4.probeEnable = r6;     // Catch: Throwable -> L48
    L20:
        if (r10.has("local_host_filter") == false) goto L32;
        JSONArray r0 = r10.getJSONArray("local_host_filter");     // Catch: Throwable -> L48
        HashMap r1 = new HashMap();     // Catch: Throwable -> L48
        if (r0.length() <= 0) goto L31;
        int r3 = 0;
    L25:
        if (r3 >= r0.length()) goto L31;
        String r5 = r0.getString(r3);     // Catch: Throwable -> L48
        if (TextUtils.isEmpty(r5) == true) goto L30;
        r1.put(r5, 0);     // Catch: Throwable -> L48
    L30:
        r3 = r3 + 1;     // Catch: Throwable -> L48
    L31:
        r4.localHostFilterList = r1;     // Catch: Throwable -> L48
    L34:
        if (r10.has("host_replace_map") == false) goto L46;
        JSONObject r8 = r10.getJSONObject("host_replace_map");     // Catch: Throwable -> L48
        if (r8.length() <= 0) goto L46;
        Iterator<String> r7 = r8.keys();     // Catch: Throwable -> L48
    L39:
        if (r7.hasNext() == false) goto L46;
        String r11 = r7.next();     // Catch: Throwable -> L48
        String r12 = r8.getString(r11);     // Catch: Throwable -> L48
        if (TextUtils.isEmpty(r11) == true) goto L39;
        if (TextUtils.isEmpty(r12) == true) goto L39;
        URLDispatcher.inst().getHostReplaceMap().put(r11, r12);     // Catch: Throwable -> L48
    L46:
        r4.reqToCnt = r10.optInt("req_to_cnt", r4.reqToCnt);     // Catch: Throwable -> L48
        r4.reqToApiCnt = r10.optInt("req_to_api_cnt", r4.reqToApiCnt);     // Catch: Throwable -> L48
        r4.reqToIpCnt = r10.optInt("req_to_ip_cnt", r4.reqToIpCnt);     // Catch: Throwable -> L48
        r4.reqErrCnt = r10.optInt("req_err_cnt", r4.reqErrCnt);     // Catch: Throwable -> L48
        r4.reqErrApiCnt = r10.optInt("req_err_api_cnt", r4.reqErrApiCnt);     // Catch: Throwable -> L48
        r4.reqErrIpCnt = r10.optInt("req_err_ip_cnt", r4.reqErrIpCnt);     // Catch: Throwable -> L48
        r4.updateInterval = r10.optInt("update_interval", r4.updateInterval);     // Catch: Throwable -> L48
        r4.updateRandomRange = r10.optInt("update_random_range", r4.updateRandomRange);     // Catch: Throwable -> L48
        r4.httpCodeBlack = r10.optString("http_code_black", r4.httpCodeBlack);     // Catch: Throwable -> L48
        return r4;
    L32:
        r4.localHostFilterList = null;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    private void notifyTncConfigChanged(JSONObject r2) {
        if (AppConfig.getInstance(this.mContext).isChromiumOpen() == true) goto L6;
        HttpDns.getService().onServerConfigChanged(r2);
        TTConfigManager.inst().onServerConfigChanged(r2);
    L6:
        if (ProcessUtils.isMainProcessByProcessFlag(this.mContext) == false) goto L8;
        TTHttpCallThrottleControl.getInstance().onServerConfigChangedFromTNCHandler(r2);
    L8:
        TTDelayStateManager.onServerConfigChanged(r2);
        QueryFilterStateListener.getInstance().onServerConfigChanged(r2);
        TTRequestCompressManager.onServerConfigChanged(r2);
        BoeUtils.onServerConfigChanged(r2);
        InsecureRequestControlConfig.onServerConfigChanged(r2);
        TTCookieConfig.onServerConfigChanged(r2);
    }

    public void setTncAbTest(String r1) {
        this.mTncAbTest = r1;
        URLDispatcher.inst().setTncAbTest(r1);
    }

    public String getRegion() {
        return this.mStoreRegion;
    }

    public String getRegionSrc() {
        return this.mStoreRegionSrc;
    }
}
