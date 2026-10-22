package h.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.location.LocationRequestCompat;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0011\u0010\u0005\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u0019\u0010\u0000\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a!\u0010\u0000\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0086@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000b\u001a\u0019\u0010\u000f\u001a\u00020\n*\u00020\rH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"delay", "Lkotlinx/coroutines/Delay;", "Lkotlin/coroutines/CoroutineContext;", "getDelay", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Delay;", "awaitCancellation", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "timeMillis", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", TypedValues.TransitionType.S_DURATION, "Lkotlin/time/Duration;", "delay-VtjQ1oo", "toDelayMillis", "toDelayMillis-LRDsOJo", "(J)J", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class v0 {
    public static final Object a(long r3, kotlin.k0.d<? super kotlin.f0> r5) {
        if (r3 <= 0) goto L5;
        o r0 = new o(kotlin.k0.i.b.b(r5), 1);
        r0.A();
        if (r3 >= LocationRequestCompat.PASSIVE_INTERVAL) goto L9;
        b(r0.getContext()).l(r3, r0);
    L9:
        Object r4 = r0.x();
        if (r4 != kotlin.k0.i.b.c()) goto L13;
        kotlin.k0.j.a.h.c(r5);
    L13:
        if (r4 != kotlin.k0.i.b.c()) goto L16;
        return r4;
    L16:
        return kotlin.f0.f18324a;
    L5:
        return kotlin.f0.f18324a;
    }

    public static final u0 b(kotlin.k0.g r1) {
        kotlin.k0.g.b r2 = r1.get(kotlin.k0.e.f18396a);
        if ((r2 instanceof u0) == false) goto L5;
        u0 r3 = (u0) r2;
    L6:
        if (r3 == null) goto L8;
        return r3;
    L8:
        return t0.a();
    L5:
        r3 = null;
        goto L6
    }
}
