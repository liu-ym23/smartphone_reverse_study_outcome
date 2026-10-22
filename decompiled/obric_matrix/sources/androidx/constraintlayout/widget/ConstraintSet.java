package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.motion.widget.ViewTransition;
import androidx.core.os.EnvironmentCompat;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintSet {
    private static final int ALPHA = 43;
    private static final int ANIMATE_CIRCLE_ANGLE_TO = 82;
    private static final int ANIMATE_RELATIVE_TO = 64;
    private static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
    private static final int BARRIER_DIRECTION = 72;
    private static final int BARRIER_MARGIN = 73;
    private static final int BARRIER_TYPE = 1;
    public static final int BASELINE = 5;
    private static final int BASELINE_MARGIN = 93;
    private static final int BASELINE_TO_BASELINE = 1;
    private static final int BASELINE_TO_BOTTOM = 92;
    private static final int BASELINE_TO_TOP = 91;
    public static final int BOTTOM = 4;
    private static final int BOTTOM_MARGIN = 2;
    private static final int BOTTOM_TO_BOTTOM = 3;
    private static final int BOTTOM_TO_TOP = 4;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    private static final int CHAIN_USE_RTL = 71;
    private static final int CIRCLE = 61;
    private static final int CIRCLE_ANGLE = 63;
    private static final int CIRCLE_RADIUS = 62;
    public static final int CIRCLE_REFERENCE = 8;
    private static final int CONSTRAINED_HEIGHT = 81;
    private static final int CONSTRAINED_WIDTH = 80;
    private static final int CONSTRAINT_REFERENCED_IDS = 74;
    private static final int CONSTRAINT_TAG = 77;
    private static final boolean DEBUG = false;
    private static final int DIMENSION_RATIO = 5;
    private static final int DRAW_PATH = 66;
    private static final int EDITOR_ABSOLUTE_X = 6;
    private static final int EDITOR_ABSOLUTE_Y = 7;
    private static final int ELEVATION = 44;
    public static final int END = 7;
    private static final int END_MARGIN = 8;
    private static final int END_TO_END = 9;
    private static final int END_TO_START = 10;
    private static final String ERROR_MESSAGE = "XML parser error must be within a Constraint ";
    public static final int GONE = 8;
    private static final int GONE_BASELINE_MARGIN = 94;
    private static final int GONE_BOTTOM_MARGIN = 11;
    private static final int GONE_END_MARGIN = 12;
    private static final int GONE_LEFT_MARGIN = 13;
    private static final int GONE_RIGHT_MARGIN = 14;
    private static final int GONE_START_MARGIN = 15;
    private static final int GONE_TOP_MARGIN = 16;
    private static final int GUIDELINE_USE_RTL = 99;
    private static final int GUIDE_BEGIN = 17;
    private static final int GUIDE_END = 18;
    private static final int GUIDE_PERCENT = 19;
    private static final int HEIGHT_DEFAULT = 55;
    private static final int HEIGHT_MAX = 57;
    private static final int HEIGHT_MIN = 59;
    private static final int HEIGHT_PERCENT = 70;
    public static final int HORIZONTAL = 0;
    private static final int HORIZONTAL_BIAS = 20;
    public static final int HORIZONTAL_GUIDELINE = 0;
    private static final int HORIZONTAL_STYLE = 41;
    private static final int HORIZONTAL_WEIGHT = 39;
    private static final int INTERNAL_MATCH_CONSTRAINT = -3;
    private static final int INTERNAL_MATCH_PARENT = -1;
    private static final int INTERNAL_WRAP_CONTENT = -2;
    private static final int INTERNAL_WRAP_CONTENT_CONSTRAINED = -4;
    public static final int INVISIBLE = 4;
    private static final String KEY_PERCENT_PARENT = "parent";
    private static final String KEY_RATIO = "ratio";
    private static final String KEY_WEIGHT = "weight";
    private static final int LAYOUT_CONSTRAINT_HEIGHT = 96;
    private static final int LAYOUT_CONSTRAINT_WIDTH = 95;
    private static final int LAYOUT_HEIGHT = 21;
    private static final int LAYOUT_VISIBILITY = 22;
    private static final int LAYOUT_WIDTH = 23;
    private static final int LAYOUT_WRAP_BEHAVIOR = 97;
    public static final int LEFT = 1;
    private static final int LEFT_MARGIN = 24;
    private static final int LEFT_TO_LEFT = 25;
    private static final int LEFT_TO_RIGHT = 26;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    private static final int MOTION_STAGGER = 79;
    private static final int MOTION_TARGET = 98;
    private static final int ORIENTATION = 27;
    public static final int PARENT_ID = 0;
    private static final int PATH_MOTION_ARC = 76;
    private static final int PROGRESS = 68;
    private static final int QUANTIZE_MOTION_INTERPOLATOR = 86;
    private static final int QUANTIZE_MOTION_INTERPOLATOR_ID = 89;
    private static final int QUANTIZE_MOTION_INTERPOLATOR_STR = 90;
    private static final int QUANTIZE_MOTION_INTERPOLATOR_TYPE = 88;
    private static final int QUANTIZE_MOTION_PHASE = 85;
    private static final int QUANTIZE_MOTION_STEPS = 84;
    public static final int RIGHT = 2;
    private static final int RIGHT_MARGIN = 28;
    private static final int RIGHT_TO_LEFT = 29;
    private static final int RIGHT_TO_RIGHT = 30;
    public static final int ROTATE_LEFT_OF_PORTRATE = 4;
    public static final int ROTATE_NONE = 0;
    public static final int ROTATE_PORTRATE_OF_LEFT = 2;
    public static final int ROTATE_PORTRATE_OF_RIGHT = 1;
    public static final int ROTATE_RIGHT_OF_PORTRATE = 3;
    private static final int ROTATION = 60;
    private static final int ROTATION_X = 45;
    private static final int ROTATION_Y = 46;
    private static final int SCALE_X = 47;
    private static final int SCALE_Y = 48;
    public static final int START = 6;
    private static final int START_MARGIN = 31;
    private static final int START_TO_END = 32;
    private static final int START_TO_START = 33;
    private static final String TAG = "ConstraintSet";
    public static final int TOP = 3;
    private static final int TOP_MARGIN = 34;
    private static final int TOP_TO_BOTTOM = 35;
    private static final int TOP_TO_TOP = 36;
    private static final int TRANSFORM_PIVOT_TARGET = 83;
    private static final int TRANSFORM_PIVOT_X = 49;
    private static final int TRANSFORM_PIVOT_Y = 50;
    private static final int TRANSITION_EASING = 65;
    private static final int TRANSITION_PATH_ROTATE = 67;
    private static final int TRANSLATION_X = 51;
    private static final int TRANSLATION_Y = 52;
    private static final int TRANSLATION_Z = 53;
    public static final int UNSET = -1;
    private static final int UNUSED = 87;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_BIAS = 37;
    public static final int VERTICAL_GUIDELINE = 1;
    private static final int VERTICAL_STYLE = 42;
    private static final int VERTICAL_WEIGHT = 40;
    private static final int VIEW_ID = 38;
    private static final int[] VISIBILITY_FLAGS = null;
    private static final int VISIBILITY_MODE = 78;
    public static final int VISIBILITY_MODE_IGNORE = 1;
    public static final int VISIBILITY_MODE_NORMAL = 0;
    public static final int VISIBLE = 0;
    private static final int WIDTH_DEFAULT = 54;
    private static final int WIDTH_MAX = 56;
    private static final int WIDTH_MIN = 58;
    private static final int WIDTH_PERCENT = 69;
    public static final int WRAP_CONTENT = -2;
    private static SparseIntArray mapToConstant;
    private static SparseIntArray overrideMapToConstant;
    public String derivedState;
    private HashMap<Integer, Constraint> mConstraints;
    private boolean mForceId;
    public String mIdString;
    public int mRotate;
    private HashMap<String, ConstraintAttribute> mSavedAttributes;
    private boolean mValidate;

    public static class Constraint {
        public final Layout layout;
        public HashMap<String, ConstraintAttribute> mCustomConstraints;
        Delta mDelta;
        String mTargetString;
        int mViewId;
        public final Motion motion;
        public final PropertySet propertySet;
        public final Transform transform;

        static class Delta {
            private static final int INITIAL_BOOLEAN = 4;
            private static final int INITIAL_FLOAT = 10;
            private static final int INITIAL_INT = 10;
            private static final int INITIAL_STRING = 5;
            int mCountBoolean;
            int mCountFloat;
            int mCountInt;
            int mCountString;
            int[] mTypeBoolean;
            int[] mTypeFloat;
            int[] mTypeInt;
            int[] mTypeString;
            boolean[] mValueBoolean;
            float[] mValueFloat;
            int[] mValueInt;
            String[] mValueString;

            Delta() {
                this.mTypeInt = new int[10];
                this.mValueInt = new int[10];
                this.mCountInt = 0;
                this.mTypeFloat = new int[10];
                this.mValueFloat = new float[10];
                this.mCountFloat = 0;
                this.mTypeString = new int[5];
                this.mValueString = new String[5];
                this.mCountString = 0;
                this.mTypeBoolean = new int[4];
                this.mValueBoolean = new boolean[4];
                this.mCountBoolean = 0;
            }

            void add(int r4, float r5) {
                int r0 = this.mCountFloat;
                int[] r1 = this.mTypeFloat;
                if (r0 < r1.length) goto L5;
                this.mTypeFloat = Arrays.copyOf(r1, r1.length * 2);
                float[] r2 = this.mValueFloat;
                this.mValueFloat = Arrays.copyOf(r2, r2.length * 2);
            L5:
                int[] r3 = this.mTypeFloat;
                int r6 = this.mCountFloat;
                r3[r6] = r4;
                float[] r7 = this.mValueFloat;
                this.mCountFloat = r6 + 1;
                r7[r6] = r5;
            }

            void add(int r4, int r5) {
                int r0 = this.mCountInt;
                int[] r1 = this.mTypeInt;
                if (r0 < r1.length) goto L5;
                this.mTypeInt = Arrays.copyOf(r1, r1.length * 2);
                int[] r2 = this.mValueInt;
                this.mValueInt = Arrays.copyOf(r2, r2.length * 2);
            L5:
                int[] r3 = this.mTypeInt;
                int r6 = this.mCountInt;
                r3[r6] = r4;
                int[] r7 = this.mValueInt;
                this.mCountInt = r6 + 1;
                r7[r6] = r5;
            }

            void add(int r4, String r5) {
                int r0 = this.mCountString;
                int[] r1 = this.mTypeString;
                if (r0 < r1.length) goto L5;
                this.mTypeString = Arrays.copyOf(r1, r1.length * 2);
                String[] r2 = this.mValueString;
                this.mValueString = (String[]) Arrays.copyOf(r2, r2.length * 2);
            L5:
                int[] r3 = this.mTypeString;
                int r6 = this.mCountString;
                r3[r6] = r4;
                String[] r7 = this.mValueString;
                this.mCountString = r6 + 1;
                r7[r6] = r5;
            }

            void add(int r4, boolean r5) {
                int r0 = this.mCountBoolean;
                int[] r1 = this.mTypeBoolean;
                if (r0 < r1.length) goto L5;
                this.mTypeBoolean = Arrays.copyOf(r1, r1.length * 2);
                boolean[] r2 = this.mValueBoolean;
                this.mValueBoolean = Arrays.copyOf(r2, r2.length * 2);
            L5:
                int[] r3 = this.mTypeBoolean;
                int r6 = this.mCountBoolean;
                r3[r6] = r4;
                boolean[] r7 = this.mValueBoolean;
                this.mCountBoolean = r6 + 1;
                r7[r6] = r5;
            }

            void applyDelta(Constraint r5) {
                int r0 = 0;
                int r1 = 0;
            L4:
                if (r1 >= this.mCountInt) goto L6;
                ConstraintSet.access$300(r5, this.mTypeInt[r1], this.mValueInt[r1]);
                r1 = r1 + 1;
                goto L4
            L6:
                int r2 = 0;
            L8:
                if (r2 >= this.mCountFloat) goto L10;
                ConstraintSet.access$400(r5, this.mTypeFloat[r2], this.mValueFloat[r2]);
                r2 = r2 + 1;
                goto L8
            L10:
                int r3 = 0;
            L12:
                if (r3 >= this.mCountString) goto L15;
                ConstraintSet.access$500(r5, this.mTypeString[r3], this.mValueString[r3]);
                r3 = r3 + 1;
            L15:
                if (r0 >= this.mCountBoolean) goto L17;
                ConstraintSet.access$600(r5, this.mTypeBoolean[r0], this.mValueBoolean[r0]);
                r0 = r0 + 1;
                goto L15
            }

            @SuppressLint({"LogConditional"})
            void printDelta(String r6) {
                Log.v(r6, "int");
                int r0 = 0;
                int r1 = 0;
            L4:
                if (r1 >= this.mCountInt) goto L6;
                Log.v(r6, this.mTypeInt[r1] + " = " + this.mValueInt[r1]);
                r1 = r1 + 1;
                goto L4
            L6:
                Log.v(r6, TypedValues.Custom.S_FLOAT);
                int r2 = 0;
            L8:
                if (r2 >= this.mCountFloat) goto L10;
                Log.v(r6, this.mTypeFloat[r2] + " = " + this.mValueFloat[r2]);
                r2 = r2 + 1;
                goto L8
            L10:
                Log.v(r6, "strings");
                int r3 = 0;
            L12:
                if (r3 >= this.mCountString) goto L14;
                Log.v(r6, this.mTypeString[r3] + " = " + this.mValueString[r3]);
                r3 = r3 + 1;
                goto L12
            L14:
                Log.v(r6, TypedValues.Custom.S_BOOLEAN);
            L16:
                if (r0 >= this.mCountBoolean) goto L18;
                Log.v(r6, this.mTypeBoolean[r0] + " = " + this.mValueBoolean[r0]);
                r0 = r0 + 1;
                goto L16
            }
        }

        public Constraint() {
            this.propertySet = new PropertySet();
            this.motion = new Motion();
            this.layout = new Layout();
            this.transform = new Transform();
            this.mCustomConstraints = new HashMap();
        }

        static /* synthetic */ void access$000(Constraint r0, int r1, ConstraintLayout.LayoutParams r2) {
            r0.fillFrom(r1, r2);
        }

        static /* synthetic */ void access$1000(Constraint r0, String r1, int r2) {
            r0.setColorValue(r1, r2);
        }

        static /* synthetic */ void access$1100(Constraint r0, String r1, float r2) {
            r0.setFloatValue(r1, r2);
        }

        static /* synthetic */ void access$1200(Constraint r0, String r1, String r2) {
            r0.setStringValue(r1, r2);
        }

        static /* synthetic */ void access$700(Constraint r0, ConstraintHelper r1, int r2, Constraints.LayoutParams r3) {
            r0.fillFromConstraints(r1, r2, r3);
        }

        static /* synthetic */ void access$800(Constraint r0, int r1, Constraints.LayoutParams r2) {
            r0.fillFromConstraints(r1, r2);
        }

        static /* synthetic */ void access$900(Constraint r0, String r1, int r2) {
            r0.setIntValue(r1, r2);
        }

        private void fillFrom(int r3, ConstraintLayout.LayoutParams r4) {
            this.mViewId = r3;
            Layout r5 = this.layout;
            r5.leftToLeft = r4.leftToLeft;
            r5.leftToRight = r4.leftToRight;
            r5.rightToLeft = r4.rightToLeft;
            r5.rightToRight = r4.rightToRight;
            r5.topToTop = r4.topToTop;
            r5.topToBottom = r4.topToBottom;
            r5.bottomToTop = r4.bottomToTop;
            r5.bottomToBottom = r4.bottomToBottom;
            r5.baselineToBaseline = r4.baselineToBaseline;
            r5.baselineToTop = r4.baselineToTop;
            r5.baselineToBottom = r4.baselineToBottom;
            r5.startToEnd = r4.startToEnd;
            r5.startToStart = r4.startToStart;
            r5.endToStart = r4.endToStart;
            r5.endToEnd = r4.endToEnd;
            r5.horizontalBias = r4.horizontalBias;
            r5.verticalBias = r4.verticalBias;
            r5.dimensionRatio = r4.dimensionRatio;
            r5.circleConstraint = r4.circleConstraint;
            r5.circleRadius = r4.circleRadius;
            r5.circleAngle = r4.circleAngle;
            r5.editorAbsoluteX = r4.editorAbsoluteX;
            r5.editorAbsoluteY = r4.editorAbsoluteY;
            r5.orientation = r4.orientation;
            r5.guidePercent = r4.guidePercent;
            Layout r6 = this.layout;
            r6.guideBegin = r4.guideBegin;
            r6.guideEnd = r4.guideEnd;
            r6.mWidth = ((ViewGroup.MarginLayoutParams) r4).width;
            r6.mHeight = ((ViewGroup.MarginLayoutParams) r4).height;
            r6.leftMargin = ((ViewGroup.MarginLayoutParams) r4).leftMargin;
            r6.rightMargin = ((ViewGroup.MarginLayoutParams) r4).rightMargin;
            r6.topMargin = ((ViewGroup.MarginLayoutParams) r4).topMargin;
            r6.bottomMargin = ((ViewGroup.MarginLayoutParams) r4).bottomMargin;
            r6.baselineMargin = r4.baselineMargin;
            r6.verticalWeight = r4.verticalWeight;
            r6.horizontalWeight = r4.horizontalWeight;
            r6.verticalChainStyle = r4.verticalChainStyle;
            r6.horizontalChainStyle = r4.horizontalChainStyle;
            r6.constrainedWidth = r4.constrainedWidth;
            r6.constrainedHeight = r4.constrainedHeight;
            r6.widthDefault = r4.matchConstraintDefaultWidth;
            r6.heightDefault = r4.matchConstraintDefaultHeight;
            r6.widthMax = r4.matchConstraintMaxWidth;
            r6.heightMax = r4.matchConstraintMaxHeight;
            r6.widthMin = r4.matchConstraintMinWidth;
            r6.heightMin = r4.matchConstraintMinHeight;
            r6.widthPercent = r4.matchConstraintPercentWidth;
            r6.heightPercent = r4.matchConstraintPercentHeight;
            r6.mConstraintTag = r4.constraintTag;
            r6.goneTopMargin = r4.goneTopMargin;
            Layout r7 = this.layout;
            r7.goneBottomMargin = r4.goneBottomMargin;
            r7.goneLeftMargin = r4.goneLeftMargin;
            r7.goneRightMargin = r4.goneRightMargin;
            r7.goneStartMargin = r4.goneStartMargin;
            r7.goneEndMargin = r4.goneEndMargin;
            r7.goneBaselineMargin = r4.goneBaselineMargin;
            r7.mWrapBehavior = r4.wrapBehaviorInParent;
            if (Build.VERSION.SDK_INT < 17) goto L6;
            r7.endMargin = r4.getMarginEnd();
            Layout r2 = this.layout;
            r2.startMargin = r4.getMarginStart();
            return;
        }

        private void fillFromConstraints(int r2, Constraints.LayoutParams r3) {
            fillFrom(r2, r3);
            PropertySet r4 = this.propertySet;
            r4.alpha = r3.alpha;
            Transform r1 = this.transform;
            r1.rotation = r3.rotation;
            r1.rotationX = r3.rotationX;
            r1.rotationY = r3.rotationY;
            r1.scaleX = r3.scaleX;
            r1.scaleY = r3.scaleY;
            r1.transformPivotX = r3.transformPivotX;
            r1.transformPivotY = r3.transformPivotY;
            r1.translationX = r3.translationX;
            r1.translationY = r3.translationY;
            r1.translationZ = r3.translationZ;
            r1.elevation = r3.elevation;
            r1.applyElevation = r3.applyElevation;
        }

        private void fillFromConstraints(ConstraintHelper r1, int r2, Constraints.LayoutParams r3) {
            fillFromConstraints(r2, r3);
            if ((r1 instanceof Barrier) == false) goto L6;
            Layout r4 = this.layout;
            r4.mHelperType = 1;
            Barrier r5 = (Barrier) r1;
            r4.mBarrierDirection = r5.getType();
            Layout r6 = this.layout;
            r6.mReferenceIds = r5.getReferencedIds();
            Layout r0 = this.layout;
            r0.mBarrierMargin = r5.getMargin();
            return;
        }

        private ConstraintAttribute get(String r2, ConstraintAttribute.AttributeType r3) {
            if (this.mCustomConstraints.containsKey(r2) == false) goto L9;
            ConstraintAttribute r1 = this.mCustomConstraints.get(r2);
            if (r1.getType() != r3) goto L8;
            return r1;
        L8:
            throw new IllegalArgumentException("ConstraintAttribute is already a " + r1.getType().name());
        L9:
            ConstraintAttribute r0 = new ConstraintAttribute(r2, r3);
            this.mCustomConstraints.put(r2, r0);
            return r0;
        }

        private void setColorValue(String r2, int r3) {
            get(r2, ConstraintAttribute.AttributeType.COLOR_TYPE).setColorValue(r3);
        }

        private void setFloatValue(String r2, float r3) {
            get(r2, ConstraintAttribute.AttributeType.FLOAT_TYPE).setFloatValue(r3);
        }

        private void setIntValue(String r2, int r3) {
            get(r2, ConstraintAttribute.AttributeType.INT_TYPE).setIntValue(r3);
        }

        private void setStringValue(String r2, String r3) {
            get(r2, ConstraintAttribute.AttributeType.STRING_TYPE).setStringValue(r3);
        }

        public void applyDelta(Constraint r1) {
            Delta r0 = this.mDelta;
            if (r0 == null) goto L6;
            r0.applyDelta(r1);
            return;
        }

        public void applyTo(ConstraintLayout.LayoutParams r4) {
            Layout r0 = this.layout;
            r4.leftToLeft = r0.leftToLeft;
            r4.leftToRight = r0.leftToRight;
            r4.rightToLeft = r0.rightToLeft;
            r4.rightToRight = r0.rightToRight;
            r4.topToTop = r0.topToTop;
            r4.topToBottom = r0.topToBottom;
            r4.bottomToTop = r0.bottomToTop;
            r4.bottomToBottom = r0.bottomToBottom;
            r4.baselineToBaseline = r0.baselineToBaseline;
            r4.baselineToTop = r0.baselineToTop;
            r4.baselineToBottom = r0.baselineToBottom;
            r4.startToEnd = r0.startToEnd;
            r4.startToStart = r0.startToStart;
            r4.endToStart = r0.endToStart;
            r4.endToEnd = r0.endToEnd;
            ((ViewGroup.MarginLayoutParams) r4).leftMargin = r0.leftMargin;
            ((ViewGroup.MarginLayoutParams) r4).rightMargin = r0.rightMargin;
            ((ViewGroup.MarginLayoutParams) r4).topMargin = r0.topMargin;
            ((ViewGroup.MarginLayoutParams) r4).bottomMargin = r0.bottomMargin;
            r4.goneStartMargin = r0.goneStartMargin;
            r4.goneEndMargin = r0.goneEndMargin;
            r4.goneTopMargin = r0.goneTopMargin;
            r4.goneBottomMargin = r0.goneBottomMargin;
            r4.horizontalBias = r0.horizontalBias;
            r4.verticalBias = r0.verticalBias;
            Layout r1 = this.layout;
            r4.circleConstraint = r1.circleConstraint;
            r4.circleRadius = r1.circleRadius;
            r4.circleAngle = r1.circleAngle;
            r4.dimensionRatio = r1.dimensionRatio;
            r4.editorAbsoluteX = r1.editorAbsoluteX;
            r4.editorAbsoluteY = r1.editorAbsoluteY;
            r4.verticalWeight = r1.verticalWeight;
            r4.horizontalWeight = r1.horizontalWeight;
            r4.verticalChainStyle = r1.verticalChainStyle;
            r4.horizontalChainStyle = r1.horizontalChainStyle;
            r4.constrainedWidth = r1.constrainedWidth;
            r4.constrainedHeight = r1.constrainedHeight;
            r4.matchConstraintDefaultWidth = r1.widthDefault;
            r4.matchConstraintDefaultHeight = r1.heightDefault;
            r4.matchConstraintMaxWidth = r1.widthMax;
            r4.matchConstraintMaxHeight = r1.heightMax;
            r4.matchConstraintMinWidth = r1.widthMin;
            r4.matchConstraintMinHeight = r1.heightMin;
            r4.matchConstraintPercentWidth = r1.widthPercent;
            r4.matchConstraintPercentHeight = r1.heightPercent;
            r4.orientation = r1.orientation;
            r4.guidePercent = r1.guidePercent;
            r4.guideBegin = r1.guideBegin;
            r4.guideEnd = r1.guideEnd;
            ((ViewGroup.MarginLayoutParams) r4).width = r1.mWidth;
            Layout r2 = this.layout;
            ((ViewGroup.MarginLayoutParams) r4).height = r2.mHeight;
            String r3 = r2.mConstraintTag;
            if (r3 == null) goto L5;
            r4.constraintTag = r3;
        L5:
            r4.wrapBehaviorInParent = r2.mWrapBehavior;
            if (Build.VERSION.SDK_INT < 17) goto L8;
            r4.setMarginStart(r2.startMargin);
            r4.setMarginEnd(this.layout.endMargin);
        L8:
            r4.validate();
        }

        public Constraint clone() {
            Constraint r0 = new Constraint();
            r0.layout.copyFrom(this.layout);
            r0.motion.copyFrom(this.motion);
            r0.propertySet.copyFrom(this.propertySet);
            r0.transform.copyFrom(this.transform);
            r0.mViewId = this.mViewId;
            r0.mDelta = this.mDelta;
            return r0;
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m9clone() {
            return clone();
        }

        public void printDelta(String r1) {
            Delta r0 = this.mDelta;
            if (r0 == null) goto L5;
            r0.printDelta(r1);
            return;
        L5:
            Log.v(r1, "DELTA IS NULL");
        }
    }

    public static class Layout {
        private static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
        private static final int BARRIER_DIRECTION = 72;
        private static final int BARRIER_MARGIN = 73;
        private static final int BASELINE_MARGIN = 80;
        private static final int BASELINE_TO_BASELINE = 1;
        private static final int BASELINE_TO_BOTTOM = 78;
        private static final int BASELINE_TO_TOP = 77;
        private static final int BOTTOM_MARGIN = 2;
        private static final int BOTTOM_TO_BOTTOM = 3;
        private static final int BOTTOM_TO_TOP = 4;
        private static final int CHAIN_USE_RTL = 71;
        private static final int CIRCLE = 61;
        private static final int CIRCLE_ANGLE = 63;
        private static final int CIRCLE_RADIUS = 62;
        private static final int CONSTRAINED_HEIGHT = 88;
        private static final int CONSTRAINED_WIDTH = 87;
        private static final int CONSTRAINT_REFERENCED_IDS = 74;
        private static final int CONSTRAINT_TAG = 89;
        private static final int DIMENSION_RATIO = 5;
        private static final int EDITOR_ABSOLUTE_X = 6;
        private static final int EDITOR_ABSOLUTE_Y = 7;
        private static final int END_MARGIN = 8;
        private static final int END_TO_END = 9;
        private static final int END_TO_START = 10;
        private static final int GONE_BASELINE_MARGIN = 79;
        private static final int GONE_BOTTOM_MARGIN = 11;
        private static final int GONE_END_MARGIN = 12;
        private static final int GONE_LEFT_MARGIN = 13;
        private static final int GONE_RIGHT_MARGIN = 14;
        private static final int GONE_START_MARGIN = 15;
        private static final int GONE_TOP_MARGIN = 16;
        private static final int GUIDE_BEGIN = 17;
        private static final int GUIDE_END = 18;
        private static final int GUIDE_PERCENT = 19;
        private static final int GUIDE_USE_RTL = 90;
        private static final int HEIGHT_DEFAULT = 82;
        private static final int HEIGHT_MAX = 83;
        private static final int HEIGHT_MIN = 85;
        private static final int HEIGHT_PERCENT = 70;
        private static final int HORIZONTAL_BIAS = 20;
        private static final int HORIZONTAL_STYLE = 39;
        private static final int HORIZONTAL_WEIGHT = 37;
        private static final int LAYOUT_CONSTRAINT_HEIGHT = 42;
        private static final int LAYOUT_CONSTRAINT_WIDTH = 41;
        private static final int LAYOUT_HEIGHT = 21;
        private static final int LAYOUT_WIDTH = 22;
        private static final int LAYOUT_WRAP_BEHAVIOR = 76;
        private static final int LEFT_MARGIN = 23;
        private static final int LEFT_TO_LEFT = 24;
        private static final int LEFT_TO_RIGHT = 25;
        private static final int ORIENTATION = 26;
        private static final int RIGHT_MARGIN = 27;
        private static final int RIGHT_TO_LEFT = 28;
        private static final int RIGHT_TO_RIGHT = 29;
        private static final int START_MARGIN = 30;
        private static final int START_TO_END = 31;
        private static final int START_TO_START = 32;
        private static final int TOP_MARGIN = 33;
        private static final int TOP_TO_BOTTOM = 34;
        private static final int TOP_TO_TOP = 35;
        public static final int UNSET = -1;
        public static final int UNSET_GONE_MARGIN = Integer.MIN_VALUE;
        private static final int UNUSED = 91;
        private static final int VERTICAL_BIAS = 36;
        private static final int VERTICAL_STYLE = 40;
        private static final int VERTICAL_WEIGHT = 38;
        private static final int WIDTH_DEFAULT = 81;
        private static final int WIDTH_MAX = 84;
        private static final int WIDTH_MIN = 86;
        private static final int WIDTH_PERCENT = 69;
        private static SparseIntArray mapToConstant;
        public int baselineMargin;
        public int baselineToBaseline;
        public int baselineToBottom;
        public int baselineToTop;
        public int bottomMargin;
        public int bottomToBottom;
        public int bottomToTop;
        public float circleAngle;
        public int circleConstraint;
        public int circleRadius;
        public boolean constrainedHeight;
        public boolean constrainedWidth;
        public String dimensionRatio;
        public int editorAbsoluteX;
        public int editorAbsoluteY;
        public int endMargin;
        public int endToEnd;
        public int endToStart;
        public int goneBaselineMargin;
        public int goneBottomMargin;
        public int goneEndMargin;
        public int goneLeftMargin;
        public int goneRightMargin;
        public int goneStartMargin;
        public int goneTopMargin;
        public int guideBegin;
        public int guideEnd;
        public float guidePercent;
        public boolean guidelineUseRtl;
        public int heightDefault;
        public int heightMax;
        public int heightMin;
        public float heightPercent;
        public float horizontalBias;
        public int horizontalChainStyle;
        public float horizontalWeight;
        public int leftMargin;
        public int leftToLeft;
        public int leftToRight;
        public boolean mApply;
        public boolean mBarrierAllowsGoneWidgets;
        public int mBarrierDirection;
        public int mBarrierMargin;
        public String mConstraintTag;
        public int mHeight;
        public int mHelperType;
        public boolean mIsGuideline;
        public boolean mOverride;
        public String mReferenceIdString;
        public int[] mReferenceIds;
        public int mWidth;
        public int mWrapBehavior;
        public int orientation;
        public int rightMargin;
        public int rightToLeft;
        public int rightToRight;
        public int startMargin;
        public int startToEnd;
        public int startToStart;
        public int topMargin;
        public int topToBottom;
        public int topToTop;
        public float verticalBias;
        public int verticalChainStyle;
        public float verticalWeight;
        public int widthDefault;
        public int widthMax;
        public int widthMin;
        public float widthPercent;

        static {
            SparseIntArray r0 = new SparseIntArray();
            mapToConstant = r0;
            r0.append(R.styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            mapToConstant.append(R.styleable.Layout_layout_constraintLeft_toRightOf, 25);
            mapToConstant.append(R.styleable.Layout_layout_constraintRight_toLeftOf, 28);
            mapToConstant.append(R.styleable.Layout_layout_constraintRight_toRightOf, 29);
            mapToConstant.append(R.styleable.Layout_layout_constraintTop_toTopOf, 35);
            mapToConstant.append(R.styleable.Layout_layout_constraintTop_toBottomOf, 34);
            mapToConstant.append(R.styleable.Layout_layout_constraintBottom_toTopOf, 4);
            mapToConstant.append(R.styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            mapToConstant.append(R.styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            mapToConstant.append(R.styleable.Layout_layout_editor_absoluteX, 6);
            mapToConstant.append(R.styleable.Layout_layout_editor_absoluteY, 7);
            mapToConstant.append(R.styleable.Layout_layout_constraintGuide_begin, 17);
            mapToConstant.append(R.styleable.Layout_layout_constraintGuide_end, 18);
            mapToConstant.append(R.styleable.Layout_layout_constraintGuide_percent, 19);
            mapToConstant.append(R.styleable.Layout_guidelineUseRtl, 90);
            mapToConstant.append(R.styleable.Layout_android_orientation, 26);
            mapToConstant.append(R.styleable.Layout_layout_constraintStart_toEndOf, 31);
            mapToConstant.append(R.styleable.Layout_layout_constraintStart_toStartOf, 32);
            mapToConstant.append(R.styleable.Layout_layout_constraintEnd_toStartOf, 10);
            mapToConstant.append(R.styleable.Layout_layout_constraintEnd_toEndOf, 9);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginLeft, 13);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginTop, 16);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginRight, 14);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginBottom, 11);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginStart, 15);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginEnd, 12);
            mapToConstant.append(R.styleable.Layout_layout_constraintVertical_weight, 38);
            mapToConstant.append(R.styleable.Layout_layout_constraintHorizontal_weight, 37);
            mapToConstant.append(R.styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            mapToConstant.append(R.styleable.Layout_layout_constraintVertical_chainStyle, 40);
            mapToConstant.append(R.styleable.Layout_layout_constraintHorizontal_bias, 20);
            mapToConstant.append(R.styleable.Layout_layout_constraintVertical_bias, 36);
            mapToConstant.append(R.styleable.Layout_layout_constraintDimensionRatio, 5);
            mapToConstant.append(R.styleable.Layout_layout_constraintLeft_creator, 91);
            mapToConstant.append(R.styleable.Layout_layout_constraintTop_creator, 91);
            mapToConstant.append(R.styleable.Layout_layout_constraintRight_creator, 91);
            mapToConstant.append(R.styleable.Layout_layout_constraintBottom_creator, 91);
            mapToConstant.append(R.styleable.Layout_layout_constraintBaseline_creator, 91);
            mapToConstant.append(R.styleable.Layout_android_layout_marginLeft, 23);
            mapToConstant.append(R.styleable.Layout_android_layout_marginRight, 27);
            mapToConstant.append(R.styleable.Layout_android_layout_marginStart, 30);
            mapToConstant.append(R.styleable.Layout_android_layout_marginEnd, 8);
            mapToConstant.append(R.styleable.Layout_android_layout_marginTop, 33);
            mapToConstant.append(R.styleable.Layout_android_layout_marginBottom, 2);
            mapToConstant.append(R.styleable.Layout_android_layout_width, 22);
            mapToConstant.append(R.styleable.Layout_android_layout_height, 21);
            mapToConstant.append(R.styleable.Layout_layout_constraintWidth, 41);
            mapToConstant.append(R.styleable.Layout_layout_constraintHeight, 42);
            mapToConstant.append(R.styleable.Layout_layout_constrainedWidth, 41);
            mapToConstant.append(R.styleable.Layout_layout_constrainedHeight, 42);
            mapToConstant.append(R.styleable.Layout_layout_wrapBehaviorInParent, 76);
            mapToConstant.append(R.styleable.Layout_layout_constraintCircle, 61);
            mapToConstant.append(R.styleable.Layout_layout_constraintCircleRadius, 62);
            mapToConstant.append(R.styleable.Layout_layout_constraintCircleAngle, 63);
            mapToConstant.append(R.styleable.Layout_layout_constraintWidth_percent, 69);
            mapToConstant.append(R.styleable.Layout_layout_constraintHeight_percent, 70);
            mapToConstant.append(R.styleable.Layout_chainUseRtl, 71);
            mapToConstant.append(R.styleable.Layout_barrierDirection, 72);
            mapToConstant.append(R.styleable.Layout_barrierMargin, 73);
            mapToConstant.append(R.styleable.Layout_constraint_referenced_ids, 74);
            mapToConstant.append(R.styleable.Layout_barrierAllowsGoneWidgets, 75);
        }

        public Layout() {
            this.mIsGuideline = false;
            this.mApply = false;
            this.mOverride = false;
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.guidelineUseRtl = true;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.baselineToTop = -1;
            this.baselineToBottom = -1;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.leftMargin = 0;
            this.rightMargin = 0;
            this.topMargin = 0;
            this.bottomMargin = 0;
            this.endMargin = 0;
            this.startMargin = 0;
            this.baselineMargin = 0;
            this.goneLeftMargin = Integer.MIN_VALUE;
            this.goneTopMargin = Integer.MIN_VALUE;
            this.goneRightMargin = Integer.MIN_VALUE;
            this.goneBottomMargin = Integer.MIN_VALUE;
            this.goneEndMargin = Integer.MIN_VALUE;
            this.goneStartMargin = Integer.MIN_VALUE;
            this.goneBaselineMargin = Integer.MIN_VALUE;
            this.verticalWeight = -1.0f;
            this.horizontalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.widthDefault = 0;
            this.heightDefault = 0;
            this.widthMax = 0;
            this.heightMax = 0;
            this.widthMin = 0;
            this.heightMin = 0;
            this.widthPercent = 1.0f;
            this.heightPercent = 1.0f;
            this.mBarrierDirection = -1;
            this.mBarrierMargin = 0;
            this.mHelperType = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.mBarrierAllowsGoneWidgets = true;
            this.mWrapBehavior = 0;
        }

        public void copyFrom(Layout r3) {
            this.mIsGuideline = r3.mIsGuideline;
            this.mWidth = r3.mWidth;
            this.mApply = r3.mApply;
            this.mHeight = r3.mHeight;
            this.guideBegin = r3.guideBegin;
            this.guideEnd = r3.guideEnd;
            this.guidePercent = r3.guidePercent;
            this.guidelineUseRtl = r3.guidelineUseRtl;
            this.leftToLeft = r3.leftToLeft;
            this.leftToRight = r3.leftToRight;
            this.rightToLeft = r3.rightToLeft;
            this.rightToRight = r3.rightToRight;
            this.topToTop = r3.topToTop;
            this.topToBottom = r3.topToBottom;
            this.bottomToTop = r3.bottomToTop;
            this.bottomToBottom = r3.bottomToBottom;
            this.baselineToBaseline = r3.baselineToBaseline;
            this.baselineToTop = r3.baselineToTop;
            this.baselineToBottom = r3.baselineToBottom;
            this.startToEnd = r3.startToEnd;
            this.startToStart = r3.startToStart;
            this.endToStart = r3.endToStart;
            this.endToEnd = r3.endToEnd;
            this.horizontalBias = r3.horizontalBias;
            this.verticalBias = r3.verticalBias;
            this.dimensionRatio = r3.dimensionRatio;
            this.circleConstraint = r3.circleConstraint;
            this.circleRadius = r3.circleRadius;
            this.circleAngle = r3.circleAngle;
            this.editorAbsoluteX = r3.editorAbsoluteX;
            this.editorAbsoluteY = r3.editorAbsoluteY;
            this.orientation = r3.orientation;
            this.leftMargin = r3.leftMargin;
            this.rightMargin = r3.rightMargin;
            this.topMargin = r3.topMargin;
            this.bottomMargin = r3.bottomMargin;
            this.endMargin = r3.endMargin;
            this.startMargin = r3.startMargin;
            this.baselineMargin = r3.baselineMargin;
            this.goneLeftMargin = r3.goneLeftMargin;
            this.goneTopMargin = r3.goneTopMargin;
            this.goneRightMargin = r3.goneRightMargin;
            this.goneBottomMargin = r3.goneBottomMargin;
            this.goneEndMargin = r3.goneEndMargin;
            this.goneStartMargin = r3.goneStartMargin;
            this.goneBaselineMargin = r3.goneBaselineMargin;
            this.verticalWeight = r3.verticalWeight;
            this.horizontalWeight = r3.horizontalWeight;
            this.horizontalChainStyle = r3.horizontalChainStyle;
            this.verticalChainStyle = r3.verticalChainStyle;
            this.widthDefault = r3.widthDefault;
            this.heightDefault = r3.heightDefault;
            this.widthMax = r3.widthMax;
            this.heightMax = r3.heightMax;
            this.widthMin = r3.widthMin;
            this.heightMin = r3.heightMin;
            this.widthPercent = r3.widthPercent;
            this.heightPercent = r3.heightPercent;
            this.mBarrierDirection = r3.mBarrierDirection;
            this.mBarrierMargin = r3.mBarrierMargin;
            this.mHelperType = r3.mHelperType;
            this.mConstraintTag = r3.mConstraintTag;
            int[] r0 = r3.mReferenceIds;
            if (r0 != null) goto L5;
        L7:
            this.mReferenceIds = null;
        L8:
            this.mReferenceIdString = r3.mReferenceIdString;
            this.constrainedWidth = r3.constrainedWidth;
            this.constrainedHeight = r3.constrainedHeight;
            this.mBarrierAllowsGoneWidgets = r3.mBarrierAllowsGoneWidgets;
            this.mWrapBehavior = r3.mWrapBehavior;
            return;
        L5:
            if (r3.mReferenceIdString != null) goto L7;
            this.mReferenceIds = Arrays.copyOf(r0, r0.length);
            goto L8
        }

        public void dump(MotionScene r10, StringBuilder r11) {
            Field[] r0 = getClass().getDeclaredFields();
            r11.append("\n");
            int r1 = 0;
        L4:
            if (r1 >= r0.length) goto L28;
            Field r2 = r0[r1];
            String r3 = r2.getName();
            if (Modifier.isStatic(r2.getModifiers()) == true) goto L27;
            Object r4 = r2.get(this);     // Catch: IllegalAccessException -> L25
            Class<?> r5 = r2.getType();     // Catch: IllegalAccessException -> L25
            if (r5 != Integer.TYPE) goto L20;
            Integer r6 = (Integer) r4;     // Catch: IllegalAccessException -> L25
            if (r6.intValue() == (-1)) goto L27;
            Object r7 = r10.lookUpConstraintName(r6.intValue());     // Catch: IllegalAccessException -> L25
            r11.append("    ");     // Catch: IllegalAccessException -> L25
            r11.append(r3);     // Catch: IllegalAccessException -> L25
            r11.append(" = \"");     // Catch: IllegalAccessException -> L25
            if (r7 != null) goto L16;
            Object r8 = r6;
        L17:
            r11.append(r8);     // Catch: IllegalAccessException -> L25
        L18:
            r11.append("\"\n");     // Catch: IllegalAccessException -> L25
            goto L27
        L16:
            r8 = r7;
            goto L17
        L20:
            if (r5 != Float.TYPE) goto L27;
            Float r9 = (Float) r4;     // Catch: IllegalAccessException -> L25
            if (r9.floatValue() == (-1.0f)) goto L27;
            r11.append("    ");     // Catch: IllegalAccessException -> L25
            r11.append(r3);     // Catch: IllegalAccessException -> L25
            r11.append(" = \"");     // Catch: IllegalAccessException -> L25
            r11.append(r9);     // Catch: IllegalAccessException -> L25
        L25:
            e = move-exception;
            e.printStackTrace();
        L27:
            r1 = r1 + 1;
            goto L4
        }

        void fillFromAttributeList(Context r10, AttributeSet r11) {
            int r0 = Build.VERSION.SDK_INT;
            TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.Layout);
            this.mApply = true;
            int r1 = r12.getIndexCount();
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L82;
            int r4 = r12.getIndex(r3);
            int r5 = mapToConstant.get(r4);
            switch(r5) {
                case 1: goto L80;
                case 2: goto L79;
                case 3: goto L78;
                case 4: goto L77;
                case 5: goto L76;
                case 6: goto L75;
                case 7: goto L74;
                case 8: goto L72;
                case 9: goto L71;
                case 10: goto L70;
                case 11: goto L69;
                case 12: goto L68;
                case 13: goto L67;
                case 14: goto L66;
                case 15: goto L65;
                case 16: goto L64;
                case 17: goto L63;
                case 18: goto L62;
                case 19: goto L61;
                case 20: goto L60;
                case 21: goto L59;
                case 22: goto L58;
                case 23: goto L57;
                case 24: goto L56;
                case 25: goto L55;
                case 26: goto L54;
                case 27: goto L53;
                case 28: goto L52;
                case 29: goto L51;
                case 30: goto L49;
                case 31: goto L48;
                case 32: goto L47;
                case 33: goto L46;
                case 34: goto L45;
                case 35: goto L44;
                case 36: goto L43;
                case 37: goto L42;
                case 38: goto L41;
                case 39: goto L40;
                case 40: goto L39;
                case 41: goto L38;
                case 42: goto L37;
                default: goto L6;
            };
        L6:
            switch(r5) {
                case 61: goto L36;
                case 62: goto L35;
                case 63: goto L34;
                default: goto L8;
            };
        L34:
            this.circleAngle = r12.getFloat(r4, this.circleAngle);
        L81:
            r3 = r3 + 1;
            goto L3
        L35:
            this.circleRadius = r12.getDimensionPixelSize(r4, this.circleRadius);
            goto L81
        L36:
            this.circleConstraint = ConstraintSet.access$100(r12, r4, this.circleConstraint);
            goto L81
        L8:
            switch(r5) {
                case 69: goto L33;
                case 70: goto L32;
                case 71: goto L31;
                case 72: goto L30;
                case 73: goto L29;
                case 74: goto L28;
                case 75: goto L27;
                case 76: goto L26;
                case 77: goto L25;
                case 78: goto L24;
                case 79: goto L23;
                case 80: goto L22;
                case 81: goto L21;
                case 82: goto L20;
                case 83: goto L19;
                case 84: goto L18;
                case 85: goto L17;
                case 86: goto L16;
                case 87: goto L15;
                case 88: goto L14;
                case 89: goto L13;
                case 90: goto L12;
                case 91: goto L11;
                default: goto L9;
            };
        L9:
            StringBuilder r6 = new StringBuilder();
            String r7 = "Unknown attribute 0x";
        L10:
            r6.append(r7);
            r6.append(Integer.toHexString(r4));
            r6.append("   ");
            r6.append(mapToConstant.get(r4));
            Log.w(ConstraintSet.TAG, r6.toString());
            goto L81
        L11:
            r6 = new StringBuilder();
            r7 = "unused attribute 0x";
            goto L10
        L12:
            this.guidelineUseRtl = r12.getBoolean(r4, this.guidelineUseRtl);
            goto L81
        L13:
            this.mConstraintTag = r12.getString(r4);
            goto L81
        L14:
            this.constrainedHeight = r12.getBoolean(r4, this.constrainedHeight);
            goto L81
        L15:
            this.constrainedWidth = r12.getBoolean(r4, this.constrainedWidth);
            goto L81
        L16:
            this.widthMin = r12.getDimensionPixelSize(r4, this.widthMin);
            goto L81
        L17:
            this.heightMin = r12.getDimensionPixelSize(r4, this.heightMin);
            goto L81
        L18:
            this.widthMax = r12.getDimensionPixelSize(r4, this.widthMax);
            goto L81
        L19:
            this.heightMax = r12.getDimensionPixelSize(r4, this.heightMax);
            goto L81
        L20:
            this.heightDefault = r12.getInt(r4, this.heightDefault);
            goto L81
        L21:
            this.widthDefault = r12.getInt(r4, this.widthDefault);
            goto L81
        L22:
            this.baselineMargin = r12.getDimensionPixelSize(r4, this.baselineMargin);
            goto L81
        L23:
            this.goneBaselineMargin = r12.getDimensionPixelSize(r4, this.goneBaselineMargin);
            goto L81
        L24:
            this.baselineToBottom = ConstraintSet.access$100(r12, r4, this.baselineToBottom);
            goto L81
        L25:
            this.baselineToTop = ConstraintSet.access$100(r12, r4, this.baselineToTop);
            goto L81
        L26:
            this.mWrapBehavior = r12.getInt(r4, this.mWrapBehavior);
            goto L81
        L27:
            this.mBarrierAllowsGoneWidgets = r12.getBoolean(r4, this.mBarrierAllowsGoneWidgets);
            goto L81
        L28:
            this.mReferenceIdString = r12.getString(r4);
            goto L81
        L29:
            this.mBarrierMargin = r12.getDimensionPixelSize(r4, this.mBarrierMargin);
            goto L81
        L30:
            this.mBarrierDirection = r12.getInt(r4, this.mBarrierDirection);
            goto L81
        L31:
            Log.e(ConstraintSet.TAG, "CURRENTLY UNSUPPORTED");
            goto L81
        L32:
            this.heightPercent = r12.getFloat(r4, 1.0f);
            goto L81
        L33:
            this.widthPercent = r12.getFloat(r4, 1.0f);
            goto L81
        L37:
            ConstraintSet.parseDimensionConstraints(this, r12, r4, 1);
            goto L81
        L38:
            ConstraintSet.parseDimensionConstraints(this, r12, r4, 0);
            goto L81
        L39:
            this.verticalChainStyle = r12.getInt(r4, this.verticalChainStyle);
            goto L81
        L40:
            this.horizontalChainStyle = r12.getInt(r4, this.horizontalChainStyle);
            goto L81
        L41:
            this.verticalWeight = r12.getFloat(r4, this.verticalWeight);
            goto L81
        L42:
            this.horizontalWeight = r12.getFloat(r4, this.horizontalWeight);
            goto L81
        L43:
            this.verticalBias = r12.getFloat(r4, this.verticalBias);
            goto L81
        L44:
            this.topToTop = ConstraintSet.access$100(r12, r4, this.topToTop);
            goto L81
        L45:
            this.topToBottom = ConstraintSet.access$100(r12, r4, this.topToBottom);
            goto L81
        L46:
            this.topMargin = r12.getDimensionPixelSize(r4, this.topMargin);
            goto L81
        L47:
            this.startToStart = ConstraintSet.access$100(r12, r4, this.startToStart);
            goto L81
        L48:
            this.startToEnd = ConstraintSet.access$100(r12, r4, this.startToEnd);
            goto L81
        L49:
            if (r0 < 17) goto L81;
            this.startMargin = r12.getDimensionPixelSize(r4, this.startMargin);
            goto L81
        L51:
            this.rightToRight = ConstraintSet.access$100(r12, r4, this.rightToRight);
            goto L81
        L52:
            this.rightToLeft = ConstraintSet.access$100(r12, r4, this.rightToLeft);
            goto L81
        L53:
            this.rightMargin = r12.getDimensionPixelSize(r4, this.rightMargin);
            goto L81
        L54:
            this.orientation = r12.getInt(r4, this.orientation);
            goto L81
        L55:
            this.leftToRight = ConstraintSet.access$100(r12, r4, this.leftToRight);
            goto L81
        L56:
            this.leftToLeft = ConstraintSet.access$100(r12, r4, this.leftToLeft);
            goto L81
        L57:
            this.leftMargin = r12.getDimensionPixelSize(r4, this.leftMargin);
            goto L81
        L58:
            this.mWidth = r12.getLayoutDimension(r4, this.mWidth);
            goto L81
        L59:
            this.mHeight = r12.getLayoutDimension(r4, this.mHeight);
            goto L81
        L60:
            this.horizontalBias = r12.getFloat(r4, this.horizontalBias);
            goto L81
        L61:
            this.guidePercent = r12.getFloat(r4, this.guidePercent);
            goto L81
        L62:
            this.guideEnd = r12.getDimensionPixelOffset(r4, this.guideEnd);
            goto L81
        L63:
            this.guideBegin = r12.getDimensionPixelOffset(r4, this.guideBegin);
            goto L81
        L64:
            this.goneTopMargin = r12.getDimensionPixelSize(r4, this.goneTopMargin);
            goto L81
        L65:
            this.goneStartMargin = r12.getDimensionPixelSize(r4, this.goneStartMargin);
            goto L81
        L66:
            this.goneRightMargin = r12.getDimensionPixelSize(r4, this.goneRightMargin);
            goto L81
        L67:
            this.goneLeftMargin = r12.getDimensionPixelSize(r4, this.goneLeftMargin);
            goto L81
        L68:
            this.goneEndMargin = r12.getDimensionPixelSize(r4, this.goneEndMargin);
            goto L81
        L69:
            this.goneBottomMargin = r12.getDimensionPixelSize(r4, this.goneBottomMargin);
            goto L81
        L70:
            this.endToStart = ConstraintSet.access$100(r12, r4, this.endToStart);
            goto L81
        L71:
            this.endToEnd = ConstraintSet.access$100(r12, r4, this.endToEnd);
            goto L81
        L72:
            if (r0 < 17) goto L81;
            this.endMargin = r12.getDimensionPixelSize(r4, this.endMargin);
            goto L81
        L74:
            this.editorAbsoluteY = r12.getDimensionPixelOffset(r4, this.editorAbsoluteY);
            goto L81
        L75:
            this.editorAbsoluteX = r12.getDimensionPixelOffset(r4, this.editorAbsoluteX);
            goto L81
        L76:
            this.dimensionRatio = r12.getString(r4);
            goto L81
        L77:
            this.bottomToTop = ConstraintSet.access$100(r12, r4, this.bottomToTop);
            goto L81
        L78:
            this.bottomToBottom = ConstraintSet.access$100(r12, r4, this.bottomToBottom);
            goto L81
        L79:
            this.bottomMargin = r12.getDimensionPixelSize(r4, this.bottomMargin);
            goto L81
        L80:
            this.baselineToBaseline = ConstraintSet.access$100(r12, r4, this.baselineToBaseline);
            goto L81
        L82:
            r12.recycle();
        }
    }

    public static class Motion {
        private static final int ANIMATE_CIRCLE_ANGLE_TO = 6;
        private static final int ANIMATE_RELATIVE_TO = 5;
        private static final int INTERPOLATOR_REFERENCE_ID = -2;
        private static final int INTERPOLATOR_UNDEFINED = -3;
        private static final int MOTION_DRAW_PATH = 4;
        private static final int MOTION_STAGGER = 7;
        private static final int PATH_MOTION_ARC = 2;
        private static final int QUANTIZE_MOTION_INTERPOLATOR = 10;
        private static final int QUANTIZE_MOTION_PHASE = 9;
        private static final int QUANTIZE_MOTION_STEPS = 8;
        private static final int SPLINE_STRING = -1;
        private static final int TRANSITION_EASING = 3;
        private static final int TRANSITION_PATH_ROTATE = 1;
        private static SparseIntArray mapToConstant;
        public int mAnimateCircleAngleTo;
        public int mAnimateRelativeTo;
        public boolean mApply;
        public int mDrawPath;
        public float mMotionStagger;
        public int mPathMotionArc;
        public float mPathRotate;
        public int mPolarRelativeTo;
        public int mQuantizeInterpolatorID;
        public String mQuantizeInterpolatorString;
        public int mQuantizeInterpolatorType;
        public float mQuantizeMotionPhase;
        public int mQuantizeMotionSteps;
        public String mTransitionEasing;

        static {
            SparseIntArray r0 = new SparseIntArray();
            mapToConstant = r0;
            r0.append(R.styleable.Motion_motionPathRotate, 1);
            mapToConstant.append(R.styleable.Motion_pathMotionArc, 2);
            mapToConstant.append(R.styleable.Motion_transitionEasing, 3);
            mapToConstant.append(R.styleable.Motion_drawPath, 4);
            mapToConstant.append(R.styleable.Motion_animateRelativeTo, 5);
            mapToConstant.append(R.styleable.Motion_animateCircleAngleTo, 6);
            mapToConstant.append(R.styleable.Motion_motionStagger, 7);
            mapToConstant.append(R.styleable.Motion_quantizeMotionSteps, 8);
            mapToConstant.append(R.styleable.Motion_quantizeMotionPhase, 9);
            mapToConstant.append(R.styleable.Motion_quantizeMotionInterpolator, 10);
        }

        public Motion() {
            this.mApply = false;
            this.mAnimateRelativeTo = -1;
            this.mAnimateCircleAngleTo = 0;
            this.mTransitionEasing = null;
            this.mPathMotionArc = -1;
            this.mDrawPath = 0;
            this.mMotionStagger = Float.NaN;
            this.mPolarRelativeTo = -1;
            this.mPathRotate = Float.NaN;
            this.mQuantizeMotionPhase = Float.NaN;
            this.mQuantizeMotionSteps = -1;
            this.mQuantizeInterpolatorString = null;
            this.mQuantizeInterpolatorType = -3;
            this.mQuantizeInterpolatorID = -1;
        }

        public void copyFrom(Motion r2) {
            this.mApply = r2.mApply;
            this.mAnimateRelativeTo = r2.mAnimateRelativeTo;
            this.mTransitionEasing = r2.mTransitionEasing;
            this.mPathMotionArc = r2.mPathMotionArc;
            this.mDrawPath = r2.mDrawPath;
            this.mPathRotate = r2.mPathRotate;
            this.mMotionStagger = r2.mMotionStagger;
            this.mPolarRelativeTo = r2.mPolarRelativeTo;
        }

        void fillFromAttributeList(Context r9, AttributeSet r10) {
            TypedArray r11 = r9.obtainStyledAttributes(r10, R.styleable.Motion);
            this.mApply = true;
            int r0 = r11.getIndexCount();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L32;
            int r3 = r11.getIndex(r2);
            switch(mapToConstant.get(r3)) {
                case 1: goto L30;
                case 2: goto L29;
                case 3: goto L25;
                case 4: goto L23;
                case 5: goto L22;
                case 6: goto L21;
                case 7: goto L20;
                case 8: goto L19;
                case 9: goto L18;
                case 10: goto L7;
                default: goto L31;
            };
        L7:
            int r4 = r11.peekValue(r3).type;
            if (r4 != 1) goto L12;
            int r5 = r11.getResourceId(r3, -1);
            this.mQuantizeInterpolatorID = r5;
            if (r5 == (-1)) goto L31;
        L11:
            this.mQuantizeInterpolatorType = -2;
            goto L31
        L12:
            if (r4 != 3) goto L17;
            String r6 = r11.getString(r3);
            this.mQuantizeInterpolatorString = r6;
            if (r6.indexOf("/") <= 0) goto L16;
            this.mQuantizeInterpolatorID = r11.getResourceId(r3, -1);
            goto L11
        L16:
            this.mQuantizeInterpolatorType = -1;
            goto L31
        L17:
            this.mQuantizeInterpolatorType = r11.getInteger(r3, this.mQuantizeInterpolatorID);
            goto L31
        L18:
            this.mQuantizeMotionPhase = r11.getFloat(r3, this.mQuantizeMotionPhase);
            goto L31
        L19:
            this.mQuantizeMotionSteps = r11.getInteger(r3, this.mQuantizeMotionSteps);
            goto L31
        L20:
            this.mMotionStagger = r11.getFloat(r3, this.mMotionStagger);
            goto L31
        L21:
            this.mAnimateCircleAngleTo = r11.getInteger(r3, this.mAnimateCircleAngleTo);
            goto L31
        L22:
            this.mAnimateRelativeTo = ConstraintSet.access$100(r11, r3, this.mAnimateRelativeTo);
            goto L31
        L23:
            this.mDrawPath = r11.getInt(r3, 0);
            goto L31
        L29:
            this.mPathMotionArc = r11.getInt(r3, this.mPathMotionArc);
            goto L31
        L30:
            this.mPathRotate = r11.getFloat(r3, this.mPathRotate);
            goto L31
        L25:
            if (r11.peekValue(r3).type != 3) goto L27;
            String r7 = r11.getString(r3);
        L28:
            this.mTransitionEasing = r7;
            goto L31
        L27:
            r7 = Easing.NAMED_EASING[r11.getInteger(r3, 0)];
        L31:
            r2 = r2 + 1;
            goto L3
        L32:
            r11.recycle();
        }
    }

    public static class PropertySet {
        public float alpha;
        public boolean mApply;
        public float mProgress;
        public int mVisibilityMode;
        public int visibility;

        public PropertySet() {
            this.mApply = false;
            this.visibility = 0;
            this.mVisibilityMode = 0;
            this.alpha = 1.0f;
            this.mProgress = Float.NaN;
        }

        public void copyFrom(PropertySet r2) {
            this.mApply = r2.mApply;
            this.visibility = r2.visibility;
            this.alpha = r2.alpha;
            this.mProgress = r2.mProgress;
            this.mVisibilityMode = r2.mVisibilityMode;
        }

        void fillFromAttributeList(Context r4, AttributeSet r5) {
            TypedArray r6 = r4.obtainStyledAttributes(r5, R.styleable.PropertySet);
            this.mApply = true;
            int r7 = r6.getIndexCount();
            int r0 = 0;
        L3:
            if (r0 >= r7) goto L17;
            int r1 = r6.getIndex(r0);
            if (r1 != R.styleable.PropertySet_android_alpha) goto L8;
            this.alpha = r6.getFloat(r1, this.alpha);
        L16:
            r0 = r0 + 1;
            goto L3
        L8:
            if (r1 != R.styleable.PropertySet_android_visibility) goto L11;
            this.visibility = r6.getInt(r1, this.visibility);
            this.visibility = ConstraintSet.access$200()[this.visibility];
            goto L16
        L11:
            if (r1 != R.styleable.PropertySet_visibilityMode) goto L14;
            this.mVisibilityMode = r6.getInt(r1, this.mVisibilityMode);
            goto L16
        L14:
            if (r1 != R.styleable.PropertySet_motionProgress) goto L16;
            this.mProgress = r6.getFloat(r1, this.mProgress);
            goto L16
        L17:
            r6.recycle();
        }
    }

    public static class Transform {
        private static final int ELEVATION = 11;
        private static final int ROTATION = 1;
        private static final int ROTATION_X = 2;
        private static final int ROTATION_Y = 3;
        private static final int SCALE_X = 4;
        private static final int SCALE_Y = 5;
        private static final int TRANSFORM_PIVOT_TARGET = 12;
        private static final int TRANSFORM_PIVOT_X = 6;
        private static final int TRANSFORM_PIVOT_Y = 7;
        private static final int TRANSLATION_X = 8;
        private static final int TRANSLATION_Y = 9;
        private static final int TRANSLATION_Z = 10;
        private static SparseIntArray mapToConstant;
        public boolean applyElevation;
        public float elevation;
        public boolean mApply;
        public float rotation;
        public float rotationX;
        public float rotationY;
        public float scaleX;
        public float scaleY;
        public int transformPivotTarget;
        public float transformPivotX;
        public float transformPivotY;
        public float translationX;
        public float translationY;
        public float translationZ;

        static {
            SparseIntArray r0 = new SparseIntArray();
            mapToConstant = r0;
            r0.append(R.styleable.Transform_android_rotation, 1);
            mapToConstant.append(R.styleable.Transform_android_rotationX, 2);
            mapToConstant.append(R.styleable.Transform_android_rotationY, 3);
            mapToConstant.append(R.styleable.Transform_android_scaleX, 4);
            mapToConstant.append(R.styleable.Transform_android_scaleY, 5);
            mapToConstant.append(R.styleable.Transform_android_transformPivotX, 6);
            mapToConstant.append(R.styleable.Transform_android_transformPivotY, 7);
            mapToConstant.append(R.styleable.Transform_android_translationX, 8);
            mapToConstant.append(R.styleable.Transform_android_translationY, 9);
            mapToConstant.append(R.styleable.Transform_android_translationZ, 10);
            mapToConstant.append(R.styleable.Transform_android_elevation, 11);
            mapToConstant.append(R.styleable.Transform_transformPivotTarget, 12);
        }

        public Transform() {
            this.mApply = false;
            this.rotation = 0.0f;
            this.rotationX = 0.0f;
            this.rotationY = 0.0f;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.transformPivotX = Float.NaN;
            this.transformPivotY = Float.NaN;
            this.transformPivotTarget = -1;
            this.translationX = 0.0f;
            this.translationY = 0.0f;
            this.translationZ = 0.0f;
            this.applyElevation = false;
            this.elevation = 0.0f;
        }

        public void copyFrom(Transform r2) {
            this.mApply = r2.mApply;
            this.rotation = r2.rotation;
            this.rotationX = r2.rotationX;
            this.rotationY = r2.rotationY;
            this.scaleX = r2.scaleX;
            this.scaleY = r2.scaleY;
            this.transformPivotX = r2.transformPivotX;
            this.transformPivotY = r2.transformPivotY;
            this.transformPivotTarget = r2.transformPivotTarget;
            this.translationX = r2.translationX;
            this.translationY = r2.translationY;
            this.translationZ = r2.translationZ;
            this.applyElevation = r2.applyElevation;
            this.elevation = r2.elevation;
        }

        void fillFromAttributeList(Context r7, AttributeSet r8) {
            int r0 = Build.VERSION.SDK_INT;
            TypedArray r9 = r7.obtainStyledAttributes(r8, R.styleable.Transform);
            this.mApply = true;
            int r1 = r9.getIndexCount();
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L22;
            int r3 = r9.getIndex(r2);
            switch(mapToConstant.get(r3)) {
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L14;
                case 8: goto L13;
                case 9: goto L12;
                case 10: goto L10;
                case 11: goto L8;
                case 12: goto L7;
                default: goto L21;
            };
        L7:
            this.transformPivotTarget = ConstraintSet.access$100(r9, r3, this.transformPivotTarget);
            goto L21
        L8:
            if (r0 < 21) goto L21;
            this.applyElevation = true;
            this.elevation = r9.getDimension(r3, this.elevation);
            goto L21
        L10:
            if (r0 < 21) goto L21;
            this.translationZ = r9.getDimension(r3, this.translationZ);
            goto L21
        L12:
            this.translationY = r9.getDimension(r3, this.translationY);
            goto L21
        L13:
            this.translationX = r9.getDimension(r3, this.translationX);
            goto L21
        L14:
            this.transformPivotY = r9.getDimension(r3, this.transformPivotY);
            goto L21
        L15:
            this.transformPivotX = r9.getDimension(r3, this.transformPivotX);
            goto L21
        L16:
            this.scaleY = r9.getFloat(r3, this.scaleY);
            goto L21
        L17:
            this.scaleX = r9.getFloat(r3, this.scaleX);
            goto L21
        L18:
            this.rotationY = r9.getFloat(r3, this.rotationY);
            goto L21
        L19:
            this.rotationX = r9.getFloat(r3, this.rotationX);
            goto L21
        L20:
            this.rotation = r9.getFloat(r3, this.rotation);
        L21:
            r2 = r2 + 1;
            goto L3
        L22:
            r9.recycle();
        }
    }

    class WriteJsonEngine {
        private static final String SPACE = "       ";
        final String BASELINE;
        final String BOTTOM;
        final String END;
        final String LEFT;
        final String RIGHT;
        final String START;
        final String TOP;
        Context context;
        int flags;
        HashMap<Integer, String> idMap;
        ConstraintLayout layout;
        final /* synthetic */ ConstraintSet this$0;
        int unknownCount;
        Writer writer;

        WriteJsonEngine(ConstraintSet r1, Writer r2, ConstraintLayout r3, int r4) {
            this.this$0 = r1;
            this.unknownCount = 0;
            this.LEFT = "'left'";
            this.RIGHT = "'right'";
            this.BASELINE = "'baseline'";
            this.BOTTOM = "'bottom'";
            this.TOP = "'top'";
            this.START = "'start'";
            this.END = "'end'";
            this.idMap = new HashMap();
            this.writer = r2;
            this.layout = r3;
            this.context = r3.getContext();
            this.flags = r4;
        }

        private void writeDimension(String r4, int r5, int r6, float r7, int r8, int r9, boolean r10) {
            if (r5 == 0) goto L5;
            Writer r3 = this.writer;
            if (r5 != (-2)) goto L31;
            StringBuilder r11 = new StringBuilder();
            r11.append(SPACE);
            r11.append(r4);
            String r12 = ": 'wrap'\n";
        L29:
            r11.append(r12);
            String r13 = r11.toString();
        L30:
            r3.write(r13);
            return;
        L31:
            if (r5 != (-1)) goto L33;
            r11 = new StringBuilder();
            r11.append(SPACE);
            r11.append(r4);
            r12 = ": 'parent'\n";
            goto L29
        L33:
            r13 = SPACE + r4 + ": " + r5 + ",\n";
            goto L30
        L5:
            if (r9 != (-1)) goto L17;
            if (r8 != (-1)) goto L17;
            if (r6 == 1) goto L15;
            if (r6 != 2) goto L36;
            Writer r14 = this.writer;
            StringBuilder r15 = new StringBuilder();
            r15.append(SPACE);
            r15.append(r4);
            r15.append(": '");
            r15.append(r7);
            String r16 = "%',\n";
        L12:
            r15.append(r16);
        L13:
            r14.write(r15.toString());
            return;
        L36:
            return;
        L15:
            r14 = this.writer;
            r15 = new StringBuilder();
            r15.append(SPACE);
            r15.append(r4);
            r16 = ": '???????????',\n";
        L17:
            if (r6 == 0) goto L24;
            if (r6 == 1) goto L23;
            if (r6 != 2) goto L35;
            r14 = this.writer;
            r15 = new StringBuilder();
            r15.append(SPACE);
            r15.append(r4);
            r15.append(": {'");
            r15.append(r7);
            String r17 = "'% ,";
        L22:
            r15.append(r17);
            r15.append(r8);
            r15.append(", ");
            r15.append(r9);
            r15.append("}\n");
            goto L13
        L35:
            return;
        L23:
            r14 = this.writer;
            r15 = new StringBuilder();
            r15.append(SPACE);
            r15.append(r4);
            r17 = ": {'wrap' ,";
            goto L22
        L24:
            this.writer.write(SPACE + r4 + ": {'spread' ," + r8 + ", " + r9 + "}\n");
        }

        private void writeGuideline(int r1, int r2, int r3, float r4) {
        }

        String getName(int r3) {
            if (this.idMap.containsKey(Integer.valueOf(r3)) == true) goto L5;
            if (r3 != 0) goto L9;
            return "'parent'";
        L9:
            String r0 = lookup(r3);
            this.idMap.put(Integer.valueOf(r3), r0);
            return "'" + r0 + "'";
        L5:
            return "'" + this.idMap.get(Integer.valueOf(r3)) + "'";
        }

        String lookup(int r3) {
            if (r3 != (-1)) goto L5;
            StringBuilder r4 = new StringBuilder();     // Catch: Exception -> L8
            r4.append(EnvironmentCompat.MEDIA_UNKNOWN);     // Catch: Exception -> L8
            int r0 = this.unknownCount + 1;     // Catch: Exception -> L8
            this.unknownCount = r0;     // Catch: Exception -> L8
            r4.append(r0);     // Catch: Exception -> L8
            return r4.toString();
        L5:
            return this.context.getResources().getResourceEntryName(r3);
        L8:
            StringBuilder r5 = new StringBuilder();
            r5.append(EnvironmentCompat.MEDIA_UNKNOWN);
            int r1 = this.unknownCount + 1;
            this.unknownCount = r1;
            r5.append(r1);
            return r5.toString();
        }

        void writeCircle(int r3, float r4, int r5) {
            if (r3 != (-1)) goto L5;
            return;
        L5:
            this.writer.write("       circle");
            this.writer.write(":[");
            this.writer.write(getName(r3));
            this.writer.write(", " + r4);
            this.writer.write(r5 + "]");
        }

        void writeConstraint(String r3, int r4, String r5, int r6, int r7) {
            if (r4 != (-1)) goto L5;
            return;
        L5:
            this.writer.write(SPACE + r3);
            this.writer.write(":[");
            this.writer.write(getName(r4));
            this.writer.write(" , ");
            this.writer.write(r5);
            if (r6 == 0) goto L8;
            this.writer.write(" , " + r6);
        L8:
            this.writer.write("],\n");
        }

        void writeLayout() {
            this.writer.write("\n'ConstraintSet':{\n");
            Iterator r8 = ConstraintSet.access$1300(this.this$0).keySet().iterator();
        L4:
            if (r8.hasNext() == false) goto L9;
            Integer r0 = (Integer) r8.next();
            Constraint r1 = (Constraint) ConstraintSet.access$1300(this.this$0).get(r0);
            String r2 = getName(r0.intValue());
            this.writer.write(r2 + ":{\n");
            Layout r10 = r1.layout;
            writeDimension("height", r10.mHeight, r10.heightDefault, r10.heightPercent, r10.heightMin, r10.heightMax, r10.constrainedHeight);
            writeDimension("width", r10.mWidth, r10.widthDefault, r10.widthPercent, r10.widthMin, r10.widthMax, r10.constrainedWidth);
            writeConstraint("'left'", r10.leftToLeft, "'left'", r10.leftMargin, r10.goneLeftMargin);
            writeConstraint("'left'", r10.leftToRight, "'right'", r10.leftMargin, r10.goneLeftMargin);
            writeConstraint("'right'", r10.rightToLeft, "'left'", r10.rightMargin, r10.goneRightMargin);
            writeConstraint("'right'", r10.rightToRight, "'right'", r10.rightMargin, r10.goneRightMargin);
            writeConstraint("'baseline'", r10.baselineToBaseline, "'baseline'", -1, r10.goneBaselineMargin);
            writeConstraint("'baseline'", r10.baselineToTop, "'top'", -1, r10.goneBaselineMargin);
            writeConstraint("'baseline'", r10.baselineToBottom, "'bottom'", -1, r10.goneBaselineMargin);
            writeConstraint("'top'", r10.topToBottom, "'bottom'", r10.topMargin, r10.goneTopMargin);
            writeConstraint("'top'", r10.topToTop, "'top'", r10.topMargin, r10.goneTopMargin);
            writeConstraint("'bottom'", r10.bottomToBottom, "'bottom'", r10.bottomMargin, r10.goneBottomMargin);
            writeConstraint("'bottom'", r10.bottomToTop, "'top'", r10.bottomMargin, r10.goneBottomMargin);
            writeConstraint("'start'", r10.startToStart, "'start'", r10.startMargin, r10.goneStartMargin);
            writeConstraint("'start'", r10.startToEnd, "'end'", r10.startMargin, r10.goneStartMargin);
            writeConstraint("'end'", r10.endToStart, "'start'", r10.endMargin, r10.goneEndMargin);
            writeConstraint("'end'", r10.endToEnd, "'end'", r10.endMargin, r10.goneEndMargin);
            writeVariable("'horizontalBias'", r10.horizontalBias, 0.5f);
            writeVariable("'verticalBias'", r10.verticalBias, 0.5f);
            writeCircle(r10.circleConstraint, r10.circleAngle, r10.circleRadius);
            writeGuideline(r10.orientation, r10.guideBegin, r10.guideEnd, r10.guidePercent);
            writeVariable("'dimensionRatio'", r10.dimensionRatio);
            writeVariable("'barrierMargin'", r10.mBarrierMargin);
            writeVariable("'type'", r10.mHelperType);
            writeVariable("'ReferenceId'", r10.mReferenceIdString);
            writeVariable("'mBarrierAllowsGoneWidgets'", r10.mBarrierAllowsGoneWidgets, true);
            writeVariable("'WrapBehavior'", r10.mWrapBehavior);
            writeVariable("'verticalWeight'", r10.verticalWeight);
            writeVariable("'horizontalWeight'", r10.horizontalWeight);
            writeVariable("'horizontalChainStyle'", r10.horizontalChainStyle);
            writeVariable("'verticalChainStyle'", r10.verticalChainStyle);
            writeVariable("'barrierDirection'", r10.mBarrierDirection);
            int[] r3 = r10.mReferenceIds;
            if (r3 == null) goto L8;
            writeVariable("'ReferenceIds'", r3);
        L8:
            this.writer.write("}\n");
            goto L4
        L9:
            this.writer.write("}\n");
        }

        void writeVariable(String r4, float r5) {
            if (r5 != (-1.0f)) goto L5;
            return;
        L5:
            this.writer.write(SPACE + r4);
            this.writer.write(": " + r5);
            this.writer.write(",\n");
        }

        void writeVariable(String r3, float r4, float r5) {
            if (r4 != r5) goto L5;
            return;
        L5:
            this.writer.write(SPACE + r3);
            this.writer.write(": " + r4);
            this.writer.write(",\n");
        }

        void writeVariable(String r4, int r5) {
            if (r5 != 0) goto L4;
            return;
        L4:
            if (r5 == (-1)) goto L9;
            this.writer.write(SPACE + r4);
            this.writer.write(":");
            this.writer.write(", " + r5);
            this.writer.write("\n");
            return;
        }

        void writeVariable(String r4, String r5) {
            if (r5 != null) goto L4;
            return;
        L4:
            this.writer.write(SPACE + r4);
            this.writer.write(":");
            this.writer.write(", " + r5);
            this.writer.write("\n");
        }

        void writeVariable(String r4, boolean r5) {
            if (r5 == true) goto L4;
            return;
        L4:
            this.writer.write(SPACE + r4);
            this.writer.write(": " + r5);
            this.writer.write(",\n");
        }

        void writeVariable(String r3, boolean r4, boolean r5) {
            if (r4 != r5) goto L4;
            return;
        L4:
            this.writer.write(SPACE + r3);
            this.writer.write(": " + r4);
            this.writer.write(",\n");
        }

        void writeVariable(String r4, int[] r5) {
            if (r5 != null) goto L4;
            return;
        L4:
            this.writer.write(SPACE + r4);
            this.writer.write(": ");
            int r6 = 0;
        L6:
            if (r6 >= r5.length) goto L12;
            Writer r0 = this.writer;
            StringBuilder r1 = new StringBuilder();
            if (r6 != 0) goto L10;
            String r2 = "[";
        L11:
            r1.append(r2);
            r1.append(getName(r5[r6]));
            r0.write(r1.toString());
            r6 = r6 + 1;
            goto L6
        L10:
            r2 = ", ";
            goto L11
        L12:
            this.writer.write("],\n");
        }
    }

    class WriteXmlEngine {
        private static final String SPACE = "\n       ";
        final String BASELINE;
        final String BOTTOM;
        final String END;
        final String LEFT;
        final String RIGHT;
        final String START;
        final String TOP;
        Context context;
        int flags;
        HashMap<Integer, String> idMap;
        ConstraintLayout layout;
        final /* synthetic */ ConstraintSet this$0;
        int unknownCount;
        Writer writer;

        WriteXmlEngine(ConstraintSet r1, Writer r2, ConstraintLayout r3, int r4) {
            this.this$0 = r1;
            this.unknownCount = 0;
            this.LEFT = "'left'";
            this.RIGHT = "'right'";
            this.BASELINE = "'baseline'";
            this.BOTTOM = "'bottom'";
            this.TOP = "'top'";
            this.START = "'start'";
            this.END = "'end'";
            this.idMap = new HashMap();
            this.writer = r2;
            this.layout = r3;
            this.context = r3.getContext();
            this.flags = r4;
        }

        private void writeBaseDimension(String r2, int r3, int r4) {
            if (r3 != r4) goto L4;
            return;
        L4:
            if (r3 != (-2)) goto L8;
            Writer r1 = this.writer;
            StringBuilder r5 = new StringBuilder();
            r5.append(SPACE);
            r5.append(r2);
            String r6 = "=\"wrap_content\"";
        L6:
            r5.append(r6);
            String r7 = r5.toString();
        L7:
            r1.write(r7);
            return;
        L8:
            r1 = this.writer;
            if (r3 != (-1)) goto L11;
            r5 = new StringBuilder();
            r5.append(SPACE);
            r5.append(r2);
            r6 = "=\"match_parent\"";
            goto L6
        L11:
            r7 = SPACE + r2 + "=\"" + r3 + "dp\"";
            goto L7
        }

        private void writeBoolen(String r2, boolean r3, boolean r4) {
            if (r3 == r4) goto L5;
            this.writer.write(SPACE + r2 + "=\"" + r3 + "dp\"");
            return;
        }

        private void writeDimension(String r2, int r3, int r4) {
            if (r3 == r4) goto L5;
            this.writer.write(SPACE + r2 + "=\"" + r3 + "dp\"");
            return;
        }

        private void writeEnum(String r2, int r3, String[] r4, int r5) {
            if (r3 == r5) goto L5;
            this.writer.write(SPACE + r2 + "=\"" + r4[r3] + "\"");
            return;
        }

        String getName(int r4) {
            if (this.idMap.containsKey(Integer.valueOf(r4)) == true) goto L5;
            if (r4 != 0) goto L9;
            return ConstraintSet.KEY_PERCENT_PARENT;
        L9:
            String r0 = lookup(r4);
            this.idMap.put(Integer.valueOf(r4), r0);
            return "@+id/" + r0 + "";
        L5:
            return "@+id/" + this.idMap.get(Integer.valueOf(r4)) + "";
        }

        String lookup(int r3) {
            if (r3 != (-1)) goto L5;
            StringBuilder r4 = new StringBuilder();     // Catch: Exception -> L8
            r4.append(EnvironmentCompat.MEDIA_UNKNOWN);     // Catch: Exception -> L8
            int r0 = this.unknownCount + 1;     // Catch: Exception -> L8
            this.unknownCount = r0;     // Catch: Exception -> L8
            r4.append(r0);     // Catch: Exception -> L8
            return r4.toString();
        L5:
            return this.context.getResources().getResourceEntryName(r3);
        L8:
            StringBuilder r5 = new StringBuilder();
            r5.append(EnvironmentCompat.MEDIA_UNKNOWN);
            int r1 = this.unknownCount + 1;
            this.unknownCount = r1;
            r5.append(r1);
            return r5.toString();
        }

        void writeCircle(int r3, float r4, int r5) {
            if (r3 != (-1)) goto L5;
            return;
        L5:
            this.writer.write("circle");
            this.writer.write(":[");
            this.writer.write(getName(r3));
            this.writer.write(", " + r4);
            this.writer.write(r5 + "]");
        }

        void writeConstraint(String r3, int r4, String r5, int r6, int r7) {
            if (r4 != (-1)) goto L5;
            return;
        L5:
            this.writer.write(SPACE + r3);
            this.writer.write(":[");
            this.writer.write(getName(r4));
            this.writer.write(" , ");
            this.writer.write(r5);
            if (r6 == 0) goto L8;
            this.writer.write(" , " + r6);
        L8:
            this.writer.write("],\n");
        }

        void writeLayout() {
            this.writer.write("\n<ConstraintSet>\n");
            Iterator r0 = ConstraintSet.access$1300(this.this$0).keySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L9;
            Integer r1 = (Integer) r0.next();
            Constraint r2 = (Constraint) ConstraintSet.access$1300(this.this$0).get(r1);
            String r3 = getName(r1.intValue());
            this.writer.write("  <Constraint");
            this.writer.write("\n       android:id=\"" + r3 + "\"");
            Layout r4 = r2.layout;
            writeBaseDimension("android:layout_width", r4.mWidth, -5);
            writeBaseDimension("android:layout_height", r4.mHeight, -5);
            writeVariable("app:layout_constraintGuide_begin", (float) r4.guideBegin, -1.0f);
            writeVariable("app:layout_constraintGuide_end", r4.guideEnd, -1.0f);
            writeVariable("app:layout_constraintGuide_percent", r4.guidePercent, -1.0f);
            writeVariable("app:layout_constraintHorizontal_bias", r4.horizontalBias, 0.5f);
            writeVariable("app:layout_constraintVertical_bias", r4.verticalBias, 0.5f);
            writeVariable("app:layout_constraintDimensionRatio", r4.dimensionRatio, null);
            writeXmlConstraint("app:layout_constraintCircle", r4.circleConstraint);
            writeVariable("app:layout_constraintCircleRadius", r4.circleRadius, 0.0f);
            writeVariable("app:layout_constraintCircleAngle", r4.circleAngle, 0.0f);
            writeVariable("android:orientation", r4.orientation, -1.0f);
            writeVariable("app:layout_constraintVertical_weight", r4.verticalWeight, -1.0f);
            writeVariable("app:layout_constraintHorizontal_weight", r4.horizontalWeight, -1.0f);
            writeVariable("app:layout_constraintHorizontal_chainStyle", r4.horizontalChainStyle, 0.0f);
            writeVariable("app:layout_constraintVertical_chainStyle", r4.verticalChainStyle, 0.0f);
            writeVariable("app:barrierDirection", r4.mBarrierDirection, -1.0f);
            writeVariable("app:barrierMargin", r4.mBarrierMargin, 0.0f);
            writeDimension("app:layout_marginLeft", r4.leftMargin, 0);
            writeDimension("app:layout_goneMarginLeft", r4.goneLeftMargin, Integer.MIN_VALUE);
            writeDimension("app:layout_marginRight", r4.rightMargin, 0);
            writeDimension("app:layout_goneMarginRight", r4.goneRightMargin, Integer.MIN_VALUE);
            writeDimension("app:layout_marginStart", r4.startMargin, 0);
            writeDimension("app:layout_goneMarginStart", r4.goneStartMargin, Integer.MIN_VALUE);
            writeDimension("app:layout_marginEnd", r4.endMargin, 0);
            writeDimension("app:layout_goneMarginEnd", r4.goneEndMargin, Integer.MIN_VALUE);
            writeDimension("app:layout_marginTop", r4.topMargin, 0);
            writeDimension("app:layout_goneMarginTop", r4.goneTopMargin, Integer.MIN_VALUE);
            writeDimension("app:layout_marginBottom", r4.bottomMargin, 0);
            writeDimension("app:layout_goneMarginBottom", r4.goneBottomMargin, Integer.MIN_VALUE);
            writeDimension("app:goneBaselineMargin", r4.goneBaselineMargin, Integer.MIN_VALUE);
            writeDimension("app:baselineMargin", r4.baselineMargin, 0);
            writeBoolen("app:layout_constrainedWidth", r4.constrainedWidth, false);
            writeBoolen("app:layout_constrainedHeight", r4.constrainedHeight, false);
            writeBoolen("app:barrierAllowsGoneWidgets", r4.mBarrierAllowsGoneWidgets, true);
            writeVariable("app:layout_wrapBehaviorInParent", r4.mWrapBehavior, 0.0f);
            writeXmlConstraint("app:baselineToBaseline", r4.baselineToBaseline);
            writeXmlConstraint("app:baselineToBottom", r4.baselineToBottom);
            writeXmlConstraint("app:baselineToTop", r4.baselineToTop);
            writeXmlConstraint("app:layout_constraintBottom_toBottomOf", r4.bottomToBottom);
            writeXmlConstraint("app:layout_constraintBottom_toTopOf", r4.bottomToTop);
            writeXmlConstraint("app:layout_constraintEnd_toEndOf", r4.endToEnd);
            writeXmlConstraint("app:layout_constraintEnd_toStartOf", r4.endToStart);
            writeXmlConstraint("app:layout_constraintLeft_toLeftOf", r4.leftToLeft);
            writeXmlConstraint("app:layout_constraintLeft_toRightOf", r4.leftToRight);
            writeXmlConstraint("app:layout_constraintRight_toLeftOf", r4.rightToLeft);
            writeXmlConstraint("app:layout_constraintRight_toRightOf", r4.rightToRight);
            writeXmlConstraint("app:layout_constraintStart_toEndOf", r4.startToEnd);
            writeXmlConstraint("app:layout_constraintStart_toStartOf", r4.startToStart);
            writeXmlConstraint("app:layout_constraintTop_toBottomOf", r4.topToBottom);
            writeXmlConstraint("app:layout_constraintTop_toTopOf", r4.topToTop);
            String[] r5 = {"spread", "wrap", "percent"};
            writeEnum("app:layout_constraintHeight_default", r4.heightDefault, r5, 0);
            writeVariable("app:layout_constraintHeight_percent", r4.heightPercent, 1.0f);
            writeDimension("app:layout_constraintHeight_min", r4.heightMin, 0);
            writeDimension("app:layout_constraintHeight_max", r4.heightMax, 0);
            writeBoolen("android:layout_constrainedHeight", r4.constrainedHeight, false);
            writeEnum("app:layout_constraintWidth_default", r4.widthDefault, r5, 0);
            writeVariable("app:layout_constraintWidth_percent", r4.widthPercent, 1.0f);
            writeDimension("app:layout_constraintWidth_min", r4.widthMin, 0);
            writeDimension("app:layout_constraintWidth_max", r4.widthMax, 0);
            writeBoolen("android:layout_constrainedWidth", r4.constrainedWidth, false);
            writeVariable("app:layout_constraintVertical_weight", r4.verticalWeight, -1.0f);
            writeVariable("app:layout_constraintHorizontal_weight", r4.horizontalWeight, -1.0f);
            writeVariable("app:layout_constraintHorizontal_chainStyle", r4.horizontalChainStyle);
            writeVariable("app:layout_constraintVertical_chainStyle", r4.verticalChainStyle);
            writeEnum("app:barrierDirection", r4.mBarrierDirection, new String[]{"left", "right", "top", "bottom", "start", "end"}, -1);
            writeVariable("app:layout_constraintTag", r4.mConstraintTag, null);
            int[] r6 = r4.mReferenceIds;
            if (r6 == null) goto L8;
            writeVariable("'ReferenceIds'", r6);
        L8:
            this.writer.write(" />\n");
            goto L4
        L9:
            this.writer.write("</ConstraintSet>\n");
        }

        void writeVariable(String r3, float r4, float r5) {
            if (r4 != r5) goto L5;
            return;
        L5:
            this.writer.write(SPACE + r3);
            this.writer.write("=\"" + r4 + "\"");
        }

        void writeVariable(String r3, int r4) {
            if (r4 != 0) goto L4;
            return;
        L4:
            if (r4 == (-1)) goto L9;
            this.writer.write(SPACE + r3 + "=\"" + r4 + "\"\n");
            return;
        }

        void writeVariable(String r3, String r4) {
            if (r4 != null) goto L4;
            return;
        L4:
            this.writer.write(r3);
            this.writer.write(":");
            this.writer.write(", " + r4);
            this.writer.write("\n");
        }

        void writeVariable(String r3, String r4, String r5) {
            if (r4 != null) goto L4;
            return;
        L4:
            if (r4.equals(r5) == true) goto L9;
            this.writer.write(SPACE + r3);
            this.writer.write("=\"" + r4 + "\"");
            return;
        }

        void writeVariable(String r4, int[] r5) {
            if (r5 != null) goto L4;
            return;
        L4:
            this.writer.write(SPACE + r4);
            this.writer.write(":");
            int r6 = 0;
        L6:
            if (r6 >= r5.length) goto L12;
            Writer r0 = this.writer;
            StringBuilder r1 = new StringBuilder();
            if (r6 != 0) goto L10;
            String r2 = "[";
        L11:
            r1.append(r2);
            r1.append(getName(r5[r6]));
            r0.write(r1.toString());
            r6 = r6 + 1;
            goto L6
        L10:
            r2 = ", ";
            goto L11
        L12:
            this.writer.write("],\n");
        }

        void writeXmlConstraint(String r4, int r5) {
            if (r5 != (-1)) goto L5;
            return;
        L5:
            this.writer.write(SPACE + r4);
            this.writer.write("=\"" + getName(r5) + "\"");
        }
    }

    static {
        VISIBILITY_FLAGS = new int[]{0, 4, 8};
        mapToConstant = new SparseIntArray();
        overrideMapToConstant = new SparseIntArray();
        mapToConstant.append(R.styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        mapToConstant.append(R.styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        mapToConstant.append(R.styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        mapToConstant.append(R.styleable.Constraint_layout_constraintRight_toRightOf, 30);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTop_toTopOf, 36);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_toTopOf, 91);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_toBottomOf, 92);
        mapToConstant.append(R.styleable.Constraint_layout_editor_absoluteX, 6);
        mapToConstant.append(R.styleable.Constraint_layout_editor_absoluteY, 7);
        mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_begin, 17);
        mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_end, 18);
        mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_percent, 19);
        mapToConstant.append(R.styleable.Constraint_guidelineUseRtl, 99);
        mapToConstant.append(R.styleable.Constraint_android_orientation, 27);
        mapToConstant.append(R.styleable.Constraint_layout_constraintStart_toEndOf, 32);
        mapToConstant.append(R.styleable.Constraint_layout_constraintStart_toStartOf, 33);
        mapToConstant.append(R.styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        mapToConstant.append(R.styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginLeft, 13);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginTop, 16);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginRight, 14);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginBottom, 11);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginStart, 15);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginEnd, 12);
        mapToConstant.append(R.styleable.Constraint_layout_constraintVertical_weight, 40);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_weight, 39);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        mapToConstant.append(R.styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_bias, 20);
        mapToConstant.append(R.styleable.Constraint_layout_constraintVertical_bias, 37);
        mapToConstant.append(R.styleable.Constraint_layout_constraintDimensionRatio, 5);
        mapToConstant.append(R.styleable.Constraint_layout_constraintLeft_creator, 87);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTop_creator, 87);
        mapToConstant.append(R.styleable.Constraint_layout_constraintRight_creator, 87);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_creator, 87);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_creator, 87);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginLeft, 24);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginRight, 28);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginStart, 31);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginEnd, 8);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginTop, 34);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginBottom, 2);
        mapToConstant.append(R.styleable.Constraint_android_layout_width, 23);
        mapToConstant.append(R.styleable.Constraint_android_layout_height, 21);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth, 95);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight, 96);
        mapToConstant.append(R.styleable.Constraint_android_visibility, 22);
        mapToConstant.append(R.styleable.Constraint_android_alpha, 43);
        mapToConstant.append(R.styleable.Constraint_android_elevation, 44);
        mapToConstant.append(R.styleable.Constraint_android_rotationX, 45);
        mapToConstant.append(R.styleable.Constraint_android_rotationY, 46);
        mapToConstant.append(R.styleable.Constraint_android_rotation, 60);
        mapToConstant.append(R.styleable.Constraint_android_scaleX, 47);
        mapToConstant.append(R.styleable.Constraint_android_scaleY, 48);
        mapToConstant.append(R.styleable.Constraint_android_transformPivotX, 49);
        mapToConstant.append(R.styleable.Constraint_android_transformPivotY, 50);
        mapToConstant.append(R.styleable.Constraint_android_translationX, 51);
        mapToConstant.append(R.styleable.Constraint_android_translationY, 52);
        mapToConstant.append(R.styleable.Constraint_android_translationZ, 53);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_default, 54);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_default, 55);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_max, 56);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_max, 57);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_min, 58);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_min, 59);
        mapToConstant.append(R.styleable.Constraint_layout_constraintCircle, 61);
        mapToConstant.append(R.styleable.Constraint_layout_constraintCircleRadius, 62);
        mapToConstant.append(R.styleable.Constraint_layout_constraintCircleAngle, 63);
        mapToConstant.append(R.styleable.Constraint_animateRelativeTo, 64);
        mapToConstant.append(R.styleable.Constraint_transitionEasing, 65);
        mapToConstant.append(R.styleable.Constraint_drawPath, 66);
        mapToConstant.append(R.styleable.Constraint_transitionPathRotate, 67);
        mapToConstant.append(R.styleable.Constraint_motionStagger, 79);
        mapToConstant.append(R.styleable.Constraint_android_id, 38);
        mapToConstant.append(R.styleable.Constraint_motionProgress, 68);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_percent, 69);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_percent, 70);
        mapToConstant.append(R.styleable.Constraint_layout_wrapBehaviorInParent, 97);
        mapToConstant.append(R.styleable.Constraint_chainUseRtl, 71);
        mapToConstant.append(R.styleable.Constraint_barrierDirection, 72);
        mapToConstant.append(R.styleable.Constraint_barrierMargin, 73);
        mapToConstant.append(R.styleable.Constraint_constraint_referenced_ids, 74);
        mapToConstant.append(R.styleable.Constraint_barrierAllowsGoneWidgets, 75);
        mapToConstant.append(R.styleable.Constraint_pathMotionArc, 76);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTag, 77);
        mapToConstant.append(R.styleable.Constraint_visibilityMode, 78);
        mapToConstant.append(R.styleable.Constraint_layout_constrainedWidth, 80);
        mapToConstant.append(R.styleable.Constraint_layout_constrainedHeight, 81);
        mapToConstant.append(R.styleable.Constraint_polarRelativeTo, 82);
        mapToConstant.append(R.styleable.Constraint_transformPivotTarget, 83);
        mapToConstant.append(R.styleable.Constraint_quantizeMotionSteps, 84);
        mapToConstant.append(R.styleable.Constraint_quantizeMotionPhase, 85);
        mapToConstant.append(R.styleable.Constraint_quantizeMotionInterpolator, 86);
        SparseIntArray r0 = overrideMapToConstant;
        int r1 = R.styleable.ConstraintOverride_layout_editor_absoluteY;
        r0.append(r1, 6);
        overrideMapToConstant.append(r1, 7);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_orientation, 27);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginLeft, 13);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginTop, 16);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginRight, 14);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginBottom, 11);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginStart, 15);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginEnd, 12);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintVertical_weight, 40);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintVertical_bias, 37);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintDimensionRatio, 5);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintLeft_creator, 87);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintTop_creator, 87);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintRight_creator, 87);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintBottom_creator, 87);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintBaseline_creator, 87);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginLeft, 24);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginRight, 28);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginStart, 31);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginEnd, 8);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginTop, 34);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginBottom, 2);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_width, 23);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_height, 21);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth, 95);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight, 96);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_visibility, 22);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_alpha, 43);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_elevation, 44);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_rotationX, 45);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_rotationY, 46);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_rotation, 60);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_scaleX, 47);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_scaleY, 48);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_transformPivotX, 49);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_transformPivotY, 50);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_translationX, 51);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_translationY, 52);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_translationZ, 53);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_default, 54);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_default, 55);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_max, 56);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_max, 57);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_min, 58);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_min, 59);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintCircleRadius, 62);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintCircleAngle, 63);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_animateRelativeTo, 64);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_transitionEasing, 65);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_drawPath, 66);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_transitionPathRotate, 67);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_motionStagger, 79);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_id, 38);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_motionTarget, 98);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_motionProgress, 68);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_percent, 69);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_percent, 70);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_chainUseRtl, 71);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_barrierDirection, 72);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_barrierMargin, 73);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_constraint_referenced_ids, 74);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_pathMotionArc, 76);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintTag, 77);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_visibilityMode, 78);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constrainedWidth, 80);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constrainedHeight, 81);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_polarRelativeTo, 82);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_transformPivotTarget, 83);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_quantizeMotionSteps, 84);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_quantizeMotionPhase, 85);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_quantizeMotionInterpolator, 86);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    public ConstraintSet() {
        this.derivedState = "";
        this.mRotate = 0;
        this.mSavedAttributes = new HashMap();
        this.mForceId = true;
        this.mConstraints = new HashMap();
    }

    static /* synthetic */ int access$100(TypedArray r0, int r1, int r2) {
        return lookupID(r0, r1, r2);
    }

    static /* synthetic */ HashMap access$1300(ConstraintSet r0) {
        return r0.mConstraints;
    }

    static /* synthetic */ int[] access$200() {
        return VISIBILITY_FLAGS;
    }

    static /* synthetic */ void access$300(Constraint r0, int r1, int r2) {
        setDeltaValue(r0, r1, r2);
    }

    static /* synthetic */ void access$400(Constraint r0, int r1, float r2) {
        setDeltaValue(r0, r1, r2);
    }

    static /* synthetic */ void access$500(Constraint r0, int r1, String r2) {
        setDeltaValue(r0, r1, r2);
    }

    static /* synthetic */ void access$600(Constraint r0, int r1, boolean r2) {
        setDeltaValue(r0, r1, r2);
    }

    private void addAttributes(ConstraintAttribute.AttributeType r5, String... r6) {
        int r0 = 0;
    L4:
        if (r0 >= r6.length) goto L17;
        if (this.mSavedAttributes.containsKey(r6[r0]) == false) goto L15;
        ConstraintAttribute r1 = this.mSavedAttributes.get(r6[r0]);
        if (r1 == null) goto L16;
        if (r1.getType() == r5) goto L16;
        throw new IllegalArgumentException("ConstraintAttribute is already a " + r1.getType().name());
    L16:
        r0 = r0 + 1;
        goto L4
    L15:
        this.mSavedAttributes.put(r6[r0], new ConstraintAttribute(r6[r0], r5));
        goto L16
    }

    public static Constraint buildDelta(Context r2, XmlPullParser r3) {
        AttributeSet r4 = Xml.asAttributeSet(r3);
        Constraint r0 = new Constraint();
        TypedArray r5 = r2.obtainStyledAttributes(r4, R.styleable.ConstraintOverride);
        populateOverride(r2, r0, r5);
        r5.recycle();
        return r0;
    }

    private int[] convertReferenceString(View r9, String r10) {
        String[] r8 = r10.split(",");
        Context r11 = r9.getContext();
        int[] r0 = new int[r8.length];
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= r8.length) goto L23;
        String r4 = r8[r2].trim();
        int r5 = R.id.class.getField(r4).getInt(null);     // Catch: Exception -> L8
    L9:
        if (r5 != 0) goto L11;
        r5 = r11.getResources().getIdentifier(r4, "id", r11.getPackageName());
    L11:
        if (r5 != 0) goto L21;
        if (r9.isInEditMode() == false) goto L21;
        if ((r9.getParent() instanceof ConstraintLayout) == false) goto L21;
        Object r6 = ((ConstraintLayout) r9.getParent()).getDesignInformation(0, r4);
        if (r6 == null) goto L21;
        if ((r6 instanceof Integer) == false) goto L21;
        r5 = ((Integer) r6).intValue();
    L21:
        r0[r3] = r5;
        r2 = r2 + 1;
        r3 = r3 + 1;
    L8:
        r5 = 0;
        goto L9
    L23:
        if (r3 != r8.length) goto L25;
        return r0;
    L25:
        return Arrays.copyOf(r0, r3);
    }

    private void createHorizontalChain(int r13, int r14, int r15, int r16, int[] r17, float[] r18, int r19, int r20, int r21) {
        if (r17.length < 2) goto L23;
        if (r18 == null) goto L11;
        if (r18.length == r17.length) goto L11;
        throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    L11:
        if (r18 == null) goto L13;
        get(r17[0]).layout.horizontalWeight = r18[0];
    L13:
        get(r17[0]).layout.horizontalChainStyle = r19;
        connect(r17[0], r20, r13, r14, -1);
        int r10 = 1;
    L15:
        if (r10 >= r17.length) goto L20;
        int r0 = r17[r10];
        int r11 = r10 - 1;
        connect(r17[r10], r20, r17[r11], r21, -1);
        connect(r17[r11], r21, r17[r10], r20, -1);
        if (r18 == null) goto L19;
        get(r17[r10]).layout.horizontalWeight = r18[r10];
    L19:
        r10 = r10 + 1;
        goto L15
    L20:
        connect(r17[r17.length - 1], r21, r15, r16, -1);
        return;
    L23:
        throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    }

    private Constraint fillFromAttributeList(Context r3, AttributeSet r4, boolean r5) {
        Constraint r0 = new Constraint();
        if (r5 == false) goto L5;
        int[] r1 = R.styleable.ConstraintOverride;
    L6:
        TypedArray r6 = r3.obtainStyledAttributes(r4, r1);
        populateConstraint(r3, r0, r6, r5);
        r6.recycle();
        return r0;
    L5:
        r1 = R.styleable.Constraint;
        goto L6
    }

    private Constraint get(int r4) {
        if (this.mConstraints.containsKey(Integer.valueOf(r4)) == true) goto L6;
        this.mConstraints.put(Integer.valueOf(r4), new Constraint());
    L6:
        return this.mConstraints.get(Integer.valueOf(r4));
    }

    static String getDebugName(int r6) {
        Field[] r0 = ConstraintSet.class.getDeclaredFields();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L20;
        Field r3 = r0[r2];
        if (r3.getName().contains("_") == false) goto L19;
        if (r3.getType() != Integer.TYPE) goto L19;
        if (Modifier.isStatic(r3.getModifiers()) == false) goto L19;
        if (Modifier.isFinal(r3.getModifiers()) == false) goto L19;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L14:
        if (r3.getInt(null) != r6) goto L19;
        return r3.getName();
    L19:
        r2 = r2 + 1;
        goto L3
    L20:
        return "UNKNOWN";
    }

    static String getLine(Context r2, int r3, XmlPullParser r4) {
        return ".(" + Debug.getName(r2, r3) + ".xml:" + r4.getLineNumber() + ") \"" + r4.getName() + "\"";
    }

    private static int lookupID(TypedArray r1, int r2, int r3) {
        int r4 = r1.getResourceId(r2, r3);
        if (r4 == (-1)) goto L5;
        return r4;
    L5:
        return r1.getInt(r2, -1);
    }

    static void parseDimensionConstraints(Object r4, TypedArray r5, int r6, int r7) {
        if (r4 != null) goto L4;
        return;
    L4:
        int r0 = r5.peekValue(r6).type;
        if (r0 == 3) goto L39;
        int r2 = -2;
        boolean r3 = false;
        if (r0 == 5) goto L18;
        int r8 = r5.getInt(r6, 0);
        if (r8 != (-4)) goto L11;
        r3 = true;
    L20:
        if ((r4 instanceof ConstraintLayout.LayoutParams) == false) goto L26;
        ConstraintLayout.LayoutParams r9 = (ConstraintLayout.LayoutParams) r4;
        if (r7 != 0) goto L24;
        ((ViewGroup.MarginLayoutParams) r9).width = r2;
        r9.constrainedWidth = r3;
        return;
    L24:
        ((ViewGroup.MarginLayoutParams) r9).height = r2;
        r9.constrainedHeight = r3;
        return;
    L26:
        if ((r4 instanceof Layout) == false) goto L32;
        Layout r10 = (Layout) r4;
        if (r7 != 0) goto L30;
        r10.mWidth = r2;
        r10.constrainedWidth = r3;
        return;
    L30:
        r10.mHeight = r2;
        r10.constrainedHeight = r3;
        return;
    L32:
        if ((r4 instanceof Constraint.Delta) == false) goto L45;
        Constraint.Delta r11 = (Constraint.Delta) r4;
        if (r7 != 0) goto L36;
        r11.add(23, r2);
        int r12 = 80;
    L37:
        r11.add(r12, r3);
        return;
    L36:
        r11.add(21, r2);
        r12 = 81;
        goto L37
    L45:
        return;
    L11:
        if (r8 == (-3)) goto L15;
        if (r8 != (-2)) goto L14;
    L16:
        r2 = r8;
        goto L20
    L14:
        if (r8 == (-1)) goto L16;
    L15:
        r2 = 0;
        goto L20
    L18:
        r2 = r5.getDimensionPixelSize(r6, 0);
        goto L20
    L39:
        parseDimensionConstraintsString(r4, r5.getString(r6), r7);
    }

    static void parseDimensionConstraintsString(Object r5, String r6, int r7) {
        if (r6 != null) goto L4;
        return;
    L4:
        int r0 = r6.indexOf(61);
        int r1 = r6.length();
        if (r0 > 0) goto L7;
        return;
    L7:
        if (r0 >= (r1 - 1)) goto L73;
        String r2 = r6.substring(0, r0);
        String r8 = r6.substring(r0 + 1);
        if (r8.length() <= 0) goto L74;
        String r3 = r2.trim();
        String r9 = r8.trim();
        if (KEY_RATIO.equalsIgnoreCase(r3) == false) goto L72;
        if ((r5 instanceof ConstraintLayout.LayoutParams) == false) goto L20;
        ConstraintLayout.LayoutParams r10 = (ConstraintLayout.LayoutParams) r5;
        if (r7 != 0) goto L17;
        ((ViewGroup.MarginLayoutParams) r10).width = 0;
    L18:
        parseDimensionRatioString(r10, r9);
        return;
    L17:
        ((ViewGroup.MarginLayoutParams) r10).height = 0;
        goto L18
    L20:
        if ((r5 instanceof Layout) == false) goto L23;
        ((Layout) r5).dimensionRatio = r9;
        return;
    L23:
        if ((r5 instanceof Constraint.Delta) == false) goto L77;
        ((Constraint.Delta) r5).add(5, r9);
        return;
    L77:
        return;
    L72:
        if (KEY_WEIGHT.equalsIgnoreCase(r3) == false) goto L48;
        float r11 = Float.parseFloat(r9);     // Catch: NumberFormatException -> L71
        if ((r5 instanceof ConstraintLayout.LayoutParams) == false) goto L34;
        ConstraintLayout.LayoutParams r12 = (ConstraintLayout.LayoutParams) r5;     // Catch: NumberFormatException -> L71
        if (r7 != 0) goto L32;
        ((ViewGroup.MarginLayoutParams) r12).width = 0;     // Catch: NumberFormatException -> L71
        r12.horizontalWeight = r11;     // Catch: NumberFormatException -> L71
        return;
    L32:
        ((ViewGroup.MarginLayoutParams) r12).height = 0;     // Catch: NumberFormatException -> L71
        r12.verticalWeight = r11;     // Catch: NumberFormatException -> L71
        return;
    L34:
        if ((r5 instanceof Layout) == false) goto L40;
        Layout r13 = (Layout) r5;     // Catch: NumberFormatException -> L71
        if (r7 != 0) goto L38;
        r13.mWidth = 0;     // Catch: NumberFormatException -> L71
        r13.horizontalWeight = r11;     // Catch: NumberFormatException -> L71
        return;
    L38:
        r13.mHeight = 0;     // Catch: NumberFormatException -> L71
        r13.verticalWeight = r11;     // Catch: NumberFormatException -> L71
        return;
    L40:
        if ((r5 instanceof Constraint.Delta) == false) goto L83;
        Constraint.Delta r14 = (Constraint.Delta) r5;     // Catch: NumberFormatException -> L71
        if (r7 != 0) goto L45;
        r14.add(23, 0);     // Catch: NumberFormatException -> L71
        int r15 = 39;
    L44:
        r14.add(r15, r11);     // Catch: NumberFormatException -> L71
        return;
    L45:
        r14.add(21, 0);     // Catch: NumberFormatException -> L71
        r15 = 40;
        goto L44
    L83:
        return;
    L48:
        if (KEY_PERCENT_PARENT.equalsIgnoreCase(r3) == true) goto L50;
        return;
    L50:
        float r16 = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(r9)));     // Catch: NumberFormatException -> L71
        if ((r5 instanceof ConstraintLayout.LayoutParams) == false) goto L57;
        ConstraintLayout.LayoutParams r17 = (ConstraintLayout.LayoutParams) r5;     // Catch: NumberFormatException -> L71
        if (r7 != 0) goto L55;
        ((ViewGroup.MarginLayoutParams) r17).width = 0;     // Catch: NumberFormatException -> L71
        r17.matchConstraintPercentWidth = r16;     // Catch: NumberFormatException -> L71
        r17.matchConstraintDefaultWidth = 2;     // Catch: NumberFormatException -> L71
        return;
    L55:
        ((ViewGroup.MarginLayoutParams) r17).height = 0;     // Catch: NumberFormatException -> L71
        r17.matchConstraintPercentHeight = r16;     // Catch: NumberFormatException -> L71
        r17.matchConstraintDefaultHeight = 2;     // Catch: NumberFormatException -> L71
        return;
    L57:
        if ((r5 instanceof Layout) == false) goto L63;
        Layout r18 = (Layout) r5;     // Catch: NumberFormatException -> L71
        if (r7 != 0) goto L61;
        r18.mWidth = 0;     // Catch: NumberFormatException -> L71
        r18.widthPercent = r16;     // Catch: NumberFormatException -> L71
        r18.widthDefault = 2;     // Catch: NumberFormatException -> L71
        return;
    L61:
        r18.mHeight = 0;     // Catch: NumberFormatException -> L71
        r18.heightPercent = r16;     // Catch: NumberFormatException -> L71
        r18.heightDefault = 2;     // Catch: NumberFormatException -> L71
        return;
    L63:
        if ((r5 instanceof Constraint.Delta) == false) goto L90;
        Constraint.Delta r19 = (Constraint.Delta) r5;     // Catch: NumberFormatException -> L71
        if (r7 != 0) goto L68;
        r19.add(23, 0);     // Catch: NumberFormatException -> L71
        int r20 = 54;
    L67:
        r19.add(r20, 2);     // Catch: NumberFormatException -> L71
        return;
    L68:
        r19.add(21, 0);     // Catch: NumberFormatException -> L71
        r20 = 55;
        goto L67
    L90:
        return;
    L92:
        return;
    L74:
        return;
    }

    static void parseDimensionRatioString(ConstraintLayout.LayoutParams r8, String r9) {
        float r0 = Float.NaN;
        int r1 = -1;
        if (r9 == null) goto L34;
        int r2 = r9.length();
        int r3 = r9.indexOf(44);
        int r4 = 0;
        if (r3 > 0) goto L7;
    L15:
        int r5 = r9.indexOf(58);
        if (r5 >= 0) goto L18;
    L31:
        String r6 = r9.substring(r4);
        if (r6.length() <= 0) goto L34;
        r0 = Float.parseFloat(r6);     // Catch: NumberFormatException -> L36
    L37:
        goto L34
    L18:
        if (r5 >= (r2 - 1)) goto L31;
        String r7 = r9.substring(r4, r5);
        String r10 = r9.substring(r5 + 1);
        if (r7.length() <= 0) goto L34;
        if (r10.length() <= 0) goto L34;
        float r11 = Float.parseFloat(r7);     // Catch: NumberFormatException -> L36
        float r12 = Float.parseFloat(r10);     // Catch: NumberFormatException -> L36
        if (r11 <= 0.0f) goto L37;
        if (r12 <= 0.0f) goto L37;
        if (r1 != 1) goto L29;
        r0 = Math.abs(r12 / r11);     // Catch: NumberFormatException -> L36
        goto L37
    L29:
        r0 = Math.abs(r11 / r12);     // Catch: NumberFormatException -> L36
        goto L37
    L7:
        if (r3 >= (r2 - 1)) goto L15;
        String r13 = r9.substring(0, r3);
        if (r13.equalsIgnoreCase("W") == false) goto L12;
        r1 = 0;
    L14:
        r4 = r3 + 1;
        goto L15
    L12:
        if (r13.equalsIgnoreCase("H") == false) goto L14;
        r1 = 1;
    L34:
        r8.dimensionRatio = r9;
        r8.dimensionRatioValue = r0;
        r8.dimensionRatioSide = r1;
    }

    private void populateConstraint(Context r11, Constraint r12, TypedArray r13, boolean r14) {
        int r10 = Build.VERSION.SDK_INT;
        if (r14 == false) goto L6;
        populateOverride(r11, r12, r13);
        return;
    L6:
        int r15 = r13.getIndexCount();
        int r0 = 0;
    L7:
        if (r0 >= r15) goto L132;
        int r1 = r13.getIndex(r0);
        if (r1 == R.styleable.Constraint_android_id) goto L16;
        if (R.styleable.Constraint_android_layout_marginStart == r1) goto L16;
        if (R.styleable.Constraint_android_layout_marginEnd == r1) goto L16;
        r12.motion.mApply = true;
        r12.layout.mApply = true;
        r12.propertySet.mApply = true;
        r12.transform.mApply = true;
    L16:
        switch(mapToConstant.get(r1)) {
            case 1: goto L130;
            case 2: goto L129;
            case 3: goto L128;
            case 4: goto L127;
            case 5: goto L126;
            case 6: goto L125;
            case 7: goto L124;
            case 8: goto L122;
            case 9: goto L121;
            case 10: goto L120;
            case 11: goto L119;
            case 12: goto L118;
            case 13: goto L117;
            case 14: goto L116;
            case 15: goto L115;
            case 16: goto L114;
            case 17: goto L113;
            case 18: goto L112;
            case 19: goto L111;
            case 20: goto L110;
            case 21: goto L109;
            case 22: goto L108;
            case 23: goto L107;
            case 24: goto L106;
            case 25: goto L105;
            case 26: goto L104;
            case 27: goto L103;
            case 28: goto L102;
            case 29: goto L101;
            case 30: goto L100;
            case 31: goto L98;
            case 32: goto L97;
            case 33: goto L96;
            case 34: goto L95;
            case 35: goto L94;
            case 36: goto L93;
            case 37: goto L92;
            case 38: goto L91;
            case 39: goto L90;
            case 40: goto L89;
            case 41: goto L88;
            case 42: goto L87;
            case 43: goto L86;
            case 44: goto L84;
            case 45: goto L83;
            case 46: goto L82;
            case 47: goto L81;
            case 48: goto L80;
            case 49: goto L79;
            case 50: goto L78;
            case 51: goto L77;
            case 52: goto L76;
            case 53: goto L74;
            case 54: goto L73;
            case 55: goto L72;
            case 56: goto L71;
            case 57: goto L70;
            case 58: goto L69;
            case 59: goto L68;
            case 60: goto L67;
            case 61: goto L66;
            case 62: goto L65;
            case 63: goto L64;
            case 64: goto L63;
            case 65: goto L59;
            case 66: goto L57;
            case 67: goto L56;
            case 68: goto L55;
            case 69: goto L54;
            case 70: goto L53;
            case 71: goto L52;
            case 72: goto L51;
            case 73: goto L50;
            case 74: goto L49;
            case 75: goto L48;
            case 76: goto L47;
            case 77: goto L46;
            case 78: goto L45;
            case 79: goto L44;
            case 80: goto L43;
            case 81: goto L42;
            case 82: goto L41;
            case 83: goto L40;
            case 84: goto L39;
            case 85: goto L38;
            case 86: goto L27;
            case 87: goto L25;
            case 88: goto L17;
            case 89: goto L17;
            case 90: goto L17;
            case 91: goto L24;
            case 92: goto L23;
            case 93: goto L22;
            case 94: goto L21;
            case 95: goto L20;
            case 96: goto L19;
            case 97: goto L18;
            default: goto L17;
        };
    L17:
        StringBuilder r2 = new StringBuilder();
        String r3 = "Unknown attribute 0x";
    L26:
        r2.append(r3);
        r2.append(Integer.toHexString(r1));
        r2.append("   ");
        r2.append(mapToConstant.get(r1));
        Log.w(TAG, r2.toString());
    L131:
        r0 = r0 + 1;
        goto L7
    L18:
        Layout r4 = r12.layout;
        r4.mWrapBehavior = r13.getInt(r1, r4.mWrapBehavior);
        goto L131
    L19:
        parseDimensionConstraints(r12.layout, r13, r1, 1);
        goto L131
    L20:
        parseDimensionConstraints(r12.layout, r13, r1, 0);
        goto L131
    L21:
        Layout r5 = r12.layout;
        r5.goneBaselineMargin = r13.getDimensionPixelSize(r1, r5.goneBaselineMargin);
        goto L131
    L22:
        Layout r6 = r12.layout;
        r6.baselineMargin = r13.getDimensionPixelSize(r1, r6.baselineMargin);
        goto L131
    L23:
        Layout r7 = r12.layout;
        r7.baselineToBottom = lookupID(r13, r1, r7.baselineToBottom);
        goto L131
    L24:
        Layout r8 = r12.layout;
        r8.baselineToTop = lookupID(r13, r1, r8.baselineToTop);
        goto L131
    L25:
        r2 = new StringBuilder();
        r3 = "unused attribute 0x";
        goto L26
    L27:
        int r9 = r13.peekValue(r1).type;
        if (r9 != 1) goto L32;
        r12.motion.mQuantizeInterpolatorID = r13.getResourceId(r1, -1);
        Motion r16 = r12.motion;
        if (r16.mQuantizeInterpolatorID == (-1)) goto L131;
    L31:
        r16.mQuantizeInterpolatorType = -2;
        goto L131
    L32:
        if (r9 != 3) goto L37;
        r12.motion.mQuantizeInterpolatorString = r13.getString(r1);
        if (r12.motion.mQuantizeInterpolatorString.indexOf("/") <= 0) goto L36;
        r12.motion.mQuantizeInterpolatorID = r13.getResourceId(r1, -1);
        r16 = r12.motion;
        goto L31
    L36:
        r12.motion.mQuantizeInterpolatorType = -1;
        goto L131
    L37:
        Motion r17 = r12.motion;
        r17.mQuantizeInterpolatorType = r13.getInteger(r1, r17.mQuantizeInterpolatorID);
        goto L131
    L38:
        Motion r18 = r12.motion;
        r18.mQuantizeMotionPhase = r13.getFloat(r1, r18.mQuantizeMotionPhase);
        goto L131
    L39:
        Motion r19 = r12.motion;
        r19.mQuantizeMotionSteps = r13.getInteger(r1, r19.mQuantizeMotionSteps);
        goto L131
    L40:
        Transform r20 = r12.transform;
        r20.transformPivotTarget = lookupID(r13, r1, r20.transformPivotTarget);
        goto L131
    L41:
        Motion r21 = r12.motion;
        r21.mAnimateCircleAngleTo = r13.getInteger(r1, r21.mAnimateCircleAngleTo);
        goto L131
    L42:
        Layout r22 = r12.layout;
        r22.constrainedHeight = r13.getBoolean(r1, r22.constrainedHeight);
        goto L131
    L43:
        Layout r23 = r12.layout;
        r23.constrainedWidth = r13.getBoolean(r1, r23.constrainedWidth);
        goto L131
    L44:
        Motion r24 = r12.motion;
        r24.mMotionStagger = r13.getFloat(r1, r24.mMotionStagger);
        goto L131
    L45:
        PropertySet r25 = r12.propertySet;
        r25.mVisibilityMode = r13.getInt(r1, r25.mVisibilityMode);
        goto L131
    L46:
        r12.layout.mConstraintTag = r13.getString(r1);
        goto L131
    L47:
        Motion r26 = r12.motion;
        r26.mPathMotionArc = r13.getInt(r1, r26.mPathMotionArc);
        goto L131
    L48:
        Layout r27 = r12.layout;
        r27.mBarrierAllowsGoneWidgets = r13.getBoolean(r1, r27.mBarrierAllowsGoneWidgets);
        goto L131
    L49:
        r12.layout.mReferenceIdString = r13.getString(r1);
        goto L131
    L50:
        Layout r28 = r12.layout;
        r28.mBarrierMargin = r13.getDimensionPixelSize(r1, r28.mBarrierMargin);
        goto L131
    L51:
        Layout r29 = r12.layout;
        r29.mBarrierDirection = r13.getInt(r1, r29.mBarrierDirection);
        goto L131
    L52:
        Log.e(TAG, "CURRENTLY UNSUPPORTED");
        goto L131
    L53:
        r12.layout.heightPercent = r13.getFloat(r1, 1.0f);
        goto L131
    L54:
        r12.layout.widthPercent = r13.getFloat(r1, 1.0f);
        goto L131
    L55:
        PropertySet r30 = r12.propertySet;
        r30.mProgress = r13.getFloat(r1, r30.mProgress);
        goto L131
    L56:
        Motion r31 = r12.motion;
        r31.mPathRotate = r13.getFloat(r1, r31.mPathRotate);
        goto L131
    L57:
        r12.motion.mDrawPath = r13.getInt(r1, 0);
        goto L131
    L63:
        Motion r32 = r12.motion;
        r32.mAnimateRelativeTo = lookupID(r13, r1, r32.mAnimateRelativeTo);
        goto L131
    L64:
        Layout r33 = r12.layout;
        r33.circleAngle = r13.getFloat(r1, r33.circleAngle);
        goto L131
    L65:
        Layout r34 = r12.layout;
        r34.circleRadius = r13.getDimensionPixelSize(r1, r34.circleRadius);
        goto L131
    L66:
        Layout r35 = r12.layout;
        r35.circleConstraint = lookupID(r13, r1, r35.circleConstraint);
        goto L131
    L67:
        Transform r36 = r12.transform;
        r36.rotation = r13.getFloat(r1, r36.rotation);
        goto L131
    L68:
        Layout r37 = r12.layout;
        r37.heightMin = r13.getDimensionPixelSize(r1, r37.heightMin);
        goto L131
    L69:
        Layout r38 = r12.layout;
        r38.widthMin = r13.getDimensionPixelSize(r1, r38.widthMin);
        goto L131
    L70:
        Layout r39 = r12.layout;
        r39.heightMax = r13.getDimensionPixelSize(r1, r39.heightMax);
        goto L131
    L71:
        Layout r40 = r12.layout;
        r40.widthMax = r13.getDimensionPixelSize(r1, r40.widthMax);
        goto L131
    L72:
        Layout r41 = r12.layout;
        r41.heightDefault = r13.getInt(r1, r41.heightDefault);
        goto L131
    L73:
        Layout r42 = r12.layout;
        r42.widthDefault = r13.getInt(r1, r42.widthDefault);
        goto L131
    L74:
        if (r10 < 21) goto L131;
        Transform r43 = r12.transform;
        r43.translationZ = r13.getDimension(r1, r43.translationZ);
        goto L131
    L76:
        Transform r44 = r12.transform;
        r44.translationY = r13.getDimension(r1, r44.translationY);
        goto L131
    L77:
        Transform r45 = r12.transform;
        r45.translationX = r13.getDimension(r1, r45.translationX);
        goto L131
    L78:
        Transform r46 = r12.transform;
        r46.transformPivotY = r13.getDimension(r1, r46.transformPivotY);
        goto L131
    L79:
        Transform r47 = r12.transform;
        r47.transformPivotX = r13.getDimension(r1, r47.transformPivotX);
        goto L131
    L80:
        Transform r48 = r12.transform;
        r48.scaleY = r13.getFloat(r1, r48.scaleY);
        goto L131
    L81:
        Transform r49 = r12.transform;
        r49.scaleX = r13.getFloat(r1, r49.scaleX);
        goto L131
    L82:
        Transform r50 = r12.transform;
        r50.rotationY = r13.getFloat(r1, r50.rotationY);
        goto L131
    L83:
        Transform r51 = r12.transform;
        r51.rotationX = r13.getFloat(r1, r51.rotationX);
        goto L131
    L84:
        if (r10 < 21) goto L131;
        Transform r52 = r12.transform;
        r52.applyElevation = true;
        r52.elevation = r13.getDimension(r1, r52.elevation);
        goto L131
    L86:
        PropertySet r53 = r12.propertySet;
        r53.alpha = r13.getFloat(r1, r53.alpha);
        goto L131
    L87:
        Layout r54 = r12.layout;
        r54.verticalChainStyle = r13.getInt(r1, r54.verticalChainStyle);
        goto L131
    L88:
        Layout r55 = r12.layout;
        r55.horizontalChainStyle = r13.getInt(r1, r55.horizontalChainStyle);
        goto L131
    L89:
        Layout r56 = r12.layout;
        r56.verticalWeight = r13.getFloat(r1, r56.verticalWeight);
        goto L131
    L90:
        Layout r57 = r12.layout;
        r57.horizontalWeight = r13.getFloat(r1, r57.horizontalWeight);
        goto L131
    L91:
        r12.mViewId = r13.getResourceId(r1, r12.mViewId);
        goto L131
    L92:
        Layout r58 = r12.layout;
        r58.verticalBias = r13.getFloat(r1, r58.verticalBias);
        goto L131
    L93:
        Layout r59 = r12.layout;
        r59.topToTop = lookupID(r13, r1, r59.topToTop);
        goto L131
    L94:
        Layout r60 = r12.layout;
        r60.topToBottom = lookupID(r13, r1, r60.topToBottom);
        goto L131
    L95:
        Layout r61 = r12.layout;
        r61.topMargin = r13.getDimensionPixelSize(r1, r61.topMargin);
        goto L131
    L96:
        Layout r62 = r12.layout;
        r62.startToStart = lookupID(r13, r1, r62.startToStart);
        goto L131
    L97:
        Layout r63 = r12.layout;
        r63.startToEnd = lookupID(r13, r1, r63.startToEnd);
        goto L131
    L98:
        if (r10 < 17) goto L131;
        Layout r64 = r12.layout;
        r64.startMargin = r13.getDimensionPixelSize(r1, r64.startMargin);
        goto L131
    L100:
        Layout r65 = r12.layout;
        r65.rightToRight = lookupID(r13, r1, r65.rightToRight);
        goto L131
    L101:
        Layout r66 = r12.layout;
        r66.rightToLeft = lookupID(r13, r1, r66.rightToLeft);
        goto L131
    L102:
        Layout r67 = r12.layout;
        r67.rightMargin = r13.getDimensionPixelSize(r1, r67.rightMargin);
        goto L131
    L103:
        Layout r68 = r12.layout;
        r68.orientation = r13.getInt(r1, r68.orientation);
        goto L131
    L104:
        Layout r69 = r12.layout;
        r69.leftToRight = lookupID(r13, r1, r69.leftToRight);
        goto L131
    L105:
        Layout r70 = r12.layout;
        r70.leftToLeft = lookupID(r13, r1, r70.leftToLeft);
        goto L131
    L106:
        Layout r71 = r12.layout;
        r71.leftMargin = r13.getDimensionPixelSize(r1, r71.leftMargin);
        goto L131
    L107:
        Layout r72 = r12.layout;
        r72.mWidth = r13.getLayoutDimension(r1, r72.mWidth);
        goto L131
    L108:
        PropertySet r73 = r12.propertySet;
        r73.visibility = r13.getInt(r1, r73.visibility);
        PropertySet r74 = r12.propertySet;
        r74.visibility = VISIBILITY_FLAGS[r74.visibility];
        goto L131
    L109:
        Layout r75 = r12.layout;
        r75.mHeight = r13.getLayoutDimension(r1, r75.mHeight);
        goto L131
    L110:
        Layout r76 = r12.layout;
        r76.horizontalBias = r13.getFloat(r1, r76.horizontalBias);
        goto L131
    L111:
        Layout r77 = r12.layout;
        r77.guidePercent = r13.getFloat(r1, r77.guidePercent);
        goto L131
    L112:
        Layout r78 = r12.layout;
        r78.guideEnd = r13.getDimensionPixelOffset(r1, r78.guideEnd);
        goto L131
    L113:
        Layout r79 = r12.layout;
        r79.guideBegin = r13.getDimensionPixelOffset(r1, r79.guideBegin);
        goto L131
    L114:
        Layout r80 = r12.layout;
        r80.goneTopMargin = r13.getDimensionPixelSize(r1, r80.goneTopMargin);
        goto L131
    L115:
        Layout r81 = r12.layout;
        r81.goneStartMargin = r13.getDimensionPixelSize(r1, r81.goneStartMargin);
        goto L131
    L116:
        Layout r82 = r12.layout;
        r82.goneRightMargin = r13.getDimensionPixelSize(r1, r82.goneRightMargin);
        goto L131
    L117:
        Layout r83 = r12.layout;
        r83.goneLeftMargin = r13.getDimensionPixelSize(r1, r83.goneLeftMargin);
        goto L131
    L118:
        Layout r84 = r12.layout;
        r84.goneEndMargin = r13.getDimensionPixelSize(r1, r84.goneEndMargin);
        goto L131
    L119:
        Layout r85 = r12.layout;
        r85.goneBottomMargin = r13.getDimensionPixelSize(r1, r85.goneBottomMargin);
        goto L131
    L120:
        Layout r86 = r12.layout;
        r86.endToStart = lookupID(r13, r1, r86.endToStart);
        goto L131
    L121:
        Layout r87 = r12.layout;
        r87.endToEnd = lookupID(r13, r1, r87.endToEnd);
        goto L131
    L122:
        if (r10 < 17) goto L131;
        Layout r88 = r12.layout;
        r88.endMargin = r13.getDimensionPixelSize(r1, r88.endMargin);
        goto L131
    L124:
        Layout r89 = r12.layout;
        r89.editorAbsoluteY = r13.getDimensionPixelOffset(r1, r89.editorAbsoluteY);
        goto L131
    L125:
        Layout r90 = r12.layout;
        r90.editorAbsoluteX = r13.getDimensionPixelOffset(r1, r90.editorAbsoluteX);
        goto L131
    L126:
        r12.layout.dimensionRatio = r13.getString(r1);
        goto L131
    L127:
        Layout r91 = r12.layout;
        r91.bottomToTop = lookupID(r13, r1, r91.bottomToTop);
        goto L131
    L128:
        Layout r92 = r12.layout;
        r92.bottomToBottom = lookupID(r13, r1, r92.bottomToBottom);
        goto L131
    L129:
        Layout r93 = r12.layout;
        r93.bottomMargin = r13.getDimensionPixelSize(r1, r93.bottomMargin);
        goto L131
    L130:
        Layout r94 = r12.layout;
        r94.baselineToBaseline = lookupID(r13, r1, r94.baselineToBaseline);
        goto L131
    L59:
        if (r13.peekValue(r1).type != 3) goto L61;
        Motion r95 = r12.motion;
        String r96 = r13.getString(r1);
    L62:
        r95.mTransitionEasing = r96;
        goto L131
    L61:
        r95 = r12.motion;
        r96 = Easing.NAMED_EASING[r13.getInteger(r1, 0)];
        goto L62
    L132:
        Layout r110 = r12.layout;
        if (r110.mReferenceIdString == null) goto L238;
        r110.mReferenceIds = null;
        return;
    }

    private static void populateOverride(Context r16, Constraint r17, TypedArray r18) {
        int r2 = Build.VERSION.SDK_INT;
        int r3 = r18.getIndexCount();
        Constraint.Delta r4 = new Constraint.Delta();
        r17.mDelta = r4;
        r17.motion.mApply = false;
        r17.layout.mApply = false;
        r17.propertySet.mApply = false;
        r17.transform.mApply = false;
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L129;
        int r7 = r18.getIndex(r5);
        float r9 = 1.0f;
        int r12 = 21;
        switch(overrideMapToConstant.get(r7)) {
            case 2: goto L125;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L123;
            case 6: goto L121;
            case 7: goto L120;
            case 8: goto L118;
            case 9: goto L6;
            case 10: goto L6;
            case 11: goto L116;
            case 12: goto L115;
            case 13: goto L114;
            case 14: goto L113;
            case 15: goto L112;
            case 16: goto L111;
            case 17: goto L110;
            case 18: goto L109;
            case 19: goto L106;
            case 20: goto L105;
            case 21: goto L103;
            case 22: goto L102;
            case 23: goto L101;
            case 24: goto L100;
            case 25: goto L6;
            case 26: goto L6;
            case 27: goto L98;
            case 28: goto L97;
            case 29: goto L6;
            case 30: goto L6;
            case 31: goto L95;
            case 32: goto L6;
            case 33: goto L6;
            case 34: goto L93;
            case 35: goto L6;
            case 36: goto L6;
            case 37: goto L92;
            case 38: goto L91;
            case 39: goto L90;
            case 40: goto L89;
            case 41: goto L88;
            case 42: goto L87;
            case 43: goto L86;
            case 44: goto L84;
            case 45: goto L83;
            case 46: goto L82;
            case 47: goto L81;
            case 48: goto L80;
            case 49: goto L78;
            case 50: goto L77;
            case 51: goto L76;
            case 52: goto L75;
            case 53: goto L73;
            case 54: goto L72;
            case 55: goto L71;
            case 56: goto L70;
            case 57: goto L69;
            case 58: goto L68;
            case 59: goto L67;
            case 60: goto L66;
            case 61: goto L6;
            case 62: goto L65;
            case 63: goto L64;
            case 64: goto L62;
            case 65: goto L58;
            case 66: goto L56;
            case 67: goto L55;
            case 68: goto L54;
            case 69: goto L53;
            case 70: goto L52;
            case 71: goto L51;
            case 72: goto L50;
            case 73: goto L49;
            case 74: goto L48;
            case 75: goto L46;
            case 76: goto L45;
            case 77: goto L44;
            case 78: goto L43;
            case 79: goto L42;
            case 80: goto L41;
            case 81: goto L40;
            case 82: goto L38;
            case 83: goto L37;
            case 84: goto L36;
            case 85: goto L35;
            case 86: goto L24;
            case 87: goto L23;
            case 88: goto L6;
            case 89: goto L6;
            case 90: goto L6;
            case 91: goto L6;
            case 92: goto L6;
            case 93: goto L22;
            case 94: goto L21;
            case 95: goto L20;
            case 96: goto L19;
            case 97: goto L18;
            case 98: goto L10;
            case 99: goto L8;
            default: goto L6;
        };
    L6:
        StringBuilder r8 = new StringBuilder();
        String r10 = "Unknown attribute 0x";
    L7:
        r8.append(r10);
        r8.append(Integer.toHexString(r7));
        r8.append("   ");
        r8.append(mapToConstant.get(r7));
        Log.w(TAG, r8.toString());
    L128:
        r5 = r5 + 1;
        goto L3
    L8:
        int r11 = 99;
        boolean r13 = r17.layout.guidelineUseRtl;
    L47:
        r4.add(r11, r18.getBoolean(r7, r13));
        goto L128
    L18:
        int r14 = 97;
        int r15 = r17.layout.mWrapBehavior;
    L99:
        int r19 = r18.getInt(r7, r15);
    L127:
        r4.add(r14, r19);
        goto L128
    L19:
        parseDimensionConstraints(r4, r18, r7, 1);
        goto L128
    L20:
        parseDimensionConstraints(r4, r18, r7, 0);
        goto L128
    L21:
        r14 = 94;
        int r20 = r17.layout.goneBaselineMargin;
    L126:
        r19 = r18.getDimensionPixelSize(r7, r20);
        goto L127
    L22:
        r14 = 93;
        r20 = r17.layout.baselineMargin;
        goto L126
    L23:
        r8 = new StringBuilder();
        r10 = "unused attribute 0x";
        goto L7
    L24:
        int r21 = r18.peekValue(r7).type;
        r12 = 88;
        if (r21 != 1) goto L29;
        r17.motion.mQuantizeInterpolatorID = r18.getResourceId(r7, -1);
        r4.add(89, r17.motion.mQuantizeInterpolatorID);
        Motion r22 = r17.motion;
        if (r22.mQuantizeInterpolatorID == (-1)) goto L128;
    L28:
        r22.mQuantizeInterpolatorType = -2;
        r4.add(88, -2);
        goto L128
    L29:
        if (r21 != 3) goto L34;
        r17.motion.mQuantizeInterpolatorString = r18.getString(r7);
        r4.add(90, r17.motion.mQuantizeInterpolatorString);
        if (r17.motion.mQuantizeInterpolatorString.indexOf("/") <= 0) goto L33;
        r17.motion.mQuantizeInterpolatorID = r18.getResourceId(r7, -1);
        r4.add(89, r17.motion.mQuantizeInterpolatorID);
        r22 = r17.motion;
        goto L28
    L33:
        r17.motion.mQuantizeInterpolatorType = -1;
        r4.add(88, -1);
        goto L128
    L34:
        Motion r23 = r17.motion;
        r23.mQuantizeInterpolatorType = r18.getInteger(r7, r23.mQuantizeInterpolatorID);
        int r24 = r17.motion.mQuantizeInterpolatorType;
    L104:
        r4.add(r12, r24);
        goto L128
    L35:
        int r25 = 85;
        r9 = r17.motion.mQuantizeMotionPhase;
    L107:
        float r26 = r18.getFloat(r7, r9);
    L108:
        r4.add(r25, r26);
        goto L128
    L36:
        r14 = 84;
        int r27 = r17.motion.mQuantizeMotionSteps;
    L39:
        r19 = r18.getInteger(r7, r27);
        goto L127
    L37:
        r14 = 83;
        int r28 = r17.transform.transformPivotTarget;
    L63:
        r19 = lookupID(r18, r7, r28);
        goto L127
    L38:
        r14 = 82;
        r27 = r17.motion.mAnimateCircleAngleTo;
        goto L39
    L40:
        r11 = 81;
        r13 = r17.layout.constrainedHeight;
        goto L47
    L41:
        r11 = 80;
        r13 = r17.layout.constrainedWidth;
        goto L47
    L42:
        r25 = 79;
        r9 = r17.motion.mMotionStagger;
        goto L107
    L43:
        r14 = 78;
        r15 = r17.propertySet.mVisibilityMode;
        goto L99
    L44:
        int r29 = 77;
    L124:
        r4.add(r29, r18.getString(r7));
        goto L128
    L45:
        r14 = 76;
        r15 = r17.motion.mPathMotionArc;
        goto L99
    L46:
        r11 = 75;
        r13 = r17.layout.mBarrierAllowsGoneWidgets;
        goto L47
    L48:
        r29 = 74;
        goto L124
    L49:
        r14 = 73;
        r20 = r17.layout.mBarrierMargin;
        goto L126
    L50:
        r14 = 72;
        r15 = r17.layout.mBarrierDirection;
        goto L99
    L51:
        Log.e(TAG, "CURRENTLY UNSUPPORTED");
        goto L128
    L52:
        r25 = 70;
        goto L107
    L53:
        r25 = 69;
        goto L107
    L54:
        r25 = 68;
        r9 = r17.propertySet.mProgress;
        goto L107
    L55:
        r25 = 67;
        r9 = r17.motion.mPathRotate;
        goto L107
    L56:
        r14 = 66;
        r19 = r18.getInt(r7, 0);
        goto L127
    L62:
        r14 = 64;
        r28 = r17.motion.mAnimateRelativeTo;
        goto L63
    L64:
        r25 = 63;
        r9 = r17.layout.circleAngle;
        goto L107
    L65:
        r14 = 62;
        r20 = r17.layout.circleRadius;
        goto L126
    L66:
        r25 = 60;
        r9 = r17.transform.rotation;
        goto L107
    L67:
        r14 = 59;
        r20 = r17.layout.heightMin;
        goto L126
    L68:
        r14 = 58;
        r20 = r17.layout.widthMin;
        goto L126
    L69:
        r14 = 57;
        r20 = r17.layout.heightMax;
        goto L126
    L70:
        r14 = 56;
        r20 = r17.layout.widthMax;
        goto L126
    L71:
        r14 = 55;
        r15 = r17.layout.heightDefault;
        goto L99
    L72:
        r14 = 54;
        r15 = r17.layout.widthDefault;
        goto L99
    L73:
        if (r2 < 21) goto L128;
        r25 = 53;
        float r30 = r17.transform.translationZ;
    L79:
        r26 = r18.getDimension(r7, r30);
        goto L108
    L75:
        r25 = 52;
        r30 = r17.transform.translationY;
        goto L79
    L76:
        r25 = 51;
        r30 = r17.transform.translationX;
        goto L79
    L77:
        r25 = 50;
        r30 = r17.transform.transformPivotY;
        goto L79
    L78:
        r25 = 49;
        r30 = r17.transform.transformPivotX;
        goto L79
    L80:
        r25 = 48;
        r9 = r17.transform.scaleY;
        goto L107
    L81:
        r25 = 47;
        r9 = r17.transform.scaleX;
        goto L107
    L82:
        r25 = 46;
        r9 = r17.transform.rotationY;
        goto L107
    L83:
        r25 = 45;
        r9 = r17.transform.rotationX;
        goto L107
    L84:
        if (r2 < 21) goto L128;
        r25 = 44;
        r4.add(44, true);
        r30 = r17.transform.elevation;
        goto L79
    L86:
        r25 = 43;
        r9 = r17.propertySet.alpha;
        goto L107
    L87:
        r14 = 42;
        r15 = r17.layout.verticalChainStyle;
        goto L99
    L88:
        r14 = 41;
        r15 = r17.layout.horizontalChainStyle;
        goto L99
    L89:
        r25 = 40;
        r9 = r17.layout.verticalWeight;
        goto L107
    L90:
        r25 = 39;
        r9 = r17.layout.horizontalWeight;
        goto L107
    L91:
        r19 = r18.getResourceId(r7, r17.mViewId);
        r17.mViewId = r19;
        r14 = 38;
        goto L127
    L92:
        r25 = 37;
        r9 = r17.layout.verticalBias;
        goto L107
    L93:
        r14 = 34;
        r20 = r17.layout.topMargin;
        goto L126
    L97:
        r14 = 28;
        r20 = r17.layout.rightMargin;
        goto L126
    L98:
        r14 = 27;
        r15 = r17.layout.orientation;
        goto L99
    L100:
        r14 = 24;
        r20 = r17.layout.leftMargin;
        goto L126
    L101:
        r14 = 23;
        r19 = r18.getLayoutDimension(r7, r17.layout.mWidth);
        goto L127
    L102:
        r14 = 22;
        r19 = VISIBILITY_FLAGS[r18.getInt(r7, r17.propertySet.visibility)];
        goto L127
    L103:
        r24 = r18.getLayoutDimension(r7, r17.layout.mHeight);
        goto L104
    L105:
        r25 = 20;
        r9 = r17.layout.horizontalBias;
        goto L107
    L106:
        r25 = 19;
        r9 = r17.layout.guidePercent;
        goto L107
    L109:
        r14 = 18;
        int r31 = r17.layout.guideEnd;
    L122:
        r19 = r18.getDimensionPixelOffset(r7, r31);
        goto L127
    L110:
        r19 = r18.getDimensionPixelOffset(r7, r17.layout.guideBegin);
        r14 = 17;
        goto L127
    L111:
        r14 = 16;
        r20 = r17.layout.goneTopMargin;
        goto L126
    L112:
        r14 = 15;
        r20 = r17.layout.goneStartMargin;
        goto L126
    L113:
        r14 = 14;
        r20 = r17.layout.goneRightMargin;
        goto L126
    L114:
        r14 = 13;
        r20 = r17.layout.goneLeftMargin;
        goto L126
    L115:
        r14 = 12;
        r20 = r17.layout.goneEndMargin;
        goto L126
    L116:
        r14 = 11;
        r20 = r17.layout.goneBottomMargin;
        goto L126
    L120:
        r14 = 7;
        r31 = r17.layout.editorAbsoluteY;
        goto L122
    L121:
        r14 = 6;
        r31 = r17.layout.editorAbsoluteX;
        goto L122
    L123:
        r29 = 5;
        goto L124
    L125:
        r14 = 2;
        r20 = r17.layout.bottomMargin;
        goto L126
    L10:
        if (MotionLayout.IS_IN_EDIT_MODE == false) goto L15;
        int r32 = r18.getResourceId(r7, r17.mViewId);
        r17.mViewId = r32;
        if (r32 != (-1)) goto L128;
    L16:
        r17.mTargetString = r18.getString(r7);
        goto L128
    L15:
        if (r18.peekValue(r7).type == 3) goto L16;
        r17.mViewId = r18.getResourceId(r7, r17.mViewId);
        goto L128
    L58:
        if (r18.peekValue(r7).type != 3) goto L60;
        String r33 = r18.getString(r7);
    L61:
        r4.add(65, r33);
        goto L128
    L60:
        r33 = Easing.NAMED_EASING[r18.getInteger(r7, 0)];
        goto L61
    L95:
        if (r2 < 17) goto L128;
        r14 = 31;
        r20 = r17.layout.startMargin;
        goto L126
    L118:
        if (r2 < 17) goto L128;
        r14 = 8;
        r20 = r17.layout.endMargin;
        goto L126
    }

    private static void setDeltaValue(Constraint r1, int r2, float r3) {
        if (r2 != 19) goto L5;
        r1.layout.guidePercent = r3;
        return;
    L5:
        if (r2 != 20) goto L7;
        r1.layout.horizontalBias = r3;
        return;
    L7:
        if (r2 != 37) goto L9;
        r1.layout.verticalBias = r3;
        return;
    L9:
        if (r2 != 60) goto L11;
        r1.transform.rotation = r3;
        return;
    L11:
        if (r2 != 63) goto L13;
        r1.layout.circleAngle = r3;
        return;
    L13:
        if (r2 != 79) goto L15;
        r1.motion.mMotionStagger = r3;
        return;
    L15:
        if (r2 != 85) goto L17;
        r1.motion.mQuantizeMotionPhase = r3;
        return;
    L17:
        if (r2 != 87) goto L19;
        return;
    L19:
        if (r2 != 39) goto L21;
        r1.layout.horizontalWeight = r3;
        return;
    L21:
        if (r2 == 40) goto L40;
        switch(r2) {
            case 43: goto L39;
            case 44: goto L38;
            case 45: goto L37;
            case 46: goto L36;
            case 47: goto L35;
            case 48: goto L34;
            case 49: goto L33;
            case 50: goto L32;
            case 51: goto L31;
            case 52: goto L30;
            case 53: goto L29;
            default: goto L23;
        };
    L23:
        switch(r2) {
            case 67: goto L28;
            case 68: goto L27;
            case 69: goto L26;
            case 70: goto L25;
            default: goto L24;
        };
    L24:
        Log.w(TAG, "Unknown attribute 0x");
        return;
    L25:
        r1.layout.heightPercent = r3;
        return;
    L26:
        r1.layout.widthPercent = r3;
        return;
    L27:
        r1.propertySet.mProgress = r3;
        return;
    L28:
        r1.motion.mPathRotate = r3;
        return;
    L29:
        r1.transform.translationZ = r3;
        return;
    L30:
        r1.transform.translationY = r3;
        return;
    L31:
        r1.transform.translationX = r3;
        return;
    L32:
        r1.transform.transformPivotY = r3;
        return;
    L33:
        r1.transform.transformPivotX = r3;
        return;
    L34:
        r1.transform.scaleY = r3;
        return;
    L35:
        r1.transform.scaleX = r3;
        return;
    L36:
        r1.transform.rotationY = r3;
        return;
    L37:
        r1.transform.rotationX = r3;
        return;
    L38:
        Transform r4 = r1.transform;
        r4.elevation = r3;
        r4.applyElevation = true;
        return;
    L39:
        r1.propertySet.alpha = r3;
        return;
    L40:
        r1.layout.verticalWeight = r3;
    }

    private static void setDeltaValue(Constraint r1, int r2, int r3) {
        if (r2 != 6) goto L5;
        r1.layout.editorAbsoluteX = r3;
        return;
    L5:
        if (r2 != 7) goto L7;
        r1.layout.editorAbsoluteY = r3;
        return;
    L7:
        if (r2 != 8) goto L9;
        r1.layout.endMargin = r3;
        return;
    L9:
        if (r2 != 27) goto L11;
        r1.layout.orientation = r3;
        return;
    L11:
        if (r2 != 28) goto L13;
        r1.layout.rightMargin = r3;
        return;
    L13:
        if (r2 != 41) goto L15;
        r1.layout.horizontalChainStyle = r3;
        return;
    L15:
        if (r2 != 42) goto L17;
        r1.layout.verticalChainStyle = r3;
        return;
    L17:
        if (r2 != 61) goto L19;
        r1.layout.circleConstraint = r3;
        return;
    L19:
        if (r2 != 62) goto L21;
        r1.layout.circleRadius = r3;
        return;
    L21:
        if (r2 != 72) goto L23;
        r1.layout.mBarrierDirection = r3;
        return;
    L23:
        if (r2 == 73) goto L64;
        switch(r2) {
            case 2: goto L63;
            case 11: goto L62;
            case 12: goto L61;
            case 13: goto L60;
            case 14: goto L59;
            case 15: goto L58;
            case 16: goto L57;
            case 17: goto L56;
            case 18: goto L55;
            case 31: goto L54;
            case 34: goto L53;
            case 38: goto L52;
            case 64: goto L51;
            case 66: goto L50;
            case 76: goto L49;
            case 78: goto L48;
            case 93: goto L47;
            case 94: goto L46;
            case 97: goto L45;
            default: goto L25;
        };
    L25:
        switch(r2) {
            case 21: goto L44;
            case 22: goto L43;
            case 23: goto L42;
            case 24: goto L41;
            default: goto L26;
        };
    L26:
        switch(r2) {
            case 54: goto L40;
            case 55: goto L39;
            case 56: goto L38;
            case 57: goto L37;
            case 58: goto L36;
            case 59: goto L35;
            default: goto L27;
        };
    L27:
        switch(r2) {
            case 82: goto L34;
            case 83: goto L33;
            case 84: goto L32;
            default: goto L28;
        };
    L28:
        switch(r2) {
            case 87: goto L76;
            case 88: goto L31;
            case 89: goto L30;
            default: goto L29;
        };
    L29:
        Log.w(TAG, "Unknown attribute 0x");
        return;
    L30:
        r1.motion.mQuantizeInterpolatorID = r3;
        return;
    L31:
        r1.motion.mQuantizeInterpolatorType = r3;
        return;
    L76:
        return;
    L32:
        r1.motion.mQuantizeMotionSteps = r3;
        return;
    L33:
        r1.transform.transformPivotTarget = r3;
        return;
    L34:
        r1.motion.mAnimateCircleAngleTo = r3;
        return;
    L35:
        r1.layout.heightMin = r3;
        return;
    L36:
        r1.layout.widthMin = r3;
        return;
    L37:
        r1.layout.heightMax = r3;
        return;
    L38:
        r1.layout.widthMax = r3;
        return;
    L39:
        r1.layout.heightDefault = r3;
        return;
    L40:
        r1.layout.widthDefault = r3;
        return;
    L41:
        r1.layout.leftMargin = r3;
        return;
    L42:
        r1.layout.mWidth = r3;
        return;
    L43:
        r1.propertySet.visibility = r3;
        return;
    L44:
        r1.layout.mHeight = r3;
        return;
    L45:
        r1.layout.mWrapBehavior = r3;
        return;
    L46:
        r1.layout.goneBaselineMargin = r3;
        return;
    L47:
        r1.layout.baselineMargin = r3;
        return;
    L48:
        r1.propertySet.mVisibilityMode = r3;
        return;
    L49:
        r1.motion.mPathMotionArc = r3;
        return;
    L50:
        r1.motion.mDrawPath = r3;
        return;
    L51:
        r1.motion.mAnimateRelativeTo = r3;
        return;
    L52:
        r1.mViewId = r3;
        return;
    L53:
        r1.layout.topMargin = r3;
        return;
    L54:
        r1.layout.startMargin = r3;
        return;
    L55:
        r1.layout.guideEnd = r3;
        return;
    L56:
        r1.layout.guideBegin = r3;
        return;
    L57:
        r1.layout.goneTopMargin = r3;
        return;
    L58:
        r1.layout.goneStartMargin = r3;
        return;
    L59:
        r1.layout.goneRightMargin = r3;
        return;
    L60:
        r1.layout.goneLeftMargin = r3;
        return;
    L61:
        r1.layout.goneEndMargin = r3;
        return;
    L62:
        r1.layout.goneBottomMargin = r3;
        return;
    L63:
        r1.layout.bottomMargin = r3;
        return;
    L64:
        r1.layout.mBarrierMargin = r3;
    }

    private static void setDeltaValue(Constraint r1, int r2, String r3) {
        if (r2 != 5) goto L5;
        r1.layout.dimensionRatio = r3;
        return;
    L5:
        if (r2 != 65) goto L7;
        r1.motion.mTransitionEasing = r3;
        return;
    L7:
        if (r2 != 74) goto L9;
        Layout r4 = r1.layout;
        r4.mReferenceIdString = r3;
        r4.mReferenceIds = null;
        return;
    L9:
        if (r2 != 77) goto L11;
        r1.layout.mConstraintTag = r3;
        return;
    L11:
        if (r2 != 87) goto L13;
        return;
    L13:
        if (r2 == 90) goto L15;
        Log.w(TAG, "Unknown attribute 0x");
        return;
    L15:
        r1.motion.mQuantizeInterpolatorString = r3;
    }

    private static void setDeltaValue(Constraint r1, int r2, boolean r3) {
        if (r2 != 44) goto L5;
        r1.transform.applyElevation = r3;
        return;
    L5:
        if (r2 != 75) goto L7;
        r1.layout.mBarrierAllowsGoneWidgets = r3;
        return;
    L7:
        if (r2 != 87) goto L9;
        return;
    L9:
        if (r2 != 80) goto L11;
        r1.layout.constrainedWidth = r3;
        return;
    L11:
        if (r2 == 81) goto L13;
        Log.w(TAG, "Unknown attribute 0x");
        return;
    L13:
        r1.layout.constrainedHeight = r3;
    }

    private String sideToString(int r1) {
        switch(r1) {
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            case 7: goto L5;
            default: goto L3;
        };
    L3:
        return "undefined";
    L5:
        return "end";
    L7:
        return "start";
    L9:
        return "baseline";
    L11:
        return "bottom";
    L13:
        return "top";
    L15:
        return "right";
    L17:
        return "left";
    }

    private static String[] splitString(String r6) {
        char[] r7 = r6.toCharArray();
        ArrayList r0 = new ArrayList();
        int r1 = 0;
        int r2 = 0;
        boolean r3 = false;
    L4:
        if (r1 >= r7.length) goto L13;
        if (r7[r1] != ',') goto L10;
        if (r3 == true) goto L10;
        r0.add(new String(r7, r2, r1 - r2));
        r2 = r1 + 1;
    L12:
        r1 = r1 + 1;
    L10:
        if (r7[r1] != '\"') goto L12;
        r3 = !r3;
        goto L12
    L13:
        r0.add(new String(r7, r2, r7.length - r2));
        return (String[]) r0.toArray(new String[r0.size()]);
    }

    public void addColorAttributes(String... r2) {
        addAttributes(ConstraintAttribute.AttributeType.COLOR_TYPE, r2);
    }

    public void addFloatAttributes(String... r2) {
        addAttributes(ConstraintAttribute.AttributeType.FLOAT_TYPE, r2);
    }

    public void addIntAttributes(String... r2) {
        addAttributes(ConstraintAttribute.AttributeType.INT_TYPE, r2);
    }

    public void addStringAttributes(String... r2) {
        addAttributes(ConstraintAttribute.AttributeType.STRING_TYPE, r2);
    }

    public void addToHorizontalChain(int r9, int r10, int r11) {
        if (r10 != 0) goto L5;
        int r4 = 1;
    L6:
        connect(r9, 1, r10, r4, 0);
        if (r11 != 0) goto L9;
        int r5 = 2;
    L10:
        connect(r9, 2, r11, r5, 0);
        if (r10 == 0) goto L13;
        connect(r10, 2, r9, 1, 0);
    L13:
        if (r11 == 0) goto L16;
        connect(r11, 1, r9, 2, 0);
        return;
    L16:
        return;
    L9:
        r5 = 1;
        goto L10
    L5:
        r4 = 2;
        goto L6
    }

    public void addToHorizontalChainRTL(int r9, int r10, int r11) {
        if (r10 != 0) goto L5;
        int r4 = 6;
    L6:
        connect(r9, 6, r10, r4, 0);
        if (r11 != 0) goto L9;
        int r5 = 7;
    L10:
        connect(r9, 7, r11, r5, 0);
        if (r10 == 0) goto L13;
        connect(r10, 7, r9, 6, 0);
    L13:
        if (r11 == 0) goto L16;
        connect(r11, 6, r9, 7, 0);
        return;
    L16:
        return;
    L9:
        r5 = 6;
        goto L10
    L5:
        r4 = 7;
        goto L6
    }

    public void addToVerticalChain(int r9, int r10, int r11) {
        if (r10 != 0) goto L5;
        int r4 = 3;
    L6:
        connect(r9, 3, r10, r4, 0);
        if (r11 != 0) goto L9;
        int r5 = 4;
    L10:
        connect(r9, 4, r11, r5, 0);
        if (r10 == 0) goto L13;
        connect(r10, 4, r9, 3, 0);
    L13:
        if (r11 == 0) goto L16;
        connect(r11, 3, r9, 4, 0);
        return;
    L16:
        return;
    L9:
        r5 = 3;
        goto L10
    L5:
        r4 = 4;
        goto L6
    }

    public void applyCustomAttributes(ConstraintLayout r7) {
        int r0 = r7.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L21;
        View r2 = r7.getChildAt(r1);
        int r3 = r2.getId();
        if (this.mConstraints.containsKey(Integer.valueOf(r3)) == true) goto L8;
        Log.w(TAG, "id unknown " + Debug.getName(r2));
    L20:
        r1 = r1 + 1;
        goto L3
    L8:
        if (this.mForceId == false) goto L15;
        if (r3 != (-1)) goto L15;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L15:
        if (this.mConstraints.containsKey(Integer.valueOf(r3)) == false) goto L20;
        Constraint r4 = this.mConstraints.get(Integer.valueOf(r3));
        if (r4 == null) goto L20;
        ConstraintAttribute.setAttributes(r2, r4.mCustomConstraints);
        goto L20
    }

    public void applyDeltaFrom(ConstraintSet r6) {
        Iterator<Constraint> r7 = r6.mConstraints.values().iterator();
    L4:
        if (r7.hasNext() == false) goto L18;
        Constraint r0 = r7.next();
        if (r0.mDelta == null) goto L4;
        if (r0.mTargetString != null) goto L9;
        Constraint r1 = getConstraint(r0.mViewId);
        r0.mDelta.applyDelta(r1);
        goto L4
    L9:
        Iterator<Integer> r2 = this.mConstraints.keySet().iterator();
    L11:
        if (r2.hasNext() == false) goto L4;
        Constraint r3 = getConstraint(r2.next().intValue());
        String r4 = r3.layout.mConstraintTag;
        if (r4 == null) goto L11;
        if (r0.mTargetString.matches(r4) == false) goto L11;
        r0.mDelta.applyDelta(r3);
        r3.mCustomConstraints.putAll((HashMap) r0.mCustomConstraints.clone());
        goto L11
    }

    public void applyTo(ConstraintLayout r2) {
        applyToInternal(r2, true);
        r2.setConstraintSet(null);
        r2.requestLayout();
    }

    public void applyToHelper(ConstraintHelper r4, ConstraintWidget r5, ConstraintLayout.LayoutParams r6, SparseArray<ConstraintWidget> r7) {
        int r0 = r4.getId();
        if (this.mConstraints.containsKey(Integer.valueOf(r0)) == false) goto L10;
        Constraint r3 = this.mConstraints.get(Integer.valueOf(r0));
        if (r3 != null) goto L7;
        return;
    L7:
        if ((r5 instanceof HelperWidget) == false) goto L12;
        r4.loadParameters(r3, (HelperWidget) r5, r6, r7);
        return;
    L12:
        return;
    }

    void applyToInternal(ConstraintLayout r12, boolean r13) {
        int r0 = r12.getChildCount();
        HashSet r1 = new HashSet(this.mConstraints.keySet());
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r3 >= r0) goto L59;
        View r5 = r12.getChildAt(r3);
        int r6 = r5.getId();
        if (this.mConstraints.containsKey(Integer.valueOf(r6)) == true) goto L9;
        Log.w(TAG, "id unknown " + Debug.getName(r5));
    L58:
        r3 = r3 + 1;
        goto L4
    L9:
        if (this.mForceId == false) goto L14;
        if (r6 != (-1)) goto L14;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L14:
        if (r6 == (-1)) goto L58;
        if (this.mConstraints.containsKey(Integer.valueOf(r6)) == false) goto L57;
        r1.remove(Integer.valueOf(r6));
        Constraint r7 = this.mConstraints.get(Integer.valueOf(r6));
        if (r7 == null) goto L58;
        if ((r5 instanceof Barrier) == false) goto L29;
        r7.layout.mHelperType = 1;
        Barrier r4 = (Barrier) r5;
        r4.setId(r6);
        r4.setType(r7.layout.mBarrierDirection);
        r4.setMargin(r7.layout.mBarrierMargin);
        r4.setAllowsGoneWidget(r7.layout.mBarrierAllowsGoneWidgets);
        Layout r8 = r7.layout;
        int[] r9 = r8.mReferenceIds;
        if (r9 == null) goto L26;
        r4.setReferencedIds(r9);
        goto L29
    L26:
        String r10 = r8.mReferenceIdString;
        if (r10 == null) goto L29;
        r8.mReferenceIds = convertReferenceString(r4, r10);
        r4.setReferencedIds(r7.layout.mReferenceIds);
    L29:
        ConstraintLayout.LayoutParams r11 = (ConstraintLayout.LayoutParams) r5.getLayoutParams();
        r11.validate();
        r7.applyTo(r11);
        if (r13 == false) goto L32;
        ConstraintAttribute.setAttributes(r5, r7.mCustomConstraints);
    L32:
        r5.setLayoutParams(r11);
        PropertySet r14 = r7.propertySet;
        if (r14.mVisibilityMode != 0) goto L35;
        r5.setVisibility(r14.visibility);
    L35:
        int r15 = Build.VERSION.SDK_INT;
        if (r15 < 17) goto L58;
        r5.setAlpha(r7.propertySet.alpha);
        r5.setRotation(r7.transform.rotation);
        r5.setRotationX(r7.transform.rotationX);
        r5.setRotationY(r7.transform.rotationY);
        r5.setScaleX(r7.transform.scaleX);
        r5.setScaleY(r7.transform.scaleY);
        Transform r16 = r7.transform;
        if (r16.transformPivotTarget == (-1)) goto L47;
        View r17 = ((View) r5.getParent()).findViewById(r7.transform.transformPivotTarget);
        if (r17 == null) goto L52;
        float r18 = (r17.getTop() + r17.getBottom()) / 2.0f;
        float r19 = (r17.getLeft() + r17.getRight()) / 2.0f;
        if ((r5.getRight() - r5.getLeft()) <= 0) goto L52;
        if ((r5.getBottom() - r5.getTop()) <= 0) goto L52;
        float r20 = r19 - r5.getLeft();
        float r21 = r18 - r5.getTop();
        r5.setPivotX(r20);
        r5.setPivotY(r21);
    L52:
        r5.setTranslationX(r7.transform.translationX);
        r5.setTranslationY(r7.transform.translationY);
        if (r15 < 21) goto L58;
        r5.setTranslationZ(r7.transform.translationZ);
        Transform r22 = r7.transform;
        if (r22.applyElevation == false) goto L58;
        r5.setElevation(r22.elevation);
        goto L58
    L47:
        if (Float.isNaN(r16.transformPivotX) == true) goto L50;
        r5.setPivotX(r7.transform.transformPivotX);
    L50:
        if (Float.isNaN(r7.transform.transformPivotY) == true) goto L52;
        r5.setPivotY(r7.transform.transformPivotY);
        goto L52
    L57:
        Log.v(TAG, "WARNING NO CONSTRAINTS for view " + r6);
        goto L58
    L59:
        Iterator r110 = r1.iterator();
    L61:
        if (r110.hasNext() == false) goto L77;
        Integer r23 = (Integer) r110.next();
        Constraint r24 = this.mConstraints.get(r23);
        if (r24 == null) goto L61;
        if (r24.layout.mHelperType != 1) goto L75;
        Barrier r25 = new Barrier(r12.getContext());
        r25.setId(r23.intValue());
        Layout r26 = r24.layout;
        int[] r27 = r26.mReferenceIds;
        if (r27 == null) goto L70;
        r25.setReferencedIds(r27);
    L73:
        r25.setType(r24.layout.mBarrierDirection);
        r25.setMargin(r24.layout.mBarrierMargin);
        ConstraintLayout.LayoutParams r28 = r12.generateDefaultLayoutParams();
        r25.validateParams();
        r24.applyTo(r28);
        r12.addView(r25, r28);
        goto L75
    L70:
        String r29 = r26.mReferenceIdString;
        if (r29 == null) goto L73;
        r26.mReferenceIds = convertReferenceString(r25, r29);
        r25.setReferencedIds(r24.layout.mReferenceIds);
    L75:
        if (r24.layout.mIsGuideline == false) goto L61;
        View r30 = new Guideline(r12.getContext());
        r30.setId(r23.intValue());
        ConstraintLayout.LayoutParams r31 = r12.generateDefaultLayoutParams();
        r24.applyTo(r31);
        r12.addView(r30, r31);
    L77:
        if (r2 >= r0) goto L82;
        View r111 = r12.getChildAt(r2);
        if ((r111 instanceof ConstraintHelper) == false) goto L81;
        ((ConstraintHelper) r111).applyLayoutFeaturesInConstraintSet(r12);
    L81:
        r2 = r2 + 1;
        goto L77
    }

    public void applyToLayoutParams(int r3, ConstraintLayout.LayoutParams r4) {
        if (this.mConstraints.containsKey(Integer.valueOf(r3)) == false) goto L8;
        Constraint r2 = this.mConstraints.get(Integer.valueOf(r3));
        if (r2 == null) goto L9;
        r2.applyTo(r4);
        return;
    L9:
        return;
    }

    public void applyToWithoutCustom(ConstraintLayout r2) {
        applyToInternal(r2, false);
        r2.setConstraintSet(null);
    }

    public void center(int r9, int r10, int r11, int r12, int r13, int r14, int r15, float r16) {
        if (r12 < 0) goto L34;
        if (r15 < 0) goto L32;
        if (r16 <= 0.0f) goto L30;
        if (r16 > 1.0f) goto L30;
        if (r11 != 1) goto L12;
    L25:
        connect(r9, 1, r10, r11, r12);
        connect(r9, 2, r13, r14, r15);
        Constraint r0 = this.mConstraints.get(Integer.valueOf(r9));
        if (r0 == null) goto L38;
    L24:
        r0.layout.horizontalBias = r16;
        return;
    L38:
        return;
    L12:
        if (r11 == 2) goto L25;
        if (r11 != 6) goto L17;
    L22:
        connect(r9, 6, r10, r11, r12);
        connect(r9, 7, r13, r14, r15);
        r0 = this.mConstraints.get(Integer.valueOf(r9));
        if (r0 != null) goto L24;
        return;
    L17:
        if (r11 == 7) goto L22;
        connect(r9, 3, r10, r11, r12);
        connect(r9, 4, r13, r14, r15);
        Constraint r1 = this.mConstraints.get(Integer.valueOf(r9));
        if (r1 == null) goto L28;
        r1.layout.verticalBias = r16;
        return;
    L28:
        return;
    L30:
        throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
    L32:
        throw new IllegalArgumentException("margin must be > 0");
    L34:
        throw new IllegalArgumentException("margin must be > 0");
    }

    public void centerHorizontally(int r10, int r11) {
        if (r11 != 0) goto L4;
        int r2 = 0;
        int r3 = 1;
        int r4 = 0;
        int r5 = 0;
        int r6 = 2;
        int r7 = 0;
        float r8 = 0.5f;
    L5:
        center(r10, r2, r3, r4, r5, r6, r7, r8);
        return;
    L4:
        r3 = 2;
        r4 = 0;
        r6 = 1;
        r7 = 0;
        r8 = 0.5f;
        r2 = r11;
        r5 = r11;
        goto L5
    }

    public void centerHorizontally(int r10, int r11, int r12, int r13, int r14, int r15, int r16, float r17) {
        connect(r10, 1, r11, r12, r13);
        connect(r10, 2, r14, r15, r16);
        Constraint r0 = this.mConstraints.get(Integer.valueOf(r10));
        if (r0 == null) goto L6;
        r0.layout.horizontalBias = r17;
        return;
    }

    public void centerHorizontallyRtl(int r10, int r11) {
        if (r11 != 0) goto L4;
        int r2 = 0;
        int r3 = 6;
        int r4 = 0;
        int r5 = 0;
        int r6 = 7;
        int r7 = 0;
        float r8 = 0.5f;
    L5:
        center(r10, r2, r3, r4, r5, r6, r7, r8);
        return;
    L4:
        r3 = 7;
        r4 = 0;
        r6 = 6;
        r7 = 0;
        r8 = 0.5f;
        r2 = r11;
        r5 = r11;
        goto L5
    }

    public void centerHorizontallyRtl(int r10, int r11, int r12, int r13, int r14, int r15, int r16, float r17) {
        connect(r10, 6, r11, r12, r13);
        connect(r10, 7, r14, r15, r16);
        Constraint r0 = this.mConstraints.get(Integer.valueOf(r10));
        if (r0 == null) goto L6;
        r0.layout.horizontalBias = r17;
        return;
    }

    public void centerVertically(int r10, int r11) {
        if (r11 != 0) goto L4;
        int r2 = 0;
        int r3 = 3;
        int r4 = 0;
        int r5 = 0;
        int r6 = 4;
        int r7 = 0;
        float r8 = 0.5f;
    L5:
        center(r10, r2, r3, r4, r5, r6, r7, r8);
        return;
    L4:
        r3 = 4;
        r4 = 0;
        r6 = 3;
        r7 = 0;
        r8 = 0.5f;
        r2 = r11;
        r5 = r11;
        goto L5
    }

    public void centerVertically(int r10, int r11, int r12, int r13, int r14, int r15, int r16, float r17) {
        connect(r10, 3, r11, r12, r13);
        connect(r10, 4, r14, r15, r16);
        Constraint r0 = this.mConstraints.get(Integer.valueOf(r10));
        if (r0 == null) goto L6;
        r0.layout.verticalBias = r17;
        return;
    }

    public void clear(int r1) {
        this.mConstraints.remove(Integer.valueOf(r1));
    }

    public void clear(int r3, int r4) {
        if (this.mConstraints.containsKey(Integer.valueOf(r3)) == false) goto L20;
        Constraint r2 = this.mConstraints.get(Integer.valueOf(r3));
        if (r2 != null) goto L8;
        return;
    L8:
        switch(r4) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            default: goto L10;
        };
    L11:
        Layout r5 = r2.layout;
        r5.circleAngle = -1.0f;
        r5.circleRadius = -1;
        r5.circleConstraint = -1;
        return;
    L12:
        Layout r6 = r2.layout;
        r6.endToStart = -1;
        r6.endToEnd = -1;
        r6.endMargin = 0;
        r6.goneEndMargin = Integer.MIN_VALUE;
        return;
    L13:
        Layout r7 = r2.layout;
        r7.startToEnd = -1;
        r7.startToStart = -1;
        r7.startMargin = 0;
        r7.goneStartMargin = Integer.MIN_VALUE;
        return;
    L14:
        Layout r8 = r2.layout;
        r8.baselineToBaseline = -1;
        r8.baselineToTop = -1;
        r8.baselineToBottom = -1;
        r8.baselineMargin = 0;
        r8.goneBaselineMargin = Integer.MIN_VALUE;
        return;
    L15:
        Layout r9 = r2.layout;
        r9.bottomToTop = -1;
        r9.bottomToBottom = -1;
        r9.bottomMargin = 0;
        r9.goneBottomMargin = Integer.MIN_VALUE;
        return;
    L16:
        Layout r10 = r2.layout;
        r10.topToBottom = -1;
        r10.topToTop = -1;
        r10.topMargin = 0;
        r10.goneTopMargin = Integer.MIN_VALUE;
        return;
    L17:
        Layout r11 = r2.layout;
        r11.rightToRight = -1;
        r11.rightToLeft = -1;
        r11.rightMargin = -1;
        r11.goneRightMargin = Integer.MIN_VALUE;
        return;
    L18:
        Layout r12 = r2.layout;
        r12.leftToRight = -1;
        r12.leftToLeft = -1;
        r12.leftMargin = -1;
        r12.goneLeftMargin = Integer.MIN_VALUE;
        return;
    L10:
        throw new IllegalArgumentException("unknown constraint");
    }

    public void clone(Context r2, int r3) {
        clone((ConstraintLayout) LayoutInflater.from(r2).inflate(r3, null));
    }

    public void clone(ConstraintLayout r12) {
        int r0 = r12.getChildCount();
        this.mConstraints.clear();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L33;
        View r2 = r12.getChildAt(r1);
        ConstraintLayout.LayoutParams r3 = (ConstraintLayout.LayoutParams) r2.getLayoutParams();
        int r4 = r2.getId();
        if (this.mForceId == false) goto L12;
        if (r4 != (-1)) goto L12;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L12:
        if (this.mConstraints.containsKey(Integer.valueOf(r4)) == true) goto L14;
        this.mConstraints.put(Integer.valueOf(r4), new Constraint());
    L14:
        Constraint r5 = this.mConstraints.get(Integer.valueOf(r4));
        if (r5 == null) goto L32;
        r5.mCustomConstraints = ConstraintAttribute.extractAttributes(this.mSavedAttributes, r2);
        Constraint.access$000(r5, r4, r3);
        r5.propertySet.visibility = r2.getVisibility();
        int r6 = Build.VERSION.SDK_INT;
        if (r6 < 17) goto L30;
        r5.propertySet.alpha = r2.getAlpha();
        r5.transform.rotation = r2.getRotation();
        r5.transform.rotationX = r2.getRotationX();
        r5.transform.rotationY = r2.getRotationY();
        r5.transform.scaleX = r2.getScaleX();
        r5.transform.scaleY = r2.getScaleY();
        float r7 = r2.getPivotX();
        float r8 = r2.getPivotY();
        if (r7 == 0.0d) goto L22;
    L23:
        Transform r9 = r5.transform;
        r9.transformPivotX = r7;
        r9.transformPivotY = r8;
    L24:
        r5.transform.translationX = r2.getTranslationX();
        r5.transform.translationY = r2.getTranslationY();
        if (r6 < 21) goto L30;
        r5.transform.translationZ = r2.getTranslationZ();
        Transform r10 = r5.transform;
        if (r10.applyElevation == false) goto L30;
        r10.elevation = r2.getElevation();
        goto L30
    L22:
        if (r8 == 0.0d) goto L24;
    L30:
        if ((r2 instanceof Barrier) == false) goto L32;
        Barrier r11 = (Barrier) r2;
        r5.layout.mBarrierAllowsGoneWidgets = r11.getAllowsGoneWidget();
        r5.layout.mReferenceIds = r11.getReferencedIds();
        r5.layout.mBarrierDirection = r11.getType();
        r5.layout.mBarrierMargin = r11.getMargin();
    L32:
        r1 = r1 + 1;
        goto L3
    }

    public void clone(ConstraintSet r5) {
        this.mConstraints.clear();
        Iterator<Integer> r0 = r5.mConstraints.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Integer r1 = r0.next();
        Constraint r2 = r5.mConstraints.get(r1);
        if (r2 == null) goto L4;
        this.mConstraints.put(r1, r2.clone());
        goto L4
    }

    public void clone(Constraints r9) {
        int r0 = r9.getChildCount();
        this.mConstraints.clear();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L22;
        View r2 = r9.getChildAt(r1);
        Constraints.LayoutParams r3 = (Constraints.LayoutParams) r2.getLayoutParams();
        int r4 = r2.getId();
        if (this.mForceId == false) goto L12;
        if (r4 != (-1)) goto L12;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L12:
        if (this.mConstraints.containsKey(Integer.valueOf(r4)) == true) goto L14;
        this.mConstraints.put(Integer.valueOf(r4), new Constraint());
    L14:
        Constraint r5 = this.mConstraints.get(Integer.valueOf(r4));
        if (r5 == null) goto L21;
        if ((r2 instanceof ConstraintHelper) == false) goto L20;
        Constraint.access$700(r5, (ConstraintHelper) r2, r4, r3);
    L20:
        Constraint.access$800(r5, r4, r3);
    L21:
        r1 = r1 + 1;
        goto L3
    }

    public void connect(int r10, int r11, int r12, int r13) {
        if (this.mConstraints.containsKey(Integer.valueOf(r10)) == true) goto L5;
        this.mConstraints.put(Integer.valueOf(r10), new Constraint());
    L5:
        Constraint r14 = this.mConstraints.get(Integer.valueOf(r10));
        if (r14 != null) goto L9;
        return;
    L9:
        switch(r11) {
            case 1: goto L53;
            case 2: goto L47;
            case 3: goto L40;
            case 4: goto L34;
            case 5: goto L25;
            case 6: goto L18;
            case 7: goto L12;
            default: goto L11;
        };
    L12:
        if (r13 != 7) goto L14;
        Layout r9 = r14.layout;
        r9.endToEnd = r12;
        r9.endToStart = -1;
        return;
    L14:
        if (r13 != 6) goto L17;
        Layout r15 = r14.layout;
        r15.endToStart = r12;
        r15.endToEnd = -1;
        return;
    L17:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L18:
        if (r13 != 6) goto L20;
        Layout r16 = r14.layout;
        r16.startToStart = r12;
        r16.startToEnd = -1;
        return;
    L20:
        if (r13 != 7) goto L23;
        Layout r17 = r14.layout;
        r17.startToEnd = r12;
        r17.startToStart = -1;
        return;
    L23:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L34:
        if (r13 != 4) goto L36;
        Layout r18 = r14.layout;
        r18.bottomToBottom = r12;
        r18.bottomToTop = -1;
    L42:
        r18.baselineToBaseline = -1;
        r18.baselineToTop = -1;
        r18.baselineToBottom = -1;
        return;
    L36:
        if (r13 != 3) goto L39;
        r18 = r14.layout;
        r18.bottomToTop = r12;
        r18.bottomToBottom = -1;
        goto L42
    L39:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L40:
        if (r13 != 3) goto L43;
        r18 = r14.layout;
        r18.topToTop = r12;
        r18.topToBottom = -1;
        goto L42
    L43:
        if (r13 != 4) goto L46;
        r18 = r14.layout;
        r18.topToBottom = r12;
        r18.topToTop = -1;
        goto L42
    L46:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L47:
        if (r13 != 1) goto L49;
        Layout r19 = r14.layout;
        r19.rightToLeft = r12;
        r19.rightToRight = -1;
        return;
    L49:
        if (r13 != 2) goto L52;
        Layout r20 = r14.layout;
        r20.rightToRight = r12;
        r20.rightToLeft = -1;
        return;
    L52:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L53:
        if (r13 != 1) goto L55;
        Layout r21 = r14.layout;
        r21.leftToLeft = r12;
        r21.leftToRight = -1;
        return;
    L55:
        if (r13 != 2) goto L59;
        Layout r22 = r14.layout;
        r22.leftToRight = r12;
        r22.leftToLeft = -1;
        return;
    L59:
        throw new IllegalArgumentException("left to " + sideToString(r13) + " undefined");
    L11:
        throw new IllegalArgumentException(sideToString(r11) + " to " + sideToString(r13) + " unknown");
    L25:
        if (r13 != 5) goto L28;
        Layout r23 = r14.layout;
        r23.baselineToBaseline = r12;
    L27:
        r23.bottomToBottom = -1;
        r23.bottomToTop = -1;
        r23.topToTop = -1;
        r23.topToBottom = -1;
        return;
    L28:
        if (r13 != 3) goto L30;
        r23 = r14.layout;
        r23.baselineToTop = r12;
        goto L27
    L30:
        if (r13 != 4) goto L33;
        r23 = r14.layout;
        r23.baselineToBottom = r12;
        goto L27
    L33:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    }

    public void connect(int r10, int r11, int r12, int r13, int r14) {
        if (this.mConstraints.containsKey(Integer.valueOf(r10)) == true) goto L5;
        this.mConstraints.put(Integer.valueOf(r10), new Constraint());
    L5:
        Constraint r15 = this.mConstraints.get(Integer.valueOf(r10));
        if (r15 != null) goto L9;
        return;
    L9:
        switch(r11) {
            case 1: goto L59;
            case 2: goto L52;
            case 3: goto L44;
            case 4: goto L36;
            case 5: goto L27;
            case 6: goto L19;
            case 7: goto L12;
            default: goto L11;
        };
    L12:
        if (r13 != 7) goto L14;
        Layout r9 = r15.layout;
        r9.endToEnd = r12;
        r9.endToStart = -1;
    L16:
        r15.layout.endMargin = r14;
        return;
    L14:
        if (r13 != 6) goto L18;
        Layout r16 = r15.layout;
        r16.endToStart = r12;
        r16.endToEnd = -1;
        goto L16
    L18:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L19:
        if (r13 != 6) goto L21;
        Layout r17 = r15.layout;
        r17.startToStart = r12;
        r17.startToEnd = -1;
    L23:
        r15.layout.startMargin = r14;
        return;
    L21:
        if (r13 != 7) goto L25;
        Layout r18 = r15.layout;
        r18.startToEnd = r12;
        r18.startToStart = -1;
        goto L23
    L25:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L36:
        if (r13 != 4) goto L39;
        Layout r19 = r15.layout;
        r19.bottomToBottom = r12;
        r19.bottomToTop = -1;
    L38:
        r19.baselineToBaseline = -1;
        r19.baselineToTop = -1;
        r19.baselineToBottom = -1;
        r15.layout.bottomMargin = r14;
        return;
    L39:
        if (r13 != 3) goto L43;
        r19 = r15.layout;
        r19.bottomToTop = r12;
        r19.bottomToBottom = -1;
        goto L38
    L43:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L44:
        if (r13 != 3) goto L47;
        Layout r20 = r15.layout;
        r20.topToTop = r12;
        r20.topToBottom = -1;
    L46:
        r20.baselineToBaseline = -1;
        r20.baselineToTop = -1;
        r20.baselineToBottom = -1;
        r15.layout.topMargin = r14;
        return;
    L47:
        if (r13 != 4) goto L51;
        r20 = r15.layout;
        r20.topToBottom = r12;
        r20.topToTop = -1;
        goto L46
    L51:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L52:
        if (r13 != 1) goto L54;
        Layout r21 = r15.layout;
        r21.rightToLeft = r12;
        r21.rightToRight = -1;
    L56:
        r15.layout.rightMargin = r14;
        return;
    L54:
        if (r13 != 2) goto L58;
        Layout r22 = r15.layout;
        r22.rightToRight = r12;
        r22.rightToLeft = -1;
        goto L56
    L58:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L59:
        if (r13 != 1) goto L61;
        Layout r23 = r15.layout;
        r23.leftToLeft = r12;
        r23.leftToRight = -1;
    L63:
        r15.layout.leftMargin = r14;
        return;
    L61:
        if (r13 != 2) goto L66;
        Layout r24 = r15.layout;
        r24.leftToRight = r12;
        r24.leftToLeft = -1;
        goto L63
    L66:
        throw new IllegalArgumentException("Left to " + sideToString(r13) + " undefined");
    L11:
        throw new IllegalArgumentException(sideToString(r11) + " to " + sideToString(r13) + " unknown");
    L27:
        if (r13 != 5) goto L30;
        Layout r25 = r15.layout;
        r25.baselineToBaseline = r12;
    L29:
        r25.bottomToBottom = -1;
        r25.bottomToTop = -1;
        r25.topToTop = -1;
        r25.topToBottom = -1;
        return;
    L30:
        if (r13 != 3) goto L32;
        r25 = r15.layout;
        r25.baselineToTop = r12;
        goto L29
    L32:
        if (r13 != 4) goto L35;
        r25 = r15.layout;
        r25.baselineToBottom = r12;
        goto L29
    L35:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    }

    public void constrainCircle(int r1, int r2, int r3, float r4) {
        Layout r0 = get(r1).layout;
        r0.circleConstraint = r2;
        r0.circleRadius = r3;
        r0.circleAngle = r4;
    }

    public void constrainDefaultHeight(int r1, int r2) {
        get(r1).layout.heightDefault = r2;
    }

    public void constrainDefaultWidth(int r1, int r2) {
        get(r1).layout.widthDefault = r2;
    }

    public void constrainHeight(int r1, int r2) {
        get(r1).layout.mHeight = r2;
    }

    public void constrainMaxHeight(int r1, int r2) {
        get(r1).layout.heightMax = r2;
    }

    public void constrainMaxWidth(int r1, int r2) {
        get(r1).layout.widthMax = r2;
    }

    public void constrainMinHeight(int r1, int r2) {
        get(r1).layout.heightMin = r2;
    }

    public void constrainMinWidth(int r1, int r2) {
        get(r1).layout.widthMin = r2;
    }

    public void constrainPercentHeight(int r1, float r2) {
        get(r1).layout.heightPercent = r2;
    }

    public void constrainPercentWidth(int r1, float r2) {
        get(r1).layout.widthPercent = r2;
    }

    public void constrainWidth(int r1, int r2) {
        get(r1).layout.mWidth = r2;
    }

    public void constrainedHeight(int r1, boolean r2) {
        get(r1).layout.constrainedHeight = r2;
    }

    public void constrainedWidth(int r1, boolean r2) {
        get(r1).layout.constrainedWidth = r2;
    }

    public void create(int r1, int r2) {
        Layout r0 = get(r1).layout;
        r0.mIsGuideline = true;
        r0.orientation = r2;
    }

    public void createBarrier(int r1, int r2, int r3, int... r4) {
        Layout r0 = get(r1).layout;
        r0.mHelperType = 1;
        r0.mBarrierDirection = r2;
        r0.mBarrierMargin = r3;
        r0.mIsGuideline = false;
        r0.mReferenceIds = r4;
    }

    public void createHorizontalChain(int r11, int r12, int r13, int r14, int[] r15, float[] r16, int r17) {
        createHorizontalChain(r11, r12, r13, r14, r15, r16, r17, 1, 2);
    }

    public void createHorizontalChainRtl(int r11, int r12, int r13, int r14, int[] r15, float[] r16, int r17) {
        createHorizontalChain(r11, r12, r13, r14, r15, r16, r17, 6, 7);
    }

    public void createVerticalChain(int r13, int r14, int r15, int r16, int[] r17, float[] r18, int r19) {
        if (r17.length < 2) goto L23;
        if (r18 == null) goto L11;
        if (r18.length == r17.length) goto L11;
        throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    L11:
        if (r18 == null) goto L13;
        get(r17[0]).layout.verticalWeight = r18[0];
    L13:
        get(r17[0]).layout.verticalChainStyle = r19;
        connect(r17[0], 3, r13, r14, 0);
        int r10 = 1;
    L15:
        if (r10 >= r17.length) goto L20;
        int r0 = r17[r10];
        int r11 = r10 - 1;
        connect(r17[r10], 3, r17[r11], 4, 0);
        connect(r17[r11], 4, r17[r10], 3, 0);
        if (r18 == null) goto L19;
        get(r17[r10]).layout.verticalWeight = r18[r10];
    L19:
        r10 = r10 + 1;
        goto L15
    L20:
        connect(r17[r17.length - 1], 4, r15, r16, 0);
        return;
    L23:
        throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    }

    public void dump(MotionScene r7, int... r8) {
        Set<Integer> r0 = this.mConstraints.keySet();
        int r2 = 0;
        if (r8.length == 0) goto L7;
        HashSet r1 = new HashSet();
        int r3 = r8.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L8;
        r1.add(Integer.valueOf(r8[r4]));
        r4 = r4 + 1;
    L8:
        System.out.println(r1.size() + " constraints");
        StringBuilder r9 = new StringBuilder();
        Integer[] r5 = (Integer[]) r1.toArray(new Integer[0]);
        int r6 = r5.length;
    L9:
        if (r2 >= r6) goto L15;
        Integer r10 = r5[r2];
        Constraint r11 = this.mConstraints.get(r10);
        if (r11 == null) goto L14;
        r9.append("<Constraint id=");
        r9.append(r10);
        r9.append(" \n");
        r11.layout.dump(r7, r9);
        r9.append("/>\n");
    L14:
        r2 = r2 + 1;
        goto L9
    L15:
        System.out.println(r9.toString());
        return;
    L7:
        r1 = new HashSet(r0);
        goto L8
    }

    public boolean getApplyElevation(int r1) {
        return get(r1).transform.applyElevation;
    }

    public Constraint getConstraint(int r3) {
        if (this.mConstraints.containsKey(Integer.valueOf(r3)) == true) goto L5;
        return null;
    L5:
        return this.mConstraints.get(Integer.valueOf(r3));
    }

    public HashMap<String, ConstraintAttribute> getCustomAttributeSet() {
        return this.mSavedAttributes;
    }

    public int getHeight(int r1) {
        return get(r1).layout.mHeight;
    }

    public int[] getKnownIds() {
        int r0 = 0;
        Integer[] r4 = (Integer[]) this.mConstraints.keySet().toArray(new Integer[0]);
        int r1 = r4.length;
        int[] r2 = new int[r1];
    L3:
        if (r0 >= r1) goto L5;
        r2[r0] = r4[r0].intValue();
        r0 = r0 + 1;
        goto L3
    L5:
        return r2;
    }

    public Constraint getParameters(int r1) {
        return get(r1);
    }

    public int[] getReferencedIds(int r1) {
        int[] r0 = get(r1).layout.mReferenceIds;
        if (r0 != null) goto L7;
        return new int[0];
    L7:
        return Arrays.copyOf(r0, r0.length);
    }

    public int getVisibility(int r1) {
        return get(r1).propertySet.visibility;
    }

    public int getVisibilityMode(int r1) {
        return get(r1).propertySet.mVisibilityMode;
    }

    public int getWidth(int r1) {
        return get(r1).layout.mWidth;
    }

    public boolean isForceId() {
        return this.mForceId;
    }

    public void load(Context r5, int r6) {
        XmlResourceParser r7 = r5.getResources().getXml(r6);
        int r0 = r7.getEventType();     // Catch: IOException -> L17 XmlPullParserException -> L19
    L5:
        if (r0 == 1) goto L30;
        if (r0 != 0) goto L8;
        r7.getName();     // Catch: IOException -> L17 XmlPullParserException -> L19
    L15:
        r0 = r7.next();     // Catch: IOException -> L17 XmlPullParserException -> L19
    L8:
        if (r0 != 2) goto L15;
        String r1 = r7.getName();     // Catch: IOException -> L17 XmlPullParserException -> L19
        Constraint r2 = fillFromAttributeList(r5, Xml.asAttributeSet(r7), false);     // Catch: IOException -> L17 XmlPullParserException -> L19
        if (r1.equalsIgnoreCase("Guideline") == false) goto L13;
        r2.layout.mIsGuideline = true;     // Catch: IOException -> L17 XmlPullParserException -> L19
    L13:
        this.mConstraints.put(Integer.valueOf(r2.mViewId), r2);     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L15
    L30:
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
    }

    public void load(Context r10, XmlPullParser r11) {
        int r0 = r11.getEventType();     // Catch: IOException -> L96 XmlPullParserException -> L98
        Constraint r2 = null;
    L4:
        if (r0 == 1) goto L121;
        if (r0 == 0) goto L93;
        byte r4 = -1;
        if (r0 == 2) goto L32;
        if (r0 != 3) goto L94;
        String r1 = r11.getName().toLowerCase(Locale.ROOT);     // Catch: IOException -> L96 XmlPullParserException -> L98
        switch(r1.hashCode()) {
            case -2075718416: goto L23;
            case -190376483: goto L20;
            case 426575017: goto L17;
            case 2146106725: goto L14;
            default: goto L25;
        };     // Catch: IOException -> L96 XmlPullParserException -> L98
    L25:
        if (r4 == 0) goto L31;
        if (r4 == 1) goto L30;
        if (r4 == 2) goto L30;
        if (r4 != 3) goto L94;
    L30:
        this.mConstraints.put(Integer.valueOf(r2.mViewId), r2);     // Catch: IOException -> L96 XmlPullParserException -> L98
        r2 = null;
        goto L94
    L31:
        return;
    L14:
        if (r1.equals("constraintset") == false) goto L25;
        r4 = 0;
        goto L25
    L17:
        if (r1.equals("constraintoverride") == false) goto L25;
        r4 = 2;
        goto L25
    L20:
        if (r1.equals("constraint") == false) goto L25;
        r4 = 1;
        goto L25
    L23:
        if (r1.equals("guideline") == false) goto L25;
        r4 = 3;
    L94:
        r0 = r11.next();     // Catch: IOException -> L96 XmlPullParserException -> L98
        goto L4
    L32:
        String r3 = r11.getName();     // Catch: IOException -> L96 XmlPullParserException -> L98
        switch(r3.hashCode()) {
            case -2025855158: goto L63;
            case -1984451626: goto L60;
            case -1962203927: goto L57;
            case -1269513683: goto L54;
            case -1238332596: goto L51;
            case -71750448: goto L48;
            case 366511058: goto L45;
            case 1331510167: goto L42;
            case 1791837707: goto L39;
            case 1803088381: goto L36;
            default: goto L66;
        };     // Catch: IOException -> L96 XmlPullParserException -> L98
    L66:
        switch(r4) {
            case 0: goto L91;
            case 1: goto L90;
            case 2: goto L89;
            case 3: goto L88;
            case 4: goto L84;
            case 5: goto L80;
            case 6: goto L76;
            case 7: goto L72;
            case 8: goto L68;
            case 9: goto L68;
            default: goto L94;
        };
    L68:
        if (r2 == null) goto L71;
        ConstraintAttribute.parse(r10, r11, r2.mCustomConstraints);     // Catch: IOException -> L96 XmlPullParserException -> L98
        goto L94
    L71:
        throw new RuntimeException(ERROR_MESSAGE + r11.getLineNumber());     // Catch: IOException -> L96 XmlPullParserException -> L98
    L72:
        if (r2 == null) goto L75;
        r2.motion.fillFromAttributeList(r10, Xml.asAttributeSet(r11));     // Catch: IOException -> L96 XmlPullParserException -> L98
        goto L94
    L75:
        throw new RuntimeException(ERROR_MESSAGE + r11.getLineNumber());     // Catch: IOException -> L96 XmlPullParserException -> L98
    L76:
        if (r2 == null) goto L79;
        r2.layout.fillFromAttributeList(r10, Xml.asAttributeSet(r11));     // Catch: IOException -> L96 XmlPullParserException -> L98
        goto L94
    L79:
        throw new RuntimeException(ERROR_MESSAGE + r11.getLineNumber());     // Catch: IOException -> L96 XmlPullParserException -> L98
    L80:
        if (r2 == null) goto L83;
        r2.transform.fillFromAttributeList(r10, Xml.asAttributeSet(r11));     // Catch: IOException -> L96 XmlPullParserException -> L98
        goto L94
    L83:
        throw new RuntimeException(ERROR_MESSAGE + r11.getLineNumber());     // Catch: IOException -> L96 XmlPullParserException -> L98
    L84:
        if (r2 == null) goto L87;
        r2.propertySet.fillFromAttributeList(r10, Xml.asAttributeSet(r11));     // Catch: IOException -> L96 XmlPullParserException -> L98
        goto L94
    L87:
        throw new RuntimeException(ERROR_MESSAGE + r11.getLineNumber());     // Catch: IOException -> L96 XmlPullParserException -> L98
    L88:
        Constraint r5 = fillFromAttributeList(r10, Xml.asAttributeSet(r11), false);     // Catch: IOException -> L96 XmlPullParserException -> L98
        r5.layout.mHelperType = 1;     // Catch: IOException -> L96 XmlPullParserException -> L98
    L92:
        r2 = r5;
        goto L94
    L89:
        r5 = fillFromAttributeList(r10, Xml.asAttributeSet(r11), false);     // Catch: IOException -> L96 XmlPullParserException -> L98
        Layout r6 = r5.layout;     // Catch: IOException -> L96 XmlPullParserException -> L98
        r6.mIsGuideline = true;     // Catch: IOException -> L96 XmlPullParserException -> L98
        r6.mApply = true;     // Catch: IOException -> L96 XmlPullParserException -> L98
        goto L92
    L90:
        r5 = fillFromAttributeList(r10, Xml.asAttributeSet(r11), true);     // Catch: IOException -> L96 XmlPullParserException -> L98
        goto L92
    L91:
        r5 = fillFromAttributeList(r10, Xml.asAttributeSet(r11), false);     // Catch: IOException -> L96 XmlPullParserException -> L98
        goto L92
    L36:
        if (r3.equals("Constraint") == false) goto L66;
        r4 = 0;
        goto L66
    L39:
        if (r3.equals(ViewTransition.CUSTOM_ATTRIBUTE) == false) goto L66;
        r4 = 8;
        goto L66
    L42:
        if (r3.equals("Barrier") == false) goto L66;
        r4 = 3;
        goto L66
    L45:
        if (r3.equals(ViewTransition.CUSTOM_METHOD) == false) goto L66;
        r4 = 9;
        goto L66
    L48:
        if (r3.equals("Guideline") == false) goto L66;
        r4 = 2;
        goto L66
    L51:
        if (r3.equals("Transform") == false) goto L66;
        r4 = 5;
        goto L66
    L54:
        if (r3.equals("PropertySet") == false) goto L66;
        r4 = 4;
        goto L66
    L57:
        if (r3.equals(ViewTransition.CONSTRAINT_OVERRIDE) == false) goto L66;
        r4 = 1;
        goto L66
    L60:
        if (r3.equals(TypedValues.MotionType.NAME) == false) goto L66;
        r4 = 7;
        goto L66
    L63:
        if (r3.equals("Layout") == false) goto L66;
        r4 = 6;
        goto L66
    L93:
        r11.getName();     // Catch: IOException -> L96 XmlPullParserException -> L98
        goto L94
    L121:
        return;
    L96:
        e = move-exception;
        e.printStackTrace();
        return;
    L98:
        e = move-exception;
        e.printStackTrace();
    }

    public void parseColorAttributes(Constraint r5, String r6) {
        String[] r4 = r6.split(",");
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L10;
        String[] r1 = r4[r0].split("=");
        if (r1.length == 2) goto L8;
        Log.w(TAG, " Unable to parse " + r4[r0]);
    L9:
        r0 = r0 + 1;
        goto L4
    L8:
        Constraint.access$1000(r5, r1[0], Color.parseColor(r1[1]));
        goto L9
    }

    public void parseFloatAttributes(Constraint r5, String r6) {
        String[] r4 = r6.split(",");
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L10;
        String[] r1 = r4[r0].split("=");
        if (r1.length == 2) goto L8;
        Log.w(TAG, " Unable to parse " + r4[r0]);
    L9:
        r0 = r0 + 1;
        goto L4
    L8:
        Constraint.access$1100(r5, r1[0], Float.parseFloat(r1[1]));
        goto L9
    }

    public void parseIntAttributes(Constraint r5, String r6) {
        String[] r4 = r6.split(",");
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L10;
        String[] r1 = r4[r0].split("=");
        if (r1.length == 2) goto L8;
        Log.w(TAG, " Unable to parse " + r4[r0]);
    L9:
        r0 = r0 + 1;
        goto L4
    L8:
        Constraint.access$1100(r5, r1[0], Integer.decode(r1[1]).intValue());
        goto L9
    }

    public void parseStringAttributes(Constraint r5, String r6) {
        String[] r4 = splitString(r6);
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L6;
        String[] r1 = r4[r0].split("=");
        Log.w(TAG, " Unable to parse " + r4[r0]);
        Constraint.access$1200(r5, r1[0], r1[1]);
        r0 = r0 + 1;
        goto L4
    }

    public void readFallback(ConstraintLayout r12) {
        int r0 = r12.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L43;
        View r2 = r12.getChildAt(r1);
        ConstraintLayout.LayoutParams r3 = (ConstraintLayout.LayoutParams) r2.getLayoutParams();
        int r4 = r2.getId();
        if (this.mForceId == false) goto L12;
        if (r4 != (-1)) goto L12;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L12:
        if (this.mConstraints.containsKey(Integer.valueOf(r4)) == true) goto L14;
        this.mConstraints.put(Integer.valueOf(r4), new Constraint());
    L14:
        Constraint r5 = this.mConstraints.get(Integer.valueOf(r4));
        if (r5 == null) goto L42;
        if (r5.layout.mApply == true) goto L25;
        Constraint.access$000(r5, r4, r3);
        if ((r2 instanceof ConstraintHelper) == false) goto L24;
        r5.layout.mReferenceIds = ((ConstraintHelper) r2).getReferencedIds();
        if ((r2 instanceof Barrier) == false) goto L24;
        Barrier r6 = (Barrier) r2;
        r5.layout.mBarrierAllowsGoneWidgets = r6.getAllowsGoneWidget();
        r5.layout.mBarrierDirection = r6.getType();
        r5.layout.mBarrierMargin = r6.getMargin();
    L24:
        r5.layout.mApply = true;
    L25:
        PropertySet r7 = r5.propertySet;
        if (r7.mApply == true) goto L28;
        r7.visibility = r2.getVisibility();
        r5.propertySet.alpha = r2.getAlpha();
        r5.propertySet.mApply = true;
    L28:
        int r8 = Build.VERSION.SDK_INT;
        if (r8 < 17) goto L42;
        Transform r9 = r5.transform;
        if (r9.mApply == true) goto L42;
        r9.mApply = true;
        r9.rotation = r2.getRotation();
        r5.transform.rotationX = r2.getRotationX();
        r5.transform.rotationY = r2.getRotationY();
        r5.transform.scaleX = r2.getScaleX();
        r5.transform.scaleY = r2.getScaleY();
        float r10 = r2.getPivotX();
        float r11 = r2.getPivotY();
        if (r10 == 0.0d) goto L35;
    L36:
        Transform r13 = r5.transform;
        r13.transformPivotX = r10;
        r13.transformPivotY = r11;
    L37:
        r5.transform.translationX = r2.getTranslationX();
        r5.transform.translationY = r2.getTranslationY();
        if (r8 < 21) goto L42;
        r5.transform.translationZ = r2.getTranslationZ();
        Transform r14 = r5.transform;
        if (r14.applyElevation == false) goto L42;
        r14.elevation = r2.getElevation();
        goto L42
    L35:
        if (r11 == 0.0d) goto L37;
    L42:
        r1 = r1 + 1;
        goto L3
    }

    public void readFallback(ConstraintSet r8) {
        Iterator<Integer> r0 = r8.mConstraints.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L29;
        Integer r1 = r0.next();
        int r2 = r1.intValue();
        Constraint r3 = r8.mConstraints.get(r1);
        if (this.mConstraints.containsKey(Integer.valueOf(r2)) == true) goto L8;
        this.mConstraints.put(Integer.valueOf(r2), new Constraint());
    L8:
        Constraint r4 = this.mConstraints.get(Integer.valueOf(r2));
        if (r4 == null) goto L4;
        Layout r5 = r4.layout;
        if (r5.mApply == true) goto L14;
        r5.copyFrom(r3.layout);
    L14:
        PropertySet r6 = r4.propertySet;
        if (r6.mApply == true) goto L17;
        r6.copyFrom(r3.propertySet);
    L17:
        Transform r7 = r4.transform;
        if (r7.mApply == true) goto L20;
        r7.copyFrom(r3.transform);
    L20:
        Motion r9 = r4.motion;
        if (r9.mApply == true) goto L23;
        r9.copyFrom(r3.motion);
    L23:
        Iterator<String> r10 = r3.mCustomConstraints.keySet().iterator();
    L25:
        if (r10.hasNext() == false) goto L4;
        String r11 = r10.next();
        if (r4.mCustomConstraints.containsKey(r11) == true) goto L25;
        r4.mCustomConstraints.put(r11, r3.mCustomConstraints.get(r11));
        goto L25
    }

    public void removeAttribute(String r1) {
        this.mSavedAttributes.remove(r1);
    }

    public void removeFromHorizontalChain(int r9) {
        if (this.mConstraints.containsKey(Integer.valueOf(r9)) == false) goto L39;
        Constraint r0 = this.mConstraints.get(Integer.valueOf(r9));
        if (r0 != null) goto L7;
        return;
    L7:
        Layout r1 = r0.layout;
        int r6 = r1.leftToRight;
        int r7 = r1.rightToLeft;
        if (r6 != (-1)) goto L26;
        if (r7 != (-1)) goto L26;
        int r2 = r1.startToEnd;
        int r8 = r1.endToStart;
        if (r2 != (-1)) goto L14;
        if (r8 != (-1)) goto L14;
    L25:
        clear(r9, 6);
        int r3 = 7;
    L37:
        clear(r9, r3);
        return;
    L14:
        if (r2 == (-1)) goto L18;
        if (r8 == (-1)) goto L18;
        int r5 = 0;
        ConstraintSet r4 = this;
        r4.connect(r2, 7, r8, 6, 0);
        int r10 = 6;
        int r11 = 7;
        int r12 = r8;
        int r13 = r6;
    L17:
        r4.connect(r12, r10, r13, r11, r5);
    L18:
        if (r8 == (-1)) goto L25;
        r13 = r1.rightToRight;
        if (r13 == (-1)) goto L22;
        r10 = 7;
        r11 = 7;
        r5 = 0;
        r4 = this;
        r12 = r6;
        goto L17
    L22:
        r13 = r1.leftToLeft;
        if (r13 == (-1)) goto L25;
        r10 = 6;
        r11 = 6;
        r5 = 0;
        r4 = this;
        r12 = r8;
    L26:
        if (r6 == (-1)) goto L29;
        if (r7 == (-1)) goto L29;
        int r14 = 0;
        ConstraintSet r15 = this;
        r15.connect(r6, 2, r7, 1, 0);
        int r16 = 1;
        int r17 = 2;
        int r18 = r7;
        int r19 = r6;
    L32:
        r15.connect(r18, r16, r19, r17, r14);
    L36:
        clear(r9, 1);
        r3 = 2;
    L29:
        r19 = r1.rightToRight;
        if (r19 == (-1)) goto L33;
        r16 = 2;
        r17 = 2;
        r14 = 0;
        r15 = this;
        r18 = r6;
        goto L32
    L33:
        r19 = r1.leftToLeft;
        if (r19 == (-1)) goto L36;
        r16 = 1;
        r17 = 1;
        r14 = 0;
        r15 = this;
        r18 = r7;
        goto L32
    }

    public void removeFromVerticalChain(int r10) {
        if (this.mConstraints.containsKey(Integer.valueOf(r10)) == false) goto L20;
        Constraint r0 = this.mConstraints.get(Integer.valueOf(r10));
        if (r0 != null) goto L7;
        return;
    L7:
        Layout r1 = r0.layout;
        int r7 = r1.topToBottom;
        int r8 = r1.bottomToTop;
        if (r7 != (-1)) goto L10;
        if (r8 == (-1)) goto L20;
    L10:
        if (r7 == (-1)) goto L13;
        if (r8 == (-1)) goto L13;
        int r6 = 0;
        ConstraintSet r2 = this;
        r2.connect(r7, 4, r8, 3, 0);
        int r3 = 3;
        int r5 = 4;
        int r4 = r8;
        int r9 = r7;
    L16:
        r2.connect(r4, r3, r9, r5, r6);
    L13:
        r9 = r1.bottomToBottom;
        if (r9 == (-1)) goto L17;
        r3 = 4;
        r5 = 4;
        r6 = 0;
        r2 = this;
        r4 = r7;
        goto L16
    L17:
        r9 = r1.topToTop;
        if (r9 == (-1)) goto L20;
        r3 = 3;
        r5 = 3;
        r6 = 0;
        r2 = this;
        r4 = r8;
    L20:
        clear(r10, 3);
        clear(r10, 4);
    }

    public void setAlpha(int r1, float r2) {
        get(r1).propertySet.alpha = r2;
    }

    public void setApplyElevation(int r3, boolean r4) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        get(r3).transform.applyElevation = r4;
        return;
    }

    public void setBarrierType(int r1, int r2) {
        get(r1).layout.mHelperType = r2;
    }

    public void setColorValue(int r1, String r2, int r3) {
        Constraint.access$1000(get(r1), r2, r3);
    }

    public void setDimensionRatio(int r1, String r2) {
        get(r1).layout.dimensionRatio = r2;
    }

    public void setEditorAbsoluteX(int r1, int r2) {
        get(r1).layout.editorAbsoluteX = r2;
    }

    public void setEditorAbsoluteY(int r1, int r2) {
        get(r1).layout.editorAbsoluteY = r2;
    }

    public void setElevation(int r3, float r4) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        get(r3).transform.elevation = r4;
        get(r3).transform.applyElevation = true;
        return;
    }

    public void setFloatValue(int r1, String r2, float r3) {
        Constraint.access$1100(get(r1), r2, r3);
    }

    public void setForceId(boolean r1) {
        this.mForceId = r1;
    }

    public void setGoneMargin(int r1, int r2, int r3) {
        Constraint r0 = get(r1);
        switch(r2) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        r0.layout.goneEndMargin = r3;
        return;
    L7:
        r0.layout.goneStartMargin = r3;
        return;
    L8:
        r0.layout.goneBaselineMargin = r3;
        return;
    L9:
        r0.layout.goneBottomMargin = r3;
        return;
    L10:
        r0.layout.goneTopMargin = r3;
        return;
    L11:
        r0.layout.goneRightMargin = r3;
        return;
    L12:
        r0.layout.goneLeftMargin = r3;
        return;
    L5:
        throw new IllegalArgumentException("unknown constraint");
    }

    public void setGuidelineBegin(int r2, int r3) {
        get(r2).layout.guideBegin = r3;
        get(r2).layout.guideEnd = -1;
        get(r2).layout.guidePercent = -1.0f;
    }

    public void setGuidelineEnd(int r2, int r3) {
        get(r2).layout.guideEnd = r3;
        get(r2).layout.guideBegin = -1;
        get(r2).layout.guidePercent = -1.0f;
    }

    public void setGuidelinePercent(int r2, float r3) {
        get(r2).layout.guidePercent = r3;
        get(r2).layout.guideEnd = -1;
        get(r2).layout.guideBegin = -1;
    }

    public void setHorizontalBias(int r1, float r2) {
        get(r1).layout.horizontalBias = r2;
    }

    public void setHorizontalChainStyle(int r1, int r2) {
        get(r1).layout.horizontalChainStyle = r2;
    }

    public void setHorizontalWeight(int r1, float r2) {
        get(r1).layout.horizontalWeight = r2;
    }

    public void setIntValue(int r1, String r2, int r3) {
        Constraint.access$900(get(r1), r2, r3);
    }

    public void setLayoutWrapBehavior(int r2, int r3) {
        if (r3 >= 0) goto L4;
        return;
    L4:
        if (r3 > 3) goto L8;
        get(r2).layout.mWrapBehavior = r3;
        return;
    }

    public void setMargin(int r1, int r2, int r3) {
        Constraint r0 = get(r1);
        switch(r2) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        r0.layout.endMargin = r3;
        return;
    L7:
        r0.layout.startMargin = r3;
        return;
    L8:
        r0.layout.baselineMargin = r3;
        return;
    L9:
        r0.layout.bottomMargin = r3;
        return;
    L10:
        r0.layout.topMargin = r3;
        return;
    L11:
        r0.layout.rightMargin = r3;
        return;
    L12:
        r0.layout.leftMargin = r3;
        return;
    L5:
        throw new IllegalArgumentException("unknown constraint");
    }

    public void setReferencedIds(int r1, int... r2) {
        get(r1).layout.mReferenceIds = r2;
    }

    public void setRotation(int r1, float r2) {
        get(r1).transform.rotation = r2;
    }

    public void setRotationX(int r1, float r2) {
        get(r1).transform.rotationX = r2;
    }

    public void setRotationY(int r1, float r2) {
        get(r1).transform.rotationY = r2;
    }

    public void setScaleX(int r1, float r2) {
        get(r1).transform.scaleX = r2;
    }

    public void setScaleY(int r1, float r2) {
        get(r1).transform.scaleY = r2;
    }

    public void setStringValue(int r1, String r2, String r3) {
        Constraint.access$1200(get(r1), r2, r3);
    }

    public void setTransformPivot(int r1, float r2, float r3) {
        Transform r0 = get(r1).transform;
        r0.transformPivotY = r3;
        r0.transformPivotX = r2;
    }

    public void setTransformPivotX(int r1, float r2) {
        get(r1).transform.transformPivotX = r2;
    }

    public void setTransformPivotY(int r1, float r2) {
        get(r1).transform.transformPivotY = r2;
    }

    public void setTranslation(int r1, float r2, float r3) {
        Transform r0 = get(r1).transform;
        r0.translationX = r2;
        r0.translationY = r3;
    }

    public void setTranslationX(int r1, float r2) {
        get(r1).transform.translationX = r2;
    }

    public void setTranslationY(int r1, float r2) {
        get(r1).transform.translationY = r2;
    }

    public void setTranslationZ(int r3, float r4) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        get(r3).transform.translationZ = r4;
        return;
    }

    public void setValidateOnParse(boolean r1) {
        this.mValidate = r1;
    }

    public void setVerticalBias(int r1, float r2) {
        get(r1).layout.verticalBias = r2;
    }

    public void setVerticalChainStyle(int r1, int r2) {
        get(r1).layout.verticalChainStyle = r2;
    }

    public void setVerticalWeight(int r1, float r2) {
        get(r1).layout.verticalWeight = r2;
    }

    public void setVisibility(int r1, int r2) {
        get(r1).propertySet.visibility = r2;
    }

    public void setVisibilityMode(int r1, int r2) {
        get(r1).propertySet.mVisibilityMode = r2;
    }

    public void writeState(Writer r4, ConstraintLayout r5, int r6) {
        r4.write("\n---------------------------------------------\n");
        if ((r6 & 1) != 1) goto L5;
        new WriteXmlEngine(this, r4, r5, r6).writeLayout();
    L6:
        r4.write("\n---------------------------------------------\n");
        return;
    L5:
        new WriteJsonEngine(this, r4, r5, r6).writeLayout();
        goto L6
    }
}
