package com.obric.safecheck.riskcontrol.domain;

import android.content.Context;
import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import com.obric.safecheck.riskcontrol.api.model.RiskInstallSource;
import com.obric.safecheck.riskcontrol.api.repo.RiskAppControlRepository;
import com.obric.safecheck.riskcontrol.ui.RiskControlRuntimeDependencies;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RiskControlEntryPoints.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0007JR\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/safecheck/riskcontrol/domain/RiskControlEntryPoints;", "", "()V", "TAG", "", "createInitializer", "Lcom/obric/safecheck/riskcontrol/domain/RiskAppControlInitializer;", "context", "Landroid/content/Context;", "onPackageRemoved", "", ApkVirusCheckProvider.KEY_PKG, AccountInfoBundleKey.USER_ID, "", "onRiskDetected", "appName", "riskType", "riskLevel", "riskDesc", "installIdentity", "installSource", "Lcom/obric/safecheck/riskcontrol/api/model/RiskInstallSource;", "reapplyControlledPolicies", "refreshPermissionSnapshot", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class RiskControlEntryPoints {
    public static final RiskControlEntryPoints INSTANCE = null;
    private static final String TAG = "RiskControlEntryPoints";

    @JvmStatic
    public static final void onRiskDetected(Context r11, String r12, int r13, String r14, String r15, String r16, String r17, String r18) {
        onRiskDetected$default(r11, r12, r13, r14, r15, r16, r17, r18, null, 256, null);
    }

    static {
        INSTANCE = new RiskControlEntryPoints();
    }

    private RiskControlEntryPoints() {
    }

    public static /* synthetic */ void onRiskDetected$default(Context r10, String r11, int r12, String r13, String r14, String r15, String r16, String r17, RiskInstallSource r18, int r19, Object r20) {
        if ((r19 & 256) == 0) goto L5;
        RiskInstallSource r9 = RiskInstallSource.UNKNOWN;
    L6:
        onRiskDetected(r10, r11, r12, r13, r14, r15, r16, r17, r9);
        return;
    L5:
        r9 = r18;
        goto L6
    }

    @JvmStatic
    public static final void onRiskDetected(Context r10, String r11, int r12, String r13, String r14, String r15, String r16, String r17, RiskInstallSource r18) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, ApkVirusCheckProvider.KEY_PKG);
        Intrinsics.checkNotNullParameter(r13, "appName");
        Intrinsics.checkNotNullParameter(r14, "riskType");
        Intrinsics.checkNotNullParameter(r15, "riskLevel");
        Intrinsics.checkNotNullParameter(r16, "riskDesc");
        Intrinsics.checkNotNullParameter(r17, "installIdentity");
        Intrinsics.checkNotNullParameter(r18, "installSource");
        INSTANCE.createInitializer(r10).onRiskDetected(r11, r12, r13, r14, r15, r16, r17);
        RiskControlRuntimeDependencies.ensureProcessObserverActive(r10);
    }

    @JvmStatic
    public static final void onPackageRemoved(Context r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, ApkVirusCheckProvider.KEY_PKG);
        INSTANCE.createInitializer(r1).onPackageRemoved(r2, r3);
    }

    @JvmStatic
    public static final void refreshPermissionSnapshot(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        INSTANCE.createInitializer(r1).refreshPermissionSnapshot();
    }

    @JvmStatic
    public static final void reapplyControlledPolicies(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        INSTANCE.createInitializer(r1).reapplyControlledPolicies();
    }

    private final RiskAppControlInitializer createInitializer(Context r2) {
        Context r1 = r2.getApplicationContext();
        Function1<Context, RiskAppControlRepository> r3 = RiskControlRuntimeDependencies.INSTANCE.getRepositoryFactory();
        Intrinsics.checkNotNullExpressionValue(r1, "appContext");
        return new RiskAppControlInitializer(r1, r3.invoke(r1));
    }
}
