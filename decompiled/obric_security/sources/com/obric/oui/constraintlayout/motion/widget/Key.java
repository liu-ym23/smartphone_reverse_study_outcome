package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.obric.oui.constraintlayout.motion.utils.ViewSpline;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Key {
    public static final String ALPHA = "alpha";
    public static final String CURVEFIT = "curveFit";
    public static final String CUSTOM = "CUSTOM";
    public static final String ELEVATION = "elevation";
    public static final String MOTIONPROGRESS = "motionProgress";
    public static final String PIVOT_X = "transformPivotX";
    public static final String PIVOT_Y = "transformPivotY";
    public static final String PROGRESS = "progress";
    public static final String ROTATION = "rotation";
    public static final String ROTATION_X = "rotationX";
    public static final String ROTATION_Y = "rotationY";
    public static final String SCALE_X = "scaleX";
    public static final String SCALE_Y = "scaleY";
    public static final String TRANSITIONEASING = "transitionEasing";
    public static final String TRANSITION_PATH_ROTATE = "transitionPathRotate";
    public static final String TRANSLATION_X = "translationX";
    public static final String TRANSLATION_Y = "translationY";
    public static final String TRANSLATION_Z = "translationZ";
    public static int UNSET = -1;
    public static final String VISIBILITY = "visibility";
    public static final String WAVE_OFFSET = "waveOffset";
    public static final String WAVE_PERIOD = "wavePeriod";
    public static final String WAVE_PHASE = "wavePhase";
    public static final String WAVE_VARIES_BY = "waveVariesBy";
    HashMap<String, ConstraintAttribute> mCustomConstraints;
    int mFramePosition;
    int mTargetId;
    String mTargetString;
    protected int mType;

    static {
    }

    public abstract void addValues(HashMap<String, ViewSpline> r1);

    public abstract Key clone();

    abstract void getAttributeNames(HashSet<String> r1);

    abstract void load(Context r1, AttributeSet r2);

    public void setInterpolation(HashMap<String, Integer> r1) {
    }

    public abstract void setValue(String r1, Object r2);

    public Key() {
        int r0 = UNSET;
        this.mFramePosition = r0;
        this.mTargetId = r0;
        this.mTargetString = null;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object mo250clone() throws CloneNotSupportedException {
        return clone();
    }

    boolean matches(String r1) {
        String r0 = this.mTargetString;
        if (r0 == null) goto L8;
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.matches(r0);
    L8:
        return false;
    }

    float toFloat(Object r1) {
        if ((r1 instanceof Float) == false) goto L6;
        return ((Float) r1).floatValue();
    L6:
        return Float.parseFloat(r1.toString());
    }

    int toInt(Object r1) {
        if ((r1 instanceof Integer) == false) goto L6;
        return ((Integer) r1).intValue();
    L6:
        return Integer.parseInt(r1.toString());
    }

    boolean toBoolean(Object r1) {
        if ((r1 instanceof Boolean) == false) goto L6;
        return ((Boolean) r1).booleanValue();
    L6:
        return Boolean.parseBoolean(r1.toString());
    }

    public Key copy(Key r2) {
        this.mFramePosition = r2.mFramePosition;
        this.mTargetId = r2.mTargetId;
        this.mTargetString = r2.mTargetString;
        this.mType = r2.mType;
        this.mCustomConstraints = r2.mCustomConstraints;
        return this;
    }

    public Key setViewId(int r1) {
        this.mTargetId = r1;
        return this;
    }

    public void setFramePosition(int r1) {
        this.mFramePosition = r1;
    }

    public int getFramePosition() {
        return this.mFramePosition;
    }
}
