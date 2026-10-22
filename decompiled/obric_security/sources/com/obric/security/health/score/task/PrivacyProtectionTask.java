package com.obric.security.health.score.task;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.bytedanceos.utils.Constants;
import com.obric.security.health.model.HealthCheckResult;
import com.obric.security.health.model.HealthCheckStatus;
import com.obric.security.health.model.HealthFixCapability;
import com.obric.security.health.score.HealthModuleIds;
import com.obric.security.health.score.HealthScoreLog;
import com.obric.security.health.score.HealthTaskIds;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: PrivacyProtectionTask.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0094@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0019\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0019\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0094@ø\u0001\u0000¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/obric/security/health/score/task/PrivacyProtectionTask;", "Lcom/obric/security/health/score/task/HealthCheckTask;", "()V", "defaultScore", "", "getDefaultScore", "()I", "fixCapability", "Lcom/obric/security/health/model/HealthFixCapability;", "getFixCapability", "()Lcom/obric/security/health/model/HealthFixCapability;", SlardarConfigConsts.CONFIG_ID, "", "getId", "()Ljava/lang/String;", "moduleId", "getModuleId", "check", "Lcom/obric/security/health/model/HealthCheckResult;", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isWlanSecurityDetectEnabled", "", "launchNetworkAssistantActivity", "optimize", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PrivacyProtectionTask extends HealthCheckTask {
    private static final Companion Companion = null;

    @Deprecated
    private static final String NETWORK_ASSISTANT_ACTIVITY = "com.android.settings.wifi.assistant.NetworkAssistantActivity";

    @Deprecated
    private static final String SETTINGS_KEY_WLAN_SECURITY_CHECK = "wlan_security_check";

    @Deprecated
    private static final String SETTINGS_PACKAGE = "com.android.settings";

    @Deprecated
    private static final String SOURCE = "PrivacyProtectionTask";
    private final int defaultScore;
    private final HealthFixCapability fixCapability;
    private final String id;
    private final String moduleId;

    /* JADX INFO: compiled from: PrivacyProtectionTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/security/health/score/task/PrivacyProtectionTask$Companion;", "", "()V", "NETWORK_ASSISTANT_ACTIVITY", "", "SETTINGS_KEY_WLAN_SECURITY_CHECK", "SETTINGS_PACKAGE", "SOURCE", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.security.health.score.task.PrivacyProtectionTask$launchNetworkAssistantActivity$2, reason: invalid class name */
    /* JADX INFO: compiled from: PrivacyProtectionTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.score.task.PrivacyProtectionTask$launchNetworkAssistantActivity$2", f = "PrivacyProtectionTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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
            Intent r7 = new Intent();     // Catch: Throwable -> L10
            PrivacyProtectionTask.access$Companion();     // Catch: Throwable -> L10
            PrivacyProtectionTask.access$Companion();     // Catch: Throwable -> L10
            r7.setClassName("com.android.settings", PrivacyProtectionTask.NETWORK_ASSISTANT_ACTIVITY);     // Catch: Throwable -> L10
            if ((this.$context instanceof Activity) == true) goto L8;
            r7.addFlags(268435456);     // Catch: Throwable -> L10
        L8:
            this.$context.startActivity(r7);     // Catch: Throwable -> L10
            Object r3 = Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
        L12:
            Throwable r8 = Result.m777exceptionOrNullimpl(r3);
            if (r8 == null) goto L16;
            HealthScoreLog r0 = HealthScoreLog.INSTANCE;
            PrivacyProtectionTask.access$Companion();
            r0.e(PrivacyProtectionTask.SOURCE, "launchNetworkAssistantFailed", r8);
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

    /* JADX INFO: renamed from: com.obric.security.health.score.task.PrivacyProtectionTask$optimize$1, reason: invalid class name */
    /* JADX INFO: compiled from: PrivacyProtectionTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0094@"}, d2 = {"optimize", "", "context", "Landroid/content/Context;", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/obric/security/health/model/HealthCheckResult;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.score.task.PrivacyProtectionTask", f = "PrivacyProtectionTask.kt", i = {0}, l = {33}, m = "optimize", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PrivacyProtectionTask this$0;

        AnonymousClass1(PrivacyProtectionTask r1, Continuation r2) {
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

    public static final /* synthetic */ Companion access$Companion() {
        return Companion;
    }

    public PrivacyProtectionTask() {
        this.id = HealthTaskIds.PRIVACY_PROTECTION;
        this.moduleId = HealthModuleIds.SECURITY;
        this.defaultScore = 5;
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
    protected Object check(Context r8, Continuation<? super HealthCheckResult> r9) {
        boolean r10 = isWlanSecurityDetectEnabled(r8);
        String r1 = getId();
        if (r10 == false) goto L5;
        HealthCheckStatus r7 = HealthCheckStatus.PASS;
    L7:
        return new HealthCheckResult(r1, r7, null, MapsKt.mapOf(TuplesKt.to("wlan_security_check_enabled", String.valueOf(r10))), 4, null);
    L5:
        r7 = HealthCheckStatus.FAIL;
        goto L7
    }

    @Override // com.obric.security.health.score.task.HealthCheckTask
    protected Object optimize(Context r17, Continuation<? super HealthCheckResult> r18) {
        PrivacyProtectionTask r0 = this;
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
        r0 = (PrivacyProtectionTask) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L18:
        if (((Boolean) r1).booleanValue() == false) goto L21;
        return new HealthCheckResult(r0.getId(), HealthCheckStatus.PASS, null, MapsKt.mapOf(TuplesKt.to("activity_launched", Constants.IS_SET)), 4, null);
    L21:
        return new HealthCheckResult(r0.getId(), HealthCheckStatus.ERROR, "launch network assistant page failed", null, 8, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        r2.L$0 = r0;
        r2.label = 1;
        r1 = r0.launchNetworkAssistantActivity(r17, r2);
        if (r1 != r3) goto L18;
        return r3;
    L7:
        r2 = new AnonymousClass1(r0, r18);
        goto L8
    }

    private final Object launchNetworkAssistantActivity(Context r3, Continuation<? super Boolean> r4) {
        return BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(r3, null), r4);
    }

    private final boolean isWlanSecurityDetectEnabled(Context r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        PrivacyProtectionTask r3 = this;     // Catch: Throwable -> L4
        Object r5 = Result.m774constructorimpl(Settings.Global.getString(r4.getContentResolver(), SETTINGS_KEY_WLAN_SECURITY_CHECK));     // Catch: Throwable -> L4
    L7:
        if (Result.m780isFailureimpl(r5) == false) goto L9;
        r5 = null;
    L9:
        String r6 = (String) r5;
        if (r6 != null) goto L12;
    L15:
        boolean r7 = true;
    L16:
        HealthScoreLog.INSTANCE.d(SOURCE, "isWlanSecurityDetectEnabled value=" + r6 + " enabled=" + r7);
        return r7;
    L12:
        if (Intrinsics.areEqual(r6, "1") == true) goto L15;
        r7 = false;
    L4:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r5 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
