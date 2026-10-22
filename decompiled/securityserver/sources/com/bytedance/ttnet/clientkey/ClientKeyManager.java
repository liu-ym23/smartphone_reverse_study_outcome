package com.bytedance.ttnet.clientkey;

import a.a;
import android.os.SystemClock;
import android.text.TextUtils;
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
import java.net.CookieHandler;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f90a = 0;
    private static volatile boolean mClientKeySignEnabled = false;
    private static Keva mKevaStorage = null;
    private static Map<String, String> sClientKeyHeaders = null;
    private static volatile ClientKeyManager sInstance = null;
    private static boolean sIsMainProcess = true;
    private String mClientKey;
    private String mKmsVersion;
    private boolean mRewriteSessionEnabled;
    private String mSessionId;
    private String mSessionUrl;
    private List<String> mUpdateHostList;
    private List<String> mUpdatePathList;

    private ClientKeyManager() {
        this.mUpdateHostList = new CopyOnWriteArrayList();
        this.mUpdatePathList = new CopyOnWriteArrayList();
        this.mClientKey = "";
        this.mSessionId = "";
        this.mSessionUrl = "";
        this.mKmsVersion = "";
        this.mRewriteSessionEnabled = true;
    }

    private void ParseClientKeyConfig(JSONObject r7) {
        int r1 = 0;
        boolean r2 = true;
        if (r7.optInt("client_key_sign_enabled", 0) <= 0) goto L5;
        boolean r0 = true;
    L6:
        mClientKeySignEnabled = r0;
        if (mClientKeySignEnabled == true) goto L14;
        if (Logger.debug() == false) goto L11;
        Logger.d(TAG, "clear client key storage.");
    L11:
        mKevaStorage.clear();
        return;
    L14:
        if (r7.optInt("rewrite_session_enabled", 1) > 0) goto L17;
        r2 = false;
    L17:
        this.mRewriteSessionEnabled = r2;
        this.mUpdateHostList.clear();
        String r3 = r7.optString("update_host_list", null);
        if (TextUtils.isEmpty(r3) == true) goto L26;
        JSONArray r4 = new JSONArray(r3);
        int r5 = 0;
    L21:
        if (r5 >= r4.length()) goto L26;
        String r6 = r4.getString(r5);
        if (TextUtils.isEmpty(r6) == true) goto L25;
        this.mUpdateHostList.add(r6);
    L25:
        r5 = r5 + 1;
    L26:
        this.mUpdatePathList.clear();
        String r8 = r7.optString("update_path_list", null);
        if (TextUtils.isEmpty(r8) == true) goto L35;
        JSONArray r9 = new JSONArray(r8);
    L30:
        if (r1 >= r9.length()) goto L42;
        String r10 = r9.getString(r1);
        if (TextUtils.isEmpty(r10) == true) goto L34;
        this.mUpdatePathList.add(r10);
    L34:
        r1 = r1 + 1;
        goto L30
    L42:
        return;
    L35:
        return;
    L5:
        r0 = false;
        goto L6
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

    private void SendCookieMismatchLog(String r6, String r7) {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L4
        r0.put("report_time", System.currentTimeMillis() + "");     // Catch: Throwable -> L4
        r0.put("cookie_line", r6);     // Catch: Throwable -> L4
        r0.put("session_id", r7);     // Catch: Throwable -> L4
        r0.put("url", this.mSessionUrl);     // Catch: Throwable -> L4
        TTReportAllLog.reportInternalAllLog("cookie_mismatch", r0);     // Catch: Throwable -> L4
        return;
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
        SendCookieMismatchLog("empty", r7);     // Catch: Throwable -> L24
        return;
    L20:
        if (r0.contains(this.mSessionId) == true) goto L29;
        refreshSessionCookie(r7, r2, r3);     // Catch: Throwable -> L24
        SendCookieMismatchLog(r0, r7);     // Catch: Throwable -> L24
        return;
    L29:
        return;
    L28:
        return;
    }

    private static String appendHeaderString(Response r1, String r2) {
        Header r3 = r1.getFirstHeader(r2);
        if (r3 != null) goto L5;
        return "";
    L5:
        return a.j("" + r3.toString(), "; ");
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

    public static ClientKeyManager inst() {
        if (sInstance != null) goto L16;
        monitor-enter(ClientKeyManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new ClientKeyManager();     // Catch: Throwable -> L9
    L11:
        monitor-exit(ClientKeyManager.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    private void refreshSessionCookie(String r3, CookieHandler r4, URI r5) {
        if (this.mRewriteSessionEnabled == true) goto L5;
        return;
    L5:
        Map<String, List<String>> r2 = new LinkedHashMap();
        ArrayList r0 = new ArrayList();
        r0.add(r3);
        r2.put("Set-Cookie", r0);
        r4.put(r5, r2);
        if (Logger.debug() == false) goto L9;
        a.y("Refresh session cookie: ", r3, TAG);
        return;
    }

    private void reportClientKeyLog(int r2, String r3, String r4, String r5, String r6, String r7, String r8, Response r9, String r10) {
        JSONObject r1 = new JSONObject();
        r1.put("origin_sid", r3);
        r1.put("sid", r4);
        r1.put("origin_key", r5);
        r1.put("key", r6);
        r1.put("origin_kms", r7);
        r1.put("kms", r8);
        if (r9 == null) goto L7;
        StringBuilder r11 = a.q(appendHeaderString(r9, "x-tt-token"));
        r11.append(appendHeaderString(r9, "x-tt-logid"));
        StringBuilder r12 = a.q(r11.toString());
        r12.append(appendHeaderString(r9, CLIENT_KEY_RESPONSE_HEADER_NAME));
        StringBuilder r13 = a.q(r12.toString());
        r13.append(appendHeaderString(r9, KMS_VERSION_RESPONSE_HEADER_NAME));
        String r14 = r13.toString();
        if (TextUtils.isEmpty(r14) == true) goto L7;
        r1.put("headers", r14);
    L7:
        TTReportAllLog.reportInternalAllLog(CLIENT_KEY_NAME, r1, r2, r10);
    }

    public void AddClientKeyHeader(List<Header> r6, RetrofitMetrics r7) {
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
        long r0 = SystemClock.uptimeMillis();
        r6.add(new Header(CLIENT_KEY_REQUEST_HEADER_NAME, this.mClientKey));
        r6.add(new Header(KMS_VERSION_REQUEST_HEADER_NAME, this.mKmsVersion));
        if (r7 == null) goto L18;
        r7.addClientKeyDuration = SystemClock.uptimeMillis() - r0;
        r7.addClientKeySuccess = true;
        return;
    L18:
        return;
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

    public synchronized void UpdateClientKeyAndSessionInfo(Request r20, Response r21) {
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (mKevaStorage != null) goto L7;
    L90:
        monitor-exit(this);
        return;
    L7:
        if (mClientKeySignEnabled == false) goto L90;
        long r12 = SystemClock.uptimeMillis();     // Catch: Throwable -> L24
        URI r1 = URIUtils.safeCreateUri(r20.getUrl());     // Catch: Throwable -> L12
    L13:
        if (r1 != null) goto L17;
        monitor-exit(this);
        return;
    L17:
        if (this.mUpdateHostList.isEmpty() == true) goto L29;
        Iterator<String> r2 = this.mUpdateHostList.iterator();     // Catch: Throwable -> L24
    L20:
        if (r2.hasNext() == false) goto L26;
        if (UrlUtils.matchPattern(r1.getHost(), r2.next()) == false) goto L20;
    L26:
        monitor-exit(this);
        return;
    L29:
        if (this.mUpdatePathList.isEmpty() == true) goto L88;
        Iterator<String> r3 = this.mUpdatePathList.iterator();     // Catch: Throwable -> L24
    L32:
        if (r3.hasNext() == false) goto L88;
        if (UrlUtils.matchPattern(r1.getPath(), r3.next()) == false) goto L32;
        String r4 = "";
        List<Header> r5 = r21.headers("Set-Cookie");     // Catch: Throwable -> L24
        if (r5 != null) goto L38;
    L45:
        String r14 = "";
    L46:
        String[] r6 = r14.split(";");     // Catch: Throwable -> L24
        int r7 = 0;
        if (r6 != null) goto L49;
    L51:
        String r15 = r4;
        if (TextUtils.isEmpty(r15) == false) goto L56;
        monitor-exit(this);
        return;
    L56:
        if (Logger.debug() == false) goto L58;
        Logger.d(TAG, "original sessionid: " + this.mSessionId + " new sessionid: " + r15);     // Catch: Throwable -> L24
    L58:
        String r8 = "";
        String r9 = "";
        Header r10 = r21.getFirstHeader(CLIENT_KEY_RESPONSE_HEADER_NAME);     // Catch: Throwable -> L24
        Header r11 = r21.getFirstHeader(KMS_VERSION_RESPONSE_HEADER_NAME);     // Catch: Throwable -> L24
        if (r10 == null) goto L69;
        if (r11 == null) goto L69;
        r8 = r10.getValue();     // Catch: Throwable -> L24
        r9 = r11.getValue();     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r8) == false) goto L64;
    L67:
        r8 = "";
        r9 = "";
        r7 = 1;
    L66:
        String r13 = r8;
        String r16 = r9;
        int r17 = r7;
        if (r17 != 0) goto L98;
    L78:
        String r0 = r16;
        long r18 = r12;
        String r19 = r13;
    L79:
        this.mClientKey = r19;     // Catch: Throwable -> L24
        this.mKmsVersion = r0;     // Catch: Throwable -> L24
        String r22 = r20.getUrl();     // Catch: Throwable -> L24
        this.mSessionUrl = r22;     // Catch: Throwable -> L24
        this.mSessionId = r15;     // Catch: Throwable -> L24
        mKevaStorage.storeString(SESSION_URL_NAME, r22);     // Catch: Throwable -> L24
        mKevaStorage.storeString("session_id", r14);     // Catch: Throwable -> L24
        mKevaStorage.storeString(CLIENT_KEY_NAME, this.mClientKey);     // Catch: Throwable -> L24
        mKevaStorage.storeString(KMS_VERSION_NAME, this.mKmsVersion);     // Catch: Throwable -> L24
        mKevaStorage.storeLong(SESSION_TIME_NAME, System.currentTimeMillis());     // Catch: Throwable -> L24
        sClientKeyHeaders = constructClientKeyHeaders(this.mClientKey, this.mKmsVersion);     // Catch: Throwable -> L24
        if (r20.getMetrics() == null) goto L83;
        r20.getMetrics().updateClientKeyDuration = SystemClock.uptimeMillis() - r18;     // Catch: Throwable -> L24
    L83:
        if (Logger.debug() == false) goto L85;
        Logger.d(TAG, "save session url: " + this.mSessionUrl + " session cookie: " + r14 + " client key: " + this.mClientKey + " kms version: " + this.mKmsVersion);     // Catch: Throwable -> L24
    L85:
        monitor-exit(this);
        return;
    L98:
        r0 = r16;
        r18 = r12;
        r19 = r13;
        reportClientKeyLog(r17, this.mSessionId, r15, this.mClientKey, r13, this.mKmsVersion, r16, r21, r1.getPath());     // Catch: Throwable -> L94
        goto L79
    L64:
        if (TextUtils.isEmpty(r9) == false) goto L66;
    L69:
        if (r15.equals(this.mSessionId) == false) goto L72;
        r8 = this.mClientKey;     // Catch: Throwable -> L24
        r9 = this.mKmsVersion;     // Catch: Throwable -> L24
        r7 = 2;
        goto L66
    L72:
        r7 = 3;
        goto L66
    L49:
        if (r6.length <= 0) goto L51;
        r4 = r6[0].trim();     // Catch: Throwable -> L24
        goto L51
    L38:
        if (r5.isEmpty() == true) goto L45;
        Iterator<Header> r23 = r5.iterator();     // Catch: Throwable -> L24
    L41:
        if (r23.hasNext() == false) goto L45;
        String r24 = r23.next().getValue().trim();     // Catch: Throwable -> L24
        if (r24.toLowerCase().startsWith("sessionid=") == false) goto L41;
        r14 = r24;
    L88:
        monitor-exit(this);
        return;
    L12:
        r1 = null;
        goto L13
    }
}
