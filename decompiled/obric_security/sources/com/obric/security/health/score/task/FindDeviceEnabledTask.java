package com.obric.security.health.score.task;

import android.app.Activity;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.bytedance.networkstackapplib.NetworkStackConstant;
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

/* JADX INFO: compiled from: FindDeviceEnabledTask.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0094@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0019\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0094@ø\u0001\u0000¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lcom/obric/security/health/score/task/FindDeviceEnabledTask;", "Lcom/obric/security/health/score/task/HealthCheckTask;", "()V", "defaultScore", "", "getDefaultScore", "()I", "fixCapability", "Lcom/obric/security/health/model/HealthFixCapability;", "getFixCapability", "()Lcom/obric/security/health/model/HealthFixCapability;", SlardarConfigConsts.CONFIG_ID, "", "getId", "()Ljava/lang/String;", "moduleId", "getModuleId", "check", "Lcom/obric/security/health/model/HealthCheckResult;", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFindDeviceStatus", "Lcom/obric/security/health/score/task/FindDeviceEnabledTask$FindDeviceStatus;", "launchFindDevicePage", "", "optimize", "Companion", "FindDeviceStatus", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class FindDeviceEnabledTask extends HealthCheckTask {
    private static final Companion Companion = null;

    @Deprecated
    private static final String FIND_DEVICE_ACTION = "com.obric.cloudservice.ACTION_FIND_DEVICE";

    @Deprecated
    private static final String FIND_DEVICE_PACKAGE = "com.obric.cloudservice";

    @Deprecated
    private static final String FIND_DEVICE_PROVIDER_AUTHORITY = "com.obric.cloudservice.finddeviceprovider";

    @Deprecated
    private static final String METHOD_IS_FIND_DEVICE_ENABLED = "request_get_find_device_switch";

    @Deprecated
    private static final String RESULT_KEY_RESULT = "result";

    @Deprecated
    private static final String SOURCE = "FindDeviceEnabledTask";
    private final int defaultScore;
    private final HealthFixCapability fixCapability;
    private final String id;
    private final String moduleId;

    /* JADX INFO: compiled from: FindDeviceEnabledTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/security/health/score/task/FindDeviceEnabledTask$Companion;", "", "()V", "FIND_DEVICE_ACTION", "", "FIND_DEVICE_PACKAGE", "FIND_DEVICE_PROVIDER_AUTHORITY", "METHOD_IS_FIND_DEVICE_ENABLED", "RESULT_KEY_RESULT", "SOURCE", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: compiled from: FindDeviceEnabledTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/security/health/score/task/FindDeviceEnabledTask$FindDeviceStatus;", "", "(Ljava/lang/String;I)V", "ON", "OFF", NetworkStackConstant.UNKNOWN_TYPE, "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final enum FindDeviceStatus extends Enum<FindDeviceStatus> {
        private static final /* synthetic */ FindDeviceStatus[] $VALUES = null;
        public static final FindDeviceStatus OFF = null;
        public static final FindDeviceStatus ON = null;
        public static final FindDeviceStatus UNKNOWN = null;

        static {
            FindDeviceStatus r1 = new FindDeviceStatus("ON", 0);
            ON = r1;
            FindDeviceStatus r2 = new FindDeviceStatus("OFF", 1);
            OFF = r2;
            FindDeviceStatus r3 = new FindDeviceStatus(NetworkStackConstant.UNKNOWN_TYPE, 2);
            UNKNOWN = r3;
            $VALUES = new FindDeviceStatus[]{r1, r2, r3};
        }

        public static FindDeviceStatus valueOf(String r1) {
            return (FindDeviceStatus) Enum.valueOf(FindDeviceStatus.class, r1);
        }

        public static FindDeviceStatus[] values() {
            return (FindDeviceStatus[]) $VALUES.clone();
        }

        private FindDeviceStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    /* JADX INFO: renamed from: com.obric.security.health.score.task.FindDeviceEnabledTask$check$1, reason: invalid class name */
    /* JADX INFO: compiled from: FindDeviceEnabledTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0094@"}, d2 = {"check", "", "context", "Landroid/content/Context;", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/obric/security/health/model/HealthCheckResult;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.score.task.FindDeviceEnabledTask", f = "FindDeviceEnabledTask.kt", i = {0}, l = {25}, m = "check", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FindDeviceEnabledTask this$0;

        AnonymousClass1(FindDeviceEnabledTask r1, Continuation r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.check(null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.security.health.score.task.FindDeviceEnabledTask$getFindDeviceStatus$2, reason: invalid class name */
    /* JADX INFO: compiled from: FindDeviceEnabledTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Lcom/obric/security/health/score/task/FindDeviceEnabledTask$FindDeviceStatus;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.score.task.FindDeviceEnabledTask$getFindDeviceStatus$2", f = "FindDeviceEnabledTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super FindDeviceStatus>, Object> {
        final /* synthetic */ Context $context;
        int label;

        AnonymousClass2(Context r1, Continuation r2) {
            this.$context = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            Intrinsics.checkNotNullParameter(r2, "completion");
            return new AnonymousClass2(this.$context, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super FindDeviceStatus> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r13) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L40;
            ResultKt.throwOnFailure(r13);
            Boolean r14 = null;
            ContentProviderClient r1 = (ContentProviderClient) null;
            long r2 = SystemClock.elapsedRealtime();
            long r3 = 0;
            FindDeviceEnabledTask.access$Companion();     // Catch: Throwable -> L27
            long r6 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L27
            Context r12 = this.$context.getApplicationContext();     // Catch: Throwable -> L27
            Intrinsics.checkNotNullExpressionValue(r12, "context.applicationContext");     // Catch: Throwable -> L27
            ContentProviderClient r15 = r12.getContentResolver().acquireUnstableContentProviderClient(FindDeviceEnabledTask.FIND_DEVICE_PROVIDER_AUTHORITY);     // Catch: Throwable -> L27
            if (r15 == null) goto L26;
            long r8 = SystemClock.elapsedRealtime() - r6;
            long r7 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L21
            FindDeviceEnabledTask.access$Companion();     // Catch: Throwable -> L21
            Bundle r5 = r15.call(FindDeviceEnabledTask.FIND_DEVICE_PROVIDER_AUTHORITY, FindDeviceEnabledTask.METHOD_IS_FIND_DEVICE_ENABLED, null, null);     // Catch: Throwable -> L21
            long r4 = SystemClock.elapsedRealtime() - r7;     // Catch: Throwable -> L21
            if (r5 == null) goto L13;
            FindDeviceEnabledTask.access$Companion();     // Catch: Throwable -> L21
            r14 = Boxing.boxBoolean(r5.getBoolean("result"));     // Catch: Throwable -> L21
        L13:
            if (Intrinsics.areEqual(r14, Boxing.boxBoolean(true)) == false) goto L16;
            FindDeviceStatus r16 = FindDeviceStatus.ON;     // Catch: Throwable -> L21
        L19:
            if (r15 == null) goto L33;
            r15.close();
        L33:
            HealthScoreLog r17 = HealthScoreLog.INSTANCE;
            FindDeviceEnabledTask.access$Companion();
            r17.d(FindDeviceEnabledTask.SOURCE, "getFindDeviceStatus result=" + r16 + " acquireCostMs=" + r8 + " callCostMs=" + r4 + " totalCostMs=" + (SystemClock.elapsedRealtime() - r2));
            return r16;
        L16:
            if (Intrinsics.areEqual(r14, Boxing.boxBoolean(false)) == false) goto L18;
            r16 = FindDeviceStatus.OFF;     // Catch: Throwable -> L21
            goto L19
        L18:
            r16 = FindDeviceStatus.UNKNOWN;     // Catch: Throwable -> L21
        L21:
            Throwable th = th;
            r3 = r8;
        L41:
            HealthScoreLog r9 = HealthScoreLog.INSTANCE;     // Catch: Throwable -> L35
            FindDeviceEnabledTask.access$Companion();     // Catch: Throwable -> L35
            r9.e(FindDeviceEnabledTask.SOURCE, "getFindDeviceStatusFailed", th);     // Catch: Throwable -> L35
            r16 = FindDeviceStatus.UNKNOWN;     // Catch: Throwable -> L35
            if (r15 == null) goto L32;
            r15.close();
        L32:
            r8 = r3;
            r4 = 0;
        L35:
            th = move-exception;
            if (r15 == null) goto L38;
            r15.close();
        L38:
            throw th;
        L23:
            th = th;
            goto L41
        L26:
            throw new IllegalStateException("acquireUnstableContentProviderClient failed");     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            th = th;
            r15 = null;
            goto L41
        L40:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.security.health.score.task.FindDeviceEnabledTask$launchFindDevicePage$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FindDeviceEnabledTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.score.task.FindDeviceEnabledTask$launchFindDevicePage$2", f = "FindDeviceEnabledTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03702 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Context $context;
        private /* synthetic */ Object L$0;
        int label;

        C03702(Context r1, Continuation r2) {
            this.$context = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "completion");
            C03702 r0 = new C03702(this.$context, r3);
            r0.L$0 = r2;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return ((C03702) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L18;
            ResultKt.throwOnFailure(r4);
            CoroutineScope r5 = (CoroutineScope) this.L$0;
            Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L10
            Intent r7 = new Intent();     // Catch: Throwable -> L10
            FindDeviceEnabledTask.access$Companion();     // Catch: Throwable -> L10
            r7.setPackage(FindDeviceEnabledTask.FIND_DEVICE_PACKAGE);     // Catch: Throwable -> L10
            FindDeviceEnabledTask.access$Companion();     // Catch: Throwable -> L10
            r7.setAction(FindDeviceEnabledTask.FIND_DEVICE_ACTION);     // Catch: Throwable -> L10
            if ((this.$context instanceof Activity) == true) goto L8;
            r7.addFlags(268435456);     // Catch: Throwable -> L10
        L8:
            this.$context.startActivity(r7);     // Catch: Throwable -> L10
            Object r3 = Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
        L12:
            Throwable r8 = Result.m777exceptionOrNullimpl(r3);
            if (r8 == null) goto L16;
            HealthScoreLog r0 = HealthScoreLog.INSTANCE;
            FindDeviceEnabledTask.access$Companion();
            r0.e(FindDeviceEnabledTask.SOURCE, "launchFindDevicePageFailed", r8);
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

    /* JADX INFO: renamed from: com.obric.security.health.score.task.FindDeviceEnabledTask$optimize$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FindDeviceEnabledTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0094@"}, d2 = {"optimize", "", "context", "Landroid/content/Context;", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/obric/security/health/model/HealthCheckResult;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.score.task.FindDeviceEnabledTask", f = "FindDeviceEnabledTask.kt", i = {0}, l = {34}, m = "optimize", n = {"this"}, s = {"L$0"})
    static final class C03711 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FindDeviceEnabledTask this$0;

        C03711(FindDeviceEnabledTask r1, Continuation r2) {
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

    public FindDeviceEnabledTask() {
        this.id = HealthTaskIds.FIND_DEVICE_ENABLED;
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
    protected Object check(Context r8, Continuation<? super HealthCheckResult> r9) {
        if ((r9 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r9;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        FindDeviceEnabledTask this = (FindDeviceEnabledTask) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L17:
        FindDeviceStatus r11 = (FindDeviceStatus) r10;
        String r3 = this.getId();
        if (r11 != FindDeviceStatus.ON) goto L20;
        HealthCheckStatus r7 = HealthCheckStatus.PASS;
    L22:
        return new HealthCheckResult(r3, r7, null, MapsKt.mapOf(TuplesKt.to("find_device_status", r11.name())), 4, null);
    L20:
        r7 = HealthCheckStatus.FAIL;
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        r0.L$0 = this;
        r0.label = 1;
        r10 = getFindDeviceStatus(r8, r0);
        if (r10 != r1) goto L17;
        return r1;
    L7:
        r0 = new AnonymousClass1(this, r9);
        goto L8
    }

    @Override // com.obric.security.health.score.task.HealthCheckTask
    protected Object optimize(Context r17, Continuation<? super HealthCheckResult> r18) {
        FindDeviceEnabledTask r0 = this;
        if ((r18 instanceof C03711) == false) goto L7;
        C03711 r2 = (C03711) r18;
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r2.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        r0 = (FindDeviceEnabledTask) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L18:
        if (((Boolean) r1).booleanValue() == false) goto L21;
        return new HealthCheckResult(r0.getId(), HealthCheckStatus.PASS, null, MapsKt.mapOf(TuplesKt.to("activity_launched", Constants.IS_SET)), 4, null);
    L21:
        return new HealthCheckResult(r0.getId(), HealthCheckStatus.ERROR, "launch find device page failed", null, 8, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        r2.L$0 = r0;
        r2.label = 1;
        r1 = r0.launchFindDevicePage(r17, r2);
        if (r1 != r3) goto L18;
        return r3;
    L7:
        r2 = new C03711(r0, r18);
        goto L8
    }

    private final Object getFindDeviceStatus(Context r3, Continuation<? super FindDeviceStatus> r4) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(r3, null), r4);
    }

    private final Object launchFindDevicePage(Context r3, Continuation<? super Boolean> r4) {
        return BuildersKt.withContext(Dispatchers.getMain(), new C03702(r3, null), r4);
    }
}
