package com.obric.security.health.score.task;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.obric.security.health.score.HealthScoreLog;
import com.obric.securitycenter.nodisturb.InterceptSettingActivity;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: RiskBehaviorProtectionHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0004J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0019\u001a\u00020\u0004J\u0014\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015J\u0006\u0010\u001d\u001a\u00020\u001bJ\u0019\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lcom/obric/security/health/score/task/RiskBehaviorProtectionHelper;", "", "()V", "MARK_CLASSIFY_AD_SALES", "", "MARK_CLASSIFY_DECORATION", "MARK_CLASSIFY_EDUCATION", "MARK_CLASSIFY_EXPRESS", "MARK_CLASSIFY_FRAUD", "MARK_CLASSIFY_HARASSMENT", "MARK_CLASSIFY_HEAD_HUNTER", "MARK_CLASSIFY_HIGH_RISK", "MARK_CLASSIFY_HOUSE_MARKET", "MARK_CLASSIFY_INSURANCE_FINANCE", "MARK_CLASSIFY_LOAN_PROMOTION", "MARK_CLASSIFY_TAXI", "PRODUCT_NERIDA", "", "REGION_HK", "SOURCE", "buildCallSwitchStates", "", "Lcom/obric/security/health/score/task/RiskSwitchState;", "callInterceptType", "buildSmsSwitchStates", "smsInterceptType", "isAnySwitchEnabled", "", "states", "isSmsRequiredForRiskScore", "launchInterceptSettings", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class RiskBehaviorProtectionHelper {
    public static final RiskBehaviorProtectionHelper INSTANCE = null;
    private static final int MARK_CLASSIFY_AD_SALES = 2;
    private static final int MARK_CLASSIFY_DECORATION = 8192;
    private static final int MARK_CLASSIFY_EDUCATION = 4096;
    private static final int MARK_CLASSIFY_EXPRESS = 8;
    private static final int MARK_CLASSIFY_FRAUD = 16;
    private static final int MARK_CLASSIFY_HARASSMENT = 1;
    private static final int MARK_CLASSIFY_HEAD_HUNTER = 32;
    private static final int MARK_CLASSIFY_HIGH_RISK = 128;
    private static final int MARK_CLASSIFY_HOUSE_MARKET = 4;
    private static final int MARK_CLASSIFY_INSURANCE_FINANCE = 256;
    private static final int MARK_CLASSIFY_LOAN_PROMOTION = 512;
    private static final int MARK_CLASSIFY_TAXI = 64;
    private static final String PRODUCT_NERIDA = "nerida";
    private static final String REGION_HK = "hk";
    private static final String SOURCE = "RiskBehaviorProtectionHelper";

    /* JADX INFO: renamed from: com.obric.security.health.score.task.RiskBehaviorProtectionHelper$launchInterceptSettings$2, reason: invalid class name */
    /* JADX INFO: compiled from: RiskBehaviorProtectionHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.score.task.RiskBehaviorProtectionHelper$launchInterceptSettings$2", f = "RiskBehaviorProtectionHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Context $context;
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Context r1, Continuation r2) {
            this.$context = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "completion");
            AnonymousClass2 r0 = new AnonymousClass2(this.$context, r3);
            r0.L$0 = r2;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L18;
            ResultKt.throwOnFailure(r4);
            CoroutineScope r5 = (CoroutineScope) this.L$0;
            Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L10
            Intent r7 = new Intent(this.$context, InterceptSettingActivity.class);     // Catch: Throwable -> L10
            if ((this.$context instanceof Activity) == true) goto L8;
            r7.addFlags(268435456);     // Catch: Throwable -> L10
        L8:
            this.$context.startActivity(r7);     // Catch: Throwable -> L10
            Object r3 = Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
        L12:
            Throwable r8 = Result.m777exceptionOrNullimpl(r3);
            if (r8 == null) goto L16;
            HealthScoreLog.INSTANCE.e(RiskBehaviorProtectionHelper.SOURCE, "launchInterceptSettingsFailed", r8);
        L16:
            return Boxing.boxBoolean(Result.m781isSuccessimpl(r3));
        L10:
            th = move-exception;
            Result.Companion r9 = Result.Companion;
            r3 = Result.m774constructorimpl(ResultKt.createFailure(th));
            goto L12
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final boolean isSmsRequiredForRiskScore() {
        return true;
    }

    static {
        INSTANCE = new RiskBehaviorProtectionHelper();
    }

    private RiskBehaviorProtectionHelper() {
    }

    public final Object launchInterceptSettings(Context r3, Continuation<? super Boolean> r4) {
        return BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(r3, null), r4);
    }

    public final List<RiskSwitchState> buildSmsSwitchStates(int r6) {
        return CollectionsKt.listOf(new RiskSwitchState[]{new RiskSwitchState("sms_high_risk", RiskBehaviorProtectionHelperKt.hasRiskFlag(r6, 1)), new RiskSwitchState("sms_medium_risk", RiskBehaviorProtectionHelperKt.hasRiskFlag(r6, 2)), new RiskSwitchState("sms_harassment", RiskBehaviorProtectionHelperKt.hasRiskFlag(r6, 4))});
    }

    public final List<RiskSwitchState> buildCallSwitchStates(int r6) {
        return CollectionsKt.listOf(new RiskSwitchState[]{new RiskSwitchState("call_ad_sales", RiskBehaviorProtectionHelperKt.hasRiskFlag(r6, 2)), new RiskSwitchState("call_insurance_finance", RiskBehaviorProtectionHelperKt.hasRiskFlag(r6, 256)), new RiskSwitchState("call_harassment", RiskBehaviorProtectionHelperKt.hasRiskFlag(r6, 1)), new RiskSwitchState("call_house_market", RiskBehaviorProtectionHelperKt.hasRiskFlag(r6, 4)), new RiskSwitchState("call_express", RiskBehaviorProtectionHelperKt.hasRiskFlag(r6, 8)), new RiskSwitchState("call_taxi", RiskBehaviorProtectionHelperKt.hasRiskFlag(r6, 64)), new RiskSwitchState("call_high_risk", RiskBehaviorProtectionHelperKt.hasRiskFlag(r6, 128)), new RiskSwitchState("call_fraud", RiskBehaviorProtectionHelperKt.hasRiskFlag(r6, 16)), new RiskSwitchState("call_head_hunter", RiskBehaviorProtectionHelperKt.hasRiskFlag(r6, 32)), new RiskSwitchState("call_loan_promotion", RiskBehaviorProtectionHelperKt.hasRiskFlag(r6, 512)), new RiskSwitchState("call_education", RiskBehaviorProtectionHelperKt.hasRiskFlag(r6, 4096)), new RiskSwitchState("call_decoration", RiskBehaviorProtectionHelperKt.hasRiskFlag(r6, 8192))});
    }

    public final boolean isAnySwitchEnabled(List<RiskSwitchState> r2) {
        Intrinsics.checkNotNullParameter(r2, "states");
        List<RiskSwitchState> r3 = r2;
        if ((r3 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r3.iterator();
    L9:
        if (r1.hasNext() == false) goto L18;
        if (((RiskSwitchState) r1.next()).getEnabled() == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r3.isEmpty() == false) goto L7;
        return false;
    }
}
