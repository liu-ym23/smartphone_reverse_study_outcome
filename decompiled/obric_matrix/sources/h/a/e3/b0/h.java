package h.a.e3.b0;

import h.a.b2;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.v;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u00032\u00020\u0004B\u001b\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ'\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ%\u0010\u001a\u001a\u0004\u0018\u00010\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0018\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001eJ\u001a\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\b\u0010\u0018\u001a\u0004\u0018\u00010\u001cH\u0002J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0016J \u0010$\u001a\u00020\u001c2\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0&H\u0016ø\u0001\u0000¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u0010H\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\r8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lkotlinx/coroutines/flow/internal/SafeCollector;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "collector", "collectContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/CoroutineContext;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "collectContextSize", "", "completion", "Lkotlin/coroutines/Continuation;", "", "context", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "lastEmissionContext", "checkContext", "currentContext", "previousContext", "value", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "uCont", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)Ljava/lang/Object;", "exceptionTransparencyViolated", "exception", "Lkotlinx/coroutines/flow/internal/DownstreamExceptionContext;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "invokeSuspend", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class h<T> extends kotlin.k0.j.a.d implements h.a.e3.f<T>, kotlin.k0.j.a.e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h.a.e3.f<T> f17273f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final kotlin.k0.g f17274g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f17275h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private kotlin.k0.g f17276i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private kotlin.k0.d<? super f0> f17277j;

    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "count", "<anonymous parameter 1>", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke", "(ILkotlin/coroutines/CoroutineContext$Element;)Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends q implements p<Integer, kotlin.k0.g.b, Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f17278f = null;

        static {
            f17278f = new a();
        }

        a() {
            super(2);
        }

        public final Integer a(int r1, kotlin.k0.g.b r2) {
            return Integer.valueOf(r1 + 1);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Integer invoke(Integer r1, kotlin.k0.g.b r2) {
            return a(r1.intValue(), r2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(h.a.e3.f<? super T> r3, kotlin.k0.g r4) {
        super(f.f17270f, kotlin.k0.h.f18399f);
        this.f17273f = r3;
        this.f17274g = r4;
        this.f17275h = ((Number) r4.fold(0, a.f17278f)).intValue();
    }

    private final void b(kotlin.k0.g r2, kotlin.k0.g r3, T r4) {
        if ((r3 instanceof e) == true) goto L6;
        j.a(this, r2);
        return;
    L6:
        i((e) r3, r4);
        throw null;
    }

    private final Object d(kotlin.k0.d<? super f0> r3, T r4) {
        kotlin.k0.g r0 = r3.getContext();
        b2.g(r0);
        kotlin.k0.g r1 = this.f17276i;
        if (r1 == r0) goto L5;
        b(r0, r1, r4);
        this.f17276i = r0;
    L5:
        this.f17277j = r3;
        Object r5 = i.a().f(this.f17273f, r4, this);
        if (o.a(r5, kotlin.k0.i.b.c()) == true) goto L8;
        this.f17277j = null;
    L8:
        return r5;
    }

    private final void i(e r3, Object r4) {
        throw new IllegalStateException(kotlin.u0.k.e("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + r3.f17268f + ", but then emission attempt of value '" + r4 + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    @Override // h.a.e3.f
    public Object emit(T r2, kotlin.k0.d<? super f0> r3) {
        Object r1 = d(r3, r2);     // Catch: Throwable -> L11
        if (r1 != kotlin.k0.i.b.c()) goto L7;
        kotlin.k0.j.a.h.c(r3);
    L7:
        if (r1 != kotlin.k0.i.b.c()) goto L10;
        return r1;
    L10:
        return f0.f18324a;
    L11:
        th = move-exception;
        this.f17276i = new e(th, r3.getContext());
        throw th;
    }

    @Override // kotlin.k0.j.a.a, kotlin.k0.j.a.e
    public kotlin.k0.j.a.e getCallerFrame() {
        kotlin.k0.d<? super f0> r1 = this.f17277j;
        if ((r1 instanceof kotlin.k0.j.a.e) == true) goto L7;
        return null;
    L7:
        return (kotlin.k0.j.a.e) r1;
    }

    @Override // kotlin.k0.j.a.d, kotlin.k0.d
    public kotlin.k0.g getContext() {
        kotlin.k0.g r0 = this.f17276i;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return kotlin.k0.h.f18399f;
    }

    @Override // kotlin.k0.j.a.a, kotlin.k0.j.a.e
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.k0.j.a.a
    public Object invokeSuspend(Object r4) {
        Throwable r0 = v.d(r4);
        if (r0 == null) goto L6;
        this.f17276i = new e(r0, getContext());
    L6:
        kotlin.k0.d<? super f0> r3 = this.f17277j;
        if (r3 == null) goto L11;
        r3.resumeWith(r4);
    L11:
        return kotlin.k0.i.b.c();
    }

    @Override // kotlin.k0.j.a.d, kotlin.k0.j.a.a
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
