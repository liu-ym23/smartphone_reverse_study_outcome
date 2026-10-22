package h.a.g3;

import h.a.f3.d0;
import h.a.f3.e0;
import h.a.f3.j0;
import h.a.g2;
import h.a.q0;
import h.a.w2;
import h.a.y;
import kotlin.Metadata;
import kotlin.k0.d;
import kotlin.k0.g;
import kotlin.k0.j.a.e;
import kotlin.k0.j.a.h;
import kotlin.n0.c.p;
import kotlin.v;
import kotlin.w;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a9\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u001a\u0010\u0005\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0082\b\u001a>\u0010\b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\t\u001aR\u0010\b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u0002*\u001e\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b2\u0006\u0010\f\u001a\u0002H\n2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a>\u0010\u000e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\t\u001aR\u0010\u000e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u0002*\u001e\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b2\u0006\u0010\f\u001a\u0002H\n2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\r\u001aY\u0010\u000f\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u0002H\u00020\u00102\u0006\u0010\f\u001a\u0002H\n2'\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b¢\u0006\u0002\b\u0011H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aY\u0010\u0013\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u0002H\u00020\u00102\u0006\u0010\f\u001a\u0002H\n2'\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b¢\u0006\u0002\b\u0011H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a?\u0010\u0014\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00102\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00062\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0019H\u0082\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"startDirect", "", "T", "completion", "Lkotlin/coroutines/Continuation;", "block", "Lkotlin/Function1;", "", "startCoroutineUndispatched", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "startCoroutineUnintercepted", "startUndispatchedOrReturn", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/internal/ScopeCoroutine;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "startUndispatchedOrReturnIgnoreTimeout", "undispatchedResult", "shouldThrow", "", "", "startBlock", "Lkotlin/Function0;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class b {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <R, T> void a(p<? super R, ? super d<? super T>, ? extends Object> r3, R r4, d<? super T> r5) {
        h.a(r5);
        g r0 = r5.getContext();     // Catch: Throwable -> L13
        Object r1 = j0.c(r0, null);     // Catch: Throwable -> L13
        kotlin.n0.d.j0.e(r3, 2);     // Catch: Throwable -> L10
        Object r6 = r3.invoke(r4, r5);     // Catch: Throwable -> L10
        j0.a(r0, r1);     // Catch: Throwable -> L13
        if (r6 == kotlin.k0.i.b.c()) goto L20;
        v.a r7 = v.f21457g;
    L15:
        v.b(r6);
        r5.resumeWith(r6);
        return;
    L20:
        return;
    L10:
        th = move-exception;
        j0.a(r0, r1);     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        v.a r8 = v.f21457g;
        r6 = w.a(th);
        goto L15
    }

    public static final <T, R> Object b(d0<? super T> r3, R r4, p<? super R, ? super d<? super T>, ? extends Object> r5) {
        kotlin.n0.d.j0.e(r5, 2);     // Catch: Throwable -> L5
        Object r6 = r5.invoke(r4, r3);     // Catch: Throwable -> L5
    L8:
        if (r6 == kotlin.k0.i.b.c()) goto L28;
        Object r7 = r3.o0(r6);
        if (r7 == g2.f17440b) goto L28;
        if ((r7 instanceof y) == false) goto L23;
        Throwable r8 = ((y) r7).f17588a;
        d<? super T> r9 = r3.f17362h;
        if (q0.d() == true) goto L18;
        throw r8;
    L18:
        if ((r9 instanceof e) == true) goto L21;
        throw r8;
    L21:
        throw e0.a(r8, (e) r9);
    L23:
        return g2.h(r7);
    L28:
        return kotlin.k0.i.b.c();
    L5:
        th = move-exception;
        r6 = new y(th, false, 2, null);
        goto L8
    }

    public static final <T, R> Object c(d0<? super T> r3, R r4, p<? super R, ? super d<? super T>, ? extends Object> r5) {
        boolean r0 = false;
        kotlin.n0.d.j0.e(r5, 2);     // Catch: Throwable -> L5
        Object r6 = r5.invoke(r4, r3);     // Catch: Throwable -> L5
    L8:
        if (r6 == kotlin.k0.i.b.c()) goto L46;
        Object r7 = r3.o0(r6);
        if (r7 == g2.f17440b) goto L46;
        if ((r7 instanceof y) == false) goto L37;
        Throwable r8 = ((y) r7).f17588a;
        if ((r8 instanceof w2) == true) goto L18;
    L19:
        r0 = true;
    L20:
        if (r0 == false) goto L29;
        d<? super T> r9 = r3.f17362h;
        if (q0.d() == true) goto L24;
        throw r8;
    L24:
        if ((r9 instanceof e) == true) goto L27;
        throw r8;
    L27:
        throw e0.a(r8, (e) r9);
    L29:
        if ((r6 instanceof y) == false) goto L39;
        Throwable r10 = ((y) r6).f17588a;
        d<? super T> r11 = r3.f17362h;
        if (q0.d() == true) goto L33;
        throw r10;
    L33:
        if ((r11 instanceof e) == true) goto L36;
        throw r10;
    L36:
        throw e0.a(r10, (e) r11);
    L39:
        return r6;
    L18:
        if (((w2) r8).f17577f == r3) goto L20;
    L37:
        r6 = g2.h(r7);
    L46:
        return kotlin.k0.i.b.c();
    L5:
        th = move-exception;
        r6 = new y(th, false, 2, null);
        goto L8
    }
}
