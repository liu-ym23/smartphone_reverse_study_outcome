package kotlinx.coroutines;

import a.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class NodeList extends LockFreeLinkedListHead implements Incomplete {
    public final String K(String r6) {
        StringBuilder r7 = a.u("List{", r6, "}[");
        Object r0 = z();
        if (r0 == null) goto L18;
        LockFreeLinkedListNode r1 = (LockFreeLinkedListNode) r0;
        boolean r2 = true;
    L6:
        if ((!r1.equals(this)) == false) goto L15;
        if ((r1 instanceof JobNode) == false) goto L14;
        JobNode r3 = (JobNode) r1;
        if (r2 == false) goto L12;
        r2 = false;
    L13:
        r7.append(r3);
        goto L14
    L12:
        r7.append(", ");
    L14:
        r1 = r1.A();
        goto L6
    L15:
        r7.append("]");
        String r5 = r7.toString();
        Intrinsics.e(r5, "StringBuilder().apply(builderAction).toString()");
        return r5;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    @Override // kotlinx.coroutines.Incomplete
    public final boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.Incomplete
    public final NodeList j() {
        return this;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public final String toString() {
        if (DebugKt.f370a == false) goto L6;
        return K("Active");
    L6:
        return super.toString();
    }
}
