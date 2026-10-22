package androidx.lifecycle;

import h.a.b1;
import h.a.s2;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"coroutineScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "Landroidx/lifecycle/Lifecycle;", "getCoroutineScope", "(Landroidx/lifecycle/Lifecycle;)Landroidx/lifecycle/LifecycleCoroutineScope;", "lifecycle-runtime-ktx_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class LifecycleKt {
    public static final LifecycleCoroutineScope getCoroutineScope(Lifecycle r4) {
        o.f(r4, "<this>");
    L3:
        LifecycleCoroutineScopeImpl r0 = (LifecycleCoroutineScopeImpl) r4.mInternalScopeRef.get();
        if (r0 != null) goto L5;
        LifecycleCoroutineScopeImpl r1 = new LifecycleCoroutineScopeImpl(r4, s2.b(null, 1, null).plus(b1.c().h0()));
        if (r4.mInternalScopeRef.compareAndSet(null, r1) == false) goto L3;
        r1.register();
        return r1;
    L5:
        return r0;
    }
}
