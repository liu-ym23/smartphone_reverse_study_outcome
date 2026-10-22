package androidx.constraintlayout.motion.utils;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.qq.taf.jce.JceStruct;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewTimeCycle extends TimeCycleSplineSet {
    private static final String TAG = "ViewTimeCycle";

    static class AlphaSet extends ViewTimeCycle {
        AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setAlpha(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    public static class CustomSet extends ViewTimeCycle {
        String mAttributeName;
        float[] mCache;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;
        SparseArray<float[]> mWaveProperties;

        public CustomSet(String attribute, SparseArray<ConstraintAttribute> attrList) {
            this.mWaveProperties = new SparseArray();
            this.mAttributeName = attribute.split(",")[1];
            this.mConstraintAttributeList = attrList;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setup(int curveType) {
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
            this.mCurveFit = CurveFit.get(curveType, r3, r5);
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setPoint(int position, float value, float period, int shape, float offset) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public void setPoint(int position, ConstraintAttribute value, float period, int shape, float offset) {
            this.mConstraintAttributeList.append(position, value);
            this.mWaveProperties.append(position, new float[]{period, offset});
            this.mWaveShape = Math.max(this.mWaveShape, shape);
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            this.mCurveFit.getPos(t, this.mTempValues);
            float[] r4 = this.mTempValues;
            float r5 = r4[r4.length - 2];
            float r6 = r4[r4.length - 1];
            long r8 = time - this.last_time;
            if (Float.isNaN(this.last_cycle) == false) goto L7;
            this.last_cycle = cache.getFloatValue(view, this.mAttributeName, 0);
            if (Float.isNaN(this.last_cycle) == false) goto L7;
            this.last_cycle = 0.0f;
        L7:
            this.last_cycle = (float) ((((double) this.last_cycle) + ((r8 * 1.0E-9d) * ((double) r5))) % 1.0d);
            this.last_time = time;
            float r2 = calcWave(this.last_cycle);
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
            CustomSupport.setInterpolatedValue(this.mConstraintAttributeList.valueAt(0), view, this.mCache);
            if (r5 == 0.0f) goto L19;
            this.mContinue = true;
        L19:
            return this.mContinue;
        }
    }

    static class ElevationSet extends ViewTimeCycle {
        ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setElevation(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    public static class PathRotate extends ViewTimeCycle {
        public PathRotate() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            return this.mContinue;
        }

        public boolean setPathRotate(View view, KeyCache cache, float t, long time, double dx, double dy) {
            view.setRotation(get(t, time, view, cache) + ((float) Math.toDegrees(Math.atan2(dy, dx))));
            return this.mContinue;
        }
    }

    static class ProgressSet extends ViewTimeCycle {
        boolean mNoMethod;

        ProgressSet() {
            this.mNoMethod = false;
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            if ((view instanceof MotionLayout) == false) goto L6;
            ((MotionLayout) view).setProgress(get(t, time, view, cache));
        L21:
            return this.mContinue;
        L6:
            if (this.mNoMethod == false) goto L22;
            return false;
        L22:
            Method r2 = view.getClass().getMethod("setProgress", new Class[]{Float.TYPE});     // Catch: NoSuchMethodException -> L11
        L12:
            Method r11 = r2;
            if (r11 == null) goto L21;
            r11.invoke(view, new Object[]{Float.valueOf(get(t, time, view, cache))});     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18
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

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setRotation(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    static class RotationXset extends ViewTimeCycle {
        RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setRotationX(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    static class RotationYset extends ViewTimeCycle {
        RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setRotationY(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    static class ScaleXset extends ViewTimeCycle {
        ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setScaleX(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    static class ScaleYset extends ViewTimeCycle {
        ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setScaleY(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    static class TranslationXset extends ViewTimeCycle {
        TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setTranslationX(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    static class TranslationYset extends ViewTimeCycle {
        TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setTranslationY(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    static class TranslationZset extends ViewTimeCycle {
        TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setTranslationZ(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    public abstract boolean setProperty(View view, float t, long time, KeyCache cache);

    public ViewTimeCycle() {
    }

    public float get(float pos, long time, View view, KeyCache cache) {
        this.mCurveFit.getPos(pos, this.mCache);
        float r5 = this.mCache[1];
        if (r5 != 0.0f) goto L7;
        this.mContinue = false;
        return this.mCache[2];
    L7:
        if (Float.isNaN(this.last_cycle) == false) goto L11;
        this.last_cycle = cache.getFloatValue(view, this.mType, 0);
        if (Float.isNaN(this.last_cycle) == false) goto L11;
        this.last_cycle = 0.0f;
    L11:
        this.last_cycle = (float) ((((double) this.last_cycle) + (((time - this.last_time) * 1.0E-9d) * ((double) r5))) % 1.0d);
        cache.setFloatValue(view, this.mType, 0, this.last_cycle);
        this.last_time = time;
        float r1 = this.mCache[0];
        float r2 = (calcWave(this.last_cycle) * r1) + this.mCache[2];
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

    public static ViewTimeCycle makeCustomSpline(String str, SparseArray<ConstraintAttribute> attrList) {
        return new CustomSet(str, attrList);
    }

    public static ViewTimeCycle makeSpline(String str, long currentTime) {
        str.hashCode();
        byte r1 = -1;
        switch(str.hashCode()) {
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
        ViewTimeCycle r2 = new AlphaSet();
    L68:
        r2.setStartTime(currentTime);
        return r2;
    L57:
        r2 = new PathRotate();
        goto L68
    L58:
        r2 = new ElevationSet();
        goto L68
    L59:
        r2 = new RotationSet();
        goto L68
    L60:
        r2 = new ScaleYset();
        goto L68
    L61:
        r2 = new ScaleXset();
        goto L68
    L62:
        r2 = new ProgressSet();
        goto L68
    L63:
        r2 = new TranslationZset();
        goto L68
    L64:
        r2 = new TranslationYset();
        goto L68
    L65:
        r2 = new TranslationXset();
        goto L68
    L66:
        r2 = new RotationYset();
        goto L68
    L67:
        r2 = new RotationXset();
        goto L68
    L6:
        if (str.equals("alpha") == false) goto L53;
        r1 = JceStruct.STRUCT_END;
        goto L53
    L10:
        if (str.equals("transitionPathRotate") == false) goto L53;
        r1 = 10;
        goto L53
    L14:
        if (str.equals("elevation") == false) goto L53;
        r1 = 9;
        goto L53
    L18:
        if (str.equals("rotation") == false) goto L53;
        r1 = 8;
        goto L53
    L22:
        if (str.equals("scaleY") == false) goto L53;
        r1 = 7;
        goto L53
    L26:
        if (str.equals("scaleX") == false) goto L53;
        r1 = 6;
        goto L53
    L30:
        if (str.equals("progress") == false) goto L53;
        r1 = 5;
        goto L53
    L34:
        if (str.equals("translationZ") == false) goto L53;
        r1 = 4;
        goto L53
    L38:
        if (str.equals("translationY") == false) goto L53;
        r1 = 3;
        goto L53
    L42:
        if (str.equals("translationX") == false) goto L53;
        r1 = 2;
        goto L53
    L46:
        if (str.equals("rotationY") == false) goto L53;
        r1 = 1;
        goto L53
    L50:
        if (str.equals("rotationX") == false) goto L53;
        r1 = 0;
        goto L53
    }
}
