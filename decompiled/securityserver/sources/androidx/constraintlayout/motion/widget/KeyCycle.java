package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class KeyCycle extends Key {
    public static final int KEY_TYPE = 4;
    static final String NAME = "KeyCycle";
    public static final int SHAPE_BOUNCE = 6;
    public static final int SHAPE_COS_WAVE = 5;
    public static final int SHAPE_REVERSE_SAW_WAVE = 4;
    public static final int SHAPE_SAW_WAVE = 3;
    public static final int SHAPE_SIN_WAVE = 0;
    public static final int SHAPE_SQUARE_WAVE = 1;
    public static final int SHAPE_TRIANGLE_WAVE = 2;
    private static final String TAG = "KeyCycle";
    public static final String WAVE_OFFSET = "waveOffset";
    public static final String WAVE_PERIOD = "wavePeriod";
    public static final String WAVE_PHASE = "wavePhase";
    public static final String WAVE_SHAPE = "waveShape";
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
    private float mWavePhase;
    private int mWaveShape;
    private int mWaveVariesBy;

    public static class Loader {
        private static final int ANDROID_ALPHA = 9;
        private static final int ANDROID_ELEVATION = 10;
        private static final int ANDROID_ROTATION = 11;
        private static final int ANDROID_ROTATION_X = 12;
        private static final int ANDROID_ROTATION_Y = 13;
        private static final int ANDROID_SCALE_X = 15;
        private static final int ANDROID_SCALE_Y = 16;
        private static final int ANDROID_TRANSLATION_X = 17;
        private static final int ANDROID_TRANSLATION_Y = 18;
        private static final int ANDROID_TRANSLATION_Z = 19;
        private static final int CURVE_FIT = 4;
        private static final int FRAME_POSITION = 2;
        private static final int PROGRESS = 20;
        private static final int TARGET_ID = 1;
        private static final int TRANSITION_EASING = 3;
        private static final int TRANSITION_PATH_ROTATE = 14;
        private static final int WAVE_OFFSET = 7;
        private static final int WAVE_PERIOD = 6;
        private static final int WAVE_PHASE = 21;
        private static final int WAVE_SHAPE = 5;
        private static final int WAVE_VARIES_BY = 8;
        private static SparseIntArray mAttrMap;

        static {
            SparseIntArray r0 = new SparseIntArray();
            mAttrMap = r0;
            r0.append(R.styleable.KeyCycle_motionTarget, 1);
            mAttrMap.append(R.styleable.KeyCycle_framePosition, 2);
            mAttrMap.append(R.styleable.KeyCycle_transitionEasing, 3);
            mAttrMap.append(R.styleable.KeyCycle_curveFit, 4);
            mAttrMap.append(R.styleable.KeyCycle_waveShape, 5);
            mAttrMap.append(R.styleable.KeyCycle_wavePeriod, 6);
            mAttrMap.append(R.styleable.KeyCycle_waveOffset, 7);
            mAttrMap.append(R.styleable.KeyCycle_waveVariesBy, 8);
            mAttrMap.append(R.styleable.KeyCycle_android_alpha, 9);
            mAttrMap.append(R.styleable.KeyCycle_android_elevation, 10);
            mAttrMap.append(R.styleable.KeyCycle_android_rotation, 11);
            mAttrMap.append(R.styleable.KeyCycle_android_rotationX, 12);
            mAttrMap.append(R.styleable.KeyCycle_android_rotationY, 13);
            mAttrMap.append(R.styleable.KeyCycle_transitionPathRotate, 14);
            mAttrMap.append(R.styleable.KeyCycle_android_scaleX, 15);
            mAttrMap.append(R.styleable.KeyCycle_android_scaleY, 16);
            mAttrMap.append(R.styleable.KeyCycle_android_translationX, 17);
            mAttrMap.append(R.styleable.KeyCycle_android_translationY, 18);
            mAttrMap.append(R.styleable.KeyCycle_android_translationZ, 19);
            mAttrMap.append(R.styleable.KeyCycle_motionProgress, 20);
            mAttrMap.append(R.styleable.KeyCycle_wavePhase, 21);
        }

        private Loader() {
        }

        public static /* synthetic */ void access$000(KeyCycle r0, TypedArray r1) {
            read(r0, r1);
        }

        private static void read(KeyCycle r5, TypedArray r6) {
            int r0 = r6.getIndexCount();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L43;
            int r2 = r6.getIndex(r1);
            switch(mAttrMap.get(r2)) {
                case 1: goto L34;
                case 2: goto L32;
                case 3: goto L31;
                case 4: goto L30;
                case 5: goto L27;
                case 6: goto L25;
                case 7: goto L22;
                case 8: goto L20;
                case 9: goto L19;
                case 10: goto L18;
                case 11: goto L17;
                case 12: goto L16;
                case 13: goto L15;
                case 14: goto L14;
                case 15: goto L13;
                case 16: goto L12;
                case 17: goto L11;
                case 18: goto L10;
                case 19: goto L9;
                case 20: goto L8;
                case 21: goto L7;
                default: goto L6;
            };
        L6:
            Log.e(TypedValues.CycleType.NAME, "unused attribute 0x" + Integer.toHexString(r2) + "   " + mAttrMap.get(r2));
        L42:
            r1 = r1 + 1;
            goto L3
        L7:
            KeyCycle.access$2002(r5, r6.getFloat(r2, KeyCycle.access$2000(r5)) / 360.0f);
            goto L42
        L8:
            KeyCycle.access$1902(r5, r6.getFloat(r2, KeyCycle.access$1900(r5)));
            goto L42
        L9:
            KeyCycle.access$1802(r5, r6.getDimension(r2, KeyCycle.access$1800(r5)));
            goto L42
        L10:
            KeyCycle.access$1702(r5, r6.getDimension(r2, KeyCycle.access$1700(r5)));
            goto L42
        L11:
            KeyCycle.access$1602(r5, r6.getDimension(r2, KeyCycle.access$1600(r5)));
            goto L42
        L12:
            KeyCycle.access$1502(r5, r6.getFloat(r2, KeyCycle.access$1500(r5)));
            goto L42
        L13:
            KeyCycle.access$1402(r5, r6.getFloat(r2, KeyCycle.access$1400(r5)));
            goto L42
        L14:
            KeyCycle.access$1302(r5, r6.getFloat(r2, KeyCycle.access$1300(r5)));
            goto L42
        L15:
            KeyCycle.access$1202(r5, r6.getFloat(r2, KeyCycle.access$1200(r5)));
            goto L42
        L16:
            KeyCycle.access$1102(r5, r6.getFloat(r2, KeyCycle.access$1100(r5)));
            goto L42
        L17:
            KeyCycle.access$1002(r5, r6.getFloat(r2, KeyCycle.access$1000(r5)));
            goto L42
        L18:
            KeyCycle.access$902(r5, r6.getDimension(r2, KeyCycle.access$900(r5)));
            goto L42
        L19:
            KeyCycle.access$802(r5, r6.getFloat(r2, KeyCycle.access$800(r5)));
            goto L42
        L20:
            KeyCycle.access$702(r5, r6.getInt(r2, KeyCycle.access$700(r5)));
            goto L42
        L25:
            KeyCycle.access$502(r5, r6.getFloat(r2, KeyCycle.access$500(r5)));
            goto L42
        L30:
            KeyCycle.access$202(r5, r6.getInteger(r2, KeyCycle.access$200(r5)));
            goto L42
        L31:
            KeyCycle.access$102(r5, r6.getString(r2));
            goto L42
        L32:
            r5.mFramePosition = r6.getInt(r2, r5.mFramePosition);
            goto L42
        L22:
            if (r6.peekValue(r2).type != 5) goto L24;
            KeyCycle.access$602(r5, r6.getDimension(r2, KeyCycle.access$600(r5)));
            goto L42
        L24:
            KeyCycle.access$602(r5, r6.getFloat(r2, KeyCycle.access$600(r5)));
            goto L42
        L27:
            if (r6.peekValue(r2).type != 3) goto L29;
            KeyCycle.access$302(r5, r6.getString(r2));
            KeyCycle.access$402(r5, 7);
            goto L42
        L29:
            KeyCycle.access$402(r5, r6.getInt(r2, KeyCycle.access$400(r5)));
            goto L42
        L34:
            if (MotionLayout.IS_IN_EDIT_MODE == false) goto L39;
            int r3 = r6.getResourceId(r2, r5.mTargetId);
            r5.mTargetId = r3;
            if (r3 != (-1)) goto L42;
            r5.mTargetString = r6.getString(r2);
            goto L42
        L39:
            if (r6.peekValue(r2).type != 3) goto L41;
            r5.mTargetString = r6.getString(r2);
            goto L42
        L41:
            r5.mTargetId = r6.getResourceId(r2, r5.mTargetId);
            goto L42
        }
    }

    public KeyCycle() {
        this.mTransitionEasing = null;
        this.mCurveFit = 0;
        this.mWaveShape = -1;
        this.mCustomWaveShape = null;
        this.mWavePeriod = Float.NaN;
        this.mWaveOffset = 0.0f;
        this.mWavePhase = 0.0f;
        this.mProgress = Float.NaN;
        this.mWaveVariesBy = -1;
        this.mAlpha = Float.NaN;
        this.mElevation = Float.NaN;
        this.mRotation = Float.NaN;
        this.mTransitionPathRotate = Float.NaN;
        this.mRotationX = Float.NaN;
        this.mRotationY = Float.NaN;
        this.mScaleX = Float.NaN;
        this.mScaleY = Float.NaN;
        this.mTranslationX = Float.NaN;
        this.mTranslationY = Float.NaN;
        this.mTranslationZ = Float.NaN;
        this.mType = 4;
        this.mCustomConstraints = new HashMap();
    }

    public static /* synthetic */ float access$1000(KeyCycle r0) {
        return r0.mRotation;
    }

    public static /* synthetic */ float access$1002(KeyCycle r0, float r1) {
        r0.mRotation = r1;
        return r1;
    }

    public static /* synthetic */ String access$102(KeyCycle r0, String r1) {
        r0.mTransitionEasing = r1;
        return r1;
    }

    public static /* synthetic */ float access$1100(KeyCycle r0) {
        return r0.mRotationX;
    }

    public static /* synthetic */ float access$1102(KeyCycle r0, float r1) {
        r0.mRotationX = r1;
        return r1;
    }

    public static /* synthetic */ float access$1200(KeyCycle r0) {
        return r0.mRotationY;
    }

    public static /* synthetic */ float access$1202(KeyCycle r0, float r1) {
        r0.mRotationY = r1;
        return r1;
    }

    public static /* synthetic */ float access$1300(KeyCycle r0) {
        return r0.mTransitionPathRotate;
    }

    public static /* synthetic */ float access$1302(KeyCycle r0, float r1) {
        r0.mTransitionPathRotate = r1;
        return r1;
    }

    public static /* synthetic */ float access$1400(KeyCycle r0) {
        return r0.mScaleX;
    }

    public static /* synthetic */ float access$1402(KeyCycle r0, float r1) {
        r0.mScaleX = r1;
        return r1;
    }

    public static /* synthetic */ float access$1500(KeyCycle r0) {
        return r0.mScaleY;
    }

    public static /* synthetic */ float access$1502(KeyCycle r0, float r1) {
        r0.mScaleY = r1;
        return r1;
    }

    public static /* synthetic */ float access$1600(KeyCycle r0) {
        return r0.mTranslationX;
    }

    public static /* synthetic */ float access$1602(KeyCycle r0, float r1) {
        r0.mTranslationX = r1;
        return r1;
    }

    public static /* synthetic */ float access$1700(KeyCycle r0) {
        return r0.mTranslationY;
    }

    public static /* synthetic */ float access$1702(KeyCycle r0, float r1) {
        r0.mTranslationY = r1;
        return r1;
    }

    public static /* synthetic */ float access$1800(KeyCycle r0) {
        return r0.mTranslationZ;
    }

    public static /* synthetic */ float access$1802(KeyCycle r0, float r1) {
        r0.mTranslationZ = r1;
        return r1;
    }

    public static /* synthetic */ float access$1900(KeyCycle r0) {
        return r0.mProgress;
    }

    public static /* synthetic */ float access$1902(KeyCycle r0, float r1) {
        r0.mProgress = r1;
        return r1;
    }

    public static /* synthetic */ int access$200(KeyCycle r0) {
        return r0.mCurveFit;
    }

    public static /* synthetic */ float access$2000(KeyCycle r0) {
        return r0.mWavePhase;
    }

    public static /* synthetic */ float access$2002(KeyCycle r0, float r1) {
        r0.mWavePhase = r1;
        return r1;
    }

    public static /* synthetic */ int access$202(KeyCycle r0, int r1) {
        r0.mCurveFit = r1;
        return r1;
    }

    public static /* synthetic */ String access$302(KeyCycle r0, String r1) {
        r0.mCustomWaveShape = r1;
        return r1;
    }

    public static /* synthetic */ int access$400(KeyCycle r0) {
        return r0.mWaveShape;
    }

    public static /* synthetic */ int access$402(KeyCycle r0, int r1) {
        r0.mWaveShape = r1;
        return r1;
    }

    public static /* synthetic */ float access$500(KeyCycle r0) {
        return r0.mWavePeriod;
    }

    public static /* synthetic */ float access$502(KeyCycle r0, float r1) {
        r0.mWavePeriod = r1;
        return r1;
    }

    public static /* synthetic */ float access$600(KeyCycle r0) {
        return r0.mWaveOffset;
    }

    public static /* synthetic */ float access$602(KeyCycle r0, float r1) {
        r0.mWaveOffset = r1;
        return r1;
    }

    public static /* synthetic */ int access$700(KeyCycle r0) {
        return r0.mWaveVariesBy;
    }

    public static /* synthetic */ int access$702(KeyCycle r0, int r1) {
        r0.mWaveVariesBy = r1;
        return r1;
    }

    public static /* synthetic */ float access$800(KeyCycle r0) {
        return r0.mAlpha;
    }

    public static /* synthetic */ float access$802(KeyCycle r0, float r1) {
        r0.mAlpha = r1;
        return r1;
    }

    public static /* synthetic */ float access$900(KeyCycle r0) {
        return r0.mElevation;
    }

    public static /* synthetic */ float access$902(KeyCycle r0, float r1) {
        r0.mElevation = r1;
        return r1;
    }

    public void addCycleValues(HashMap<String, ViewOscillator> r25) {
        Iterator<String> r2 = r25.keySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L23;
        String r3 = r2.next();
        if (r3.startsWith("CUSTOM") == true) goto L7;
        float r23 = getValue(r3);
        if (Float.isNaN(r23) == true) goto L4;
        ViewOscillator r15 = r25.get(r3);
        if (r15 == null) goto L4;
        r15.setPoint(this.mFramePosition, this.mWaveShape, this.mCustomWaveShape, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, this.mWavePhase, r23);
        goto L4
    L7:
        String r4 = r3.substring(7);
        ConstraintAttribute r14 = this.mCustomConstraints.get(r4);
        if (r14 == null) goto L4;
        if (r14.getType() != ConstraintAttribute.AttributeType.FLOAT_TYPE) goto L4;
        ViewOscillator r5 = r25.get(r3);
        if (r5 == null) goto L4;
        r5.setPoint(this.mFramePosition, this.mWaveShape, this.mCustomWaveShape, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, this.mWavePhase, r14.getValueToInterpolate(), r14);
        goto L4
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, ViewSpline> r7) {
        Debug.logStack(TypedValues.CycleType.NAME, "add " + r7.size() + " values", 2);
        Iterator<String> r0 = r7.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L85;
        String r2 = r0.next();
        ViewSpline r3 = r7.get(r2);
        if (r3 == null) goto L4;
        r2.getClass();
        byte r4 = -1;
        switch(r2.hashCode()) {
            case -1249320806: goto L64;
            case -1249320805: goto L60;
            case -1225497657: goto L56;
            case -1225497656: goto L52;
            case -1225497655: goto L48;
            case -1001078227: goto L44;
            case -908189618: goto L40;
            case -908189617: goto L36;
            case -40300674: goto L32;
            case -4379043: goto L28;
            case 37232917: goto L24;
            case 92909918: goto L20;
            case 156108012: goto L16;
            case 1530034690: goto L12;
            default: goto L67;
        };
    L67:
        switch(r4) {
            case 0: goto L84;
            case 1: goto L83;
            case 2: goto L82;
            case 3: goto L81;
            case 4: goto L80;
            case 5: goto L79;
            case 6: goto L78;
            case 7: goto L77;
            case 8: goto L76;
            case 9: goto L75;
            case 10: goto L74;
            case 11: goto L73;
            case 12: goto L72;
            case 13: goto L71;
            default: goto L69;
        };
    L71:
        r3.setPoint(this.mFramePosition, this.mWavePhase);
        goto L4
    L72:
        r3.setPoint(this.mFramePosition, this.mWaveOffset);
        goto L4
    L73:
        r3.setPoint(this.mFramePosition, this.mAlpha);
        goto L4
    L74:
        r3.setPoint(this.mFramePosition, this.mTransitionPathRotate);
        goto L4
    L75:
        r3.setPoint(this.mFramePosition, this.mElevation);
        goto L4
    L76:
        r3.setPoint(this.mFramePosition, this.mRotation);
        goto L4
    L77:
        r3.setPoint(this.mFramePosition, this.mScaleY);
        goto L4
    L78:
        r3.setPoint(this.mFramePosition, this.mScaleX);
        goto L4
    L79:
        r3.setPoint(this.mFramePosition, this.mProgress);
        goto L4
    L80:
        r3.setPoint(this.mFramePosition, this.mTranslationZ);
        goto L4
    L81:
        r3.setPoint(this.mFramePosition, this.mTranslationY);
        goto L4
    L82:
        r3.setPoint(this.mFramePosition, this.mTranslationX);
        goto L4
    L83:
        r3.setPoint(this.mFramePosition, this.mRotationY);
        goto L4
    L84:
        r3.setPoint(this.mFramePosition, this.mRotationX);
        goto L4
    L69:
        if (r2.startsWith("CUSTOM") == true) goto L4;
        Log.v("WARNING KeyCycle", "  UNKNOWN  ".concat(r2));
        goto L4
    L12:
        if (r2.equals("wavePhase") == false) goto L67;
        r4 = 13;
        goto L67
    L16:
        if (r2.equals("waveOffset") == false) goto L67;
        r4 = 12;
        goto L67
    L20:
        if (r2.equals("alpha") == false) goto L67;
        r4 = 11;
        goto L67
    L24:
        if (r2.equals("transitionPathRotate") == false) goto L67;
        r4 = 10;
        goto L67
    L28:
        if (r2.equals("elevation") == false) goto L67;
        r4 = 9;
        goto L67
    L32:
        if (r2.equals(Key.ROTATION) == false) goto L67;
        r4 = 8;
        goto L67
    L36:
        if (r2.equals("scaleY") == false) goto L67;
        r4 = 7;
        goto L67
    L40:
        if (r2.equals("scaleX") == false) goto L67;
        r4 = 6;
        goto L67
    L44:
        if (r2.equals("progress") == false) goto L67;
        r4 = 5;
        goto L67
    L48:
        if (r2.equals("translationZ") == false) goto L67;
        r4 = 4;
        goto L67
    L52:
        if (r2.equals("translationY") == false) goto L67;
        r4 = 3;
        goto L67
    L56:
        if (r2.equals("translationX") == false) goto L67;
        r4 = 2;
        goto L67
    L60:
        if (r2.equals("rotationY") == false) goto L67;
        r4 = 1;
        goto L67
    L64:
        if (r2.equals("rotationX") == false) goto L67;
        r4 = 0;
        goto L67
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo3clone() {
        return clone();
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key copy(Key r2) {
        super.copy(r2);
        KeyCycle r3 = (KeyCycle) r2;
        this.mTransitionEasing = r3.mTransitionEasing;
        this.mCurveFit = r3.mCurveFit;
        this.mWaveShape = r3.mWaveShape;
        this.mCustomWaveShape = r3.mCustomWaveShape;
        this.mWavePeriod = r3.mWavePeriod;
        this.mWaveOffset = r3.mWaveOffset;
        this.mWavePhase = r3.mWavePhase;
        this.mProgress = r3.mProgress;
        this.mWaveVariesBy = r3.mWaveVariesBy;
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
        if (Float.isNaN(this.mScaleX) == true) goto L21;
        r4.add("scaleX");
    L21:
        if (Float.isNaN(this.mScaleY) == true) goto L24;
        r4.add("scaleY");
    L24:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L27;
        r4.add("transitionPathRotate");
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
        if (this.mCustomConstraints.size() <= 0) goto L41;
        Iterator<String> r3 = this.mCustomConstraints.keySet().iterator();
    L39:
        if (r3.hasNext() == false) goto L43;
        r4.add("CUSTOM," + r3.next());
        goto L39
    L43:
        return;
    }

    public float getValue(String r3) {
        r3.getClass();
        byte r0 = -1;
        switch(r3.hashCode()) {
            case -1249320806: goto L58;
            case -1249320805: goto L54;
            case -1225497657: goto L50;
            case -1225497656: goto L46;
            case -1225497655: goto L42;
            case -1001078227: goto L38;
            case -908189618: goto L34;
            case -908189617: goto L30;
            case -40300674: goto L26;
            case -4379043: goto L22;
            case 37232917: goto L18;
            case 92909918: goto L14;
            case 156108012: goto L10;
            case 1530034690: goto L6;
            default: goto L61;
        };
    L61:
        switch(r0) {
            case 0: goto L94;
            case 1: goto L92;
            case 2: goto L90;
            case 3: goto L88;
            case 4: goto L86;
            case 5: goto L84;
            case 6: goto L82;
            case 7: goto L80;
            case 8: goto L78;
            case 9: goto L76;
            case 10: goto L74;
            case 11: goto L72;
            case 12: goto L70;
            case 13: goto L68;
            default: goto L63;
        };
    L63:
        if (r3.startsWith("CUSTOM") == true) goto L95;
        Log.v("WARNING! KeyCycle", "  UNKNOWN  ".concat(r3));
        return Float.NaN;
    L95:
        return Float.NaN;
    L68:
        return this.mWavePhase;
    L70:
        return this.mWaveOffset;
    L72:
        return this.mAlpha;
    L74:
        return this.mTransitionPathRotate;
    L76:
        return this.mElevation;
    L78:
        return this.mRotation;
    L80:
        return this.mScaleY;
    L82:
        return this.mScaleX;
    L84:
        return this.mProgress;
    L86:
        return this.mTranslationZ;
    L88:
        return this.mTranslationY;
    L90:
        return this.mTranslationX;
    L92:
        return this.mRotationY;
    L94:
        return this.mRotationX;
    L6:
        if (r3.equals("wavePhase") == false) goto L61;
        r0 = 13;
        goto L61
    L10:
        if (r3.equals("waveOffset") == false) goto L61;
        r0 = 12;
        goto L61
    L14:
        if (r3.equals("alpha") == false) goto L61;
        r0 = 11;
        goto L61
    L18:
        if (r3.equals("transitionPathRotate") == false) goto L61;
        r0 = 10;
        goto L61
    L22:
        if (r3.equals("elevation") == false) goto L61;
        r0 = 9;
        goto L61
    L26:
        if (r3.equals(Key.ROTATION) == false) goto L61;
        r0 = 8;
        goto L61
    L30:
        if (r3.equals("scaleY") == false) goto L61;
        r0 = 7;
        goto L61
    L34:
        if (r3.equals("scaleX") == false) goto L61;
        r0 = 6;
        goto L61
    L38:
        if (r3.equals("progress") == false) goto L61;
        r0 = 5;
        goto L61
    L42:
        if (r3.equals("translationZ") == false) goto L61;
        r0 = 4;
        goto L61
    L46:
        if (r3.equals("translationY") == false) goto L61;
        r0 = 3;
        goto L61
    L50:
        if (r3.equals("translationX") == false) goto L61;
        r0 = 2;
        goto L61
    L54:
        if (r3.equals("rotationY") == false) goto L61;
        r0 = 1;
        goto L61
    L58:
        if (r3.equals("rotationX") == false) goto L61;
        r0 = 0;
        goto L61
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context r2, AttributeSet r3) {
        Loader.access$000(this, r2.obtainStyledAttributes(r3, R.styleable.KeyCycle));
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String r4, Object r5) {
        r4.getClass();
        byte r1 = -1;
        switch(r4.hashCode()) {
            case -1913008125: goto L74;
            case -1812823328: goto L70;
            case -1249320806: goto L66;
            case -1249320805: goto L62;
            case -1225497657: goto L58;
            case -1225497656: goto L54;
            case -1225497655: goto L50;
            case -908189618: goto L46;
            case -908189617: goto L42;
            case -40300674: goto L38;
            case -4379043: goto L34;
            case 37232917: goto L30;
            case 92909918: goto L26;
            case 156108012: goto L22;
            case 184161818: goto L18;
            case 579057826: goto L14;
            case 1530034690: goto L10;
            case 1532805160: goto L6;
            default: goto L77;
        };
    L77:
        switch(r1) {
            case 0: goto L99;
            case 1: goto L98;
            case 2: goto L97;
            case 3: goto L96;
            case 4: goto L95;
            case 5: goto L94;
            case 6: goto L93;
            case 7: goto L92;
            case 8: goto L91;
            case 9: goto L90;
            case 10: goto L89;
            case 11: goto L88;
            case 12: goto L87;
            case 13: goto L86;
            case 14: goto L85;
            case 15: goto L84;
            case 16: goto L83;
            case 17: goto L80;
            default: goto L119;
        };
    L83:
        this.mWavePhase = toFloat(r5);
        return;
    L84:
        this.mCurveFit = toInt(r5);
        return;
    L85:
        this.mWavePeriod = toFloat(r5);
        return;
    L86:
        this.mWaveOffset = toFloat(r5);
        return;
    L87:
        this.mAlpha = toFloat(r5);
        return;
    L88:
        this.mTransitionPathRotate = toFloat(r5);
        return;
    L89:
        this.mElevation = toFloat(r5);
        return;
    L90:
        this.mRotation = toFloat(r5);
        return;
    L91:
        this.mScaleY = toFloat(r5);
        return;
    L92:
        this.mScaleX = toFloat(r5);
        return;
    L93:
        this.mTranslationZ = toFloat(r5);
        return;
    L94:
        this.mTranslationY = toFloat(r5);
        return;
    L95:
        this.mTranslationX = toFloat(r5);
        return;
    L96:
        this.mRotationY = toFloat(r5);
        return;
    L97:
        this.mRotationX = toFloat(r5);
        return;
    L98:
        this.mTransitionEasing = r5.toString();
        return;
    L99:
        this.mProgress = toFloat(r5);
        return;
    L119:
        return;
    L80:
        if ((r5 instanceof Integer) == false) goto L82;
        this.mWaveShape = toInt(r5);
        return;
    L82:
        this.mWaveShape = 7;
        this.mCustomWaveShape = r5.toString();
        return;
    L6:
        if (r4.equals("waveShape") == false) goto L77;
        r1 = 17;
        goto L77
    L10:
        if (r4.equals("wavePhase") == false) goto L77;
        r1 = 16;
        goto L77
    L14:
        if (r4.equals("curveFit") == false) goto L77;
        r1 = 15;
        goto L77
    L18:
        if (r4.equals("wavePeriod") == false) goto L77;
        r1 = 14;
        goto L77
    L22:
        if (r4.equals("waveOffset") == false) goto L77;
        r1 = 13;
        goto L77
    L26:
        if (r4.equals("alpha") == false) goto L77;
        r1 = 12;
        goto L77
    L30:
        if (r4.equals("transitionPathRotate") == false) goto L77;
        r1 = 11;
        goto L77
    L34:
        if (r4.equals("elevation") == false) goto L77;
        r1 = 10;
        goto L77
    L38:
        if (r4.equals(Key.ROTATION) == false) goto L77;
        r1 = 9;
        goto L77
    L42:
        if (r4.equals("scaleY") == false) goto L77;
        r1 = 8;
        goto L77
    L46:
        if (r4.equals("scaleX") == false) goto L77;
        r1 = 7;
        goto L77
    L50:
        if (r4.equals("translationZ") == false) goto L77;
        r1 = 6;
        goto L77
    L54:
        if (r4.equals("translationY") == false) goto L77;
        r1 = 5;
        goto L77
    L58:
        if (r4.equals("translationX") == false) goto L77;
        r1 = 4;
        goto L77
    L62:
        if (r4.equals("rotationY") == false) goto L77;
        r1 = 3;
        goto L77
    L66:
        if (r4.equals("rotationX") == false) goto L77;
        r1 = 2;
        goto L77
    L70:
        if (r4.equals("transitionEasing") == false) goto L77;
        r1 = 1;
        goto L77
    L74:
        if (r4.equals(Key.MOTIONPROGRESS) == false) goto L77;
        r1 = 0;
        goto L77
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key clone() {
        return new KeyCycle().copy(this);
    }
}
