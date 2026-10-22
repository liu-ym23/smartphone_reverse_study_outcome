package com.bytedance.frameworks.baselib.network.http;

import android.os.SystemClock;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.parser.MimeType;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Request;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseHttpClient implements IHttpClient {
    private static volatile long sAppActivityResumeState = 0;
    private static volatile boolean sAppActivityResumed = false;

    public BaseHttpClient() {
    }

    public static long GetAppActivityResumeState() {
        return sAppActivityResumeState;
    }

    public static void OnAppActivitySuspend() {
        if (sAppActivityResumed == false) goto L6;
        sAppActivityResumed = false;
        sAppActivityResumeState++;
        return;
    }

    public static void OnAppActiviyResume() {
        if (sAppActivityResumed == true) goto L6;
        sAppActivityResumed = true;
        sAppActivityResumeState++;
        return;
    }

    public static String getContentBaseType(String r2) {
    L7:
        e = move-exception;
        e.printStackTrace();
        return "";
    L4:
        if (StringUtils.isEmpty(r2) == true) goto L12;
        return new MimeType(r2).getBaseType();
    L12:
        return "";
    }

    public void tryApiProcessHookInit() {
        NetworkParams.tryApiProcessHookInit();
    }

    public void tryNecessaryInit(Request r7) {
        if (NetworkParams.interceptCookie(r7.getExtraInfo()) == true) goto L8;
        long r0 = SystemClock.uptimeMillis();
        NetworkParams.tryCookieManagerInit();
        if (r7.getMetrics() == null) goto L9;
        RetrofitMetrics r6 = r7.getMetrics();
        long r2 = r6.tryNecessaryInitDuration;
        r6.tryNecessaryInitDuration = (SystemClock.uptimeMillis() - r0) + r2;
        return;
    L9:
        return;
    }
}
