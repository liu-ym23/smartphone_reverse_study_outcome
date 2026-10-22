package kotlin.io;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FilePathComponents {
    public final boolean equals(Object r3) {
        if (this != r3) goto L6;
        return true;
    L6:
        if ((r3 instanceof FilePathComponents) == true) goto L8;
        return false;
    L8:
        ((FilePathComponents) r3).getClass();
        if (Intrinsics.a(null, null) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.a(null, null) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "FilePathComponents(root=null, segments=null)";
    }
}
