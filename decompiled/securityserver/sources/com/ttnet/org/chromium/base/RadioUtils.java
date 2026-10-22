package com.ttnet.org.chromium.base;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Process;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import androidx.annotation.RequiresApi;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import com.ttnet.org.chromium.base.compat.ApiHelperForP;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
public class RadioUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static Boolean sHaveAccessNetworkState;
    private static Boolean sHaveAccessWifiState;

    private RadioUtils() {
    }

    @RequiresApi(28)
    @CalledByNative
    private static int getCellDataActivity() {
        TraceEvent r0 = TraceEvent.scoped("RadioUtils::getCellDataActivity");
    L8:
        th = move-exception;
        if (r0 != null) goto L20;
    L19:
        throw th;
    L20:
        r0.close();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.addSuppressed(th);
        goto L19
    L24:
        int r1 = ((TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone")).getDataActivity();     // Catch: Throwable -> L8 SecurityException -> L10
        if (r0 == null) goto L7;
        r0.close();
    L7:
        return r1;
    L10:
        if (r0 == null) goto L25;
        r0.close();
        return -1;
    L25:
        return -1;
    }

    @RequiresApi(28)
    @CalledByNative
    private static int getCellSignalLevel() {
        TraceEvent r0 = TraceEvent.scoped("RadioUtils::getCellSignalLevel");
    L9:
        th = move-exception;
        if (r0 != null) goto L21;
    L19:
        throw th;
    L21:
        r0.close();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.addSuppressed(th);
        goto L19
    L4:
        int r2 = -1;
        SignalStrength r1 = ApiHelperForP.getSignalStrength((TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone"));     // Catch: Throwable -> L9 SecurityException -> L20
        if (r1 == null) goto L11;
        r2 = r1.getLevel();     // Catch: Throwable -> L9 SecurityException -> L20
    L11:
        if (r0 == null) goto L13;
        r0.close();
    L13:
        return r2;
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

    @CalledByNative
    private static boolean isSupported() {
        if (haveAccessNetworkState() == true) goto L5;
    L7:
        return false;
    L5:
        if (haveAccessWifiState() == false) goto L7;
        return true;
    }

    @RequiresApi(28)
    @CalledByNative
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
}
