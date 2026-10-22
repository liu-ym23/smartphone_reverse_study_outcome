package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SafeCollector<T> extends ContinuationImpl implements FlowCollector<T>, CoroutineStackFrame {
    public final int f;
    public CoroutineContext i;
    public Continuation j;
    public final FlowCollector k;
    public final CoroutineContext l;

    public SafeCollector(FlowCollector r3, CoroutineContext r4) {
        super(NoOpContinuation.b, EmptyCoroutineContext.b);
        this.k = r3;
        this.l = r4;
        this.f = ((Number) r4.H(0, SafeCollector$collectContextSize$1.b)).intValue();
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object d(Object r1, Continuation r2) {
        Object r0 = l(r2, r1);     // Catch: Throwable -> L8
        if (r0 != CoroutineSingletons.b) goto L7;
        return r0;
    L7:
        return Unit.f330a;
    L8:
        th = move-exception;
        this.i = new DownstreamExceptionElement(th);
        throw th;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame e() {
        Continuation r1 = this.j;
        if ((r1 instanceof CoroutineStackFrame) == true) goto L6;
        r1 = null;
    L6:
        return (CoroutineStackFrame) r1;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        Continuation r0 = this.j;
        if (r0 == null) goto L8;
        CoroutineContext r1 = r0.getContext();
        if (r1 == null) goto L8;
        return r1;
    L8:
        return EmptyCoroutineContext.b;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r3) {
        Throwable r0 = Result.a(r3);
        if (r0 == null) goto L5;
        this.i = new DownstreamExceptionElement(r0);
    L5:
        Continuation r2 = this.j;
        if (r2 == null) goto L9;
        r2.k(r3);
    L9:
        return CoroutineSingletons.b;
    }

    public final Object l(Continuation r4, Object r5) {
        CoroutineContext r0 = r4.getContext();
        Job r1 = (Job) r0.f(Job.g);
        if (r1 != null) goto L5;
    L9:
        CoroutineContext r2 = this.i;
        if (r2 != r0) goto L12;
    L20:
        this.j = r4;
        Function3 r6 = SafeCollectorKt.f404a;
        FlowCollector r3 = this.k;
        if (r3 == null) goto L25;
        return r6.b(r3, r5, this);
    L25:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
    L12:
        if ((r2 instanceof DownstreamExceptionElement) == true) goto L19;
        if (((Number) r0.H(0, new SafeCollector_commonKt$checkContext$result$1(this))).intValue() != this.f) goto L17;
        this.i = r0;
        goto L20
    L17:
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + this.l + ",\n\t\tbut emission happened in " + r0 + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    L19:
        throw new IllegalStateException(StringsKt.K("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + ((DownstreamExceptionElement) r2).b + ", but then emission attempt of value '" + r5 + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    L5:
        if (r1.isActive() == true) goto L9;
        throw r1.q();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement w() {
        return null;
    }
}
