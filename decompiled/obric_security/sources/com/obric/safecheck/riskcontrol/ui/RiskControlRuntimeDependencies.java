package com.obric.safecheck.riskcontrol.ui;

import android.content.Context;
import android.util.Log;
import com.obric.safecheck.database.dao.VirusApkDao;
import com.obric.safecheck.riskcontrol.api.repo.RiskAppControlRepository;
import com.obric.safecheck.riskcontrol.api.repo.ScanResultRepository;
import com.obric.safecheck.riskcontrol.domain.usecase.ApplyRiskControlUseCase;
import com.obric.safecheck.riskcontrol.domain.usecase.LoadRiskAppsUseCase;
import com.obric.safecheck.riskcontrol.domain.usecase.PersistScanResultsUseCase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: RiskControlRuntimeDependencies.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010M\u001a\u0002062\u0006\u0010N\u001a\u00020\u0006J\u0010\u0010O\u001a\u0002062\u0006\u0010N\u001a\u00020\u0006H\u0007J\u0010\u0010P\u001a\u00020B2\u0006\u0010N\u001a\u00020\u0006H\u0002J\u0006\u0010Q\u001a\u000206R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R,\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R2\u0010)\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020*0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\f\"\u0004\b+\u0010\u000eR&\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-0\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0013\"\u0004\b/\u0010\u0015R&\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0013\"\u0004\b3\u0010\u0015R8\u00104\u001a \u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020605X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R8\u0010;\u001a \u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020605X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00108\"\u0004\b=\u0010:R&\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002060\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0013\"\u0004\b@\u0010\u0015R&\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020B0\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0013\"\u0004\bD\u0010\u0015R&\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020F0\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0013\"\u0004\bH\u0010\u0015R&\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020J0\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0013\"\u0004\bL\u0010\u0015¨\u0006R"}, d2 = {"Lcom/obric/safecheck/riskcontrol/ui/RiskControlRuntimeDependencies;", "", "()V", "TAG", "", "appContextHolder", "Landroid/content/Context;", "appInfoResolver", "Lkotlin/Function3;", "", "Lcom/obric/safecheck/riskcontrol/ui/RiskAppUiInfo;", "getAppInfoResolver", "()Lkotlin/jvm/functions/Function3;", "setAppInfoResolver", "(Lkotlin/jvm/functions/Function3;)V", "applyRiskControlUseCaseFactory", "Lkotlin/Function1;", "Lcom/obric/safecheck/riskcontrol/domain/usecase/ApplyRiskControlUseCase;", "getApplyRiskControlUseCaseFactory", "()Lkotlin/jvm/functions/Function1;", "setApplyRiskControlUseCaseFactory", "(Lkotlin/jvm/functions/Function1;)V", "archiveAppInfoResolver", "Lkotlin/Function2;", "getArchiveAppInfoResolver", "()Lkotlin/jvm/functions/Function2;", "setArchiveAppInfoResolver", "(Lkotlin/jvm/functions/Function2;)V", "clock", "Lkotlin/Function0;", "", "getClock", "()Lkotlin/jvm/functions/Function0;", "setClock", "(Lkotlin/jvm/functions/Function0;)V", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getIoDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "setIoDispatcher", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "isPackageInstalled", "", "setPackageInstalled", "loadRiskAppsUseCaseFactory", "Lcom/obric/safecheck/riskcontrol/domain/usecase/LoadRiskAppsUseCase;", "getLoadRiskAppsUseCaseFactory", "setLoadRiskAppsUseCaseFactory", "persistScanResultsUseCaseFactory", "Lcom/obric/safecheck/riskcontrol/domain/usecase/PersistScanResultsUseCase;", "getPersistScanResultsUseCaseFactory", "setPersistScanResultsUseCaseFactory", "policyEnforcer", "Lkotlin/Function4;", "", "getPolicyEnforcer", "()Lkotlin/jvm/functions/Function4;", "setPolicyEnforcer", "(Lkotlin/jvm/functions/Function4;)V", "policyReleaser", "getPolicyReleaser", "setPolicyReleaser", "processObserverActivator", "getProcessObserverActivator", "setProcessObserverActivator", "repositoryFactory", "Lcom/obric/safecheck/riskcontrol/api/repo/RiskAppControlRepository;", "getRepositoryFactory", "setRepositoryFactory", "scanResultRepositoryFactory", "Lcom/obric/safecheck/riskcontrol/api/repo/ScanResultRepository;", "getScanResultRepositoryFactory", "setScanResultRepositoryFactory", "virusApkDaoFactory", "Lcom/obric/safecheck/database/dao/VirusApkDao;", "getVirusApkDaoFactory", "setVirusApkDaoFactory", "ensureInitialized", "context", "ensureProcessObserverActive", "missingRepositoryFactory", "reset", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class RiskControlRuntimeDependencies {
    public static final RiskControlRuntimeDependencies INSTANCE = null;
    private static final String TAG = "RiskRuntimeDeps";
    private static Context appContextHolder;
    private static Function3<? super Context, ? super String, ? super Integer, RiskAppUiInfo> appInfoResolver;
    private static Function1<? super Context, ApplyRiskControlUseCase> applyRiskControlUseCaseFactory;
    private static Function2<? super Context, ? super String, RiskAppUiInfo> archiveAppInfoResolver;
    private static Function0<Long> clock;
    private static CoroutineDispatcher ioDispatcher;
    private static Function3<? super Context, ? super String, ? super Integer, Boolean> isPackageInstalled;
    private static Function1<? super Context, LoadRiskAppsUseCase> loadRiskAppsUseCaseFactory;
    private static Function1<? super Context, PersistScanResultsUseCase> persistScanResultsUseCaseFactory;
    private static Function4<? super Context, ? super String, ? super Integer, ? super Integer, Unit> policyEnforcer;
    private static Function4<? super Context, ? super String, ? super Integer, ? super Integer, Unit> policyReleaser;
    private static Function1<? super Context, Unit> processObserverActivator;
    private static Function1<? super Context, ? extends RiskAppControlRepository> repositoryFactory;
    private static Function1<? super Context, ? extends ScanResultRepository> scanResultRepositoryFactory;
    private static Function1<? super Context, ? extends VirusApkDao> virusApkDaoFactory;

    /* JADX INFO: renamed from: com.obric.safecheck.riskcontrol.ui.RiskControlRuntimeDependencies$reset$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RiskControlRuntimeDependencies.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/obric/safecheck/riskcontrol/api/repo/RiskAppControlRepository;", "p1", "Landroid/content/Context;", "Lkotlin/ParameterName;", "name", "context", "invoke"}, k = 3, mv = {1, 4, 3})
    static final /* synthetic */ class C03291 extends FunctionReferenceImpl implements Function1<Context, RiskAppControlRepository> {
        C03291(RiskControlRuntimeDependencies r8) {
            super(1, r8, RiskControlRuntimeDependencies.class, "missingRepositoryFactory", "missingRepositoryFactory(Landroid/content/Context;)Lcom/obric/safecheck/riskcontrol/api/repo/RiskAppControlRepository;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ RiskAppControlRepository invoke(Context r1) {
            return invoke2(r1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final RiskAppControlRepository invoke2(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            return RiskControlRuntimeDependencies.access$missingRepositoryFactory((RiskControlRuntimeDependencies) this.receiver, r2);
        }
    }

    static {
        RiskControlRuntimeDependencies r0 = new RiskControlRuntimeDependencies();
        INSTANCE = r0;
        repositoryFactory = new RiskControlRuntimeDependencies$repositoryFactory$1(r0);
        virusApkDaoFactory = RiskControlRuntimeDependencies$virusApkDaoFactory$1.INSTANCE;
        clock = RiskControlRuntimeDependencies$clock$1.INSTANCE;
        scanResultRepositoryFactory = RiskControlRuntimeDependencies$scanResultRepositoryFactory$1.INSTANCE;
        policyEnforcer = RiskControlRuntimeDependencies$policyEnforcer$1.INSTANCE;
        policyReleaser = RiskControlRuntimeDependencies$policyReleaser$1.INSTANCE;
        appInfoResolver = RiskControlRuntimeDependencies$appInfoResolver$1.INSTANCE;
        archiveAppInfoResolver = RiskControlRuntimeDependencies$archiveAppInfoResolver$1.INSTANCE;
        isPackageInstalled = AnonymousClass1.INSTANCE;
        ioDispatcher = Dispatchers.getIO();
        applyRiskControlUseCaseFactory = RiskControlRuntimeDependencies$applyRiskControlUseCaseFactory$1.INSTANCE;
        persistScanResultsUseCaseFactory = RiskControlRuntimeDependencies$persistScanResultsUseCaseFactory$1.INSTANCE;
        loadRiskAppsUseCaseFactory = RiskControlRuntimeDependencies$loadRiskAppsUseCaseFactory$1.INSTANCE;
        processObserverActivator = RiskControlRuntimeDependencies$processObserverActivator$1.INSTANCE;
    }

    private RiskControlRuntimeDependencies() {
    }

    public static final /* synthetic */ RiskAppControlRepository access$missingRepositoryFactory(RiskControlRuntimeDependencies r0, Context r1) {
        return r0.missingRepositoryFactory(r1);
    }

    public final Function1<Context, RiskAppControlRepository> getRepositoryFactory() {
        return repositoryFactory;
    }

    public final void setRepositoryFactory(Function1<? super Context, ? extends RiskAppControlRepository> r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        repositoryFactory = r1;
    }

    public final Function1<Context, VirusApkDao> getVirusApkDaoFactory() {
        return virusApkDaoFactory;
    }

    public final void setVirusApkDaoFactory(Function1<? super Context, ? extends VirusApkDao> r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        virusApkDaoFactory = r1;
    }

    public final Function0<Long> getClock() {
        return clock;
    }

    public final void setClock(Function0<Long> r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        clock = r1;
    }

    public final Function1<Context, ScanResultRepository> getScanResultRepositoryFactory() {
        return scanResultRepositoryFactory;
    }

    public final void setScanResultRepositoryFactory(Function1<? super Context, ? extends ScanResultRepository> r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        scanResultRepositoryFactory = r1;
    }

    public final Function4<Context, String, Integer, Integer, Unit> getPolicyEnforcer() {
        return policyEnforcer;
    }

    public final void setPolicyEnforcer(Function4<? super Context, ? super String, ? super Integer, ? super Integer, Unit> r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        policyEnforcer = r1;
    }

    public final Function4<Context, String, Integer, Integer, Unit> getPolicyReleaser() {
        return policyReleaser;
    }

    public final void setPolicyReleaser(Function4<? super Context, ? super String, ? super Integer, ? super Integer, Unit> r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        policyReleaser = r1;
    }

    public final Function3<Context, String, Integer, RiskAppUiInfo> getAppInfoResolver() {
        return appInfoResolver;
    }

    public final void setAppInfoResolver(Function3<? super Context, ? super String, ? super Integer, RiskAppUiInfo> r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        appInfoResolver = r1;
    }

    public final Function2<Context, String, RiskAppUiInfo> getArchiveAppInfoResolver() {
        return archiveAppInfoResolver;
    }

    public final void setArchiveAppInfoResolver(Function2<? super Context, ? super String, RiskAppUiInfo> r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        archiveAppInfoResolver = r1;
    }

    public final Function3<Context, String, Integer, Boolean> isPackageInstalled() {
        return isPackageInstalled;
    }

    public final void setPackageInstalled(Function3<? super Context, ? super String, ? super Integer, Boolean> r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        isPackageInstalled = r1;
    }

    public final CoroutineDispatcher getIoDispatcher() {
        return ioDispatcher;
    }

    public final void setIoDispatcher(CoroutineDispatcher r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        ioDispatcher = r1;
    }

    public final Function1<Context, ApplyRiskControlUseCase> getApplyRiskControlUseCaseFactory() {
        return applyRiskControlUseCaseFactory;
    }

    public final void setApplyRiskControlUseCaseFactory(Function1<? super Context, ApplyRiskControlUseCase> r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        applyRiskControlUseCaseFactory = r1;
    }

    public final Function1<Context, PersistScanResultsUseCase> getPersistScanResultsUseCaseFactory() {
        return persistScanResultsUseCaseFactory;
    }

    public final void setPersistScanResultsUseCaseFactory(Function1<? super Context, PersistScanResultsUseCase> r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        persistScanResultsUseCaseFactory = r1;
    }

    public final Function1<Context, LoadRiskAppsUseCase> getLoadRiskAppsUseCaseFactory() {
        return loadRiskAppsUseCaseFactory;
    }

    public final void setLoadRiskAppsUseCaseFactory(Function1<? super Context, LoadRiskAppsUseCase> r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        loadRiskAppsUseCaseFactory = r1;
    }

    public final Function1<Context, Unit> getProcessObserverActivator() {
        return processObserverActivator;
    }

    public final void setProcessObserverActivator(Function1<? super Context, Unit> r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        processObserverActivator = r1;
    }

    public final void ensureInitialized(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if (appContextHolder != null) goto L6;
        appContextHolder = r1.getApplicationContext();
        return;
    }

    @JvmStatic
    public static final void ensureProcessObserverActive(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Function1<? super Context, Unit> r0 = processObserverActivator;     // Catch: Throwable -> L5
        Context r3 = r2.getApplicationContext();     // Catch: Throwable -> L5
        Intrinsics.checkNotNullExpressionValue(r3, "context.applicationContext");     // Catch: Throwable -> L5
        r0.invoke(r3);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Log.e(TAG, "Failed to activate risk process observer", th);
    }

    public final void reset() {
        Context r1 = (Context) null;
        appContextHolder = null;
        repositoryFactory = new C03291(this);
        virusApkDaoFactory = AnonymousClass2.INSTANCE;
        clock = AnonymousClass3.INSTANCE;
        scanResultRepositoryFactory = AnonymousClass4.INSTANCE;
        policyEnforcer = AnonymousClass5.INSTANCE;
        policyReleaser = AnonymousClass6.INSTANCE;
        appInfoResolver = AnonymousClass7.INSTANCE;
        archiveAppInfoResolver = AnonymousClass8.INSTANCE;
        isPackageInstalled = AnonymousClass9.INSTANCE;
        ioDispatcher = Dispatchers.getIO();
        applyRiskControlUseCaseFactory = AnonymousClass10.INSTANCE;
        persistScanResultsUseCaseFactory = AnonymousClass11.INSTANCE;
        loadRiskAppsUseCaseFactory = AnonymousClass12.INSTANCE;
        processObserverActivator = AnonymousClass13.INSTANCE;
    }

    private final RiskAppControlRepository missingRepositoryFactory(Context r3) {
        throw new IllegalStateException("RiskAppControlRepository is not initialized. Call VirusRiskControlRuntimeInstaller.install(context) from the host module first. context=" + r3);
    }
}
