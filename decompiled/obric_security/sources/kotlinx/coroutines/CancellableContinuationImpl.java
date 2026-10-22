package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import obric.widget.search.data.SearchConfigType;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: compiled from: CancellableContinuationImpl.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\t\u0012\u0004\u0012\u00028\u00000\u008a\u00012\t\u0012\u0004\u0012\u00028\u00000\u008b\u00012\u00060tj\u0002`uB\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0012\u0010\u0013JB\u0010\u0012\u001a\u00020\u00112'\u0010\u000e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u0014j\u0002`\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0018J\u001e\u0010\u001b\u001a\u00020\u00112\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u0019H\u0082\b¢\u0006\u0004\b\u001b\u0010\u001cJ8\u0010\u001e\u001a\u00020\u00112!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u00142\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u001e\u0010\u0018J\u0019\u0010 \u001a\u00020\u001f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b \u0010!J!\u0010%\u001a\u00020\u00112\b\u0010\"\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0010¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b&\u0010!J\u0017\u0010(\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\bH\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010,\u001a\u00020\u0011H\u0000¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020\u0011H\u0002¢\u0006\u0004\b-\u0010+J\u0017\u0010/\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u0004H\u0002¢\u0006\u0004\b/\u00100J\u0017\u00103\u001a\u00020\u000f2\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b3\u00104J\u001b\u00108\u001a\u0004\u0018\u00010\u000f2\b\u00105\u001a\u0004\u0018\u00010\bH\u0010¢\u0006\u0004\b6\u00107J\u0011\u00109\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0004\b9\u0010:J\u0017\u0010=\u001a\n\u0018\u00010;j\u0004\u0018\u0001`<H\u0016¢\u0006\u0004\b=\u0010>J\u001f\u0010A\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u00105\u001a\u0004\u0018\u00010\bH\u0010¢\u0006\u0004\b?\u0010@J\u000f\u0010B\u001a\u00020\u0011H\u0016¢\u0006\u0004\bB\u0010+J\u0011\u0010D\u001a\u0004\u0018\u00010CH\u0002¢\u0006\u0004\bD\u0010EJ8\u0010F\u001a\u00020\u00112'\u0010\u000e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u0014j\u0002`\u0017H\u0016¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\u001fH\u0002¢\u0006\u0004\bH\u0010IJ8\u0010J\u001a\u00020\r2'\u0010\u000e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u0014j\u0002`\u0017H\u0002¢\u0006\u0004\bJ\u0010KJB\u0010L\u001a\u00020\u00112'\u0010\u000e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u0014j\u0002`\u00172\b\u00105\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\bL\u0010MJ\u000f\u0010O\u001a\u00020NH\u0014¢\u0006\u0004\bO\u0010PJ\u0017\u0010S\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\bQ\u0010RJ\u000f\u0010T\u001a\u00020\u0011H\u0002¢\u0006\u0004\bT\u0010+J\u000f\u0010U\u001a\u00020\u001fH\u0001¢\u0006\u0004\bU\u0010IJ<\u0010W\u001a\u00020\u00112\u0006\u0010V\u001a\u00028\u00002#\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014H\u0016¢\u0006\u0004\bW\u0010XJH\u0010Y\u001a\u00020\u00112\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042%\b\u0002\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014H\u0002¢\u0006\u0004\bY\u0010ZJ \u0010]\u001a\u00020\u00112\f\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000[H\u0016ø\u0001\u0000¢\u0006\u0004\b]\u0010)JZ\u0010`\u001a\u0004\u0018\u00010\b2\u0006\u00105\u001a\u00020^2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042#\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00142\b\u0010_\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b`\u0010aJ\u0011\u0010c\u001a\u0004\u0018\u00010\bH\u0010¢\u0006\u0004\bb\u0010:J\u000f\u0010d\u001a\u00020NH\u0016¢\u0006\u0004\bd\u0010PJ\u000f\u0010e\u001a\u00020\u001fH\u0002¢\u0006\u0004\be\u0010IJ#\u0010e\u001a\u0004\u0018\u00010\b2\u0006\u0010V\u001a\u00028\u00002\b\u0010_\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\be\u0010fJH\u0010e\u001a\u0004\u0018\u00010\b2\u0006\u0010V\u001a\u00028\u00002\b\u0010_\u001a\u0004\u0018\u00010\b2#\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014H\u0016¢\u0006\u0004\be\u0010gJJ\u0010i\u001a\u0004\u0018\u00010h2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010_\u001a\u0004\u0018\u00010\b2#\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014H\u0002¢\u0006\u0004\bi\u0010jJ\u0019\u0010l\u001a\u0004\u0018\u00010\b2\u0006\u0010k\u001a\u00020\u000fH\u0016¢\u0006\u0004\bl\u0010mJ\u000f\u0010n\u001a\u00020\u001fH\u0002¢\u0006\u0004\bn\u0010IJ\u001b\u0010p\u001a\u00020\u0011*\u00020o2\u0006\u0010V\u001a\u00028\u0000H\u0016¢\u0006\u0004\bp\u0010qJ\u001b\u0010r\u001a\u00020\u0011*\u00020o2\u0006\u0010k\u001a\u00020\u000fH\u0016¢\u0006\u0004\br\u0010sR\u001c\u0010x\u001a\n\u0018\u00010tj\u0004\u0018\u0001`u8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bv\u0010wR\u001a\u0010z\u001a\u00020y8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0000X\u0080\u0004¢\u0006\r\n\u0004\b\u0003\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001R\u0016\u0010\u0081\u0001\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0081\u0001\u0010IR\u0016\u0010\u0082\u0001\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010IR\u0016\u0010\u0083\u0001\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0083\u0001\u0010IR\u001b\u0010\u0084\u0001\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0017\u00105\u001a\u0004\u0018\u00010\b8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u0086\u0001\u0010:R\u0016\u0010\u0088\u0001\u001a\u00020N8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0087\u0001\u0010P\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0089\u0001"}, d2 = {"Lkotlinx/coroutines/CancellableContinuationImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/Continuation;", "delegate", "", "resumeMode", "<init>", "(Lkotlin/coroutines/Continuation;I)V", "", "proposedUpdate", "", "alreadyResumedError", "(Ljava/lang/Object;)Ljava/lang/Void;", "Lkotlinx/coroutines/CancelHandler;", "handler", "", "cause", "", "callCancelHandler", "(Lkotlinx/coroutines/CancelHandler;Ljava/lang/Throwable;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Throwable;)V", "Lkotlin/Function0;", "block", "callCancelHandlerSafely", "(Lkotlin/jvm/functions/Function0;)V", "onCancellation", "callOnCancellation", "", "cancel", "(Ljava/lang/Throwable;)Z", "takenState", "cancelCompletedResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelCompletedResult", "cancelLater", "token", "completeResume", "(Ljava/lang/Object;)V", "detachChild$kotlinx_coroutines_core", "()V", "detachChild", "detachChildIfNonResuable", SearchConfigType.KEY_MODE, "dispatchResume", "(I)V", "Lkotlinx/coroutines/Job;", "parent", "getContinuationCancellationCause", "(Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "state", "getExceptionalResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getExceptionalResult", "getResult", "()Ljava/lang/Object;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "getSuccessfulResult", "initCancellability", "Lkotlinx/coroutines/DisposableHandle;", "installParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "invokeOnCancellation", "(Lkotlin/jvm/functions/Function1;)V", "isReusable", "()Z", "makeCancelHandler", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/CancelHandler;", "multipleHandlersError", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V", "", "nameString", "()Ljava/lang/String;", "parentCancelled$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)V", "parentCancelled", "releaseClaimedReusableContinuation", "resetStateReusable", "value", "resume", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "resumeImpl", "(Ljava/lang/Object;ILkotlin/jvm/functions/Function1;)V", "Lkotlin/Result;", "result", "resumeWith", "Lkotlinx/coroutines/NotCompleted;", "idempotent", "resumedState", "(Lkotlinx/coroutines/NotCompleted;Ljava/lang/Object;ILkotlin/jvm/functions/Function1;Ljava/lang/Object;)Ljava/lang/Object;", "takeState$kotlinx_coroutines_core", "takeState", "toString", "tryResume", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/Symbol;", "tryResumeImpl", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/Symbol;", "exception", "tryResumeWithException", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "trySuspend", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "isActive", "isCancelled", "isCompleted", "parentHandle", "Lkotlinx/coroutines/DisposableHandle;", "getState$kotlinx_coroutines_core", "getStateDebugRepresentation", "stateDebugRepresentation", "kotlinx-coroutines-core", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class CancellableContinuationImpl<T> extends DispatchedTask<T> implements CancellableContinuation<T>, CoroutineStackFrame {
    private static final /* synthetic */ AtomicIntegerFieldUpdater _decision$FU = null;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _state$FU = null;
    private volatile /* synthetic */ int _decision;
    private volatile /* synthetic */ Object _state;
    private final CoroutineContext context;
    private final Continuation<T> delegate;
    private DisposableHandle parentHandle;

    static {
        _decision$FU = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl.class, "_decision");
        _state$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_state");
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    protected String nameString() {
        return "CancellableContinuation";
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return this.delegate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CancellableContinuationImpl(Continuation<? super T> r3, int r4) {
        super(r4);
        this.delegate = r3;
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L5;
    L12:
        this.context = r3.getContext();
        this._decision = 0;
        this._state = Active.INSTANCE;
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

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.context;
    }

    public final Object getState$kotlinx_coroutines_core() {
        return this._state;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isActive() {
        return getState$kotlinx_coroutines_core() instanceof NotCompleted;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof NotCompleted);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isCancelled() {
        return getState$kotlinx_coroutines_core() instanceof CancelledContinuation;
    }

    private final String getStateDebugRepresentation() {
        Object r1 = getState$kotlinx_coroutines_core();
        if ((r1 instanceof NotCompleted) == false) goto L6;
        return "Active";
    L6:
        if ((r1 instanceof CancelledContinuation) == false) goto L8;
        return "Cancelled";
    L8:
        return "Completed";
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void initCancellability() {
        DisposableHandle r0 = installParentHandle();
        if (r0 != null) goto L6;
        return;
    L6:
        if (isCompleted() == false) goto L9;
        r0.dispose();
        this.parentHandle = NonDisposableHandle.INSTANCE;
        return;
    }

    private final boolean isReusable() {
        if (DispatchedTaskKt.isReusableMode(this.resumeMode) == true) goto L5;
    L7:
        return false;
    L5:
        if (((DispatchedContinuation) this.delegate).isReusable() == false) goto L7;
        return true;
    }

    public final boolean resetStateReusable() {
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L13;
        if (this.resumeMode != 2) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L13;
        throw new AssertionError();
    L7:
        r0 = false;
    L13:
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L15;
    L22:
        Object r1 = this._state;
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L30;
        if ((!(r1 instanceof NotCompleted)) == true) goto L30;
        throw new AssertionError();
    L30:
        if ((r1 instanceof CompletedContinuation) == true) goto L32;
    L35:
        this._decision = 0;
        this._state = Active.INSTANCE;
        return true;
    L32:
        if (((CompletedContinuation) r1).idempotentResume == null) goto L35;
        detachChild$kotlinx_coroutines_core();
        return false;
    L15:
        if (this.parentHandle == NonDisposableHandle.INSTANCE) goto L17;
        boolean r2 = true;
    L18:
        if (r2 == true) goto L22;
        throw new AssertionError();
    L17:
        r2 = false;
        goto L18
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> r1 = this.delegate;
        if ((r1 instanceof CoroutineStackFrame) == true) goto L7;
        return null;
    L7:
        return (CoroutineStackFrame) r1;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Object takeState$kotlinx_coroutines_core() {
        return getState$kotlinx_coroutines_core();
    }

    private final boolean cancelLater(Throwable r2) {
        if (isReusable() == true) goto L7;
        return false;
    L7:
        return ((DispatchedContinuation) this.delegate).postponeCancellation(r2);
    }

    public final void parentCancelled$kotlinx_coroutines_core(Throwable r2) {
        if (cancelLater(r2) == false) goto L5;
        return;
    L5:
        cancel(r2);
        detachChildIfNonResuable();
    }

    private final void callCancelHandlerSafely(Function0<Unit> r5) {
        r5.invoke();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th));
    }

    public final void callCancelHandler(CancelHandler r4, Throwable r5) {
        r4.invoke(r5);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th));
    }

    public final void callOnCancellation(Function1<? super Throwable, Unit> r4, Throwable r5) {
        r4.invoke(r5);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th));
    }

    public Throwable getContinuationCancellationCause(Job r1) {
        return r1.getCancellationException();
    }

    public final Object getResult() {
        boolean r0 = isReusable();
        if (trySuspend() == true) goto L5;
        if (r0 == false) goto L13;
        releaseClaimedReusableContinuation();
    L13:
        Object r1 = getState$kotlinx_coroutines_core();
        if ((r1 instanceof CompletedExceptionally) == false) goto L23;
        Throwable r2 = ((CompletedExceptionally) r1).cause;
        if (DebugKt.getRECOVER_STACK_TRACES() == false) goto L37;
        CancellableContinuationImpl<T> r3 = this;
        if ((r3 instanceof CoroutineStackFrame) == true) goto L21;
        throw r2;
    L21:
        throw StackTraceRecoveryKt.access$recoverFromStackFrame(r2, r3);
    L37:
        throw r2;
    L23:
        if (DispatchedTaskKt.isCancellableMode(this.resumeMode) == false) goto L36;
        Job r4 = (Job) getContext().get(Job.Key);
        if (r4 == null) goto L36;
        if (r4.isActive() == true) goto L36;
        CancellationException r5 = r4.getCancellationException();
        cancelCompletedResult$kotlinx_coroutines_core(r1, r5);
        if (DebugKt.getRECOVER_STACK_TRACES() == false) goto L39;
        CancellableContinuationImpl<T> r6 = this;
        if ((r6 instanceof CoroutineStackFrame) == true) goto L34;
        throw r5;
    L34:
        throw StackTraceRecoveryKt.access$recoverFromStackFrame(r5, r6);
    L39:
        throw r5;
    L36:
        return getSuccessfulResult$kotlinx_coroutines_core(r1);
    L5:
        if (this.parentHandle != null) goto L7;
        installParentHandle();
    L7:
        if (r0 == false) goto L10;
        releaseClaimedReusableContinuation();
    L10:
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    private final DisposableHandle installParentHandle() {
        Job r1 = (Job) getContext().get(Job.Key);
        if (r1 != null) goto L6;
        return null;
    L6:
        DisposableHandle r0 = Job.DefaultImpls.invokeOnCompletion$default(r1, true, false, new ChildContinuation(this), 2, null);
        this.parentHandle = r0;
        return r0;
    }

    private final void releaseClaimedReusableContinuation() {
        Continuation<T> r0 = this.delegate;
        if ((r0 instanceof DispatchedContinuation) == false) goto L5;
        DispatchedContinuation r1 = (DispatchedContinuation) r0;
    L6:
        if (r1 == null) goto L12;
        Throwable r2 = r1.tryReleaseClaimedContinuation(this);
        if (r2 == null) goto L13;
        detachChild$kotlinx_coroutines_core();
        cancel(r2);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object r8) {
        resumeImpl$default(this, CompletionStateKt.toState(r8, this), this.resumeMode, null, 4, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resume(T r2, Function1<? super Throwable, Unit> r3) {
        resumeImpl(r2, this.resumeMode, r3);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void invokeOnCancellation(Function1<? super Throwable, Unit> r12) {
        CancelHandler r8 = makeCancelHandler(r12);
    L3:
        Object r9 = this._state;
        if ((r9 instanceof Active) == true) goto L6;
        if ((r9 instanceof CancelHandler) == true) goto L10;
        boolean r0 = r9 instanceof CompletedExceptionally;
        if (r0 == true) goto L13;
        if ((r9 instanceof CompletedContinuation) == true) goto L28;
        if ((r8 instanceof BeforeResumeCancelHandler) == true) goto L43;
        if (b0$$ExternalSyntheticBackport0.m(_state$FU, this, r9, new CompletedContinuation(r9, r8, null, null, null, 28, null)) == false) goto L3;
        return;
    L43:
        return;
    L28:
        CompletedContinuation r1 = (CompletedContinuation) r9;
        if (r1.cancelHandler == null) goto L32;
        multipleHandlersError(r12, r9);
    L32:
        if ((r8 instanceof BeforeResumeCancelHandler) == true) goto L33;
        if (r1.getCancelled() == true) goto L36;
        if (b0$$ExternalSyntheticBackport0.m(_state$FU, this, r9, CompletedContinuation.copy$default(r1, null, r8, null, null, null, 29, null)) == false) goto L3;
        return;
    L36:
        callCancelHandler(r12, r1.cancelCause);
        return;
    L33:
        return;
    L13:
        CompletedExceptionally r2 = (CompletedExceptionally) r9;
        if (r2.makeHandled() == true) goto L17;
        multipleHandlersError(r12, r9);
    L17:
        if ((r9 instanceof CancelledContinuation) == false) goto L65;
        Throwable r3 = null;
        if (r0 == true) goto L22;
        r2 = null;
    L22:
        if (r2 == null) goto L24;
        r3 = r2.cause;
    L24:
        callCancelHandler(r12, r3);
        return;
    L65:
        return;
    L10:
        multipleHandlersError(r12, r9);
        goto L3
    L6:
        if (b0$$ExternalSyntheticBackport0.m(_state$FU, this, r9, r8) == false) goto L3;
    }

    private final void multipleHandlersError(Function1<? super Throwable, Unit> r3, Object r4) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + r3 + ", already has " + r4).toString());
    }

    private final CancelHandler makeCancelHandler(Function1<? super Throwable, Unit> r1) {
        if ((r1 instanceof CancelHandler) == false) goto L6;
        return (CancelHandler) r1;
    L6:
        return new InvokeOnCancel(r1);
    }

    private final void dispatchResume(int r2) {
        if (tryResume() == false) goto L5;
        return;
    L5:
        DispatchedTaskKt.dispatch(this, r2);
    }

    private final Object resumedState(NotCompleted r9, Object r10, int r11, Function1<? super Throwable, Unit> r12, Object r13) {
        if ((r10 instanceof CompletedExceptionally) == false) goto L23;
        boolean r14 = true;
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L14;
        if (r13 != null) goto L8;
        boolean r8 = true;
    L9:
        if (r8 == true) goto L14;
        throw new AssertionError();
    L8:
        r8 = false;
    L14:
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L38;
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
        if (DispatchedTaskKt.isCancellableMode(r11) == true) goto L26;
        if (r13 != null) goto L26;
        return r10;
    L26:
        if (r12 != null) goto L33;
        if ((r9 instanceof CancelHandler) == true) goto L30;
    L31:
        if (r13 != null) goto L33;
        return r10;
    L30:
        if ((r9 instanceof BeforeResumeCancelHandler) == true) goto L31;
    L33:
        if ((r9 instanceof CancelHandler) == false) goto L35;
        CancelHandler r15 = (CancelHandler) r9;
    L37:
        return new CompletedContinuation(r10, r15, r12, r13, null, 16, null);
    L35:
        r15 = null;
        goto L37
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void resumeImpl$default(CancellableContinuationImpl r0, Object r1, int r2, Function1 r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        r0.resumeImpl(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    private final Void alreadyResumedError(Object r3) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + r3).toString());
    }

    private final void detachChildIfNonResuable() {
        if (isReusable() == true) goto L6;
        detachChild$kotlinx_coroutines_core();
        return;
    }

    public final void detachChild$kotlinx_coroutines_core() {
        DisposableHandle r0 = this.parentHandle;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.dispose();
        this.parentHandle = NonDisposableHandle.INSTANCE;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object tryResume(T r2, Object r3) {
        return tryResumeImpl(r2, r3, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object tryResume(T r1, Object r2, Function1<? super Throwable, Unit> r3) {
        return tryResumeImpl(r1, r2, r3);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object tryResumeWithException(Throwable r5) {
        return tryResumeImpl(new CompletedExceptionally(r5, false, 2, null), null, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void completeResume(Object r2) {
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L5;
    L12:
        dispatchResume(this.resumeMode);
        return;
    L5:
        if (r2 != CancellableContinuationImplKt.RESUME_TOKEN) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L12;
        throw new AssertionError();
    L7:
        r3 = false;
        goto L8
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resumeUndispatched(CoroutineDispatcher r7, T r8) {
        Continuation<T> r0 = this.delegate;
        CoroutineDispatcher r2 = null;
        if ((r0 instanceof DispatchedContinuation) == false) goto L5;
        DispatchedContinuation r1 = (DispatchedContinuation) r0;
    L6:
        if (r1 == null) goto L8;
        r2 = r1.dispatcher;
    L8:
        if (r2 != r7) goto L10;
        int r9 = 4;
    L11:
        resumeImpl$default(this, r8, r9, null, 4, null);
        return;
    L10:
        r9 = this.resumeMode;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resumeUndispatchedWithException(CoroutineDispatcher r10, Throwable r11) {
        Continuation<T> r0 = this.delegate;
        CoroutineDispatcher r2 = null;
        if ((r0 instanceof DispatchedContinuation) == false) goto L5;
        DispatchedContinuation r1 = (DispatchedContinuation) r0;
    L6:
        CompletedExceptionally r4 = new CompletedExceptionally(r11, false, 2, null);
        if (r1 == null) goto L9;
        r2 = r1.dispatcher;
    L9:
        if (r2 != r10) goto L11;
        int r12 = 4;
    L12:
        resumeImpl$default(this, r4, r12, null, 4, null);
        return;
    L11:
        r12 = this.resumeMode;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.DispatchedTask
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(Object r1) {
        if ((r1 instanceof CompletedContinuation) == true) goto L5;
        return r1;
    L5:
        return (T) ((CompletedContinuation) r1).result;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object r2) {
        Throwable r3 = super.getExceptionalResult$kotlinx_coroutines_core(r2);
        if (r3 == null) goto L10;
        Continuation<T> r1 = this.delegate;
        if (DebugKt.getRECOVER_STACK_TRACES() == true) goto L7;
        return r3;
    L7:
        if ((r1 instanceof CoroutineStackFrame) == true) goto L13;
        return r3;
    L13:
        return StackTraceRecoveryKt.access$recoverFromStackFrame(r3, (CoroutineStackFrame) r1);
    L10:
        return null;
    }

    public String toString() {
        return nameString() + '(' + DebugStringsKt.toDebugString(this.delegate) + "){" + getStateDebugRepresentation() + "}@" + DebugStringsKt.getHexAddress(this);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void cancelCompletedResult$kotlinx_coroutines_core(Object r11, Throwable r12) {
    L2:
        Object r13 = this._state;
        if ((r13 instanceof NotCompleted) == true) goto L21;
        if ((r13 instanceof CompletedExceptionally) == true) goto L6;
        if ((r13 instanceof CompletedContinuation) == true) goto L9;
        if (b0$$ExternalSyntheticBackport0.m(_state$FU, this, r13, new CompletedContinuation(r13, null, null, null, r12, 14, null)) == false) goto L2;
        return;
    L9:
        CompletedContinuation r0 = (CompletedContinuation) r13;
        if ((!r0.getCancelled()) == false) goto L16;
        if (b0$$ExternalSyntheticBackport0.m(_state$FU, this, r13, CompletedContinuation.copy$default(r0, null, null, null, null, r12, 15, null)) == false) goto L2;
        r0.invokeHandlers(this, r12);
        return;
    L16:
        throw new IllegalStateException("Must be called at most once".toString());
    L6:
        return;
    L21:
        throw new IllegalStateException("Not completed".toString());
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean cancel(Throwable r5) {
    L2:
        Object r0 = this._state;
        if ((r0 instanceof NotCompleted) == false) goto L4;
        boolean r3 = r0 instanceof CancelHandler;
        CancelledContinuation r1 = new CancelledContinuation(this, r5, r3);
        if (b0$$ExternalSyntheticBackport0.m(_state$FU, this, r0, r1) == false) goto L2;
        if (r3 == false) goto L10;
        CancelHandler r2 = (CancelHandler) r0;
    L11:
        if (r2 == null) goto L13;
        callCancelHandler(r2, r5);
    L13:
        detachChildIfNonResuable();
        dispatchResume(this.resumeMode);
        return true;
    L10:
        r2 = null;
        goto L11
    L4:
        return false;
    }

    private final void callCancelHandler(Function1<? super Throwable, Unit> r4, Throwable r5) {
        r4.invoke(r5);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th));
    }

    private final boolean trySuspend() {
    L2:
        int r0 = this._decision;
        if (r0 != 0) goto L5;
        if (_decision$FU.compareAndSet(this, 0, 1) == false) goto L2;
        return true;
    L5:
        if (r0 != 2) goto L8;
        return false;
    L8:
        throw new IllegalStateException("Already suspended".toString());
    }

    private final boolean tryResume() {
    L2:
        int r0 = this._decision;
        if (r0 != 0) goto L4;
        if (_decision$FU.compareAndSet(this, 0, 2) == false) goto L2;
        return true;
    L4:
        if (r0 != 1) goto L7;
        return false;
    L7:
        throw new IllegalStateException("Already resumed".toString());
    }

    private final void resumeImpl(Object r9, int r10, Function1<? super Throwable, Unit> r11) {
    L2:
        Object r0 = this._state;
        if ((r0 instanceof NotCompleted) == false) goto L9;
        Object r1 = resumedState((NotCompleted) r0, r9, r10, r11, null);
        if (b0$$ExternalSyntheticBackport0.m(_state$FU, this, r0, r1) == false) goto L2;
        detachChildIfNonResuable();
        dispatchResume(r10);
        return;
    L9:
        if ((r0 instanceof CancelledContinuation) == false) goto L15;
        CancelledContinuation r2 = (CancelledContinuation) r0;
        if (r2.makeResumed() == false) goto L15;
        if (r11 == null) goto L20;
        callOnCancellation(r11, r2.cause);
        return;
    L20:
        return;
    L15:
        alreadyResumedError(r9);
        throw new KotlinNothingValueException();
    }

    private final Symbol tryResumeImpl(Object r9, Object r10, Function1<? super Throwable, Unit> r11) {
    L2:
        Object r0 = this._state;
        if ((r0 instanceof NotCompleted) == false) goto L9;
        Object r1 = resumedState((NotCompleted) r0, r9, this.resumeMode, r11, r10);
        if (b0$$ExternalSyntheticBackport0.m(_state$FU, this, r0, r1) == false) goto L2;
        detachChildIfNonResuable();
        return CancellableContinuationImplKt.RESUME_TOKEN;
    L9:
        if ((r0 instanceof CompletedContinuation) == false) goto L26;
        if (r10 == null) goto L21;
        CompletedContinuation r2 = (CompletedContinuation) r0;
        if (r2.idempotentResume != r10) goto L21;
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L27;
        if (Intrinsics.areEqual(r2.result, r9) == true) goto L27;
        throw new AssertionError();
    L27:
        return CancellableContinuationImplKt.RESUME_TOKEN;
    L21:
        Symbol r8 = (Symbol) null;
        return null;
    L26:
        return null;
    }
}
