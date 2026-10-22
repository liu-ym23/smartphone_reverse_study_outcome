package com.bytedance.frameworks.baselib.network.config;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import okhttp3.Headers;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class InsecureRequestControlConfig {
    private static final String DISABLE_SHARE_INSECURE_COOKIE_KEY = "disable_share_insecure_cookie";
    private static final String INSECURE_REQUEST_CONTROL_KEY = "insecure_request_control";
    private static final String SECRET_COOKIE_LIST_KEY = "secret_cookie_list";
    private static final String SECRET_HEADER_LIST_KEY = "secret_header_list";
    private static volatile boolean sDisableShareInsecureCookie = false;
    private static final CopyOnWriteArraySet<String> sSecretCookieSet = null;
    private static final CopyOnWriteArraySet<String> sSecretHeaderSet = null;

    public InsecureRequestControlConfig() {
    }

    static {
        sSecretCookieSet = new CopyOnWriteArraySet();
        sSecretHeaderSet = new CopyOnWriteArraySet();
    }

    public static boolean isDisableShareInsecureCookie() {
        return sDisableShareInsecureCookie;
    }

    public static Set<String> getInSecureCookies(List<String> r8) {
        CopyOnWriteArraySet<String> r0 = sSecretCookieSet;
        if (r0.isEmpty() == true) goto L31;
        if (r8 != null) goto L6;
        return null;
    L6:
        if (r8.isEmpty() == true) goto L34;
        HashSet r1 = new HashSet();
        Iterator<String> r2 = r0.iterator();
    L10:
        if (r2.hasNext() == false) goto L20;
        String r3 = r2.next();
        Iterator<String> r4 = r8.iterator();
    L13:
        if (r4.hasNext() == false) goto L10;
        String r5 = r4.next();
        if (r5 == null) goto L13;
        if (r5.contains(r3 + "=") == false) goto L13;
        r1.add(r3);
        goto L13
    L20:
        if (r1.size() > 0) goto L22;
        return null;
    L22:
        return r1;
    L34:
        return null;
    L31:
        return null;
    }

    public static Set<String> getInsecureHeaders(Headers r5) {
        CopyOnWriteArraySet<String> r0 = sSecretHeaderSet;
        if (r0.isEmpty() == true) goto L23;
        if (r5 != null) goto L6;
        return null;
    L6:
        if (r5.size() == 0) goto L26;
        HashSet r1 = new HashSet();
        Iterator<String> r2 = r0.iterator();
    L10:
        if (r2.hasNext() == false) goto L15;
        String r3 = r2.next();
        if (r5.get(r3) == null) goto L10;
        r1.add(r3);
        goto L10
    L15:
        if (r1.size() > 0) goto L17;
        return null;
    L17:
        return r1;
    L26:
        return null;
    L23:
        return null;
    }

    public static void onServerConfigChanged(JSONObject r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        resetTncConfig();
        JSONObject r3 = r2.optJSONObject(INSECURE_REQUEST_CONTROL_KEY);
        if (r3 != null) goto L7;
        return;
    L7:
        boolean r1 = false;
        if (r3.optInt(DISABLE_SHARE_INSECURE_COOKIE_KEY, 0) <= 0) goto L10;
        r1 = true;
    L10:
        sDisableShareInsecureCookie = r1;
        parseArraySetStringConfig(r3.optJSONArray(SECRET_COOKIE_LIST_KEY), sSecretCookieSet);
        parseArraySetStringConfig(r3.optJSONArray(SECRET_HEADER_LIST_KEY), sSecretHeaderSet);
    }

    private static void resetTncConfig() {
        sDisableShareInsecureCookie = false;
        sSecretCookieSet.clear();
        sSecretHeaderSet.clear();
    }

    private static void parseArraySetStringConfig(JSONArray r3, CopyOnWriteArraySet<String> r4) {
        if (r3 == null) goto L12;
        if (r4 == null) goto L19;
        int r0 = 0;
    L14:
        if (r0 >= r3.length()) goto L21;
        String r1 = r3.getString(r0);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r1) == true) goto L11;
        r4.add(r1);     // Catch: JSONException -> L13
    L11:
        r0 = r0 + 1;
        goto L14
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }
}
