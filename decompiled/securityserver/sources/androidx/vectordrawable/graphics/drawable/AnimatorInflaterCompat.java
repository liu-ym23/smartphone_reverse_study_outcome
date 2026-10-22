package androidx.vectordrawable.graphics.drawable;

import a.a;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import androidx.annotation.AnimatorRes;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import com.bytedance.frameworks.baselib.network.http.util.HttpStatus;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class AnimatorInflaterCompat {
    private static final boolean DBG_ANIMATOR_INFLATER = false;
    private static final int MAX_NUM_POINTS = 100;
    private static final String TAG = "AnimatorInflater";
    private static final int TOGETHER = 0;
    private static final int VALUE_TYPE_COLOR = 3;
    private static final int VALUE_TYPE_FLOAT = 0;
    private static final int VALUE_TYPE_INT = 1;
    private static final int VALUE_TYPE_PATH = 2;
    private static final int VALUE_TYPE_UNDEFINED = 4;

    public static class PathDataEvaluator implements TypeEvaluator<PathParser.PathDataNode[]> {
        private PathParser.PathDataNode[] mNodeArray;

        public PathDataEvaluator() {
        }

        @Override // android.animation.TypeEvaluator
        public /* bridge */ /* synthetic */ PathParser.PathDataNode[] evaluate(float r1, PathParser.PathDataNode[] r2, PathParser.PathDataNode[] r3) {
            return evaluate2(r1, r2, r3);
        }

        public PathDataEvaluator(PathParser.PathDataNode[] r1) {
            this.mNodeArray = r1;
        }

        /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
        public PathParser.PathDataNode[] evaluate2(float r5, PathParser.PathDataNode[] r6, PathParser.PathDataNode[] r7) {
            if (PathParser.canMorph(r6, r7) == false) goto L14;
            if (PathParser.canMorph(this.mNodeArray, r6) == true) goto L7;
            this.mNodeArray = PathParser.deepCopyNodes(r6);
        L7:
            int r0 = 0;
        L9:
            if (r0 >= r6.length) goto L12;
            this.mNodeArray[r0].interpolatePathDataNode(r6[r0], r7[r0], r5);
            r0 = r0 + 1;
            goto L9
        L12:
            return this.mNodeArray;
        L14:
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    private AnimatorInflaterCompat() {
    }

    private static Animator createAnimatorFromXml(Context r8, Resources r9, Resources.Theme r10, XmlPullParser r11, float r12) {
        return createAnimatorFromXml(r8, r9, r10, r11, Xml.asAttributeSet(r11), null, 0, r12);
    }

    private static Keyframe createNewKeyframe(Keyframe r2, float r3) {
        if (r2.getType() != Float.TYPE) goto L6;
        return Keyframe.ofFloat(r3);
    L6:
        if (r2.getType() != Integer.TYPE) goto L9;
        return Keyframe.ofInt(r3);
    L9:
        return Keyframe.ofObject(r3);
    }

    private static void distributeKeyframes(Keyframe[] r2, float r3, int r4, int r5) {
        float r6 = r3 / ((r5 - r4) + 2);
    L3:
        if (r4 > r5) goto L5;
        r2[r4].setFraction(r2[r4 - 1].getFraction() + r6);
        r4 = r4 + 1;
        goto L3
    }

    private static void dumpKeyframes(Object[] r6, String r7) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r6.length == 0) goto L20;
        Log.d(TAG, r7);
        int r8 = r6.length;
        int r1 = 0;
    L7:
        if (r1 >= r8) goto L21;
        Keyframe r2 = (Keyframe) r6[r1];
        StringBuilder r3 = a.p(r1, "Keyframe ", ": fraction ");
        Object r5 = "null";
        if (r2.getFraction() >= 0.0f) goto L11;
        Object r4 = "null";
    L12:
        r3.append(r4);
        r3.append(", , value : ");
        if (r2.hasValue() == false) goto L15;
        r5 = r2.getValue();
    L15:
        r3.append(r5);
        Log.d(TAG, r3.toString());
        r1 = r1 + 1;
        goto L7
    L11:
        r4 = Float.valueOf(r2.getFraction());
        goto L12
    L21:
        return;
    }

    private static PropertyValuesHolder getPVH(TypedArray r11, int r12, int r13, int r14, String r15) {
        TypedValue r1 = r11.peekValue(r13);
        if (r1 == null) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L8;
        int r2 = r1.type;
    L9:
        TypedValue r5 = r11.peekValue(r14);
        if (r5 == null) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L15;
        int r7 = r5.type;
    L17:
        if (r12 != 4) goto L26;
        if (r4 == true) goto L20;
    L21:
        if (r6 == true) goto L23;
    L25:
        r12 = 0;
        goto L26
    L23:
        if (isColorType(r7) == false) goto L25;
    L24:
        r12 = 3;
        goto L26
    L20:
        if (isColorType(r2) == true) goto L24;
    L26:
        if (r12 != 0) goto L28;
        boolean r8 = true;
    L29:
        PropertyValuesHolder r9 = null;
        if (r12 != 2) goto L46;
        String r16 = r11.getString(r13);
        String r17 = r11.getString(r14);
        PathParser.PathDataNode[] r18 = PathParser.createNodesFromPathData(r16);
        PathParser.PathDataNode[] r19 = PathParser.createNodesFromPathData(r17);
        if (r18 != null) goto L34;
        if (r19 != null) goto L34;
        return null;
    L34:
        if (r18 == null) goto L44;
        PathDataEvaluator r0 = new PathDataEvaluator();
        if (r19 != null) goto L38;
        PropertyValuesHolder r110 = PropertyValuesHolder.ofObject(r15, r0, new Object[]{r18});
    L95:
        return r110;
    L38:
        if (PathParser.canMorph(r18, r19) == false) goto L42;
        r110 = PropertyValuesHolder.ofObject(r15, r0, new Object[]{r18, r19});
        goto L95
    L42:
        throw new InflateException(" Can't morph from " + r16 + " to " + r17);
    L44:
        if (r19 != null) goto L97;
        return null;
    L97:
        return PropertyValuesHolder.ofObject(r15, new PathDataEvaluator(), new Object[]{r19});
    L46:
        if (r12 != 3) goto L48;
        ArgbEvaluator r111 = ArgbEvaluator.getInstance();
    L50:
        if (r8 == false) goto L66;
        if (r4 == false) goto L62;
        if (r2 != 5) goto L54;
        float r112 = r11.getDimension(r13, 0.0f);
    L55:
        if (r6 == false) goto L61;
        if (r7 != 5) goto L58;
        float r113 = r11.getDimension(r14, 0.0f);
    L59:
        PropertyValuesHolder r114 = PropertyValuesHolder.ofFloat(r15, new float[]{r112, r113});
    L60:
        r9 = r114;
    L90:
        if (r9 == null) goto L98;
        if (r111 == null) goto L99;
        r9.setEvaluator(r111);
        return r9;
    L99:
        return r9;
    L98:
        return r9;
    L58:
        r113 = r11.getFloat(r14, 0.0f);
        goto L59
    L61:
        r114 = PropertyValuesHolder.ofFloat(r15, new float[]{r112});
        goto L60
    L54:
        r112 = r11.getFloat(r13, 0.0f);
        goto L55
    L62:
        if (r7 != 5) goto L64;
        float r115 = r11.getDimension(r14, 0.0f);
    L65:
        r114 = PropertyValuesHolder.ofFloat(r15, new float[]{r115});
        goto L60
    L64:
        r115 = r11.getFloat(r14, 0.0f);
        goto L65
    L66:
        if (r4 == false) goto L82;
        if (r2 != 5) goto L70;
        int r116 = (int) r11.getDimension(r13, 0.0f);
    L73:
        if (r6 == false) goto L81;
        if (r7 != 5) goto L77;
        int r117 = (int) r11.getDimension(r14, 0.0f);
    L80:
        r9 = PropertyValuesHolder.ofInt(r15, new int[]{r116, r117});
        goto L90
    L77:
        if (isColorType(r7) == false) goto L79;
        r117 = r11.getColor(r14, 0);
        goto L80
    L79:
        r117 = r11.getInt(r14, 0);
        goto L80
    L81:
        r9 = PropertyValuesHolder.ofInt(r15, new int[]{r116});
        goto L90
    L70:
        if (isColorType(r2) == false) goto L72;
        r116 = r11.getColor(r13, 0);
        goto L73
    L72:
        r116 = r11.getInt(r13, 0);
        goto L73
    L82:
        if (r6 == false) goto L90;
        if (r7 != 5) goto L86;
        int r118 = (int) r11.getDimension(r14, 0.0f);
    L89:
        r9 = PropertyValuesHolder.ofInt(r15, new int[]{r118});
        goto L90
    L86:
        if (isColorType(r7) == false) goto L88;
        r118 = r11.getColor(r14, 0);
        goto L89
    L88:
        r118 = r11.getInt(r14, 0);
        goto L89
    L48:
        r111 = null;
        goto L50
    L28:
        r8 = false;
        goto L29
    L15:
        r7 = 0;
        goto L17
    L12:
        r6 = false;
        goto L13
    L8:
        r2 = 0;
        goto L9
    L5:
        r4 = false;
        goto L6
    }

    private static int inferValueTypeFromValues(TypedArray r3, int r4, int r5) {
        TypedValue r6 = r3.peekValue(r4);
        boolean r0 = true;
        if (r6 == null) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        int r7 = r6.type;
    L9:
        TypedValue r8 = r3.peekValue(r5);
        if (r8 != null) goto L13;
        r0 = false;
    L13:
        if (r0 == false) goto L15;
        int r9 = r8.type;
    L16:
        if (r2 == true) goto L18;
    L19:
        if (r0 == true) goto L21;
        return 0;
    L21:
        if (isColorType(r9) == false) goto L25;
    L22:
        return 3;
    L25:
        return 0;
    L18:
        if (isColorType(r7) == true) goto L22;
    L15:
        r9 = 0;
        goto L16
    L8:
        r7 = 0;
        goto L9
    L5:
        r2 = false;
        goto L6
    }

    private static int inferValueTypeOfKeyframe(Resources r1, Resources.Theme r2, AttributeSet r3, XmlPullParser r4) {
        TypedArray r5 = TypedArrayUtils.obtainAttributes(r1, r2, r3, AndroidResources.STYLEABLE_KEYFRAME);
        int r6 = 0;
        TypedValue r7 = TypedArrayUtils.peekNamedValue(r5, r4, "value", 0);
        if (r7 != null) goto L5;
    L7:
        r5.recycle();
        return r6;
    L5:
        if (isColorType(r7.type) == false) goto L7;
        r6 = 3;
        goto L7
    }

    private static boolean isColorType(int r1) {
        if (r1 >= 28) goto L5;
    L7:
        return false;
    L5:
        if (r1 > 31) goto L7;
        return true;
    }

    public static Animator loadAnimator(Context r0, @AnimatorRes int r1) {
        return AnimatorInflater.loadAnimator(r0, r1);
    }

    private static Keyframe loadKeyframe(Context r6, Resources r7, Resources.Theme r8, AttributeSet r9, int r10, XmlPullParser r11) {
        TypedArray r12 = TypedArrayUtils.obtainAttributes(r7, r8, r9, AndroidResources.STYLEABLE_KEYFRAME);
        float r13 = TypedArrayUtils.getNamedFloat(r12, r11, "fraction", 3, -1.0f);
        TypedValue r2 = TypedArrayUtils.peekNamedValue(r12, r11, "value", 0);
        if (r2 == null) goto L5;
        boolean r4 = true;
    L7:
        if (r10 != 4) goto L13;
        if (r4 == true) goto L10;
    L12:
        r10 = 0;
        goto L13
    L10:
        if (isColorType(r2.type) == false) goto L12;
        r10 = 3;
    L13:
        if (r4 == false) goto L20;
        if (r10 == 0) goto L19;
        if (r10 == 1) goto L18;
        if (r10 == 3) goto L18;
        Keyframe r14 = null;
    L23:
        int r15 = TypedArrayUtils.getNamedResourceId(r12, r11, "interpolator", 1, 0);
        if (r15 <= 0) goto L26;
        r14.setInterpolator(AnimationUtilsCompat.loadInterpolator(r6, r15));
    L26:
        r12.recycle();
        return r14;
    L18:
        r14 = Keyframe.ofInt(r13, TypedArrayUtils.getNamedInt(r12, r11, "value", 0, 0));
        goto L23
    L19:
        r14 = Keyframe.ofFloat(r13, TypedArrayUtils.getNamedFloat(r12, r11, "value", 0, 0.0f));
        goto L23
    L20:
        if (r10 != 0) goto L22;
        r14 = Keyframe.ofFloat(r13);
        goto L23
    L22:
        r14 = Keyframe.ofInt(r13);
        goto L23
    L5:
        r4 = false;
        goto L7
    }

    private static ObjectAnimator loadObjectAnimator(Context r8, Resources r9, Resources.Theme r10, AttributeSet r11, float r12, XmlPullParser r13) {
        ObjectAnimator r7 = new ObjectAnimator();
        loadAnimator(r8, r9, r10, r11, r7, r12, r13);
        return r7;
    }

    private static PropertyValuesHolder loadPvh(Context r9, Resources r10, Resources.Theme r11, XmlPullParser r12, String r13, int r14) {
        PropertyValuesHolder r0 = null;
        ArrayList r1 = null;
    L3:
        int r2 = r12.next();
        if (r2 == 3) goto L18;
        if (r2 == 1) goto L18;
        if (r12.getName().equals("keyframe") == false) goto L3;
        if (r14 != 4) goto L12;
        r14 = inferValueTypeOfKeyframe(r10, r11, Xml.asAttributeSet(r12), r12);
    L12:
        Keyframe r3 = loadKeyframe(r9, r10, r11, Xml.asAttributeSet(r12), r14, r12);
        if (r3 == null) goto L17;
        if (r1 != null) goto L16;
        r1 = new ArrayList();
    L16:
        r1.add(r3);
    L17:
        r12.next();
    L18:
        if (r1 == null) goto L53;
        int r15 = r1.size();
        if (r15 <= 0) goto L53;
        int r16 = 0;
        Keyframe r17 = (Keyframe) r1.get(0);
        Keyframe r18 = (Keyframe) r1.get(r15 - 1);
        float r4 = r18.getFraction();
        if (r4 < 1.0f) goto L24;
    L27:
        float r19 = r17.getFraction();
        if (r19 != 0.0f) goto L30;
    L33:
        Keyframe[] r110 = new Keyframe[r15];
        r1.toArray(r110);
    L34:
        if (r16 >= r15) goto L50;
        Keyframe r111 = r110[r16];
        if (r111.getFraction() >= 0.0f) goto L49;
        if (r16 != 0) goto L39;
        r111.setFraction(0.0f);
        goto L49
    L39:
        int r5 = r15 - 1;
        if (r16 != r5) goto L42;
        r111.setFraction(1.0f);
        goto L49
    L42:
        int r112 = r16 + 1;
        int r6 = r16;
    L43:
        if (r112 >= r5) goto L48;
        if (r110[r112].getFraction() >= 0.0f) goto L48;
        r6 = r112;
        r112 = r112 + 1;
    L48:
        distributeKeyframes(r110, r110[r6 + 1].getFraction() - r110[r16 - 1].getFraction(), r16, r6);
    L49:
        r16 = r16 + 1;
        goto L34
    L50:
        r0 = PropertyValuesHolder.ofKeyframe(r13, r110);
        if (r14 != 3) goto L53;
        r0.setEvaluator(ArgbEvaluator.getInstance());
        goto L53
    L30:
        if (r19 >= 0.0f) goto L32;
        r17.setFraction(0.0f);
        goto L33
    L32:
        r1.add(0, createNewKeyframe(r17, 0.0f));
        r15 = r15 + 1;
        goto L33
    L24:
        if (r4 >= 0.0f) goto L26;
        r18.setFraction(1.0f);
        goto L27
    L26:
        r1.add(r1.size(), createNewKeyframe(r18, 1.0f));
        r15 = r15 + 1;
    L53:
        return r0;
    }

    private static PropertyValuesHolder[] loadValues(Context r17, Resources r18, Resources.Theme r19, XmlPullParser r20, AttributeSet r21) {
        PropertyValuesHolder[] r7 = null;
        ArrayList r8 = null;
    L3:
        int r0 = r20.getEventType();
        int r9 = 0;
        if (r0 == 3) goto L22;
        if (r0 == 1) goto L22;
        if (r0 != 2) goto L9;
        if (r20.getName().equals("propertyValuesHolder") == false) goto L21;
        TypedArray r14 = TypedArrayUtils.obtainAttributes(r18, r19, r21, AndroidResources.STYLEABLE_PROPERTY_VALUES_HOLDER);
        String r15 = TypedArrayUtils.getNamedString(r14, r20, "propertyName", 3);
        int r5 = TypedArrayUtils.getNamedInt(r14, r20, "valueType", 2, 4);
        PropertyValuesHolder r1 = loadPvh(r17, r18, r19, r20, r15, r5);
        if (r1 != null) goto L15;
        r1 = getPVH(r14, r5, 0, 1, r15);
    L15:
        if (r1 == null) goto L19;
        if (r8 != null) goto L18;
        r8 = new ArrayList();
    L18:
        r8.add(r1);
    L19:
        r14.recycle();
    L21:
        r20.next();
        goto L3
    L9:
        r20.next();
    L22:
        if (r8 == null) goto L26;
        int r2 = r8.size();
        r7 = new PropertyValuesHolder[r2];
    L24:
        if (r9 >= r2) goto L26;
        r7[r9] = (PropertyValuesHolder) r8.get(r9);
        r9 = r9 + 1;
    L26:
        return r7;
    }

    private static void parseAnimatorFromTypeArray(ValueAnimator r11, TypedArray r12, TypedArray r13, float r14, XmlPullParser r15) {
        long r0 = TypedArrayUtils.getNamedInt(r12, r15, "duration", 1, HttpStatus.SC_MULTIPLE_CHOICES);
        long r3 = TypedArrayUtils.getNamedInt(r12, r15, "startOffset", 2, 0);
        int r6 = TypedArrayUtils.getNamedInt(r12, r15, "valueType", 7, 4);
        if (TypedArrayUtils.hasAttribute(r15, "valueFrom") == true) goto L5;
    L12:
        r11.setDuration(r0);
        r11.setStartDelay(r3);
        r11.setRepeatCount(TypedArrayUtils.getNamedInt(r12, r15, "repeatCount", 3, 0));
        r11.setRepeatMode(TypedArrayUtils.getNamedInt(r12, r15, "repeatMode", 4, 1));
        if (r13 == null) goto L16;
        setupObjectAnimator(r11, r13, r6, r14, r15);
        return;
    L16:
        return;
    L5:
        if (TypedArrayUtils.hasAttribute(r15, "valueTo") == false) goto L12;
        if (r6 != 4) goto L9;
        r6 = inferValueTypeFromValues(r12, 5, 6);
    L9:
        PropertyValuesHolder r7 = getPVH(r12, r6, 5, 6, "");
        if (r7 == null) goto L12;
        r11.setValues(new PropertyValuesHolder[]{r7});
        goto L12
    }

    private static void setupObjectAnimator(ValueAnimator r5, TypedArray r6, int r7, float r8, XmlPullParser r9) {
        ObjectAnimator r10 = (ObjectAnimator) r5;
        String r0 = TypedArrayUtils.getNamedString(r6, r9, "pathData", 1);
        if (r0 == null) goto L13;
        String r1 = TypedArrayUtils.getNamedString(r6, r9, "propertyXName", 2);
        String r11 = TypedArrayUtils.getNamedString(r6, r9, "propertyYName", 3);
        if (r7 != 2) goto L7;
    L7:
        if (r1 != null) goto L12;
        if (r11 != null) goto L12;
        throw new InflateException(r6.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
    L12:
        setupPathMotion(PathParser.createPathFromPathData(r0), r10, r8 * 0.5f, r1, r11);
        return;
    L13:
        r10.setPropertyName(TypedArrayUtils.getNamedString(r6, r9, "propertyName", 0));
    }

    private static void setupPathMotion(Path r17, ObjectAnimator r18, float r19, String r20, String r21) {
        char r5 = 0;
        PathMeasure r4 = new PathMeasure(r17, false);
        ArrayList r6 = new ArrayList();
        float r7 = 0.0f;
        r6.add(Float.valueOf(0.0f));
        float r8 = 0.0f;
    L3:
        r8 = r8 + r4.getLength();
        r6.add(Float.valueOf(r8));
        if (r4.nextContour() == true) goto L3;
        PathMeasure r9 = new PathMeasure(r17, false);
        int r0 = Math.min(100, ((int) (r8 / r19)) + 1);
        float[] r10 = new float[r0];
        float[] r11 = new float[r0];
        float[] r12 = new float[2];
        float r13 = r8 / (r0 - 1);
        int r14 = 0;
        int r15 = 0;
    L6:
        PropertyValuesHolder r16 = null;
        if (r14 >= r0) goto L14;
        r9.getPosTan(r7 - ((Float) r6.get(r15)).floatValue(), r12, null);
        r10[r14] = r12[r5];
        r11[r14] = r12[1];
        r7 = r7 + r13;
        int r110 = r15 + 1;
        if (r110 >= r6.size()) goto L13;
        if (r7 <= ((Float) r6.get(r110)).floatValue()) goto L13;
        r9.nextContour();
        r15 = r110;
    L13:
        r14 = r14 + 1;
        r5 = 0;
        goto L6
    L14:
        if (r20 == null) goto L16;
        PropertyValuesHolder r1 = PropertyValuesHolder.ofFloat(r20, r10);
    L17:
        if (r21 == null) goto L19;
        r16 = PropertyValuesHolder.ofFloat(r21, r11);
    L19:
        if (r1 != null) goto L21;
        r18.setValues(new PropertyValuesHolder[]{r16});
        return;
    L21:
        if (r16 != null) goto L23;
        r18.setValues(new PropertyValuesHolder[]{r1});
        return;
    L23:
        r18.setValues(new PropertyValuesHolder[]{r1, r16});
        return;
    L16:
        r1 = null;
        goto L17
    }

    private static Animator createAnimatorFromXml(Context r18, Resources r19, Resources.Theme r20, XmlPullParser r21, AttributeSet r22, AnimatorSet r23, int r24, float r25) {
        int r12 = r21.getDepth();
        Animator r0 = null;
        ArrayList r13 = null;
    L3:
        int r1 = r21.next();
        int r14 = 0;
        if (r1 != 3) goto L8;
        if (r21.getDepth() > r12) goto L8;
    L37:
        if (r23 == null) goto L46;
        if (r13 == null) goto L46;
        Animator[] r2 = new Animator[r13.size()];
        Iterator r3 = r13.iterator();
    L41:
        if (r3.hasNext() == false) goto L43;
        r2[r14] = (Animator) r3.next();
        r14 = r14 + 1;
        goto L41
    L43:
        if (r24 != 0) goto L45;
        r23.playTogether(r2);
        goto L46
    L45:
        r23.playSequentially(r2);
    L46:
        return r0;
    L8:
        if (r1 == 1) goto L37;
        if (r1 != 2) goto L3;
        String r4 = r21.getName();
        if (r4.equals("objectAnimator") == false) goto L17;
        r0 = loadObjectAnimator(r18, r19, r20, r22, r25, r21);
    L30:
        if (r23 == null) goto L3;
        if (r14 != 0) goto L3;
        if (r13 != null) goto L34;
        r13 = new ArrayList();
    L34:
        r13.add(r0);
        goto L3
    L17:
        if (r4.equals("animator") == false) goto L20;
        r0 = loadAnimator(r18, r19, r20, r22, null, r25, r21);
        goto L30
    L20:
        if (r4.equals("set") == false) goto L23;
        AnimatorSet r15 = new AnimatorSet();
        TypedArray r6 = TypedArrayUtils.obtainAttributes(r19, r20, r22, AndroidResources.STYLEABLE_ANIMATOR_SET);
        createAnimatorFromXml(r18, r19, r20, r21, r22, r15, TypedArrayUtils.getNamedInt(r6, r21, "ordering", 0, 0), r25);
        r6.recycle();
        r0 = r15;
        goto L30
    L23:
        if (r4.equals("propertyValuesHolder") == false) goto L36;
        PropertyValuesHolder[] r5 = loadValues(r18, r19, r20, r21, Xml.asAttributeSet(r21));
        if (r5 != null) goto L27;
    L29:
        r14 = 1;
        goto L30
    L27:
        if ((r0 instanceof ValueAnimator) == false) goto L29;
        ((ValueAnimator) r0).setValues(r5);
        goto L29
    L36:
        throw new RuntimeException("Unknown animator name: " + r21.getName());
    }

    public static Animator loadAnimator(Context r1, Resources r2, Resources.Theme r3, @AnimatorRes int r4) {
        return loadAnimator(r1, r2, r3, r4, 1.0f);
    }

    public static Animator loadAnimator(Context r2, Resources r3, Resources.Theme r4, @AnimatorRes int r5, float r6) {
        XmlResourceParser r1 = null;
        r1 = r3.getAnimation(r5);     // Catch: Throwable -> L7 IOException -> L9 XmlPullParserException -> L11
        Animator r7 = createAnimatorFromXml(r2, r3, r4, r1, r6);     // Catch: Throwable -> L7 IOException -> L9 XmlPullParserException -> L11
        if (r1 == null) goto L6;
        r1.close();
    L6:
        return r7;
    L7:
        th = move-exception;
        if (r1 == null) goto L19;
        r1.close();
    L19:
        throw th;
    L9:
        e = move-exception;
        Resources.NotFoundException r8 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(r5));     // Catch: Throwable -> L7
        r8.initCause(e);     // Catch: Throwable -> L7
        throw r8;     // Catch: Throwable -> L7
    L11:
        e = move-exception;
        Resources.NotFoundException r9 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(r5));     // Catch: Throwable -> L7
        r9.initCause(e);     // Catch: Throwable -> L7
        throw r9;     // Catch: Throwable -> L7
    }

    private static ValueAnimator loadAnimator(Context r2, Resources r3, Resources.Theme r4, AttributeSet r5, ValueAnimator r6, float r7, XmlPullParser r8) {
        TypedArray r0 = TypedArrayUtils.obtainAttributes(r3, r4, r5, AndroidResources.STYLEABLE_ANIMATOR);
        TypedArray r9 = TypedArrayUtils.obtainAttributes(r3, r4, r5, AndroidResources.STYLEABLE_PROPERTY_ANIMATOR);
        if (r6 != null) goto L5;
        r6 = new ValueAnimator();
    L5:
        parseAnimatorFromTypeArray(r6, r0, r9, r7, r8);
        int r10 = TypedArrayUtils.getNamedResourceId(r0, r8, "interpolator", 0, 0);
        if (r10 <= 0) goto L8;
        r6.setInterpolator(AnimationUtilsCompat.loadInterpolator(r2, r10));
    L8:
        r0.recycle();
        if (r9 == null) goto L11;
        r9.recycle();
    L11:
        return r6;
    }
}
