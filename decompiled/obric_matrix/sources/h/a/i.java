package h.a;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aT\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"runBlocking", "T", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "kotlinx/coroutines/BuildersKt")
final /* synthetic */ class i {
    public static final <T> T a(kotlin.k0.g r4, kotlin.n0.c.p<? super m0, ? super kotlin.k0.d<? super T>, ? extends Object> r5) {
        Thread r0 = Thread.currentThread();
        kotlin.k0.e r1 = (kotlin.k0.e) r4.get(kotlin.k0.e.f18396a);
        if (r1 != null) goto L6;
        h1 r2 = v2.f17573a.b();
        q1 r3 = q1.f17560f;
        r4 = r4.plus(r2);
    L19:
        f r6 = new f(f0.e(r3, r4), r0, r2);
        r6.O0(o0.f17545f, r6, r5);
        return (T) r6.P0();
    L6:
        h1 r7 = null;
        if ((r1 instanceof h1) == false) goto L9;
        h1 r8 = (h1) r1;
    L10:
        if (r8 != null) goto L13;
    L15:
        if (r7 != null) goto L17;
        r2 = v2.f17573a.a();
    L18:
        r3 = q1.f17560f;
        goto L19
    L17:
        r2 = r7;
        goto L18
    L13:
        if (r8.s0() == false) goto L15;
        r7 = r8;
        goto L15
    L9:
        r8 = null;
        goto L10
    }

    public static /* synthetic */ Object b(kotlin.k0.g r0, kotlin.n0.c.p r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r0 = kotlin.k0.h.f18399f;
    L6:
        return h.c(r0, r1);
    }
}
