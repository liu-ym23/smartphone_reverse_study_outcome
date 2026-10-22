package com.bytedance.ttnet.clientkey;

import android.os.SystemClock;
import android.text.TextUtils;
import com.android.settings.applications.PreferredSettingsUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.URIUtils;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.keva.Keva;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.ttnet.TTReportAllLog;
import com.bytedance.ttnet.config.JsonOptConfig;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import obric.time.HttpHeadTimeFetcher;
import org.apache.commons.math3.geometry.VectorFormat;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ClientKeyManager {
    private static final String CLIENT_KEY_CONFIG_FILE_NAME = "ttnet_client_key_config";
    private static final String CLIENT_KEY_CONFIG_NAME = "client_key_config";
    private static final String CLIENT_KEY_NAME = "client_key";
    private static final String CLIENT_KEY_REQUEST_HEADER_NAME = "x-bd-client-key";
    private static final String CLIENT_KEY_RESPONSE_HEADER_NAME = "x-bd-lanusk";
    private static final String HEADER_SPLIT_STRING = "\r\n";
    private static final String KMS_VERSION_NAME = "kms_version";
    private static final String KMS_VERSION_REQUEST_HEADER_NAME = "x-bd-kmsv";
    private static final String KMS_VERSION_RESPONSE_HEADER_NAME = "x-bd-lanusv";
    private static final String MAX_AGE_NAME = "Max-Age=";
    private static final int RESPONSE_CLIENT_KEY_DEFAULT = 0;
    private static final int RESPONSE_CLIENT_KEY_INVALID = 1;
    private static final int RESPONSE_CLIENT_KEY_NULL = 3;
    private static final int RESPONSE_CLIENT_KEY_SAME_NULL = 2;
    private static final String SESSION_ID_NAME = "session_id";
    private static final String SESSION_TIME_NAME = "session_time";
    private static final String SESSION_URL_NAME = "session_url";
    private static final String TAG = "ClientKeyManager";
    private static volatile boolean mClientKeySignEnabled = false;
    private static Keva mKevaStorage = null;
    private static Map<String, String> sClientKeyHeaders = null;
    private static volatile ClientKeyManager sInstance = null;
    private static boolean sIsMainProcess = true;
    private String mClientKey;
    private String mKmsVersion;
    private String mSessionId;
    private String mSessionUrl;
    private List<String> mUpdateHostList;
    private List<String> mUpdatePathList;

    static {
    }

    public static ClientKeyManager inst() {
        if (sInstance != null) goto L15;
        monitor-enter(ClientKeyManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new ClientKeyManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ClientKeyManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private ClientKeyManager() {
        this.mUpdateHostList = new CopyOnWriteArrayList();
        this.mUpdatePathList = new CopyOnWriteArrayList();
        this.mClientKey = "";
        this.mSessionId = "";
        this.mSessionUrl = "";
        this.mKmsVersion = "";
    }

    public void InitClientKeyAndSessionInfo(boolean r7) {
        sIsMainProcess = r7;
        mKevaStorage = Keva.getRepo(CLIENT_KEY_CONFIG_FILE_NAME, 1);     // Catch: Throwable -> L5
    L7:
        Keva r8 = mKevaStorage;
        if (r8 != null) goto L10;
        return;
    L10:
        String r9 = r8.getString(CLIENT_KEY_CONFIG_NAME, "");
        if (TextUtils.isEmpty(r9) == true) goto L14;
        ParseClientKeyConfig(new JSONObject(r9));     // Catch: Throwable -> L37
    L14:
        if (mClientKeySignEnabled == true) goto L16;
        return;
    L16:
        String r0 = mKevaStorage.getString("session_id", "");
        long r2 = mKevaStorage.getLong(SESSION_TIME_NAME, 0);
        this.mSessionUrl = mKevaStorage.getString(SESSION_URL_NAME, "");
        this.mClientKey = mKevaStorage.getString(CLIENT_KEY_NAME, "");
        String r1 = mKevaStorage.getString(KMS_VERSION_NAME, "");
        this.mKmsVersion = r1;
        sClientKeyHeaders = constructClientKeyHeaders(this.mClientKey, r1);
        if (r0.isEmpty() == false) goto L19;
        return;
    L19:
        if (this.mSessionUrl.isEmpty() == true) goto L43;
        String[] r3 = r0.split(";");
        if (r3 == null) goto L27;
        if (r3.length <= 0) goto L27;
        this.mSessionId = r3[0].trim();
    L27:
        if (TextUtils.isEmpty(this.mSessionId) == false) goto L29;
        return;
    L29:
        String r4 = ReplaceMaxAgeTime(r3, r2, r0);
        if (TextUtils.isEmpty(r4) == true) goto L33;
        r0 = r4;
    L33:
        if (Logger.debug() == false) goto L35;
        Logger.d(TAG, "client key: " + this.mClientKey + " | kms version: " + this.mKmsVersion + " | session cookie: " + r0 + " | sessionid: " + this.mSessionId + " | session time: " + r2 + " session url: " + this.mSessionUrl + " config: " + r9);
    L35:
        UpdateCookieInfo(r0);
        return;
    L43:
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    private static String ReplaceMaxAgeTime(String[] r10, long r11, String r13) {
        if (r10 != null) goto L5;
    L33:
        return null;
    L5:
        if (r10.length < 2) goto L33;
        long r3 = 0;
        if (r11 <= 0) goto L33;
        int r1 = r10.length;
        int r5 = 0;
    L11:
        if (r5 >= r1) goto L18;
        String r7 = r10[r5];
        if (TextUtils.isEmpty(r7) == true) goto L17;
        if (r7.toLowerCase().trim().startsWith(MAX_AGE_NAME.toLowerCase()) == false) goto L17;
        String[] r12 = r7.split("=");
    L19:
        if (r12 == null) goto L33;
        if (r12.length != 2) goto L33;
        long r2 = Long.parseLong(r12[1]);     // Catch: Throwable -> L34
        if (r2 > 0) goto L27;
        return null;
    L27:
        long r4 = r2 - ((System.currentTimeMillis() - r11) / 1000);     // Catch: Throwable -> L34
        if (r4 <= 0) goto L31;
        r3 = r4;
    L31:
        return r13.replaceFirst(r7.trim(), MAX_AGE_NAME + r3);
    L17:
        r5 = r5 + 1;
        goto L11
    L18:
        r12 = null;
        r7 = null;
        goto L19
    }

    private void UpdateCookieInfo(String r7) {
        CookieHandler r2 = CookieHandler.getDefault();
        if (r2 != null) goto L25;
        return;
    L25:
        URI r3 = URIUtils.safeCreateUri(this.mSessionUrl);     // Catch: Throwable -> L24
        if (r3 != null) goto L8;
        return;
    L8:
        Map<String, List<String>> r4 = r2.get(r3, null);     // Catch: Throwable -> L24
        if (r4 != null) goto L11;
        return;
    L11:
        if (r4.isEmpty() == false) goto L13;
        return;
    L13:
        if (r4.containsKey("Cookie") == false) goto L28;
        String r0 = r4.get("Cookie").toString();     // Catch: Throwable -> L24
        if (Logger.debug() == false) goto L18;
        Logger.d(TAG, "cookieStr: " + r0 + " sessionId: " + this.mSessionId);     // Catch: Throwable -> L24
    L18:
        if (TextUtils.isEmpty(r0) == false) goto L20;
        refreshSessionCookie(r7, r2, r3);     // Catch: Throwable -> L24
        SendCookieMismatchLog(PreferredSettingsUtils.INTENT_EXTRA_EMPTY);     // Catch: Throwable -> L24
        return;
    L20:
        if (r0.contains(this.mSessionId) == true) goto L29;
        refreshSessionCookie(r7, r2, r3);     // Catch: Throwable -> L24
        SendCookieMismatchLog(r0);     // Catch: Throwable -> L24
        return;
    L29:
        return;
    L28:
        return;
    }

    private void refreshSessionCookie(String r3, CookieHandler r4, URI r5) throws IOException {
        LinkedHashMap r2 = new LinkedHashMap();
        ArrayList r0 = new ArrayList();
        r0.add(r3);
        r2.put("Set-Cookie", r0);
        r4.put(r5, r2);
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "Refresh session cookie: " + r3);
        return;
    }

    private void SendCookieMismatchLog(String r6) {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L4
        r0.put("report_time", System.currentTimeMillis() + "");     // Catch: Throwable -> L4
        r0.put("cookie_line", r6);     // Catch: Throwable -> L4
        r0.put("session_id", this.mSessionId);     // Catch: Throwable -> L4
        r0.put("url", this.mSessionUrl);     // Catch: Throwable -> L4
        TTReportAllLog.reportInternalAllLog("cookie_mismatch", r0);     // Catch: Throwable -> L4
        return;
    }

    public void AddClientKeyHeader(List<Header> r5, RetrofitMetrics r6) {
        if (mKevaStorage != null) goto L5;
        return;
    L5:
        if (mClientKeySignEnabled == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(this.mClientKey) == false) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(this.mKmsVersion) == true) goto L19;
        Long r0 = Long.valueOf(SystemClock.uptimeMillis());
        r5.add(new Header(CLIENT_KEY_REQUEST_HEADER_NAME, this.mClientKey));
        r5.add(new Header(KMS_VERSION_REQUEST_HEADER_NAME, this.mKmsVersion));
        if (r6 == null) goto L18;
        r6.addClientKeyDuration = SystemClock.uptimeMillis() - r0.longValue();
        return;
    L18:
        return;
    }

    public synchronized void UpdateClientKeyAndSessionInfo(Request r18, Response r19) {
        monitor-enter(this);
    L98:
        th = move-exception;
        throw th;
    L5:
        if (mKevaStorage != null) goto L7;
    L96:
        monitor-exit(this);
        return;
    L7:
        if (mClientKeySignEnabled == false) goto L96;
        Long r12 = Long.valueOf(SystemClock.uptimeMillis());     // Catch: Throwable -> L98
        URI r1 = URIUtils.safeCreateUri(r18.getUrl());     // Catch: Throwable -> L12
    L13:
        if (r1 != null) goto L15;
    L94:
        monitor-exit(this);
        return;
    L15:
        if (r1.getScheme().equals(HttpHeadTimeFetcher.FETCHER_TYPE) == false) goto L94;
        int r3 = 1;
        if (this.mUpdateHostList.isEmpty() == true) goto L30;
        Iterator<String> r2 = this.mUpdateHostList.iterator();     // Catch: Throwable -> L98
    L21:
        if (r2.hasNext() == false) goto L25;
        if (UrlUtils.matchPattern(r1.getHost(), r2.next()) == false) goto L21;
        boolean r4 = true;
    L26:
        if (r4 == true) goto L30;
        monitor-exit(this);
        return;
    L25:
        r4 = false;
    L30:
        if (this.mUpdatePathList.isEmpty() == true) goto L37;
        Iterator<String> r5 = this.mUpdatePathList.iterator();     // Catch: Throwable -> L98
    L33:
        if (r5.hasNext() == false) goto L37;
        if (UrlUtils.matchPattern(r1.getPath(), r5.next()) == false) goto L33;
        boolean r6 = true;
    L38:
        if (r6 == true) goto L41;
        monitor-exit(this);
        return;
    L41:
        String r7 = "";
        List<Header> r8 = r19.headers("Set-Cookie");     // Catch: Throwable -> L98
        if (r8 != null) goto L44;
    L51:
        String r13 = "";
    L52:
        String[] r9 = r13.split(";");     // Catch: Throwable -> L98
        if (r9 != null) goto L55;
    L57:
        String r14 = r7;
        if (TextUtils.isEmpty(r14) == false) goto L62;
        monitor-exit(this);
        return;
    L62:
        if (Logger.debug() == false) goto L64;
        Logger.d(TAG, "original sessionid: " + this.mSessionId + " new sessionid: " + r14);     // Catch: Throwable -> L98
    L64:
        String r10 = "";
        String r11 = "";
        Header r15 = r19.getFirstHeader(CLIENT_KEY_RESPONSE_HEADER_NAME);     // Catch: Throwable -> L98
        Header r16 = r19.getFirstHeader(KMS_VERSION_RESPONSE_HEADER_NAME);     // Catch: Throwable -> L98
        if (r15 == null) goto L75;
        if (r16 == null) goto L75;
        String r17 = r15.getValue();     // Catch: Throwable -> L98
        r11 = r16.getValue();     // Catch: Throwable -> L98
        if (TextUtils.isEmpty(r17) == false) goto L70;
    L73:
        r10 = "";
        r11 = "";
    L79:
        String r110 = r10;
        int r20 = r3;
    L80:
        String r111 = r11;
        String r0 = r111;
        reportClientKeyLog(r20, this.mSessionId, r14, this.mClientKey, r110, this.mKmsVersion, r111, r19, r1.getPath());     // Catch: Throwable -> L101
    L86:
        this.mClientKey = r110;     // Catch: Throwable -> L98
        this.mKmsVersion = r0;     // Catch: Throwable -> L98
        String r21 = r18.getUrl();     // Catch: Throwable -> L98
        this.mSessionUrl = r21;     // Catch: Throwable -> L98
        this.mSessionId = r14;     // Catch: Throwable -> L98
        mKevaStorage.storeString(SESSION_URL_NAME, r21);     // Catch: Throwable -> L98
        mKevaStorage.storeString("session_id", r13);     // Catch: Throwable -> L98
        mKevaStorage.storeString(CLIENT_KEY_NAME, this.mClientKey);     // Catch: Throwable -> L98
        mKevaStorage.storeString(KMS_VERSION_NAME, this.mKmsVersion);     // Catch: Throwable -> L98
        mKevaStorage.storeLong(SESSION_TIME_NAME, System.currentTimeMillis());     // Catch: Throwable -> L98
        sClientKeyHeaders = constructClientKeyHeaders(this.mClientKey, this.mKmsVersion);     // Catch: Throwable -> L98
        if (r18.getMetrics() == null) goto L90;
        r18.getMetrics().updateClientKeyDuration = SystemClock.uptimeMillis() - r12.longValue();     // Catch: Throwable -> L98
    L90:
        if (Logger.debug() == false) goto L92;
        Logger.d(TAG, "save session url: " + this.mSessionUrl + " session cookie: " + r13 + " client key: " + this.mClientKey + " kms version: " + this.mKmsVersion);     // Catch: Throwable -> L98
    L92:
        monitor-exit(this);
        return;
    L85:
        r0 = r111;
        goto L86
    L70:
        if (TextUtils.isEmpty(r11) == true) goto L73;
        r110 = r17;
        r20 = 0;
    L75:
        if (r14.equals(this.mSessionId) == false) goto L78;
        r10 = this.mClientKey;     // Catch: Throwable -> L98
        r11 = this.mKmsVersion;     // Catch: Throwable -> L98
        r3 = 2;
        goto L79
    L78:
        r3 = 3;
        goto L79
    L55:
        if (r9.length <= 0) goto L57;
        r7 = r9[0].trim();     // Catch: Throwable -> L98
        goto L57
    L44:
        if (r8.isEmpty() == true) goto L51;
        Iterator<Header> r22 = r8.iterator();     // Catch: Throwable -> L98
    L47:
        if (r22.hasNext() == false) goto L51;
        String r23 = r22.next().getValue().trim();     // Catch: Throwable -> L98
        if (r23.toLowerCase().startsWith("sessionid=") == false) goto L47;
        r13 = r23;
    L37:
        r6 = false;
    L12:
        r1 = null;
        goto L13
    }

    private static String appendHeaderString(Response r1, String r2) {
        Header r3 = r1.getFirstHeader(r2);
        if (r3 != null) goto L5;
        return "";
    L5:
        return ("" + r3.toString()) + VectorFormat.DEFAULT_SEPARATOR;
    }

    private void reportClientKeyLog(int r2, String r3, String r4, String r5, String r6, String r7, String r8, Response r9, String r10) throws Exception {
        JSONObject r1 = new JSONObject();
        r1.put("origin_sid", r3);
        r1.put("sid", r4);
        r1.put("origin_key", r5);
        r1.put("key", r6);
        r1.put("origin_kms", r7);
        r1.put("kms", r8);
        if (r9 == null) goto L7;
        String r11 = ((appendHeaderString(r9, "x-tt-token") + appendHeaderString(r9, "x-tt-logid")) + appendHeaderString(r9, CLIENT_KEY_RESPONSE_HEADER_NAME)) + appendHeaderString(r9, KMS_VERSION_RESPONSE_HEADER_NAME);
        if (TextUtils.isEmpty(r11) == true) goto L7;
        r1.put("headers", r11);
    L7:
        TTReportAllLog.reportInternalAllLog(CLIENT_KEY_NAME, r1, r2, r10);
    }

    private void ParseClientKeyConfig(JSONObject r7) throws Exception {
        int r1 = 0;
        if (r7.optInt("client_key_sign_enabled", 0) <= 0) goto L5;
        boolean r0 = true;
    L6:
        mClientKeySignEnabled = r0;
        if (mClientKeySignEnabled == false) goto L9;
        this.mUpdateHostList.clear();
        String r2 = r7.optString("update_host_list", null);
        if (TextUtils.isEmpty(r2) == true) goto L22;
        JSONArray r3 = new JSONArray(r2);
        int r4 = 0;
    L17:
        if (r4 >= r3.length()) goto L22;
        String r5 = r3.getString(r4);
        if (TextUtils.isEmpty(r5) == true) goto L21;
        this.mUpdateHostList.add(r5);
    L21:
        r4 = r4 + 1;
    L22:
        this.mUpdatePathList.clear();
        String r8 = r7.optString("update_path_list", null);
        if (TextUtils.isEmpty(r8) == true) goto L31;
        JSONArray r6 = new JSONArray(r8);
    L26:
        if (r1 >= r6.length()) goto L38;
        String r9 = r6.getString(r1);
        if (TextUtils.isEmpty(r9) == true) goto L30;
        this.mUpdatePathList.add(r9);
    L30:
        r1 = r1 + 1;
        goto L26
    L38:
        return;
    L31:
        return;
    L9:
        if (Logger.debug() == false) goto L11;
        Logger.d(TAG, "clear client key storage.");
    L11:
        mKevaStorage.clear();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void OnNetConfigChanged(Object r6) {
        if (mKevaStorage != null) goto L5;
        return;
    L5:
        if (JsonOptConfig.isValid(r6) == false) goto L26;
        JSONObject r7 = JsonOptConfig.jsonObject(r6);     // Catch: Throwable -> L23
        if (r7 == null) goto L11;
        JSONObject r8 = r7.getJSONObject("data").optJSONObject(CLIENT_KEY_CONFIG_NAME);     // Catch: Throwable -> L23
    L12:
        if (r8 == null) goto L14;
        String r2 = r8.toString();     // Catch: Throwable -> L23
        if (Logger.debug() == false) goto L21;
        Logger.d(TAG, "config: " + r2);     // Catch: Throwable -> L23
    L21:
        mKevaStorage.storeString(CLIENT_KEY_CONFIG_NAME, r2);     // Catch: Throwable -> L23
        ParseClientKeyConfig(r8);     // Catch: Throwable -> L23
        return;
    L14:
        if (Logger.debug() == false) goto L16;
        Logger.d(TAG, "clear client key storage.");     // Catch: Throwable -> L23
    L16:
        mClientKeySignEnabled = false;     // Catch: Throwable -> L23
        mKevaStorage.clear();     // Catch: Throwable -> L23
        return;
    L11:
        r8 = null;
        goto L12
    L27:
        return;
    }

    private static Map<String, String> constructClientKeyHeaders(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L11;
        HashMap r0 = new HashMap();
        r0.put(CLIENT_KEY_REQUEST_HEADER_NAME, r2);
        r0.put(KMS_VERSION_REQUEST_HEADER_NAME, r3);
        return r0;
    L11:
        return null;
    }

    public static Map<String, String> getClientKeyHeaders() {
        if (mKevaStorage != null) goto L5;
        return null;
    L5:
        if (mClientKeySignEnabled == true) goto L8;
        return null;
    L8:
        if (sIsMainProcess == false) goto L12;
        return sClientKeyHeaders;
    L12:
        return constructClientKeyHeaders(mKevaStorage.getString(CLIENT_KEY_NAME, ""), mKevaStorage.getString(KMS_VERSION_NAME, ""));
    }
}
