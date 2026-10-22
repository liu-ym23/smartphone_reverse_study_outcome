package com.obric.oui.utils;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.VectorDrawable;
import android.util.ArrayMap;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VectorBreaker.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0003J \u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0003J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002J \u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/utils/VectorBreaker;", "", "()V", "TAG", "", "reflectSetPathColor", "", "vd", "Landroid/graphics/drawable/VectorDrawable;", "pathName", "color", "", "reflectSetPathColor2", "Landroid/graphics/drawable/AnimatedVectorDrawable;", "setPathColor", "drawable", "Landroid/graphics/drawable/StateListDrawable;", "setPathColor2", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VectorBreaker {
    public static final VectorBreaker INSTANCE = null;
    private static final String TAG = "VectorBreaker";

    static {
        INSTANCE = new VectorBreaker();
    }

    private VectorBreaker() {
    }

    public final void setPathColor(StateListDrawable r5, String r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "drawable");
        Intrinsics.checkNotNullParameter(r6, "pathName");
        int r0 = r5.getStateCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        int r2 = r1 + 1;
        Drawable r3 = r5.getStateDrawable(r1);
        if ((r3 instanceof VectorDrawable) == false) goto L8;
        setPathColor((VectorDrawable) r3, r6, r7);
    L10:
        r1 = r2;
        goto L3
    L8:
        if ((r3 instanceof AnimatedVectorDrawable) == false) goto L10;
        setPathColor2((AnimatedVectorDrawable) r3, r6, r7);
        goto L10
    }

    private final void setPathColor(VectorDrawable r1, String r2, int r3) {
        reflectSetPathColor(r1, r2, r3);     // Catch: Exception -> L4
        r1.invalidateSelf();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "Color injection failed", e);
    }

    private final void reflectSetPathColor(VectorDrawable r6, String r7, int r8) throws Exception {
        Field r5 = VectorDrawable.class.getDeclaredField("mVectorState");
        r5.setAccessible(true);
        Object r9 = r5.get(r6);
        Field r10 = r9.getClass().getDeclaredField("mVGTargetsMap");
        r10.setAccessible(true);
        Object r11 = r10.get(r9);
        if (r11 == null) goto L15;
        Object r12 = ((ArrayMap) r11).get(r7);
        if (r12 != null) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r12.getClass().getSimpleName(), "VFullPath") == false) goto L16;
        Field r13 = Class.forName("android.graphics.drawable.VectorDrawable$VFullPath").getDeclaredField("mNativePtr");
        r13.setAccessible(true);
        Object r14 = r13.get(r12);
        if (r14 == null) goto L12;
        long r15 = ((Long) r14).longValue();
        Method r16 = Class.forName("android.graphics.drawable.VectorDrawable").getDeclaredMethod("nSetFillColor", new Class[]{Long.TYPE, Integer.TYPE});
        r16.setAccessible(true);
        r16.invoke(null, new Object[]{Long.valueOf(r15), Integer.valueOf(r8)});
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    L16:
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.util.ArrayMap<kotlin.String, kotlin.Any>");
    }

    private final void setPathColor2(AnimatedVectorDrawable r1, String r2, int r3) {
        reflectSetPathColor2(r1, r2, r3);     // Catch: Exception -> L4
        r1.invalidateSelf();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "setPathColor2, Color injection failed", e);
    }

    private final void reflectSetPathColor2(AnimatedVectorDrawable r4, String r5, int r6) throws Exception {
        Field r0 = AnimatedVectorDrawable.class.getDeclaredField("mAnimatedVectorState");
        r0.setAccessible(true);
        Object r7 = r0.get(r4);
        Field r1 = r7.getClass().getDeclaredField("mVectorDrawable");
        if (r1 == null) goto L16;
        r1.setAccessible(true);
        KtExt r2 = KtExt.INSTANCE;
        Object r8 = r1.get(r7);
        if (r8 != null) goto L8;
    L6:
        r8 = null;
    L9:
        VectorDrawable r9 = (VectorDrawable) r8;
        if (r9 == null) goto L14;
        reflectSetPathColor(r9, r5, r6);
        return;
    L14:
        throw new IllegalStateException("mVectorDrawable is null");
    L8:
        if ((r8 instanceof VectorDrawable) == false) goto L6;
    L16:
        throw new IllegalStateException("mVectorDrawable Field is null");
    }
}
