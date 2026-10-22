package com.ttnet.org.chromium.base.compat;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.PictureInPictureParams;
import android.app.Service;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.view.Display;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextLinks;
import android.view.textclassifier.TextSelection;
import com.android.vcard.VCardConfig;
import com.ttnet.org.chromium.base.ApiCompatibilityUtils;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.Log;

/* JADX INFO: loaded from: classes5.dex */
public final class ApiHelperForS {
    private static final String TAG = "ApiHelperForS";

    public static int getPendingIntentMutableFlag() {
        return VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING;
    }

    private ApiHelperForS() {
    }

    public static boolean isStyleText(ClipDescription r0) {
        return r0.isStyledText();
    }

    public static float getConfidenceScore(ClipDescription r0, String r1) {
        return r0.getConfidenceScore(r1);
    }

    public static boolean isGetClassificationStatusIsComplete(ClipDescription r1) {
        if (r1.getClassificationStatus() != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public static TextLinks getTextLinks(ClipData.Item r0) {
        return r0.getTextLinks();
    }

    public static boolean hasBluetoothConnectPermission() {
        if (ApiCompatibilityUtils.checkPermission(ContextUtils.getApplicationContext(), "android.permission.BLUETOOTH_CONNECT", Process.myPid(), Process.myUid()) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static void setAutoEnterEnabled(PictureInPictureParams.Builder r0, boolean r1) {
        r0.setAutoEnterEnabled(r1);
    }

    public static TextSelection.Request.Builder setIncludeTextClassification(TextSelection.Request.Builder r0, boolean r1) {
        return r0.setIncludeTextClassification(r1);
    }

    public static TextClassification getTextClassification(TextSelection r0) {
        return r0.getTextClassification();
    }

    public static Context createWindowContext(Context r0, Display r1, int r2, Bundle r3) {
        return r0.createWindowContext(r1, r2, r3);
    }

    public static void startForeground(Service r1, int r2, Notification r3, int r4) {
        r1.startForeground(r2, r3, r4);     // Catch: ForegroundServiceStartNotAllowedException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "Cannot run service as foreground: " + e + " for notification channel " + r3.getChannelId() + " notification id " + r2, new Object[0]);
    }
}
