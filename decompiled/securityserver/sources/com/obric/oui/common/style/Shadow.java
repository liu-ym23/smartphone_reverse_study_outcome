package com.obric.oui.common.style;

import android.graphics.Paint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Shadow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f204a;
    public float b;
    public float c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f205d;
    public float e;
    public final Paint f;
    public final float g;

    public Shadow(int r7) {
        this(r7, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    public final boolean a() {
        if (this.c == 0.0f) goto L5;
    L12:
        return true;
    L5:
        if (this.f205d != 0.0f) goto L12;
        if (this.b != 0.0f) goto L12;
        if (this.e != 0.0f) goto L12;
        return false;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof Shadow) == false) goto L20;
        Shadow r4 = (Shadow) r3;
        if (this.f204a == r4.f204a) goto L8;
        return false;
    L8:
        if (Float.compare(this.b, r4.b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.c, r4.c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f205d, r4.f205d) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.e, r4.e) == 0) goto L16;
        return false;
    L16:
        if (Intrinsics.a(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.g, r4.g) == 0) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        int r0 = Integer.hashCode(this.f204a) * 31;
        int r1 = a.a.b(this.b, r0, 31);
        int r2 = a.a.b(this.c, r1, 31);
        int r3 = a.a.b(this.f205d, r2, 31);
        int r4 = a.a.b(this.e, r3, 31);
        Paint r5 = this.f;
        if (r5 == null) goto L5;
        int r6 = r5.hashCode();
    L6:
        int r7 = Float.hashCode(this.g);
        return r7 + ((r4 + r6) * 31);
    L5:
        r6 = 0;
        goto L6
    }

    public final String toString() {
        return "Shadow(color=" + this.f204a + ", radius=" + this.b + ", offsetX=" + this.c + ", offsetY=" + this.f205d + ", spread=" + this.e + ", paint=" + this.f + ", cornerRadius=" + this.g + ")";
    }

    public Shadow(int r3, float r4, float r5, float r6, float r7) {
        Paint r0 = new Paint(1);
        this.f204a = r3;
        this.b = r4;
        this.c = r5;
        this.f205d = r6;
        this.e = r7;
        this.f = r0;
        this.g = 0.0f;
    }
}
