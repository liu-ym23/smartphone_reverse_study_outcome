package h.a.f3;

import h.a.a3;
import h.a.h1;
import h.a.v2;
import h.a.x1;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a;\u0010\u0006\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0082\b\u001aU\u0010\u0011\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00152%\b\u0002\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a\u0012\u0010\u001d\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00100\bH\u0000\"\u0016\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"REUSABLE_CLAIMED", "Lkotlinx/coroutines/internal/Symbol;", "getREUSABLE_CLAIMED$annotations", "()V", "UNDEFINED", "getUNDEFINED$annotations", "executeUnconfined", "", "Lkotlinx/coroutines/internal/DispatchedContinuation;", "contState", "", "mode", "", "doYield", "block", "Lkotlin/Function0;", "", "resumeCancellableWith", "T", "Lkotlin/coroutines/Continuation;", "result", "Lkotlin/Result;", "onCancellation", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "yieldUndispatched", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final f0 f17375a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f0 f17376b = null;

    static {
        f17375a = new f0("UNDEFINED");
        f17376b = new f0("REUSABLE_CLAIMED");
    }

    public static final /* synthetic */ f0 a() {
        return f17375a;
    }

    public static final <T> void b(kotlin.k0.d<? super T> r6, Object r7, kotlin.n0.c.l<? super Throwable, kotlin.f0> r8) {
        if ((r6 instanceof i) == false) goto L43;
        i r9 = (i) r6;
        Object r10 = h.a.c0.b(r7, r8);
        if (r9.f17371i.isDispatchNeeded(r9.getContext()) == false) goto L7;
        r9.f17373k = r10;
        r9.f17589h = 1;
        r9.f17371i.dispatch(r9.getContext(), r9);
        return;
    L7:
        h.a.q0.a();
        h1 r0 = v2.f17573a.b();
        if (r0.o0() == false) goto L10;
        r9.f17373k = r10;
        r9.f17589h = 1;
        r0.k0(r9);
        return;
    L10:
        r0.m0(true);
        x1 r3 = (x1) r9.getContext().get(x1.f17584d);     // Catch: Throwable -> L37
        if (r3 != null) goto L14;
    L16:
        boolean r11 = false;
    L17:
        if (r11 == true) goto L35;
        kotlin.k0.d<T> r12 = r9.f17372j;     // Catch: Throwable -> L37
        Object r4 = r9.f17374l;     // Catch: Throwable -> L37
        kotlin.k0.g r5 = r12.getContext();     // Catch: Throwable -> L37
        Object r13 = j0.c(r5, r4);     // Catch: Throwable -> L37
        if (r13 == j0.f17377a) goto L22;
        a3<?> r14 = h.a.f0.g(r12, r5, r13);     // Catch: Throwable -> L37
    L47:
        r9.f17372j.resumeWith(r7);     // Catch: Throwable -> L28
        kotlin.f0 r15 = kotlin.f0.f18324a;     // Catch: Throwable -> L28
        if (r14 != null) goto L26;
    L27:
        j0.a(r5, r13);     // Catch: Throwable -> L37
        goto L35
    L26:
        if (r14.Q0() == false) goto L35;
    L28:
        th = move-exception;
        if (r14 != null) goto L31;
    L32:
        j0.a(r5, r13);     // Catch: Throwable -> L37
    L33:
        throw th;     // Catch: Throwable -> L37
    L31:
        if (r14.Q0() == false) goto L33;
    L22:
        r14 = null;
    L35:
        if (r0.r0() == true) goto L35;
    L39:
        r0.h0(true);
        return;
    L14:
        if (r3.b() == true) goto L16;
        CancellationException r16 = r3.A();     // Catch: Throwable -> L37
        r9.a(r10, r16);     // Catch: Throwable -> L37
        kotlin.v.a r17 = kotlin.v.f21457g;     // Catch: Throwable -> L37
        Object r18 = kotlin.w.a(r16);     // Catch: Throwable -> L37
        kotlin.v.b(r18);     // Catch: Throwable -> L37
        r9.resumeWith(r18);     // Catch: Throwable -> L37
        r11 = true;
    L37:
        th = move-exception;
        r9.f(th, null);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        r0.h0(true);
        throw th;
    L43:
        r6.resumeWith(r7);
    }

    public static /* synthetic */ void c(kotlin.k0.d r0, Object r1, kotlin.n0.c.l r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        b(r0, r1, r2);
    }
}
