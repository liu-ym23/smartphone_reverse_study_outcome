package androidx.room;

import h.a.g0;
import h.a.p1;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.b0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u001a\u0010\u0004\u001a\u00020\u0001*\u00020\u00008@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u001a\u0010\u0006\u001a\u00020\u0001*\u00020\u00008@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003¨\u0006\u0007"}, d2 = {"Landroidx/room/RoomDatabase;", "Lh/a/g0;", "getQueryDispatcher", "(Landroidx/room/RoomDatabase;)Lh/a/g0;", "queryDispatcher", "getTransactionDispatcher", "transactionDispatcher", "room-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class CoroutinesRoomKt {
    public static final g0 getQueryDispatcher(RoomDatabase r3) {
        o.g(r3, "$this$queryDispatcher");
        Map<String, Object> r0 = r3.getBackingFieldMap();
        o.b(r0, "backingFieldMap");
        Object r2 = r0.get("QueryDispatcher");
        if (r2 != null) goto L5;
        Executor r4 = r3.getQueryExecutor();
        o.b(r4, "queryExecutor");
        r2 = p1.a(r4);
        r0.put("QueryDispatcher", r2);
    L5:
        if (r2 == null) goto L9;
        return (g0) r2;
    L9:
        throw new b0("null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
    }

    public static final g0 getTransactionDispatcher(RoomDatabase r3) {
        o.g(r3, "$this$transactionDispatcher");
        Map<String, Object> r0 = r3.getBackingFieldMap();
        o.b(r0, "backingFieldMap");
        Object r2 = r0.get("TransactionDispatcher");
        if (r2 != null) goto L5;
        Executor r4 = r3.getTransactionExecutor();
        o.b(r4, "transactionExecutor");
        r2 = p1.a(r4);
        r0.put("TransactionDispatcher", r2);
    L5:
        if (r2 == null) goto L9;
        return (g0) r2;
    L9:
        throw new b0("null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
    }
}
