package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.motion.utils.Utils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class MotionKeyTimeCycle extends MotionKey {
    public static final int KEY_TYPE = 3;
    static final String NAME = "KeyTimeCycle";
    private static final String TAG = "KeyTimeCycle";
    private float mAlpha;
    private int mCurveFit;
    private String mCustomWaveShape;
    private float mElevation;
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
    private float mWaveOffset;
    private float mWavePeriod;
    private int mWaveShape;

    public MotionKeyTimeCycle() {
        this.mCurveFit = -1;
        this.mAlpha = Float.NaN;
        this.mElevation = Float.NaN;
        this.mRotation = Float.NaN;
        this.mRotationX = Float.NaN;
        this.mRotationY = Float.NaN;
        this.mTransitionPathRotate = Float.NaN;
        this.mScaleX = Float.NaN;
        this.mScaleY = Float.NaN;
        this.mTranslationX = Float.NaN;
        this.mTranslationY = Float.NaN;
        this.mTranslationZ = Float.NaN;
        this.mProgress = Float.NaN;
        this.mWaveShape = 0;
        this.mCustomWaveShape = null;
        this.mWavePeriod = Float.NaN;
        this.mWaveOffset = 0.0f;
        this.mType = 3;
        this.mCustom = new HashMap();
    }

    public void addTimeValues(HashMap<String, TimeCycleSplineSet> r12) {
        Iterator<String> r1 = r12.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L102;
        String r2 = r1.next();
        TimeCycleSplineSet r4 = r12.get(r2);
        if (r4 == null) goto L4;
        if (r2.startsWith("CUSTOM") == true) goto L10;
        byte r3 = -1;
        switch(r2.hashCode()) {
            case -1249320806: goto L61;
            case -1249320805: goto L57;
            case -1249320804: goto L53;
            case -1225497657: goto L49;
            case -1225497656: goto L45;
            case -1225497655: goto L41;
            case -1001078227: goto L37;
            case -908189618: goto L33;
            case -908189617: goto L29;
            case -4379043: goto L25;
            case 92909918: goto L21;
            case 803192288: goto L17;
            default: goto L64;
        };
    L64:
        switch(r3) {
            case 0: goto L100;
            case 1: goto L97;
            case 2: goto L94;
            case 3: goto L91;
            case 4: goto L88;
            case 5: goto L85;
            case 6: goto L82;
            case 7: goto L79;
            case 8: goto L76;
            case 9: goto L73;
            case 10: goto L70;
            case 11: goto L67;
            default: goto L65;
        };
    L67:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L4;
        r4.setPoint(this.mFramePosition, this.mTransitionPathRotate, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L70:
        if (Float.isNaN(this.mAlpha) == true) goto L4;
        r4.setPoint(this.mFramePosition, this.mAlpha, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L73:
        if (Float.isNaN(this.mTranslationZ) == true) goto L4;
        r4.setPoint(this.mFramePosition, this.mTranslationZ, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L76:
        if (Float.isNaN(this.mScaleY) == true) goto L4;
        r4.setPoint(this.mFramePosition, this.mScaleY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L79:
        if (Float.isNaN(this.mScaleX) == true) goto L4;
        r4.setPoint(this.mFramePosition, this.mScaleX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L82:
        if (Float.isNaN(this.mProgress) == true) goto L4;
        r4.setPoint(this.mFramePosition, this.mProgress, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L85:
        if (Float.isNaN(this.mTranslationZ) == true) goto L4;
        r4.setPoint(this.mFramePosition, this.mTranslationZ, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L88:
        if (Float.isNaN(this.mTranslationY) == true) goto L4;
        r4.setPoint(this.mFramePosition, this.mTranslationY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L91:
        if (Float.isNaN(this.mTranslationX) == true) goto L4;
        r4.setPoint(this.mFramePosition, this.mTranslationX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L94:
        if (Float.isNaN(this.mRotation) == true) goto L4;
        r4.setPoint(this.mFramePosition, this.mRotation, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L97:
        if (Float.isNaN(this.mRotationY) == true) goto L4;
        r4.setPoint(this.mFramePosition, this.mRotationY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L100:
        if (Float.isNaN(this.mRotationX) == true) goto L4;
        r4.setPoint(this.mFramePosition, this.mRotationX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L65:
        Utils.loge("KeyTimeCycles", "UNKNOWN addValues \"" + r2 + "\"");
        goto L4
    L17:
        if (r2.equals("pathRotate") == false) goto L64;
        r3 = 11;
        goto L64
    L21:
        if (r2.equals("alpha") == false) goto L64;
        r3 = 10;
        goto L64
    L25:
        if (r2.equals("elevation") == false) goto L64;
        r3 = 9;
        goto L64
    L29:
        if (r2.equals("scaleY") == false) goto L64;
        r3 = 8;
        goto L64
    L33:
        if (r2.equals("scaleX") == false) goto L64;
        r3 = 7;
        goto L64
    L37:
        if (r2.equals("progress") == false) goto L64;
        r3 = 6;
        goto L64
    L41:
        if (r2.equals("translationZ") == false) goto L64;
        r3 = 5;
        goto L64
    L45:
        if (r2.equals("translationY") == false) goto L64;
        r3 = 4;
        goto L64
    L49:
        if (r2.equals("translationX") == false) goto L64;
        r3 = 3;
        goto L64
    L53:
        if (r2.equals("rotationZ") == false) goto L64;
        r3 = 2;
        goto L64
    L57:
        if (r2.equals("rotationY") == false) goto L64;
        r3 = 1;
        goto L64
    L61:
        if (r2.equals("rotationX") == false) goto L64;
        r3 = 0;
        goto L64
    L10:
        CustomVariable r7 = this.mCustom.get(r2.substring(7));
        if (r7 == null) goto L4;
        ((TimeCycleSplineSet.CustomVarSet) r4).setPoint(this.mFramePosition, r7, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void addValues(HashMap<String, SplineSet> r1) {
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo2clone() {
        return clone();
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public /* bridge */ /* synthetic */ MotionKey copy(MotionKey r1) {
        return copy(r1);
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
        if (Float.isNaN(this.mScaleX) == true) goto L21;
        r4.add("scaleX");
    L21:
        if (Float.isNaN(this.mScaleY) == true) goto L24;
        r4.add("scaleY");
    L24:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L27;
        r4.add("pathRotate");
    L27:
        if (Float.isNaN(this.mTranslationX) == true) goto L30;
        r4.add("translationX");
    L30:
        if (Float.isNaN(this.mTranslationY) == true) goto L33;
        r4.add("translationY");
    L33:
        if (Float.isNaN(this.mTranslationZ) == true) goto L36;
        r4.add("translationZ");
    L36:
        if (this.mCustom.size() <= 0) goto L41;
        Iterator<String> r3 = this.mCustom.keySet().iterator();
    L39:
        if (r3.hasNext() == false) goto L43;
        r4.add("CUSTOM," + r3.next());
        goto L39
    L43:
        return;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String r1) {
        return TypedValues.CycleType.getId(r1);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, int r3) {
        if (r2 != 100) goto L5;
        this.mFramePosition = r3;
        return true;
    L5:
        if (r2 != 421) goto L7;
        this.mWaveShape = r3;
        return true;
    L7:
        return super.setValue(r2, r3);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKey clone() {
        return new MotionKeyTimeCycle().copy(this);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKeyTimeCycle copy(MotionKey r2) {
        super.copy(r2);
        MotionKeyTimeCycle r3 = (MotionKeyTimeCycle) r2;
        this.mTransitionEasing = r3.mTransitionEasing;
        this.mCurveFit = r3.mCurveFit;
        this.mWaveShape = r3.mWaveShape;
        this.mWavePeriod = r3.mWavePeriod;
        this.mWaveOffset = r3.mWaveOffset;
        this.mProgress = r3.mProgress;
        this.mAlpha = r3.mAlpha;
        this.mElevation = r3.mElevation;
        this.mRotation = r3.mRotation;
        this.mTransitionPathRotate = r3.mTransitionPathRotate;
        this.mRotationX = r3.mRotationX;
        this.mRotationY = r3.mRotationY;
        this.mScaleX = r3.mScaleX;
        this.mScaleY = r3.mScaleY;
        this.mTranslationX = r3.mTranslationX;
        this.mTranslationY = r3.mTranslationY;
        this.mTranslationZ = r3.mTranslationZ;
        return this;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, float r3) {
        if (r2 != 315) goto L5;
        this.mProgress = toFloat(Float.valueOf(r3));
        return true;
    L5:
        if (r2 != 401) goto L7;
        this.mCurveFit = toInt(Float.valueOf(r3));
        return true;
    L7:
        if (r2 != 403) goto L9;
        this.mAlpha = r3;
        return true;
    L9:
        if (r2 != 416) goto L11;
        this.mTransitionPathRotate = toFloat(Float.valueOf(r3));
        return true;
    L11:
        if (r2 != 423) goto L13;
        this.mWavePeriod = toFloat(Float.valueOf(r3));
        return true;
    L13:
        if (r2 == 424) goto L26;
        switch(r2) {
            case 304: goto L25;
            case 305: goto L24;
            case 306: goto L23;
            case 307: goto L22;
            case 308: goto L21;
            case 309: goto L20;
            case 310: goto L19;
            case 311: goto L18;
            case 312: goto L17;
            default: goto L16;
        };
    L17:
        this.mScaleY = toFloat(Float.valueOf(r3));
        return true;
    L18:
        this.mScaleX = toFloat(Float.valueOf(r3));
        return true;
    L19:
        this.mRotation = toFloat(Float.valueOf(r3));
        return true;
    L20:
        this.mRotationY = toFloat(Float.valueOf(r3));
        return true;
    L21:
        this.mRotationX = toFloat(Float.valueOf(r3));
        return true;
    L22:
        this.mElevation = toFloat(Float.valueOf(r3));
        return true;
    L23:
        this.mTranslationZ = toFloat(Float.valueOf(r3));
        return true;
    L24:
        this.mTranslationY = toFloat(Float.valueOf(r3));
        return true;
    L25:
        this.mTranslationX = toFloat(Float.valueOf(r3));
        return true;
    L16:
        return super.setValue(r2, r3);
    L26:
        this.mWaveOffset = toFloat(Float.valueOf(r3));
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, String r3) {
        if (r2 != 420) goto L5;
        this.mTransitionEasing = r3;
        return true;
    L5:
        if (r2 != 421) goto L7;
        this.mWaveShape = 7;
        this.mCustomWaveShape = r3;
        return true;
    L7:
        return super.setValue(r2, r3);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r1, boolean r2) {
        return super.setValue(r1, r2);
    }
}
