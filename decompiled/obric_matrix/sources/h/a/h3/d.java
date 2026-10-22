package h.a.h3;

import kotlin.Metadata;
import kotlin.k0.g;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014J\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/rx2/RxMaybeCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "subscriber", "Lio/reactivex/MaybeEmitter;", "(Lkotlin/coroutines/CoroutineContext;Lio/reactivex/MaybeEmitter;)V", "onCancelled", "", "cause", "", "handled", "", "onCompleted", "value", "(Ljava/lang/Object;)V", "kotlinx-coroutines-rx2"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class d<T> extends h.a.a<T> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final f.a.b<T> f17456h;

    public d(g r3, f.a.b<T> r4) {
        super(r3, false, true);
        this.f17456h = r4;
    }

    @Override // h.a.a
    protected void M0(Throwable r1, boolean r2) {
        if (this.f17456h.d(r1) == false) goto L7;
        return;
    L7:
        c.a(r1, getContext());
        return;
    L5:
        th = move-exception;
        kotlin.a.a(r1, th);
        goto L7
    }

    @Override // h.a.a
    protected void N0(T r2) {
        if (r2 != null) goto L4;
        this.f17456h.a();     // Catch: Throwable -> L6
    L9:
        return;
    L4:
        this.f17456h.b(r2);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        c.a(th, getContext());
    }
}
