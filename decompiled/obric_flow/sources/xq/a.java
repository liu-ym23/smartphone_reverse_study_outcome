package xq;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f23207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f23208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f23209c;
    public final int d;
    public final float e;

    public a(float r5, float r10, float r11, int r12, int r13) {
        this.f23207a = r5;
        this.f23208b = r12;
        this.f23209c = r10;
        this.d = r13;
        this.e = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r10 = (a) r5;
        if (Intrinsics.areEqual(Float.valueOf(this.f23207a), Float.valueOf(r10.f23207a)) == true) goto L12;
        return false;
    L12:
        if (this.f23208b == r10.f23208b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(Float.valueOf(this.f23209c), Float.valueOf(r10.f23209c)) == true) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(Float.valueOf(this.e), Float.valueOf(r10.e)) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r5 = Float.hashCode(this.f23207a) * 31;
        int r10 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.f23208b, r5, 31);
        int r11 = androidx.constraintlayout.motion.widget.a.b(this.f23209c, r10, 31);
        int r12 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.d, r11, 31);
        return Float.hashCode(this.e) + r12;
    }

    public final String toString() {
        return "BlurConfig(blurRadius=" + this.f23207a + ", direction=" + this.f23208b + ", alpha=" + this.f23209c + ", curveType=" + this.d + ", endPoint=" + this.e + ')';
    }

    public /* synthetic */ a(float r10, int r11, int r12) {
        this(r10, 1.0f, 1.0f, r11, r12);
    }
}
