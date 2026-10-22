package com.obric.aikernel.phx.core.conn;

import android.content.ComponentName;
import android.content.Context;
import android.os.IBinder;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.sdk.AIKernelConfig;
import cz.msebera.android.httpclient.message.TokenParser;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: compiled from: ServiceConnector.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003*\u0002\r\u0012\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/obric/aikernel/phx/core/conn/ServiceConnector;", "", "context", "Landroid/content/Context;", "aiKernelConfig", "Lcom/obric/aikernel/sdk/AIKernelConfig;", "connName", "Landroid/content/ComponentName;", "(Landroid/content/Context;Lcom/obric/aikernel/sdk/AIKernelConfig;Landroid/content/ComponentName;)V", "connectTask", "Lkotlinx/coroutines/Deferred;", "Lcom/obric/aikernel/AIKBinder;", WsConstants.KEY_CONNECTION, "com/obric/aikernel/phx/core/conn/ServiceConnector$connection$1", "Lcom/obric/aikernel/phx/core/conn/ServiceConnector$connection$1;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "lifeCycleConnection", "com/obric/aikernel/phx/core/conn/ServiceConnector$lifeCycleConnection$1", "Lcom/obric/aikernel/phx/core/conn/ServiceConnector$lifeCycleConnection$1;", "remote", "getService", "timeout", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ServiceConnector {
    public static final long BINDER_TIMEOUT = 5000;
    public static final Companion Companion = null;
    private static final String TAG = "ServiceConnector";
    private final AIKernelConfig aiKernelConfig;
    private final ComponentName connName;
    private Deferred<? extends AIKBinder> connectTask;
    private final ServiceConnector$connection$1 connection;
    private final Context context;
    private volatile CancellableContinuation<? super AIKBinder> continuation;
    private final ServiceConnector$lifeCycleConnection$1 lifeCycleConnection;
    private volatile AIKBinder remote;

    /* JADX INFO: compiled from: ServiceConnector.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/aikernel/phx/core/conn/ServiceConnector$Companion;", "", "()V", "BINDER_TIMEOUT", "", "TAG", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.conn.ServiceConnector$getService$2, reason: invalid class name */
    /* JADX INFO: compiled from: ServiceConnector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/aikernel/AIKBinder;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.core.conn.ServiceConnector$getService$2", f = "ServiceConnector.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AIKBinder>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ServiceConnector this$0;

        AnonymousClass2(ServiceConnector r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, r3);
            r0.L$0 = r2;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super AIKBinder> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super AIKBinder> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r14) {
            Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r4 = this.label;
            IBinder r6 = null;
            if (r4 == 0) goto L11;
            if (r4 != 1) goto L10;
            ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L7
        L56:
            Object r15 = Result.m1508constructorimpl((AIKBinder) r14);     // Catch: Throwable -> L7
        L59:
            Throwable r0 = Result.m1511exceptionOrNullimpl(r15);
            if (r0 == null) goto L63;
            AIKLog.INSTANCE.w(ServiceConnector.TAG, "connectTask failed by " + r0);
        L63:
            if (Result.m1514isFailureimpl(r15) == false) goto L65;
            r15 = null;
        L65:
            AIKBinder r16 = (AIKBinder) r15;
            if (r16 == null) goto L80;
            ServiceConnector r13 = this.this$0;
            AIKLog r1 = AIKLog.INSTANCE;
            StringBuilder r2 = new StringBuilder("await finished ");
            AIKBinder r17 = ServiceConnector.access$getRemote$p(r13);
            if (r17 == null) goto L70;
            r6 = r17.asBinder();
        L70:
            r1.v(ServiceConnector.TAG, r2.append(r6).toString());
            return r16;
        L80:
            return null;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r14);
            CoroutineScope r18 = (CoroutineScope) this.L$0;
            ServiceConnector r19 = this.this$0;
            monitor-enter(r19);
            AIKBinder r5 = ServiceConnector.access$getRemote$p(r19);     // Catch: Throwable -> L72
            boolean r7 = false;
            if (r5 == null) goto L20;
            IBinder r8 = r5.asBinder();     // Catch: Throwable -> L72
            if (r8 == null) goto L20;
            if (r8.isBinderAlive() != true) goto L20;
            boolean r9 = true;
        L22:
            if (r9 == true) goto L39;
            AIKLog r10 = AIKLog.INSTANCE;     // Catch: Throwable -> L72
            StringBuilder r11 = new StringBuilder("should rebind ");     // Catch: Throwable -> L72
            AIKBinder r12 = ServiceConnector.access$getRemote$p(r19);     // Catch: Throwable -> L72
            if (r12 == null) goto L26;
            IBinder r20 = r12.asBinder();     // Catch: Throwable -> L72
        L27:
            StringBuilder r21 = r11.append(r20).append(TokenParser.SP).append(ServiceConnector.access$getConnectTask$p(r19)).append(TokenParser.SP);     // Catch: Throwable -> L72
            Deferred r110 = ServiceConnector.access$getConnectTask$p(r19);     // Catch: Throwable -> L72
            if (r110 == null) goto L30;
            Boolean r111 = Boxing.boxBoolean(r110.isCompleted());     // Catch: Throwable -> L72
        L31:
            r10.d(ServiceConnector.TAG, r21.append(r111).toString());     // Catch: Throwable -> L72
            Deferred r22 = ServiceConnector.access$getConnectTask$p(r19);     // Catch: Throwable -> L72
            if (r22 != null) goto L34;
        L36:
            if (r7 == false) goto L39;
            ServiceConnector.access$setConnectTask$p(r19, null);     // Catch: Throwable -> L72
            goto L39
        L34:
            if (r22.isCompleted() != true) goto L36;
            r7 = true;
            goto L36
        L30:
            r111 = null;
            goto L31
        L26:
            r20 = null;
        L39:
            if (ServiceConnector.access$getConnectTask$p(r19) != null) goto L45;
            AIKLog r23 = AIKLog.INSTANCE;     // Catch: Throwable -> L72
            StringBuilder r24 = new StringBuilder("new task ");     // Catch: Throwable -> L72
            AIKBinder r25 = ServiceConnector.access$getRemote$p(r19);     // Catch: Throwable -> L72
            if (r25 == null) goto L43;
            IBinder r26 = r25.asBinder();     // Catch: Throwable -> L72
        L44:
            r23.i(ServiceConnector.TAG, r24.append(r26).toString());     // Catch: Throwable -> L72
            ServiceConnector.access$setConnectTask$p(r19, BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ServiceConnector$getService$2$1$1(r19, null), 3, null));     // Catch: Throwable -> L72
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ServiceConnector$getService$2$1$2(ServiceConnector.access$getConnectTask$p(r19), null), 3, null);     // Catch: Throwable -> L72
        L50:
            Deferred r27 = ServiceConnector.access$getConnectTask$p(r19);     // Catch: Throwable -> L72
            monitor-exit(r19);
            if (r27 == null) goto L79;
            Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L7
            this.label = 1;     // Catch: Throwable -> L7
            r14 = r27.await(this);     // Catch: Throwable -> L7
            if (r14 != r3) goto L56;
            return r3;
        L79:
            return null;
        L43:
            r26 = null;
            goto L44
        L45:
            AIKLog r28 = AIKLog.INSTANCE;     // Catch: Throwable -> L72
            StringBuilder r29 = new StringBuilder("reuse task ").append(ServiceConnector.access$getConnectTask$p(r19)).append(TokenParser.SP);     // Catch: Throwable -> L72
            Deferred r30 = ServiceConnector.access$getConnectTask$p(r19);     // Catch: Throwable -> L72
            if (r30 == null) goto L48;
            Boolean r31 = Boxing.boxBoolean(r30.isCompleted());     // Catch: Throwable -> L72
        L49:
            r28.d(ServiceConnector.TAG, r29.append(r31).toString());     // Catch: Throwable -> L72
            goto L50
        L48:
            r31 = null;
        L20:
            r9 = false;
        L72:
            th = move-exception;
            throw th;
        L7:
            th = move-exception;
            Result.Companion r32 = Result.Companion;
            r15 = Result.m1508constructorimpl(ResultKt.createFailure(th));
            goto L59
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.obric.aikernel.phx.core.conn.ServiceConnector$connection$1] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.obric.aikernel.phx.core.conn.ServiceConnector$lifeCycleConnection$1] */
    public ServiceConnector(Context r2, AIKernelConfig r3, ComponentName r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "aiKernelConfig");
        Intrinsics.checkNotNullParameter(r4, "connName");
        this.context = r2;
        this.aiKernelConfig = r3;
        this.connName = r4;
        this.connection = new ServiceConnector$connection$1(this);
        this.lifeCycleConnection = new ServiceConnector$lifeCycleConnection$1(this);
    }

    public static final /* synthetic */ AIKernelConfig access$getAiKernelConfig$p(ServiceConnector r0) {
        return r0.aiKernelConfig;
    }

    public static final /* synthetic */ ComponentName access$getConnName$p(ServiceConnector r0) {
        return r0.connName;
    }

    public static final /* synthetic */ Deferred access$getConnectTask$p(ServiceConnector r0) {
        return r0.connectTask;
    }

    public static final /* synthetic */ ServiceConnector$connection$1 access$getConnection$p(ServiceConnector r0) {
        return r0.connection;
    }

    public static final /* synthetic */ Context access$getContext$p(ServiceConnector r0) {
        return r0.context;
    }

    public static final /* synthetic */ CancellableContinuation access$getContinuation$p(ServiceConnector r0) {
        return r0.continuation;
    }

    public static final /* synthetic */ ServiceConnector$lifeCycleConnection$1 access$getLifeCycleConnection$p(ServiceConnector r0) {
        return r0.lifeCycleConnection;
    }

    public static final /* synthetic */ AIKBinder access$getRemote$p(ServiceConnector r0) {
        return r0.remote;
    }

    public static final /* synthetic */ void access$setConnectTask$p(ServiceConnector r0, Deferred r1) {
        r0.connectTask = r1;
    }

    public static final /* synthetic */ void access$setContinuation$p(ServiceConnector r0, CancellableContinuation r1) {
        r0.continuation = r1;
    }

    public static final /* synthetic */ void access$setRemote$p(ServiceConnector r0, AIKBinder r1) {
        r0.remote = r1;
    }

    public static /* synthetic */ Object getService$default(ServiceConnector r0, long r1, Continuation r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 5000;
    L6:
        return r0.getService(r1, r3);
    }

    public final Object getService(long r4, Continuation<? super AIKBinder> r6) {
        AIKBinder r0 = this.remote;
        boolean r1 = false;
        if (r0 == null) goto L9;
        IBinder r2 = r0.asBinder();
        if (r2 == null) goto L9;
        if (r2.isBinderAlive() != true) goto L9;
        r1 = true;
    L9:
        if (r1 == false) goto L13;
        return this.remote;
    L13:
        return TimeoutKt.withTimeoutOrNull(r4, new AnonymousClass2(this, null), r6);
    }
}
