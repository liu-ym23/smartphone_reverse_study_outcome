package kotlinx.coroutines.debug.internal;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: DebugCoroutineInfoImpl.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\b\u0010$\u001a\u00020\u000eH\u0016J!\u0010%\u001a\u00020&2\u0006\u0010 \u001a\u00020\u000e2\n\u0010'\u001a\u0006\u0012\u0002\b\u00030(H\u0000¢\u0006\u0002\b)J%\u0010*\u001a\u00020&*\b\u0012\u0004\u0012\u00020\u00150+2\b\u0010'\u001a\u0004\u0018\u00010\fH\u0082Pø\u0001\u0000¢\u0006\u0002\u0010,R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R(\u0010\u0019\u001a\u0004\u0018\u00010\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\f8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b!\u0010\"\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "", "context", "Lkotlin/coroutines/CoroutineContext;", "creationStackBottom", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "sequenceNumber", "", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/debug/internal/StackTraceFrame;J)V", "_context", "Ljava/lang/ref/WeakReference;", "_lastObservedFrame", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "_state", "", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getCreationStackBottom", "()Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "creationStackTrace", "", "Ljava/lang/StackTraceElement;", "getCreationStackTrace", "()Ljava/util/List;", "value", "lastObservedFrame", "getLastObservedFrame$kotlinx_coroutines_core", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "setLastObservedFrame$kotlinx_coroutines_core", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)V", "lastObservedThread", "Ljava/lang/Thread;", "state", "getState", "()Ljava/lang/String;", "lastObservedStackTrace", "toString", "updateState", "", "frame", "Lkotlin/coroutines/Continuation;", "updateState$kotlinx_coroutines_core", "yieldFrames", "Lkotlin/sequences/SequenceScope;", "(Lkotlin/sequences/SequenceScope;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DebugCoroutineInfoImpl {
    private final WeakReference<CoroutineContext> _context;
    private WeakReference<CoroutineStackFrame> _lastObservedFrame;
    private String _state;
    private final StackTraceFrame creationStackBottom;
    public Thread lastObservedThread;
    public final long sequenceNumber;

    /* JADX INFO: renamed from: kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$creationStackTrace$1, reason: invalid class name */
    /* JADX INFO: compiled from: DebugCoroutineInfoImpl.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Ljava/lang/StackTraceElement;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$creationStackTrace$1", f = "DebugCoroutineInfoImpl.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super StackTraceElement>, Continuation<? super Unit>, Object> {
        final /* synthetic */ StackTraceFrame $bottom;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DebugCoroutineInfoImpl this$0;

        AnonymousClass1(DebugCoroutineInfoImpl r1, StackTraceFrame r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$bottom = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, this.$bottom, r4);
            r0.L$0 = r3;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(SequenceScope<? super StackTraceElement> r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(SequenceScope<? super StackTraceElement> r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            SequenceScope r7 = (SequenceScope) this.L$0;
            this.label = 1;
            if (DebugCoroutineInfoImpl.access$yieldFrames(this.this$0, r7, this.$bottom.getCallerFrame(), this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DebugCoroutineInfoImpl.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl", f = "DebugCoroutineInfoImpl.kt", i = {}, l = {80}, m = "yieldFrames", n = {}, s = {})
    static final class C04821 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DebugCoroutineInfoImpl this$0;

        C04821(DebugCoroutineInfoImpl r1, Continuation<? super C04821> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DebugCoroutineInfoImpl.access$yieldFrames(this.this$0, null, null, this);
        }
    }

    public DebugCoroutineInfoImpl(CoroutineContext r1, StackTraceFrame r2, long r3) {
        this.creationStackBottom = r2;
        this.sequenceNumber = r3;
        this._context = new WeakReference(r1);
        this._state = DebugCoroutineInfoImplKt.CREATED;
    }

    public static final /* synthetic */ Object access$yieldFrames(DebugCoroutineInfoImpl r0, SequenceScope r1, CoroutineStackFrame r2, Continuation r3) {
        return r0.yieldFrames(r1, r2, r3);
    }

    public final StackTraceFrame getCreationStackBottom() {
        return this.creationStackBottom;
    }

    public final CoroutineContext getContext() {
        return this._context.get();
    }

    public final List<StackTraceElement> getCreationStackTrace() {
        return creationStackTrace();
    }

    public final String getState() {
        return this._state;
    }

    public final CoroutineStackFrame getLastObservedFrame$kotlinx_coroutines_core() {
        WeakReference<CoroutineStackFrame> r0 = this._lastObservedFrame;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    public final void setLastObservedFrame$kotlinx_coroutines_core(CoroutineStackFrame r2) {
        if (r2 == null) goto L4;
        WeakReference<CoroutineStackFrame> r0 = new WeakReference(r2);
    L5:
        this._lastObservedFrame = r0;
        return;
    L4:
        r0 = null;
        goto L5
    }

    public final List<StackTraceElement> lastObservedStackTrace() {
        CoroutineStackFrame r2 = getLastObservedFrame$kotlinx_coroutines_core();
        if (r2 == null) goto L5;
        ArrayList r0 = new ArrayList();
    L7:
        if (r2 == null) goto L13;
        StackTraceElement r1 = r2.getStackTraceElement();
        if (r1 == null) goto L11;
        r0.add(r1);
    L11:
        r2 = r2.getCallerFrame();
        goto L7
    L13:
        return r0;
    L5:
        return CollectionsKt.emptyList();
    }

    private final List<StackTraceElement> creationStackTrace() {
        StackTraceFrame r0 = this.creationStackBottom;
        if (r0 != null) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return SequencesKt.toList(SequencesKt.sequence(new AnonymousClass1(this, r0, null)));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004a -> B:25:0x0061). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005b -> B:24:0x005e). Please report as a decompilation issue!!! */
    private final Object yieldFrames(SequenceScope<? super StackTraceElement> r6, CoroutineStackFrame r7, Continuation<? super Unit> r8) {
        if ((r8 instanceof C04821) == false) goto L7;
        C04821 r0 = (C04821) r8;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        CoroutineStackFrame r5 = (CoroutineStackFrame) r0.L$2;
        r6 = (SequenceScope) r0.L$1;
        DebugCoroutineInfoImpl r10 = (DebugCoroutineInfoImpl) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L24:
        DebugCoroutineInfoImpl r4 = r10;
        r7 = r5;
        DebugCoroutineInfoImpl this = r4;
    L25:
        r7 = r7.getCallerFrame();
        if (r7 == null) goto L29;
    L15:
        if (r7 == null) goto L17;
        StackTraceElement r11 = r7.getStackTraceElement();
        if (r11 == null) goto L25;
        r0.L$0 = this;
        r0.L$1 = r6;
        r0.L$2 = r7;
        r0.label = 1;
        if (r6.yield(r11, r0) != r1) goto L23;
        return r1;
    L23:
        CoroutineStackFrame r12 = r7;
        r10 = this;
        r5 = r12;
        goto L24
    L17:
        return Unit.INSTANCE;
    L29:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
    L7:
        r0 = new C04821(this, r8);
        goto L8
    }

    public final void updateState$kotlinx_coroutines_core(String r3, Continuation<?> r4) {
        if (Intrinsics.areEqual(this._state, r3) == true) goto L5;
    L9:
        this._state = r3;
        Thread r1 = null;
        if ((r4 instanceof CoroutineStackFrame) == false) goto L12;
        CoroutineStackFrame r5 = (CoroutineStackFrame) r4;
    L13:
        setLastObservedFrame$kotlinx_coroutines_core(r5);
        if (Intrinsics.areEqual(r3, DebugCoroutineInfoImplKt.RUNNING) == false) goto L16;
        r1 = Thread.currentThread();
    L17:
        this.lastObservedThread = r1;
        return;
    L16:
        Thread r6 = (Thread) null;
        goto L17
    L12:
        r5 = null;
        goto L13
    L5:
        if (Intrinsics.areEqual(r3, DebugCoroutineInfoImplKt.SUSPENDED) == false) goto L9;
        if (getLastObservedFrame$kotlinx_coroutines_core() == null) goto L9;
    }

    public String toString() {
        return "DebugCoroutineInfo(state=" + getState() + ",context=" + getContext() + ')';
    }
}
