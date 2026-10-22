package com.obric.security.mainpage;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedanceos.securitycenter.MainActivity;
import com.obric.security.battertpower.BatteryPowerActivityViewModel;
import com.obric.security.health.score.HealthScoreLog;
import com.obric.security.health.score.HealthTaskIds;
import com.obric.security.service.SecurityServiceBinder;
import com.obric.security.tcsecurity.cleansdk.CleanSDK;
import com.obric.securitycenter.api.ISecurityCenterService;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: MainViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\u0006\u0010\u0018\u001a\u00020\u0013J\u0006\u0010\u0019\u001a\u00020\u0013J\u0006\u0010\u001a\u001a\u00020\u0013J\u0006\u0010\u001b\u001a\u00020\u0013R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0007R\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/obric/security/mainpage/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "agreeGrant", "Landroidx/lifecycle/MutableLiveData;", "", "getAgreeGrant", "()Landroidx/lifecycle/MutableLiveData;", "itemCardHeight", "", "getItemCardHeight", "itemCardMaxHeight", "getItemCardMaxHeight", "serviceLiveData", "Lcom/obric/securitycenter/api/ISecurityCenterService;", "getServiceLiveData", "startScanTrashAndMem", "getStartScanTrashAndMem", "initAndStartScan", "", "startHealthScoreRefresh", "itemIds", "", "", "startMemoryCleanHealthScoreRefresh", "startSafeCheckHealthScoreRefresh", "startSpamInterceptHealthScoreRefresh", "startTrashCleanHealthScoreRefresh", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class MainViewModel extends ViewModel {
    public static final Companion Companion = null;
    private static final String SOURCE = "MainViewModel";
    private final MutableLiveData<Boolean> agreeGrant;
    private final MutableLiveData<Integer> itemCardHeight;
    private final MutableLiveData<Integer> itemCardMaxHeight;
    private final MutableLiveData<ISecurityCenterService> serviceLiveData;
    private final MutableLiveData<Integer> startScanTrashAndMem;

    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/security/mainpage/MainViewModel$Companion;", "", "()V", "SOURCE", "", "getBatteryPowerViewModel", "Lcom/obric/security/battertpower/BatteryPowerActivityViewModel;", "activity", "Landroid/content/Context;", "getMainViewModel", "Lcom/obric/security/mainpage/MainViewModel;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final MainViewModel getMainViewModel(Context r1) {
            if ((r1 instanceof MainActivity) == true) goto L5;
            return null;
        L5:
            return (MainViewModel) new ViewModelProvider((ViewModelStoreOwner) r1).get(MainViewModel.class);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final BatteryPowerActivityViewModel getBatteryPowerViewModel(Context r1) {
            if ((r1 instanceof MainActivity) == true) goto L5;
            return null;
        L5:
            return (BatteryPowerActivityViewModel) new ViewModelProvider((ViewModelStoreOwner) r1).get(BatteryPowerActivityViewModel.class);
        }
    }

    /* JADX INFO: renamed from: com.obric.security.mainpage.MainViewModel$initAndStartScan$1, reason: invalid class name */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.mainpage.MainViewModel$initAndStartScan$1", f = "MainViewModel.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MainViewModel this$0;

        /* JADX INFO: renamed from: com.obric.security.mainpage.MainViewModel$initAndStartScan$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: MainViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @DebugMetadata(c = "com.obric.security.mainpage.MainViewModel$initAndStartScan$1$1", f = "MainViewModel.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
        static final class C00621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;

            C00621(Continuation r2) {
                super(2, r2);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
                Intrinsics.checkNotNullParameter(r2, "completion");
                return new C00621(r2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return ((C00621) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r4) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r4);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r4);
                CleanSDK.INSTANCE.initCleanSDK();
                this.label = 1;
                if (DelayKt.delay(340, this) != r0) goto L12;
                return r0;
            }
        }

        AnonymousClass1(MainViewModel r1, Continuation r2) {
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
            this.this$0.getStartScanTrashAndMem().setValue(Boxing.boxInt(1));
            this.this$0.getAgreeGrant().setValue(Boxing.boxBoolean(true));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            CoroutineDispatcher r6 = Dispatchers.getIO();
            C00621 r2 = new C00621(null);
            this.label = 1;
            if (BuildersKt.withContext(r6, r2, this) != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public MainViewModel() {
        this.itemCardHeight = new MutableLiveData();
        this.itemCardMaxHeight = new MutableLiveData();
        this.startScanTrashAndMem = new MutableLiveData();
        this.agreeGrant = new MutableLiveData();
        this.serviceLiveData = new MutableLiveData();
    }

    public final MutableLiveData<Integer> getItemCardHeight() {
        return this.itemCardHeight;
    }

    public final MutableLiveData<Integer> getItemCardMaxHeight() {
        return this.itemCardMaxHeight;
    }

    public final void initAndStartScan() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final MutableLiveData<Integer> getStartScanTrashAndMem() {
        return this.startScanTrashAndMem;
    }

    public final MutableLiveData<Boolean> getAgreeGrant() {
        return this.agreeGrant;
    }

    public final MutableLiveData<ISecurityCenterService> getServiceLiveData() {
        return this.serviceLiveData;
    }

    public final void startSafeCheckHealthScoreRefresh() {
        startHealthScoreRefresh(SetsKt.setOf(new String[]{HealthTaskIds.RECENT_SAFE_CHECK, HealthTaskIds.MALWARE_FREE, HealthTaskIds.VIRUS_DB_AUTO_UPDATE}));
    }

    public final void startSpamInterceptHealthScoreRefresh() {
        startHealthScoreRefresh(SetsKt.setOf(HealthTaskIds.RISK_BEHAVIOR_PROTECTION));
    }

    public final void startMemoryCleanHealthScoreRefresh() {
        startHealthScoreRefresh(SetsKt.setOf(HealthTaskIds.MEMORY_CLEAN));
    }

    public final void startTrashCleanHealthScoreRefresh() {
        startHealthScoreRefresh(SetsKt.setOf(HealthTaskIds.TRASH_LESS));
    }

    private final void startHealthScoreRefresh(Set<String> r3) {
        HealthScoreLog.INSTANCE.i(SOURCE, "startHealthScoreRefresh itemIds=" + r3);
        SecurityServiceBinder.Companion.getInstance().startScanHealthItems(r3);
    }
}
