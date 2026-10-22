package androidx.appcompat.widget;

import android.R;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.WrappedDrawable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class DrawableUtils {
    private static final int[] CHECKED_STATE_SET = null;
    private static final int[] EMPTY_STATE_SET = null;
    public static final Rect INSETS_NONE = null;

    @RequiresApi(18)
    static class Api18Impl {
        private static final Field sBottom = null;
        private static final Method sGetOpticalInsets = null;
        private static final Field sLeft = null;
        private static final boolean sReflectionSuccessful = false;
        private static final Field sRight = null;
        private static final Field sTop = null;

        static {
            Class<?> r3 = Class.forName("android.graphics.Insets");     // Catch: NoSuchFieldException -> L16 ClassNotFoundException -> L18 NoSuchMethodException -> L20
            Method r4 = Drawable.class.getMethod("getOpticalInsets", new Class[0]);     // Catch: NoSuchFieldException -> L16 ClassNotFoundException -> L18 NoSuchMethodException -> L20
        L37:
            Field r5 = r3.getField("left");     // Catch: NoSuchFieldException -> L13 ClassNotFoundException -> L14 NoSuchMethodException -> L15
            Field r6 = r3.getField("top");     // Catch: NoSuchFieldException -> L10 ClassNotFoundException -> L11 NoSuchMethodException -> L12
            Field r7 = r3.getField("right");     // Catch: Throwable -> L9
            Field r8 = r3.getField("bottom");     // Catch: Throwable -> L28
            boolean r9 = true;
        L24:
            if (r9 == false) goto L26;
            sGetOpticalInsets = r4;
            sLeft = r5;
            sTop = r6;
            sRight = r7;
            sBottom = r8;
            sReflectionSuccessful = true;
            return;
        L26:
            sGetOpticalInsets = null;
            sLeft = null;
            sTop = null;
            sRight = null;
            sBottom = null;
            sReflectionSuccessful = false;
            return;
        L23:
            r9 = false;
            r8 = null;
        L9:
            r7 = null;
            goto L23
        L11:
            r6 = null;
        L22:
            r7 = r6;
        L10:
            r6 = null;
        L12:
            r6 = null;
            goto L22
        L14:
            r5 = null;
        L19:
            r6 = r5;
        L13:
            r5 = null;
        L17:
            r6 = r5;
        L15:
            r5 = null;
        L21:
            r6 = r5;
        L18:
            r4 = null;
            r5 = null;
        L16:
            r4 = null;
            r5 = null;
        L20:
            r4 = null;
            r5 = null;
            goto L21
        }

        private Api18Impl() {
        }

        @NonNull
        static Rect getOpticalInsets(@NonNull Drawable r5) {
            if (Build.VERSION.SDK_INT >= 29) goto L11;
            if (sReflectionSuccessful == false) goto L11;
            Object r6 = sGetOpticalInsets.invoke(r5, new Object[0]);     // Catch: Throwable -> L12
            if (r6 == null) goto L11;
            return new Rect(sLeft.getInt(r6), sTop.getInt(r6), sRight.getInt(r6), sBottom.getInt(r6));
        L11:
            return DrawableUtils.INSETS_NONE;
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static Insets getOpticalInsets(Drawable r0) {
            return r0.getOpticalInsets();
        }
    }

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        EMPTY_STATE_SET = new int[0];
        INSETS_NONE = new Rect();
    }

    private DrawableUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean canSafelyMutateDrawable(@NonNull Drawable r6) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 17) goto L6;
        return true;
    L6:
        if (r0 < 15) goto L8;
    L10:
        if (r0 < 15) goto L12;
    L14:
        if (r0 >= 17) goto L19;
        if ((r6 instanceof LayerDrawable) == false) goto L19;
        return false;
    L19:
        if ((r6 instanceof DrawableContainer) == false) goto L29;
        Drawable.ConstantState r7 = r6.getConstantState();
        if ((r7 instanceof DrawableContainer.DrawableContainerState) == false) goto L39;
        Drawable[] r8 = ((DrawableContainer.DrawableContainerState) r7).getChildren();
        int r1 = r8.length;
        int r2 = 0;
    L23:
        if (r2 >= r1) goto L39;
        if (canSafelyMutateDrawable(r8[r2]) == false) goto L26;
        r2 = r2 + 1;
        goto L23
    L26:
        return false;
    L39:
        return true;
    L29:
        if ((r6 instanceof WrappedDrawable) == false) goto L34;
        Drawable r9 = ((WrappedDrawable) r6).getWrappedDrawable();
    L32:
        return canSafelyMutateDrawable(r9);
    L34:
        if ((r6 instanceof DrawableWrapperCompat) == false) goto L37;
        r9 = ((DrawableWrapperCompat) r6).getDrawable();
        goto L32
    L37:
        if ((r6 instanceof ScaleDrawable) == false) goto L39;
        r9 = ((ScaleDrawable) r6).getDrawable();
        goto L32
    L12:
        if ((r6 instanceof GradientDrawable) == false) goto L14;
        return false;
    L8:
        if ((r6 instanceof InsetDrawable) == false) goto L10;
        return false;
    }

    static void fixDrawable(@NonNull Drawable r3) {
        String r0 = r3.getClass().getName();
        int r1 = Build.VERSION.SDK_INT;
        if (r1 != 21) goto L8;
        if ("android.graphics.drawable.VectorDrawable".equals(r0) == false) goto L8;
    L6:
        forceDrawableStateChange(r3);
        return;
    L8:
        if (r1 >= 29) goto L10;
        return;
    L10:
        if (r1 < 31) goto L12;
        return;
    L12:
        if ("android.graphics.drawable.ColorStateListDrawable".equals(r0) == true) goto L6;
    }

    private static void forceDrawableStateChange(Drawable r2) {
        int[] r0 = r2.getState();
        if (r0 != null) goto L5;
    L8:
        r2.setState(CHECKED_STATE_SET);
    L9:
        r2.setState(r0);
        return;
    L5:
        if (r0.length == 0) goto L8;
        r2.setState(EMPTY_STATE_SET);
        goto L9
    }

    @NonNull
    public static Rect getOpticalBounds(@NonNull Drawable r4) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 29) goto L7;
        Insets r5 = Api29Impl.getOpticalInsets(r4);
        return new Rect(r5.left, r5.top, r5.right, r5.bottom);
    L7:
        if (r0 < 18) goto L11;
        return Api18Impl.getOpticalInsets(DrawableCompat.unwrap(r4));
    L11:
        return INSETS_NONE;
    }

    public static PorterDuff.Mode parseTintMode(int r1, PorterDuff.Mode r2) {
        if (r1 == 3) goto L21;
        if (r1 == 5) goto L19;
        if (r1 == 9) goto L17;
        switch(r1) {
            case 14: goto L15;
            case 15: goto L13;
            case 16: goto L11;
            default: goto L9;
        };
    L9:
        return r2;
    L11:
        return PorterDuff.Mode.ADD;
    L13:
        return PorterDuff.Mode.SCREEN;
    L15:
        return PorterDuff.Mode.MULTIPLY;
    L17:
        return PorterDuff.Mode.SRC_ATOP;
    L19:
        return PorterDuff.Mode.SRC_IN;
    L21:
        return PorterDuff.Mode.SRC_OVER;
    }
}
