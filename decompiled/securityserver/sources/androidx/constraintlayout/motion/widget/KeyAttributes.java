package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class KeyAttributes extends Key {
    private static final boolean DEBUG = false;
    public static final int KEY_TYPE = 1;
    static final String NAME = "KeyAttribute";
    private static final String TAG = "KeyAttributes";
    private float mAlpha;
    private int mCurveFit;
    private float mElevation;
    private float mPivotX;
    private float mPivotY;
    private float mProgress;
    private float mRotation;
    private float mRotationX;
    private float mRotationY;
    private float mScaleX;
    private float mScaleY;
    private String mTransitionEasing;
    private float mTransitionPathRotate;
    private float mTranslationX;
    private float mTranslationY;
    private float mTranslationZ;
    private boolean mVisibility;

    public static class Loader {
        private static final int ANDROID_ALPHA = 1;
        private static final int ANDROID_ELEVATION = 2;
        private static final int ANDROID_PIVOT_X = 19;
        private static final int ANDROID_PIVOT_Y = 20;
        private static final int ANDROID_ROTATION = 4;
        private static final int ANDROID_ROTATION_X = 5;
        private static final int ANDROID_ROTATION_Y = 6;
        private static final int ANDROID_SCALE_X = 7;
        private static final int ANDROID_SCALE_Y = 14;
        private static final int ANDROID_TRANSLATION_X = 15;
        private static final int ANDROID_TRANSLATION_Y = 16;
        private static final int ANDROID_TRANSLATION_Z = 17;
        private static final int CURVE_FIT = 13;
        private static final int FRAME_POSITION = 12;
        private static final int PROGRESS = 18;
        private static final int TARGET_ID = 10;
        private static final int TRANSITION_EASING = 9;
        private static final int TRANSITION_PATH_ROTATE = 8;
        private static SparseIntArray mAttrMap;

        static {
            SparseIntArray r0 = new SparseIntArray();
            mAttrMap = r0;
            r0.append(R.styleable.KeyAttribute_android_alpha, 1);
            mAttrMap.append(R.styleable.KeyAttribute_android_elevation, 2);
            mAttrMap.append(R.styleable.KeyAttribute_android_rotation, 4);
            mAttrMap.append(R.styleable.KeyAttribute_android_rotationX, 5);
            mAttrMap.append(R.styleable.KeyAttribute_android_rotationY, 6);
            mAttrMap.append(R.styleable.KeyAttribute_android_transformPivotX, 19);
            mAttrMap.append(R.styleable.KeyAttribute_android_transformPivotY, 20);
            mAttrMap.append(R.styleable.KeyAttribute_android_scaleX, 7);
            mAttrMap.append(R.styleable.KeyAttribute_transitionPathRotate, 8);
            mAttrMap.append(R.styleable.KeyAttribute_transitionEasing, 9);
            mAttrMap.append(R.styleable.KeyAttribute_motionTarget, 10);
            mAttrMap.append(R.styleable.KeyAttribute_framePosition, 12);
            mAttrMap.append(R.styleable.KeyAttribute_curveFit, 13);
            mAttrMap.append(R.styleable.KeyAttribute_android_scaleY, 14);
            mAttrMap.append(R.styleable.KeyAttribute_android_translationX, 15);
            mAttrMap.append(R.styleable.KeyAttribute_android_translationY, 16);
            mAttrMap.append(R.styleable.KeyAttribute_android_translationZ, 17);
            mAttrMap.append(R.styleable.KeyAttribute_motionProgress, 18);
        }

        private Loader() {
        }

        public static void read(KeyAttributes r5, TypedArray r6) {
            int r0 = r6.getIndexCount();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L34;
            int r2 = r6.getIndex(r1);
            switch(mAttrMap.get(r2)) {
                case 1: goto L32;
                case 2: goto L31;
                case 3: goto L6;
                case 4: goto L30;
                case 5: goto L29;
                case 6: goto L28;
                case 7: goto L27;
                case 8: goto L26;
                case 9: goto L25;
                case 10: goto L17;
                case 11: goto L6;
                case 12: goto L15;
                case 13: goto L14;
                case 14: goto L13;
                case 15: goto L12;
                case 16: goto L11;
                case 17: goto L10;
                case 18: goto L9;
                case 19: goto L8;
                case 20: goto L7;
                default: goto L6;
            };
        L6:
            Log.e(KeyAttributes.NAME, "unused attribute 0x" + Integer.toHexString(r2) + "   " + mAttrMap.get(r2));
        L33:
            r1 = r1 + 1;
            goto L3
        L7:
            KeyAttributes.access$802(r5, r6.getDimension(r2, KeyAttributes.access$800(r5)));
            goto L33
        L8:
            KeyAttributes.access$702(r5, r6.getDimension(r2, KeyAttributes.access$700(r5)));
            goto L33
        L9:
            KeyAttributes.access$1502(r5, r6.getFloat(r2, KeyAttributes.access$1500(r5)));
            goto L33
        L10:
            KeyAttributes.access$1402(r5, r6.getDimension(r2, KeyAttributes.access$1400(r5)));
            goto L33
        L11:
            KeyAttributes.access$1302(r5, r6.getDimension(r2, KeyAttributes.access$1300(r5)));
            goto L33
        L12:
            KeyAttributes.access$1202(r5, r6.getDimension(r2, KeyAttributes.access$1200(r5)));
            goto L33
        L13:
            KeyAttributes.access$1002(r5, r6.getFloat(r2, KeyAttributes.access$1000(r5)));
            goto L33
        L14:
            KeyAttributes.access$302(r5, r6.getInteger(r2, KeyAttributes.access$300(r5)));
            goto L33
        L15:
            r5.mFramePosition = r6.getInt(r2, r5.mFramePosition);
            goto L33
        L25:
            KeyAttributes.access$902(r5, r6.getString(r2));
            goto L33
        L26:
            KeyAttributes.access$1102(r5, r6.getFloat(r2, KeyAttributes.access$1100(r5)));
            goto L33
        L27:
            KeyAttributes.access$402(r5, r6.getFloat(r2, KeyAttributes.access$400(r5)));
            goto L33
        L28:
            KeyAttributes.access$602(r5, r6.getFloat(r2, KeyAttributes.access$600(r5)));
            goto L33
        L29:
            KeyAttributes.access$502(r5, r6.getFloat(r2, KeyAttributes.access$500(r5)));
            goto L33
        L30:
            KeyAttributes.access$202(r5, r6.getFloat(r2, KeyAttributes.access$200(r5)));
            goto L33
        L31:
            KeyAttributes.access$102(r5, r6.getDimension(r2, KeyAttributes.access$100(r5)));
            goto L33
        L32:
            KeyAttributes.access$002(r5, r6.getFloat(r2, KeyAttributes.access$000(r5)));
            goto L33
        L17:
            if (MotionLayout.IS_IN_EDIT_MODE == false) goto L22;
            int r3 = r6.getResourceId(r2, r5.mTargetId);
            r5.mTargetId = r3;
            if (r3 != (-1)) goto L33;
            r5.mTargetString = r6.getString(r2);
            goto L33
        L22:
            if (r6.peekValue(r2).type != 3) goto L24;
            r5.mTargetString = r6.getString(r2);
            goto L33
        L24:
            r5.mTargetId = r6.getResourceId(r2, r5.mTargetId);
            goto L33
        }
    }

    public KeyAttributes() {
        this.mCurveFit = -1;
        this.mVisibility = false;
        this.mAlpha = Float.NaN;
        this.mElevation = Float.NaN;
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
        this.mProgress = Float.NaN;
        this.mType = 1;
        this.mCustomConstraints = new HashMap();
    }

    public static /* synthetic */ float access$000(KeyAttributes r0) {
        return r0.mAlpha;
    }

    public static /* synthetic */ float access$002(KeyAttributes r0, float r1) {
        r0.mAlpha = r1;
        return r1;
    }

    public static /* synthetic */ float access$100(KeyAttributes r0) {
        return r0.mElevation;
    }

    public static /* synthetic */ float access$1000(KeyAttributes r0) {
        return r0.mScaleY;
    }

    public static /* synthetic */ float access$1002(KeyAttributes r0, float r1) {
        r0.mScaleY = r1;
        return r1;
    }

    public static /* synthetic */ float access$102(KeyAttributes r0, float r1) {
        r0.mElevation = r1;
        return r1;
    }

    public static /* synthetic */ float access$1100(KeyAttributes r0) {
        return r0.mTransitionPathRotate;
    }

    public static /* synthetic */ float access$1102(KeyAttributes r0, float r1) {
        r0.mTransitionPathRotate = r1;
        return r1;
    }

    public static /* synthetic */ float access$1200(KeyAttributes r0) {
        return r0.mTranslationX;
    }

    public static /* synthetic */ float access$1202(KeyAttributes r0, float r1) {
        r0.mTranslationX = r1;
        return r1;
    }

    public static /* synthetic */ float access$1300(KeyAttributes r0) {
        return r0.mTranslationY;
    }

    public static /* synthetic */ float access$1302(KeyAttributes r0, float r1) {
        r0.mTranslationY = r1;
        return r1;
    }

    public static /* synthetic */ float access$1400(KeyAttributes r0) {
        return r0.mTranslationZ;
    }

    public static /* synthetic */ float access$1402(KeyAttributes r0, float r1) {
        r0.mTranslationZ = r1;
        return r1;
    }

    public static /* synthetic */ float access$1500(KeyAttributes r0) {
        return r0.mProgress;
    }

    public static /* synthetic */ float access$1502(KeyAttributes r0, float r1) {
        r0.mProgress = r1;
        return r1;
    }

    public static /* synthetic */ float access$200(KeyAttributes r0) {
        return r0.mRotation;
    }

    public static /* synthetic */ float access$202(KeyAttributes r0, float r1) {
        r0.mRotation = r1;
        return r1;
    }

    public static /* synthetic */ int access$300(KeyAttributes r0) {
        return r0.mCurveFit;
    }

    public static /* synthetic */ int access$302(KeyAttributes r0, int r1) {
        r0.mCurveFit = r1;
        return r1;
    }

    public static /* synthetic */ float access$400(KeyAttributes r0) {
        return r0.mScaleX;
    }

    public static /* synthetic */ float access$402(KeyAttributes r0, float r1) {
        r0.mScaleX = r1;
        return r1;
    }

    public static /* synthetic */ float access$500(KeyAttributes r0) {
        return r0.mRotationX;
    }

    public static /* synthetic */ float access$502(KeyAttributes r0, float r1) {
        r0.mRotationX = r1;
        return r1;
    }

    public static /* synthetic */ float access$600(KeyAttributes r0) {
        return r0.mRotationY;
    }

    public static /* synthetic */ float access$602(KeyAttributes r0, float r1) {
        r0.mRotationY = r1;
        return r1;
    }

    public static /* synthetic */ float access$700(KeyAttributes r0) {
        return r0.mPivotX;
    }

    public static /* synthetic */ float access$702(KeyAttributes r0, float r1) {
        r0.mPivotX = r1;
        return r1;
    }

    public static /* synthetic */ float access$800(KeyAttributes r0) {
        return r0.mPivotY;
    }

    public static /* synthetic */ float access$802(KeyAttributes r0, float r1) {
        r0.mPivotY = r1;
        return r1;
    }

    public static /* synthetic */ String access$902(KeyAttributes r0, String r1) {
        r0.mTransitionEasing = r1;
        return r1;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, ViewSpline> r7) {
        Iterator<String> r1 = r7.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L116;
        String r2 = r1.next();
        ViewSpline r3 = r7.get(r2);
        if (r3 == null) goto L4;
        if (r2.startsWith("CUSTOM") == true) goto L10;
        byte r4 = -1;
        switch(r2.hashCode()) {
            case -1249320806: goto L69;
            case -1249320805: goto L65;
            case -1225497657: goto L61;
            case -1225497656: goto L57;
            case -1225497655: goto L53;
            case -1001078227: goto L49;
            case -908189618: goto L45;
            case -908189617: goto L41;
            case -760884510: goto L37;
            case -760884509: goto L33;
            case -40300674: goto L29;
            case -4379043: goto L25;
            case 37232917: goto L21;
            case 92909918: goto L17;
            default: goto L72;
        };
    L72:
        switch(r4) {
            case 0: goto L114;
            case 1: goto L111;
            case 2: goto L108;
            case 3: goto L105;
            case 4: goto L102;
            case 5: goto L99;
            case 6: goto L96;
            case 7: goto L93;
            case 8: goto L90;
            case 9: goto L87;
            case 10: goto L84;
            case 11: goto L81;
            case 12: goto L78;
            case 13: goto L75;
            default: goto L4;
        };
    L75:
        if (Float.isNaN(this.mAlpha) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mAlpha);
        goto L4
    L78:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mTransitionPathRotate);
        goto L4
    L81:
        if (Float.isNaN(this.mElevation) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mElevation);
        goto L4
    L84:
        if (Float.isNaN(this.mRotation) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mRotation);
        goto L4
    L87:
        if (Float.isNaN(this.mRotationY) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mPivotY);
        goto L4
    L90:
        if (Float.isNaN(this.mRotationX) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mPivotX);
        goto L4
    L93:
        if (Float.isNaN(this.mScaleY) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mScaleY);
        goto L4
    L96:
        if (Float.isNaN(this.mScaleX) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mScaleX);
        goto L4
    L99:
        if (Float.isNaN(this.mProgress) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mProgress);
        goto L4
    L102:
        if (Float.isNaN(this.mTranslationZ) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mTranslationZ);
        goto L4
    L105:
        if (Float.isNaN(this.mTranslationY) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mTranslationY);
        goto L4
    L108:
        if (Float.isNaN(this.mTranslationX) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mTranslationX);
        goto L4
    L111:
        if (Float.isNaN(this.mRotationY) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mRotationY);
        goto L4
    L114:
        if (Float.isNaN(this.mRotationX) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mRotationX);
        goto L4
    L17:
        if (r2.equals("alpha") == false) goto L72;
        r4 = 13;
        goto L72
    L21:
        if (r2.equals("transitionPathRotate") == false) goto L72;
        r4 = 12;
        goto L72
    L25:
        if (r2.equals("elevation") == false) goto L72;
        r4 = 11;
        goto L72
    L29:
        if (r2.equals(Key.ROTATION) == false) goto L72;
        r4 = 10;
        goto L72
    L33:
        if (r2.equals(Key.PIVOT_Y) == false) goto L72;
        r4 = 9;
        goto L72
    L37:
        if (r2.equals(Key.PIVOT_X) == false) goto L72;
        r4 = 8;
        goto L72
    L41:
        if (r2.equals("scaleY") == false) goto L72;
        r4 = 7;
        goto L72
    L45:
        if (r2.equals("scaleX") == false) goto L72;
        r4 = 6;
        goto L72
    L49:
        if (r2.equals("progress") == false) goto L72;
        r4 = 5;
        goto L72
    L53:
        if (r2.equals("translationZ") == false) goto L72;
        r4 = 4;
        goto L72
    L57:
        if (r2.equals("translationY") == false) goto L72;
        r4 = 3;
        goto L72
    L61:
        if (r2.equals("translationX") == false) goto L72;
        r4 = 2;
        goto L72
    L65:
        if (r2.equals("rotationY") == false) goto L72;
        r4 = 1;
        goto L72
    L69:
        if (r2.equals("rotationX") == false) goto L72;
        r4 = 0;
        goto L72
    L10:
        ConstraintAttribute r5 = this.mCustomConstraints.get(r2.substring(7));
        if (r5 == null) goto L4;
        ((ViewSpline.CustomSet) r3).setPoint(this.mFramePosition, r5);
        goto L4
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo3clone() {
        return clone();
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key copy(Key r2) {
        super.copy(r2);
        KeyAttributes r3 = (KeyAttributes) r2;
        this.mCurveFit = r3.mCurveFit;
        this.mVisibility = r3.mVisibility;
        this.mAlpha = r3.mAlpha;
        this.mElevation = r3.mElevation;
        this.mRotation = r3.mRotation;
        this.mRotationX = r3.mRotationX;
        this.mRotationY = r3.mRotationY;
        this.mPivotX = r3.mPivotX;
        this.mPivotY = r3.mPivotY;
        this.mTransitionPathRotate = r3.mTransitionPathRotate;
        this.mScaleX = r3.mScaleX;
        this.mScaleY = r3.mScaleY;
        this.mTranslationX = r3.mTranslationX;
        this.mTranslationY = r3.mTranslationY;
        this.mTranslationZ = r3.mTranslationZ;
        this.mProgress = r3.mProgress;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> r4) {
        if (Float.isNaN(this.mAlpha) == true) goto L6;
        r4.add("alpha");
    L6:
        if (Float.isNaN(this.mElevation) == true) goto L9;
        r4.add("elevation");
    L9:
        if (Float.isNaN(this.mRotation) == true) goto L12;
        r4.add(Key.ROTATION);
    L12:
        if (Float.isNaN(this.mRotationX) == true) goto L15;
        r4.add("rotationX");
    L15:
        if (Float.isNaN(this.mRotationY) == true) goto L18;
        r4.add("rotationY");
    L18:
        if (Float.isNaN(this.mPivotX) == true) goto L21;
        r4.add(Key.PIVOT_X);
    L21:
        if (Float.isNaN(this.mPivotY) == true) goto L24;
        r4.add(Key.PIVOT_Y);
    L24:
        if (Float.isNaN(this.mTranslationX) == true) goto L27;
        r4.add("translationX");
    L27:
        if (Float.isNaN(this.mTranslationY) == true) goto L30;
        r4.add("translationY");
    L30:
        if (Float.isNaN(this.mTranslationZ) == true) goto L33;
        r4.add("translationZ");
    L33:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L36;
        r4.add("transitionPathRotate");
    L36:
        if (Float.isNaN(this.mScaleX) == true) goto L39;
        r4.add("scaleX");
    L39:
        if (Float.isNaN(this.mScaleY) == true) goto L42;
        r4.add("scaleY");
    L42:
        if (Float.isNaN(this.mProgress) == true) goto L45;
        r4.add("progress");
    L45:
        if (this.mCustomConstraints.size() <= 0) goto L50;
        Iterator<String> r3 = this.mCustomConstraints.keySet().iterator();
    L48:
        if (r3.hasNext() == false) goto L52;
        r4.add("CUSTOM," + r3.next());
        goto L48
    L52:
        return;
    }

    public int getCurveFit() {
        return this.mCurveFit;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context r2, AttributeSet r3) {
        Loader.read(this, r2.obtainStyledAttributes(r3, R.styleable.KeyAttribute));
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setInterpolation(HashMap<String, Integer> r4) {
        if (this.mCurveFit != (-1)) goto L6;
        return;
    L6:
        if (Float.isNaN(this.mAlpha) == true) goto L9;
        r4.put("alpha", Integer.valueOf(this.mCurveFit));
    L9:
        if (Float.isNaN(this.mElevation) == true) goto L12;
        r4.put("elevation", Integer.valueOf(this.mCurveFit));
    L12:
        if (Float.isNaN(this.mRotation) == true) goto L15;
        r4.put(Key.ROTATION, Integer.valueOf(this.mCurveFit));
    L15:
        if (Float.isNaN(this.mRotationX) == true) goto L18;
        r4.put("rotationX", Integer.valueOf(this.mCurveFit));
    L18:
        if (Float.isNaN(this.mRotationY) == true) goto L21;
        r4.put("rotationY", Integer.valueOf(this.mCurveFit));
    L21:
        if (Float.isNaN(this.mPivotX) == true) goto L24;
        r4.put(Key.PIVOT_X, Integer.valueOf(this.mCurveFit));
    L24:
        if (Float.isNaN(this.mPivotY) == true) goto L27;
        r4.put(Key.PIVOT_Y, Integer.valueOf(this.mCurveFit));
    L27:
        if (Float.isNaN(this.mTranslationX) == true) goto L30;
        r4.put("translationX", Integer.valueOf(this.mCurveFit));
    L30:
        if (Float.isNaN(this.mTranslationY) == true) goto L33;
        r4.put("translationY", Integer.valueOf(this.mCurveFit));
    L33:
        if (Float.isNaN(this.mTranslationZ) == true) goto L36;
        r4.put("translationZ", Integer.valueOf(this.mCurveFit));
    L36:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L39;
        r4.put("transitionPathRotate", Integer.valueOf(this.mCurveFit));
    L39:
        if (Float.isNaN(this.mScaleX) == true) goto L42;
        r4.put("scaleX", Integer.valueOf(this.mCurveFit));
    L42:
        if (Float.isNaN(this.mScaleY) == true) goto L45;
        r4.put("scaleY", Integer.valueOf(this.mCurveFit));
    L45:
        if (Float.isNaN(this.mProgress) == true) goto L48;
        r4.put("progress", Integer.valueOf(this.mCurveFit));
    L48:
        if (this.mCustomConstraints.size() <= 0) goto L53;
        Iterator<String> r0 = this.mCustomConstraints.keySet().iterator();
    L51:
        if (r0.hasNext() == false) goto L55;
        r4.put(a.a.A("CUSTOM,", r0.next()), Integer.valueOf(this.mCurveFit));
        goto L51
    L55:
        return;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String r3, Object r4) {
        r3.getClass();
        byte r0 = -1;
        switch(r3.hashCode()) {
            case -1913008125: goto L70;
            case -1812823328: goto L66;
            case -1249320806: goto L62;
            case -1249320805: goto L58;
            case -1225497657: goto L54;
            case -1225497656: goto L50;
            case -1225497655: goto L46;
            case -908189618: goto L42;
            case -908189617: goto L38;
            case -760884510: goto L34;
            case -760884509: goto L30;
            case -40300674: goto L26;
            case -4379043: goto L22;
            case 37232917: goto L18;
            case 92909918: goto L14;
            case 579057826: goto L10;
            case 1941332754: goto L6;
            default: goto L73;
        };
    L73:
        switch(r0) {
            case 0: goto L91;
            case 1: goto L90;
            case 2: goto L89;
            case 3: goto L88;
            case 4: goto L87;
            case 5: goto L86;
            case 6: goto L85;
            case 7: goto L84;
            case 8: goto L83;
            case 9: goto L82;
            case 10: goto L81;
            case 11: goto L80;
            case 12: goto L79;
            case 13: goto L78;
            case 14: goto L77;
            case 15: goto L76;
            case 16: goto L75;
            default: goto L109;
        };
    L75:
        this.mVisibility = toBoolean(r4);
        return;
    L76:
        this.mCurveFit = toInt(r4);
        return;
    L77:
        this.mAlpha = toFloat(r4);
        return;
    L78:
        this.mTransitionPathRotate = toFloat(r4);
        return;
    L79:
        this.mElevation = toFloat(r4);
        return;
    L80:
        this.mRotation = toFloat(r4);
        return;
    L81:
        this.mPivotY = toFloat(r4);
        return;
    L82:
        this.mPivotX = toFloat(r4);
        return;
    L83:
        this.mScaleY = toFloat(r4);
        return;
    L84:
        this.mScaleX = toFloat(r4);
        return;
    L85:
        this.mTranslationZ = toFloat(r4);
        return;
    L86:
        this.mTranslationY = toFloat(r4);
        return;
    L87:
        this.mTranslationX = toFloat(r4);
        return;
    L88:
        this.mRotationY = toFloat(r4);
        return;
    L89:
        this.mRotationX = toFloat(r4);
        return;
    L90:
        this.mTransitionEasing = r4.toString();
        return;
    L91:
        this.mProgress = toFloat(r4);
        return;
    L109:
        return;
    L6:
        if (r3.equals("visibility") == false) goto L73;
        r0 = 16;
        goto L73
    L10:
        if (r3.equals("curveFit") == false) goto L73;
        r0 = 15;
        goto L73
    L14:
        if (r3.equals("alpha") == false) goto L73;
        r0 = 14;
        goto L73
    L18:
        if (r3.equals("transitionPathRotate") == false) goto L73;
        r0 = 13;
        goto L73
    L22:
        if (r3.equals("elevation") == false) goto L73;
        r0 = 12;
        goto L73
    L26:
        if (r3.equals(Key.ROTATION) == false) goto L73;
        r0 = 11;
        goto L73
    L30:
        if (r3.equals(Key.PIVOT_Y) == false) goto L73;
        r0 = 10;
        goto L73
    L34:
        if (r3.equals(Key.PIVOT_X) == false) goto L73;
        r0 = 9;
        goto L73
    L38:
        if (r3.equals("scaleY") == false) goto L73;
        r0 = 8;
        goto L73
    L42:
        if (r3.equals("scaleX") == false) goto L73;
        r0 = 7;
        goto L73
    L46:
        if (r3.equals("translationZ") == false) goto L73;
        r0 = 6;
        goto L73
    L50:
        if (r3.equals("translationY") == false) goto L73;
        r0 = 5;
        goto L73
    L54:
        if (r3.equals("translationX") == false) goto L73;
        r0 = 4;
        goto L73
    L58:
        if (r3.equals("rotationY") == false) goto L73;
        r0 = 3;
        goto L73
    L62:
        if (r3.equals("rotationX") == false) goto L73;
        r0 = 2;
        goto L73
    L66:
        if (r3.equals("transitionEasing") == false) goto L73;
        r0 = 1;
        goto L73
    L70:
        if (r3.equals(Key.MOTIONPROGRESS) == false) goto L73;
        r0 = 0;
        goto L73
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key clone() {
        return new KeyAttributes().copy(this);
    }
}
