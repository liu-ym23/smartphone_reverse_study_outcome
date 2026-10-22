package com.android.settings.wifi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.Uri;
import android.os.Bundle;
import com.android.settings.SettingsApplication;
import com.android.settings.wifi.assistant.SecondaryNetworkCallback;
import com.obric.olog.OLog;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WIFIUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ \u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/settings/wifi/WIFIUtils;", "", "()V", "IS_SAFE_KEY", "", "QUERY_WIFI_SAFETY_FUNC", "SECURITY_WLAN_PROVIDER", "TAG", "getIpAddress", "isMain", "", "queryWifiSafe", "context", "Landroid/content/Context;", "ssid", WlanRiskInfo.EXTRA_BSSID, "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WIFIUtils {
    public static final WIFIUtils INSTANCE = null;
    private static final String IS_SAFE_KEY = "is_safe";
    private static final String QUERY_WIFI_SAFETY_FUNC = "query_wifi_safety";
    private static final String SECURITY_WLAN_PROVIDER = "content://com.obric.security.wlan.provider";
    private static final String TAG = "WIFIUtils";

    static {
        INSTANCE = new WIFIUtils();
    }

    private WIFIUtils() {
    }

    public final String getIpAddress(boolean r15) {
        Object r2 = "";
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L49
        WIFIUtils r14 = this;     // Catch: Throwable -> L49
        Object r16 = SettingsApplication.getContext().getSystemService("connectivity");     // Catch: Throwable -> L49
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type android.net.ConnectivityManager");     // Catch: Throwable -> L49
        ConnectivityManager r17 = (ConnectivityManager) r16;     // Catch: Throwable -> L49
        Network r4 = r17.getActiveNetwork();     // Catch: Throwable -> L49
        if (r15 == true) goto L7;
        r4 = SecondaryNetworkCallback.Companion.getNetwork();     // Catch: Throwable -> L49
    L7:
        LinkProperties r18 = r17.getLinkProperties(r4);     // Catch: Throwable -> L49
        if (r18 != null) goto L10;
        Object r19 = Result.m1508constructorimpl("");     // Catch: Throwable -> L49
    L51:
        Throwable r110 = Result.m1511exceptionOrNullimpl(r19);
        if (r110 == null) goto L55;
        OLog.e(TAG, "getIpAddress: ", r110);
    L55:
        if (Result.m1514isFailureimpl(r19) == true) goto L59;
        r2 = r19;
    L59:
        return (String) r2;
    L10:
        Intrinsics.checkNotNull(r18);     // Catch: Throwable -> L49
        List<LinkAddress> r111 = r18.getLinkAddresses();     // Catch: Throwable -> L49
        Intrinsics.checkNotNullExpressionValue(r111, "getLinkAddresses(...)");     // Catch: Throwable -> L49
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L49
        Iterator<T> r112 = r111.iterator();     // Catch: Throwable -> L49
    L12:
        if (r112.hasNext() == false) goto L16;
        Object r6 = r112.next();     // Catch: Throwable -> L49
        if ((((LinkAddress) r6).getAddress() instanceof Inet4Address) == false) goto L12;
        r5.add(r6);     // Catch: Throwable -> L49
        goto L12
    L16:
        ArrayList r7 = r5;     // Catch: Throwable -> L49
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));     // Catch: Throwable -> L49
        Iterator r8 = r7.iterator();     // Catch: Throwable -> L49
    L18:
        if (r8.hasNext() == false) goto L20;
        r113.add(((LinkAddress) r8.next()).getAddress());     // Catch: Throwable -> L49
        goto L18
    L20:
        String r114 = CollectionsKt.joinToString$default(r113, "\n", null, null, 0, null, WIFIUtils$getIpAddress$1$ipv4$3.INSTANCE, 30, null);     // Catch: Throwable -> L49
        List<LinkAddress> r115 = r18.getLinkAddresses();     // Catch: Throwable -> L49
        Intrinsics.checkNotNullExpressionValue(r115, "getLinkAddresses(...)");     // Catch: Throwable -> L49
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L49
        Iterator<T> r116 = r115.iterator();     // Catch: Throwable -> L49
    L22:
        if (r116.hasNext() == false) goto L26;
        Object r9 = r116.next();     // Catch: Throwable -> L49
        if ((((LinkAddress) r9).getAddress() instanceof Inet6Address) == false) goto L22;
        r1.add(r9);     // Catch: Throwable -> L49
        goto L22
    L26:
        ArrayList r10 = r1;     // Catch: Throwable -> L49
        ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));     // Catch: Throwable -> L49
        Iterator r11 = r10.iterator();     // Catch: Throwable -> L49
    L28:
        if (r11.hasNext() == false) goto L30;
        r117.add(((LinkAddress) r11.next()).getAddress());     // Catch: Throwable -> L49
        goto L28
    L30:
        String r118 = CollectionsKt.joinToString$default(r117, "\n", null, null, 0, null, WIFIUtils$getIpAddress$1$ipv6$3.INSTANCE, 30, null);     // Catch: Throwable -> L49
        boolean r12 = true;
        if (r114.length() <= 0) goto L33;
        boolean r0 = true;
    L34:
        if (r0 == false) goto L43;
        if (r118.length() <= 0) goto L38;
        boolean r13 = true;
    L39:
        if (r13 == false) goto L43;
        return r114 + '\n' + r118;
    L38:
        r13 = false;
    L43:
        if (r114.length() > 0) goto L46;
        r12 = false;
    L46:
        if (r12 == false) goto L48;
        return r114;
    L48:
        return r118;
    L33:
        r0 = false;
    L49:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r19 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L51
    }

    public final boolean queryWifiSafe(Context r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "ssid");
        Uri r0 = Uri.parse(SECURITY_WLAN_PROVIDER);
        Bundle r1 = new Bundle();
        r1.putString("ssid", r4);
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        r1.putString(WlanRiskInfo.EXTRA_BSSID, r5);
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L12
        Bundle r7 = r3.getContentResolver().call(r0, QUERY_WIFI_SAFETY_FUNC, null, r1);     // Catch: Throwable -> L12
        if (r7 == null) goto L9;
        boolean r8 = r7.getBoolean(IS_SAFE_KEY, true);     // Catch: Throwable -> L12
    L10:
        Object r9 = Result.m1508constructorimpl(Boolean.valueOf(r8));     // Catch: Throwable -> L12
    L14:
        Throwable r10 = Result.m1511exceptionOrNullimpl(r9);
        if (r10 == null) goto L18;
        OLog.e(TAG, "queryWifiSafe: ", r10);
    L18:
        if (Result.m1514isFailureimpl(r9) == false) goto L21;
        r9 = true;
    L21:
        return ((Boolean) r9).booleanValue();
    L9:
        r8 = true;
    L12:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L14
    }
}
