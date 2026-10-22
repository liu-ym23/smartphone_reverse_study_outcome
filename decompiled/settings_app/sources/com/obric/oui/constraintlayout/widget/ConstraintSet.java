package com.obric.oui.constraintlayout.widget;

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
import androidx.core.os.EnvironmentCompat;
import androidx.exifinterface.media.ExifInterface;
import com.android.settings.fuelgauge.PowerUsageDetail;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import com.obric.oui.constraintlayout.core.motion.utils.Easing;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.HelperWidget;
import com.obric.oui.constraintlayout.motion.widget.Debug;
import com.obric.oui.constraintlayout.motion.widget.MotionLayout;
import com.obric.oui.constraintlayout.motion.widget.MotionScene;
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

/* JADX INFO: loaded from: classes4.dex */
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
    private static SparseIntArray sMapToConstant;
    private static SparseIntArray sOverrideMapToConstant;
    public String derivedState;
    private HashMap<Integer, Constraint> mConstraints;
    private boolean mForceId;
    public String mIdString;
    private String[] mMatchLabels;
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
        public /* bridge */ /* synthetic */ Object m1105clone() throws CloneNotSupportedException {
            return clone();
        }

        public void applyDelta(Constraint r1) {
            Delta r0 = this.mDelta;
            if (r0 == null) goto L6;
            r0.applyDelta(r1);
            return;
        }

        public void printDelta(String r1) {
            Delta r0 = this.mDelta;
            if (r0 == null) goto L5;
            r0.printDelta(r1);
            return;
        L5:
            Log.v(r1, "DELTA IS NULL");
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

        private void setStringValue(String r2, String r3) {
            get(r2, ConstraintAttribute.AttributeType.STRING_TYPE).setStringValue(r3);
        }

        private void setFloatValue(String r2, float r3) {
            get(r2, ConstraintAttribute.AttributeType.FLOAT_TYPE).setFloatValue(r3);
        }

        private void setIntValue(String r2, int r3) {
            get(r2, ConstraintAttribute.AttributeType.INT_TYPE).setIntValue(r3);
        }

        private void setColorValue(String r2, int r3) {
            get(r2, ConstraintAttribute.AttributeType.COLOR_TYPE).setColorValue(r3);
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

        private void fillFromConstraints(ConstraintHelper r1, int r2, Constraints.LayoutParams r3) {
            fillFromConstraints(r2, r3);
            if ((r1 instanceof Barrier) == false) goto L6;
            this.layout.mHelperType = 1;
            Barrier r4 = (Barrier) r1;
            Layout r5 = this.layout;
            r5.mBarrierDirection = r4.getType();
            Layout r6 = this.layout;
            r6.mReferenceIds = r4.getReferencedIds();
            Layout r0 = this.layout;
            r0.mBarrierMargin = r4.getMargin();
            return;
        }

        private void fillFromConstraints(int r2, Constraints.LayoutParams r3) {
            fillFrom(r2, r3);
            PropertySet r4 = this.propertySet;
            r4.alpha = r3.alpha;
            Transform r5 = this.transform;
            r5.rotation = r3.rotation;
            Transform r6 = this.transform;
            r6.rotationX = r3.rotationX;
            Transform r7 = this.transform;
            r7.rotationY = r3.rotationY;
            Transform r8 = this.transform;
            r8.scaleX = r3.scaleX;
            Transform r9 = this.transform;
            r9.scaleY = r3.scaleY;
            Transform r10 = this.transform;
            r10.transformPivotX = r3.transformPivotX;
            Transform r11 = this.transform;
            r11.transformPivotY = r3.transformPivotY;
            Transform r12 = this.transform;
            r12.translationX = r3.translationX;
            Transform r13 = this.transform;
            r13.translationY = r3.translationY;
            Transform r14 = this.transform;
            r14.translationZ = r3.translationZ;
            Transform r15 = this.transform;
            r15.elevation = r3.elevation;
            Transform r1 = this.transform;
            r1.applyElevation = r3.applyElevation;
        }

        private void fillFrom(int r2, ConstraintLayout.LayoutParams r3) {
            this.mViewId = r2;
            Layout r4 = this.layout;
            r4.leftToLeft = r3.leftToLeft;
            Layout r5 = this.layout;
            r5.leftToRight = r3.leftToRight;
            Layout r6 = this.layout;
            r6.rightToLeft = r3.rightToLeft;
            Layout r7 = this.layout;
            r7.rightToRight = r3.rightToRight;
            Layout r8 = this.layout;
            r8.topToTop = r3.topToTop;
            Layout r9 = this.layout;
            r9.topToBottom = r3.topToBottom;
            Layout r10 = this.layout;
            r10.bottomToTop = r3.bottomToTop;
            Layout r11 = this.layout;
            r11.bottomToBottom = r3.bottomToBottom;
            Layout r12 = this.layout;
            r12.baselineToBaseline = r3.baselineToBaseline;
            Layout r13 = this.layout;
            r13.baselineToTop = r3.baselineToTop;
            Layout r14 = this.layout;
            r14.baselineToBottom = r3.baselineToBottom;
            Layout r15 = this.layout;
            r15.startToEnd = r3.startToEnd;
            Layout r16 = this.layout;
            r16.startToStart = r3.startToStart;
            Layout r17 = this.layout;
            r17.endToStart = r3.endToStart;
            Layout r18 = this.layout;
            r18.endToEnd = r3.endToEnd;
            Layout r19 = this.layout;
            r19.horizontalBias = r3.horizontalBias;
            Layout r20 = this.layout;
            r20.verticalBias = r3.verticalBias;
            Layout r21 = this.layout;
            r21.dimensionRatio = r3.dimensionRatio;
            Layout r22 = this.layout;
            r22.circleConstraint = r3.circleConstraint;
            Layout r23 = this.layout;
            r23.circleRadius = r3.circleRadius;
            Layout r24 = this.layout;
            r24.circleAngle = r3.circleAngle;
            Layout r25 = this.layout;
            r25.editorAbsoluteX = r3.editorAbsoluteX;
            Layout r26 = this.layout;
            r26.editorAbsoluteY = r3.editorAbsoluteY;
            Layout r27 = this.layout;
            r27.orientation = r3.orientation;
            Layout r28 = this.layout;
            r28.guidePercent = r3.guidePercent;
            Layout r29 = this.layout;
            r29.guideBegin = r3.guideBegin;
            Layout r30 = this.layout;
            r30.guideEnd = r3.guideEnd;
            Layout r31 = this.layout;
            r31.mWidth = r3.width;
            Layout r32 = this.layout;
            r32.mHeight = r3.height;
            Layout r33 = this.layout;
            r33.leftMargin = r3.leftMargin;
            Layout r34 = this.layout;
            r34.rightMargin = r3.rightMargin;
            Layout r35 = this.layout;
            r35.topMargin = r3.topMargin;
            Layout r36 = this.layout;
            r36.bottomMargin = r3.bottomMargin;
            Layout r37 = this.layout;
            r37.baselineMargin = r3.baselineMargin;
            Layout r38 = this.layout;
            r38.verticalWeight = r3.verticalWeight;
            Layout r39 = this.layout;
            r39.horizontalWeight = r3.horizontalWeight;
            Layout r40 = this.layout;
            r40.verticalChainStyle = r3.verticalChainStyle;
            Layout r41 = this.layout;
            r41.horizontalChainStyle = r3.horizontalChainStyle;
            Layout r42 = this.layout;
            r42.constrainedWidth = r3.constrainedWidth;
            Layout r43 = this.layout;
            r43.constrainedHeight = r3.constrainedHeight;
            Layout r44 = this.layout;
            r44.widthDefault = r3.matchConstraintDefaultWidth;
            Layout r45 = this.layout;
            r45.heightDefault = r3.matchConstraintDefaultHeight;
            Layout r46 = this.layout;
            r46.widthMax = r3.matchConstraintMaxWidth;
            Layout r47 = this.layout;
            r47.heightMax = r3.matchConstraintMaxHeight;
            Layout r48 = this.layout;
            r48.widthMin = r3.matchConstraintMinWidth;
            Layout r49 = this.layout;
            r49.heightMin = r3.matchConstraintMinHeight;
            Layout r50 = this.layout;
            r50.widthPercent = r3.matchConstraintPercentWidth;
            Layout r51 = this.layout;
            r51.heightPercent = r3.matchConstraintPercentHeight;
            Layout r52 = this.layout;
            r52.mConstraintTag = r3.constraintTag;
            Layout r53 = this.layout;
            r53.goneTopMargin = r3.goneTopMargin;
            Layout r54 = this.layout;
            r54.goneBottomMargin = r3.goneBottomMargin;
            Layout r55 = this.layout;
            r55.goneLeftMargin = r3.goneLeftMargin;
            Layout r56 = this.layout;
            r56.goneRightMargin = r3.goneRightMargin;
            Layout r57 = this.layout;
            r57.goneStartMargin = r3.goneStartMargin;
            Layout r58 = this.layout;
            r58.goneEndMargin = r3.goneEndMargin;
            Layout r59 = this.layout;
            r59.goneBaselineMargin = r3.goneBaselineMargin;
            Layout r60 = this.layout;
            r60.mWrapBehavior = r3.wrapBehaviorInParent;
            Layout r61 = this.layout;
            r61.endMargin = r3.getMarginEnd();
            Layout r1 = this.layout;
            r1.startMargin = r3.getMarginStart();
        }

        public void applyTo(ConstraintLayout.LayoutParams r2) {
            r2.leftToLeft = this.layout.leftToLeft;
            r2.leftToRight = this.layout.leftToRight;
            r2.rightToLeft = this.layout.rightToLeft;
            r2.rightToRight = this.layout.rightToRight;
            r2.topToTop = this.layout.topToTop;
            r2.topToBottom = this.layout.topToBottom;
            r2.bottomToTop = this.layout.bottomToTop;
            r2.bottomToBottom = this.layout.bottomToBottom;
            r2.baselineToBaseline = this.layout.baselineToBaseline;
            r2.baselineToTop = this.layout.baselineToTop;
            r2.baselineToBottom = this.layout.baselineToBottom;
            r2.startToEnd = this.layout.startToEnd;
            r2.startToStart = this.layout.startToStart;
            r2.endToStart = this.layout.endToStart;
            r2.endToEnd = this.layout.endToEnd;
            r2.leftMargin = this.layout.leftMargin;
            r2.rightMargin = this.layout.rightMargin;
            r2.topMargin = this.layout.topMargin;
            r2.bottomMargin = this.layout.bottomMargin;
            r2.goneStartMargin = this.layout.goneStartMargin;
            r2.goneEndMargin = this.layout.goneEndMargin;
            r2.goneTopMargin = this.layout.goneTopMargin;
            r2.goneBottomMargin = this.layout.goneBottomMargin;
            r2.horizontalBias = this.layout.horizontalBias;
            r2.verticalBias = this.layout.verticalBias;
            r2.circleConstraint = this.layout.circleConstraint;
            r2.circleRadius = this.layout.circleRadius;
            r2.circleAngle = this.layout.circleAngle;
            r2.dimensionRatio = this.layout.dimensionRatio;
            r2.editorAbsoluteX = this.layout.editorAbsoluteX;
            r2.editorAbsoluteY = this.layout.editorAbsoluteY;
            r2.verticalWeight = this.layout.verticalWeight;
            r2.horizontalWeight = this.layout.horizontalWeight;
            r2.verticalChainStyle = this.layout.verticalChainStyle;
            r2.horizontalChainStyle = this.layout.horizontalChainStyle;
            r2.constrainedWidth = this.layout.constrainedWidth;
            r2.constrainedHeight = this.layout.constrainedHeight;
            r2.matchConstraintDefaultWidth = this.layout.widthDefault;
            r2.matchConstraintDefaultHeight = this.layout.heightDefault;
            r2.matchConstraintMaxWidth = this.layout.widthMax;
            r2.matchConstraintMaxHeight = this.layout.heightMax;
            r2.matchConstraintMinWidth = this.layout.widthMin;
            r2.matchConstraintMinHeight = this.layout.heightMin;
            r2.matchConstraintPercentWidth = this.layout.widthPercent;
            r2.matchConstraintPercentHeight = this.layout.heightPercent;
            r2.orientation = this.layout.orientation;
            r2.guidePercent = this.layout.guidePercent;
            r2.guideBegin = this.layout.guideBegin;
            r2.guideEnd = this.layout.guideEnd;
            r2.width = this.layout.mWidth;
            r2.height = this.layout.mHeight;
            if (this.layout.mConstraintTag == null) goto L5;
            r2.constraintTag = this.layout.mConstraintTag;
        L5:
            r2.wrapBehaviorInParent = this.layout.mWrapBehavior;
            r2.setMarginStart(this.layout.startMargin);
            r2.setMarginEnd(this.layout.endMargin);
            r2.validate();
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
        private static SparseIntArray sMapToConstant;
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

        static {
            SparseIntArray r0 = new SparseIntArray();
            sMapToConstant = r0;
            r0.append(R.styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            sMapToConstant.append(R.styleable.Layout_layout_constraintLeft_toRightOf, 25);
            sMapToConstant.append(R.styleable.Layout_layout_constraintRight_toLeftOf, 28);
            sMapToConstant.append(R.styleable.Layout_layout_constraintRight_toRightOf, 29);
            sMapToConstant.append(R.styleable.Layout_layout_constraintTop_toTopOf, 35);
            sMapToConstant.append(R.styleable.Layout_layout_constraintTop_toBottomOf, 34);
            sMapToConstant.append(R.styleable.Layout_layout_constraintBottom_toTopOf, 4);
            sMapToConstant.append(R.styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            sMapToConstant.append(R.styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            sMapToConstant.append(R.styleable.Layout_layout_editor_absoluteX, 6);
            sMapToConstant.append(R.styleable.Layout_layout_editor_absoluteY, 7);
            sMapToConstant.append(R.styleable.Layout_layout_constraintGuide_begin, 17);
            sMapToConstant.append(R.styleable.Layout_layout_constraintGuide_end, 18);
            sMapToConstant.append(R.styleable.Layout_layout_constraintGuide_percent, 19);
            sMapToConstant.append(R.styleable.Layout_guidelineUseRtl, 90);
            sMapToConstant.append(R.styleable.Layout_android_orientation, 26);
            sMapToConstant.append(R.styleable.Layout_layout_constraintStart_toEndOf, 31);
            sMapToConstant.append(R.styleable.Layout_layout_constraintStart_toStartOf, 32);
            sMapToConstant.append(R.styleable.Layout_layout_constraintEnd_toStartOf, 10);
            sMapToConstant.append(R.styleable.Layout_layout_constraintEnd_toEndOf, 9);
            sMapToConstant.append(R.styleable.Layout_layout_goneMarginLeft, 13);
            sMapToConstant.append(R.styleable.Layout_layout_goneMarginTop, 16);
            sMapToConstant.append(R.styleable.Layout_layout_goneMarginRight, 14);
            sMapToConstant.append(R.styleable.Layout_layout_goneMarginBottom, 11);
            sMapToConstant.append(R.styleable.Layout_layout_goneMarginStart, 15);
            sMapToConstant.append(R.styleable.Layout_layout_goneMarginEnd, 12);
            sMapToConstant.append(R.styleable.Layout_layout_constraintVertical_weight, 38);
            sMapToConstant.append(R.styleable.Layout_layout_constraintHorizontal_weight, 37);
            sMapToConstant.append(R.styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            sMapToConstant.append(R.styleable.Layout_layout_constraintVertical_chainStyle, 40);
            sMapToConstant.append(R.styleable.Layout_layout_constraintHorizontal_bias, 20);
            sMapToConstant.append(R.styleable.Layout_layout_constraintVertical_bias, 36);
            sMapToConstant.append(R.styleable.Layout_layout_constraintDimensionRatio, 5);
            sMapToConstant.append(R.styleable.Layout_layout_constraintLeft_creator, 91);
            sMapToConstant.append(R.styleable.Layout_layout_constraintTop_creator, 91);
            sMapToConstant.append(R.styleable.Layout_layout_constraintRight_creator, 91);
            sMapToConstant.append(R.styleable.Layout_layout_constraintBottom_creator, 91);
            sMapToConstant.append(R.styleable.Layout_layout_constraintBaseline_creator, 91);
            sMapToConstant.append(R.styleable.Layout_android_layout_marginLeft, 23);
            sMapToConstant.append(R.styleable.Layout_android_layout_marginRight, 27);
            sMapToConstant.append(R.styleable.Layout_android_layout_marginStart, 30);
            sMapToConstant.append(R.styleable.Layout_android_layout_marginEnd, 8);
            sMapToConstant.append(R.styleable.Layout_android_layout_marginTop, 33);
            sMapToConstant.append(R.styleable.Layout_android_layout_marginBottom, 2);
            sMapToConstant.append(R.styleable.Layout_android_layout_width, 22);
            sMapToConstant.append(R.styleable.Layout_android_layout_height, 21);
            sMapToConstant.append(R.styleable.Layout_layout_constraintWidth, 41);
            sMapToConstant.append(R.styleable.Layout_layout_constraintHeight, 42);
            sMapToConstant.append(R.styleable.Layout_layout_constrainedWidth, 87);
            sMapToConstant.append(R.styleable.Layout_layout_constrainedHeight, 88);
            sMapToConstant.append(R.styleable.Layout_layout_wrapBehaviorInParent, 76);
            sMapToConstant.append(R.styleable.Layout_layout_constraintCircle, 61);
            sMapToConstant.append(R.styleable.Layout_layout_constraintCircleRadius, 62);
            sMapToConstant.append(R.styleable.Layout_layout_constraintCircleAngle, 63);
            sMapToConstant.append(R.styleable.Layout_layout_constraintWidth_percent, 69);
            sMapToConstant.append(R.styleable.Layout_layout_constraintHeight_percent, 70);
            sMapToConstant.append(R.styleable.Layout_chainUseRtl, 71);
            sMapToConstant.append(R.styleable.Layout_barrierDirection, 72);
            sMapToConstant.append(R.styleable.Layout_barrierMargin, 73);
            sMapToConstant.append(R.styleable.Layout_constraint_referenced_ids, 74);
            sMapToConstant.append(R.styleable.Layout_barrierAllowsGoneWidgets, 75);
            sMapToConstant.append(R.styleable.Layout_layout_constraintWidth_max, 84);
            sMapToConstant.append(R.styleable.Layout_layout_constraintWidth_min, 86);
            sMapToConstant.append(R.styleable.Layout_layout_constraintWidth_max, 83);
            sMapToConstant.append(R.styleable.Layout_layout_constraintHeight_min, 85);
            sMapToConstant.append(R.styleable.Layout_layout_constraintWidth, 87);
            sMapToConstant.append(R.styleable.Layout_layout_constraintHeight, 88);
            sMapToConstant.append(R.styleable.ConstraintLayout_Layout_layout_constraintTag, 89);
            sMapToConstant.append(R.styleable.Layout_guidelineUseRtl, 90);
        }

        void fillFromAttributeList(Context r9, AttributeSet r10) {
            TypedArray r11 = r9.obtainStyledAttributes(r10, R.styleable.Layout);
            this.mApply = true;
            int r0 = r11.getIndexCount();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L79;
            int r3 = r11.getIndex(r2);
            int r4 = sMapToConstant.get(r3);
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
            Log.w(ConstraintSet.TAG, "Unknown attribute 0x" + Integer.toHexString(r3) + "   " + sMapToConstant.get(r3));
            goto L78
        L10:
            Log.w(ConstraintSet.TAG, "unused attribute 0x" + Integer.toHexString(r3) + "   " + sMapToConstant.get(r3));
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
            Log.e(ConstraintSet.TAG, "Error accessing ConstraintSet field", e);
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
        private static SparseIntArray sMapToConstant;
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

        static {
            SparseIntArray r0 = new SparseIntArray();
            sMapToConstant = r0;
            r0.append(R.styleable.Motion_motionPathRotate, 1);
            sMapToConstant.append(R.styleable.Motion_pathMotionArc, 2);
            sMapToConstant.append(R.styleable.Motion_transitionEasing, 3);
            sMapToConstant.append(R.styleable.Motion_drawPath, 4);
            sMapToConstant.append(R.styleable.Motion_animateRelativeTo, 5);
            sMapToConstant.append(R.styleable.Motion_animateCircleAngleTo, 6);
            sMapToConstant.append(R.styleable.Motion_motionStagger, 7);
            sMapToConstant.append(R.styleable.Motion_quantizeMotionSteps, 8);
            sMapToConstant.append(R.styleable.Motion_quantizeMotionPhase, 9);
            sMapToConstant.append(R.styleable.Motion_quantizeMotionInterpolator, 10);
        }

        void fillFromAttributeList(Context r10, AttributeSet r11) {
            TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.Motion);
            this.mApply = true;
            int r0 = r12.getIndexCount();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L32;
            int r3 = r12.getIndex(r2);
            switch(sMapToConstant.get(r3)) {
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
            TypedValue r4 = r12.peekValue(r3);
            if (r4.type != 1) goto L13;
            int r5 = r12.getResourceId(r3, -1);
            this.mQuantizeInterpolatorID = r5;
            if (r5 == (-1)) goto L31;
            this.mQuantizeInterpolatorType = -2;
            goto L31
        L13:
            if (r4.type != 3) goto L18;
            String r6 = r12.getString(r3);
            this.mQuantizeInterpolatorString = r6;
            if (r6.indexOf(LibrarianImpl.Constants.SEPARATOR) <= 0) goto L17;
            this.mQuantizeInterpolatorID = r12.getResourceId(r3, -1);
            this.mQuantizeInterpolatorType = -2;
            goto L31
        L17:
            this.mQuantizeInterpolatorType = -1;
            goto L31
        L18:
            this.mQuantizeInterpolatorType = r12.getInteger(r3, this.mQuantizeInterpolatorID);
            goto L31
        L19:
            this.mQuantizeMotionPhase = r12.getFloat(r3, this.mQuantizeMotionPhase);
            goto L31
        L20:
            this.mQuantizeMotionSteps = r12.getInteger(r3, this.mQuantizeMotionSteps);
            goto L31
        L21:
            this.mMotionStagger = r12.getFloat(r3, this.mMotionStagger);
            goto L31
        L22:
            this.mAnimateCircleAngleTo = r12.getInteger(r3, this.mAnimateCircleAngleTo);
            goto L31
        L23:
            this.mAnimateRelativeTo = ConstraintSet.access$100(r12, r3, this.mAnimateRelativeTo);
            goto L31
        L24:
            this.mDrawPath = r12.getInt(r3, 0);
            goto L31
        L29:
            this.mPathMotionArc = r12.getInt(r3, this.mPathMotionArc);
            goto L31
        L30:
            this.mPathRotate = r12.getFloat(r3, this.mPathRotate);
            goto L31
        L26:
            if (r12.peekValue(r3).type != 3) goto L28;
            this.mTransitionEasing = r12.getString(r3);
            goto L31
        L28:
            this.mTransitionEasing = Easing.NAMED_EASING[r12.getInteger(r3, 0)];
        L31:
            r2 = r2 + 1;
            goto L3
        L32:
            r12.recycle();
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
        private static SparseIntArray sMapToConstant;
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

        static {
            SparseIntArray r0 = new SparseIntArray();
            sMapToConstant = r0;
            r0.append(R.styleable.Transform_android_rotation, 1);
            sMapToConstant.append(R.styleable.Transform_android_rotationX, 2);
            sMapToConstant.append(R.styleable.Transform_android_rotationY, 3);
            sMapToConstant.append(R.styleable.Transform_android_scaleX, 4);
            sMapToConstant.append(R.styleable.Transform_android_scaleY, 5);
            sMapToConstant.append(R.styleable.Transform_android_transformPivotX, 6);
            sMapToConstant.append(R.styleable.Transform_android_transformPivotY, 7);
            sMapToConstant.append(R.styleable.Transform_android_translationX, 8);
            sMapToConstant.append(R.styleable.Transform_android_translationY, 9);
            sMapToConstant.append(R.styleable.Transform_android_translationZ, 10);
            sMapToConstant.append(R.styleable.Transform_android_elevation, 11);
            sMapToConstant.append(R.styleable.Transform_transformPivotTarget, 12);
        }

        void fillFromAttributeList(Context r5, AttributeSet r6) {
            TypedArray r7 = r5.obtainStyledAttributes(r6, R.styleable.Transform);
            this.mApply = true;
            int r0 = r7.getIndexCount();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L20;
            int r2 = r7.getIndex(r1);
            switch(sMapToConstant.get(r2)) {
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

    class WriteJsonEngine {
        private static final String SPACE = "       ";
        final String mBASELINE;
        final String mBOTTOM;
        Context mContext;
        final String mEND;
        int mFlags;
        HashMap<Integer, String> mIdMap;
        final String mLEFT;
        ConstraintLayout mLayout;
        final String mRIGHT;
        final String mSTART;
        final String mTOP;
        int mUnknownCount;
        Writer mWriter;
        final /* synthetic */ ConstraintSet this$0;

        WriteJsonEngine(ConstraintSet r1, Writer r2, ConstraintLayout r3, int r4) throws IOException {
            this.this$0 = r1;
            this.mUnknownCount = 0;
            this.mLEFT = "'left'";
            this.mRIGHT = "'right'";
            this.mBASELINE = "'baseline'";
            this.mBOTTOM = "'bottom'";
            this.mTOP = "'top'";
            this.mSTART = "'start'";
            this.mEND = "'end'";
            this.mIdMap = new HashMap();
            this.mWriter = r2;
            this.mLayout = r3;
            this.mContext = r3.getContext();
            this.mFlags = r4;
        }

        void writeLayout() throws IOException {
            this.mWriter.write("\n'ConstraintSet':{\n");
            Iterator r8 = ConstraintSet.access$1300(this.this$0).keySet().iterator();
        L4:
            if (r8.hasNext() == false) goto L9;
            Integer r0 = (Integer) r8.next();
            Constraint r1 = (Constraint) ConstraintSet.access$1300(this.this$0).get(r0);
            this.mWriter.write(getName(r0.intValue()) + ":{\n");
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
            this.mWriter.write("}\n");
            goto L4
        L9:
            this.mWriter.write("}\n");
        }

        private void writeGuideline(int r2, int r3, int r4, float r5) throws IOException {
            writeVariable("'orientation'", r2);
            writeVariable("'guideBegin'", r3);
            writeVariable("'guideEnd'", r4);
            writeVariable("'guidePercent'", r5);
        }

        private void writeDimension(String r4, int r5, int r6, float r7, int r8, int r9, boolean r10) throws IOException {
            if (r5 != 0) goto L27;
            if (r9 != (-1)) goto L16;
            if (r8 != (-1)) goto L16;
            if (r6 == 1) goto L13;
            if (r6 != 2) goto L36;
            this.mWriter.write(SPACE + r4 + ": '" + r7 + "%',\n");
            return;
        L36:
            return;
        L13:
            this.mWriter.write(SPACE + r4 + ": '???????????',\n");
            return;
        L16:
            if (r6 == 0) goto L24;
            if (r6 == 1) goto L22;
            if (r6 != 2) goto L33;
            this.mWriter.write(SPACE + r4 + ": {'" + r7 + "'% ," + r8 + ", " + r9 + "}\n");
            return;
        L33:
            return;
        L22:
            this.mWriter.write(SPACE + r4 + ": {'wrap' ," + r8 + ", " + r9 + "}\n");
            return;
        L24:
            this.mWriter.write(SPACE + r4 + ": {'spread' ," + r8 + ", " + r9 + "}\n");
            return;
        L27:
            if (r5 != (-2)) goto L29;
            this.mWriter.write(SPACE + r4 + ": 'wrap'\n");
            return;
        L29:
            if (r5 != (-1)) goto L31;
            this.mWriter.write(SPACE + r4 + ": 'parent'\n");
            return;
        L31:
            this.mWriter.write(SPACE + r4 + ": " + r5 + ",\n");
        }

        String getName(int r3) {
            if (this.mIdMap.containsKey(Integer.valueOf(r3)) == true) goto L5;
            if (r3 != 0) goto L9;
            return "'parent'";
        L9:
            String r0 = lookup(r3);
            this.mIdMap.put(Integer.valueOf(r3), r0);
            return "'" + r0 + "'";
        L5:
            return "'" + this.mIdMap.get(Integer.valueOf(r3)) + "'";
        }

        String lookup(int r3) {
            if (r3 != (-1)) goto L5;
            StringBuilder r4 = new StringBuilder(EnvironmentCompat.MEDIA_UNKNOWN);     // Catch: Exception -> L8
            int r0 = this.mUnknownCount + 1;     // Catch: Exception -> L8
            this.mUnknownCount = r0;     // Catch: Exception -> L8
            return r4.append(r0).toString();
        L5:
            return this.mContext.getResources().getResourceEntryName(r3);
        L8:
            StringBuilder r5 = new StringBuilder(EnvironmentCompat.MEDIA_UNKNOWN);
            int r1 = this.mUnknownCount + 1;
            this.mUnknownCount = r1;
            return r5.append(r1).toString();
        }

        void writeConstraint(String r3, int r4, String r5, int r6, int r7) throws IOException {
            if (r4 != (-1)) goto L5;
            return;
        L5:
            this.mWriter.write(SPACE + r3);
            this.mWriter.write(":[");
            this.mWriter.write(getName(r4));
            this.mWriter.write(" , ");
            this.mWriter.write(r5);
            if (r6 == 0) goto L8;
            this.mWriter.write(" , " + r6);
        L8:
            this.mWriter.write("],\n");
        }

        void writeCircle(int r3, float r4, int r5) throws IOException {
            if (r3 != (-1)) goto L5;
            return;
        L5:
            this.mWriter.write("       circle");
            this.mWriter.write(":[");
            this.mWriter.write(getName(r3));
            this.mWriter.write(", " + r4);
            this.mWriter.write(r5 + "]");
        }

        void writeVariable(String r4, int r5) throws IOException {
            if (r5 != 0) goto L4;
            return;
        L4:
            if (r5 == (-1)) goto L9;
            this.mWriter.write(SPACE + r4);
            this.mWriter.write(":");
            this.mWriter.write(", " + r5);
            this.mWriter.write("\n");
            return;
        }

        void writeVariable(String r4, float r5) throws IOException {
            if (r5 != (-1.0f)) goto L5;
            return;
        L5:
            this.mWriter.write(SPACE + r4);
            this.mWriter.write(": " + r5);
            this.mWriter.write(",\n");
        }

        void writeVariable(String r3, float r4, float r5) throws IOException {
            if (r4 != r5) goto L5;
            return;
        L5:
            this.mWriter.write(SPACE + r3);
            this.mWriter.write(": " + r4);
            this.mWriter.write(",\n");
        }

        void writeVariable(String r4, boolean r5) throws IOException {
            if (r5 == true) goto L4;
            return;
        L4:
            this.mWriter.write(SPACE + r4);
            this.mWriter.write(": " + r5);
            this.mWriter.write(",\n");
        }

        void writeVariable(String r3, boolean r4, boolean r5) throws IOException {
            if (r4 != r5) goto L4;
            return;
        L4:
            this.mWriter.write(SPACE + r3);
            this.mWriter.write(": " + r4);
            this.mWriter.write(",\n");
        }

        void writeVariable(String r4, int[] r5) throws IOException {
            if (r5 != null) goto L4;
            return;
        L4:
            this.mWriter.write(SPACE + r4);
            this.mWriter.write(": ");
            int r6 = 0;
        L6:
            if (r6 >= r5.length) goto L12;
            Writer r0 = this.mWriter;
            StringBuilder r1 = new StringBuilder();
            if (r6 != 0) goto L10;
            String r2 = "[";
        L11:
            r0.write(r1.append(r2).append(getName(r5[r6])).toString());
            r6 = r6 + 1;
            goto L6
        L10:
            r2 = ", ";
            goto L11
        L12:
            this.mWriter.write("],\n");
        }

        void writeVariable(String r4, String r5) throws IOException {
            if (r5 != null) goto L4;
            return;
        L4:
            this.mWriter.write(SPACE + r4);
            this.mWriter.write(":");
            this.mWriter.write(", " + r5);
            this.mWriter.write("\n");
        }
    }

    class WriteXmlEngine {
        private static final String SPACE = "\n       ";
        final String mBASELINE;
        final String mBOTTOM;
        Context mContext;
        final String mEND;
        int mFlags;
        HashMap<Integer, String> mIdMap;
        final String mLEFT;
        ConstraintLayout mLayout;
        final String mRIGHT;
        final String mSTART;
        final String mTOP;
        int mUnknownCount;
        Writer mWriter;
        final /* synthetic */ ConstraintSet this$0;

        WriteXmlEngine(ConstraintSet r1, Writer r2, ConstraintLayout r3, int r4) throws IOException {
            this.this$0 = r1;
            this.mUnknownCount = 0;
            this.mLEFT = "'left'";
            this.mRIGHT = "'right'";
            this.mBASELINE = "'baseline'";
            this.mBOTTOM = "'bottom'";
            this.mTOP = "'top'";
            this.mSTART = "'start'";
            this.mEND = "'end'";
            this.mIdMap = new HashMap();
            this.mWriter = r2;
            this.mLayout = r3;
            this.mContext = r3.getContext();
            this.mFlags = r4;
        }

        void writeLayout() throws IOException {
            this.mWriter.write("\n<ConstraintSet>\n");
            Iterator r1 = ConstraintSet.access$1300(this.this$0).keySet().iterator();
        L4:
            if (r1.hasNext() == false) goto L9;
            Integer r2 = (Integer) r1.next();
            Constraint r3 = (Constraint) ConstraintSet.access$1300(this.this$0).get(r2);
            String r4 = getName(r2.intValue());
            this.mWriter.write("  <Constraint");
            this.mWriter.write("\n       android:id=\"" + r4 + "\"");
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
            this.mWriter.write(" />\n");
            goto L4
        L9:
            this.mWriter.write("</ConstraintSet>\n");
        }

        private void writeBoolen(String r2, boolean r3, boolean r4) throws IOException {
            if (r3 == r4) goto L5;
            this.mWriter.write(SPACE + r2 + "=\"" + r3 + "dp\"");
            return;
        }

        private void writeEnum(String r2, int r3, String[] r4, int r5) throws IOException {
            if (r3 == r5) goto L5;
            this.mWriter.write(SPACE + r2 + "=\"" + r4[r3] + "\"");
            return;
        }

        private void writeDimension(String r2, int r3, int r4) throws IOException {
            if (r3 == r4) goto L5;
            this.mWriter.write(SPACE + r2 + "=\"" + r3 + "dp\"");
            return;
        }

        private void writeBaseDimension(String r2, int r3, int r4) throws IOException {
            if (r3 != r4) goto L4;
            return;
        L4:
            if (r3 != (-2)) goto L7;
            this.mWriter.write(SPACE + r2 + "=\"wrap_content\"");
            return;
        L7:
            if (r3 != (-1)) goto L9;
            this.mWriter.write(SPACE + r2 + "=\"match_parent\"");
            return;
        L9:
            this.mWriter.write(SPACE + r2 + "=\"" + r3 + "dp\"");
        }

        String getName(int r4) {
            if (this.mIdMap.containsKey(Integer.valueOf(r4)) == true) goto L5;
            if (r4 != 0) goto L9;
            return ConstraintSet.KEY_PERCENT_PARENT;
        L9:
            String r0 = lookup(r4);
            this.mIdMap.put(Integer.valueOf(r4), r0);
            return "@+id/" + r0 + "";
        L5:
            return "@+id/" + this.mIdMap.get(Integer.valueOf(r4)) + "";
        }

        String lookup(int r3) {
            if (r3 != (-1)) goto L5;
            StringBuilder r4 = new StringBuilder(EnvironmentCompat.MEDIA_UNKNOWN);     // Catch: Exception -> L8
            int r0 = this.mUnknownCount + 1;     // Catch: Exception -> L8
            this.mUnknownCount = r0;     // Catch: Exception -> L8
            return r4.append(r0).toString();
        L5:
            return this.mContext.getResources().getResourceEntryName(r3);
        L8:
            StringBuilder r5 = new StringBuilder(EnvironmentCompat.MEDIA_UNKNOWN);
            int r1 = this.mUnknownCount + 1;
            this.mUnknownCount = r1;
            return r5.append(r1).toString();
        }

        void writeXmlConstraint(String r4, int r5) throws IOException {
            if (r5 != (-1)) goto L5;
            return;
        L5:
            this.mWriter.write(SPACE + r4);
            this.mWriter.write("=\"" + getName(r5) + "\"");
        }

        void writeConstraint(String r3, int r4, String r5, int r6, int r7) throws IOException {
            if (r4 != (-1)) goto L5;
            return;
        L5:
            this.mWriter.write(SPACE + r3);
            this.mWriter.write(":[");
            this.mWriter.write(getName(r4));
            this.mWriter.write(" , ");
            this.mWriter.write(r5);
            if (r6 == 0) goto L8;
            this.mWriter.write(" , " + r6);
        L8:
            this.mWriter.write("],\n");
        }

        void writeCircle(int r3, float r4, int r5) throws IOException {
            if (r3 != (-1)) goto L5;
            return;
        L5:
            this.mWriter.write("circle");
            this.mWriter.write(":[");
            this.mWriter.write(getName(r3));
            this.mWriter.write(", " + r4);
            this.mWriter.write(r5 + "]");
        }

        void writeVariable(String r3, int r4) throws IOException {
            if (r4 != 0) goto L4;
            return;
        L4:
            if (r4 == (-1)) goto L9;
            this.mWriter.write(SPACE + r3 + "=\"" + r4 + "\"\n");
            return;
        }

        void writeVariable(String r3, float r4, float r5) throws IOException {
            if (r4 != r5) goto L5;
            return;
        L5:
            this.mWriter.write(SPACE + r3);
            this.mWriter.write("=\"" + r4 + "\"");
        }

        void writeVariable(String r3, String r4, String r5) throws IOException {
            if (r4 != null) goto L4;
            return;
        L4:
            if (r4.equals(r5) == true) goto L9;
            this.mWriter.write(SPACE + r3);
            this.mWriter.write("=\"" + r4 + "\"");
            return;
        }

        void writeVariable(String r4, int[] r5) throws IOException {
            if (r5 != null) goto L4;
            return;
        L4:
            this.mWriter.write(SPACE + r4);
            this.mWriter.write(":");
            int r6 = 0;
        L6:
            if (r6 >= r5.length) goto L12;
            Writer r0 = this.mWriter;
            StringBuilder r1 = new StringBuilder();
            if (r6 != 0) goto L10;
            String r2 = "[";
        L11:
            r0.write(r1.append(r2).append(getName(r5[r6])).toString());
            r6 = r6 + 1;
            goto L6
        L10:
            r2 = ", ";
            goto L11
        L12:
            this.mWriter.write("],\n");
        }

        void writeVariable(String r3, String r4) throws IOException {
            if (r4 != null) goto L4;
            return;
        L4:
            this.mWriter.write(r3);
            this.mWriter.write(":");
            this.mWriter.write(", " + r4);
            this.mWriter.write("\n");
        }
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

    public ConstraintSet() {
        this.derivedState = "";
        this.mMatchLabels = new String[0];
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
        sMapToConstant = new SparseIntArray();
        sOverrideMapToConstant = new SparseIntArray();
        sMapToConstant.append(R.styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintRight_toRightOf, 30);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintTop_toTopOf, 36);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_toTopOf, 91);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_toBottomOf, 92);
        sMapToConstant.append(R.styleable.Constraint_layout_editor_absoluteX, 6);
        sMapToConstant.append(R.styleable.Constraint_layout_editor_absoluteY, 7);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintGuide_begin, 17);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintGuide_end, 18);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintGuide_percent, 19);
        sMapToConstant.append(R.styleable.Constraint_guidelineUseRtl, 99);
        sMapToConstant.append(R.styleable.Constraint_android_orientation, 27);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintStart_toEndOf, 32);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintStart_toStartOf, 33);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        sMapToConstant.append(R.styleable.Constraint_layout_goneMarginLeft, 13);
        sMapToConstant.append(R.styleable.Constraint_layout_goneMarginTop, 16);
        sMapToConstant.append(R.styleable.Constraint_layout_goneMarginRight, 14);
        sMapToConstant.append(R.styleable.Constraint_layout_goneMarginBottom, 11);
        sMapToConstant.append(R.styleable.Constraint_layout_goneMarginStart, 15);
        sMapToConstant.append(R.styleable.Constraint_layout_goneMarginEnd, 12);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintVertical_weight, 40);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_weight, 39);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_bias, 20);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintVertical_bias, 37);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintDimensionRatio, 5);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintLeft_creator, 87);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintTop_creator, 87);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintRight_creator, 87);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintBottom_creator, 87);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_creator, 87);
        sMapToConstant.append(R.styleable.Constraint_android_layout_marginLeft, 24);
        sMapToConstant.append(R.styleable.Constraint_android_layout_marginRight, 28);
        sMapToConstant.append(R.styleable.Constraint_android_layout_marginStart, 31);
        sMapToConstant.append(R.styleable.Constraint_android_layout_marginEnd, 8);
        sMapToConstant.append(R.styleable.Constraint_android_layout_marginTop, 34);
        sMapToConstant.append(R.styleable.Constraint_android_layout_marginBottom, 2);
        sMapToConstant.append(R.styleable.Constraint_android_layout_width, 23);
        sMapToConstant.append(R.styleable.Constraint_android_layout_height, 21);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintWidth, 95);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintHeight, 96);
        sMapToConstant.append(R.styleable.Constraint_android_visibility, 22);
        sMapToConstant.append(R.styleable.Constraint_android_alpha, 43);
        sMapToConstant.append(R.styleable.Constraint_android_elevation, 44);
        sMapToConstant.append(R.styleable.Constraint_android_rotationX, 45);
        sMapToConstant.append(R.styleable.Constraint_android_rotationY, 46);
        sMapToConstant.append(R.styleable.Constraint_android_rotation, 60);
        sMapToConstant.append(R.styleable.Constraint_android_scaleX, 47);
        sMapToConstant.append(R.styleable.Constraint_android_scaleY, 48);
        sMapToConstant.append(R.styleable.Constraint_android_transformPivotX, 49);
        sMapToConstant.append(R.styleable.Constraint_android_transformPivotY, 50);
        sMapToConstant.append(R.styleable.Constraint_android_translationX, 51);
        sMapToConstant.append(R.styleable.Constraint_android_translationY, 52);
        sMapToConstant.append(R.styleable.Constraint_android_translationZ, 53);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintWidth_default, 54);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintHeight_default, 55);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintWidth_max, 56);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintHeight_max, 57);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintWidth_min, 58);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintHeight_min, 59);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintCircle, 61);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintCircleRadius, 62);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintCircleAngle, 63);
        sMapToConstant.append(R.styleable.Constraint_animateRelativeTo, 64);
        sMapToConstant.append(R.styleable.Constraint_transitionEasing, 65);
        sMapToConstant.append(R.styleable.Constraint_drawPath, 66);
        sMapToConstant.append(R.styleable.Constraint_transitionPathRotate, 67);
        sMapToConstant.append(R.styleable.Constraint_motionStagger, 79);
        sMapToConstant.append(R.styleable.Constraint_android_id, 38);
        sMapToConstant.append(R.styleable.Constraint_motionProgress, 68);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintWidth_percent, 69);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintHeight_percent, 70);
        sMapToConstant.append(R.styleable.Constraint_layout_wrapBehaviorInParent, 97);
        sMapToConstant.append(R.styleable.Constraint_chainUseRtl, 71);
        sMapToConstant.append(R.styleable.Constraint_barrierDirection, 72);
        sMapToConstant.append(R.styleable.Constraint_barrierMargin, 73);
        sMapToConstant.append(R.styleable.Constraint_constraint_referenced_ids, 74);
        sMapToConstant.append(R.styleable.Constraint_barrierAllowsGoneWidgets, 75);
        sMapToConstant.append(R.styleable.Constraint_pathMotionArc, 76);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintTag, 77);
        sMapToConstant.append(R.styleable.Constraint_visibilityMode, 78);
        sMapToConstant.append(R.styleable.Constraint_layout_constrainedWidth, 80);
        sMapToConstant.append(R.styleable.Constraint_layout_constrainedHeight, 81);
        sMapToConstant.append(R.styleable.Constraint_polarRelativeTo, 82);
        sMapToConstant.append(R.styleable.Constraint_transformPivotTarget, 83);
        sMapToConstant.append(R.styleable.Constraint_quantizeMotionSteps, 84);
        sMapToConstant.append(R.styleable.Constraint_quantizeMotionPhase, 85);
        sMapToConstant.append(R.styleable.Constraint_quantizeMotionInterpolator, 86);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_editor_absoluteY, 6);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_editor_absoluteY, 7);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_orientation, 27);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginLeft, 13);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginTop, 16);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginRight, 14);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginBottom, 11);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginStart, 15);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginEnd, 12);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintVertical_weight, 40);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintVertical_bias, 37);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintDimensionRatio, 5);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintLeft_creator, 87);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintTop_creator, 87);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintRight_creator, 87);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintBottom_creator, 87);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintBaseline_creator, 87);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginLeft, 24);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginRight, 28);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginStart, 31);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginEnd, 8);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginTop, 34);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginBottom, 2);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_width, 23);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_height, 21);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth, 95);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight, 96);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_visibility, 22);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_alpha, 43);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_elevation, 44);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_rotationX, 45);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_rotationY, 46);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_rotation, 60);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_scaleX, 47);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_scaleY, 48);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_transformPivotX, 49);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_transformPivotY, 50);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_translationX, 51);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_translationY, 52);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_translationZ, 53);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_default, 54);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_default, 55);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_max, 56);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_max, 57);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_min, 58);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_min, 59);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintCircleRadius, 62);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintCircleAngle, 63);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_animateRelativeTo, 64);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_transitionEasing, 65);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_drawPath, 66);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_transitionPathRotate, 67);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_motionStagger, 79);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_id, 38);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_motionTarget, 98);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_motionProgress, 68);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_percent, 69);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_percent, 70);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_chainUseRtl, 71);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_barrierDirection, 72);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_barrierMargin, 73);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_constraint_referenced_ids, 74);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_pathMotionArc, 76);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintTag, 77);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_visibilityMode, 78);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constrainedWidth, 80);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constrainedHeight, 81);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_polarRelativeTo, 82);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_transformPivotTarget, 83);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_quantizeMotionSteps, 84);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_quantizeMotionPhase, 85);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_quantizeMotionInterpolator, 86);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    public HashMap<String, ConstraintAttribute> getCustomAttributeSet() {
        return this.mSavedAttributes;
    }

    public Constraint getParameters(int r1) {
        return get(r1);
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

    public void applyDeltaFrom(ConstraintSet r6) {
        Iterator<Constraint> r7 = r6.mConstraints.values().iterator();
    L4:
        if (r7.hasNext() == false) goto L20;
        Constraint r0 = r7.next();
        if (r0.mDelta == null) goto L4;
        if (r0.mTargetString == null) goto L10;
        Iterator<Integer> r1 = this.mConstraints.keySet().iterator();
    L13:
        if (r1.hasNext() == false) goto L4;
        Constraint r2 = getConstraint(r1.next().intValue());
        if (r2.layout.mConstraintTag == null) goto L13;
        if (r0.mTargetString.matches(r2.layout.mConstraintTag) == false) goto L13;
        r0.mDelta.applyDelta(r2);
        HashMap r3 = (HashMap) r0.mCustomConstraints.clone();
        r2.mCustomConstraints.putAll(r3);
        goto L13
    L10:
        Constraint r4 = getConstraint(r0.mViewId);
        r0.mDelta.applyDelta(r4);
        goto L4
    }

    static void parseDimensionConstraints(Object r4, TypedArray r5, int r6, int r7) {
        if (r4 != null) goto L4;
        return;
    L4:
        int r0 = r5.peekValue(r6).type;
        if (r0 == 3) goto L38;
        int r2 = 0;
        if (r0 == 5) goto L17;
        int r8 = r5.getInt(r6, 0);
        if (r8 != (-4)) goto L11;
        boolean r9 = true;
        r2 = -2;
    L20:
        if ((r4 instanceof ConstraintLayout.LayoutParams) == false) goto L26;
        ConstraintLayout.LayoutParams r10 = (ConstraintLayout.LayoutParams) r4;
        if (r7 != 0) goto L24;
        r10.width = r2;
        r10.constrainedWidth = r9;
        return;
    L24:
        r10.height = r2;
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
        r12.add(81, r9);
        return;
    L44:
        return;
    L11:
        if (r8 == (-3)) goto L15;
        if (r8 != (-2)) goto L14;
    L18:
        r2 = r8;
        r9 = false;
        goto L20
    L14:
        if (r8 == (-1)) goto L18;
    L15:
        r9 = false;
        goto L20
    L17:
        r8 = r5.getDimensionPixelSize(r6, 0);
        goto L18
    L38:
        parseDimensionConstraintsString(r4, r5.getString(r6), r7);
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
        if (r13.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST) == false) goto L12;
        r1 = 0;
    L14:
        r4 = r3 + 1;
        goto L15
    L12:
        if (r13.equalsIgnoreCase(DateFormat.HOUR24) == false) goto L14;
        r1 = 1;
    L34:
        r8.dimensionRatio = r9;
        r8.mDimensionRatioValue = r0;
        r8.mDimensionRatioSide = r1;
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
        r10.width = 0;
    L18:
        parseDimensionRatioString(r10, r9);
        return;
    L17:
        r10.height = 0;
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
        r12.width = 0;     // Catch: NumberFormatException -> L67
        r12.horizontalWeight = r11;     // Catch: NumberFormatException -> L67
    L68:
        return;
    L32:
        r12.height = 0;     // Catch: NumberFormatException -> L67
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
        r16.width = 0;     // Catch: NumberFormatException -> L67
        r16.matchConstraintPercentWidth = r15;     // Catch: NumberFormatException -> L67
        r16.matchConstraintDefaultWidth = 2;     // Catch: NumberFormatException -> L67
        goto L68
    L53:
        r16.height = 0;     // Catch: NumberFormatException -> L67
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

    public String[] getStateLabels() {
        String[] r1 = this.mMatchLabels;
        return (String[]) Arrays.copyOf(r1, r1.length);
    }

    public void setStateLabels(String r3) {
        this.mMatchLabels = r3.split(",");
        int r4 = 0;
    L3:
        String[] r0 = this.mMatchLabels;
        if (r4 >= r0.length) goto L6;
        r0[r4] = r0[r4].trim();
        r4 = r4 + 1;
        goto L3
    }

    public void setStateLabelsList(String... r3) {
        this.mMatchLabels = r3;
        int r4 = 0;
    L3:
        String[] r0 = this.mMatchLabels;
        if (r4 >= r0.length) goto L6;
        r0[r4] = r0[r4].trim();
        r4 = r4 + 1;
        goto L3
    }

    public boolean matchesLabels(String... r10) {
        int r0 = r10.length;
        int r2 = 0;
    L3:
        boolean r3 = true;
        if (r2 >= r0) goto L15;
        String r4 = r10[r2];
        String[] r5 = this.mMatchLabels;
        int r6 = r5.length;
        int r7 = 0;
    L6:
        if (r7 >= r6) goto L11;
        if (r5[r7].equals(r4) == true) goto L12;
        r7 = r7 + 1;
    L12:
        if (r3 == false) goto L13;
        r2 = r2 + 1;
        goto L3
    L13:
        return false;
    L11:
        r3 = false;
        goto L12
    L15:
        return true;
    }

    public void clone(Context r2, int r3) {
        clone((ConstraintLayout) LayoutInflater.from(r2).inflate(r3, null));
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

    public void applyTo(ConstraintLayout r2) {
        applyToInternal(r2, true);
        r2.setConstraintSet(null);
        r2.requestLayout();
    }

    public void applyToWithoutCustom(ConstraintLayout r2) {
        applyToInternal(r2, false);
        r2.setConstraintSet(null);
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

    public void applyToLayoutParams(int r3, ConstraintLayout.LayoutParams r4) {
        if (this.mConstraints.containsKey(Integer.valueOf(r3)) == false) goto L8;
        Constraint r2 = this.mConstraints.get(Integer.valueOf(r3));
        if (r2 == null) goto L9;
        r2.applyTo(r4);
        return;
    L9:
        return;
    }

    void applyToInternal(ConstraintLayout r12, boolean r13) {
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
        if (r13 == false) goto L32;
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
        float r14 = r11 - r5.getLeft();
        float r15 = r10 - r5.getTop();
        r5.setPivotX(r14);
        r5.setPivotY(r15);
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
        Iterator r16 = r1.iterator();
    L57:
        if (r16.hasNext() == false) goto L73;
        Integer r17 = (Integer) r16.next();
        Constraint r18 = this.mConstraints.get(r17);
        if (r18 == null) goto L57;
        if (r18.layout.mHelperType != 1) goto L71;
        Barrier r19 = new Barrier(r12.getContext());
        r19.setId(r17.intValue());
        if (r18.layout.mReferenceIds == null) goto L67;
        r19.setReferencedIds(r18.layout.mReferenceIds);
    L69:
        r19.setType(r18.layout.mBarrierDirection);
        r19.setMargin(r18.layout.mBarrierMargin);
        ConstraintLayout.LayoutParams r20 = r12.generateDefaultLayoutParams();
        r19.validateParams();
        r18.applyTo(r20);
        r12.addView(r19, r20);
        goto L71
    L67:
        if (r18.layout.mReferenceIdString == null) goto L69;
        r18.layout.mReferenceIds = convertReferenceString(r19, r18.layout.mReferenceIdString);
        r19.setReferencedIds(r18.layout.mReferenceIds);
    L71:
        if (r18.layout.mIsGuideline == false) goto L57;
        Guideline r21 = new Guideline(r12.getContext());
        r21.setId(r17.intValue());
        ConstraintLayout.LayoutParams r22 = r12.generateDefaultLayoutParams();
        r18.applyTo(r22);
        r12.addView(r21, r22);
    L73:
        if (r2 >= r0) goto L78;
        View r110 = r12.getChildAt(r2);
        if ((r110 instanceof ConstraintHelper) == false) goto L77;
        ((ConstraintHelper) r110).applyLayoutFeaturesInConstraintSet(r12);
    L77:
        r2 = r2 + 1;
        goto L73
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

    public void createHorizontalChain(int r11, int r12, int r13, int r14, int[] r15, float[] r16, int r17) {
        createHorizontalChain(r11, r12, r13, r14, r15, r16, r17, 1, 2);
    }

    public void createHorizontalChainRtl(int r11, int r12, int r13, int r14, int[] r15, float[] r16, int r17) {
        createHorizontalChain(r11, r12, r13, r14, r15, r16, r17, 6, 7);
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
            default: goto L11;
        };
    L12:
        if (r13 != 7) goto L14;
        r15.layout.endToEnd = r12;
        r15.layout.endToStart = -1;
    L16:
        r15.layout.endMargin = r14;
        return;
    L14:
        if (r13 != 6) goto L18;
        r15.layout.endToStart = r12;
        r15.layout.endToEnd = -1;
        goto L16
    L18:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L19:
        if (r13 != 6) goto L21;
        r15.layout.startToStart = r12;
        r15.layout.startToEnd = -1;
    L23:
        r15.layout.startMargin = r14;
        return;
    L21:
        if (r13 != 7) goto L25;
        r15.layout.startToEnd = r12;
        r15.layout.startToStart = -1;
        goto L23
    L25:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L35:
        if (r13 != 4) goto L37;
        r15.layout.bottomToBottom = r12;
        r15.layout.bottomToTop = -1;
        r15.layout.baselineToBaseline = -1;
        r15.layout.baselineToTop = -1;
        r15.layout.baselineToBottom = -1;
    L39:
        r15.layout.bottomMargin = r14;
        return;
    L37:
        if (r13 != 3) goto L41;
        r15.layout.bottomToTop = r12;
        r15.layout.bottomToBottom = -1;
        r15.layout.baselineToBaseline = -1;
        r15.layout.baselineToTop = -1;
        r15.layout.baselineToBottom = -1;
        goto L39
    L41:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L42:
        if (r13 != 3) goto L44;
        r15.layout.topToTop = r12;
        r15.layout.topToBottom = -1;
        r15.layout.baselineToBaseline = -1;
        r15.layout.baselineToTop = -1;
        r15.layout.baselineToBottom = -1;
    L46:
        r15.layout.topMargin = r14;
        return;
    L44:
        if (r13 != 4) goto L48;
        r15.layout.topToBottom = r12;
        r15.layout.topToTop = -1;
        r15.layout.baselineToBaseline = -1;
        r15.layout.baselineToTop = -1;
        r15.layout.baselineToBottom = -1;
        goto L46
    L48:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L49:
        if (r13 != 1) goto L51;
        r15.layout.rightToLeft = r12;
        r15.layout.rightToRight = -1;
    L53:
        r15.layout.rightMargin = r14;
        return;
    L51:
        if (r13 != 2) goto L55;
        r15.layout.rightToRight = r12;
        r15.layout.rightToLeft = -1;
        goto L53
    L55:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L56:
        if (r13 != 1) goto L58;
        r15.layout.leftToLeft = r12;
        r15.layout.leftToRight = -1;
    L60:
        r15.layout.leftMargin = r14;
        return;
    L58:
        if (r13 != 2) goto L63;
        r15.layout.leftToRight = r12;
        r15.layout.leftToLeft = -1;
        goto L60
    L63:
        throw new IllegalArgumentException("Left to " + sideToString(r13) + " undefined");
    L11:
        throw new IllegalArgumentException(sideToString(r11) + " to " + sideToString(r13) + " unknown");
    L27:
        if (r13 != 5) goto L29;
        r15.layout.baselineToBaseline = r12;
        r15.layout.bottomToBottom = -1;
        r15.layout.bottomToTop = -1;
        r15.layout.topToTop = -1;
        r15.layout.topToBottom = -1;
        return;
    L29:
        if (r13 != 3) goto L31;
        r15.layout.baselineToTop = r12;
        r15.layout.bottomToBottom = -1;
        r15.layout.bottomToTop = -1;
        r15.layout.topToTop = -1;
        r15.layout.topToBottom = -1;
        return;
    L31:
        if (r13 != 4) goto L34;
        r15.layout.baselineToBottom = r12;
        r15.layout.bottomToBottom = -1;
        r15.layout.bottomToTop = -1;
        r15.layout.topToTop = -1;
        r15.layout.topToBottom = -1;
        return;
    L34:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
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
            default: goto L11;
        };
    L12:
        if (r13 != 7) goto L14;
        r14.layout.endToEnd = r12;
        r14.layout.endToStart = -1;
        return;
    L14:
        if (r13 != 6) goto L17;
        r14.layout.endToStart = r12;
        r14.layout.endToEnd = -1;
        return;
    L17:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L18:
        if (r13 != 6) goto L20;
        r14.layout.startToStart = r12;
        r14.layout.startToEnd = -1;
        return;
    L20:
        if (r13 != 7) goto L23;
        r14.layout.startToEnd = r12;
        r14.layout.startToStart = -1;
        return;
    L23:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L33:
        if (r13 != 4) goto L35;
        r14.layout.bottomToBottom = r12;
        r14.layout.bottomToTop = -1;
        r14.layout.baselineToBaseline = -1;
        r14.layout.baselineToTop = -1;
        r14.layout.baselineToBottom = -1;
        return;
    L35:
        if (r13 != 3) goto L38;
        r14.layout.bottomToTop = r12;
        r14.layout.bottomToBottom = -1;
        r14.layout.baselineToBaseline = -1;
        r14.layout.baselineToTop = -1;
        r14.layout.baselineToBottom = -1;
        return;
    L38:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L39:
        if (r13 != 3) goto L41;
        r14.layout.topToTop = r12;
        r14.layout.topToBottom = -1;
        r14.layout.baselineToBaseline = -1;
        r14.layout.baselineToTop = -1;
        r14.layout.baselineToBottom = -1;
        return;
    L41:
        if (r13 != 4) goto L44;
        r14.layout.topToBottom = r12;
        r14.layout.topToTop = -1;
        r14.layout.baselineToBaseline = -1;
        r14.layout.baselineToTop = -1;
        r14.layout.baselineToBottom = -1;
        return;
    L44:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L45:
        if (r13 != 1) goto L47;
        r14.layout.rightToLeft = r12;
        r14.layout.rightToRight = -1;
        return;
    L47:
        if (r13 != 2) goto L50;
        r14.layout.rightToRight = r12;
        r14.layout.rightToLeft = -1;
        return;
    L50:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L51:
        if (r13 != 1) goto L53;
        r14.layout.leftToLeft = r12;
        r14.layout.leftToRight = -1;
        return;
    L53:
        if (r13 != 2) goto L57;
        r14.layout.leftToRight = r12;
        r14.layout.leftToLeft = -1;
        return;
    L57:
        throw new IllegalArgumentException("left to " + sideToString(r13) + " undefined");
    L11:
        throw new IllegalArgumentException(sideToString(r11) + " to " + sideToString(r13) + " unknown");
    L25:
        if (r13 != 5) goto L27;
        r14.layout.baselineToBaseline = r12;
        r14.layout.bottomToBottom = -1;
        r14.layout.bottomToTop = -1;
        r14.layout.topToTop = -1;
        r14.layout.topToBottom = -1;
        return;
    L27:
        if (r13 != 3) goto L29;
        r14.layout.baselineToTop = r12;
        r14.layout.bottomToBottom = -1;
        r14.layout.bottomToTop = -1;
        r14.layout.topToTop = -1;
        r14.layout.topToBottom = -1;
        return;
    L29:
        if (r13 != 4) goto L32;
        r14.layout.baselineToBottom = r12;
        r14.layout.bottomToBottom = -1;
        r14.layout.bottomToTop = -1;
        r14.layout.topToTop = -1;
        r14.layout.topToBottom = -1;
        return;
    L32:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
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

    public void setHorizontalBias(int r1, float r2) {
        get(r1).layout.horizontalBias = r2;
    }

    public void setVerticalBias(int r1, float r2) {
        get(r1).layout.verticalBias = r2;
    }

    public void setDimensionRatio(int r1, String r2) {
        get(r1).layout.dimensionRatio = r2;
    }

    public void setVisibility(int r1, int r2) {
        get(r1).propertySet.visibility = r2;
    }

    public void setVisibilityMode(int r1, int r2) {
        get(r1).propertySet.mVisibilityMode = r2;
    }

    public int getVisibilityMode(int r1) {
        return get(r1).propertySet.mVisibilityMode;
    }

    public int getVisibility(int r1) {
        return get(r1).propertySet.visibility;
    }

    public int getHeight(int r1) {
        return get(r1).layout.mHeight;
    }

    public int getWidth(int r1) {
        return get(r1).layout.mWidth;
    }

    public void setAlpha(int r1, float r2) {
        get(r1).propertySet.alpha = r2;
    }

    public boolean getApplyElevation(int r1) {
        return get(r1).transform.applyElevation;
    }

    public void setApplyElevation(int r1, boolean r2) {
        get(r1).transform.applyElevation = r2;
    }

    public void setElevation(int r2, float r3) {
        get(r2).transform.elevation = r3;
        get(r2).transform.applyElevation = true;
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

    public void setTransformPivotX(int r1, float r2) {
        get(r1).transform.transformPivotX = r2;
    }

    public void setTransformPivotY(int r1, float r2) {
        get(r1).transform.transformPivotY = r2;
    }

    public void setTransformPivot(int r1, float r2, float r3) {
        Constraint r0 = get(r1);
        r0.transform.transformPivotY = r3;
        r0.transform.transformPivotX = r2;
    }

    public void setTranslationX(int r1, float r2) {
        get(r1).transform.translationX = r2;
    }

    public void setTranslationY(int r1, float r2) {
        get(r1).transform.translationY = r2;
    }

    public void setTranslation(int r1, float r2, float r3) {
        Constraint r0 = get(r1);
        r0.transform.translationX = r2;
        r0.transform.translationY = r3;
    }

    public void setTranslationZ(int r1, float r2) {
        get(r1).transform.translationZ = r2;
    }

    public void setEditorAbsoluteX(int r1, int r2) {
        get(r1).layout.editorAbsoluteX = r2;
    }

    public void setEditorAbsoluteY(int r1, int r2) {
        get(r1).layout.editorAbsoluteY = r2;
    }

    public void setLayoutWrapBehavior(int r2, int r3) {
        if (r3 >= 0) goto L4;
        return;
    L4:
        if (r3 > 3) goto L8;
        get(r2).layout.mWrapBehavior = r3;
        return;
    }

    public void constrainHeight(int r1, int r2) {
        get(r1).layout.mHeight = r2;
    }

    public void constrainWidth(int r1, int r2) {
        get(r1).layout.mWidth = r2;
    }

    public void constrainCircle(int r1, int r2, int r3, float r4) {
        Constraint r0 = get(r1);
        r0.layout.circleConstraint = r2;
        r0.layout.circleRadius = r3;
        r0.layout.circleAngle = r4;
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

    public void constrainPercentWidth(int r1, float r2) {
        get(r1).layout.widthPercent = r2;
    }

    public void constrainPercentHeight(int r1, float r2) {
        get(r1).layout.heightPercent = r2;
    }

    public void constrainDefaultHeight(int r1, int r2) {
        get(r1).layout.heightDefault = r2;
    }

    public void constrainedWidth(int r1, boolean r2) {
        get(r1).layout.constrainedWidth = r2;
    }

    public void constrainedHeight(int r1, boolean r2) {
        get(r1).layout.constrainedHeight = r2;
    }

    public void constrainDefaultWidth(int r1, int r2) {
        get(r1).layout.widthDefault = r2;
    }

    public void setHorizontalWeight(int r1, float r2) {
        get(r1).layout.horizontalWeight = r2;
    }

    public void setVerticalWeight(int r1, float r2) {
        get(r1).layout.verticalWeight = r2;
    }

    public void setHorizontalChainStyle(int r1, int r2) {
        get(r1).layout.horizontalChainStyle = r2;
    }

    public void setVerticalChainStyle(int r1, int r2) {
        get(r1).layout.verticalChainStyle = r2;
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

    public void removeFromVerticalChain(int r10) {
        if (this.mConstraints.containsKey(Integer.valueOf(r10)) == false) goto L19;
        Constraint r0 = this.mConstraints.get(Integer.valueOf(r10));
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
        clear(r10, 3);
        clear(r10, 4);
    }

    public void removeFromHorizontalChain(int r13) {
        if (this.mConstraints.containsKey(Integer.valueOf(r13)) == false) goto L36;
        Constraint r0 = this.mConstraints.get(Integer.valueOf(r13));
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
        clear(r13, 6);
        clear(r13, 7);
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
        clear(r13, 1);
        clear(r13, 2);
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

    public void create(int r2, int r3) {
        Constraint r1 = get(r2);
        r1.layout.mIsGuideline = true;
        r1.layout.orientation = r3;
    }

    public void createBarrier(int r2, int r3, int r4, int... r5) {
        Constraint r1 = get(r2);
        r1.layout.mHelperType = 1;
        r1.layout.mBarrierDirection = r3;
        r1.layout.mBarrierMargin = r4;
        r1.layout.mIsGuideline = false;
        r1.layout.mReferenceIds = r5;
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

    public int[] getReferencedIds(int r1) {
        Constraint r0 = get(r1);
        if (r0.layout.mReferenceIds != null) goto L7;
        return new int[0];
    L7:
        return Arrays.copyOf(r0.layout.mReferenceIds, r0.layout.mReferenceIds.length);
    }

    public void setReferencedIds(int r1, int... r2) {
        get(r1).layout.mReferenceIds = r2;
    }

    public void setBarrierType(int r1, int r2) {
        get(r1).layout.mHelperType = r2;
    }

    public void removeAttribute(String r1) {
        this.mSavedAttributes.remove(r1);
    }

    public void setIntValue(int r1, String r2, int r3) {
        Constraint.access$900(get(r1), r2, r3);
    }

    public void setColorValue(int r1, String r2, int r3) {
        Constraint.access$1000(get(r1), r2, r3);
    }

    public void setFloatValue(int r1, String r2, float r3) {
        Constraint.access$1100(get(r1), r2, r3);
    }

    public void setStringValue(int r1, String r2, String r3) {
        Constraint.access$1200(get(r1), r2, r3);
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

    public void addIntAttributes(String... r2) {
        addAttributes(ConstraintAttribute.AttributeType.INT_TYPE, r2);
    }

    public void addColorAttributes(String... r2) {
        addAttributes(ConstraintAttribute.AttributeType.COLOR_TYPE, r2);
    }

    public void addFloatAttributes(String... r2) {
        addAttributes(ConstraintAttribute.AttributeType.FLOAT_TYPE, r2);
    }

    public void addStringAttributes(String... r2) {
        addAttributes(ConstraintAttribute.AttributeType.STRING_TYPE, r2);
    }

    private Constraint get(int r4) {
        if (this.mConstraints.containsKey(Integer.valueOf(r4)) == true) goto L6;
        this.mConstraints.put(Integer.valueOf(r4), new Constraint());
    L6:
        return this.mConstraints.get(Integer.valueOf(r4));
    }

    public void load(Context r8, int r9) {
        XmlResourceParser r2 = r8.getResources().getXml(r9);
        int r3 = r2.getEventType();     // Catch: IOException -> L15 XmlPullParserException -> L17
    L5:
        if (r3 == 1) goto L27;
        if (r3 != 2) goto L13;
        String r4 = r2.getName();     // Catch: IOException -> L15 XmlPullParserException -> L17
        Constraint r5 = fillFromAttributeList(r8, Xml.asAttributeSet(r2), false);     // Catch: IOException -> L15 XmlPullParserException -> L17
        if (r4.equalsIgnoreCase("Guideline") == false) goto L12;
        r5.layout.mIsGuideline = true;     // Catch: IOException -> L15 XmlPullParserException -> L17
    L12:
        this.mConstraints.put(Integer.valueOf(r5.mViewId), r5);     // Catch: IOException -> L15 XmlPullParserException -> L17
    L13:
        r3 = r2.next();     // Catch: IOException -> L15 XmlPullParserException -> L17
    L27:
        return;
    L15:
        e = move-exception;
        Log.e(TAG, "Error parsing resource: " + r9, e);
        return;
    L17:
        e = move-exception;
        Log.e(TAG, "Error parsing resource: " + r9, e);
    }

    public void load(Context r12, XmlPullParser r13) {
        int r2 = r13.getEventType();     // Catch: IOException -> L97 XmlPullParserException -> L99
        Constraint r4 = null;
    L5:
        if (r2 == 1) goto L122;
        if (r2 == 0) goto L94;
        byte r6 = -1;
        if (r2 == 2) goto L33;
        if (r2 != 3) goto L95;
        String r3 = r13.getName().toLowerCase(Locale.ROOT);     // Catch: IOException -> L97 XmlPullParserException -> L99
        switch(r3.hashCode()) {
            case -2075718416: goto L24;
            case -190376483: goto L21;
            case 426575017: goto L18;
            case 2146106725: goto L15;
            default: goto L26;
        };     // Catch: IOException -> L97 XmlPullParserException -> L99
    L26:
        if (r6 == 0) goto L32;
        if (r6 == 1) goto L31;
        if (r6 == 2) goto L31;
        if (r6 != 3) goto L95;
    L31:
        this.mConstraints.put(Integer.valueOf(r4.mViewId), r4);     // Catch: IOException -> L97 XmlPullParserException -> L99
        r4 = null;
        goto L95
    L32:
        return;
    L15:
        if (r3.equals("constraintset") == false) goto L26;
        r6 = 0;
        goto L26
    L18:
        if (r3.equals("constraintoverride") == false) goto L26;
        r6 = 2;
        goto L26
    L21:
        if (r3.equals("constraint") == false) goto L26;
        r6 = 1;
        goto L26
    L24:
        if (r3.equals("guideline") == false) goto L26;
        r6 = 3;
    L95:
        r2 = r13.next();     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L5
    L33:
        String r5 = r13.getName();     // Catch: IOException -> L97 XmlPullParserException -> L99
        switch(r5.hashCode()) {
            case -2025855158: goto L64;
            case -1984451626: goto L61;
            case -1962203927: goto L58;
            case -1269513683: goto L55;
            case -1238332596: goto L52;
            case -71750448: goto L49;
            case 366511058: goto L46;
            case 1331510167: goto L43;
            case 1791837707: goto L40;
            case 1803088381: goto L37;
            default: goto L67;
        };     // Catch: IOException -> L97 XmlPullParserException -> L99
    L67:
        switch(r6) {
            case 0: goto L92;
            case 1: goto L91;
            case 2: goto L90;
            case 3: goto L89;
            case 4: goto L85;
            case 5: goto L81;
            case 6: goto L77;
            case 7: goto L73;
            case 8: goto L69;
            case 9: goto L69;
            default: goto L95;
        };
    L69:
        if (r4 == null) goto L72;
        ConstraintAttribute.parse(r12, r13, r4.mCustomConstraints);     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L95
    L72:
        throw new RuntimeException(ERROR_MESSAGE + r13.getLineNumber());     // Catch: IOException -> L97 XmlPullParserException -> L99
    L73:
        if (r4 == null) goto L76;
        r4.motion.fillFromAttributeList(r12, Xml.asAttributeSet(r13));     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L95
    L76:
        throw new RuntimeException(ERROR_MESSAGE + r13.getLineNumber());     // Catch: IOException -> L97 XmlPullParserException -> L99
    L77:
        if (r4 == null) goto L80;
        r4.layout.fillFromAttributeList(r12, Xml.asAttributeSet(r13));     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L95
    L80:
        throw new RuntimeException(ERROR_MESSAGE + r13.getLineNumber());     // Catch: IOException -> L97 XmlPullParserException -> L99
    L81:
        if (r4 == null) goto L84;
        r4.transform.fillFromAttributeList(r12, Xml.asAttributeSet(r13));     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L95
    L84:
        throw new RuntimeException(ERROR_MESSAGE + r13.getLineNumber());     // Catch: IOException -> L97 XmlPullParserException -> L99
    L85:
        if (r4 == null) goto L88;
        r4.propertySet.fillFromAttributeList(r12, Xml.asAttributeSet(r13));     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L95
    L88:
        throw new RuntimeException(ERROR_MESSAGE + r13.getLineNumber());     // Catch: IOException -> L97 XmlPullParserException -> L99
    L89:
        Constraint r7 = fillFromAttributeList(r12, Xml.asAttributeSet(r13), false);     // Catch: IOException -> L97 XmlPullParserException -> L99
        r7.layout.mHelperType = 1;     // Catch: IOException -> L97 XmlPullParserException -> L99
    L93:
        r4 = r7;
        goto L95
    L90:
        r7 = fillFromAttributeList(r12, Xml.asAttributeSet(r13), false);     // Catch: IOException -> L97 XmlPullParserException -> L99
        r7.layout.mIsGuideline = true;     // Catch: IOException -> L97 XmlPullParserException -> L99
        r7.layout.mApply = true;     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L93
    L91:
        r7 = fillFromAttributeList(r12, Xml.asAttributeSet(r13), true);     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L93
    L92:
        r7 = fillFromAttributeList(r12, Xml.asAttributeSet(r13), false);     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L93
    L37:
        if (r5.equals("Constraint") == false) goto L67;
        r6 = 0;
        goto L67
    L40:
        if (r5.equals("CustomAttribute") == false) goto L67;
        r6 = 8;
        goto L67
    L43:
        if (r5.equals("Barrier") == false) goto L67;
        r6 = 3;
        goto L67
    L46:
        if (r5.equals("CustomMethod") == false) goto L67;
        r6 = 9;
        goto L67
    L49:
        if (r5.equals("Guideline") == false) goto L67;
        r6 = 2;
        goto L67
    L52:
        if (r5.equals("Transform") == false) goto L67;
        r6 = 5;
        goto L67
    L55:
        if (r5.equals("PropertySet") == false) goto L67;
        r6 = 4;
        goto L67
    L58:
        if (r5.equals("ConstraintOverride") == false) goto L67;
        r6 = 1;
        goto L67
    L61:
        if (r5.equals("Motion") == false) goto L67;
        r6 = 7;
        goto L67
    L64:
        if (r5.equals("Layout") == false) goto L67;
        r6 = 6;
        goto L67
    L94:
        r13.getName();     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L95
    L122:
        return;
    L97:
        e = move-exception;
        Log.e(TAG, "Error parsing XML resource", e);
        return;
    L99:
        e = move-exception;
        Log.e(TAG, "Error parsing XML resource", e);
    }

    private static int lookupID(TypedArray r1, int r2, int r3) {
        int r4 = r1.getResourceId(r2, r3);
        if (r4 == (-1)) goto L5;
        return r4;
    L5:
        return r1.getInt(r2, -1);
    }

    private Constraint fillFromAttributeList(Context r3, AttributeSet r4, boolean r5) {
        Constraint r0 = new Constraint();
        if (r5 == false) goto L5;
        int[] r1 = R.styleable.ConstraintOverride;
    L6:
        TypedArray r6 = r3.obtainStyledAttributes(r4, r1);
        populateConstraint(r0, r6, r5);
        r6.recycle();
        return r0;
    L5:
        r1 = R.styleable.Constraint;
        goto L6
    }

    public static Constraint buildDelta(Context r2, XmlPullParser r3) {
        AttributeSet r4 = Xml.asAttributeSet(r3);
        Constraint r0 = new Constraint();
        TypedArray r5 = r2.obtainStyledAttributes(r4, R.styleable.ConstraintOverride);
        populateOverride(r0, r5);
        r5.recycle();
        return r0;
    }

    private static void populateOverride(Constraint r13, TypedArray r14) {
        int r0 = r14.getIndexCount();
        Constraint.Delta r1 = new Constraint.Delta();
        r13.mDelta = r1;
        r13.motion.mApply = false;
        r13.layout.mApply = false;
        r13.propertySet.mApply = false;
        r13.transform.mApply = false;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L110;
        int r4 = r14.getIndex(r2);
        switch(sOverrideMapToConstant.get(r4)) {
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
        Log.w(TAG, "Unknown attribute 0x" + Integer.toHexString(r4) + "   " + sMapToConstant.get(r4));
    L109:
        r2 = r2 + 1;
        goto L3
    L7:
        r1.add(99, r14.getBoolean(r4, r13.layout.guidelineUseRtl));
        goto L109
    L17:
        r1.add(97, r14.getInt(r4, r13.layout.mWrapBehavior));
        goto L109
    L18:
        parseDimensionConstraints(r1, r14, r4, 1);
        goto L109
    L19:
        parseDimensionConstraints(r1, r14, r4, 0);
        goto L109
    L20:
        r1.add(94, r14.getDimensionPixelSize(r4, r13.layout.goneBaselineMargin));
        goto L109
    L21:
        r1.add(93, r14.getDimensionPixelSize(r4, r13.layout.baselineMargin));
        goto L109
    L22:
        Log.w(TAG, "unused attribute 0x" + Integer.toHexString(r4) + "   " + sMapToConstant.get(r4));
        goto L109
    L23:
        TypedValue r5 = r14.peekValue(r4);
        if (r5.type != 1) goto L29;
        r13.motion.mQuantizeInterpolatorID = r14.getResourceId(r4, -1);
        r1.add(89, r13.motion.mQuantizeInterpolatorID);
        if (r13.motion.mQuantizeInterpolatorID == (-1)) goto L109;
        r13.motion.mQuantizeInterpolatorType = -2;
        r1.add(88, r13.motion.mQuantizeInterpolatorType);
        goto L109
    L29:
        if (r5.type != 3) goto L34;
        r13.motion.mQuantizeInterpolatorString = r14.getString(r4);
        r1.add(90, r13.motion.mQuantizeInterpolatorString);
        if (r13.motion.mQuantizeInterpolatorString.indexOf(LibrarianImpl.Constants.SEPARATOR) <= 0) goto L33;
        r13.motion.mQuantizeInterpolatorID = r14.getResourceId(r4, -1);
        r1.add(89, r13.motion.mQuantizeInterpolatorID);
        r13.motion.mQuantizeInterpolatorType = -2;
        r1.add(88, r13.motion.mQuantizeInterpolatorType);
        goto L109
    L33:
        r13.motion.mQuantizeInterpolatorType = -1;
        r1.add(88, r13.motion.mQuantizeInterpolatorType);
        goto L109
    L34:
        r13.motion.mQuantizeInterpolatorType = r14.getInteger(r4, r13.motion.mQuantizeInterpolatorID);
        r1.add(88, r13.motion.mQuantizeInterpolatorType);
        goto L109
    L35:
        r1.add(85, r14.getFloat(r4, r13.motion.mQuantizeMotionPhase));
        goto L109
    L36:
        r1.add(84, r14.getInteger(r4, r13.motion.mQuantizeMotionSteps));
        goto L109
    L37:
        r1.add(83, lookupID(r14, r4, r13.transform.transformPivotTarget));
        goto L109
    L38:
        r1.add(82, r14.getInteger(r4, r13.motion.mAnimateCircleAngleTo));
        goto L109
    L39:
        r1.add(81, r14.getBoolean(r4, r13.layout.constrainedHeight));
        goto L109
    L40:
        r1.add(80, r14.getBoolean(r4, r13.layout.constrainedWidth));
        goto L109
    L41:
        r1.add(79, r14.getFloat(r4, r13.motion.mMotionStagger));
        goto L109
    L42:
        r1.add(78, r14.getInt(r4, r13.propertySet.mVisibilityMode));
        goto L109
    L43:
        r1.add(77, r14.getString(r4));
        goto L109
    L44:
        r1.add(76, r14.getInt(r4, r13.motion.mPathMotionArc));
        goto L109
    L45:
        r1.add(75, r14.getBoolean(r4, r13.layout.mBarrierAllowsGoneWidgets));
        goto L109
    L46:
        r1.add(74, r14.getString(r4));
        goto L109
    L47:
        r1.add(73, r14.getDimensionPixelSize(r4, r13.layout.mBarrierMargin));
        goto L109
    L48:
        r1.add(72, r14.getInt(r4, r13.layout.mBarrierDirection));
        goto L109
    L49:
        Log.e(TAG, "CURRENTLY UNSUPPORTED");
        goto L109
    L50:
        r1.add(70, r14.getFloat(r4, 1.0f));
        goto L109
    L51:
        r1.add(69, r14.getFloat(r4, 1.0f));
        goto L109
    L52:
        r1.add(68, r14.getFloat(r4, r13.propertySet.mProgress));
        goto L109
    L53:
        r1.add(67, r14.getFloat(r4, r13.motion.mPathRotate));
        goto L109
    L54:
        r1.add(66, r14.getInt(r4, 0));
        goto L109
    L59:
        r1.add(64, lookupID(r14, r4, r13.motion.mAnimateRelativeTo));
        goto L109
    L60:
        r1.add(63, r14.getFloat(r4, r13.layout.circleAngle));
        goto L109
    L61:
        r1.add(62, r14.getDimensionPixelSize(r4, r13.layout.circleRadius));
        goto L109
    L62:
        r1.add(60, r14.getFloat(r4, r13.transform.rotation));
        goto L109
    L63:
        r1.add(59, r14.getDimensionPixelSize(r4, r13.layout.heightMin));
        goto L109
    L64:
        r1.add(58, r14.getDimensionPixelSize(r4, r13.layout.widthMin));
        goto L109
    L65:
        r1.add(57, r14.getDimensionPixelSize(r4, r13.layout.heightMax));
        goto L109
    L66:
        r1.add(56, r14.getDimensionPixelSize(r4, r13.layout.widthMax));
        goto L109
    L67:
        r1.add(55, r14.getInt(r4, r13.layout.heightDefault));
        goto L109
    L68:
        r1.add(54, r14.getInt(r4, r13.layout.widthDefault));
        goto L109
    L69:
        r1.add(53, r14.getDimension(r4, r13.transform.translationZ));
        goto L109
    L70:
        r1.add(52, r14.getDimension(r4, r13.transform.translationY));
        goto L109
    L71:
        r1.add(51, r14.getDimension(r4, r13.transform.translationX));
        goto L109
    L72:
        r1.add(50, r14.getDimension(r4, r13.transform.transformPivotY));
        goto L109
    L73:
        r1.add(49, r14.getDimension(r4, r13.transform.transformPivotX));
        goto L109
    L74:
        r1.add(48, r14.getFloat(r4, r13.transform.scaleY));
        goto L109
    L75:
        r1.add(47, r14.getFloat(r4, r13.transform.scaleX));
        goto L109
    L76:
        r1.add(46, r14.getFloat(r4, r13.transform.rotationY));
        goto L109
    L77:
        r1.add(45, r14.getFloat(r4, r13.transform.rotationX));
        goto L109
    L78:
        r1.add(44, true);
        r1.add(44, r14.getDimension(r4, r13.transform.elevation));
        goto L109
    L79:
        r1.add(43, r14.getFloat(r4, r13.propertySet.alpha));
        goto L109
    L80:
        r1.add(42, r14.getInt(r4, r13.layout.verticalChainStyle));
        goto L109
    L81:
        r1.add(41, r14.getInt(r4, r13.layout.horizontalChainStyle));
        goto L109
    L82:
        r1.add(40, r14.getFloat(r4, r13.layout.verticalWeight));
        goto L109
    L83:
        r1.add(39, r14.getFloat(r4, r13.layout.horizontalWeight));
        goto L109
    L84:
        r13.mViewId = r14.getResourceId(r4, r13.mViewId);
        r1.add(38, r13.mViewId);
        goto L109
    L85:
        r1.add(37, r14.getFloat(r4, r13.layout.verticalBias));
        goto L109
    L86:
        r1.add(34, r14.getDimensionPixelSize(r4, r13.layout.topMargin));
        goto L109
    L87:
        r1.add(31, r14.getDimensionPixelSize(r4, r13.layout.startMargin));
        goto L109
    L88:
        r1.add(28, r14.getDimensionPixelSize(r4, r13.layout.rightMargin));
        goto L109
    L89:
        r1.add(27, r14.getInt(r4, r13.layout.orientation));
        goto L109
    L90:
        r1.add(24, r14.getDimensionPixelSize(r4, r13.layout.leftMargin));
        goto L109
    L91:
        r1.add(23, r14.getLayoutDimension(r4, r13.layout.mWidth));
        goto L109
    L92:
        r1.add(22, VISIBILITY_FLAGS[r14.getInt(r4, r13.propertySet.visibility)]);
        goto L109
    L93:
        r1.add(21, r14.getLayoutDimension(r4, r13.layout.mHeight));
        goto L109
    L94:
        r1.add(20, r14.getFloat(r4, r13.layout.horizontalBias));
        goto L109
    L95:
        r1.add(19, r14.getFloat(r4, r13.layout.guidePercent));
        goto L109
    L96:
        r1.add(18, r14.getDimensionPixelOffset(r4, r13.layout.guideEnd));
        goto L109
    L97:
        r1.add(17, r14.getDimensionPixelOffset(r4, r13.layout.guideBegin));
        goto L109
    L98:
        r1.add(16, r14.getDimensionPixelSize(r4, r13.layout.goneTopMargin));
        goto L109
    L99:
        r1.add(15, r14.getDimensionPixelSize(r4, r13.layout.goneStartMargin));
        goto L109
    L100:
        r1.add(14, r14.getDimensionPixelSize(r4, r13.layout.goneRightMargin));
        goto L109
    L101:
        r1.add(13, r14.getDimensionPixelSize(r4, r13.layout.goneLeftMargin));
        goto L109
    L102:
        r1.add(12, r14.getDimensionPixelSize(r4, r13.layout.goneEndMargin));
        goto L109
    L103:
        r1.add(11, r14.getDimensionPixelSize(r4, r13.layout.goneBottomMargin));
        goto L109
    L104:
        r1.add(8, r14.getDimensionPixelSize(r4, r13.layout.endMargin));
        goto L109
    L105:
        r1.add(7, r14.getDimensionPixelOffset(r4, r13.layout.editorAbsoluteY));
        goto L109
    L106:
        r1.add(6, r14.getDimensionPixelOffset(r4, r13.layout.editorAbsoluteX));
        goto L109
    L107:
        r1.add(5, r14.getString(r4));
        goto L109
    L108:
        r1.add(2, r14.getDimensionPixelSize(r4, r13.layout.bottomMargin));
        goto L109
    L9:
        if (MotionLayout.IS_IN_EDIT_MODE == false) goto L14;
        r13.mViewId = r14.getResourceId(r4, r13.mViewId);
        if (r13.mViewId != (-1)) goto L109;
        r13.mTargetString = r14.getString(r4);
        goto L109
    L14:
        if (r14.peekValue(r4).type != 3) goto L16;
        r13.mTargetString = r14.getString(r4);
        goto L109
    L16:
        r13.mViewId = r14.getResourceId(r4, r13.mViewId);
        goto L109
    L56:
        if (r14.peekValue(r4).type != 3) goto L58;
        r1.add(65, r14.getString(r4));
        goto L109
    L58:
        r1.add(65, Easing.NAMED_EASING[r14.getInteger(r4, 0)]);
        goto L109
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
        r1.transform.elevation = r3;
        r1.transform.applyElevation = true;
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
        r1.layout.mReferenceIdString = r3;
        r1.layout.mReferenceIds = null;
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

    private void populateConstraint(Constraint r9, TypedArray r10, boolean r11) {
        if (r11 == false) goto L5;
        populateOverride(r9, r10);
        return;
    L5:
        int r8 = r10.getIndexCount();
        int r0 = 0;
    L6:
        if (r0 >= r8) goto L127;
        int r1 = r10.getIndex(r0);
        if (r1 == R.styleable.Constraint_android_id) goto L15;
        if (R.styleable.Constraint_android_layout_marginStart == r1) goto L15;
        if (R.styleable.Constraint_android_layout_marginEnd == r1) goto L15;
        r9.motion.mApply = true;
        r9.layout.mApply = true;
        r9.propertySet.mApply = true;
        r9.transform.mApply = true;
    L15:
        switch(sMapToConstant.get(r1)) {
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
        Log.w(TAG, "Unknown attribute 0x" + Integer.toHexString(r1) + "   " + sMapToConstant.get(r1));
    L125:
        r0 = r0 + 1;
        goto L6
    L17:
        r9.layout.mWrapBehavior = r10.getInt(r1, r9.layout.mWrapBehavior);
        goto L125
    L18:
        parseDimensionConstraints(r9.layout, r10, r1, 1);
        goto L125
    L19:
        parseDimensionConstraints(r9.layout, r10, r1, 0);
        goto L125
    L20:
        r9.layout.goneBaselineMargin = r10.getDimensionPixelSize(r1, r9.layout.goneBaselineMargin);
        goto L125
    L21:
        r9.layout.baselineMargin = r10.getDimensionPixelSize(r1, r9.layout.baselineMargin);
        goto L125
    L22:
        r9.layout.baselineToBottom = lookupID(r10, r1, r9.layout.baselineToBottom);
        goto L125
    L23:
        r9.layout.baselineToTop = lookupID(r10, r1, r9.layout.baselineToTop);
        goto L125
    L24:
        Log.w(TAG, "unused attribute 0x" + Integer.toHexString(r1) + "   " + sMapToConstant.get(r1));
        goto L125
    L25:
        TypedValue r2 = r10.peekValue(r1);
        if (r2.type != 1) goto L31;
        r9.motion.mQuantizeInterpolatorID = r10.getResourceId(r1, -1);
        if (r9.motion.mQuantizeInterpolatorID == (-1)) goto L125;
        r9.motion.mQuantizeInterpolatorType = -2;
        goto L125
    L31:
        if (r2.type != 3) goto L36;
        r9.motion.mQuantizeInterpolatorString = r10.getString(r1);
        if (r9.motion.mQuantizeInterpolatorString.indexOf(LibrarianImpl.Constants.SEPARATOR) <= 0) goto L35;
        r9.motion.mQuantizeInterpolatorID = r10.getResourceId(r1, -1);
        r9.motion.mQuantizeInterpolatorType = -2;
        goto L125
    L35:
        r9.motion.mQuantizeInterpolatorType = -1;
        goto L125
    L36:
        r9.motion.mQuantizeInterpolatorType = r10.getInteger(r1, r9.motion.mQuantizeInterpolatorID);
        goto L125
    L37:
        r9.motion.mQuantizeMotionPhase = r10.getFloat(r1, r9.motion.mQuantizeMotionPhase);
        goto L125
    L38:
        r9.motion.mQuantizeMotionSteps = r10.getInteger(r1, r9.motion.mQuantizeMotionSteps);
        goto L125
    L39:
        r9.transform.transformPivotTarget = lookupID(r10, r1, r9.transform.transformPivotTarget);
        goto L125
    L40:
        r9.motion.mAnimateCircleAngleTo = r10.getInteger(r1, r9.motion.mAnimateCircleAngleTo);
        goto L125
    L41:
        r9.layout.constrainedHeight = r10.getBoolean(r1, r9.layout.constrainedHeight);
        goto L125
    L42:
        r9.layout.constrainedWidth = r10.getBoolean(r1, r9.layout.constrainedWidth);
        goto L125
    L43:
        r9.motion.mMotionStagger = r10.getFloat(r1, r9.motion.mMotionStagger);
        goto L125
    L44:
        r9.propertySet.mVisibilityMode = r10.getInt(r1, r9.propertySet.mVisibilityMode);
        goto L125
    L45:
        r9.layout.mConstraintTag = r10.getString(r1);
        goto L125
    L46:
        r9.motion.mPathMotionArc = r10.getInt(r1, r9.motion.mPathMotionArc);
        goto L125
    L47:
        r9.layout.mBarrierAllowsGoneWidgets = r10.getBoolean(r1, r9.layout.mBarrierAllowsGoneWidgets);
        goto L125
    L48:
        r9.layout.mReferenceIdString = r10.getString(r1);
        goto L125
    L49:
        r9.layout.mBarrierMargin = r10.getDimensionPixelSize(r1, r9.layout.mBarrierMargin);
        goto L125
    L50:
        r9.layout.mBarrierDirection = r10.getInt(r1, r9.layout.mBarrierDirection);
        goto L125
    L51:
        Log.e(TAG, "CURRENTLY UNSUPPORTED");
        goto L125
    L52:
        r9.layout.heightPercent = r10.getFloat(r1, 1.0f);
        goto L125
    L53:
        r9.layout.widthPercent = r10.getFloat(r1, 1.0f);
        goto L125
    L54:
        r9.propertySet.mProgress = r10.getFloat(r1, r9.propertySet.mProgress);
        goto L125
    L55:
        r9.motion.mPathRotate = r10.getFloat(r1, r9.motion.mPathRotate);
        goto L125
    L56:
        r9.motion.mDrawPath = r10.getInt(r1, 0);
        goto L125
    L61:
        r9.motion.mAnimateRelativeTo = lookupID(r10, r1, r9.motion.mAnimateRelativeTo);
        goto L125
    L62:
        r9.layout.circleAngle = r10.getFloat(r1, r9.layout.circleAngle);
        goto L125
    L63:
        r9.layout.circleRadius = r10.getDimensionPixelSize(r1, r9.layout.circleRadius);
        goto L125
    L64:
        r9.layout.circleConstraint = lookupID(r10, r1, r9.layout.circleConstraint);
        goto L125
    L65:
        r9.transform.rotation = r10.getFloat(r1, r9.transform.rotation);
        goto L125
    L66:
        r9.layout.heightMin = r10.getDimensionPixelSize(r1, r9.layout.heightMin);
        goto L125
    L67:
        r9.layout.widthMin = r10.getDimensionPixelSize(r1, r9.layout.widthMin);
        goto L125
    L68:
        r9.layout.heightMax = r10.getDimensionPixelSize(r1, r9.layout.heightMax);
        goto L125
    L69:
        r9.layout.widthMax = r10.getDimensionPixelSize(r1, r9.layout.widthMax);
        goto L125
    L70:
        r9.layout.heightDefault = r10.getInt(r1, r9.layout.heightDefault);
        goto L125
    L71:
        r9.layout.widthDefault = r10.getInt(r1, r9.layout.widthDefault);
        goto L125
    L72:
        r9.transform.translationZ = r10.getDimension(r1, r9.transform.translationZ);
        goto L125
    L73:
        r9.transform.translationY = r10.getDimension(r1, r9.transform.translationY);
        goto L125
    L74:
        r9.transform.translationX = r10.getDimension(r1, r9.transform.translationX);
        goto L125
    L75:
        r9.transform.transformPivotY = r10.getDimension(r1, r9.transform.transformPivotY);
        goto L125
    L76:
        r9.transform.transformPivotX = r10.getDimension(r1, r9.transform.transformPivotX);
        goto L125
    L77:
        r9.transform.scaleY = r10.getFloat(r1, r9.transform.scaleY);
        goto L125
    L78:
        r9.transform.scaleX = r10.getFloat(r1, r9.transform.scaleX);
        goto L125
    L79:
        r9.transform.rotationY = r10.getFloat(r1, r9.transform.rotationY);
        goto L125
    L80:
        r9.transform.rotationX = r10.getFloat(r1, r9.transform.rotationX);
        goto L125
    L81:
        r9.transform.applyElevation = true;
        r9.transform.elevation = r10.getDimension(r1, r9.transform.elevation);
        goto L125
    L82:
        r9.propertySet.alpha = r10.getFloat(r1, r9.propertySet.alpha);
        goto L125
    L83:
        r9.layout.verticalChainStyle = r10.getInt(r1, r9.layout.verticalChainStyle);
        goto L125
    L84:
        r9.layout.horizontalChainStyle = r10.getInt(r1, r9.layout.horizontalChainStyle);
        goto L125
    L85:
        r9.layout.verticalWeight = r10.getFloat(r1, r9.layout.verticalWeight);
        goto L125
    L86:
        r9.layout.horizontalWeight = r10.getFloat(r1, r9.layout.horizontalWeight);
        goto L125
    L87:
        r9.mViewId = r10.getResourceId(r1, r9.mViewId);
        goto L125
    L88:
        r9.layout.verticalBias = r10.getFloat(r1, r9.layout.verticalBias);
        goto L125
    L89:
        r9.layout.topToTop = lookupID(r10, r1, r9.layout.topToTop);
        goto L125
    L90:
        r9.layout.topToBottom = lookupID(r10, r1, r9.layout.topToBottom);
        goto L125
    L91:
        r9.layout.topMargin = r10.getDimensionPixelSize(r1, r9.layout.topMargin);
        goto L125
    L92:
        r9.layout.startToStart = lookupID(r10, r1, r9.layout.startToStart);
        goto L125
    L93:
        r9.layout.startToEnd = lookupID(r10, r1, r9.layout.startToEnd);
        goto L125
    L94:
        r9.layout.startMargin = r10.getDimensionPixelSize(r1, r9.layout.startMargin);
        goto L125
    L95:
        r9.layout.rightToRight = lookupID(r10, r1, r9.layout.rightToRight);
        goto L125
    L96:
        r9.layout.rightToLeft = lookupID(r10, r1, r9.layout.rightToLeft);
        goto L125
    L97:
        r9.layout.rightMargin = r10.getDimensionPixelSize(r1, r9.layout.rightMargin);
        goto L125
    L98:
        r9.layout.orientation = r10.getInt(r1, r9.layout.orientation);
        goto L125
    L99:
        r9.layout.leftToRight = lookupID(r10, r1, r9.layout.leftToRight);
        goto L125
    L100:
        r9.layout.leftToLeft = lookupID(r10, r1, r9.layout.leftToLeft);
        goto L125
    L101:
        r9.layout.leftMargin = r10.getDimensionPixelSize(r1, r9.layout.leftMargin);
        goto L125
    L102:
        r9.layout.mWidth = r10.getLayoutDimension(r1, r9.layout.mWidth);
        goto L125
    L103:
        r9.propertySet.visibility = r10.getInt(r1, r9.propertySet.visibility);
        r9.propertySet.visibility = VISIBILITY_FLAGS[r9.propertySet.visibility];
        goto L125
    L104:
        r9.layout.mHeight = r10.getLayoutDimension(r1, r9.layout.mHeight);
        goto L125
    L105:
        r9.layout.horizontalBias = r10.getFloat(r1, r9.layout.horizontalBias);
        goto L125
    L106:
        r9.layout.guidePercent = r10.getFloat(r1, r9.layout.guidePercent);
        goto L125
    L107:
        r9.layout.guideEnd = r10.getDimensionPixelOffset(r1, r9.layout.guideEnd);
        goto L125
    L108:
        r9.layout.guideBegin = r10.getDimensionPixelOffset(r1, r9.layout.guideBegin);
        goto L125
    L109:
        r9.layout.goneTopMargin = r10.getDimensionPixelSize(r1, r9.layout.goneTopMargin);
        goto L125
    L110:
        r9.layout.goneStartMargin = r10.getDimensionPixelSize(r1, r9.layout.goneStartMargin);
        goto L125
    L111:
        r9.layout.goneRightMargin = r10.getDimensionPixelSize(r1, r9.layout.goneRightMargin);
        goto L125
    L112:
        r9.layout.goneLeftMargin = r10.getDimensionPixelSize(r1, r9.layout.goneLeftMargin);
        goto L125
    L113:
        r9.layout.goneEndMargin = r10.getDimensionPixelSize(r1, r9.layout.goneEndMargin);
        goto L125
    L114:
        r9.layout.goneBottomMargin = r10.getDimensionPixelSize(r1, r9.layout.goneBottomMargin);
        goto L125
    L115:
        r9.layout.endToStart = lookupID(r10, r1, r9.layout.endToStart);
        goto L125
    L116:
        r9.layout.endToEnd = lookupID(r10, r1, r9.layout.endToEnd);
        goto L125
    L117:
        r9.layout.endMargin = r10.getDimensionPixelSize(r1, r9.layout.endMargin);
        goto L125
    L118:
        r9.layout.editorAbsoluteY = r10.getDimensionPixelOffset(r1, r9.layout.editorAbsoluteY);
        goto L125
    L119:
        r9.layout.editorAbsoluteX = r10.getDimensionPixelOffset(r1, r9.layout.editorAbsoluteX);
        goto L125
    L120:
        r9.layout.dimensionRatio = r10.getString(r1);
        goto L125
    L121:
        r9.layout.bottomToTop = lookupID(r10, r1, r9.layout.bottomToTop);
        goto L125
    L122:
        r9.layout.bottomToBottom = lookupID(r10, r1, r9.layout.bottomToBottom);
        goto L125
    L123:
        r9.layout.bottomMargin = r10.getDimensionPixelSize(r1, r9.layout.bottomMargin);
        goto L125
    L124:
        r9.layout.baselineToBaseline = lookupID(r10, r1, r9.layout.baselineToBaseline);
        goto L125
    L58:
        if (r10.peekValue(r1).type != 3) goto L60;
        r9.motion.mTransitionEasing = r10.getString(r1);
        goto L125
    L60:
        r9.motion.mTransitionEasing = Easing.NAMED_EASING[r10.getInteger(r1, 0)];
        goto L125
    L127:
        if (r9.layout.mReferenceIdString == null) goto L231;
        r9.layout.mReferenceIds = null;
        return;
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

    public Constraint getConstraint(int r3) {
        if (this.mConstraints.containsKey(Integer.valueOf(r3)) == true) goto L5;
        return null;
    L5:
        return this.mConstraints.get(Integer.valueOf(r3));
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

    public void setForceId(boolean r1) {
        this.mForceId = r1;
    }

    public void setValidateOnParse(boolean r1) {
        this.mValidate = r1;
    }

    public boolean isValidateOnParse() {
        return this.mValidate;
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

    static String getLine(Context r2, int r3, XmlPullParser r4) {
        return ".(" + Debug.getName(r2, r3) + ".xml:" + r4.getLineNumber() + ") \"" + r4.getName() + "\"";
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
        Log.e(TAG, "Error accessing ConstraintSet field", e);
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

    public void writeState(Writer r4, ConstraintLayout r5, int r6) throws IOException {
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
