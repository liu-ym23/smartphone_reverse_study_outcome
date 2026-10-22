package wu;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements a {
    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        ((b) r5).getClass();
        if (Intrinsics.areEqual("_root_", "_root_") == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // wu.a
    public final String getValue() {
        return "_root_";
    }

    public final int hashCode() {
        return -1466499394;
    }

    public final String toString() {
        return "_root_";
    }
}
