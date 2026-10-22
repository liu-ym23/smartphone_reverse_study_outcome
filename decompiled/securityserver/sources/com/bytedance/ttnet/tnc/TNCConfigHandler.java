package com.bytedance.ttnet.tnc;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.TTDelayStateManager;
import com.bytedance.frameworks.baselib.network.config.InsecureRequestControlConfig;
import com.bytedance.frameworks.baselib.network.config.TTCookieConfig;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.HttpDns;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.metadispatch.TTMetaDispatchManager;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatcher;
import com.bytedance.frameworks.baselib.network.http.parser.RequestTimeoutParser;
import com.bytedance.frameworks.baselib.network.http.util.BoeUtils;
import com.bytedance.frameworks.baselib.network.http.util.ProcessUtils;
import com.bytedance.frameworks.baselib.network.queryfilter.QueryFilterStateListener;
import com.bytedance.retrofit2.mime.TTRequestCompressManager;
import com.bytedance.ttnet.TNCRequestFlagHandler;
import com.bytedance.ttnet.config.AppConfig;
import com.bytedance.ttnet.config.ExperimentalSwitches;
import com.bytedance.ttnet.config.JsonOptConfig;
import com.bytedance.ttnet.config.TTHttpCallThrottleControl;
import com.bytedance.ttnet.priority.TTHttpCallPriorityControl;
import com.bytedance.ttnet.utils.MultiProcessFileUtils;
import java.util.HashMap;
import java.util.Iterator;
import okhttp3.ttnet.TTConfigManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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

    private String loadGetDomainDefaultJson() {
        if (TextUtils.isEmpty(TNCManager.getGetDomainDefaultJson()) == false) goto L15;
        Logger.d(TAG, "getGetDomainDefaultJson no existed");
        return null;
    L15:
        String r3 = new JSONObject(TNCManager.getGetDomainDefaultJson()).getString("data");     // Catch: JSONException -> L10
        if (Logger.debug() == false) goto L12;
        Logger.d(TAG, "use get domain default json.");     // Catch: JSONException -> L10
    L12:
        return r3;
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private void notifyTncConfigChanged(JSONObject r2) {
        if (AppConfig.getInstance(this.mContext).isChromiumOpen() == true) goto L6;
        HttpDns.getService().onServerConfigChanged(r2);
        TTConfigManager.inst().onServerConfigChanged(r2);
    L6:
        if (ProcessUtils.isMainProcessByProcessFlag(this.mContext) == false) goto L8;
        ExperimentalSwitches.onServerConfigChanged(r2);
        TTHttpCallThrottleControl.getInstance().onServerConfigChangedFromTNCHandler(r2);
        TTHttpCallPriorityControl.getInstance().onServerConfigChangedFromTNCHandler(r2);
    L8:
        TNCRequestFlagHandler.getInstance().parseJson2Config(r2);
        RequestTimeoutParser.onServerConfigChanged(r2);
        TTDelayStateManager.onServerConfigChanged(r2);
        QueryFilterStateListener.getInstance().onServerConfigChanged(r2);
        TTRequestCompressManager.onServerConfigChanged(r2);
        BoeUtils.onServerConfigChanged(r2);
        InsecureRequestControlConfig.onServerConfigChanged(r2);
        TTCookieConfig.onServerConfigChanged(r2);
        TTMetaDispatchManager.onServerConfigChanged(r2);
    }

    private TNCConfig parseConfigFromJson(JSONObject r9) {
        URLDispatcher.inst().getHostReplaceMap().clear();     // Catch: Throwable -> L13
        JSONObject r10 = r9.optJSONObject(MultiProcessFileUtils.KEY_TNC_CONFIG);     // Catch: Throwable -> L13
        TNCConfig r4 = new TNCConfig();     // Catch: Throwable -> L13
        if (r10 != null) goto L6;
        return r4;
    L6:
        boolean r6 = true;
        if (r10.has("local_enable") == false) goto L16;
        if (r10.getInt("local_enable") != 0) goto L11;
        boolean r2 = false;
    L12:
        r4.localEnable = r2;     // Catch: Throwable -> L13
        goto L16
    L11:
        r2 = true;
    L16:
        if (r10.has("probe_enable") == false) goto L22;
        if (r10.getInt("probe_enable") != 0) goto L20;
        r6 = false;
    L20:
        r4.probeEnable = r6;     // Catch: Throwable -> L13
    L22:
        if (r10.has("local_host_filter") == false) goto L34;
        JSONArray r0 = r10.getJSONArray("local_host_filter");     // Catch: Throwable -> L13
        HashMap r1 = new HashMap();     // Catch: Throwable -> L13
        if (r0.length() <= 0) goto L33;
        int r3 = 0;
    L27:
        if (r3 >= r0.length()) goto L33;
        String r5 = r0.getString(r3);     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r5) == true) goto L32;
        r1.put(r5, 0);     // Catch: Throwable -> L13
    L32:
        r3 = r3 + 1;     // Catch: Throwable -> L13
    L33:
        r4.localHostFilterList = r1;     // Catch: Throwable -> L13
    L36:
        if (r10.has("host_replace_map") == false) goto L48;
        JSONObject r8 = r10.getJSONObject("host_replace_map");     // Catch: Throwable -> L13
        if (r8.length() <= 0) goto L48;
        Iterator<String> r7 = r8.keys();     // Catch: Throwable -> L13
    L41:
        if (r7.hasNext() == false) goto L48;
        String r11 = r7.next();     // Catch: Throwable -> L13
        String r12 = r8.getString(r11);     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r11) == true) goto L41;
        if (TextUtils.isEmpty(r12) == true) goto L41;
        URLDispatcher.inst().getHostReplaceMap().put(r11, r12);     // Catch: Throwable -> L13
    L48:
        r4.reqToCnt = r10.optInt("req_to_cnt", r4.reqToCnt);     // Catch: Throwable -> L13
        r4.reqToApiCnt = r10.optInt("req_to_api_cnt", r4.reqToApiCnt);     // Catch: Throwable -> L13
        r4.reqToIpCnt = r10.optInt("req_to_ip_cnt", r4.reqToIpCnt);     // Catch: Throwable -> L13
        r4.reqErrCnt = r10.optInt("req_err_cnt", r4.reqErrCnt);     // Catch: Throwable -> L13
        r4.reqErrApiCnt = r10.optInt("req_err_api_cnt", r4.reqErrApiCnt);     // Catch: Throwable -> L13
        r4.reqErrIpCnt = r10.optInt("req_err_ip_cnt", r4.reqErrIpCnt);     // Catch: Throwable -> L13
        r4.updateInterval = r10.optInt("update_interval", r4.updateInterval);     // Catch: Throwable -> L13
        r4.updateRandomRange = r10.optInt("update_random_range", r4.updateRandomRange);     // Catch: Throwable -> L13
        r4.httpCodeBlack = r10.optString("http_code_black", r4.httpCodeBlack);     // Catch: Throwable -> L13
        return r4;
    L34:
        r4.localHostFilterList = null;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public String getRegion() {
        return this.mStoreRegion;
    }

    public String getRegionSrc() {
        return this.mStoreRegionSrc;
    }

    public TNCConfig getTNCConfig() {
        return this.mTNCConfig;
    }

    public boolean handleConfigChanged(Object r18, TNCManager.TNCUpdateSource r19, String r20, String r21, long r22) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "handleConfigChanged");
    L6:
        if (this.mIsMainProcess == false) goto L8;
        JSONObject r5 = JsonOptConfig.tncJSONObject(r18);
        URLDispatcher.inst().onServerConfigChanged(r5, r19.mValue, r20, this.mTncAbTest, r22);
        notifyTncConfigChanged(r5);
        TNCConfig r6 = parseConfigFromJson(r5);     // Catch: Throwable -> L17
        if (Logger.debug() == false) goto L22;
        StringBuilder r7 = new StringBuilder("handleConfigChanged, newConfig: ");     // Catch: Throwable -> L17
        if (r6 != null) goto L20;
        String r8 = "null";
    L21:
        r7.append(r8);     // Catch: Throwable -> L17
        Logger.d(TAG, r7.toString());     // Catch: Throwable -> L17
        goto L22
    L20:
        r8 = r6.toString();     // Catch: Throwable -> L17
    L22:
        if (r6 != null) goto L31;
        SharedPreferences.Editor r0 = this.mContext.getSharedPreferences(TNCManager.TNC_SP_NAME, 0).edit();
        r0.putBoolean("is_full_config", false);
        r0.putString(TNCManager.TNC_CONFIG_STR, "").apply();
        MultiProcessFileUtils.saveData(this.mContext, 7, MultiProcessFileUtils.bool2Str(false));
        MultiProcessFileUtils.saveData(this.mContext, 4, "");
        if (TextUtils.isEmpty(r20) == true) goto L27;
        r0.putString(TNCManager.TNC_ETAG_NAME, r20).apply();
        MultiProcessFileUtils.saveData(this.mContext, 5, r20);
    L27:
        if (TextUtils.isEmpty(this.mTncAbTest) == false) goto L29;
        this.mTncAbTest = "";
    L29:
        r0.putString(TNCManager.TNC_ABTEST_NAME, this.mTncAbTest).apply();
        MultiProcessFileUtils.saveData(this.mContext, 6, this.mTncAbTest);
        return false;
    L31:
        String r9 = r20;
        String r10 = TNCManager.TNC_ABTEST_NAME;
        this.mTNCConfig = r6;     // Catch: Throwable -> L48
        if ((r18 instanceof JsonOptConfig.JsonWrapper) == true) goto L74;
        String r1 = r5.toString();     // Catch: Throwable -> L48
        boolean r11 = false;
    L40:
        SharedPreferences.Editor r12 = this.mContext.getSharedPreferences(TNCManager.TNC_SP_NAME, 0).edit();
        r12.putBoolean("is_full_config", r11);
        r12.putString(TNCManager.TNC_CONFIG_STR, r1).apply();
        MultiProcessFileUtils.saveData(this.mContext, 7, MultiProcessFileUtils.bool2Str(r11));
        MultiProcessFileUtils.saveData(this.mContext, 4, r1);
        if (TextUtils.isEmpty(r20) == true) goto L44;
        r12.putString(TNCManager.TNC_ETAG_NAME, r9).apply();
        MultiProcessFileUtils.saveData(this.mContext, 5, r9);
    L44:
        if (TextUtils.isEmpty(this.mTncAbTest) == false) goto L46;
        this.mTncAbTest = "";
    L46:
        r12.putString(r10, this.mTncAbTest).apply();
        MultiProcessFileUtils.saveData(this.mContext, 6, this.mTncAbTest);
        return true;
    L74:
        r1 = ((JsonOptConfig.JsonWrapper) r18).jsonStr();     // Catch: Throwable -> L36
        r11 = true;
    L36:
        th = th;
        boolean r13 = true;
    L68:
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
    L48:
        th = th;
    L19:
        r13 = false;
    L17:
        th = th;
        r9 = r20;
        r10 = TNCManager.TNC_ABTEST_NAME;
        goto L19
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d(TAG, "handleConfigChanged: no mainProc");
    L10:
        return false;
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
    L39:
        JSONObject r3 = new JSONObject(r6);     // Catch: Throwable -> L22
        if (r5 == false) goto L24;
        JSONObject r7 = r3.optJSONObject("data");     // Catch: Throwable -> L22
        if (r7 == null) goto L24;
        r3 = r7;
    L24:
        URLDispatcher.inst().onServerConfigChanged(r3, TNCManager.TNCUpdateSource.TTCACHE.mValue, r12, r13, r17);     // Catch: Throwable -> L22
        notifyTncConfigChanged(r3);     // Catch: Throwable -> L22
        TNCConfig r8 = parseConfigFromJson(r3);     // Catch: Throwable -> L22
        if (r8 == null) goto L28;
        this.mTNCConfig = r8;     // Catch: Throwable -> L22
    L28:
        if (Logger.debug() == false) goto L42;
        StringBuilder r0 = new StringBuilder("loadLocalConfig: ");     // Catch: Throwable -> L22
        if (r8 != null) goto L32;
        String r1 = "null";
    L33:
        r0.append(r1);     // Catch: Throwable -> L22
        Logger.d(TAG, r0.toString());     // Catch: Throwable -> L22
        return;
    L32:
        r1 = r8.toString();     // Catch: Throwable -> L22
        goto L33
    L42:
        return;
    L22:
        th = move-exception;
        th.printStackTrace();
        if (Logger.debug() == false) goto L43;
        Logger.d(TAG, "loadLocalConfig: except: " + th.getMessage());
        return;
    L43:
        return;
    L13:
        if (Logger.debug() == false) goto L41;
        Logger.d(TAG, "load local config failed.");
        return;
    L41:
        return;
    L16:
        r5 = r4;
        goto L39
    }

    public void loadLocalConfigForOtherProcess(long r12) {
        boolean r2 = MultiProcessFileUtils.str2Bool(MultiProcessFileUtils.getData(this.mContext, 7));     // Catch: Throwable -> L10
        String r3 = MultiProcessFileUtils.getData(this.mContext, 4);     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(r3) == false) goto L14;
        r3 = loadGetDomainDefaultJson();     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(r3) == true) goto L8;
        r2 = false;
        goto L14
    L8:
        if (Logger.debug() == false) goto L12;
        Logger.d(TAG, "load local config failed.");     // Catch: Throwable -> L10
        return;
    L12:
        return;
    L14:
        JSONObject r4 = new JSONObject(r3);     // Catch: Throwable -> L10
        if (r2 == false) goto L19;
        JSONObject r5 = r4.optJSONObject("data");     // Catch: Throwable -> L10
        if (r5 == null) goto L19;
        r4 = r5;
    L19:
        JSONObject r9 = r4;
        TNCConfig r10 = parseConfigFromJson(r9);     // Catch: Throwable -> L10
        URLDispatcher.inst().onServerConfigChanged(r9, TNCManager.TNCUpdateSource.TTCACHE.mValue, MultiProcessFileUtils.getData(this.mContext, 5), MultiProcessFileUtils.getData(this.mContext, 6), r12);     // Catch: Throwable -> L10
        notifyTncConfigChanged(r9);     // Catch: Throwable -> L10
        if (Logger.debug() == false) goto L26;
        StringBuilder r13 = new StringBuilder("loadLocalConfigForOtherProcess, config: ");     // Catch: Throwable -> L10
        if (r10 != null) goto L24;
        String r14 = "null";
    L25:
        r13.append(r14);     // Catch: Throwable -> L10
        Logger.d(TAG, r13.toString());     // Catch: Throwable -> L10
        goto L26
    L24:
        r14 = r10.toString();     // Catch: Throwable -> L10
    L26:
        if (r10 == null) goto L35;
        this.mTNCConfig = r10;     // Catch: Throwable -> L10
        return;
    L35:
        return;
    L10:
        th = move-exception;
        if (Logger.debug() == false) goto L36;
        Logger.d(TAG, "loadLocalConfigForOtherProcess, except: " + th.getMessage());
        return;
    }

    public void setTncAbTest(String r1) {
        this.mTncAbTest = r1;
        URLDispatcher.inst().setTncAbTest(r1);
    }
}
