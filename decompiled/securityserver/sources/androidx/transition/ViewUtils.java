package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
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
        IMPL = new ViewUtilsApi29();
        final Class<Float> r1 = Float.class;
        final String r2 = "translationAlpha";
        TRANSITION_ALPHA = new AnonymousClass1(r1, r2);
        final Class<Rect> r3 = Rect.class;
        final String r4 = "clipBounds";
        CLIP_BOUNDS = new AnonymousClass2(r3, r4);
    }

    private ViewUtils() {
    }

    public static void clearNonTransitionAlpha(@NonNull View r1) {
        IMPL.clearNonTransitionAlpha(r1);
    }

    public static ViewOverlayImpl getOverlay(@NonNull View r1) {
        return new ViewOverlayApi18(r1);
    }

    public static float getTransitionAlpha(@NonNull View r1) {
        return IMPL.getTransitionAlpha(r1);
    }

    public static WindowIdImpl getWindowId(@NonNull View r1) {
        return new WindowIdApi18(r1);
    }

    public static void saveNonTransitionAlpha(@NonNull View r1) {
        IMPL.saveNonTransitionAlpha(r1);
    }

    public static void setAnimationMatrix(@NonNull View r1, @Nullable Matrix r2) {
        IMPL.setAnimationMatrix(r1, r2);
    }

    public static void setLeftTopRightBottom(@NonNull View r6, int r7, int r8, int r9, int r10) {
        IMPL.setLeftTopRightBottom(r6, r7, r8, r9, r10);
    }

    public static void setTransitionAlpha(@NonNull View r1, float r2) {
        IMPL.setTransitionAlpha(r1, r2);
    }

    public static void setTransitionVisibility(@NonNull View r1, int r2) {
        IMPL.setTransitionVisibility(r1, r2);
    }

    public static void transformMatrixToGlobal(@NonNull View r1, @NonNull Matrix r2) {
        IMPL.transformMatrixToGlobal(r1, r2);
    }

    public static void transformMatrixToLocal(@NonNull View r1, @NonNull Matrix r2) {
        IMPL.transformMatrixToLocal(r1, r2);
    }
}
