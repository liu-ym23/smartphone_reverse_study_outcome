package h.a.h3;

import h.a.f0;
import h.a.m0;
import h.a.o0;
import h.a.q1;
import h.a.x1;
import kotlin.Metadata;
import kotlin.k0.g;
import kotlin.k0.h;
import kotlin.n0.c.p;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aO\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042)\u0010\u0005\u001a%\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\nø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001aW\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00042)\u0010\u0005\u001a%\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\nH\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001aU\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u00042)\u0010\u0005\u001a%\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\nH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"rxMaybe", "Lio/reactivex/Maybe;", "T", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lio/reactivex/Maybe;", "rxMaybeInternal", "scope", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lio/reactivex/Maybe;", "kotlinx-coroutines-rx2"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class e {
    public static /* synthetic */ void a(m0 r0, g r1, p r2, f.a.b r3) {
        e(r0, r1, r2, r3);
    }

    public static final <T> f.a.a<T> b(g r1, p<? super m0, ? super kotlin.k0.d<? super T>, ? extends Object> r2) {
        if (r1.get(x1.f17584d) != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return d(q1.f17560f, r1, r2);
    L10:
        throw new IllegalArgumentException(o.m("Maybe context cannot contain job in it.Its lifecycle should be managed via Disposable handle. Had ", r1).toString());
    L5:
        r0 = false;
        goto L6
    }

    public static /* synthetic */ f.a.a c(g r0, p r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r0 = h.f18399f;
    L6:
        return b(r0, r1);
    }

    private static final <T> f.a.a<T> d(final m0 r1, final g r2, final p<? super m0, ? super kotlin.k0.d<? super T>, ? extends Object> r3) {
        return f.a.a.b(new a(r1, r2, r3));
    }

    private static final void e(m0 r0, g r1, p r2, f.a.b r3) {
        d r4 = new d(f0.e(r0, r1), r3);
        r3.c(new b(r4));
        r4.O0(o0.f17545f, r4, r2);
    }
}
