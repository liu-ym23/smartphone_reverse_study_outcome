package com.obric.devenvcheck.checker;

import com.obric.olog.OLog;
import com.obric.security.devenvcheck.WlanCheckResultProviderKt;
import com.obric.securitycenter.api.GlobalManagerCreator;
import com.obric.securitycenter.api.ITmsWifiDetectManager;
import com.obric.securitycenter.api.WifiDetectResult;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TmsWifiSecurityChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\f\u0010\u0005\u001a\u00020\u0004*\u00020\u0006H\u0002¨\u0006\b"}, d2 = {"Lcom/obric/devenvcheck/checker/TmsWifiSecurityChecker;", "Lcom/obric/devenvcheck/checker/WifiSecurityChecker;", "()V", "checkCurrentWifi", "Lcom/obric/devenvcheck/checker/WifiSecurityCheckResult;", "toCheckResult", "Lcom/obric/securitycenter/api/WifiDetectResult;", "Companion", "devenvcheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class TmsWifiSecurityChecker implements WifiSecurityChecker {
    private static final int ARP_FAKE = 262;
    private static final int CLOUND_CHECK_DNS_FAKE = 18;
    private static final int CLOUND_CHECK_PHISHING_FAKE = 19;
    public static final Companion Companion = null;
    private static final String RISK_ARP_ATTACK = "arp_attack";
    private static final String RISK_DNS_HIJACK = "dns_hijack";
    private static final String RISK_PHISHING_WIFI = "phishing_wifi";
    private static final String RISK_SSLSTRIP_ATTACK = "sslstrip_attack";
    private static final int SSLSTRIP_ATTACK = 272;

    /* JADX INFO: compiled from: TmsWifiSecurityChecker.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/devenvcheck/checker/TmsWifiSecurityChecker$Companion;", "", "()V", "ARP_FAKE", "", "CLOUND_CHECK_DNS_FAKE", "CLOUND_CHECK_PHISHING_FAKE", "RISK_ARP_ATTACK", "", "RISK_DNS_HIJACK", "RISK_PHISHING_WIFI", "RISK_SSLSTRIP_ATTACK", "SSLSTRIP_ATTACK", "devenvcheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
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

    public TmsWifiSecurityChecker() {
    }

    @Override // com.obric.devenvcheck.checker.WifiSecurityChecker
    public WifiSecurityCheckResult checkCurrentWifi() {
        ITmsWifiDetectManager r0 = (ITmsWifiDetectManager) GlobalManagerCreator.INSTANCE.getManager(ITmsWifiDetectManager.class);
        if (r0 == null) goto L5;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        TmsWifiSecurityChecker r2 = this;     // Catch: Throwable -> L8
        Object r3 = Result.m774constructorimpl(ITmsWifiDetectManager.DefaultImpls.detectCurrentWifi$default(r0, 0, 1, null));     // Catch: Throwable -> L8
    L10:
        Throwable r4 = Result.m777exceptionOrNullimpl(r3);
        if (r4 == null) goto L18;
        OLog.w(WlanCheckResultProviderKt.WLAN_LOG_TAG, "TmsWifiSecurityChecker: detectCurrentWifi failed", r4);
        String r5 = r4.getMessage();
        if (r5 != null) goto L16;
        r5 = "detect_failed";
    L16:
        r3 = new WifiDetectResult(0, 0, 0, r5, 7, null);
    L18:
        return toCheckResult((WifiDetectResult) r3);
    L8:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r3 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L10
    L5:
        return new WifiSecurityCheckResult(false, CollectionsKt.listOf("wifi_manager_not_registered"), null, 4, null);
    }

    private final WifiSecurityCheckResult toCheckResult(WifiDetectResult r3) {
        ArrayList r2 = new ArrayList();
        int r0 = r3.getDnsAndPhishingResult();
        if (r0 != 18) goto L5;
        r2.add(RISK_DNS_HIJACK);
    L10:
        if (r3.getArpResult() != 262) goto L13;
        r2.add(RISK_ARP_ATTACK);
    L13:
        if (r3.getSslStripResult() != 272) goto L16;
        r2.add(RISK_SSLSTRIP_ATTACK);
    L16:
        return new WifiSecurityCheckResult(r2.isEmpty(), r2, r3);
    L5:
        if (r0 != 19) goto L10;
        r2.add(RISK_PHISHING_WIFI);
        goto L10
    }
}
