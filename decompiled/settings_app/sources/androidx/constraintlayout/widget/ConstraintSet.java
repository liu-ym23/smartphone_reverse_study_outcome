package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.icu.text.DateFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.core.os.EnvironmentCompat;
import androidx.exifinterface.media.ExifInterface;
import com.android.settings.fuelgauge.PowerUsageDetail;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import com.obric.oui.material.MaterialConfigFormatNames;
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
import obric.widget.calendar.MonthWeekEventsView;
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

            void add(int type, int value) {
                int r0 = this.mCountInt;
                int[] r1 = this.mTypeInt;
                if (r0 < r1.length) goto L5;
                this.mTypeInt = Arrays.copyOf(r1, r1.length * 2);
                int[] r2 = this.mValueInt;
                this.mValueInt = Arrays.copyOf(r2, r2.length * 2);
            L5:
                int[] r3 = this.mTypeInt;
                int r4 = this.mCountInt;
                r3[r4] = type;
                int[] r5 = this.mValueInt;
                this.mCountInt = r4 + 1;
                r5[r4] = value;
            }

            void add(int type, float value) {
                int r0 = this.mCountFloat;
                int[] r1 = this.mTypeFloat;
                if (r0 < r1.length) goto L5;
                this.mTypeFloat = Arrays.copyOf(r1, r1.length * 2);
                float[] r2 = this.mValueFloat;
                this.mValueFloat = Arrays.copyOf(r2, r2.length * 2);
            L5:
                int[] r3 = this.mTypeFloat;
                int r4 = this.mCountFloat;
                r3[r4] = type;
                float[] r5 = this.mValueFloat;
                this.mCountFloat = r4 + 1;
                r5[r4] = value;
            }

            void add(int type, String value) {
                int r0 = this.mCountString;
                int[] r1 = this.mTypeString;
                if (r0 < r1.length) goto L5;
                this.mTypeString = Arrays.copyOf(r1, r1.length * 2);
                String[] r2 = this.mValueString;
                this.mValueString = (String[]) Arrays.copyOf(r2, r2.length * 2);
            L5:
                int[] r3 = this.mTypeString;
                int r4 = this.mCountString;
                r3[r4] = type;
                String[] r5 = this.mValueString;
                this.mCountString = r4 + 1;
                r5[r4] = value;
            }

            void add(int type, boolean value) {
                int r0 = this.mCountBoolean;
                int[] r1 = this.mTypeBoolean;
                if (r0 < r1.length) goto L5;
                this.mTypeBoolean = Arrays.copyOf(r1, r1.length * 2);
                boolean[] r2 = this.mValueBoolean;
                this.mValueBoolean = Arrays.copyOf(r2, r2.length * 2);
            L5:
                int[] r3 = this.mTypeBoolean;
                int r4 = this.mCountBoolean;
                r3[r4] = type;
                boolean[] r5 = this.mValueBoolean;
                this.mCountBoolean = r4 + 1;
                r5[r4] = value;
            }

            void applyDelta(Constraint c) {
                int r0 = 0;
                int r1 = 0;
            L4:
                if (r1 >= this.mCountInt) goto L6;
                ConstraintSet.access$300(c, this.mTypeInt[r1], this.mValueInt[r1]);
                r1 = r1 + 1;
                goto L4
            L6:
                int r2 = 0;
            L8:
                if (r2 >= this.mCountFloat) goto L10;
                ConstraintSet.access$400(c, this.mTypeFloat[r2], this.mValueFloat[r2]);
                r2 = r2 + 1;
                goto L8
            L10:
                int r3 = 0;
            L12:
                if (r3 >= this.mCountString) goto L15;
                ConstraintSet.access$500(c, this.mTypeString[r3], this.mValueString[r3]);
                r3 = r3 + 1;
            L15:
                if (r0 >= this.mCountBoolean) goto L17;
                ConstraintSet.access$600(c, this.mTypeBoolean[r0], this.mValueBoolean[r0]);
                r0 = r0 + 1;
                goto L15
            }

            void printDelta(String tag) {
                Log.v(tag, "int");
                int r0 = 0;
                int r1 = 0;
            L4:
                if (r1 >= this.mCountInt) goto L6;
                Log.v(tag, this.mTypeInt[r1] + " = " + this.mValueInt[r1]);
                r1 = r1 + 1;
                goto L4
            L6:
                Log.v(tag, "float");
                int r2 = 0;
            L8:
                if (r2 >= this.mCountFloat) goto L10;
                Log.v(tag, this.mTypeFloat[r2] + " = " + this.mValueFloat[r2]);
                r2 = r2 + 1;
                goto L8
            L10:
                Log.v(tag, "strings");
                int r3 = 0;
            L12:
                if (r3 >= this.mCountString) goto L14;
                Log.v(tag, this.mTypeString[r3] + " = " + this.mValueString[r3]);
                r3 = r3 + 1;
                goto L12
            L14:
                Log.v(tag, "boolean");
            L16:
                if (r0 >= this.mCountBoolean) goto L18;
                Log.v(tag, this.mTypeBoolean[r0] + " = " + this.mValueBoolean[r0]);
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

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m14clone() throws CloneNotSupportedException {
            return clone();
        }

        public void applyDelta(Constraint c) {
            Delta r0 = this.mDelta;
            if (r0 == null) goto L6;
            r0.applyDelta(c);
            return;
        }

        public void printDelta(String tag) {
            Delta r0 = this.mDelta;
            if (r0 == null) goto L5;
            r0.printDelta(tag);
            return;
        L5:
            Log.v(tag, "DELTA IS NULL");
        }

        private ConstraintAttribute get(String attributeName, ConstraintAttribute.AttributeType attributeType) {
            if (this.mCustomConstraints.containsKey(attributeName) == false) goto L9;
            ConstraintAttribute r1 = this.mCustomConstraints.get(attributeName);
            if (r1.getType() != attributeType) goto L8;
            return r1;
        L8:
            throw new IllegalArgumentException("ConstraintAttribute is already a " + r1.getType().name());
        L9:
            ConstraintAttribute r0 = new ConstraintAttribute(attributeName, attributeType);
            this.mCustomConstraints.put(attributeName, r0);
            return r0;
        }

        private void setStringValue(String attributeName, String value) {
            get(attributeName, ConstraintAttribute.AttributeType.STRING_TYPE).setStringValue(value);
        }

        private void setFloatValue(String attributeName, float value) {
            get(attributeName, ConstraintAttribute.AttributeType.FLOAT_TYPE).setFloatValue(value);
        }

        private void setIntValue(String attributeName, int value) {
            get(attributeName, ConstraintAttribute.AttributeType.INT_TYPE).setIntValue(value);
        }

        private void setColorValue(String attributeName, int value) {
            get(attributeName, ConstraintAttribute.AttributeType.COLOR_TYPE).setColorValue(value);
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

        private void fillFromConstraints(ConstraintHelper helper, int viewId, Constraints.LayoutParams param) {
            fillFromConstraints(viewId, param);
            if ((helper instanceof Barrier) == false) goto L6;
            this.layout.mHelperType = 1;
            Barrier r1 = (Barrier) helper;
            Layout r2 = this.layout;
            r2.mBarrierDirection = r1.getType();
            Layout r3 = this.layout;
            r3.mReferenceIds = r1.getReferencedIds();
            Layout r0 = this.layout;
            r0.mBarrierMargin = r1.getMargin();
            return;
        }

        private void fillFromConstraints(int viewId, Constraints.LayoutParams param) {
            fillFrom(viewId, param);
            PropertySet r2 = this.propertySet;
            r2.alpha = param.alpha;
            Transform r3 = this.transform;
            r3.rotation = param.rotation;
            Transform r4 = this.transform;
            r4.rotationX = param.rotationX;
            Transform r5 = this.transform;
            r5.rotationY = param.rotationY;
            Transform r6 = this.transform;
            r6.scaleX = param.scaleX;
            Transform r7 = this.transform;
            r7.scaleY = param.scaleY;
            Transform r8 = this.transform;
            r8.transformPivotX = param.transformPivotX;
            Transform r9 = this.transform;
            r9.transformPivotY = param.transformPivotY;
            Transform r10 = this.transform;
            r10.translationX = param.translationX;
            Transform r11 = this.transform;
            r11.translationY = param.translationY;
            Transform r12 = this.transform;
            r12.translationZ = param.translationZ;
            Transform r13 = this.transform;
            r13.elevation = param.elevation;
            Transform r1 = this.transform;
            r1.applyElevation = param.applyElevation;
        }

        private void fillFrom(int viewId, ConstraintLayout.LayoutParams param) {
            this.mViewId = viewId;
            Layout r2 = this.layout;
            r2.leftToLeft = param.leftToLeft;
            Layout r3 = this.layout;
            r3.leftToRight = param.leftToRight;
            Layout r4 = this.layout;
            r4.rightToLeft = param.rightToLeft;
            Layout r5 = this.layout;
            r5.rightToRight = param.rightToRight;
            Layout r6 = this.layout;
            r6.topToTop = param.topToTop;
            Layout r7 = this.layout;
            r7.topToBottom = param.topToBottom;
            Layout r8 = this.layout;
            r8.bottomToTop = param.bottomToTop;
            Layout r9 = this.layout;
            r9.bottomToBottom = param.bottomToBottom;
            Layout r10 = this.layout;
            r10.baselineToBaseline = param.baselineToBaseline;
            Layout r11 = this.layout;
            r11.baselineToTop = param.baselineToTop;
            Layout r12 = this.layout;
            r12.baselineToBottom = param.baselineToBottom;
            Layout r13 = this.layout;
            r13.startToEnd = param.startToEnd;
            Layout r14 = this.layout;
            r14.startToStart = param.startToStart;
            Layout r15 = this.layout;
            r15.endToStart = param.endToStart;
            Layout r16 = this.layout;
            r16.endToEnd = param.endToEnd;
            Layout r17 = this.layout;
            r17.horizontalBias = param.horizontalBias;
            Layout r18 = this.layout;
            r18.verticalBias = param.verticalBias;
            Layout r19 = this.layout;
            r19.dimensionRatio = param.dimensionRatio;
            Layout r20 = this.layout;
            r20.circleConstraint = param.circleConstraint;
            Layout r21 = this.layout;
            r21.circleRadius = param.circleRadius;
            Layout r22 = this.layout;
            r22.circleAngle = param.circleAngle;
            Layout r23 = this.layout;
            r23.editorAbsoluteX = param.editorAbsoluteX;
            Layout r24 = this.layout;
            r24.editorAbsoluteY = param.editorAbsoluteY;
            Layout r25 = this.layout;
            r25.orientation = param.orientation;
            Layout r26 = this.layout;
            r26.guidePercent = param.guidePercent;
            Layout r27 = this.layout;
            r27.guideBegin = param.guideBegin;
            Layout r28 = this.layout;
            r28.guideEnd = param.guideEnd;
            Layout r29 = this.layout;
            r29.mWidth = param.width;
            Layout r30 = this.layout;
            r30.mHeight = param.height;
            Layout r31 = this.layout;
            r31.leftMargin = param.leftMargin;
            Layout r32 = this.layout;
            r32.rightMargin = param.rightMargin;
            Layout r33 = this.layout;
            r33.topMargin = param.topMargin;
            Layout r34 = this.layout;
            r34.bottomMargin = param.bottomMargin;
            Layout r35 = this.layout;
            r35.baselineMargin = param.baselineMargin;
            Layout r36 = this.layout;
            r36.verticalWeight = param.verticalWeight;
            Layout r37 = this.layout;
            r37.horizontalWeight = param.horizontalWeight;
            Layout r38 = this.layout;
            r38.verticalChainStyle = param.verticalChainStyle;
            Layout r39 = this.layout;
            r39.horizontalChainStyle = param.horizontalChainStyle;
            Layout r40 = this.layout;
            r40.constrainedWidth = param.constrainedWidth;
            Layout r41 = this.layout;
            r41.constrainedHeight = param.constrainedHeight;
            Layout r42 = this.layout;
            r42.widthDefault = param.matchConstraintDefaultWidth;
            Layout r43 = this.layout;
            r43.heightDefault = param.matchConstraintDefaultHeight;
            Layout r44 = this.layout;
            r44.widthMax = param.matchConstraintMaxWidth;
            Layout r45 = this.layout;
            r45.heightMax = param.matchConstraintMaxHeight;
            Layout r46 = this.layout;
            r46.widthMin = param.matchConstraintMinWidth;
            Layout r47 = this.layout;
            r47.heightMin = param.matchConstraintMinHeight;
            Layout r48 = this.layout;
            r48.widthPercent = param.matchConstraintPercentWidth;
            Layout r49 = this.layout;
            r49.heightPercent = param.matchConstraintPercentHeight;
            Layout r50 = this.layout;
            r50.mConstraintTag = param.constraintTag;
            Layout r51 = this.layout;
            r51.goneTopMargin = param.goneTopMargin;
            Layout r52 = this.layout;
            r52.goneBottomMargin = param.goneBottomMargin;
            Layout r53 = this.layout;
            r53.goneLeftMargin = param.goneLeftMargin;
            Layout r54 = this.layout;
            r54.goneRightMargin = param.goneRightMargin;
            Layout r55 = this.layout;
            r55.goneStartMargin = param.goneStartMargin;
            Layout r56 = this.layout;
            r56.goneEndMargin = param.goneEndMargin;
            Layout r57 = this.layout;
            r57.goneBaselineMargin = param.goneBaselineMargin;
            Layout r58 = this.layout;
            r58.mWrapBehavior = param.wrapBehaviorInParent;
            Layout r59 = this.layout;
            r59.endMargin = param.getMarginEnd();
            Layout r1 = this.layout;
            r1.startMargin = param.getMarginStart();
        }

        public void applyTo(ConstraintLayout.LayoutParams param) {
            param.leftToLeft = this.layout.leftToLeft;
            param.leftToRight = this.layout.leftToRight;
            param.rightToLeft = this.layout.rightToLeft;
            param.rightToRight = this.layout.rightToRight;
            param.topToTop = this.layout.topToTop;
            param.topToBottom = this.layout.topToBottom;
            param.bottomToTop = this.layout.bottomToTop;
            param.bottomToBottom = this.layout.bottomToBottom;
            param.baselineToBaseline = this.layout.baselineToBaseline;
            param.baselineToTop = this.layout.baselineToTop;
            param.baselineToBottom = this.layout.baselineToBottom;
            param.startToEnd = this.layout.startToEnd;
            param.startToStart = this.layout.startToStart;
            param.endToStart = this.layout.endToStart;
            param.endToEnd = this.layout.endToEnd;
            param.leftMargin = this.layout.leftMargin;
            param.rightMargin = this.layout.rightMargin;
            param.topMargin = this.layout.topMargin;
            param.bottomMargin = this.layout.bottomMargin;
            param.goneStartMargin = this.layout.goneStartMargin;
            param.goneEndMargin = this.layout.goneEndMargin;
            param.goneTopMargin = this.layout.goneTopMargin;
            param.goneBottomMargin = this.layout.goneBottomMargin;
            param.horizontalBias = this.layout.horizontalBias;
            param.verticalBias = this.layout.verticalBias;
            param.circleConstraint = this.layout.circleConstraint;
            param.circleRadius = this.layout.circleRadius;
            param.circleAngle = this.layout.circleAngle;
            param.dimensionRatio = this.layout.dimensionRatio;
            param.editorAbsoluteX = this.layout.editorAbsoluteX;
            param.editorAbsoluteY = this.layout.editorAbsoluteY;
            param.verticalWeight = this.layout.verticalWeight;
            param.horizontalWeight = this.layout.horizontalWeight;
            param.verticalChainStyle = this.layout.verticalChainStyle;
            param.horizontalChainStyle = this.layout.horizontalChainStyle;
            param.constrainedWidth = this.layout.constrainedWidth;
            param.constrainedHeight = this.layout.constrainedHeight;
            param.matchConstraintDefaultWidth = this.layout.widthDefault;
            param.matchConstraintDefaultHeight = this.layout.heightDefault;
            param.matchConstraintMaxWidth = this.layout.widthMax;
            param.matchConstraintMaxHeight = this.layout.heightMax;
            param.matchConstraintMinWidth = this.layout.widthMin;
            param.matchConstraintMinHeight = this.layout.heightMin;
            param.matchConstraintPercentWidth = this.layout.widthPercent;
            param.matchConstraintPercentHeight = this.layout.heightPercent;
            param.orientation = this.layout.orientation;
            param.guidePercent = this.layout.guidePercent;
            param.guideBegin = this.layout.guideBegin;
            param.guideEnd = this.layout.guideEnd;
            param.width = this.layout.mWidth;
            param.height = this.layout.mHeight;
            if (this.layout.mConstraintTag == null) goto L5;
            param.constraintTag = this.layout.mConstraintTag;
        L5:
            param.wrapBehaviorInParent = this.layout.mWrapBehavior;
            param.setMarginStart(this.layout.startMargin);
            param.setMarginEnd(this.layout.endMargin);
            param.validate();
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

        public void copyFrom(Layout src) {
            this.mIsGuideline = src.mIsGuideline;
            this.mWidth = src.mWidth;
            this.mApply = src.mApply;
            this.mHeight = src.mHeight;
            this.guideBegin = src.guideBegin;
            this.guideEnd = src.guideEnd;
            this.guidePercent = src.guidePercent;
            this.guidelineUseRtl = src.guidelineUseRtl;
            this.leftToLeft = src.leftToLeft;
            this.leftToRight = src.leftToRight;
            this.rightToLeft = src.rightToLeft;
            this.rightToRight = src.rightToRight;
            this.topToTop = src.topToTop;
            this.topToBottom = src.topToBottom;
            this.bottomToTop = src.bottomToTop;
            this.bottomToBottom = src.bottomToBottom;
            this.baselineToBaseline = src.baselineToBaseline;
            this.baselineToTop = src.baselineToTop;
            this.baselineToBottom = src.baselineToBottom;
            this.startToEnd = src.startToEnd;
            this.startToStart = src.startToStart;
            this.endToStart = src.endToStart;
            this.endToEnd = src.endToEnd;
            this.horizontalBias = src.horizontalBias;
            this.verticalBias = src.verticalBias;
            this.dimensionRatio = src.dimensionRatio;
            this.circleConstraint = src.circleConstraint;
            this.circleRadius = src.circleRadius;
            this.circleAngle = src.circleAngle;
            this.editorAbsoluteX = src.editorAbsoluteX;
            this.editorAbsoluteY = src.editorAbsoluteY;
            this.orientation = src.orientation;
            this.leftMargin = src.leftMargin;
            this.rightMargin = src.rightMargin;
            this.topMargin = src.topMargin;
            this.bottomMargin = src.bottomMargin;
            this.endMargin = src.endMargin;
            this.startMargin = src.startMargin;
            this.baselineMargin = src.baselineMargin;
            this.goneLeftMargin = src.goneLeftMargin;
            this.goneTopMargin = src.goneTopMargin;
            this.goneRightMargin = src.goneRightMargin;
            this.goneBottomMargin = src.goneBottomMargin;
            this.goneEndMargin = src.goneEndMargin;
            this.goneStartMargin = src.goneStartMargin;
            this.goneBaselineMargin = src.goneBaselineMargin;
            this.verticalWeight = src.verticalWeight;
            this.horizontalWeight = src.horizontalWeight;
            this.horizontalChainStyle = src.horizontalChainStyle;
            this.verticalChainStyle = src.verticalChainStyle;
            this.widthDefault = src.widthDefault;
            this.heightDefault = src.heightDefault;
            this.widthMax = src.widthMax;
            this.heightMax = src.heightMax;
            this.widthMin = src.widthMin;
            this.heightMin = src.heightMin;
            this.widthPercent = src.widthPercent;
            this.heightPercent = src.heightPercent;
            this.mBarrierDirection = src.mBarrierDirection;
            this.mBarrierMargin = src.mBarrierMargin;
            this.mHelperType = src.mHelperType;
            this.mConstraintTag = src.mConstraintTag;
            int[] r0 = src.mReferenceIds;
            if (r0 != null) goto L5;
        L7:
            this.mReferenceIds = null;
        L8:
            this.mReferenceIdString = src.mReferenceIdString;
            this.constrainedWidth = src.constrainedWidth;
            this.constrainedHeight = src.constrainedHeight;
            this.mBarrierAllowsGoneWidgets = src.mBarrierAllowsGoneWidgets;
            this.mWrapBehavior = src.mWrapBehavior;
            return;
        L5:
            if (src.mReferenceIdString != null) goto L7;
            this.mReferenceIds = Arrays.copyOf(r0, r0.length);
            goto L8
        }

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

        void fillFromAttributeList(Context context, AttributeSet attrs) {
            TypedArray r9 = context.obtainStyledAttributes(attrs, R.styleable.Layout);
            this.mApply = true;
            int r0 = r9.getIndexCount();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L79;
            int r3 = r9.getIndex(r2);
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
            this.circleAngle = r9.getFloat(r3, this.circleAngle);
        L78:
            r2 = r2 + 1;
            goto L3
        L34:
            this.circleRadius = r9.getDimensionPixelSize(r3, this.circleRadius);
            goto L78
        L35:
            this.circleConstraint = ConstraintSet.access$100(r9, r3, this.circleConstraint);
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
            this.guidelineUseRtl = r9.getBoolean(r3, this.guidelineUseRtl);
            goto L78
        L12:
            this.mConstraintTag = r9.getString(r3);
            goto L78
        L13:
            this.constrainedHeight = r9.getBoolean(r3, this.constrainedHeight);
            goto L78
        L14:
            this.constrainedWidth = r9.getBoolean(r3, this.constrainedWidth);
            goto L78
        L15:
            this.widthMin = r9.getDimensionPixelSize(r3, this.widthMin);
            goto L78
        L16:
            this.heightMin = r9.getDimensionPixelSize(r3, this.heightMin);
            goto L78
        L17:
            this.widthMax = r9.getDimensionPixelSize(r3, this.widthMax);
            goto L78
        L18:
            this.heightMax = r9.getDimensionPixelSize(r3, this.heightMax);
            goto L78
        L19:
            this.heightDefault = r9.getInt(r3, this.heightDefault);
            goto L78
        L20:
            this.widthDefault = r9.getInt(r3, this.widthDefault);
            goto L78
        L21:
            this.baselineMargin = r9.getDimensionPixelSize(r3, this.baselineMargin);
            goto L78
        L22:
            this.goneBaselineMargin = r9.getDimensionPixelSize(r3, this.goneBaselineMargin);
            goto L78
        L23:
            this.baselineToBottom = ConstraintSet.access$100(r9, r3, this.baselineToBottom);
            goto L78
        L24:
            this.baselineToTop = ConstraintSet.access$100(r9, r3, this.baselineToTop);
            goto L78
        L25:
            this.mWrapBehavior = r9.getInt(r3, this.mWrapBehavior);
            goto L78
        L26:
            this.mBarrierAllowsGoneWidgets = r9.getBoolean(r3, this.mBarrierAllowsGoneWidgets);
            goto L78
        L27:
            this.mReferenceIdString = r9.getString(r3);
            goto L78
        L28:
            this.mBarrierMargin = r9.getDimensionPixelSize(r3, this.mBarrierMargin);
            goto L78
        L29:
            this.mBarrierDirection = r9.getInt(r3, this.mBarrierDirection);
            goto L78
        L30:
            Log.e(ConstraintSet.TAG, "CURRENTLY UNSUPPORTED");
            goto L78
        L31:
            this.heightPercent = r9.getFloat(r3, 1.0f);
            goto L78
        L32:
            this.widthPercent = r9.getFloat(r3, 1.0f);
            goto L78
        L36:
            ConstraintSet.parseDimensionConstraints(this, r9, r3, 1);
            goto L78
        L37:
            ConstraintSet.parseDimensionConstraints(this, r9, r3, 0);
            goto L78
        L38:
            this.verticalChainStyle = r9.getInt(r3, this.verticalChainStyle);
            goto L78
        L39:
            this.horizontalChainStyle = r9.getInt(r3, this.horizontalChainStyle);
            goto L78
        L40:
            this.verticalWeight = r9.getFloat(r3, this.verticalWeight);
            goto L78
        L41:
            this.horizontalWeight = r9.getFloat(r3, this.horizontalWeight);
            goto L78
        L42:
            this.verticalBias = r9.getFloat(r3, this.verticalBias);
            goto L78
        L43:
            this.topToTop = ConstraintSet.access$100(r9, r3, this.topToTop);
            goto L78
        L44:
            this.topToBottom = ConstraintSet.access$100(r9, r3, this.topToBottom);
            goto L78
        L45:
            this.topMargin = r9.getDimensionPixelSize(r3, this.topMargin);
            goto L78
        L46:
            this.startToStart = ConstraintSet.access$100(r9, r3, this.startToStart);
            goto L78
        L47:
            this.startToEnd = ConstraintSet.access$100(r9, r3, this.startToEnd);
            goto L78
        L48:
            this.startMargin = r9.getDimensionPixelSize(r3, this.startMargin);
            goto L78
        L49:
            this.rightToRight = ConstraintSet.access$100(r9, r3, this.rightToRight);
            goto L78
        L50:
            this.rightToLeft = ConstraintSet.access$100(r9, r3, this.rightToLeft);
            goto L78
        L51:
            this.rightMargin = r9.getDimensionPixelSize(r3, this.rightMargin);
            goto L78
        L52:
            this.orientation = r9.getInt(r3, this.orientation);
            goto L78
        L53:
            this.leftToRight = ConstraintSet.access$100(r9, r3, this.leftToRight);
            goto L78
        L54:
            this.leftToLeft = ConstraintSet.access$100(r9, r3, this.leftToLeft);
            goto L78
        L55:
            this.leftMargin = r9.getDimensionPixelSize(r3, this.leftMargin);
            goto L78
        L56:
            this.mWidth = r9.getLayoutDimension(r3, this.mWidth);
            goto L78
        L57:
            this.mHeight = r9.getLayoutDimension(r3, this.mHeight);
            goto L78
        L58:
            this.horizontalBias = r9.getFloat(r3, this.horizontalBias);
            goto L78
        L59:
            this.guidePercent = r9.getFloat(r3, this.guidePercent);
            goto L78
        L60:
            this.guideEnd = r9.getDimensionPixelOffset(r3, this.guideEnd);
            goto L78
        L61:
            this.guideBegin = r9.getDimensionPixelOffset(r3, this.guideBegin);
            goto L78
        L62:
            this.goneTopMargin = r9.getDimensionPixelSize(r3, this.goneTopMargin);
            goto L78
        L63:
            this.goneStartMargin = r9.getDimensionPixelSize(r3, this.goneStartMargin);
            goto L78
        L64:
            this.goneRightMargin = r9.getDimensionPixelSize(r3, this.goneRightMargin);
            goto L78
        L65:
            this.goneLeftMargin = r9.getDimensionPixelSize(r3, this.goneLeftMargin);
            goto L78
        L66:
            this.goneEndMargin = r9.getDimensionPixelSize(r3, this.goneEndMargin);
            goto L78
        L67:
            this.goneBottomMargin = r9.getDimensionPixelSize(r3, this.goneBottomMargin);
            goto L78
        L68:
            this.endToStart = ConstraintSet.access$100(r9, r3, this.endToStart);
            goto L78
        L69:
            this.endToEnd = ConstraintSet.access$100(r9, r3, this.endToEnd);
            goto L78
        L70:
            this.endMargin = r9.getDimensionPixelSize(r3, this.endMargin);
            goto L78
        L71:
            this.editorAbsoluteY = r9.getDimensionPixelOffset(r3, this.editorAbsoluteY);
            goto L78
        L72:
            this.editorAbsoluteX = r9.getDimensionPixelOffset(r3, this.editorAbsoluteX);
            goto L78
        L73:
            this.dimensionRatio = r9.getString(r3);
            goto L78
        L74:
            this.bottomToTop = ConstraintSet.access$100(r9, r3, this.bottomToTop);
            goto L78
        L75:
            this.bottomToBottom = ConstraintSet.access$100(r9, r3, this.bottomToBottom);
            goto L78
        L76:
            this.bottomMargin = r9.getDimensionPixelSize(r3, this.bottomMargin);
            goto L78
        L77:
            this.baselineToBaseline = ConstraintSet.access$100(r9, r3, this.baselineToBaseline);
            goto L78
        L79:
            r9.recycle();
        }

        public void dump(MotionScene r10, StringBuilder r11) {
            Field[] r0 = getClass().getDeclaredFields();
            r11.append("\n");
            int r1 = 0;
        L4:
            if (r1 >= r0.length) goto L27;
            Field r2 = r0[r1];
            String r3 = r2.getName();
            if (Modifier.isStatic(r2.getModifiers()) == true) goto L26;
            Object r4 = r2.get(this);     // Catch: IllegalAccessException -> L24
            Class<?> r5 = r2.getType();     // Catch: IllegalAccessException -> L24
            if (r5 != Integer.TYPE) goto L19;
            Integer r6 = (Integer) r4;     // Catch: IllegalAccessException -> L24
            if (r6.intValue() == (-1)) goto L26;
            Object r7 = r10.lookUpConstraintName(r6.intValue());     // Catch: IllegalAccessException -> L24
            r11.append("    ");     // Catch: IllegalAccessException -> L24
            r11.append(r3);     // Catch: IllegalAccessException -> L24
            r11.append(" = \"");     // Catch: IllegalAccessException -> L24
            if (r7 != null) goto L16;
            Object r8 = r6;
        L17:
            r11.append(r8);     // Catch: IllegalAccessException -> L24
            r11.append("\"\n");     // Catch: IllegalAccessException -> L24
            goto L26
        L16:
            r8 = r7;
            goto L17
        L19:
            if (r5 != Float.TYPE) goto L26;
            Float r9 = (Float) r4;     // Catch: IllegalAccessException -> L24
            if (r9.floatValue() == (-1.0f)) goto L26;
            r11.append("    ");     // Catch: IllegalAccessException -> L24
            r11.append(r3);     // Catch: IllegalAccessException -> L24
            r11.append(" = \"");     // Catch: IllegalAccessException -> L24
            r11.append(r9);     // Catch: IllegalAccessException -> L24
            r11.append("\"\n");     // Catch: IllegalAccessException -> L24
        L24:
            e = move-exception;
            e.printStackTrace();
        L26:
            r1 = r1 + 1;
            goto L4
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

        public void copyFrom(Motion src) {
            this.mApply = src.mApply;
            this.mAnimateRelativeTo = src.mAnimateRelativeTo;
            this.mTransitionEasing = src.mTransitionEasing;
            this.mPathMotionArc = src.mPathMotionArc;
            this.mDrawPath = src.mDrawPath;
            this.mPathRotate = src.mPathRotate;
            this.mMotionStagger = src.mMotionStagger;
            this.mPolarRelativeTo = src.mPolarRelativeTo;
        }

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

        void fillFromAttributeList(Context context, AttributeSet attrs) {
            TypedArray r10 = context.obtainStyledAttributes(attrs, R.styleable.Motion);
            this.mApply = true;
            int r0 = r10.getIndexCount();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L32;
            int r3 = r10.getIndex(r2);
            switch(mapToConstant.get(r3)) {
                case 1: goto L30;
                case 2: goto L29;
                case 3: goto L26;
                case 4: goto L24;
                case 5: goto L23;
                case 6: goto L22;
                case 7: goto L21;
                case 8: goto L20;
                case 9: goto L19;
                case 10: goto L7;
                default: goto L31;
            };
        L7:
            TypedValue r4 = r10.peekValue(r3);
            if (r4.type != 1) goto L13;
            int r5 = r10.getResourceId(r3, -1);
            this.mQuantizeInterpolatorID = r5;
            if (r5 == (-1)) goto L31;
            this.mQuantizeInterpolatorType = -2;
            goto L31
        L13:
            if (r4.type != 3) goto L18;
            String r6 = r10.getString(r3);
            this.mQuantizeInterpolatorString = r6;
            if (r6.indexOf(LibrarianImpl.Constants.SEPARATOR) <= 0) goto L17;
            this.mQuantizeInterpolatorID = r10.getResourceId(r3, -1);
            this.mQuantizeInterpolatorType = -2;
            goto L31
        L17:
            this.mQuantizeInterpolatorType = -1;
            goto L31
        L18:
            this.mQuantizeInterpolatorType = r10.getInteger(r3, this.mQuantizeInterpolatorID);
            goto L31
        L19:
            this.mQuantizeMotionPhase = r10.getFloat(r3, this.mQuantizeMotionPhase);
            goto L31
        L20:
            this.mQuantizeMotionSteps = r10.getInteger(r3, this.mQuantizeMotionSteps);
            goto L31
        L21:
            this.mMotionStagger = r10.getFloat(r3, this.mMotionStagger);
            goto L31
        L22:
            this.mAnimateCircleAngleTo = r10.getInteger(r3, this.mAnimateCircleAngleTo);
            goto L31
        L23:
            this.mAnimateRelativeTo = ConstraintSet.access$100(r10, r3, this.mAnimateRelativeTo);
            goto L31
        L24:
            this.mDrawPath = r10.getInt(r3, 0);
            goto L31
        L29:
            this.mPathMotionArc = r10.getInt(r3, this.mPathMotionArc);
            goto L31
        L30:
            this.mPathRotate = r10.getFloat(r3, this.mPathRotate);
            goto L31
        L26:
            if (r10.peekValue(r3).type != 3) goto L28;
            this.mTransitionEasing = r10.getString(r3);
            goto L31
        L28:
            this.mTransitionEasing = Easing.NAMED_EASING[r10.getInteger(r3, 0)];
        L31:
            r2 = r2 + 1;
            goto L3
        L32:
            r10.recycle();
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

        public void copyFrom(PropertySet src) {
            this.mApply = src.mApply;
            this.visibility = src.visibility;
            this.alpha = src.alpha;
            this.mProgress = src.mProgress;
            this.mVisibilityMode = src.mVisibilityMode;
        }

        void fillFromAttributeList(Context context, AttributeSet attrs) {
            TypedArray r4 = context.obtainStyledAttributes(attrs, R.styleable.PropertySet);
            this.mApply = true;
            int r5 = r4.getIndexCount();
            int r0 = 0;
        L3:
            if (r0 >= r5) goto L17;
            int r1 = r4.getIndex(r0);
            if (r1 != R.styleable.PropertySet_android_alpha) goto L8;
            this.alpha = r4.getFloat(r1, this.alpha);
        L16:
            r0 = r0 + 1;
            goto L3
        L8:
            if (r1 != R.styleable.PropertySet_android_visibility) goto L11;
            this.visibility = r4.getInt(r1, this.visibility);
            this.visibility = ConstraintSet.access$200()[this.visibility];
            goto L16
        L11:
            if (r1 != R.styleable.PropertySet_visibilityMode) goto L14;
            this.mVisibilityMode = r4.getInt(r1, this.mVisibilityMode);
            goto L16
        L14:
            if (r1 != R.styleable.PropertySet_motionProgress) goto L16;
            this.mProgress = r4.getFloat(r1, this.mProgress);
            goto L16
        L17:
            r4.recycle();
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

        public void copyFrom(Transform src) {
            this.mApply = src.mApply;
            this.rotation = src.rotation;
            this.rotationX = src.rotationX;
            this.rotationY = src.rotationY;
            this.scaleX = src.scaleX;
            this.scaleY = src.scaleY;
            this.transformPivotX = src.transformPivotX;
            this.transformPivotY = src.transformPivotY;
            this.transformPivotTarget = src.transformPivotTarget;
            this.translationX = src.translationX;
            this.translationY = src.translationY;
            this.translationZ = src.translationZ;
            this.applyElevation = src.applyElevation;
            this.elevation = src.elevation;
        }

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

        void fillFromAttributeList(Context context, AttributeSet attrs) {
            TypedArray r5 = context.obtainStyledAttributes(attrs, R.styleable.Transform);
            this.mApply = true;
            int r0 = r5.getIndexCount();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L20;
            int r2 = r5.getIndex(r1);
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
            this.transformPivotTarget = ConstraintSet.access$100(r5, r2, this.transformPivotTarget);
            goto L19
        L8:
            this.applyElevation = true;
            this.elevation = r5.getDimension(r2, this.elevation);
            goto L19
        L9:
            this.translationZ = r5.getDimension(r2, this.translationZ);
            goto L19
        L10:
            this.translationY = r5.getDimension(r2, this.translationY);
            goto L19
        L11:
            this.translationX = r5.getDimension(r2, this.translationX);
            goto L19
        L12:
            this.transformPivotY = r5.getDimension(r2, this.transformPivotY);
            goto L19
        L13:
            this.transformPivotX = r5.getDimension(r2, this.transformPivotX);
            goto L19
        L14:
            this.scaleY = r5.getFloat(r2, this.scaleY);
            goto L19
        L15:
            this.scaleX = r5.getFloat(r2, this.scaleX);
            goto L19
        L16:
            this.rotationY = r5.getFloat(r2, this.rotationY);
            goto L19
        L17:
            this.rotationX = r5.getFloat(r2, this.rotationX);
            goto L19
        L18:
            this.rotation = r5.getFloat(r2, this.rotation);
        L19:
            r1 = r1 + 1;
            goto L3
        L20:
            r5.recycle();
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

        private void writeGuideline(int orientation, int guideBegin, int guideEnd, float guidePercent) {
        }

        WriteJsonEngine(final ConstraintSet this$0, Writer writer, ConstraintLayout layout, int flags) throws IOException {
            this.this$0 = this$0;
            this.unknownCount = 0;
            this.LEFT = "'left'";
            this.RIGHT = "'right'";
            this.BASELINE = "'baseline'";
            this.BOTTOM = "'bottom'";
            this.TOP = "'top'";
            this.START = "'start'";
            this.END = "'end'";
            this.idMap = new HashMap();
            this.writer = writer;
            this.layout = layout;
            this.context = layout.getContext();
            this.flags = flags;
        }

        void writeLayout() throws IOException {
            this.writer.write("\n'ConstraintSet':{\n");
            Iterator r8 = ConstraintSet.access$1300(this.this$0).keySet().iterator();
        L4:
            if (r8.hasNext() == false) goto L9;
            Integer r0 = (Integer) r8.next();
            Constraint r1 = (Constraint) ConstraintSet.access$1300(this.this$0).get(r0);
            this.writer.write(getName(r0.intValue()) + ":{\n");
            Layout r10 = r1.layout;
            writeDimension(MonthWeekEventsView.VIEW_PARAMS_HEIGHT, r10.mHeight, r10.heightDefault, r10.heightPercent, r10.heightMin, r10.heightMax, r10.constrainedHeight);
            writeDimension(MaterialConfigFormatNames.WIDTH, r10.mWidth, r10.widthDefault, r10.widthPercent, r10.widthMin, r10.widthMax, r10.constrainedWidth);
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
            if (r10.mReferenceIds == null) goto L8;
            writeVariable("'ReferenceIds'", r10.mReferenceIds);
        L8:
            this.writer.write("}\n");
            goto L4
        L9:
            this.writer.write("}\n");
        }

        private void writeDimension(String dimString, int dim, int dimDefault, float dimPercent, int dimMin, int dimMax, boolean constrainedDim) throws IOException {
            if (dim != 0) goto L27;
            if (dimMax != (-1)) goto L16;
            if (dimMin != (-1)) goto L16;
            if (dimDefault == 1) goto L13;
            if (dimDefault != 2) goto L36;
            this.writer.write(SPACE + dimString + ": '" + dimPercent + "%',\n");
            return;
        L36:
            return;
        L13:
            this.writer.write(SPACE + dimString + ": '???????????',\n");
            return;
        L16:
            if (dimDefault == 0) goto L24;
            if (dimDefault == 1) goto L22;
            if (dimDefault != 2) goto L33;
            this.writer.write(SPACE + dimString + ": {'" + dimPercent + "'% ," + dimMin + ", " + dimMax + "}\n");
            return;
        L33:
            return;
        L22:
            this.writer.write(SPACE + dimString + ": {'wrap' ," + dimMin + ", " + dimMax + "}\n");
            return;
        L24:
            this.writer.write(SPACE + dimString + ": {'spread' ," + dimMin + ", " + dimMax + "}\n");
            return;
        L27:
            if (dim != (-2)) goto L29;
            this.writer.write(SPACE + dimString + ": 'wrap'\n");
            return;
        L29:
            if (dim != (-1)) goto L31;
            this.writer.write(SPACE + dimString + ": 'parent'\n");
            return;
        L31:
            this.writer.write(SPACE + dimString + ": " + dim + ",\n");
        }

        String getName(int id) {
            if (this.idMap.containsKey(Integer.valueOf(id)) == true) goto L5;
            if (id != 0) goto L9;
            return "'parent'";
        L9:
            String r0 = lookup(id);
            this.idMap.put(Integer.valueOf(id), r0);
            return "'" + r0 + "'";
        L5:
            return "'" + this.idMap.get(Integer.valueOf(id)) + "'";
        }

        String lookup(int id) {
            if (id != (-1)) goto L5;
            StringBuilder r3 = new StringBuilder(EnvironmentCompat.MEDIA_UNKNOWN);     // Catch: Exception -> L8
            int r0 = this.unknownCount + 1;     // Catch: Exception -> L8
            this.unknownCount = r0;     // Catch: Exception -> L8
            return r3.append(r0).toString();
        L5:
            return this.context.getResources().getResourceEntryName(id);
        L8:
            StringBuilder r4 = new StringBuilder(EnvironmentCompat.MEDIA_UNKNOWN);
            int r1 = this.unknownCount + 1;
            this.unknownCount = r1;
            return r4.append(r1).toString();
        }

        void writeConstraint(String my, int leftToLeft, String other, int margin, int goneMargin) throws IOException {
            if (leftToLeft != (-1)) goto L5;
            return;
        L5:
            this.writer.write(SPACE + my);
            this.writer.write(":[");
            this.writer.write(getName(leftToLeft));
            this.writer.write(" , ");
            this.writer.write(other);
            if (margin == 0) goto L8;
            this.writer.write(" , " + margin);
        L8:
            this.writer.write("],\n");
        }

        void writeCircle(int circleConstraint, float circleAngle, int circleRadius) throws IOException {
            if (circleConstraint != (-1)) goto L5;
            return;
        L5:
            this.writer.write("       circle");
            this.writer.write(":[");
            this.writer.write(getName(circleConstraint));
            this.writer.write(", " + circleAngle);
            this.writer.write(circleRadius + "]");
        }

        void writeVariable(String name, int value) throws IOException {
            if (value != 0) goto L4;
            return;
        L4:
            if (value == (-1)) goto L9;
            this.writer.write(SPACE + name);
            this.writer.write(":");
            this.writer.write(", " + value);
            this.writer.write("\n");
            return;
        }

        void writeVariable(String name, float value) throws IOException {
            if (value != (-1.0f)) goto L5;
            return;
        L5:
            this.writer.write(SPACE + name);
            this.writer.write(": " + value);
            this.writer.write(",\n");
        }

        void writeVariable(String name, float value, float def) throws IOException {
            if (value != def) goto L5;
            return;
        L5:
            this.writer.write(SPACE + name);
            this.writer.write(": " + value);
            this.writer.write(",\n");
        }

        void writeVariable(String name, boolean value) throws IOException {
            if (value == true) goto L4;
            return;
        L4:
            this.writer.write(SPACE + name);
            this.writer.write(": " + value);
            this.writer.write(",\n");
        }

        void writeVariable(String name, boolean value, boolean def) throws IOException {
            if (value != def) goto L4;
            return;
        L4:
            this.writer.write(SPACE + name);
            this.writer.write(": " + value);
            this.writer.write(",\n");
        }

        void writeVariable(String name, int[] value) throws IOException {
            if (value != null) goto L4;
            return;
        L4:
            this.writer.write(SPACE + name);
            this.writer.write(": ");
            int r4 = 0;
        L6:
            if (r4 >= value.length) goto L12;
            Writer r0 = this.writer;
            StringBuilder r1 = new StringBuilder();
            if (r4 != 0) goto L10;
            String r2 = "[";
        L11:
            r0.write(r1.append(r2).append(getName(value[r4])).toString());
            r4 = r4 + 1;
            goto L6
        L10:
            r2 = ", ";
            goto L11
        L12:
            this.writer.write("],\n");
        }

        void writeVariable(String name, String value) throws IOException {
            if (value != null) goto L4;
            return;
        L4:
            this.writer.write(SPACE + name);
            this.writer.write(":");
            this.writer.write(", " + value);
            this.writer.write("\n");
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

        WriteXmlEngine(final ConstraintSet this$0, Writer writer, ConstraintLayout layout, int flags) throws IOException {
            this.this$0 = this$0;
            this.unknownCount = 0;
            this.LEFT = "'left'";
            this.RIGHT = "'right'";
            this.BASELINE = "'baseline'";
            this.BOTTOM = "'bottom'";
            this.TOP = "'top'";
            this.START = "'start'";
            this.END = "'end'";
            this.idMap = new HashMap();
            this.writer = writer;
            this.layout = layout;
            this.context = layout.getContext();
            this.flags = flags;
        }

        void writeLayout() throws IOException {
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
            String[] r6 = {MaterialConfigFormatNames.SPREAD, "wrap", PowerUsageDetail.EXTRA_PERCENT};
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
            if (r5.mReferenceIds == null) goto L8;
            writeVariable("'ReferenceIds'", r5.mReferenceIds);
        L8:
            this.writer.write(" />\n");
            goto L4
        L9:
            this.writer.write("</ConstraintSet>\n");
        }

        private void writeBoolen(String dimString, boolean val, boolean def) throws IOException {
            if (val == def) goto L5;
            this.writer.write(SPACE + dimString + "=\"" + val + "dp\"");
            return;
        }

        private void writeEnum(String dimString, int val, String[] types, int def) throws IOException {
            if (val == def) goto L5;
            this.writer.write(SPACE + dimString + "=\"" + types[val] + "\"");
            return;
        }

        private void writeDimension(String dimString, int dim, int def) throws IOException {
            if (dim == def) goto L5;
            this.writer.write(SPACE + dimString + "=\"" + dim + "dp\"");
            return;
        }

        private void writeBaseDimension(String dimString, int dim, int def) throws IOException {
            if (dim != def) goto L4;
            return;
        L4:
            if (dim != (-2)) goto L7;
            this.writer.write(SPACE + dimString + "=\"wrap_content\"");
            return;
        L7:
            if (dim != (-1)) goto L9;
            this.writer.write(SPACE + dimString + "=\"match_parent\"");
            return;
        L9:
            this.writer.write(SPACE + dimString + "=\"" + dim + "dp\"");
        }

        String getName(int id) {
            if (this.idMap.containsKey(Integer.valueOf(id)) == true) goto L5;
            if (id != 0) goto L9;
            return ConstraintSet.KEY_PERCENT_PARENT;
        L9:
            String r0 = lookup(id);
            this.idMap.put(Integer.valueOf(id), r0);
            return "@+id/" + r0 + "";
        L5:
            return "@+id/" + this.idMap.get(Integer.valueOf(id)) + "";
        }

        String lookup(int id) {
            if (id != (-1)) goto L5;
            StringBuilder r3 = new StringBuilder(EnvironmentCompat.MEDIA_UNKNOWN);     // Catch: Exception -> L8
            int r0 = this.unknownCount + 1;     // Catch: Exception -> L8
            this.unknownCount = r0;     // Catch: Exception -> L8
            return r3.append(r0).toString();
        L5:
            return this.context.getResources().getResourceEntryName(id);
        L8:
            StringBuilder r4 = new StringBuilder(EnvironmentCompat.MEDIA_UNKNOWN);
            int r1 = this.unknownCount + 1;
            this.unknownCount = r1;
            return r4.append(r1).toString();
        }

        void writeXmlConstraint(String str, int leftToLeft) throws IOException {
            if (leftToLeft != (-1)) goto L5;
            return;
        L5:
            this.writer.write(SPACE + str);
            this.writer.write("=\"" + getName(leftToLeft) + "\"");
        }

        void writeConstraint(String my, int leftToLeft, String other, int margin, int goneMargin) throws IOException {
            if (leftToLeft != (-1)) goto L5;
            return;
        L5:
            this.writer.write(SPACE + my);
            this.writer.write(":[");
            this.writer.write(getName(leftToLeft));
            this.writer.write(" , ");
            this.writer.write(other);
            if (margin == 0) goto L8;
            this.writer.write(" , " + margin);
        L8:
            this.writer.write("],\n");
        }

        void writeCircle(int circleConstraint, float circleAngle, int circleRadius) throws IOException {
            if (circleConstraint != (-1)) goto L5;
            return;
        L5:
            this.writer.write("circle");
            this.writer.write(":[");
            this.writer.write(getName(circleConstraint));
            this.writer.write(", " + circleAngle);
            this.writer.write(circleRadius + "]");
        }

        void writeVariable(String name, int value) throws IOException {
            if (value != 0) goto L4;
            return;
        L4:
            if (value == (-1)) goto L9;
            this.writer.write(SPACE + name + "=\"" + value + "\"\n");
            return;
        }

        void writeVariable(String name, float value, float def) throws IOException {
            if (value != def) goto L5;
            return;
        L5:
            this.writer.write(SPACE + name);
            this.writer.write("=\"" + value + "\"");
        }

        void writeVariable(String name, String value, String def) throws IOException {
            if (value != null) goto L4;
            return;
        L4:
            if (value.equals(def) == true) goto L9;
            this.writer.write(SPACE + name);
            this.writer.write("=\"" + value + "\"");
            return;
        }

        void writeVariable(String name, int[] value) throws IOException {
            if (value != null) goto L4;
            return;
        L4:
            this.writer.write(SPACE + name);
            this.writer.write(":");
            int r4 = 0;
        L6:
            if (r4 >= value.length) goto L12;
            Writer r0 = this.writer;
            StringBuilder r1 = new StringBuilder();
            if (r4 != 0) goto L10;
            String r2 = "[";
        L11:
            r0.write(r1.append(r2).append(getName(value[r4])).toString());
            r4 = r4 + 1;
            goto L6
        L10:
            r2 = ", ";
            goto L11
        L12:
            this.writer.write("],\n");
        }

        void writeVariable(String name, String value) throws IOException {
            if (value != null) goto L4;
            return;
        L4:
            this.writer.write(name);
            this.writer.write(":");
            this.writer.write(", " + value);
            this.writer.write("\n");
        }
    }

    private String sideToString(int side) {
        switch(side) {
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

    public HashMap<String, ConstraintAttribute> getCustomAttributeSet() {
        return this.mSavedAttributes;
    }

    public Constraint getParameters(int mId) {
        return get(mId);
    }

    public void readFallback(ConstraintSet set) {
        Iterator<Integer> r0 = set.mConstraints.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L29;
        Integer r1 = r0.next();
        int r2 = r1.intValue();
        Constraint r3 = set.mConstraints.get(r1);
        if (this.mConstraints.containsKey(Integer.valueOf(r2)) == true) goto L8;
        this.mConstraints.put(Integer.valueOf(r2), new Constraint());
    L8:
        Constraint r4 = this.mConstraints.get(Integer.valueOf(r2));
        if (r4 == null) goto L4;
        if (r4.layout.mApply == true) goto L15;
        r4.layout.copyFrom(r3.layout);
    L15:
        if (r4.propertySet.mApply == true) goto L18;
        r4.propertySet.copyFrom(r3.propertySet);
    L18:
        if (r4.transform.mApply == true) goto L21;
        r4.transform.copyFrom(r3.transform);
    L21:
        if (r4.motion.mApply == true) goto L23;
        r4.motion.copyFrom(r3.motion);
    L23:
        Iterator<String> r5 = r3.mCustomConstraints.keySet().iterator();
    L25:
        if (r5.hasNext() == false) goto L4;
        String r6 = r5.next();
        if (r4.mCustomConstraints.containsKey(r6) == true) goto L25;
        r4.mCustomConstraints.put(r6, r3.mCustomConstraints.get(r6));
        goto L25
    }

    public void readFallback(ConstraintLayout constraintLayout) {
        int r0 = constraintLayout.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L39;
        View r2 = constraintLayout.getChildAt(r1);
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
        if (r5.layout.mApply == true) goto L26;
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
    L26:
        if (r5.propertySet.mApply == true) goto L29;
        r5.propertySet.visibility = r2.getVisibility();
        r5.propertySet.alpha = r2.getAlpha();
        r5.propertySet.mApply = true;
    L29:
        if (r5.transform.mApply == true) goto L38;
        r5.transform.mApply = true;
        r5.transform.rotation = r2.getRotation();
        r5.transform.rotationX = r2.getRotationX();
        r5.transform.rotationY = r2.getRotationY();
        r5.transform.scaleX = r2.getScaleX();
        r5.transform.scaleY = r2.getScaleY();
        float r7 = r2.getPivotX();
        float r8 = r2.getPivotY();
        if (r7 == 0.0d) goto L33;
    L34:
        r5.transform.transformPivotX = r7;
        r5.transform.transformPivotY = r8;
    L35:
        r5.transform.translationX = r2.getTranslationX();
        r5.transform.translationY = r2.getTranslationY();
        r5.transform.translationZ = r2.getTranslationZ();
        if (r5.transform.applyElevation == false) goto L38;
        r5.transform.elevation = r2.getElevation();
        goto L38
    L33:
        if (r8 == 0.0d) goto L35;
    L38:
        r1 = r1 + 1;
        goto L3
    }

    public void applyDeltaFrom(ConstraintSet cs) {
        Iterator<Constraint> r6 = cs.mConstraints.values().iterator();
    L4:
        if (r6.hasNext() == false) goto L18;
        Constraint r0 = r6.next();
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
        if (r3.layout.mConstraintTag == null) goto L11;
        if (r0.mTargetString.matches(r3.layout.mConstraintTag) == false) goto L11;
        r0.mDelta.applyDelta(r3);
        r3.mCustomConstraints.putAll((HashMap) r0.mCustomConstraints.clone());
        goto L11
    }

    static void parseDimensionConstraints(Object data, TypedArray a, int attr, int orientation) {
        if (data != null) goto L4;
        return;
    L4:
        int r0 = a.peekValue(attr).type;
        if (r0 == 3) goto L38;
        int r2 = 0;
        if (r0 == 5) goto L17;
        int r5 = a.getInt(attr, 0);
        if (r5 != (-4)) goto L11;
        boolean r6 = true;
        r2 = -2;
    L20:
        if ((data instanceof ConstraintLayout.LayoutParams) == false) goto L26;
        ConstraintLayout.LayoutParams r4 = (ConstraintLayout.LayoutParams) data;
        if (orientation != 0) goto L24;
        r4.width = r2;
        r4.constrainedWidth = r6;
        return;
    L24:
        r4.height = r2;
        r4.constrainedHeight = r6;
        return;
    L26:
        if ((data instanceof Layout) == false) goto L32;
        Layout r7 = (Layout) data;
        if (orientation != 0) goto L30;
        r7.mWidth = r2;
        r7.constrainedWidth = r6;
        return;
    L30:
        r7.mHeight = r2;
        r7.constrainedHeight = r6;
        return;
    L32:
        if ((data instanceof Constraint.Delta) == false) goto L44;
        Constraint.Delta r8 = (Constraint.Delta) data;
        if (orientation != 0) goto L36;
        r8.add(23, r2);
        r8.add(80, r6);
        return;
    L36:
        r8.add(21, r2);
        r8.add(81, r6);
        return;
    L44:
        return;
    L11:
        if (r5 == (-3)) goto L15;
        if (r5 != (-2)) goto L14;
    L18:
        r2 = r5;
        r6 = false;
        goto L20
    L14:
        if (r5 == (-1)) goto L18;
    L15:
        r6 = false;
        goto L20
    L17:
        r5 = a.getDimensionPixelSize(attr, 0);
        goto L18
    L38:
        parseDimensionConstraintsString(data, a.getString(attr), orientation);
    }

    static void parseDimensionRatioString(ConstraintLayout.LayoutParams params, String value) {
        float r0 = Float.NaN;
        int r1 = -1;
        if (value == null) goto L34;
        int r2 = value.length();
        int r3 = value.indexOf(44);
        int r4 = 0;
        if (r3 > 0) goto L7;
    L15:
        int r5 = value.indexOf(58);
        if (r5 >= 0) goto L18;
    L31:
        String r6 = value.substring(r4);
        if (r6.length() <= 0) goto L34;
        r0 = Float.parseFloat(r6);     // Catch: NumberFormatException -> L36
    L37:
        goto L34
    L18:
        if (r5 >= (r2 - 1)) goto L31;
        String r7 = value.substring(r4, r5);
        String r8 = value.substring(r5 + 1);
        if (r7.length() <= 0) goto L34;
        if (r8.length() <= 0) goto L34;
        float r9 = Float.parseFloat(r7);     // Catch: NumberFormatException -> L36
        float r10 = Float.parseFloat(r8);     // Catch: NumberFormatException -> L36
        if (r9 <= 0.0f) goto L37;
        if (r10 <= 0.0f) goto L37;
        if (r1 != 1) goto L29;
        r0 = Math.abs(r10 / r9);     // Catch: NumberFormatException -> L36
        goto L37
    L29:
        r0 = Math.abs(r9 / r10);     // Catch: NumberFormatException -> L36
        goto L37
    L7:
        if (r3 >= (r2 - 1)) goto L15;
        String r11 = value.substring(0, r3);
        if (r11.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST) == false) goto L12;
        r1 = 0;
    L14:
        r4 = r3 + 1;
        goto L15
    L12:
        if (r11.equalsIgnoreCase(DateFormat.HOUR24) == false) goto L14;
        r1 = 1;
    L34:
        params.dimensionRatio = value;
        params.dimensionRatioValue = r0;
        params.dimensionRatioSide = r1;
    }

    static void parseDimensionConstraintsString(Object data, String value, int orientation) {
        if (value != null) goto L4;
        return;
    L4:
        int r0 = value.indexOf(61);
        int r1 = value.length();
        if (r0 > 0) goto L7;
        return;
    L7:
        if (r0 >= (r1 - 1)) goto L72;
        String r2 = value.substring(0, r0);
        String r6 = value.substring(r0 + 1);
        if (r6.length() <= 0) goto L73;
        String r3 = r2.trim();
        String r7 = r6.trim();
        if (KEY_RATIO.equalsIgnoreCase(r3) == false) goto L69;
        if ((data instanceof ConstraintLayout.LayoutParams) == false) goto L20;
        ConstraintLayout.LayoutParams r5 = (ConstraintLayout.LayoutParams) data;
        if (orientation != 0) goto L17;
        r5.width = 0;
    L18:
        parseDimensionRatioString(r5, r7);
        return;
    L17:
        r5.height = 0;
        goto L18
    L20:
        if ((data instanceof Layout) == false) goto L23;
        ((Layout) data).dimensionRatio = r7;
        return;
    L23:
        if ((data instanceof Constraint.Delta) == false) goto L76;
        ((Constraint.Delta) data).add(5, r7);
        return;
    L76:
        return;
    L69:
        if (KEY_WEIGHT.equalsIgnoreCase(r3) == false) goto L47;
        float r8 = Float.parseFloat(r7);     // Catch: NumberFormatException -> L67
        if ((data instanceof ConstraintLayout.LayoutParams) == false) goto L34;
        ConstraintLayout.LayoutParams r9 = (ConstraintLayout.LayoutParams) data;     // Catch: NumberFormatException -> L67
        if (orientation != 0) goto L32;
        r9.width = 0;     // Catch: NumberFormatException -> L67
        r9.horizontalWeight = r8;     // Catch: NumberFormatException -> L67
    L68:
        return;
    L32:
        r9.height = 0;     // Catch: NumberFormatException -> L67
        r9.verticalWeight = r8;     // Catch: NumberFormatException -> L67
        goto L68
    L34:
        if ((data instanceof Layout) == false) goto L40;
        Layout r10 = (Layout) data;     // Catch: NumberFormatException -> L67
        if (orientation != 0) goto L38;
        r10.mWidth = 0;     // Catch: NumberFormatException -> L67
        r10.horizontalWeight = r8;     // Catch: NumberFormatException -> L67
        goto L68
    L38:
        r10.mHeight = 0;     // Catch: NumberFormatException -> L67
        r10.verticalWeight = r8;     // Catch: NumberFormatException -> L67
        goto L68
    L40:
        if ((data instanceof Constraint.Delta) == false) goto L68;
        Constraint.Delta r11 = (Constraint.Delta) data;     // Catch: NumberFormatException -> L67
        if (orientation != 0) goto L44;
        r11.add(23, 0);     // Catch: NumberFormatException -> L67
        r11.add(39, r8);     // Catch: NumberFormatException -> L67
        goto L68
    L44:
        r11.add(21, 0);     // Catch: NumberFormatException -> L67
        r11.add(40, r8);     // Catch: NumberFormatException -> L67
        goto L68
    L47:
        if (KEY_PERCENT_PARENT.equalsIgnoreCase(r3) == false) goto L78;
        float r12 = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(r7)));     // Catch: NumberFormatException -> L67
        if ((data instanceof ConstraintLayout.LayoutParams) == false) goto L55;
        ConstraintLayout.LayoutParams r13 = (ConstraintLayout.LayoutParams) data;     // Catch: NumberFormatException -> L67
        if (orientation != 0) goto L53;
        r13.width = 0;     // Catch: NumberFormatException -> L67
        r13.matchConstraintPercentWidth = r12;     // Catch: NumberFormatException -> L67
        r13.matchConstraintDefaultWidth = 2;     // Catch: NumberFormatException -> L67
        goto L68
    L53:
        r13.height = 0;     // Catch: NumberFormatException -> L67
        r13.matchConstraintPercentHeight = r12;     // Catch: NumberFormatException -> L67
        r13.matchConstraintDefaultHeight = 2;     // Catch: NumberFormatException -> L67
        goto L68
    L55:
        if ((data instanceof Layout) == false) goto L61;
        Layout r14 = (Layout) data;     // Catch: NumberFormatException -> L67
        if (orientation != 0) goto L59;
        r14.mWidth = 0;     // Catch: NumberFormatException -> L67
        r14.widthPercent = r12;     // Catch: NumberFormatException -> L67
        r14.widthDefault = 2;     // Catch: NumberFormatException -> L67
        goto L68
    L59:
        r14.mHeight = 0;     // Catch: NumberFormatException -> L67
        r14.heightPercent = r12;     // Catch: NumberFormatException -> L67
        r14.heightDefault = 2;     // Catch: NumberFormatException -> L67
        goto L68
    L61:
        if ((data instanceof Constraint.Delta) == false) goto L68;
        Constraint.Delta r15 = (Constraint.Delta) data;     // Catch: NumberFormatException -> L67
        if (orientation != 0) goto L65;
        r15.add(23, 0);     // Catch: NumberFormatException -> L67
        r15.add(54, 2);     // Catch: NumberFormatException -> L67
        goto L68
    L65:
        r15.add(21, 0);     // Catch: NumberFormatException -> L67
        r15.add(55, 2);     // Catch: NumberFormatException -> L67
        goto L68
    L78:
        return;
    L79:
        return;
    L73:
        return;
    }

    public void clone(Context context, int constraintLayoutId) {
        clone((ConstraintLayout) LayoutInflater.from(context).inflate(constraintLayoutId, null));
    }

    public void clone(ConstraintSet set) {
        this.mConstraints.clear();
        Iterator<Integer> r0 = set.mConstraints.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Integer r1 = r0.next();
        Constraint r2 = set.mConstraints.get(r1);
        if (r2 == null) goto L4;
        this.mConstraints.put(r1, r2.clone());
        goto L4
    }

    public void clone(ConstraintLayout constraintLayout) {
        int r0 = constraintLayout.getChildCount();
        this.mConstraints.clear();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L29;
        View r2 = constraintLayout.getChildAt(r1);
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
        r5.transform.transformPivotX = r6;
        r5.transform.transformPivotY = r7;
    L22:
        r5.transform.translationX = r2.getTranslationX();
        r5.transform.translationY = r2.getTranslationY();
        r5.transform.translationZ = r2.getTranslationZ();
        if (r5.transform.applyElevation == false) goto L26;
        r5.transform.elevation = r2.getElevation();
    L26:
        if ((r2 instanceof Barrier) == false) goto L28;
        Barrier r8 = (Barrier) r2;
        r5.layout.mBarrierAllowsGoneWidgets = r8.getAllowsGoneWidget();
        r5.layout.mReferenceIds = r8.getReferencedIds();
        r5.layout.mBarrierDirection = r8.getType();
        r5.layout.mBarrierMargin = r8.getMargin();
        goto L28
    L20:
        if (r7 == 0.0d) goto L22;
    L28:
        r1 = r1 + 1;
        goto L3
    }

    public void clone(Constraints constraints) {
        int r0 = constraints.getChildCount();
        this.mConstraints.clear();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L22;
        View r2 = constraints.getChildAt(r1);
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

    public void applyTo(ConstraintLayout constraintLayout) {
        applyToInternal(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public void applyToWithoutCustom(ConstraintLayout constraintLayout) {
        applyToInternal(constraintLayout, false);
        constraintLayout.setConstraintSet(null);
    }

    public void applyCustomAttributes(ConstraintLayout constraintLayout) {
        int r0 = constraintLayout.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L21;
        View r2 = constraintLayout.getChildAt(r1);
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

    public void applyToHelper(ConstraintHelper helper, ConstraintWidget child, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> mapIdToWidget) {
        int r0 = helper.getId();
        if (this.mConstraints.containsKey(Integer.valueOf(r0)) == false) goto L10;
        Constraint r3 = this.mConstraints.get(Integer.valueOf(r0));
        if (r3 != null) goto L7;
        return;
    L7:
        if ((child instanceof HelperWidget) == false) goto L12;
        helper.loadParameters(r3, (HelperWidget) child, layoutParams, mapIdToWidget);
        return;
    L12:
        return;
    }

    public void applyToLayoutParams(int id, ConstraintLayout.LayoutParams layoutParams) {
        if (this.mConstraints.containsKey(Integer.valueOf(id)) == false) goto L8;
        Constraint r2 = this.mConstraints.get(Integer.valueOf(id));
        if (r2 == null) goto L9;
        r2.applyTo(layoutParams);
        return;
    L9:
        return;
    }

    void applyToInternal(ConstraintLayout constraintLayout, boolean applyPostLayout) {
        int r0 = constraintLayout.getChildCount();
        HashSet r1 = new HashSet(this.mConstraints.keySet());
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r3 >= r0) goto L55;
        View r5 = constraintLayout.getChildAt(r3);
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
        if (r7.layout.mReferenceIds == null) goto L27;
        r4.setReferencedIds(r7.layout.mReferenceIds);
        goto L29
    L27:
        if (r7.layout.mReferenceIdString == null) goto L29;
        r7.layout.mReferenceIds = convertReferenceString(r4, r7.layout.mReferenceIdString);
        r4.setReferencedIds(r7.layout.mReferenceIds);
    L29:
        ConstraintLayout.LayoutParams r8 = (ConstraintLayout.LayoutParams) r5.getLayoutParams();
        r8.validate();
        r7.applyTo(r8);
        if (applyPostLayout == false) goto L32;
        ConstraintAttribute.setAttributes(r5, r7.mCustomConstraints);
    L32:
        r5.setLayoutParams(r8);
        if (r7.propertySet.mVisibilityMode != 0) goto L35;
        r5.setVisibility(r7.propertySet.visibility);
    L35:
        r5.setAlpha(r7.propertySet.alpha);
        r5.setRotation(r7.transform.rotation);
        r5.setRotationX(r7.transform.rotationX);
        r5.setRotationY(r7.transform.rotationY);
        r5.setScaleX(r7.transform.scaleX);
        r5.setScaleY(r7.transform.scaleY);
        if (r7.transform.transformPivotTarget == (-1)) goto L45;
        View r9 = ((View) r5.getParent()).findViewById(r7.transform.transformPivotTarget);
        if (r9 == null) goto L50;
        float r10 = (r9.getTop() + r9.getBottom()) / 2.0f;
        float r11 = (r9.getLeft() + r9.getRight()) / 2.0f;
        if ((r5.getRight() - r5.getLeft()) <= 0) goto L50;
        if ((r5.getBottom() - r5.getTop()) <= 0) goto L50;
        float r12 = r11 - r5.getLeft();
        float r13 = r10 - r5.getTop();
        r5.setPivotX(r12);
        r5.setPivotY(r13);
    L50:
        r5.setTranslationX(r7.transform.translationX);
        r5.setTranslationY(r7.transform.translationY);
        r5.setTranslationZ(r7.transform.translationZ);
        if (r7.transform.applyElevation == false) goto L54;
        r5.setElevation(r7.transform.elevation);
        goto L54
    L45:
        if (Float.isNaN(r7.transform.transformPivotX) == true) goto L48;
        r5.setPivotX(r7.transform.transformPivotX);
    L48:
        if (Float.isNaN(r7.transform.transformPivotY) == true) goto L50;
        r5.setPivotY(r7.transform.transformPivotY);
        goto L50
    L53:
        Log.v(TAG, "WARNING NO CONSTRAINTS for view " + r6);
        goto L54
    L55:
        Iterator r14 = r1.iterator();
    L57:
        if (r14.hasNext() == false) goto L73;
        Integer r15 = (Integer) r14.next();
        Constraint r16 = this.mConstraints.get(r15);
        if (r16 == null) goto L57;
        if (r16.layout.mHelperType != 1) goto L71;
        Barrier r17 = new Barrier(constraintLayout.getContext());
        r17.setId(r15.intValue());
        if (r16.layout.mReferenceIds == null) goto L67;
        r17.setReferencedIds(r16.layout.mReferenceIds);
    L69:
        r17.setType(r16.layout.mBarrierDirection);
        r17.setMargin(r16.layout.mBarrierMargin);
        ConstraintLayout.LayoutParams r18 = constraintLayout.generateDefaultLayoutParams();
        r17.validateParams();
        r16.applyTo(r18);
        constraintLayout.addView(r17, r18);
        goto L71
    L67:
        if (r16.layout.mReferenceIdString == null) goto L69;
        r16.layout.mReferenceIds = convertReferenceString(r17, r16.layout.mReferenceIdString);
        r17.setReferencedIds(r16.layout.mReferenceIds);
    L71:
        if (r16.layout.mIsGuideline == false) goto L57;
        Guideline r19 = new Guideline(constraintLayout.getContext());
        r19.setId(r15.intValue());
        ConstraintLayout.LayoutParams r20 = constraintLayout.generateDefaultLayoutParams();
        r16.applyTo(r20);
        constraintLayout.addView(r19, r20);
    L73:
        if (r2 >= r0) goto L78;
        View r110 = constraintLayout.getChildAt(r2);
        if ((r110 instanceof ConstraintHelper) == false) goto L77;
        ((ConstraintHelper) r110).applyLayoutFeaturesInConstraintSet(constraintLayout);
    L77:
        r2 = r2 + 1;
        goto L73
    }

    public void center(int centerID, int firstID, int firstSide, int firstMargin, int secondId, int secondSide, int secondMargin, float bias) {
        if (firstMargin < 0) goto L34;
        if (secondMargin < 0) goto L32;
        if (bias <= 0.0f) goto L30;
        if (bias > 1.0f) goto L30;
        if (firstSide != 1) goto L12;
    L25:
        connect(centerID, 1, firstID, firstSide, firstMargin);
        connect(centerID, 2, secondId, secondSide, secondMargin);
        Constraint r0 = this.mConstraints.get(Integer.valueOf(centerID));
        if (r0 == null) goto L39;
        r0.layout.horizontalBias = bias;
        return;
    L39:
        return;
    L12:
        if (firstSide == 2) goto L25;
        if (firstSide != 6) goto L17;
    L22:
        connect(centerID, 6, firstID, firstSide, firstMargin);
        connect(centerID, 7, secondId, secondSide, secondMargin);
        Constraint r1 = this.mConstraints.get(Integer.valueOf(centerID));
        if (r1 == null) goto L37;
        r1.layout.horizontalBias = bias;
        return;
    L37:
        return;
    L17:
        if (firstSide == 7) goto L22;
        connect(centerID, 3, firstID, firstSide, firstMargin);
        connect(centerID, 4, secondId, secondSide, secondMargin);
        Constraint r2 = this.mConstraints.get(Integer.valueOf(centerID));
        if (r2 == null) goto L35;
        r2.layout.verticalBias = bias;
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

    public void centerHorizontally(int centerID, int leftId, int leftSide, int leftMargin, int rightId, int rightSide, int rightMargin, float bias) {
        connect(centerID, 1, leftId, leftSide, leftMargin);
        connect(centerID, 2, rightId, rightSide, rightMargin);
        Constraint r0 = this.mConstraints.get(Integer.valueOf(centerID));
        if (r0 == null) goto L6;
        r0.layout.horizontalBias = bias;
        return;
    }

    public void centerHorizontallyRtl(int centerID, int startId, int startSide, int startMargin, int endId, int endSide, int endMargin, float bias) {
        connect(centerID, 6, startId, startSide, startMargin);
        connect(centerID, 7, endId, endSide, endMargin);
        Constraint r0 = this.mConstraints.get(Integer.valueOf(centerID));
        if (r0 == null) goto L6;
        r0.layout.horizontalBias = bias;
        return;
    }

    public void centerVertically(int centerID, int topId, int topSide, int topMargin, int bottomId, int bottomSide, int bottomMargin, float bias) {
        connect(centerID, 3, topId, topSide, topMargin);
        connect(centerID, 4, bottomId, bottomSide, bottomMargin);
        Constraint r0 = this.mConstraints.get(Integer.valueOf(centerID));
        if (r0 == null) goto L6;
        r0.layout.verticalBias = bias;
        return;
    }

    public void createVerticalChain(int topId, int topSide, int bottomId, int bottomSide, int[] chainIds, float[] weights, int style) {
        if (chainIds.length < 2) goto L23;
        if (weights == null) goto L11;
        if (weights.length == chainIds.length) goto L11;
        throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    L11:
        if (weights == null) goto L13;
        get(chainIds[0]).layout.verticalWeight = weights[0];
    L13:
        get(chainIds[0]).layout.verticalChainStyle = style;
        connect(chainIds[0], 3, topId, topSide, 0);
        int r10 = 1;
    L15:
        if (r10 >= chainIds.length) goto L20;
        int r11 = r10 - 1;
        connect(chainIds[r10], 3, chainIds[r11], 4, 0);
        connect(chainIds[r11], 4, chainIds[r10], 3, 0);
        if (weights == null) goto L19;
        get(chainIds[r10]).layout.verticalWeight = weights[r10];
    L19:
        r10 = r10 + 1;
        goto L15
    L20:
        connect(chainIds[chainIds.length - 1], 4, bottomId, bottomSide, 0);
        return;
    L23:
        throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    }

    public void createHorizontalChain(int leftId, int leftSide, int rightId, int rightSide, int[] chainIds, float[] weights, int style) {
        createHorizontalChain(leftId, leftSide, rightId, rightSide, chainIds, weights, style, 1, 2);
    }

    public void createHorizontalChainRtl(int startId, int startSide, int endId, int endSide, int[] chainIds, float[] weights, int style) {
        createHorizontalChain(startId, startSide, endId, endSide, chainIds, weights, style, 6, 7);
    }

    private void createHorizontalChain(int leftId, int leftSide, int rightId, int rightSide, int[] chainIds, float[] weights, int style, int left, int right) {
        if (chainIds.length < 2) goto L23;
        if (weights == null) goto L11;
        if (weights.length == chainIds.length) goto L11;
        throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    L11:
        if (weights == null) goto L13;
        get(chainIds[0]).layout.horizontalWeight = weights[0];
    L13:
        get(chainIds[0]).layout.horizontalChainStyle = style;
        connect(chainIds[0], left, leftId, leftSide, -1);
        int r10 = 1;
    L15:
        if (r10 >= chainIds.length) goto L20;
        int r11 = r10 - 1;
        connect(chainIds[r10], left, chainIds[r11], right, -1);
        connect(chainIds[r11], right, chainIds[r10], left, -1);
        if (weights == null) goto L19;
        get(chainIds[r10]).layout.horizontalWeight = weights[r10];
    L19:
        r10 = r10 + 1;
        goto L15
    L20:
        connect(chainIds[chainIds.length - 1], right, rightId, rightSide, -1);
        return;
    L23:
        throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    }

    public void connect(int startID, int startSide, int endID, int endSide, int margin) {
        if (this.mConstraints.containsKey(Integer.valueOf(startID)) == true) goto L5;
        this.mConstraints.put(Integer.valueOf(startID), new Constraint());
    L5:
        Constraint r10 = this.mConstraints.get(Integer.valueOf(startID));
        if (r10 != null) goto L9;
        return;
    L9:
        switch(startSide) {
            case 1: goto L56;
            case 2: goto L49;
            case 3: goto L42;
            case 4: goto L35;
            case 5: goto L27;
            case 6: goto L19;
            case 7: goto L12;
            default: goto L11;
        };
    L12:
        if (endSide != 7) goto L14;
        r10.layout.endToEnd = endID;
        r10.layout.endToStart = -1;
    L16:
        r10.layout.endMargin = margin;
        return;
    L14:
        if (endSide != 6) goto L18;
        r10.layout.endToStart = endID;
        r10.layout.endToEnd = -1;
        goto L16
    L18:
        throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
    L19:
        if (endSide != 6) goto L21;
        r10.layout.startToStart = endID;
        r10.layout.startToEnd = -1;
    L23:
        r10.layout.startMargin = margin;
        return;
    L21:
        if (endSide != 7) goto L25;
        r10.layout.startToEnd = endID;
        r10.layout.startToStart = -1;
        goto L23
    L25:
        throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
    L35:
        if (endSide != 4) goto L37;
        r10.layout.bottomToBottom = endID;
        r10.layout.bottomToTop = -1;
        r10.layout.baselineToBaseline = -1;
        r10.layout.baselineToTop = -1;
        r10.layout.baselineToBottom = -1;
    L39:
        r10.layout.bottomMargin = margin;
        return;
    L37:
        if (endSide != 3) goto L41;
        r10.layout.bottomToTop = endID;
        r10.layout.bottomToBottom = -1;
        r10.layout.baselineToBaseline = -1;
        r10.layout.baselineToTop = -1;
        r10.layout.baselineToBottom = -1;
        goto L39
    L41:
        throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
    L42:
        if (endSide != 3) goto L44;
        r10.layout.topToTop = endID;
        r10.layout.topToBottom = -1;
        r10.layout.baselineToBaseline = -1;
        r10.layout.baselineToTop = -1;
        r10.layout.baselineToBottom = -1;
    L46:
        r10.layout.topMargin = margin;
        return;
    L44:
        if (endSide != 4) goto L48;
        r10.layout.topToBottom = endID;
        r10.layout.topToTop = -1;
        r10.layout.baselineToBaseline = -1;
        r10.layout.baselineToTop = -1;
        r10.layout.baselineToBottom = -1;
        goto L46
    L48:
        throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
    L49:
        if (endSide != 1) goto L51;
        r10.layout.rightToLeft = endID;
        r10.layout.rightToRight = -1;
    L53:
        r10.layout.rightMargin = margin;
        return;
    L51:
        if (endSide != 2) goto L55;
        r10.layout.rightToRight = endID;
        r10.layout.rightToLeft = -1;
        goto L53
    L55:
        throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
    L56:
        if (endSide != 1) goto L58;
        r10.layout.leftToLeft = endID;
        r10.layout.leftToRight = -1;
    L60:
        r10.layout.leftMargin = margin;
        return;
    L58:
        if (endSide != 2) goto L63;
        r10.layout.leftToRight = endID;
        r10.layout.leftToLeft = -1;
        goto L60
    L63:
        throw new IllegalArgumentException("Left to " + sideToString(endSide) + " undefined");
    L11:
        throw new IllegalArgumentException(sideToString(startSide) + " to " + sideToString(endSide) + " unknown");
    L27:
        if (endSide != 5) goto L29;
        r10.layout.baselineToBaseline = endID;
        r10.layout.bottomToBottom = -1;
        r10.layout.bottomToTop = -1;
        r10.layout.topToTop = -1;
        r10.layout.topToBottom = -1;
        return;
    L29:
        if (endSide != 3) goto L31;
        r10.layout.baselineToTop = endID;
        r10.layout.bottomToBottom = -1;
        r10.layout.bottomToTop = -1;
        r10.layout.topToTop = -1;
        r10.layout.topToBottom = -1;
        return;
    L31:
        if (endSide != 4) goto L34;
        r10.layout.baselineToBottom = endID;
        r10.layout.bottomToBottom = -1;
        r10.layout.bottomToTop = -1;
        r10.layout.topToTop = -1;
        r10.layout.topToBottom = -1;
        return;
    L34:
        throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
    }

    public void connect(int startID, int startSide, int endID, int endSide) {
        if (this.mConstraints.containsKey(Integer.valueOf(startID)) == true) goto L5;
        this.mConstraints.put(Integer.valueOf(startID), new Constraint());
    L5:
        Constraint r10 = this.mConstraints.get(Integer.valueOf(startID));
        if (r10 != null) goto L9;
        return;
    L9:
        switch(startSide) {
            case 1: goto L51;
            case 2: goto L45;
            case 3: goto L39;
            case 4: goto L33;
            case 5: goto L25;
            case 6: goto L18;
            case 7: goto L12;
            default: goto L11;
        };
    L12:
        if (endSide != 7) goto L14;
        r10.layout.endToEnd = endID;
        r10.layout.endToStart = -1;
        return;
    L14:
        if (endSide != 6) goto L17;
        r10.layout.endToStart = endID;
        r10.layout.endToEnd = -1;
        return;
    L17:
        throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
    L18:
        if (endSide != 6) goto L20;
        r10.layout.startToStart = endID;
        r10.layout.startToEnd = -1;
        return;
    L20:
        if (endSide != 7) goto L23;
        r10.layout.startToEnd = endID;
        r10.layout.startToStart = -1;
        return;
    L23:
        throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
    L33:
        if (endSide != 4) goto L35;
        r10.layout.bottomToBottom = endID;
        r10.layout.bottomToTop = -1;
        r10.layout.baselineToBaseline = -1;
        r10.layout.baselineToTop = -1;
        r10.layout.baselineToBottom = -1;
        return;
    L35:
        if (endSide != 3) goto L38;
        r10.layout.bottomToTop = endID;
        r10.layout.bottomToBottom = -1;
        r10.layout.baselineToBaseline = -1;
        r10.layout.baselineToTop = -1;
        r10.layout.baselineToBottom = -1;
        return;
    L38:
        throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
    L39:
        if (endSide != 3) goto L41;
        r10.layout.topToTop = endID;
        r10.layout.topToBottom = -1;
        r10.layout.baselineToBaseline = -1;
        r10.layout.baselineToTop = -1;
        r10.layout.baselineToBottom = -1;
        return;
    L41:
        if (endSide != 4) goto L44;
        r10.layout.topToBottom = endID;
        r10.layout.topToTop = -1;
        r10.layout.baselineToBaseline = -1;
        r10.layout.baselineToTop = -1;
        r10.layout.baselineToBottom = -1;
        return;
    L44:
        throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
    L45:
        if (endSide != 1) goto L47;
        r10.layout.rightToLeft = endID;
        r10.layout.rightToRight = -1;
        return;
    L47:
        if (endSide != 2) goto L50;
        r10.layout.rightToRight = endID;
        r10.layout.rightToLeft = -1;
        return;
    L50:
        throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
    L51:
        if (endSide != 1) goto L53;
        r10.layout.leftToLeft = endID;
        r10.layout.leftToRight = -1;
        return;
    L53:
        if (endSide != 2) goto L57;
        r10.layout.leftToRight = endID;
        r10.layout.leftToLeft = -1;
        return;
    L57:
        throw new IllegalArgumentException("left to " + sideToString(endSide) + " undefined");
    L11:
        throw new IllegalArgumentException(sideToString(startSide) + " to " + sideToString(endSide) + " unknown");
    L25:
        if (endSide != 5) goto L27;
        r10.layout.baselineToBaseline = endID;
        r10.layout.bottomToBottom = -1;
        r10.layout.bottomToTop = -1;
        r10.layout.topToTop = -1;
        r10.layout.topToBottom = -1;
        return;
    L27:
        if (endSide != 3) goto L29;
        r10.layout.baselineToTop = endID;
        r10.layout.bottomToBottom = -1;
        r10.layout.bottomToTop = -1;
        r10.layout.topToTop = -1;
        r10.layout.topToBottom = -1;
        return;
    L29:
        if (endSide != 4) goto L32;
        r10.layout.baselineToBottom = endID;
        r10.layout.bottomToBottom = -1;
        r10.layout.bottomToTop = -1;
        r10.layout.topToTop = -1;
        r10.layout.topToBottom = -1;
        return;
    L32:
        throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
    }

    public void centerHorizontally(int viewId, int toView) {
        if (toView != 0) goto L4;
        center(viewId, 0, 1, 0, 0, 2, 0, 0.5f);
        return;
    L4:
        center(viewId, toView, 2, 0, toView, 1, 0, 0.5f);
    }

    public void centerHorizontallyRtl(int viewId, int toView) {
        if (toView != 0) goto L4;
        center(viewId, 0, 6, 0, 0, 7, 0, 0.5f);
        return;
    L4:
        center(viewId, toView, 7, 0, toView, 6, 0, 0.5f);
    }

    public void centerVertically(int viewId, int toView) {
        if (toView != 0) goto L4;
        center(viewId, 0, 3, 0, 0, 4, 0, 0.5f);
        return;
    L4:
        center(viewId, toView, 4, 0, toView, 3, 0, 0.5f);
    }

    public void clear(int viewId) {
        this.mConstraints.remove(Integer.valueOf(viewId));
    }

    public void clear(int viewId, int anchor) {
        if (this.mConstraints.containsKey(Integer.valueOf(viewId)) == false) goto L20;
        Constraint r2 = this.mConstraints.get(Integer.valueOf(viewId));
        if (r2 != null) goto L8;
        return;
    L8:
        switch(anchor) {
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
        r2.layout.circleAngle = -1.0f;
        r2.layout.circleRadius = -1;
        r2.layout.circleConstraint = -1;
        return;
    L12:
        r2.layout.endToStart = -1;
        r2.layout.endToEnd = -1;
        r2.layout.endMargin = 0;
        r2.layout.goneEndMargin = Integer.MIN_VALUE;
        return;
    L13:
        r2.layout.startToEnd = -1;
        r2.layout.startToStart = -1;
        r2.layout.startMargin = 0;
        r2.layout.goneStartMargin = Integer.MIN_VALUE;
        return;
    L14:
        r2.layout.baselineToBaseline = -1;
        r2.layout.baselineToTop = -1;
        r2.layout.baselineToBottom = -1;
        r2.layout.baselineMargin = 0;
        r2.layout.goneBaselineMargin = Integer.MIN_VALUE;
        return;
    L15:
        r2.layout.bottomToTop = -1;
        r2.layout.bottomToBottom = -1;
        r2.layout.bottomMargin = 0;
        r2.layout.goneBottomMargin = Integer.MIN_VALUE;
        return;
    L16:
        r2.layout.topToBottom = -1;
        r2.layout.topToTop = -1;
        r2.layout.topMargin = 0;
        r2.layout.goneTopMargin = Integer.MIN_VALUE;
        return;
    L17:
        r2.layout.rightToRight = -1;
        r2.layout.rightToLeft = -1;
        r2.layout.rightMargin = -1;
        r2.layout.goneRightMargin = Integer.MIN_VALUE;
        return;
    L18:
        r2.layout.leftToRight = -1;
        r2.layout.leftToLeft = -1;
        r2.layout.leftMargin = -1;
        r2.layout.goneLeftMargin = Integer.MIN_VALUE;
        return;
    L10:
        throw new IllegalArgumentException("unknown constraint");
    }

    public void setMargin(int viewId, int anchor, int value) {
        Constraint r0 = get(viewId);
        switch(anchor) {
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
        r0.layout.endMargin = value;
        return;
    L7:
        r0.layout.startMargin = value;
        return;
    L8:
        r0.layout.baselineMargin = value;
        return;
    L9:
        r0.layout.bottomMargin = value;
        return;
    L10:
        r0.layout.topMargin = value;
        return;
    L11:
        r0.layout.rightMargin = value;
        return;
    L12:
        r0.layout.leftMargin = value;
        return;
    L5:
        throw new IllegalArgumentException("unknown constraint");
    }

    public void setGoneMargin(int viewId, int anchor, int value) {
        Constraint r0 = get(viewId);
        switch(anchor) {
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
        r0.layout.goneEndMargin = value;
        return;
    L7:
        r0.layout.goneStartMargin = value;
        return;
    L8:
        r0.layout.goneBaselineMargin = value;
        return;
    L9:
        r0.layout.goneBottomMargin = value;
        return;
    L10:
        r0.layout.goneTopMargin = value;
        return;
    L11:
        r0.layout.goneRightMargin = value;
        return;
    L12:
        r0.layout.goneLeftMargin = value;
        return;
    L5:
        throw new IllegalArgumentException("unknown constraint");
    }

    public void setHorizontalBias(int viewId, float bias) {
        get(viewId).layout.horizontalBias = bias;
    }

    public void setVerticalBias(int viewId, float bias) {
        get(viewId).layout.verticalBias = bias;
    }

    public void setDimensionRatio(int viewId, String ratio) {
        get(viewId).layout.dimensionRatio = ratio;
    }

    public void setVisibility(int viewId, int visibility) {
        get(viewId).propertySet.visibility = visibility;
    }

    public void setVisibilityMode(int viewId, int visibilityMode) {
        get(viewId).propertySet.mVisibilityMode = visibilityMode;
    }

    public int getVisibilityMode(int viewId) {
        return get(viewId).propertySet.mVisibilityMode;
    }

    public int getVisibility(int viewId) {
        return get(viewId).propertySet.visibility;
    }

    public int getHeight(int viewId) {
        return get(viewId).layout.mHeight;
    }

    public int getWidth(int viewId) {
        return get(viewId).layout.mWidth;
    }

    public void setAlpha(int viewId, float alpha) {
        get(viewId).propertySet.alpha = alpha;
    }

    public boolean getApplyElevation(int viewId) {
        return get(viewId).transform.applyElevation;
    }

    public void setApplyElevation(int viewId, boolean apply) {
        get(viewId).transform.applyElevation = apply;
    }

    public void setElevation(int viewId, float elevation) {
        get(viewId).transform.elevation = elevation;
        get(viewId).transform.applyElevation = true;
    }

    public void setRotation(int viewId, float rotation) {
        get(viewId).transform.rotation = rotation;
    }

    public void setRotationX(int viewId, float rotationX) {
        get(viewId).transform.rotationX = rotationX;
    }

    public void setRotationY(int viewId, float rotationY) {
        get(viewId).transform.rotationY = rotationY;
    }

    public void setScaleX(int viewId, float scaleX) {
        get(viewId).transform.scaleX = scaleX;
    }

    public void setScaleY(int viewId, float scaleY) {
        get(viewId).transform.scaleY = scaleY;
    }

    public void setTransformPivotX(int viewId, float transformPivotX) {
        get(viewId).transform.transformPivotX = transformPivotX;
    }

    public void setTransformPivotY(int viewId, float transformPivotY) {
        get(viewId).transform.transformPivotY = transformPivotY;
    }

    public void setTransformPivot(int viewId, float transformPivotX, float transformPivotY) {
        Constraint r0 = get(viewId);
        r0.transform.transformPivotY = transformPivotY;
        r0.transform.transformPivotX = transformPivotX;
    }

    public void setTranslationX(int viewId, float translationX) {
        get(viewId).transform.translationX = translationX;
    }

    public void setTranslationY(int viewId, float translationY) {
        get(viewId).transform.translationY = translationY;
    }

    public void setTranslation(int viewId, float translationX, float translationY) {
        Constraint r0 = get(viewId);
        r0.transform.translationX = translationX;
        r0.transform.translationY = translationY;
    }

    public void setTranslationZ(int viewId, float translationZ) {
        get(viewId).transform.translationZ = translationZ;
    }

    public void setEditorAbsoluteX(int viewId, int position) {
        get(viewId).layout.editorAbsoluteX = position;
    }

    public void setEditorAbsoluteY(int viewId, int position) {
        get(viewId).layout.editorAbsoluteY = position;
    }

    public void setLayoutWrapBehavior(int viewId, int behavior) {
        if (behavior >= 0) goto L4;
        return;
    L4:
        if (behavior > 3) goto L8;
        get(viewId).layout.mWrapBehavior = behavior;
        return;
    }

    public void constrainHeight(int viewId, int height) {
        get(viewId).layout.mHeight = height;
    }

    public void constrainWidth(int viewId, int width) {
        get(viewId).layout.mWidth = width;
    }

    public void constrainCircle(int viewId, int id, int radius, float angle) {
        Constraint r0 = get(viewId);
        r0.layout.circleConstraint = id;
        r0.layout.circleRadius = radius;
        r0.layout.circleAngle = angle;
    }

    public void constrainMaxHeight(int viewId, int height) {
        get(viewId).layout.heightMax = height;
    }

    public void constrainMaxWidth(int viewId, int width) {
        get(viewId).layout.widthMax = width;
    }

    public void constrainMinHeight(int viewId, int height) {
        get(viewId).layout.heightMin = height;
    }

    public void constrainMinWidth(int viewId, int width) {
        get(viewId).layout.widthMin = width;
    }

    public void constrainPercentWidth(int viewId, float percent) {
        get(viewId).layout.widthPercent = percent;
    }

    public void constrainPercentHeight(int viewId, float percent) {
        get(viewId).layout.heightPercent = percent;
    }

    public void constrainDefaultHeight(int viewId, int height) {
        get(viewId).layout.heightDefault = height;
    }

    public void constrainedWidth(int viewId, boolean constrained) {
        get(viewId).layout.constrainedWidth = constrained;
    }

    public void constrainedHeight(int viewId, boolean constrained) {
        get(viewId).layout.constrainedHeight = constrained;
    }

    public void constrainDefaultWidth(int viewId, int width) {
        get(viewId).layout.widthDefault = width;
    }

    public void setHorizontalWeight(int viewId, float weight) {
        get(viewId).layout.horizontalWeight = weight;
    }

    public void setVerticalWeight(int viewId, float weight) {
        get(viewId).layout.verticalWeight = weight;
    }

    public void setHorizontalChainStyle(int viewId, int chainStyle) {
        get(viewId).layout.horizontalChainStyle = chainStyle;
    }

    public void setVerticalChainStyle(int viewId, int chainStyle) {
        get(viewId).layout.verticalChainStyle = chainStyle;
    }

    public void addToHorizontalChain(int viewId, int leftId, int rightId) {
        if (leftId != 0) goto L5;
        int r4 = 1;
    L6:
        connect(viewId, 1, leftId, r4, 0);
        if (rightId != 0) goto L9;
        int r5 = 2;
    L10:
        connect(viewId, 2, rightId, r5, 0);
        if (leftId == 0) goto L13;
        connect(leftId, 2, viewId, 1, 0);
    L13:
        if (rightId == 0) goto L16;
        connect(rightId, 1, viewId, 2, 0);
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

    public void addToHorizontalChainRTL(int viewId, int leftId, int rightId) {
        if (leftId != 0) goto L5;
        int r4 = 6;
    L6:
        connect(viewId, 6, leftId, r4, 0);
        if (rightId != 0) goto L9;
        int r5 = 7;
    L10:
        connect(viewId, 7, rightId, r5, 0);
        if (leftId == 0) goto L13;
        connect(leftId, 7, viewId, 6, 0);
    L13:
        if (rightId == 0) goto L16;
        connect(rightId, 6, viewId, 7, 0);
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

    public void addToVerticalChain(int viewId, int topId, int bottomId) {
        if (topId != 0) goto L5;
        int r4 = 3;
    L6:
        connect(viewId, 3, topId, r4, 0);
        if (bottomId != 0) goto L9;
        int r5 = 4;
    L10:
        connect(viewId, 4, bottomId, r5, 0);
        if (topId == 0) goto L13;
        connect(topId, 4, viewId, 3, 0);
    L13:
        if (bottomId == 0) goto L16;
        connect(bottomId, 3, viewId, 4, 0);
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

    public void removeFromVerticalChain(int viewId) {
        if (this.mConstraints.containsKey(Integer.valueOf(viewId)) == false) goto L19;
        Constraint r0 = this.mConstraints.get(Integer.valueOf(viewId));
        if (r0 != null) goto L7;
        return;
    L7:
        int r1 = r0.layout.topToBottom;
        int r8 = r0.layout.bottomToTop;
        if (r1 != (-1)) goto L10;
        if (r8 == (-1)) goto L19;
    L10:
        if (r1 == (-1)) goto L14;
        if (r8 == (-1)) goto L14;
        connect(r1, 4, r8, 3, 0);
        connect(r8, 3, r1, 4, 0);
    L14:
        if (r0.layout.bottomToBottom == (-1)) goto L17;
        connect(r1, 4, r0.layout.bottomToBottom, 4, 0);
        goto L19
    L17:
        if (r0.layout.topToTop == (-1)) goto L19;
        connect(r8, 3, r0.layout.topToTop, 3, 0);
    L19:
        clear(viewId, 3);
        clear(viewId, 4);
    }

    public void removeFromHorizontalChain(int viewId) {
        if (this.mConstraints.containsKey(Integer.valueOf(viewId)) == false) goto L36;
        Constraint r0 = this.mConstraints.get(Integer.valueOf(viewId));
        if (r0 != null) goto L7;
        return;
    L7:
        int r1 = r0.layout.leftToRight;
        int r8 = r0.layout.rightToLeft;
        if (r1 != (-1)) goto L25;
        if (r8 != (-1)) goto L25;
        int r5 = r0.layout.startToEnd;
        int r3 = r0.layout.endToStart;
        if (r5 != (-1)) goto L14;
        if (r3 != (-1)) goto L14;
    L24:
        clear(viewId, 6);
        clear(viewId, 7);
        return;
    L14:
        if (r5 == (-1)) goto L17;
        if (r3 == (-1)) goto L17;
        connect(r5, 7, r3, 6, 0);
        connect(r3, 6, r1, 7, 0);
    L17:
        if (r3 == (-1)) goto L24;
        if (r0.layout.rightToRight == (-1)) goto L22;
        connect(r1, 7, r0.layout.rightToRight, 7, 0);
        goto L24
    L22:
        if (r0.layout.leftToLeft == (-1)) goto L24;
        connect(r3, 6, r0.layout.leftToLeft, 6, 0);
    L25:
        if (r1 == (-1)) goto L29;
        if (r8 == (-1)) goto L29;
        connect(r1, 2, r8, 1, 0);
        connect(r8, 1, r1, 2, 0);
    L34:
        clear(viewId, 1);
        clear(viewId, 2);
        return;
    L29:
        if (r0.layout.rightToRight == (-1)) goto L32;
        connect(r1, 2, r0.layout.rightToRight, 2, 0);
        goto L34
    L32:
        if (r0.layout.leftToLeft == (-1)) goto L34;
        connect(r8, 1, r0.layout.leftToLeft, 1, 0);
        goto L34
    }

    public void create(int guidelineID, int orientation) {
        Constraint r1 = get(guidelineID);
        r1.layout.mIsGuideline = true;
        r1.layout.orientation = orientation;
    }

    public void createBarrier(int id, int direction, int margin, int... referenced) {
        Constraint r1 = get(id);
        r1.layout.mHelperType = 1;
        r1.layout.mBarrierDirection = direction;
        r1.layout.mBarrierMargin = margin;
        r1.layout.mIsGuideline = false;
        r1.layout.mReferenceIds = referenced;
    }

    public void setGuidelineBegin(int guidelineID, int margin) {
        get(guidelineID).layout.guideBegin = margin;
        get(guidelineID).layout.guideEnd = -1;
        get(guidelineID).layout.guidePercent = -1.0f;
    }

    public void setGuidelineEnd(int guidelineID, int margin) {
        get(guidelineID).layout.guideEnd = margin;
        get(guidelineID).layout.guideBegin = -1;
        get(guidelineID).layout.guidePercent = -1.0f;
    }

    public void setGuidelinePercent(int guidelineID, float ratio) {
        get(guidelineID).layout.guidePercent = ratio;
        get(guidelineID).layout.guideEnd = -1;
        get(guidelineID).layout.guideBegin = -1;
    }

    public int[] getReferencedIds(int id) {
        Constraint r0 = get(id);
        if (r0.layout.mReferenceIds != null) goto L7;
        return new int[0];
    L7:
        return Arrays.copyOf(r0.layout.mReferenceIds, r0.layout.mReferenceIds.length);
    }

    public void setReferencedIds(int id, int... referenced) {
        get(id).layout.mReferenceIds = referenced;
    }

    public void setBarrierType(int id, int type) {
        get(id).layout.mHelperType = type;
    }

    public void removeAttribute(String attributeName) {
        this.mSavedAttributes.remove(attributeName);
    }

    public void setIntValue(int viewId, String attributeName, int value) {
        Constraint.access$900(get(viewId), attributeName, value);
    }

    public void setColorValue(int viewId, String attributeName, int value) {
        Constraint.access$1000(get(viewId), attributeName, value);
    }

    public void setFloatValue(int viewId, String attributeName, float value) {
        Constraint.access$1100(get(viewId), attributeName, value);
    }

    public void setStringValue(int viewId, String attributeName, String value) {
        Constraint.access$1200(get(viewId), attributeName, value);
    }

    private void addAttributes(ConstraintAttribute.AttributeType attributeType, String... attributeName) {
        int r0 = 0;
    L4:
        if (r0 >= attributeName.length) goto L17;
        if (this.mSavedAttributes.containsKey(attributeName[r0]) == false) goto L15;
        ConstraintAttribute r1 = this.mSavedAttributes.get(attributeName[r0]);
        if (r1 == null) goto L16;
        if (r1.getType() == attributeType) goto L16;
        throw new IllegalArgumentException("ConstraintAttribute is already a " + r1.getType().name());
    L16:
        r0 = r0 + 1;
        goto L4
    L15:
        this.mSavedAttributes.put(attributeName[r0], new ConstraintAttribute(attributeName[r0], attributeType));
        goto L16
    }

    public void parseIntAttributes(Constraint set, String attributes) {
        String[] r4 = attributes.split(",");
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
        Constraint.access$1100(set, r1[0], Integer.decode(r1[1]).intValue());
        goto L9
    }

    public void parseColorAttributes(Constraint set, String attributes) {
        String[] r4 = attributes.split(",");
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
        Constraint.access$1000(set, r1[0], Color.parseColor(r1[1]));
        goto L9
    }

    public void parseFloatAttributes(Constraint set, String attributes) {
        String[] r4 = attributes.split(",");
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
        Constraint.access$1100(set, r1[0], Float.parseFloat(r1[1]));
        goto L9
    }

    public void parseStringAttributes(Constraint set, String attributes) {
        String[] r4 = splitString(attributes);
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L6;
        String[] r1 = r4[r0].split("=");
        Log.w(TAG, " Unable to parse " + r4[r0]);
        Constraint.access$1200(set, r1[0], r1[1]);
        r0 = r0 + 1;
        goto L4
    }

    private static String[] splitString(String str) {
        char[] r6 = str.toCharArray();
        ArrayList r0 = new ArrayList();
        int r1 = 0;
        int r2 = 0;
        boolean r3 = false;
    L4:
        if (r1 >= r6.length) goto L13;
        char r4 = r6[r1];
        if (r4 != ',') goto L10;
        if (r3 == true) goto L10;
        r0.add(new String(r6, r2, r1 - r2));
        r2 = r1 + 1;
    L12:
        r1 = r1 + 1;
    L10:
        if (r4 != '\"') goto L12;
        r3 = !r3;
        goto L12
    L13:
        r0.add(new String(r6, r2, r6.length - r2));
        return (String[]) r0.toArray(new String[r0.size()]);
    }

    public void addIntAttributes(String... attributeName) {
        addAttributes(ConstraintAttribute.AttributeType.INT_TYPE, attributeName);
    }

    public void addColorAttributes(String... attributeName) {
        addAttributes(ConstraintAttribute.AttributeType.COLOR_TYPE, attributeName);
    }

    public void addFloatAttributes(String... attributeName) {
        addAttributes(ConstraintAttribute.AttributeType.FLOAT_TYPE, attributeName);
    }

    public void addStringAttributes(String... attributeName) {
        addAttributes(ConstraintAttribute.AttributeType.STRING_TYPE, attributeName);
    }

    private Constraint get(int id) {
        if (this.mConstraints.containsKey(Integer.valueOf(id)) == true) goto L6;
        this.mConstraints.put(Integer.valueOf(id), new Constraint());
    L6:
        return this.mConstraints.get(Integer.valueOf(id));
    }

    public void load(Context context, int resourceId) {
        XmlResourceParser r6 = context.getResources().getXml(resourceId);
        int r0 = r6.getEventType();     // Catch: IOException -> L17 XmlPullParserException -> L19
    L5:
        if (r0 == 1) goto L30;
        if (r0 != 0) goto L8;
        r6.getName();     // Catch: IOException -> L17 XmlPullParserException -> L19
    L15:
        r0 = r6.next();     // Catch: IOException -> L17 XmlPullParserException -> L19
    L8:
        if (r0 != 2) goto L15;
        String r1 = r6.getName();     // Catch: IOException -> L17 XmlPullParserException -> L19
        Constraint r2 = fillFromAttributeList(context, Xml.asAttributeSet(r6), false);     // Catch: IOException -> L17 XmlPullParserException -> L19
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

    public void load(Context context, XmlPullParser parser) {
        int r0 = parser.getEventType();     // Catch: IOException -> L96 XmlPullParserException -> L98
        Constraint r2 = null;
    L4:
        if (r0 == 1) goto L121;
        if (r0 == 0) goto L93;
        byte r4 = -1;
        if (r0 == 2) goto L32;
        if (r0 != 3) goto L94;
        String r1 = parser.getName().toLowerCase(Locale.ROOT);     // Catch: IOException -> L96 XmlPullParserException -> L98
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
        r0 = parser.next();     // Catch: IOException -> L96 XmlPullParserException -> L98
        goto L4
    L32:
        String r3 = parser.getName();     // Catch: IOException -> L96 XmlPullParserException -> L98
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
        ConstraintAttribute.parse(context, parser, r2.mCustomConstraints);     // Catch: IOException -> L96 XmlPullParserException -> L98
        goto L94
    L71:
        throw new RuntimeException(ERROR_MESSAGE + parser.getLineNumber());     // Catch: IOException -> L96 XmlPullParserException -> L98
    L72:
        if (r2 == null) goto L75;
        r2.motion.fillFromAttributeList(context, Xml.asAttributeSet(parser));     // Catch: IOException -> L96 XmlPullParserException -> L98
        goto L94
    L75:
        throw new RuntimeException(ERROR_MESSAGE + parser.getLineNumber());     // Catch: IOException -> L96 XmlPullParserException -> L98
    L76:
        if (r2 == null) goto L79;
        r2.layout.fillFromAttributeList(context, Xml.asAttributeSet(parser));     // Catch: IOException -> L96 XmlPullParserException -> L98
        goto L94
    L79:
        throw new RuntimeException(ERROR_MESSAGE + parser.getLineNumber());     // Catch: IOException -> L96 XmlPullParserException -> L98
    L80:
        if (r2 == null) goto L83;
        r2.transform.fillFromAttributeList(context, Xml.asAttributeSet(parser));     // Catch: IOException -> L96 XmlPullParserException -> L98
        goto L94
    L83:
        throw new RuntimeException(ERROR_MESSAGE + parser.getLineNumber());     // Catch: IOException -> L96 XmlPullParserException -> L98
    L84:
        if (r2 == null) goto L87;
        r2.propertySet.fillFromAttributeList(context, Xml.asAttributeSet(parser));     // Catch: IOException -> L96 XmlPullParserException -> L98
        goto L94
    L87:
        throw new RuntimeException(ERROR_MESSAGE + parser.getLineNumber());     // Catch: IOException -> L96 XmlPullParserException -> L98
    L88:
        Constraint r5 = fillFromAttributeList(context, Xml.asAttributeSet(parser), false);     // Catch: IOException -> L96 XmlPullParserException -> L98
        r5.layout.mHelperType = 1;     // Catch: IOException -> L96 XmlPullParserException -> L98
    L92:
        r2 = r5;
        goto L94
    L89:
        r5 = fillFromAttributeList(context, Xml.asAttributeSet(parser), false);     // Catch: IOException -> L96 XmlPullParserException -> L98
        r5.layout.mIsGuideline = true;     // Catch: IOException -> L96 XmlPullParserException -> L98
        r5.layout.mApply = true;     // Catch: IOException -> L96 XmlPullParserException -> L98
        goto L92
    L90:
        r5 = fillFromAttributeList(context, Xml.asAttributeSet(parser), true);     // Catch: IOException -> L96 XmlPullParserException -> L98
        goto L92
    L91:
        r5 = fillFromAttributeList(context, Xml.asAttributeSet(parser), false);     // Catch: IOException -> L96 XmlPullParserException -> L98
        goto L92
    L36:
        if (r3.equals("Constraint") == false) goto L66;
        r4 = 0;
        goto L66
    L39:
        if (r3.equals("CustomAttribute") == false) goto L66;
        r4 = 8;
        goto L66
    L42:
        if (r3.equals("Barrier") == false) goto L66;
        r4 = 3;
        goto L66
    L45:
        if (r3.equals("CustomMethod") == false) goto L66;
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
        if (r3.equals("ConstraintOverride") == false) goto L66;
        r4 = 1;
        goto L66
    L60:
        if (r3.equals("Motion") == false) goto L66;
        r4 = 7;
        goto L66
    L63:
        if (r3.equals("Layout") == false) goto L66;
        r4 = 6;
        goto L66
    L93:
        parser.getName();     // Catch: IOException -> L96 XmlPullParserException -> L98
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

    private static int lookupID(TypedArray a, int index, int def) {
        int r3 = a.getResourceId(index, def);
        if (r3 == (-1)) goto L5;
        return r3;
    L5:
        return a.getInt(index, -1);
    }

    private Constraint fillFromAttributeList(Context context, AttributeSet attrs, boolean override) {
        Constraint r0 = new Constraint();
        if (override == false) goto L5;
        int[] r1 = R.styleable.ConstraintOverride;
    L6:
        TypedArray r4 = context.obtainStyledAttributes(attrs, r1);
        populateConstraint(context, r0, r4, override);
        r4.recycle();
        return r0;
    L5:
        r1 = R.styleable.Constraint;
        goto L6
    }

    public static Constraint buildDelta(Context context, XmlPullParser parser) {
        AttributeSet r3 = Xml.asAttributeSet(parser);
        Constraint r0 = new Constraint();
        TypedArray r4 = context.obtainStyledAttributes(r3, R.styleable.ConstraintOverride);
        populateOverride(context, r0, r4);
        r4.recycle();
        return r0;
    }

    private static void populateOverride(Context ctx, Constraint c, TypedArray a) {
        int r12 = a.getIndexCount();
        Constraint.Delta r0 = new Constraint.Delta();
        c.mDelta = r0;
        c.motion.mApply = false;
        c.layout.mApply = false;
        c.propertySet.mApply = false;
        c.transform.mApply = false;
        int r1 = 0;
    L3:
        if (r1 >= r12) goto L110;
        int r3 = a.getIndex(r1);
        switch(overrideMapToConstant.get(r3)) {
            case 2: goto L108;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L107;
            case 6: goto L106;
            case 7: goto L105;
            case 8: goto L104;
            case 9: goto L6;
            case 10: goto L6;
            case 11: goto L103;
            case 12: goto L102;
            case 13: goto L101;
            case 14: goto L100;
            case 15: goto L99;
            case 16: goto L98;
            case 17: goto L97;
            case 18: goto L96;
            case 19: goto L95;
            case 20: goto L94;
            case 21: goto L93;
            case 22: goto L92;
            case 23: goto L91;
            case 24: goto L90;
            case 25: goto L6;
            case 26: goto L6;
            case 27: goto L89;
            case 28: goto L88;
            case 29: goto L6;
            case 30: goto L6;
            case 31: goto L87;
            case 32: goto L6;
            case 33: goto L6;
            case 34: goto L86;
            case 35: goto L6;
            case 36: goto L6;
            case 37: goto L85;
            case 38: goto L84;
            case 39: goto L83;
            case 40: goto L82;
            case 41: goto L81;
            case 42: goto L80;
            case 43: goto L79;
            case 44: goto L78;
            case 45: goto L77;
            case 46: goto L76;
            case 47: goto L75;
            case 48: goto L74;
            case 49: goto L73;
            case 50: goto L72;
            case 51: goto L71;
            case 52: goto L70;
            case 53: goto L69;
            case 54: goto L68;
            case 55: goto L67;
            case 56: goto L66;
            case 57: goto L65;
            case 58: goto L64;
            case 59: goto L63;
            case 60: goto L62;
            case 61: goto L6;
            case 62: goto L61;
            case 63: goto L60;
            case 64: goto L59;
            case 65: goto L56;
            case 66: goto L54;
            case 67: goto L53;
            case 68: goto L52;
            case 69: goto L51;
            case 70: goto L50;
            case 71: goto L49;
            case 72: goto L48;
            case 73: goto L47;
            case 74: goto L46;
            case 75: goto L45;
            case 76: goto L44;
            case 77: goto L43;
            case 78: goto L42;
            case 79: goto L41;
            case 80: goto L40;
            case 81: goto L39;
            case 82: goto L38;
            case 83: goto L37;
            case 84: goto L36;
            case 85: goto L35;
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
    L109:
        r1 = r1 + 1;
        goto L3
    L7:
        r0.add(99, a.getBoolean(r3, c.layout.guidelineUseRtl));
        goto L109
    L17:
        r0.add(97, a.getInt(r3, c.layout.mWrapBehavior));
        goto L109
    L18:
        parseDimensionConstraints(r0, a, r3, 1);
        goto L109
    L19:
        parseDimensionConstraints(r0, a, r3, 0);
        goto L109
    L20:
        r0.add(94, a.getDimensionPixelSize(r3, c.layout.goneBaselineMargin));
        goto L109
    L21:
        r0.add(93, a.getDimensionPixelSize(r3, c.layout.baselineMargin));
        goto L109
    L22:
        Log.w(TAG, "unused attribute 0x" + Integer.toHexString(r3) + "   " + mapToConstant.get(r3));
        goto L109
    L23:
        TypedValue r4 = a.peekValue(r3);
        if (r4.type != 1) goto L29;
        c.motion.mQuantizeInterpolatorID = a.getResourceId(r3, -1);
        r0.add(89, c.motion.mQuantizeInterpolatorID);
        if (c.motion.mQuantizeInterpolatorID == (-1)) goto L109;
        c.motion.mQuantizeInterpolatorType = -2;
        r0.add(88, c.motion.mQuantizeInterpolatorType);
        goto L109
    L29:
        if (r4.type != 3) goto L34;
        c.motion.mQuantizeInterpolatorString = a.getString(r3);
        r0.add(90, c.motion.mQuantizeInterpolatorString);
        if (c.motion.mQuantizeInterpolatorString.indexOf(LibrarianImpl.Constants.SEPARATOR) <= 0) goto L33;
        c.motion.mQuantizeInterpolatorID = a.getResourceId(r3, -1);
        r0.add(89, c.motion.mQuantizeInterpolatorID);
        c.motion.mQuantizeInterpolatorType = -2;
        r0.add(88, c.motion.mQuantizeInterpolatorType);
        goto L109
    L33:
        c.motion.mQuantizeInterpolatorType = -1;
        r0.add(88, c.motion.mQuantizeInterpolatorType);
        goto L109
    L34:
        c.motion.mQuantizeInterpolatorType = a.getInteger(r3, c.motion.mQuantizeInterpolatorID);
        r0.add(88, c.motion.mQuantizeInterpolatorType);
        goto L109
    L35:
        r0.add(85, a.getFloat(r3, c.motion.mQuantizeMotionPhase));
        goto L109
    L36:
        r0.add(84, a.getInteger(r3, c.motion.mQuantizeMotionSteps));
        goto L109
    L37:
        r0.add(83, lookupID(a, r3, c.transform.transformPivotTarget));
        goto L109
    L38:
        r0.add(82, a.getInteger(r3, c.motion.mAnimateCircleAngleTo));
        goto L109
    L39:
        r0.add(81, a.getBoolean(r3, c.layout.constrainedHeight));
        goto L109
    L40:
        r0.add(80, a.getBoolean(r3, c.layout.constrainedWidth));
        goto L109
    L41:
        r0.add(79, a.getFloat(r3, c.motion.mMotionStagger));
        goto L109
    L42:
        r0.add(78, a.getInt(r3, c.propertySet.mVisibilityMode));
        goto L109
    L43:
        r0.add(77, a.getString(r3));
        goto L109
    L44:
        r0.add(76, a.getInt(r3, c.motion.mPathMotionArc));
        goto L109
    L45:
        r0.add(75, a.getBoolean(r3, c.layout.mBarrierAllowsGoneWidgets));
        goto L109
    L46:
        r0.add(74, a.getString(r3));
        goto L109
    L47:
        r0.add(73, a.getDimensionPixelSize(r3, c.layout.mBarrierMargin));
        goto L109
    L48:
        r0.add(72, a.getInt(r3, c.layout.mBarrierDirection));
        goto L109
    L49:
        Log.e(TAG, "CURRENTLY UNSUPPORTED");
        goto L109
    L50:
        r0.add(70, a.getFloat(r3, 1.0f));
        goto L109
    L51:
        r0.add(69, a.getFloat(r3, 1.0f));
        goto L109
    L52:
        r0.add(68, a.getFloat(r3, c.propertySet.mProgress));
        goto L109
    L53:
        r0.add(67, a.getFloat(r3, c.motion.mPathRotate));
        goto L109
    L54:
        r0.add(66, a.getInt(r3, 0));
        goto L109
    L59:
        r0.add(64, lookupID(a, r3, c.motion.mAnimateRelativeTo));
        goto L109
    L60:
        r0.add(63, a.getFloat(r3, c.layout.circleAngle));
        goto L109
    L61:
        r0.add(62, a.getDimensionPixelSize(r3, c.layout.circleRadius));
        goto L109
    L62:
        r0.add(60, a.getFloat(r3, c.transform.rotation));
        goto L109
    L63:
        r0.add(59, a.getDimensionPixelSize(r3, c.layout.heightMin));
        goto L109
    L64:
        r0.add(58, a.getDimensionPixelSize(r3, c.layout.widthMin));
        goto L109
    L65:
        r0.add(57, a.getDimensionPixelSize(r3, c.layout.heightMax));
        goto L109
    L66:
        r0.add(56, a.getDimensionPixelSize(r3, c.layout.widthMax));
        goto L109
    L67:
        r0.add(55, a.getInt(r3, c.layout.heightDefault));
        goto L109
    L68:
        r0.add(54, a.getInt(r3, c.layout.widthDefault));
        goto L109
    L69:
        r0.add(53, a.getDimension(r3, c.transform.translationZ));
        goto L109
    L70:
        r0.add(52, a.getDimension(r3, c.transform.translationY));
        goto L109
    L71:
        r0.add(51, a.getDimension(r3, c.transform.translationX));
        goto L109
    L72:
        r0.add(50, a.getDimension(r3, c.transform.transformPivotY));
        goto L109
    L73:
        r0.add(49, a.getDimension(r3, c.transform.transformPivotX));
        goto L109
    L74:
        r0.add(48, a.getFloat(r3, c.transform.scaleY));
        goto L109
    L75:
        r0.add(47, a.getFloat(r3, c.transform.scaleX));
        goto L109
    L76:
        r0.add(46, a.getFloat(r3, c.transform.rotationY));
        goto L109
    L77:
        r0.add(45, a.getFloat(r3, c.transform.rotationX));
        goto L109
    L78:
        r0.add(44, true);
        r0.add(44, a.getDimension(r3, c.transform.elevation));
        goto L109
    L79:
        r0.add(43, a.getFloat(r3, c.propertySet.alpha));
        goto L109
    L80:
        r0.add(42, a.getInt(r3, c.layout.verticalChainStyle));
        goto L109
    L81:
        r0.add(41, a.getInt(r3, c.layout.horizontalChainStyle));
        goto L109
    L82:
        r0.add(40, a.getFloat(r3, c.layout.verticalWeight));
        goto L109
    L83:
        r0.add(39, a.getFloat(r3, c.layout.horizontalWeight));
        goto L109
    L84:
        c.mViewId = a.getResourceId(r3, c.mViewId);
        r0.add(38, c.mViewId);
        goto L109
    L85:
        r0.add(37, a.getFloat(r3, c.layout.verticalBias));
        goto L109
    L86:
        r0.add(34, a.getDimensionPixelSize(r3, c.layout.topMargin));
        goto L109
    L87:
        r0.add(31, a.getDimensionPixelSize(r3, c.layout.startMargin));
        goto L109
    L88:
        r0.add(28, a.getDimensionPixelSize(r3, c.layout.rightMargin));
        goto L109
    L89:
        r0.add(27, a.getInt(r3, c.layout.orientation));
        goto L109
    L90:
        r0.add(24, a.getDimensionPixelSize(r3, c.layout.leftMargin));
        goto L109
    L91:
        r0.add(23, a.getLayoutDimension(r3, c.layout.mWidth));
        goto L109
    L92:
        r0.add(22, VISIBILITY_FLAGS[a.getInt(r3, c.propertySet.visibility)]);
        goto L109
    L93:
        r0.add(21, a.getLayoutDimension(r3, c.layout.mHeight));
        goto L109
    L94:
        r0.add(20, a.getFloat(r3, c.layout.horizontalBias));
        goto L109
    L95:
        r0.add(19, a.getFloat(r3, c.layout.guidePercent));
        goto L109
    L96:
        r0.add(18, a.getDimensionPixelOffset(r3, c.layout.guideEnd));
        goto L109
    L97:
        r0.add(17, a.getDimensionPixelOffset(r3, c.layout.guideBegin));
        goto L109
    L98:
        r0.add(16, a.getDimensionPixelSize(r3, c.layout.goneTopMargin));
        goto L109
    L99:
        r0.add(15, a.getDimensionPixelSize(r3, c.layout.goneStartMargin));
        goto L109
    L100:
        r0.add(14, a.getDimensionPixelSize(r3, c.layout.goneRightMargin));
        goto L109
    L101:
        r0.add(13, a.getDimensionPixelSize(r3, c.layout.goneLeftMargin));
        goto L109
    L102:
        r0.add(12, a.getDimensionPixelSize(r3, c.layout.goneEndMargin));
        goto L109
    L103:
        r0.add(11, a.getDimensionPixelSize(r3, c.layout.goneBottomMargin));
        goto L109
    L104:
        r0.add(8, a.getDimensionPixelSize(r3, c.layout.endMargin));
        goto L109
    L105:
        r0.add(7, a.getDimensionPixelOffset(r3, c.layout.editorAbsoluteY));
        goto L109
    L106:
        r0.add(6, a.getDimensionPixelOffset(r3, c.layout.editorAbsoluteX));
        goto L109
    L107:
        r0.add(5, a.getString(r3));
        goto L109
    L108:
        r0.add(2, a.getDimensionPixelSize(r3, c.layout.bottomMargin));
        goto L109
    L9:
        if (MotionLayout.IS_IN_EDIT_MODE == false) goto L14;
        c.mViewId = a.getResourceId(r3, c.mViewId);
        if (c.mViewId != (-1)) goto L109;
        c.mTargetString = a.getString(r3);
        goto L109
    L14:
        if (a.peekValue(r3).type != 3) goto L16;
        c.mTargetString = a.getString(r3);
        goto L109
    L16:
        c.mViewId = a.getResourceId(r3, c.mViewId);
        goto L109
    L56:
        if (a.peekValue(r3).type != 3) goto L58;
        r0.add(65, a.getString(r3));
        goto L109
    L58:
        r0.add(65, Easing.NAMED_EASING[a.getInteger(r3, 0)]);
        goto L109
    }

    private static void setDeltaValue(Constraint c, int type, float value) {
        if (type != 19) goto L5;
        c.layout.guidePercent = value;
        return;
    L5:
        if (type != 20) goto L7;
        c.layout.horizontalBias = value;
        return;
    L7:
        if (type != 37) goto L9;
        c.layout.verticalBias = value;
        return;
    L9:
        if (type != 60) goto L11;
        c.transform.rotation = value;
        return;
    L11:
        if (type != 63) goto L13;
        c.layout.circleAngle = value;
        return;
    L13:
        if (type != 79) goto L15;
        c.motion.mMotionStagger = value;
        return;
    L15:
        if (type != 85) goto L17;
        c.motion.mQuantizeMotionPhase = value;
        return;
    L17:
        if (type != 87) goto L19;
        return;
    L19:
        if (type != 39) goto L21;
        c.layout.horizontalWeight = value;
        return;
    L21:
        if (type == 40) goto L40;
        switch(type) {
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
        switch(type) {
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
        c.layout.heightPercent = value;
        return;
    L26:
        c.layout.widthPercent = value;
        return;
    L27:
        c.propertySet.mProgress = value;
        return;
    L28:
        c.motion.mPathRotate = value;
        return;
    L29:
        c.transform.translationZ = value;
        return;
    L30:
        c.transform.translationY = value;
        return;
    L31:
        c.transform.translationX = value;
        return;
    L32:
        c.transform.transformPivotY = value;
        return;
    L33:
        c.transform.transformPivotX = value;
        return;
    L34:
        c.transform.scaleY = value;
        return;
    L35:
        c.transform.scaleX = value;
        return;
    L36:
        c.transform.rotationY = value;
        return;
    L37:
        c.transform.rotationX = value;
        return;
    L38:
        c.transform.elevation = value;
        c.transform.applyElevation = true;
        return;
    L39:
        c.propertySet.alpha = value;
        return;
    L40:
        c.layout.verticalWeight = value;
    }

    private static void setDeltaValue(Constraint c, int type, int value) {
        if (type != 6) goto L5;
        c.layout.editorAbsoluteX = value;
        return;
    L5:
        if (type != 7) goto L7;
        c.layout.editorAbsoluteY = value;
        return;
    L7:
        if (type != 8) goto L9;
        c.layout.endMargin = value;
        return;
    L9:
        if (type != 27) goto L11;
        c.layout.orientation = value;
        return;
    L11:
        if (type != 28) goto L13;
        c.layout.rightMargin = value;
        return;
    L13:
        if (type != 41) goto L15;
        c.layout.horizontalChainStyle = value;
        return;
    L15:
        if (type != 42) goto L17;
        c.layout.verticalChainStyle = value;
        return;
    L17:
        if (type != 61) goto L19;
        c.layout.circleConstraint = value;
        return;
    L19:
        if (type != 62) goto L21;
        c.layout.circleRadius = value;
        return;
    L21:
        if (type != 72) goto L23;
        c.layout.mBarrierDirection = value;
        return;
    L23:
        if (type == 73) goto L64;
        switch(type) {
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
        switch(type) {
            case 21: goto L44;
            case 22: goto L43;
            case 23: goto L42;
            case 24: goto L41;
            default: goto L26;
        };
    L26:
        switch(type) {
            case 54: goto L40;
            case 55: goto L39;
            case 56: goto L38;
            case 57: goto L37;
            case 58: goto L36;
            case 59: goto L35;
            default: goto L27;
        };
    L27:
        switch(type) {
            case 82: goto L34;
            case 83: goto L33;
            case 84: goto L32;
            default: goto L28;
        };
    L28:
        switch(type) {
            case 87: goto L76;
            case 88: goto L31;
            case 89: goto L30;
            default: goto L29;
        };
    L29:
        Log.w(TAG, "Unknown attribute 0x");
        return;
    L30:
        c.motion.mQuantizeInterpolatorID = value;
        return;
    L31:
        c.motion.mQuantizeInterpolatorType = value;
        return;
    L76:
        return;
    L32:
        c.motion.mQuantizeMotionSteps = value;
        return;
    L33:
        c.transform.transformPivotTarget = value;
        return;
    L34:
        c.motion.mAnimateCircleAngleTo = value;
        return;
    L35:
        c.layout.heightMin = value;
        return;
    L36:
        c.layout.widthMin = value;
        return;
    L37:
        c.layout.heightMax = value;
        return;
    L38:
        c.layout.widthMax = value;
        return;
    L39:
        c.layout.heightDefault = value;
        return;
    L40:
        c.layout.widthDefault = value;
        return;
    L41:
        c.layout.leftMargin = value;
        return;
    L42:
        c.layout.mWidth = value;
        return;
    L43:
        c.propertySet.visibility = value;
        return;
    L44:
        c.layout.mHeight = value;
        return;
    L45:
        c.layout.mWrapBehavior = value;
        return;
    L46:
        c.layout.goneBaselineMargin = value;
        return;
    L47:
        c.layout.baselineMargin = value;
        return;
    L48:
        c.propertySet.mVisibilityMode = value;
        return;
    L49:
        c.motion.mPathMotionArc = value;
        return;
    L50:
        c.motion.mDrawPath = value;
        return;
    L51:
        c.motion.mAnimateRelativeTo = value;
        return;
    L52:
        c.mViewId = value;
        return;
    L53:
        c.layout.topMargin = value;
        return;
    L54:
        c.layout.startMargin = value;
        return;
    L55:
        c.layout.guideEnd = value;
        return;
    L56:
        c.layout.guideBegin = value;
        return;
    L57:
        c.layout.goneTopMargin = value;
        return;
    L58:
        c.layout.goneStartMargin = value;
        return;
    L59:
        c.layout.goneRightMargin = value;
        return;
    L60:
        c.layout.goneLeftMargin = value;
        return;
    L61:
        c.layout.goneEndMargin = value;
        return;
    L62:
        c.layout.goneBottomMargin = value;
        return;
    L63:
        c.layout.bottomMargin = value;
        return;
    L64:
        c.layout.mBarrierMargin = value;
    }

    private static void setDeltaValue(Constraint c, int type, String value) {
        if (type != 5) goto L5;
        c.layout.dimensionRatio = value;
        return;
    L5:
        if (type != 65) goto L7;
        c.motion.mTransitionEasing = value;
        return;
    L7:
        if (type != 74) goto L9;
        c.layout.mReferenceIdString = value;
        c.layout.mReferenceIds = null;
        return;
    L9:
        if (type != 77) goto L11;
        c.layout.mConstraintTag = value;
        return;
    L11:
        if (type != 87) goto L13;
        return;
    L13:
        if (type == 90) goto L15;
        Log.w(TAG, "Unknown attribute 0x");
        return;
    L15:
        c.motion.mQuantizeInterpolatorString = value;
    }

    private static void setDeltaValue(Constraint c, int type, boolean value) {
        if (type != 44) goto L5;
        c.transform.applyElevation = value;
        return;
    L5:
        if (type != 75) goto L7;
        c.layout.mBarrierAllowsGoneWidgets = value;
        return;
    L7:
        if (type != 87) goto L9;
        return;
    L9:
        if (type != 80) goto L11;
        c.layout.constrainedWidth = value;
        return;
    L11:
        if (type == 81) goto L13;
        Log.w(TAG, "Unknown attribute 0x");
        return;
    L13:
        c.layout.constrainedHeight = value;
    }

    private void populateConstraint(Context ctx, Constraint c, TypedArray a, boolean override) {
        if (override == false) goto L5;
        populateOverride(ctx, c, a);
        return;
    L5:
        int r7 = a.getIndexCount();
        int r11 = 0;
    L6:
        if (r11 >= r7) goto L127;
        int r0 = a.getIndex(r11);
        if (r0 == R.styleable.Constraint_android_id) goto L15;
        if (R.styleable.Constraint_android_layout_marginStart == r0) goto L15;
        if (R.styleable.Constraint_android_layout_marginEnd == r0) goto L15;
        c.motion.mApply = true;
        c.layout.mApply = true;
        c.propertySet.mApply = true;
        c.transform.mApply = true;
    L15:
        switch(mapToConstant.get(r0)) {
            case 1: goto L124;
            case 2: goto L123;
            case 3: goto L122;
            case 4: goto L121;
            case 5: goto L120;
            case 6: goto L119;
            case 7: goto L118;
            case 8: goto L117;
            case 9: goto L116;
            case 10: goto L115;
            case 11: goto L114;
            case 12: goto L113;
            case 13: goto L112;
            case 14: goto L111;
            case 15: goto L110;
            case 16: goto L109;
            case 17: goto L108;
            case 18: goto L107;
            case 19: goto L106;
            case 20: goto L105;
            case 21: goto L104;
            case 22: goto L103;
            case 23: goto L102;
            case 24: goto L101;
            case 25: goto L100;
            case 26: goto L99;
            case 27: goto L98;
            case 28: goto L97;
            case 29: goto L96;
            case 30: goto L95;
            case 31: goto L94;
            case 32: goto L93;
            case 33: goto L92;
            case 34: goto L91;
            case 35: goto L90;
            case 36: goto L89;
            case 37: goto L88;
            case 38: goto L87;
            case 39: goto L86;
            case 40: goto L85;
            case 41: goto L84;
            case 42: goto L83;
            case 43: goto L82;
            case 44: goto L81;
            case 45: goto L80;
            case 46: goto L79;
            case 47: goto L78;
            case 48: goto L77;
            case 49: goto L76;
            case 50: goto L75;
            case 51: goto L74;
            case 52: goto L73;
            case 53: goto L72;
            case 54: goto L71;
            case 55: goto L70;
            case 56: goto L69;
            case 57: goto L68;
            case 58: goto L67;
            case 59: goto L66;
            case 60: goto L65;
            case 61: goto L64;
            case 62: goto L63;
            case 63: goto L62;
            case 64: goto L61;
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
            case 75: goto L47;
            case 76: goto L46;
            case 77: goto L45;
            case 78: goto L44;
            case 79: goto L43;
            case 80: goto L42;
            case 81: goto L41;
            case 82: goto L40;
            case 83: goto L39;
            case 84: goto L38;
            case 85: goto L37;
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
    L125:
        r11 = r11 + 1;
        goto L6
    L17:
        c.layout.mWrapBehavior = a.getInt(r0, c.layout.mWrapBehavior);
        goto L125
    L18:
        parseDimensionConstraints(c.layout, a, r0, 1);
        goto L125
    L19:
        parseDimensionConstraints(c.layout, a, r0, 0);
        goto L125
    L20:
        c.layout.goneBaselineMargin = a.getDimensionPixelSize(r0, c.layout.goneBaselineMargin);
        goto L125
    L21:
        c.layout.baselineMargin = a.getDimensionPixelSize(r0, c.layout.baselineMargin);
        goto L125
    L22:
        c.layout.baselineToBottom = lookupID(a, r0, c.layout.baselineToBottom);
        goto L125
    L23:
        c.layout.baselineToTop = lookupID(a, r0, c.layout.baselineToTop);
        goto L125
    L24:
        Log.w(TAG, "unused attribute 0x" + Integer.toHexString(r0) + "   " + mapToConstant.get(r0));
        goto L125
    L25:
        TypedValue r1 = a.peekValue(r0);
        if (r1.type != 1) goto L31;
        c.motion.mQuantizeInterpolatorID = a.getResourceId(r0, -1);
        if (c.motion.mQuantizeInterpolatorID == (-1)) goto L125;
        c.motion.mQuantizeInterpolatorType = -2;
        goto L125
    L31:
        if (r1.type != 3) goto L36;
        c.motion.mQuantizeInterpolatorString = a.getString(r0);
        if (c.motion.mQuantizeInterpolatorString.indexOf(LibrarianImpl.Constants.SEPARATOR) <= 0) goto L35;
        c.motion.mQuantizeInterpolatorID = a.getResourceId(r0, -1);
        c.motion.mQuantizeInterpolatorType = -2;
        goto L125
    L35:
        c.motion.mQuantizeInterpolatorType = -1;
        goto L125
    L36:
        c.motion.mQuantizeInterpolatorType = a.getInteger(r0, c.motion.mQuantizeInterpolatorID);
        goto L125
    L37:
        c.motion.mQuantizeMotionPhase = a.getFloat(r0, c.motion.mQuantizeMotionPhase);
        goto L125
    L38:
        c.motion.mQuantizeMotionSteps = a.getInteger(r0, c.motion.mQuantizeMotionSteps);
        goto L125
    L39:
        c.transform.transformPivotTarget = lookupID(a, r0, c.transform.transformPivotTarget);
        goto L125
    L40:
        c.motion.mAnimateCircleAngleTo = a.getInteger(r0, c.motion.mAnimateCircleAngleTo);
        goto L125
    L41:
        c.layout.constrainedHeight = a.getBoolean(r0, c.layout.constrainedHeight);
        goto L125
    L42:
        c.layout.constrainedWidth = a.getBoolean(r0, c.layout.constrainedWidth);
        goto L125
    L43:
        c.motion.mMotionStagger = a.getFloat(r0, c.motion.mMotionStagger);
        goto L125
    L44:
        c.propertySet.mVisibilityMode = a.getInt(r0, c.propertySet.mVisibilityMode);
        goto L125
    L45:
        c.layout.mConstraintTag = a.getString(r0);
        goto L125
    L46:
        c.motion.mPathMotionArc = a.getInt(r0, c.motion.mPathMotionArc);
        goto L125
    L47:
        c.layout.mBarrierAllowsGoneWidgets = a.getBoolean(r0, c.layout.mBarrierAllowsGoneWidgets);
        goto L125
    L48:
        c.layout.mReferenceIdString = a.getString(r0);
        goto L125
    L49:
        c.layout.mBarrierMargin = a.getDimensionPixelSize(r0, c.layout.mBarrierMargin);
        goto L125
    L50:
        c.layout.mBarrierDirection = a.getInt(r0, c.layout.mBarrierDirection);
        goto L125
    L51:
        Log.e(TAG, "CURRENTLY UNSUPPORTED");
        goto L125
    L52:
        c.layout.heightPercent = a.getFloat(r0, 1.0f);
        goto L125
    L53:
        c.layout.widthPercent = a.getFloat(r0, 1.0f);
        goto L125
    L54:
        c.propertySet.mProgress = a.getFloat(r0, c.propertySet.mProgress);
        goto L125
    L55:
        c.motion.mPathRotate = a.getFloat(r0, c.motion.mPathRotate);
        goto L125
    L56:
        c.motion.mDrawPath = a.getInt(r0, 0);
        goto L125
    L61:
        c.motion.mAnimateRelativeTo = lookupID(a, r0, c.motion.mAnimateRelativeTo);
        goto L125
    L62:
        c.layout.circleAngle = a.getFloat(r0, c.layout.circleAngle);
        goto L125
    L63:
        c.layout.circleRadius = a.getDimensionPixelSize(r0, c.layout.circleRadius);
        goto L125
    L64:
        c.layout.circleConstraint = lookupID(a, r0, c.layout.circleConstraint);
        goto L125
    L65:
        c.transform.rotation = a.getFloat(r0, c.transform.rotation);
        goto L125
    L66:
        c.layout.heightMin = a.getDimensionPixelSize(r0, c.layout.heightMin);
        goto L125
    L67:
        c.layout.widthMin = a.getDimensionPixelSize(r0, c.layout.widthMin);
        goto L125
    L68:
        c.layout.heightMax = a.getDimensionPixelSize(r0, c.layout.heightMax);
        goto L125
    L69:
        c.layout.widthMax = a.getDimensionPixelSize(r0, c.layout.widthMax);
        goto L125
    L70:
        c.layout.heightDefault = a.getInt(r0, c.layout.heightDefault);
        goto L125
    L71:
        c.layout.widthDefault = a.getInt(r0, c.layout.widthDefault);
        goto L125
    L72:
        c.transform.translationZ = a.getDimension(r0, c.transform.translationZ);
        goto L125
    L73:
        c.transform.translationY = a.getDimension(r0, c.transform.translationY);
        goto L125
    L74:
        c.transform.translationX = a.getDimension(r0, c.transform.translationX);
        goto L125
    L75:
        c.transform.transformPivotY = a.getDimension(r0, c.transform.transformPivotY);
        goto L125
    L76:
        c.transform.transformPivotX = a.getDimension(r0, c.transform.transformPivotX);
        goto L125
    L77:
        c.transform.scaleY = a.getFloat(r0, c.transform.scaleY);
        goto L125
    L78:
        c.transform.scaleX = a.getFloat(r0, c.transform.scaleX);
        goto L125
    L79:
        c.transform.rotationY = a.getFloat(r0, c.transform.rotationY);
        goto L125
    L80:
        c.transform.rotationX = a.getFloat(r0, c.transform.rotationX);
        goto L125
    L81:
        c.transform.applyElevation = true;
        c.transform.elevation = a.getDimension(r0, c.transform.elevation);
        goto L125
    L82:
        c.propertySet.alpha = a.getFloat(r0, c.propertySet.alpha);
        goto L125
    L83:
        c.layout.verticalChainStyle = a.getInt(r0, c.layout.verticalChainStyle);
        goto L125
    L84:
        c.layout.horizontalChainStyle = a.getInt(r0, c.layout.horizontalChainStyle);
        goto L125
    L85:
        c.layout.verticalWeight = a.getFloat(r0, c.layout.verticalWeight);
        goto L125
    L86:
        c.layout.horizontalWeight = a.getFloat(r0, c.layout.horizontalWeight);
        goto L125
    L87:
        c.mViewId = a.getResourceId(r0, c.mViewId);
        goto L125
    L88:
        c.layout.verticalBias = a.getFloat(r0, c.layout.verticalBias);
        goto L125
    L89:
        c.layout.topToTop = lookupID(a, r0, c.layout.topToTop);
        goto L125
    L90:
        c.layout.topToBottom = lookupID(a, r0, c.layout.topToBottom);
        goto L125
    L91:
        c.layout.topMargin = a.getDimensionPixelSize(r0, c.layout.topMargin);
        goto L125
    L92:
        c.layout.startToStart = lookupID(a, r0, c.layout.startToStart);
        goto L125
    L93:
        c.layout.startToEnd = lookupID(a, r0, c.layout.startToEnd);
        goto L125
    L94:
        c.layout.startMargin = a.getDimensionPixelSize(r0, c.layout.startMargin);
        goto L125
    L95:
        c.layout.rightToRight = lookupID(a, r0, c.layout.rightToRight);
        goto L125
    L96:
        c.layout.rightToLeft = lookupID(a, r0, c.layout.rightToLeft);
        goto L125
    L97:
        c.layout.rightMargin = a.getDimensionPixelSize(r0, c.layout.rightMargin);
        goto L125
    L98:
        c.layout.orientation = a.getInt(r0, c.layout.orientation);
        goto L125
    L99:
        c.layout.leftToRight = lookupID(a, r0, c.layout.leftToRight);
        goto L125
    L100:
        c.layout.leftToLeft = lookupID(a, r0, c.layout.leftToLeft);
        goto L125
    L101:
        c.layout.leftMargin = a.getDimensionPixelSize(r0, c.layout.leftMargin);
        goto L125
    L102:
        c.layout.mWidth = a.getLayoutDimension(r0, c.layout.mWidth);
        goto L125
    L103:
        c.propertySet.visibility = a.getInt(r0, c.propertySet.visibility);
        c.propertySet.visibility = VISIBILITY_FLAGS[c.propertySet.visibility];
        goto L125
    L104:
        c.layout.mHeight = a.getLayoutDimension(r0, c.layout.mHeight);
        goto L125
    L105:
        c.layout.horizontalBias = a.getFloat(r0, c.layout.horizontalBias);
        goto L125
    L106:
        c.layout.guidePercent = a.getFloat(r0, c.layout.guidePercent);
        goto L125
    L107:
        c.layout.guideEnd = a.getDimensionPixelOffset(r0, c.layout.guideEnd);
        goto L125
    L108:
        c.layout.guideBegin = a.getDimensionPixelOffset(r0, c.layout.guideBegin);
        goto L125
    L109:
        c.layout.goneTopMargin = a.getDimensionPixelSize(r0, c.layout.goneTopMargin);
        goto L125
    L110:
        c.layout.goneStartMargin = a.getDimensionPixelSize(r0, c.layout.goneStartMargin);
        goto L125
    L111:
        c.layout.goneRightMargin = a.getDimensionPixelSize(r0, c.layout.goneRightMargin);
        goto L125
    L112:
        c.layout.goneLeftMargin = a.getDimensionPixelSize(r0, c.layout.goneLeftMargin);
        goto L125
    L113:
        c.layout.goneEndMargin = a.getDimensionPixelSize(r0, c.layout.goneEndMargin);
        goto L125
    L114:
        c.layout.goneBottomMargin = a.getDimensionPixelSize(r0, c.layout.goneBottomMargin);
        goto L125
    L115:
        c.layout.endToStart = lookupID(a, r0, c.layout.endToStart);
        goto L125
    L116:
        c.layout.endToEnd = lookupID(a, r0, c.layout.endToEnd);
        goto L125
    L117:
        c.layout.endMargin = a.getDimensionPixelSize(r0, c.layout.endMargin);
        goto L125
    L118:
        c.layout.editorAbsoluteY = a.getDimensionPixelOffset(r0, c.layout.editorAbsoluteY);
        goto L125
    L119:
        c.layout.editorAbsoluteX = a.getDimensionPixelOffset(r0, c.layout.editorAbsoluteX);
        goto L125
    L120:
        c.layout.dimensionRatio = a.getString(r0);
        goto L125
    L121:
        c.layout.bottomToTop = lookupID(a, r0, c.layout.bottomToTop);
        goto L125
    L122:
        c.layout.bottomToBottom = lookupID(a, r0, c.layout.bottomToBottom);
        goto L125
    L123:
        c.layout.bottomMargin = a.getDimensionPixelSize(r0, c.layout.bottomMargin);
        goto L125
    L124:
        c.layout.baselineToBaseline = lookupID(a, r0, c.layout.baselineToBaseline);
        goto L125
    L58:
        if (a.peekValue(r0).type != 3) goto L60;
        c.motion.mTransitionEasing = a.getString(r0);
        goto L125
    L60:
        c.motion.mTransitionEasing = Easing.NAMED_EASING[a.getInteger(r0, 0)];
        goto L125
    L127:
        if (c.layout.mReferenceIdString == null) goto L231;
        c.layout.mReferenceIds = null;
        return;
    }

    private int[] convertReferenceString(View view, String referenceIdString) {
        String[] r8 = referenceIdString.split(",");
        Context r10 = view.getContext();
        int[] r0 = new int[r8.length];
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= r8.length) goto L23;
        String r4 = r8[r2].trim();
        int r5 = R.id.class.getField(r4).getInt(null);     // Catch: Exception -> L8
    L9:
        if (r5 != 0) goto L11;
        r5 = r10.getResources().getIdentifier(r4, "id", r10.getPackageName());
    L11:
        if (r5 != 0) goto L21;
        if (view.isInEditMode() == false) goto L21;
        if ((view.getParent() instanceof ConstraintLayout) == false) goto L21;
        Object r6 = ((ConstraintLayout) view.getParent()).getDesignInformation(0, r4);
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

    public Constraint getConstraint(int id) {
        if (this.mConstraints.containsKey(Integer.valueOf(id)) == true) goto L5;
        return null;
    L5:
        return this.mConstraints.get(Integer.valueOf(id));
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

    public boolean isForceId() {
        return this.mForceId;
    }

    public void setForceId(boolean forceId) {
        this.mForceId = forceId;
    }

    public void setValidateOnParse(boolean validate) {
        this.mValidate = validate;
    }

    public void dump(MotionScene scene, int... ids) {
        Set<Integer> r0 = this.mConstraints.keySet();
        int r2 = 0;
        if (ids.length == 0) goto L7;
        HashSet r1 = new HashSet();
        int r3 = ids.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L8;
        r1.add(Integer.valueOf(ids[r4]));
        r4 = r4 + 1;
    L8:
        System.out.println(r1.size() + " constraints");
        StringBuilder r8 = new StringBuilder();
        Integer[] r5 = (Integer[]) r1.toArray(new Integer[0]);
        int r6 = r5.length;
    L9:
        if (r2 >= r6) goto L15;
        Integer r7 = r5[r2];
        Constraint r9 = this.mConstraints.get(r7);
        if (r9 == null) goto L14;
        r8.append("<Constraint id=");
        r8.append(r7);
        r8.append(" \n");
        r9.layout.dump(scene, r8);
        r8.append("/>\n");
    L14:
        r2 = r2 + 1;
        goto L9
    L15:
        System.out.println(r8.toString());
        return;
    L7:
        r1 = new HashSet(r0);
        goto L8
    }

    static String getLine(Context context, int resourceId, XmlPullParser pullParser) {
        return ".(" + Debug.getName(context, resourceId) + ".xml:" + pullParser.getLineNumber() + ") \"" + pullParser.getName() + "\"";
    }

    static String getDebugName(int v) {
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
        if (r3.getInt(null) != v) goto L19;
        return r3.getName();
    L19:
        r2 = r2 + 1;
        goto L3
    L20:
        return NetworkStackConstant.UNKNOWN_TYPE;
    }

    public void writeState(Writer writer, ConstraintLayout layout, int flags) throws IOException {
        writer.write("\n---------------------------------------------\n");
        if ((flags & 1) != 1) goto L5;
        new WriteXmlEngine(this, writer, layout, flags).writeLayout();
    L6:
        writer.write("\n---------------------------------------------\n");
        return;
    L5:
        new WriteJsonEngine(this, writer, layout, flags).writeLayout();
        goto L6
    }
}
