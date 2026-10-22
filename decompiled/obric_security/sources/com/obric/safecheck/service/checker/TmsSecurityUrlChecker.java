package com.obric.safecheck.service.checker;

import android.text.TextUtils;
import com.obric.olog.OLog;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import com.obric.security.safecheckapi.CheckResult;
import com.obric.securitycenter.api.GlobalManagerCreator;
import com.obric.securitycenter.api.ITmsUrlCheckManager;
import com.obric.securitycenter.api.UrlCheckResult;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TmsSecurityUrlChecker.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/safecheck/service/checker/TmsSecurityUrlChecker;", "Lcom/obric/safecheck/service/checker/UrlTmsSecurityChecker;", "()V", "check", "", "Lcom/obric/security/safecheckapi/CheckResult;", ApkVirusCheckProvider.KEY_RESULTS, "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class TmsSecurityUrlChecker implements UrlTmsSecurityChecker {
    public TmsSecurityUrlChecker() {
    }

    @Override // com.obric.safecheck.service.checker.UrlTmsSecurityChecker
    public List<CheckResult> check(List<CheckResult> r8) {
        Intrinsics.checkNotNullParameter(r8, ApkVirusCheckProvider.KEY_RESULTS);
        OLog.d("TmsSecurityUrlChecker", "check2");
        if (r8.isEmpty() == false) goto L5;
        OLog.d("TmsSecurityUrlChecker", "results is empty");
    L5:
        ITmsUrlCheckManager r7 = (ITmsUrlCheckManager) GlobalManagerCreator.INSTANCE.getManager(ITmsUrlCheckManager.class);
        Iterator<T> r1 = r8.iterator();
    L7:
        if (r1.hasNext() == false) goto L19;
        CheckResult r2 = (CheckResult) r1.next();
        if (TextUtils.isEmpty(r2.getThreatType()) == true) goto L10;
        OLog.d("TmsSecurityUrlChecker", "skip source=" + r2.getSource() + ", threatType=" + r2.getThreatType());
        goto L7
    L10:
        if (r7 == null) goto L14;
        UrlCheckResult r3 = r7.checkUrlSync(r2.getSource());
        if (r3 == null) goto L14;
        boolean r4 = r3.isHarm();
    L15:
        OLog.d("TmsSecurityUrlChecker", "checkUrlSync source=" + r2.getSource() + ", isHarm=" + r4);
        r2.setBlacklisted(r4);
        if (r4 == false) goto L7;
        r2.setThreatType(CheckResult.THREAT_VIRUS);
    L14:
        r4 = false;
        goto L15
    L19:
        return r8;
    }
}
