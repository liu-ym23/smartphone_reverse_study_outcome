package h.a.g3;

import h.a.f3.j;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.k0.d;
import kotlin.n0.c.l;
import kotlin.n0.c.p;
import kotlin.v;
import kotlin.w;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001c\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a#\u0010\u0006\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0082\b\u001a\u001e\u0010\t\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00032\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0000\u001a>\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u000b*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0003H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001ay\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u000b*\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00102\u0006\u0010\u0011\u001a\u0002H\u000f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00032%\b\u0002\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"dispatcherFailure", "", "completion", "Lkotlin/coroutines/Continuation;", "e", "", "runSafely", "block", "Lkotlin/Function0;", "startCoroutineCancellable", "fatalCompletion", "T", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "onCancellation", "Lkotlin/ParameterName;", "name", "cause", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class a {
    private static final void a(d<?> r1, Throwable r2) {
        v.a r0 = v.f21457g;
        Object r3 = w.a(r2);
        v.b(r3);
        r1.resumeWith(r3);
        throw r2;
    }

    public static final void b(d<? super f0> r3, d<?> r4) {
        d r5 = kotlin.k0.i.b.b(r3);     // Catch: Throwable -> L5
        v.a r1 = v.f21457g;     // Catch: Throwable -> L5
        f0 r2 = f0.f18324a;     // Catch: Throwable -> L5
        v.b(r2);     // Catch: Throwable -> L5
        j.c(r5, r2, null, 2, null);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        a(r4, th);
        throw null;
    }

    public static final <R, T> void c(p<? super R, ? super d<? super T>, ? extends Object> r0, R r1, d<? super T> r2, l<? super Throwable, f0> r3) {
        d r4 = kotlin.k0.i.b.b(kotlin.k0.i.b.a(r0, r1, r2));     // Catch: Throwable -> L4
        v.a r5 = v.f21457g;     // Catch: Throwable -> L4
        f0 r6 = f0.f18324a;     // Catch: Throwable -> L4
        v.b(r6);     // Catch: Throwable -> L4
        j.b(r4, r6, r3);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        a(r2, th);
        throw null;
    }

    public static /* synthetic */ void d(p r0, Object r1, d r2, l r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        c(r0, r1, r2, r3);
    }
}
