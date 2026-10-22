package kotlin.k0.j.a;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.o;
import kotlin.v;
import kotlin.w;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b!\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\u00020\u0004B\u0017\u0012\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\u0002\u0010\u0006J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016J\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\"\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013H$ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\rH\u0014J\u001e\u0010\u0016\u001a\u00020\r2\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001b\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Ljava/io/Serializable;", "completion", "(Lkotlin/coroutines/Continuation;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCompletion", "()Lkotlin/coroutines/Continuation;", "create", "", "value", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "invokeSuspend", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "resumeWith", "(Ljava/lang/Object;)V", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class a implements kotlin.k0.d<Object>, e, Serializable {
    private final kotlin.k0.d<Object> completion;

    public a(kotlin.k0.d<Object> r1) {
        this.completion = r1;
    }

    public kotlin.k0.d<f0> create(Object r1, kotlin.k0.d<?> r2) {
        o.f(r2, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public kotlin.k0.d<f0> create(kotlin.k0.d<?> r1) {
        o.f(r1, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public e getCallerFrame() {
        kotlin.k0.d<Object> r1 = this.completion;
        if ((r1 instanceof e) == true) goto L7;
        return null;
    L7:
        return (e) r1;
    }

    public final kotlin.k0.d<Object> getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        return g.d(this);
    }

    protected abstract Object invokeSuspend(Object r1);

    protected void releaseIntercepted() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.k0.d] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    @Override // kotlin.k0.d
    public final void resumeWith(Object r3) {
    L2:
        h.b(r2);
        a r2 = (a) r2;
        kotlin.k0.d<Object> r0 = r2.completion;
        o.c(r0);
        r3 = r2.invokeSuspend(r3);     // Catch: Throwable -> L8
        if (r3 == kotlin.k0.i.b.c()) goto L5;
        v.a r1 = v.f21457g;     // Catch: Throwable -> L8
        v.b(r3);     // Catch: Throwable -> L8
    L10:
        r2.releaseIntercepted();
        if ((r0 instanceof a) == false) goto L13;
        ?? r4 = r0;
        goto L2
    L13:
        r0.resumeWith(r3);
        return;
    L5:
        return;
    L8:
        th = move-exception;
        v.a r5 = v.f21457g;
        r3 = w.a(th);
        v.b(r3);
        goto L10
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("Continuation at ");
        Object r1 = getStackTraceElement();
        if (r1 != null) goto L6;
        r1 = getClass().getName();
    L6:
        r0.append(r1);
        return r0.toString();
    }
}
