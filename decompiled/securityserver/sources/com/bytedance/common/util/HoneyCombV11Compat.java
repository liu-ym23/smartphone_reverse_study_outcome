package com.bytedance.common.util;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class HoneyCombV11Compat {
    static Method sMethodWebViewOnPause = null;
    static Method sMethodWebViewOnResume = null;
    static boolean sWebViewPauseResumeGot = false;

    @TargetApi(11)
    public static class HoneyCombImpl {
        public HoneyCombImpl() {
        }

        public static Context getContext(AlertDialog.Builder r0) {
            return r0.getContext();
        }

        public static int getLargeMemoryClass(ActivityManager r0) {
            return r0.getLargeMemoryClass();
        }

        public static void pauseWebView(WebView r0) {
            r0.onPause();
        }

        public static void resumeWebView(WebView r0) {
            r0.onResume();
        }

        public static void setDisplayZoomControl(WebSettings r0, boolean r1) {
            r0.setDisplayZoomControls(r1);
        }
    }

    public HoneyCombV11Compat() {
    }

    public static Context getContext(Context r0, AlertDialog.Builder r1) {
        return HoneyCombImpl.getContext(r1);
    }

    public static int getLargeMemoryClass(ActivityManager r0) {
        return HoneyCombImpl.getLargeMemoryClass(r0);
    L4:
        return -1;
    }

    public static void pauseWebView(WebView r0) {
        if (r0 != null) goto L4;
        return;
    L4:
        HoneyCombImpl.pauseWebView(r0);
    }

    public static void resumeWebView(WebView r0) {
        if (r0 != null) goto L4;
        return;
    L4:
        HoneyCombImpl.resumeWebView(r0);
    }

    public static void setDisplayZoomControl(WebSettings r0, boolean r1) {
        HoneyCombImpl.setDisplayZoomControl(r0, r1);
    }

    private static void tryGetWebViewPauseResumeMethod() {
        if (sWebViewPauseResumeGot == false) goto L5;
        return;
    L5:
        sWebViewPauseResumeGot = true;
        sMethodWebViewOnPause = WebView.class.getMethod("onPause", null);     // Catch: Exception -> L8
        sMethodWebViewOnResume = WebView.class.getMethod("onResume", null);     // Catch: Exception -> L8
        return;
    }
}
