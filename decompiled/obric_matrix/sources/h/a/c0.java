package h.a;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001aI\u0010\b\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012%\b\u0002\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nH\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a.\u0010\b\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"recoverResult", "Lkotlin/Result;", "T", WsConstants.KEY_CONNECTION_STATE, "", "uCont", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toState", "onCancellation", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "caller", "Lkotlinx/coroutines/CancellableContinuation;", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class c0 {
    public static final <T> Object a(Object r1, kotlin.k0.d<? super T> r2) {
        if ((r1 instanceof y) == false) goto L11;
        kotlin.v.a r0 = kotlin.v.f21457g;
        Throwable r3 = ((y) r1).f17588a;
        if (q0.d() == true) goto L7;
    L10:
        r1 = kotlin.w.a(r3);
    L12:
        kotlin.v.b(r1);
        return r1;
    L7:
        if ((r2 instanceof kotlin.k0.j.a.e) == false) goto L10;
        r3 = h.a.f3.e0.a(r3, (kotlin.k0.j.a.e) r2);
        goto L10
    L11:
        kotlin.v.a r4 = kotlin.v.f21457g;
        goto L12
    }

    public static final <T> Object b(Object r3, kotlin.n0.c.l<? super Throwable, kotlin.f0> r4) {
        Throwable r0 = kotlin.v.d(r3);
        if (r0 != null) goto L7;
        if (r4 != null) goto L9;
        return r3;
    L9:
        return new z(r3, r4);
    L7:
        return new y(r0, false, 2, null);
    }

    public static final <T> Object c(Object r3, n<?> r4) {
        Throwable r0 = kotlin.v.d(r3);
        if (r0 != null) goto L6;
    L12:
        return r3;
    L6:
        if (q0.d() == true) goto L8;
    L11:
        r3 = new y(r0, false, 2, null);
        goto L12
    L8:
        if ((r4 instanceof kotlin.k0.j.a.e) == false) goto L11;
        r0 = h.a.f3.e0.a(r0, (kotlin.k0.j.a.e) r4);
        goto L11
    }

    public static /* synthetic */ Object d(Object r0, kotlin.n0.c.l r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return b(r0, r1);
    }
}
