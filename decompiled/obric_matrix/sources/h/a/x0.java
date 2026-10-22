package h.a;

import com.bytedance.common.wschannel.WsConstants;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0015B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0012¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/DispatchedCoroutine;", "T", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "", WsConstants.KEY_CONNECTION_STATE, "", "afterCompletion", "(Ljava/lang/Object;)V", "afterResume", "getResult", "()Ljava/lang/Object;", "", "tryResume", "()Z", "trySuspend", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/ScopeCoroutine;"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class x0<T> extends h.a.f3.d0<T> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f17583i = null;
    private volatile /* synthetic */ int _decision;

    static {
        f17583i = AtomicIntegerFieldUpdater.newUpdater(x0.class, "_decision");
    }

    public x0(kotlin.k0.g r1, kotlin.k0.d<? super T> r2) {
        super(r1, r2);
        this._decision = 0;
    }

    private final boolean R0() {
    L2:
        int r0 = this._decision;
        if (r0 != 0) goto L4;
        if (f17583i.compareAndSet(this, 0, 2) == false) goto L2;
        return true;
    L4:
        if (r0 != 1) goto L7;
        return false;
    L7:
        throw new IllegalStateException("Already resumed".toString());
    }

    private final boolean S0() {
    L2:
        int r0 = this._decision;
        if (r0 != 0) goto L5;
        if (f17583i.compareAndSet(this, 0, 1) == false) goto L2;
        return true;
    L5:
        if (r0 != 2) goto L8;
        return false;
    L8:
        throw new IllegalStateException("Already suspended".toString());
    }

    @Override // h.a.f3.d0, h.a.a
    protected void L0(Object r3) {
        if (R0() == false) goto L5;
        return;
    L5:
        h.a.f3.j.c(kotlin.k0.i.b.b(this.f17362h), c0.a(r3, this.f17362h), null, 2, null);
    }

    public final Object Q0() {
        if (S0() == true) goto L5;
        Object r1 = g2.h(c0());
        if ((r1 instanceof y) == true) goto L10;
        return r1;
    L10:
        throw ((y) r1).f17588a;
    L5:
        return kotlin.k0.i.b.c();
    }

    @Override // h.a.f3.d0, h.a.f2
    protected void w(Object r1) {
        L0(r1);
    }
}
