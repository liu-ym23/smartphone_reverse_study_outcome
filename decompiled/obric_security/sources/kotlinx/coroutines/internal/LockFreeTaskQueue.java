package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.PerfConsts;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: compiled from: LockFreeTaskQueue.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012\"\u0004\b\u0001\u0010\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000eR\u0011\u0010\u001b\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "", ExifInterface.LONGITUDE_EAST, "", "singleConsumer", "<init>", "(Z)V", "element", "addLast", "(Ljava/lang/Object;)Z", "", "close", "()V", "isClosed", "()Z", "R", "Lkotlin/Function1;", "transform", "", "map", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "removeFirstOrNull", "()Ljava/lang/Object;", "isEmpty", "", "getSize", "()I", PerfConsts.PERF_DISK_FILE_SIZE, "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class LockFreeTaskQueue<E> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater _cur$FU = null;
    private volatile /* synthetic */ Object _cur;

    static {
        _cur$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueue.class, Object.class, "_cur");
    }

    public LockFreeTaskQueue(boolean r3) {
        this._cur = new LockFreeTaskQueueCore(8, r3);
    }

    public final boolean isEmpty() {
        return ((LockFreeTaskQueueCore) this._cur).isEmpty();
    }

    public final int getSize() {
        return ((LockFreeTaskQueueCore) this._cur).getSize();
    }

    public final <R> List<R> map(Function1<? super E, ? extends R> r1) {
        return ((LockFreeTaskQueueCore) this._cur).map(r1);
    }

    public final boolean isClosed() {
        return ((LockFreeTaskQueueCore) this._cur).isClosed();
    }

    public final void close() {
    L2:
        LockFreeTaskQueueCore r0 = (LockFreeTaskQueueCore) this._cur;
        if (r0.close() == true) goto L4;
        b0$$ExternalSyntheticBackport0.m(_cur$FU, this, r0, r0.next());
        goto L2
    }

    public final boolean addLast(E r4) {
    L2:
        LockFreeTaskQueueCore r0 = (LockFreeTaskQueueCore) this._cur;
        int r1 = r0.addLast(r4);
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L6;
        b0$$ExternalSyntheticBackport0.m(_cur$FU, this, r0, r0.next());
        goto L2
    L6:
        if (r1 != 2) goto L2;
        return false;
    L11:
        return true;
    }

    public final E removeFirstOrNull() {
    L2:
        LockFreeTaskQueueCore r0 = (LockFreeTaskQueueCore) this._cur;
        E r1 = (E) r0.removeFirstOrNull();
        if (r1 != LockFreeTaskQueueCore.REMOVE_FROZEN) goto L4;
        b0$$ExternalSyntheticBackport0.m(_cur$FU, this, r0, r0.next());
        goto L2
    L4:
        return r1;
    }
}
