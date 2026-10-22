package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;

/* JADX INFO: loaded from: classes.dex */
class TransitionUtils {
    private static final boolean HAS_IS_ATTACHED_TO_WINDOW = false;
    private static final boolean HAS_OVERLAY = false;
    private static final boolean HAS_PICTURE_BITMAP = false;
    private static final int MAX_IMAGE_SIZE = 1048576;

    static class MatrixEvaluator implements TypeEvaluator<Matrix> {
        final float[] mTempEndValues;
        final Matrix mTempMatrix;
        final float[] mTempStartValues;

        MatrixEvaluator() {
            this.mTempStartValues = new float[9];
            this.mTempEndValues = new float[9];
            this.mTempMatrix = new Matrix();
        }

        /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
        public Matrix evaluate2(float r4, Matrix r5, Matrix r6) {
            r5.getValues(this.mTempStartValues);
            r6.getValues(this.mTempEndValues);
            int r7 = 0;
        L4:
            if (r7 >= 9) goto L6;
            float[] r8 = this.mTempEndValues;
            float r0 = r8[r7];
            float[] r1 = this.mTempStartValues;
            float r2 = r0 - r1[r7];
            r8[r7] = r1[r7] + (r2 * r4);
            r7 = r7 + 1;
            goto L4
        L6:
            this.mTempMatrix.setValues(this.mTempEndValues);
            return this.mTempMatrix;
        }

        @Override // android.animation.TypeEvaluator
        public /* bridge */ /* synthetic */ Matrix evaluate(float r1, Matrix r2, Matrix r3) {
            return evaluate2(r1, r2, r3);
        }
    }

    static {
        int r0 = Build.VERSION.SDK_INT;
        boolean r1 = true;
        if (r0 < 19) goto L5;
        boolean r3 = true;
    L6:
        HAS_IS_ATTACHED_TO_WINDOW = r3;
        if (r0 < 18) goto L9;
        boolean r4 = true;
    L10:
        HAS_OVERLAY = r4;
        if (r0 >= 28) goto L14;
        r1 = false;
    L14:
        HAS_PICTURE_BITMAP = r1;
        return;
    L9:
        r4 = false;
        goto L10
    L5:
        r3 = false;
        goto L6
    }

    private TransitionUtils() {
    }

    static View copyViewImage(ViewGroup r7, View r8, View r9) {
        Matrix r0 = new Matrix();
        r0.setTranslate(-r9.getScrollX(), -r9.getScrollY());
        ViewUtils.transformMatrixToGlobal(r8, r0);
        ViewUtils.transformMatrixToLocal(r7, r0);
        RectF r10 = new RectF(0.0f, 0.0f, r8.getWidth(), r8.getHeight());
        r0.mapRect(r10);
        int r1 = Math.round(r10.left);
        int r2 = Math.round(r10.top);
        int r3 = Math.round(r10.right);
        int r4 = Math.round(r10.bottom);
        ImageView r5 = new ImageView(r8.getContext());
        r5.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap r11 = createViewBitmap(r8, r0, r10, r7);
        if (r11 == null) goto L5;
        r5.setImageBitmap(r11);
    L5:
        r5.measure(View.MeasureSpec.makeMeasureSpec(r3 - r1, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(r4 - r2, BasicMeasure.EXACTLY));
        r5.layout(r1, r2, r3, r4);
        return r5;
    }

    private static Bitmap createViewBitmap(View r9, Matrix r10, RectF r11, ViewGroup r12) {
        if (HAS_IS_ATTACHED_TO_WINDOW == false) goto L8;
        boolean r0 = !r9.isAttachedToWindow();
        if (r12 != null) goto L7;
        boolean r2 = false;
    L9:
        boolean r3 = HAS_OVERLAY;
        Bitmap r4 = null;
        if (r3 == false) goto L15;
        if (r0 == false) goto L15;
        if (r2 == true) goto L14;
        return null;
    L14:
        ViewGroup r1 = (ViewGroup) r9.getParent();
        int r5 = r1.indexOfChild(r9);
        r12.getOverlay().add(r9);
    L16:
        int r6 = Math.round(r11.width());
        int r7 = Math.round(r11.height());
        if (r6 <= 0) goto L23;
        if (r7 <= 0) goto L23;
        float r8 = Math.min(1.0f, 1048576.0f / (r6 * r7));
        int r13 = Math.round(r6 * r8);
        int r14 = Math.round(r7 * r8);
        r10.postTranslate(-r11.left, -r11.top);
        r10.postScale(r8, r8);
        if (HAS_PICTURE_BITMAP == false) goto L22;
        Picture r15 = new Picture();
        Canvas r16 = r15.beginRecording(r13, r14);
        r16.concat(r10);
        r9.draw(r16);
        r15.endRecording();
        r4 = Bitmap.createBitmap(r15);
        goto L23
    L22:
        r4 = Bitmap.createBitmap(r13, r14, Bitmap.Config.ARGB_8888);
        Canvas r17 = new Canvas(r4);
        r17.concat(r10);
        r9.draw(r17);
    L23:
        if (r3 == false) goto L26;
        if (r0 == false) goto L26;
        r12.getOverlay().remove(r9);
        r1.addView(r9, r5);
    L26:
        return r4;
    L15:
        r5 = 0;
        r1 = null;
        goto L16
    L7:
        r2 = r12.isAttachedToWindow();
        goto L9
    L8:
        r0 = false;
        r2 = false;
        goto L9
    }

    static Animator mergeAnimators(Animator r3, Animator r4) {
        if (r3 != null) goto L4;
        return r4;
    L4:
        if (r4 != null) goto L6;
        return r3;
    L6:
        AnimatorSet r0 = new AnimatorSet();
        r0.playTogether(new Animator[]{r3, r4});
        return r0;
    }
}
