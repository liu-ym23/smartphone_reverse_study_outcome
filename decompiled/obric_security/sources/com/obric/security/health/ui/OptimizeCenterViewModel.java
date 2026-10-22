package com.obric.security.health.ui;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedanceos.securitycenter.appBgBatteryControl.AppBgBatteryControlDataHelper;
import com.obric.security.R;
import com.obric.security.health.model.HealthCheckItemPresentation;
import com.obric.security.health.model.HealthCheckItemSnapshot;
import com.obric.security.health.model.HealthCheckStatus;
import com.obric.security.health.model.HealthFixCapability;
import com.obric.security.health.model.HealthModulePresentation;
import com.obric.security.health.model.HealthModuleSnapshot;
import com.obric.security.health.model.HealthScoreSnapshot;
import com.obric.security.health.model.HealthTaskProgressEvent;
import com.obric.security.health.score.HealthScoreLog;
import com.obric.security.service.SecurityServiceBinder;
import com.obric.securitycenter.api.Const;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: OptimizeCenterViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¥\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011*\u0001\t\u0018\u0000 _2\u00020\u0001:\u0001_B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0013H\u0002J\b\u0010&\u001a\u00020\u0007H\u0002J\u0011\u0010'\u001a\u00020$H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010(J\u0014\u0010)\u001a\u0004\u0018\u00010\u00132\b\u0010*\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020-H\u0002J)\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020-2\u0012\u0010.\u001a\n\u0012\u0006\b\u0001\u0012\u0002000/\"\u000200H\u0002¢\u0006\u0002\u00101J\u0010\u00102\u001a\u00020$2\u0006\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u00020$H\u0002J\u0010\u00106\u001a\u00020$2\u0006\u00103\u001a\u000204H\u0002J\b\u00107\u001a\u00020$H\u0002J\u0010\u00108\u001a\u00020$2\u0006\u00103\u001a\u000204H\u0002J\u0010\u00109\u001a\u00020\u00132\u0006\u0010:\u001a\u00020\u0015H\u0002J\u0018\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e2\b\u0010<\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010=\u001a\u00020$H\u0014J\u001a\u0010>\u001a\u00020\u00132\b\u0010*\u001a\u0004\u0018\u00010\u00132\u0006\u0010?\u001a\u00020\u0013H\u0002J\u001a\u0010@\u001a\u00020$2\u0006\u0010*\u001a\u00020\u00132\n\b\u0002\u0010A\u001a\u0004\u0018\u00010BJ \u0010C\u001a\u00020$2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00130E2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010BJ\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u000e2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020G0\u000eH\u0002J\u0006\u0010I\u001a\u00020$J\u0010\u0010J\u001a\u00020$2\u0006\u0010K\u001a\u00020LH\u0002J \u0010M\u001a\u00020$2\u0006\u0010<\u001a\u00020\u00112\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u0013H\u0002J\u001c\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00150\u000eH\u0002J\u0010\u0010S\u001a\u00020$2\u0006\u0010<\u001a\u00020\u0011H\u0002J\u0006\u0010T\u001a\u00020$J\u0010\u0010U\u001a\u00020$2\u0006\u0010<\u001a\u00020\u0011H\u0002J\u0012\u0010V\u001a\u00020$2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010BJ*\u0010W\u001a\u00020$2\u0006\u0010<\u001a\u00020\u00112\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00130E2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010BH\u0002J\u0006\u0010Z\u001a\u00020$J\u0012\u0010[\u001a\u0004\u0018\u00010L2\u0006\u00103\u001a\u000204H\u0002J\f\u0010\\\u001a\u00020\u0015*\u00020\u0015H\u0002J\f\u0010]\u001a\u00020\u0015*\u00020\u0015H\u0002J\u0014\u0010^\u001a\u00020\u0015*\u00020\u00152\u0006\u0010K\u001a\u00020LH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006`"}, d2 = {"Lcom/obric/security/health/ui/OptimizeCenterViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_uiState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/obric/security/health/ui/OptimizeCenterUiState;", "eventCallback", "com/obric/security/health/ui/OptimizeCenterViewModel$eventCallback$1", "Lcom/obric/security/health/ui/OptimizeCenterViewModel$eventCallback$1;", "ignoringNavigateOnlyOptimizeResult", "", "itemPresentations", "", "Lcom/obric/security/health/model/HealthCheckItemPresentation;", "latestSnapshot", "Lcom/obric/security/health/model/HealthScoreSnapshot;", "moduleOrder", "", "moduleTemplates", "Lcom/obric/security/health/ui/OptimizeModuleUi;", "optimizeFinishPending", "optimizeRunning", "optimizeStartedAtMillis", "", "pendingResultRefreshAfterNavigate", "refreshingResultScan", "securityService", "Lcom/obric/security/service/SecurityServiceBinder;", "uiState", "Landroidx/lifecycle/LiveData;", "getUiState", "()Landroidx/lifecycle/LiveData;", "waitingScanForOptimize", "cancelResultRefreshIfNeeded", "", AppBgBatteryControlDataHelper.ItemColumns.REASON, PerfConsts.KEY_CURRENT_GALVANIC, "delayRemainingOptimizeDuration", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findModuleIdByItemId", "itemId", "getString", "resId", "", "args", "", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "handleBinderEvent", AppBgBatteryControlDataHelper.ItemColumns.PARAM, "Landroid/os/Bundle;", "handleOptimizeFinish", "handleOptimizeProgress", "handleResultRefreshScanFinish", "handleScanProgress", "moduleTitle", "module", "moduleUisForRun", "snapshot", "onCleared", "optimizeTitle", "fallbackTitle", "optimizeTodoItem", "context", "Landroid/content/Context;", "optimizeTodoItems", "itemIds", "", "recommendationTodos", "Lcom/obric/security/health/model/HealthCheckItemSnapshot;", "items", "refreshResultOnResume", "renderProgress", "event", "Lcom/obric/security/health/model/HealthTaskProgressEvent;", "renderResult", "phase", "Lcom/obric/security/health/ui/OptimizeCenterPhase;", "bottomAction", "runningModules", "currentModules", "showFinalResult", "showResult", "showResultPage", "startOptimize", "startOptimizeWithSnapshot", "optimizeItemIds", "runtimeContext", "stopOptimize", "taskProgressEvent", "asDone", "asPending", "asRunning", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class OptimizeCenterViewModel extends AndroidViewModel {
    private static final Companion Companion = null;

    @Deprecated
    private static final long MIN_OPTIMIZE_DURATION_MS = 1000;

    @Deprecated
    private static final String SOURCE = "OptimizeCenterViewModel";
    private final MutableLiveData<OptimizeCenterUiState> _uiState;
    private final OptimizeCenterViewModel$eventCallback$1 eventCallback;
    private boolean ignoringNavigateOnlyOptimizeResult;
    private List<HealthCheckItemPresentation> itemPresentations;
    private HealthScoreSnapshot latestSnapshot;
    private List<String> moduleOrder;
    private List<OptimizeModuleUi> moduleTemplates;
    private boolean optimizeFinishPending;
    private boolean optimizeRunning;
    private long optimizeStartedAtMillis;
    private boolean pendingResultRefreshAfterNavigate;
    private boolean refreshingResultScan;
    private final SecurityServiceBinder securityService;
    private final LiveData<OptimizeCenterUiState> uiState;
    private boolean waitingScanForOptimize;

    /* JADX INFO: compiled from: OptimizeCenterViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/security/health/ui/OptimizeCenterViewModel$Companion;", "", "()V", "MIN_OPTIMIZE_DURATION_MS", "", "SOURCE", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.security.health.ui.OptimizeCenterViewModel$handleOptimizeFinish$1, reason: invalid class name */
    /* JADX INFO: compiled from: OptimizeCenterViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.ui.OptimizeCenterViewModel$handleOptimizeFinish$1", f = "OptimizeCenterViewModel.kt", i = {}, l = {329}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ HealthScoreSnapshot $snapshot;
        int label;
        final /* synthetic */ OptimizeCenterViewModel this$0;

        AnonymousClass1(OptimizeCenterViewModel r1, HealthScoreSnapshot r2, Continuation r3) {
            this.this$0 = r1;
            this.$snapshot = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "completion");
            return new AnonymousClass1(this.this$0, this.$snapshot, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            if (OptimizeCenterViewModel.access$getOptimizeRunning$p(this.this$0) == false) goto L14;
            OptimizeCenterViewModel.access$setOptimizeRunning$p(this.this$0, false);
            OptimizeCenterViewModel.access$setOptimizeFinishPending$p(this.this$0, false);
            OptimizeCenterViewModel.access$showFinalResult(this.this$0, this.$snapshot);
            return Unit.INSTANCE;
        L14:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            OptimizeCenterViewModel r5 = this.this$0;
            this.label = 1;
            if (OptimizeCenterViewModel.access$delayRemainingOptimizeDuration(r5, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.security.health.ui.OptimizeCenterViewModel$startOptimizeWithSnapshot$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OptimizeCenterViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.ui.OptimizeCenterViewModel$startOptimizeWithSnapshot$1", f = "OptimizeCenterViewModel.kt", i = {}, l = {257}, m = "invokeSuspend", n = {}, s = {})
    static final class C03861 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ HealthScoreSnapshot $snapshot;
        int label;
        final /* synthetic */ OptimizeCenterViewModel this$0;

        C03861(OptimizeCenterViewModel r1, HealthScoreSnapshot r2, Continuation r3) {
            this.this$0 = r1;
            this.$snapshot = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "completion");
            return new C03861(this.this$0, this.$snapshot, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C03861) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            if (OptimizeCenterViewModel.access$getOptimizeRunning$p(this.this$0) == false) goto L14;
            OptimizeCenterViewModel.access$setOptimizeRunning$p(this.this$0, false);
            OptimizeCenterViewModel.access$setOptimizeFinishPending$p(this.this$0, false);
            OptimizeCenterViewModel.access$showFinalResult(this.this$0, this.$snapshot);
            return Unit.INSTANCE;
        L14:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            OptimizeCenterViewModel r5 = this.this$0;
            this.label = 1;
            if (OptimizeCenterViewModel.access$delayRemainingOptimizeDuration(r5, this) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OptimizeCenterViewModel(Application r17) {
        Intrinsics.checkNotNullParameter(r17, "application");
        super(r17);
        SecurityServiceBinder r1 = SecurityServiceBinder.Companion.getInstance();
        this.securityService = r1;
        this.moduleTemplates = CollectionsKt.emptyList();
        this.itemPresentations = CollectionsKt.emptyList();
        this.moduleOrder = CollectionsKt.emptyList();
        MutableLiveData<OptimizeCenterUiState> r2 = new MutableLiveData();
        this._uiState = r2;
        this.uiState = r2;
        this.eventCallback = new OptimizeCenterViewModel$eventCallback$1(this);
        r1.onCreate();
        List<HealthModulePresentation> r3 = r1.getVisibleHealthModulePresentations();
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        HealthModulePresentation r6 = (HealthModulePresentation) r5.next();
        r4.add(new OptimizeModuleUi(r6.getId(), r6.getTitleResId(), r6.getIconResId(), OptimizeModuleStatus.PENDING, getString(R.string.health_running_prepare), 0, null, 96, null));
        goto L4
    L6:
        this.moduleTemplates = r4;
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r3.iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        CollectionsKt.addAll(r7, ((HealthModulePresentation) r8.next()).getItems());
        goto L8
    L10:
        this.itemPresentations = r7;
        List<OptimizeModuleUi> r9 = this.moduleTemplates;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r11 = r9.iterator();
    L12:
        if (r11.hasNext() == false) goto L14;
        r10.add(((OptimizeModuleUi) r11.next()).getModuleId());
        goto L12
    L14:
        this.moduleOrder = r10;
        this.securityService.subscribe(this.eventCallback);
        HealthScoreSnapshot r12 = this.securityService.getHealthSnapshot();
        this.latestSnapshot = r12;
        HealthScoreLog r13 = HealthScoreLog.INSTANCE;
        StringBuilder r14 = new StringBuilder("init score=");
        List<HealthCheckItemSnapshot> r15 = null;
        if (r12 == null) goto L17;
        Integer r16 = Integer.valueOf(r12.getTotal());
    L18:
        StringBuilder r18 = r14.append(r16).append(" modules=").append(this.moduleTemplates.size()).append(" todo=");
        if (r12 == null) goto L23;
        List<HealthCheckItemSnapshot> r19 = r12.getTodoItems();
        if (r19 == null) goto L23;
        Integer r20 = Integer.valueOf(r19.size());
    L24:
        r13.i(SOURCE, r18.append(r20).toString());
        MutableLiveData<OptimizeCenterUiState> r21 = this._uiState;
        OptimizeCenterPhase r22 = OptimizeCenterPhase.OPTIMIZING;
        if (r12 == null) goto L27;
        int r23 = r12.getTotal();
    L28:
        int r24 = r23;
        List<OptimizeModuleUi> r25 = moduleUisForRun(r12);
        if (r12 == null) goto L31;
        List<HealthCheckItemSnapshot> r0 = r12.getCompletedItems();
    L32:
        if (r0 != null) goto L34;
        r0 = CollectionsKt.emptyList();
    L34:
        List<HealthCheckItemSnapshot> r26 = r0;
        if (r12 == null) goto L37;
        r15 = r12.getTodoItems();
    L37:
        if (r15 != null) goto L39;
        List<HealthCheckItemSnapshot> r110 = CollectionsKt.emptyList();
    L40:
        r21.setValue(new OptimizeCenterUiState(r22, r24, r25, r26, r110, null, 32, null));
        return;
    L39:
        r110 = r15;
        goto L40
    L31:
        r0 = null;
        goto L32
    L27:
        r23 = 100;
    L23:
        r20 = null;
        goto L24
    L17:
        r16 = null;
        goto L18
    }

    public static final /* synthetic */ Object access$delayRemainingOptimizeDuration(OptimizeCenterViewModel r0, Continuation r1) {
        return r0.delayRemainingOptimizeDuration(r1);
    }

    public static final /* synthetic */ boolean access$getOptimizeFinishPending$p(OptimizeCenterViewModel r0) {
        return r0.optimizeFinishPending;
    }

    public static final /* synthetic */ boolean access$getOptimizeRunning$p(OptimizeCenterViewModel r0) {
        return r0.optimizeRunning;
    }

    public static final /* synthetic */ void access$handleBinderEvent(OptimizeCenterViewModel r0, Bundle r1) {
        r0.handleBinderEvent(r1);
    }

    public static final /* synthetic */ void access$setOptimizeFinishPending$p(OptimizeCenterViewModel r0, boolean r1) {
        r0.optimizeFinishPending = r1;
    }

    public static final /* synthetic */ void access$setOptimizeRunning$p(OptimizeCenterViewModel r0, boolean r1) {
        r0.optimizeRunning = r1;
    }

    public static final /* synthetic */ void access$showFinalResult(OptimizeCenterViewModel r0, HealthScoreSnapshot r1) {
        r0.showFinalResult(r1);
    }

    public final LiveData<OptimizeCenterUiState> getUiState() {
        return this.uiState;
    }

    public static /* synthetic */ void startOptimize$default(OptimizeCenterViewModel r0, Context r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
        Context r4 = (Context) null;
    L5:
        r0.startOptimize(r1);
    }

    public final void startOptimize(Context r11) {
        if (this.optimizeRunning == false) goto L6;
        HealthScoreLog.INSTANCE.d(SOURCE, "startOptimize ignored optimizeRunning=true");
        return;
    L6:
        cancelResultRefreshIfNeeded("startOptimize");
        HealthScoreLog r0 = HealthScoreLog.INSTANCE;
        StringBuilder r2 = new StringBuilder("startOptimize score=");
        HealthScoreSnapshot r3 = this.latestSnapshot;
        if (r3 == null) goto L9;
        Integer r4 = Integer.valueOf(r3.getTotal());
    L10:
        StringBuilder r5 = r2.append(r4).append(" hasContext=");
        if (r11 == null) goto L13;
        boolean r6 = true;
    L14:
        r0.i(SOURCE, r5.append(r6).toString());
        this.waitingScanForOptimize = true;
        this.optimizeRunning = true;
        this.optimizeStartedAtMillis = System.currentTimeMillis();
        this.optimizeFinishPending = false;
        this._uiState.setValue(OptimizeCenterUiState.copy$default(current(), OptimizeCenterPhase.OPTIMIZING, 0, moduleUisForRun(this.latestSnapshot), null, null, getString(R.string.optimize_action_cancel), 26, null));
        this.securityService.startAutoOptimizeItems(r11);
        return;
    L13:
        r6 = false;
        goto L14
    L9:
        r4 = null;
        goto L10
    }

    public final void stopOptimize() {
        if (current().getPhase() != OptimizeCenterPhase.OPTIMIZING) goto L6;
        HealthScoreLog.INSTANCE.i(SOURCE, "stopOptimize");
        this.waitingScanForOptimize = false;
        this.refreshingResultScan = false;
        this.pendingResultRefreshAfterNavigate = false;
        this.optimizeRunning = false;
        this.optimizeFinishPending = false;
        this.securityService.stopScanTrashAndMem();
        this.securityService.stopOptimizeItems();
        return;
    }

    public final void showResult() {
        HealthScoreSnapshot r0 = this.securityService.getHealthSnapshot();
        if (r0 != null) goto L5;
        r0 = this.latestSnapshot;
    L5:
        if (r0 != null) goto L7;
        return;
    L7:
        showResultPage(r0);
    }

    public final void refreshResultOnResume() {
        if (current().getPhase() == OptimizeCenterPhase.RESULT) goto L5;
    L25:
        HealthScoreLog.INSTANCE.d(SOURCE, "refreshResultOnResume ignored phase=" + current().getPhase() + " optimizeRunning=" + this.optimizeRunning + " waitingScanForOptimize=" + this.waitingScanForOptimize + " refreshingResultScan=" + this.refreshingResultScan + " ignoringNavigateOnlyOptimizeResult=" + this.ignoringNavigateOnlyOptimizeResult);
        return;
    L5:
        if (this.optimizeRunning == true) goto L25;
        if (this.waitingScanForOptimize == true) goto L25;
        if (this.refreshingResultScan == true) goto L25;
        if (this.ignoringNavigateOnlyOptimizeResult == false) goto L15;
        this.pendingResultRefreshAfterNavigate = true;
        HealthScoreLog.INSTANCE.d(SOURCE, "refreshResultOnResume waitNavigateOptimizeFinish");
        return;
    L15:
        List<HealthCheckItemSnapshot> r0 = current().getTodoItems();
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r1 = r0.iterator();
    L17:
        if (r1.hasNext() == false) goto L19;
        r3.add(((HealthCheckItemSnapshot) r1.next()).getId());
        goto L17
    L19:
        Set<String> r2 = CollectionsKt.toSet(r3);
        if (r2.isEmpty() == false) goto L23;
        HealthScoreLog.INSTANCE.d(SOURCE, "refreshResultOnResume ignored noRecommendationItem");
        return;
    L23:
        this.refreshingResultScan = true;
        HealthScoreLog.INSTANCE.i(SOURCE, "refreshResultOnResume start itemIds=" + r2);
        this.securityService.startScanHealthItems(r2);
    }

    public static /* synthetic */ void optimizeTodoItem$default(OptimizeCenterViewModel r0, String r1, Context r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
        Context r5 = (Context) null;
    L5:
        r0.optimizeTodoItem(r1, r2);
    }

    public final void optimizeTodoItem(String r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "itemId");
        optimizeTodoItems(SetsKt.setOf(r2), r3);
    }

    public static /* synthetic */ void optimizeTodoItems$default(OptimizeCenterViewModel r0, Set r1, Context r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
        Context r5 = (Context) null;
    L5:
        r0.optimizeTodoItems(r1, r2);
    }

    public final void optimizeTodoItems(Set<String> r10, Context r11) {
        Intrinsics.checkNotNullParameter(r10, "itemIds");
        if (this.optimizeRunning == false) goto L6;
        HealthScoreLog.INSTANCE.d(SOURCE, "optimizeTodoItems ignored running itemIds=" + r10);
        return;
    L6:
        cancelResultRefreshIfNeeded("optimizeTodoItems");
        HealthScoreSnapshot r0 = this.securityService.getHealthSnapshot();
        if (r0 != null) goto L9;
        r0 = this.latestSnapshot;
    L9:
        if (r0 != null) goto L11;
        return;
    L11:
        List<HealthCheckItemSnapshot> r2 = r0.getTodoItems();
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L12:
        boolean r5 = false;
        if (r4.hasNext() == false) goto L21;
        Object r6 = r4.next();
        HealthCheckItemSnapshot r7 = (HealthCheckItemSnapshot) r6;
        if (r10.contains(r7.getId()) == true) goto L17;
    L19:
        if (r5 == false) goto L12;
        r3.add(r6);
        goto L12
    L17:
        if (r7.isFixable() == false) goto L19;
        r5 = true;
        goto L19
    L21:
        ArrayList r8 = r3;
        if (r8.isEmpty() == false) goto L25;
        HealthScoreLog.INSTANCE.d(SOURCE, "optimizeTodoItems ignored noFixableItem itemIds=" + r10);
        return;
    L25:
        ArrayList r9 = r8;
        if ((r9 instanceof Collection) == true) goto L28;
    L30:
        Iterator r12 = r9.iterator();
    L32:
        if (r12.hasNext() == false) goto L29;
        if (((HealthCheckItemSnapshot) r12.next()).isNavigateFixable() == true) goto L32;
        boolean r13 = false;
    L37:
        if (r13 == false) goto L44;
        this.ignoringNavigateOnlyOptimizeResult = true;
        HealthScoreLog.INSTANCE.i(SOURCE, "optimizeTodoItems navigateOnlyLaunch itemIds=" + r10);
        SecurityServiceBinder r14 = this.securityService;
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r1 = r9.iterator();
    L40:
        if (r1.hasNext() == false) goto L42;
        r15.add(((HealthCheckItemSnapshot) r1.next()).getId());
        goto L40
    L42:
        r14.startOptimizeItems(CollectionsKt.toSet(r15), r11);
        return;
    L44:
        this.ignoringNavigateOnlyOptimizeResult = false;
        HealthScoreLog.INSTANCE.i(SOURCE, "optimizeTodoItems start itemIds=" + r10);
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r17 = r9.iterator();
    L46:
        if (r17.hasNext() == false) goto L48;
        r16.add(((HealthCheckItemSnapshot) r17.next()).getId());
        goto L46
    L48:
        startOptimizeWithSnapshot(r0, CollectionsKt.toSet(r16), r11);
        return;
    L29:
        r13 = true;
        goto L37
    L28:
        if (r9.isEmpty() == false) goto L30;
        goto L29
    }

    private final void handleBinderEvent(Bundle r11) {
        String r0 = r11.getString("event");
        HealthScoreLog.INSTANCE.d(SOURCE, "binderEvent event=" + r0);
        if (r0 != null) goto L6;
        return;
    L6:
        switch(r0.hashCode()) {
            case -509153886: goto L28;
            case 1763283776: goto L25;
            case 1775068966: goto L12;
            case 1787001616: goto L9;
            default: goto L39;
        };
    L39:
        return;
    L9:
        if (r0.equals(Const.EVENT_CLEAR_TASK_PROGRESS) == false) goto L31;
        handleOptimizeProgress(r11);
        return;
    L31:
        return;
    L12:
        if (r0.equals(Const.EVENT_SCAN_TASK_FINISH) == true) goto L14;
        return;
    L14:
        if (this.refreshingResultScan == false) goto L18;
        handleResultRefreshScanFinish();
        return;
    L18:
        if (this.waitingScanForOptimize == true) goto L20;
        return;
    L20:
        this.waitingScanForOptimize = false;
        HealthScoreSnapshot r12 = this.securityService.getHealthSnapshot();
        if (r12 != null) goto L23;
        return;
    L23:
        this.latestSnapshot = r12;
        this._uiState.setValue(OptimizeCenterUiState.copy$default(current(), null, r12.getTotal(), moduleUisForRun(r12), r12.getCompletedItems(), r12.getTodoItems(), getString(R.string.optimize_action_cancel), 1, null));
        return;
    L25:
        if (r0.equals(Const.EVENT_SCAN_TASK_PROGRESS) == false) goto L35;
        handleScanProgress(r11);
        return;
    L35:
        return;
    L28:
        if (r0.equals(Const.EVENT_CLEAR_TASK_FINISH) == false) goto L37;
        handleOptimizeFinish();
        return;
    }

    private final void handleResultRefreshScanFinish() {
        this.refreshingResultScan = false;
        this.pendingResultRefreshAfterNavigate = false;
        HealthScoreSnapshot r0 = this.securityService.getHealthSnapshot();
        if (r0 != null) goto L6;
        HealthScoreLog.w$default(HealthScoreLog.INSTANCE, SOURCE, "refreshResultOnResume finish snapshotNull", null, 4, null);
        return;
    L6:
        HealthScoreLog.INSTANCE.i(SOURCE, "refreshResultOnResume finish score=" + r0.getTotal() + " todo=" + CollectionsKt.joinToString$default(r0.getTodoItems(), ",", null, null, 0, null, C03841.INSTANCE, 30, null));
        showResultPage(r0);
    }

    private final void handleScanProgress(Bundle r2) {
        if (this.waitingScanForOptimize == false) goto L5;
    L7:
        HealthTaskProgressEvent r3 = taskProgressEvent(r2);
        if (r3 != null) goto L10;
        return;
    L10:
        renderProgress(r3);
        return;
    L5:
        if (this.optimizeRunning == true) goto L7;
    }

    static /* synthetic */ void startOptimizeWithSnapshot$default(OptimizeCenterViewModel r0, HealthScoreSnapshot r1, Set r2, Context r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
        Context r6 = (Context) null;
    L5:
        r0.startOptimizeWithSnapshot(r1, r2, r3);
    }

    private final void startOptimizeWithSnapshot(HealthScoreSnapshot r9, Set<String> r10, Context r11) {
        this.latestSnapshot = r9;
        HealthScoreLog.INSTANCE.i(SOURCE, "startOptimizeWithSnapshot score=" + r9.getTotal() + " optimizeItemIds=" + r10);
        this.optimizeStartedAtMillis = System.currentTimeMillis();
        this.optimizeFinishPending = false;
        this._uiState.setValue(current().copy(OptimizeCenterPhase.OPTIMIZING, r9.getTotal(), moduleUisForRun(r9), r9.getCompletedItems(), r9.getTodoItems(), getString(R.string.optimize_action_cancel)));
        if (r10.isEmpty() == false) goto L6;
        this.optimizeRunning = true;
        this.optimizeFinishPending = true;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new C03861(this, r9, null), 2, null);
        return;
    L6:
        this.optimizeRunning = true;
        this.securityService.startOptimizeItems(r10, r11);
    }

    private final void cancelResultRefreshIfNeeded(String r4) {
        if (this.refreshingResultScan == true) goto L5;
        return;
    L5:
        HealthScoreLog.INSTANCE.i(SOURCE, "cancelResultRefresh reason=" + r4);
        this.refreshingResultScan = false;
        this.pendingResultRefreshAfterNavigate = false;
    }

    private final void handleOptimizeProgress(Bundle r2) {
        if (this.optimizeRunning == true) goto L5;
        return;
    L5:
        this.waitingScanForOptimize = false;
        HealthTaskProgressEvent r3 = taskProgressEvent(r2);
        if (r3 != null) goto L8;
        return;
    L8:
        renderProgress(r3);
    }

    private final void renderProgress(HealthTaskProgressEvent r12) {
        int r0 = this.moduleOrder.indexOf(r12.getModuleId());
        OptimizeCenterUiState r1 = current();
        HealthScoreLog.INSTANCE.d(SOURCE, "renderProgress moduleId=" + r12.getModuleId() + " itemId=" + r12.getItemId() + " taskPassed=" + r12.getTaskPassed());
        MutableLiveData<OptimizeCenterUiState> r10 = this._uiState;
        OptimizeCenterPhase r2 = OptimizeCenterPhase.OPTIMIZING;
        List<OptimizeModuleUi> r4 = runningModules(r1.getModules());
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L15;
        OptimizeModuleUi r7 = (OptimizeModuleUi) r6.next();
        int r8 = this.moduleOrder.indexOf(r7.getModuleId());
        if (r8 < 0) goto L11;
        if (r0 <= r8) goto L11;
        OptimizeModuleUi r9 = asDone(r7);
    L14:
        r5.add(r9);
    L11:
        if (Intrinsics.areEqual(r7.getModuleId(), r12.getModuleId()) == false) goto L13;
        r9 = asRunning(r7, r12);
        goto L14
    L13:
        r9 = asPending(r7);
        goto L14
    L15:
        r10.setValue(OptimizeCenterUiState.copy$default(r1, r2, 0, r5, null, null, getString(R.string.optimize_action_cancel), 26, null));
    }

    private final void handleOptimizeFinish() {
        this.waitingScanForOptimize = false;
        if (this.optimizeRunning == true) goto L11;
        if (this.ignoringNavigateOnlyOptimizeResult == false) goto L20;
        this.ignoringNavigateOnlyOptimizeResult = false;
        HealthScoreLog.INSTANCE.d(SOURCE, "ignoreNavigateOnlyOptimizeFinishUiRefresh");
        if (this.pendingResultRefreshAfterNavigate == false) goto L21;
        this.pendingResultRefreshAfterNavigate = false;
        refreshResultOnResume();
        return;
    L21:
        return;
    L20:
        return;
    L11:
        if (this.optimizeFinishPending == false) goto L13;
        return;
    L13:
        HealthScoreSnapshot r0 = this.securityService.getHealthSnapshot();
        if (r0 != null) goto L16;
        r0 = this.latestSnapshot;
    L16:
        if (r0 != null) goto L18;
        return;
    L18:
        this.optimizeFinishPending = true;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new AnonymousClass1(this, r0, null), 2, null);
    }

    private final List<OptimizeModuleUi> moduleUisForRun(HealthScoreSnapshot r18) {
        List<OptimizeModuleUi> r1 = this.moduleTemplates;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L77;
        OptimizeModuleUi r5 = (OptimizeModuleUi) r3.next();
        if (r18 == null) goto L39;
        List<HealthModuleSnapshot> r8 = r18.getModules();
        if (r8 == null) goto L39;
        Iterator<T> r9 = r8.iterator();
    L11:
        if (r9.hasNext() == false) goto L15;
        Object r10 = r9.next();
        if (Intrinsics.areEqual(((HealthModuleSnapshot) r10).getId(), r5.getModuleId()) == false) goto L11;
    L16:
        HealthModuleSnapshot r11 = (HealthModuleSnapshot) r10;
        if (r11 == null) goto L39;
        List<HealthCheckItemSnapshot> r12 = r11.getItems();
        if (r12 == null) goto L39;
        List<HealthCheckItemSnapshot> r13 = r12;
        if ((r13 instanceof Collection) == true) goto L23;
    L25:
        Iterator<T> r14 = r13.iterator();
        int r15 = 0;
    L27:
        if (r14.hasNext() == false) goto L38;
        HealthCheckItemSnapshot r16 = (HealthCheckItemSnapshot) r14.next();
        if (r16.getVisible() == true) goto L31;
    L33:
        boolean r17 = false;
    L34:
        if (r17 == false) goto L27;
        r15 = r15 + 1;
        if (r15 >= 0) goto L27;
        CollectionsKt.throwCountOverflow();
        goto L27
    L31:
        if (r16.getStatus() != HealthCheckStatus.PASS) goto L33;
        r17 = true;
        goto L34
    L38:
        int r19 = r15;
    L40:
        OptimizeModuleStatus r110 = OptimizeModuleStatus.PENDING;
        String r111 = getString(R.string.health_running_prepare);
        if (r18 == null) goto L71;
        List<HealthModuleSnapshot> r112 = r18.getModules();
        if (r112 == null) goto L71;
        Iterator<T> r113 = r112.iterator();
    L46:
        if (r113.hasNext() == false) goto L50;
        Object r114 = r113.next();
        if (Intrinsics.areEqual(((HealthModuleSnapshot) r114).getId(), r5.getModuleId()) == false) goto L46;
    L51:
        HealthModuleSnapshot r115 = (HealthModuleSnapshot) r114;
        if (r115 == null) goto L71;
        List<HealthCheckItemSnapshot> r4 = r115.getItems();
        if (r4 == null) goto L71;
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r4.iterator();
    L57:
        if (r7.hasNext() == false) goto L66;
        Object r116 = r7.next();
        HealthCheckItemSnapshot r117 = (HealthCheckItemSnapshot) r116;
        if (r117.getVisible() == true) goto L61;
    L63:
        boolean r20 = false;
    L64:
        if (r20 == false) goto L57;
        r6.add(r116);
        goto L57
    L61:
        if (r117.getStatus() != HealthCheckStatus.PASS) goto L63;
        r20 = true;
        goto L64
    L66:
        ArrayList r21 = r6;
        ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10));
        Iterator r23 = r21.iterator();
    L68:
        if (r23.hasNext() == false) goto L70;
        r22.add(((HealthCheckItemSnapshot) r23.next()).getId());
        goto L68
    L70:
        Set r24 = CollectionsKt.toSet(r22);
    L72:
        if (r24 != null) goto L74;
        Set r25 = SetsKt.emptySet();
    L75:
        r2.add(OptimizeModuleUi.copy$default(r5, null, 0, 0, r110, r111, r19, r25, 7, null));
        goto L4
    L74:
        r25 = r24;
        goto L75
    L50:
        r114 = null;
    L71:
        r24 = null;
        goto L72
    L23:
        if (r13.isEmpty() == false) goto L25;
    L15:
        r10 = null;
    L39:
        r19 = 0;
        goto L40
    L77:
        return r2;
    }

    private final List<OptimizeModuleUi> runningModules(List<OptimizeModuleUi> r5) {
        List<OptimizeModuleUi> r6 = r5;
        LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r6, 10)), 16));
        Iterator<T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        Object r1 = r7.next();
        r2.put(((OptimizeModuleUi) r1).getModuleId(), r1);
        goto L4
    L6:
        List<OptimizeModuleUi> r4 = moduleUisForRun(this.latestSnapshot);
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r9 = r4.iterator();
    L8:
        if (r9.hasNext() == false) goto L15;
        OptimizeModuleUi r0 = (OptimizeModuleUi) r9.next();
        OptimizeModuleUi r3 = (OptimizeModuleUi) r2.get(r0.getModuleId());
        if (r3 == null) goto L13;
        r0 = r3;
    L13:
        r8.add(r0);
        goto L8
    L15:
        return r8;
    }

    private final void showFinalResult(HealthScoreSnapshot r3) {
        renderResult(r3, OptimizeCenterPhase.OPTIMIZED, getString(R.string.optimize_action_cancel));
    }

    private final void showResultPage(HealthScoreSnapshot r3) {
        renderResult(r3, OptimizeCenterPhase.RESULT, getString(R.string.optimize_action_finish));
    }

    private final void renderResult(HealthScoreSnapshot r9, OptimizeCenterPhase r10, String r11) {
        this.latestSnapshot = r9;
        HealthScoreLog.INSTANCE.i(SOURCE, "renderResult phase=" + r10 + " score=" + r9.getTotal() + " completed=" + r9.getCompletedItems().size() + " todo=" + r9.getTodoItems().size());
        MutableLiveData<OptimizeCenterUiState> r0 = this._uiState;
        OptimizeCenterUiState r1 = current();
        int r3 = r9.getTotal();
        List<OptimizeModuleUi> r2 = moduleUisForRun(r9);
        if (r10 != OptimizeCenterPhase.OPTIMIZED) goto L9;
        List<OptimizeModuleUi> r4 = r2;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r6 = r4.iterator();
    L6:
        if (r6.hasNext() == false) goto L8;
        r5.add(asDone((OptimizeModuleUi) r6.next()));
        goto L6
    L8:
        ArrayList r7 = r5;
    L10:
        r0.setValue(r1.copy(r10, r3, r7, r9.getCompletedItems(), recommendationTodos(r9.getTodoItems()), r11));
        return;
    L9:
        r7 = r2;
        goto L10
    }

    private final String findModuleIdByItemId(String r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        Iterator<T> r3 = this.itemPresentations.iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        Object r1 = r3.next();
        if (Intrinsics.areEqual(((HealthCheckItemPresentation) r1).getId(), r4) == false) goto L7;
    L12:
        HealthCheckItemPresentation r2 = (HealthCheckItemPresentation) r1;
        if (r2 != null) goto L15;
        return null;
    L15:
        return r2.getModuleId();
    L11:
        r1 = null;
        goto L12
    }

    private final HealthTaskProgressEvent taskProgressEvent(Bundle r6) {
        String r0 = r6.getString(Const.TASK_ITEM_ID);
        String r1 = r6.getString(Const.TASK_TITLE);
        String r2 = r6.getString(Const.TASK_MODULE_ID);
        if (r2 != null) goto L5;
        r2 = findModuleIdByItemId(r0);
    L5:
        if (r2 != null) goto L8;
        return null;
    L8:
        Intrinsics.checkNotNullExpressionValue(r2, "param.getString(Const.TA…           ?: return null");
        return new HealthTaskProgressEvent(r0, r1, r2, r6.getBoolean(Const.TASK_PASSED, false));
    }

    private final String moduleTitle(OptimizeModuleUi r3) {
        Integer r4 = Integer.valueOf(r3.getTitleResId());
        if (r4.intValue() == 0) goto L5;
        boolean r0 = true;
    L6:
        String r1 = null;
        if (r0 == true) goto L10;
        r4 = null;
    L10:
        if (r4 == null) goto L12;
        r1 = getString(r4.intValue());
    L12:
        if (r1 != null) goto L15;
        return "";
    L15:
        return r1;
    L5:
        r0 = false;
        goto L6
    }

    private final OptimizeCenterUiState current() {
        OptimizeCenterUiState r9 = this._uiState.getValue();
        if (r9 == null) goto L5;
        return r9;
    L5:
        return new OptimizeCenterUiState(null, 0, null, null, null, null, 63, null);
    }

    private final OptimizeModuleUi asDone(OptimizeModuleUi r11) {
        return OptimizeModuleUi.copy$default(r11, null, 0, 0, OptimizeModuleStatus.DONE, getString(R.string.health_running_done_count, new Object[]{Integer.valueOf(r11.getOptimizedCount())}), 0, null, 103, null);
    }

    private final OptimizeModuleUi asRunning(OptimizeModuleUi r12, HealthTaskProgressEvent r13) {
        if (r13.getTaskPassed() == true) goto L5;
    L7:
        Set<String> r0 = r12.getCompletedItemIds();
    L8:
        Set<String> r8 = r0;
        int r7 = r8.size();
        OptimizeModuleStatus r5 = OptimizeModuleStatus.RUNNING;
        if (r13.getTaskPassed() == false) goto L12;
        String r11 = getString(R.string.health_running_done_count, new Object[]{Integer.valueOf(r7)});
    L17:
        return OptimizeModuleUi.copy$default(r12, null, 0, 0, r5, r11, r7, r8, 7, null);
    L12:
        String r1 = r13.getItemId();
        String r14 = r13.getTitle();
        if (r14 != null) goto L15;
        r14 = moduleTitle(r12);
    L15:
        r11 = optimizeTitle(r1, r14);
        goto L17
    L5:
        if (r13.getItemId() == null) goto L7;
        r0 = SetsKt.plus(r12.getCompletedItemIds(), r13.getItemId());
        goto L8
    }

    private final OptimizeModuleUi asPending(OptimizeModuleUi r11) {
        return OptimizeModuleUi.copy$default(r11, null, 0, 0, OptimizeModuleStatus.PENDING, getString(R.string.health_running_prepare), 0, null, 103, null);
    }

    private final String optimizeTitle(String r5, String r6) {
        Iterator<T> r0 = this.itemPresentations.iterator();
    L3:
        Integer r2 = null;
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((HealthCheckItemPresentation) r1).getId(), r5) == false) goto L3;
    L9:
        HealthCheckItemPresentation r3 = (HealthCheckItemPresentation) r1;
        if (r3 == null) goto L26;
        Integer r7 = Integer.valueOf(r3.getTitleResId());
        if (r7.intValue() == 0) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L17;
        r2 = r7;
    L17:
        if (r2 == null) goto L27;
        String r8 = getString(r2.intValue());
        if (r8 != null) goto L22;
        return r6;
    L22:
        return r8;
    L27:
        return r6;
    L14:
        r4 = false;
        goto L15
    L26:
        return r6;
    L8:
        r1 = null;
        goto L9
    }

    private final String getString(int r1) {
        String r0 = getApplication().getString(r1);
        Intrinsics.checkNotNullExpressionValue(r0, "getApplication<Application>().getString(resId)");
        return r0;
    }

    private final String getString(int r2, Object... r3) {
        String r1 = getApplication().getString(r2, Arrays.copyOf(r3, r3.length));
        Intrinsics.checkNotNullExpressionValue(r1, "getApplication<Applicati…).getString(resId, *args)");
        return r1;
    }

    private final Object delayRemainingOptimizeDuration(Continuation<? super Unit> r5) {
        long r2 = 1000 - (System.currentTimeMillis() - this.optimizeStartedAtMillis);
        if (r2 <= 0) goto L8;
        Object r4 = DelayKt.delay(r2, r5);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r4;
    L8:
        return Unit.INSTANCE;
    }

    private final List<HealthCheckItemSnapshot> recommendationTodos(List<HealthCheckItemSnapshot> r13) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r12 = r13.iterator();
    L4:
        if (r12.hasNext() == false) goto L14;
        Object r1 = r12.next();
        HealthCheckItemSnapshot r2 = (HealthCheckItemSnapshot) r1;
        if (r2.isNavigateFixable() == false) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        if (r2.getFixCapability() == HealthFixCapability.NONE) goto L11;
        r3 = false;
        goto L12
    L14:
        List<HealthCheckItemSnapshot> r14 = CollectionsKt.sortedWith(r0, new OptimizeCenterViewModel$recommendationTodos$$inlined$sortedBy$1());
        HealthScoreLog.INSTANCE.d(SOURCE, "recommendationTodos itemIds=" + CollectionsKt.joinToString$default(r14, ",", null, null, 0, null, C03851.INSTANCE, 30, null) + " sourceCount=" + r13.size());
        return r14;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        this.securityService.unsubscribe(this.eventCallback);
        super.onCleared();
    }
}
