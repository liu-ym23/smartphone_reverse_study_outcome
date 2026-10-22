package h.a.d3;

import h.a.m0;
import h.a.o0;
import h.a.x1;
import kotlin.Metadata;
import kotlin.f0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u009e\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2-\b\u0002\u0010\u0010\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`\u00162/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u001a¨\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2-\b\u0002\u0010\u0010\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`\u00162/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017¢\u0006\u0002\b\u001aH\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001ae\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"awaitClose", "", "Lkotlinx/coroutines/channels/ProducerScope;", "block", "Lkotlin/Function0;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "produce", "Lkotlinx/coroutines/channels/ReceiveChannel;", "E", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "start", "Lkotlinx/coroutines/CoroutineStart;", "onCompletion", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlinx/coroutines/CompletionHandler;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class r {

    @kotlin.k0.j.a.f(c = "kotlinx.coroutines.channels.ProduceKt", f = "Produce.kt", l = {153}, m = "awaitClose")
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends kotlin.k0.j.a.d {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f17236f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f17237g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        /* synthetic */ Object f17238h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f17239i;

        a(kotlin.k0.d<? super a> r1) {
            super(r1);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r2) {
            this.f17238h = r2;
            this.f17239i |= Integer.MIN_VALUE;
            return r.a(null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.l<Throwable, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ h.a.n<f0> f17240f;

        /* JADX WARN: Multi-variable type inference failed */
        b(h.a.n<? super f0> r1) {
            this.f17240f = r1;
            super(1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(Throwable r1) {
            invoke2(r1);
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable r1) {
            h.a.n<f0> r0 = this.f17240f;
            kotlin.v.a r2 = kotlin.v.f21457g;
            f0 r3 = f0.f18324a;
            kotlin.v.b(r3);
            r0.resumeWith(r3);
        }
    }

    public static final Object a(t<?> r4, kotlin.n0.c.a<f0> r5, kotlin.k0.d<? super f0> r6) {
        if ((r6 instanceof a) == false) goto L7;
        a r0 = (a) r6;
        int r1 = r0.f17239i;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.f17239i = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.f17238h;
        Object r2 = kotlin.k0.i.b.c();
        int r3 = r0.f17239i;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        r5 = (kotlin.n0.c.a) r0.f17237g;
        t r8 = (t) r0.f17236f;
        kotlin.w.b(r7);     // Catch: Throwable -> L14
    L28:
        r5.invoke();
        return f0.f18324a;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        kotlin.w.b(r7);
        if (r0.getContext().get(x1.f17584d) != r4) goto L21;
        boolean r9 = true;
    L22:
        if (r9 == false) goto L33;
        r0.f17236f = r4;     // Catch: Throwable -> L14
        r0.f17237g = r5;     // Catch: Throwable -> L14
        r0.f17239i = 1;     // Catch: Throwable -> L14
        h.a.o r10 = new h.a.o(kotlin.k0.i.b.b(r0), 1);     // Catch: Throwable -> L14
        r10.A();     // Catch: Throwable -> L14
        r4.f(new b(r10));     // Catch: Throwable -> L14
        Object r11 = r10.x();     // Catch: Throwable -> L14
        if (r11 != kotlin.k0.i.b.c()) goto L26;
        kotlin.k0.j.a.h.c(r0);     // Catch: Throwable -> L14
    L26:
        if (r11 != r2) goto L28;
        return r2;
    L33:
        throw new IllegalStateException("awaitClose() can only be invoked from the producer context".toString());
    L21:
        r9 = false;
    L14:
        th = move-exception;
        r5.invoke();
        throw th;
    L7:
        r0 = new a(r6);
        goto L8
    }

    public static final <E> v<E> b(m0 r2, kotlin.k0.g r3, int r4, e r5, o0 r6, kotlin.n0.c.l<? super Throwable, f0> r7, kotlin.n0.c.p<? super t<? super E>, ? super kotlin.k0.d<? super f0>, ? extends Object> r8) {
        f r9 = i.c(r4, r5, null, 4, null);
        s r10 = new s(h.a.f0.e(r2, r3), r9);
        if (r7 == null) goto L5;
        r10.L(r7);
    L5:
        r10.O0(r6, r10, r8);
        return r10;
    }

    public static /* synthetic */ v c(m0 r7, kotlin.k0.g r8, int r9, e r10, o0 r11, kotlin.n0.c.l r12, kotlin.n0.c.p r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L5;
        r8 = kotlin.k0.h.f18399f;
    L5:
        kotlin.k0.g r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r9 = 0;
    L8:
        int r2 = r9;
        if ((r14 & 4) == 0) goto L11;
        r10 = e.f17221f;
    L11:
        e r3 = r10;
        if ((r14 & 8) == 0) goto L14;
        r11 = o0.f17545f;
    L14:
        o0 r4 = r11;
        if ((r14 & 16) == 0) goto L18;
        r12 = null;
    L18:
        return b(r7, r1, r2, r3, r4, r12, r13);
    }
}
