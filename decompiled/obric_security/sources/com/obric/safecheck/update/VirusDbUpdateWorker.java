package com.obric.safecheck.update;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.obric.olog.OLog;
import com.obric.securitycenter.api.VirusDbUpdateResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VirusDbUpdateWorker.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/obric/safecheck/update/VirusDbUpdateWorker;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "params", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class VirusDbUpdateWorker extends CoroutineWorker {
    private static final Companion Companion = null;

    @Deprecated
    private static final int MAX_RETRY = 2;

    @Deprecated
    private static final String TAG = "VirusDbUpdateWorker";
    private final Context context;

    /* JADX INFO: compiled from: VirusDbUpdateWorker.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/safecheck/update/VirusDbUpdateWorker$Companion;", "", "()V", "MAX_RETRY", "", "TAG", "", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.safecheck.update.VirusDbUpdateWorker$doWork$1, reason: invalid class name */
    /* JADX INFO: compiled from: VirusDbUpdateWorker.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0096@"}, d2 = {"doWork", "", "continuation", "Lkotlin/coroutines/Continuation;", "Landroidx/work/ListenableWorker$Result;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.safecheck.update.VirusDbUpdateWorker", f = "VirusDbUpdateWorker.kt", i = {0}, l = {20}, m = "doWork", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ VirusDbUpdateWorker this$0;

        AnonymousClass1(VirusDbUpdateWorker r1, Continuation r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.doWork(this);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public VirusDbUpdateWorker(Context r2, WorkerParameters r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "params");
        super(r2, r3);
        this.context = r2;
    }

    @Override // androidx.work.CoroutineWorker
    public Object doWork(Continuation<? super ListenableWorker.Result> r6) {
        if ((r6 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r6;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L16;
        if (r2 != 1) goto L15;
        VirusDbUpdateWorker this = (VirusDbUpdateWorker) r0.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L29
    L21:
        if (((VirusDbUpdateResult) r7).getSuccess() == false) goto L24;
        ListenableWorker.Result r8 = ListenableWorker.Result.success();     // Catch: Throwable -> L29
    L27:
        Intrinsics.checkNotNullExpressionValue(r8, "if (result.success) {\n  …t.failure()\n            }");     // Catch: Throwable -> L29
        return r8;
    L24:
        if (this.getRunAttemptCount() >= 2) goto L26;
        r8 = ListenableWorker.Result.retry();     // Catch: Throwable -> L29
        goto L27
    L26:
        r8 = ListenableWorker.Result.failure();     // Catch: Throwable -> L29
        goto L27
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r7);
        VirusDbUpdateManager r9 = VirusDbUpdateManager.INSTANCE;     // Catch: Throwable -> L29
        Context r3 = this.context;     // Catch: Throwable -> L29
        r0.L$0 = this;     // Catch: Throwable -> L29
        r0.label = 1;     // Catch: Throwable -> L29
        r7 = r9.updateNowAsync(r3, r0);     // Catch: Throwable -> L29
        if (r7 != r1) goto L21;
        return r1;
    L29:
        th = move-exception;
        OLog.e(TAG, "virus db update work error: " + th.getMessage());
        if (this.getRunAttemptCount() >= 2) goto L33;
        ListenableWorker.Result r5 = ListenableWorker.Result.retry();
    L34:
        ListenableWorker.Result r10 = r5;
        Intrinsics.checkNotNullExpressionValue(r10, "if (runAttemptCount < MA…y() else Result.failure()");
        return r10;
    L33:
        r5 = ListenableWorker.Result.failure();
    L7:
        r0 = new AnonymousClass1(this, r6);
        goto L8
    }
}
