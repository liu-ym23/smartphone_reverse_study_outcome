package ss;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f22004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f22005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f22006c;

    public a(float r5, float r10) {
        this.f22004a = r5;
        this.f22005b = r10;
        this.f22006c = (int) r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r10 = (a) r5;
        if (Intrinsics.areEqual(Float.valueOf(this.f22004a), Float.valueOf(r10.f22004a)) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(Float.valueOf(this.f22005b), Float.valueOf(r10.f22005b)) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = Float.hashCode(this.f22004a) * 31;
        return Float.hashCode(this.f22005b) + r5;
    }

    public final String toString() {
        return "AvailableWindowSize(width=" + this.f22004a + ", height=" + this.f22005b + ')';
    }
}
