package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class ChangeTransform extends Transition {
    private static final Property<PathAnimatorMatrix, float[]> NON_TRANSLATIONS_PROPERTY = null;
    private static final String PROPNAME_INTERMEDIATE_MATRIX = "android:changeTransform:intermediateMatrix";
    private static final String PROPNAME_INTERMEDIATE_PARENT_MATRIX = "android:changeTransform:intermediateParentMatrix";
    private static final String PROPNAME_MATRIX = "android:changeTransform:matrix";
    private static final String PROPNAME_PARENT = "android:changeTransform:parent";
    private static final String PROPNAME_PARENT_MATRIX = "android:changeTransform:parentMatrix";
    private static final String PROPNAME_TRANSFORMS = "android:changeTransform:transforms";
    private static final boolean SUPPORTS_VIEW_REMOVAL_SUPPRESSION = false;
    private static final Property<PathAnimatorMatrix, PointF> TRANSLATIONS_PROPERTY = null;
    private static final String[] sTransitionProperties = null;
    private boolean mReparent;
    private Matrix mTempMatrix;
    boolean mUseOverlay;

    private static class GhostListener extends TransitionListenerAdapter {
        private GhostView mGhostView;
        private View mView;

        GhostListener(View r1, GhostView r2) {
            this.mView = r1;
            this.mGhostView = r2;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition r3) {
            r3.removeListener(this);
            GhostViewUtils.removeGhost(this.mView);
            this.mView.setTag(R.id.transition_transform, null);
            this.mView.setTag(R.id.parent_matrix, null);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionPause(Transition r1) {
            this.mGhostView.setVisibility(4);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionResume(Transition r1) {
            this.mGhostView.setVisibility(0);
        }
    }

    private static class PathAnimatorMatrix {
        private final Matrix mMatrix;
        private float mTranslationX;
        private float mTranslationY;
        private final float[] mValues;
        private final View mView;

        PathAnimatorMatrix(View r2, float[] r3) {
            this.mMatrix = new Matrix();
            this.mView = r2;
            float[] r4 = (float[]) r3.clone();
            this.mValues = r4;
            this.mTranslationX = r4[2];
            this.mTranslationY = r4[5];
            setAnimationMatrix();
        }

        void setValues(float[] r4) {
            System.arraycopy(r4, 0, this.mValues, 0, r4.length);
            setAnimationMatrix();
        }

        void setTranslation(PointF r2) {
            this.mTranslationX = r2.x;
            this.mTranslationY = r2.y;
            setAnimationMatrix();
        }

        private void setAnimationMatrix() {
            float[] r0 = this.mValues;
            r0[2] = this.mTranslationX;
            r0[5] = this.mTranslationY;
            this.mMatrix.setValues(r0);
            ViewUtils.setAnimationMatrix(this.mView, this.mMatrix);
        }

        Matrix getMatrix() {
            return this.mMatrix;
        }
    }

    private static class Transforms {
        final float mRotationX;
        final float mRotationY;
        final float mRotationZ;
        final float mScaleX;
        final float mScaleY;
        final float mTranslationX;
        final float mTranslationY;
        final float mTranslationZ;

        Transforms(View r2) {
            this.mTranslationX = r2.getTranslationX();
            this.mTranslationY = r2.getTranslationY();
            this.mTranslationZ = ViewCompat.getTranslationZ(r2);
            this.mScaleX = r2.getScaleX();
            this.mScaleY = r2.getScaleY();
            this.mRotationX = r2.getRotationX();
            this.mRotationY = r2.getRotationY();
            this.mRotationZ = r2.getRotation();
        }

        public void restore(View r10) {
            ChangeTransform.setTransforms(r10, this.mTranslationX, this.mTranslationY, this.mTranslationZ, this.mScaleX, this.mScaleY, this.mRotationX, this.mRotationY, this.mRotationZ);
        }

        public boolean equals(Object r4) {
            if ((r4 instanceof Transforms) == true) goto L5;
            return false;
        L5:
            Transforms r5 = (Transforms) r4;
            if (r5.mTranslationX == this.mTranslationX) goto L8;
            return false;
        L8:
            if (r5.mTranslationY == this.mTranslationY) goto L10;
            return false;
        L10:
            if (r5.mTranslationZ == this.mTranslationZ) goto L12;
            return false;
        L12:
            if (r5.mScaleX == this.mScaleX) goto L14;
            return false;
        L14:
            if (r5.mScaleY == this.mScaleY) goto L16;
            return false;
        L16:
            if (r5.mRotationX == this.mRotationX) goto L18;
            return false;
        L18:
            if (r5.mRotationY == this.mRotationY) goto L20;
            return false;
        L20:
            if (r5.mRotationZ != this.mRotationZ) goto L30;
            return true;
        L30:
            return false;
        }

        public int hashCode() {
            float r0 = this.mTranslationX;
            int r3 = 0;
            if (r0 == 0.0f) goto L5;
            int r1 = Float.floatToIntBits(r0);
        L6:
            int r2 = r1 * 31;
            float r4 = this.mTranslationY;
            if (r4 == 0.0f) goto L9;
            int r5 = Float.floatToIntBits(r4);
        L10:
            int r6 = (r2 + r5) * 31;
            float r7 = this.mTranslationZ;
            if (r7 == 0.0f) goto L13;
            int r8 = Float.floatToIntBits(r7);
        L14:
            int r9 = (r6 + r8) * 31;
            float r10 = this.mScaleX;
            if (r10 == 0.0f) goto L17;
            int r11 = Float.floatToIntBits(r10);
        L18:
            int r12 = (r9 + r11) * 31;
            float r13 = this.mScaleY;
            if (r13 == 0.0f) goto L21;
            int r14 = Float.floatToIntBits(r13);
        L22:
            int r15 = (r12 + r14) * 31;
            float r16 = this.mRotationX;
            if (r16 == 0.0f) goto L25;
            int r17 = Float.floatToIntBits(r16);
        L26:
            int r18 = (r15 + r17) * 31;
            float r19 = this.mRotationY;
            if (r19 == 0.0f) goto L29;
            int r20 = Float.floatToIntBits(r19);
        L30:
            int r21 = (r18 + r20) * 31;
            float r22 = this.mRotationZ;
            if (r22 == 0.0f) goto L34;
            r3 = Float.floatToIntBits(r22);
        L34:
            return r21 + r3;
        L29:
            r20 = 0;
            goto L30
        L25:
            r17 = 0;
            goto L26
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r1 = 0;
            goto L6
        }
    }

    static {
        sTransitionProperties = new String[]{PROPNAME_MATRIX, PROPNAME_TRANSFORMS, PROPNAME_PARENT_MATRIX};
        final Class<float[]> r1 = float[].class;
        final String r2 = "nonTranslations";
        NON_TRANSLATIONS_PROPERTY = new AnonymousClass1(r1, r2);
        final Class<PointF> r3 = PointF.class;
        final String r4 = "translations";
        TRANSLATIONS_PROPERTY = new AnonymousClass2(r3, r4);
        SUPPORTS_VIEW_REMOVAL_SUPPRESSION = true;
    }

    public ChangeTransform() {
        this.mUseOverlay = true;
        this.mReparent = true;
        this.mTempMatrix = new Matrix();
    }

    public ChangeTransform(Context r4, AttributeSet r5) {
        super(r4, r5);
        this.mUseOverlay = true;
        this.mReparent = true;
        this.mTempMatrix = new Matrix();
        TypedArray r6 = r4.obtainStyledAttributes(r5, Styleable.CHANGE_TRANSFORM);
        XmlPullParser r7 = (XmlPullParser) r5;
        this.mUseOverlay = TypedArrayUtils.getNamedBoolean(r6, r7, "reparentWithOverlay", 1, true);
        this.mReparent = TypedArrayUtils.getNamedBoolean(r6, r7, "reparent", 0, true);
        r6.recycle();
    }

    public boolean getReparentWithOverlay() {
        return this.mUseOverlay;
    }

    public void setReparentWithOverlay(boolean r1) {
        this.mUseOverlay = r1;
    }

    public boolean getReparent() {
        return this.mReparent;
    }

    public void setReparent(boolean r1) {
        this.mReparent = r1;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    private void captureValues(TransitionValues r5) {
        View r0 = r5.view;
        if (r0.getVisibility() != 8) goto L5;
        return;
    L5:
        r5.values.put(PROPNAME_PARENT, r0.getParent());
        r5.values.put(PROPNAME_TRANSFORMS, new Transforms(r0));
        Matrix r1 = r0.getMatrix();
        if (r1 != null) goto L8;
    L11:
        Matrix r2 = null;
    L12:
        r5.values.put(PROPNAME_MATRIX, r2);
        if (this.mReparent == false) goto L16;
        Matrix r4 = new Matrix();
        ViewGroup r3 = (ViewGroup) r0.getParent();
        ViewUtils.transformMatrixToGlobal(r3, r4);
        r4.preTranslate(-r3.getScrollX(), -r3.getScrollY());
        r5.values.put(PROPNAME_PARENT_MATRIX, r4);
        r5.values.put(PROPNAME_INTERMEDIATE_MATRIX, r0.getTag(R.id.transition_transform));
        r5.values.put(PROPNAME_INTERMEDIATE_PARENT_MATRIX, r0.getTag(R.id.parent_matrix));
        return;
    L16:
        return;
    L8:
        if (r1.isIdentity() == true) goto L11;
        r2 = new Matrix(r1);
        goto L12
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues r1) {
        captureValues(r1);
        if (SUPPORTS_VIEW_REMOVAL_SUPPRESSION == true) goto L6;
        ((ViewGroup) r1.view.getParent()).startViewTransition(r1.view);
        return;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues r1) {
        captureValues(r1);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup r6, TransitionValues r7, TransitionValues r8) {
        if (r7 == null) goto L33;
        if (r8 != null) goto L5;
        return null;
    L5:
        if (r7.values.containsKey(PROPNAME_PARENT) == true) goto L7;
        return null;
    L7:
        if (r8.values.containsKey(PROPNAME_PARENT) == false) goto L37;
        ViewGroup r0 = (ViewGroup) r7.values.get(PROPNAME_PARENT);
        ViewGroup r1 = (ViewGroup) r8.values.get(PROPNAME_PARENT);
        if (this.mReparent == true) goto L12;
    L14:
        boolean r2 = false;
    L15:
        Matrix r3 = (Matrix) r7.values.get(PROPNAME_INTERMEDIATE_MATRIX);
        if (r3 == null) goto L18;
        r7.values.put(PROPNAME_MATRIX, r3);
    L18:
        Matrix r4 = (Matrix) r7.values.get(PROPNAME_INTERMEDIATE_PARENT_MATRIX);
        if (r4 == null) goto L21;
        r7.values.put(PROPNAME_PARENT_MATRIX, r4);
    L21:
        if (r2 == false) goto L23;
        setMatricesForParent(r7, r8);
    L23:
        ObjectAnimator r5 = createTransformAnimator(r7, r8, r2);
        if (r2 == false) goto L30;
        if (r5 == null) goto L30;
        if (this.mUseOverlay == false) goto L30;
        createGhostView(r6, r7, r8);
    L32:
        return r5;
    L30:
        if (SUPPORTS_VIEW_REMOVAL_SUPPRESSION == true) goto L32;
        r0.endViewTransition(r7.view);
        goto L32
    L12:
        if (parentsMatch(r0, r1) == true) goto L14;
        r2 = true;
        goto L15
    L37:
        return null;
    L33:
        return null;
    }

    private ObjectAnimator createTransformAnimator(TransitionValues r13, TransitionValues r14, final boolean r15) {
        Matrix r16 = (Matrix) r13.values.get(PROPNAME_MATRIX);
        Matrix r0 = (Matrix) r14.values.get(PROPNAME_MATRIX);
        if (r16 != null) goto L5;
        r16 = MatrixUtils.IDENTITY_MATRIX;
    L5:
        if (r0 != null) goto L7;
        r0 = MatrixUtils.IDENTITY_MATRIX;
    L7:
        final Matrix r4 = r0;
        if (r16.equals(r4) == false) goto L11;
        return null;
    L11:
        final Transforms r6 = (Transforms) r14.values.get(PROPNAME_TRANSFORMS);
        final View r5 = r14.view;
        setIdentityTransforms(r5);
        float[] r1 = new float[9];
        r16.getValues(r1);
        float[] r17 = new float[9];
        r4.getValues(r17);
        final PathAnimatorMatrix r7 = new PathAnimatorMatrix(r5, r1);
        ObjectAnimator r18 = ObjectAnimator.ofPropertyValuesHolder(r7, new PropertyValuesHolder[]{PropertyValuesHolder.ofObject(NON_TRANSLATIONS_PROPERTY, new FloatArrayEvaluator(new float[9]), new float[][]{r1, r17}), PropertyValuesHolderUtils.ofPointF(TRANSLATIONS_PROPERTY, getPathMotion().getPath(r1[2], r1[5], r17[2], r17[5]))});
        AnimatorListenerAdapter r19 = new AnonymousClass3(this, r15, r4, r5, r6, r7);
        r18.addListener(r19);
        AnimatorUtils.addPauseListener(r18, r19);
        return r18;
    }

    private boolean parentsMatch(ViewGroup r4, ViewGroup r5) {
        boolean r1 = true;
        if (isValidTarget(r4) == true) goto L5;
    L12:
        if (r4 == r5) goto L16;
    L14:
        r1 = false;
    L16:
        return r1;
    L5:
        if (isValidTarget(r5) == false) goto L12;
        TransitionValues r3 = getMatchedTransitionValues(r4, true);
        if (r3 != null) goto L10;
        return false;
    L10:
        if (r5 != r3.view) goto L14;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [androidx.transition.Transition] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    private void createGhostView(ViewGroup r4, TransitionValues r5, TransitionValues r6) {
        View r0 = r6.view;
        Matrix r2 = new Matrix((Matrix) r6.values.get(PROPNAME_PARENT_MATRIX));
        ViewUtils.transformMatrixToLocal(r4, r2);
        GhostView r7 = GhostViewUtils.addGhost(r0, r4, r2);
        if (r7 != null) goto L5;
        return;
    L5:
        r7.reserveEndViewTransition((ViewGroup) r5.values.get(PROPNAME_PARENT), r5.view);
        ?? r3 = this;
    L7:
        if (r3.mParent == null) goto L9;
        r3 = r3.mParent;
        goto L7
    L9:
        r3.addListener(new GhostListener(r0, r7));
        if (SUPPORTS_VIEW_REMOVAL_SUPPRESSION == true) goto L12;
        return;
    L12:
        if (r5.view == r6.view) goto L14;
        ViewUtils.setTransitionAlpha(r5.view, 0.0f);
    L14:
        ViewUtils.setTransitionAlpha(r0, 1.0f);
    }

    private void setMatricesForParent(TransitionValues r4, TransitionValues r5) {
        Matrix r0 = (Matrix) r5.values.get(PROPNAME_PARENT_MATRIX);
        r5.view.setTag(R.id.parent_matrix, r0);
        Matrix r3 = this.mTempMatrix;
        r3.reset();
        r0.invert(r3);
        Matrix r6 = (Matrix) r4.values.get(PROPNAME_MATRIX);
        if (r6 != null) goto L5;
        r6 = new Matrix();
        r4.values.put(PROPNAME_MATRIX, r6);
    L5:
        r6.postConcat((Matrix) r4.values.get(PROPNAME_PARENT_MATRIX));
        r6.postConcat(r3);
    }

    static void setIdentityTransforms(View r9) {
        setTransforms(r9, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    static void setTransforms(View r0, float r1, float r2, float r3, float r4, float r5, float r6, float r7, float r8) {
        r0.setTranslationX(r1);
        r0.setTranslationY(r2);
        ViewCompat.setTranslationZ(r0, r3);
        r0.setScaleX(r4);
        r0.setScaleY(r5);
        r0.setRotationX(r6);
        r0.setRotationY(r7);
        r0.setRotation(r8);
    }
}
