package com.obric.oui.constraintlayout.motion.utils;

import android.util.Log;
import android.view.View;
import com.obric.oui.constraintlayout.core.motion.utils.KeyCycleOscillator;
import com.obric.oui.constraintlayout.motion.widget.MotionLayout;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import com.qq.taf.jce.JceStruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ViewOscillator extends KeyCycleOscillator {
    private static final String TAG = "ViewOscillator";

    static class AlphaSet extends ViewOscillator {
        AlphaSet() {
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.ViewOscillator
        public void setProperty(View r1, float r2) {
            r1.setAlpha(get(r2));
        }
    }

    static class CustomSet extends ViewOscillator {
        protected ConstraintAttribute mCustom;
        float[] mValue;

        CustomSet() {
            this.mValue = new float[1];
        }

        @Override // com.obric.oui.constraintlayout.core.motion.utils.KeyCycleOscillator
        protected void setCustom(Object r1) {
            this.mCustom = (ConstraintAttribute) r1;
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.ViewOscillator
        public void setProperty(View r3, float r4) {
            this.mValue[0] = get(r4);
            CustomSupport.setInterpolatedValue(this.mCustom, r3, this.mValue);
        }
    }

    static class ElevationSet extends ViewOscillator {
        ElevationSet() {
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.ViewOscillator
        public void setProperty(View r1, float r2) {
            r1.setElevation(get(r2));
        }
    }

    public static class PathRotateSet extends ViewOscillator {
        @Override // com.obric.oui.constraintlayout.motion.utils.ViewOscillator
        public void setProperty(View r1, float r2) {
        }

        public PathRotateSet() {
        }

        public void setPathRotate(View r1, float r2, double r3, double r5) {
            r1.setRotation(get(r2) + ((float) Math.toDegrees(Math.atan2(r5, r3))));
        }
    }

    static class ProgressSet extends ViewOscillator {
        boolean mNoMethod;

        ProgressSet() {
            this.mNoMethod = false;
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.ViewOscillator
        public void setProperty(View r9, float r10) {
            if ((r9 instanceof MotionLayout) == false) goto L6;
            ((MotionLayout) r9).setProgress(get(r10));
            return;
        L6:
            if (this.mNoMethod == false) goto L20;
            return;
        L20:
            Method r4 = r9.getClass().getMethod("setProgress", new Class[]{Float.TYPE});     // Catch: NoSuchMethodException -> L11
        L12:
            if (r4 == null) goto L25;
            r4.invoke(r9, new Object[]{Float.valueOf(get(r10))});     // Catch: InvocationTargetException -> L15 IllegalAccessException -> L17
        L27:
            return;
        L17:
            e = move-exception;
            Log.e(ViewOscillator.TAG, "unable to setProgress", e);
            return;
        L15:
            e = move-exception;
            Log.e(ViewOscillator.TAG, "unable to setProgress", e);
            return;
        L25:
            return;
        L11:
            this.mNoMethod = true;
            r4 = null;
            goto L12
        }
    }

    static class RotationSet extends ViewOscillator {
        RotationSet() {
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.ViewOscillator
        public void setProperty(View r1, float r2) {
            r1.setRotation(get(r2));
        }
    }

    static class RotationXset extends ViewOscillator {
        RotationXset() {
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.ViewOscillator
        public void setProperty(View r1, float r2) {
            r1.setRotationX(get(r2));
        }
    }

    static class RotationYset extends ViewOscillator {
        RotationYset() {
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.ViewOscillator
        public void setProperty(View r1, float r2) {
            r1.setRotationY(get(r2));
        }
    }

    static class ScaleXset extends ViewOscillator {
        ScaleXset() {
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.ViewOscillator
        public void setProperty(View r1, float r2) {
            r1.setScaleX(get(r2));
        }
    }

    static class ScaleYset extends ViewOscillator {
        ScaleYset() {
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.ViewOscillator
        public void setProperty(View r1, float r2) {
            r1.setScaleY(get(r2));
        }
    }

    static class TranslationXset extends ViewOscillator {
        TranslationXset() {
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.ViewOscillator
        public void setProperty(View r1, float r2) {
            r1.setTranslationX(get(r2));
        }
    }

    static class TranslationYset extends ViewOscillator {
        TranslationYset() {
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.ViewOscillator
        public void setProperty(View r1, float r2) {
            r1.setTranslationY(get(r2));
        }
    }

    static class TranslationZset extends ViewOscillator {
        TranslationZset() {
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.ViewOscillator
        public void setProperty(View r1, float r2) {
            r1.setTranslationZ(get(r2));
        }
    }

    public abstract void setProperty(View r1, float r2);

    public ViewOscillator() {
    }

    public static ViewOscillator makeSpline(String r2) {
        if (r2.startsWith("CUSTOM") == true) goto L5;
        r2.hashCode();
        byte r1 = -1;
        switch(r2.hashCode()) {
            case -1249320806: goto L62;
            case -1249320805: goto L58;
            case -1225497657: goto L54;
            case -1225497656: goto L50;
            case -1225497655: goto L46;
            case -1001078227: goto L42;
            case -908189618: goto L38;
            case -908189617: goto L34;
            case -797520672: goto L30;
            case -40300674: goto L26;
            case -4379043: goto L22;
            case 37232917: goto L18;
            case 92909918: goto L14;
            case 156108012: goto L10;
            default: goto L65;
        };
    L65:
        switch(r1) {
            case 0: goto L95;
            case 1: goto L93;
            case 2: goto L91;
            case 3: goto L89;
            case 4: goto L87;
            case 5: goto L85;
            case 6: goto L83;
            case 7: goto L81;
            case 8: goto L79;
            case 9: goto L77;
            case 10: goto L75;
            case 11: goto L73;
            case 12: goto L71;
            case 13: goto L69;
            default: goto L66;
        };
    L66:
        return null;
    L69:
        return new AlphaSet();
    L71:
        return new AlphaSet();
    L73:
        return new PathRotateSet();
    L75:
        return new ElevationSet();
    L77:
        return new RotationSet();
    L79:
        return new AlphaSet();
    L81:
        return new ScaleYset();
    L83:
        return new ScaleXset();
    L85:
        return new ProgressSet();
    L87:
        return new TranslationZset();
    L89:
        return new TranslationYset();
    L91:
        return new TranslationXset();
    L93:
        return new RotationYset();
    L95:
        return new RotationXset();
    L10:
        if (r2.equals("waveOffset") == false) goto L65;
        r1 = JceStruct.SIMPLE_LIST;
        goto L65
    L14:
        if (r2.equals("alpha") == false) goto L65;
        r1 = JceStruct.ZERO_TAG;
        goto L65
    L18:
        if (r2.equals("transitionPathRotate") == false) goto L65;
        r1 = JceStruct.STRUCT_END;
        goto L65
    L22:
        if (r2.equals("elevation") == false) goto L65;
        r1 = 10;
        goto L65
    L26:
        if (r2.equals("rotation") == false) goto L65;
        r1 = 9;
        goto L65
    L30:
        if (r2.equals("waveVariesBy") == false) goto L65;
        r1 = 8;
        goto L65
    L34:
        if (r2.equals("scaleY") == false) goto L65;
        r1 = 7;
        goto L65
    L38:
        if (r2.equals("scaleX") == false) goto L65;
        r1 = 6;
        goto L65
    L42:
        if (r2.equals("progress") == false) goto L65;
        r1 = 5;
        goto L65
    L46:
        if (r2.equals("translationZ") == false) goto L65;
        r1 = 4;
        goto L65
    L50:
        if (r2.equals("translationY") == false) goto L65;
        r1 = 3;
        goto L65
    L54:
        if (r2.equals("translationX") == false) goto L65;
        r1 = 2;
        goto L65
    L58:
        if (r2.equals("rotationY") == false) goto L65;
        r1 = 1;
        goto L65
    L62:
        if (r2.equals("rotationX") == false) goto L65;
        r1 = 0;
        goto L65
    L5:
        return new CustomSet();
    }
}
