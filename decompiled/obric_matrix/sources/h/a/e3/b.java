package h.a.e3;

import kotlin.Metadata;
import kotlin.f0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BU\u0012-\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0002\b\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0094@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J&\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014R:\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0002\b\tX\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/flow/CallbackFlowBuilder;", "T", "Lkotlinx/coroutines/flow/ChannelFlowBuilder;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "Lkotlin/jvm/functions/Function2;", "collectTo", "scope", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class b<T> extends c<T> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final kotlin.n0.c.p<h.a.d3.t<? super T>, kotlin.k0.d<? super f0>, Object> f17248j;

    @kotlin.k0.j.a.f(c = "kotlinx.coroutines.flow.CallbackFlowBuilder", f = "Builders.kt", l = {336}, m = "collectTo")
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends kotlin.k0.j.a.d {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f17249f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f17250g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ b<T> f17251h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f17252i;

        a(b<T> r1, kotlin.k0.d<? super a> r2) {
            this.f17251h = r1;
            super(r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r2) {
            this.f17250g = r2;
            this.f17252i |= Integer.MIN_VALUE;
            return this.f17251h.d(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(kotlin.n0.c.p<? super h.a.d3.t<? super T>, ? super kotlin.k0.d<? super f0>, ? extends Object> r1, kotlin.k0.g r2, int r3, h.a.d3.e r4) {
        super(r1, r2, r3, r4);
        this.f17248j = r1;
    }

    public /* synthetic */ b(kotlin.n0.c.p r1, kotlin.k0.g r2, int r3, h.a.d3.e r4, int r5, kotlin.n0.d.g r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = kotlin.k0.h.f18399f;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = -2;
    L9:
        if ((r5 & 8) == 0) goto L11;
        r4 = h.a.d3.e.f17221f;
    L11:
        this(r1, r2, r3, r4);
    }

    @Override // h.a.e3.c, h.a.e3.b0.d
    protected Object d(h.a.d3.t<? super T> r5, kotlin.k0.d<? super f0> r6) {
        if ((r6 instanceof a) == false) goto L7;
        a r0 = (a) r6;
        int r1 = r0.f17252i;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.f17252i = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.f17250g;
        Object r2 = kotlin.k0.i.b.c();
        int r3 = r0.f17252i;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r5 = (h.a.d3.t) r0.f17249f;
        kotlin.w.b(r7);
    L18:
        if (r5.p() == false) goto L22;
        return f0.f18324a;
    L22:
        throw new IllegalStateException("'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details.");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.w.b(r7);
        r0.f17249f = r5;
        r0.f17252i = 1;
        if (super.d(r5, r0) != r2) goto L18;
        return r2;
    L7:
        r0 = new a(this, r6);
        goto L8
    }
}
