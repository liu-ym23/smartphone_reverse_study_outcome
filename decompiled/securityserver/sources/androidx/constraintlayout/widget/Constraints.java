package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
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

        public LayoutParams(Context r4, AttributeSet r5) {
            super(r4, r5);
            this.alpha = 1.0f;
            int r1 = 0;
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
            TypedArray r6 = r4.obtainStyledAttributes(r5, R.styleable.ConstraintSet);
            int r7 = r6.getIndexCount();
        L3:
            if (r1 >= r7) goto L41;
            int r0 = r6.getIndex(r1);
            if (r0 != R.styleable.ConstraintSet_android_alpha) goto L8;
            this.alpha = r6.getFloat(r0, this.alpha);
        L40:
            r1 = r1 + 1;
            goto L3
        L8:
            if (r0 != R.styleable.ConstraintSet_android_elevation) goto L11;
            this.elevation = r6.getFloat(r0, this.elevation);
            this.applyElevation = true;
            goto L40
        L11:
            if (r0 != R.styleable.ConstraintSet_android_rotationX) goto L14;
            this.rotationX = r6.getFloat(r0, this.rotationX);
            goto L40
        L14:
            if (r0 != R.styleable.ConstraintSet_android_rotationY) goto L17;
            this.rotationY = r6.getFloat(r0, this.rotationY);
            goto L40
        L17:
            if (r0 != R.styleable.ConstraintSet_android_rotation) goto L20;
            this.rotation = r6.getFloat(r0, this.rotation);
            goto L40
        L20:
            if (r0 != R.styleable.ConstraintSet_android_scaleX) goto L23;
            this.scaleX = r6.getFloat(r0, this.scaleX);
            goto L40
        L23:
            if (r0 != R.styleable.ConstraintSet_android_scaleY) goto L26;
            this.scaleY = r6.getFloat(r0, this.scaleY);
            goto L40
        L26:
            if (r0 != R.styleable.ConstraintSet_android_transformPivotX) goto L29;
            this.transformPivotX = r6.getFloat(r0, this.transformPivotX);
            goto L40
        L29:
            if (r0 != R.styleable.ConstraintSet_android_transformPivotY) goto L32;
            this.transformPivotY = r6.getFloat(r0, this.transformPivotY);
            goto L40
        L32:
            if (r0 != R.styleable.ConstraintSet_android_translationX) goto L35;
            this.translationX = r6.getFloat(r0, this.translationX);
            goto L40
        L35:
            if (r0 != R.styleable.ConstraintSet_android_translationY) goto L38;
            this.translationY = r6.getFloat(r0, this.translationY);
            goto L40
        L38:
            if (r0 != R.styleable.ConstraintSet_android_translationZ) goto L40;
            this.translationZ = r6.getFloat(r0, this.translationZ);
            goto L40
        L41:
            r6.recycle();
        }
    }

    public Constraints(Context r1) {
        super(r1);
        super.setVisibility(8);
    }

    private void init(AttributeSet r1) {
        Log.v(TAG, " ################# init");
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    public ConstraintSet getConstraintSet() {
        if (this.myConstraintSet != null) goto L5;
        this.myConstraintSet = new ConstraintSet();
    L5:
        this.myConstraintSet.clone(this);
        return this.myConstraintSet;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r2) {
        return new LayoutParams(getContext(), r2);
    }

    public Constraints(Context r1, AttributeSet r2) {
        super(r1, r2);
        init(r2);
        super.setVisibility(8);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return new ConstraintLayout.LayoutParams(r1);
    }

    public Constraints(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        init(r2);
        super.setVisibility(8);
    }
}
