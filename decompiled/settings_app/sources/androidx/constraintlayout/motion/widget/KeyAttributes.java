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

    private static class Loader {
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

        private Loader() {
        }

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

        public static void read(KeyAttributes c, TypedArray a) {
            int r0 = a.getIndexCount();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L34;
            int r2 = a.getIndex(r1);
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
            KeyAttributes.access$802(c, a.getDimension(r2, KeyAttributes.access$800(c)));
            goto L33
        L8:
            KeyAttributes.access$702(c, a.getDimension(r2, KeyAttributes.access$700(c)));
            goto L33
        L9:
            KeyAttributes.access$1502(c, a.getFloat(r2, KeyAttributes.access$1500(c)));
            goto L33
        L10:
            KeyAttributes.access$1402(c, a.getDimension(r2, KeyAttributes.access$1400(c)));
            goto L33
        L11:
            KeyAttributes.access$1302(c, a.getDimension(r2, KeyAttributes.access$1300(c)));
            goto L33
        L12:
            KeyAttributes.access$1202(c, a.getDimension(r2, KeyAttributes.access$1200(c)));
            goto L33
        L13:
            KeyAttributes.access$1002(c, a.getFloat(r2, KeyAttributes.access$1000(c)));
            goto L33
        L14:
            KeyAttributes.access$302(c, a.getInteger(r2, KeyAttributes.access$300(c)));
            goto L33
        L15:
            c.mFramePosition = a.getInt(r2, c.mFramePosition);
            goto L33
        L25:
            KeyAttributes.access$902(c, a.getString(r2));
            goto L33
        L26:
            KeyAttributes.access$1102(c, a.getFloat(r2, KeyAttributes.access$1100(c)));
            goto L33
        L27:
            KeyAttributes.access$402(c, a.getFloat(r2, KeyAttributes.access$400(c)));
            goto L33
        L28:
            KeyAttributes.access$602(c, a.getFloat(r2, KeyAttributes.access$600(c)));
            goto L33
        L29:
            KeyAttributes.access$502(c, a.getFloat(r2, KeyAttributes.access$500(c)));
            goto L33
        L30:
            KeyAttributes.access$202(c, a.getFloat(r2, KeyAttributes.access$200(c)));
            goto L33
        L31:
            KeyAttributes.access$102(c, a.getDimension(r2, KeyAttributes.access$100(c)));
            goto L33
        L32:
            KeyAttributes.access$002(c, a.getFloat(r2, KeyAttributes.access$000(c)));
            goto L33
        L17:
            if (MotionLayout.IS_IN_EDIT_MODE == false) goto L22;
            c.mTargetId = a.getResourceId(r2, c.mTargetId);
            if (c.mTargetId != (-1)) goto L33;
            c.mTargetString = a.getString(r2);
            goto L33
        L22:
            if (a.peekValue(r2).type != 3) goto L24;
            c.mTargetString = a.getString(r2);
            goto L33
        L24:
            c.mTargetId = a.getResourceId(r2, c.mTargetId);
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

    static /* synthetic */ float access$000(KeyAttributes r0) {
        return r0.mAlpha;
    }

    static /* synthetic */ float access$002(KeyAttributes r0, float r1) {
        r0.mAlpha = r1;
        return r1;
    }

    static /* synthetic */ float access$100(KeyAttributes r0) {
        return r0.mElevation;
    }

    static /* synthetic */ float access$1000(KeyAttributes r0) {
        return r0.mScaleY;
    }

    static /* synthetic */ float access$1002(KeyAttributes r0, float r1) {
        r0.mScaleY = r1;
        return r1;
    }

    static /* synthetic */ float access$102(KeyAttributes r0, float r1) {
        r0.mElevation = r1;
        return r1;
    }

    static /* synthetic */ float access$1100(KeyAttributes r0) {
        return r0.mTransitionPathRotate;
    }

    static /* synthetic */ float access$1102(KeyAttributes r0, float r1) {
        r0.mTransitionPathRotate = r1;
        return r1;
    }

    static /* synthetic */ float access$1200(KeyAttributes r0) {
        return r0.mTranslationX;
    }

    static /* synthetic */ float access$1202(KeyAttributes r0, float r1) {
        r0.mTranslationX = r1;
        return r1;
    }

    static /* synthetic */ float access$1300(KeyAttributes r0) {
        return r0.mTranslationY;
    }

    static /* synthetic */ float access$1302(KeyAttributes r0, float r1) {
        r0.mTranslationY = r1;
        return r1;
    }

    static /* synthetic */ float access$1400(KeyAttributes r0) {
        return r0.mTranslationZ;
    }

    static /* synthetic */ float access$1402(KeyAttributes r0, float r1) {
        r0.mTranslationZ = r1;
        return r1;
    }

    static /* synthetic */ float access$1500(KeyAttributes r0) {
        return r0.mProgress;
    }

    static /* synthetic */ float access$1502(KeyAttributes r0, float r1) {
        r0.mProgress = r1;
        return r1;
    }

    static /* synthetic */ float access$200(KeyAttributes r0) {
        return r0.mRotation;
    }

    static /* synthetic */ float access$202(KeyAttributes r0, float r1) {
        r0.mRotation = r1;
        return r1;
    }

    static /* synthetic */ int access$300(KeyAttributes r0) {
        return r0.mCurveFit;
    }

    static /* synthetic */ int access$302(KeyAttributes r0, int r1) {
        r0.mCurveFit = r1;
        return r1;
    }

    static /* synthetic */ float access$400(KeyAttributes r0) {
        return r0.mScaleX;
    }

    static /* synthetic */ float access$402(KeyAttributes r0, float r1) {
        r0.mScaleX = r1;
        return r1;
    }

    static /* synthetic */ float access$500(KeyAttributes r0) {
        return r0.mRotationX;
    }

    static /* synthetic */ float access$502(KeyAttributes r0, float r1) {
        r0.mRotationX = r1;
        return r1;
    }

    static /* synthetic */ float access$600(KeyAttributes r0) {
        return r0.mRotationY;
    }

    static /* synthetic */ float access$602(KeyAttributes r0, float r1) {
        r0.mRotationY = r1;
        return r1;
    }

    static /* synthetic */ float access$700(KeyAttributes r0) {
        return r0.mPivotX;
    }

    static /* synthetic */ float access$702(KeyAttributes r0, float r1) {
        r0.mPivotX = r1;
        return r1;
    }

    static /* synthetic */ float access$800(KeyAttributes r0) {
        return r0.mPivotY;
    }

    static /* synthetic */ float access$802(KeyAttributes r0, float r1) {
        r0.mPivotY = r1;
        return r1;
    }

    static /* synthetic */ String access$902(KeyAttributes r0, String r1) {
        r0.mTransitionEasing = r1;
        return r1;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo12clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attrs) {
        Loader.read(this, context.obtainStyledAttributes(attrs, R.styleable.KeyAttribute));
    }

    int getCurveFit() {
        return this.mCurveFit;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> attributes) {
        if (Float.isNaN(this.mAlpha) == true) goto L6;
        attributes.add("alpha");
    L6:
        if (Float.isNaN(this.mElevation) == true) goto L9;
        attributes.add("elevation");
    L9:
        if (Float.isNaN(this.mRotation) == true) goto L12;
        attributes.add("rotation");
    L12:
        if (Float.isNaN(this.mRotationX) == true) goto L15;
        attributes.add("rotationX");
    L15:
        if (Float.isNaN(this.mRotationY) == true) goto L18;
        attributes.add("rotationY");
    L18:
        if (Float.isNaN(this.mPivotX) == true) goto L21;
        attributes.add("transformPivotX");
    L21:
        if (Float.isNaN(this.mPivotY) == true) goto L24;
        attributes.add("transformPivotY");
    L24:
        if (Float.isNaN(this.mTranslationX) == true) goto L27;
        attributes.add("translationX");
    L27:
        if (Float.isNaN(this.mTranslationY) == true) goto L30;
        attributes.add("translationY");
    L30:
        if (Float.isNaN(this.mTranslationZ) == true) goto L33;
        attributes.add("translationZ");
    L33:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L36;
        attributes.add("transitionPathRotate");
    L36:
        if (Float.isNaN(this.mScaleX) == true) goto L39;
        attributes.add("scaleX");
    L39:
        if (Float.isNaN(this.mScaleY) == true) goto L42;
        attributes.add("scaleY");
    L42:
        if (Float.isNaN(this.mProgress) == true) goto L45;
        attributes.add("progress");
    L45:
        if (this.mCustomConstraints.size() <= 0) goto L50;
        Iterator<String> r3 = this.mCustomConstraints.keySet().iterator();
    L48:
        if (r3.hasNext() == false) goto L52;
        attributes.add("CUSTOM," + r3.next());
        goto L48
    L52:
        return;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setInterpolation(HashMap<String, Integer> interpolation) {
        if (this.mCurveFit != (-1)) goto L6;
        return;
    L6:
        if (Float.isNaN(this.mAlpha) == true) goto L9;
        interpolation.put("alpha", Integer.valueOf(this.mCurveFit));
    L9:
        if (Float.isNaN(this.mElevation) == true) goto L12;
        interpolation.put("elevation", Integer.valueOf(this.mCurveFit));
    L12:
        if (Float.isNaN(this.mRotation) == true) goto L15;
        interpolation.put("rotation", Integer.valueOf(this.mCurveFit));
    L15:
        if (Float.isNaN(this.mRotationX) == true) goto L18;
        interpolation.put("rotationX", Integer.valueOf(this.mCurveFit));
    L18:
        if (Float.isNaN(this.mRotationY) == true) goto L21;
        interpolation.put("rotationY", Integer.valueOf(this.mCurveFit));
    L21:
        if (Float.isNaN(this.mPivotX) == true) goto L24;
        interpolation.put("transformPivotX", Integer.valueOf(this.mCurveFit));
    L24:
        if (Float.isNaN(this.mPivotY) == true) goto L27;
        interpolation.put("transformPivotY", Integer.valueOf(this.mCurveFit));
    L27:
        if (Float.isNaN(this.mTranslationX) == true) goto L30;
        interpolation.put("translationX", Integer.valueOf(this.mCurveFit));
    L30:
        if (Float.isNaN(this.mTranslationY) == true) goto L33;
        interpolation.put("translationY", Integer.valueOf(this.mCurveFit));
    L33:
        if (Float.isNaN(this.mTranslationZ) == true) goto L36;
        interpolation.put("translationZ", Integer.valueOf(this.mCurveFit));
    L36:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L39;
        interpolation.put("transitionPathRotate", Integer.valueOf(this.mCurveFit));
    L39:
        if (Float.isNaN(this.mScaleX) == true) goto L42;
        interpolation.put("scaleX", Integer.valueOf(this.mCurveFit));
    L42:
        if (Float.isNaN(this.mScaleY) == true) goto L45;
        interpolation.put("scaleY", Integer.valueOf(this.mCurveFit));
    L45:
        if (Float.isNaN(this.mProgress) == true) goto L48;
        interpolation.put("progress", Integer.valueOf(this.mCurveFit));
    L48:
        if (this.mCustomConstraints.size() <= 0) goto L53;
        Iterator<String> r0 = this.mCustomConstraints.keySet().iterator();
    L51:
        if (r0.hasNext() == false) goto L55;
        interpolation.put("CUSTOM," + r0.next(), Integer.valueOf(this.mCurveFit));
        goto L51
    L55:
        return;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, ViewSpline> splines) {
        Iterator<String> r0 = splines.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L115;
        String r1 = r0.next();
        ViewSpline r2 = splines.get(r1);
        if (r2 == null) goto L4;
        byte r4 = 7;
        if (r1.startsWith("CUSTOM") == true) goto L10;
        r1.hashCode();
        switch(r1.hashCode()) {
            case -1249320806: goto L68;
            case -1249320805: goto L64;
            case -1225497657: goto L60;
            case -1225497656: goto L56;
            case -1225497655: goto L52;
            case -1001078227: goto L48;
            case -908189618: goto L44;
            case -908189617: goto L41;
            case -760884510: goto L37;
            case -760884509: goto L33;
            case -40300674: goto L29;
            case -4379043: goto L25;
            case 37232917: goto L21;
            case 92909918: goto L17;
            default: goto L15;
        };
    L15:
        r4 = -1;
    L71:
        switch(r4) {
            case 0: goto L113;
            case 1: goto L110;
            case 2: goto L107;
            case 3: goto L104;
            case 4: goto L101;
            case 5: goto L98;
            case 6: goto L95;
            case 7: goto L92;
            case 8: goto L89;
            case 9: goto L86;
            case 10: goto L83;
            case 11: goto L80;
            case 12: goto L77;
            case 13: goto L74;
            default: goto L4;
        };
    L74:
        if (Float.isNaN(this.mAlpha) == true) goto L4;
        r2.setPoint(this.mFramePosition, this.mAlpha);
        goto L4
    L77:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L4;
        r2.setPoint(this.mFramePosition, this.mTransitionPathRotate);
        goto L4
    L80:
        if (Float.isNaN(this.mElevation) == true) goto L4;
        r2.setPoint(this.mFramePosition, this.mElevation);
        goto L4
    L83:
        if (Float.isNaN(this.mRotation) == true) goto L4;
        r2.setPoint(this.mFramePosition, this.mRotation);
        goto L4
    L86:
        if (Float.isNaN(this.mRotationY) == true) goto L4;
        r2.setPoint(this.mFramePosition, this.mPivotY);
        goto L4
    L89:
        if (Float.isNaN(this.mRotationX) == true) goto L4;
        r2.setPoint(this.mFramePosition, this.mPivotX);
        goto L4
    L92:
        if (Float.isNaN(this.mScaleY) == true) goto L4;
        r2.setPoint(this.mFramePosition, this.mScaleY);
        goto L4
    L95:
        if (Float.isNaN(this.mScaleX) == true) goto L4;
        r2.setPoint(this.mFramePosition, this.mScaleX);
        goto L4
    L98:
        if (Float.isNaN(this.mProgress) == true) goto L4;
        r2.setPoint(this.mFramePosition, this.mProgress);
        goto L4
    L101:
        if (Float.isNaN(this.mTranslationZ) == true) goto L4;
        r2.setPoint(this.mFramePosition, this.mTranslationZ);
        goto L4
    L104:
        if (Float.isNaN(this.mTranslationY) == true) goto L4;
        r2.setPoint(this.mFramePosition, this.mTranslationY);
        goto L4
    L107:
        if (Float.isNaN(this.mTranslationX) == true) goto L4;
        r2.setPoint(this.mFramePosition, this.mTranslationX);
        goto L4
    L110:
        if (Float.isNaN(this.mRotationY) == true) goto L4;
        r2.setPoint(this.mFramePosition, this.mRotationY);
        goto L4
    L113:
        if (Float.isNaN(this.mRotationX) == true) goto L4;
        r2.setPoint(this.mFramePosition, this.mRotationX);
        goto L4
    L17:
        if (r1.equals("alpha") == false) goto L182;
        r4 = 13;
        goto L71
    L182:
        r4 = -1;
        goto L71
    L21:
        if (r1.equals("transitionPathRotate") == false) goto L183;
        r4 = 12;
        goto L71
    L183:
        r4 = -1;
        goto L71
    L25:
        if (r1.equals("elevation") == false) goto L184;
        r4 = 11;
        goto L71
    L184:
        r4 = -1;
        goto L71
    L29:
        if (r1.equals("rotation") == false) goto L185;
        r4 = 10;
        goto L71
    L185:
        r4 = -1;
        goto L71
    L33:
        if (r1.equals("transformPivotY") == false) goto L186;
        r4 = 9;
        goto L71
    L186:
        r4 = -1;
        goto L71
    L37:
        if (r1.equals("transformPivotX") == false) goto L187;
        r4 = 8;
        goto L71
    L187:
        r4 = -1;
        goto L71
    L41:
        if (r1.equals("scaleY") == true) goto L71;
        r4 = -1;
        goto L71
    L44:
        if (r1.equals("scaleX") == false) goto L189;
        r4 = 6;
        goto L71
    L189:
        r4 = -1;
        goto L71
    L48:
        if (r1.equals("progress") == false) goto L190;
        r4 = 5;
        goto L71
    L190:
        r4 = -1;
        goto L71
    L52:
        if (r1.equals("translationZ") == false) goto L191;
        r4 = 4;
        goto L71
    L191:
        r4 = -1;
        goto L71
    L56:
        if (r1.equals("translationY") == false) goto L192;
        r4 = 3;
        goto L71
    L192:
        r4 = -1;
        goto L71
    L60:
        if (r1.equals("translationX") == false) goto L193;
        r4 = 2;
        goto L71
    L193:
        r4 = -1;
        goto L71
    L64:
        if (r1.equals("rotationY") == false) goto L194;
        r4 = 1;
        goto L71
    L194:
        r4 = -1;
        goto L71
    L68:
        if (r1.equals("rotationX") == false) goto L195;
        r4 = 0;
        goto L71
    L195:
        r4 = -1;
        goto L71
    L10:
        ConstraintAttribute r3 = this.mCustomConstraints.get(r1.substring(7));
        if (r3 == null) goto L4;
        ((ViewSpline.CustomSet) r2).setPoint(this.mFramePosition, r3);
        goto L4
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String tag, Object value) {
        tag.hashCode();
        byte r1 = -1;
        switch(tag.hashCode()) {
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
        switch(r1) {
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
        this.mVisibility = toBoolean(value);
        return;
    L76:
        this.mCurveFit = toInt(value);
        return;
    L77:
        this.mAlpha = toFloat(value);
        return;
    L78:
        this.mTransitionPathRotate = toFloat(value);
        return;
    L79:
        this.mElevation = toFloat(value);
        return;
    L80:
        this.mRotation = toFloat(value);
        return;
    L81:
        this.mPivotY = toFloat(value);
        return;
    L82:
        this.mPivotX = toFloat(value);
        return;
    L83:
        this.mScaleY = toFloat(value);
        return;
    L84:
        this.mScaleX = toFloat(value);
        return;
    L85:
        this.mTranslationZ = toFloat(value);
        return;
    L86:
        this.mTranslationY = toFloat(value);
        return;
    L87:
        this.mTranslationX = toFloat(value);
        return;
    L88:
        this.mRotationY = toFloat(value);
        return;
    L89:
        this.mRotationX = toFloat(value);
        return;
    L90:
        this.mTransitionEasing = value.toString();
        return;
    L91:
        this.mProgress = toFloat(value);
        return;
    L109:
        return;
    L6:
        if (tag.equals("visibility") == false) goto L73;
        r1 = 16;
        goto L73
    L10:
        if (tag.equals("curveFit") == false) goto L73;
        r1 = 15;
        goto L73
    L14:
        if (tag.equals("alpha") == false) goto L73;
        r1 = 14;
        goto L73
    L18:
        if (tag.equals("transitionPathRotate") == false) goto L73;
        r1 = 13;
        goto L73
    L22:
        if (tag.equals("elevation") == false) goto L73;
        r1 = 12;
        goto L73
    L26:
        if (tag.equals("rotation") == false) goto L73;
        r1 = 11;
        goto L73
    L30:
        if (tag.equals("transformPivotY") == false) goto L73;
        r1 = 10;
        goto L73
    L34:
        if (tag.equals("transformPivotX") == false) goto L73;
        r1 = 9;
        goto L73
    L38:
        if (tag.equals("scaleY") == false) goto L73;
        r1 = 8;
        goto L73
    L42:
        if (tag.equals("scaleX") == false) goto L73;
        r1 = 7;
        goto L73
    L46:
        if (tag.equals("translationZ") == false) goto L73;
        r1 = 6;
        goto L73
    L50:
        if (tag.equals("translationY") == false) goto L73;
        r1 = 5;
        goto L73
    L54:
        if (tag.equals("translationX") == false) goto L73;
        r1 = 4;
        goto L73
    L58:
        if (tag.equals("rotationY") == false) goto L73;
        r1 = 3;
        goto L73
    L62:
        if (tag.equals("rotationX") == false) goto L73;
        r1 = 2;
        goto L73
    L66:
        if (tag.equals("transitionEasing") == false) goto L73;
        r1 = 1;
        goto L73
    L70:
        if (tag.equals("motionProgress") == false) goto L73;
        r1 = 0;
        goto L73
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key copy(Key src) {
        super.copy(src);
        KeyAttributes r2 = (KeyAttributes) src;
        this.mCurveFit = r2.mCurveFit;
        this.mVisibility = r2.mVisibility;
        this.mAlpha = r2.mAlpha;
        this.mElevation = r2.mElevation;
        this.mRotation = r2.mRotation;
        this.mRotationX = r2.mRotationX;
        this.mRotationY = r2.mRotationY;
        this.mPivotX = r2.mPivotX;
        this.mPivotY = r2.mPivotY;
        this.mTransitionPathRotate = r2.mTransitionPathRotate;
        this.mScaleX = r2.mScaleX;
        this.mScaleY = r2.mScaleY;
        this.mTranslationX = r2.mTranslationX;
        this.mTranslationY = r2.mTranslationY;
        this.mTranslationZ = r2.mTranslationZ;
        this.mProgress = r2.mProgress;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key clone() {
        return new KeyAttributes().copy(this);
    }
}
