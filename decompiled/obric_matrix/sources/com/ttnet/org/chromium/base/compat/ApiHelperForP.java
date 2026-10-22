package com.ttnet.org.chromium.base.compat;

import android.content.ClipboardManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.LinkProperties;
import android.os.LocaleList;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.view.textclassifier.TextClassifier;
import android.view.textclassifier.TextSelection;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(28)
public final class ApiHelperForP {
    private ApiHelperForP() {
    }

    public static TextSelection.Request build(TextSelection.Request.Builder r0) {
        return r0.build();
    }

    public static void clearPrimaryClip(ClipboardManager r0) {
    }

    public static long getLongVersionCode(PackageInfo r2) {
        return r2.getLongVersionCode();
    }

    public static String getPrivateDnsServerName(LinkProperties r0) {
        return r0.getPrivateDnsServerName();
    }

    public static SignalStrength getSignalStrength(TelephonyManager r0) {
        return r0.getSignalStrength();
    }

    public static boolean hasSigningCertificate(PackageManager r0, String r1, byte[] r2, int r3) {
        return r0.hasSigningCertificate(r1, r2, r3);
    }

    public static boolean isLocationEnabled(LocationManager r0) {
        return r0.isLocationEnabled();
    }

    public static boolean isPrivateDnsActive(LinkProperties r0) {
        return r0.isPrivateDnsActive();
    }

    public static TextSelection.Request.Builder newTextSelectionRequestBuilder(CharSequence r1, int r2, int r3) {
        return new TextSelection.Request.Builder(r1, r2, r3);
    }

    public static TextSelection.Request.Builder setDefaultLocales(TextSelection.Request.Builder r0, LocaleList r1) {
        return r0.setDefaultLocales(r1);
    }

    public static TextSelection suggestSelection(TextClassifier r0, TextSelection.Request r1) {
        return r0.suggestSelection(r1);
    }
}
