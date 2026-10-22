package com.obric.common.oea.foundation.a.a.d;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f8176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f8177b;

    public e(float r1, float r2) {
        this.f8176a = r1;
        this.f8177b = r2;
    }

    public final float a() {
        return this.f8176a;
    }

    public final float b() {
        return this.f8177b;
    }

    public final float c() {
        return this.f8176a;
    }

    public final float d() {
        return this.f8177b;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L10;
        e r4 = (e) r3;
        if (Float.compare(this.f8176a, r4.f8176a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f8177b, r4.f8177b) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        return (Float.hashCode(this.f8176a) * 31) + Float.hashCode(this.f8177b);
    }

    public String toString() {
        return "Point(x=" + this.f8176a + ", y=" + this.f8177b + ")";
    }
}
