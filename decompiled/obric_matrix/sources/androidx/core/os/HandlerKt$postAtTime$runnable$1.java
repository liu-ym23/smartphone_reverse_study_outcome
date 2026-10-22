package androidx.core.os;

import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.a;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 7, 1}, xi = 176)
public final class HandlerKt$postAtTime$runnable$1 implements Runnable {
    final /* synthetic */ a<f0> $action;

    public HandlerKt$postAtTime$runnable$1(a<f0> r1) {
        this.$action = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$action.invoke();
    }
}
