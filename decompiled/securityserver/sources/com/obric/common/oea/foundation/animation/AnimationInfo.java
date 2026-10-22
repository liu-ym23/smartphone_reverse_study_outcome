package com.obric.common.oea.foundation.animation;

import com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator;
import com.obric.common.oea.foundation.animation.calculator.FloatAnimationValueCalculator;
import com.obric.common.oea.foundation.animation.calculator.IntAnimationValueCalculator;
import com.obric.common.oea.foundation.animation.spec.AnimationSpec;
import com.obric.common.oea.foundation.animation.spec.spring.FloatSpringSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class AnimationInfo<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f99a;
    public long b;
    public long c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f100d;
    public final String e;
    public Object f;
    public Object g;
    public final AnimationSpec h;
    public Float i;
    public final KClass j;
    public float k;

    public AnimationInfo(FloatSpringSpec r2, Float r3, Float r4, Float r5, String r6, ClassReference r7) {
        Intrinsics.f(r6, "property");
        this.e = r6;
        this.f = r3;
        this.g = r4;
        this.h = r2;
        this.i = r5;
        this.j = r7;
        this.k = 0.0f;
        this.f99a = -1;
        this.b = -1;
        this.c = -1;
        this.f100d = true;
    }

    public final boolean a(long r8) {
        ClassReference r0 = Reflection.a(Float.TYPE);
        KClass r1 = this.j;
        if (Intrinsics.a(r1, r0) == false) goto L7;
        AnimationValueCalculator r2 = FloatAnimationValueCalculator.f106a;
    L5:
        AnimationValueCalculator r3 = r2;
        if (this.f99a >= 0) goto L17;
        Object r4 = this.f;
        Object r5 = this.g;
        Float r6 = this.i;
        if (r6 == null) goto L14;
        float r7 = r6.floatValue();
    L15:
        this.f99a = this.h.b(r7, r4, r5);
        goto L17
    L14:
        r7 = 0.0f;
    L17:
        return r3.c(r8, this.f99a, this.h);
    L7:
        if (Intrinsics.a(r1, Reflection.a(Integer.TYPE)) == false) goto L19;
        r2 = IntAnimationValueCalculator.f107a;
        goto L5
    L19:
        throw new IllegalArgumentException("Unsupported type " + r1);
    }

    public final void b(boolean r3, boolean r4, boolean r5) {
        this.f100d = r3;
        if (r5 == false) goto L5;
        float r6 = 0.0f;
    L6:
        this.k = r6;
        this.b = -1;
        this.c = -1;
        if (r4 == false) goto L10;
        Object r7 = this.f;
        this.f = this.g;
        this.g = r7;
        return;
    L10:
        return;
    L5:
        r6 = this.k;
        goto L6
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof AnimationInfo) == false) goto L20;
        AnimationInfo r4 = (AnimationInfo) r3;
        String r0 = r4.e;
        if (Intrinsics.a(this.e, r0) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.a(this.f, r4.f) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.a(this.g, r4.g) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.a(this.h, r4.h) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.a(this.i, r4.i) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.a(this.j, r4.j) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.k, r4.k) == 0) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        int r0 = 0;
        String r1 = this.e;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L6:
        int r3 = r2 * 31;
        Object r4 = this.f;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Object r7 = this.g;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        AnimationSpec r10 = this.h;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Float r13 = this.i;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        KClass r16 = this.j;
        if (r16 == null) goto L26;
        r0 = r16.hashCode();
    L26:
        return Float.hashCode(this.k) + ((r15 + r0) * 31);
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "AnimationInfo(property=" + this.e + ", initialValue=" + this.f + ", targetValue=" + this.g + ", spec=" + this.h + ", initialVelocity=" + this.i + ", valueClass=" + this.j + ", currentVelocity=" + this.k + ")";
    }
}
