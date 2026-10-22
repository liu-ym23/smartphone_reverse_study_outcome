package com.obric.security.health.score.task;

import android.content.Context;
import android.provider.Settings;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.bytedanceos.utils.Constants;
import com.obric.security.health.model.HealthCheckResult;
import com.obric.security.health.model.HealthCheckStatus;
import com.obric.security.health.model.HealthFixCapability;
import com.obric.security.health.score.HealthModuleIds;
import com.obric.security.health.score.HealthScoreLog;
import com.obric.security.health.score.HealthTaskIds;
import com.obric.securitycenter.nodisturb.manager.NumberCheckManager;
import com.obric.securitycenter.nodisturb.manager.SmsBodyCheckManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: RiskBehaviorProtectionTask.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0094@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0094@ø\u0001\u0000¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/obric/security/health/score/task/RiskBehaviorProtectionTask;", "Lcom/obric/security/health/score/task/HealthCheckTask;", "()V", "defaultScore", "", "getDefaultScore", "()I", "fixCapability", "Lcom/obric/security/health/model/HealthFixCapability;", "getFixCapability", "()Lcom/obric/security/health/model/HealthFixCapability;", SlardarConfigConsts.CONFIG_ID, "", "getId", "()Ljava/lang/String;", "moduleId", "getModuleId", "check", "Lcom/obric/security/health/model/HealthCheckResult;", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "optimize", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class RiskBehaviorProtectionTask extends HealthCheckTask {
    private static final Companion Companion = null;

    @Deprecated
    private static final String SOURCE = "RiskBehaviorProtectionTask";
    private final int defaultScore;
    private final HealthFixCapability fixCapability;
    private final String id;
    private final String moduleId;

    /* JADX INFO: compiled from: RiskBehaviorProtectionTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/security/health/score/task/RiskBehaviorProtectionTask$Companion;", "", "()V", "SOURCE", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.security.health.score.task.RiskBehaviorProtectionTask$optimize$1, reason: invalid class name */
    /* JADX INFO: compiled from: RiskBehaviorProtectionTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0094@"}, d2 = {"optimize", "", "context", "Landroid/content/Context;", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/obric/security/health/model/HealthCheckResult;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.score.task.RiskBehaviorProtectionTask", f = "RiskBehaviorProtectionTask.kt", i = {0}, l = {63}, m = "optimize", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ RiskBehaviorProtectionTask this$0;

        AnonymousClass1(RiskBehaviorProtectionTask r1, Continuation r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.optimize(null, this);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RiskBehaviorProtectionTask() {
        this.id = HealthTaskIds.RISK_BEHAVIOR_PROTECTION;
        this.moduleId = HealthModuleIds.SECURITY;
        this.defaultScore = 8;
        this.fixCapability = HealthFixCapability.NAVIGATE;
    }

    @Override // com.obric.security.health.score.task.HealthCheckTask
    public String getId() {
        return this.id;
    }

    @Override // com.obric.security.health.score.task.HealthCheckTask
    public String getModuleId() {
        return this.moduleId;
    }

    @Override // com.obric.security.health.score.task.HealthCheckTask
    public int getDefaultScore() {
        return this.defaultScore;
    }

    @Override // com.obric.security.health.score.task.HealthCheckTask
    public HealthFixCapability getFixCapability() {
        return this.fixCapability;
    }

    @Override // com.obric.security.health.score.task.HealthCheckTask
    protected Object check(Context r25, Continuation<? super HealthCheckResult> r26) {
        int r0 = Settings.System.getInt(r25.getContentResolver(), SmsBodyCheckManager.SMS_INTERCEPT_YULORE_TYPE, 0);
        int r3 = Settings.Global.getInt(r25.getContentResolver(), NumberCheckManager.SETTINGS_KEY, 0);
        List<RiskSwitchState> r5 = RiskBehaviorProtectionHelper.INSTANCE.buildSmsSwitchStates(r0);
        List<RiskSwitchState> r6 = RiskBehaviorProtectionHelper.INSTANCE.buildCallSwitchStates(r3);
        boolean r7 = RiskBehaviorProtectionHelper.INSTANCE.isAnySwitchEnabled(r5);
        boolean r8 = RiskBehaviorProtectionHelper.INSTANCE.isAnySwitchEnabled(r6);
        boolean r9 = RiskBehaviorProtectionHelper.INSTANCE.isSmsRequiredForRiskScore();
        if (r9 == false) goto L8;
        if (r7 == false) goto L7;
        if (r8 == false) goto L7;
        boolean r11 = true;
    L9:
        List<RiskSwitchState> r10 = r5;
        List<RiskSwitchState> r12 = r6;
        HealthScoreLog.INSTANCE.d(SOURCE, "checkRiskBehaviorProtection sms=" + r0 + " call=" + r3 + " smsEnabled=" + r7 + " callEnabled=" + r8 + " smsRequired=" + r9 + " enabled=" + r11 + ' ' + CollectionsKt.joinToString$default(CollectionsKt.plus(r10, r12), null, null, null, 0, null, AnonymousClass2.INSTANCE, 31, null));
        String r16 = getId();
        if (r11 == false) goto L12;
        HealthCheckStatus r13 = HealthCheckStatus.PASS;
    L13:
        HealthCheckStatus r17 = r13;
        List r14 = CollectionsKt.plus(r10, r12);
        LinkedHashMap r15 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r14, 10)), 16));
        Iterator r18 = r14.iterator();
    L15:
        if (r18.hasNext() == false) goto L17;
        RiskSwitchState r19 = (RiskSwitchState) r18.next();
        Pair r20 = TuplesKt.to(r19.getKey(), String.valueOf(r19.getEnabled()));
        r15.put(r20.getFirst(), r20.getSecond());
        goto L15
    L17:
        Pair[] r21 = new Pair[6];
        r21[0] = TuplesKt.to(SmsBodyCheckManager.SMS_INTERCEPT_YULORE_TYPE, String.valueOf(r0));
        r21[1] = TuplesKt.to(NumberCheckManager.SETTINGS_KEY, String.valueOf(r3));
        r21[2] = TuplesKt.to("black_white_list_rule", "match_by_number_not_score_switch");
        r21[3] = TuplesKt.to("sms_enabled", String.valueOf(r7));
        r21[4] = TuplesKt.to("call_enabled", String.valueOf(r8));
        if (r9 == false) goto L20;
        String r1 = "sms_and_call_required";
    L21:
        r21[5] = TuplesKt.to("risk_score_policy", r1);
        return new HealthCheckResult(r16, r17, null, MapsKt.plus(r15, MapsKt.mapOf(r21)), 4, null);
    L20:
        r1 = "call_switch_required";
        goto L21
    L12:
        r13 = HealthCheckStatus.FAIL;
    L7:
        r11 = false;
        goto L9
    L8:
        r11 = r8;
        goto L9
    }

    @Override // com.obric.security.health.score.task.HealthCheckTask
    protected Object optimize(Context r17, Continuation<? super HealthCheckResult> r18) {
        RiskBehaviorProtectionTask r0 = this;
        if ((r18 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r2 = (AnonymousClass1) r18;
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r2.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        r0 = (RiskBehaviorProtectionTask) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L18:
        if (((Boolean) r1).booleanValue() == false) goto L21;
        return new HealthCheckResult(r0.getId(), HealthCheckStatus.PASS, null, MapsKt.mapOf(TuplesKt.to("activity_launched", Constants.IS_SET)), 4, null);
    L21:
        return new HealthCheckResult(r0.getId(), HealthCheckStatus.ERROR, "launch intercept settings failed", null, 8, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        RiskBehaviorProtectionHelper r5 = RiskBehaviorProtectionHelper.INSTANCE;
        r2.L$0 = r0;
        r2.label = 1;
        r1 = r5.launchInterceptSettings(r17, r2);
        if (r1 != r3) goto L18;
        return r3;
    L7:
        r2 = new AnonymousClass1(r0, r18);
        goto L8
    }
}
