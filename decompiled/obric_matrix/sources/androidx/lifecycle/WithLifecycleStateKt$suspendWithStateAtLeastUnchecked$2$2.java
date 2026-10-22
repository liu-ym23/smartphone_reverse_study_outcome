package androidx.lifecycle;

import h.a.g0;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.k0.h;
import kotlin.n0.c.l;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "R", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2 extends q implements l<Throwable, f0> {
    final /* synthetic */ g0 $lifecycleDispatcher;
    final /* synthetic */ WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 $observer;
    final /* synthetic */ Lifecycle $this_suspendWithStateAtLeastUnchecked;

    WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2(g0 r1, Lifecycle r2, WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 r3) {
        this.$lifecycleDispatcher = r1;
        this.$this_suspendWithStateAtLeastUnchecked = r2;
        this.$observer = r3;
        super(1);
    }

    @Override // kotlin.n0.c.l
    public /* bridge */ /* synthetic */ f0 invoke(Throwable r1) {
        invoke2(r1);
        return f0.f18324a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable r4) {
        g0 r5 = this.$lifecycleDispatcher;
        h r0 = h.f18399f;
        if (r5.isDispatchNeeded(r0) == false) goto L5;
        g0 r6 = this.$lifecycleDispatcher;
        final Lifecycle r2 = this.$this_suspendWithStateAtLeastUnchecked;
        final WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 r3 = this.$observer;
        r6.dispatch(r0, new AnonymousClass1(r2, r3));
        return;
    L5:
        this.$this_suspendWithStateAtLeastUnchecked.removeObserver(this.$observer);
    }
}
