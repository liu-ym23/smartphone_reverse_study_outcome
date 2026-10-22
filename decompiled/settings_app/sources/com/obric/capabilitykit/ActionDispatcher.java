package com.obric.capabilitykit;

import androidx.core.app.NotificationCompat;
import com.bytedance.apm.alog.AlogMonitor;
import com.google.gson.Gson;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.BaseResult;
import com.obric.capabilitykit.common.BaseResultExt;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.FeedbackResult;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.IMAppActionExt;
import com.obric.capabilitykit.common.UtilsKt;
import com.obric.capabilitykit.common.execution.IntentCalling;
import com.obric.capabilitykit.logger.Logger;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004J3\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u001bJ?\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00062'\u0010\u001f\u001a#\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0!\u0012\u0006\u0012\u0004\u0018\u00010\u00010 ¢\u0006\u0002\b\"ø\u0001\u0000¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\u0019\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0012H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010(R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lcom/obric/capabilitykit/ActionDispatcher;", "", "()V", "TAG", "", "<set-?>", "", "dispatchStartedQuestion", "getDispatchStartedQuestion", "()Ljava/lang/Long;", "Ljava/lang/Long;", "parallelScope", "Lkotlinx/coroutines/CoroutineScope;", "getParallelScope", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "getScope", "getAppActionFailResult", "Lcom/obric/capabilitykit/common/IMAppAction;", Ext.KEY_REQUEST, AlogMonitor.ALOG_RESULT_CODE, "", NotificationCompat.CATEGORY_MESSAGE, "getIntentFailResult", "intentCalling", "Lcom/obric/capabilitykit/common/execution/IntentCalling;", "duration", "(Lcom/obric/capabilitykit/common/execution/IntentCalling;ILjava/lang/String;Ljava/lang/Long;)Lcom/obric/capabilitykit/common/IMAppAction;", "launchWithTrace", "", "questionId", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(JLkotlin/jvm/functions/Function2;)V", "markDispatchEnded", "markDispatchStarted", "onActionReceived", "action", "(Lcom/obric/capabilitykit/common/IMAppAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ActionDispatcher {
    public static final ActionDispatcher INSTANCE = null;
    private static final String TAG = "ActionDispatcher";
    private static Long dispatchStartedQuestion;
    private static final CoroutineScope parallelScope = null;
    private static final CoroutineScope scope = null;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.ActionDispatcher$launchWithTrace$1", f = "ActionDispatcher.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        private /* synthetic */ Object b;
        public final /* synthetic */ long c;
        public final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(long r1, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r3, Continuation<? super a> r4) {
            this.c = r1;
            this.d = r3;
            super(2, r4);
        }

        public final Object a(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((a) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            a r0 = new a(this.c, this.d, r5);
            r0.b = r4;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return a(r1, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            ActionDispatcher.access$markDispatchEnded(ActionDispatcher.INSTANCE, this.c);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            CoroutineScope r7 = (CoroutineScope) this.b;
            ActionDispatcher.access$markDispatchStarted(ActionDispatcher.INSTANCE, this.c);
            Function2<CoroutineScope, Continuation<? super Unit>, Object> r2 = this.d;
            this.a = 1;
            if (r2.invoke(r7, this) != r0) goto L11;
            return r0;
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.ActionDispatcher", f = "ActionDispatcher.kt", i = {0, 0}, l = {58}, m = "onActionReceived", n = {"action", "start"}, s = {"L$0", "J$0"})
    public static final class b extends ContinuationImpl {
        public Object a;
        public long b;
        public /* synthetic */ Object c;
        public final /* synthetic */ ActionDispatcher d;
        public int e;

        public b(ActionDispatcher r1, Continuation<? super b> r2) {
            this.d = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.c = r2;
            this.e |= Integer.MIN_VALUE;
            return this.d.onActionReceived(null, this);
        }
    }

    public static /* synthetic */ Thread $r8$lambda$FQPYtXqtKDxYM7JfWjJo1lWPFzo(Runnable r0) {
        return parallelScope$lambda$1(r0);
    }

    public static /* synthetic */ Thread $r8$lambda$aywdmJbp20ZmM29BzRWOXx9Uxvo(Runnable r0) {
        return scope$lambda$0(r0);
    }

    static {
        INSTANCE = new ActionDispatcher();
        ExecutorService r0 = Executors.newSingleThreadExecutor(new ActionDispatcher$$ExternalSyntheticLambda0());
        Intrinsics.checkNotNullExpressionValue(r0, "newSingleThreadExecutor …action-dispatcher\")\n    }");
        scope = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(r0));
        ExecutorService r1 = Executors.newCachedThreadPool(new ActionDispatcher$$ExternalSyntheticLambda1());
        Intrinsics.checkNotNullExpressionValue(r1, "newCachedThreadPool {\n  …spatcher-parallel\")\n    }");
        parallelScope = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(r1));
    }

    private ActionDispatcher() {
    }

    public static final /* synthetic */ void access$markDispatchEnded(ActionDispatcher r0, long r1) {
        r0.markDispatchEnded(r1);
    }

    public static final /* synthetic */ void access$markDispatchStarted(ActionDispatcher r0, long r1) {
        r0.markDispatchStarted(r1);
    }

    public static /* synthetic */ IMAppAction getAppActionFailResult$default(ActionDispatcher r0, IMAppAction r1, int r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return r0.getAppActionFailResult(r1, r2, r3);
    }

    public static /* synthetic */ IMAppAction getIntentFailResult$default(ActionDispatcher r1, IntentCalling r2, int r3, String r4, Long r5, int r6, Object r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L9;
        r5 = null;
    L9:
        return r1.getIntentFailResult(r2, r3, r4, r5);
    }

    private final void markDispatchEnded(long r3) {
        Logger.INSTANCE.d(TAG, "** ActionDispatcher [ended qId=" + r3 + ']');
        dispatchStartedQuestion = null;
    }

    private final void markDispatchStarted(long r3) {
        Logger.INSTANCE.d(TAG, "** ActionDispatcher [started qId=" + r3 + ']');
        dispatchStartedQuestion = Long.valueOf(r3);
    }

    private static final Thread parallelScope$lambda$1(Runnable r2) {
        return new Thread(r2, "action-dispatcher-parallel");
    }

    private static final Thread scope$lambda$0(Runnable r2) {
        return new Thread(r2, "action-dispatcher");
    }

    public final IMAppAction getAppActionFailResult(IMAppAction r32, int r33, String r34) {
        Intrinsics.checkNotNullParameter(r32, Ext.KEY_REQUEST);
        Gson r0 = UtilsKt.getGson();
        if (r34 != null) goto L5;
        String r4 = "failed";
    L6:
        String r21 = r0.toJson(new FeedbackResult(r33, r4, null, 1, String.valueOf(r32.getReplyId()), false, 36, null));
        String r16 = UUID.randomUUID().toString();
        long r17 = r32.getReplyId();
        Long r19 = r32.getQuestionId();
        return new IMAppAction(0, r32.getMessageId(), r16, r17, r19, null, r21, null, r32.getActionId(), r32.getJobId(), 0, null, 3233, null);
    L5:
        r4 = r34;
        goto L6
    }

    public final Long getDispatchStartedQuestion() {
        return dispatchStartedQuestion;
    }

    public final IMAppAction getIntentFailResult(IntentCalling r32, int r33, String r34, Long r35) {
        Intrinsics.checkNotNullParameter(r32, "intentCalling");
        Gson r0 = UtilsKt.getGson();
        if (r34 != null) goto L5;
        String r4 = "failed";
    L6:
        String r21 = r0.toJson(new FeedbackResult(r33, r4, null, 1, String.valueOf(r32.getReplyFor()), false, 36, null));
        String r16 = UUID.randomUUID().toString();
        long r17 = r32.getReplyFor();
        long r2 = r32.getQuestionId();
        long r5 = r32.getMessageId();
        long r23 = r32.getActionId();
        long r25 = r32.getJobId();
        if (r35 == null) goto L9;
        long r1 = r35.longValue();
        IMAppActionExt r6 = new IMAppActionExt();
        r6.put("app_cost", String.valueOf(r1));
        IMAppActionExt r28 = r6;
    L11:
        return new IMAppAction(0, Long.valueOf(r5), r16, r17, Long.valueOf(r2), null, r21, null, r23, r25, 0, r28, 1185, null);
    L9:
        r28 = null;
        goto L11
    L5:
        r4 = r34;
        goto L6
    }

    public final CoroutineScope getParallelScope() {
        return parallelScope;
    }

    public final CoroutineScope getScope() {
        return scope;
    }

    public final void launchWithTrace(long r7, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r9) {
        Intrinsics.checkNotNullParameter(r9, "block");
        BuildersKt.launch$default(scope, null, null, new a(r7, r9, null), 3, null);
    }

    public final Object onActionReceived(IMAppAction r36, Continuation<? super IMAppAction> r37) {
        IMAppAction r0 = r36;
        if ((r37 instanceof b) == false) goto L7;
        b r2 = (b) r37;
        int r3 = r2.e;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.e = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.c;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.e;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        long r6 = r2.b;
        r0 = (IMAppAction) r2.a;
        ResultKt.throwOnFailure(r1);
    L18:
        BaseResult r7 = (BaseResult) r1;
        long r8 = System.currentTimeMillis() - r6;
        Gson r9 = new Gson();
        AppHost.Companion r10 = AppHost.Companion;
        String r11 = r10.getApplication().getString(R.string.obric_action_success);
        Intrinsics.checkNotNullExpressionValue(r11, "AppHost.application.getS…ing.obric_action_success)");
        String r12 = r10.getApplication().getString(R.string.obric_action_failed);
        Intrinsics.checkNotNullExpressionValue(r12, "AppHost.application.getS…ring.obric_action_failed)");
        if (r7.getRet() != 0) goto L25;
        String r13 = r7.getDetails();
        if (r13 == null) goto L24;
        r11 = r13;
    L24:
        r7.setDetails(r11);
    L25:
        int r14 = r7.getRet();
        String r15 = r7.getDetails();
        if (r15 != null) goto L28;
        String r16 = r12;
    L29:
        String r25 = r9.toJson(new FeedbackResult(r14, r16, null, r7.getUiType(), r7.getReplyFor(), false, 36, null));
        long r17 = 0;
        if ((r7.getUiType() & 32) == 0) goto L32;
    L75:
        String r20 = UUID.randomUUID().toString();
        Long r18 = r7.getReplyId();
        if (r18 == null) goto L78;
        r17 = r18.longValue();
    L78:
        long r21 = r17;
        Long r23 = r7.getQuestionId();
        Long r19 = r0.getMessageId();
        long r27 = r0.getActionId();
        long r29 = r0.getJobId();
        IMAppActionExt r22 = new IMAppActionExt();
        ConcurrentHashMap<String, String> r24 = r7.getExt();
        String r26 = null;
        if ((r24 instanceof BaseResultExt) == false) goto L81;
        BaseResultExt r28 = (BaseResultExt) r24;
    L82:
        if (r28 == null) goto L84;
        r26 = r28.getResultDetailExtras();
    L84:
        r22.setActionDetailExtras(r26);
        r22.put("app_cost", String.valueOf(r8));
        ConcurrentHashMap<String, String> r30 = r7.getExt();
        if (r30 == null) goto L88;
        r22.putAll(r30);
    L88:
        return new IMAppAction(0, r19, r20, r21, r23, null, r25, null, r27, r29, 0, r22, 1185, null);
    L81:
        r28 = null;
        goto L82
    L32:
        if ((r7.getUiType() & 64) != 0) goto L75;
        if ((r7.getUiType() & 128) != 0) goto L75;
        if ((r7.getUiType() & 512) != 0) goto L75;
        if ((r7.getUiType() & 1024) != 0) goto L75;
        if ((r7.getUiType() & 2048) != 0) goto L75;
        if ((r7.getUiType() & 4096) != 0) goto L75;
        if ((r7.getUiType() & 8192) != 0) goto L75;
        if ((r7.getUiType() & 16384) != 0) goto L75;
        if ((r7.getUiType() & 32768) != 0) goto L75;
        if ((r7.getUiType() & 524288) != 0) goto L75;
        if ((r7.getUiType() & 65536) != 0) goto L75;
        if ((r7.getUiType() & 131072) != 0) goto L75;
        if ((r7.getUiType() & 1048576) != 0) goto L75;
        if ((r7.getUiType() & 262144) != 0) goto L75;
        if ((r7.getUiType() & 2097152) != 0) goto L75;
        if ((r7.getUiType() & 8388608) != 0) goto L75;
        String r210 = UUID.randomUUID().toString();
        Long r31 = r7.getReplyId();
        if (r31 == null) goto L67;
        r17 = r31.longValue();
    L67:
        long r211 = r17;
        Long r212 = r7.getQuestionId();
        Long r110 = r0.getMessageId();
        long r213 = r0.getActionId();
        long r214 = r0.getJobId();
        IMAppActionExt r32 = r0.getExt();
        if (r32 != null) goto L70;
        r32 = new IMAppActionExt();
    L70:
        r32.put("app_cost", String.valueOf(r8));
        ConcurrentHashMap<String, String> r33 = r7.getExt();
        if (r33 == null) goto L74;
        r32.putAll(r33);
    L74:
        return new IMAppAction(0, r110, r210, r211, r212, null, r25, null, r213, r214, 0, r32, 1185, null);
    L28:
        r16 = r15;
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        long r34 = System.currentTimeMillis();
        com.obric.capabilitykit.b r35 = com.obric.capabilitykit.b.a;
        r2.a = r0;
        r2.b = r34;
        r2.e = 1;
        r1 = r35.a(r0, r2);
        if (r1 != r4) goto L17;
        return r4;
    L17:
        r6 = r34;
    L7:
        r2 = new b(this, r37);
        goto L8
    }
}
