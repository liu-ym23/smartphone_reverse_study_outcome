package com.obric.oui.constraintlayout.core.motion.utils;

import com.obric.oui.constraintlayout.core.motion.CustomAttribute;
import com.obric.oui.constraintlayout.core.motion.CustomVariable;
import com.obric.oui.constraintlayout.core.motion.MotionWidget;
import com.obric.oui.constraintlayout.core.state.WidgetFrame;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SplineSet {
    private static final String TAG = "SplineSet";
    private int mCount;
    protected CurveFit mCurveFit;
    protected int[] mTimePoints;
    private String mType;
    protected float[] mValues;

    private static class CoreSpline extends SplineSet {
        long mStart;
        String mType;

        CoreSpline(String r1, long r2) {
            this.mType = r1;
            this.mStart = r2;
        }

        @Override // com.obric.oui.constraintlayout.core.motion.utils.SplineSet
        public void setProperty(TypedValues r2, float r3) {
            r2.setValue(r2.getId(this.mType), get(r3));
        }
    }

    public static class CustomSet extends SplineSet {
        String mAttributeName;
        KeyFrameArray.CustomArray mConstraintAttributeList;
        float[] mTempValues;

        public CustomSet(String r2, KeyFrameArray.CustomArray r3) {
            this.mAttributeName = r2.split(",")[1];
            this.mConstraintAttributeList = r3;
        }

        @Override // com.obric.oui.constraintlayout.core.motion.utils.SplineSet
        public void setup(int r12) {
            int r0 = this.mConstraintAttributeList.size();
            int r1 = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] r3 = new double[r0];
            this.mTempValues = new float[r1];
            double[][] r2 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r0, r1});
            int r4 = 0;
        L3:
            if (r4 >= r0) goto L9;
            int r5 = this.mConstraintAttributeList.keyAt(r4);
            CustomAttribute r6 = this.mConstraintAttributeList.valueAt(r4);
            r3[r4] = ((double) r5) * 0.01d;
            r6.getValuesToInterpolate(this.mTempValues);
            int r7 = 0;
        L5:
            float[] r8 = this.mTempValues;
            if (r7 >= r8.length) goto L8;
            r2[r4][r7] = r8[r7];
            r7 = r7 + 1;
            goto L5
        L8:
            r4 = r4 + 1;
            goto L3
        L9:
            this.mCurveFit = CurveFit.get(r12, r3, r2);
        }

        @Override // com.obric.oui.constraintlayout.core.motion.utils.SplineSet
        public void setPoint(int r1, float r2) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void setPoint(int r1, CustomAttribute r2) {
            this.mConstraintAttributeList.append(r1, r2);
        }

        public void setProperty(WidgetFrame r4, float r5) {
            this.mCurveFit.getPos(r5, this.mTempValues);
            r4.setCustomValue(this.mConstraintAttributeList.valueAt(0), this.mTempValues);
        }
    }

    public static class CustomSpline extends SplineSet {
        String mAttributeName;
        KeyFrameArray.CustomVar mConstraintAttributeList;
        float[] mTempValues;

        public CustomSpline(String r2, KeyFrameArray.CustomVar r3) {
            this.mAttributeName = r2.split(",")[1];
            this.mConstraintAttributeList = r3;
        }

        @Override // com.obric.oui.constraintlayout.core.motion.utils.SplineSet
        public void setup(int r12) {
            int r0 = this.mConstraintAttributeList.size();
            int r1 = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] r3 = new double[r0];
            this.mTempValues = new float[r1];
            double[][] r2 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r0, r1});
            int r4 = 0;
        L3:
            if (r4 >= r0) goto L9;
            int r5 = this.mConstraintAttributeList.keyAt(r4);
            CustomVariable r6 = this.mConstraintAttributeList.valueAt(r4);
            r3[r4] = ((double) r5) * 0.01d;
            r6.getValuesToInterpolate(this.mTempValues);
            int r7 = 0;
        L5:
            float[] r8 = this.mTempValues;
            if (r7 >= r8.length) goto L8;
            r2[r4][r7] = r8[r7];
            r7 = r7 + 1;
            goto L5
        L8:
            r4 = r4 + 1;
            goto L3
        L9:
            this.mCurveFit = CurveFit.get(r12, r3, r2);
        }

        @Override // com.obric.oui.constraintlayout.core.motion.utils.SplineSet
        public void setPoint(int r1, float r2) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        @Override // com.obric.oui.constraintlayout.core.motion.utils.SplineSet
        public void setProperty(TypedValues r1, float r2) {
            setProperty((MotionWidget) r1, r2);
        }

        public void setPoint(int r1, CustomVariable r2) {
            this.mConstraintAttributeList.append(r1, r2);
        }

        public void setProperty(MotionWidget r4, float r5) {
            this.mCurveFit.getPos(r5, this.mTempValues);
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(r4, this.mTempValues);
        }
    }

    private static class Sort {
        private Sort() {
        }

        static void doubleQuickSort(int[] r6, float[] r7, int r8, int r9) {
            int[] r0 = new int[r6.length + 10];
            r0[0] = r9;
            r0[1] = r8;
            int r10 = 2;
        L3:
            if (r10 <= 0) goto L7;
            int r11 = r10 - 1;
            int r1 = r0[r11];
            r10 = r11 - 1;
            int r2 = r0[r10];
            if (r1 >= r2) goto L3;
            int r3 = partition(r6, r7, r1, r2);
            int r4 = r10 + 1;
            r0[r10] = r3 - 1;
            int r12 = r4 + 1;
            r0[r4] = r1;
            int r5 = r12 + 1;
            r0[r12] = r2;
            r10 = r5 + 1;
            r0[r5] = r3 + 1;
            goto L3
        }

        private static int partition(int[] r3, float[] r4, int r5, int r6) {
            int r0 = r3[r6];
            int r1 = r5;
        L3:
            if (r5 >= r6) goto L8;
            if (r3[r5] > r0) goto L7;
            swap(r3, r4, r1, r5);
            r1 = r1 + 1;
        L7:
            r5 = r5 + 1;
            goto L3
        L8:
            swap(r3, r4, r1, r6);
            return r1;
        }

        private static void swap(int[] r2, float[] r3, int r4, int r5) {
            int r0 = r2[r4];
            r2[r4] = r2[r5];
            r2[r5] = r0;
            float r6 = r3[r4];
            r3[r4] = r3[r5];
            r3[r5] = r6;
        }
    }

    public SplineSet() {
        this.mTimePoints = new int[10];
        this.mValues = new float[10];
    }

    public void setProperty(TypedValues r2, float r3) {
        r2.setValue(TypedValues.AttributesType.getId(this.mType), get(r3));
    }

    public String toString() {
        String r0 = this.mType;
        DecimalFormat r1 = new DecimalFormat("##.##");
        int r2 = 0;
    L4:
        if (r2 >= this.mCount) goto L6;
        r0 = r0 + "[" + this.mTimePoints[r2] + " , " + r1.format(this.mValues[r2]) + "] ";
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }

    public void setType(String r1) {
        this.mType = r1;
    }

    public float get(float r3) {
        return (float) this.mCurveFit.getPos(r3, 0);
    }

    public float getSlope(float r3) {
        return (float) this.mCurveFit.getSlope(r3, 0);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public void setPoint(int r4, float r5) {
        int[] r0 = this.mTimePoints;
        if (r0.length >= (this.mCount + 1)) goto L5;
        this.mTimePoints = Arrays.copyOf(r0, r0.length * 2);
        float[] r1 = this.mValues;
        this.mValues = Arrays.copyOf(r1, r1.length * 2);
    L5:
        int[] r2 = this.mTimePoints;
        int r3 = this.mCount;
        r2[r3] = r4;
        this.mValues[r3] = r5;
        this.mCount = r3 + 1;
    }

    public void setup(int r10) {
        int r0 = this.mCount;
        if (r0 != 0) goto L5;
        return;
    L5:
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, r0 - 1);
        int r1 = 1;
        int r2 = 1;
    L7:
        if (r1 >= this.mCount) goto L12;
        int[] r3 = this.mTimePoints;
        if (r3[r1 - 1] == r3[r1]) goto L11;
        r2 = r2 + 1;
    L11:
        r1 = r1 + 1;
        goto L7
    L12:
        double[] r4 = new double[r2];
        double[][] r5 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r2, 1});
        int r6 = 0;
        int r7 = 0;
    L14:
        if (r6 >= this.mCount) goto L21;
        if (r6 <= 0) goto L19;
        int[] r8 = this.mTimePoints;
        if (r8[r6] != r8[r6 - 1]) goto L19;
    L20:
        r6 = r6 + 1;
    L19:
        r4[r7] = ((double) this.mTimePoints[r6]) * 0.01d;
        r5[r7][0] = this.mValues[r6];
        r7 = r7 + 1;
        goto L20
    L21:
        this.mCurveFit = CurveFit.get(r10, r4, r5);
    }

    public static SplineSet makeCustomSpline(String r1, KeyFrameArray.CustomArray r2) {
        return new CustomSet(r1, r2);
    }

    public static SplineSet makeCustomSplineSet(String r1, KeyFrameArray.CustomVar r2) {
        return new CustomSpline(r1, r2);
    }

    public static SplineSet makeSpline(String r1, long r2) {
        return new CoreSpline(r1, r2);
    }
}
