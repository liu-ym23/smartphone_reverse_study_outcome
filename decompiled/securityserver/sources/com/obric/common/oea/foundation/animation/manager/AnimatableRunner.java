package com.obric.common.oea.foundation.animation.manager;

import android.view.View;
import com.obric.common.oea.foundation.animation.AnimationInfo;
import com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator;
import com.obric.common.oea.foundation.animation.calculator.FloatAnimationValueCalculator;
import com.obric.common.oea.foundation.animation.calculator.IntAnimationValueCalculator;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import com.obric.common.oea.foundation.util.OEALogger;
import defpackage.ViewUtilKt;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class AnimatableRunner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnimatableRunner$frameCallback$1 f118a;
    public final AnimatableStateManager b;
    public Function3 c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function2 f119d;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public final /* synthetic */ class WhenMappings {
        static {
            int[] r0 = new int[RunMode.values().length];
            r0[0] = 1;
            r0[1] = 2;
            int[] r1 = new int[RepeatMode.values().length];
            r1[1] = 1;
            r1[2] = 2;
            r1[0] = 3;
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.obric.common.oea.foundation.animation.manager.AnimatableRunner$frameCallback$1] */
    public AnimatableRunner(AnimatableStateManager r2, Function3 r3, Function2 r4) {
        Intrinsics.f(r2, "stateManager");
        this.b = r2;
        this.c = r3;
        this.f119d = r4;
        this.f118a = new AnimatableRunner$frameCallback$1(this);
    }

    public static final void a(AnimatableRunner r5, boolean r6) {
        AnimatableStateManager r7 = r5.b;
        WeakReference r0 = r7.f121d;
        if (r0 == null) goto L5;
        View r1 = (View) r0.get();
    L6:
        Iterator r2 = r7.c.iterator();
    L8:
        if (r2.hasNext() == false) goto L17;
        AnimationInfo r3 = (AnimationInfo) r2.next();
        if (r1 == null) goto L16;
        String r4 = r3.e;
        if (r6 == false) goto L14;
        Object r8 = r3.g;
    L15:
        ViewUtilKt.b(r1, r4, r8);
        goto L16
    L14:
        r8 = r3.f;
    L16:
        r3.b(true, r6, true);
        goto L8
    L17:
        r7.e = 0;
        r7.h = 0;
        r7.i = 0;
        r7.getClass();
        r7.f = -1;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final boolean b(String r23, long r24, AnimationInfo r26, long r27, boolean r29) {
        AnimatableStateManager r6 = this.b;
        long r14 = (long) (r24 * r6.g);
        r26.getClass();
        Class r5 = Float.TYPE;
        ClassReference r7 = Reflection.a(r5);
        KClass r13 = r26.j;
        boolean r8 = Intrinsics.a(r13, r7);
        IntAnimationValueCalculator r16 = IntAnimationValueCalculator.f107a;
        FloatAnimationValueCalculator r17 = FloatAnimationValueCalculator.f106a;
        if (r8 == false) goto L6;
        AnimationValueCalculator r9 = r17;
    L8:
        Object r10 = r26.f;
        Object r11 = r26.g;
        Float r12 = r26.i;
        float r18 = 0.0f;
        if (r12 == null) goto L11;
        float r19 = r12.floatValue();
    L12:
        Object r15 = r9.a(r14, r10, r11, r19, r26.h);
        WeakReference r20 = r6.f121d;
        if (r20 == null) goto L15;
        View r21 = (View) r20.get();
    L17:
        if (r26.b != (-1)) goto L19;
        r26.b = r27;
    L19:
        boolean r110 = r26.a(r14);
        String r111 = r26.e;
        if (r21 == null) goto L25;
        if (r110 == false) goto L23;
        Object r22 = r26.g;
    L24:
        ViewUtilKt.b(r21, r111, r22);
        goto L25
    L23:
        r22 = r15;
    L25:
        r26.c = r27;
        r26.f100d = !r110;
        if (Intrinsics.a(r13, Reflection.a(r5)) == false) goto L29;
        AnimationValueCalculator r25 = r17;
    L31:
        Object r112 = r26.f;
        Object r0 = r26.g;
        Float r3 = r26.i;
        if (r3 == null) goto L34;
        r18 = r3.floatValue();
    L34:
        float r4 = r25.b(r14, r112, r0, r18, r26.h);
        r26.k = r4;
        if (r110 == true) goto L37;
        Function3 r1 = this.c;
        if (r1 == null) goto L45;
        Unit r2 = (Unit) r1.b(r111, r15, Float.valueOf(r4));
    L45:
        return r110;
    L37:
        if (r29 == false) goto L41;
        OEALogger.c("executeAnimation, " + r23 + ", return case 1, property: " + r111 + ", targetValue: " + r26.g);
        Function2 r28 = this.f119d;
        if (r28 == null) goto L45;
        Unit r30 = (Unit) r28.mo7invoke(Boolean.TRUE, null);
        goto L45
    L41:
        OEALogger.c("executeAnimation, " + r23 + ", return case 2, property: " + r111 + ", targetValue: " + r26.g);
        goto L45
    L29:
        if (Intrinsics.a(r13, Reflection.a(Integer.TYPE)) == false) goto L47;
        r25 = r16;
        goto L31
    L47:
        throw new IllegalArgumentException("Unsupported type " + r13);
    L15:
        r21 = null;
        goto L17
    L11:
        r19 = 0.0f;
        goto L12
    L6:
        if (Intrinsics.a(r13, Reflection.a(Integer.TYPE)) == false) goto L49;
        r9 = r16;
        goto L8
    L49:
        throw new IllegalArgumentException("Unsupported type " + r13);
    }
}
