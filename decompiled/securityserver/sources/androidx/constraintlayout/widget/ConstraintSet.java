package androidx.constraintlayout.widget;

import a.a;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
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
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.networkstackapplib.NetworkStackConstant;
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

        public static class Delta {
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

            public Delta() {
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

            public void add(int r4, int r5) {
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

            public void applyDelta(Constraint r5) {
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
            public void printDelta(String r6) {
                Log.v(r6, "int");
                int r0 = 0;
                int r1 = 0;
            L4:
                if (r1 >= this.mCountInt) goto L6;
                Log.v(r6, this.mTypeInt[r1] + " = " + this.mValueInt[r1]);
                r1 = r1 + 1;
                goto L4
            L6:
                Log.v(r6, "float");
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
                Log.v(r6, "boolean");
            L16:
                if (r0 >= this.mCountBoolean) goto L18;
                Log.v(r6, this.mTypeBoolean[r0] + " = " + this.mValueBoolean[r0]);
                r0 = r0 + 1;
                goto L16
            }

            public void add(int r4, float r5) {
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

            public void add(int r4, String r5) {
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

            public void add(int r4, boolean r5) {
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
        }

        public Constraint() {
            this.propertySet = new PropertySet();
            this.motion = new Motion();
            this.layout = new Layout();
            this.transform = new Transform();
            this.mCustomConstraints = new HashMap();
        }

        public static /* synthetic */ void access$000(Constraint r0, int r1, ConstraintLayout.LayoutParams r2) {
            r0.fillFrom(r1, r2);
        }

        public static /* synthetic */ void access$1000(Constraint r0, String r1, int r2) {
            r0.setColorValue(r1, r2);
        }

        public static /* synthetic */ void access$1100(Constraint r0, String r1, float r2) {
            r0.setFloatValue(r1, r2);
        }

        public static /* synthetic */ void access$1200(Constraint r0, String r1, String r2) {
            r0.setStringValue(r1, r2);
        }

        public static /* synthetic */ void access$700(Constraint r0, ConstraintHelper r1, int r2, Constraints.LayoutParams r3) {
            r0.fillFromConstraints(r1, r2, r3);
        }

        public static /* synthetic */ void access$800(Constraint r0, int r1, Constraints.LayoutParams r2) {
            r0.fillFromConstraints(r1, r2);
        }

        public static /* synthetic */ void access$900(Constraint r0, String r1, int r2) {
            r0.setIntValue(r1, r2);
        }

        private void fillFrom(int r2, ConstraintLayout.LayoutParams r3) {
            this.mViewId = r2;
            Layout r4 = this.layout;
            r4.leftToLeft = r3.leftToLeft;
            r4.leftToRight = r3.leftToRight;
            r4.rightToLeft = r3.rightToLeft;
            r4.rightToRight = r3.rightToRight;
            r4.topToTop = r3.topToTop;
            r4.topToBottom = r3.topToBottom;
            r4.bottomToTop = r3.bottomToTop;
            r4.bottomToBottom = r3.bottomToBottom;
            r4.baselineToBaseline = r3.baselineToBaseline;
            r4.baselineToTop = r3.baselineToTop;
            r4.baselineToBottom = r3.baselineToBottom;
            r4.startToEnd = r3.startToEnd;
            r4.startToStart = r3.startToStart;
            r4.endToStart = r3.endToStart;
            r4.endToEnd = r3.endToEnd;
            r4.horizontalBias = r3.horizontalBias;
            r4.verticalBias = r3.verticalBias;
            r4.dimensionRatio = r3.dimensionRatio;
            r4.circleConstraint = r3.circleConstraint;
            r4.circleRadius = r3.circleRadius;
            r4.circleAngle = r3.circleAngle;
            r4.editorAbsoluteX = r3.editorAbsoluteX;
            r4.editorAbsoluteY = r3.editorAbsoluteY;
            r4.orientation = r3.orientation;
            r4.guidePercent = r3.guidePercent;
            r4.guideBegin = r3.guideBegin;
            r4.guideEnd = r3.guideEnd;
            r4.mWidth = ((ViewGroup.MarginLayoutParams) r3).width;
            r4.mHeight = ((ViewGroup.MarginLayoutParams) r3).height;
            r4.leftMargin = ((ViewGroup.MarginLayoutParams) r3).leftMargin;
            r4.rightMargin = ((ViewGroup.MarginLayoutParams) r3).rightMargin;
            r4.topMargin = ((ViewGroup.MarginLayoutParams) r3).topMargin;
            r4.bottomMargin = ((ViewGroup.MarginLayoutParams) r3).bottomMargin;
            r4.baselineMargin = r3.baselineMargin;
            r4.verticalWeight = r3.verticalWeight;
            r4.horizontalWeight = r3.horizontalWeight;
            r4.verticalChainStyle = r3.verticalChainStyle;
            r4.horizontalChainStyle = r3.horizontalChainStyle;
            r4.constrainedWidth = r3.constrainedWidth;
            r4.constrainedHeight = r3.constrainedHeight;
            r4.widthDefault = r3.matchConstraintDefaultWidth;
            r4.heightDefault = r3.matchConstraintDefaultHeight;
            r4.widthMax = r3.matchConstraintMaxWidth;
            r4.heightMax = r3.matchConstraintMaxHeight;
            r4.widthMin = r3.matchConstraintMinWidth;
            r4.heightMin = r3.matchConstraintMinHeight;
            r4.widthPercent = r3.matchConstraintPercentWidth;
            r4.heightPercent = r3.matchConstraintPercentHeight;
            r4.mConstraintTag = r3.constraintTag;
            r4.goneTopMargin = r3.goneTopMargin;
            r4.goneBottomMargin = r3.goneBottomMargin;
            r4.goneLeftMargin = r3.goneLeftMargin;
            r4.goneRightMargin = r3.goneRightMargin;
            r4.goneStartMargin = r3.goneStartMargin;
            r4.goneEndMargin = r3.goneEndMargin;
            r4.goneBaselineMargin = r3.goneBaselineMargin;
            r4.mWrapBehavior = r3.wrapBehaviorInParent;
            r4.endMargin = r3.getMarginEnd();
            Layout r1 = this.layout;
            r1.startMargin = r3.getMarginStart();
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

        public void applyTo(ConstraintLayout.LayoutParams r3) {
            Layout r0 = this.layout;
            r3.leftToLeft = r0.leftToLeft;
            r3.leftToRight = r0.leftToRight;
            r3.rightToLeft = r0.rightToLeft;
            r3.rightToRight = r0.rightToRight;
            r3.topToTop = r0.topToTop;
            r3.topToBottom = r0.topToBottom;
            r3.bottomToTop = r0.bottomToTop;
            r3.bottomToBottom = r0.bottomToBottom;
            r3.baselineToBaseline = r0.baselineToBaseline;
            r3.baselineToTop = r0.baselineToTop;
            r3.baselineToBottom = r0.baselineToBottom;
            r3.startToEnd = r0.startToEnd;
            r3.startToStart = r0.startToStart;
            r3.endToStart = r0.endToStart;
            r3.endToEnd = r0.endToEnd;
            ((ViewGroup.MarginLayoutParams) r3).leftMargin = r0.leftMargin;
            ((ViewGroup.MarginLayoutParams) r3).rightMargin = r0.rightMargin;
            ((ViewGroup.MarginLayoutParams) r3).topMargin = r0.topMargin;
            ((ViewGroup.MarginLayoutParams) r3).bottomMargin = r0.bottomMargin;
            r3.goneStartMargin = r0.goneStartMargin;
            r3.goneEndMargin = r0.goneEndMargin;
            r3.goneTopMargin = r0.goneTopMargin;
            r3.goneBottomMargin = r0.goneBottomMargin;
            r3.horizontalBias = r0.horizontalBias;
            r3.verticalBias = r0.verticalBias;
            r3.circleConstraint = r0.circleConstraint;
            r3.circleRadius = r0.circleRadius;
            r3.circleAngle = r0.circleAngle;
            r3.dimensionRatio = r0.dimensionRatio;
            r3.editorAbsoluteX = r0.editorAbsoluteX;
            r3.editorAbsoluteY = r0.editorAbsoluteY;
            r3.verticalWeight = r0.verticalWeight;
            r3.horizontalWeight = r0.horizontalWeight;
            r3.verticalChainStyle = r0.verticalChainStyle;
            r3.horizontalChainStyle = r0.horizontalChainStyle;
            r3.constrainedWidth = r0.constrainedWidth;
            r3.constrainedHeight = r0.constrainedHeight;
            r3.matchConstraintDefaultWidth = r0.widthDefault;
            r3.matchConstraintDefaultHeight = r0.heightDefault;
            r3.matchConstraintMaxWidth = r0.widthMax;
            r3.matchConstraintMaxHeight = r0.heightMax;
            r3.matchConstraintMinWidth = r0.widthMin;
            r3.matchConstraintMinHeight = r0.heightMin;
            r3.matchConstraintPercentWidth = r0.widthPercent;
            r3.matchConstraintPercentHeight = r0.heightPercent;
            r3.orientation = r0.orientation;
            r3.guidePercent = r0.guidePercent;
            r3.guideBegin = r0.guideBegin;
            r3.guideEnd = r0.guideEnd;
            ((ViewGroup.MarginLayoutParams) r3).width = r0.mWidth;
            ((ViewGroup.MarginLayoutParams) r3).height = r0.mHeight;
            String r1 = r0.mConstraintTag;
            if (r1 == null) goto L5;
            r3.constraintTag = r1;
        L5:
            r3.wrapBehaviorInParent = r0.mWrapBehavior;
            r3.setMarginStart(r0.startMargin);
            r3.setMarginEnd(this.layout.endMargin);
            r3.validate();
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m4clone() {
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
            mapToConstant.append(R.styleable.Layout_guidelineUseRtl, GUIDE_USE_RTL);
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
            mapToConstant.append(R.styleable.Layout_layout_constraintLeft_creator, UNUSED);
            mapToConstant.append(R.styleable.Layout_layout_constraintTop_creator, UNUSED);
            mapToConstant.append(R.styleable.Layout_layout_constraintRight_creator, UNUSED);
            mapToConstant.append(R.styleable.Layout_layout_constraintBottom_creator, UNUSED);
            mapToConstant.append(R.styleable.Layout_layout_constraintBaseline_creator, UNUSED);
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
            mapToConstant.append(R.styleable.Layout_layout_wrapBehaviorInParent, LAYOUT_WRAP_BEHAVIOR);
            mapToConstant.append(R.styleable.Layout_layout_constraintCircle, CIRCLE);
            mapToConstant.append(R.styleable.Layout_layout_constraintCircleRadius, CIRCLE_RADIUS);
            mapToConstant.append(R.styleable.Layout_layout_constraintCircleAngle, 63);
            mapToConstant.append(R.styleable.Layout_layout_constraintWidth_percent, WIDTH_PERCENT);
            mapToConstant.append(R.styleable.Layout_layout_constraintHeight_percent, HEIGHT_PERCENT);
            mapToConstant.append(R.styleable.Layout_chainUseRtl, 71);
            mapToConstant.append(R.styleable.Layout_barrierDirection, BARRIER_DIRECTION);
            mapToConstant.append(R.styleable.Layout_barrierMargin, BARRIER_MARGIN);
            mapToConstant.append(R.styleable.Layout_constraint_referenced_ids, CONSTRAINT_REFERENCED_IDS);
            mapToConstant.append(R.styleable.Layout_barrierAllowsGoneWidgets, BARRIER_ALLOWS_GONE_WIDGETS);
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
            Object r4 = r2.get(this);     // Catch: IllegalAccessException -> L18
            Class<?> r5 = r2.getType();     // Catch: IllegalAccessException -> L18
            if (r5 != Integer.TYPE) goto L21;
            Integer r6 = (Integer) r4;     // Catch: IllegalAccessException -> L18
            if (r6.intValue() == (-1)) goto L27;
            Object r7 = r10.lookUpConstraintName(r6.intValue());     // Catch: IllegalAccessException -> L18
            r11.append("    ");     // Catch: IllegalAccessException -> L18
            r11.append(r3);     // Catch: IllegalAccessException -> L18
            r11.append(" = \"");     // Catch: IllegalAccessException -> L18
            if (r7 != null) goto L16;
            Object r8 = r6;
        L17:
            r11.append(r8);     // Catch: IllegalAccessException -> L18
            r11.append("\"\n");     // Catch: IllegalAccessException -> L18
            goto L27
        L16:
            r8 = r7;
            goto L17
        L21:
            if (r5 != Float.TYPE) goto L27;
            Float r9 = (Float) r4;     // Catch: IllegalAccessException -> L18
            if (r9.floatValue() == (-1.0f)) goto L27;
            r11.append("    ");     // Catch: IllegalAccessException -> L18
            r11.append(r3);     // Catch: IllegalAccessException -> L18
            r11.append(" = \"");     // Catch: IllegalAccessException -> L18
            r11.append(r9);     // Catch: IllegalAccessException -> L18
            r11.append("\"\n");     // Catch: IllegalAccessException -> L18
        L18:
            e = move-exception;
            e.printStackTrace();
        L27:
            r1 = r1 + 1;
            goto L4
        }

        public void fillFromAttributeList(Context r9, AttributeSet r10) {
            TypedArray r11 = r9.obtainStyledAttributes(r10, R.styleable.Layout);
            this.mApply = true;
            int r0 = r11.getIndexCount();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L79;
            int r3 = r11.getIndex(r2);
            int r4 = mapToConstant.get(r3);
            switch(r4) {
                case 1: goto L77;
                case 2: goto L76;
                case 3: goto L75;
                case 4: goto L74;
                case 5: goto L73;
                case 6: goto L72;
                case 7: goto L71;
                case 8: goto L70;
                case 9: goto L69;
                case 10: goto L68;
                case 11: goto L67;
                case 12: goto L66;
                case 13: goto L65;
                case 14: goto L64;
                case 15: goto L63;
                case 16: goto L62;
                case 17: goto L61;
                case 18: goto L60;
                case 19: goto L59;
                case 20: goto L58;
                case 21: goto L57;
                case 22: goto L56;
                case 23: goto L55;
                case 24: goto L54;
                case 25: goto L53;
                case 26: goto L52;
                case 27: goto L51;
                case 28: goto L50;
                case 29: goto L49;
                case 30: goto L48;
                case 31: goto L47;
                case 32: goto L46;
                case 33: goto L45;
                case 34: goto L44;
                case 35: goto L43;
                case 36: goto L42;
                case 37: goto L41;
                case 38: goto L40;
                case 39: goto L39;
                case 40: goto L38;
                case 41: goto L37;
                case 42: goto L36;
                default: goto L6;
            };
        L6:
            switch(r4) {
                case 61: goto L35;
                case 62: goto L34;
                case 63: goto L33;
                default: goto L8;
            };
        L33:
            this.circleAngle = r11.getFloat(r3, this.circleAngle);
        L78:
            r2 = r2 + 1;
            goto L3
        L34:
            this.circleRadius = r11.getDimensionPixelSize(r3, this.circleRadius);
            goto L78
        L35:
            this.circleConstraint = ConstraintSet.access$100(r11, r3, this.circleConstraint);
            goto L78
        L8:
            switch(r4) {
                case 69: goto L32;
                case 70: goto L31;
                case 71: goto L30;
                case 72: goto L29;
                case 73: goto L28;
                case 74: goto L27;
                case 75: goto L26;
                case 76: goto L25;
                case 77: goto L24;
                case 78: goto L23;
                case 79: goto L22;
                case 80: goto L21;
                case 81: goto L20;
                case 82: goto L19;
                case 83: goto L18;
                case 84: goto L17;
                case 85: goto L16;
                case 86: goto L15;
                case 87: goto L14;
                case 88: goto L13;
                case 89: goto L12;
                case 90: goto L11;
                case 91: goto L10;
                default: goto L9;
            };
        L9:
            Log.w(ConstraintSet.TAG, "Unknown attribute 0x" + Integer.toHexString(r3) + "   " + mapToConstant.get(r3));
            goto L78
        L10:
            Log.w(ConstraintSet.TAG, "unused attribute 0x" + Integer.toHexString(r3) + "   " + mapToConstant.get(r3));
            goto L78
        L11:
            this.guidelineUseRtl = r11.getBoolean(r3, this.guidelineUseRtl);
            goto L78
        L12:
            this.mConstraintTag = r11.getString(r3);
            goto L78
        L13:
            this.constrainedHeight = r11.getBoolean(r3, this.constrainedHeight);
            goto L78
        L14:
            this.constrainedWidth = r11.getBoolean(r3, this.constrainedWidth);
            goto L78
        L15:
            this.widthMin = r11.getDimensionPixelSize(r3, this.widthMin);
            goto L78
        L16:
            this.heightMin = r11.getDimensionPixelSize(r3, this.heightMin);
            goto L78
        L17:
            this.widthMax = r11.getDimensionPixelSize(r3, this.widthMax);
            goto L78
        L18:
            this.heightMax = r11.getDimensionPixelSize(r3, this.heightMax);
            goto L78
        L19:
            this.heightDefault = r11.getInt(r3, this.heightDefault);
            goto L78
        L20:
            this.widthDefault = r11.getInt(r3, this.widthDefault);
            goto L78
        L21:
            this.baselineMargin = r11.getDimensionPixelSize(r3, this.baselineMargin);
            goto L78
        L22:
            this.goneBaselineMargin = r11.getDimensionPixelSize(r3, this.goneBaselineMargin);
            goto L78
        L23:
            this.baselineToBottom = ConstraintSet.access$100(r11, r3, this.baselineToBottom);
            goto L78
        L24:
            this.baselineToTop = ConstraintSet.access$100(r11, r3, this.baselineToTop);
            goto L78
        L25:
            this.mWrapBehavior = r11.getInt(r3, this.mWrapBehavior);
            goto L78
        L26:
            this.mBarrierAllowsGoneWidgets = r11.getBoolean(r3, this.mBarrierAllowsGoneWidgets);
            goto L78
        L27:
            this.mReferenceIdString = r11.getString(r3);
            goto L78
        L28:
            this.mBarrierMargin = r11.getDimensionPixelSize(r3, this.mBarrierMargin);
            goto L78
        L29:
            this.mBarrierDirection = r11.getInt(r3, this.mBarrierDirection);
            goto L78
        L30:
            Log.e(ConstraintSet.TAG, "CURRENTLY UNSUPPORTED");
            goto L78
        L31:
            this.heightPercent = r11.getFloat(r3, 1.0f);
            goto L78
        L32:
            this.widthPercent = r11.getFloat(r3, 1.0f);
            goto L78
        L36:
            ConstraintSet.parseDimensionConstraints(this, r11, r3, 1);
            goto L78
        L37:
            ConstraintSet.parseDimensionConstraints(this, r11, r3, 0);
            goto L78
        L38:
            this.verticalChainStyle = r11.getInt(r3, this.verticalChainStyle);
            goto L78
        L39:
            this.horizontalChainStyle = r11.getInt(r3, this.horizontalChainStyle);
            goto L78
        L40:
            this.verticalWeight = r11.getFloat(r3, this.verticalWeight);
            goto L78
        L41:
            this.horizontalWeight = r11.getFloat(r3, this.horizontalWeight);
            goto L78
        L42:
            this.verticalBias = r11.getFloat(r3, this.verticalBias);
            goto L78
        L43:
            this.topToTop = ConstraintSet.access$100(r11, r3, this.topToTop);
            goto L78
        L44:
            this.topToBottom = ConstraintSet.access$100(r11, r3, this.topToBottom);
            goto L78
        L45:
            this.topMargin = r11.getDimensionPixelSize(r3, this.topMargin);
            goto L78
        L46:
            this.startToStart = ConstraintSet.access$100(r11, r3, this.startToStart);
            goto L78
        L47:
            this.startToEnd = ConstraintSet.access$100(r11, r3, this.startToEnd);
            goto L78
        L48:
            this.startMargin = r11.getDimensionPixelSize(r3, this.startMargin);
            goto L78
        L49:
            this.rightToRight = ConstraintSet.access$100(r11, r3, this.rightToRight);
            goto L78
        L50:
            this.rightToLeft = ConstraintSet.access$100(r11, r3, this.rightToLeft);
            goto L78
        L51:
            this.rightMargin = r11.getDimensionPixelSize(r3, this.rightMargin);
            goto L78
        L52:
            this.orientation = r11.getInt(r3, this.orientation);
            goto L78
        L53:
            this.leftToRight = ConstraintSet.access$100(r11, r3, this.leftToRight);
            goto L78
        L54:
            this.leftToLeft = ConstraintSet.access$100(r11, r3, this.leftToLeft);
            goto L78
        L55:
            this.leftMargin = r11.getDimensionPixelSize(r3, this.leftMargin);
            goto L78
        L56:
            this.mWidth = r11.getLayoutDimension(r3, this.mWidth);
            goto L78
        L57:
            this.mHeight = r11.getLayoutDimension(r3, this.mHeight);
            goto L78
        L58:
            this.horizontalBias = r11.getFloat(r3, this.horizontalBias);
            goto L78
        L59:
            this.guidePercent = r11.getFloat(r3, this.guidePercent);
            goto L78
        L60:
            this.guideEnd = r11.getDimensionPixelOffset(r3, this.guideEnd);
            goto L78
        L61:
            this.guideBegin = r11.getDimensionPixelOffset(r3, this.guideBegin);
            goto L78
        L62:
            this.goneTopMargin = r11.getDimensionPixelSize(r3, this.goneTopMargin);
            goto L78
        L63:
            this.goneStartMargin = r11.getDimensionPixelSize(r3, this.goneStartMargin);
            goto L78
        L64:
            this.goneRightMargin = r11.getDimensionPixelSize(r3, this.goneRightMargin);
            goto L78
        L65:
            this.goneLeftMargin = r11.getDimensionPixelSize(r3, this.goneLeftMargin);
            goto L78
        L66:
            this.goneEndMargin = r11.getDimensionPixelSize(r3, this.goneEndMargin);
            goto L78
        L67:
            this.goneBottomMargin = r11.getDimensionPixelSize(r3, this.goneBottomMargin);
            goto L78
        L68:
            this.endToStart = ConstraintSet.access$100(r11, r3, this.endToStart);
            goto L78
        L69:
            this.endToEnd = ConstraintSet.access$100(r11, r3, this.endToEnd);
            goto L78
        L70:
            this.endMargin = r11.getDimensionPixelSize(r3, this.endMargin);
            goto L78
        L71:
            this.editorAbsoluteY = r11.getDimensionPixelOffset(r3, this.editorAbsoluteY);
            goto L78
        L72:
            this.editorAbsoluteX = r11.getDimensionPixelOffset(r3, this.editorAbsoluteX);
            goto L78
        L73:
            this.dimensionRatio = r11.getString(r3);
            goto L78
        L74:
            this.bottomToTop = ConstraintSet.access$100(r11, r3, this.bottomToTop);
            goto L78
        L75:
            this.bottomToBottom = ConstraintSet.access$100(r11, r3, this.bottomToBottom);
            goto L78
        L76:
            this.bottomMargin = r11.getDimensionPixelSize(r3, this.bottomMargin);
            goto L78
        L77:
            this.baselineToBaseline = ConstraintSet.access$100(r11, r3, this.baselineToBaseline);
            goto L78
        L79:
            r11.recycle();
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

        public void fillFromAttributeList(Context r9, AttributeSet r10) {
            TypedArray r11 = r9.obtainStyledAttributes(r10, R.styleable.Motion);
            this.mApply = true;
            int r0 = r11.getIndexCount();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L31;
            int r3 = r11.getIndex(r2);
            switch(mapToConstant.get(r3)) {
                case 1: goto L29;
                case 2: goto L28;
                case 3: goto L25;
                case 4: goto L23;
                case 5: goto L22;
                case 6: goto L21;
                case 7: goto L20;
                case 8: goto L19;
                case 9: goto L18;
                case 10: goto L7;
                default: goto L30;
            };
        L7:
            int r4 = r11.peekValue(r3).type;
            if (r4 != 1) goto L12;
            int r5 = r11.getResourceId(r3, -1);
            this.mQuantizeInterpolatorID = r5;
            if (r5 == (-1)) goto L30;
            this.mQuantizeInterpolatorType = -2;
            goto L30
        L12:
            if (r4 != 3) goto L17;
            String r6 = r11.getString(r3);
            this.mQuantizeInterpolatorString = r6;
            if (r6.indexOf(LibrarianImpl.Constants.SEPARATOR) <= 0) goto L16;
            this.mQuantizeInterpolatorID = r11.getResourceId(r3, -1);
            this.mQuantizeInterpolatorType = -2;
            goto L30
        L16:
            this.mQuantizeInterpolatorType = -1;
            goto L30
        L17:
            this.mQuantizeInterpolatorType = r11.getInteger(r3, this.mQuantizeInterpolatorID);
            goto L30
        L18:
            this.mQuantizeMotionPhase = r11.getFloat(r3, this.mQuantizeMotionPhase);
            goto L30
        L19:
            this.mQuantizeMotionSteps = r11.getInteger(r3, this.mQuantizeMotionSteps);
            goto L30
        L20:
            this.mMotionStagger = r11.getFloat(r3, this.mMotionStagger);
            goto L30
        L21:
            this.mAnimateCircleAngleTo = r11.getInteger(r3, this.mAnimateCircleAngleTo);
            goto L30
        L22:
            this.mAnimateRelativeTo = ConstraintSet.access$100(r11, r3, this.mAnimateRelativeTo);
            goto L30
        L23:
            this.mDrawPath = r11.getInt(r3, 0);
            goto L30
        L28:
            this.mPathMotionArc = r11.getInt(r3, this.mPathMotionArc);
            goto L30
        L29:
            this.mPathRotate = r11.getFloat(r3, this.mPathRotate);
            goto L30
        L25:
            if (r11.peekValue(r3).type != 3) goto L27;
            this.mTransitionEasing = r11.getString(r3);
            goto L30
        L27:
            this.mTransitionEasing = Easing.NAMED_EASING[r11.getInteger(r3, 0)];
        L30:
            r2 = r2 + 1;
            goto L3
        L31:
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

        public void fillFromAttributeList(Context r4, AttributeSet r5) {
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

        public void fillFromAttributeList(Context r5, AttributeSet r6) {
            TypedArray r7 = r5.obtainStyledAttributes(r6, R.styleable.Transform);
            this.mApply = true;
            int r0 = r7.getIndexCount();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L20;
            int r2 = r7.getIndex(r1);
            switch(mapToConstant.get(r2)) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L11;
                case 9: goto L10;
                case 10: goto L9;
                case 11: goto L8;
                case 12: goto L7;
                default: goto L19;
            };
        L7:
            this.transformPivotTarget = ConstraintSet.access$100(r7, r2, this.transformPivotTarget);
            goto L19
        L8:
            this.applyElevation = true;
            this.elevation = r7.getDimension(r2, this.elevation);
            goto L19
        L9:
            this.translationZ = r7.getDimension(r2, this.translationZ);
            goto L19
        L10:
            this.translationY = r7.getDimension(r2, this.translationY);
            goto L19
        L11:
            this.translationX = r7.getDimension(r2, this.translationX);
            goto L19
        L12:
            this.transformPivotY = r7.getDimension(r2, this.transformPivotY);
            goto L19
        L13:
            this.transformPivotX = r7.getDimension(r2, this.transformPivotX);
            goto L19
        L14:
            this.scaleY = r7.getFloat(r2, this.scaleY);
            goto L19
        L15:
            this.scaleX = r7.getFloat(r2, this.scaleX);
            goto L19
        L16:
            this.rotationY = r7.getFloat(r2, this.rotationY);
            goto L19
        L17:
            this.rotationX = r7.getFloat(r2, this.rotationX);
            goto L19
        L18:
            this.rotation = r7.getFloat(r2, this.rotation);
        L19:
            r1 = r1 + 1;
            goto L3
        L20:
            r7.recycle();
        }
    }

    public class WriteJsonEngine {
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

        public WriteJsonEngine(ConstraintSet r1, Writer r2, ConstraintLayout r3, int r4) {
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
            if (r5 != 0) goto L27;
            if (r9 != (-1)) goto L16;
            if (r8 != (-1)) goto L16;
            if (r6 == 1) goto L13;
            if (r6 != 2) goto L36;
            this.writer.write(SPACE + r4 + ": '" + r7 + "%',\n");
            return;
        L36:
            return;
        L13:
            this.writer.write(SPACE + r4 + ": '???????????',\n");
            return;
        L16:
            if (r6 == 0) goto L24;
            if (r6 == 1) goto L22;
            if (r6 != 2) goto L33;
            this.writer.write(SPACE + r4 + ": {'" + r7 + "'% ," + r8 + ", " + r9 + "}\n");
            return;
        L33:
            return;
        L22:
            this.writer.write(SPACE + r4 + ": {'wrap' ," + r8 + ", " + r9 + "}\n");
            return;
        L24:
            this.writer.write(SPACE + r4 + ": {'spread' ," + r8 + ", " + r9 + "}\n");
            return;
        L27:
            if (r5 != (-2)) goto L29;
            this.writer.write(SPACE + r4 + ": 'wrap'\n");
            return;
        L29:
            if (r5 != (-1)) goto L31;
            this.writer.write(SPACE + r4 + ": 'parent'\n");
            return;
        L31:
            this.writer.write(SPACE + r4 + ": " + r5 + ",\n");
        }

        private void writeGuideline(int r1, int r2, int r3, float r4) {
        }

        public String getName(int r3) {
            if (this.idMap.containsKey(Integer.valueOf(r3)) == true) goto L5;
            if (r3 != 0) goto L9;
            return "'parent'";
        L9:
            String r0 = lookup(r3);
            this.idMap.put(Integer.valueOf(r3), r0);
            return "'" + r0 + "'";
        L5:
            return a.o(new StringBuilder("'"), this.idMap.get(Integer.valueOf(r3)), "'");
        }

        public String lookup(int r3) {
            if (r3 != (-1)) goto L5;
            StringBuilder r4 = new StringBuilder(EnvironmentCompat.MEDIA_UNKNOWN);     // Catch: Exception -> L8
            int r0 = this.unknownCount + 1;     // Catch: Exception -> L8
            this.unknownCount = r0;     // Catch: Exception -> L8
            r4.append(r0);     // Catch: Exception -> L8
            return r4.toString();
        L5:
            return this.context.getResources().getResourceEntryName(r3);
        L8:
            StringBuilder r5 = new StringBuilder(EnvironmentCompat.MEDIA_UNKNOWN);
            int r1 = this.unknownCount + 1;
            this.unknownCount = r1;
            r5.append(r1);
            return r5.toString();
        }

        public void writeCircle(int r3, float r4, int r5) {
            if (r3 != (-1)) goto L5;
            return;
        L5:
            this.writer.write("       circle");
            this.writer.write(":[");
            this.writer.write(getName(r3));
            this.writer.write(", " + r4);
            this.writer.write(r5 + "]");
        }

        public void writeConstraint(String r3, int r4, String r5, int r6, int r7) {
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

        public void writeLayout() {
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

        public void writeVariable(String r4, int r5) {
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

        public void writeVariable(String r4, float r5) {
            if (r5 != (-1.0f)) goto L5;
            return;
        L5:
            this.writer.write(SPACE + r4);
            this.writer.write(": " + r5);
            this.writer.write(",\n");
        }

        public void writeVariable(String r3, float r4, float r5) {
            if (r4 != r5) goto L5;
            return;
        L5:
            this.writer.write(SPACE + r3);
            this.writer.write(": " + r4);
            this.writer.write(",\n");
        }

        public void writeVariable(String r4, boolean r5) {
            if (r5 == true) goto L4;
            return;
        L4:
            this.writer.write(SPACE + r4);
            this.writer.write(": " + r5);
            this.writer.write(",\n");
        }

        public void writeVariable(String r3, boolean r4, boolean r5) {
            if (r4 != r5) goto L4;
            return;
        L4:
            this.writer.write(SPACE + r3);
            this.writer.write(": " + r4);
            this.writer.write(",\n");
        }

        public void writeVariable(String r4, int[] r5) {
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

        public void writeVariable(String r4, String r5) {
            if (r5 != null) goto L4;
            return;
        L4:
            this.writer.write(SPACE + r4);
            this.writer.write(":");
            this.writer.write(", ".concat(r5));
            this.writer.write("\n");
        }
    }

    public class WriteXmlEngine {
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

        public WriteXmlEngine(ConstraintSet r1, Writer r2, ConstraintLayout r3, int r4) {
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
            if (r3 != (-2)) goto L7;
            this.writer.write(SPACE + r2 + "=\"wrap_content\"");
            return;
        L7:
            if (r3 != (-1)) goto L9;
            this.writer.write(SPACE + r2 + "=\"match_parent\"");
            return;
        L9:
            this.writer.write(SPACE + r2 + "=\"" + r3 + "dp\"");
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
            Writer r1 = this.writer;
            StringBuilder r6 = a.u(SPACE, r2, "=\"");
            r6.append(r4[r3]);
            r6.append("\"");
            r1.write(r6.toString());
            return;
        }

        public String getName(int r4) {
            if (this.idMap.containsKey(Integer.valueOf(r4)) == true) goto L5;
            if (r4 != 0) goto L9;
            return ConstraintSet.KEY_PERCENT_PARENT;
        L9:
            String r0 = lookup(r4);
            this.idMap.put(Integer.valueOf(r4), r0);
            return "@+id/" + r0 + "";
        L5:
            return a.o(new StringBuilder("@+id/"), this.idMap.get(Integer.valueOf(r4)), "");
        }

        public String lookup(int r3) {
            if (r3 != (-1)) goto L5;
            StringBuilder r4 = new StringBuilder(EnvironmentCompat.MEDIA_UNKNOWN);     // Catch: Exception -> L8
            int r0 = this.unknownCount + 1;     // Catch: Exception -> L8
            this.unknownCount = r0;     // Catch: Exception -> L8
            r4.append(r0);     // Catch: Exception -> L8
            return r4.toString();
        L5:
            return this.context.getResources().getResourceEntryName(r3);
        L8:
            StringBuilder r5 = new StringBuilder(EnvironmentCompat.MEDIA_UNKNOWN);
            int r1 = this.unknownCount + 1;
            this.unknownCount = r1;
            r5.append(r1);
            return r5.toString();
        }

        public void writeCircle(int r3, float r4, int r5) {
            if (r3 != (-1)) goto L5;
            return;
        L5:
            this.writer.write("circle");
            this.writer.write(":[");
            this.writer.write(getName(r3));
            this.writer.write(", " + r4);
            this.writer.write(r5 + "]");
        }

        public void writeConstraint(String r3, int r4, String r5, int r6, int r7) {
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

        public void writeLayout() {
            this.writer.write("\n<ConstraintSet>\n");
            Iterator r1 = ConstraintSet.access$1300(this.this$0).keySet().iterator();
        L4:
            if (r1.hasNext() == false) goto L9;
            Integer r2 = (Integer) r1.next();
            Constraint r3 = (Constraint) ConstraintSet.access$1300(this.this$0).get(r2);
            String r4 = getName(r2.intValue());
            this.writer.write("  <Constraint");
            this.writer.write("\n       android:id=\"" + r4 + "\"");
            Layout r5 = r3.layout;
            writeBaseDimension("android:layout_width", r5.mWidth, -5);
            writeBaseDimension("android:layout_height", r5.mHeight, -5);
            writeVariable("app:layout_constraintGuide_begin", r5.guideBegin, -1.0f);
            writeVariable("app:layout_constraintGuide_end", r5.guideEnd, -1.0f);
            writeVariable("app:layout_constraintGuide_percent", r5.guidePercent, -1.0f);
            writeVariable("app:layout_constraintHorizontal_bias", r5.horizontalBias, 0.5f);
            writeVariable("app:layout_constraintVertical_bias", r5.verticalBias, 0.5f);
            writeVariable("app:layout_constraintDimensionRatio", r5.dimensionRatio, null);
            writeXmlConstraint("app:layout_constraintCircle", r5.circleConstraint);
            writeVariable("app:layout_constraintCircleRadius", r5.circleRadius, 0.0f);
            writeVariable("app:layout_constraintCircleAngle", r5.circleAngle, 0.0f);
            writeVariable("android:orientation", r5.orientation, -1.0f);
            writeVariable("app:layout_constraintVertical_weight", r5.verticalWeight, -1.0f);
            writeVariable("app:layout_constraintHorizontal_weight", r5.horizontalWeight, -1.0f);
            writeVariable("app:layout_constraintHorizontal_chainStyle", r5.horizontalChainStyle, 0.0f);
            writeVariable("app:layout_constraintVertical_chainStyle", r5.verticalChainStyle, 0.0f);
            writeVariable("app:barrierDirection", r5.mBarrierDirection, -1.0f);
            writeVariable("app:barrierMargin", r5.mBarrierMargin, 0.0f);
            writeDimension("app:layout_marginLeft", r5.leftMargin, 0);
            writeDimension("app:layout_goneMarginLeft", r5.goneLeftMargin, Integer.MIN_VALUE);
            writeDimension("app:layout_marginRight", r5.rightMargin, 0);
            writeDimension("app:layout_goneMarginRight", r5.goneRightMargin, Integer.MIN_VALUE);
            writeDimension("app:layout_marginStart", r5.startMargin, 0);
            writeDimension("app:layout_goneMarginStart", r5.goneStartMargin, Integer.MIN_VALUE);
            writeDimension("app:layout_marginEnd", r5.endMargin, 0);
            writeDimension("app:layout_goneMarginEnd", r5.goneEndMargin, Integer.MIN_VALUE);
            writeDimension("app:layout_marginTop", r5.topMargin, 0);
            writeDimension("app:layout_goneMarginTop", r5.goneTopMargin, Integer.MIN_VALUE);
            writeDimension("app:layout_marginBottom", r5.bottomMargin, 0);
            writeDimension("app:layout_goneMarginBottom", r5.goneBottomMargin, Integer.MIN_VALUE);
            writeDimension("app:goneBaselineMargin", r5.goneBaselineMargin, Integer.MIN_VALUE);
            writeDimension("app:baselineMargin", r5.baselineMargin, 0);
            writeBoolen("app:layout_constrainedWidth", r5.constrainedWidth, false);
            writeBoolen("app:layout_constrainedHeight", r5.constrainedHeight, false);
            writeBoolen("app:barrierAllowsGoneWidgets", r5.mBarrierAllowsGoneWidgets, true);
            writeVariable("app:layout_wrapBehaviorInParent", r5.mWrapBehavior, 0.0f);
            writeXmlConstraint("app:baselineToBaseline", r5.baselineToBaseline);
            writeXmlConstraint("app:baselineToBottom", r5.baselineToBottom);
            writeXmlConstraint("app:baselineToTop", r5.baselineToTop);
            writeXmlConstraint("app:layout_constraintBottom_toBottomOf", r5.bottomToBottom);
            writeXmlConstraint("app:layout_constraintBottom_toTopOf", r5.bottomToTop);
            writeXmlConstraint("app:layout_constraintEnd_toEndOf", r5.endToEnd);
            writeXmlConstraint("app:layout_constraintEnd_toStartOf", r5.endToStart);
            writeXmlConstraint("app:layout_constraintLeft_toLeftOf", r5.leftToLeft);
            writeXmlConstraint("app:layout_constraintLeft_toRightOf", r5.leftToRight);
            writeXmlConstraint("app:layout_constraintRight_toLeftOf", r5.rightToLeft);
            writeXmlConstraint("app:layout_constraintRight_toRightOf", r5.rightToRight);
            writeXmlConstraint("app:layout_constraintStart_toEndOf", r5.startToEnd);
            writeXmlConstraint("app:layout_constraintStart_toStartOf", r5.startToStart);
            writeXmlConstraint("app:layout_constraintTop_toBottomOf", r5.topToBottom);
            writeXmlConstraint("app:layout_constraintTop_toTopOf", r5.topToTop);
            String[] r6 = {"spread", "wrap", "percent"};
            writeEnum("app:layout_constraintHeight_default", r5.heightDefault, r6, 0);
            writeVariable("app:layout_constraintHeight_percent", r5.heightPercent, 1.0f);
            writeDimension("app:layout_constraintHeight_min", r5.heightMin, 0);
            writeDimension("app:layout_constraintHeight_max", r5.heightMax, 0);
            writeBoolen("android:layout_constrainedHeight", r5.constrainedHeight, false);
            writeEnum("app:layout_constraintWidth_default", r5.widthDefault, r6, 0);
            writeVariable("app:layout_constraintWidth_percent", r5.widthPercent, 1.0f);
            writeDimension("app:layout_constraintWidth_min", r5.widthMin, 0);
            writeDimension("app:layout_constraintWidth_max", r5.widthMax, 0);
            writeBoolen("android:layout_constrainedWidth", r5.constrainedWidth, false);
            writeVariable("app:layout_constraintVertical_weight", r5.verticalWeight, -1.0f);
            writeVariable("app:layout_constraintHorizontal_weight", r5.horizontalWeight, -1.0f);
            writeVariable("app:layout_constraintHorizontal_chainStyle", r5.horizontalChainStyle);
            writeVariable("app:layout_constraintVertical_chainStyle", r5.verticalChainStyle);
            writeEnum("app:barrierDirection", r5.mBarrierDirection, new String[]{"left", "right", "top", "bottom", "start", TraceStatsConsts.STATS_KEY_END}, -1);
            writeVariable("app:layout_constraintTag", r5.mConstraintTag, null);
            int[] r7 = r5.mReferenceIds;
            if (r7 == null) goto L8;
            writeVariable("'ReferenceIds'", r7);
        L8:
            this.writer.write(" />\n");
            goto L4
        L9:
            this.writer.write("</ConstraintSet>\n");
        }

        public void writeVariable(String r3, int r4) {
            if (r4 != 0) goto L4;
            return;
        L4:
            if (r4 == (-1)) goto L9;
            this.writer.write(SPACE + r3 + "=\"" + r4 + "\"\n");
            return;
        }

        public void writeXmlConstraint(String r4, int r5) {
            if (r5 != (-1)) goto L5;
            return;
        L5:
            this.writer.write(SPACE + r4);
            this.writer.write("=\"" + getName(r5) + "\"");
        }

        public void writeVariable(String r3, float r4, float r5) {
            if (r4 != r5) goto L5;
            return;
        L5:
            this.writer.write(SPACE + r3);
            this.writer.write("=\"" + r4 + "\"");
        }

        public void writeVariable(String r3, String r4, String r5) {
            if (r4 != null) goto L4;
            return;
        L4:
            if (r4.equals(r5) == true) goto L9;
            this.writer.write(SPACE + r3);
            this.writer.write("=\"" + r4 + "\"");
            return;
        }

        public void writeVariable(String r4, int[] r5) {
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

        public void writeVariable(String r2, String r3) {
            if (r3 != null) goto L4;
            return;
        L4:
            this.writer.write(r2);
            this.writer.write(":");
            this.writer.write(", ".concat(r3));
            this.writer.write("\n");
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
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_toTopOf, BASELINE_TO_TOP);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_toBottomOf, BASELINE_TO_BOTTOM);
        mapToConstant.append(R.styleable.Constraint_layout_editor_absoluteX, 6);
        mapToConstant.append(R.styleable.Constraint_layout_editor_absoluteY, 7);
        mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_begin, 17);
        mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_end, 18);
        mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_percent, 19);
        mapToConstant.append(R.styleable.Constraint_guidelineUseRtl, GUIDELINE_USE_RTL);
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
        mapToConstant.append(R.styleable.Constraint_layout_constraintLeft_creator, UNUSED);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTop_creator, UNUSED);
        mapToConstant.append(R.styleable.Constraint_layout_constraintRight_creator, UNUSED);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_creator, UNUSED);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_creator, UNUSED);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginLeft, 24);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginRight, 28);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginStart, 31);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginEnd, 8);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginTop, 34);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginBottom, 2);
        mapToConstant.append(R.styleable.Constraint_android_layout_width, 23);
        mapToConstant.append(R.styleable.Constraint_android_layout_height, 21);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth, LAYOUT_CONSTRAINT_WIDTH);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight, LAYOUT_CONSTRAINT_HEIGHT);
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
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_max, WIDTH_MAX);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_max, HEIGHT_MAX);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_min, WIDTH_MIN);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_min, HEIGHT_MIN);
        mapToConstant.append(R.styleable.Constraint_layout_constraintCircle, CIRCLE);
        mapToConstant.append(R.styleable.Constraint_layout_constraintCircleRadius, CIRCLE_RADIUS);
        mapToConstant.append(R.styleable.Constraint_layout_constraintCircleAngle, 63);
        mapToConstant.append(R.styleable.Constraint_animateRelativeTo, 64);
        mapToConstant.append(R.styleable.Constraint_transitionEasing, 65);
        mapToConstant.append(R.styleable.Constraint_drawPath, 66);
        mapToConstant.append(R.styleable.Constraint_transitionPathRotate, 67);
        mapToConstant.append(R.styleable.Constraint_motionStagger, MOTION_STAGGER);
        mapToConstant.append(R.styleable.Constraint_android_id, 38);
        mapToConstant.append(R.styleable.Constraint_motionProgress, PROGRESS);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_percent, WIDTH_PERCENT);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_percent, HEIGHT_PERCENT);
        mapToConstant.append(R.styleable.Constraint_layout_wrapBehaviorInParent, LAYOUT_WRAP_BEHAVIOR);
        mapToConstant.append(R.styleable.Constraint_chainUseRtl, 71);
        mapToConstant.append(R.styleable.Constraint_barrierDirection, BARRIER_DIRECTION);
        mapToConstant.append(R.styleable.Constraint_barrierMargin, BARRIER_MARGIN);
        mapToConstant.append(R.styleable.Constraint_constraint_referenced_ids, CONSTRAINT_REFERENCED_IDS);
        mapToConstant.append(R.styleable.Constraint_barrierAllowsGoneWidgets, BARRIER_ALLOWS_GONE_WIDGETS);
        mapToConstant.append(R.styleable.Constraint_pathMotionArc, PATH_MOTION_ARC);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTag, CONSTRAINT_TAG);
        mapToConstant.append(R.styleable.Constraint_visibilityMode, VISIBILITY_MODE);
        mapToConstant.append(R.styleable.Constraint_layout_constrainedWidth, 80);
        mapToConstant.append(R.styleable.Constraint_layout_constrainedHeight, CONSTRAINED_HEIGHT);
        mapToConstant.append(R.styleable.Constraint_polarRelativeTo, ANIMATE_CIRCLE_ANGLE_TO);
        mapToConstant.append(R.styleable.Constraint_transformPivotTarget, TRANSFORM_PIVOT_TARGET);
        mapToConstant.append(R.styleable.Constraint_quantizeMotionSteps, QUANTIZE_MOTION_STEPS);
        mapToConstant.append(R.styleable.Constraint_quantizeMotionPhase, QUANTIZE_MOTION_PHASE);
        mapToConstant.append(R.styleable.Constraint_quantizeMotionInterpolator, QUANTIZE_MOTION_INTERPOLATOR);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_editor_absoluteY, 6);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_editor_absoluteY, 7);
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
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintLeft_creator, UNUSED);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintTop_creator, UNUSED);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintRight_creator, UNUSED);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintBottom_creator, UNUSED);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintBaseline_creator, UNUSED);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginLeft, 24);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginRight, 28);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginStart, 31);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginEnd, 8);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginTop, 34);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginBottom, 2);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_width, 23);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_height, 21);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth, LAYOUT_CONSTRAINT_WIDTH);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight, LAYOUT_CONSTRAINT_HEIGHT);
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
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_max, WIDTH_MAX);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_max, HEIGHT_MAX);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_min, WIDTH_MIN);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_min, HEIGHT_MIN);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintCircleRadius, CIRCLE_RADIUS);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintCircleAngle, 63);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_animateRelativeTo, 64);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_transitionEasing, 65);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_drawPath, 66);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_transitionPathRotate, 67);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_motionStagger, MOTION_STAGGER);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_id, 38);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_motionTarget, MOTION_TARGET);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_motionProgress, PROGRESS);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_percent, WIDTH_PERCENT);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_percent, HEIGHT_PERCENT);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_chainUseRtl, 71);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_barrierDirection, BARRIER_DIRECTION);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_barrierMargin, BARRIER_MARGIN);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_constraint_referenced_ids, CONSTRAINT_REFERENCED_IDS);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_barrierAllowsGoneWidgets, BARRIER_ALLOWS_GONE_WIDGETS);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_pathMotionArc, PATH_MOTION_ARC);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintTag, CONSTRAINT_TAG);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_visibilityMode, VISIBILITY_MODE);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constrainedWidth, 80);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constrainedHeight, CONSTRAINED_HEIGHT);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_polarRelativeTo, ANIMATE_CIRCLE_ANGLE_TO);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_transformPivotTarget, TRANSFORM_PIVOT_TARGET);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_quantizeMotionSteps, QUANTIZE_MOTION_STEPS);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_quantizeMotionPhase, QUANTIZE_MOTION_PHASE);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_quantizeMotionInterpolator, QUANTIZE_MOTION_INTERPOLATOR);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_wrapBehaviorInParent, LAYOUT_WRAP_BEHAVIOR);
    }

    public ConstraintSet() {
        this.derivedState = "";
        this.mRotate = 0;
        this.mSavedAttributes = new HashMap();
        this.mForceId = true;
        this.mConstraints = new HashMap();
    }

    public static /* synthetic */ int access$100(TypedArray r0, int r1, int r2) {
        return lookupID(r0, r1, r2);
    }

    public static /* synthetic */ HashMap access$1300(ConstraintSet r0) {
        return r0.mConstraints;
    }

    public static /* synthetic */ int[] access$200() {
        return VISIBILITY_FLAGS;
    }

    public static /* synthetic */ void access$300(Constraint r0, int r1, int r2) {
        setDeltaValue(r0, r1, r2);
    }

    public static /* synthetic */ void access$400(Constraint r0, int r1, float r2) {
        setDeltaValue(r0, r1, r2);
    }

    public static /* synthetic */ void access$500(Constraint r0, int r1, String r2) {
        setDeltaValue(r0, r1, r2);
    }

    public static /* synthetic */ void access$600(Constraint r0, int r1, boolean r2) {
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
        r5 = r11.getResources().getIdentifier(r4, SlardarConfigConsts.CONFIG_ID, r11.getPackageName());
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

    public static String getDebugName(int r6) {
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
        return NetworkStackConstant.UNKNOWN_TYPE;
    }

    public static String getLine(Context r2, int r3, XmlPullParser r4) {
        return ".(" + Debug.getName(r2, r3) + ".xml:" + r4.getLineNumber() + ") \"" + r4.getName() + "\"";
    }

    private static int lookupID(TypedArray r1, int r2, int r3) {
        int r4 = r1.getResourceId(r2, r3);
        if (r4 == (-1)) goto L5;
        return r4;
    L5:
        return r1.getInt(r2, -1);
    }

    public static void parseDimensionConstraints(Object r4, TypedArray r5, int r6, int r7) {
        if (r4 != null) goto L4;
        return;
    L4:
        int r0 = r5.peekValue(r6).type;
        if (r0 == 3) goto L38;
        int r2 = 0;
        if (r0 == 5) goto L18;
        int r8 = r5.getInt(r6, 0);
        if (r8 != (-4)) goto L11;
        boolean r9 = true;
        r2 = -2;
    L20:
        if ((r4 instanceof ConstraintLayout.LayoutParams) == false) goto L26;
        ConstraintLayout.LayoutParams r10 = (ConstraintLayout.LayoutParams) r4;
        if (r7 != 0) goto L24;
        ((ViewGroup.MarginLayoutParams) r10).width = r2;
        r10.constrainedWidth = r9;
        return;
    L24:
        ((ViewGroup.MarginLayoutParams) r10).height = r2;
        r10.constrainedHeight = r9;
        return;
    L26:
        if ((r4 instanceof Layout) == false) goto L32;
        Layout r11 = (Layout) r4;
        if (r7 != 0) goto L30;
        r11.mWidth = r2;
        r11.constrainedWidth = r9;
        return;
    L30:
        r11.mHeight = r2;
        r11.constrainedHeight = r9;
        return;
    L32:
        if ((r4 instanceof Constraint.Delta) == false) goto L44;
        Constraint.Delta r12 = (Constraint.Delta) r4;
        if (r7 != 0) goto L36;
        r12.add(23, r2);
        r12.add(80, r9);
        return;
    L36:
        r12.add(21, r2);
        r12.add(CONSTRAINED_HEIGHT, r9);
        return;
    L44:
        return;
    L11:
        if (r8 == (-3)) goto L15;
        if (r8 != (-2)) goto L14;
    L16:
        r2 = r8;
        r9 = false;
        goto L20
    L14:
        if (r8 == (-1)) goto L16;
    L15:
        r9 = false;
        goto L20
    L18:
        r8 = r5.getDimensionPixelSize(r6, 0);
        goto L16
    L38:
        parseDimensionConstraintsString(r4, r5.getString(r6), r7);
    }

    public static void parseDimensionConstraintsString(Object r5, String r6, int r7) {
        if (r6 != null) goto L4;
        return;
    L4:
        int r0 = r6.indexOf(CIRCLE);
        int r1 = r6.length();
        if (r0 > 0) goto L7;
        return;
    L7:
        if (r0 >= (r1 - 1)) goto L72;
        String r2 = r6.substring(0, r0);
        String r8 = r6.substring(r0 + 1);
        if (r8.length() <= 0) goto L73;
        String r3 = r2.trim();
        String r9 = r8.trim();
        if (KEY_RATIO.equalsIgnoreCase(r3) == false) goto L69;
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
        if ((r5 instanceof Constraint.Delta) == false) goto L76;
        ((Constraint.Delta) r5).add(5, r9);
        return;
    L76:
        return;
    L69:
        if (KEY_WEIGHT.equalsIgnoreCase(r3) == false) goto L47;
        float r11 = Float.parseFloat(r9);     // Catch: NumberFormatException -> L67
        if ((r5 instanceof ConstraintLayout.LayoutParams) == false) goto L34;
        ConstraintLayout.LayoutParams r12 = (ConstraintLayout.LayoutParams) r5;     // Catch: NumberFormatException -> L67
        if (r7 != 0) goto L32;
        ((ViewGroup.MarginLayoutParams) r12).width = 0;     // Catch: NumberFormatException -> L67
        r12.horizontalWeight = r11;     // Catch: NumberFormatException -> L67
    L68:
        return;
    L32:
        ((ViewGroup.MarginLayoutParams) r12).height = 0;     // Catch: NumberFormatException -> L67
        r12.verticalWeight = r11;     // Catch: NumberFormatException -> L67
        goto L68
    L34:
        if ((r5 instanceof Layout) == false) goto L40;
        Layout r13 = (Layout) r5;     // Catch: NumberFormatException -> L67
        if (r7 != 0) goto L38;
        r13.mWidth = 0;     // Catch: NumberFormatException -> L67
        r13.horizontalWeight = r11;     // Catch: NumberFormatException -> L67
        goto L68
    L38:
        r13.mHeight = 0;     // Catch: NumberFormatException -> L67
        r13.verticalWeight = r11;     // Catch: NumberFormatException -> L67
        goto L68
    L40:
        if ((r5 instanceof Constraint.Delta) == false) goto L68;
        Constraint.Delta r14 = (Constraint.Delta) r5;     // Catch: NumberFormatException -> L67
        if (r7 != 0) goto L44;
        r14.add(23, 0);     // Catch: NumberFormatException -> L67
        r14.add(39, r11);     // Catch: NumberFormatException -> L67
        goto L68
    L44:
        r14.add(21, 0);     // Catch: NumberFormatException -> L67
        r14.add(40, r11);     // Catch: NumberFormatException -> L67
        goto L68
    L47:
        if (KEY_PERCENT_PARENT.equalsIgnoreCase(r3) == false) goto L78;
        float r15 = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(r9)));     // Catch: NumberFormatException -> L67
        if ((r5 instanceof ConstraintLayout.LayoutParams) == false) goto L55;
        ConstraintLayout.LayoutParams r16 = (ConstraintLayout.LayoutParams) r5;     // Catch: NumberFormatException -> L67
        if (r7 != 0) goto L53;
        ((ViewGroup.MarginLayoutParams) r16).width = 0;     // Catch: NumberFormatException -> L67
        r16.matchConstraintPercentWidth = r15;     // Catch: NumberFormatException -> L67
        r16.matchConstraintDefaultWidth = 2;     // Catch: NumberFormatException -> L67
        goto L68
    L53:
        ((ViewGroup.MarginLayoutParams) r16).height = 0;     // Catch: NumberFormatException -> L67
        r16.matchConstraintPercentHeight = r15;     // Catch: NumberFormatException -> L67
        r16.matchConstraintDefaultHeight = 2;     // Catch: NumberFormatException -> L67
        goto L68
    L55:
        if ((r5 instanceof Layout) == false) goto L61;
        Layout r17 = (Layout) r5;     // Catch: NumberFormatException -> L67
        if (r7 != 0) goto L59;
        r17.mWidth = 0;     // Catch: NumberFormatException -> L67
        r17.widthPercent = r15;     // Catch: NumberFormatException -> L67
        r17.widthDefault = 2;     // Catch: NumberFormatException -> L67
        goto L68
    L59:
        r17.mHeight = 0;     // Catch: NumberFormatException -> L67
        r17.heightPercent = r15;     // Catch: NumberFormatException -> L67
        r17.heightDefault = 2;     // Catch: NumberFormatException -> L67
        goto L68
    L61:
        if ((r5 instanceof Constraint.Delta) == false) goto L68;
        Constraint.Delta r18 = (Constraint.Delta) r5;     // Catch: NumberFormatException -> L67
        if (r7 != 0) goto L65;
        r18.add(23, 0);     // Catch: NumberFormatException -> L67
        r18.add(54, 2);     // Catch: NumberFormatException -> L67
        goto L68
    L65:
        r18.add(21, 0);     // Catch: NumberFormatException -> L67
        r18.add(55, 2);     // Catch: NumberFormatException -> L67
        goto L68
    L78:
        return;
    L79:
        return;
    L73:
        return;
    }

    public static void parseDimensionRatioString(ConstraintLayout.LayoutParams r8, String r9) {
        float r0 = Float.NaN;
        int r1 = -1;
        if (r9 == null) goto L34;
        int r2 = r9.length();
        int r3 = r9.indexOf(44);
        int r4 = 0;
        if (r3 > 0) goto L7;
    L15:
        int r5 = r9.indexOf(WIDTH_MIN);
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

    private void populateConstraint(Context r8, Constraint r9, TypedArray r10, boolean r11) {
        if (r11 == false) goto L5;
        populateOverride(r8, r9, r10);
        return;
    L5:
        int r7 = r10.getIndexCount();
        int r12 = 0;
    L6:
        if (r12 >= r7) goto L125;
        int r0 = r10.getIndex(r12);
        if (r0 == R.styleable.Constraint_android_id) goto L15;
        if (R.styleable.Constraint_android_layout_marginStart == r0) goto L15;
        if (R.styleable.Constraint_android_layout_marginEnd == r0) goto L15;
        r9.motion.mApply = true;
        r9.layout.mApply = true;
        r9.propertySet.mApply = true;
        r9.transform.mApply = true;
    L15:
        switch(mapToConstant.get(r0)) {
            case 1: goto L123;
            case 2: goto L122;
            case 3: goto L121;
            case 4: goto L120;
            case 5: goto L119;
            case 6: goto L118;
            case 7: goto L117;
            case 8: goto L116;
            case 9: goto L115;
            case 10: goto L114;
            case 11: goto L113;
            case 12: goto L112;
            case 13: goto L111;
            case 14: goto L110;
            case 15: goto L109;
            case 16: goto L108;
            case 17: goto L107;
            case 18: goto L106;
            case 19: goto L105;
            case 20: goto L104;
            case 21: goto L103;
            case 22: goto L102;
            case 23: goto L101;
            case 24: goto L100;
            case 25: goto L99;
            case 26: goto L98;
            case 27: goto L97;
            case 28: goto L96;
            case 29: goto L95;
            case 30: goto L94;
            case 31: goto L93;
            case 32: goto L92;
            case 33: goto L91;
            case 34: goto L90;
            case 35: goto L89;
            case 36: goto L88;
            case 37: goto L87;
            case 38: goto L86;
            case 39: goto L85;
            case 40: goto L84;
            case 41: goto L83;
            case 42: goto L82;
            case 43: goto L81;
            case 44: goto L80;
            case 45: goto L79;
            case 46: goto L78;
            case 47: goto L77;
            case 48: goto L76;
            case 49: goto L75;
            case 50: goto L74;
            case 51: goto L73;
            case 52: goto L72;
            case 53: goto L71;
            case 54: goto L70;
            case 55: goto L69;
            case 56: goto L68;
            case 57: goto L67;
            case 58: goto L66;
            case 59: goto L65;
            case 60: goto L64;
            case 61: goto L63;
            case 62: goto L62;
            case 63: goto L61;
            case 64: goto L60;
            case 65: goto L57;
            case 66: goto L55;
            case 67: goto L54;
            case 68: goto L53;
            case 69: goto L52;
            case 70: goto L51;
            case 71: goto L50;
            case 72: goto L49;
            case 73: goto L48;
            case 74: goto L47;
            case 75: goto L46;
            case 76: goto L45;
            case 77: goto L44;
            case 78: goto L43;
            case 79: goto L42;
            case 80: goto L41;
            case 81: goto L40;
            case 82: goto L39;
            case 83: goto L38;
            case 84: goto L37;
            case 85: goto L36;
            case 86: goto L25;
            case 87: goto L24;
            case 88: goto L16;
            case 89: goto L16;
            case 90: goto L16;
            case 91: goto L23;
            case 92: goto L22;
            case 93: goto L21;
            case 94: goto L20;
            case 95: goto L19;
            case 96: goto L18;
            case 97: goto L17;
            default: goto L16;
        };
    L16:
        Log.w(TAG, "Unknown attribute 0x" + Integer.toHexString(r0) + "   " + mapToConstant.get(r0));
    L124:
        r12 = r12 + 1;
        goto L6
    L17:
        Layout r1 = r9.layout;
        r1.mWrapBehavior = r10.getInt(r0, r1.mWrapBehavior);
        goto L124
    L18:
        parseDimensionConstraints(r9.layout, r10, r0, 1);
        goto L124
    L19:
        parseDimensionConstraints(r9.layout, r10, r0, 0);
        goto L124
    L20:
        Layout r2 = r9.layout;
        r2.goneBaselineMargin = r10.getDimensionPixelSize(r0, r2.goneBaselineMargin);
        goto L124
    L21:
        Layout r3 = r9.layout;
        r3.baselineMargin = r10.getDimensionPixelSize(r0, r3.baselineMargin);
        goto L124
    L22:
        Layout r4 = r9.layout;
        r4.baselineToBottom = lookupID(r10, r0, r4.baselineToBottom);
        goto L124
    L23:
        Layout r5 = r9.layout;
        r5.baselineToTop = lookupID(r10, r0, r5.baselineToTop);
        goto L124
    L24:
        Log.w(TAG, "unused attribute 0x" + Integer.toHexString(r0) + "   " + mapToConstant.get(r0));
        goto L124
    L25:
        int r6 = r10.peekValue(r0).type;
        if (r6 != 1) goto L30;
        r9.motion.mQuantizeInterpolatorID = r10.getResourceId(r0, -1);
        Motion r13 = r9.motion;
        if (r13.mQuantizeInterpolatorID == (-1)) goto L124;
        r13.mQuantizeInterpolatorType = -2;
        goto L124
    L30:
        if (r6 != 3) goto L35;
        r9.motion.mQuantizeInterpolatorString = r10.getString(r0);
        if (r9.motion.mQuantizeInterpolatorString.indexOf(LibrarianImpl.Constants.SEPARATOR) <= 0) goto L34;
        r9.motion.mQuantizeInterpolatorID = r10.getResourceId(r0, -1);
        r9.motion.mQuantizeInterpolatorType = -2;
        goto L124
    L34:
        r9.motion.mQuantizeInterpolatorType = -1;
        goto L124
    L35:
        Motion r14 = r9.motion;
        r14.mQuantizeInterpolatorType = r10.getInteger(r0, r14.mQuantizeInterpolatorID);
        goto L124
    L36:
        Motion r15 = r9.motion;
        r15.mQuantizeMotionPhase = r10.getFloat(r0, r15.mQuantizeMotionPhase);
        goto L124
    L37:
        Motion r16 = r9.motion;
        r16.mQuantizeMotionSteps = r10.getInteger(r0, r16.mQuantizeMotionSteps);
        goto L124
    L38:
        Transform r17 = r9.transform;
        r17.transformPivotTarget = lookupID(r10, r0, r17.transformPivotTarget);
        goto L124
    L39:
        Motion r18 = r9.motion;
        r18.mAnimateCircleAngleTo = r10.getInteger(r0, r18.mAnimateCircleAngleTo);
        goto L124
    L40:
        Layout r19 = r9.layout;
        r19.constrainedHeight = r10.getBoolean(r0, r19.constrainedHeight);
        goto L124
    L41:
        Layout r20 = r9.layout;
        r20.constrainedWidth = r10.getBoolean(r0, r20.constrainedWidth);
        goto L124
    L42:
        Motion r21 = r9.motion;
        r21.mMotionStagger = r10.getFloat(r0, r21.mMotionStagger);
        goto L124
    L43:
        PropertySet r22 = r9.propertySet;
        r22.mVisibilityMode = r10.getInt(r0, r22.mVisibilityMode);
        goto L124
    L44:
        r9.layout.mConstraintTag = r10.getString(r0);
        goto L124
    L45:
        Motion r23 = r9.motion;
        r23.mPathMotionArc = r10.getInt(r0, r23.mPathMotionArc);
        goto L124
    L46:
        Layout r24 = r9.layout;
        r24.mBarrierAllowsGoneWidgets = r10.getBoolean(r0, r24.mBarrierAllowsGoneWidgets);
        goto L124
    L47:
        r9.layout.mReferenceIdString = r10.getString(r0);
        goto L124
    L48:
        Layout r25 = r9.layout;
        r25.mBarrierMargin = r10.getDimensionPixelSize(r0, r25.mBarrierMargin);
        goto L124
    L49:
        Layout r26 = r9.layout;
        r26.mBarrierDirection = r10.getInt(r0, r26.mBarrierDirection);
        goto L124
    L50:
        Log.e(TAG, "CURRENTLY UNSUPPORTED");
        goto L124
    L51:
        r9.layout.heightPercent = r10.getFloat(r0, 1.0f);
        goto L124
    L52:
        r9.layout.widthPercent = r10.getFloat(r0, 1.0f);
        goto L124
    L53:
        PropertySet r27 = r9.propertySet;
        r27.mProgress = r10.getFloat(r0, r27.mProgress);
        goto L124
    L54:
        Motion r28 = r9.motion;
        r28.mPathRotate = r10.getFloat(r0, r28.mPathRotate);
        goto L124
    L55:
        r9.motion.mDrawPath = r10.getInt(r0, 0);
        goto L124
    L60:
        Motion r29 = r9.motion;
        r29.mAnimateRelativeTo = lookupID(r10, r0, r29.mAnimateRelativeTo);
        goto L124
    L61:
        Layout r30 = r9.layout;
        r30.circleAngle = r10.getFloat(r0, r30.circleAngle);
        goto L124
    L62:
        Layout r31 = r9.layout;
        r31.circleRadius = r10.getDimensionPixelSize(r0, r31.circleRadius);
        goto L124
    L63:
        Layout r32 = r9.layout;
        r32.circleConstraint = lookupID(r10, r0, r32.circleConstraint);
        goto L124
    L64:
        Transform r33 = r9.transform;
        r33.rotation = r10.getFloat(r0, r33.rotation);
        goto L124
    L65:
        Layout r34 = r9.layout;
        r34.heightMin = r10.getDimensionPixelSize(r0, r34.heightMin);
        goto L124
    L66:
        Layout r35 = r9.layout;
        r35.widthMin = r10.getDimensionPixelSize(r0, r35.widthMin);
        goto L124
    L67:
        Layout r36 = r9.layout;
        r36.heightMax = r10.getDimensionPixelSize(r0, r36.heightMax);
        goto L124
    L68:
        Layout r37 = r9.layout;
        r37.widthMax = r10.getDimensionPixelSize(r0, r37.widthMax);
        goto L124
    L69:
        Layout r38 = r9.layout;
        r38.heightDefault = r10.getInt(r0, r38.heightDefault);
        goto L124
    L70:
        Layout r39 = r9.layout;
        r39.widthDefault = r10.getInt(r0, r39.widthDefault);
        goto L124
    L71:
        Transform r40 = r9.transform;
        r40.translationZ = r10.getDimension(r0, r40.translationZ);
        goto L124
    L72:
        Transform r41 = r9.transform;
        r41.translationY = r10.getDimension(r0, r41.translationY);
        goto L124
    L73:
        Transform r42 = r9.transform;
        r42.translationX = r10.getDimension(r0, r42.translationX);
        goto L124
    L74:
        Transform r43 = r9.transform;
        r43.transformPivotY = r10.getDimension(r0, r43.transformPivotY);
        goto L124
    L75:
        Transform r44 = r9.transform;
        r44.transformPivotX = r10.getDimension(r0, r44.transformPivotX);
        goto L124
    L76:
        Transform r45 = r9.transform;
        r45.scaleY = r10.getFloat(r0, r45.scaleY);
        goto L124
    L77:
        Transform r46 = r9.transform;
        r46.scaleX = r10.getFloat(r0, r46.scaleX);
        goto L124
    L78:
        Transform r47 = r9.transform;
        r47.rotationY = r10.getFloat(r0, r47.rotationY);
        goto L124
    L79:
        Transform r48 = r9.transform;
        r48.rotationX = r10.getFloat(r0, r48.rotationX);
        goto L124
    L80:
        Transform r49 = r9.transform;
        r49.applyElevation = true;
        r49.elevation = r10.getDimension(r0, r49.elevation);
        goto L124
    L81:
        PropertySet r50 = r9.propertySet;
        r50.alpha = r10.getFloat(r0, r50.alpha);
        goto L124
    L82:
        Layout r51 = r9.layout;
        r51.verticalChainStyle = r10.getInt(r0, r51.verticalChainStyle);
        goto L124
    L83:
        Layout r52 = r9.layout;
        r52.horizontalChainStyle = r10.getInt(r0, r52.horizontalChainStyle);
        goto L124
    L84:
        Layout r53 = r9.layout;
        r53.verticalWeight = r10.getFloat(r0, r53.verticalWeight);
        goto L124
    L85:
        Layout r54 = r9.layout;
        r54.horizontalWeight = r10.getFloat(r0, r54.horizontalWeight);
        goto L124
    L86:
        r9.mViewId = r10.getResourceId(r0, r9.mViewId);
        goto L124
    L87:
        Layout r55 = r9.layout;
        r55.verticalBias = r10.getFloat(r0, r55.verticalBias);
        goto L124
    L88:
        Layout r56 = r9.layout;
        r56.topToTop = lookupID(r10, r0, r56.topToTop);
        goto L124
    L89:
        Layout r57 = r9.layout;
        r57.topToBottom = lookupID(r10, r0, r57.topToBottom);
        goto L124
    L90:
        Layout r58 = r9.layout;
        r58.topMargin = r10.getDimensionPixelSize(r0, r58.topMargin);
        goto L124
    L91:
        Layout r59 = r9.layout;
        r59.startToStart = lookupID(r10, r0, r59.startToStart);
        goto L124
    L92:
        Layout r60 = r9.layout;
        r60.startToEnd = lookupID(r10, r0, r60.startToEnd);
        goto L124
    L93:
        Layout r61 = r9.layout;
        r61.startMargin = r10.getDimensionPixelSize(r0, r61.startMargin);
        goto L124
    L94:
        Layout r62 = r9.layout;
        r62.rightToRight = lookupID(r10, r0, r62.rightToRight);
        goto L124
    L95:
        Layout r63 = r9.layout;
        r63.rightToLeft = lookupID(r10, r0, r63.rightToLeft);
        goto L124
    L96:
        Layout r64 = r9.layout;
        r64.rightMargin = r10.getDimensionPixelSize(r0, r64.rightMargin);
        goto L124
    L97:
        Layout r65 = r9.layout;
        r65.orientation = r10.getInt(r0, r65.orientation);
        goto L124
    L98:
        Layout r66 = r9.layout;
        r66.leftToRight = lookupID(r10, r0, r66.leftToRight);
        goto L124
    L99:
        Layout r67 = r9.layout;
        r67.leftToLeft = lookupID(r10, r0, r67.leftToLeft);
        goto L124
    L100:
        Layout r68 = r9.layout;
        r68.leftMargin = r10.getDimensionPixelSize(r0, r68.leftMargin);
        goto L124
    L101:
        Layout r69 = r9.layout;
        r69.mWidth = r10.getLayoutDimension(r0, r69.mWidth);
        goto L124
    L102:
        PropertySet r70 = r9.propertySet;
        r70.visibility = r10.getInt(r0, r70.visibility);
        PropertySet r71 = r9.propertySet;
        r71.visibility = VISIBILITY_FLAGS[r71.visibility];
        goto L124
    L103:
        Layout r72 = r9.layout;
        r72.mHeight = r10.getLayoutDimension(r0, r72.mHeight);
        goto L124
    L104:
        Layout r73 = r9.layout;
        r73.horizontalBias = r10.getFloat(r0, r73.horizontalBias);
        goto L124
    L105:
        Layout r74 = r9.layout;
        r74.guidePercent = r10.getFloat(r0, r74.guidePercent);
        goto L124
    L106:
        Layout r75 = r9.layout;
        r75.guideEnd = r10.getDimensionPixelOffset(r0, r75.guideEnd);
        goto L124
    L107:
        Layout r76 = r9.layout;
        r76.guideBegin = r10.getDimensionPixelOffset(r0, r76.guideBegin);
        goto L124
    L108:
        Layout r77 = r9.layout;
        r77.goneTopMargin = r10.getDimensionPixelSize(r0, r77.goneTopMargin);
        goto L124
    L109:
        Layout r78 = r9.layout;
        r78.goneStartMargin = r10.getDimensionPixelSize(r0, r78.goneStartMargin);
        goto L124
    L110:
        Layout r79 = r9.layout;
        r79.goneRightMargin = r10.getDimensionPixelSize(r0, r79.goneRightMargin);
        goto L124
    L111:
        Layout r80 = r9.layout;
        r80.goneLeftMargin = r10.getDimensionPixelSize(r0, r80.goneLeftMargin);
        goto L124
    L112:
        Layout r81 = r9.layout;
        r81.goneEndMargin = r10.getDimensionPixelSize(r0, r81.goneEndMargin);
        goto L124
    L113:
        Layout r82 = r9.layout;
        r82.goneBottomMargin = r10.getDimensionPixelSize(r0, r82.goneBottomMargin);
        goto L124
    L114:
        Layout r83 = r9.layout;
        r83.endToStart = lookupID(r10, r0, r83.endToStart);
        goto L124
    L115:
        Layout r84 = r9.layout;
        r84.endToEnd = lookupID(r10, r0, r84.endToEnd);
        goto L124
    L116:
        Layout r85 = r9.layout;
        r85.endMargin = r10.getDimensionPixelSize(r0, r85.endMargin);
        goto L124
    L117:
        Layout r86 = r9.layout;
        r86.editorAbsoluteY = r10.getDimensionPixelOffset(r0, r86.editorAbsoluteY);
        goto L124
    L118:
        Layout r87 = r9.layout;
        r87.editorAbsoluteX = r10.getDimensionPixelOffset(r0, r87.editorAbsoluteX);
        goto L124
    L119:
        r9.layout.dimensionRatio = r10.getString(r0);
        goto L124
    L120:
        Layout r88 = r9.layout;
        r88.bottomToTop = lookupID(r10, r0, r88.bottomToTop);
        goto L124
    L121:
        Layout r89 = r9.layout;
        r89.bottomToBottom = lookupID(r10, r0, r89.bottomToBottom);
        goto L124
    L122:
        Layout r90 = r9.layout;
        r90.bottomMargin = r10.getDimensionPixelSize(r0, r90.bottomMargin);
        goto L124
    L123:
        Layout r91 = r9.layout;
        r91.baselineToBaseline = lookupID(r10, r0, r91.baselineToBaseline);
        goto L124
    L57:
        if (r10.peekValue(r0).type != 3) goto L59;
        r9.motion.mTransitionEasing = r10.getString(r0);
        goto L124
    L59:
        r9.motion.mTransitionEasing = Easing.NAMED_EASING[r10.getInteger(r0, 0)];
        goto L124
    L125:
        Layout r92 = r9.layout;
        if (r92.mReferenceIdString == null) goto L230;
        r92.mReferenceIds = null;
        return;
    }

    private static void populateOverride(Context r11, Constraint r12, TypedArray r13) {
        int r14 = r13.getIndexCount();
        Constraint.Delta r0 = new Constraint.Delta();
        r12.mDelta = r0;
        r12.motion.mApply = false;
        r12.layout.mApply = false;
        r12.propertySet.mApply = false;
        r12.transform.mApply = false;
        int r1 = 0;
    L3:
        if (r1 >= r14) goto L109;
        int r3 = r13.getIndex(r1);
        switch(overrideMapToConstant.get(r3)) {
            case 2: goto L107;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L106;
            case 6: goto L105;
            case 7: goto L104;
            case 8: goto L103;
            case 9: goto L6;
            case 10: goto L6;
            case 11: goto L102;
            case 12: goto L101;
            case 13: goto L100;
            case 14: goto L99;
            case 15: goto L98;
            case 16: goto L97;
            case 17: goto L96;
            case 18: goto L95;
            case 19: goto L94;
            case 20: goto L93;
            case 21: goto L92;
            case 22: goto L91;
            case 23: goto L90;
            case 24: goto L89;
            case 25: goto L6;
            case 26: goto L6;
            case 27: goto L88;
            case 28: goto L87;
            case 29: goto L6;
            case 30: goto L6;
            case 31: goto L86;
            case 32: goto L6;
            case 33: goto L6;
            case 34: goto L85;
            case 35: goto L6;
            case 36: goto L6;
            case 37: goto L84;
            case 38: goto L83;
            case 39: goto L82;
            case 40: goto L81;
            case 41: goto L80;
            case 42: goto L79;
            case 43: goto L78;
            case 44: goto L77;
            case 45: goto L76;
            case 46: goto L75;
            case 47: goto L74;
            case 48: goto L73;
            case 49: goto L72;
            case 50: goto L71;
            case 51: goto L70;
            case 52: goto L69;
            case 53: goto L68;
            case 54: goto L67;
            case 55: goto L66;
            case 56: goto L65;
            case 57: goto L64;
            case 58: goto L63;
            case 59: goto L62;
            case 60: goto L61;
            case 61: goto L6;
            case 62: goto L60;
            case 63: goto L59;
            case 64: goto L58;
            case 65: goto L55;
            case 66: goto L53;
            case 67: goto L52;
            case 68: goto L51;
            case 69: goto L50;
            case 70: goto L49;
            case 71: goto L48;
            case 72: goto L47;
            case 73: goto L46;
            case 74: goto L45;
            case 75: goto L44;
            case 76: goto L43;
            case 77: goto L42;
            case 78: goto L41;
            case 79: goto L40;
            case 80: goto L39;
            case 81: goto L38;
            case 82: goto L37;
            case 83: goto L36;
            case 84: goto L35;
            case 85: goto L34;
            case 86: goto L23;
            case 87: goto L22;
            case 88: goto L6;
            case 89: goto L6;
            case 90: goto L6;
            case 91: goto L6;
            case 92: goto L6;
            case 93: goto L21;
            case 94: goto L20;
            case 95: goto L19;
            case 96: goto L18;
            case 97: goto L17;
            case 98: goto L9;
            case 99: goto L7;
            default: goto L6;
        };
    L6:
        Log.w(TAG, "Unknown attribute 0x" + Integer.toHexString(r3) + "   " + mapToConstant.get(r3));
    L108:
        r1 = r1 + 1;
        goto L3
    L7:
        r0.add(GUIDELINE_USE_RTL, r13.getBoolean(r3, r12.layout.guidelineUseRtl));
        goto L108
    L17:
        r0.add(LAYOUT_WRAP_BEHAVIOR, r13.getInt(r3, r12.layout.mWrapBehavior));
        goto L108
    L18:
        parseDimensionConstraints(r0, r13, r3, 1);
        goto L108
    L19:
        parseDimensionConstraints(r0, r13, r3, 0);
        goto L108
    L20:
        r0.add(GONE_BASELINE_MARGIN, r13.getDimensionPixelSize(r3, r12.layout.goneBaselineMargin));
        goto L108
    L21:
        r0.add(BASELINE_MARGIN, r13.getDimensionPixelSize(r3, r12.layout.baselineMargin));
        goto L108
    L22:
        Log.w(TAG, "unused attribute 0x" + Integer.toHexString(r3) + "   " + mapToConstant.get(r3));
        goto L108
    L23:
        int r4 = r13.peekValue(r3).type;
        if (r4 != 1) goto L28;
        r12.motion.mQuantizeInterpolatorID = r13.getResourceId(r3, -1);
        r0.add(QUANTIZE_MOTION_INTERPOLATOR_ID, r12.motion.mQuantizeInterpolatorID);
        Motion r5 = r12.motion;
        if (r5.mQuantizeInterpolatorID == (-1)) goto L108;
        r5.mQuantizeInterpolatorType = -2;
        r0.add(QUANTIZE_MOTION_INTERPOLATOR_TYPE, -2);
        goto L108
    L28:
        if (r4 != 3) goto L33;
        r12.motion.mQuantizeInterpolatorString = r13.getString(r3);
        r0.add(QUANTIZE_MOTION_INTERPOLATOR_STR, r12.motion.mQuantizeInterpolatorString);
        if (r12.motion.mQuantizeInterpolatorString.indexOf(LibrarianImpl.Constants.SEPARATOR) <= 0) goto L32;
        r12.motion.mQuantizeInterpolatorID = r13.getResourceId(r3, -1);
        r0.add(QUANTIZE_MOTION_INTERPOLATOR_ID, r12.motion.mQuantizeInterpolatorID);
        r12.motion.mQuantizeInterpolatorType = -2;
        r0.add(QUANTIZE_MOTION_INTERPOLATOR_TYPE, -2);
        goto L108
    L32:
        r12.motion.mQuantizeInterpolatorType = -1;
        r0.add(QUANTIZE_MOTION_INTERPOLATOR_TYPE, -1);
        goto L108
    L33:
        Motion r6 = r12.motion;
        r6.mQuantizeInterpolatorType = r13.getInteger(r3, r6.mQuantizeInterpolatorID);
        r0.add(QUANTIZE_MOTION_INTERPOLATOR_TYPE, r12.motion.mQuantizeInterpolatorType);
        goto L108
    L34:
        r0.add(QUANTIZE_MOTION_PHASE, r13.getFloat(r3, r12.motion.mQuantizeMotionPhase));
        goto L108
    L35:
        r0.add(QUANTIZE_MOTION_STEPS, r13.getInteger(r3, r12.motion.mQuantizeMotionSteps));
        goto L108
    L36:
        r0.add(TRANSFORM_PIVOT_TARGET, lookupID(r13, r3, r12.transform.transformPivotTarget));
        goto L108
    L37:
        r0.add(ANIMATE_CIRCLE_ANGLE_TO, r13.getInteger(r3, r12.motion.mAnimateCircleAngleTo));
        goto L108
    L38:
        r0.add(CONSTRAINED_HEIGHT, r13.getBoolean(r3, r12.layout.constrainedHeight));
        goto L108
    L39:
        r0.add(80, r13.getBoolean(r3, r12.layout.constrainedWidth));
        goto L108
    L40:
        r0.add(MOTION_STAGGER, r13.getFloat(r3, r12.motion.mMotionStagger));
        goto L108
    L41:
        r0.add(VISIBILITY_MODE, r13.getInt(r3, r12.propertySet.mVisibilityMode));
        goto L108
    L42:
        r0.add(CONSTRAINT_TAG, r13.getString(r3));
        goto L108
    L43:
        r0.add(PATH_MOTION_ARC, r13.getInt(r3, r12.motion.mPathMotionArc));
        goto L108
    L44:
        r0.add(BARRIER_ALLOWS_GONE_WIDGETS, r13.getBoolean(r3, r12.layout.mBarrierAllowsGoneWidgets));
        goto L108
    L45:
        r0.add(CONSTRAINT_REFERENCED_IDS, r13.getString(r3));
        goto L108
    L46:
        r0.add(BARRIER_MARGIN, r13.getDimensionPixelSize(r3, r12.layout.mBarrierMargin));
        goto L108
    L47:
        r0.add(BARRIER_DIRECTION, r13.getInt(r3, r12.layout.mBarrierDirection));
        goto L108
    L48:
        Log.e(TAG, "CURRENTLY UNSUPPORTED");
        goto L108
    L49:
        r0.add(HEIGHT_PERCENT, r13.getFloat(r3, 1.0f));
        goto L108
    L50:
        r0.add(WIDTH_PERCENT, r13.getFloat(r3, 1.0f));
        goto L108
    L51:
        r0.add(PROGRESS, r13.getFloat(r3, r12.propertySet.mProgress));
        goto L108
    L52:
        r0.add(67, r13.getFloat(r3, r12.motion.mPathRotate));
        goto L108
    L53:
        r0.add(66, r13.getInt(r3, 0));
        goto L108
    L58:
        r0.add(64, lookupID(r13, r3, r12.motion.mAnimateRelativeTo));
        goto L108
    L59:
        r0.add(63, r13.getFloat(r3, r12.layout.circleAngle));
        goto L108
    L60:
        r0.add(CIRCLE_RADIUS, r13.getDimensionPixelSize(r3, r12.layout.circleRadius));
        goto L108
    L61:
        r0.add(60, r13.getFloat(r3, r12.transform.rotation));
        goto L108
    L62:
        r0.add(HEIGHT_MIN, r13.getDimensionPixelSize(r3, r12.layout.heightMin));
        goto L108
    L63:
        r0.add(WIDTH_MIN, r13.getDimensionPixelSize(r3, r12.layout.widthMin));
        goto L108
    L64:
        r0.add(HEIGHT_MAX, r13.getDimensionPixelSize(r3, r12.layout.heightMax));
        goto L108
    L65:
        r0.add(WIDTH_MAX, r13.getDimensionPixelSize(r3, r12.layout.widthMax));
        goto L108
    L66:
        r0.add(55, r13.getInt(r3, r12.layout.heightDefault));
        goto L108
    L67:
        r0.add(54, r13.getInt(r3, r12.layout.widthDefault));
        goto L108
    L68:
        r0.add(53, r13.getDimension(r3, r12.transform.translationZ));
        goto L108
    L69:
        r0.add(52, r13.getDimension(r3, r12.transform.translationY));
        goto L108
    L70:
        r0.add(51, r13.getDimension(r3, r12.transform.translationX));
        goto L108
    L71:
        r0.add(50, r13.getDimension(r3, r12.transform.transformPivotY));
        goto L108
    L72:
        r0.add(49, r13.getDimension(r3, r12.transform.transformPivotX));
        goto L108
    L73:
        r0.add(48, r13.getFloat(r3, r12.transform.scaleY));
        goto L108
    L74:
        r0.add(47, r13.getFloat(r3, r12.transform.scaleX));
        goto L108
    L75:
        r0.add(46, r13.getFloat(r3, r12.transform.rotationY));
        goto L108
    L76:
        r0.add(45, r13.getFloat(r3, r12.transform.rotationX));
        goto L108
    L77:
        r0.add(44, true);
        r0.add(44, r13.getDimension(r3, r12.transform.elevation));
        goto L108
    L78:
        r0.add(43, r13.getFloat(r3, r12.propertySet.alpha));
        goto L108
    L79:
        r0.add(42, r13.getInt(r3, r12.layout.verticalChainStyle));
        goto L108
    L80:
        r0.add(41, r13.getInt(r3, r12.layout.horizontalChainStyle));
        goto L108
    L81:
        r0.add(40, r13.getFloat(r3, r12.layout.verticalWeight));
        goto L108
    L82:
        r0.add(39, r13.getFloat(r3, r12.layout.horizontalWeight));
        goto L108
    L83:
        int r7 = r13.getResourceId(r3, r12.mViewId);
        r12.mViewId = r7;
        r0.add(38, r7);
        goto L108
    L84:
        r0.add(37, r13.getFloat(r3, r12.layout.verticalBias));
        goto L108
    L85:
        r0.add(34, r13.getDimensionPixelSize(r3, r12.layout.topMargin));
        goto L108
    L86:
        r0.add(31, r13.getDimensionPixelSize(r3, r12.layout.startMargin));
        goto L108
    L87:
        r0.add(28, r13.getDimensionPixelSize(r3, r12.layout.rightMargin));
        goto L108
    L88:
        r0.add(27, r13.getInt(r3, r12.layout.orientation));
        goto L108
    L89:
        r0.add(24, r13.getDimensionPixelSize(r3, r12.layout.leftMargin));
        goto L108
    L90:
        r0.add(23, r13.getLayoutDimension(r3, r12.layout.mWidth));
        goto L108
    L91:
        r0.add(22, VISIBILITY_FLAGS[r13.getInt(r3, r12.propertySet.visibility)]);
        goto L108
    L92:
        r0.add(21, r13.getLayoutDimension(r3, r12.layout.mHeight));
        goto L108
    L93:
        r0.add(20, r13.getFloat(r3, r12.layout.horizontalBias));
        goto L108
    L94:
        r0.add(19, r13.getFloat(r3, r12.layout.guidePercent));
        goto L108
    L95:
        r0.add(18, r13.getDimensionPixelOffset(r3, r12.layout.guideEnd));
        goto L108
    L96:
        r0.add(17, r13.getDimensionPixelOffset(r3, r12.layout.guideBegin));
        goto L108
    L97:
        r0.add(16, r13.getDimensionPixelSize(r3, r12.layout.goneTopMargin));
        goto L108
    L98:
        r0.add(15, r13.getDimensionPixelSize(r3, r12.layout.goneStartMargin));
        goto L108
    L99:
        r0.add(14, r13.getDimensionPixelSize(r3, r12.layout.goneRightMargin));
        goto L108
    L100:
        r0.add(13, r13.getDimensionPixelSize(r3, r12.layout.goneLeftMargin));
        goto L108
    L101:
        r0.add(12, r13.getDimensionPixelSize(r3, r12.layout.goneEndMargin));
        goto L108
    L102:
        r0.add(11, r13.getDimensionPixelSize(r3, r12.layout.goneBottomMargin));
        goto L108
    L103:
        r0.add(8, r13.getDimensionPixelSize(r3, r12.layout.endMargin));
        goto L108
    L104:
        r0.add(7, r13.getDimensionPixelOffset(r3, r12.layout.editorAbsoluteY));
        goto L108
    L105:
        r0.add(6, r13.getDimensionPixelOffset(r3, r12.layout.editorAbsoluteX));
        goto L108
    L106:
        r0.add(5, r13.getString(r3));
        goto L108
    L107:
        r0.add(2, r13.getDimensionPixelSize(r3, r12.layout.bottomMargin));
        goto L108
    L9:
        if (MotionLayout.IS_IN_EDIT_MODE == false) goto L14;
        int r8 = r13.getResourceId(r3, r12.mViewId);
        r12.mViewId = r8;
        if (r8 != (-1)) goto L108;
        r12.mTargetString = r13.getString(r3);
        goto L108
    L14:
        if (r13.peekValue(r3).type != 3) goto L16;
        r12.mTargetString = r13.getString(r3);
        goto L108
    L16:
        r12.mViewId = r13.getResourceId(r3, r12.mViewId);
        goto L108
    L55:
        if (r13.peekValue(r3).type != 3) goto L57;
        r0.add(65, r13.getString(r3));
        goto L108
    L57:
        r0.add(65, Easing.NAMED_EASING[r13.getInteger(r3, 0)]);
        goto L108
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
        if (r2 != MOTION_STAGGER) goto L15;
        r1.motion.mMotionStagger = r3;
        return;
    L15:
        if (r2 != QUANTIZE_MOTION_PHASE) goto L17;
        r1.motion.mQuantizeMotionPhase = r3;
        return;
    L17:
        if (r2 != UNUSED) goto L19;
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
        return TraceStatsConsts.STATS_KEY_END;
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
        char r4 = r7[r1];
        if (r4 != ',') goto L10;
        if (r3 == true) goto L10;
        r0.add(new String(r7, r2, r1 - r2));
        r2 = r1 + 1;
    L12:
        r1 = r1 + 1;
    L10:
        if (r4 != '\"') goto L12;
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

    public void applyToInternal(ConstraintLayout r12, boolean r13) {
        int r0 = r12.getChildCount();
        HashSet r1 = new HashSet(this.mConstraints.keySet());
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r3 >= r0) goto L55;
        View r5 = r12.getChildAt(r3);
        int r6 = r5.getId();
        if (this.mConstraints.containsKey(Integer.valueOf(r6)) == true) goto L9;
        Log.w(TAG, "id unknown " + Debug.getName(r5));
    L54:
        r3 = r3 + 1;
        goto L4
    L9:
        if (this.mForceId == false) goto L14;
        if (r6 != (-1)) goto L14;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L14:
        if (r6 == (-1)) goto L54;
        if (this.mConstraints.containsKey(Integer.valueOf(r6)) == false) goto L53;
        r1.remove(Integer.valueOf(r6));
        Constraint r7 = this.mConstraints.get(Integer.valueOf(r6));
        if (r7 == null) goto L54;
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
        r5.setAlpha(r7.propertySet.alpha);
        r5.setRotation(r7.transform.rotation);
        r5.setRotationX(r7.transform.rotationX);
        r5.setRotationY(r7.transform.rotationY);
        r5.setScaleX(r7.transform.scaleX);
        r5.setScaleY(r7.transform.scaleY);
        Transform r15 = r7.transform;
        if (r15.transformPivotTarget == (-1)) goto L45;
        View r16 = ((View) r5.getParent()).findViewById(r7.transform.transformPivotTarget);
        if (r16 == null) goto L50;
        float r17 = (r16.getBottom() + r16.getTop()) / 2.0f;
        float r18 = (r16.getRight() + r16.getLeft()) / 2.0f;
        if ((r5.getRight() - r5.getLeft()) <= 0) goto L50;
        if ((r5.getBottom() - r5.getTop()) <= 0) goto L50;
        float r19 = r18 - r5.getLeft();
        float r20 = r17 - r5.getTop();
        r5.setPivotX(r19);
        r5.setPivotY(r20);
    L50:
        r5.setTranslationX(r7.transform.translationX);
        r5.setTranslationY(r7.transform.translationY);
        r5.setTranslationZ(r7.transform.translationZ);
        Transform r21 = r7.transform;
        if (r21.applyElevation == false) goto L54;
        r5.setElevation(r21.elevation);
        goto L54
    L45:
        if (Float.isNaN(r15.transformPivotX) == true) goto L48;
        r5.setPivotX(r7.transform.transformPivotX);
    L48:
        if (Float.isNaN(r7.transform.transformPivotY) == true) goto L50;
        r5.setPivotY(r7.transform.transformPivotY);
        goto L50
    L53:
        Log.v(TAG, "WARNING NO CONSTRAINTS for view " + r6);
        goto L54
    L55:
        Iterator r110 = r1.iterator();
    L57:
        if (r110.hasNext() == false) goto L73;
        Integer r22 = (Integer) r110.next();
        Constraint r23 = this.mConstraints.get(r22);
        if (r23 == null) goto L57;
        if (r23.layout.mHelperType != 1) goto L71;
        Barrier r24 = new Barrier(r12.getContext());
        r24.setId(r22.intValue());
        Layout r25 = r23.layout;
        int[] r26 = r25.mReferenceIds;
        if (r26 == null) goto L66;
        r24.setReferencedIds(r26);
    L69:
        r24.setType(r23.layout.mBarrierDirection);
        r24.setMargin(r23.layout.mBarrierMargin);
        ConstraintLayout.LayoutParams r27 = r12.generateDefaultLayoutParams();
        r24.validateParams();
        r23.applyTo(r27);
        r12.addView(r24, r27);
        goto L71
    L66:
        String r28 = r25.mReferenceIdString;
        if (r28 == null) goto L69;
        r25.mReferenceIds = convertReferenceString(r24, r28);
        r24.setReferencedIds(r23.layout.mReferenceIds);
    L71:
        if (r23.layout.mIsGuideline == false) goto L57;
        View r29 = new Guideline(r12.getContext());
        r29.setId(r22.intValue());
        ConstraintLayout.LayoutParams r30 = r12.generateDefaultLayoutParams();
        r23.applyTo(r30);
        r12.addView(r29, r30);
    L73:
        if (r2 >= r0) goto L78;
        View r111 = r12.getChildAt(r2);
        if ((r111 instanceof ConstraintHelper) == false) goto L77;
        ((ConstraintHelper) r111).applyLayoutFeaturesInConstraintSet(r12);
    L77:
        r2 = r2 + 1;
        goto L73
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
        if (r0 == null) goto L39;
        r0.layout.horizontalBias = r16;
        return;
    L39:
        return;
    L12:
        if (r11 == 2) goto L25;
        if (r11 != 6) goto L17;
    L22:
        connect(r9, 6, r10, r11, r12);
        connect(r9, 7, r13, r14, r15);
        Constraint r1 = this.mConstraints.get(Integer.valueOf(r9));
        if (r1 == null) goto L37;
        r1.layout.horizontalBias = r16;
        return;
    L37:
        return;
    L17:
        if (r11 == 7) goto L22;
        connect(r9, 3, r10, r11, r12);
        connect(r9, 4, r13, r14, r15);
        Constraint r2 = this.mConstraints.get(Integer.valueOf(r9));
        if (r2 == null) goto L35;
        r2.layout.verticalBias = r16;
        return;
    L35:
        return;
    L30:
        throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
    L32:
        throw new IllegalArgumentException("margin must be > 0");
    L34:
        throw new IllegalArgumentException("margin must be > 0");
    }

    public void centerHorizontally(int r10, int r11, int r12, int r13, int r14, int r15, int r16, float r17) {
        connect(r10, 1, r11, r12, r13);
        connect(r10, 2, r14, r15, r16);
        Constraint r0 = this.mConstraints.get(Integer.valueOf(r10));
        if (r0 == null) goto L6;
        r0.layout.horizontalBias = r17;
        return;
    }

    public void centerHorizontallyRtl(int r10, int r11, int r12, int r13, int r14, int r15, int r16, float r17) {
        connect(r10, 6, r11, r12, r13);
        connect(r10, 7, r14, r15, r16);
        Constraint r0 = this.mConstraints.get(Integer.valueOf(r10));
        if (r0 == null) goto L6;
        r0.layout.horizontalBias = r17;
        return;
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

    public void clone(Context r2, int r3) {
        clone((ConstraintLayout) LayoutInflater.from(r2).inflate(r3, null));
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
            case 1: goto L56;
            case 2: goto L49;
            case 3: goto L42;
            case 4: goto L35;
            case 5: goto L27;
            case 6: goto L19;
            case 7: goto L12;
            default: goto L10;
        };
    L10:
        StringBuilder r16 = new StringBuilder();
        r16.append(sideToString(r11));
        r16.append(" to ");
        throw new IllegalArgumentException(a.o(r16, sideToString(r13), " unknown"));
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
        Layout r17 = r15.layout;
        r17.endToStart = r12;
        r17.endToEnd = -1;
        goto L16
    L18:
        throw new IllegalArgumentException(a.o(new StringBuilder("right to "), sideToString(r13), " undefined"));
    L19:
        if (r13 != 6) goto L21;
        Layout r18 = r15.layout;
        r18.startToStart = r12;
        r18.startToEnd = -1;
    L23:
        r15.layout.startMargin = r14;
        return;
    L21:
        if (r13 != 7) goto L25;
        Layout r19 = r15.layout;
        r19.startToEnd = r12;
        r19.startToStart = -1;
        goto L23
    L25:
        throw new IllegalArgumentException(a.o(new StringBuilder("right to "), sideToString(r13), " undefined"));
    L35:
        if (r13 != 4) goto L37;
        Layout r20 = r15.layout;
        r20.bottomToBottom = r12;
        r20.bottomToTop = -1;
        r20.baselineToBaseline = -1;
        r20.baselineToTop = -1;
        r20.baselineToBottom = -1;
    L39:
        r15.layout.bottomMargin = r14;
        return;
    L37:
        if (r13 != 3) goto L41;
        Layout r21 = r15.layout;
        r21.bottomToTop = r12;
        r21.bottomToBottom = -1;
        r21.baselineToBaseline = -1;
        r21.baselineToTop = -1;
        r21.baselineToBottom = -1;
        goto L39
    L41:
        throw new IllegalArgumentException(a.o(new StringBuilder("right to "), sideToString(r13), " undefined"));
    L42:
        if (r13 != 3) goto L44;
        Layout r22 = r15.layout;
        r22.topToTop = r12;
        r22.topToBottom = -1;
        r22.baselineToBaseline = -1;
        r22.baselineToTop = -1;
        r22.baselineToBottom = -1;
    L46:
        r15.layout.topMargin = r14;
        return;
    L44:
        if (r13 != 4) goto L48;
        Layout r23 = r15.layout;
        r23.topToBottom = r12;
        r23.topToTop = -1;
        r23.baselineToBaseline = -1;
        r23.baselineToTop = -1;
        r23.baselineToBottom = -1;
        goto L46
    L48:
        throw new IllegalArgumentException(a.o(new StringBuilder("right to "), sideToString(r13), " undefined"));
    L49:
        if (r13 != 1) goto L51;
        Layout r24 = r15.layout;
        r24.rightToLeft = r12;
        r24.rightToRight = -1;
    L53:
        r15.layout.rightMargin = r14;
        return;
    L51:
        if (r13 != 2) goto L55;
        Layout r25 = r15.layout;
        r25.rightToRight = r12;
        r25.rightToLeft = -1;
        goto L53
    L55:
        throw new IllegalArgumentException(a.o(new StringBuilder("right to "), sideToString(r13), " undefined"));
    L56:
        if (r13 != 1) goto L58;
        Layout r26 = r15.layout;
        r26.leftToLeft = r12;
        r26.leftToRight = -1;
    L60:
        r15.layout.leftMargin = r14;
        return;
    L58:
        if (r13 != 2) goto L63;
        Layout r27 = r15.layout;
        r27.leftToRight = r12;
        r27.leftToLeft = -1;
        goto L60
    L63:
        throw new IllegalArgumentException(a.o(new StringBuilder("Left to "), sideToString(r13), " undefined"));
    L27:
        if (r13 != 5) goto L29;
        Layout r28 = r15.layout;
        r28.baselineToBaseline = r12;
        r28.bottomToBottom = -1;
        r28.bottomToTop = -1;
        r28.topToTop = -1;
        r28.topToBottom = -1;
        return;
    L29:
        if (r13 != 3) goto L31;
        Layout r29 = r15.layout;
        r29.baselineToTop = r12;
        r29.bottomToBottom = -1;
        r29.bottomToTop = -1;
        r29.topToTop = -1;
        r29.topToBottom = -1;
        return;
    L31:
        if (r13 != 4) goto L34;
        Layout r30 = r15.layout;
        r30.baselineToBottom = r12;
        r30.bottomToBottom = -1;
        r30.bottomToTop = -1;
        r30.topToTop = -1;
        r30.topToBottom = -1;
        return;
    L34:
        throw new IllegalArgumentException(a.o(new StringBuilder("right to "), sideToString(r13), " undefined"));
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
        int r0 = r7.getEventType();     // Catch: IOException -> L13 XmlPullParserException -> L15
    L5:
        if (r0 == 1) goto L32;
        if (r0 != 0) goto L8;
        r7.getName();     // Catch: IOException -> L13 XmlPullParserException -> L15
    L19:
        r0 = r7.next();     // Catch: IOException -> L13 XmlPullParserException -> L15
    L8:
        if (r0 != 2) goto L19;
        String r1 = r7.getName();     // Catch: IOException -> L13 XmlPullParserException -> L15
        Constraint r2 = fillFromAttributeList(r5, Xml.asAttributeSet(r7), false);     // Catch: IOException -> L13 XmlPullParserException -> L15
        if (r1.equalsIgnoreCase("Guideline") == false) goto L17;
        r2.layout.mIsGuideline = true;     // Catch: IOException -> L13 XmlPullParserException -> L15
    L17:
        this.mConstraints.put(Integer.valueOf(r2.mViewId), r2);     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L19
    L32:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        return;
    L15:
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

    public void readFallback(ConstraintSet r8) {
        Iterator<Integer> r0 = r8.mConstraints.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L29;
        Integer r1 = r0.next();
        r1.intValue();
        Constraint r2 = r8.mConstraints.get(r1);
        if (this.mConstraints.containsKey(r1) == true) goto L8;
        this.mConstraints.put(r1, new Constraint());
    L8:
        Constraint r3 = this.mConstraints.get(r1);
        if (r3 == null) goto L4;
        Layout r4 = r3.layout;
        if (r4.mApply == true) goto L14;
        r4.copyFrom(r2.layout);
    L14:
        PropertySet r5 = r3.propertySet;
        if (r5.mApply == true) goto L17;
        r5.copyFrom(r2.propertySet);
    L17:
        Transform r6 = r3.transform;
        if (r6.mApply == true) goto L20;
        r6.copyFrom(r2.transform);
    L20:
        Motion r7 = r3.motion;
        if (r7.mApply == true) goto L23;
        r7.copyFrom(r2.motion);
    L23:
        Iterator<String> r9 = r2.mCustomConstraints.keySet().iterator();
    L25:
        if (r9.hasNext() == false) goto L4;
        String r10 = r9.next();
        if (r3.mCustomConstraints.containsKey(r10) == true) goto L25;
        r3.mCustomConstraints.put(r10, r2.mCustomConstraints.get(r10));
        goto L25
    }

    public void removeAttribute(String r1) {
        this.mSavedAttributes.remove(r1);
    }

    public void removeFromHorizontalChain(int r9) {
        if (this.mConstraints.containsKey(Integer.valueOf(r9)) == false) goto L36;
        Constraint r0 = this.mConstraints.get(Integer.valueOf(r9));
        if (r0 != null) goto L7;
        return;
    L7:
        Layout r1 = r0.layout;
        int r6 = r1.leftToRight;
        int r7 = r1.rightToLeft;
        if (r6 != (-1)) goto L25;
        if (r7 != (-1)) goto L25;
        int r2 = r1.startToEnd;
        int r8 = r1.endToStart;
        if (r2 != (-1)) goto L14;
        if (r8 != (-1)) goto L14;
    L24:
        clear(r9, 6);
        clear(r9, 7);
        return;
    L14:
        if (r2 == (-1)) goto L17;
        if (r8 == (-1)) goto L17;
        connect(r2, 7, r8, 6, 0);
        connect(r8, 6, r6, 7, 0);
    L17:
        if (r8 == (-1)) goto L24;
        int r3 = r1.rightToRight;
        if (r3 == (-1)) goto L21;
        connect(r6, 7, r3, 7, 0);
        goto L24
    L21:
        int r4 = r1.leftToLeft;
        if (r4 == (-1)) goto L24;
        connect(r8, 6, r4, 6, 0);
    L25:
        if (r6 == (-1)) goto L28;
        if (r7 == (-1)) goto L28;
        connect(r6, 2, r7, 1, 0);
        connect(r7, 1, r6, 2, 0);
    L34:
        clear(r9, 1);
        clear(r9, 2);
        return;
    L28:
        int r5 = r1.rightToRight;
        if (r5 == (-1)) goto L31;
        connect(r6, 2, r5, 2, 0);
        goto L34
    L31:
        int r10 = r1.leftToLeft;
        if (r10 == (-1)) goto L34;
        connect(r7, 1, r10, 1, 0);
        goto L34
    }

    public void removeFromVerticalChain(int r10) {
        if (this.mConstraints.containsKey(Integer.valueOf(r10)) == false) goto L19;
        Constraint r0 = this.mConstraints.get(Integer.valueOf(r10));
        if (r0 != null) goto L7;
        return;
    L7:
        Layout r1 = r0.layout;
        int r7 = r1.topToBottom;
        int r8 = r1.bottomToTop;
        if (r7 != (-1)) goto L10;
        if (r8 == (-1)) goto L19;
    L10:
        if (r7 == (-1)) goto L13;
        if (r8 == (-1)) goto L13;
        connect(r7, 4, r8, 3, 0);
        connect(r8, 3, r7, 4, 0);
    L13:
        int r4 = r1.bottomToBottom;
        if (r4 == (-1)) goto L16;
        connect(r7, 4, r4, 4, 0);
        goto L19
    L16:
        int r5 = r1.topToTop;
        if (r5 == (-1)) goto L19;
        connect(r8, 3, r5, 3, 0);
    L19:
        clear(r10, 3);
        clear(r10, 4);
    }

    public void setAlpha(int r1, float r2) {
        get(r1).propertySet.alpha = r2;
    }

    public void setApplyElevation(int r1, boolean r2) {
        get(r1).transform.applyElevation = r2;
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

    public void setElevation(int r2, float r3) {
        get(r2).transform.elevation = r3;
        get(r2).transform.applyElevation = true;
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

    public void setTranslationZ(int r1, float r2) {
        get(r1).transform.translationZ = r2;
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

    public void centerHorizontally(int r10, int r11) {
        if (r11 != 0) goto L4;
        center(r10, 0, 1, 0, 0, 2, 0, 0.5f);
        return;
    L4:
        center(r10, r11, 2, 0, r11, 1, 0, 0.5f);
    }

    public void centerHorizontallyRtl(int r10, int r11) {
        if (r11 != 0) goto L4;
        center(r10, 0, 6, 0, 0, 7, 0, 0.5f);
        return;
    L4:
        center(r10, r11, 7, 0, r11, 6, 0, 0.5f);
    }

    public void centerVertically(int r10, int r11) {
        if (r11 != 0) goto L4;
        center(r10, 0, 3, 0, 0, 4, 0, 0.5f);
        return;
    L4:
        center(r10, r11, 4, 0, r11, 3, 0, 0.5f);
    }

    public void clone(ConstraintLayout r11) {
        int r0 = r11.getChildCount();
        this.mConstraints.clear();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L29;
        View r2 = r11.getChildAt(r1);
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
        if (r5 == null) goto L28;
        r5.mCustomConstraints = ConstraintAttribute.extractAttributes(this.mSavedAttributes, r2);
        Constraint.access$000(r5, r4, r3);
        r5.propertySet.visibility = r2.getVisibility();
        r5.propertySet.alpha = r2.getAlpha();
        r5.transform.rotation = r2.getRotation();
        r5.transform.rotationX = r2.getRotationX();
        r5.transform.rotationY = r2.getRotationY();
        r5.transform.scaleX = r2.getScaleX();
        r5.transform.scaleY = r2.getScaleY();
        float r6 = r2.getPivotX();
        float r7 = r2.getPivotY();
        if (r6 == 0.0d) goto L20;
    L21:
        Transform r8 = r5.transform;
        r8.transformPivotX = r6;
        r8.transformPivotY = r7;
    L22:
        r5.transform.translationX = r2.getTranslationX();
        r5.transform.translationY = r2.getTranslationY();
        r5.transform.translationZ = r2.getTranslationZ();
        Transform r9 = r5.transform;
        if (r9.applyElevation == false) goto L26;
        r9.elevation = r2.getElevation();
    L26:
        if ((r2 instanceof Barrier) == false) goto L28;
        Barrier r10 = (Barrier) r2;
        r5.layout.mBarrierAllowsGoneWidgets = r10.getAllowsGoneWidget();
        r5.layout.mReferenceIds = r10.getReferencedIds();
        r5.layout.mBarrierDirection = r10.getType();
        r5.layout.mBarrierMargin = r10.getMargin();
        goto L28
    L20:
        if (r7 == 0.0d) goto L22;
    L28:
        r1 = r1 + 1;
        goto L3
    }

    public void load(Context r10, XmlPullParser r11) {
        int r0 = r11.getEventType();     // Catch: IOException -> L16 XmlPullParserException -> L18
        Constraint r2 = null;
    L4:
        if (r0 == 1) goto L125;
        if (r0 == 0) goto L96;
        byte r4 = -1;
        if (r0 == 2) goto L36;
        if (r0 != 3) goto L97;
        String r1 = r11.getName().toLowerCase(Locale.ROOT);     // Catch: IOException -> L16 XmlPullParserException -> L18
        switch(r1.hashCode()) {
            case -2075718416: goto L27;
            case -190376483: goto L24;
            case 426575017: goto L21;
            case 2146106725: goto L14;
            default: goto L29;
        };     // Catch: IOException -> L16 XmlPullParserException -> L18
    L29:
        if (r4 == 0) goto L35;
        if (r4 == 1) goto L34;
        if (r4 == 2) goto L34;
        if (r4 != 3) goto L97;
    L34:
        this.mConstraints.put(Integer.valueOf(r2.mViewId), r2);     // Catch: IOException -> L16 XmlPullParserException -> L18
        r2 = null;
        goto L97
    L35:
        return;
    L14:
        if (r1.equals("constraintset") == false) goto L29;
        r4 = 0;
        goto L29
    L21:
        if (r1.equals("constraintoverride") == false) goto L29;
        r4 = 2;
        goto L29
    L24:
        if (r1.equals("constraint") == false) goto L29;
        r4 = 1;
        goto L29
    L27:
        if (r1.equals("guideline") == false) goto L29;
        r4 = 3;
    L97:
        r0 = r11.next();     // Catch: IOException -> L16 XmlPullParserException -> L18
        goto L4
    L36:
        String r3 = r11.getName();     // Catch: IOException -> L16 XmlPullParserException -> L18
        switch(r3.hashCode()) {
            case -2025855158: goto L67;
            case -1984451626: goto L64;
            case -1962203927: goto L61;
            case -1269513683: goto L58;
            case -1238332596: goto L55;
            case -71750448: goto L52;
            case 366511058: goto L49;
            case 1331510167: goto L46;
            case 1791837707: goto L43;
            case 1803088381: goto L40;
            default: goto L70;
        };     // Catch: IOException -> L16 XmlPullParserException -> L18
    L70:
        switch(r4) {
            case 0: goto L95;
            case 1: goto L94;
            case 2: goto L93;
            case 3: goto L92;
            case 4: goto L88;
            case 5: goto L84;
            case 6: goto L80;
            case 7: goto L76;
            case 8: goto L72;
            case 9: goto L72;
            default: goto L97;
        };
    L72:
        if (r2 == null) goto L75;
        ConstraintAttribute.parse(r10, r11, r2.mCustomConstraints);     // Catch: IOException -> L16 XmlPullParserException -> L18
        goto L97
    L75:
        throw new RuntimeException(ERROR_MESSAGE + r11.getLineNumber());     // Catch: IOException -> L16 XmlPullParserException -> L18
    L76:
        if (r2 == null) goto L79;
        r2.motion.fillFromAttributeList(r10, Xml.asAttributeSet(r11));     // Catch: IOException -> L16 XmlPullParserException -> L18
        goto L97
    L79:
        throw new RuntimeException(ERROR_MESSAGE + r11.getLineNumber());     // Catch: IOException -> L16 XmlPullParserException -> L18
    L80:
        if (r2 == null) goto L83;
        r2.layout.fillFromAttributeList(r10, Xml.asAttributeSet(r11));     // Catch: IOException -> L16 XmlPullParserException -> L18
        goto L97
    L83:
        throw new RuntimeException(ERROR_MESSAGE + r11.getLineNumber());     // Catch: IOException -> L16 XmlPullParserException -> L18
    L84:
        if (r2 == null) goto L87;
        r2.transform.fillFromAttributeList(r10, Xml.asAttributeSet(r11));     // Catch: IOException -> L16 XmlPullParserException -> L18
        goto L97
    L87:
        throw new RuntimeException(ERROR_MESSAGE + r11.getLineNumber());     // Catch: IOException -> L16 XmlPullParserException -> L18
    L88:
        if (r2 == null) goto L91;
        r2.propertySet.fillFromAttributeList(r10, Xml.asAttributeSet(r11));     // Catch: IOException -> L16 XmlPullParserException -> L18
        goto L97
    L91:
        throw new RuntimeException(ERROR_MESSAGE + r11.getLineNumber());     // Catch: IOException -> L16 XmlPullParserException -> L18
    L92:
        r2 = fillFromAttributeList(r10, Xml.asAttributeSet(r11), false);     // Catch: IOException -> L16 XmlPullParserException -> L18
        r2.layout.mHelperType = 1;     // Catch: IOException -> L16 XmlPullParserException -> L18
        goto L97
    L93:
        r2 = fillFromAttributeList(r10, Xml.asAttributeSet(r11), false);     // Catch: IOException -> L16 XmlPullParserException -> L18
        Layout r5 = r2.layout;     // Catch: IOException -> L16 XmlPullParserException -> L18
        r5.mIsGuideline = true;     // Catch: IOException -> L16 XmlPullParserException -> L18
        r5.mApply = true;     // Catch: IOException -> L16 XmlPullParserException -> L18
        goto L97
    L94:
        r2 = fillFromAttributeList(r10, Xml.asAttributeSet(r11), true);     // Catch: IOException -> L16 XmlPullParserException -> L18
        goto L97
    L95:
        r2 = fillFromAttributeList(r10, Xml.asAttributeSet(r11), false);     // Catch: IOException -> L16 XmlPullParserException -> L18
        goto L97
    L40:
        if (r3.equals("Constraint") == false) goto L70;
        r4 = 0;
        goto L70
    L43:
        if (r3.equals(ViewTransition.CUSTOM_ATTRIBUTE) == false) goto L70;
        r4 = 8;
        goto L70
    L46:
        if (r3.equals("Barrier") == false) goto L70;
        r4 = 3;
        goto L70
    L49:
        if (r3.equals(ViewTransition.CUSTOM_METHOD) == false) goto L70;
        r4 = 9;
        goto L70
    L52:
        if (r3.equals("Guideline") == false) goto L70;
        r4 = 2;
        goto L70
    L55:
        if (r3.equals("Transform") == false) goto L70;
        r4 = 5;
        goto L70
    L58:
        if (r3.equals("PropertySet") == false) goto L70;
        r4 = 4;
        goto L70
    L61:
        if (r3.equals(ViewTransition.CONSTRAINT_OVERRIDE) == false) goto L70;
        r4 = 1;
        goto L70
    L64:
        if (r3.equals(TypedValues.MotionType.NAME) == false) goto L70;
        r4 = 7;
        goto L70
    L67:
        if (r3.equals("Layout") == false) goto L70;
        r4 = 6;
        goto L70
    L96:
        r11.getName();     // Catch: IOException -> L16 XmlPullParserException -> L18
        goto L97
    L125:
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
    }

    public void readFallback(ConstraintLayout r11) {
        int r0 = r11.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L39;
        View r2 = r11.getChildAt(r1);
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
        if (r5 == null) goto L38;
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
        Transform r8 = r5.transform;
        if (r8.mApply == true) goto L38;
        r8.mApply = true;
        r8.rotation = r2.getRotation();
        r5.transform.rotationX = r2.getRotationX();
        r5.transform.rotationY = r2.getRotationY();
        r5.transform.scaleX = r2.getScaleX();
        r5.transform.scaleY = r2.getScaleY();
        float r9 = r2.getPivotX();
        float r10 = r2.getPivotY();
        if (r9 == 0.0d) goto L33;
    L34:
        Transform r12 = r5.transform;
        r12.transformPivotX = r9;
        r12.transformPivotY = r10;
    L35:
        r5.transform.translationX = r2.getTranslationX();
        r5.transform.translationY = r2.getTranslationY();
        r5.transform.translationZ = r2.getTranslationZ();
        Transform r13 = r5.transform;
        if (r13.applyElevation == false) goto L38;
        r13.elevation = r2.getElevation();
        goto L38
    L33:
        if (r10 == 0.0d) goto L35;
    L38:
        r1 = r1 + 1;
        goto L3
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
        if (r2 != CIRCLE) goto L19;
        r1.layout.circleConstraint = r3;
        return;
    L19:
        if (r2 != CIRCLE_RADIUS) goto L21;
        r1.layout.circleRadius = r3;
        return;
    L21:
        if (r2 != BARRIER_DIRECTION) goto L23;
        r1.layout.mBarrierDirection = r3;
        return;
    L23:
        if (r2 == BARRIER_MARGIN) goto L64;
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

    private static void setDeltaValue(Constraint r1, int r2, String r3) {
        if (r2 != 5) goto L5;
        r1.layout.dimensionRatio = r3;
        return;
    L5:
        if (r2 != 65) goto L7;
        r1.motion.mTransitionEasing = r3;
        return;
    L7:
        if (r2 != CONSTRAINT_REFERENCED_IDS) goto L9;
        Layout r4 = r1.layout;
        r4.mReferenceIdString = r3;
        r4.mReferenceIds = null;
        return;
    L9:
        if (r2 != CONSTRAINT_TAG) goto L11;
        r1.layout.mConstraintTag = r3;
        return;
    L11:
        if (r2 != UNUSED) goto L13;
        return;
    L13:
        if (r2 == QUANTIZE_MOTION_INTERPOLATOR_STR) goto L15;
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
        if (r2 != BARRIER_ALLOWS_GONE_WIDGETS) goto L7;
        r1.layout.mBarrierAllowsGoneWidgets = r3;
        return;
    L7:
        if (r2 != UNUSED) goto L9;
        return;
    L9:
        if (r2 != 80) goto L11;
        r1.layout.constrainedWidth = r3;
        return;
    L11:
        if (r2 == CONSTRAINED_HEIGHT) goto L13;
        Log.w(TAG, "Unknown attribute 0x");
        return;
    L13:
        r1.layout.constrainedHeight = r3;
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
            case 1: goto L51;
            case 2: goto L45;
            case 3: goto L39;
            case 4: goto L33;
            case 5: goto L25;
            case 6: goto L18;
            case 7: goto L12;
            default: goto L10;
        };
    L10:
        StringBuilder r15 = new StringBuilder();
        r15.append(sideToString(r11));
        r15.append(" to ");
        throw new IllegalArgumentException(a.o(r15, sideToString(r13), " unknown"));
    L12:
        if (r13 != 7) goto L14;
        Layout r9 = r14.layout;
        r9.endToEnd = r12;
        r9.endToStart = -1;
        return;
    L14:
        if (r13 != 6) goto L17;
        Layout r16 = r14.layout;
        r16.endToStart = r12;
        r16.endToEnd = -1;
        return;
    L17:
        throw new IllegalArgumentException(a.o(new StringBuilder("right to "), sideToString(r13), " undefined"));
    L18:
        if (r13 != 6) goto L20;
        Layout r17 = r14.layout;
        r17.startToStart = r12;
        r17.startToEnd = -1;
        return;
    L20:
        if (r13 != 7) goto L23;
        Layout r18 = r14.layout;
        r18.startToEnd = r12;
        r18.startToStart = -1;
        return;
    L23:
        throw new IllegalArgumentException(a.o(new StringBuilder("right to "), sideToString(r13), " undefined"));
    L33:
        if (r13 != 4) goto L35;
        Layout r19 = r14.layout;
        r19.bottomToBottom = r12;
        r19.bottomToTop = -1;
        r19.baselineToBaseline = -1;
        r19.baselineToTop = -1;
        r19.baselineToBottom = -1;
        return;
    L35:
        if (r13 != 3) goto L38;
        Layout r20 = r14.layout;
        r20.bottomToTop = r12;
        r20.bottomToBottom = -1;
        r20.baselineToBaseline = -1;
        r20.baselineToTop = -1;
        r20.baselineToBottom = -1;
        return;
    L38:
        throw new IllegalArgumentException(a.o(new StringBuilder("right to "), sideToString(r13), " undefined"));
    L39:
        if (r13 != 3) goto L41;
        Layout r21 = r14.layout;
        r21.topToTop = r12;
        r21.topToBottom = -1;
        r21.baselineToBaseline = -1;
        r21.baselineToTop = -1;
        r21.baselineToBottom = -1;
        return;
    L41:
        if (r13 != 4) goto L44;
        Layout r22 = r14.layout;
        r22.topToBottom = r12;
        r22.topToTop = -1;
        r22.baselineToBaseline = -1;
        r22.baselineToTop = -1;
        r22.baselineToBottom = -1;
        return;
    L44:
        throw new IllegalArgumentException(a.o(new StringBuilder("right to "), sideToString(r13), " undefined"));
    L45:
        if (r13 != 1) goto L47;
        Layout r23 = r14.layout;
        r23.rightToLeft = r12;
        r23.rightToRight = -1;
        return;
    L47:
        if (r13 != 2) goto L50;
        Layout r24 = r14.layout;
        r24.rightToRight = r12;
        r24.rightToLeft = -1;
        return;
    L50:
        throw new IllegalArgumentException(a.o(new StringBuilder("right to "), sideToString(r13), " undefined"));
    L51:
        if (r13 != 1) goto L53;
        Layout r25 = r14.layout;
        r25.leftToLeft = r12;
        r25.leftToRight = -1;
        return;
    L53:
        if (r13 != 2) goto L57;
        Layout r26 = r14.layout;
        r26.leftToRight = r12;
        r26.leftToLeft = -1;
        return;
    L57:
        throw new IllegalArgumentException(a.o(new StringBuilder("left to "), sideToString(r13), " undefined"));
    L25:
        if (r13 != 5) goto L27;
        Layout r27 = r14.layout;
        r27.baselineToBaseline = r12;
        r27.bottomToBottom = -1;
        r27.bottomToTop = -1;
        r27.topToTop = -1;
        r27.topToBottom = -1;
        return;
    L27:
        if (r13 != 3) goto L29;
        Layout r28 = r14.layout;
        r28.baselineToTop = r12;
        r28.bottomToBottom = -1;
        r28.bottomToTop = -1;
        r28.topToTop = -1;
        r28.topToBottom = -1;
        return;
    L29:
        if (r13 != 4) goto L32;
        Layout r29 = r14.layout;
        r29.baselineToBottom = r12;
        r29.bottomToBottom = -1;
        r29.bottomToTop = -1;
        r29.topToTop = -1;
        r29.topToBottom = -1;
        return;
    L32:
        throw new IllegalArgumentException(a.o(new StringBuilder("right to "), sideToString(r13), " undefined"));
    }
}
