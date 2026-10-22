package h.a;

import com.bytedance.common.wschannel.WsConstants;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\t\u0012\u0004\u0012\u00028\u00000\u008a\u00012\t\u0012\u0004\u0012\u00028\u00000\u008b\u00012\u00060tj\u0002`uB\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0012\u0010\u0013JB\u0010\u0012\u001a\u00020\u00112'\u0010\u000e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u0014j\u0002`\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0018J\u001e\u0010\u001b\u001a\u00020\u00112\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u0019H\u0082\b¢\u0006\u0004\b\u001b\u0010\u001cJ8\u0010\u001e\u001a\u00020\u00112!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u00142\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u001e\u0010\u0018J\u0019\u0010 \u001a\u00020\u001f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b \u0010!J!\u0010%\u001a\u00020\u00112\b\u0010\"\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0010¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b&\u0010!J\u0017\u0010(\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\bH\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010,\u001a\u00020\u0011H\u0000¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020\u0011H\u0002¢\u0006\u0004\b-\u0010+J\u0017\u0010/\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u0004H\u0002¢\u0006\u0004\b/\u00100J\u0017\u00103\u001a\u00020\u000f2\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b3\u00104J\u001b\u00108\u001a\u0004\u0018\u00010\u000f2\b\u00105\u001a\u0004\u0018\u00010\bH\u0010¢\u0006\u0004\b6\u00107J\u0011\u00109\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0004\b9\u0010:J\u0017\u0010=\u001a\n\u0018\u00010;j\u0004\u0018\u0001`<H\u0016¢\u0006\u0004\b=\u0010>J\u001f\u0010A\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u00105\u001a\u0004\u0018\u00010\bH\u0010¢\u0006\u0004\b?\u0010@J\u000f\u0010B\u001a\u00020\u0011H\u0016¢\u0006\u0004\bB\u0010+J\u0011\u0010D\u001a\u0004\u0018\u00010CH\u0002¢\u0006\u0004\bD\u0010EJ8\u0010F\u001a\u00020\u00112'\u0010\u000e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u0014j\u0002`\u0017H\u0016¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\u001fH\u0002¢\u0006\u0004\bH\u0010IJ8\u0010J\u001a\u00020\r2'\u0010\u000e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u0014j\u0002`\u0017H\u0002¢\u0006\u0004\bJ\u0010KJB\u0010L\u001a\u00020\u00112'\u0010\u000e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u0014j\u0002`\u00172\b\u00105\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\bL\u0010MJ\u000f\u0010O\u001a\u00020NH\u0014¢\u0006\u0004\bO\u0010PJ\u0017\u0010S\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\bQ\u0010RJ\u000f\u0010T\u001a\u00020\u0011H\u0002¢\u0006\u0004\bT\u0010+J\u000f\u0010U\u001a\u00020\u001fH\u0001¢\u0006\u0004\bU\u0010IJ<\u0010W\u001a\u00020\u00112\u0006\u0010V\u001a\u00028\u00002#\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014H\u0016¢\u0006\u0004\bW\u0010XJH\u0010Y\u001a\u00020\u00112\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042%\b\u0002\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014H\u0002¢\u0006\u0004\bY\u0010ZJ \u0010]\u001a\u00020\u00112\f\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000[H\u0016ø\u0001\u0000¢\u0006\u0004\b]\u0010)JZ\u0010`\u001a\u0004\u0018\u00010\b2\u0006\u00105\u001a\u00020^2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042#\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00142\b\u0010_\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b`\u0010aJ\u0011\u0010c\u001a\u0004\u0018\u00010\bH\u0010¢\u0006\u0004\bb\u0010:J\u000f\u0010d\u001a\u00020NH\u0016¢\u0006\u0004\bd\u0010PJ\u000f\u0010e\u001a\u00020\u001fH\u0002¢\u0006\u0004\be\u0010IJ#\u0010e\u001a\u0004\u0018\u00010\b2\u0006\u0010V\u001a\u00028\u00002\b\u0010_\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\be\u0010fJH\u0010e\u001a\u0004\u0018\u00010\b2\u0006\u0010V\u001a\u00028\u00002\b\u0010_\u001a\u0004\u0018\u00010\b2#\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014H\u0016¢\u0006\u0004\be\u0010gJJ\u0010i\u001a\u0004\u0018\u00010h2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010_\u001a\u0004\u0018\u00010\b2#\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014H\u0002¢\u0006\u0004\bi\u0010jJ\u0019\u0010l\u001a\u0004\u0018\u00010\b2\u0006\u0010k\u001a\u00020\u000fH\u0016¢\u0006\u0004\bl\u0010mJ\u000f\u0010n\u001a\u00020\u001fH\u0002¢\u0006\u0004\bn\u0010IJ\u001b\u0010p\u001a\u00020\u0011*\u00020o2\u0006\u0010V\u001a\u00028\u0000H\u0016¢\u0006\u0004\bp\u0010qJ\u001b\u0010r\u001a\u00020\u0011*\u00020o2\u0006\u0010k\u001a\u00020\u000fH\u0016¢\u0006\u0004\br\u0010sR\u001c\u0010x\u001a\n\u0018\u00010tj\u0004\u0018\u0001`u8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bv\u0010wR\u001a\u0010z\u001a\u00020y8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0000X\u0080\u0004¢\u0006\r\n\u0004\b\u0003\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001R\u0016\u0010\u0081\u0001\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0081\u0001\u0010IR\u0016\u0010\u0082\u0001\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010IR\u0016\u0010\u0083\u0001\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0083\u0001\u0010IR\u001b\u0010\u0084\u0001\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0017\u00105\u001a\u0004\u0018\u00010\b8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u0086\u0001\u0010:R\u0016\u0010\u0088\u0001\u001a\u00020N8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0087\u0001\u0010P\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0089\u0001"}, d2 = {"Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "Lkotlin/coroutines/Continuation;", "delegate", "", "resumeMode", "<init>", "(Lkotlin/coroutines/Continuation;I)V", "", "proposedUpdate", "", "alreadyResumedError", "(Ljava/lang/Object;)Ljava/lang/Void;", "Lkotlinx/coroutines/CancelHandler;", "handler", "", "cause", "", "callCancelHandler", "(Lkotlinx/coroutines/CancelHandler;Ljava/lang/Throwable;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Throwable;)V", "Lkotlin/Function0;", "block", "callCancelHandlerSafely", "(Lkotlin/jvm/functions/Function0;)V", "onCancellation", "callOnCancellation", "", "cancel", "(Ljava/lang/Throwable;)Z", "takenState", "cancelCompletedResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelCompletedResult", "cancelLater", "token", "completeResume", "(Ljava/lang/Object;)V", "detachChild$kotlinx_coroutines_core", "()V", "detachChild", "detachChildIfNonResuable", "mode", "dispatchResume", "(I)V", "Lkotlinx/coroutines/Job;", "parent", "getContinuationCancellationCause", "(Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", WsConstants.KEY_CONNECTION_STATE, "getExceptionalResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getExceptionalResult", "getResult", "()Ljava/lang/Object;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "getSuccessfulResult", "initCancellability", "Lkotlinx/coroutines/DisposableHandle;", "installParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "invokeOnCancellation", "(Lkotlin/jvm/functions/Function1;)V", "isReusable", "()Z", "makeCancelHandler", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/CancelHandler;", "multipleHandlersError", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V", "", "nameString", "()Ljava/lang/String;", "parentCancelled$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)V", "parentCancelled", "releaseClaimedReusableContinuation", "resetStateReusable", "value", "resume", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "resumeImpl", "(Ljava/lang/Object;ILkotlin/jvm/functions/Function1;)V", "Lkotlin/Result;", "result", "resumeWith", "Lkotlinx/coroutines/NotCompleted;", "idempotent", "resumedState", "(Lkotlinx/coroutines/NotCompleted;Ljava/lang/Object;ILkotlin/jvm/functions/Function1;Ljava/lang/Object;)Ljava/lang/Object;", "takeState$kotlinx_coroutines_core", "takeState", "toString", "tryResume", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/Symbol;", "tryResumeImpl", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/Symbol;", "exception", "tryResumeWithException", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "trySuspend", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "isActive", "isCancelled", "isCompleted", "parentHandle", "Lkotlinx/coroutines/DisposableHandle;", "getState$kotlinx_coroutines_core", "getStateDebugRepresentation", "stateDebugRepresentation", "kotlinx-coroutines-core", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class o<T> extends y0<T> implements n<T>, kotlin.k0.j.a.e {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f17541l = null;
    private static final /* synthetic */ AtomicReferenceFieldUpdater m = null;
    private volatile /* synthetic */ int _decision;
    private volatile /* synthetic */ Object _state;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final kotlin.k0.d<T> f17542i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final kotlin.k0.g f17543j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private d1 f17544k;

    static {
        f17541l = AtomicIntegerFieldUpdater.newUpdater(o.class, "_decision");
        m = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_state");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(kotlin.k0.d<? super T> r3, int r4) {
        super(r4);
        this.f17542i = r3;
        if (q0.a() == true) goto L5;
    L12:
        this.f17543j = r3.getContext();
        this._decision = 0;
        this._state = d.f17188f;
        return;
    L5:
        if (r4 == (-1)) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == true) goto L12;
        throw new AssertionError();
    L7:
        r5 = false;
        goto L8
    }

    private final d1 B() {
        x1 r1 = (x1) getContext().get(x1.f17584d);
        if (r1 != null) goto L6;
        return null;
    L6:
        d1 r0 = x1.a.d(r1, true, false, new s(this), 2, null);
        this.f17544k = r0;
        return r0;
    }

    private final boolean D() {
        if (z0.c(this.f17589h) == true) goto L5;
    L7:
        return false;
    L5:
        if (((h.a.f3.i) this.f17542i).r() == false) goto L7;
        return true;
    }

    private final l G(kotlin.n0.c.l<? super Throwable, kotlin.f0> r1) {
        if ((r1 instanceof l) == false) goto L6;
        return (l) r1;
    L6:
        return new u1(r1);
    }

    private final void H(kotlin.n0.c.l<? super Throwable, kotlin.f0> r3, Object r4) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + r3 + ", already has " + r4).toString());
    }

    private final void K() {
        kotlin.k0.d<T> r0 = this.f17542i;
        Throwable r2 = null;
        if ((r0 instanceof h.a.f3.i) == false) goto L5;
        h.a.f3.i r1 = (h.a.f3.i) r0;
    L6:
        if (r1 == null) goto L9;
        r2 = r1.u(this);
    L9:
        if (r2 != null) goto L11;
        return;
    L11:
        t();
        o(r2);
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void M(Object r9, int r10, kotlin.n0.c.l<? super Throwable, kotlin.f0> r11) {
    L2:
        Object r0 = this._state;
        if ((r0 instanceof l2) == false) goto L10;
        Object r1 = P((l2) r0, r9, r10, r11, null);
        if (m.compareAndSet(this, r0, r1) == false) goto L2;
        u();
        v(r10);
        return;
    L10:
        if ((r0 instanceof r) == false) goto L17;
        r r2 = (r) r0;
        if (r2.c() == false) goto L17;
        if (r11 == null) goto L22;
        r(r11, r2.f17588a);
        return;
    L22:
        return;
    L17:
        i(r9);
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void N(o r0, Object r1, int r2, kotlin.n0.c.l r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        r0.M(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    private final Object P(l2 r9, Object r10, int r11, kotlin.n0.c.l<? super Throwable, kotlin.f0> r12, Object r13) {
        if ((r10 instanceof y) == false) goto L23;
        boolean r14 = true;
        if (q0.a() == false) goto L14;
        if (r13 != null) goto L8;
        boolean r8 = true;
    L9:
        if (r8 == true) goto L14;
        throw new AssertionError();
    L8:
        r8 = false;
    L14:
        if (q0.a() == false) goto L38;
        if (r12 == null) goto L18;
        r14 = false;
    L18:
        if (r14 == false) goto L21;
        return r10;
    L21:
        throw new AssertionError();
    L38:
        return r10;
    L23:
        if (z0.b(r11) == true) goto L26;
        if (r13 != null) goto L26;
        return r10;
    L26:
        if (r12 != null) goto L33;
        if ((r9 instanceof l) == true) goto L30;
    L31:
        if (r13 != null) goto L33;
        return r10;
    L30:
        if ((r9 instanceof e) == true) goto L31;
    L33:
        if ((r9 instanceof l) == false) goto L35;
        l r15 = (l) r9;
    L37:
        return new x(r10, r15, r12, r13, null, 16, null);
    L35:
        r15 = null;
        goto L37
    }

    private final boolean Q() {
    L2:
        int r0 = this._decision;
        if (r0 != 0) goto L4;
        if (f17541l.compareAndSet(this, 0, 2) == false) goto L2;
        return true;
    L4:
        if (r0 != 1) goto L7;
        return false;
    L7:
        throw new IllegalStateException("Already resumed".toString());
    }

    private final h.a.f3.f0 R(Object r9, Object r10, kotlin.n0.c.l<? super Throwable, kotlin.f0> r11) {
    L2:
        Object r0 = this._state;
        if ((r0 instanceof l2) == false) goto L10;
        Object r1 = P((l2) r0, r9, this.f17589h, r11, r10);
        if (m.compareAndSet(this, r0, r1) == false) goto L2;
        u();
        return p.f17553a;
    L10:
        if ((r0 instanceof x) == false) goto L26;
        if (r10 == null) goto L27;
        x r2 = (x) r0;
        if (r2.f17581d == r10) goto L15;
        return null;
    L15:
        if (q0.a() == false) goto L22;
        if (kotlin.n0.d.o.a(r2.f17578a, r9) == true) goto L22;
        throw new AssertionError();
    L22:
        return p.f17553a;
    L27:
        return null;
    L26:
        return null;
    }

    private final boolean T() {
    L2:
        int r0 = this._decision;
        if (r0 != 0) goto L5;
        if (f17541l.compareAndSet(this, 0, 1) == false) goto L2;
        return true;
    L5:
        if (r0 != 2) goto L8;
        return false;
    L8:
        throw new IllegalStateException("Already suspended".toString());
    }

    private final Void i(Object r2) {
        throw new IllegalStateException(kotlin.n0.d.o.m("Already resumed, but proposed with update ", r2).toString());
    }

    private final void k(kotlin.n0.c.l<? super Throwable, kotlin.f0> r3, Throwable r4) {
        r3.invoke(r4);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        j0.a(getContext(), new b0(kotlin.n0.d.o.m("Exception in invokeOnCancellation handler for ", this), th));
    }

    private final boolean s(Throwable r2) {
        if (D() == true) goto L7;
        return false;
    L7:
        return ((h.a.f3.i) this.f17542i).s(r2);
    }

    private final void u() {
        if (D() == true) goto L6;
        t();
        return;
    }

    private final void v(int r2) {
        if (Q() == false) goto L5;
        return;
    L5:
        z0.a(this, r2);
    }

    private final String z() {
        Object r1 = y();
        if ((r1 instanceof l2) == false) goto L6;
        return "Active";
    L6:
        if ((r1 instanceof r) == false) goto L8;
        return "Cancelled";
    L8:
        return "Completed";
    }

    public void A() {
        d1 r0 = B();
        if (r0 != null) goto L6;
        return;
    L6:
        if (C() == false) goto L9;
        r0.dispose();
        this.f17544k = k2.f17534f;
        return;
    }

    public boolean C() {
        return !(y() instanceof l2);
    }

    protected String I() {
        return "CancellableContinuation";
    }

    public final void J(Throwable r2) {
        if (s(r2) == false) goto L5;
        return;
    L5:
        o(r2);
        u();
    }

    public final boolean L() {
        if (q0.a() == false) goto L13;
        if (this.f17589h != 2) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L13;
        throw new AssertionError();
    L7:
        r0 = false;
    L13:
        if (q0.a() == true) goto L15;
    L22:
        Object r1 = this._state;
        if (q0.a() == false) goto L30;
        if ((!(r1 instanceof l2)) == true) goto L30;
        throw new AssertionError();
    L30:
        if ((r1 instanceof x) == true) goto L32;
    L35:
        this._decision = 0;
        this._state = d.f17188f;
        return true;
    L32:
        if (((x) r1).f17581d == null) goto L35;
        t();
        return false;
    L15:
        if (this.f17544k == k2.f17534f) goto L17;
        boolean r2 = true;
    L18:
        if (r2 == true) goto L22;
        throw new AssertionError();
    L17:
        r2 = false;
        goto L18
    }

    @Override // h.a.y0
    public void a(Object r11, Throwable r12) {
    L2:
        Object r13 = this._state;
        if ((r13 instanceof l2) == true) goto L21;
        if ((r13 instanceof y) == true) goto L6;
        if ((r13 instanceof x) == true) goto L9;
        if (m.compareAndSet(this, r13, new x(r13, null, null, null, r12, 14, null)) == false) goto L2;
        return;
    L9:
        x r0 = (x) r13;
        if ((!r0.c()) == false) goto L16;
        if (m.compareAndSet(this, r13, x.b(r0, null, null, null, null, r12, 15, null)) == false) goto L2;
        r0.d(this, r12);
        return;
    L16:
        throw new IllegalStateException("Must be called at most once".toString());
    L6:
        return;
    L21:
        throw new IllegalStateException("Not completed".toString());
    }

    @Override // h.a.y0
    public final kotlin.k0.d<T> b() {
        return this.f17542i;
    }

    @Override // h.a.n
    public Object c(T r2, Object r3) {
        return R(r2, r3, null);
    }

    @Override // h.a.y0
    public Throwable d(Object r2) {
        Throwable r3 = super.d(r2);
        if (r3 != null) goto L5;
        return null;
    L5:
        kotlin.k0.d<T> r1 = b();
        if (q0.d() == false) goto L12;
        if ((r1 instanceof kotlin.k0.j.a.e) == false) goto L12;
        r3 = h.a.f3.e0.a(r3, (kotlin.k0.j.a.e) r1);
    L12:
        return r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h.a.y0
    public <T> T e(Object r1) {
        if ((r1 instanceof x) == true) goto L5;
        return r1;
    L5:
        return (T) ((x) r1).f17578a;
    }

    @Override // h.a.y0
    public Object g() {
        return y();
    }

    @Override // kotlin.k0.j.a.e
    public kotlin.k0.j.a.e getCallerFrame() {
        kotlin.k0.d<T> r1 = this.f17542i;
        if ((r1 instanceof kotlin.k0.j.a.e) == true) goto L7;
        return null;
    L7:
        return (kotlin.k0.j.a.e) r1;
    }

    @Override // kotlin.k0.d
    public kotlin.k0.g getContext() {
        return this.f17543j;
    }

    @Override // kotlin.k0.j.a.e
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // h.a.n
    public void h(kotlin.n0.c.l<? super Throwable, kotlin.f0> r12) {
        l r8 = G(r12);
    L3:
        Object r9 = this._state;
        if ((r9 instanceof d) == true) goto L6;
        Throwable r1 = null;
        if ((r9 instanceof l) == true) goto L48;
        boolean r0 = r9 instanceof y;
        if (r0 == true) goto L12;
        if ((r9 instanceof x) == true) goto L28;
        if ((r8 instanceof e) == true) goto L44;
        if (m.compareAndSet(this, r9, new x(r9, r8, null, null, null, 28, null)) == false) goto L3;
        return;
    L44:
        return;
    L28:
        x r2 = (x) r9;
        if (r2.f17579b != null) goto L40;
        if ((r8 instanceof e) == true) goto L32;
        if (r2.c() == true) goto L35;
        if (m.compareAndSet(this, r9, x.b(r2, null, r8, null, null, null, 29, null)) == false) goto L3;
        return;
    L35:
        k(r12, r2.f17582e);
        return;
    L32:
        return;
    L40:
        H(r12, r9);
        throw null;
    L12:
        y r3 = (y) r9;
        if (r3.b() == true) goto L15;
        H(r12, r9);
        throw null;
    L15:
        if ((r9 instanceof r) == false) goto L67;
        if (r0 == true) goto L19;
        r3 = null;
    L19:
        if (r3 == null) goto L22;
        r1 = r3.f17588a;
    L22:
        k(r12, r1);
        return;
    L67:
        return;
    L48:
        H(r12, r9);
        throw null;
    L6:
        if (m.compareAndSet(this, r9, r8) == false) goto L3;
    }

    @Override // h.a.n
    public Object j(Throwable r5) {
        return R(new y(r5, false, 2, null), null, null);
    }

    @Override // h.a.n
    public Object l(T r1, Object r2, kotlin.n0.c.l<? super Throwable, kotlin.f0> r3) {
        return R(r1, r2, r3);
    }

    @Override // h.a.n
    public void m(g0 r7, T r8) {
        kotlin.k0.d<T> r0 = this.f17542i;
        g0 r2 = null;
        if ((r0 instanceof h.a.f3.i) == false) goto L5;
        h.a.f3.i r1 = (h.a.f3.i) r0;
    L6:
        if (r1 == null) goto L9;
        r2 = r1.f17371i;
    L9:
        if (r2 != r7) goto L11;
        int r9 = 4;
    L12:
        N(this, r8, r9, null, 4, null);
        return;
    L11:
        r9 = this.f17589h;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    @Override // h.a.n
    public void n(T r2, kotlin.n0.c.l<? super Throwable, kotlin.f0> r3) {
        M(r2, this.f17589h, r3);
    }

    @Override // h.a.n
    public boolean o(Throwable r5) {
    L2:
        Object r0 = this._state;
        if ((r0 instanceof l2) == false) goto L4;
        boolean r2 = r0 instanceof l;
        r r1 = new r(this, r5, r2);
        if (m.compareAndSet(this, r0, r1) == false) goto L2;
        if (r2 == false) goto L11;
        l r3 = (l) r0;
    L12:
        if (r3 == null) goto L15;
        p(r3, r5);
    L15:
        u();
        v(this.f17589h);
        return true;
    L11:
        r3 = null;
        goto L12
    L4:
        return false;
    }

    public final void p(l r3, Throwable r4) {
        r3.a(r4);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        j0.a(getContext(), new b0(kotlin.n0.d.o.m("Exception in invokeOnCancellation handler for ", this), th));
    }

    @Override // h.a.n
    public void q(Object r2) {
        if (q0.a() == true) goto L5;
    L12:
        v(this.f17589h);
        return;
    L5:
        if (r2 != p.f17553a) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L12;
        throw new AssertionError();
    L7:
        r3 = false;
        goto L8
    }

    public final void r(kotlin.n0.c.l<? super Throwable, kotlin.f0> r3, Throwable r4) {
        r3.invoke(r4);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        j0.a(getContext(), new b0(kotlin.n0.d.o.m("Exception in resume onCancellation handler for ", this), th));
    }

    @Override // kotlin.k0.d
    public void resumeWith(Object r7) {
        N(this, c0.c(r7, this), this.f17589h, null, 4, null);
    }

    public final void t() {
        d1 r0 = this.f17544k;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.dispose();
        this.f17544k = k2.f17534f;
    }

    public String toString() {
        return I() + '(' + r0.c(this.f17542i) + "){" + z() + "}@" + r0.b(this);
    }

    public Throwable w(x1 r1) {
        return r1.A();
    }

    public final Object x() {
        boolean r0 = D();
        if (T() == true) goto L5;
        if (r0 == false) goto L13;
        K();
    L13:
        Object r1 = y();
        if ((r1 instanceof y) == false) goto L20;
        Throwable r2 = ((y) r1).f17588a;
        if (q0.d() == true) goto L18;
        throw r2;
    L18:
        throw h.a.f3.e0.a(r2, this);
    L20:
        if (z0.b(this.f17589h) == false) goto L30;
        x1 r3 = (x1) getContext().get(x1.f17584d);
        if (r3 == null) goto L30;
        if (r3.b() == true) goto L30;
        CancellationException r4 = r3.A();
        a(r1, r4);
        if (q0.d() == true) goto L28;
        throw r4;
    L28:
        throw h.a.f3.e0.a(r4, this);
    L30:
        return e(r1);
    L5:
        if (this.f17544k != null) goto L7;
        B();
    L7:
        if (r0 == false) goto L10;
        K();
    L10:
        return kotlin.k0.i.b.c();
    }

    public final Object y() {
        return this._state;
    }
}
