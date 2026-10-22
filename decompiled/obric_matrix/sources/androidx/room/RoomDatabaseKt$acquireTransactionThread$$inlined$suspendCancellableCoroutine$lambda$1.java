package androidx.room;

import h.a.x1;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "it", "Lkotlin/f0;", "invoke", "(Ljava/lang/Throwable;)V", "androidx/room/RoomDatabaseKt$acquireTransactionThread$2$1", "<anonymous>"}, k = 3, mv = {1, 1, 15})
final class RoomDatabaseKt$acquireTransactionThread$$inlined$suspendCancellableCoroutine$lambda$1 extends q implements l<Throwable, f0> {
    final /* synthetic */ x1 $controlJob$inlined;
    final /* synthetic */ Executor $this_acquireTransactionThread$inlined;

    RoomDatabaseKt$acquireTransactionThread$$inlined$suspendCancellableCoroutine$lambda$1(Executor r1, x1 r2) {
        this.$this_acquireTransactionThread$inlined = r1;
        this.$controlJob$inlined = r2;
        super(1);
    }

    @Override // kotlin.n0.c.l
    public /* bridge */ /* synthetic */ f0 invoke(Throwable r1) {
        invoke2(r1);
        return f0.f18324a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable r2) {
        x1.a.a(this.$controlJob$inlined, null, 1, null);
    }
}
