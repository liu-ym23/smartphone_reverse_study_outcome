package com.obric.aikernel.phx.core.api;

import android.os.Bundle;
import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.phx.compat.ParamsCompat;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.obric.aikernel.sdk.response.Response;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: ScriptBizApi.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J#\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u00122\u0006\u0010\u0004\u001a\u00020\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J)\u0010\u0015\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012\u0018\u00010\u00162\u0006\u0010\u0004\u001a\u00020\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J)\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00120\u00162\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J#\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00122\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/obric/aikernel/phx/core/api/ScriptBizApi;", "Lcom/obric/aikernel/phx/core/api/AbsApi;", "bizName", "", "params", "Lcom/obric/aikernel/sdk/config/RequestParams;", "remote", "Lcom/obric/aikernel/AIKBinder;", "(Ljava/lang/String;Lcom/obric/aikernel/sdk/config/RequestParams;Lcom/obric/aikernel/AIKBinder;)V", "getBizName", "()Ljava/lang/String;", "getParams", "()Lcom/obric/aikernel/sdk/config/RequestParams;", "close", "", "getBinder", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "infer", "Lcom/obric/aikernel/sdk/response/Response;", "", "(Lcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "inferAsFlow", "Lkotlinx/coroutines/flow/Flow;", "inferenceAsFlow", "inferenceTo", "Companion", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ScriptBizApi extends AbsApi {
    public static final Companion Companion = null;
    private static final String TAG = "ScriptBizApi";
    private final String bizName;
    private final RequestParams params;
    private AIKBinder remote;

    /* JADX INFO: compiled from: ScriptBizApi.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/aikernel/phx/core/api/ScriptBizApi$Companion;", "", "()V", "TAG", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.ScriptBizApi$getBinder$1, reason: invalid class name */
    /* JADX INFO: compiled from: ScriptBizApi.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.core.api.ScriptBizApi", f = "ScriptBizApi.kt", i = {0}, l = {26}, m = "getBinder", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ScriptBizApi this$0;

        AnonymousClass1(ScriptBizApi r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getBinder(this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.ScriptBizApi$infer$2, reason: invalid class name */
    /* JADX INFO: compiled from: ScriptBizApi.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/aikernel/sdk/response/Response;", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.core.api.ScriptBizApi$infer$2", f = "ScriptBizApi.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Response<Object>>, Object> {
        final /* synthetic */ RequestParams $params;
        int label;
        final /* synthetic */ ScriptBizApi this$0;

        AnonymousClass2(ScriptBizApi r1, RequestParams r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$params = r2;
            super(1, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, this.$params, r3);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Response<Object>> r1) {
            return invoke2(r1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Response<Object>> r1) {
            return ((AnonymousClass2) create(r1)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            this.label = 1;
            r5 = ScriptBizApi.access$inferenceTo(this.this$0, this.$params, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.ScriptBizApi$inferAsFlow$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ScriptBizApi.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0018\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/flow/Flow;", "Lcom/obric/aikernel/sdk/response/Response;", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.core.api.ScriptBizApi$inferAsFlow$2", f = "ScriptBizApi.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
    static final class C01742 extends SuspendLambda implements Function1<Continuation<? super Flow<? extends Response<Object>>>, Object> {
        final /* synthetic */ RequestParams $params;
        int label;
        final /* synthetic */ ScriptBizApi this$0;

        C01742(ScriptBizApi r1, RequestParams r2, Continuation<? super C01742> r3) {
            this.this$0 = r1;
            this.$params = r2;
            super(1, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r3) {
            return new C01742(this.this$0, this.$params, r3);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Flow<? extends Response<Object>>> r1) {
            return invoke2(r1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Flow<Response<Object>>> r1) {
            return ((C01742) create(r1)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            this.label = 1;
            r5 = ScriptBizApi.access$inferenceAsFlow(this.this$0, this.$params, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.ScriptBizApi$inferenceAsFlow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ScriptBizApi.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.core.api.ScriptBizApi", f = "ScriptBizApi.kt", i = {0, 0, 1, 1}, l = {51, 52}, m = "inferenceAsFlow", n = {"this", "params", "this", "params"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class C01751 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ScriptBizApi this$0;

        C01751(ScriptBizApi r1, Continuation<? super C01751> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ScriptBizApi.access$inferenceAsFlow(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.ScriptBizApi$inferenceTo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ScriptBizApi.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.core.api.ScriptBizApi", f = "ScriptBizApi.kt", i = {0, 0, 1, 1}, l = {43, 44, 44}, m = "inferenceTo", n = {"this", "params", "this", "params"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class C01761 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ScriptBizApi this$0;

        C01761(ScriptBizApi r1, Continuation<? super C01761> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ScriptBizApi.access$inferenceTo(this.this$0, null, this);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static final /* synthetic */ AIKBinder access$getRemote$p(ScriptBizApi r0) {
        return r0.remote;
    }

    public static final /* synthetic */ Object access$inferenceAsFlow(ScriptBizApi r0, RequestParams r1, Continuation r2) {
        return r0.inferenceAsFlow(r1, r2);
    }

    public static final /* synthetic */ Object access$inferenceTo(ScriptBizApi r0, RequestParams r1, Continuation r2) {
        return r0.inferenceTo(r1, r2);
    }

    public final String getBizName() {
        return this.bizName;
    }

    public final RequestParams getParams() {
        return this.params;
    }

    public ScriptBizApi(String r2, RequestParams r3, AIKBinder r4) {
        Intrinsics.checkNotNullParameter(r2, "bizName");
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "remote");
        this.bizName = r2;
        this.params = r3;
        this.remote = r4;
    }

    @Override // com.obric.aikernel.phx.core.api.AbsApi
    public Object getBinder(Continuation<? super AIKBinder> r9) {
        if ((r9 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r9;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        AnonymousClass1 r5 = r0;
        Object r10 = r5.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r5.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ScriptBizApi this = (ScriptBizApi) r5.L$0;
        ResultKt.throwOnFailure(r10);
    L21:
        if ((r10 instanceof ScriptBizApi) == false) goto L23;
        ScriptBizApi r11 = (ScriptBizApi) r10;
    L24:
        if (r11 == null) goto L27;
        this.remote = r11.remote;
    L27:
        return this.remote;
    L23:
        r11 = null;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        if (this.remote.asBinder().isBinderAlive() == true) goto L28;
        IAIKernelManager r3 = AIKernelManager.INSTANCE.invoke();
        String r12 = this.bizName;
        RequestParams r4 = this.params;
        r5.L$0 = this;
        r5.label = 1;
        r10 = IAIKernelManager.DefaultImpls.loadPackage$default(r3, r12, false, r4, r5, 2, null);
        if (r10 != r1) goto L21;
        return r1;
    L28:
        return this.remote;
    L7:
        r0 = new AnonymousClass1(this, r9);
        goto L8
    }

    @Override // com.obric.aikernel.phx.sdk.api.IBaseModel
    public Object infer(RequestParams r5, Continuation<? super Response<Object>> r6) {
        return AIKernelManager.INSTANCE.getInstance$sdk_release().wrapApiCall(r5, this.remote, new AnonymousClass2(this, r5, null), r6);
    }

    @Override // com.obric.aikernel.phx.sdk.api.IBaseModel
    public Object inferAsFlow(RequestParams r5, Continuation<? super Flow<Response<Object>>> r6) {
        return AIKernelManager.INSTANCE.getInstance$sdk_release().wrapApiCall(r5, this.remote, new C01742(this, r5, null), r6);
    }

    private final Object inferenceTo(RequestParams r19, Continuation<? super Response<Object>> r20) {
        ScriptBizApi r0 = this;
        if ((r20 instanceof C01761) == false) goto L7;
        C01761 r2 = (C01761) r20;
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r2.label;
        if (r4 == 0) goto L18;
        if (r4 == 1) goto L17;
        if (r4 == 2) goto L16;
        if (r4 != 3) goto L15;
        ResultKt.throwOnFailure(r1);
    L32:
        return r1;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        AIKBinder r5 = (AIKBinder) r2.L$3;
        ScriptBizApi r6 = (ScriptBizApi) r2.L$2;
        RequestParams r7 = (RequestParams) r2.L$1;
        ScriptBizApi r8 = (ScriptBizApi) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L29:
        BundleExtKt.setBizCall(r7.getBackend(), r8.bizName, TAG, "inferenceTo");
        Unit r9 = Unit.INSTANCE;
        AnonymousClass3 r10 = AnonymousClass3.INSTANCE;
        r2.L$0 = null;
        r2.L$1 = null;
        r2.L$2 = null;
        r2.L$3 = null;
        r2.label = 3;
        r1 = r6.callModelAsResponse(r5, (Bundle) r1, r10, r2);
        if (r1 != r3) goto L32;
        return r3;
    L17:
        RequestParams r11 = (RequestParams) r2.L$1;
        ScriptBizApi r12 = (ScriptBizApi) r2.L$0;
        ResultKt.throwOnFailure(r1);
        RequestParams r13 = r11;
        r0 = r12;
        Object r14 = r1;
    L21:
        AIKBinder r15 = (AIKBinder) r14;
        if (r15 == null) goto L24;
        ParamsCompat r16 = ParamsCompat.INSTANCE;
        r2.L$0 = r0;
        r2.L$1 = r13;
        r2.L$2 = r0;
        r2.L$3 = r15;
        r2.label = 2;
        Object r17 = r16.startCompat(r13, r2);
        if (r17 != r3) goto L28;
        return r3;
    L28:
        r8 = r0;
        r5 = r15;
        r6 = r8;
        r7 = r13;
        r1 = r17;
        goto L29
    L24:
        return new Response(102, null, null, false, false, null, null, 126, null);
    L18:
        ResultKt.throwOnFailure(r1);
        r2.L$0 = r0;
        r13 = r19;
        r2.L$1 = r13;
        r2.label = 1;
        r14 = r0.getBinder(r2);
        if (r14 != r3) goto L21;
        return r3;
    L7:
        r2 = new C01761(r0, r20);
        goto L8
    }

    static /* synthetic */ Object inferenceTo$default(ScriptBizApi r0, RequestParams r1, Continuation r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = new RequestParams(null, null, 3, null);
    L6:
        return r0.inferenceTo(r1, r2);
    }

    private final Object inferenceAsFlow(RequestParams r8, Continuation<? super Flow<Response<Object>>> r9) {
        if ((r9 instanceof C01751) == false) goto L7;
        C01751 r0 = (C01751) r9;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        AIKBinder r7 = (AIKBinder) r0.L$3;
        ScriptBizApi r11 = (ScriptBizApi) r0.L$2;
        RequestParams r3 = (RequestParams) r0.L$1;
        ScriptBizApi r4 = (ScriptBizApi) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L27:
        BundleExtKt.setBizCall(r3.getBackend(), r4.bizName, TAG, "inferenceAsFlow").putBoolean(IdlKeys.Args_StreamingCall, true);
        Unit r5 = Unit.INSTANCE;
        final Flow<Bundle> r12 = r11.callModelAsFlow(r7, (Bundle) r10);
        return new ScriptBizApi$inferenceAsFlow$$inlined$map$1(r12);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r8 = (RequestParams) r0.L$1;
        ScriptBizApi this = (ScriptBizApi) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L19:
        AIKBinder r13 = (AIKBinder) r10;
        if (r13 == null) goto L22;
        ParamsCompat r6 = ParamsCompat.INSTANCE;
        r0.L$0 = this;
        r0.L$1 = r8;
        r0.L$2 = this;
        r0.L$3 = r13;
        r0.label = 2;
        Object r14 = r6.startCompat(r8, r0);
        if (r14 != r1) goto L26;
        return r1;
    L26:
        r3 = r8;
        r11 = this;
        r7 = r13;
        r10 = r14;
        r4 = r11;
        goto L27
    L22:
        return FlowKt.flow(new ScriptBizApi$inferenceAsFlow$binder$1(null));
    L16:
        ResultKt.throwOnFailure(r10);
        AIKLog.INSTANCE.i(TAG, "call inferenceAsFlow " + this.bizName);
        r0.L$0 = this;
        r0.L$1 = r8;
        r0.label = 1;
        r10 = getBinder(r0);
        if (r10 != r1) goto L19;
        return r1;
    L7:
        r0 = new C01751(this, r9);
        goto L8
    }

    static /* synthetic */ Object inferenceAsFlow$default(ScriptBizApi r0, RequestParams r1, Continuation r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = new RequestParams(null, null, 3, null);
    L6:
        return r0.inferenceAsFlow(r1, r2);
    }

    @Override // com.obric.aikernel.phx.core.api.AbsApi, com.obric.aikernel.phx.sdk.api.IBaseModel, java.lang.AutoCloseable
    public void close() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        BuildersKt.runBlocking$default(null, new ScriptBizApi$close$1$1(this, null), 1, null);     // Catch: Throwable -> L4
        Result.m1508constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.m1508constructorimpl(ResultKt.createFailure(th));
    }
}
