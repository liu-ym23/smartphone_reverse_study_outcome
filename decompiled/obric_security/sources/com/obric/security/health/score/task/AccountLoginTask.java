package com.obric.security.health.score.task;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.bytedanceos.utils.Constants;
import com.obric.matrix.platform.sdk.ones.account.OAccount;
import com.obric.security.health.model.HealthCheckResult;
import com.obric.security.health.model.HealthCheckStatus;
import com.obric.security.health.model.HealthFixCapability;
import com.obric.security.health.score.HealthModuleIds;
import com.obric.security.health.score.HealthScoreLog;
import com.obric.security.health.score.HealthTaskIds;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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

/* JADX INFO: compiled from: AccountLoginTask.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0094@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0094@ø\u0001\u0000¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/obric/security/health/score/task/AccountLoginTask;", "Lcom/obric/security/health/score/task/HealthCheckTask;", "()V", "defaultScore", "", "getDefaultScore", "()I", "fixCapability", "Lcom/obric/security/health/model/HealthFixCapability;", "getFixCapability", "()Lcom/obric/security/health/model/HealthFixCapability;", SlardarConfigConsts.CONFIG_ID, "", "getId", "()Ljava/lang/String;", "moduleId", "getModuleId", "check", "Lcom/obric/security/health/model/HealthCheckResult;", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "launchAccountPage", "", "optimize", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class AccountLoginTask extends HealthCheckTask {
    private static final Companion Companion = null;

    @Deprecated
    private static final String SOURCE = "AccountLoginTask";
    private final int defaultScore;
    private final HealthFixCapability fixCapability;
    private final String id;
    private final String moduleId;

    /* JADX INFO: compiled from: AccountLoginTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/security/health/score/task/AccountLoginTask$Companion;", "", "()V", "SOURCE", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.security.health.score.task.AccountLoginTask$launchAccountPage$2, reason: invalid class name */
    /* JADX INFO: compiled from: AccountLoginTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.score.task.AccountLoginTask$launchAccountPage$2", f = "AccountLoginTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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
        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L23;
            ResultKt.throwOnFailure(r7);
            CoroutineScope r8 = (CoroutineScope) this.L$0;
            Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L15
            Intent r10 = new Intent();     // Catch: Throwable -> L15
            OAccount.INSTANCE.accountLaunchIntent(this.$context, r10);     // Catch: Throwable -> L15
            boolean r3 = true;
            boolean r2 = OAccount.INSTANCE.isLogin(true);     // Catch: Throwable -> L15
            HealthScoreLog r4 = HealthScoreLog.INSTANCE;     // Catch: Throwable -> L15
            AccountLoginTask.access$Companion();     // Catch: Throwable -> L15
            StringBuilder r5 = new StringBuilder("prepareAccountLaunchIntent isLogin=");     // Catch: Throwable -> L15
            if (r2 == true) goto L9;
            r3 = false;
        L9:
            r4.i(AccountLoginTask.SOURCE, r5.append(r3).toString());     // Catch: Throwable -> L15
            if ((this.$context instanceof Activity) == false) goto L12;
            r10.removeFlags(268435456);     // Catch: Throwable -> L15
        L13:
            this.$context.startActivity(r10);     // Catch: Throwable -> L15
            Object r6 = Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
        L17:
            Throwable r11 = Result.m777exceptionOrNullimpl(r6);
            if (r11 == null) goto L21;
            HealthScoreLog r1 = HealthScoreLog.INSTANCE;
            AccountLoginTask.access$Companion();
            r1.e(AccountLoginTask.SOURCE, "launchAccountPageFailed", r11);
        L21:
            return Boxing.boxBoolean(Result.m781isSuccessimpl(r6));
        L12:
            Intrinsics.checkNotNullExpressionValue(r10.addFlags(268435456), "intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)");     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            Result.Companion r12 = Result.Companion;
            r6 = Result.m774constructorimpl(ResultKt.createFailure(th));
            goto L17
        L23:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.security.health.score.task.AccountLoginTask$optimize$1, reason: invalid class name */
    /* JADX INFO: compiled from: AccountLoginTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0094@"}, d2 = {"optimize", "", "context", "Landroid/content/Context;", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/obric/security/health/model/HealthCheckResult;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.score.task.AccountLoginTask", f = "AccountLoginTask.kt", i = {0}, l = {44}, m = "optimize", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AccountLoginTask this$0;

        AnonymousClass1(AccountLoginTask r1, Continuation r2) {
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

    public AccountLoginTask() {
        this.id = HealthTaskIds.ACCOUNT_LOGGED_IN;
        this.moduleId = HealthModuleIds.UPDATE;
        this.defaultScore = 4;
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
    protected Object check(Context r7, Continuation<? super HealthCheckResult> r8) {
        String r9 = null;
        String r10 = (String) null;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        AccountLoginTask r1 = this;     // Catch: Throwable -> L5
        Object r2 = Result.m774constructorimpl(Boxing.boxBoolean(OAccount.INSTANCE.isLogin(true)));     // Catch: Throwable -> L5
    L7:
        Throwable r3 = Result.m777exceptionOrNullimpl(r2);
        if (r3 == null) goto L13;
        String r4 = r3.getMessage();
        if (r4 != null) goto L12;
        r4 = r3.getClass().getSimpleName();
    L12:
        HealthScoreLog.INSTANCE.e(SOURCE, "getAccountLoginStateFailed", r3);
    L15:
        if (Result.m780isFailureimpl(r2) == false) goto L17;
        r2 = null;
    L17:
        Boolean r5 = (Boolean) r2;
        String r6 = getId();
        if (Intrinsics.areEqual(r5, Boxing.boxBoolean(true)) == false) goto L21;
        HealthCheckStatus r11 = HealthCheckStatus.PASS;
    L25:
        if (r5 == null) goto L27;
        r9 = String.valueOf(r5.booleanValue());
    L27:
        if (r9 != null) goto L30;
        r9 = "";
    L30:
        return new HealthCheckResult(r6, r11, r4, MapsKt.mapOf(TuplesKt.to("account_is_login", r9)));
    L21:
        if (Intrinsics.areEqual(r5, Boxing.boxBoolean(false)) == false) goto L23;
        r11 = HealthCheckStatus.FAIL;
        goto L25
    L23:
        if (r5 != null) goto L32;
        r11 = HealthCheckStatus.ERROR;
        goto L25
    L32:
        throw new NoWhenBranchMatchedException();
    L13:
        r4 = null;
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r2 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.obric.security.health.score.task.HealthCheckTask
    protected Object optimize(Context r17, Continuation<? super HealthCheckResult> r18) {
        AccountLoginTask r0 = this;
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
        r0 = (AccountLoginTask) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L18:
        if (((Boolean) r1).booleanValue() == false) goto L21;
        return new HealthCheckResult(r0.getId(), HealthCheckStatus.PASS, null, MapsKt.mapOf(TuplesKt.to("activity_launched", Constants.IS_SET)), 4, null);
    L21:
        return new HealthCheckResult(r0.getId(), HealthCheckStatus.ERROR, "launch account page failed", null, 8, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        r2.L$0 = r0;
        r2.label = 1;
        r1 = r0.launchAccountPage(r17, r2);
        if (r1 != r3) goto L18;
        return r3;
    L7:
        r2 = new AnonymousClass1(r0, r18);
        goto L8
    }

    private final Object launchAccountPage(Context r3, Continuation<? super Boolean> r4) {
        return BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(r3, null), r4);
    }
}
