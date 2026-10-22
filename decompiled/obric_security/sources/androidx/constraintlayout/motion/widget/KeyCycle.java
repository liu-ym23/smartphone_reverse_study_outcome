package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import com.qq.taf.jce.JceStruct;
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

    private static class Loader {
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

        private Loader() {
        }

        static /* synthetic */ void access$000(KeyCycle r0, TypedArray r1) {
            read(r0, r1);
        }

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

        private static void read(KeyCycle c, TypedArray a2) {
            int r0 = a2.getIndexCount();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L43;
            int r2 = a2.getIndex(r1);
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
            Log.e("KeyCycle", "unused attribute 0x" + Integer.toHexString(r2) + "   " + mAttrMap.get(r2));
        L42:
            r1 = r1 + 1;
            goto L3
        L7:
            KeyCycle.access$2002(c, a2.getFloat(r2, KeyCycle.access$2000(c)) / 360.0f);
            goto L42
        L8:
            KeyCycle.access$1902(c, a2.getFloat(r2, KeyCycle.access$1900(c)));
            goto L42
        L9:
            KeyCycle.access$1802(c, a2.getDimension(r2, KeyCycle.access$1800(c)));
            goto L42
        L10:
            KeyCycle.access$1702(c, a2.getDimension(r2, KeyCycle.access$1700(c)));
            goto L42
        L11:
            KeyCycle.access$1602(c, a2.getDimension(r2, KeyCycle.access$1600(c)));
            goto L42
        L12:
            KeyCycle.access$1502(c, a2.getFloat(r2, KeyCycle.access$1500(c)));
            goto L42
        L13:
            KeyCycle.access$1402(c, a2.getFloat(r2, KeyCycle.access$1400(c)));
            goto L42
        L14:
            KeyCycle.access$1302(c, a2.getFloat(r2, KeyCycle.access$1300(c)));
            goto L42
        L15:
            KeyCycle.access$1202(c, a2.getFloat(r2, KeyCycle.access$1200(c)));
            goto L42
        L16:
            KeyCycle.access$1102(c, a2.getFloat(r2, KeyCycle.access$1100(c)));
            goto L42
        L17:
            KeyCycle.access$1002(c, a2.getFloat(r2, KeyCycle.access$1000(c)));
            goto L42
        L18:
            KeyCycle.access$902(c, a2.getDimension(r2, KeyCycle.access$900(c)));
            goto L42
        L19:
            KeyCycle.access$802(c, a2.getFloat(r2, KeyCycle.access$800(c)));
            goto L42
        L20:
            KeyCycle.access$702(c, a2.getInt(r2, KeyCycle.access$700(c)));
            goto L42
        L25:
            KeyCycle.access$502(c, a2.getFloat(r2, KeyCycle.access$500(c)));
            goto L42
        L30:
            KeyCycle.access$202(c, a2.getInteger(r2, KeyCycle.access$200(c)));
            goto L42
        L31:
            KeyCycle.access$102(c, a2.getString(r2));
            goto L42
        L32:
            c.mFramePosition = a2.getInt(r2, c.mFramePosition);
            goto L42
        L22:
            if (a2.peekValue(r2).type != 5) goto L24;
            KeyCycle.access$602(c, a2.getDimension(r2, KeyCycle.access$600(c)));
            goto L42
        L24:
            KeyCycle.access$602(c, a2.getFloat(r2, KeyCycle.access$600(c)));
            goto L42
        L27:
            if (a2.peekValue(r2).type != 3) goto L29;
            KeyCycle.access$302(c, a2.getString(r2));
            KeyCycle.access$402(c, 7);
            goto L42
        L29:
            KeyCycle.access$402(c, a2.getInt(r2, KeyCycle.access$400(c)));
            goto L42
        L34:
            if (MotionLayout.IS_IN_EDIT_MODE == false) goto L39;
            c.mTargetId = a2.getResourceId(r2, c.mTargetId);
            if (c.mTargetId != (-1)) goto L42;
            c.mTargetString = a2.getString(r2);
            goto L42
        L39:
            if (a2.peekValue(r2).type != 3) goto L41;
            c.mTargetString = a2.getString(r2);
            goto L42
        L41:
            c.mTargetId = a2.getResourceId(r2, c.mTargetId);
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

    static /* synthetic */ float access$1000(KeyCycle r0) {
        return r0.mRotation;
    }

    static /* synthetic */ float access$1002(KeyCycle r0, float r1) {
        r0.mRotation = r1;
        return r1;
    }

    static /* synthetic */ String access$102(KeyCycle r0, String r1) {
        r0.mTransitionEasing = r1;
        return r1;
    }

    static /* synthetic */ float access$1100(KeyCycle r0) {
        return r0.mRotationX;
    }

    static /* synthetic */ float access$1102(KeyCycle r0, float r1) {
        r0.mRotationX = r1;
        return r1;
    }

    static /* synthetic */ float access$1200(KeyCycle r0) {
        return r0.mRotationY;
    }

    static /* synthetic */ float access$1202(KeyCycle r0, float r1) {
        r0.mRotationY = r1;
        return r1;
    }

    static /* synthetic */ float access$1300(KeyCycle r0) {
        return r0.mTransitionPathRotate;
    }

    static /* synthetic */ float access$1302(KeyCycle r0, float r1) {
        r0.mTransitionPathRotate = r1;
        return r1;
    }

    static /* synthetic */ float access$1400(KeyCycle r0) {
        return r0.mScaleX;
    }

    static /* synthetic */ float access$1402(KeyCycle r0, float r1) {
        r0.mScaleX = r1;
        return r1;
    }

    static /* synthetic */ float access$1500(KeyCycle r0) {
        return r0.mScaleY;
    }

    static /* synthetic */ float access$1502(KeyCycle r0, float r1) {
        r0.mScaleY = r1;
        return r1;
    }

    static /* synthetic */ float access$1600(KeyCycle r0) {
        return r0.mTranslationX;
    }

    static /* synthetic */ float access$1602(KeyCycle r0, float r1) {
        r0.mTranslationX = r1;
        return r1;
    }

    static /* synthetic */ float access$1700(KeyCycle r0) {
        return r0.mTranslationY;
    }

    static /* synthetic */ float access$1702(KeyCycle r0, float r1) {
        r0.mTranslationY = r1;
        return r1;
    }

    static /* synthetic */ float access$1800(KeyCycle r0) {
        return r0.mTranslationZ;
    }

    static /* synthetic */ float access$1802(KeyCycle r0, float r1) {
        r0.mTranslationZ = r1;
        return r1;
    }

    static /* synthetic */ float access$1900(KeyCycle r0) {
        return r0.mProgress;
    }

    static /* synthetic */ float access$1902(KeyCycle r0, float r1) {
        r0.mProgress = r1;
        return r1;
    }

    static /* synthetic */ int access$200(KeyCycle r0) {
        return r0.mCurveFit;
    }

    static /* synthetic */ float access$2000(KeyCycle r0) {
        return r0.mWavePhase;
    }

    static /* synthetic */ float access$2002(KeyCycle r0, float r1) {
        r0.mWavePhase = r1;
        return r1;
    }

    static /* synthetic */ int access$202(KeyCycle r0, int r1) {
        r0.mCurveFit = r1;
        return r1;
    }

    static /* synthetic */ String access$302(KeyCycle r0, String r1) {
        r0.mCustomWaveShape = r1;
        return r1;
    }

    static /* synthetic */ int access$400(KeyCycle r0) {
        return r0.mWaveShape;
    }

    static /* synthetic */ int access$402(KeyCycle r0, int r1) {
        r0.mWaveShape = r1;
        return r1;
    }

    static /* synthetic */ float access$500(KeyCycle r0) {
        return r0.mWavePeriod;
    }

    static /* synthetic */ float access$502(KeyCycle r0, float r1) {
        r0.mWavePeriod = r1;
        return r1;
    }

    static /* synthetic */ float access$600(KeyCycle r0) {
        return r0.mWaveOffset;
    }

    static /* synthetic */ float access$602(KeyCycle r0, float r1) {
        r0.mWaveOffset = r1;
        return r1;
    }

    static /* synthetic */ int access$700(KeyCycle r0) {
        return r0.mWaveVariesBy;
    }

    static /* synthetic */ int access$702(KeyCycle r0, int r1) {
        r0.mWaveVariesBy = r1;
        return r1;
    }

    static /* synthetic */ float access$800(KeyCycle r0) {
        return r0.mAlpha;
    }

    static /* synthetic */ float access$802(KeyCycle r0, float r1) {
        r0.mAlpha = r1;
        return r1;
    }

    static /* synthetic */ float access$900(KeyCycle r0) {
        return r0.mElevation;
    }

    static /* synthetic */ float access$902(KeyCycle r0, float r1) {
        r0.mElevation = r1;
        return r1;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo14clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attrs) {
        Loader.access$000(this, context.obtainStyledAttributes(attrs, R.styleable.KeyCycle));
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
        if (Float.isNaN(this.mScaleX) == true) goto L21;
        attributes.add("scaleX");
    L21:
        if (Float.isNaN(this.mScaleY) == true) goto L24;
        attributes.add("scaleY");
    L24:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L27;
        attributes.add("transitionPathRotate");
    L27:
        if (Float.isNaN(this.mTranslationX) == true) goto L30;
        attributes.add("translationX");
    L30:
        if (Float.isNaN(this.mTranslationY) == true) goto L33;
        attributes.add("translationY");
    L33:
        if (Float.isNaN(this.mTranslationZ) == true) goto L36;
        attributes.add("translationZ");
    L36:
        if (this.mCustomConstraints.size() <= 0) goto L41;
        Iterator<String> r3 = this.mCustomConstraints.keySet().iterator();
    L39:
        if (r3.hasNext() == false) goto L43;
        attributes.add("CUSTOM," + r3.next());
        goto L39
    L43:
        return;
    }

    public void addCycleValues(HashMap<String, ViewOscillator> oscSet) {
        Iterator<String> r2 = oscSet.keySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L23;
        String r3 = r2.next();
        if (r3.startsWith("CUSTOM") == true) goto L7;
        float r23 = getValue(r3);
        if (Float.isNaN(r23) == true) goto L4;
        ViewOscillator r15 = oscSet.get(r3);
        if (r15 == null) goto L4;
        r15.setPoint(this.mFramePosition, this.mWaveShape, this.mCustomWaveShape, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, this.mWavePhase, r23);
        goto L4
    L7:
        String r4 = r3.substring(7);
        ConstraintAttribute r14 = this.mCustomConstraints.get(r4);
        if (r14 == null) goto L4;
        if (r14.getType() != ConstraintAttribute.AttributeType.FLOAT_TYPE) goto L4;
        ViewOscillator r5 = oscSet.get(r3);
        if (r5 == null) goto L4;
        r5.setPoint(this.mFramePosition, this.mWaveShape, this.mCustomWaveShape, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, this.mWavePhase, r14.getValueToInterpolate(), r14);
        goto L4
    }

    public float getValue(String key) {
        key.hashCode();
        byte r1 = -1;
        switch(key.hashCode()) {
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
        switch(r1) {
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
        if (key.startsWith("CUSTOM") == true) goto L95;
        Log.v("WARNING! KeyCycle", "  UNKNOWN  " + key);
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
        if (key.equals("wavePhase") == false) goto L61;
        r1 = JceStruct.SIMPLE_LIST;
        goto L61
    L10:
        if (key.equals("waveOffset") == false) goto L61;
        r1 = JceStruct.ZERO_TAG;
        goto L61
    L14:
        if (key.equals("alpha") == false) goto L61;
        r1 = JceStruct.STRUCT_END;
        goto L61
    L18:
        if (key.equals("transitionPathRotate") == false) goto L61;
        r1 = 10;
        goto L61
    L22:
        if (key.equals("elevation") == false) goto L61;
        r1 = 9;
        goto L61
    L26:
        if (key.equals("rotation") == false) goto L61;
        r1 = 8;
        goto L61
    L30:
        if (key.equals("scaleY") == false) goto L61;
        r1 = 7;
        goto L61
    L34:
        if (key.equals("scaleX") == false) goto L61;
        r1 = 6;
        goto L61
    L38:
        if (key.equals("progress") == false) goto L61;
        r1 = 5;
        goto L61
    L42:
        if (key.equals("translationZ") == false) goto L61;
        r1 = 4;
        goto L61
    L46:
        if (key.equals("translationY") == false) goto L61;
        r1 = 3;
        goto L61
    L50:
        if (key.equals("translationX") == false) goto L61;
        r1 = 2;
        goto L61
    L54:
        if (key.equals("rotationY") == false) goto L61;
        r1 = 1;
        goto L61
    L58:
        if (key.equals("rotationX") == false) goto L61;
        r1 = 0;
        goto L61
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, ViewSpline> splines) {
        Debug.logStack("KeyCycle", "add " + splines.size() + " values", 2);
        Iterator<String> r0 = splines.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L85;
        String r1 = r0.next();
        ViewSpline r3 = splines.get(r1);
        if (r3 == null) goto L4;
        r1.hashCode();
        byte r5 = -1;
        switch(r1.hashCode()) {
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
        switch(r5) {
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
        if (r1.startsWith("CUSTOM") == true) goto L4;
        Log.v("WARNING KeyCycle", "  UNKNOWN  " + r1);
        goto L4
    L12:
        if (r1.equals("wavePhase") == false) goto L67;
        r5 = JceStruct.SIMPLE_LIST;
        goto L67
    L16:
        if (r1.equals("waveOffset") == false) goto L67;
        r5 = JceStruct.ZERO_TAG;
        goto L67
    L20:
        if (r1.equals("alpha") == false) goto L67;
        r5 = JceStruct.STRUCT_END;
        goto L67
    L24:
        if (r1.equals("transitionPathRotate") == false) goto L67;
        r5 = 10;
        goto L67
    L28:
        if (r1.equals("elevation") == false) goto L67;
        r5 = 9;
        goto L67
    L32:
        if (r1.equals("rotation") == false) goto L67;
        r5 = 8;
        goto L67
    L36:
        if (r1.equals("scaleY") == false) goto L67;
        r5 = 7;
        goto L67
    L40:
        if (r1.equals("scaleX") == false) goto L67;
        r5 = 6;
        goto L67
    L44:
        if (r1.equals("progress") == false) goto L67;
        r5 = 5;
        goto L67
    L48:
        if (r1.equals("translationZ") == false) goto L67;
        r5 = 4;
        goto L67
    L52:
        if (r1.equals("translationY") == false) goto L67;
        r5 = 3;
        goto L67
    L56:
        if (r1.equals("translationX") == false) goto L67;
        r5 = 2;
        goto L67
    L60:
        if (r1.equals("rotationY") == false) goto L67;
        r5 = 1;
        goto L67
    L64:
        if (r1.equals("rotationX") == false) goto L67;
        r5 = 0;
        goto L67
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String tag, Object value) {
        tag.hashCode();
        byte r2 = -1;
        switch(tag.hashCode()) {
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
        switch(r2) {
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
        this.mWavePhase = toFloat(value);
        return;
    L84:
        this.mCurveFit = toInt(value);
        return;
    L85:
        this.mWavePeriod = toFloat(value);
        return;
    L86:
        this.mWaveOffset = toFloat(value);
        return;
    L87:
        this.mAlpha = toFloat(value);
        return;
    L88:
        this.mTransitionPathRotate = toFloat(value);
        return;
    L89:
        this.mElevation = toFloat(value);
        return;
    L90:
        this.mRotation = toFloat(value);
        return;
    L91:
        this.mScaleY = toFloat(value);
        return;
    L92:
        this.mScaleX = toFloat(value);
        return;
    L93:
        this.mTranslationZ = toFloat(value);
        return;
    L94:
        this.mTranslationY = toFloat(value);
        return;
    L95:
        this.mTranslationX = toFloat(value);
        return;
    L96:
        this.mRotationY = toFloat(value);
        return;
    L97:
        this.mRotationX = toFloat(value);
        return;
    L98:
        this.mTransitionEasing = value.toString();
        return;
    L99:
        this.mProgress = toFloat(value);
        return;
    L119:
        return;
    L80:
        if ((value instanceof Integer) == false) goto L82;
        this.mWaveShape = toInt(value);
        return;
    L82:
        this.mWaveShape = 7;
        this.mCustomWaveShape = value.toString();
        return;
    L6:
        if (tag.equals("waveShape") == false) goto L77;
        r2 = 17;
        goto L77
    L10:
        if (tag.equals("wavePhase") == false) goto L77;
        r2 = 16;
        goto L77
    L14:
        if (tag.equals("curveFit") == false) goto L77;
        r2 = 15;
        goto L77
    L18:
        if (tag.equals("wavePeriod") == false) goto L77;
        r2 = 14;
        goto L77
    L22:
        if (tag.equals("waveOffset") == false) goto L77;
        r2 = JceStruct.SIMPLE_LIST;
        goto L77
    L26:
        if (tag.equals("alpha") == false) goto L77;
        r2 = JceStruct.ZERO_TAG;
        goto L77
    L30:
        if (tag.equals("transitionPathRotate") == false) goto L77;
        r2 = JceStruct.STRUCT_END;
        goto L77
    L34:
        if (tag.equals("elevation") == false) goto L77;
        r2 = 10;
        goto L77
    L38:
        if (tag.equals("rotation") == false) goto L77;
        r2 = 9;
        goto L77
    L42:
        if (tag.equals("scaleY") == false) goto L77;
        r2 = 8;
        goto L77
    L46:
        if (tag.equals("scaleX") == false) goto L77;
        r2 = 7;
        goto L77
    L50:
        if (tag.equals("translationZ") == false) goto L77;
        r2 = 6;
        goto L77
    L54:
        if (tag.equals("translationY") == false) goto L77;
        r2 = 5;
        goto L77
    L58:
        if (tag.equals("translationX") == false) goto L77;
        r2 = 4;
        goto L77
    L62:
        if (tag.equals("rotationY") == false) goto L77;
        r2 = 3;
        goto L77
    L66:
        if (tag.equals("rotationX") == false) goto L77;
        r2 = 2;
        goto L77
    L70:
        if (tag.equals("transitionEasing") == false) goto L77;
        r2 = 1;
        goto L77
    L74:
        if (tag.equals("motionProgress") == false) goto L77;
        r2 = 0;
        goto L77
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key copy(Key src) {
        super.copy(src);
        KeyCycle r2 = (KeyCycle) src;
        this.mTransitionEasing = r2.mTransitionEasing;
        this.mCurveFit = r2.mCurveFit;
        this.mWaveShape = r2.mWaveShape;
        this.mCustomWaveShape = r2.mCustomWaveShape;
        this.mWavePeriod = r2.mWavePeriod;
        this.mWaveOffset = r2.mWaveOffset;
        this.mWavePhase = r2.mWavePhase;
        this.mProgress = r2.mProgress;
        this.mWaveVariesBy = r2.mWaveVariesBy;
        this.mAlpha = r2.mAlpha;
        this.mElevation = r2.mElevation;
        this.mRotation = r2.mRotation;
        this.mTransitionPathRotate = r2.mTransitionPathRotate;
        this.mRotationX = r2.mRotationX;
        this.mRotationY = r2.mRotationY;
        this.mScaleX = r2.mScaleX;
        this.mScaleY = r2.mScaleY;
        this.mTranslationX = r2.mTranslationX;
        this.mTranslationY = r2.mTranslationY;
        this.mTranslationZ = r2.mTranslationZ;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key clone() {
        return new KeyCycle().copy(this);
    }
}
