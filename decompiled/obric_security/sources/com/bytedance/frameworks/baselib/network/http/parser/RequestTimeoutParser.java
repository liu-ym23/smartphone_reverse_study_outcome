package com.bytedance.frameworks.baselib.network.http.parser;

import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import java.net.URL;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class RequestTimeoutParser {
    private static final String CONNECT_TIMEOUT = "conn_to";
    private static final String HOST_KEY_EQ = "host_eq";
    private static final String HOST_KEY_WC = "host_wc";
    private static final String PATH_KEY_CONTAIN = "path_contain";
    private static final String PATH_KEY_EQ = "path_eq";
    private static final String PATH_KEY_PATTERN = "path_pattern";
    private static final String PATH_KEY_PREFIX = "path_prefix";
    private static final String PROTECT_TIMEOUT = "pro_to";
    private static final String READ_TIMEOUT = "read_to";
    private static final String TIMEOUT_CONFIG_ENABLE = "enabled";
    private static final String TIMEOUT_CONFIG_KEY = "to_config_v1";
    private static final String TIMEOUT_CONFIG_RULE_LIST = "rule_list";
    private static final int TYPE_HOST_EQ = 1;
    private static final int TYPE_HOST_NONE = 0;
    private static final int TYPE_HOST_WC = 2;
    private static final int TYPE_PATH_CONTAIN = 5;
    private static final int TYPE_PATH_EQ = 3;
    private static final int TYPE_PATH_PATTERN = 6;
    private static final int TYPE_PATH_PREFIX = 4;
    private static final String VALUE = "value";
    private static final String WRITE_TIMEOUT = "write_to";
    private static Lock sReadLock;
    private static ReentrantReadWriteLock sReadWriteLock;
    private static JSONObject sTimeoutConfigData;
    private static Lock sWriteLock;

    public static class SocketTimeoutParam {
        public int connectTimeout;
        public int readTimeout;
        public int writeTimeout;

        public SocketTimeoutParam() {
        }
    }

    public RequestTimeoutParser() {
    }

    static {
        ReentrantReadWriteLock r0 = new ReentrantReadWriteLock();
        sReadWriteLock = r0;
        sReadLock = r0.readLock();
        sWriteLock = sReadWriteLock.writeLock();
    }

    public static void onServerConfigChanged(JSONObject r1) {
        if (r1 != null) goto L10;
        return;
    L10:
        sWriteLock.lock();     // Catch: Throwable -> L7
        sTimeoutConfigData = r1.optJSONObject(TIMEOUT_CONFIG_KEY);     // Catch: Throwable -> L7
        sWriteLock.unlock();
        return;
    L7:
        th = move-exception;
        sWriteLock.unlock();
        throw th;
    }

    public static int getRequestTimeout(URL r16, SocketTimeoutParam r17) {
        if (r16 != null) goto L64;
        return -1;
    L64:
        sReadLock.lock();     // Catch: Throwable -> L63
        JSONObject r8 = sTimeoutConfigData;     // Catch: Throwable -> L63
        if (r8 != null) goto L10;
    L7:
        sReadLock.unlock();
        return -1;
    L10:
        if (r8.optInt(TIMEOUT_CONFIG_ENABLE, 0) <= 0) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == false) goto L7;
        JSONArray r10 = sTimeoutConfigData.optJSONArray(TIMEOUT_CONFIG_RULE_LIST);     // Catch: Throwable -> L63
        if (r10 == null) goto L7;
        if (r10.length() == 0) goto L7;
        int r11 = 0;
    L22:
        if (r11 >= r10.length()) goto L61;
        JSONObject r12 = r10.optJSONObject(r11);     // Catch: Throwable -> L63
        if (r12 == null) goto L60;
        JSONArray r14 = null;
        if (r12.has(HOST_KEY_EQ) == false) goto L30;
        JSONArray r13 = r12.optJSONArray(HOST_KEY_EQ);     // Catch: Throwable -> L63
        int r15 = 1;
    L33:
        if (r13 == null) goto L60;
        if (hitRule(r16.getHost(), r13, r15) == false) goto L60;
        if (r12.has(PATH_KEY_EQ) == false) goto L41;
        r14 = r12.optJSONArray(PATH_KEY_EQ);     // Catch: Throwable -> L63
        int r18 = 3;
    L50:
        if (r14 == null) goto L60;
        if (hitRule(r16.getPath(), r14, r18) == false) goto L60;
        JSONObject r19 = r12.optJSONObject("value");     // Catch: Throwable -> L63
        if (r19 == null) goto L60;
        r17.connectTimeout = r19.optInt(CONNECT_TIMEOUT, -1);     // Catch: Throwable -> L63
        r17.readTimeout = r19.optInt(READ_TIMEOUT, -1);     // Catch: Throwable -> L63
        r17.writeTimeout = r19.optInt(WRITE_TIMEOUT, -1);     // Catch: Throwable -> L63
        int r0 = r19.optInt(PROTECT_TIMEOUT, -1);     // Catch: Throwable -> L63
        sReadLock.unlock();
        return r0;
    L41:
        if (r12.has(PATH_KEY_PREFIX) == false) goto L44;
        r14 = r12.optJSONArray(PATH_KEY_PREFIX);     // Catch: Throwable -> L63
        r18 = 4;
        goto L50
    L44:
        if (r12.has(PATH_KEY_CONTAIN) == false) goto L47;
        r14 = r12.optJSONArray(PATH_KEY_CONTAIN);     // Catch: Throwable -> L63
        r18 = 5;
        goto L50
    L47:
        if (r12.has(PATH_KEY_PATTERN) == false) goto L49;
        r14 = r12.optJSONArray(PATH_KEY_PATTERN);     // Catch: Throwable -> L63
        r18 = 6;
        goto L50
    L49:
        r18 = 0;
        goto L50
    L30:
        if (r12.has(HOST_KEY_WC) == false) goto L32;
        r13 = r12.optJSONArray(HOST_KEY_WC);     // Catch: Throwable -> L63
        r15 = 2;
        goto L33
    L32:
        r15 = 0;
        r13 = null;
    L60:
        r11 = r11 + 1;
        goto L22
    L12:
        r9 = false;
    L61:
        sReadLock.unlock();
        return -1;
    }

    private static boolean hitRule(String r4, JSONArray r5, int r6) {
        if (r4 != null) goto L5;
    L61:
        return false;
    L5:
        if (r4.isEmpty() == true) goto L61;
        if (r5 == null) goto L61;
        if (r5.length() == 0) goto L61;
        switch(r6) {
            case 1: goto L49;
            case 2: goto L40;
            case 3: goto L49;
            case 4: goto L31;
            case 5: goto L22;
            case 6: goto L13;
            default: goto L12;
        };
    L12:
        return false;
    L13:
        int r7 = 0;
    L15:
        if (r7 >= r5.length()) goto L58;
        String r2 = r5.optString(r7);     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r2) == true) goto L21;
        if (r4.matches(r2) == false) goto L21;
        return true;
    L21:
        r7 = r7 + 1;     // Catch: Throwable -> L59
    L58:
        return false;
    L22:
        int r8 = 0;
    L24:
        if (r8 >= r5.length()) goto L58;
        String r3 = r5.optString(r8);     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r3) == true) goto L30;
        if (r4.contains(r3) == false) goto L30;
        return true;
    L30:
        r8 = r8 + 1;     // Catch: Throwable -> L59
        goto L24
    L31:
        int r9 = 0;
    L33:
        if (r9 >= r5.length()) goto L58;
        String r10 = r5.optString(r9);     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r10) == true) goto L39;
        if (r4.startsWith(r10) == false) goto L39;
        return true;
    L39:
        r9 = r9 + 1;     // Catch: Throwable -> L59
        goto L33
    L40:
        int r11 = 0;
    L42:
        if (r11 >= r5.length()) goto L58;
        String r12 = r5.optString(r11);     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r12) == true) goto L48;
        if (UrlUtils.matchPattern(r4, r12) == false) goto L48;
        return true;
    L48:
        r11 = r11 + 1;     // Catch: Throwable -> L59
        goto L42
    L49:
        int r13 = 0;
    L51:
        if (r13 >= r5.length()) goto L58;
        String r14 = r5.optString(r13);     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r14) == true) goto L57;
        if (r4.equals(r14) == false) goto L57;
        return true;
    L57:
        r13 = r13 + 1;
    L59:
        th = move-exception;
        th.printStackTrace();
        goto L61
    }
}
