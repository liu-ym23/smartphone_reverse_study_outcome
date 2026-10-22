package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class MotionKey implements TypedValues {
    public static final String ALPHA = "alpha";
    public static final String CUSTOM = "CUSTOM";
    public static final String ELEVATION = "elevation";
    public static final String ROTATION = "rotationZ";
    public static final String ROTATION_X = "rotationX";
    public static final String SCALE_X = "scaleX";
    public static final String SCALE_Y = "scaleY";
    public static final String TRANSITION_PATH_ROTATE = "transitionPathRotate";
    public static final String TRANSLATION_X = "translationX";
    public static final String TRANSLATION_Y = "translationY";
    public static int UNSET = -1;
    public static final String VISIBILITY = "visibility";
    public HashMap<String, CustomVariable> mCustom;
    public int mFramePosition;
    int mTargetId;
    String mTargetString;
    public int mType;

    public MotionKey() {
        int r0 = UNSET;
        this.mFramePosition = r0;
        this.mTargetId = r0;
        this.mTargetString = null;
    }

    public abstract void addValues(HashMap<String, SplineSet> r1);

    public abstract MotionKey clone();

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object mo2clone() {
        return clone();
    }

    public MotionKey copy(MotionKey r2) {
        this.mFramePosition = r2.mFramePosition;
        this.mTargetId = r2.mTargetId;
        this.mTargetString = r2.mTargetString;
        this.mType = r2.mType;
        return this;
    }

    public abstract void getAttributeNames(HashSet<String> r1);

    public int getFramePosition() {
        return this.mFramePosition;
    }

    public boolean matches(String r1) {
        String r0 = this.mTargetString;
        if (r0 == null) goto L8;
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.matches(r0);
    L8:
        return false;
    }

    public void setCustomAttribute(String r2, int r3, float r4) {
        this.mCustom.put(r2, new CustomVariable(r2, r3, r4));
    }

    public void setFramePosition(int r1) {
        this.mFramePosition = r1;
    }

    public void setInterpolation(HashMap<String, Integer> r1) {
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r1, float r2) {
        return false;
    }

    public MotionKey setViewId(int r1) {
        this.mTargetId = r1;
        return this;
    }

    public boolean toBoolean(Object r1) {
        if ((r1 instanceof Boolean) == false) goto L6;
        return ((Boolean) r1).booleanValue();
    L6:
        return Boolean.parseBoolean(r1.toString());
    }

    public float toFloat(Object r1) {
        if ((r1 instanceof Float) == false) goto L6;
        return ((Float) r1).floatValue();
    L6:
        return Float.parseFloat(r1.toString());
    }

    public int toInt(Object r1) {
        if ((r1 instanceof Integer) == false) goto L6;
        return ((Integer) r1).intValue();
    L6:
        return Integer.parseInt(r1.toString());
    }

    public void setCustomAttribute(String r2, int r3, int r4) {
        this.mCustom.put(r2, new CustomVariable(r2, r3, r4));
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r1, boolean r2) {
        return false;
    }

    public void setCustomAttribute(String r2, int r3, boolean r4) {
        this.mCustom.put(r2, new CustomVariable(r2, r3, r4));
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, int r3) {
        if (r2 == 100) goto L6;
        return false;
    L6:
        this.mFramePosition = r3;
        return true;
    }

    public void setCustomAttribute(String r2, int r3, String r4) {
        this.mCustom.put(r2, new CustomVariable(r2, r3, r4));
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, String r3) {
        if (r2 == 101) goto L6;
        return false;
    L6:
        this.mTargetString = r3;
        return true;
    }
}
