package d.g.d.f;

import android.annotation.SuppressLint;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.VectorDrawable;
import android.util.ArrayMap;
import android.util.Log;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f16935a = null;

    static {
        f16935a = new d();
    }

    private d() {
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    private final void a(VectorDrawable r6, String r7, int r8) {
        Field r5 = VectorDrawable.class.getDeclaredField("mVectorState");
        o.e(r5, "stateField");
        r5.setAccessible(true);
        Object r9 = r5.get(r6);
        Field r10 = r9.getClass().getDeclaredField("mVGTargetsMap");
        o.e(r10, "targetsMapField");
        r10.setAccessible(true);
        Object r11 = r10.get(r9);
        Objects.requireNonNull(r11, "null cannot be cast to non-null type android.util.ArrayMap<kotlin.String, kotlin.Any>");
        Object r12 = ((ArrayMap) r11).get(r7);
        if (r12 != null) goto L5;
        return;
    L5:
        if (o.a(r12.getClass().getSimpleName(), "VFullPath") == false) goto L9;
        Field r13 = Class.forName("android.graphics.drawable.VectorDrawable$VFullPath").getDeclaredField("mNativePtr");
        o.e(r13, "nativePtrField");
        r13.setAccessible(true);
        Object r14 = r13.get(r12);
        Objects.requireNonNull(r14, "null cannot be cast to non-null type kotlin.Long");
        long r15 = ((Long) r14).longValue();
        Method r16 = Class.forName("android.graphics.drawable.VectorDrawable").getDeclaredMethod("nSetFillColor", new Class[]{Long.TYPE, Integer.TYPE});
        o.e(r16, "nSetFillColor");
        r16.setAccessible(true);
        r16.invoke(null, new Object[]{Long.valueOf(r15), Integer.valueOf(r8)});
        return;
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    private final void b(AnimatedVectorDrawable r4, String r5, int r6) {
        Field r0 = AnimatedVectorDrawable.class.getDeclaredField("mAnimatedVectorState");
        o.e(r0, "stateField");
        r0.setAccessible(true);
        Object r7 = r0.get(r4);
        Field r1 = r7.getClass().getDeclaredField("mVectorDrawable");
        if (r1 == null) goto L16;
        r1.setAccessible(true);
        b r2 = b.f16934a;
        Object r8 = r1.get(r7);
        if (r8 != null) goto L8;
    L6:
        r8 = null;
    L9:
        VectorDrawable r9 = (VectorDrawable) r8;
        if (r9 == null) goto L14;
        a(r9, r5, r6);
        return;
    L14:
        throw new IllegalStateException("mVectorDrawable is null");
    L8:
        if ((r8 instanceof VectorDrawable) == false) goto L6;
    L16:
        throw new IllegalStateException("mVectorDrawable Field is null");
    }

    private final void d(VectorDrawable r1, String r2, int r3) {
        a(r1, r2, r3);     // Catch: Exception -> L4
        r1.invalidateSelf();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("VectorBreaker", "Color injection failed", e);
    }

    private final void e(AnimatedVectorDrawable r1, String r2, int r3) {
        b(r1, r2, r3);     // Catch: Exception -> L4
        r1.invalidateSelf();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("VectorBreaker", "setPathColor2, Color injection failed", e);
    }

    @RequiresApi(29)
    public final void c(StateListDrawable r5, String r6, int r7) {
        o.f(r5, "drawable");
        o.f(r6, "pathName");
        int r0 = r5.getStateCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        Drawable r2 = r5.getStateDrawable(r1);
        if ((r2 instanceof VectorDrawable) == false) goto L8;
        d((VectorDrawable) r2, r6, r7);
    L10:
        r1 = r1 + 1;
        goto L3
    L8:
        if ((r2 instanceof AnimatedVectorDrawable) == false) goto L10;
        e((AnimatedVectorDrawable) r2, r6, r7);
        goto L10
    }
}
