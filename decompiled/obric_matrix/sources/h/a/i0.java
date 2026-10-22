package h.a;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"handlers", "", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleCoroutineExceptionImpl", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<h0> f17457a = null;

    static {
        f17457a = kotlin.t0.k.z(kotlin.t0.k.c(defpackage.a.a()));
    }

    public static final void a(kotlin.k0.g r4, Throwable r5) {
        Iterator<h0> r0 = f17457a.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        r0.next().handleException(r4, r5);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Thread r2 = Thread.currentThread();
        r2.getUncaughtExceptionHandler().uncaughtException(r2, j0.b(r5, th));
        goto L4
    L10:
        Thread r1 = Thread.currentThread();
        kotlin.v.a r3 = kotlin.v.f21457g;     // Catch: Throwable -> L13
        kotlin.a.a(r5, new w0(r4));     // Catch: Throwable -> L13
        kotlin.v.b(kotlin.f0.f18324a);     // Catch: Throwable -> L13
    L15:
        r1.getUncaughtExceptionHandler().uncaughtException(r1, r5);
        return;
    L13:
        th = move-exception;
        kotlin.v.a r6 = kotlin.v.f21457g;
        kotlin.v.b(kotlin.w.a(th));
        goto L15
    }
}
