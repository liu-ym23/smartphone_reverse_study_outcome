package h.a.f3;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aI\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u0004*\u0018\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u00052\u0006\u0010\u0006\u001a\u0002H\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\u0010\t\u001a=\u0010\n\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0004*\u0018\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u00052\u0006\u0010\u0006\u001a\u0002H\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\u0010\u000b\u001aC\u0010\f\u001a\u0004\u0018\u00010\r\"\u0004\b\u0000\u0010\u0004*\u0018\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u00052\u0006\u0010\u0006\u001a\u0002H\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0000¢\u0006\u0002\u0010\u000f**\b\u0000\u0010\u0010\u001a\u0004\b\u0000\u0010\u0004\"\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00030\u00012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00030\u0001¨\u0006\u0011"}, d2 = {"bindCancellationFun", "Lkotlin/Function1;", "", "", "E", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "element", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)Lkotlin/jvm/functions/Function1;", "callUndeliveredElement", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", "callUndeliveredElementCatchingException", "Lkotlinx/coroutines/internal/UndeliveredElementException;", "undeliveredElementException", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlinx/coroutines/internal/UndeliveredElementException;)Lkotlinx/coroutines/internal/UndeliveredElementException;", "OnUndeliveredElement", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class z {

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "E", "<anonymous parameter 0>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.l<Throwable, kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.l<E, kotlin.f0> f17433f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ E f17434g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ kotlin.k0.g f17435h;

        /* JADX WARN: Multi-variable type inference failed */
        a(kotlin.n0.c.l<? super E, kotlin.f0> r1, E r2, kotlin.k0.g r3) {
            this.f17433f = r1;
            this.f17434g = r2;
            this.f17435h = r3;
            super(1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.f0 invoke(Throwable r1) {
            invoke2(r1);
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable r2) {
            z.b(this.f17433f, this.f17434g, this.f17435h);
        }
    }

    public static final <E> kotlin.n0.c.l<Throwable, kotlin.f0> a(kotlin.n0.c.l<? super E, kotlin.f0> r1, E r2, kotlin.k0.g r3) {
        return new a(r1, r2, r3);
    }

    public static final <E> void b(kotlin.n0.c.l<? super E, kotlin.f0> r1, E r2, kotlin.k0.g r3) {
        p0 r4 = c(r1, r2, null);
        if (r4 == null) goto L7;
        h.a.j0.a(r3, r4);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> p0 c(kotlin.n0.c.l<? super E, kotlin.f0> r1, E r2, p0 r3) {
        r1.invoke(r2);     // Catch: Throwable -> L4
    L9:
        return r3;
    L4:
        th = move-exception;
        if (r3 == null) goto L11;
        if (r3.getCause() == th) goto L11;
        kotlin.a.a(r3, th);
    L11:
        return new p0(kotlin.n0.d.o.m("Exception in undelivered element handler for ", r2), th);
    }

    public static /* synthetic */ p0 d(kotlin.n0.c.l r0, Object r1, p0 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return c(r0, r1, r2);
    }
}
