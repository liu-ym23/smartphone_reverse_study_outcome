package androidx.core.os;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class HandlerKt$postAtTime$runnable$1 implements Runnable {
    final /* synthetic */ Function0 $action;

    public HandlerKt$postAtTime$runnable$1(Function0 r1) {
        this.$action = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$action.invoke();
    }
}
