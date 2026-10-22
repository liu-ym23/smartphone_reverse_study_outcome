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

        public LayoutParams(int width, int height) {
            super(width, height);
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

        public LayoutParams(LayoutParams source) {
            super(source);
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

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
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
            TypedArray r4 = c.obtainStyledAttributes(attrs, R.styleable.ConstraintSet);
            int r5 = r4.getIndexCount();
        L3:
            if (r1 >= r5) goto L41;
            int r0 = r4.getIndex(r1);
            if (r0 != R.styleable.ConstraintSet_android_alpha) goto L8;
            this.alpha = r4.getFloat(r0, this.alpha);
        L40:
            r1 = r1 + 1;
            goto L3
        L8:
            if (r0 != R.styleable.ConstraintSet_android_elevation) goto L11;
            this.elevation = r4.getFloat(r0, this.elevation);
            this.applyElevation = true;
            goto L40
        L11:
            if (r0 != R.styleable.ConstraintSet_android_rotationX) goto L14;
            this.rotationX = r4.getFloat(r0, this.rotationX);
            goto L40
        L14:
            if (r0 != R.styleable.ConstraintSet_android_rotationY) goto L17;
            this.rotationY = r4.getFloat(r0, this.rotationY);
            goto L40
        L17:
            if (r0 != R.styleable.ConstraintSet_android_rotation) goto L20;
            this.rotation = r4.getFloat(r0, this.rotation);
            goto L40
        L20:
            if (r0 != R.styleable.ConstraintSet_android_scaleX) goto L23;
            this.scaleX = r4.getFloat(r0, this.scaleX);
            goto L40
        L23:
            if (r0 != R.styleable.ConstraintSet_android_scaleY) goto L26;
            this.scaleY = r4.getFloat(r0, this.scaleY);
            goto L40
        L26:
            if (r0 != R.styleable.ConstraintSet_android_transformPivotX) goto L29;
            this.transformPivotX = r4.getFloat(r0, this.transformPivotX);
            goto L40
        L29:
            if (r0 != R.styleable.ConstraintSet_android_transformPivotY) goto L32;
            this.transformPivotY = r4.getFloat(r0, this.transformPivotY);
            goto L40
        L32:
            if (r0 != R.styleable.ConstraintSet_android_translationX) goto L35;
            this.translationX = r4.getFloat(r0, this.translationX);
            goto L40
        L35:
            if (r0 != R.styleable.ConstraintSet_android_translationY) goto L38;
            this.translationY = r4.getFloat(r0, this.translationY);
            goto L40
        L38:
            if (r0 != R.styleable.ConstraintSet_android_translationZ) goto L40;
            this.translationZ = r4.getFloat(r0, this.translationZ);
            goto L40
        L41:
            r4.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
    }

    @Override // android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return generateLayoutParams(attrs);
    }

    public Constraints(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public Constraints(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
        super.setVisibility(8);
    }

    public Constraints(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
        super.setVisibility(8);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    @Override // android.view.ViewGroup
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    private void init(AttributeSet attrs) {
        Log.v("Constraints", " ################# init");
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return new ConstraintLayout.LayoutParams(p);
    }

    public ConstraintSet getConstraintSet() {
        if (this.myConstraintSet != null) goto L5;
        this.myConstraintSet = new ConstraintSet();
    L5:
        this.myConstraintSet.clone(this);
        return this.myConstraintSet;
    }
}
