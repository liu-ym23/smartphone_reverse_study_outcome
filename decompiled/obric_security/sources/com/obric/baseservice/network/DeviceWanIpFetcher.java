package com.obric.baseservice.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.obric.netdetect.API.NetDetectConfig;
import com.obric.netdetect.API.NetDetectManager;
import com.obric.olog.OLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DeviceWanIpFetcher.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\b0\fH\u0007J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/baseservice/network/DeviceWanIpFetcher;", "", "()V", "TAG", "", "manager", "Lcom/obric/netdetect/API/NetDetectManager;", "fetchWanIp", "", "context", "Landroid/content/Context;", "callback", "Lkotlin/Function1;", "obtainManager", "appCtx", "parseWanIpFromToString", "text", "resolveDetectType", "", "baseservice_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class DeviceWanIpFetcher {
    public static final DeviceWanIpFetcher INSTANCE = null;
    private static final String TAG = "GbtCodeDict-DeviceWanIpFetcher";
    private static volatile NetDetectManager manager;

    static {
        INSTANCE = new DeviceWanIpFetcher();
    }

    private DeviceWanIpFetcher() {
    }

    public static final /* synthetic */ String access$parseWanIpFromToString(DeviceWanIpFetcher r0, String r1) {
        return r0.parseWanIpFromToString(r1);
    }

    @JvmStatic
    public static final void fetchWanIp(Context r5, final Function1<? super String, Unit> r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "callback");
        Context r7 = r5.getApplicationContext();
        DeviceWanIpFetcher r2 = INSTANCE;     // Catch: Throwable -> L10
        Intrinsics.checkNotNullExpressionValue(r7, "appCtx");     // Catch: Throwable -> L10
        NetDetectManager r3 = r2.obtainManager(r7);     // Catch: Throwable -> L10
        int r8 = r2.resolveDetectType(r7);
        OLog.d(TAG, "fetchWanIp start, type=" + r8);
        r3.detectNetworkInfo(r8, new AnonymousClass1(r6));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        OLog.e(TAG, "detectNetworkInfo throw", th);
        r6.invoke(null);
        return;
    L10:
        th = move-exception;
        OLog.e(TAG, "obtain NetDetectManager failed", th);
        r6.invoke(null);
    }

    private final String parseWanIpFromToString(String r12) {
        String r11 = r12;
        if (r11 != null) goto L5;
    L8:
        boolean r0 = true;
    L10:
        if (r0 == false) goto L12;
        return null;
    L12:
        Iterator r9 = CollectionsKt.listOf(new String[]{"WanIp：", "WanIp:", "wanIp：", "wanIp:"}).iterator();
    L14:
        if (r9.hasNext() == false) goto L34;
        String r10 = (String) r9.next();
        int r1 = StringsKt.indexOf$default(r11, r10, 0, false, 6, null);
        if (r1 < 0) goto L14;
        int r2 = r1 + r10.length();
        int r3 = r2;
    L19:
        if (r3 >= r12.length()) goto L26;
        char r4 = r12.charAt(r3);
        if (r4 == '\n') goto L26;
        if (r4 == '\r') goto L26;
        r3 = r3 + 1;
    L26:
        String r5 = r12.substring(r2, r3);
        Intrinsics.checkNotNullExpressionValue(r5, "this as java.lang.String…ing(startIndex, endIndex)");
        String r6 = StringsKt.trim(r5).toString();
        if (r6.length() <= 0) goto L29;
        boolean r7 = true;
    L30:
        if (r7 == false) goto L14;
        if ((!Intrinsics.areEqual(r6, "null")) == false) goto L14;
        return r6;
    L29:
        r7 = false;
        goto L30
    L34:
        return null;
    L5:
        if (r11.length() == 0) goto L8;
        r0 = false;
        goto L10
    }

    private final NetDetectManager obtainManager(Context r3) {
        NetDetectManager r0 = manager;
        if (r0 == null) goto L5;
        return r0;
    L5:
        monitor-enter(this);
        NetDetectManager r1 = manager;     // Catch: Throwable -> L13
        if (r1 == null) goto L10;
        monitor-exit(this);
        return r1;
    L10:
        NetDetectManager r2 = new NetDetectManager(r3, new NetDetectConfig.Builder().setLogLevel(2).build());     // Catch: Throwable -> L13
        manager = r2;     // Catch: Throwable -> L13
        monitor-exit(this);
        return r2;
    L13:
        th = move-exception;
        throw th;
    }

    private final int resolveDetectType(Context r3) {
        Object r4 = r3.getSystemService("connectivity");     // Catch: Throwable -> L24
        if ((r4 instanceof ConnectivityManager) == true) goto L6;
        r4 = null;
    L6:
        ConnectivityManager r5 = (ConnectivityManager) r4;     // Catch: Throwable -> L24
        if (r5 != null) goto L9;
        return 0;
    L9:
        Network r0 = r5.getActiveNetwork();     // Catch: Throwable -> L24
        if (r0 != null) goto L12;
        return 0;
    L12:
        Intrinsics.checkNotNullExpressionValue(r0, "cm.activeNetwork ?: retu…t.NET_DETECT_TYPE_UNKNOWN");     // Catch: Throwable -> L24
        NetworkCapabilities r6 = r5.getNetworkCapabilities(r0);     // Catch: Throwable -> L24
        if (r6 != null) goto L15;
        return 0;
    L15:
        Intrinsics.checkNotNullExpressionValue(r6, "cm.getNetworkCapabilitie…t.NET_DETECT_TYPE_UNKNOWN");     // Catch: Throwable -> L24
        int r1 = 1;
        if (r6.hasTransport(1) == false) goto L19;
    L29:
        return r1;
    L19:
        if (r6.hasTransport(0) == true) goto L30;
        r1 = 3;
        if (r6.hasTransport(3) == true) goto L29;
        return 0;
    L30:
        return 2;
    L24:
        th = move-exception;
        OLog.e(TAG, "resolveDetectType throw", th);
        return 0;
    }
}
