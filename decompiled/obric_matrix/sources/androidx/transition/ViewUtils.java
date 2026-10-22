package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
class ViewUtils {
    static final Property<View, Rect> CLIP_BOUNDS = null;
    private static final ViewUtilsBase IMPL = null;
    private static final String TAG = "ViewUtils";
    static final Property<View, Float> TRANSITION_ALPHA = null;

    static {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 29) goto L7;
        ViewUtilsBase r1 = new ViewUtilsApi29();
    L5:
        IMPL = r1;
        final Class<Float> r2 = Float.class;
        final String r3 = "translationAlpha";
        TRANSITION_ALPHA = new AnonymousClass1(r2, r3);
        final Class<Rect> r4 = Rect.class;
        final String r5 = "clipBounds";
        CLIP_BOUNDS = new AnonymousClass2(r4, r5);
        return;
    L7:
        if (r0 < 23) goto L10;
        r1 = new ViewUtilsApi23();
        goto L5
    L10:
        if (r0 < 22) goto L13;
        r1 = new ViewUtilsApi22();
        goto L5
    L13:
        if (r0 < 21) goto L16;
        r1 = new ViewUtilsApi21();
        goto L5
    L16:
        if (r0 < 19) goto L18;
        r1 = new ViewUtilsApi19();
        goto L5
    L18:
        r1 = new ViewUtilsBase();
        goto L5
    }

    private ViewUtils() {
    }

    static void clearNonTransitionAlpha(@NonNull View r1) {
        IMPL.clearNonTransitionAlpha(r1);
    }

    static ViewOverlayImpl getOverlay(@NonNull View r2) {
        if (Build.VERSION.SDK_INT < 18) goto L7;
        return new ViewOverlayApi18(r2);
    L7:
        return ViewOverlayApi14.createFrom(r2);
    }

    static float getTransitionAlpha(@NonNull View r1) {
        return IMPL.getTransitionAlpha(r1);
    }

    static WindowIdImpl getWindowId(@NonNull View r2) {
        if (Build.VERSION.SDK_INT < 18) goto L7;
        return new WindowIdApi18(r2);
    L7:
        return new WindowIdApi14(r2.getWindowToken());
    }

    static void saveNonTransitionAlpha(@NonNull View r1) {
        IMPL.saveNonTransitionAlpha(r1);
    }

    static void setAnimationMatrix(@NonNull View r1, @Nullable Matrix r2) {
        IMPL.setAnimationMatrix(r1, r2);
    }

    static void setLeftTopRightBottom(@NonNull View r6, int r7, int r8, int r9, int r10) {
        IMPL.setLeftTopRightBottom(r6, r7, r8, r9, r10);
    }

    static void setTransitionAlpha(@NonNull View r1, float r2) {
        IMPL.setTransitionAlpha(r1, r2);
    }

    static void setTransitionVisibility(@NonNull View r1, int r2) {
        IMPL.setTransitionVisibility(r1, r2);
    }

    static void transformMatrixToGlobal(@NonNull View r1, @NonNull Matrix r2) {
        IMPL.transformMatrixToGlobal(r1, r2);
    }

    static void transformMatrixToLocal(@NonNull View r1, @NonNull Matrix r2) {
        IMPL.transformMatrixToLocal(r1, r2);
    }
}
