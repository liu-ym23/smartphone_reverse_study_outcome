package androidx.constraintlayout.core.motion.utils;

import a.a;
import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.MotionWidget;
import java.lang.reflect.Array;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public abstract class TimeCycleSplineSet {
    protected static final int CURVE_OFFSET = 2;
    protected static final int CURVE_PERIOD = 1;
    protected static final int CURVE_VALUE = 0;
    private static final String TAG = "SplineSet";
    protected static float VAL_2PI = 6.2831855f;
    protected int count;
    protected float last_cycle;
    protected long last_time;
    protected float[] mCache;
    protected boolean mContinue;
    protected CurveFit mCurveFit;
    protected int[] mTimePoints;
    protected String mType;
    protected float[][] mValues;
    protected int mWaveShape;

    public static class CustomSet extends TimeCycleSplineSet {
        String mAttributeName;
        float[] mCache;
        KeyFrameArray.CustomArray mConstraintAttributeList;
        float[] mTempValues;
        KeyFrameArray.FloatArray mWaveProperties;

        public CustomSet(String r2, KeyFrameArray.CustomArray r3) {
            this.mWaveProperties = new KeyFrameArray.FloatArray();
            this.mAttributeName = r2.split(",")[1];
            this.mConstraintAttributeList = r3;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setPoint(int r1, float r2, float r3, int r4, float r5) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public boolean setProperty(MotionWidget r17, float r18, long r19, KeyCache r21) {
            this.mCurveFit.getPos(r18, this.mTempValues);
            float[] r4 = this.mTempValues;
            float r5 = r4[r4.length - 2];
            float r6 = r4[r4.length - 1];
            long r8 = r19 - this.last_time;
            if (Float.isNaN(this.last_cycle) == false) goto L7;
            float r7 = r21.getFloatValue(r17, this.mAttributeName, 0);
            this.last_cycle = r7;
            if (Float.isNaN(r7) == false) goto L7;
            this.last_cycle = 0.0f;
        L7:
            float r9 = (float) ((((r8 * 1.0E-9d) * ((double) r5)) + ((double) this.last_cycle)) % 1.0d);
            this.last_cycle = r9;
            this.last_time = r19;
            float r2 = calcWave(r9);
            this.mContinue = false;
            int r3 = 0;
        L8:
            float[] r10 = this.mCache;
            if (r3 >= r10.length) goto L15;
            boolean r11 = this.mContinue;
            float r12 = this.mTempValues[r3];
            if (r12 == 0.0d) goto L13;
            boolean r13 = true;
        L14:
            this.mContinue = r11 | r13;
            r10[r3] = (r12 * r2) + r6;
            r3 = r3 + 1;
            goto L8
        L13:
            r13 = false;
            goto L14
        L15:
            r17.setInterpolatedValue(this.mConstraintAttributeList.valueAt(0), this.mCache);
            if (r5 == 0.0f) goto L19;
            this.mContinue = true;
        L19:
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
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
            CustomAttribute r8 = this.mConstraintAttributeList.valueAt(r6);
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

        public void setPoint(int r3, CustomAttribute r4, float r5, int r6, float r7) {
            this.mConstraintAttributeList.append(r3, r4);
            this.mWaveProperties.append(r3, new float[]{r5, r7});
            this.mWaveShape = Math.max(this.mWaveShape, r6);
        }
    }

    public static class CustomVarSet extends TimeCycleSplineSet {
        String mAttributeName;
        float[] mCache;
        KeyFrameArray.CustomVar mConstraintAttributeList;
        float[] mTempValues;
        KeyFrameArray.FloatArray mWaveProperties;

        public CustomVarSet(String r2, KeyFrameArray.CustomVar r3) {
            this.mWaveProperties = new KeyFrameArray.FloatArray();
            this.mAttributeName = r2.split(",")[1];
            this.mConstraintAttributeList = r3;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setPoint(int r1, float r2, float r3, int r4, float r5) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public boolean setProperty(MotionWidget r17, float r18, long r19, KeyCache r21) {
            this.mCurveFit.getPos(r18, this.mTempValues);
            float[] r4 = this.mTempValues;
            float r5 = r4[r4.length - 2];
            float r6 = r4[r4.length - 1];
            long r8 = r19 - this.last_time;
            if (Float.isNaN(this.last_cycle) == false) goto L7;
            float r7 = r21.getFloatValue(r17, this.mAttributeName, 0);
            this.last_cycle = r7;
            if (Float.isNaN(r7) == false) goto L7;
            this.last_cycle = 0.0f;
        L7:
            float r9 = (float) ((((r8 * 1.0E-9d) * ((double) r5)) + ((double) this.last_cycle)) % 1.0d);
            this.last_cycle = r9;
            this.last_time = r19;
            float r2 = calcWave(r9);
            this.mContinue = false;
            int r3 = 0;
        L8:
            float[] r10 = this.mCache;
            if (r3 >= r10.length) goto L15;
            boolean r11 = this.mContinue;
            float r12 = this.mTempValues[r3];
            if (r12 == 0.0d) goto L13;
            boolean r13 = true;
        L14:
            this.mContinue = r11 | r13;
            r10[r3] = (r12 * r2) + r6;
            r3 = r3 + 1;
            goto L8
        L13:
            r13 = false;
            goto L14
        L15:
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(r17, this.mCache);
            if (r5 == 0.0f) goto L19;
            this.mContinue = true;
        L19:
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
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
            CustomVariable r8 = this.mConstraintAttributeList.valueAt(r6);
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

        public void setPoint(int r3, CustomVariable r4, float r5, int r6, float r7) {
            this.mConstraintAttributeList.append(r3, r4);
            this.mWaveProperties.append(r3, new float[]{r5, r7});
            this.mWaveShape = Math.max(this.mWaveShape, r6);
        }
    }

    public static class Sort {
        public Sort() {
        }

        public static void doubleQuickSort(int[] r7, float[][] r8, int r9, int r10) {
            int[] r0 = new int[r7.length + 10];
            r0[0] = r10;
            r0[1] = r9;
            int r11 = 2;
        L3:
            if (r11 <= 0) goto L8;
            int r1 = r0[r11 - 1];
            int r2 = r11 - 2;
            int r3 = r0[r2];
            if (r1 < r3) goto L6;
            r11 = r2;
            goto L3
        L6:
            int r4 = partition(r7, r8, r1, r3);
            r0[r2] = r4 - 1;
            r0[r11 - 1] = r1;
            int r5 = r11 + 1;
            r0[r11] = r3;
            r11 = r11 + 2;
            r0[r5] = r4 + 1;
            goto L3
        }

        private static int partition(int[] r3, float[][] r4, int r5, int r6) {
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

        private static void swap(int[] r2, float[][] r3, int r4, int r5) {
            int r0 = r2[r4];
            r2[r4] = r2[r5];
            r2[r5] = r0;
            float[] r6 = r3[r4];
            r3[r4] = r3[r5];
            r3[r5] = r6;
        }
    }

    public TimeCycleSplineSet() {
        this.mWaveShape = 0;
        this.mTimePoints = new int[10];
        this.mValues = (float[][]) Array.newInstance(Float.TYPE, new int[]{10, 3});
        this.mCache = new float[3];
        this.mContinue = false;
        this.last_cycle = Float.NaN;
    }

    public float calcWave(float r3) {
        switch(this.mWaveShape) {
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        float r2 = 1.0f - Math.abs(((r3 * 4.0f) % 4.0f) - 2.0f);
        return 1.0f - (r2 * r2);
    L5:
        return (float) Math.sin(r3 * VAL_2PI);
    L9:
        return (float) Math.cos(r3 * VAL_2PI);
    L11:
        return 1.0f - (((r3 * 2.0f) + 1.0f) % 2.0f);
    L13:
        return (((r3 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
    L15:
        return 1.0f - Math.abs(r3);
    L17:
        return Math.signum(r3 * VAL_2PI);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public void setPoint(int r3, float r4, float r5, int r6, float r7) {
        int[] r0 = this.mTimePoints;
        int r1 = this.count;
        r0[r1] = r3;
        float[] r8 = this.mValues[r1];
        r8[0] = r4;
        r8[1] = r5;
        r8[2] = r7;
        this.mWaveShape = Math.max(this.mWaveShape, r6);
        this.count++;
    }

    public void setStartTime(long r1) {
        this.last_time = r1;
    }

    public void setType(String r1) {
        this.mType = r1;
    }

    public void setup(int r12) {
        int r0 = this.count;
        if (r0 != 0) goto L6;
        System.err.println("Error no points added to " + this.mType);
        return;
    L6:
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, r0 - 1);
        int r1 = 1;
        int r2 = 0;
    L7:
        int[] r3 = this.mTimePoints;
        if (r1 >= r3.length) goto L13;
        if (r3[r1] == r3[r1 - 1]) goto L12;
        r2 = r2 + 1;
    L12:
        r1 = r1 + 1;
        goto L7
    L13:
        if (r2 != 0) goto L15;
        r2 = 1;
    L15:
        double[] r4 = new double[r2];
        double[][] r5 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r2, 3});
        int r6 = 0;
        int r7 = 0;
    L17:
        if (r6 >= this.count) goto L24;
        if (r6 <= 0) goto L22;
        int[] r8 = this.mTimePoints;
        if (r8[r6] != r8[r6 - 1]) goto L22;
    L23:
        r6 = r6 + 1;
    L22:
        r4[r7] = ((double) this.mTimePoints[r6]) * 0.01d;
        double[] r9 = r5[r7];
        float[] r10 = this.mValues[r6];
        r9[0] = r10[0];
        r9[1] = r10[1];
        r9[2] = r10[2];
        r7 = r7 + 1;
        goto L23
    L24:
        this.mCurveFit = CurveFit.get(r12, r4, r5);
    }

    public String toString() {
        String r0 = this.mType;
        DecimalFormat r1 = new DecimalFormat("##.##");
        int r2 = 0;
    L4:
        if (r2 >= this.count) goto L6;
        StringBuilder r3 = a.t(r0, "[");
        r3.append(this.mTimePoints[r2]);
        r3.append(" , ");
        r3.append(r1.format(this.mValues[r2]));
        r3.append("] ");
        r0 = r3.toString();
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }
}
