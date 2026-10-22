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

    static {
        ReentrantReadWriteLock r0 = new ReentrantReadWriteLock();
        sReadWriteLock = r0;
        sReadLock = r0.readLock();
        sWriteLock = sReadWriteLock.writeLock();
    }

    public RequestTimeoutParser() {
    }

    public static int getRequestTimeout(URL r16, SocketTimeoutParam r17) {
        if (r16 != null) goto L60;
        return -1;
    L60:
        sReadLock.lock();     // Catch: Throwable -> L59
        JSONObject r8 = sTimeoutConfigData;     // Catch: Throwable -> L59
        if (r8 != null) goto L10;
    L7:
        sReadLock.unlock();
        return -1;
    L10:
        if (r8.optInt(TIMEOUT_CONFIG_ENABLE, 0) <= 0) goto L7;
        JSONArray r9 = sTimeoutConfigData.optJSONArray(TIMEOUT_CONFIG_RULE_LIST);     // Catch: Throwable -> L59
        if (r9 == null) goto L7;
        if (r9.length() == 0) goto L7;
        int r10 = 0;
    L18:
        if (r10 >= r9.length()) goto L57;
        JSONObject r11 = r9.optJSONObject(r10);     // Catch: Throwable -> L59
        if (r11 == null) goto L56;
        JSONArray r13 = null;
        if (r11.has(HOST_KEY_EQ) == false) goto L26;
        JSONArray r12 = r11.optJSONArray(HOST_KEY_EQ);     // Catch: Throwable -> L59
        int r14 = 1;
    L29:
        if (r12 == null) goto L56;
        if (hitRule(r16.getHost(), r12, r14) == false) goto L56;
        if (r11.has(PATH_KEY_EQ) == false) goto L37;
        r13 = r11.optJSONArray(PATH_KEY_EQ);     // Catch: Throwable -> L59
        int r15 = 3;
    L46:
        if (r13 == null) goto L56;
        if (hitRule(r16.getPath(), r13, r15) == false) goto L56;
        JSONObject r18 = r11.optJSONObject("value");     // Catch: Throwable -> L59
        if (r18 == null) goto L56;
        r17.connectTimeout = r18.optInt(CONNECT_TIMEOUT, -1);     // Catch: Throwable -> L59
        r17.readTimeout = r18.optInt(READ_TIMEOUT, -1);     // Catch: Throwable -> L59
        r17.writeTimeout = r18.optInt(WRITE_TIMEOUT, -1);     // Catch: Throwable -> L59
        int r0 = r18.optInt(PROTECT_TIMEOUT, -1);     // Catch: Throwable -> L59
        sReadLock.unlock();
        return r0;
    L37:
        if (r11.has(PATH_KEY_PREFIX) == false) goto L40;
        r13 = r11.optJSONArray(PATH_KEY_PREFIX);     // Catch: Throwable -> L59
        r15 = 4;
        goto L46
    L40:
        if (r11.has(PATH_KEY_CONTAIN) == false) goto L43;
        r13 = r11.optJSONArray(PATH_KEY_CONTAIN);     // Catch: Throwable -> L59
        r15 = 5;
        goto L46
    L43:
        if (r11.has(PATH_KEY_PATTERN) == false) goto L45;
        r13 = r11.optJSONArray(PATH_KEY_PATTERN);     // Catch: Throwable -> L59
        r15 = 6;
        goto L46
    L45:
        r15 = 0;
        goto L46
    L26:
        if (r11.has(HOST_KEY_WC) == false) goto L28;
        r12 = r11.optJSONArray(HOST_KEY_WC);     // Catch: Throwable -> L59
        r14 = 2;
        goto L29
    L28:
        r14 = 0;
        r12 = null;
    L56:
        r10 = r10 + 1;
    L57:
        sReadLock.unlock();
        return -1;
    }

    private static boolean hitRule(String r4, JSONArray r5, int r6) {
        if (r4 != null) goto L5;
    L62:
        return false;
    L5:
        if (r4.isEmpty() == true) goto L62;
        if (r5 == null) goto L62;
        if (r5.length() == 0) goto L62;
        switch(r6) {
            case 1: goto L51;
            case 2: goto L42;
            case 3: goto L51;
            case 4: goto L33;
            case 5: goto L24;
            case 6: goto L13;
            default: goto L12;
        };
    L12:
        return false;
    L13:
        int r7 = 0;
    L15:
        if (r7 >= r5.length()) goto L60;
        String r2 = r5.optString(r7);     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r2) == true) goto L23;
        if (r4.matches(r2) == false) goto L23;
        return true;
    L23:
        r7 = r7 + 1;     // Catch: Throwable -> L21
    L60:
        return false;
    L24:
        int r8 = 0;
    L26:
        if (r8 >= r5.length()) goto L60;
        String r3 = r5.optString(r8);     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r3) == true) goto L32;
        if (r4.contains(r3) == false) goto L32;
        return true;
    L32:
        r8 = r8 + 1;     // Catch: Throwable -> L21
        goto L26
    L33:
        int r9 = 0;
    L35:
        if (r9 >= r5.length()) goto L60;
        String r10 = r5.optString(r9);     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r10) == true) goto L41;
        if (r4.startsWith(r10) == false) goto L41;
        return true;
    L41:
        r9 = r9 + 1;     // Catch: Throwable -> L21
        goto L35
    L42:
        int r11 = 0;
    L44:
        if (r11 >= r5.length()) goto L60;
        String r12 = r5.optString(r11);     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r12) == true) goto L50;
        if (UrlUtils.matchPattern(r4, r12) == false) goto L50;
        return true;
    L50:
        r11 = r11 + 1;     // Catch: Throwable -> L21
        goto L44
    L51:
        int r13 = 0;
    L53:
        if (r13 >= r5.length()) goto L60;
        String r14 = r5.optString(r13);     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r14) == true) goto L59;
        if (r4.equals(r14) == false) goto L59;
        return true;
    L59:
        r13 = r13 + 1;
    L21:
        th = move-exception;
        th.printStackTrace();
        goto L62
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
}
