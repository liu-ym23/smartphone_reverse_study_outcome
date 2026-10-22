package androidx.constraintlayout.core.motion.key;

import a.a;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class MotionKeyAttributes extends MotionKey {
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
    private int mVisibility;

    public MotionKeyAttributes() {
        this.mCurveFit = -1;
        this.mVisibility = 0;
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
        this.mCustom = new HashMap();
    }

    private float getFloatValue(int r2) {
        if (r2 == 100) goto L36;
        switch(r2) {
            case 303: goto L34;
            case 304: goto L32;
            case 305: goto L30;
            case 306: goto L28;
            case 307: goto L26;
            case 308: goto L24;
            case 309: goto L22;
            case 310: goto L20;
            case 311: goto L18;
            case 312: goto L16;
            case 313: goto L14;
            case 314: goto L12;
            case 315: goto L10;
            case 316: goto L8;
            default: goto L5;
        };
    L5:
        return Float.NaN;
    L8:
        return this.mTransitionPathRotate;
    L10:
        return this.mProgress;
    L12:
        return this.mPivotY;
    L14:
        return this.mPivotX;
    L16:
        return this.mScaleY;
    L18:
        return this.mScaleX;
    L20:
        return this.mRotation;
    L22:
        return this.mRotationY;
    L24:
        return this.mRotationX;
    L26:
        return this.mElevation;
    L28:
        return this.mTranslationZ;
    L30:
        return this.mTranslationY;
    L32:
        return this.mTranslationX;
    L34:
        return this.mAlpha;
    L36:
        return this.mFramePosition;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void addValues(HashMap<String, SplineSet> r7) {
        Iterator<String> r1 = r7.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L116;
        String r2 = r1.next();
        SplineSet r3 = r7.get(r2);
        if (r3 == null) goto L4;
        if (r2.startsWith("CUSTOM") == true) goto L10;
        byte r4 = -1;
        switch(r2.hashCode()) {
            case -1249320806: goto L69;
            case -1249320805: goto L65;
            case -1249320804: goto L61;
            case -1225497657: goto L57;
            case -1225497656: goto L53;
            case -1225497655: goto L49;
            case -1001078227: goto L45;
            case -987906986: goto L41;
            case -987906985: goto L37;
            case -908189618: goto L33;
            case -908189617: goto L29;
            case -4379043: goto L25;
            case 92909918: goto L21;
            case 803192288: goto L17;
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
            default: goto L73;
        };
    L75:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mTransitionPathRotate);
        goto L4
    L78:
        if (Float.isNaN(this.mAlpha) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mAlpha);
        goto L4
    L81:
        if (Float.isNaN(this.mElevation) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mElevation);
        goto L4
    L84:
        if (Float.isNaN(this.mScaleY) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mScaleY);
        goto L4
    L87:
        if (Float.isNaN(this.mScaleX) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mScaleX);
        goto L4
    L90:
        if (Float.isNaN(this.mRotationY) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mPivotY);
        goto L4
    L93:
        if (Float.isNaN(this.mRotationX) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mPivotX);
        goto L4
    L96:
        if (Float.isNaN(this.mProgress) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mProgress);
        goto L4
    L99:
        if (Float.isNaN(this.mTranslationZ) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mTranslationZ);
        goto L4
    L102:
        if (Float.isNaN(this.mTranslationY) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mTranslationY);
        goto L4
    L105:
        if (Float.isNaN(this.mTranslationX) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mTranslationX);
        goto L4
    L108:
        if (Float.isNaN(this.mRotation) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mRotation);
        goto L4
    L111:
        if (Float.isNaN(this.mRotationY) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mRotationY);
        goto L4
    L114:
        if (Float.isNaN(this.mRotationX) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mRotationX);
        goto L4
    L73:
        System.err.println("not supported by KeyAttributes ".concat(r2));
        goto L4
    L17:
        if (r2.equals("pathRotate") == false) goto L72;
        r4 = 13;
        goto L72
    L21:
        if (r2.equals("alpha") == false) goto L72;
        r4 = 12;
        goto L72
    L25:
        if (r2.equals("elevation") == false) goto L72;
        r4 = 11;
        goto L72
    L29:
        if (r2.equals("scaleY") == false) goto L72;
        r4 = 10;
        goto L72
    L33:
        if (r2.equals("scaleX") == false) goto L72;
        r4 = 9;
        goto L72
    L37:
        if (r2.equals("pivotY") == false) goto L72;
        r4 = 8;
        goto L72
    L41:
        if (r2.equals("pivotX") == false) goto L72;
        r4 = 7;
        goto L72
    L45:
        if (r2.equals("progress") == false) goto L72;
        r4 = 6;
        goto L72
    L49:
        if (r2.equals("translationZ") == false) goto L72;
        r4 = 5;
        goto L72
    L53:
        if (r2.equals("translationY") == false) goto L72;
        r4 = 4;
        goto L72
    L57:
        if (r2.equals("translationX") == false) goto L72;
        r4 = 3;
        goto L72
    L61:
        if (r2.equals("rotationZ") == false) goto L72;
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
        CustomVariable r5 = this.mCustom.get(r2.substring(7));
        if (r5 == null) goto L4;
        ((SplineSet.CustomSpline) r3).setPoint(this.mFramePosition, r5);
        goto L4
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKey clone() {
        return null;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void getAttributeNames(HashSet<String> r4) {
        if (Float.isNaN(this.mAlpha) == true) goto L6;
        r4.add("alpha");
    L6:
        if (Float.isNaN(this.mElevation) == true) goto L9;
        r4.add("elevation");
    L9:
        if (Float.isNaN(this.mRotation) == true) goto L12;
        r4.add("rotationZ");
    L12:
        if (Float.isNaN(this.mRotationX) == true) goto L15;
        r4.add("rotationX");
    L15:
        if (Float.isNaN(this.mRotationY) == true) goto L18;
        r4.add("rotationY");
    L18:
        if (Float.isNaN(this.mPivotX) == true) goto L21;
        r4.add("pivotX");
    L21:
        if (Float.isNaN(this.mPivotY) == true) goto L24;
        r4.add("pivotY");
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
        r4.add("pathRotate");
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
        if (this.mCustom.size() <= 0) goto L50;
        Iterator<String> r3 = this.mCustom.keySet().iterator();
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

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String r1) {
        return TypedValues.AttributesType.getId(r1);
    }

    public void printAttributes() {
        HashSet<String> r0 = new HashSet();
        getAttributeNames(r0);
        System.out.println(" ------------- " + this.mFramePosition + " -------------");
        int r1 = 0;
        String[] r2 = (String[]) r0.toArray(new String[0]);
    L4:
        if (r1 >= r2.length) goto L6;
        int r3 = TypedValues.AttributesType.getId(r2[r1]);
        System.out.println(r2[r1] + ":" + getFloatValue(r3));
        r1 = r1 + 1;
        goto L4
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void setInterpolation(HashMap<String, Integer> r4) {
        if (Float.isNaN(this.mAlpha) == true) goto L6;
        r4.put("alpha", Integer.valueOf(this.mCurveFit));
    L6:
        if (Float.isNaN(this.mElevation) == true) goto L9;
        r4.put("elevation", Integer.valueOf(this.mCurveFit));
    L9:
        if (Float.isNaN(this.mRotation) == true) goto L12;
        r4.put("rotationZ", Integer.valueOf(this.mCurveFit));
    L12:
        if (Float.isNaN(this.mRotationX) == true) goto L15;
        r4.put("rotationX", Integer.valueOf(this.mCurveFit));
    L15:
        if (Float.isNaN(this.mRotationY) == true) goto L18;
        r4.put("rotationY", Integer.valueOf(this.mCurveFit));
    L18:
        if (Float.isNaN(this.mPivotX) == true) goto L21;
        r4.put("pivotX", Integer.valueOf(this.mCurveFit));
    L21:
        if (Float.isNaN(this.mPivotY) == true) goto L24;
        r4.put("pivotY", Integer.valueOf(this.mCurveFit));
    L24:
        if (Float.isNaN(this.mTranslationX) == true) goto L27;
        r4.put("translationX", Integer.valueOf(this.mCurveFit));
    L27:
        if (Float.isNaN(this.mTranslationY) == true) goto L30;
        r4.put("translationY", Integer.valueOf(this.mCurveFit));
    L30:
        if (Float.isNaN(this.mTranslationZ) == true) goto L33;
        r4.put("translationZ", Integer.valueOf(this.mCurveFit));
    L33:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L36;
        r4.put("pathRotate", Integer.valueOf(this.mCurveFit));
    L36:
        if (Float.isNaN(this.mScaleX) == true) goto L39;
        r4.put("scaleX", Integer.valueOf(this.mCurveFit));
    L39:
        if (Float.isNaN(this.mScaleY) == true) goto L42;
        r4.put("scaleY", Integer.valueOf(this.mCurveFit));
    L42:
        if (Float.isNaN(this.mProgress) == true) goto L45;
        r4.put("progress", Integer.valueOf(this.mCurveFit));
    L45:
        if (this.mCustom.size() <= 0) goto L50;
        Iterator<String> r0 = this.mCustom.keySet().iterator();
    L48:
        if (r0.hasNext() == false) goto L52;
        r4.put(a.A("CUSTOM,", r0.next()), Integer.valueOf(this.mCurveFit));
        goto L48
    L52:
        return;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, int r3) {
        if (r2 != 100) goto L5;
        this.mFramePosition = r3;
        return true;
    L5:
        if (r2 != 301) goto L7;
        this.mCurveFit = r3;
        return true;
    L7:
        if (r2 != 302) goto L9;
        this.mVisibility = r3;
        return true;
    L9:
        if (setValue(r2, r3) == false) goto L11;
        return true;
    L11:
        return super.setValue(r2, r3);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo2clone() {
        return clone();
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, float r3) {
        if (r2 == 100) goto L21;
        switch(r2) {
            case 303: goto L20;
            case 304: goto L19;
            case 305: goto L18;
            case 306: goto L17;
            case 307: goto L16;
            case 308: goto L15;
            case 309: goto L14;
            case 310: goto L13;
            case 311: goto L12;
            case 312: goto L11;
            case 313: goto L10;
            case 314: goto L9;
            case 315: goto L8;
            case 316: goto L7;
            default: goto L6;
        };
    L7:
        this.mTransitionPathRotate = r3;
        return true;
    L8:
        this.mProgress = r3;
        return true;
    L9:
        this.mPivotY = r3;
        return true;
    L10:
        this.mPivotX = r3;
        return true;
    L11:
        this.mScaleY = r3;
        return true;
    L12:
        this.mScaleX = r3;
        return true;
    L13:
        this.mRotation = r3;
        return true;
    L14:
        this.mRotationY = r3;
        return true;
    L15:
        this.mRotationX = r3;
        return true;
    L16:
        this.mElevation = r3;
        return true;
    L17:
        this.mTranslationZ = r3;
        return true;
    L18:
        this.mTranslationY = r3;
        return true;
    L19:
        this.mTranslationX = r3;
        return true;
    L20:
        this.mAlpha = r3;
        return true;
    L6:
        return super.setValue(r2, r3);
    L21:
        this.mTransitionPathRotate = r3;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, String r3) {
        if (r2 != 101) goto L5;
        this.mTargetString = r3;
        return true;
    L5:
        if (r2 != 317) goto L7;
        this.mTransitionEasing = r3;
        return true;
    L7:
        return super.setValue(r2, r3);
    }
}
