package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Triple<A, B, C> implements Serializable {
    public final Object b;
    public final Object c;
    public final Object e;

    public Triple(Integer r1, Boolean r2, Boolean r3) {
        this.b = r1;
        this.c = r2;
        this.e = r3;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Triple) == true) goto L8;
        return false;
    L8:
        Triple r6 = (Triple) r5;
        Object r1 = r6.b;
        if (Intrinsics.a(this.b, r1) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.a(this.c, r6.c) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.a(this.e, r6.e) == true) goto L17;
        return false;
    L17:
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
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Object r7 = this.e;
        if (r7 == null) goto L15;
        r0 = r7.hashCode();
    L15:
        return r6 + r0;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "(" + this.b + ", " + this.c + ", " + this.e + ')';
    }
}
