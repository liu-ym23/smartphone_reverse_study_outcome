package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface ReceiveOrClosed<E> {
    Object f();

    void o(Object r1);

    Symbol r(Object r1, LockFreeLinkedListNode.PrepareOp r2);
}
