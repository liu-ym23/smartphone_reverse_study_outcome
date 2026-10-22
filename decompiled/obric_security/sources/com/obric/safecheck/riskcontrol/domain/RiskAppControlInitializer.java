package com.obric.safecheck.riskcontrol.domain;

import android.content.Context;
import android.util.Log;
import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import com.obric.safecheck.riskcontrol.api.model.RiskAppControlRecord;
import com.obric.safecheck.riskcontrol.api.model.RiskControlFlags;
import com.obric.safecheck.riskcontrol.api.model.RiskControlStatus;
import com.obric.safecheck.riskcontrol.api.repo.RiskAppControlRepository;
import com.obric.safecheck.riskcontrol.domain.settings.RiskControlSettingsSnapshotStore;
import com.obric.safecheck.riskcontrol.ui.RiskControlRuntimeDependencies;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: RiskAppControlInitializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0016\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013J>\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010J\u0006\u0010\u001a\u001a\u00020\nJ\u0006\u0010\u001b\u001a\u00020\nJ\b\u0010\u001c\u001a\u00020\nH\u0002R\u0016\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/safecheck/riskcontrol/domain/RiskAppControlInitializer;", "", "context", "Landroid/content/Context;", "repository", "Lcom/obric/safecheck/riskcontrol/api/repo/RiskAppControlRepository;", "(Landroid/content/Context;Lcom/obric/safecheck/riskcontrol/api/repo/RiskAppControlRepository;)V", "appContext", "kotlin.jvm.PlatformType", "enforceRecord", "", "record", "Lcom/obric/safecheck/riskcontrol/api/model/RiskAppControlRecord;", "isInstallationPackage", "", ApkVirusCheckProvider.KEY_PKG, "", "onPackageRemoved", AccountInfoBundleKey.USER_ID, "", "onRiskDetected", "appName", "riskType", "riskLevel", "riskDesc", "installIdentity", "reapplyControlledPolicies", "refreshPermissionSnapshot", "sweepOrphanRecords", "Companion", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class RiskAppControlInitializer {
    private static final Companion Companion = null;

    @Deprecated
    private static final String TAG = "RiskAppControlInit";
    private final Context appContext;
    private final Context context;
    private final RiskAppControlRepository repository;

    /* JADX INFO: compiled from: RiskAppControlInitializer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/safecheck/riskcontrol/domain/RiskAppControlInitializer$Companion;", "", "()V", "TAG", "", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RiskAppControlInitializer(Context r2, RiskAppControlRepository r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "repository");
        this.context = r2;
        this.repository = r3;
        this.appContext = r2.getApplicationContext();
    }

    public final void onRiskDetected(String r17, int r18, String r19, String r20, String r21, String r22, String r23) {
        Intrinsics.checkNotNullParameter(r17, ApkVirusCheckProvider.KEY_PKG);
        Intrinsics.checkNotNullParameter(r19, "appName");
        Intrinsics.checkNotNullParameter(r20, "riskType");
        Intrinsics.checkNotNullParameter(r21, "riskLevel");
        Intrinsics.checkNotNullParameter(r22, "riskDesc");
        Intrinsics.checkNotNullParameter(r23, "installIdentity");
        RiskAppControlRecord r1 = this.repository.get(r17, r18);
        RiskControlStatus r9 = RiskControlStatus.CONTROLLED;
        if (r1 == null) goto L10;
        Integer r10 = Integer.valueOf(r1.getControlFlags());
        if (RiskControlFlags.hasControlledItem(r10.intValue()) == true) goto L8;
        r10 = null;
    L8:
        if (r10 == null) goto L10;
        int r11 = r10.intValue();
    L11:
        if (r1 == null) goto L13;
        long r12 = r1.getCreatedAt();
    L14:
        RiskAppControlRecord r15 = new RiskAppControlRecord(r17, r18, r19, r20, r21, r22, r23, r9, r11, r12, 0);
        this.repository.upsert(r15);
        enforceRecord(r15);
        refreshPermissionSnapshot();
        return;
    L13:
        r12 = 0;
    L10:
        r11 = 127;
        goto L11
    }

    public final void reapplyControlledPolicies() {
        sweepOrphanRecords();
        List<RiskAppControlRecord> r0 = this.repository.listControlled();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        Object r3 = r2.next();
        if (((RiskAppControlRecord) r3).getControlStatus() != RiskControlStatus.CONTROLLED) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        r4 = false;
        goto L9
    L11:
        ArrayList r5 = new ArrayList();
        Iterator r6 = r1.iterator();
    L13:
        if (r6.hasNext() == false) goto L17;
        Object r7 = r6.next();
        if (RiskControlFlags.hasControlledItem(((RiskAppControlRecord) r7).getControlFlags()) == false) goto L13;
        r5.add(r7);
        goto L13
    L17:
        Iterator r8 = r5.iterator();
    L19:
        if (r8.hasNext() == false) goto L21;
        enforceRecord((RiskAppControlRecord) r8.next());
        goto L19
    L21:
        refreshPermissionSnapshot();
    }

    private final void sweepOrphanRecords() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        RiskAppControlInitializer r1 = this;     // Catch: Throwable -> L4
        Object r2 = Result.m774constructorimpl(this.repository.listAll());     // Catch: Throwable -> L4
    L7:
        if (Result.m780isFailureimpl(r2) == false) goto L9;
        r2 = null;
    L9:
        List r3 = (List) r2;
        if (r3 != null) goto L12;
        return;
    L12:
        Iterator r4 = r3.iterator();
    L14:
        if (r4.hasNext() == false) goto L27;
        RiskAppControlRecord r5 = (RiskAppControlRecord) r4.next();
        if (isInstallationPackage(r5.getPkg()) == true) goto L14;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L19
        RiskAppControlInitializer r7 = this;     // Catch: Throwable -> L19
        Function3<Context, String, Integer, Boolean> r8 = RiskControlRuntimeDependencies.INSTANCE.isPackageInstalled();     // Catch: Throwable -> L19
        Context r9 = this.appContext;     // Catch: Throwable -> L19
        Intrinsics.checkNotNullExpressionValue(r9, "appContext");     // Catch: Throwable -> L19
        Object r10 = Result.m774constructorimpl(Boolean.valueOf(r8.invoke(r9, r5.getPkg(), Integer.valueOf(r5.getUserId())).booleanValue()));     // Catch: Throwable -> L19
    L22:
        if (Result.m780isFailureimpl(r10) == false) goto L25;
        r10 = true;
    L25:
        if (((Boolean) r10).booleanValue() == true) goto L14;
        Log.w(TAG, "sweepOrphanRecords: removing orphan, pkg=" + r5.getPkg() + ", userId=" + r5.getUserId());
        onPackageRemoved(r5.getPkg(), r5.getUserId());
    L19:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r10 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L22
    L27:
        return;
    L4:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r2 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final boolean isInstallationPackage(String r5) {
        if (StringsKt.endsWith(r5, ".apk", true) == false) goto L10;
        if (StringsKt.startsWith$default(r5, "/sdcard", false, 2, null) == false) goto L7;
        return true;
    L7:
        if (StringsKt.startsWith$default(r5, "/storage/emulated", false, 2, null) == false) goto L10;
        return true;
    L10:
        return false;
    }

    public final void onPackageRemoved(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, ApkVirusCheckProvider.KEY_PKG);
        this.repository.delete(r3, r4);
        Context r0 = this.appContext;
        Intrinsics.checkNotNullExpressionValue(r0, "appContext");
        RiskControlSettingsSnapshotStore.releaseControlFlags(r0, r3, r4);
        refreshPermissionSnapshot();
    }

    public final void refreshPermissionSnapshot() {
        Context r0 = this.appContext;
        Intrinsics.checkNotNullExpressionValue(r0, "appContext");
        RiskControlSettingsSnapshotStore.refreshSnapshot(r0, this.repository.listControlled());
    }

    private final void enforceRecord(RiskAppControlRecord r4) {
        Function4<Context, String, Integer, Integer, Unit> r0 = RiskControlRuntimeDependencies.INSTANCE.getPolicyEnforcer();
        Context r3 = this.appContext;
        Intrinsics.checkNotNullExpressionValue(r3, "appContext");
        r0.invoke(r3, r4.getPkg(), Integer.valueOf(r4.getUserId()), Integer.valueOf(r4.getControlFlags()));
    }
}
