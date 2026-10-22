package com.bytedance.ttnet.utils;

import a.a;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.exception.CdnCacheVerifyException;
import com.bytedance.frameworks.baselib.network.http.util.URIUtils;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.ttnet.http.HttpRequestInfo;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CdnCacheVerifyUtils {
    private static final String HEADER_VERIFY_KEY = "X-TT-VERIFY-ID";
    public static final String KEY_TTNET_RESPONSE_VERIFY = "ttnet_response_verify";
    public static final String KEY_TTNET_RESPONSE_VERIFY_ENABLED = "ttnet_response_verify_enabled";
    private static final String TAG = "CDN_CACHE_VERIFY";
    public static final int VERIFY_ACCESSIBLE = 1;
    public static final int VERIFY_FAIL = 3;
    public static final int VERIFY_SUCCESS = 2;
    public static final int VERIFY_UNDEFINED = -1;
    private static volatile boolean sEnabled = false;
    private static Lock sReadLock;
    private static ReentrantReadWriteLock sReadWriteLock;
    private static List<Regex> sRegexArray;
    private static Lock sWriteLock;

    public static class CdnCacheVerifyConfig {
        public int ttnetResponseVerifyEnabled;
        public String verifyRegexsStr;

        public CdnCacheVerifyConfig() {
        }
    }

    public static class Regex {
        private Pattern pattern;

        public Regex() {
        }

        public boolean matcher(URI r4) {
            if (r4 != null) goto L5;
        L14:
            return false;
        L5:
            if (TextUtils.isEmpty(r4.getHost()) == true) goto L14;
            if (this.pattern == null) goto L14;
            String r1 = r4.getHost();
            if (TextUtils.isEmpty(r4.getPath()) == true) goto L16;
            StringBuilder r2 = a.q(r1);
            r2.append(r4.getPath());
            r1 = r2.toString();
        L16:
            return this.pattern.matcher(r1).matches();
        }

        public boolean setPattern(String r1) {
            this.pattern = Pattern.compile(r1);     // Catch: PatternSyntaxException -> L5
            return true;
        L5:
            e = move-exception;
            e.printStackTrace();
            return false;
        }
    }

    static {
        sRegexArray = new ArrayList();
        ReentrantReadWriteLock r0 = new ReentrantReadWriteLock();
        sReadWriteLock = r0;
        sReadLock = r0.readLock();
        sWriteLock = sReadWriteLock.writeLock();
    }

    public CdnCacheVerifyUtils() {
    }

    private static boolean filterRule(URI r2) {
        sReadLock.lock();     // Catch: Throwable -> L10
        Iterator<Regex> r0 = sRegexArray.iterator();     // Catch: Throwable -> L10
    L4:
        if (r0.hasNext() == false) goto L12;
        goto L4
    L7:
        if (r0.next().matcher(r2) == false) goto L4;
        sReadLock.unlock();
        return true;
    L12:
        sReadLock.unlock();
        return false;
    L10:
        th = move-exception;
        sReadLock.unlock();
        throw th;
    }

    private static String generateVerifyValue() {
        return UUID.randomUUID().toString();
    }

    private static String getCdnCacheVerifyValue(URI r0) {
        if (filterRule(r0) == true) goto L5;
        return null;
    L5:
        return generateVerifyValue();
    }

    public static void onLocalConfigUpdate(SharedPreferences r3) {
        int r0 = r3.getInt(KEY_TTNET_RESPONSE_VERIFY_ENABLED, -1);
        String r4 = r3.getString(KEY_TTNET_RESPONSE_VERIFY, "");
        if (TextUtils.isEmpty(r4) == false) goto L11;
    L8:
        JSONArray r1 = null;
    L9:
        resolveCdnCacheVerify(r0, r1);
        return;
    L11:
        r1 = new JSONArray(r4);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        th.printStackTrace();
        goto L8
    }

    public static CdnCacheVerifyConfig onServerConfigUpdate(JSONObject r2) {
        int r0 = r2.optInt(KEY_TTNET_RESPONSE_VERIFY_ENABLED, -1);
        JSONArray r3 = r2.optJSONArray(KEY_TTNET_RESPONSE_VERIFY);
        if (r3 == null) goto L5;
        String r1 = r3.toString();
    L6:
        resolveCdnCacheVerify(r0, r3);
        CdnCacheVerifyConfig r4 = new CdnCacheVerifyConfig();
        r4.ttnetResponseVerifyEnabled = r0;
        r4.verifyRegexsStr = r1;
        return r4;
    L5:
        r1 = "";
        goto L6
    }

    public static void postProcessing(Request r1, Response r2, HttpRequestInfo r3) {
        if (sEnabled == true) goto L5;
        return;
    L5:
        if (r3 != null) goto L8;
        Logger.w(TAG, "Req info is null");
        return;
    L8:
        postProcessingImpl(r1, r2, r3);
    }

    private static void postProcessingImpl(Request r4, Response r5, HttpRequestInfo r6) {
        Header r1 = r4.getFirstHeader(HEADER_VERIFY_KEY);
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getValue();
    L6:
        Header r0 = r5.getFirstHeader(HEADER_VERIFY_KEY);
        if (r0 == null) goto L9;
        r2 = r0.getValue();
    L9:
        if (r3 != null) goto L11;
        return;
    L11:
        if (r2 != null) goto L14;
        r6.cdnVerifyValue = 1;
        Logger.w(TAG, "Cdn cache verify accessible");
    L21:
        RequestTicketUtil.ICdnCacheVerifyCallback r7 = RequestTicketUtil.getCdnCacheVerifyProcessor();
        if (r7 == null) goto L25;
        r7.onCallback(r4.getUrl(), r6);
    L25:
        if (r6.cdnVerifyValue == 3) goto L28;
        return;
    L28:
        throw new CdnCacheVerifyException("Fail to verify cdn cache");
    L14:
        if (r3.equals(r2) == false) goto L16;
        r6.cdnVerifyValue = 2;
        Logger.w(TAG, "Cdn cache verify success");
        goto L21
    L16:
        r6.cdnVerifyValue = 3;
        Logger.w(TAG, "Cdn cache verify fail");
        r5.getBody().in().close();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.printStackTrace();
        Logger.w(TAG, "Cdn cache verify stream close fail:" + th.toString());
        goto L21
    L5:
        r3 = null;
        goto L6
    }

    public static void preProcessing(String r1, List<Header> r2) {
        if (sEnabled == true) goto L5;
        return;
    L5:
        preProcessingImpl(r1, r2);
    }

    private static void preProcessingImpl(String r2, List<Header> r3) {
        String r4 = getCdnCacheVerifyValue(URIUtils.safeCreateUri(r2));     // Catch: Throwable -> L6
        if (TextUtils.isEmpty(r4) == true) goto L11;
        r3.add(new Header(HEADER_VERIFY_KEY, r4));     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    private static void resolveCdnCacheVerify(int r4, JSONArray r5) {
        int r0 = 0;
        if (r4 <= 0) goto L16;
        ArrayList r6 = new ArrayList();
        if (r5 == null) goto L15;
        int r1 = r5.length();
    L7:
        if (r0 >= r1) goto L14;
        String r2 = r5.optString(r0);
        if (TextUtils.isEmpty(r2) == true) goto L13;
        Regex r3 = new Regex();
        if (r3.setPattern(r2) == false) goto L13;
        r6.add(r3);
    L13:
        r0 = r0 + 1;
        goto L7
    L14:
        setRegexArray(r6);
    L15:
        setEnabled(true);
        return;
    L16:
        setEnabled(false);
    }

    public static void setEnabled(boolean r0) {
        sEnabled = r0;
    }

    public static void setRegexArray(List<Regex> r1) {
        sWriteLock.lock();     // Catch: Throwable -> L5
        sRegexArray = r1;     // Catch: Throwable -> L5
        sWriteLock.unlock();
        return;
    L5:
        th = move-exception;
        sWriteLock.unlock();
        throw th;
    }
}
