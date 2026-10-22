package com.obric.security.health.score.task;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.UserHandle;
import com.android.internal.widget.LockPatternUtils;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.bytedanceos.utils.Constants;
import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import com.obric.security.health.model.HealthCheckResult;
import com.obric.security.health.model.HealthCheckStatus;
import com.obric.security.health.model.HealthFixCapability;
import com.obric.security.health.score.HealthModuleIds;
import com.obric.security.health.score.HealthScoreLog;
import com.obric.security.health.score.HealthTaskIds;
import kotlin.Metadata;
import kotlin.Pair;
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

/* JADX INFO: compiled from: FingerprintRecommendTask.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0094@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u0015H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0019\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0094@ø\u0001\u0000¢\u0006\u0002\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcom/obric/security/health/score/task/FingerprintRecommendTask;", "Lcom/obric/security/health/score/task/HealthCheckTask;", "()V", "defaultScore", "", "getDefaultScore", "()I", "fixCapability", "Lcom/obric/security/health/model/HealthFixCapability;", "getFixCapability", "()Lcom/obric/security/health/model/HealthFixCapability;", SlardarConfigConsts.CONFIG_ID, "", "getId", "()Ljava/lang/String;", "moduleId", "getModuleId", AccountInfoBundleKey.USER_ID, "check", "Lcom/obric/security/health/model/HealthCheckResult;", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFingerprintState", "Lcom/obric/security/health/score/task/FingerprintRecommendTask$BiometricState;", "launchLockScreenSettings", "", "optimize", "BiometricState", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class FingerprintRecommendTask extends HealthCheckTask {

    @Deprecated
    private static final String ACTION_BIOMETRIC_SETTINGS = "android.settings.BIOMETRIC_ENROLL";
    private static final Companion Companion = null;

    @Deprecated
    private static final String SETTINGS_PACKAGE = "com.android.settings";

    @Deprecated
    private static final String SOURCE = "FingerprintRecommendTask";
    private final int defaultScore;
    private final HealthFixCapability fixCapability;
    private final String id;
    private final String moduleId;
    private final int userId;

    /* JADX INFO: compiled from: FingerprintRecommendTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/security/health/score/task/FingerprintRecommendTask$BiometricState;", "", "hardwareDetected", "", "enrolled", "(ZZ)V", "getEnrolled", "()Z", "getHardwareDetected", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class BiometricState {
        private final boolean enrolled;
        private final boolean hardwareDetected;

        public static /* synthetic */ BiometricState copy$default(BiometricState r0, boolean r1, boolean r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.hardwareDetected;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.enrolled;
        L9:
            return r0.copy(r1, r2);
        }

        public final boolean component1() {
            return this.hardwareDetected;
        }

        public final boolean component2() {
            return this.enrolled;
        }

        public final BiometricState copy(boolean r1, boolean r2) {
            return new BiometricState(r1, r2);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof BiometricState) == false) goto L10;
            BiometricState r4 = (BiometricState) r3;
            if (this.hardwareDetected == r4.hardwareDetected) goto L8;
            return false;
        L8:
            if (this.enrolled == r4.enrolled) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        public int hashCode() {
            boolean r0 = this.hardwareDetected;
            ?? r1 = 1;
            ?? r2 = r0;
            if (r0 == false) goto L5;
            r2 = 1;
        L5:
            int r3 = r2 * 31;
            boolean r4 = this.enrolled;
            if (r4 == true) goto L10;
            r1 = r4;
        L10:
            return r3 + r1;
        }

        public String toString() {
            return "BiometricState(hardwareDetected=" + this.hardwareDetected + ", enrolled=" + this.enrolled + ")";
        }

        public BiometricState(boolean r1, boolean r2) {
            this.hardwareDetected = r1;
            this.enrolled = r2;
        }

        public final boolean getHardwareDetected() {
            return this.hardwareDetected;
        }

        public final boolean getEnrolled() {
            return this.enrolled;
        }
    }

    /* JADX INFO: compiled from: FingerprintRecommendTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/security/health/score/task/FingerprintRecommendTask$Companion;", "", "()V", "ACTION_BIOMETRIC_SETTINGS", "", "SETTINGS_PACKAGE", "SOURCE", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.security.health.score.task.FingerprintRecommendTask$launchLockScreenSettings$2, reason: invalid class name */
    /* JADX INFO: compiled from: FingerprintRecommendTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.score.task.FingerprintRecommendTask$launchLockScreenSettings$2", f = "FingerprintRecommendTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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
            FingerprintRecommendTask.access$Companion();     // Catch: Throwable -> L10
            Intent r7 = new Intent(FingerprintRecommendTask.ACTION_BIOMETRIC_SETTINGS);     // Catch: Throwable -> L10
            FingerprintRecommendTask.access$Companion();     // Catch: Throwable -> L10
            r7.setPackage("com.android.settings");     // Catch: Throwable -> L10
            r7.addCategory("android.intent.category.DEFAULT");     // Catch: Throwable -> L10
            if ((this.$context instanceof Activity) == true) goto L8;
            r7.addFlags(268435456);     // Catch: Throwable -> L10
        L8:
            this.$context.startActivity(r7);     // Catch: Throwable -> L10
            Object r3 = Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
        L12:
            Throwable r8 = Result.m777exceptionOrNullimpl(r3);
            if (r8 == null) goto L16;
            HealthScoreLog r0 = HealthScoreLog.INSTANCE;
            FingerprintRecommendTask.access$Companion();
            r0.e(FingerprintRecommendTask.SOURCE, "launchFingerprintSettingsFailed", r8);
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

    /* JADX INFO: renamed from: com.obric.security.health.score.task.FingerprintRecommendTask$optimize$1, reason: invalid class name */
    /* JADX INFO: compiled from: FingerprintRecommendTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0094@"}, d2 = {"optimize", "", "context", "Landroid/content/Context;", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/obric/security/health/model/HealthCheckResult;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.score.task.FingerprintRecommendTask", f = "FingerprintRecommendTask.kt", i = {0}, l = {57}, m = "optimize", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FingerprintRecommendTask this$0;

        AnonymousClass1(FingerprintRecommendTask r1, Continuation r2) {
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

    public FingerprintRecommendTask() {
        this.userId = UserHandle.myUserId();
        this.id = HealthTaskIds.FINGERPRINT_RECOMMEND;
        this.moduleId = HealthModuleIds.SECURITY;
        this.defaultScore = 6;
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
    protected Object check(Context r12, Continuation<? super HealthCheckResult> r13) {
        Context r14 = r12.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r14, "appContext");
        BiometricState r15 = getFingerprintState(r14);
        boolean r16 = r15.getHardwareDetected();
        boolean r0 = r15.getEnrolled();
        HealthScoreLog.INSTANCE.d(SOURCE, "checkFingerprintUnlock fingerprint=" + r15 + " capability=" + r16);
        String r5 = getId();
        if (r16 == false) goto L7;
        if (r0 == true) goto L7;
        HealthCheckStatus r11 = HealthCheckStatus.FAIL;
    L9:
        return new HealthCheckResult(r5, r11, null, MapsKt.mapOf(new Pair[]{TuplesKt.to("fingerprint_hardware_detected", String.valueOf(r15.getHardwareDetected())), TuplesKt.to("fingerprint_enrolled", String.valueOf(r15.getEnrolled()))}), 4, null);
    L7:
        r11 = HealthCheckStatus.PASS;
        goto L9
    }

    @Override // com.obric.security.health.score.task.HealthCheckTask
    protected Object optimize(Context r17, Continuation<? super HealthCheckResult> r18) {
        FingerprintRecommendTask r0 = this;
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
        r0 = (FingerprintRecommendTask) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L18:
        if (((Boolean) r1).booleanValue() == false) goto L21;
        return new HealthCheckResult(r0.getId(), HealthCheckStatus.PASS, null, MapsKt.mapOf(TuplesKt.to("activity_launched", Constants.IS_SET)), 4, null);
    L21:
        return new HealthCheckResult(r0.getId(), HealthCheckStatus.ERROR, "launch lock screen settings failed", null, 8, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        r2.L$0 = r0;
        r2.label = 1;
        r1 = r0.launchLockScreenSettings(r17, r2);
        if (r1 != r3) goto L18;
        return r3;
    L7:
        r2 = new AnonymousClass1(r0, r18);
        goto L8
    }

    private final Object launchLockScreenSettings(Context r3, Continuation<? super Boolean> r4) {
        return BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(r3, null), r4);
    }

    private final BiometricState getFingerprintState(Context r6) {
        Object r0 = r6.getSystemService("fingerprint");
        if ((r0 instanceof FingerprintManager) == true) goto L5;
        r0 = null;
    L5:
        FingerprintManager r1 = (FingerprintManager) r0;
        if (r1 == null) goto L8;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L24
        FingerprintRecommendTask r3 = this;     // Catch: Throwable -> L24
        boolean r4 = r1.isHardwareDetected();     // Catch: Throwable -> L24
        LockPatternUtils r5 = new LockPatternUtils(r6);     // Catch: Throwable -> L24
        boolean r7 = true;
        if (r5.isSecure(this.userId) == false) goto L12;
    L14:
        boolean r8 = false;
    L16:
        if (r8 == true) goto L21;
        if (r4 == false) goto L21;
        if (r1.hasEnrolledFingerprints() == false) goto L21;
    L22:
        Object r9 = Result.m774constructorimpl(new BiometricState(r4, r7));     // Catch: Throwable -> L24
    L26:
        Throwable r10 = Result.m777exceptionOrNullimpl(r9);
        if (r10 == null) goto L29;
        HealthScoreLog.INSTANCE.e(SOURCE, "getFingerprintStateFailed", r10);
    L29:
        BiometricState r11 = new BiometricState(false, false);
        if (Result.m780isFailureimpl(r9) == false) goto L33;
        r9 = r11;
    L33:
        return (BiometricState) r9;
    L21:
        r7 = false;
        goto L22
    L12:
        if (r5.isLockScreenDisabled(this.userId) == true) goto L14;
        r8 = true;
    L24:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r9 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L26
    L8:
        return new BiometricState(false, false);
    }
}
