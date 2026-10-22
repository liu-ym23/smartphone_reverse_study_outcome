package u4;

import ko.r;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f22240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f22241b;

    public a(long r5, r r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        this.f22240a = r5;
        this.f22241b = r10;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object r5) {
        a r10 = (a) r5;
        Intrinsics.checkNotNullParameter(r10, "other");
        return ((int) r10.f22240a) - ((int) this.f22240a);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        long r5 = r11.f22240a;
        if (this.f22240a == r5) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f22241b, r11.f22241b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = Long.hashCode(this.f22240a) * 31;
        return this.f22241b.hashCode() + r5;
    }

    public final String toString() {
        return "SubPerf(cost=" + this.f22240a + ", data=" + this.f22241b + ')';
    }
}
