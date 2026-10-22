package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.builders.ListBuilder;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class StartedWhileSubscribed implements SharingStarted {
    public final boolean equals(Object r1) {
        if ((r1 instanceof StartedWhileSubscribed) == false) goto L5;
        StartedWhileSubscribed r2 = (StartedWhileSubscribed) r1;
        r2.getClass();
        r2.getClass();
        return true;
    L5:
        return false;
    }

    public final int hashCode() {
        Long r2 = 0L;
        int r0 = r2.hashCode() * 31;
        return r2.hashCode() + r0;
    }

    public final String toString() {
        ListBuilder r7 = new ListBuilder(new Object[2], 0, 0, false, null, null);
        r7.add("replayExpiration=0ms");
        if (r7.i != null) goto L7;
        r7.e();
        r7.f = true;
        return "SharingStarted.WhileSubscribed(" + CollectionsKt.i(r7, null, null, null, null, 63) + ')';
    L7:
        throw new IllegalStateException();
    }
}
