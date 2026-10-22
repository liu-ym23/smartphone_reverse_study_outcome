package com.obric.oui.utils;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.VectorDrawable;
import android.util.ArrayMap;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class VectorBreaker {
    public static void a(VectorDrawable r4, int r5) {
        Field r0 = VectorDrawable.class.getDeclaredField("mVectorState");
        Intrinsics.e(r0, "stateField");
        r0.setAccessible(true);
        Object r6 = r0.get(r4);
        Field r1 = r6.getClass().getDeclaredField("mVGTargetsMap");
        Intrinsics.e(r1, "targetsMapField");
        r1.setAccessible(true);
        Object r7 = r1.get(r6);
        if (r7 == null) goto L15;
        Object r8 = ((ArrayMap) r7).get("primary_shape");
        if (r8 != null) goto L7;
        return;
    L7:
        if (r8.getClass().getSimpleName().equals("VFullPath") == false) goto L16;
        Field r2 = Class.forName("android.graphics.drawable.VectorDrawable$VFullPath").getDeclaredField("mNativePtr");
        Intrinsics.e(r2, "nativePtrField");
        r2.setAccessible(true);
        Object r9 = r2.get(r8);
        if (r9 == null) goto L12;
        Method r3 = Class.forName("android.graphics.drawable.VectorDrawable").getDeclaredMethod("nSetFillColor", new Class[]{Long.TYPE, Integer.TYPE});
        Intrinsics.e(r3, "nSetFillColor");
        r3.setAccessible(true);
        r3.invoke(null, new Object[]{(Long) r9, Integer.valueOf(r5)});
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    L16:
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.util.ArrayMap<kotlin.String, kotlin.Any>");
    }

    public static void b(AnimatedVectorDrawable r3, int r4) {
        Field r0 = AnimatedVectorDrawable.class.getDeclaredField("mAnimatedVectorState");
        Intrinsics.e(r0, "stateField");
        r0.setAccessible(true);
        Object r5 = r0.get(r3);
        Field r1 = r5.getClass().getDeclaredField("mVectorDrawable");
        if (r1 == null) goto L16;
        r1.setAccessible(true);
        Object r6 = r1.get(r5);
        if (r6 != null) goto L8;
    L6:
        r6 = null;
    L9:
        VectorDrawable r7 = (VectorDrawable) r6;
        if (r7 == null) goto L14;
        a(r7, r4);
        return;
    L14:
        throw new IllegalStateException("mVectorDrawable is null");
    L8:
        if ((r6 instanceof VectorDrawable) == false) goto L6;
    L16:
        throw new IllegalStateException("mVectorDrawable Field is null");
    }
}
