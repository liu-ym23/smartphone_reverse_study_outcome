package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class ViewUtilsBase {
    private static final String TAG = "ViewUtilsBase";
    private static final int VISIBILITY_MASK = 12;
    private static boolean sSetFrameFetched;
    private static Method sSetFrameMethod;
    private static Field sViewFlagsField;
    private static boolean sViewFlagsFieldFetched;
    private float[] mMatrixValues;

    public ViewUtilsBase() {
    }

    @SuppressLint({"PrivateApi"})
    private void fetchSetFrame() {
        if (sSetFrameFetched == false) goto L11;
        return;
    L11:
        Class r2 = Integer.TYPE;     // Catch: NoSuchMethodException -> L7
        Method r0 = View.class.getDeclaredMethod("setFrame", new Class[]{r2, r2, r2, r2});     // Catch: NoSuchMethodException -> L7
        sSetFrameMethod = r0;     // Catch: NoSuchMethodException -> L7
        r0.setAccessible(true);     // Catch: NoSuchMethodException -> L7
    L9:
        sSetFrameFetched = true;
        return;
    L7:
        e = move-exception;
        Log.i(TAG, "Failed to retrieve setFrame method", e);
        goto L9
    }

    public void clearNonTransitionAlpha(@NonNull View r2) {
        if (r2.getVisibility() != 0) goto L6;
        r2.setTag(R.id.save_non_transition_alpha, null);
        return;
    }

    public float getTransitionAlpha(@NonNull View r1) {
        Float r0 = (Float) r1.getTag(R.id.save_non_transition_alpha);
        if (r0 == null) goto L7;
        return r1.getAlpha() / r0.floatValue();
    L7:
        return r1.getAlpha();
    }

    public void saveNonTransitionAlpha(@NonNull View r2) {
        if (r2.getTag(R.id.save_non_transition_alpha) != null) goto L6;
        r2.setTag(R.id.save_non_transition_alpha, Float.valueOf(r2.getAlpha()));
        return;
    }

    public void setAnimationMatrix(@NonNull View r9, @Nullable Matrix r10) {
        if (r10 != null) goto L5;
    L15:
        r9.setPivotX(r9.getWidth() / 2);
        r9.setPivotY(r9.getHeight() / 2);
        r9.setTranslationX(0.0f);
        r9.setTranslationY(0.0f);
        r9.setScaleX(1.0f);
        r9.setScaleY(1.0f);
        r9.setRotation(0.0f);
        return;
    L5:
        if (r10.isIdentity() == true) goto L15;
        float[] r3 = this.mMatrixValues;
        if (r3 != null) goto L10;
        r3 = new float[9];
        this.mMatrixValues = r3;
    L10:
        r10.getValues(r3);
        float r8 = r3[3];
        float r11 = (float) Math.sqrt(1.0f - (r8 * r8));
        if (r3[0] >= 0.0f) goto L13;
        int r4 = -1;
    L14:
        float r12 = r11 * r4;
        float r13 = (float) Math.toDegrees(Math.atan2(r8, r12));
        float r1 = r3[0] / r12;
        float r5 = r3[4] / r12;
        float r14 = r3[2];
        float r0 = r3[5];
        r9.setPivotX(0.0f);
        r9.setPivotY(0.0f);
        r9.setTranslationX(r14);
        r9.setTranslationY(r0);
        r9.setRotation(r13);
        r9.setScaleX(r1);
        r9.setScaleY(r5);
        return;
    L13:
        r4 = 1;
        goto L14
    }

    public void setLeftTopRightBottom(@NonNull View r1, int r2, int r3, int r4, int r5) {
        fetchSetFrame();
        Method r0 = sSetFrameMethod;
        if (r0 != null) goto L11;
        return;
    L11:
        r0.invoke(r1, new Object[]{Integer.valueOf(r2), Integer.valueOf(r3), Integer.valueOf(r4), Integer.valueOf(r5)});     // Catch: InvocationTargetException -> L6 IllegalAccessException -> L10
        goto L14
    L13:
        return;
    L6:
        e = move-exception;
        throw new RuntimeException(e.getCause());
    }

    public void setTransitionAlpha(@NonNull View r1, float r2) {
        Float r0 = (Float) r1.getTag(R.id.save_non_transition_alpha);
        if (r0 == null) goto L5;
        r1.setAlpha(r0.floatValue() * r2);
        return;
    L5:
        r1.setAlpha(r2);
    }

    public void setTransitionVisibility(@NonNull View r3, int r4) {
        if (sViewFlagsFieldFetched == false) goto L16;
    L9:
        Field r2 = sViewFlagsField;
        if (r2 == null) goto L18;
        int r5 = r2.getInt(r3);     // Catch: IllegalAccessException -> L13
        sViewFlagsField.setInt(r3, (r5 & (-13)) | r4);     // Catch: IllegalAccessException -> L13
        return;
    L19:
        return;
    L18:
        return;
    L16:
        Field r0 = View.class.getDeclaredField("mViewFlags");     // Catch: NoSuchFieldException -> L7
        sViewFlagsField = r0;     // Catch: NoSuchFieldException -> L7
        r0.setAccessible(true);     // Catch: NoSuchFieldException -> L7
    L8:
        sViewFlagsFieldFetched = true;
    L7:
        Log.i(TAG, "fetchViewFlagsField: ");
        goto L8
    }

    public void transformMatrixToGlobal(@NonNull View r3, @NonNull Matrix r4) {
        Object r0 = r3.getParent();
        if ((r0 instanceof View) == false) goto L5;
        View r1 = (View) r0;
        transformMatrixToGlobal(r1, r4);
        r4.preTranslate(-r1.getScrollX(), -r1.getScrollY());
    L5:
        r4.preTranslate(r3.getLeft(), r3.getTop());
        Matrix r2 = r3.getMatrix();
        if (r2.isIdentity() == true) goto L9;
        r4.preConcat(r2);
        return;
    }

    public void transformMatrixToLocal(@NonNull View r3, @NonNull Matrix r4) {
        Object r0 = r3.getParent();
        if ((r0 instanceof View) == false) goto L5;
        View r1 = (View) r0;
        transformMatrixToLocal(r1, r4);
        r4.postTranslate(r1.getScrollX(), r1.getScrollY());
    L5:
        r4.postTranslate(-r3.getLeft(), -r3.getTop());
        Matrix r2 = r3.getMatrix();
        if (r2.isIdentity() == true) goto L11;
        Matrix r5 = new Matrix();
        if (r2.invert(r5) == false) goto L12;
        r4.postConcat(r5);
        return;
    L12:
        return;
    }
}
