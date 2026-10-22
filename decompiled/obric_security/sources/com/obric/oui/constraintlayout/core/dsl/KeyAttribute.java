package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes3.dex */
public class KeyAttribute extends Keys {
    protected String TYPE;
    private float mAlpha;
    private Fit mCurveFit;
    private int mFrame;
    private float mPivotX;
    private float mPivotY;
    private float mRotation;
    private float mRotationX;
    private float mRotationY;
    private float mScaleX;
    private float mScaleY;
    private String mTarget;
    private String mTransitionEasing;
    private float mTransitionPathRotate;
    private float mTranslationX;
    private float mTranslationY;
    private float mTranslationZ;
    private Visibility mVisibility;

    public static final enum Fit extends Enum<Fit> {
        private static final /* synthetic */ Fit[] $VALUES = null;
        public static final Fit LINEAR = null;
        public static final Fit SPLINE = null;

        private Fit(String r1, int r2) {
            super(r1, r2);
        }

        public static Fit valueOf(String r1) {
            return (Fit) Enum.valueOf(Fit.class, r1);
        }

        public static Fit[] values() {
            return (Fit[]) $VALUES.clone();
        }

        static {
            Fit r0 = new Fit("SPLINE", 0);
            SPLINE = r0;
            Fit r1 = new Fit("LINEAR", 1);
            LINEAR = r1;
            $VALUES = new Fit[]{r0, r1};
        }
    }

    public static final enum Visibility extends Enum<Visibility> {
        private static final /* synthetic */ Visibility[] $VALUES = null;
        public static final Visibility GONE = null;
        public static final Visibility INVISIBLE = null;
        public static final Visibility VISIBLE = null;

        private Visibility(String r1, int r2) {
            super(r1, r2);
        }

        public static Visibility valueOf(String r1) {
            return (Visibility) Enum.valueOf(Visibility.class, r1);
        }

        public static Visibility[] values() {
            return (Visibility[]) $VALUES.clone();
        }

        static {
            Visibility r0 = new Visibility("VISIBLE", 0);
            VISIBLE = r0;
            Visibility r1 = new Visibility("INVISIBLE", 1);
            INVISIBLE = r1;
            Visibility r3 = new Visibility("GONE", 2);
            GONE = r3;
            $VALUES = new Visibility[]{r0, r1, r3};
        }
    }

    public KeyAttribute(int r2, String r3) {
        this.TYPE = "KeyAttributes";
        this.mCurveFit = null;
        this.mVisibility = null;
        this.mAlpha = Float.NaN;
        this.mRotation = Float.NaN;
        this.mRotationX = Float.NaN;
        this.mRotationY = Float.NaN;
        this.mPivotX = Float.NaN;
        this.mPivotY = Float.NaN;
        this.mTransitionPathRotate = Float.NaN;
        this.mScaleX = Float.NaN;
        this.mScaleY = Float.NaN;
        this.mTranslationX = Float.NaN;
        this.mTranslationY = Float.NaN;
        this.mTranslationZ = Float.NaN;
        this.mTarget = r3;
        this.mFrame = r2;
    }

    public String getTarget() {
        return this.mTarget;
    }

    public void setTarget(String r1) {
        this.mTarget = r1;
    }

    public String getTransitionEasing() {
        return this.mTransitionEasing;
    }

    public void setTransitionEasing(String r1) {
        this.mTransitionEasing = r1;
    }

    public Fit getCurveFit() {
        return this.mCurveFit;
    }

    public void setCurveFit(Fit r1) {
        this.mCurveFit = r1;
    }

    public Visibility getVisibility() {
        return this.mVisibility;
    }

    public void setVisibility(Visibility r1) {
        this.mVisibility = r1;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public void setAlpha(float r1) {
        this.mAlpha = r1;
    }

    public float getRotation() {
        return this.mRotation;
    }

    public void setRotation(float r1) {
        this.mRotation = r1;
    }

    public float getRotationX() {
        return this.mRotationX;
    }

    public void setRotationX(float r1) {
        this.mRotationX = r1;
    }

    public float getRotationY() {
        return this.mRotationY;
    }

    public void setRotationY(float r1) {
        this.mRotationY = r1;
    }

    public float getPivotX() {
        return this.mPivotX;
    }

    public void setPivotX(float r1) {
        this.mPivotX = r1;
    }

    public float getPivotY() {
        return this.mPivotY;
    }

    public void setPivotY(float r1) {
        this.mPivotY = r1;
    }

    public float getTransitionPathRotate() {
        return this.mTransitionPathRotate;
    }

    public void setTransitionPathRotate(float r1) {
        this.mTransitionPathRotate = r1;
    }

    public float getScaleX() {
        return this.mScaleX;
    }

    public void setScaleX(float r1) {
        this.mScaleX = r1;
    }

    public float getScaleY() {
        return this.mScaleY;
    }

    public void setScaleY(float r1) {
        this.mScaleY = r1;
    }

    public float getTranslationX() {
        return this.mTranslationX;
    }

    public void setTranslationX(float r1) {
        this.mTranslationX = r1;
    }

    public float getTranslationY() {
        return this.mTranslationY;
    }

    public void setTranslationY(float r1) {
        this.mTranslationY = r1;
    }

    public float getTranslationZ() {
        return this.mTranslationZ;
    }

    public void setTranslationZ(float r1) {
        this.mTranslationZ = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.TYPE);
        r0.append(":{\n");
        attributesToString(r0);
        r0.append("},\n");
        return r0.toString();
    }

    protected void attributesToString(StringBuilder r4) {
        append(r4, "target", this.mTarget);
        r4.append("frame:").append(this.mFrame).append(",\n");
        append(r4, "easing", this.mTransitionEasing);
        if (this.mCurveFit == null) goto L6;
        r4.append("fit:'").append(this.mCurveFit).append("',\n");
    L6:
        if (this.mVisibility == null) goto L8;
        r4.append("visibility:'").append(this.mVisibility).append("',\n");
    L8:
        append(r4, "alpha", this.mAlpha);
        append(r4, "rotationX", this.mRotationX);
        append(r4, "rotationY", this.mRotationY);
        append(r4, "rotationZ", this.mRotation);
        append(r4, "pivotX", this.mPivotX);
        append(r4, "pivotY", this.mPivotY);
        append(r4, "pathRotate", this.mTransitionPathRotate);
        append(r4, "scaleX", this.mScaleX);
        append(r4, "scaleY", this.mScaleY);
        append(r4, "translationX", this.mTranslationX);
        append(r4, "translationY", this.mTranslationY);
        append(r4, "translationZ", this.mTranslationZ);
    }
}
