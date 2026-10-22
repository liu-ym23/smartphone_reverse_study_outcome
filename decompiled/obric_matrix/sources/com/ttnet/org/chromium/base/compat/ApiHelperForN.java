package com.ttnet.org.chromium.base.compat;

import android.app.Activity;
import android.app.Notification;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ClipData;
import android.content.ComponentName;
import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.net.ConnectivityManager;
import android.os.Process;
import android.security.NetworkSecurityPolicy;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RemoteViews;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(24)
public final class ApiHelperForN {
    private ApiHelperForN() {
    }

    public static PointerIcon createPointerIcon(Bitmap r0, float r1, float r2) {
        return PointerIcon.create(r0, r1, r2);
    }

    public static JobInfo getPendingJob(JobScheduler r0, int r1) {
        return r0.getPendingJob(r1);
    }

    public static int getRestrictBackgroundStatus(ConnectivityManager r0) {
        return r0.getRestrictBackgroundStatus();
    }

    public static long getStartUptimeMillis() {
        return Process.getStartUptimeMillis();
    }

    public static boolean isCleartextTrafficPermitted(String r1) {
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(r1);
    }

    public static PointerIcon onResolvePointerIcon(View r0, MotionEvent r1, int r2) {
        return r0.onResolvePointerIcon(r1, r2);
    }

    public static void setCryptoInfoPattern(MediaCodec.CryptoInfo r1, int r2, int r3) {
        r1.setPattern(new MediaCodec.CryptoInfo.Pattern(r2, r3));
    }

    public static Notification.Builder setCustomBigContentView(Notification.Builder r0, RemoteViews r1) {
        return r0.setCustomBigContentView(r1);
    }

    public static Notification.Builder setCustomContentView(Notification.Builder r0, RemoteViews r1) {
        return r0.setCustomContentView(r1);
    }

    public static void setPointerIcon(View r0, PointerIcon r1) {
        r0.setPointerIcon(r1);
    }

    public static void setVrModeEnabled(Activity r0, boolean r1, ComponentName r2) {
        r0.setVrModeEnabled(r1, r2);
    }

    public static boolean shouldOverrideUrlLoading(WebViewClient r0, WebView r1, WebResourceRequest r2) {
        return r0.shouldOverrideUrlLoading(r1, r2);
    }

    public static boolean startDragAndDrop(View r0, ClipData r1, View.DragShadowBuilder r2, Object r3, int r4) {
        return r0.startDragAndDrop(r1, r2, r3, r4);
    }
}
