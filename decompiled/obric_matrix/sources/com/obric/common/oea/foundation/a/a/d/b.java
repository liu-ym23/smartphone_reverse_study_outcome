package com.obric.common.oea.foundation.a.a.d;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f8166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f8167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f8168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f8169d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f8170e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f8171f;

    public b(float r1, float r2, float r3, float r4, float r5, float r6) {
        this.f8166a = r1;
        this.f8167b = r2;
        this.f8168c = r3;
        this.f8169d = r4;
        this.f8170e = r5;
        this.f8171f = r6;
    }

    public final float a() {
        return this.f8170e;
    }

    public final float b() {
        return this.f8171f;
    }

    public final float c() {
        return this.f8168c;
    }

    public final float d() {
        return this.f8167b;
    }

    public final float e() {
        return this.f8166a;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L18;
        b r4 = (b) r3;
        if (Float.compare(this.f8166a, r4.f8166a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f8167b, r4.f8167b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f8168c, r4.f8168c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f8169d, r4.f8169d) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.f8170e, r4.f8170e) == 0) goto L16;
        return false;
    L16:
        if (Float.compare(this.f8171f, r4.f8171f) == 0) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final float f() {
        return this.f8169d;
    }

    public int hashCode() {
        return (((((((((Float.hashCode(this.f8166a) * 31) + Float.hashCode(this.f8167b)) * 31) + Float.hashCode(this.f8168c)) * 31) + Float.hashCode(this.f8169d)) * 31) + Float.hashCode(this.f8170e)) * 31) + Float.hashCode(this.f8171f);
    }

    public String toString() {
        return "ControlPoint(handleLarge=" + this.f8166a + ", distanceOuter=" + this.f8167b + ", distanceInner=" + this.f8168c + ", handleMedium=" + this.f8169d + ", curveInner=" + this.f8170e + ", curveOuter=" + this.f8171f + ")";
    }
}
