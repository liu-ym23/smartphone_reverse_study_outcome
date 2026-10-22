package androidx.appcompat.widget;

import android.R;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class DrawableUtils {
    private static final int[] CHECKED_STATE_SET = null;
    private static final int[] EMPTY_STATE_SET = null;
    public static final Rect INSETS_NONE = null;

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
            Field r5 = r3.getField("left");     // Catch: NoSuchFieldException -> L13 ClassNotFoundException -> L14 NoSuchMethodException -> L15
        L35:
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
            r8 = null;
            r9 = false;
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
            goto L22
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

        static Rect getOpticalInsets(Drawable r0) {
            return DrawableUtils.INSETS_NONE;
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static Insets getOpticalInsets(Drawable r0) {
            return r0.getOpticalInsets();
        }
    }

    public static boolean canSafelyMutateDrawable(Drawable r0) {
        return true;
    }

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        EMPTY_STATE_SET = new int[0];
        INSETS_NONE = new Rect();
    }

    private DrawableUtils() {
    }

    public static Rect getOpticalBounds(Drawable r4) {
        Insets r5 = Api29Impl.getOpticalInsets(r4);
        return new Rect(r5.left, r5.top, r5.right, r5.bottom);
    }

    static void fixDrawable(Drawable r3) {
        String r0 = r3.getClass().getName();
        if (Build.VERSION.SDK_INT < 31) goto L5;
        return;
    L5:
        if ("android.graphics.drawable.ColorStateListDrawable".equals(r0) == false) goto L9;
        forceDrawableStateChange(r3);
        return;
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
