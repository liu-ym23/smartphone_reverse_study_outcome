package androidx.activity.contextaware;

import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "R", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
final class ContextAwareKt$withContextAvailable$2$1 extends q implements l<Throwable, f0> {
    final /* synthetic */ ContextAwareKt$withContextAvailable$2$listener$1 $listener;
    final /* synthetic */ ContextAware $this_withContextAvailable;

    public ContextAwareKt$withContextAvailable$2$1(ContextAware r1, ContextAwareKt$withContextAvailable$2$listener$1 r2) {
        this.$this_withContextAvailable = r1;
        this.$listener = r2;
        super(1);
    }

    @Override // kotlin.n0.c.l
    public /* bridge */ /* synthetic */ f0 invoke(Throwable r1) {
        invoke2(r1);
        return f0.f18324a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable r1) {
        this.$this_withContextAvailable.removeOnContextAvailableListener(this.$listener);
    }
}
