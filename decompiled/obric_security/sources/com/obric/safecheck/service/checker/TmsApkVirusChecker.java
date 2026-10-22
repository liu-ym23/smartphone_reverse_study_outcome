package com.obric.safecheck.service.checker;

import com.obric.olog.OLog;
import com.obric.security.safecheckapi.ApkInfo;
import com.obric.security.safecheckapi.CheckResult;
import com.obric.securitycenter.api.GlobalManagerCreator;
import com.obric.securitycenter.api.ITmsApkCheckManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TmsApkVirusChecker.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/safecheck/service/checker/TmsApkVirusChecker;", "Lcom/obric/safecheck/service/checker/ApkVirusChecker;", "()V", "checkByInfo", "", "Lcom/obric/security/safecheckapi/CheckResult;", "apkInfo", "Lcom/obric/security/safecheckapi/ApkInfo;", "checkByPath", "apkPath", "", "Companion", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class TmsApkVirusChecker implements ApkVirusChecker {
    public static final Companion Companion = null;
    private static final long SCAN_TIMEOUT_MILLIS = 3000;

    /* JADX INFO: compiled from: TmsApkVirusChecker.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/safecheck/service/checker/TmsApkVirusChecker$Companion;", "", "()V", "SCAN_TIMEOUT_MILLIS", "", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
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

    public TmsApkVirusChecker() {
    }

    @Override // com.obric.safecheck.service.checker.ApkVirusChecker
    public List<CheckResult> checkByPath(String r12) {
        OLog.d("TmsApkVirusChecker", "checkByPath");
        String r0 = r12;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        final ArrayList r2 = new ArrayList();
        final CountDownLatch r3 = new CountDownLatch(1);
        ITmsApkCheckManager r5 = (ITmsApkCheckManager) GlobalManagerCreator.INSTANCE.getManager(ITmsApkCheckManager.class);
        if (r5 == null) goto L16;
        r5.scanUninstallApks(CollectionsKt.mutableListOf(new String[]{r12}), new AnonymousClass1(r2, r3), false, 3000);
        r3.await(3000, TimeUnit.MILLISECONDS);
        return r2;
    L16:
        r3.countDown();
        return CollectionsKt.emptyList();
    L11:
        return CollectionsKt.emptyList();
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.obric.safecheck.service.checker.ApkVirusChecker
    public List<CheckResult> checkByInfo(ApkInfo r1) {
        return CollectionsKt.emptyList();
    }
}
