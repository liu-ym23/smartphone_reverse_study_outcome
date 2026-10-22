package com.obric.safecheck.riskcontrol.ui;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import com.obric.safecheck.riskcontrol.domain.usecase.ApplyRiskControlUseCase;
import com.obric.safecheck.riskcontrol.domain.usecase.LoadRiskAppsUseCase;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: RiskAppDetailViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 (2\u00020\u0001:\u0001(B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0014\u0010\u001d\u001a\u00020\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001fJ\u0006\u0010 \u001a\u00020\u001cJ\u0006\u0010!\u001a\u00020\u001cJ\u0016\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u0007H\u0002R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/obric/safecheck/riskcontrol/ui/RiskAppDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "appContext", "Landroid/content/Context;", ApkVirusCheckProvider.KEY_PKG, "", AccountInfoBundleKey.USER_ID, "", "(Landroid/content/Context;Ljava/lang/String;I)V", "_uiState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/obric/safecheck/riskcontrol/ui/RiskAppDetailUiState;", "kotlin.jvm.PlatformType", "applyUseCase", "Lcom/obric/safecheck/riskcontrol/domain/usecase/ApplyRiskControlUseCase;", "getApplyUseCase", "()Lcom/obric/safecheck/riskcontrol/domain/usecase/ApplyRiskControlUseCase;", "flagUpdateMutex", "Lkotlinx/coroutines/sync/Mutex;", "loadUseCase", "Lcom/obric/safecheck/riskcontrol/domain/usecase/LoadRiskAppsUseCase;", "getLoadUseCase", "()Lcom/obric/safecheck/riskcontrol/domain/usecase/LoadRiskAppsUseCase;", "uiState", "Landroidx/lifecycle/LiveData;", "getUiState", "()Landroidx/lifecycle/LiveData;", "controlAllDefaults", "", "deleteInstallationPackage", "onDeleted", "Lkotlin/Function0;", "load", "releaseAllControls", "setFlag", "flag", "enabled", "", "updateControlFlags", "nextFlags", "Companion", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class RiskAppDetailViewModel extends ViewModel {
    public static final Companion Companion = null;
    private final MutableLiveData<RiskAppDetailUiState> _uiState;
    private final Context appContext;
    private final Mutex flagUpdateMutex;
    private final String pkg;
    private final LiveData<RiskAppDetailUiState> uiState;
    private final int userId;

    /* JADX INFO: compiled from: RiskAppDetailViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/obric/safecheck/riskcontrol/ui/RiskAppDetailViewModel$Companion;", "", "()V", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "context", "Landroid/content/Context;", ApkVirusCheckProvider.KEY_PKG, "", AccountInfoBundleKey.USER_ID, "", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final ViewModelProvider.Factory factory(Context r1, final String r2, final int r3) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, ApkVirusCheckProvider.KEY_PKG);
            final Context r0 = r1.getApplicationContext();
            return new RiskAppDetailViewModel$Companion$factory$1(r0, r2, r3);
        }
    }

    /* JADX INFO: renamed from: com.obric.safecheck.riskcontrol.ui.RiskAppDetailViewModel$deleteInstallationPackage$1, reason: invalid class name */
    /* JADX INFO: compiled from: RiskAppDetailViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.safecheck.riskcontrol.ui.RiskAppDetailViewModel$deleteInstallationPackage$1", f = "RiskAppDetailViewModel.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0 $onDeleted;
        int label;
        final /* synthetic */ RiskAppDetailViewModel this$0;

        /* JADX INFO: renamed from: com.obric.safecheck.riskcontrol.ui.RiskAppDetailViewModel$deleteInstallationPackage$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: RiskAppDetailViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @DebugMetadata(c = "com.obric.safecheck.riskcontrol.ui.RiskAppDetailViewModel$deleteInstallationPackage$1$1", f = "RiskAppDetailViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00461 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AnonymousClass1 this$0;

            C00461(AnonymousClass1 r1, Continuation r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                Intrinsics.checkNotNullParameter(r3, "completion");
                C00461 r0 = new C00461(this.this$0, r3);
                r0.L$0 = r2;
                return r0;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope r1, Continuation<? super Result<? extends Unit>> r2) {
                return ((C00461) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L16;
                ResultKt.throwOnFailure(r2);
                CoroutineScope r3 = (CoroutineScope) this.L$0;
                Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L7
                Result.m774constructorimpl(Boxing.boxBoolean(new File(RiskAppDetailViewModel.access$getPkg$p(this.this$0.this$0)).delete()));     // Catch: Throwable -> L7
            L19:
                Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L11
                RiskAppDetailViewModel.access$getApplyUseCase$p(this.this$0.this$0).deleteRecord(RiskAppDetailViewModel.access$getPkg$p(this.this$0.this$0));     // Catch: Throwable -> L11
                Object r1 = Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
            L14:
                return Result.m773boximpl(r1);
            L11:
                th = move-exception;
                Result.Companion r6 = Result.Companion;
                r1 = Result.m774constructorimpl(ResultKt.createFailure(th));
            L7:
                th = move-exception;
                Result.Companion r0 = Result.Companion;
                Result.m774constructorimpl(ResultKt.createFailure(th));
                goto L19
            L16:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass1(RiskAppDetailViewModel r1, Function0 r2, Continuation r3) {
            this.this$0 = r1;
            this.$onDeleted = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "completion");
            return new AnonymousClass1(this.this$0, this.$onDeleted, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            this.$onDeleted.invoke();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            CoroutineDispatcher r6 = RiskControlRuntimeDependencies.INSTANCE.getIoDispatcher();
            C00461 r2 = new C00461(this, null);
            this.label = 1;
            if (BuildersKt.withContext(r6, r2, this) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.safecheck.riskcontrol.ui.RiskAppDetailViewModel$load$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RiskAppDetailViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.safecheck.riskcontrol.ui.RiskAppDetailViewModel$load$1", f = "RiskAppDetailViewModel.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
    static final class C03261 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ RiskAppDetailViewModel this$0;

        C03261(RiskAppDetailViewModel r1, Continuation r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            Intrinsics.checkNotNullParameter(r2, "completion");
            return new C03261(this.this$0, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C03261) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            MutableLiveData r4 = RiskAppDetailViewModel.access$get_uiState$p(this.this$0);
            r4.setValue((RiskAppDetailUiState) r5);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            CoroutineDispatcher r6 = RiskControlRuntimeDependencies.INSTANCE.getIoDispatcher();
            RiskAppDetailViewModel$load$1$state$1 r2 = new RiskAppDetailViewModel$load$1$state$1(this, null);
            this.label = 1;
            r5 = BuildersKt.withContext(r6, r2, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.safecheck.riskcontrol.ui.RiskAppDetailViewModel$updateControlFlags$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RiskAppDetailViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.safecheck.riskcontrol.ui.RiskAppDetailViewModel$updateControlFlags$1", f = "RiskAppDetailViewModel.kt", i = {0}, l = {119}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
    static final class C03271 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ RiskAppContentUiInfo $content;
        final /* synthetic */ RiskAppDetailUiState $current;
        final /* synthetic */ int $nextFlags;
        final /* synthetic */ int $previousFlags;
        Object L$0;
        int label;
        final /* synthetic */ RiskAppDetailViewModel this$0;

        C03271(RiskAppDetailViewModel r1, RiskAppContentUiInfo r2, int r3, int r4, RiskAppDetailUiState r5, Continuation r6) {
            this.this$0 = r1;
            this.$content = r2;
            this.$previousFlags = r3;
            this.$nextFlags = r4;
            this.$current = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            Intrinsics.checkNotNullParameter(r9, "completion");
            return new C03271(this.this$0, this.$content, this.$previousFlags, this.$nextFlags, this.$current, r9);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C03271) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            Mutex r2 = (Mutex) this.L$0;
            ResultKt.throwOnFailure(r11);
        L22:
            ApplyRiskControlUseCase.Result r12 = RiskAppDetailViewModel.access$getApplyUseCase$p(this.this$0).execute(RiskAppDetailViewModel.access$getPkg$p(this.this$0), RiskAppDetailViewModel.access$getUserId$p(this.this$0), this.$content.getVirusDescription(), this.$previousFlags, this.$nextFlags);     // Catch: Throwable -> L19
            if (r12 == null) goto L16;
            RiskAppDetailViewModel.access$get_uiState$p(this.this$0).postValue(RiskAppDetailUiState.copy$default(this.$current, null, null, r12.getControlFlags(), false, 11, null));     // Catch: Throwable -> L19
        L16:
            Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L19
            r2.unlock(null);
            return Unit.INSTANCE;
        L19:
            th = move-exception;
            r2.unlock(null);
            throw th;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            Mutex r13 = RiskAppDetailViewModel.access$getFlagUpdateMutex$p(this.this$0);
            this.L$0 = r13;
            this.label = 1;
            if (r13.lock(null, this) != r0) goto L11;
            return r0;
        L11:
            r2 = r13;
            goto L22
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static final /* synthetic */ ApplyRiskControlUseCase access$getApplyUseCase$p(RiskAppDetailViewModel r0) {
        return r0.getApplyUseCase();
    }

    public static final /* synthetic */ Mutex access$getFlagUpdateMutex$p(RiskAppDetailViewModel r0) {
        return r0.flagUpdateMutex;
    }

    public static final /* synthetic */ LoadRiskAppsUseCase access$getLoadUseCase$p(RiskAppDetailViewModel r0) {
        return r0.getLoadUseCase();
    }

    public static final /* synthetic */ String access$getPkg$p(RiskAppDetailViewModel r0) {
        return r0.pkg;
    }

    public static final /* synthetic */ int access$getUserId$p(RiskAppDetailViewModel r0) {
        return r0.userId;
    }

    public static final /* synthetic */ MutableLiveData access$get_uiState$p(RiskAppDetailViewModel r0) {
        return r0._uiState;
    }

    public RiskAppDetailViewModel(Context r8, String r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "appContext");
        Intrinsics.checkNotNullParameter(r9, ApkVirusCheckProvider.KEY_PKG);
        this.appContext = r8;
        this.pkg = r9;
        this.userId = r10;
        MutableLiveData<RiskAppDetailUiState> r11 = new MutableLiveData(new RiskAppDetailUiState(null, null, 0, false, 15, null));
        this._uiState = r11;
        this.uiState = r11;
        this.flagUpdateMutex = MutexKt.Mutex$default(false, 1, null);
    }

    public final LiveData<RiskAppDetailUiState> getUiState() {
        return this.uiState;
    }

    private final LoadRiskAppsUseCase getLoadUseCase() {
        return RiskControlRuntimeDependencies.INSTANCE.getLoadRiskAppsUseCaseFactory().invoke(this.appContext);
    }

    private final ApplyRiskControlUseCase getApplyUseCase() {
        return RiskControlRuntimeDependencies.INSTANCE.getApplyRiskControlUseCaseFactory().invoke(this.appContext);
    }

    public final void load() {
        if (StringsKt.isBlank(this.pkg) == false) goto L6;
        this._uiState.setValue(new RiskAppDetailUiState(null, null, 0, true, 7, null));
        return;
    L6:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03261(this, null), 3, null);
    }

    public final void setFlag(int r3, boolean r4) {
        RiskAppDetailUiState r0 = this._uiState.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNullExpressionValue(r0, "_uiState.value ?: return");
        if (r4 == false) goto L8;
        int r5 = r3 | r0.getControlFlags();
    L9:
        updateControlFlags(r5);
        return;
    L8:
        int r6 = r0.getControlFlags();
        r5 = (~r3) & r6;
        goto L9
    }

    public final void releaseAllControls() {
        updateControlFlags(0);
    }

    public final void controlAllDefaults() {
        updateControlFlags(127);
    }

    public final void deleteInstallationPackage(Function0<Unit> r8) {
        Intrinsics.checkNotNullParameter(r8, "onDeleted");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r8, null), 3, null);
    }

    private final void updateControlFlags(int r15) {
        RiskAppDetailUiState r0 = this._uiState.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNullExpressionValue(r0, "_uiState.value ?: return");
        RiskAppContentUiInfo r8 = r0.getContent();
        if (r8 != null) goto L9;
        return;
    L9:
        if (r15 != r0.getControlFlags()) goto L11;
        return;
    L11:
        int r9 = r0.getControlFlags();
        this._uiState.setValue(RiskAppDetailUiState.copy$default(r0, null, null, r15, false, 11, null));
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), RiskControlRuntimeDependencies.INSTANCE.getIoDispatcher(), null, new C03271(this, r8, r9, r15, r0, null), 2, null);
    }
}
