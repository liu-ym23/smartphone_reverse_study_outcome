package kotlinx.coroutines;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class InactiveNodeList implements Incomplete {
    public final NodeList b;

    public InactiveNodeList(NodeList r1) {
        this.b = r1;
    }

    @Override // kotlinx.coroutines.Incomplete
    public final boolean isActive() {
        return false;
    }

    @Override // kotlinx.coroutines.Incomplete
    public final NodeList j() {
        return this.b;
    }

    public final String toString() {
        if (DebugKt.f370a == false) goto L6;
        return this.b.K("New");
    L6:
        return super.toString();
    }
}
