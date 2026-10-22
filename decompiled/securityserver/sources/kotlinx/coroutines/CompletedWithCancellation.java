package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CompletedWithCancellation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f365a;
    public final Function1 b;

    public CompletedWithCancellation(Object r1, Function1 r2) {
        this.f365a = r1;
        this.b = r2;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof CompletedWithCancellation) == false) goto L10;
        CompletedWithCancellation r4 = (CompletedWithCancellation) r3;
        Object r0 = r4.f365a;
        if (Intrinsics.a(this.f365a, r0) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.a(this.b, r4.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r0 = 0;
        Object r1 = this.f365a;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L6:
        int r3 = r2 * 31;
        Function1 r4 = this.b;
        if (r4 == null) goto L10;
        r0 = r4.hashCode();
    L10:
        return r3 + r0;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "CompletedWithCancellation(result=" + this.f365a + ", onCancellation=" + this.b + ")";
    }
}
