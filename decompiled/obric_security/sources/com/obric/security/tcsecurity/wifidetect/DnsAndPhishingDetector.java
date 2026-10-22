package com.obric.security.tcsecurity.wifidetect;

import com.obric.olog.OLog;
import com.obric.securitycenter.api.WifiDetectResult;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import tmsdk.bg.module.wifidetect.WifiDetectManager;

/* JADX INFO: compiled from: WifiDetectors.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u000e"}, d2 = {"Lcom/obric/security/tcsecurity/wifidetect/DnsAndPhishingDetector;", "Lcom/obric/security/tcsecurity/wifidetect/WifiDetector;", "()V", "detect", "", "mgr", "Ltmsdk/bg/module/wifidetect/WifiDetectManager;", "timeoutMillis", "", "result", "Lcom/obric/securitycenter/api/WifiDetectResult;", "detectSync", "", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class DnsAndPhishingDetector implements WifiDetector {
    private static final int CLOUND_CHECK_NO_FAKE = 17;
    public static final Companion Companion = null;
    private static final String TAG = "DnsAndPhishingDetector";

    /* JADX INFO: compiled from: WifiDetectors.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/security/tcsecurity/wifidetect/DnsAndPhishingDetector$Companion;", "", "()V", "CLOUND_CHECK_NO_FAKE", "", "TAG", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
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

    public DnsAndPhishingDetector() {
    }

    @Override // com.obric.security.tcsecurity.wifidetect.WifiDetector
    public boolean detect(WifiDetectManager r3, long r4, WifiDetectResult r6) {
        Intrinsics.checkNotNullParameter(r3, "mgr");
        Intrinsics.checkNotNullParameter(r6, "result");
        OLog.d(TAG, "detect start, timeout=" + r4);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        DnsAndPhishingDetector r1 = this;     // Catch: Throwable -> L5
        Object r2 = Result.m774constructorimpl(Integer.valueOf(detectSync(r3, r4)));     // Catch: Throwable -> L5
    L7:
        Throwable r5 = Result.m777exceptionOrNullimpl(r2);
        if (r5 == null) goto L11;
        OLog.w(TAG, "detectDnsAndPhishing failed", r5);
        r2 = -1;
    L11:
        int r7 = ((Number) r2).intValue();
        r6.setDnsAndPhishingResult(r7);
        OLog.i(TAG, "detect result code=" + r7);
        if (r7 != 18) goto L14;
    L18:
        r6.setMessage("dns_or_phishing_risk:" + r7);
        OLog.w(TAG, "risk hit: dns_or_phishing_risk:" + r7);
        return true;
    L14:
        if (r7 == 19) goto L18;
        return false;
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r2 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final int detectSync(WifiDetectManager r5, long r6) {
        final Object r0 = new Object();
        final Ref.IntRef r1 = new Ref.IntRef();
        r1.element = -1;
        final Ref.BooleanRef r2 = new Ref.BooleanRef();
        r2.element = false;
        r5.detectDnsAndPhishing(new AnonymousClass1(r0, r1, r2), r6);
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (r2.element == true) goto L8;
        r0.wait(r6);     // Catch: Throwable -> L14
    L8:
        if (r2.element == true) goto L10;
        OLog.w(TAG, "detectDnsAndPhishing timeout after " + r6 + "ms");     // Catch: Throwable -> L14
    L10:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r0);
        return r1.element;
    }
}
