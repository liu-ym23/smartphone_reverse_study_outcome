package androidx.activity.contextaware;

import android.content.Context;
import h.a.n;
import kotlin.Metadata;
import kotlin.k0.d;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.v;
import kotlin.w;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"androidx/activity/contextaware/ContextAwareKt$withContextAvailable$2$listener$1", "Landroidx/activity/contextaware/OnContextAvailableListener;", "onContextAvailable", "", "context", "Landroid/content/Context;", "activity-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 176)
public final class ContextAwareKt$withContextAvailable$2$listener$1 implements OnContextAvailableListener {
    final /* synthetic */ n<R> $co;
    final /* synthetic */ l<Context, R> $onContextAvailable;

    /* JADX WARN: Multi-variable type inference failed */
    public ContextAwareKt$withContextAvailable$2$listener$1(n<? super R> r1, l<? super Context, ? extends R> r2) {
        this.$co = r1;
        this.$onContextAvailable = r2;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public void onContextAvailable(Context r3) {
        o.f(r3, "context");
        d r0 = this.$co;
        l<Context, R> r2 = this.$onContextAvailable;
        v.a r1 = v.f21457g;     // Catch: Throwable -> L5
        Object r4 = r2.invoke(r3);     // Catch: Throwable -> L5
        v.b(r4);     // Catch: Throwable -> L5
    L7:
        r0.resumeWith(r4);
        return;
    L5:
        th = move-exception;
        v.a r5 = v.f21457g;
        r4 = w.a(th);
        v.b(r4);
        goto L7
    }
}
