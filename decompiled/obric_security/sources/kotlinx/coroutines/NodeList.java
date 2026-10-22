package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\r\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/NodeList;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/Incomplete;", "()V", "isActive", "", "()Z", "list", "getList", "()Lkotlinx/coroutines/NodeList;", "getString", "", "state", "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NodeList extends LockFreeLinkedListHead implements Incomplete {
    @Override // kotlinx.coroutines.Incomplete
    public NodeList getList() {
        return this;
    }

    @Override // kotlinx.coroutines.Incomplete
    public boolean isActive() {
        return true;
    }

    public NodeList() {
    }

    public final String getString(String r5) {
        StringBuilder r0 = new StringBuilder("List{");
        r0.append(r5);
        r0.append("}[");
        NodeList r4 = this;
        LockFreeLinkedListNode r6 = (LockFreeLinkedListNode) r4.getNext();
        boolean r1 = true;
    L4:
        if (Intrinsics.areEqual(r6, r4) == true) goto L13;
        if ((r6 instanceof JobNode) == false) goto L12;
        JobNode r2 = (JobNode) r6;
        if (r1 == false) goto L10;
        r1 = false;
    L11:
        r0.append(r2);
        goto L12
    L10:
        r0.append(", ");
    L12:
        r6 = r6.getNextNode();
        goto L4
    L13:
        r0.append("]");
        String r7 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r7, "StringBuilder().apply(builderAction).toString()");
        return r7;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        if (DebugKt.getDEBUG() == false) goto L6;
        return getString("Active");
    L6:
        return super.toString();
    }
}
