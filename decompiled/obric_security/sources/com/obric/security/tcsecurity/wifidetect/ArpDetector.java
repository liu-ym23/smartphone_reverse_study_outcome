package com.obric.security.tcsecurity.wifidetect;

import com.obric.olog.OLog;
import com.obric.securitycenter.api.WifiDetectResult;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tmsdk.bg.module.wifidetect.WifiDetectManager;

/* JADX INFO: compiled from: WifiDetectors.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/security/tcsecurity/wifidetect/ArpDetector;", "Lcom/obric/security/tcsecurity/wifidetect/WifiDetector;", "()V", "detect", "", "mgr", "Ltmsdk/bg/module/wifidetect/WifiDetectManager;", "timeoutMillis", "", "result", "Lcom/obric/securitycenter/api/WifiDetectResult;", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class ArpDetector implements WifiDetector {
    private static final int ARP_FAKE = 262;
    public static final Companion Companion = null;
    private static final String TAG = "ArpDetector";

    /* JADX INFO: compiled from: WifiDetectors.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/security/tcsecurity/wifidetect/ArpDetector$Companion;", "", "()V", "ARP_FAKE", "", "TAG", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ArpDetector() {
    }

    @Override // com.obric.security.tcsecurity.wifidetect.WifiDetector
    public boolean detect(WifiDetectManager r3, long r4, WifiDetectResult r6) {
        Intrinsics.checkNotNullParameter(r3, "mgr");
        Intrinsics.checkNotNullParameter(r6, "result");
        OLog.d(TAG, "detect start, timeout=" + r4);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        ArpDetector r2 = this;     // Catch: Throwable -> L5
        Object r5 = Result.m774constructorimpl(Integer.valueOf(r3.detectARPNoRoot(r4)));     // Catch: Throwable -> L5
    L7:
        Throwable r7 = Result.m777exceptionOrNullimpl(r5);
        if (r7 == null) goto L11;
        OLog.w(TAG, "detectARPNoRoot failed", r7);
        r5 = -1;
    L11:
        int r8 = ((Number) r5).intValue();
        r6.setArpResult(r8);
        OLog.i(TAG, "detect result code=" + r8);
        if (r8 != 262) goto L15;
        r6.setMessage("arp_risk:" + r8);
        OLog.w(TAG, "risk hit: arp_risk:" + r8);
        return true;
    L15:
        return false;
    L5:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r5 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
