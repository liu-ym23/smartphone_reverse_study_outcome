package com.bytedanceos.securitycenter.scan;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: SafeCheckScanDependencies.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010:\u001a\u00020;R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R&\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001c0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R&\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020 0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011R \u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR&\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020(0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u000f\"\u0004\b*\u0010\u0011R&\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020,0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u000f\"\u0004\b.\u0010\u0011R&\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002000\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000f\"\u0004\b2\u0010\u0011R&\u00103\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002040\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u000f\"\u0004\b6\u0010\u0011R&\u00107\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002000\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u000f\"\u0004\b9\u0010\u0011¨\u0006<"}, d2 = {"Lcom/bytedanceos/securitycenter/scan/SafeCheckScanDependencies;", "", "()V", "apkFileDataSourceFactory", "Lkotlin/Function0;", "Lcom/bytedanceos/securitycenter/scan/ApkFileDataSource;", "getApkFileDataSourceFactory", "()Lkotlin/jvm/functions/Function0;", "setApkFileDataSourceFactory", "(Lkotlin/jvm/functions/Function0;)V", "appUninstallDataSourceFactory", "Lkotlin/Function1;", "Landroid/content/Context;", "Lcom/bytedanceos/securitycenter/scan/AppUninstallDataSource;", "getAppUninstallDataSourceFactory", "()Lkotlin/jvm/functions/Function1;", "setAppUninstallDataSourceFactory", "(Lkotlin/jvm/functions/Function1;)V", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getIoDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "setIoDispatcher", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "mainDispatcher", "getMainDispatcher", "setMainDispatcher", "packageDataSourceFactory", "Lcom/bytedanceos/securitycenter/scan/PackageDataSource;", "getPackageDataSourceFactory", "setPackageDataSourceFactory", "riskAppUseCaseFactory", "Lcom/bytedanceos/securitycenter/scan/SafeCheckRiskAppUseCase;", "getRiskAppUseCaseFactory", "setRiskAppUseCaseFactory", "scanEngineDataSourceFactory", "Lcom/bytedanceos/securitycenter/scan/VirusScanEngineDataSource;", "getScanEngineDataSourceFactory", "setScanEngineDataSourceFactory", "scanPlanBuilderFactory", "Lcom/bytedanceos/securitycenter/scan/ScanPlanBuilder;", "getScanPlanBuilderFactory", "setScanPlanBuilderFactory", "scanSettingsRepositoryFactory", "Lcom/bytedanceos/securitycenter/scan/ScanSettingsRepository;", "getScanSettingsRepositoryFactory", "setScanSettingsRepositoryFactory", "virusDbPendingUpdateReader", "", "getVirusDbPendingUpdateReader", "setVirusDbPendingUpdateReader", "virusDbScanDataSourceFactory", "Lcom/bytedanceos/securitycenter/scan/VirusDbScanDataSource;", "getVirusDbScanDataSourceFactory", "setVirusDbScanDataSourceFactory", "virusDbUpdateChecker", "getVirusDbUpdateChecker", "setVirusDbUpdateChecker", "reset", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SafeCheckScanDependencies {
    public static final SafeCheckScanDependencies INSTANCE = null;
    private static Function0<? extends ApkFileDataSource> apkFileDataSourceFactory;
    private static Function1<? super Context, ? extends AppUninstallDataSource> appUninstallDataSourceFactory;
    private static CoroutineDispatcher ioDispatcher;
    private static CoroutineDispatcher mainDispatcher;
    private static Function1<? super Context, ? extends PackageDataSource> packageDataSourceFactory;
    private static Function1<? super Context, SafeCheckRiskAppUseCase> riskAppUseCaseFactory;
    private static Function0<? extends VirusScanEngineDataSource> scanEngineDataSourceFactory;
    private static Function1<? super Context, ScanPlanBuilder> scanPlanBuilderFactory;
    private static Function1<? super Context, ? extends ScanSettingsRepository> scanSettingsRepositoryFactory;
    private static Function1<? super Context, Boolean> virusDbPendingUpdateReader;
    private static Function1<? super Context, ? extends VirusDbScanDataSource> virusDbScanDataSourceFactory;
    private static Function1<? super Context, Boolean> virusDbUpdateChecker;

    static {
        INSTANCE = new SafeCheckScanDependencies();
        ioDispatcher = Dispatchers.getIO();
        mainDispatcher = Dispatchers.getMain().getImmediate();
        packageDataSourceFactory = SafeCheckScanDependencies$packageDataSourceFactory$1.INSTANCE;
        virusDbScanDataSourceFactory = SafeCheckScanDependencies$virusDbScanDataSourceFactory$1.INSTANCE;
        apkFileDataSourceFactory = SafeCheckScanDependencies$apkFileDataSourceFactory$1.INSTANCE;
        scanEngineDataSourceFactory = SafeCheckScanDependencies$scanEngineDataSourceFactory$1.INSTANCE;
        appUninstallDataSourceFactory = SafeCheckScanDependencies$appUninstallDataSourceFactory$1.INSTANCE;
        scanSettingsRepositoryFactory = SafeCheckScanDependencies$scanSettingsRepositoryFactory$1.INSTANCE;
        virusDbUpdateChecker = SafeCheckScanDependencies$virusDbUpdateChecker$1.INSTANCE;
        virusDbPendingUpdateReader = SafeCheckScanDependencies$virusDbPendingUpdateReader$1.INSTANCE;
        scanPlanBuilderFactory = SafeCheckScanDependencies$scanPlanBuilderFactory$1.INSTANCE;
        riskAppUseCaseFactory = SafeCheckScanDependencies$riskAppUseCaseFactory$1.INSTANCE;
    }

    private SafeCheckScanDependencies() {
    }

    public final CoroutineDispatcher getIoDispatcher() {
        return ioDispatcher;
    }

    public final void setIoDispatcher(CoroutineDispatcher r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        ioDispatcher = r1;
    }

    public final CoroutineDispatcher getMainDispatcher() {
        return mainDispatcher;
    }

    public final void setMainDispatcher(CoroutineDispatcher r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        mainDispatcher = r1;
    }

    public final Function1<Context, PackageDataSource> getPackageDataSourceFactory() {
        return packageDataSourceFactory;
    }

    public final void setPackageDataSourceFactory(Function1<? super Context, ? extends PackageDataSource> r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        packageDataSourceFactory = r1;
    }

    public final Function1<Context, VirusDbScanDataSource> getVirusDbScanDataSourceFactory() {
        return virusDbScanDataSourceFactory;
    }

    public final void setVirusDbScanDataSourceFactory(Function1<? super Context, ? extends VirusDbScanDataSource> r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        virusDbScanDataSourceFactory = r1;
    }

    public final Function0<ApkFileDataSource> getApkFileDataSourceFactory() {
        return apkFileDataSourceFactory;
    }

    public final void setApkFileDataSourceFactory(Function0<? extends ApkFileDataSource> r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        apkFileDataSourceFactory = r1;
    }

    public final Function0<VirusScanEngineDataSource> getScanEngineDataSourceFactory() {
        return scanEngineDataSourceFactory;
    }

    public final void setScanEngineDataSourceFactory(Function0<? extends VirusScanEngineDataSource> r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        scanEngineDataSourceFactory = r1;
    }

    public final Function1<Context, AppUninstallDataSource> getAppUninstallDataSourceFactory() {
        return appUninstallDataSourceFactory;
    }

    public final void setAppUninstallDataSourceFactory(Function1<? super Context, ? extends AppUninstallDataSource> r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        appUninstallDataSourceFactory = r1;
    }

    public final Function1<Context, ScanSettingsRepository> getScanSettingsRepositoryFactory() {
        return scanSettingsRepositoryFactory;
    }

    public final void setScanSettingsRepositoryFactory(Function1<? super Context, ? extends ScanSettingsRepository> r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        scanSettingsRepositoryFactory = r1;
    }

    public final Function1<Context, Boolean> getVirusDbUpdateChecker() {
        return virusDbUpdateChecker;
    }

    public final void setVirusDbUpdateChecker(Function1<? super Context, Boolean> r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        virusDbUpdateChecker = r1;
    }

    public final Function1<Context, Boolean> getVirusDbPendingUpdateReader() {
        return virusDbPendingUpdateReader;
    }

    public final void setVirusDbPendingUpdateReader(Function1<? super Context, Boolean> r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        virusDbPendingUpdateReader = r1;
    }

    public final Function1<Context, ScanPlanBuilder> getScanPlanBuilderFactory() {
        return scanPlanBuilderFactory;
    }

    public final void setScanPlanBuilderFactory(Function1<? super Context, ScanPlanBuilder> r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        scanPlanBuilderFactory = r1;
    }

    public final Function1<Context, SafeCheckRiskAppUseCase> getRiskAppUseCaseFactory() {
        return riskAppUseCaseFactory;
    }

    public final void setRiskAppUseCaseFactory(Function1<? super Context, SafeCheckRiskAppUseCase> r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        riskAppUseCaseFactory = r1;
    }

    public final void reset() {
        ioDispatcher = Dispatchers.getIO();
        mainDispatcher = Dispatchers.getMain().getImmediate();
        packageDataSourceFactory = AnonymousClass1.INSTANCE;
        virusDbScanDataSourceFactory = AnonymousClass2.INSTANCE;
        apkFileDataSourceFactory = AnonymousClass3.INSTANCE;
        scanEngineDataSourceFactory = AnonymousClass4.INSTANCE;
        appUninstallDataSourceFactory = AnonymousClass5.INSTANCE;
        scanSettingsRepositoryFactory = AnonymousClass6.INSTANCE;
        virusDbUpdateChecker = AnonymousClass7.INSTANCE;
        virusDbPendingUpdateReader = AnonymousClass8.INSTANCE;
        scanPlanBuilderFactory = AnonymousClass9.INSTANCE;
        riskAppUseCaseFactory = AnonymousClass10.INSTANCE;
    }
}
