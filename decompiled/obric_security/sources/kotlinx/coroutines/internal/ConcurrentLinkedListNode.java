package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: compiled from: ConcurrentLinkedList.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\t\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u00020\u001aB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ \u0010\u000e\u001a\u0004\u0018\u00018\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0086\b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0007J\u0015\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\nR\u0016\u0010\u0017\u001a\u0004\u0018\u00018\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0019\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0002\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0016R\u0014\u0010 \u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\nR\u0014\u0010\"\u001a\u00028\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0016¨\u0006#"}, d2 = {"Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "N", "prev", "<init>", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)V", "", "cleanPrev", "()V", "", "markAsClosed", "()Z", "Lkotlin/Function0;", "", "onClosedAction", "nextOrIfClosed", "(Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "remove", "value", "trySetNext", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Z", "isTail", "getLeftmostAliveNode", "()Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "leftmostAliveNode", "getNext", "next", "", "getNextOrClosed", "()Ljava/lang/Object;", "nextOrClosed", "getPrev", "getRemoved", "removed", "getRightmostAliveNode", "rightmostAliveNode", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ConcurrentLinkedListNode<N extends ConcurrentLinkedListNode<N>> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater _next$FU = null;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _prev$FU = null;
    private volatile /* synthetic */ Object _next;
    private volatile /* synthetic */ Object _prev;

    static {
        _next$FU = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_next");
        _prev$FU = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_prev");
    }

    public abstract boolean getRemoved();

    public ConcurrentLinkedListNode(N r2) {
        this._next = null;
        this._prev = r2;
    }

    public static final /* synthetic */ Object access$getNextOrClosed(ConcurrentLinkedListNode r0) {
        return r0.getNextOrClosed();
    }

    private final Object getNextOrClosed() {
        return this._next;
    }

    public final N nextOrIfClosed(Function0 r2) {
        Object r1 = access$getNextOrClosed(this);
        if (r1 != ConcurrentLinkedListKt.access$getCLOSED$p()) goto L5;
        r2.invoke();
        throw new KotlinNothingValueException();
    L5:
        return (N) r1;
    }

    public final boolean trySetNext(N r3) {
        return b0$$ExternalSyntheticBackport0.m(_next$FU, this, null, r3);
    }

    public final boolean isTail() {
        if (getNext() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public final N getPrev() {
        return (N) this._prev;
    }

    public final void cleanPrev() {
        _prev$FU.lazySet(this, null);
    }

    public final boolean markAsClosed() {
        return b0$$ExternalSyntheticBackport0.m(_next$FU, this, null, ConcurrentLinkedListKt.access$getCLOSED$p());
    }

    public final void remove() {
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L10;
        if (getRemoved() == true) goto L10;
        throw new AssertionError();
    L10:
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L16;
        if ((!isTail()) == true) goto L16;
        throw new AssertionError();
    L16:
        ConcurrentLinkedListNode r0 = getLeftmostAliveNode();
        ConcurrentLinkedListNode r1 = getRightmostAliveNode();
        r1._prev = r0;
        if (r0 == null) goto L20;
        r0._next = r1;
    L20:
        if (r1.getRemoved() == true) goto L16;
        if (r0 == null) goto L24;
        if (r0.getRemoved() == true) goto L16;
        return;
    }

    private final N getLeftmostAliveNode() {
        N r1 = (N) getPrev();
    L3:
        if (r1 == null) goto L7;
        if (r1.getRemoved() == false) goto L7;
        r1 = (N) r1._prev;
    L7:
        return r1;
    }

    private final N getRightmostAliveNode() {
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L5;
    L9:
        N r1 = (N) getNext();
        Intrinsics.checkNotNull(r1);
    L11:
        if (r1.getRemoved() == false) goto L13;
        r1 = (N) r1.getNext();
        Intrinsics.checkNotNull(r1);
        goto L11
    L13:
        return r1;
    L5:
        if ((!isTail()) == true) goto L9;
        throw new AssertionError();
    }

    public final N getNext() {
        Object r1 = access$getNextOrClosed(this);
        if (r1 != ConcurrentLinkedListKt.access$getCLOSED$p()) goto L7;
        return null;
    L7:
        return (N) r1;
    }
}
