package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class MatchGroup {
    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof MatchGroup) == true) goto L8;
        return false;
    L8:
        MatchGroup r5 = (MatchGroup) r4;
        r5.getClass();
        if (Intrinsics.a(null, null) == true) goto L11;
        return false;
    L11:
        r5.getClass();
        if (Intrinsics.a(null, null) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "MatchGroup(value=null, range=null)";
    }
}
