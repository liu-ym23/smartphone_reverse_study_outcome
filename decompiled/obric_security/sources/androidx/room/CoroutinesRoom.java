package androidx.room;

import android.os.CancellationSignal;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: CoroutinesRoom.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/room/CoroutinesRoom;", "", "()V", "Companion", "room-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CoroutinesRoom {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: CoroutinesRoom.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JJ\u0010\u0003\u001a\r\u0012\t\u0012\u0007H\u0005¢\u0006\u0002\b\u00060\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000fH\u0007¢\u0006\u0002\u0010\u0010J=\u0010\u0011\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000fH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J5\u0010\u0011\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000fH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Landroidx/room/CoroutinesRoom$Companion;", "", "()V", "createFlow", "Lkotlinx/coroutines/flow/Flow;", "R", "Lkotlin/jvm/JvmSuppressWildcards;", CloudControlInf.DB, "Landroidx/room/RoomDatabase;", "inTransaction", "", "tableNames", "", "", "callable", "Ljava/util/concurrent/Callable;", "(Landroidx/room/RoomDatabase;Z[Ljava/lang/String;Ljava/util/concurrent/Callable;)Lkotlinx/coroutines/flow/Flow;", "execute", "cancellationSignal", "Landroid/os/CancellationSignal;", "(Landroidx/room/RoomDatabase;ZLandroid/os/CancellationSignal;Ljava/util/concurrent/Callable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroidx/room/RoomDatabase;ZLjava/util/concurrent/Callable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "room-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final <R> Object execute(RoomDatabase r2, boolean r3, Callable<R> r4, Continuation<? super R> r5) {
            if (r2.isOpen() == true) goto L5;
        L8:
            TransactionElement r1 = (TransactionElement) r5.getContext().get(TransactionElement.Key);
            if (r1 == null) goto L12;
            CoroutineDispatcher r6 = r1.getTransactionDispatcher$room_ktx_release();
            if (r6 == null) goto L12;
        L17:
            return BuildersKt.withContext(r6, new CoroutinesRoom$Companion$execute$2(r4, null), r5);
        L12:
            if (r3 == false) goto L14;
            CoroutineDispatcher r7 = CoroutinesRoomKt.getTransactionDispatcher(r2);
        L15:
            r6 = r7;
            goto L17
        L14:
            r7 = CoroutinesRoomKt.getQueryDispatcher(r2);
            goto L15
        L5:
            if (r2.inTransaction() == false) goto L8;
            return r4.call();
        }

        @JvmStatic
        public final <R> Object execute(RoomDatabase r8, boolean r9, final CancellationSignal r10, Callable<R> r11, Continuation<? super R> r12) {
            if (r8.isOpen() == true) goto L5;
        L8:
            TransactionElement r7 = (TransactionElement) r12.getContext().get(TransactionElement.Key);
            if (r7 == null) goto L12;
            CoroutineDispatcher r13 = r7.getTransactionDispatcher$room_ktx_release();
            if (r13 == null) goto L12;
        L16:
            CancellableContinuationImpl r14 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r12), 1);
            r14.initCancellability();
            CancellableContinuationImpl r15 = r14;
            final Job r16 = BuildersKt.launch$default(GlobalScope.INSTANCE, r13, null, new CoroutinesRoom$Companion$execute$4$job$1(r11, r15, null), 2, null);
            r15.invokeOnCancellation(new CoroutinesRoom$Companion$execute$4$1(r10, r16));
            Object r17 = r14.getResult();
            if (r17 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
            DebugProbesKt.probeCoroutineSuspended(r12);
        L19:
            return r17;
        L12:
            if (r9 == false) goto L14;
            CoroutineDispatcher r18 = CoroutinesRoomKt.getTransactionDispatcher(r8);
        L15:
            r13 = r18;
            goto L16
        L14:
            r18 = CoroutinesRoomKt.getQueryDispatcher(r8);
            goto L15
        L5:
            if (r8.inTransaction() == false) goto L8;
            return r11.call();
        }

        @JvmStatic
        public final <R> Flow<R> createFlow(RoomDatabase r7, boolean r8, String[] r9, Callable<R> r10) {
            Intrinsics.checkNotNullParameter(r7, CloudControlInf.DB);
            Intrinsics.checkNotNullParameter(r9, "tableNames");
            Intrinsics.checkNotNullParameter(r10, "callable");
            return FlowKt.flow(new CoroutinesRoom$Companion$createFlow$1(r8, r7, r9, r10, null));
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final <R> Flow<R> createFlow(RoomDatabase r1, boolean r2, String[] r3, Callable<R> r4) {
        return Companion.createFlow(r1, r2, r3, r4);
    }

    @JvmStatic
    public static final <R> Object execute(RoomDatabase r6, boolean r7, CancellationSignal r8, Callable<R> r9, Continuation<? super R> r10) {
        return Companion.execute(r6, r7, r8, r9, r10);
    }

    @JvmStatic
    public static final <R> Object execute(RoomDatabase r1, boolean r2, Callable<R> r3, Continuation<? super R> r4) {
        return Companion.execute(r1, r2, r3, r4);
    }

    private CoroutinesRoom() {
    }
}
