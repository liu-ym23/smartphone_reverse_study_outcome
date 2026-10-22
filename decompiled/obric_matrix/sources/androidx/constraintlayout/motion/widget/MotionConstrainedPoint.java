package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {
    static final int CARTESIAN = 2;
    public static final boolean DEBUG = false;
    static final int PERPENDICULAR = 1;
    public static final String TAG = "MotionPaths";
    static String[] names;
    private float alpha;
    private boolean applyElevation;
    LinkedHashMap<String, ConstraintAttribute> attributes;
    private float elevation;
    private float height;
    private int mAnimateRelativeTo;
    private int mDrawPath;
    private Easing mKeyFrameEasing;
    int mMode;
    private float mPathRotate;
    private float mPivotX;
    private float mPivotY;
    private float mProgress;
    double[] mTempDelta;
    double[] mTempValue;
    int mVisibilityMode;
    private float position;
    private float rotation;
    private float rotationX;
    public float rotationY;
    private float scaleX;
    private float scaleY;
    private float translationX;
    private float translationY;
    private float translationZ;
    int visibility;
    private float width;
    private float x;
    private float y;

    static {
        names = new String[]{"position", "x", "y", "width", "height", "pathRotate"};
    }

    public MotionConstrainedPoint() {
        this.alpha = 1.0f;
        this.mVisibilityMode = 0;
        this.applyElevation = false;
        this.elevation = 0.0f;
        this.rotation = 0.0f;
        this.rotationX = 0.0f;
        this.rotationY = 0.0f;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.mPivotX = Float.NaN;
        this.mPivotY = Float.NaN;
        this.translationX = 0.0f;
        this.translationY = 0.0f;
        this.translationZ = 0.0f;
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mAnimateRelativeTo = -1;
        this.attributes = new LinkedHashMap();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    private boolean diff(float r3, float r4) {
        if (Float.isNaN(r3) == true) goto L13;
        if (Float.isNaN(r4) == true) goto L13;
        if (Math.abs(r3 - r4) <= 1.0E-6f) goto L11;
        return true;
    L11:
        return false;
    L13:
        if (Float.isNaN(r3) == Float.isNaN(r4)) goto L16;
        return true;
    L16:
        return false;
    }

    public void addValues(HashMap<String, ViewSpline> r8, int r9) {
        Iterator<String> r0 = r8.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L134;
        String r1 = r0.next();
        ViewSpline r2 = r8.get(r1);
        r1.hashCode();
        byte r3 = -1;
        switch(r1.hashCode()) {
            case -1249320806: goto L61;
            case -1249320805: goto L57;
            case -1225497657: goto L53;
            case -1225497656: goto L49;
            case -1225497655: goto L45;
            case -1001078227: goto L41;
            case -908189618: goto L37;
            case -908189617: goto L33;
            case -760884510: goto L29;
            case -760884509: goto L25;
            case -40300674: goto L21;
            case -4379043: goto L17;
            case 37232917: goto L13;
            case 92909918: goto L9;
            default: goto L64;
        };
    L64:
        float r4 = 1.0f;
        float r6 = 0.0f;
        switch(r3) {
            case 0: goto L131;
            case 1: goto L127;
            case 2: goto L123;
            case 3: goto L119;
            case 4: goto L115;
            case 5: goto L111;
            case 6: goto L107;
            case 7: goto L103;
            case 8: goto L99;
            case 9: goto L95;
            case 10: goto L91;
            case 11: goto L86;
            case 12: goto L82;
            case 13: goto L77;
            default: goto L67;
        };
    L77:
        if (Float.isNaN(this.alpha) == true) goto L80;
        r4 = this.alpha;
    L80:
        r2.setPoint(r9, r4);
        goto L4
    L82:
        if (Float.isNaN(this.mPathRotate) == true) goto L89;
        r6 = this.mPathRotate;
    L89:
        r2.setPoint(r9, r6);
        goto L4
    L86:
        if (Float.isNaN(this.elevation) == true) goto L89;
        r6 = this.elevation;
        goto L89
    L91:
        if (Float.isNaN(this.rotation) == true) goto L89;
        r6 = this.rotation;
        goto L89
    L95:
        if (Float.isNaN(this.mPivotY) == true) goto L89;
        r6 = this.mPivotY;
        goto L89
    L99:
        if (Float.isNaN(this.mPivotX) == true) goto L89;
        r6 = this.mPivotX;
        goto L89
    L103:
        if (Float.isNaN(this.scaleY) == true) goto L80;
        r4 = this.scaleY;
        goto L80
    L107:
        if (Float.isNaN(this.scaleX) == true) goto L80;
        r4 = this.scaleX;
        goto L80
    L111:
        if (Float.isNaN(this.mProgress) == true) goto L89;
        r6 = this.mProgress;
        goto L89
    L115:
        if (Float.isNaN(this.translationZ) == true) goto L89;
        r6 = this.translationZ;
        goto L89
    L119:
        if (Float.isNaN(this.translationY) == true) goto L89;
        r6 = this.translationY;
        goto L89
    L123:
        if (Float.isNaN(this.translationX) == true) goto L89;
        r6 = this.translationX;
        goto L89
    L127:
        if (Float.isNaN(this.rotationY) == true) goto L89;
        r6 = this.rotationY;
        goto L89
    L131:
        if (Float.isNaN(this.rotationX) == true) goto L89;
        r6 = this.rotationX;
        goto L89
    L67:
        if (r1.startsWith("CUSTOM") == false) goto L75;
        String r5 = r1.split(",")[1];
        if (this.attributes.containsKey(r5) == false) goto L4;
        ConstraintAttribute r7 = this.attributes.get(r5);
        if ((r2 instanceof ViewSpline.CustomSet) == true) goto L72;
        String r10 = r1 + " ViewSpline not a CustomSet frame = " + r9 + ", value" + r7.getValueToInterpolate() + r2;
    L74:
        Log.e("MotionPaths", r10);
        goto L4
    L72:
        ((ViewSpline.CustomSet) r2).setPoint(r9, r7);
        goto L4
    L75:
        r10 = "UNKNOWN spline " + r1;
        goto L74
    L9:
        if (r1.equals("alpha") == false) goto L64;
        r3 = 13;
        goto L64
    L13:
        if (r1.equals("transitionPathRotate") == false) goto L64;
        r3 = 12;
        goto L64
    L17:
        if (r1.equals("elevation") == false) goto L64;
        r3 = 11;
        goto L64
    L21:
        if (r1.equals(Key.ROTATION) == false) goto L64;
        r3 = 10;
        goto L64
    L25:
        if (r1.equals(Key.PIVOT_Y) == false) goto L64;
        r3 = 9;
        goto L64
    L29:
        if (r1.equals(Key.PIVOT_X) == false) goto L64;
        r3 = 8;
        goto L64
    L33:
        if (r1.equals("scaleY") == false) goto L64;
        r3 = 7;
        goto L64
    L37:
        if (r1.equals("scaleX") == false) goto L64;
        r3 = 6;
        goto L64
    L41:
        if (r1.equals("progress") == false) goto L64;
        r3 = 5;
        goto L64
    L45:
        if (r1.equals("translationZ") == false) goto L64;
        r3 = 4;
        goto L64
    L49:
        if (r1.equals("translationY") == false) goto L64;
        r3 = 3;
        goto L64
    L53:
        if (r1.equals("translationX") == false) goto L64;
        r3 = 2;
        goto L64
    L57:
        if (r1.equals("rotationY") == false) goto L64;
        r3 = 1;
        goto L64
    L61:
        if (r1.equals("rotationX") == false) goto L64;
        r3 = 0;
        goto L64
    }

    public void applyParameters(View r4) {
        this.visibility = r4.getVisibility();
        if (r4.getVisibility() == 0) goto L5;
        float r0 = 0.0f;
    L6:
        this.alpha = r0;
        this.applyElevation = false;
        int r1 = Build.VERSION.SDK_INT;
        if (r1 < 21) goto L9;
        this.elevation = r4.getElevation();
    L9:
        this.rotation = r4.getRotation();
        this.rotationX = r4.getRotationX();
        this.rotationY = r4.getRotationY();
        this.scaleX = r4.getScaleX();
        this.scaleY = r4.getScaleY();
        this.mPivotX = r4.getPivotX();
        this.mPivotY = r4.getPivotY();
        this.translationX = r4.getTranslationX();
        this.translationY = r4.getTranslationY();
        if (r1 < 21) goto L13;
        this.translationZ = r4.getTranslationZ();
        return;
    L13:
        return;
    L5:
        r0 = r4.getAlpha();
        goto L6
    }

    public void applyParameters(ConstraintSet.Constraint r5) {
        ConstraintSet.PropertySet r0 = r5.propertySet;
        int r1 = r0.mVisibilityMode;
        this.mVisibilityMode = r1;
        int r2 = r0.visibility;
        this.visibility = r2;
        if (r2 == 0) goto L6;
        if (r1 != 0) goto L6;
        float r3 = 0.0f;
    L7:
        this.alpha = r3;
        ConstraintSet.Transform r4 = r5.transform;
        this.applyElevation = r4.applyElevation;
        this.elevation = r4.elevation;
        this.rotation = r4.rotation;
        this.rotationX = r4.rotationX;
        this.rotationY = r4.rotationY;
        this.scaleX = r4.scaleX;
        this.scaleY = r4.scaleY;
        this.mPivotX = r4.transformPivotX;
        this.mPivotY = r4.transformPivotY;
        this.translationX = r4.translationX;
        this.translationY = r4.translationY;
        this.translationZ = r4.translationZ;
        this.mKeyFrameEasing = Easing.getInterpolator(r5.motion.mTransitionEasing);
        ConstraintSet.Motion r6 = r5.motion;
        this.mPathRotate = r6.mPathRotate;
        this.mDrawPath = r6.mDrawPath;
        this.mAnimateRelativeTo = r6.mAnimateRelativeTo;
        this.mProgress = r5.propertySet.mProgress;
        Iterator<String> r7 = r5.mCustomConstraints.keySet().iterator();
    L9:
        if (r7.hasNext() == false) goto L13;
        String r8 = r7.next();
        ConstraintAttribute r9 = r5.mCustomConstraints.get(r8);
        if (r9.isContinuous() == false) goto L9;
        this.attributes.put(r8, r9);
        goto L9
    L13:
        return;
    L6:
        r3 = r0.alpha;
        goto L7
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(MotionConstrainedPoint r1) {
        return Float.compare(this.position, r1.position);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(MotionConstrainedPoint r1) {
        return compareTo2(r1);
    }

    void different(MotionConstrainedPoint r5, HashSet<String> r6) {
        if (diff(this.alpha, r5.alpha) == false) goto L6;
        r6.add("alpha");
    L6:
        if (diff(this.elevation, r5.elevation) == false) goto L8;
        r6.add("elevation");
    L8:
        int r0 = this.visibility;
        int r2 = r5.visibility;
        if (r0 == r2) goto L16;
        if (this.mVisibilityMode != 0) goto L16;
        if (r0 == 0) goto L14;
        if (r2 != 0) goto L16;
    L14:
        r6.add("alpha");
    L16:
        if (diff(this.rotation, r5.rotation) == false) goto L19;
        r6.add(Key.ROTATION);
    L19:
        if (Float.isNaN(this.mPathRotate) == true) goto L21;
    L22:
        r6.add("transitionPathRotate");
    L24:
        if (Float.isNaN(this.mProgress) == true) goto L26;
    L27:
        r6.add("progress");
    L29:
        if (diff(this.rotationX, r5.rotationX) == false) goto L32;
        r6.add("rotationX");
    L32:
        if (diff(this.rotationY, r5.rotationY) == false) goto L35;
        r6.add("rotationY");
    L35:
        if (diff(this.mPivotX, r5.mPivotX) == false) goto L38;
        r6.add(Key.PIVOT_X);
    L38:
        if (diff(this.mPivotY, r5.mPivotY) == false) goto L41;
        r6.add(Key.PIVOT_Y);
    L41:
        if (diff(this.scaleX, r5.scaleX) == false) goto L44;
        r6.add("scaleX");
    L44:
        if (diff(this.scaleY, r5.scaleY) == false) goto L47;
        r6.add("scaleY");
    L47:
        if (diff(this.translationX, r5.translationX) == false) goto L50;
        r6.add("translationX");
    L50:
        if (diff(this.translationY, r5.translationY) == false) goto L53;
        r6.add("translationY");
    L53:
        if (diff(this.translationZ, r5.translationZ) == false) goto L56;
        r6.add("translationZ");
        return;
    L56:
        return;
    L26:
        if (Float.isNaN(r5.mProgress) == true) goto L29;
    L21:
        if (Float.isNaN(r5.mPathRotate) == true) goto L24;
        goto L22
    }

    void different(MotionConstrainedPoint r4, boolean[] r5, String[] r6) {
        r5[0] = r5[0] | diff(this.position, r4.position);
        r5[1] = r5[1] | diff(this.x, r4.x);
        r5[2] = r5[2] | diff(this.y, r4.y);
        r5[3] = r5[3] | diff(this.width, r4.width);
        boolean r0 = r5[4];
        r5[4] = diff(this.height, r4.height) | r0;
    }

    void fillStandard(double[] r7, int[] r8) {
        int r3 = 0;
        float[] r1 = {this.position, this.x, this.y, this.width, this.height, this.alpha, this.elevation, this.rotation, this.rotationX, this.rotationY, this.scaleX, this.scaleY, this.mPivotX, this.mPivotY, this.translationX, this.translationY, this.translationZ, this.mPathRotate};
        int r6 = 0;
    L4:
        if (r3 >= r8.length) goto L9;
        if (r8[r3] >= 18) goto L8;
        r7[r6] = r1[r8[r3]];
        r6 = r6 + 1;
    L8:
        r3 = r3 + 1;
        goto L4
    }

    int getCustomData(String r5, double[] r6, int r7) {
        ConstraintAttribute r4 = this.attributes.get(r5);
        if (r4.numberOfInterpolatedValues() != 1) goto L6;
        r6[r7] = r4.getValueToInterpolate();
        return 1;
    L6:
        int r8 = r4.numberOfInterpolatedValues();
        float[] r0 = new float[r8];
        r4.getValuesToInterpolate(r0);
        int r9 = 0;
    L7:
        if (r9 >= r8) goto L9;
        r6[r7] = r0[r9];
        r9 = r9 + 1;
        r7 = r7 + 1;
        goto L7
    L9:
        return r8;
    }

    int getCustomDataCount(String r1) {
        return this.attributes.get(r1).numberOfInterpolatedValues();
    }

    boolean hasCustomData(String r1) {
        return this.attributes.containsKey(r1);
    }

    void setBounds(float r1, float r2, float r3, float r4) {
        this.x = r1;
        this.y = r2;
        this.width = r3;
        this.height = r4;
    }

    public void setState(Rect r4, View r5, int r6, float r7) {
        setBounds(r4.left, r4.top, r4.width(), r4.height());
        applyParameters(r5);
        this.mPivotX = Float.NaN;
        this.mPivotY = Float.NaN;
        if (r6 != 1) goto L5;
        float r8 = r7 - 90.0f;
    L9:
        this.rotation = r8;
        return;
    L5:
        if (r6 != 2) goto L11;
        r8 = r7 + 90.0f;
        goto L9
    }

    public void setState(Rect r4, ConstraintSet r5, int r6, int r7) {
        setBounds(r4.left, r4.top, r4.width(), r4.height());
        applyParameters(r5.getParameters(r7));
        float r8 = 90.0f;
        if (r6 != 1) goto L5;
    L14:
        float r9 = this.rotation;
    L15:
        this.rotation = r9 - r8;
        return;
    L5:
        if (r6 != 2) goto L7;
    L11:
        r9 = this.rotation + 90.0f;
        this.rotation = r9;
        if (r9 <= 180.0f) goto L17;
        r8 = 360.0f;
        goto L15
    L17:
        return;
    L7:
        if (r6 == 3) goto L14;
        if (r6 == 4) goto L11;
    }

    public void setState(View r5) {
        setBounds(r5.getX(), r5.getY(), r5.getWidth(), r5.getHeight());
        applyParameters(r5);
    }
}
