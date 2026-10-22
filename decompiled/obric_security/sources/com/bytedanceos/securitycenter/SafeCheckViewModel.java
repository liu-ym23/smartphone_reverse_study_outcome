package com.bytedanceos.securitycenter;

import android.app.Application;
import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.bytedanceos.securitycenter.scan.ApkFileDataSource;
import com.bytedanceos.securitycenter.scan.SafeCheckScanDependencies;
import com.bytedanceos.securitycenter.scan.ScanDisplayItem;
import com.bytedanceos.securitycenter.scan.ScanEngineResult;
import com.bytedanceos.securitycenter.scan.ScanPlan;
import com.bytedanceos.securitycenter.scan.ScanPlanBuilder;
import com.bytedanceos.securitycenter.scan.VirusScanEngineDataSource;
import com.obric.oui.utils.AnimTokens;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import com.obric.security.R;
import com.obric.security.health.score.task.SafeCheckHistory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import tmsdk.bg.module.wifidetect.WifiDetectManager;
import tmsdk.common.module.qscanner.QScanResultEntity;

/* JADX INFO: compiled from: SafeCheckViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 >2\u00020\u0001:\u0001>B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eJ\u0011\u0010 \u001a\u00020\u001eH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010!J\u0019\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010%J\u001f\u0010&\u001a\u00020\u001e2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010*J/\u0010+\u001a\u00020$2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020-0(2\u0006\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020$H\u0082@ø\u0001\u0000¢\u0006\u0002\u00100J!\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u00020$2\u0006\u00103\u001a\u000204H\u0082@ø\u0001\u0000¢\u0006\u0002\u00105J/\u00106\u001a\u00020$2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020-0(2\u0006\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020$H\u0082@ø\u0001\u0000¢\u0006\u0002\u00100J\b\u00107\u001a\u00020\u001eH\u0014J\u0018\u00108\u001a\u00020\u001e2\u0006\u00102\u001a\u00020$2\u0006\u00103\u001a\u000204H\u0002J\u0006\u00109\u001a\u00020\u001eJ\u0018\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020$2\u0006\u0010/\u001a\u00020$H\u0002J\u000e\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006?"}, d2 = {"Lcom/bytedanceos/securitycenter/SafeCheckViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_scanState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedanceos/securitycenter/ScanState;", "_virusDbUpdateAvailable", "", "apkFileDataSource", "Lcom/bytedanceos/securitycenter/scan/ApkFileDataSource;", "isCanceled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "scanEngine", "Lcom/bytedanceos/securitycenter/scan/VirusScanEngineDataSource;", "scanJob", "Lkotlinx/coroutines/Job;", "scanPlanBuilder", "Lcom/bytedanceos/securitycenter/scan/ScanPlanBuilder;", "scanState", "Landroidx/lifecycle/LiveData;", "getScanState", "()Landroidx/lifecycle/LiveData;", "tFirstProgress", "", "tLastProgress", "virusDbUpdateAvailable", "getVirusDbUpdateAvailable", "cancelScan", "", "checkVirusDbUpdate", "emitCanceled", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitError", "errCode", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitFinished", ApkVirusCheckProvider.KEY_RESULTS, "", "Ltmsdk/common/module/qscanner/QScanResultEntity;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitInstantDisplayItems", "items", "Lcom/bytedanceos/securitycenter/scan/ScanDisplayItem;", "completedStart", "totalItems", "(Ljava/util/List;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitScanning", "progress", "itemName", "", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitSkippedDisplayItems", "onCleared", "postScanning", "refreshVirusDbBadge", "scanProgress", "completedItems", "startScan", "isCloudScan", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SafeCheckViewModel extends AndroidViewModel {
    private static final Companion Companion = null;

    @Deprecated
    private static final long SKIPPED_APP_SUBTITLE_DISPLAY_MS = 30;
    private final MutableLiveData<ScanState> _scanState;
    private final MutableLiveData<Boolean> _virusDbUpdateAvailable;
    private final ApkFileDataSource apkFileDataSource;
    private final AtomicBoolean isCanceled;
    private final VirusScanEngineDataSource scanEngine;
    private Job scanJob;
    private final ScanPlanBuilder scanPlanBuilder;
    private final LiveData<ScanState> scanState;
    private long tFirstProgress;
    private long tLastProgress;
    private final LiveData<Boolean> virusDbUpdateAvailable;

    /* JADX INFO: compiled from: SafeCheckViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedanceos/securitycenter/SafeCheckViewModel$Companion;", "", "()V", "SKIPPED_APP_SUBTITLE_DISPLAY_MS", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.bytedanceos.securitycenter.SafeCheckViewModel$checkVirusDbUpdate$1, reason: invalid class name */
    /* JADX INFO: compiled from: SafeCheckViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedanceos.securitycenter.SafeCheckViewModel$checkVirusDbUpdate$1", f = "SafeCheckViewModel.kt", i = {}, l = {250}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SafeCheckViewModel this$0;

        /* JADX INFO: renamed from: com.bytedanceos.securitycenter.SafeCheckViewModel$checkVirusDbUpdate$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: SafeCheckViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @DebugMetadata(c = "com.bytedanceos.securitycenter.SafeCheckViewModel$checkVirusDbUpdate$1$1", f = "SafeCheckViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.BooleanRef $hasUpdate;
            int label;
            final /* synthetic */ AnonymousClass1 this$0;

            C00321(AnonymousClass1 r1, Ref.BooleanRef r2, Continuation r3) {
                this.this$0 = r1;
                this.$hasUpdate = r2;
                super(2, r3);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                Intrinsics.checkNotNullParameter(r3, "completion");
                return new C00321(this.this$0, this.$hasUpdate, r3);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return ((C00321) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                SafeCheckViewModel.access$get_virusDbUpdateAvailable$p(this.this$0.this$0).setValue(Boxing.boxBoolean(this.$hasUpdate.element));
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass1(SafeCheckViewModel r1, Continuation r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "completion");
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r3);
            r0.L$0 = r2;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L20:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            CoroutineScope r7 = (CoroutineScope) this.L$0;
            Ref.BooleanRef r8 = new Ref.BooleanRef();
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
            Function1<Context, Boolean> r3 = SafeCheckScanDependencies.INSTANCE.getVirusDbUpdateChecker();     // Catch: Throwable -> L11
            Application r4 = this.this$0.getApplication();     // Catch: Throwable -> L11
            Intrinsics.checkNotNullExpressionValue(r4, "getApplication()");     // Catch: Throwable -> L11
            Object r5 = Result.m774constructorimpl(Boxing.boxBoolean(r3.invoke(r4).booleanValue()));     // Catch: Throwable -> L11
        L13:
            Boolean r9 = Boxing.boxBoolean(false);
            if (Result.m780isFailureimpl(r5) == false) goto L16;
            r5 = r9;
        L16:
            r8.element = ((Boolean) r5).booleanValue();
            CoroutineDispatcher r10 = SafeCheckScanDependencies.INSTANCE.getMainDispatcher();
            C00321 r11 = new C00321(this, r8, null);
            this.label = 1;
            if (BuildersKt.withContext(r10, r11, this) != r0) goto L20;
            return r0;
        L11:
            th = move-exception;
            Result.Companion r12 = Result.Companion;
            r5 = Result.m774constructorimpl(ResultKt.createFailure(th));
            goto L13
        }
    }

    /* JADX INFO: renamed from: com.bytedanceos.securitycenter.SafeCheckViewModel$emitCanceled$2, reason: invalid class name */
    /* JADX INFO: compiled from: SafeCheckViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedanceos.securitycenter.SafeCheckViewModel$emitCanceled$2", f = "SafeCheckViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SafeCheckViewModel this$0;

        AnonymousClass2(SafeCheckViewModel r1, Continuation r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            Intrinsics.checkNotNullParameter(r2, "completion");
            return new AnonymousClass2(this.this$0, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            SafeCheckViewModel.access$get_scanState$p(this.this$0).setValue(ScanState.Canceled.INSTANCE);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.bytedanceos.securitycenter.SafeCheckViewModel$emitError$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SafeCheckViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedanceos.securitycenter.SafeCheckViewModel$emitError$2", f = "SafeCheckViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01642 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $errCode;
        int label;
        final /* synthetic */ SafeCheckViewModel this$0;

        C01642(SafeCheckViewModel r1, int r2, Continuation r3) {
            this.this$0 = r1;
            this.$errCode = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "completion");
            return new C01642(this.this$0, this.$errCode, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C01642) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            SafeCheckViewModel.access$get_scanState$p(this.this$0).setValue(new ScanState.Error(this.$errCode));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.bytedanceos.securitycenter.SafeCheckViewModel$emitFinished$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SafeCheckViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedanceos.securitycenter.SafeCheckViewModel$emitFinished$2", f = "SafeCheckViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01652 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef $snapshot;
        int label;
        final /* synthetic */ SafeCheckViewModel this$0;

        C01652(SafeCheckViewModel r1, Ref.ObjectRef r2, Continuation r3) {
            this.this$0 = r1;
            this.$snapshot = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "completion");
            return new C01652(this.this$0, this.$snapshot, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C01652) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r8);
            SafeCheckHistory r1 = SafeCheckHistory.INSTANCE;
            Application r9 = this.this$0.getApplication();
            Intrinsics.checkNotNullExpressionValue(r9, "getApplication()");
            SafeCheckHistory.markScanFinished$default(r1, r9, 0, 2, null);
            SafeCheckViewModel.access$get_scanState$p(this.this$0).setValue(new ScanState.Finished((List) this.$snapshot.element));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.bytedanceos.securitycenter.SafeCheckViewModel$emitInstantDisplayItems$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SafeCheckViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tH\u0082@"}, d2 = {"emitInstantDisplayItems", "", "items", "", "Lcom/bytedanceos/securitycenter/scan/ScanDisplayItem;", "completedStart", "", "totalItems", "continuation", "Lkotlin/coroutines/Continuation;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedanceos.securitycenter.SafeCheckViewModel", f = "SafeCheckViewModel.kt", i = {0, 0, 0}, l = {189}, m = "emitInstantDisplayItems", n = {"this", "totalItems", "completed"}, s = {"L$0", "I$0", "I$1"})
    static final class C01661 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SafeCheckViewModel this$0;

        C01661(SafeCheckViewModel r1, Continuation r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return SafeCheckViewModel.access$emitInstantDisplayItems(this.this$0, null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.bytedanceos.securitycenter.SafeCheckViewModel$emitScanning$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SafeCheckViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedanceos.securitycenter.SafeCheckViewModel$emitScanning$2", f = "SafeCheckViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01672 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $itemName;
        final /* synthetic */ int $progress;
        int label;
        final /* synthetic */ SafeCheckViewModel this$0;

        C01672(SafeCheckViewModel r1, int r2, String r3, Continuation r4) {
            this.this$0 = r1;
            this.$progress = r2;
            this.$itemName = r3;
            super(2, r4);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Intrinsics.checkNotNullParameter(r4, "completion");
            return new C01672(this.this$0, this.$progress, this.$itemName, r4);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C01672) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            SafeCheckViewModel.access$get_scanState$p(this.this$0).setValue(new ScanState.Scanning(this.$progress, this.$itemName));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.bytedanceos.securitycenter.SafeCheckViewModel$emitSkippedDisplayItems$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SafeCheckViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tH\u0082@"}, d2 = {"emitSkippedDisplayItems", "", "items", "", "Lcom/bytedanceos/securitycenter/scan/ScanDisplayItem;", "completedStart", "", "totalItems", "continuation", "Lkotlin/coroutines/Continuation;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedanceos.securitycenter.SafeCheckViewModel", f = "SafeCheckViewModel.kt", i = {0, 0, 0, 1, 1, 1}, l = {174, 175}, m = "emitSkippedDisplayItems", n = {"this", "totalItems", "completed", "this", "totalItems", "completed"}, s = {"L$0", "I$0", "I$1", "L$0", "I$0", "I$1"})
    static final class C01681 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SafeCheckViewModel this$0;

        C01681(SafeCheckViewModel r1, Continuation r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return SafeCheckViewModel.access$emitSkippedDisplayItems(this.this$0, null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.bytedanceos.securitycenter.SafeCheckViewModel$postScanning$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SafeCheckViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedanceos.securitycenter.SafeCheckViewModel$postScanning$1", f = "SafeCheckViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01691 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $itemName;
        final /* synthetic */ int $progress;
        int label;
        final /* synthetic */ SafeCheckViewModel this$0;

        C01691(SafeCheckViewModel r1, int r2, String r3, Continuation r4) {
            this.this$0 = r1;
            this.$progress = r2;
            this.$itemName = r3;
            super(2, r4);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Intrinsics.checkNotNullParameter(r4, "completion");
            return new C01691(this.this$0, this.$progress, this.$itemName, r4);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C01691) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            SafeCheckViewModel.access$get_scanState$p(this.this$0).setValue(new ScanState.Scanning(this.$progress, this.$itemName));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.bytedanceos.securitycenter.SafeCheckViewModel$refreshVirusDbBadge$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SafeCheckViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedanceos.securitycenter.SafeCheckViewModel$refreshVirusDbBadge$1", f = "SafeCheckViewModel.kt", i = {}, l = {WifiDetectManager.SSLSTRIP_OK}, m = "invokeSuspend", n = {}, s = {})
    static final class C01701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SafeCheckViewModel this$0;

        /* JADX INFO: renamed from: com.bytedanceos.securitycenter.SafeCheckViewModel$refreshVirusDbBadge$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: SafeCheckViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @DebugMetadata(c = "com.bytedanceos.securitycenter.SafeCheckViewModel$refreshVirusDbBadge$1$1", f = "SafeCheckViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.BooleanRef $pending;
            int label;
            final /* synthetic */ C01701 this$0;

            C00331(C01701 r1, Ref.BooleanRef r2, Continuation r3) {
                this.this$0 = r1;
                this.$pending = r2;
                super(2, r3);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                Intrinsics.checkNotNullParameter(r3, "completion");
                return new C00331(this.this$0, this.$pending, r3);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return ((C00331) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                SafeCheckViewModel.access$get_virusDbUpdateAvailable$p(this.this$0.this$0).setValue(Boxing.boxBoolean(this.$pending.element));
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C01701(SafeCheckViewModel r1, Continuation r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "completion");
            C01701 r0 = new C01701(this.this$0, r3);
            r0.L$0 = r2;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C01701) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L20:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            CoroutineScope r7 = (CoroutineScope) this.L$0;
            Ref.BooleanRef r8 = new Ref.BooleanRef();
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
            Function1<Context, Boolean> r3 = SafeCheckScanDependencies.INSTANCE.getVirusDbPendingUpdateReader();     // Catch: Throwable -> L11
            Application r4 = this.this$0.getApplication();     // Catch: Throwable -> L11
            Intrinsics.checkNotNullExpressionValue(r4, "getApplication()");     // Catch: Throwable -> L11
            Object r5 = Result.m774constructorimpl(Boxing.boxBoolean(r3.invoke(r4).booleanValue()));     // Catch: Throwable -> L11
        L13:
            Boolean r9 = Boxing.boxBoolean(false);
            if (Result.m780isFailureimpl(r5) == false) goto L16;
            r5 = r9;
        L16:
            r8.element = ((Boolean) r5).booleanValue();
            CoroutineDispatcher r10 = SafeCheckScanDependencies.INSTANCE.getMainDispatcher();
            C00331 r11 = new C00331(this, r8, null);
            this.label = 1;
            if (BuildersKt.withContext(r10, r11, this) != r0) goto L20;
            return r0;
        L11:
            th = move-exception;
            Result.Companion r12 = Result.Companion;
            r5 = Result.m774constructorimpl(ResultKt.createFailure(th));
            goto L13
        }
    }

    /* JADX INFO: renamed from: com.bytedanceos.securitycenter.SafeCheckViewModel$startScan$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SafeCheckViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedanceos.securitycenter.SafeCheckViewModel$startScan$1", f = "SafeCheckViewModel.kt", i = {0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 8, 8, 8, 8, 8}, l = {76, 94, 99, 101, 106, 120, 125, 132, 141, AnimTokens.OUI_ANIMATION_DURATION_SHORT_3, 154, 162}, m = "invokeSuspend", n = {"tTotalStart", "scanPlan", "localApkPaths", "accumulatedResults", "completedItems", "totalApps", "totalApks", "$fun$totalItems$1", "tTotalStart", "tSkipStart", "scanPlan", "localApkPaths", "accumulatedResults", "completedItems", "totalApps", "totalApks", "$fun$totalItems$1", "tTotalStart", "localApkPaths", "accumulatedResults", "completedItems", "totalApps", "totalApks", "$fun$totalItems$1", "tTotalStart", "tStage1Start", "accumulatedResults", "totalApks", "$fun$totalItems$1", "tTotalStart", "tStage2Start"}, s = {"J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "J$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "J$1", "L$0", "L$1", "L$2", "J$0", "J$1"})
    static final class C01711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isCloudScan;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        final /* synthetic */ SafeCheckViewModel this$0;

        /* JADX INFO: renamed from: com.bytedanceos.securitycenter.SafeCheckViewModel$startScan$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: SafeCheckViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"totalItems", "", "invoke"}, k = 3, mv = {1, 4, 3})
        static final class C00341 extends Lambda implements Function0<Integer> {
            final /* synthetic */ ScanPlan $scanPlan;
            final /* synthetic */ Ref.IntRef $totalApks;
            final /* synthetic */ Ref.IntRef $totalApps;

            C00341(ScanPlan r1, Ref.IntRef r2, Ref.IntRef r3) {
                this.$scanPlan = r1;
                this.$totalApps = r2;
                this.$totalApks = r3;
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return ((this.$scanPlan.getSkippedItems().size() + this.$scanPlan.getPreRiskItems().size()) + this.$totalApps.element) + this.$totalApks.element;
            }
        }

        C01711(SafeCheckViewModel r1, boolean r2, Continuation r3) {
            this.this$0 = r1;
            this.$isCloudScan = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "completion");
            return new C01711(this.this$0, this.$isCloudScan, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C01711) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r26) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            String r5 = "ms";
            switch(this.label) {
                case 0: goto L19;
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                case 10: goto L8;
                case 11: goto L7;
                case 12: goto L6;
                default: goto L5;
            };
        L6:
            ResultKt.throwOnFailure(r26);
        L104:
            return Unit.INSTANCE;
        L7:
            ResultKt.throwOnFailure(r26);
        L94:
            return Unit.INSTANCE;
        L8:
            ResultKt.throwOnFailure(r26);
        L87:
            return Unit.INSTANCE;
        L9:
            long r2 = this.J$1;
            long r8 = this.J$0;
            final C00341 r10 = (C00341) this.L$2;
            final Ref.IntRef r11 = (Ref.IntRef) this.L$1;
            List r12 = (List) this.L$0;
            ResultKt.throwOnFailure(r26);
            String r7 = ", cost=";
            long r3 = r2;
            Object r4 = r1;
            Object r6 = r26;
            String r27 = "SafeCheckTiming";
        L78:
            ScanEngineResult r9 = (ScanEngineResult) r6;
            String r13 = r27;
            Log.i(r13, "engine scanUninstallApks: apks=" + r11.element + r7 + (SystemClock.elapsedRealtime() - r3) + r5);
            if ((r9 instanceof ScanEngineResult.Finished) == false) goto L82;
            r12.addAll(((ScanEngineResult.Finished) r9).getResults());
        L96:
            StringBuilder r14 = new StringBuilder("engine real progress span=");
            if (SafeCheckViewModel.access$getTFirstProgress$p(this.this$0) <= 0) goto L99;
            long r15 = SafeCheckViewModel.access$getTLastProgress$p(this.this$0) - SafeCheckViewModel.access$getTFirstProgress$p(this.this$0);
        L100:
            Log.i(r13, r14.append(r15).append(r5).toString());
            Log.i(r13, "scan total cost=" + (SystemClock.elapsedRealtime() - r8) + "ms, totalItems=" + r10.invoke2());
            SafeCheckViewModel r16 = this.this$0;
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.L$4 = null;
            this.L$5 = null;
            this.L$6 = null;
            this.L$7 = null;
            this.label = 12;
            if (SafeCheckViewModel.access$emitFinished(r16, r12, this) != r4) goto L104;
            return r4;
        L99:
            r15 = -1;
            goto L100
        L82:
            if ((r9 instanceof ScanEngineResult.Error) == false) goto L89;
            SafeCheckViewModel r17 = this.this$0;
            int r18 = ((ScanEngineResult.Error) r9).getErrCode();
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 10;
            if (SafeCheckViewModel.access$emitError(r17, r18, this) != r4) goto L87;
            return r4;
        L89:
            if (Intrinsics.areEqual(r9, ScanEngineResult.Canceled.INSTANCE) == false) goto L96;
            SafeCheckViewModel r19 = this.this$0;
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 11;
            if (SafeCheckViewModel.access$emitCanceled(r19, this) != r4) goto L94;
            return r4;
        L10:
            ResultKt.throwOnFailure(r26);
        L72:
            return Unit.INSTANCE;
        L11:
            ResultKt.throwOnFailure(r26);
        L63:
            return Unit.INSTANCE;
        L12:
            ResultKt.throwOnFailure(r26);
        L56:
            return Unit.INSTANCE;
        L13:
            long r20 = this.J$1;
            r8 = this.J$0;
            r10 = (C00341) this.L$5;
            r11 = (Ref.IntRef) this.L$4;
            final Ref.IntRef r110 = (Ref.IntRef) this.L$3;
            final Ref.IntRef r111 = (Ref.IntRef) this.L$2;
            List r112 = (List) this.L$1;
            List<String> r113 = (List) this.L$0;
            ResultKt.throwOnFailure(r26);
            String r114 = ", cost=";
            String r115 = "ms";
            Object r21 = r26;
            String r28 = "SafeCheckTiming";
            long r22 = r20;
            r4 = r1;
        L47:
            ScanEngineResult r23 = (ScanEngineResult) r21;
            r7 = r114;
            StringBuilder r24 = new StringBuilder("engine scanInstalledPackages: apps=").append(r110.element).append(r7).append(SystemClock.elapsedRealtime() - r22);
            r5 = r115;
            String r25 = r28;
            Log.i(r25, r24.append(r5).toString());
            if ((r23 instanceof ScanEngineResult.Finished) == false) goto L51;
            ScanEngineResult.Finished r29 = (ScanEngineResult.Finished) r23;
            Log.i(r25, "stage1 -> Finished, results=" + r29.getResults().size());
            r112.addAll(r29.getResults());
            r111.element += r110.element;
        L64:
            r12 = r112;
        L67:
            if (SafeCheckViewModel.access$isCanceled$p(this.this$0).get() == false) goto L73;
            SafeCheckViewModel r30 = this.this$0;
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.L$4 = null;
            this.L$5 = null;
            this.L$6 = null;
            this.L$7 = null;
            this.label = 8;
            if (SafeCheckViewModel.access$emitCanceled(r30, this) != r4) goto L72;
            return r4;
        L73:
            Log.i(r25, "before stage2: totalApks=" + r11.element);
            if (r11.element <= 0) goto L95;
            r3 = SystemClock.elapsedRealtime();
            Log.i(r25, "engine scanUninstallApks START, apks=" + r11.element);
            VirusScanEngineDataSource r31 = SafeCheckViewModel.access$getScanEngine$p(this.this$0);
            boolean r116 = this.$isCloudScan;
            r27 = r25;
            Function3<Integer, Integer, String, Unit> r32 = new SafeCheckViewModel$startScan$1$stage2$1(this, r11, r111, r10);
            this.L$0 = r12;
            this.L$1 = r11;
            this.L$2 = r10;
            this.L$3 = null;
            this.L$4 = null;
            this.L$5 = null;
            this.L$6 = null;
            this.L$7 = null;
            this.J$0 = r8;
            this.J$1 = r3;
            this.label = 9;
            r6 = r31.scanUninstallApks(r116, r113, r32, this);
            if (r6 != r4) goto L78;
            return r4;
        L95:
            r13 = r25;
            goto L96
        L51:
            if ((r23 instanceof ScanEngineResult.Error) == false) goto L58;
            ScanEngineResult.Error r33 = (ScanEngineResult.Error) r23;
            Log.i(r25, "stage1 -> Error, errCode=" + r33.getErrCode());
            SafeCheckViewModel r34 = this.this$0;
            int r35 = r33.getErrCode();
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.L$4 = null;
            this.L$5 = null;
            this.label = 6;
            if (SafeCheckViewModel.access$emitError(r34, r35, this) != r4) goto L56;
            return r4;
        L58:
            if (Intrinsics.areEqual(r23, ScanEngineResult.Canceled.INSTANCE) == false) goto L64;
            Log.i(r25, "stage1 -> Canceled");
            SafeCheckViewModel r36 = this.this$0;
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.L$4 = null;
            this.L$5 = null;
            this.label = 7;
            if (SafeCheckViewModel.access$emitCanceled(r36, this) != r4) goto L63;
            return r4;
        L14:
            long r37 = this.J$0;
            Ref.IntRef r38 = (Ref.IntRef) this.L$7;
            final C00341 r39 = (C00341) this.L$6;
            Ref.IntRef r117 = (Ref.IntRef) this.L$5;
            Ref.IntRef r118 = (Ref.IntRef) this.L$4;
            Ref.IntRef r119 = (Ref.IntRef) this.L$3;
            List r120 = (List) this.L$2;
            List<String> r121 = (List) this.L$1;
            ScanPlan r122 = (ScanPlan) this.L$0;
            ResultKt.throwOnFailure(r26);
            r115 = "ms";
            List<String> r40 = r121;
            r112 = r120;
            r111 = r119;
            r110 = r118;
            r11 = r117;
            String r123 = ", cost=";
            long r41 = r37;
            r4 = r1;
            Object r42 = r26;
            r28 = "SafeCheckTiming";
        L41:
            r38.element = ((Number) r42).intValue();
            if (r110.element <= 0) goto L65;
            r22 = SystemClock.elapsedRealtime();
            VirusScanEngineDataSource r43 = SafeCheckViewModel.access$getScanEngine$p(this.this$0);
            boolean r44 = this.$isCloudScan;
            List<String> r124 = r122.getInstalledPkgs();
            r114 = r123;
            Function3<Integer, Integer, String, Unit> r125 = new SafeCheckViewModel$startScan$1$stage1$1(this, r110, r111, r39);
            this.L$0 = r40;
            this.L$1 = r112;
            this.L$2 = r111;
            this.L$3 = r110;
            this.L$4 = r11;
            this.L$5 = r39;
            List<String> r126 = r40;
            this.L$6 = null;
            this.L$7 = null;
            this.J$0 = r41;
            this.J$1 = r22;
            this.label = 5;
            r21 = r43.scanInstalledPackages(r44, r124, r125, this);
            if (r21 != r4) goto L46;
            return r4;
        L46:
            r10 = r39;
            r113 = r126;
            r8 = r41;
            goto L47
        L65:
            r25 = r28;
            List<String> r127 = r40;
            r7 = r123;
            r5 = r115;
            r10 = r39;
            r12 = r112;
            r113 = r127;
            r8 = r41;
            goto L67
        L15:
            long r45 = this.J$1;
            long r46 = this.J$0;
            Ref.IntRef r128 = (Ref.IntRef) this.L$7;
            C00341 r129 = (C00341) this.L$6;
            Ref.IntRef r130 = (Ref.IntRef) this.L$5;
            Ref.IntRef r131 = (Ref.IntRef) this.L$4;
            Ref.IntRef r132 = (Ref.IntRef) this.L$3;
            List r133 = (List) this.L$2;
            r40 = (List) this.L$1;
            ScanPlan r47 = (ScanPlan) this.L$0;
            ResultKt.throwOnFailure(r26);
            Object r48 = r26;
            r28 = "SafeCheckTiming";
            r4 = r1;
            r122 = r47;
            r115 = "ms";
            long r49 = r46;
            r38 = r132;
            List r50 = r133;
            long r51 = r45;
        L37:
            r128.element = ((Number) r48).intValue();
            r123 = ", cost=";
            String r52 = r28;
            Log.i(r52, new StringBuilder("skipped display: count=").append(r122.getSkippedItems().size()).append(r123).append(SystemClock.elapsedRealtime() - r51).append(r115).toString());
            SafeCheckViewModel r53 = this.this$0;
            List<ScanDisplayItem> r134 = r122.getPreRiskItems();
            int r54 = r38.element;
            int r55 = r129.invoke2();
            this.L$0 = r122;
            this.L$1 = r40;
            this.L$2 = r50;
            this.L$3 = r38;
            this.L$4 = r131;
            this.L$5 = r130;
            this.L$6 = r129;
            this.L$7 = r38;
            this.J$0 = r49;
            long r135 = r49;
            this.label = 4;
            r42 = SafeCheckViewModel.access$emitInstantDisplayItems(r53, r134, r54, r55, this);
            if (r42 != r4) goto L40;
            return r4;
        L40:
            r112 = r50;
            r39 = r129;
            r11 = r130;
            r110 = r131;
            r41 = r135;
            r111 = r38;
            goto L41
        L16:
            ResultKt.throwOnFailure(r26);
        L32:
            return Unit.INSTANCE;
        L17:
            long r56 = this.J$0;
            ResultKt.throwOnFailure(r26);
        L18:
            long r57 = r56;
            ScanPlan r58 = SafeCheckViewModel.access$getScanPlanBuilder$p(this.this$0).build(new SafeCheckViewModel$startScan$1$scanPlan$1(this));
            long r136 = SystemClock.elapsedRealtime();
            r40 = SafeCheckViewModel.access$getApkFileDataSource$p(this.this$0).getLocalApkPaths(new SafeCheckViewModel$startScan$1$localApkPaths$1(this));
            Log.i("SafeCheckTiming", "getLocalApkPaths: count=" + r40.size() + ", cost=" + (SystemClock.elapsedRealtime() - r136) + "ms");
            ArrayList r137 = new ArrayList();
            r137.addAll(r58.getPreRiskResults());
            r128 = new Ref.IntRef();
            r128.element = 0;
            r131 = new Ref.IntRef();
            r131.element = r58.getInstalledPkgs().size();
            r130 = new Ref.IntRef();
            r130.element = r40.size();
            r129 = new C00341(r58, r131, r130);
            if (r129.invoke2() != 0) goto L33;
            SafeCheckViewModel r59 = this.this$0;
            this.label = 2;
            if (SafeCheckViewModel.access$emitFinished(r59, r137, this) != r1) goto L32;
            return r1;
        L33:
            r51 = SystemClock.elapsedRealtime();
            r28 = "SafeCheckTiming";
            SafeCheckViewModel r138 = this.this$0;
            r115 = "ms";
            List<ScanDisplayItem> r60 = r58.getSkippedItems();
            int r61 = r128.element;
            int r62 = r129.invoke2();
            this.L$0 = r58;
            this.L$1 = r40;
            this.L$2 = r137;
            this.L$3 = r128;
            this.L$4 = r131;
            this.L$5 = r130;
            this.L$6 = r129;
            this.L$7 = r128;
            this.J$0 = r57;
            this.J$1 = r51;
            this.label = 3;
            r48 = SafeCheckViewModel.access$emitSkippedDisplayItems(r138, r60, r61, r62, this);
            r4 = r1;
            if (r48 != r4) goto L36;
            return r4;
        L36:
            r49 = r57;
            r38 = r128;
            r50 = r137;
            r122 = r58;
            goto L37
        L19:
            ResultKt.throwOnFailure(r26);
            SafeCheckViewModel.access$getScanEngine$p(this.this$0).initScanner();
            r56 = SystemClock.elapsedRealtime();
            Log.i("SafeCheckTiming", "scan start");
            if (SafeCheckViewModel.access$isCanceled$p(this.this$0).get() == true) goto L22;
            SafeCheckViewModel r63 = this.this$0;
            String r64 = r63.getApplication().getString(R.string.safe_check_scan_initializing);
            Intrinsics.checkNotNullExpressionValue(r64, "getApplication<Applicati…_check_scan_initializing)");
            this.J$0 = r56;
            this.label = 1;
            if (SafeCheckViewModel.access$emitScanning(r63, 0, r64, this) != r1) goto L18;
            return r1;
        L22:
            return Unit.INSTANCE;
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SafeCheckViewModel(Application r3) {
        Intrinsics.checkNotNullParameter(r3, "application");
        super(r3);
        MutableLiveData<ScanState> r0 = new MutableLiveData(ScanState.Idle.INSTANCE);
        this._scanState = r0;
        this.scanState = r0;
        MutableLiveData<Boolean> r1 = new MutableLiveData();
        this._virusDbUpdateAvailable = r1;
        this.virusDbUpdateAvailable = r1;
        this.scanPlanBuilder = SafeCheckScanDependencies.INSTANCE.getScanPlanBuilderFactory().invoke(r3);
        this.apkFileDataSource = SafeCheckScanDependencies.INSTANCE.getApkFileDataSourceFactory().invoke();
        this.scanEngine = SafeCheckScanDependencies.INSTANCE.getScanEngineDataSourceFactory().invoke();
        this.isCanceled = new AtomicBoolean(false);
    }

    public static final /* synthetic */ Object access$emitCanceled(SafeCheckViewModel r0, Continuation r1) {
        return r0.emitCanceled(r1);
    }

    public static final /* synthetic */ Object access$emitError(SafeCheckViewModel r0, int r1, Continuation r2) {
        return r0.emitError(r1, r2);
    }

    public static final /* synthetic */ Object access$emitFinished(SafeCheckViewModel r0, List r1, Continuation r2) {
        return r0.emitFinished(r1, r2);
    }

    public static final /* synthetic */ Object access$emitInstantDisplayItems(SafeCheckViewModel r0, List r1, int r2, int r3, Continuation r4) {
        return r0.emitInstantDisplayItems(r1, r2, r3, r4);
    }

    public static final /* synthetic */ Object access$emitScanning(SafeCheckViewModel r0, int r1, String r2, Continuation r3) {
        return r0.emitScanning(r1, r2, r3);
    }

    public static final /* synthetic */ Object access$emitSkippedDisplayItems(SafeCheckViewModel r0, List r1, int r2, int r3, Continuation r4) {
        return r0.emitSkippedDisplayItems(r1, r2, r3, r4);
    }

    public static final /* synthetic */ ApkFileDataSource access$getApkFileDataSource$p(SafeCheckViewModel r0) {
        return r0.apkFileDataSource;
    }

    public static final /* synthetic */ VirusScanEngineDataSource access$getScanEngine$p(SafeCheckViewModel r0) {
        return r0.scanEngine;
    }

    public static final /* synthetic */ ScanPlanBuilder access$getScanPlanBuilder$p(SafeCheckViewModel r0) {
        return r0.scanPlanBuilder;
    }

    public static final /* synthetic */ long access$getTFirstProgress$p(SafeCheckViewModel r2) {
        return r2.tFirstProgress;
    }

    public static final /* synthetic */ long access$getTLastProgress$p(SafeCheckViewModel r2) {
        return r2.tLastProgress;
    }

    public static final /* synthetic */ MutableLiveData access$get_scanState$p(SafeCheckViewModel r0) {
        return r0._scanState;
    }

    public static final /* synthetic */ MutableLiveData access$get_virusDbUpdateAvailable$p(SafeCheckViewModel r0) {
        return r0._virusDbUpdateAvailable;
    }

    public static final /* synthetic */ AtomicBoolean access$isCanceled$p(SafeCheckViewModel r0) {
        return r0.isCanceled;
    }

    public static final /* synthetic */ void access$postScanning(SafeCheckViewModel r0, int r1, String r2) {
        r0.postScanning(r1, r2);
    }

    public static final /* synthetic */ int access$scanProgress(SafeCheckViewModel r0, int r1, int r2) {
        return r0.scanProgress(r1, r2);
    }

    public static final /* synthetic */ void access$setTFirstProgress$p(SafeCheckViewModel r0, long r1) {
        r0.tFirstProgress = r1;
    }

    public static final /* synthetic */ void access$setTLastProgress$p(SafeCheckViewModel r0, long r1) {
        r0.tLastProgress = r1;
    }

    public final LiveData<ScanState> getScanState() {
        return this.scanState;
    }

    public final LiveData<Boolean> getVirusDbUpdateAvailable() {
        return this.virusDbUpdateAvailable;
    }

    public final void startScan(boolean r10) {
        Job r0 = this.scanJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.isCanceled.set(false);
        this.tFirstProgress = 0;
        this.tLastProgress = 0;
        this._scanState.setValue(ScanState.Idle.INSTANCE);
        this.scanJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), SafeCheckScanDependencies.INSTANCE.getIoDispatcher(), null, new C01711(this, r10, null), 2, null);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00a1 -> B:13:0x0038). Please report as a decompilation issue!!! */
    private final Object emitSkippedDisplayItems(List<ScanDisplayItem> r9, int r10, int r11, Continuation<? super Integer> r12) {
        if ((r12 instanceof C01681) == false) goto L7;
        C01681 r0 = (C01681) r12;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L17;
        if (r2 == 1) goto L16;
        if (r2 != 2) goto L15;
        int r8 = r0.I$1;
        int r14 = r0.I$0;
        Iterator<ScanDisplayItem> r15 = (Iterator) r0.L$1;
        SafeCheckViewModel r16 = (SafeCheckViewModel) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L13:
        Iterator<ScanDisplayItem> r7 = r15;
        r10 = r8;
        SafeCheckViewModel this = r16;
        r11 = r14;
        Iterator<ScanDisplayItem> r17 = r7;
    L19:
        if (r17.hasNext() == false) goto L30;
        ScanDisplayItem r18 = r17.next();
        if (this.isCanceled.get() == true) goto L30;
        int r19 = r10 + 1;
        int r3 = this.scanProgress(r19, r11);
        String r110 = r18.getDisplayName();
        r0.L$0 = this;
        r0.L$1 = r17;
        r0.I$0 = r11;
        r0.I$1 = r19;
        r0.label = 1;
        if (this.emitScanning(r3, r110, r0) != r1) goto L25;
        return r1;
    L25:
        int r20 = r11;
        r16 = this;
        r8 = r19;
        r15 = r17;
        r14 = r20;
    L26:
        r0.L$0 = r16;
        r0.L$1 = r15;
        r0.I$0 = r14;
        r0.I$1 = r8;
        r0.label = 2;
        if (DelayKt.delay(30, r0) != r1) goto L13;
        return r1;
    L30:
        return Boxing.boxInt(r10);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r8 = r0.I$1;
        r14 = r0.I$0;
        r15 = (Iterator) r0.L$1;
        r16 = (SafeCheckViewModel) r0.L$0;
        ResultKt.throwOnFailure(r13);
        goto L26
    L17:
        ResultKt.throwOnFailure(r13);
        r17 = r9.iterator();
    L7:
        r0 = new C01681(this, r12);
        goto L8
    }

    private final Object emitInstantDisplayItems(List<ScanDisplayItem> r6, int r7, int r8, Continuation<? super Integer> r9) {
        if ((r9 instanceof C01661) == false) goto L7;
        C01661 r0 = (C01661) r9;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        int r5 = r0.I$1;
        int r11 = r0.I$0;
        Iterator<ScanDisplayItem> r12 = (Iterator) r0.L$1;
        SafeCheckViewModel r13 = (SafeCheckViewModel) r0.L$0;
        ResultKt.throwOnFailure(r10);
        int r14 = r5;
        SafeCheckViewModel this = r13;
        r8 = r11;
    L16:
        if (r12.hasNext() == false) goto L23;
        ScanDisplayItem r15 = r12.next();
        if (this.isCanceled.get() == true) goto L23;
        r14 = r14 + 1;
        int r3 = this.scanProgress(r14, r8);
        String r16 = r15.getDisplayName();
        r0.L$0 = this;
        r0.L$1 = r12;
        r0.I$0 = r8;
        r0.I$1 = r14;
        r0.label = 1;
        if (this.emitScanning(r3, r16, r0) != r1) goto L16;
        return r1;
    L23:
        return Boxing.boxInt(r14);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        r12 = r6.iterator();
        r14 = r7;
    L7:
        r0 = new C01661(this, r9);
        goto L8
    }

    private final int scanProgress(int r1, int r2) {
        if (r2 > 0) goto L6;
        return 0;
    L6:
        return RangesKt.coerceIn((r1 * 100) / r2, 0, 99);
    }

    private final Object emitScanning(int r4, String r5, Continuation<? super Unit> r6) {
        Object r3 = BuildersKt.withContext(SafeCheckScanDependencies.INSTANCE.getMainDispatcher(), new C01672(this, r4, r5, null), r6);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Unit.INSTANCE;
    }

    private final void postScanning(int r11, String r12) {
        long r0 = SystemClock.elapsedRealtime();
        if (this.tFirstProgress != 0) goto L5;
        this.tFirstProgress = r0;
        Log.i("SafeCheckTiming", "engine first progress callback");
    L5:
        this.tLastProgress = r0;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), SafeCheckScanDependencies.INSTANCE.getMainDispatcher(), null, new C01691(this, r11, r12, null), 2, null);
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [T, java.util.List] */
    private final Object emitFinished(List<? extends QScanResultEntity> r4, Continuation<? super Unit> r5) {
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = CollectionsKt.toList(r4);
        Object r3 = BuildersKt.withContext(SafeCheckScanDependencies.INSTANCE.getMainDispatcher(), new C01652(this, r0, null), r5);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Unit.INSTANCE;
    }

    private final Object emitError(int r4, Continuation<? super Unit> r5) {
        Object r3 = BuildersKt.withContext(SafeCheckScanDependencies.INSTANCE.getMainDispatcher(), new C01642(this, r4, null), r5);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Unit.INSTANCE;
    }

    private final Object emitCanceled(Continuation<? super Unit> r4) {
        Object r3 = BuildersKt.withContext(SafeCheckScanDependencies.INSTANCE.getMainDispatcher(), new AnonymousClass2(this, null), r4);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Unit.INSTANCE;
    }

    public final void checkVirusDbUpdate() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), SafeCheckScanDependencies.INSTANCE.getIoDispatcher(), null, new AnonymousClass1(this, null), 2, null);
    }

    public final void refreshVirusDbBadge() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), SafeCheckScanDependencies.INSTANCE.getIoDispatcher(), null, new C01701(this, null), 2, null);
    }

    public final void cancelScan() {
        this.isCanceled.set(true);
        Job r0 = this.scanJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.scanEngine.cancelScan();
        this._scanState.postValue(ScanState.Canceled.INSTANCE);
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        cancelScan();
        super.onCleared();
    }
}
