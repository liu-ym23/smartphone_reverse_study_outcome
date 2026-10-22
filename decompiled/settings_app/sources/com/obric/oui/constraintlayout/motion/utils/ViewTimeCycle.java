package com.obric.oui.constraintlayout.motion.utils;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import com.obric.oui.constraintlayout.core.motion.utils.CurveFit;
import com.obric.oui.constraintlayout.core.motion.utils.KeyCache;
import com.obric.oui.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import com.obric.oui.constraintlayout.motion.widget.MotionLayout;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ViewTimeCycle extends TimeCycleSplineSet {
    private static final String TAG = "ViewTimeCycle";

    static class AlphaSet extends ViewTimeCycle {
        AlphaSet() {
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View r7, float r8, long r9, KeyCache r11) {
            r7.setAlpha(get(r8, r9, r7, r11));
            return this.mContinue;
        }
    }

    public static class CustomSet extends ViewTimeCycle {
        String mAttributeName;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;
        SparseArray<float[]> mWaveProperties;

        public CustomSet(String r2, SparseArray<ConstraintAttribute> r3) {
            this.mWaveProperties = new SparseArray();
            this.mAttributeName = r2.split(",")[1];
            this.mConstraintAttributeList = r3;
        }

        @Override // com.obric.oui.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setup(int r15) {
            int r0 = this.mConstraintAttributeList.size();
            int r1 = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] r3 = new double[r0];
            int r4 = r1 + 2;
            this.mTempValues = new float[r4];
            this.mCache = new float[r1];
            double[][] r5 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r0, r4});
            int r6 = 0;
        L3:
            if (r6 >= r0) goto L9;
            int r7 = this.mConstraintAttributeList.keyAt(r6);
            ConstraintAttribute r8 = this.mConstraintAttributeList.valueAt(r6);
            float[] r9 = this.mWaveProperties.valueAt(r6);
            r3[r6] = ((double) r7) * 0.01d;
            r8.getValuesToInterpolate(this.mTempValues);
            int r10 = 0;
        L5:
            float[] r11 = this.mTempValues;
            if (r10 >= r11.length) goto L8;
            r5[r6][r10] = r11[r10];
            r10 = r10 + 1;
            goto L5
        L8:
            double[] r12 = r5[r6];
            r12[r1] = r9[0];
            r12[r1 + 1] = r9[1];
            r6 = r6 + 1;
            goto L3
        L9:
            this.mCurveFit = CurveFit.get(r15, r3, r5);
        }

        @Override // com.obric.oui.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setPoint(int r1, float r2, float r3, int r4, float r5) {
            throw new RuntimeException("Wrong call for custom attribute");
        }

        public void setPoint(int r3, ConstraintAttribute r4, float r5, int r6, float r7) {
            this.mConstraintAttributeList.append(r3, r4);
            this.mWaveProperties.append(r3, new float[]{r5, r7});
            this.mWaveShape = Math.max(this.mWaveShape, r6);
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View r17, float r18, long r19, KeyCache r21) {
            this.mCurveFit.getPos(r18, this.mTempValues);
            float[] r4 = this.mTempValues;
            float r5 = r4[r4.length - 2];
            float r6 = r4[r4.length - 1];
            long r8 = r19 - this.mLastTime;
            if (Float.isNaN(this.mLastCycle) == false) goto L7;
            this.mLastCycle = r21.getFloatValue(r17, this.mAttributeName, 0);
            if (Float.isNaN(this.mLastCycle) == false) goto L7;
            this.mLastCycle = 0.0f;
        L7:
            this.mLastCycle = (float) ((((double) this.mLastCycle) + ((r8 * 1.0E-9d) * ((double) r5))) % 1.0d);
            this.mLastTime = r19;
            float r2 = calcWave(this.mLastCycle);
            this.mContinue = false;
            int r3 = 0;
        L9:
            if (r3 >= this.mCache.length) goto L15;
            boolean r7 = this.mContinue;
            if (this.mTempValues[r3] == 0.0d) goto L13;
            boolean r9 = true;
        L14:
            this.mContinue = r7 | r9;
            this.mCache[r3] = (this.mTempValues[r3] * r2) + r6;
            r3 = r3 + 1;
            goto L9
        L13:
            r9 = false;
            goto L14
        L15:
            CustomSupport.setInterpolatedValue(this.mConstraintAttributeList.valueAt(0), r17, this.mCache);
            if (r5 == 0.0f) goto L19;
            this.mContinue = true;
        L19:
            return this.mContinue;
        }
    }

    static class ElevationSet extends ViewTimeCycle {
        ElevationSet() {
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View r7, float r8, long r9, KeyCache r11) {
            r7.setElevation(get(r8, r9, r7, r11));
            return this.mContinue;
        }
    }

    public static class PathRotate extends ViewTimeCycle {
        public PathRotate() {
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View r1, float r2, long r3, KeyCache r5) {
            return this.mContinue;
        }

        public boolean setPathRotate(View r7, KeyCache r8, float r9, long r10, double r12, double r14) {
            r7.setRotation(get(r9, r10, r7, r8) + ((float) Math.toDegrees(Math.atan2(r14, r12))));
            return this.mContinue;
        }
    }

    static class ProgressSet extends ViewTimeCycle {
        boolean mNoMethod;

        ProgressSet() {
            this.mNoMethod = false;
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View r14, float r15, long r16, KeyCache r18) {
            if ((r14 instanceof MotionLayout) == false) goto L6;
            ((MotionLayout) r14).setProgress(get(r15, r16, r14, r18));
        L21:
            return this.mContinue;
        L6:
            if (this.mNoMethod == false) goto L22;
            return false;
        L22:
            Method r2 = r14.getClass().getMethod("setProgress", new Class[]{Float.TYPE});     // Catch: NoSuchMethodException -> L11
        L12:
            Method r11 = r2;
            if (r11 == null) goto L21;
            r11.invoke(r14, new Object[]{Float.valueOf(get(r15, r16, r14, r18))});     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18
        L18:
            e = move-exception;
            Log.e(ViewTimeCycle.TAG, "unable to setProgress", e);
        L16:
            e = move-exception;
            Log.e(ViewTimeCycle.TAG, "unable to setProgress", e);
        L11:
            this.mNoMethod = true;
            r2 = null;
            goto L12
        }
    }

    static class RotationSet extends ViewTimeCycle {
        RotationSet() {
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View r7, float r8, long r9, KeyCache r11) {
            r7.setRotation(get(r8, r9, r7, r11));
            return this.mContinue;
        }
    }

    static class RotationXset extends ViewTimeCycle {
        RotationXset() {
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View r7, float r8, long r9, KeyCache r11) {
            r7.setRotationX(get(r8, r9, r7, r11));
            return this.mContinue;
        }
    }

    static class RotationYset extends ViewTimeCycle {
        RotationYset() {
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View r7, float r8, long r9, KeyCache r11) {
            r7.setRotationY(get(r8, r9, r7, r11));
            return this.mContinue;
        }
    }

    static class ScaleXset extends ViewTimeCycle {
        ScaleXset() {
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View r7, float r8, long r9, KeyCache r11) {
            r7.setScaleX(get(r8, r9, r7, r11));
            return this.mContinue;
        }
    }

    static class ScaleYset extends ViewTimeCycle {
        ScaleYset() {
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View r7, float r8, long r9, KeyCache r11) {
            r7.setScaleY(get(r8, r9, r7, r11));
            return this.mContinue;
        }
    }

    static class TranslationXset extends ViewTimeCycle {
        TranslationXset() {
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View r7, float r8, long r9, KeyCache r11) {
            r7.setTranslationX(get(r8, r9, r7, r11));
            return this.mContinue;
        }
    }

    static class TranslationYset extends ViewTimeCycle {
        TranslationYset() {
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View r7, float r8, long r9, KeyCache r11) {
            r7.setTranslationY(get(r8, r9, r7, r11));
            return this.mContinue;
        }
    }

    static class TranslationZset extends ViewTimeCycle {
        TranslationZset() {
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View r7, float r8, long r9, KeyCache r11) {
            r7.setTranslationZ(get(r8, r9, r7, r11));
            return this.mContinue;
        }
    }

    public abstract boolean setProperty(View r1, float r2, long r3, KeyCache r5);

    public ViewTimeCycle() {
    }

    public float get(float r18, long r19, View r21, KeyCache r22) {
        this.mCurveFit.getPos(r18, this.mCache);
        float r5 = this.mCache[1];
        if (r5 != 0.0f) goto L7;
        this.mContinue = false;
        return this.mCache[2];
    L7:
        if (Float.isNaN(this.mLastCycle) == false) goto L11;
        this.mLastCycle = r22.getFloatValue(r21, this.mType, 0);
        if (Float.isNaN(this.mLastCycle) == false) goto L11;
        this.mLastCycle = 0.0f;
    L11:
        this.mLastCycle = (float) ((((double) this.mLastCycle) + (((r19 - this.mLastTime) * 1.0E-9d) * ((double) r5))) % 1.0d);
        r22.setFloatValue(r21, this.mType, 0, this.mLastCycle);
        this.mLastTime = r19;
        float r1 = this.mCache[0];
        float r2 = (calcWave(this.mLastCycle) * r1) + this.mCache[2];
        if (r1 != 0.0f) goto L16;
        if (r5 != 0.0f) goto L16;
        boolean r6 = false;
    L17:
        this.mContinue = r6;
        return r2;
    L16:
        r6 = true;
        goto L17
    }

    public static ViewTimeCycle makeCustomSpline(String r1, SparseArray<ConstraintAttribute> r2) {
        return new CustomSet(r1, r2);
    }

    public static ViewTimeCycle makeSpline(String r2, long r3) {
        r2.hashCode();
        byte r1 = -1;
        switch(r2.hashCode()) {
            case -1249320806: goto L50;
            case -1249320805: goto L46;
            case -1225497657: goto L42;
            case -1225497656: goto L38;
            case -1225497655: goto L34;
            case -1001078227: goto L30;
            case -908189618: goto L26;
            case -908189617: goto L22;
            case -40300674: goto L18;
            case -4379043: goto L14;
            case 37232917: goto L10;
            case 92909918: goto L6;
            default: goto L53;
        };
    L53:
        switch(r1) {
            case 0: goto L67;
            case 1: goto L66;
            case 2: goto L65;
            case 3: goto L64;
            case 4: goto L63;
            case 5: goto L62;
            case 6: goto L61;
            case 7: goto L60;
            case 8: goto L59;
            case 9: goto L58;
            case 10: goto L57;
            case 11: goto L56;
            default: goto L54;
        };
    L54:
        return null;
    L56:
        ViewTimeCycle r4 = new AlphaSet();
    L68:
        r4.setStartTime(r3);
        return r4;
    L57:
        r4 = new PathRotate();
        goto L68
    L58:
        r4 = new ElevationSet();
        goto L68
    L59:
        r4 = new RotationSet();
        goto L68
    L60:
        r4 = new ScaleYset();
        goto L68
    L61:
        r4 = new ScaleXset();
        goto L68
    L62:
        r4 = new ProgressSet();
        goto L68
    L63:
        r4 = new TranslationZset();
        goto L68
    L64:
        r4 = new TranslationYset();
        goto L68
    L65:
        r4 = new TranslationXset();
        goto L68
    L66:
        r4 = new RotationYset();
        goto L68
    L67:
        r4 = new RotationXset();
        goto L68
    L6:
        if (r2.equals("alpha") == false) goto L53;
        r1 = 11;
        goto L53
    L10:
        if (r2.equals("transitionPathRotate") == false) goto L53;
        r1 = 10;
        goto L53
    L14:
        if (r2.equals("elevation") == false) goto L53;
        r1 = 9;
        goto L53
    L18:
        if (r2.equals("rotation") == false) goto L53;
        r1 = 8;
        goto L53
    L22:
        if (r2.equals("scaleY") == false) goto L53;
        r1 = 7;
        goto L53
    L26:
        if (r2.equals("scaleX") == false) goto L53;
        r1 = 6;
        goto L53
    L30:
        if (r2.equals("progress") == false) goto L53;
        r1 = 5;
        goto L53
    L34:
        if (r2.equals("translationZ") == false) goto L53;
        r1 = 4;
        goto L53
    L38:
        if (r2.equals("translationY") == false) goto L53;
        r1 = 3;
        goto L53
    L42:
        if (r2.equals("translationX") == false) goto L53;
        r1 = 2;
        goto L53
    L46:
        if (r2.equals("rotationY") == false) goto L53;
        r1 = 1;
        goto L53
    L50:
        if (r2.equals("rotationX") == false) goto L53;
        r1 = 0;
        goto L53
    }
}
