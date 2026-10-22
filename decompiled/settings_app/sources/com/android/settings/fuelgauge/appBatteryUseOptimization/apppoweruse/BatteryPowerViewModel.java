package com.android.settings.fuelgauge.appBatteryUseOptimization.apppoweruse;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.android.settings.NotificationDisplayDetailsActivity;
import com.android.settings.fuelgauge.PowerUsageDetail;
import com.obric.olog.OLog;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: BatteryPowerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0019\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/android/settings/fuelgauge/appBatteryUseOptimization/apppoweruse/BatteryPowerViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", PowerUsageDetail.EXTRA_PERCENT, "Landroidx/lifecycle/MutableLiveData;", "", "getPercent", "()Landroidx/lifecycle/MutableLiveData;", "decimalFormat", "float", "getPowerPercent", "", "context", "Landroid/content/Context;", NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME, "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BatteryPowerViewModel extends ViewModel {
    private final MutableLiveData<Float> percent;

    /* JADX INFO: renamed from: com.android.settings.fuelgauge.appBatteryUseOptimization.apppoweruse.BatteryPowerViewModel$getPowerPercent$1, reason: invalid class name */
    /* JADX INFO: compiled from: BatteryPowerViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.android.settings.fuelgauge.appBatteryUseOptimization.apppoweruse.BatteryPowerViewModel$getPowerPercent$1", f = "BatteryPowerViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $packageName;
        int label;
        final /* synthetic */ BatteryPowerViewModel this$0;

        AnonymousClass1(BatteryPowerViewModel r1, String r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$packageName = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, this.$packageName, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v3, types: [T, com.android.settings.fuelgauge.appBatteryUseOptimization.apppoweruse.AppPowerProfileData] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L28;
            ResultKt.throwOnFailure(r7);
            ArrayList<AppPowerProfileData> r8 = PowerAdvisorService.getAllAppPowerList();
            Ref.ObjectRef r0 = new Ref.ObjectRef();
            Ref.IntRef r1 = new Ref.IntRef();
            Intrinsics.checkNotNull(r8);
            String r2 = this.$packageName;
            Iterator<T> r9 = r8.iterator();
        L6:
            if (r9.hasNext() == false) goto L10;
            ?? r3 = (AppPowerProfileData) r9.next();
            r1.element += r3.getPowermAh();
            if (Intrinsics.areEqual(r3.getPkg(), r2) == false) goto L6;
            r0.element = r3;
            goto L6
        L10:
            float r4 = 0.0f;
            if (r0.element != 0) goto L13;
            this.this$0.getPercent().postValue(Boxing.boxFloat(0.0f));
        L26:
            return Unit.INSTANCE;
        L13:
            AppPowerProfileData r10 = (AppPowerProfileData) r0.element;
            if (r10 == null) goto L20;
            BatteryPowerViewModel r5 = this.this$0;
            AppPowerProfileData r6 = (AppPowerProfileData) r0.element;
            if (r6 == null) goto L19;
            r4 = r6.getPowermAh();
        L19:
            r10.setPercent(r5.decimalFormat((r4 * 100) / r1.element));
        L20:
            MutableLiveData<Float> r11 = this.this$0.getPercent();
            AppPowerProfileData r12 = (AppPowerProfileData) r0.element;
            if (r12 == null) goto L23;
            Float r13 = Boxing.boxFloat(r12.getPercent());
        L24:
            r11.postValue(r13);
            goto L26
        L23:
            r13 = null;
            goto L24
        L28:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public BatteryPowerViewModel() {
        this.percent = new MutableLiveData();
    }

    public final MutableLiveData<Float> getPercent() {
        return this.percent;
    }

    public final void getPowerPercent(Context r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);
        OLog.i("AppPowerProfileData", "start request app power data");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, r8, null), 2, null);
    }

    public final float decimalFormat(float r2) {
        DecimalFormat r1 = new DecimalFormat("#.#");
        r1.setRoundingMode(RoundingMode.HALF_UP);
        String r3 = r1.format(Float.valueOf(r2));
        Intrinsics.checkNotNullExpressionValue(r3, "format(...)");
        return Float.parseFloat(r3);
    }
}
