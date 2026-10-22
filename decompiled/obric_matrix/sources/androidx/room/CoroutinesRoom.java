package androidx.room;

import androidx.annotation.RestrictTo;
import h.a.e3.e;
import h.a.h;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.k0.d;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/room/CoroutinesRoom;", "", "<init>", "()V", "Companion", "room-ktx_release"}, k = 1, mv = {1, 1, 15})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class CoroutinesRoom {
    public static final Companion Companion = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J7\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0087@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJG\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Landroidx/room/CoroutinesRoom$Companion;", "", "R", "Landroidx/room/RoomDatabase;", "db", "", "inTransaction", "Ljava/util/concurrent/Callable;", "callable", "execute", "(Landroidx/room/RoomDatabase;ZLjava/util/concurrent/Callable;Lkotlin/k0/d;)Ljava/lang/Object;", "", "", "tableNames", "Lh/a/e3/e;", "createFlow", "(Landroidx/room/RoomDatabase;Z[Ljava/lang/String;Ljava/util/concurrent/Callable;)Lh/a/e3/e;", "<init>", "()V", "room-ktx_release"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g r1) {
            this();
        }

        public final <R> e<R> createFlow(RoomDatabase r7, boolean r8, String[] r9, Callable<R> r10) {
            o.g(r7, "db");
            o.g(r9, "tableNames");
            o.g(r10, "callable");
            return h.a.e3.g.g(new CoroutinesRoom$Companion$createFlow$1(r9, r8, r7, r10, null));
        }

        public final <R> Object execute(RoomDatabase r2, boolean r3, Callable<R> r4, d<? super R> r5) {
            if (r2.isOpen() == true) goto L5;
        L8:
            TransactionElement r1 = (TransactionElement) r5.getContext().get(TransactionElement.Key);
            if (r1 == null) goto L13;
            kotlin.k0.e r6 = r1.getTransactionDispatcher$room_ktx_release();
            if (r6 == null) goto L13;
        L17:
            return h.e(r6, new CoroutinesRoom$Companion$execute$2(r4, null), r5);
        L13:
            if (r3 == false) goto L15;
            r6 = CoroutinesRoomKt.getTransactionDispatcher(r2);
            goto L17
        L15:
            r6 = CoroutinesRoomKt.getQueryDispatcher(r2);
            goto L17
        L5:
            if (r2.inTransaction() == false) goto L8;
            return r4.call();
        }
    }

    static {
        Companion = new Companion(null);
    }

    private CoroutinesRoom() {
    }

    public static final <R> e<R> createFlow(RoomDatabase r1, boolean r2, String[] r3, Callable<R> r4) {
        return Companion.createFlow(r1, r2, r3, r4);
    }

    public static final <R> Object execute(RoomDatabase r1, boolean r2, Callable<R> r3, d<? super R> r4) {
        return Companion.execute(r1, r2, r3, r4);
    }
}
