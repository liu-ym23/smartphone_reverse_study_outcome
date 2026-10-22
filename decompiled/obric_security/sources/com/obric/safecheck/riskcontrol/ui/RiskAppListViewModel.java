package com.obric.safecheck.riskcontrol.ui;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import com.obric.safecheck.riskcontrol.domain.usecase.LoadRiskAppsUseCase;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RiskAppListViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0011\u001a\u00020\u0012R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/obric/safecheck/riskcontrol/ui/RiskAppListViewModel;", "Landroidx/lifecycle/ViewModel;", "appContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_uiState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/obric/safecheck/riskcontrol/ui/RiskAppListUiState;", "kotlin.jvm.PlatformType", "loadUseCase", "Lcom/obric/safecheck/riskcontrol/domain/usecase/LoadRiskAppsUseCase;", "getLoadUseCase", "()Lcom/obric/safecheck/riskcontrol/domain/usecase/LoadRiskAppsUseCase;", "uiState", "Landroidx/lifecycle/LiveData;", "getUiState", "()Landroidx/lifecycle/LiveData;", "loadControlledApps", "", "Companion", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class RiskAppListViewModel extends ViewModel {
    public static final Companion Companion = null;
    private final MutableLiveData<RiskAppListUiState> _uiState;
    private final Context appContext;
    private final LiveData<RiskAppListUiState> uiState;

    /* JADX INFO: compiled from: RiskAppListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/safecheck/riskcontrol/ui/RiskAppListViewModel$Companion;", "", "()V", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "context", "Landroid/content/Context;", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final ViewModelProvider.Factory factory(Context r1) {
            Intrinsics.checkNotNullParameter(r1, "context");
            final Context r0 = r1.getApplicationContext();
            return new RiskAppListViewModel$Companion$factory$1(r0);
        }
    }

    /* JADX INFO: renamed from: com.obric.safecheck.riskcontrol.ui.RiskAppListViewModel$loadControlledApps$1, reason: invalid class name */
    /* JADX INFO: compiled from: RiskAppListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.safecheck.riskcontrol.ui.RiskAppListViewModel$loadControlledApps$1", f = "RiskAppListViewModel.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ RiskAppListViewModel this$0;

        AnonymousClass1(RiskAppListViewModel r1, Continuation r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            Intrinsics.checkNotNullParameter(r2, "completion");
            return new AnonymousClass1(this.this$0, r2);
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
            RiskAppListViewModel.access$get_uiState$p(this.this$0).setValue(new RiskAppListUiState((List) r5));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            CoroutineDispatcher r6 = RiskControlRuntimeDependencies.INSTANCE.getIoDispatcher();
            RiskAppListViewModel$loadControlledApps$1$items$1 r2 = new RiskAppListViewModel$loadControlledApps$1$items$1(this, null);
            this.label = 1;
            r5 = BuildersKt.withContext(r6, r2, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RiskAppListViewModel(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "appContext");
        this.appContext = r4;
        MutableLiveData<RiskAppListUiState> r5 = new MutableLiveData(new RiskAppListUiState(null, 1, null));
        this._uiState = r5;
        this.uiState = r5;
    }

    public static final /* synthetic */ LoadRiskAppsUseCase access$getLoadUseCase$p(RiskAppListViewModel r0) {
        return r0.getLoadUseCase();
    }

    public static final /* synthetic */ MutableLiveData access$get_uiState$p(RiskAppListViewModel r0) {
        return r0._uiState;
    }

    public final LiveData<RiskAppListUiState> getUiState() {
        return this.uiState;
    }

    private final LoadRiskAppsUseCase getLoadUseCase() {
        return RiskControlRuntimeDependencies.INSTANCE.getLoadRiskAppsUseCaseFactory().invoke(this.appContext);
    }

    public final void loadControlledApps() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }
}
