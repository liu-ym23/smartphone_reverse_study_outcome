package h.a;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001aU\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t¢\u0006\u0002\b\rH\u0086@ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\u000e\u001a[\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0010\"\u0004\b\u0000\u0010\u0005*\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00122'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t¢\u0006\u0002\b\rø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001aF\u0010\u0014\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0005*\u00020\u00152)\b\b\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t¢\u0006\u0002\b\rH\u0086Jø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001aO\u0010\u0017\u001a\u00020\u0018*\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00122'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t¢\u0006\u0002\b\rø\u0001\u0000¢\u0006\u0002\u0010\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"RESUMED", "", "SUSPENDED", "UNDECIDED", "withContext", "T", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "async", "Lkotlinx/coroutines/Deferred;", "start", "Lkotlinx/coroutines/CoroutineStart;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Deferred;", "invoke", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "launch", "Lkotlinx/coroutines/Job;", "", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "kotlinx/coroutines/BuildersKt")
final /* synthetic */ class j {
    public static final x1 a(m0 r1, kotlin.k0.g r2, o0 r3, kotlin.n0.c.p<? super m0, ? super kotlin.k0.d<? super kotlin.f0>, ? extends Object> r4) {
        kotlin.k0.g r5 = f0.e(r1, r2);
        if (r3.c() == false) goto L5;
        a r6 = new h2(r5, r4);
    L6:
        r6.O0(r3, r6, r4);
        return r6;
    L5:
        r6 = new q2(r5, true);
        goto L6
    }

    public static /* synthetic */ x1 b(m0 r0, kotlin.k0.g r1, o0 r2, kotlin.n0.c.p r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = kotlin.k0.h.f18399f;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = o0.f17545f;
    L9:
        return h.a(r0, r1, r2, r3);
    }

    public static final <T> Object c(kotlin.k0.g r8, kotlin.n0.c.p<? super m0, ? super kotlin.k0.d<? super T>, ? extends Object> r9, kotlin.k0.d<? super T> r10) {
        kotlin.k0.g r0 = r10.getContext();
        kotlin.k0.g r11 = f0.d(r0, r8);
        b2.g(r11);
        if (r11 != r0) goto L5;
        h.a.f3.d0 r1 = new h.a.f3.d0(r11, r10);
        Object r12 = h.a.g3.b.b(r1, r1, r9);
    L15:
        if (r12 != kotlin.k0.i.b.c()) goto L17;
        kotlin.k0.j.a.h.c(r10);
    L17:
        return r12;
    L5:
        kotlin.k0.e.b r2 = kotlin.k0.e.f18396a;
        if (kotlin.n0.d.o.a(r11.get(r2), r0.get(r2)) == false) goto L13;
        a3 r3 = new a3(r11, r10);
        Object r4 = h.a.f3.j0.c(r11, null);
        Object r13 = h.a.g3.b.b(r3, r3, r9);     // Catch: Throwable -> L10
        h.a.f3.j0.a(r11, r4);
        r12 = r13;
    L10:
        th = move-exception;
        h.a.f3.j0.a(r11, r4);
        throw th;
    L13:
        x0 r5 = new x0(r11, r10);
        h.a.g3.a.d(r9, r5, r5, null, 4, null);
        r12 = r5.Q0();
        goto L15
    }
}
