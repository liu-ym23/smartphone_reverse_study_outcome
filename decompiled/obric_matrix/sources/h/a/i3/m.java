package h.a.i3;

import h.a.g0;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0016J\u001c\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0017¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/scheduling/UnlimitedIoScheduler;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatchYield", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class m extends g0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final m f17508f = null;

    static {
        f17508f = new m();
    }

    private m() {
    }

    @Override // h.a.g0
    public void dispatch(kotlin.k0.g r2, Runnable r3) {
        c.f17490k.i0(r3, l.f17507g, false);
    }

    @Override // h.a.g0
    public void dispatchYield(kotlin.k0.g r2, Runnable r3) {
        c.f17490k.i0(r3, l.f17507g, true);
    }
}
