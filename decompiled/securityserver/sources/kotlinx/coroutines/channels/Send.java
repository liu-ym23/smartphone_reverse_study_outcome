package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class Send extends LockFreeLinkedListNode {
    public abstract void K();

    public abstract Object L();

    public abstract void M(Closed r1);

    public abstract Symbol N(LockFreeLinkedListNode.PrepareOp r1);

    public void O() {
    }
}
