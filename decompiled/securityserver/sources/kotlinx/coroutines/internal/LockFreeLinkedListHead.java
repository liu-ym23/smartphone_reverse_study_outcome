package kotlinx.coroutines.internal;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class LockFreeLinkedListHead extends LockFreeLinkedListNode {
    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public final boolean F() {
        return false;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public final boolean G() {
        throw new IllegalStateException("head cannot be removed".toString());
    }
}
