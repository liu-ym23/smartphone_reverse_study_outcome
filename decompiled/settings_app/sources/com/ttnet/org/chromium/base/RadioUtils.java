package com.ttnet.org.chromium.base;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Process;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.android.settings.MultiSimAdapter;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import com.ttnet.org.chromium.base.compat.ApiHelperForP;

/* JADX INFO: loaded from: classes5.dex */
@JNINamespace("base::android")
public class RadioUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static Boolean sHaveAccessNetworkState;
    private static Boolean sHaveAccessWifiState;

    static {
    }

    private RadioUtils() {
    }

    private static boolean isSupported() {
        if (haveAccessNetworkState() == true) goto L5;
    L7:
        return false;
    L5:
        if (haveAccessWifiState() == false) goto L7;
        return true;
    }

    private static boolean haveAccessNetworkState() {
        if (sHaveAccessNetworkState != null) goto L10;
        if (ApiCompatibilityUtils.checkPermission(ContextUtils.getApplicationContext(), "android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) != 0) goto L7;
        boolean r0 = true;
    L8:
        sHaveAccessNetworkState = Boolean.valueOf(r0);
        goto L10
    L7:
        r0 = false;
    L10:
        return sHaveAccessNetworkState.booleanValue();
    }

    private static boolean haveAccessWifiState() {
        if (sHaveAccessWifiState != null) goto L10;
        if (ApiCompatibilityUtils.checkPermission(ContextUtils.getApplicationContext(), "android.permission.ACCESS_WIFI_STATE", Process.myPid(), Process.myUid()) != 0) goto L7;
        boolean r0 = true;
    L8:
        sHaveAccessWifiState = Boolean.valueOf(r0);
        goto L10
    L7:
        r0 = false;
    L10:
        return sHaveAccessWifiState.booleanValue();
    }

    private static boolean isWifiConnected() {
        TraceEvent r0 = TraceEvent.scoped("RadioUtils::isWifiConnected");
        ConnectivityManager r1 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");     // Catch: Throwable -> L19
        Network r2 = ApiHelperForM.getActiveNetwork(r1);     // Catch: Throwable -> L19
        if (r2 != null) goto L9;
        if (r0 == null) goto L8;
        r0.close();
    L8:
        return false;
    L9:
        NetworkCapabilities r3 = r1.getNetworkCapabilities(r2);     // Catch: Throwable -> L19
        if (r3 != null) goto L15;
        if (r0 == null) goto L13;
        r0.close();
    L13:
        return false;
    L15:
        boolean r4 = r3.hasTransport(1);     // Catch: Throwable -> L19
        if (r0 == null) goto L18;
        r0.close();
    L18:
        return r4;
    L19:
        th = move-exception;
        if (r0 != null) goto L28;
    L25:
        throw th;
    L28:
        r0.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.addSuppressed(th);
        goto L25
    }

    private static int getCellSignalLevel() {
        TraceEvent r0 = TraceEvent.scoped("RadioUtils::getCellSignalLevel");
    L12:
        th = move-exception;
        if (r0 != null) goto L22;
    L18:
        throw th;
    L22:
        r0.close();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.addSuppressed(th);
        goto L18
    L4:
        int r2 = -1;
        SignalStrength r1 = ApiHelperForP.getSignalStrength((TelephonyManager) ContextUtils.getApplicationContext().getSystemService(MultiSimAdapter.PHONE_KEY));     // Catch: SecurityException -> L19 Throwable -> L12
        if (r1 == null) goto L9;
        r2 = r1.getLevel();     // Catch: SecurityException -> L19 Throwable -> L12
        goto L9
    L9:
        if (r0 == null) goto L11;
        r0.close();
    L11:
        return r2;
    }

    private static int getCellDataActivity() {
        TraceEvent r0 = TraceEvent.scoped("RadioUtils::getCellDataActivity");
    L12:
        th = move-exception;
        if (r0 != null) goto L21;
    L18:
        throw th;
    L21:
        r0.close();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.addSuppressed(th);
        goto L18
    L23:
        int r1 = ((TelephonyManager) ContextUtils.getApplicationContext().getSystemService(MultiSimAdapter.PHONE_KEY)).getDataActivity();     // Catch: SecurityException -> L8 Throwable -> L12
        if (r0 == null) goto L7;
        r0.close();
    L7:
        return r1;
    L8:
        if (r0 == null) goto L24;
        r0.close();
        return -1;
    L24:
        return -1;
    }
}
