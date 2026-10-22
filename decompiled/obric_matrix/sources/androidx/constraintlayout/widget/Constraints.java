package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class Constraints extends ViewGroup {
    public static final String TAG = "Constraints";
    ConstraintSet myConstraintSet;

    public static class LayoutParams extends ConstraintLayout.LayoutParams {
        public float alpha;
        public boolean applyElevation;
        public float elevation;
        public float rotation;
        public float rotationX;
        public float rotationY;
        public float scaleX;
        public float scaleY;
        public float transformPivotX;
        public float transformPivotY;
        public float translationX;
        public float translationY;
        public float translationZ;

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.alpha = 1.0f;
            this.applyElevation = false;
            this.elevation = 0.0f;
            this.rotation = 0.0f;
            this.rotationX = 0.0f;
            this.rotationY = 0.0f;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.transformPivotX = 0.0f;
            this.transformPivotY = 0.0f;
            this.translationX = 0.0f;
            this.translationY = 0.0f;
            this.translationZ = 0.0f;
        }

        public LayoutParams(Context r6, AttributeSet r7) {
            int r0 = Build.VERSION.SDK_INT;
            super(r6, r7);
            this.alpha = 1.0f;
            int r2 = 0;
            this.applyElevation = false;
            this.elevation = 0.0f;
            this.rotation = 0.0f;
            this.rotationX = 0.0f;
            this.rotationY = 0.0f;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.transformPivotX = 0.0f;
            this.transformPivotY = 0.0f;
            this.translationX = 0.0f;
            this.translationY = 0.0f;
            this.translationZ = 0.0f;
            TypedArray r8 = r6.obtainStyledAttributes(r7, R.styleable.ConstraintSet);
            int r9 = r8.getIndexCount();
        L3:
            if (r2 >= r9) goto L43;
            int r1 = r8.getIndex(r2);
            if (r1 != R.styleable.ConstraintSet_android_alpha) goto L8;
            this.alpha = r8.getFloat(r1, this.alpha);
        L42:
            r2 = r2 + 1;
            goto L3
        L8:
            if (r1 != R.styleable.ConstraintSet_android_elevation) goto L12;
            if (r0 < 21) goto L42;
            this.elevation = r8.getFloat(r1, this.elevation);
            this.applyElevation = true;
            goto L42
        L12:
            if (r1 != R.styleable.ConstraintSet_android_rotationX) goto L15;
            this.rotationX = r8.getFloat(r1, this.rotationX);
            goto L42
        L15:
            if (r1 != R.styleable.ConstraintSet_android_rotationY) goto L18;
            this.rotationY = r8.getFloat(r1, this.rotationY);
            goto L42
        L18:
            if (r1 != R.styleable.ConstraintSet_android_rotation) goto L21;
            this.rotation = r8.getFloat(r1, this.rotation);
            goto L42
        L21:
            if (r1 != R.styleable.ConstraintSet_android_scaleX) goto L24;
            this.scaleX = r8.getFloat(r1, this.scaleX);
            goto L42
        L24:
            if (r1 != R.styleable.ConstraintSet_android_scaleY) goto L27;
            this.scaleY = r8.getFloat(r1, this.scaleY);
            goto L42
        L27:
            if (r1 != R.styleable.ConstraintSet_android_transformPivotX) goto L30;
            this.transformPivotX = r8.getFloat(r1, this.transformPivotX);
            goto L42
        L30:
            if (r1 != R.styleable.ConstraintSet_android_transformPivotY) goto L33;
            this.transformPivotY = r8.getFloat(r1, this.transformPivotY);
            goto L42
        L33:
            if (r1 != R.styleable.ConstraintSet_android_translationX) goto L36;
            this.translationX = r8.getFloat(r1, this.translationX);
            goto L42
        L36:
            if (r1 != R.styleable.ConstraintSet_android_translationY) goto L39;
            this.translationY = r8.getFloat(r1, this.translationY);
            goto L42
        L39:
            if (r1 != R.styleable.ConstraintSet_android_translationZ) goto L42;
            if (r0 < 21) goto L42;
            this.translationZ = r8.getFloat(r1, this.translationZ);
            goto L42
        L43:
            r8.recycle();
        }

        public LayoutParams(LayoutParams r2) {
            super(r2);
            this.alpha = 1.0f;
            this.applyElevation = false;
            this.elevation = 0.0f;
            this.rotation = 0.0f;
            this.rotationX = 0.0f;
            this.rotationY = 0.0f;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.transformPivotX = 0.0f;
            this.transformPivotY = 0.0f;
            this.translationX = 0.0f;
            this.translationY = 0.0f;
            this.translationZ = 0.0f;
        }
    }

    public Constraints(Context r1) {
        super(r1);
        super.setVisibility(8);
    }

    public Constraints(Context r1, AttributeSet r2) {
        super(r1, r2);
        init(r2);
        super.setVisibility(8);
    }

    public Constraints(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        init(r2);
        super.setVisibility(8);
    }

    private void init(AttributeSet r1) {
        Log.v(TAG, " ################# init");
    }

    @Override // android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return new ConstraintLayout.LayoutParams(r1);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r2) {
        return new LayoutParams(getContext(), r2);
    }

    public ConstraintSet getConstraintSet() {
        if (this.myConstraintSet != null) goto L5;
        this.myConstraintSet = new ConstraintSet();
    L5:
        this.myConstraintSet.clone(this);
        return this.myConstraintSet;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
    }
}
