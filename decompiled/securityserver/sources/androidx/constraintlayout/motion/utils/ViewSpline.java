package androidx.constraintlayout.motion.utils;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewSpline extends SplineSet {
    private static final String TAG = "ViewSpline";

    public static class AlphaSet extends ViewSpline {
        public AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View r1, float r2) {
            r1.setAlpha(get(r2));
        }
    }

    public static class CustomSet extends ViewSpline {
        String mAttributeName;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;

        public CustomSet(String r2, SparseArray<ConstraintAttribute> r3) {
            this.mAttributeName = r2.split(",")[1];
            this.mConstraintAttributeList = r3;
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setPoint(int r1, float r2) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View r4, float r5) {
            this.mCurveFit.getPos(r5, this.mTempValues);
            CustomSupport.setInterpolatedValue(this.mConstraintAttributeList.valueAt(0), r4, this.mTempValues);
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
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
            ConstraintAttribute r6 = this.mConstraintAttributeList.valueAt(r4);
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

        public void setPoint(int r1, ConstraintAttribute r2) {
            this.mConstraintAttributeList.append(r1, r2);
        }
    }

    public static class ElevationSet extends ViewSpline {
        public ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View r1, float r2) {
            r1.setElevation(get(r2));
        }
    }

    public static class PathRotate extends ViewSpline {
        public PathRotate() {
        }

        public void setPathRotate(View r1, float r2, double r3, double r5) {
            r1.setRotation(get(r2) + ((float) Math.toDegrees(Math.atan2(r5, r3))));
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View r1, float r2) {
        }
    }

    public static class PivotXset extends ViewSpline {
        public PivotXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View r1, float r2) {
            r1.setPivotX(get(r2));
        }
    }

    public static class PivotYset extends ViewSpline {
        public PivotYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View r1, float r2) {
            r1.setPivotY(get(r2));
        }
    }

    public static class ProgressSet extends ViewSpline {
        boolean mNoMethod;

        public ProgressSet() {
            this.mNoMethod = false;
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View r6, float r7) {
            if ((r6 instanceof MotionLayout) == false) goto L6;
            ((MotionLayout) r6).setProgress(get(r7));
            return;
        L6:
            if (this.mNoMethod == false) goto L21;
            return;
        L21:
            Method r2 = r6.getClass().getMethod("setProgress", new Class[]{Float.TYPE});     // Catch: NoSuchMethodException -> L10
        L11:
            if (r2 == null) goto L26;
            r2.invoke(r6, new Object[]{Float.valueOf(get(r7))});     // Catch: InvocationTargetException -> L14 IllegalAccessException -> L16
        L28:
            return;
        L16:
            e = move-exception;
            Log.e(ViewSpline.TAG, "unable to setProgress", e);
            return;
        L14:
            e = move-exception;
            Log.e(ViewSpline.TAG, "unable to setProgress", e);
            return;
        L26:
            return;
        L10:
            this.mNoMethod = true;
            r2 = null;
            goto L11
        }
    }

    public static class RotationSet extends ViewSpline {
        public RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View r1, float r2) {
            r1.setRotation(get(r2));
        }
    }

    public static class RotationXset extends ViewSpline {
        public RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View r1, float r2) {
            r1.setRotationX(get(r2));
        }
    }

    public static class RotationYset extends ViewSpline {
        public RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View r1, float r2) {
            r1.setRotationY(get(r2));
        }
    }

    public static class ScaleXset extends ViewSpline {
        public ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View r1, float r2) {
            r1.setScaleX(get(r2));
        }
    }

    public static class ScaleYset extends ViewSpline {
        public ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View r1, float r2) {
            r1.setScaleY(get(r2));
        }
    }

    public static class TranslationXset extends ViewSpline {
        public TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View r1, float r2) {
            r1.setTranslationX(get(r2));
        }
    }

    public static class TranslationYset extends ViewSpline {
        public TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View r1, float r2) {
            r1.setTranslationY(get(r2));
        }
    }

    public static class TranslationZset extends ViewSpline {
        public TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View r1, float r2) {
            r1.setTranslationZ(get(r2));
        }
    }

    public ViewSpline() {
    }

    public static ViewSpline makeCustomSpline(String r1, SparseArray<ConstraintAttribute> r2) {
        return new CustomSet(r1, r2);
    }

    public static ViewSpline makeSpline(String r2) {
        r2.getClass();
        byte r0 = -1;
        switch(r2.hashCode()) {
            case -1249320806: goto L66;
            case -1249320805: goto L62;
            case -1225497657: goto L58;
            case -1225497656: goto L54;
            case -1225497655: goto L50;
            case -1001078227: goto L46;
            case -908189618: goto L42;
            case -908189617: goto L38;
            case -797520672: goto L34;
            case -760884510: goto L30;
            case -760884509: goto L26;
            case -40300674: goto L22;
            case -4379043: goto L18;
            case 37232917: goto L14;
            case 92909918: goto L10;
            case 156108012: goto L6;
            default: goto L69;
        };
    L69:
        switch(r0) {
            case 0: goto L103;
            case 1: goto L101;
            case 2: goto L99;
            case 3: goto L97;
            case 4: goto L95;
            case 5: goto L93;
            case 6: goto L91;
            case 7: goto L89;
            case 8: goto L87;
            case 9: goto L85;
            case 10: goto L83;
            case 11: goto L81;
            case 12: goto L79;
            case 13: goto L77;
            case 14: goto L75;
            case 15: goto L73;
            default: goto L70;
        };
    L70:
        return null;
    L73:
        return new AlphaSet();
    L75:
        return new AlphaSet();
    L77:
        return new PathRotate();
    L79:
        return new ElevationSet();
    L81:
        return new RotationSet();
    L83:
        return new PivotYset();
    L85:
        return new PivotXset();
    L87:
        return new AlphaSet();
    L89:
        return new ScaleYset();
    L91:
        return new ScaleXset();
    L93:
        return new ProgressSet();
    L95:
        return new TranslationZset();
    L97:
        return new TranslationYset();
    L99:
        return new TranslationXset();
    L101:
        return new RotationYset();
    L103:
        return new RotationXset();
    L6:
        if (r2.equals("waveOffset") == false) goto L69;
        r0 = 15;
        goto L69
    L10:
        if (r2.equals("alpha") == false) goto L69;
        r0 = 14;
        goto L69
    L14:
        if (r2.equals("transitionPathRotate") == false) goto L69;
        r0 = 13;
        goto L69
    L18:
        if (r2.equals("elevation") == false) goto L69;
        r0 = 12;
        goto L69
    L22:
        if (r2.equals(Key.ROTATION) == false) goto L69;
        r0 = 11;
        goto L69
    L26:
        if (r2.equals(Key.PIVOT_Y) == false) goto L69;
        r0 = 10;
        goto L69
    L30:
        if (r2.equals(Key.PIVOT_X) == false) goto L69;
        r0 = 9;
        goto L69
    L34:
        if (r2.equals(Key.WAVE_VARIES_BY) == false) goto L69;
        r0 = 8;
        goto L69
    L38:
        if (r2.equals("scaleY") == false) goto L69;
        r0 = 7;
        goto L69
    L42:
        if (r2.equals("scaleX") == false) goto L69;
        r0 = 6;
        goto L69
    L46:
        if (r2.equals("progress") == false) goto L69;
        r0 = 5;
        goto L69
    L50:
        if (r2.equals("translationZ") == false) goto L69;
        r0 = 4;
        goto L69
    L54:
        if (r2.equals("translationY") == false) goto L69;
        r0 = 3;
        goto L69
    L58:
        if (r2.equals("translationX") == false) goto L69;
        r0 = 2;
        goto L69
    L62:
        if (r2.equals("rotationY") == false) goto L69;
        r0 = 1;
        goto L69
    L66:
        if (r2.equals("rotationX") == false) goto L69;
        r0 = 0;
        goto L69
    }

    public abstract void setProperty(View r1, float r2);
}
