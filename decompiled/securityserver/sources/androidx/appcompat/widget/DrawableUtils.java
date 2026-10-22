package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.ScaleDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.graphics.drawable.WrappedDrawable;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedAPI"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class DrawableUtils {
    private static final int[] CHECKED_STATE_SET = null;
    private static final int[] EMPTY_STATE_SET = null;
    public static final Rect INSETS_NONE = null;
    private static final String TAG = "DrawableUtils";
    private static final String VECTOR_DRAWABLE_CLAZZ_NAME = "android.graphics.drawable.VectorDrawable";
    private static Class<?> sInsetsClazz;

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        EMPTY_STATE_SET = new int[0];
        INSETS_NONE = new Rect();
        sInsetsClazz = Class.forName("android.graphics.Insets");     // Catch: ClassNotFoundException -> L5
        return;
    }

    private DrawableUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean canSafelyMutateDrawable(@NonNull Drawable r4) {
        if ((r4 instanceof DrawableContainer) == false) goto L13;
        Drawable.ConstantState r5 = r4.getConstantState();
        if ((r5 instanceof DrawableContainer.DrawableContainerState) == false) goto L24;
        Drawable[] r6 = ((DrawableContainer.DrawableContainerState) r5).getChildren();
        int r0 = r6.length;
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L29;
        if (canSafelyMutateDrawable(r6[r2]) == false) goto L10;
        r2 = r2 + 1;
        goto L7
    L10:
        return false;
    L29:
        return true;
    L24:
        return true;
    L13:
        if ((r4 instanceof WrappedDrawable) == false) goto L17;
        return canSafelyMutateDrawable(((WrappedDrawable) r4).getWrappedDrawable());
    L17:
        if ((r4 instanceof DrawableWrapper) == false) goto L21;
        return canSafelyMutateDrawable(((DrawableWrapper) r4).getWrappedDrawable());
    L21:
        if ((r4 instanceof ScaleDrawable) == true) goto L23;
        return true;
    L23:
        return canSafelyMutateDrawable(((ScaleDrawable) r4).getDrawable());
    }

    public static void fixDrawable(@NonNull Drawable r0) {
    }

    private static void fixVectorDrawableTinting(Drawable r2) {
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

    public static Rect getOpticalBounds(Drawable r2) {
        Insets r3 = r2.getOpticalInsets();
        Rect r0 = new Rect();
        r0.left = r3.left;
        r0.right = r3.right;
        r0.top = r3.top;
        r0.bottom = r3.bottom;
        return r0;
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
