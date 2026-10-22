package com.obric.security.tcsecurity.wifidetect;

import com.obric.olog.OLog;
import com.obric.securitycenter.api.ITmsWifiDetectManager;
import com.obric.securitycenter.api.WifiDetectResult;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import tmsdk.bg.creator.ManagerCreatorB;
import tmsdk.bg.module.wifidetect.WifiDetectManager;

/* JADX INFO: compiled from: TmsWifiDetectManagerImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/security/tcsecurity/wifidetect/TmsWifiDetectManagerImpl;", "Lcom/obric/securitycenter/api/ITmsWifiDetectManager;", "()V", "TAG", "", "detectors", "", "Lcom/obric/security/tcsecurity/wifidetect/WifiDetector;", "wifiDetectManager", "Ltmsdk/bg/module/wifidetect/WifiDetectManager;", "detectCurrentWifi", "Lcom/obric/securitycenter/api/WifiDetectResult;", "timeoutMillis", "", "ensureManager", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class TmsWifiDetectManagerImpl implements ITmsWifiDetectManager {
    public static final TmsWifiDetectManagerImpl INSTANCE = null;
    private static final String TAG = "TmsWifiDetectManagerImpl";
    private static final List<WifiDetector> detectors = null;
    private static WifiDetectManager wifiDetectManager;

    static {
        INSTANCE = new TmsWifiDetectManagerImpl();
        detectors = CollectionsKt.listOf(new WifiDetector[]{new DnsAndPhishingDetector(), new ArpDetector()});
    }

    private TmsWifiDetectManagerImpl() {
    }

    @Override // com.obric.securitycenter.api.ITmsWifiDetectManager
    public WifiDetectResult detectCurrentWifi(long r18) {
        WifiDetectManager r2 = ensureManager();
        if (r2 == null) goto L5;
        WifiDetectResult r3 = new WifiDetectResult(0, 0, 0, null, 15, null);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        TmsWifiDetectManagerImpl r1 = this;     // Catch: Throwable -> L9
        Object r4 = Result.m774constructorimpl(Integer.valueOf(r2.init()));     // Catch: Throwable -> L9
    L11:
        Throwable r5 = Result.m777exceptionOrNullimpl(r4);
        if (r5 == null) goto L42;
        OLog.w(TAG, "WifiDetectManager init failed", r5);
    L42:
        Iterator<WifiDetector> r6 = detectors.iterator();     // Catch: Throwable -> L28
    L16:
        if (r6.hasNext() == false) goto L40;
        WifiDetector r7 = r6.next();     // Catch: Throwable -> L28
        if (r7.detect(r2, r18, r3) == false) goto L16;
        OLog.w(TAG, "risk hit by " + r7.getClass().getSimpleName() + ", message=" + r3.getMessage());     // Catch: Throwable -> L28
    L40:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L22
        TmsWifiDetectManagerImpl r9 = this;     // Catch: Throwable -> L22
        Object r10 = Result.m774constructorimpl(Integer.valueOf(r2.free()));     // Catch: Throwable -> L22
    L24:
        Throwable r11 = Result.m777exceptionOrNullimpl(r10);
        if (r11 == null) goto L27;
        OLog.w(TAG, "WifiDetectManager free failed", r11);
    L27:
        return r3;
    L22:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.m774constructorimpl(ResultKt.createFailure(th));
    L28:
        th = move-exception;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L32
        Object r14 = Result.m774constructorimpl(Integer.valueOf(r2.free()));     // Catch: Throwable -> L32
    L34:
        Throwable r15 = Result.m777exceptionOrNullimpl(r14);
        if (r15 == null) goto L48;
        OLog.w(TAG, "WifiDetectManager free failed", r15);
        throw th;
    L48:
        throw th;
    L32:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.m774constructorimpl(ResultKt.createFailure(th));
    L9:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r4 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L11
    L5:
        return new WifiDetectResult(0, 0, 0, "tms_wifi_detect_unavailable", 7, null);
    }

    private final WifiDetectManager ensureManager() {
        WifiDetectManager r0 = wifiDetectManager;
        if (r0 == null) goto L15;
        return r0;
    L15:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        TmsWifiDetectManagerImpl r2 = this;     // Catch: Throwable -> L7
        Object r3 = Result.m774constructorimpl((WifiDetectManager) ManagerCreatorB.getManager(WifiDetectManager.class));     // Catch: Throwable -> L7
    L9:
        Throwable r4 = Result.m777exceptionOrNullimpl(r3);
        if (r4 == null) goto L13;
        OLog.w(TAG, "getManager WifiDetectManager failed", r4);
        r3 = null;
    L13:
        WifiDetectManager r5 = (WifiDetectManager) r3;
        wifiDetectManager = r5;
        return r5;
    L7:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r3 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L9
    }
}
