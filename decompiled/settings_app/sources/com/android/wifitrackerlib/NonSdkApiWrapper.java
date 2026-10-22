package com.android.wifitrackerlib;

import android.app.admin.DevicePolicyManager;
import android.app.admin.WifiSsidPolicy;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.vcn.VcnTransportInfo;
import android.net.wifi.WifiInfo;
import android.os.UserManager;
import android.text.Annotation;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import androidx.core.os.BuildCompat;
import com.android.wifi.flags.Flags;

/* JADX INFO: loaded from: classes2.dex */
class NonSdkApiWrapper {
    private NonSdkApiWrapper() {
    }

    static void startCaptivePortalApp(ConnectivityManager r0, Network r1) {
        r0.startCaptivePortalApp(r1);
    }

    static CharSequence linkifyAnnotation(final Context r6, CharSequence r7, String r8, final String r9) {
        if (TextUtils.isEmpty(r9) == false) goto L5;
        return r7;
    L5:
        SpannableString r0 = new SpannableString(r7);
        int r3 = 0;
        Annotation[] r1 = (Annotation[]) r0.getSpans(0, r0.length(), Annotation.class);
        int r2 = r1.length;
    L6:
        if (r3 >= r2) goto L12;
        Annotation r4 = r1[r3];
        if (TextUtils.equals(r4.getValue(), r8) == true) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        SpannableStringBuilder r10 = new SpannableStringBuilder(r0);
        ClickableSpan r11 = new AnonymousClass1(r6, r9);
        r10.setSpan(r11, r0.getSpanStart(r4), r0.getSpanEnd(r4), r0.getSpanFlags(r11));
        return r10;
    L12:
        return r7;
    }

    static WifiInfo getWifiInfoIfVcn(NetworkCapabilities r1) {
        VcnTransportInfo r2 = r1.getTransportInfo();
        if ((r2 instanceof VcnTransportInfo) == true) goto L5;
        return null;
    L5:
        return r2.getWifiInfo();
    }

    static boolean isDemoMode(Context r0) {
        return UserManager.isDeviceInDemoMode(r0);
    }

    static boolean isPrimary(WifiInfo r0) {
        return r0.isPrimary();
    }

    static boolean isOemCapabilities(NetworkCapabilities r1) {
        if (r1.hasCapability(22) == false) goto L5;
    L8:
        return true;
    L5:
        if (r1.hasCapability(26) == true) goto L8;
        return false;
    }

    static WifiSsidPolicy getWifiSsidPolicy(DevicePolicyManager r1) {
        if (BuildCompat.isAtLeastT() == true) goto L5;
        return null;
    L5:
        return r1.getWifiSsidPolicy();
    }

    static boolean isNetworkProviderBatteryChargingStatusEnabled() {
        return Flags.networkProviderBatteryChargingStatus();
    }

    static boolean isAndroidVWifiApiEnabled() {
        return Flags.androidVWifiApi();
    }
}
