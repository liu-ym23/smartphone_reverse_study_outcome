package androidx.transition;

import a.a;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
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

    public static class MatrixEvaluator implements TypeEvaluator<Matrix> {
        final float[] mTempEndValues;
        final Matrix mTempMatrix;
        final float[] mTempStartValues;

        public MatrixEvaluator() {
            this.mTempStartValues = new float[9];
            this.mTempEndValues = new float[9];
            this.mTempMatrix = new Matrix();
        }

        @Override // android.animation.TypeEvaluator
        public /* bridge */ /* synthetic */ Matrix evaluate(float r1, Matrix r2, Matrix r3) {
            return evaluate2(r1, r2, r3);
        }

        /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
        public Matrix evaluate2(float r3, Matrix r4, Matrix r5) {
            r4.getValues(this.mTempStartValues);
            r5.getValues(this.mTempEndValues);
            int r6 = 0;
        L4:
            if (r6 >= 9) goto L6;
            float[] r7 = this.mTempEndValues;
            float r0 = r7[r6];
            float r1 = this.mTempStartValues[r6];
            r7[r6] = a.a(r0, r1, r3, r1);
            r6 = r6 + 1;
            goto L4
        L6:
            this.mTempMatrix.setValues(this.mTempEndValues);
            return this.mTempMatrix;
        }
    }

    static {
        HAS_IS_ATTACHED_TO_WINDOW = true;
        HAS_OVERLAY = true;
        HAS_PICTURE_BITMAP = true;
    }

    private TransitionUtils() {
    }

    public static View copyViewImage(ViewGroup r7, View r8, View r9) {
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

    private static Bitmap createViewBitmap(View r8, Matrix r9, RectF r10, ViewGroup r11) {
        if (HAS_IS_ATTACHED_TO_WINDOW == false) goto L8;
        boolean r0 = !r8.isAttachedToWindow();
        if (r11 != null) goto L7;
        boolean r2 = false;
    L9:
        boolean r3 = HAS_OVERLAY;
        Bitmap r4 = null;
        if (r3 == false) goto L15;
        if (r0 == false) goto L15;
        if (r2 == true) goto L14;
        return null;
    L14:
        ViewGroup r1 = (ViewGroup) r8.getParent();
        int r5 = r1.indexOfChild(r8);
        r11.getOverlay().add(r8);
    L16:
        int r6 = Math.round(r10.width());
        int r7 = Math.round(r10.height());
        if (r6 <= 0) goto L23;
        if (r7 <= 0) goto L23;
        float r12 = Math.min(1.0f, 1048576.0f / (r6 * r7));
        int r13 = Math.round(r6 * r12);
        int r14 = Math.round(r7 * r12);
        r9.postTranslate(-r10.left, -r10.top);
        r9.postScale(r12, r12);
        if (HAS_PICTURE_BITMAP == false) goto L22;
        Picture r15 = new Picture();
        Canvas r16 = r15.beginRecording(r13, r14);
        r16.concat(r9);
        r8.draw(r16);
        r15.endRecording();
        r4 = Bitmap.createBitmap(r15);
        goto L23
    L22:
        r4 = Bitmap.createBitmap(r13, r14, Bitmap.Config.ARGB_8888);
        Canvas r17 = new Canvas(r4);
        r17.concat(r9);
        r8.draw(r17);
    L23:
        if (r3 == false) goto L26;
        if (r0 == false) goto L26;
        r11.getOverlay().remove(r8);
        r1.addView(r8, r5);
    L26:
        return r4;
    L15:
        r5 = 0;
        r1 = null;
        goto L16
    L7:
        r2 = r11.isAttachedToWindow();
        goto L9
    L8:
        r0 = false;
        r2 = false;
        goto L9
    }

    public static Animator mergeAnimators(Animator r1, Animator r2) {
        if (r1 != null) goto L4;
        return r2;
    L4:
        if (r2 != null) goto L6;
        return r1;
    L6:
        AnimatorSet r0 = new AnimatorSet();
        r0.playTogether(new Animator[]{r1, r2});
        return r0;
    }
}
