package com.bytedance.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.location.Location;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes.dex */
public class JellyBeanMR1V17Compat {
    private static final long TIME_CONST = 1000000;
    static final boolean USE_REAL_LOC_TIME = false;
    private static BaseImpl mImpl;

    /* JADX INFO: renamed from: com.bytedance.common.util.JellyBeanMR1V17Compat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class BaseImpl {
        private BaseImpl() {
        }

        public long getTime(Location r1) {
            return r1.getTime();
        }

        public String getWebViewDefaultUserAgent(Context r1) {
            return null;
        }

        public float getWebViewScale(WebView r1) {
            if (r1 != null) goto L10;
            return 1.0f;
        L10:
            return r1.getScale();
        L7:
            e = move-exception;
            e.printStackTrace();
            return 1.0f;
        }

        public void setMediaPlaybackRequiresUserGesture(WebSettings r1, boolean r2) {
        }

        public /* synthetic */ BaseImpl(AnonymousClass1 r1) {
            this();
        }
    }

    @TargetApi(17)
    public static class V17Impl extends BaseImpl {
        private V17Impl() {
            super(null);
        }

        @Override // com.bytedance.common.util.JellyBeanMR1V17Compat.BaseImpl
        public long getTime(Location r1) {
            return r1.getTime();
        }

        @Override // com.bytedance.common.util.JellyBeanMR1V17Compat.BaseImpl
        public String getWebViewDefaultUserAgent(Context r1) {
            return WebSettings.getDefaultUserAgent(r1);
        L4:
            th = move-exception;
            th.printStackTrace();
            return null;
        }

        @Override // com.bytedance.common.util.JellyBeanMR1V17Compat.BaseImpl
        public float getWebViewScale(WebView r1) {
            if (r1 != null) goto L10;
            return 1.0f;
        L10:
            return r1.getScale();
        L7:
            e = move-exception;
            e.printStackTrace();
            return 1.0f;
        }

        @Override // com.bytedance.common.util.JellyBeanMR1V17Compat.BaseImpl
        public void setMediaPlaybackRequiresUserGesture(WebSettings r1, boolean r2) {
            r1.setMediaPlaybackRequiresUserGesture(r2);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }

        public /* synthetic */ V17Impl(AnonymousClass1 r1) {
            this();
        }
    }

    static {
        mImpl = new V17Impl(null);
    }

    public JellyBeanMR1V17Compat() {
    }

    public static long getTime(Location r2) {
        return mImpl.getTime(r2);
    }

    public static String getWebViewDefaultUserAgent(Context r1) {
        return mImpl.getWebViewDefaultUserAgent(r1);
    }

    public static float getWebViewScale(WebView r1) {
        return mImpl.getWebViewScale(r1);
    }

    public static void setMediaPlaybackRequiresUserGesture(WebSettings r1, boolean r2) {
        mImpl.setMediaPlaybackRequiresUserGesture(r1, r2);
    }
}
