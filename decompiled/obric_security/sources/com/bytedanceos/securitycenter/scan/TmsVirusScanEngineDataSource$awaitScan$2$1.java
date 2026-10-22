package com.bytedanceos.securitycenter.scan;

import com.obric.matrix.platform.sdk.ones.safecushion.SafeCushionConstant;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;

/* JADX INFO: compiled from: TmsVirusScanEngineDataSource.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {SafeCushionConstant.FINISH_STATE, "", "result", "Lcom/bytedanceos/securitycenter/scan/ScanEngineResult;", "invoke"}, k = 3, mv = {1, 4, 3})
final class TmsVirusScanEngineDataSource$awaitScan$2$1 extends Lambda implements Function1<ScanEngineResult, Unit> {
    final /* synthetic */ CancellableContinuation $cont;
    final /* synthetic */ AtomicBoolean $resumed;

    TmsVirusScanEngineDataSource$awaitScan$2$1(CancellableContinuation r1, AtomicBoolean r2) {
        this.$cont = r1;
        this.$resumed = r2;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ScanEngineResult r1) {
        invoke2(r1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ScanEngineResult r4) {
        Intrinsics.checkNotNullParameter(r4, "result");
        if (this.$resumed.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (this.$cont.isActive() == false) goto L9;
        CancellableContinuation r3 = this.$cont;
        Result.Companion r0 = Result.Companion;
        r3.resumeWith(Result.m774constructorimpl(r4));
        return;
    }
}
