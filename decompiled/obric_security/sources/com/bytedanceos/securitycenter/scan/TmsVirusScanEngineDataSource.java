package com.bytedanceos.securitycenter.scan;

import com.bytedance.apm.constant.PerfConsts;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CancellableContinuationImpl;
import tmsdk.common.module.qscanner.QScanListener;
import tmsdk.common.module.qscanner.QScannerManagerV2;
import tmsdk.fg.creator.ManagerCreatorF;

/* JADX INFO: compiled from: TmsVirusScanEngineDataSource.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002Jt\u0010\u0005\u001a\u00020\u00062K\u0010\u0007\u001aG\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\b2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016Jt\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001c2K\u0010\u0007\u001aG\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002Jt\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\u001c2K\u0010\u0007\u001aG\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001dR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lcom/bytedanceos/securitycenter/scan/TmsVirusScanEngineDataSource;", "Lcom/bytedanceos/securitycenter/scan/VirusScanEngineDataSource;", "()V", "manager", "Ltmsdk/common/module/qscanner/QScannerManagerV2;", "awaitScan", "Lcom/bytedanceos/securitycenter/scan/ScanEngineResult;", "onProgress", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "curr", PerfConsts.PERF_DISK_TOTAL, "", "displayName", "", "start", "Lkotlin/Function1;", "Ltmsdk/common/module/qscanner/QScanListener;", "", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelScan", "initScanner", "scanInstalledPackages", "cloudScan", "", "packages", "", "(ZLjava/util/List;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scanType", "scanUninstallApks", "apkPaths", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class TmsVirusScanEngineDataSource implements VirusScanEngineDataSource {
    private static final Companion Companion = null;

    @Deprecated
    public static final int ENGINE_UNAVAILABLE = -1;

    @Deprecated
    public static final long SCAN_TIMEOUT_MS = 15000;
    private final QScannerManagerV2 manager;

    /* JADX INFO: compiled from: TmsVirusScanEngineDataSource.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedanceos/securitycenter/scan/TmsVirusScanEngineDataSource$Companion;", "", "()V", "ENGINE_UNAVAILABLE", "", "SCAN_TIMEOUT_MS", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
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

    public static final /* synthetic */ Companion access$Companion() {
        return Companion;
    }

    private final int scanType(boolean r1) {
        if (r1 == false) goto L4;
        return 6;
    L4:
        return 2;
    }

    public TmsVirusScanEngineDataSource() {
        QScannerManagerV2 r0 = (QScannerManagerV2) ManagerCreatorF.getManager(QScannerManagerV2.class);     // Catch: Exception -> L5
    L7:
        this.manager = r0;
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        r0 = null;
        goto L7
    }

    public static final /* synthetic */ QScannerManagerV2 access$getManager$p(TmsVirusScanEngineDataSource r0) {
        return r0.manager;
    }

    public static final /* synthetic */ int access$scanType(TmsVirusScanEngineDataSource r0, boolean r1) {
        return r0.scanType(r1);
    }

    @Override // com.bytedanceos.securitycenter.scan.VirusScanEngineDataSource
    public void initScanner() {
        QScannerManagerV2 r0 = this.manager;     // Catch: Exception -> L6
        if (r0 == null) goto L11;
        r0.initScanner();     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.bytedanceos.securitycenter.scan.VirusScanEngineDataSource
    public Object scanInstalledPackages(final boolean r2, final List<String> r3, Function3<? super Integer, ? super Integer, ? super String, Unit> r4, Continuation<? super ScanEngineResult> r5) {
        return awaitScan(r4, new AnonymousClass2(this, r2, r3), r5);
    }

    @Override // com.bytedanceos.securitycenter.scan.VirusScanEngineDataSource
    public Object scanUninstallApks(final boolean r2, final List<String> r3, Function3<? super Integer, ? super Integer, ? super String, Unit> r4, Continuation<? super ScanEngineResult> r5) {
        return awaitScan(r4, new C01752(this, r2, r3), r5);
    }

    @Override // com.bytedanceos.securitycenter.scan.VirusScanEngineDataSource
    public void cancelScan() {
        QScannerManagerV2 r0 = this.manager;     // Catch: Exception -> L6
        if (r0 == null) goto L11;
        r0.cancelScan();     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    private final Object awaitScan(final Function3<? super Integer, ? super Integer, ? super String, Unit> r6, final Function1<? super QScanListener, ? extends Object> r7, Continuation<? super ScanEngineResult> r8) {
        CancellableContinuationImpl r0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r8), 1);
        r0.initCancellability();
        CancellableContinuationImpl r1 = r0;
        final TmsVirusScanEngineDataSource$awaitScan$2$1 r3 = new TmsVirusScanEngineDataSource$awaitScan$2$1(r1, new AtomicBoolean(false));
        QScanListener r2 = new TmsVirusScanEngineDataSource$awaitScan$$inlined$suspendCancellableCoroutine$lambda$1(r3, this, r6, r7);
        r1.invokeOnCancellation(new TmsVirusScanEngineDataSource$awaitScan$$inlined$suspendCancellableCoroutine$lambda$2(this, r6, r7));
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L5
        TmsVirusScanEngineDataSource r5 = this;     // Catch: Throwable -> L5
        Object r10 = Result.m774constructorimpl(r7.invoke(r2));     // Catch: Throwable -> L5
    L7:
        Throwable r11 = Result.m777exceptionOrNullimpl(r10);
        if (r11 != null) goto L11;
        if (r10 != null) goto L12;
        access$Companion();
        r3.invoke2(new ScanEngineResult.Error(-1));
    L12:
        Object r12 = r0.getResult();
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(r8);
    L15:
        return r12;
    L11:
        r11.printStackTrace();
        access$Companion();
        r3.invoke2(new ScanEngineResult.Error(-1));
    L5:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r10 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
