package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Pair<A, B> implements Serializable {
    public final Object b;
    public final Object c;

    public Pair(Object r1, Object r2) {
        this.b = r1;
        this.c = r2;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Pair) == true) goto L8;
        return false;
    L8:
        Pair r6 = (Pair) r5;
        Object r1 = r6.b;
        if (Intrinsics.a(this.b, r1) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.a(this.c, r6.c) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = 0;
        Object r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Object r4 = this.c;
        if (r4 == null) goto L11;
        r0 = r4.hashCode();
    L11:
        return r3 + r0;
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "(" + this.b + ", " + this.c + ')';
    }
}
