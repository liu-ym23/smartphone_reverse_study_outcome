package com.obric.security.devenvcheck;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.obric.olog.OLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WlanDisconnector.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/security/devenvcheck/WlanDisconnector;", "", "()V", "disconnectCurrent", "", "context", "Landroid/content/Context;", "devenvcheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class WlanDisconnector {
    public static final WlanDisconnector INSTANCE = null;

    static {
        INSTANCE = new WlanDisconnector();
    }

    private WlanDisconnector() {
    }

    public final void disconnectCurrent(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        WifiManager r6 = (WifiManager) r5.getApplicationContext().getSystemService(WifiManager.class);
        if (r6 != null) goto L21;
        OLog.w(WlanCheckResultProviderKt.WLAN_LOG_TAG, "WlanDisconnector: WifiManager unavailable");
        return;
    L21:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L15
        WlanDisconnector r4 = this;     // Catch: Throwable -> L15
        WifiInfo r7 = r6.getConnectionInfo();     // Catch: Throwable -> L15
        if (r7 == null) goto L9;
        int r8 = r7.getNetworkId();     // Catch: Throwable -> L15
    L10:
        if (r8 == (-1)) goto L12;
        OLog.d(WlanCheckResultProviderKt.WLAN_LOG_TAG, "WlanDisconnector: disableNetwork netId=" + r8 + ", result=" + r6.disableNetwork(r8));     // Catch: Throwable -> L15
    L13:
        r6.disconnect();     // Catch: Throwable -> L15
        OLog.d(WlanCheckResultProviderKt.WLAN_LOG_TAG, "WlanDisconnector: disconnect invoked");     // Catch: Throwable -> L15
        Object r9 = Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r10 = Result.m777exceptionOrNullimpl(r9);
        if (r10 == null) goto L23;
        OLog.w(WlanCheckResultProviderKt.WLAN_LOG_TAG, "WlanDisconnector: disconnect failed", r10);
        return;
    L23:
        return;
    L12:
        OLog.w(WlanCheckResultProviderKt.WLAN_LOG_TAG, "WlanDisconnector: invalid networkId, only disconnect");     // Catch: Throwable -> L15
        goto L13
    L9:
        r8 = -1;
    L15:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L17
    }
}
