package zr;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f23579a;

    public a(Map r5) {
        Intrinsics.checkNotNullParameter(r5, "selections");
        this.f23579a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f23579a, ((a) r5).f23579a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f23579a.hashCode();
    }

    public final String toString() {
        return "PickedData(selections=" + this.f23579a + ')';
    }
}
