package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class ConcurrentLinkedListNode<N extends ConcurrentLinkedListNode<N>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f410a = null;
    public static final AtomicReferenceFieldUpdater b = null;
    private volatile Object _next;
    private volatile Object _prev;

    static {
        f410a = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_next");
        b = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_prev");
    }

    public ConcurrentLinkedListNode(ConcurrentLinkedListNode r2) {
        this._next = null;
        this._prev = r2;
    }

    public static final Object a(Segment r0) {
        return ((ConcurrentLinkedListNode) r0)._next;
    }

    public abstract boolean b();

    public final boolean c() {
        Object r1 = this._next;
        if (r1 != ConcurrentLinkedListKt.f409a) goto L5;
        ConcurrentLinkedListNode r2 = null;
    L6:
        if (r2 != null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r2 = (ConcurrentLinkedListNode) r1;
        goto L6
    }

    public final void d() {
        boolean r0 = DebugKt.f370a;
    L3:
        ConcurrentLinkedListNode r1 = (ConcurrentLinkedListNode) this._prev;
    L4:
        if (r1 == null) goto L8;
        if (r1.b() == false) goto L8;
        r1 = (ConcurrentLinkedListNode) r1._prev;
    L8:
        boolean r2 = DebugKt.f370a;
        Object r3 = this._next;
        Symbol r4 = ConcurrentLinkedListKt.f409a;
        if (r3 != r4) goto L11;
        ConcurrentLinkedListNode r5 = null;
    L12:
        Intrinsics.c(r5);
    L14:
        if (r5.b() == false) goto L20;
        Object r6 = r5._next;
        if (r6 != r4) goto L18;
        r5 = null;
    L19:
        Intrinsics.c(r5);
        goto L14
    L18:
        r5 = (ConcurrentLinkedListNode) r6;
        goto L19
    L20:
        r5._prev = r1;
        if (r1 == null) goto L24;
        r1._next = r5;
    L24:
        if (r5.b() == true) goto L3;
        if (r1 == null) goto L30;
        if (r1.b() == true) goto L3;
        return;
    L30:
        return;
    L11:
        r5 = (ConcurrentLinkedListNode) r3;
        goto L12
    }
}
