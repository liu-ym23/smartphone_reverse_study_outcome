package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Optimizer;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final boolean MEASURE = false;
    private static final boolean OPTIMIZE_HEIGHT_CHANGE = false;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.1.4";
    private static SharedValues sSharedValues;
    SparseArray<View> mChildrenByIds;
    private ArrayList<ConstraintHelper> mConstraintHelpers;
    protected ConstraintLayoutStates mConstraintLayoutSpec;
    private ConstraintSet mConstraintSet;
    private int mConstraintSetId;
    private ConstraintsChangedListener mConstraintsChangedListener;
    private HashMap<String, Integer> mDesignIds;
    protected boolean mDirtyHierarchy;
    private int mLastMeasureHeight;
    int mLastMeasureHeightMode;
    int mLastMeasureHeightSize;
    private int mLastMeasureWidth;
    int mLastMeasureWidthMode;
    int mLastMeasureWidthSize;
    protected ConstraintWidgetContainer mLayoutWidget;
    private int mMaxHeight;
    private int mMaxWidth;
    Measurer mMeasurer;
    private Metrics mMetrics;
    private int mMinHeight;
    private int mMinWidth;
    private int mOnMeasureHeightMeasureSpec;
    private int mOnMeasureWidthMeasureSpec;
    private int mOptimizationLevel;
    private SparseArray<ConstraintWidget> mTempMapIdToWidget;

    /* JADX INFO: renamed from: androidx.constraintlayout.widget.ConstraintLayout$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour = null;

        static {
            int[] r0 = new int[ConstraintWidget.DimensionBehaviour.values().length];
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour = r0;
            r0[ConstraintWidget.DimensionBehaviour.FIXED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[ConstraintWidget.DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[ConstraintWidget.DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int BASELINE = 5;
        public static final int BOTTOM = 4;
        public static final int CHAIN_PACKED = 2;
        public static final int CHAIN_SPREAD = 0;
        public static final int CHAIN_SPREAD_INSIDE = 1;
        public static final int CIRCLE = 8;
        public static final int END = 7;
        public static final int GONE_UNSET = Integer.MIN_VALUE;
        public static final int HORIZONTAL = 0;
        public static final int LEFT = 1;
        public static final int MATCH_CONSTRAINT = 0;
        public static final int MATCH_CONSTRAINT_PERCENT = 2;
        public static final int MATCH_CONSTRAINT_SPREAD = 0;
        public static final int MATCH_CONSTRAINT_WRAP = 1;
        public static final int PARENT_ID = 0;
        public static final int RIGHT = 2;
        public static final int START = 6;
        public static final int TOP = 3;
        public static final int UNSET = -1;
        public static final int VERTICAL = 1;
        public static final int WRAP_BEHAVIOR_HORIZONTAL_ONLY = 1;
        public static final int WRAP_BEHAVIOR_INCLUDED = 0;
        public static final int WRAP_BEHAVIOR_SKIPPED = 3;
        public static final int WRAP_BEHAVIOR_VERTICAL_ONLY = 2;
        public int baselineMargin;
        public int baselineToBaseline;
        public int baselineToBottom;
        public int baselineToTop;
        public int bottomToBottom;
        public int bottomToTop;
        public float circleAngle;
        public int circleConstraint;
        public int circleRadius;
        public boolean constrainedHeight;
        public boolean constrainedWidth;
        public String constraintTag;
        public String dimensionRatio;
        int dimensionRatioSide;
        float dimensionRatioValue;
        public int editorAbsoluteX;
        public int editorAbsoluteY;
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
        boolean heightSet;
        public boolean helped;
        public float horizontalBias;
        public int horizontalChainStyle;
        boolean horizontalDimensionFixed;
        public float horizontalWeight;
        boolean isGuideline;
        boolean isHelper;
        boolean isInPlaceholder;
        boolean isVirtualGroup;
        public int leftToLeft;
        public int leftToRight;
        public int matchConstraintDefaultHeight;
        public int matchConstraintDefaultWidth;
        public int matchConstraintMaxHeight;
        public int matchConstraintMaxWidth;
        public int matchConstraintMinHeight;
        public int matchConstraintMinWidth;
        public float matchConstraintPercentHeight;
        public float matchConstraintPercentWidth;
        boolean needsBaseline;
        public int orientation;
        int resolveGoneLeftMargin;
        int resolveGoneRightMargin;
        int resolvedGuideBegin;
        int resolvedGuideEnd;
        float resolvedGuidePercent;
        float resolvedHorizontalBias;
        int resolvedLeftToLeft;
        int resolvedLeftToRight;
        int resolvedRightToLeft;
        int resolvedRightToRight;
        public int rightToLeft;
        public int rightToRight;
        public int startToEnd;
        public int startToStart;
        public int topToBottom;
        public int topToTop;
        public float verticalBias;
        public int verticalChainStyle;
        boolean verticalDimensionFixed;
        public float verticalWeight;
        ConstraintWidget widget;
        boolean widthSet;
        public int wrapBehaviorInParent;

        private static class Table {
            public static final int ANDROID_ORIENTATION = 1;
            public static final int GUIDELINE_USE_RTL = 67;
            public static final int LAYOUT_CONSTRAINED_HEIGHT = 28;
            public static final int LAYOUT_CONSTRAINED_WIDTH = 27;
            public static final int LAYOUT_CONSTRAINT_BASELINE_CREATOR = 43;
            public static final int LAYOUT_CONSTRAINT_BASELINE_TO_BASELINE_OF = 16;
            public static final int LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF = 53;
            public static final int LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF = 52;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_CREATOR = 42;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_BOTTOM_OF = 15;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF = 14;
            public static final int LAYOUT_CONSTRAINT_CIRCLE = 2;
            public static final int LAYOUT_CONSTRAINT_CIRCLE_ANGLE = 4;
            public static final int LAYOUT_CONSTRAINT_CIRCLE_RADIUS = 3;
            public static final int LAYOUT_CONSTRAINT_DIMENSION_RATIO = 44;
            public static final int LAYOUT_CONSTRAINT_END_TO_END_OF = 20;
            public static final int LAYOUT_CONSTRAINT_END_TO_START_OF = 19;
            public static final int LAYOUT_CONSTRAINT_GUIDE_BEGIN = 5;
            public static final int LAYOUT_CONSTRAINT_GUIDE_END = 6;
            public static final int LAYOUT_CONSTRAINT_GUIDE_PERCENT = 7;
            public static final int LAYOUT_CONSTRAINT_HEIGHT = 65;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_DEFAULT = 32;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_MAX = 37;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_MIN = 36;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_PERCENT = 38;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_BIAS = 29;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_CHAINSTYLE = 47;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_WEIGHT = 45;
            public static final int LAYOUT_CONSTRAINT_LEFT_CREATOR = 39;
            public static final int LAYOUT_CONSTRAINT_LEFT_TO_LEFT_OF = 8;
            public static final int LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF = 9;
            public static final int LAYOUT_CONSTRAINT_RIGHT_CREATOR = 41;
            public static final int LAYOUT_CONSTRAINT_RIGHT_TO_LEFT_OF = 10;
            public static final int LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF = 11;
            public static final int LAYOUT_CONSTRAINT_START_TO_END_OF = 17;
            public static final int LAYOUT_CONSTRAINT_START_TO_START_OF = 18;
            public static final int LAYOUT_CONSTRAINT_TAG = 51;
            public static final int LAYOUT_CONSTRAINT_TOP_CREATOR = 40;
            public static final int LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF = 13;
            public static final int LAYOUT_CONSTRAINT_TOP_TO_TOP_OF = 12;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_BIAS = 30;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE = 48;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_WEIGHT = 46;
            public static final int LAYOUT_CONSTRAINT_WIDTH = 64;
            public static final int LAYOUT_CONSTRAINT_WIDTH_DEFAULT = 31;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MAX = 34;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MIN = 33;
            public static final int LAYOUT_CONSTRAINT_WIDTH_PERCENT = 35;
            public static final int LAYOUT_EDITOR_ABSOLUTEX = 49;
            public static final int LAYOUT_EDITOR_ABSOLUTEY = 50;
            public static final int LAYOUT_GONE_MARGIN_BASELINE = 55;
            public static final int LAYOUT_GONE_MARGIN_BOTTOM = 24;
            public static final int LAYOUT_GONE_MARGIN_END = 26;
            public static final int LAYOUT_GONE_MARGIN_LEFT = 21;
            public static final int LAYOUT_GONE_MARGIN_RIGHT = 23;
            public static final int LAYOUT_GONE_MARGIN_START = 25;
            public static final int LAYOUT_GONE_MARGIN_TOP = 22;
            public static final int LAYOUT_MARGIN_BASELINE = 54;
            public static final int LAYOUT_WRAP_BEHAVIOR_IN_PARENT = 66;
            public static final int UNUSED = 0;
            public static final SparseIntArray map = null;

            static {
                SparseIntArray r0 = new SparseIntArray();
                map = r0;
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth, 64);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight, 65);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toTopOf, 52);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBottomOf, 53);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                r0.append(R.styleable.ConstraintLayout_Layout_guidelineUseRtl, 67);
                r0.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBaseline, 55);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_marginBaseline, 54);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                SparseIntArray r1 = map;
                r1.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                r1.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                r1.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                r1.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                r1.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                r1.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                r1.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                r1.append(R.styleable.ConstraintLayout_Layout_layout_constraintTag, 51);
                r1.append(R.styleable.ConstraintLayout_Layout_layout_wrapBehaviorInParent, 66);
            }

            private Table() {
            }
        }

        public LayoutParams(int r7, int r8) {
            super(r7, r8);
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
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = Integer.MIN_VALUE;
            this.goneTopMargin = Integer.MIN_VALUE;
            this.goneRightMargin = Integer.MIN_VALUE;
            this.goneBottomMargin = Integer.MIN_VALUE;
            this.goneStartMargin = Integer.MIN_VALUE;
            this.goneEndMargin = Integer.MIN_VALUE;
            this.goneBaselineMargin = Integer.MIN_VALUE;
            this.baselineMargin = 0;
            this.widthSet = true;
            this.heightSet = true;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.wrapBehaviorInParent = 0;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = Integer.MIN_VALUE;
            this.resolveGoneRightMargin = Integer.MIN_VALUE;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
        }

        public LayoutParams(Context r11, AttributeSet r12) {
            super(r11, r12);
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
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = Integer.MIN_VALUE;
            this.goneTopMargin = Integer.MIN_VALUE;
            this.goneRightMargin = Integer.MIN_VALUE;
            this.goneBottomMargin = Integer.MIN_VALUE;
            this.goneStartMargin = Integer.MIN_VALUE;
            this.goneEndMargin = Integer.MIN_VALUE;
            this.goneBaselineMargin = Integer.MIN_VALUE;
            this.baselineMargin = 0;
            this.widthSet = true;
            this.heightSet = true;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.wrapBehaviorInParent = 0;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = Integer.MIN_VALUE;
            this.resolveGoneRightMargin = Integer.MIN_VALUE;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
            TypedArray r13 = r11.obtainStyledAttributes(r12, R.styleable.ConstraintLayout_Layout);
            int r14 = r13.getIndexCount();
            int r1 = 0;
        L3:
            if (r1 >= r14) goto L119;
            int r5 = r13.getIndex(r1);
            int r6 = Table.map.get(r5);
            switch(r6) {
                case 1: goto L117;
                case 2: goto L114;
                case 3: goto L113;
                case 4: goto L110;
                case 5: goto L109;
                case 6: goto L108;
                case 7: goto L107;
                case 8: goto L104;
                case 9: goto L101;
                case 10: goto L98;
                case 11: goto L95;
                case 12: goto L92;
                case 13: goto L89;
                case 14: goto L86;
                case 15: goto L83;
                case 16: goto L80;
                case 17: goto L77;
                case 18: goto L74;
                case 19: goto L71;
                case 20: goto L68;
                case 21: goto L67;
                case 22: goto L66;
                case 23: goto L65;
                case 24: goto L64;
                case 25: goto L63;
                case 26: goto L62;
                case 27: goto L61;
                case 28: goto L60;
                case 29: goto L59;
                case 30: goto L58;
                case 31: goto L54;
                case 32: goto L51;
                case 33: goto L123;
                case 34: goto L127;
                case 35: goto L40;
                case 36: goto L121;
                case 37: goto L125;
                case 38: goto L29;
                default: goto L6;
            };
        L6:
            switch(r6) {
                case 44: goto L28;
                case 45: goto L27;
                case 46: goto L26;
                case 47: goto L25;
                case 48: goto L24;
                case 49: goto L23;
                case 50: goto L22;
                case 51: goto L21;
                case 52: goto L18;
                case 53: goto L15;
                case 54: goto L14;
                case 55: goto L13;
                default: goto L7;
            };
        L7:
            switch(r6) {
                case 64: goto L12;
                case 65: goto L11;
                case 66: goto L10;
                case 67: goto L9;
                default: goto L118;
            };
        L9:
            this.guidelineUseRtl = r13.getBoolean(r5, this.guidelineUseRtl);
            goto L118
        L10:
            this.wrapBehaviorInParent = r13.getInt(r5, this.wrapBehaviorInParent);
            goto L118
        L11:
            ConstraintSet.parseDimensionConstraints(this, r13, r5, 1);
            this.heightSet = true;
            goto L118
        L12:
            ConstraintSet.parseDimensionConstraints(this, r13, r5, 0);
            this.widthSet = true;
        L118:
            r1 = r1 + 1;
            goto L3
        L13:
            this.goneBaselineMargin = r13.getDimensionPixelSize(r5, this.goneBaselineMargin);
            goto L118
        L14:
            this.baselineMargin = r13.getDimensionPixelSize(r5, this.baselineMargin);
            goto L118
        L15:
            int r7 = r13.getResourceId(r5, this.baselineToBottom);
            this.baselineToBottom = r7;
            if (r7 != (-1)) goto L118;
            this.baselineToBottom = r13.getInt(r5, -1);
            goto L118
        L18:
            int r8 = r13.getResourceId(r5, this.baselineToTop);
            this.baselineToTop = r8;
            if (r8 != (-1)) goto L118;
            this.baselineToTop = r13.getInt(r5, -1);
            goto L118
        L21:
            this.constraintTag = r13.getString(r5);
            goto L118
        L22:
            this.editorAbsoluteY = r13.getDimensionPixelOffset(r5, this.editorAbsoluteY);
            goto L118
        L23:
            this.editorAbsoluteX = r13.getDimensionPixelOffset(r5, this.editorAbsoluteX);
            goto L118
        L24:
            this.verticalChainStyle = r13.getInt(r5, 0);
            goto L118
        L25:
            this.horizontalChainStyle = r13.getInt(r5, 0);
            goto L118
        L26:
            this.verticalWeight = r13.getFloat(r5, this.verticalWeight);
            goto L118
        L27:
            this.horizontalWeight = r13.getFloat(r5, this.horizontalWeight);
            goto L118
        L28:
            ConstraintSet.parseDimensionRatioString(this, r13.getString(r5));
            goto L118
        L29:
            this.matchConstraintPercentHeight = Math.max(0.0f, r13.getFloat(r5, this.matchConstraintPercentHeight));
            this.matchConstraintDefaultHeight = 2;
            goto L118
        L40:
            this.matchConstraintPercentWidth = Math.max(0.0f, r13.getFloat(r5, this.matchConstraintPercentWidth));
            this.matchConstraintDefaultWidth = 2;
            goto L118
        L51:
            int r9 = r13.getInt(r5, 0);
            this.matchConstraintDefaultHeight = r9;
            if (r9 != 1) goto L118;
            String r10 = "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.";
        L57:
            Log.e(ConstraintLayout.TAG, r10);
            goto L118
        L54:
            int r15 = r13.getInt(r5, 0);
            this.matchConstraintDefaultWidth = r15;
            if (r15 != 1) goto L118;
            r10 = "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.";
            goto L57
        L58:
            this.verticalBias = r13.getFloat(r5, this.verticalBias);
            goto L118
        L59:
            this.horizontalBias = r13.getFloat(r5, this.horizontalBias);
            goto L118
        L60:
            this.constrainedHeight = r13.getBoolean(r5, this.constrainedHeight);
            goto L118
        L61:
            this.constrainedWidth = r13.getBoolean(r5, this.constrainedWidth);
            goto L118
        L62:
            this.goneEndMargin = r13.getDimensionPixelSize(r5, this.goneEndMargin);
            goto L118
        L63:
            this.goneStartMargin = r13.getDimensionPixelSize(r5, this.goneStartMargin);
            goto L118
        L64:
            this.goneBottomMargin = r13.getDimensionPixelSize(r5, this.goneBottomMargin);
            goto L118
        L65:
            this.goneRightMargin = r13.getDimensionPixelSize(r5, this.goneRightMargin);
            goto L118
        L66:
            this.goneTopMargin = r13.getDimensionPixelSize(r5, this.goneTopMargin);
            goto L118
        L67:
            this.goneLeftMargin = r13.getDimensionPixelSize(r5, this.goneLeftMargin);
            goto L118
        L68:
            int r16 = r13.getResourceId(r5, this.endToEnd);
            this.endToEnd = r16;
            if (r16 != (-1)) goto L118;
            this.endToEnd = r13.getInt(r5, -1);
            goto L118
        L71:
            int r17 = r13.getResourceId(r5, this.endToStart);
            this.endToStart = r17;
            if (r17 != (-1)) goto L118;
            this.endToStart = r13.getInt(r5, -1);
            goto L118
        L74:
            int r18 = r13.getResourceId(r5, this.startToStart);
            this.startToStart = r18;
            if (r18 != (-1)) goto L118;
            this.startToStart = r13.getInt(r5, -1);
            goto L118
        L77:
            int r19 = r13.getResourceId(r5, this.startToEnd);
            this.startToEnd = r19;
            if (r19 != (-1)) goto L118;
            this.startToEnd = r13.getInt(r5, -1);
            goto L118
        L80:
            int r20 = r13.getResourceId(r5, this.baselineToBaseline);
            this.baselineToBaseline = r20;
            if (r20 != (-1)) goto L118;
            this.baselineToBaseline = r13.getInt(r5, -1);
            goto L118
        L83:
            int r21 = r13.getResourceId(r5, this.bottomToBottom);
            this.bottomToBottom = r21;
            if (r21 != (-1)) goto L118;
            this.bottomToBottom = r13.getInt(r5, -1);
            goto L118
        L86:
            int r22 = r13.getResourceId(r5, this.bottomToTop);
            this.bottomToTop = r22;
            if (r22 != (-1)) goto L118;
            this.bottomToTop = r13.getInt(r5, -1);
            goto L118
        L89:
            int r23 = r13.getResourceId(r5, this.topToBottom);
            this.topToBottom = r23;
            if (r23 != (-1)) goto L118;
            this.topToBottom = r13.getInt(r5, -1);
            goto L118
        L92:
            int r24 = r13.getResourceId(r5, this.topToTop);
            this.topToTop = r24;
            if (r24 != (-1)) goto L118;
            this.topToTop = r13.getInt(r5, -1);
            goto L118
        L95:
            int r25 = r13.getResourceId(r5, this.rightToRight);
            this.rightToRight = r25;
            if (r25 != (-1)) goto L118;
            this.rightToRight = r13.getInt(r5, -1);
            goto L118
        L98:
            int r26 = r13.getResourceId(r5, this.rightToLeft);
            this.rightToLeft = r26;
            if (r26 != (-1)) goto L118;
            this.rightToLeft = r13.getInt(r5, -1);
            goto L118
        L101:
            int r27 = r13.getResourceId(r5, this.leftToRight);
            this.leftToRight = r27;
            if (r27 != (-1)) goto L118;
            this.leftToRight = r13.getInt(r5, -1);
            goto L118
        L104:
            int r28 = r13.getResourceId(r5, this.leftToLeft);
            this.leftToLeft = r28;
            if (r28 != (-1)) goto L118;
            this.leftToLeft = r13.getInt(r5, -1);
            goto L118
        L107:
            this.guidePercent = r13.getFloat(r5, this.guidePercent);
            goto L118
        L108:
            this.guideEnd = r13.getDimensionPixelOffset(r5, this.guideEnd);
            goto L118
        L109:
            this.guideBegin = r13.getDimensionPixelOffset(r5, this.guideBegin);
            goto L118
        L110:
            float r29 = r13.getFloat(r5, this.circleAngle) % 360.0f;
            this.circleAngle = r29;
            if (r29 >= 0.0f) goto L118;
            this.circleAngle = (360.0f - r29) % 360.0f;
            goto L118
        L113:
            this.circleRadius = r13.getDimensionPixelSize(r5, this.circleRadius);
            goto L118
        L114:
            int r30 = r13.getResourceId(r5, this.circleConstraint);
            this.circleConstraint = r30;
            if (r30 != (-1)) goto L118;
            this.circleConstraint = r13.getInt(r5, -1);
            goto L118
        L117:
            this.orientation = r13.getInt(r5, this.orientation);
            goto L118
        L121:
            this.matchConstraintMinHeight = r13.getDimensionPixelSize(r5, this.matchConstraintMinHeight);     // Catch: Exception -> L37
        L38:
            if (r13.getInt(r5, this.matchConstraintMinHeight) != (-2)) goto L118;
            this.matchConstraintMinHeight = -2;
            goto L118
        L123:
            this.matchConstraintMinWidth = r13.getDimensionPixelSize(r5, this.matchConstraintMinWidth);     // Catch: Exception -> L48
        L49:
            if (r13.getInt(r5, this.matchConstraintMinWidth) != (-2)) goto L118;
            this.matchConstraintMinWidth = -2;
            goto L118
        L125:
            this.matchConstraintMaxHeight = r13.getDimensionPixelSize(r5, this.matchConstraintMaxHeight);     // Catch: Exception -> L32
        L33:
            if (r13.getInt(r5, this.matchConstraintMaxHeight) != (-2)) goto L118;
            this.matchConstraintMaxHeight = -2;
            goto L118
        L127:
            this.matchConstraintMaxWidth = r13.getDimensionPixelSize(r5, this.matchConstraintMaxWidth);     // Catch: Exception -> L43
        L44:
            if (r13.getInt(r5, this.matchConstraintMaxWidth) != (-2)) goto L118;
            this.matchConstraintMaxWidth = -2;
            goto L118
        L119:
            r13.recycle();
            validate();
        }

        public LayoutParams(ViewGroup.LayoutParams r8) {
            super(r8);
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
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = Integer.MIN_VALUE;
            this.goneTopMargin = Integer.MIN_VALUE;
            this.goneRightMargin = Integer.MIN_VALUE;
            this.goneBottomMargin = Integer.MIN_VALUE;
            this.goneStartMargin = Integer.MIN_VALUE;
            this.goneEndMargin = Integer.MIN_VALUE;
            this.goneBaselineMargin = Integer.MIN_VALUE;
            this.baselineMargin = 0;
            this.widthSet = true;
            this.heightSet = true;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.wrapBehaviorInParent = 0;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = Integer.MIN_VALUE;
            this.resolveGoneRightMargin = Integer.MIN_VALUE;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
        }

        public LayoutParams(LayoutParams r9) {
            super(r9);
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
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = Integer.MIN_VALUE;
            this.goneTopMargin = Integer.MIN_VALUE;
            this.goneRightMargin = Integer.MIN_VALUE;
            this.goneBottomMargin = Integer.MIN_VALUE;
            this.goneStartMargin = Integer.MIN_VALUE;
            this.goneEndMargin = Integer.MIN_VALUE;
            this.goneBaselineMargin = Integer.MIN_VALUE;
            this.baselineMargin = 0;
            this.widthSet = true;
            this.heightSet = true;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.wrapBehaviorInParent = 0;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = Integer.MIN_VALUE;
            this.resolveGoneRightMargin = Integer.MIN_VALUE;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
            this.guideBegin = r9.guideBegin;
            this.guideEnd = r9.guideEnd;
            this.guidePercent = r9.guidePercent;
            this.guidelineUseRtl = r9.guidelineUseRtl;
            this.leftToLeft = r9.leftToLeft;
            this.leftToRight = r9.leftToRight;
            this.rightToLeft = r9.rightToLeft;
            this.rightToRight = r9.rightToRight;
            this.topToTop = r9.topToTop;
            this.topToBottom = r9.topToBottom;
            this.bottomToTop = r9.bottomToTop;
            this.bottomToBottom = r9.bottomToBottom;
            this.baselineToBaseline = r9.baselineToBaseline;
            this.baselineToTop = r9.baselineToTop;
            this.baselineToBottom = r9.baselineToBottom;
            this.circleConstraint = r9.circleConstraint;
            this.circleRadius = r9.circleRadius;
            this.circleAngle = r9.circleAngle;
            this.startToEnd = r9.startToEnd;
            this.startToStart = r9.startToStart;
            this.endToStart = r9.endToStart;
            this.endToEnd = r9.endToEnd;
            this.goneLeftMargin = r9.goneLeftMargin;
            this.goneTopMargin = r9.goneTopMargin;
            this.goneRightMargin = r9.goneRightMargin;
            this.goneBottomMargin = r9.goneBottomMargin;
            this.goneStartMargin = r9.goneStartMargin;
            this.goneEndMargin = r9.goneEndMargin;
            this.goneBaselineMargin = r9.goneBaselineMargin;
            this.baselineMargin = r9.baselineMargin;
            this.horizontalBias = r9.horizontalBias;
            this.verticalBias = r9.verticalBias;
            this.dimensionRatio = r9.dimensionRatio;
            this.dimensionRatioValue = r9.dimensionRatioValue;
            this.dimensionRatioSide = r9.dimensionRatioSide;
            this.horizontalWeight = r9.horizontalWeight;
            this.verticalWeight = r9.verticalWeight;
            this.horizontalChainStyle = r9.horizontalChainStyle;
            this.verticalChainStyle = r9.verticalChainStyle;
            this.constrainedWidth = r9.constrainedWidth;
            this.constrainedHeight = r9.constrainedHeight;
            this.matchConstraintDefaultWidth = r9.matchConstraintDefaultWidth;
            this.matchConstraintDefaultHeight = r9.matchConstraintDefaultHeight;
            this.matchConstraintMinWidth = r9.matchConstraintMinWidth;
            this.matchConstraintMaxWidth = r9.matchConstraintMaxWidth;
            this.matchConstraintMinHeight = r9.matchConstraintMinHeight;
            this.matchConstraintMaxHeight = r9.matchConstraintMaxHeight;
            this.matchConstraintPercentWidth = r9.matchConstraintPercentWidth;
            this.matchConstraintPercentHeight = r9.matchConstraintPercentHeight;
            this.editorAbsoluteX = r9.editorAbsoluteX;
            this.editorAbsoluteY = r9.editorAbsoluteY;
            this.orientation = r9.orientation;
            this.horizontalDimensionFixed = r9.horizontalDimensionFixed;
            this.verticalDimensionFixed = r9.verticalDimensionFixed;
            this.needsBaseline = r9.needsBaseline;
            this.isGuideline = r9.isGuideline;
            this.resolvedLeftToLeft = r9.resolvedLeftToLeft;
            this.resolvedLeftToRight = r9.resolvedLeftToRight;
            this.resolvedRightToLeft = r9.resolvedRightToLeft;
            this.resolvedRightToRight = r9.resolvedRightToRight;
            this.resolveGoneLeftMargin = r9.resolveGoneLeftMargin;
            this.resolveGoneRightMargin = r9.resolveGoneRightMargin;
            this.resolvedHorizontalBias = r9.resolvedHorizontalBias;
            this.constraintTag = r9.constraintTag;
            this.wrapBehaviorInParent = r9.wrapBehaviorInParent;
            this.widget = r9.widget;
            this.widthSet = r9.widthSet;
            this.heightSet = r9.heightSet;
        }

        public String getConstraintTag() {
            return this.constraintTag;
        }

        public ConstraintWidget getConstraintWidget() {
            return this.widget;
        }

        public void reset() {
            ConstraintWidget r0 = this.widget;
            if (r0 == null) goto L6;
            r0.reset();
            return;
        }

        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @TargetApi(17)
        public void resolveLayoutDirection(int r11) {
            int r0 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
            int r1 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
            boolean r3 = false;
            if (Build.VERSION.SDK_INT < 17) goto L7;
            super.resolveLayoutDirection(r11);
            if (1 != getLayoutDirection()) goto L7;
            boolean r12 = true;
        L8:
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolveGoneLeftMargin = this.goneLeftMargin;
            this.resolveGoneRightMargin = this.goneRightMargin;
            float r5 = this.horizontalBias;
            this.resolvedHorizontalBias = r5;
            int r6 = this.guideBegin;
            this.resolvedGuideBegin = r6;
            int r7 = this.guideEnd;
            this.resolvedGuideEnd = r7;
            float r8 = this.guidePercent;
            this.resolvedGuidePercent = r8;
            if (r12 == false) goto L46;
            int r13 = this.startToEnd;
            if (r13 == (-1)) goto L14;
            this.resolvedRightToLeft = r13;
        L13:
            r3 = true;
        L17:
            int r14 = this.endToStart;
            if (r14 == (-1)) goto L20;
            this.resolvedLeftToRight = r14;
            r3 = true;
        L20:
            int r15 = this.endToEnd;
            if (r15 == (-1)) goto L23;
            this.resolvedLeftToLeft = r15;
            r3 = true;
        L23:
            int r16 = this.goneStartMargin;
            if (r16 == Integer.MIN_VALUE) goto L26;
            this.resolveGoneRightMargin = r16;
        L26:
            int r17 = this.goneEndMargin;
            if (r17 == Integer.MIN_VALUE) goto L30;
            this.resolveGoneLeftMargin = r17;
        L30:
            if (r3 == false) goto L33;
            this.resolvedHorizontalBias = 1.0f - r5;
        L33:
            if (this.isGuideline == false) goto L65;
            if (this.orientation != 1) goto L65;
            if (this.guidelineUseRtl == false) goto L65;
            if (r8 == (-1.0f)) goto L41;
            this.resolvedGuidePercent = 1.0f - r8;
            this.resolvedGuideBegin = -1;
            this.resolvedGuideEnd = -1;
            goto L65
        L41:
            if (r6 == (-1)) goto L44;
            this.resolvedGuideEnd = r6;
            this.resolvedGuideBegin = -1;
        L43:
            this.resolvedGuidePercent = -1.0f;
            goto L65
        L44:
            if (r7 == (-1)) goto L65;
            this.resolvedGuideBegin = r7;
            this.resolvedGuideEnd = -1;
        L65:
            if (this.endToStart == (-1)) goto L67;
            return;
        L67:
            if (this.endToEnd == (-1)) goto L69;
            return;
        L69:
            if (this.startToStart == (-1)) goto L71;
            return;
        L71:
            if (this.startToEnd != (-1)) goto L99;
            int r18 = this.rightToLeft;
            if (r18 == (-1)) goto L78;
            this.resolvedRightToLeft = r18;
            if (((ViewGroup.MarginLayoutParams) this).rightMargin > 0) goto L84;
            if (r1 <= 0) goto L84;
        L77:
            ((ViewGroup.MarginLayoutParams) this).rightMargin = r1;
        L84:
            int r19 = this.leftToLeft;
            if (r19 == (-1)) goto L90;
            this.resolvedLeftToLeft = r19;
            if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0) goto L100;
            if (r0 <= 0) goto L101;
        L89:
            ((ViewGroup.MarginLayoutParams) this).leftMargin = r0;
            return;
        L101:
            return;
        L100:
            return;
        L90:
            int r110 = this.leftToRight;
            if (r110 == (-1)) goto L103;
            this.resolvedLeftToRight = r110;
            if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0) goto L104;
            if (r0 > 0) goto L89;
            return;
        L104:
            return;
        L103:
            return;
        L78:
            int r111 = this.rightToRight;
            if (r111 == (-1)) goto L84;
            this.resolvedRightToRight = r111;
            if (((ViewGroup.MarginLayoutParams) this).rightMargin > 0) goto L84;
            if (r1 <= 0) goto L84;
        L99:
            return;
        L14:
            int r112 = this.startToStart;
            if (r112 == (-1)) goto L17;
            this.resolvedRightToRight = r112;
            goto L13
        L46:
            int r113 = this.startToEnd;
            if (r113 == (-1)) goto L49;
            this.resolvedLeftToRight = r113;
        L49:
            int r114 = this.startToStart;
            if (r114 == (-1)) goto L52;
            this.resolvedLeftToLeft = r114;
        L52:
            int r115 = this.endToStart;
            if (r115 == (-1)) goto L55;
            this.resolvedRightToLeft = r115;
        L55:
            int r116 = this.endToEnd;
            if (r116 == (-1)) goto L58;
            this.resolvedRightToRight = r116;
        L58:
            int r117 = this.goneStartMargin;
            if (r117 == Integer.MIN_VALUE) goto L61;
            this.resolveGoneLeftMargin = r117;
        L61:
            int r118 = this.goneEndMargin;
            if (r118 == Integer.MIN_VALUE) goto L65;
            this.resolveGoneRightMargin = r118;
        L7:
            r12 = false;
            goto L8
        }

        public void setWidgetDebugName(String r1) {
            this.widget.setDebugName(r1);
        }

        public void validate() {
            this.isGuideline = false;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            int r2 = ((ViewGroup.MarginLayoutParams) this).width;
            if (r2 == (-2)) goto L5;
        L9:
            int r4 = ((ViewGroup.MarginLayoutParams) this).height;
            if (r4 != (-2)) goto L17;
            if (this.constrainedHeight == false) goto L17;
            this.verticalDimensionFixed = false;
            if (this.matchConstraintDefaultHeight != 0) goto L17;
            this.matchConstraintDefaultHeight = 1;
        L17:
            if (r2 == 0) goto L19;
            if (r2 == (-1)) goto L19;
        L24:
            if (r4 == 0) goto L26;
            if (r4 == (-1)) goto L26;
        L32:
            if (this.guidePercent == (-1.0f)) goto L34;
        L37:
            this.isGuideline = true;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            if ((this.widget instanceof androidx.constraintlayout.core.widgets.Guideline) == true) goto L40;
            this.widget = new androidx.constraintlayout.core.widgets.Guideline();
        L40:
            ((androidx.constraintlayout.core.widgets.Guideline) this.widget).setOrientation(this.orientation);
            return;
        L34:
            if (this.guideBegin != (-1)) goto L37;
            if (this.guideEnd != (-1)) goto L37;
            return;
        L26:
            this.verticalDimensionFixed = false;
            if (r4 != 0) goto L32;
            if (this.matchConstraintDefaultHeight != 1) goto L32;
            ((ViewGroup.MarginLayoutParams) this).height = -2;
            this.constrainedHeight = true;
        L19:
            this.horizontalDimensionFixed = false;
            if (r2 != 0) goto L24;
            if (this.matchConstraintDefaultWidth != 1) goto L24;
            ((ViewGroup.MarginLayoutParams) this).width = -2;
            this.constrainedWidth = true;
            goto L24
        L5:
            if (this.constrainedWidth == false) goto L9;
            this.horizontalDimensionFixed = false;
            if (this.matchConstraintDefaultWidth != 0) goto L9;
            this.matchConstraintDefaultWidth = 1;
            goto L9
        }
    }

    class Measurer implements BasicMeasure.Measurer {
        ConstraintLayout layout;
        int layoutHeightSpec;
        int layoutWidthSpec;
        int paddingBottom;
        int paddingHeight;
        int paddingTop;
        int paddingWidth;
        final /* synthetic */ ConstraintLayout this$0;

        public Measurer(ConstraintLayout r1, ConstraintLayout r2) {
            this.this$0 = r1;
            this.layout = r2;
        }

        private boolean isSimilarSpec(int r3, int r4, int r5) {
            if (r3 != r4) goto L5;
            return true;
        L5:
            int r0 = View.MeasureSpec.getMode(r3);
            View.MeasureSpec.getSize(r3);
            int r6 = View.MeasureSpec.getMode(r4);
            int r7 = View.MeasureSpec.getSize(r4);
            if (r6 == 1073741824) goto L8;
            return false;
        L8:
            if (r0 == Integer.MIN_VALUE) goto L10;
            if (r0 == 0) goto L10;
            return false;
        L10:
            if (r5 != r7) goto L15;
            return true;
        L15:
            return false;
        }

        public void captureLayoutInfo(int r1, int r2, int r3, int r4, int r5, int r6) {
            this.paddingTop = r3;
            this.paddingBottom = r4;
            this.paddingWidth = r5;
            this.paddingHeight = r6;
            this.layoutWidthSpec = r1;
            this.layoutHeightSpec = r2;
        }

        @Override // androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer
        public final void didMeasures() {
            int r0 = this.layout.getChildCount();
            int r1 = 0;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L8;
            View r3 = this.layout.getChildAt(r2);
            if ((r3 instanceof Placeholder) == false) goto L7;
            ((Placeholder) r3).updatePostMeasure(this.layout);
        L7:
            r2 = r2 + 1;
            goto L3
        L8:
            int r4 = ConstraintLayout.access$100(this.layout).size();
            if (r4 <= 0) goto L12;
        L10:
            if (r1 >= r4) goto L17;
            ((ConstraintHelper) ConstraintLayout.access$100(this.layout).get(r1)).updatePostMeasure(this.layout);
            r1 = r1 + 1;
            goto L10
        L17:
            return;
        }

        @Override // androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer
        @SuppressLint({"WrongCall"})
        public final void measure(ConstraintWidget r18, BasicMeasure.Measure r19) {
            if (r18 != null) goto L6;
            return;
        L6:
            if (r18.getVisibility() != 8) goto L12;
            if (r18.isInPlaceholder() == true) goto L12;
            r19.measuredWidth = 0;
            r19.measuredHeight = 0;
            r19.measuredBaseline = 0;
            return;
        L12:
            if (r18.getParent() != null) goto L14;
            return;
        L14:
            ConstraintWidget.DimensionBehaviour r3 = r19.horizontalBehavior;
            ConstraintWidget.DimensionBehaviour r4 = r19.verticalBehavior;
            int r6 = r19.horizontalDimension;
            int r7 = r19.verticalDimension;
            int r8 = this.paddingTop + this.paddingBottom;
            int r9 = this.paddingWidth;
            View r10 = (View) r18.getCompanionWidget();
            int[] r11 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour;
            int r12 = r11[r3.ordinal()];
            if (r12 == 1) goto L49;
            if (r12 == 2) goto L47;
            if (r12 == 3) goto L46;
            if (r12 == 4) goto L20;
            int r13 = 0;
        L50:
            int r14 = r11[r4.ordinal()];
            if (r14 == 1) goto L87;
            if (r14 != 2) goto L54;
            int r15 = this.layoutHeightSpec;
            int r16 = -2;
        L86:
            int r17 = ViewGroup.getChildMeasureSpec(r15, r8, r16);
        L88:
            ConstraintWidgetContainer r20 = (ConstraintWidgetContainer) r18.getParent();
            if (r20 != null) goto L91;
        L113:
            ConstraintWidget.DimensionBehaviour r21 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (r3 != r21) goto L116;
            boolean r22 = true;
        L117:
            if (r4 != r21) goto L119;
            boolean r23 = true;
        L120:
            ConstraintWidget.DimensionBehaviour r110 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            if (r4 != r110) goto L123;
        L126:
            boolean r5 = true;
        L127:
            if (r3 != r110) goto L129;
        L132:
            boolean r24 = true;
        L134:
            if (r22 == true) goto L136;
        L138:
            boolean r111 = false;
        L139:
            if (r23 == true) goto L141;
        L143:
            boolean r112 = false;
        L144:
            if (r10 != null) goto L146;
            return;
        L146:
            LayoutParams r113 = (LayoutParams) r10.getLayoutParams();
            int r114 = r19.measureStrategy;
            if (r114 == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS) goto L159;
            if (r114 == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L159;
            if (r22 == false) goto L159;
            if (r18.mMatchConstraintDefaultWidth != 0) goto L159;
            if (r23 == false) goto L159;
            if (r18.mMatchConstraintDefaultHeight != 0) goto L159;
            int r0 = -1;
            int r25 = 0;
            int r115 = 0;
            int r116 = 0;
        L198:
            if (r115 == r0) goto L200;
            boolean r26 = true;
        L202:
            if (r116 == r19.horizontalDimension) goto L204;
        L207:
            boolean r1 = true;
        L208:
            r19.measuredNeedsSolverPass = r1;
            if (r113.needsBaseline == false) goto L211;
            r26 = true;
        L211:
            if (r26 == true) goto L213;
        L217:
            r19.measuredWidth = r116;
            r19.measuredHeight = r25;
            r19.measuredHasBaseline = r26;
            r19.measuredBaseline = r115;
            return;
        L213:
            if (r115 == (-1)) goto L217;
            if (r18.getBaselineDistance() == r115) goto L217;
            r19.measuredNeedsSolverPass = true;
            goto L217
        L204:
            if (r25 != r19.verticalDimension) goto L207;
            r1 = false;
            goto L208
        L200:
            r26 = false;
        L159:
            if ((r10 instanceof VirtualLayout) == true) goto L161;
        L163:
            r10.measure(r13, r17);
        L164:
            r18.setLastMeasureSpec(r13, r17);
            int r27 = r10.getMeasuredWidth();
            int r28 = r10.getMeasuredHeight();
            r115 = r10.getBaseline();
            int r117 = r18.mMatchConstraintMinWidth;
            if (r117 <= 0) goto L167;
            r116 = Math.max(r117, r27);
        L168:
            int r29 = r18.mMatchConstraintMaxWidth;
            if (r29 <= 0) goto L171;
            r116 = Math.min(r29, r116);
        L171:
            int r30 = r18.mMatchConstraintMinHeight;
            if (r30 <= 0) goto L174;
            r25 = Math.max(r30, r28);
        L175:
            int r31 = r18.mMatchConstraintMaxHeight;
            if (r31 <= 0) goto L179;
            r25 = Math.min(r31, r25);
        L179:
            if (Optimizer.enabled(ConstraintLayout.access$000(this.this$0), 1) == false) goto L181;
        L187:
            if (r27 != r116) goto L192;
            if (r28 != r25) goto L192;
        L190:
            r0 = -1;
        L192:
            if (r27 == r116) goto L194;
            int r32 = View.MeasureSpec.makeMeasureSpec(r116, BasicMeasure.EXACTLY);
        L195:
            if (r28 == r25) goto L197;
            r17 = View.MeasureSpec.makeMeasureSpec(r25, BasicMeasure.EXACTLY);
        L197:
            r10.measure(r32, r17);
            r18.setLastMeasureSpec(r32, r17);
            r116 = r10.getMeasuredWidth();
            r25 = r10.getMeasuredHeight();
            r115 = r10.getBaseline();
            goto L190
        L194:
            r32 = r13;
            goto L195
        L181:
            if (r111 == false) goto L184;
            if (r5 == false) goto L184;
            r116 = (int) ((r25 * r18.mDimensionRatio) + 0.5f);
        L184:
            if (r112 == false) goto L187;
            if (r24 == false) goto L187;
            r25 = (int) ((r116 / r18.mDimensionRatio) + 0.5f);
            goto L187
        L174:
            r25 = r28;
            goto L175
        L167:
            r116 = r27;
            goto L168
        L161:
            if ((r18 instanceof androidx.constraintlayout.core.widgets.VirtualLayout) == false) goto L163;
            ((VirtualLayout) r10).onMeasure((androidx.constraintlayout.core.widgets.VirtualLayout) r18, r13, r17);
            goto L164
        L141:
            if (r18.mDimensionRatio <= 0.0f) goto L143;
            r112 = true;
            goto L144
        L136:
            if (r18.mDimensionRatio <= 0.0f) goto L138;
            r111 = true;
            goto L139
        L129:
            if (r3 == ConstraintWidget.DimensionBehaviour.FIXED) goto L132;
            r24 = false;
            goto L134
        L123:
            if (r4 == ConstraintWidget.DimensionBehaviour.FIXED) goto L126;
            r5 = false;
            goto L127
        L119:
            r23 = false;
            goto L120
        L116:
            r22 = false;
            goto L117
        L91:
            if (Optimizer.enabled(ConstraintLayout.access$000(this.this$0), 256) == false) goto L113;
            if (r10.getMeasuredWidth() != r18.getWidth()) goto L113;
            if (r10.getMeasuredWidth() >= r20.getWidth()) goto L113;
            if (r10.getMeasuredHeight() != r18.getHeight()) goto L113;
            if (r10.getMeasuredHeight() >= r20.getHeight()) goto L113;
            if (r10.getBaseline() != r18.getBaselineDistance()) goto L113;
            if (r18.isMeasureRequested() == true) goto L113;
            if (isSimilarSpec(r18.getLastHorizontalMeasureSpec(), r13, r18.getWidth()) == true) goto L107;
        L109:
            boolean r33 = false;
        L110:
            if (r33 == false) goto L113;
            r19.measuredWidth = r18.getWidth();
            r19.measuredHeight = r18.getHeight();
            r19.measuredBaseline = r18.getBaselineDistance();
            return;
        L107:
            if (isSimilarSpec(r18.getLastVerticalMeasureSpec(), r17, r18.getHeight()) == false) goto L109;
            r33 = true;
            goto L110
        L54:
            if (r14 != 3) goto L56;
            r15 = this.layoutHeightSpec;
            r8 = r8 + r18.getVerticalMargin();
            r16 = -1;
            goto L86
        L56:
            if (r14 == 4) goto L58;
            r17 = 0;
            goto L88
        L58:
            r17 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, r8, -2);
            if (r18.mMatchConstraintDefaultHeight != 1) goto L61;
            boolean r34 = true;
        L62:
            int r35 = r19.measureStrategy;
            if (r35 == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS) goto L67;
            if (r35 != BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L88;
        L67:
            if (r10.getMeasuredWidth() != r18.getWidth()) goto L69;
            boolean r36 = true;
        L71:
            if (r19.measureStrategy == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L81;
            if (r34 == false) goto L81;
            if (r34 == false) goto L76;
            if (r36 == true) goto L81;
        L76:
            if ((r10 instanceof Placeholder) == true) goto L81;
            if (r18.isResolvedVertically() == true) goto L81;
            boolean r37 = false;
        L82:
            if (r37 == false) goto L88;
            r7 = r18.getHeight();
        L81:
            r37 = true;
            goto L82
        L69:
            r36 = false;
            goto L71
        L61:
            r34 = false;
        L87:
            r17 = View.MeasureSpec.makeMeasureSpec(r7, BasicMeasure.EXACTLY);
            goto L88
        L20:
            r13 = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, r9, -2);
            if (r18.mMatchConstraintDefaultWidth != 1) goto L23;
            boolean r38 = true;
        L24:
            int r118 = r19.measureStrategy;
            if (r118 == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS) goto L29;
            if (r118 != BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L50;
        L29:
            if (r10.getMeasuredHeight() != r18.getHeight()) goto L31;
            boolean r119 = true;
        L33:
            if (r19.measureStrategy == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L43;
            if (r38 == false) goto L43;
            if (r38 == false) goto L38;
            if (r119 == true) goto L43;
        L38:
            if ((r10 instanceof Placeholder) == true) goto L43;
            if (r18.isResolvedHorizontally() == true) goto L43;
            boolean r39 = false;
        L44:
            if (r39 == false) goto L50;
            r6 = r18.getWidth();
        L43:
            r39 = true;
            goto L44
        L31:
            r119 = false;
            goto L33
        L23:
            r38 = false;
            goto L24
        L46:
            int r40 = this.layoutWidthSpec;
            r9 = r9 + r18.getHorizontalMargin();
            int r120 = -1;
        L48:
            r13 = ViewGroup.getChildMeasureSpec(r40, r9, r120);
            goto L50
        L47:
            r40 = this.layoutWidthSpec;
            r120 = -2;
        L49:
            r13 = View.MeasureSpec.makeMeasureSpec(r6, BasicMeasure.EXACTLY);
            goto L50
        }
    }

    static {
    }

    public ConstraintLayout(@NonNull Context r4) {
        super(r4);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new Measurer(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(null, 0, 0);
    }

    public ConstraintLayout(@NonNull Context r3, @Nullable AttributeSet r4) {
        super(r3, r4);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new Measurer(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(r4, 0, 0);
    }

    public ConstraintLayout(@NonNull Context r3, @Nullable AttributeSet r4, int r5) {
        super(r3, r4, r5);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new Measurer(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(r4, r5, 0);
    }

    @TargetApi(21)
    public ConstraintLayout(@NonNull Context r3, @Nullable AttributeSet r4, int r5, int r6) {
        super(r3, r4, r5, r6);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new Measurer(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(r4, r5, r6);
    }

    static /* synthetic */ int access$000(ConstraintLayout r0) {
        return r0.mOptimizationLevel;
    }

    static /* synthetic */ ArrayList access$100(ConstraintLayout r0) {
        return r0.mConstraintHelpers;
    }

    private int getPaddingWidth() {
        int r1 = 0;
        int r0 = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        if (Build.VERSION.SDK_INT < 17) goto L5;
        r1 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
    L5:
        if (r1 > 0) goto L7;
        return r0;
    L7:
        return r1;
    }

    public static SharedValues getSharedValues() {
        if (sSharedValues != null) goto L6;
        sSharedValues = new SharedValues();
    L6:
        return sSharedValues;
    }

    private final ConstraintWidget getTargetWidget(int r2) {
        if (r2 == 0) goto L4;
        View r0 = this.mChildrenByIds.get(r2);
        if (r0 != null) goto L13;
        r0 = findViewById(r2);
        if (r0 == null) goto L13;
        if (r0 == this) goto L13;
        if (r0.getParent() != this) goto L13;
        onViewAdded(r0);
    L13:
        if (r0 == this) goto L15;
        if (r0 != null) goto L19;
        return null;
    L19:
        return ((LayoutParams) r0.getLayoutParams()).widget;
    L15:
        return this.mLayoutWidget;
    L4:
        return this.mLayoutWidget;
    }

    private void init(AttributeSet r6, int r7, int r8) {
        this.mLayoutWidget.setCompanionWidget(this);
        this.mLayoutWidget.setMeasurer(this.mMeasurer);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (r6 == null) goto L37;
        TypedArray r9 = getContext().obtainStyledAttributes(r6, R.styleable.ConstraintLayout_Layout, r7, r8);
        int r10 = r9.getIndexCount();
        int r1 = 0;
    L5:
        if (r1 >= r10) goto L36;
        int r2 = r9.getIndex(r1);
        if (r2 != R.styleable.ConstraintLayout_Layout_android_minWidth) goto L10;
        this.mMinWidth = r9.getDimensionPixelOffset(r2, this.mMinWidth);
    L35:
        r1 = r1 + 1;
        goto L5
    L10:
        if (r2 != R.styleable.ConstraintLayout_Layout_android_minHeight) goto L13;
        this.mMinHeight = r9.getDimensionPixelOffset(r2, this.mMinHeight);
        goto L35
    L13:
        if (r2 != R.styleable.ConstraintLayout_Layout_android_maxWidth) goto L16;
        this.mMaxWidth = r9.getDimensionPixelOffset(r2, this.mMaxWidth);
        goto L35
    L16:
        if (r2 != R.styleable.ConstraintLayout_Layout_android_maxHeight) goto L19;
        this.mMaxHeight = r9.getDimensionPixelOffset(r2, this.mMaxHeight);
        goto L35
    L19:
        if (r2 != R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) goto L22;
        this.mOptimizationLevel = r9.getInt(r2, this.mOptimizationLevel);
        goto L35
    L22:
        if (r2 != R.styleable.ConstraintLayout_Layout_layoutDescription) goto L29;
        int r3 = r9.getResourceId(r2, 0);
        if (r3 == 0) goto L35;
        parseLayoutDescription(r3);     // Catch: Resources.NotFoundException -> L27
    L27:
        this.mConstraintLayoutSpec = null;
        goto L35
    L29:
        if (r2 != R.styleable.ConstraintLayout_Layout_constraintSet) goto L35;
        int r4 = r9.getResourceId(r2, 0);
        ConstraintSet r5 = new ConstraintSet();     // Catch: Resources.NotFoundException -> L33
        this.mConstraintSet = r5;     // Catch: Resources.NotFoundException -> L33
        r5.load(getContext(), r4);     // Catch: Resources.NotFoundException -> L33
    L34:
        this.mConstraintSetId = r4;
    L33:
        this.mConstraintSet = null;
        goto L34
    L36:
        r9.recycle();
    L37:
        this.mLayoutWidget.setOptimizationLevel(this.mOptimizationLevel);
    }

    private void markHierarchyDirty() {
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }

    private void setChildrenConstraints() {
        boolean r6 = isInEditMode();
        int r7 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r7) goto L10;
        ConstraintWidget r2 = getViewWidget(getChildAt(r1));
        if (r2 == null) goto L8;
        r2.reset();
    L8:
        r1 = r1 + 1;
        goto L3
    L10:
        if (r6 == false) goto L20;
        int r3 = 0;
    L12:
        if (r3 >= r7) goto L20;
        View r4 = getChildAt(r3);
        String r5 = getResources().getResourceName(r4.getId());     // Catch: Resources.NotFoundException -> L54
        setDesignInformation(0, r5, Integer.valueOf(r4.getId()));     // Catch: Resources.NotFoundException -> L54
        int r8 = r5.indexOf(47);     // Catch: Resources.NotFoundException -> L54
        if (r8 == (-1)) goto L17;
        r5 = r5.substring(r8 + 1);     // Catch: Resources.NotFoundException -> L54
    L17:
        getTargetWidget(r4.getId()).setDebugName(r5);     // Catch: Resources.NotFoundException -> L54
    L18:
        r3 = r3 + 1;
    L20:
        if (this.mConstraintSetId == (-1)) goto L29;
        int r9 = 0;
    L22:
        if (r9 >= r7) goto L29;
        View r10 = getChildAt(r9);
        if (r10.getId() != this.mConstraintSetId) goto L28;
        if ((r10 instanceof Constraints) == false) goto L28;
        this.mConstraintSet = ((Constraints) r10).getConstraintSet();
    L28:
        r9 = r9 + 1;
    L29:
        ConstraintSet r11 = this.mConstraintSet;
        if (r11 == null) goto L32;
        r11.applyToInternal(this, true);
    L32:
        this.mLayoutWidget.removeAllChildren();
        int r12 = this.mConstraintHelpers.size();
        if (r12 <= 0) goto L37;
        int r13 = 0;
    L35:
        if (r13 >= r12) goto L37;
        this.mConstraintHelpers.get(r13).updatePreLayout(this);
        r13 = r13 + 1;
    L37:
        int r14 = 0;
    L38:
        if (r14 >= r7) goto L43;
        View r15 = getChildAt(r14);
        if ((r15 instanceof Placeholder) == false) goto L42;
        ((Placeholder) r15).updatePreLayout(this);
    L42:
        r14 = r14 + 1;
        goto L38
    L43:
        this.mTempMapIdToWidget.clear();
        this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
        this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
        int r16 = 0;
    L44:
        if (r16 >= r7) goto L46;
        View r17 = getChildAt(r16);
        this.mTempMapIdToWidget.put(r17.getId(), getViewWidget(r17));
        r16 = r16 + 1;
        goto L44
    L46:
        int r18 = 0;
    L47:
        if (r18 >= r7) goto L53;
        View r19 = getChildAt(r18);
        ConstraintWidget r20 = getViewWidget(r19);
        if (r20 == null) goto L52;
        LayoutParams r21 = (LayoutParams) r19.getLayoutParams();
        this.mLayoutWidget.add(r20);
        applyConstraintsFromLayoutParams(r6, r19, r20, r21, this.mTempMapIdToWidget);
    L52:
        r18 = r18 + 1;
        goto L47
    }

    private void setWidgetBaseline(ConstraintWidget r2, LayoutParams r3, SparseArray<ConstraintWidget> r4, int r5, ConstraintAnchor.Type r6) {
        View r1 = this.mChildrenByIds.get(r5);
        ConstraintWidget r7 = r4.get(r5);
        if (r7 == null) goto L12;
        if (r1 != null) goto L6;
        return;
    L6:
        if ((r1.getLayoutParams() instanceof LayoutParams) == false) goto L14;
        r3.needsBaseline = true;
        ConstraintAnchor.Type r0 = ConstraintAnchor.Type.BASELINE;
        if (r6 != r0) goto L10;
        LayoutParams r8 = (LayoutParams) r1.getLayoutParams();
        r8.needsBaseline = true;
        r8.widget.setHasBaseline(true);
    L10:
        r2.getAnchor(r0).connect(r7.getAnchor(r6), r3.baselineMargin, r3.goneBaselineMargin, true);
        r2.setHasBaseline(true);
        r2.getAnchor(ConstraintAnchor.Type.TOP).reset();
        r2.getAnchor(ConstraintAnchor.Type.BOTTOM).reset();
        return;
    L14:
        return;
    }

    private boolean updateHierarchy() {
        int r0 = getChildCount();
        boolean r1 = false;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (getChildAt(r2).isLayoutRequested() == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        r1 = true;
    L8:
        if (r1 == false) goto L10;
        setChildrenConstraints();
    L10:
        return r1;
    }

    protected void applyConstraintsFromLayoutParams(boolean r17, View r18, ConstraintWidget r19, LayoutParams r20, SparseArray<ConstraintWidget> r21) {
        int r1 = Build.VERSION.SDK_INT;
        r20.validate();
        r20.helped = false;
        r19.setVisibility(r18.getVisibility());
        if (r20.isInPlaceholder == false) goto L5;
        r19.setInPlaceholder(true);
        r19.setVisibility(8);
    L5:
        r19.setCompanionWidget(r18);
        if ((r18 instanceof ConstraintHelper) == false) goto L10;
        ((ConstraintHelper) r18).resolveRtl(r19, this.mLayoutWidget.isRtl());
    L10:
        if (r20.isGuideline == false) goto L21;
        androidx.constraintlayout.core.widgets.Guideline r0 = (androidx.constraintlayout.core.widgets.Guideline) r19;
        int r3 = r20.resolvedGuideBegin;
        int r4 = r20.resolvedGuideEnd;
        float r5 = r20.resolvedGuidePercent;
        if (r1 >= 17) goto L15;
        r3 = r20.guideBegin;
        r4 = r20.guideEnd;
        r5 = r20.guidePercent;
    L15:
        if (r5 == (-1.0f)) goto L17;
        r0.setGuidePercent(r5);
        return;
    L17:
        if (r3 == (-1)) goto L19;
        r0.setGuideBegin(r3);
        return;
    L19:
        if (r4 == (-1)) goto L141;
        r0.setGuideEnd(r4);
        return;
    L141:
        return;
    L21:
        int r2 = r20.resolvedLeftToLeft;
        int r6 = r20.resolvedLeftToRight;
        int r7 = r20.resolvedRightToLeft;
        int r8 = r20.resolvedRightToRight;
        int r12 = r20.resolveGoneLeftMargin;
        int r13 = r20.resolveGoneRightMargin;
        float r14 = r20.resolvedHorizontalBias;
        if (r1 >= 17) goto L43;
        r2 = r20.leftToLeft;
        int r9 = r20.leftToRight;
        int r10 = r20.rightToLeft;
        int r11 = r20.rightToRight;
        int r15 = r20.goneLeftMargin;
        int r16 = r20.goneRightMargin;
        float r110 = r20.horizontalBias;
        if (r2 != (-1)) goto L32;
        if (r9 != (-1)) goto L32;
        int r111 = r20.startToStart;
        if (r111 == (-1)) goto L29;
        r2 = r111;
        goto L32
    L29:
        int r112 = r20.startToEnd;
        if (r112 == (-1)) goto L32;
        r9 = r112;
    L32:
        if (r10 != (-1)) goto L40;
        if (r11 != (-1)) goto L40;
        int r113 = r20.endToStart;
        if (r113 != (-1)) goto L41;
        int r114 = r20.endToEnd;
        if (r114 == (-1)) goto L40;
        int r115 = r114;
        r113 = r10;
    L42:
        r6 = r9;
    L44:
        int r22 = r20.circleConstraint;
        if (r22 == (-1)) goto L49;
        ConstraintWidget r23 = r21.get(r22);
        if (r23 == null) goto L105;
        r19.connectCircularConstraint(r23, r20.circleAngle, r20.circleRadius);
    L105:
        if (r17 == false) goto L112;
        int r24 = r20.editorAbsoluteX;
        if (r24 == (-1)) goto L109;
    L110:
        r19.setOrigin(r24, r20.editorAbsoluteY);
        goto L112
    L109:
        if (r20.editorAbsoluteY != (-1)) goto L110;
    L112:
        if (r20.horizontalDimensionFixed == false) goto L114;
        r19.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        r19.setWidth(((ViewGroup.MarginLayoutParams) r20).width);
        if (((ViewGroup.MarginLayoutParams) r20).width != (-2)) goto L125;
        r19.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
    L125:
        if (r20.verticalDimensionFixed == false) goto L127;
        r19.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        r19.setHeight(((ViewGroup.MarginLayoutParams) r20).height);
        if (((ViewGroup.MarginLayoutParams) r20).height != (-2)) goto L137;
        r19.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
    L137:
        r19.setDimensionRatio(r20.dimensionRatio);
        r19.setHorizontalWeight(r20.horizontalWeight);
        r19.setVerticalWeight(r20.verticalWeight);
        r19.setHorizontalChainStyle(r20.horizontalChainStyle);
        r19.setVerticalChainStyle(r20.verticalChainStyle);
        r19.setWrapBehaviorInParent(r20.wrapBehaviorInParent);
        r19.setHorizontalMatchStyle(r20.matchConstraintDefaultWidth, r20.matchConstraintMinWidth, r20.matchConstraintMaxWidth, r20.matchConstraintPercentWidth);
        r19.setVerticalMatchStyle(r20.matchConstraintDefaultHeight, r20.matchConstraintMinHeight, r20.matchConstraintMaxHeight, r20.matchConstraintPercentHeight);
        return;
    L127:
        if (((ViewGroup.MarginLayoutParams) r20).height == (-1)) goto L129;
        r19.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        r19.setHeight(0);
        goto L137
    L129:
        if (r20.constrainedHeight == false) goto L131;
        ConstraintWidget.DimensionBehaviour r25 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
    L132:
        r19.setVerticalDimensionBehaviour(r25);
        ConstraintAnchor r26 = r19.getAnchor(ConstraintAnchor.Type.TOP);
        r26.mMargin = ((ViewGroup.MarginLayoutParams) r20).topMargin;
        ConstraintAnchor r27 = r19.getAnchor(ConstraintAnchor.Type.BOTTOM);
        r27.mMargin = ((ViewGroup.MarginLayoutParams) r20).bottomMargin;
        goto L137
    L131:
        r25 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        goto L132
    L114:
        if (((ViewGroup.MarginLayoutParams) r20).width == (-1)) goto L116;
        r19.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        r19.setWidth(0);
        goto L125
    L116:
        if (r20.constrainedWidth == false) goto L118;
        ConstraintWidget.DimensionBehaviour r28 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
    L119:
        r19.setHorizontalDimensionBehaviour(r28);
        ConstraintAnchor r29 = r19.getAnchor(ConstraintAnchor.Type.LEFT);
        r29.mMargin = ((ViewGroup.MarginLayoutParams) r20).leftMargin;
        ConstraintAnchor r30 = r19.getAnchor(ConstraintAnchor.Type.RIGHT);
        r30.mMargin = ((ViewGroup.MarginLayoutParams) r20).rightMargin;
        goto L125
    L118:
        r28 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        goto L119
    L49:
        if (r2 == (-1)) goto L53;
        ConstraintWidget r31 = r21.get(r2);
        if (r31 == null) goto L58;
        ConstraintAnchor.Type r32 = ConstraintAnchor.Type.LEFT;
        int r33 = ((ViewGroup.MarginLayoutParams) r20).leftMargin;
        ConstraintAnchor.Type r34 = r32;
    L57:
        r19.immediateConnect(r34, r31, r32, r33, r15);
    L58:
        if (r113 == (-1)) goto L62;
        ConstraintWidget r35 = r21.get(r113);
        if (r35 == null) goto L67;
        ConstraintAnchor.Type r36 = ConstraintAnchor.Type.RIGHT;
        ConstraintAnchor.Type r37 = ConstraintAnchor.Type.LEFT;
        int r38 = ((ViewGroup.MarginLayoutParams) r20).rightMargin;
    L66:
        r19.immediateConnect(r36, r35, r37, r38, r16);
    L67:
        int r39 = r20.topToTop;
        if (r39 == (-1)) goto L72;
        ConstraintWidget r40 = r21.get(r39);
        if (r40 == null) goto L78;
        ConstraintAnchor.Type r41 = ConstraintAnchor.Type.TOP;
        int r42 = ((ViewGroup.MarginLayoutParams) r20).topMargin;
        int r43 = r20.goneTopMargin;
        ConstraintAnchor.Type r44 = r41;
    L77:
        r19.immediateConnect(r44, r40, r41, r42, r43);
    L78:
        int r45 = r20.bottomToTop;
        if (r45 == (-1)) goto L83;
        ConstraintWidget r46 = r21.get(r45);
        if (r46 == null) goto L89;
        ConstraintAnchor.Type r47 = ConstraintAnchor.Type.BOTTOM;
        ConstraintAnchor.Type r48 = ConstraintAnchor.Type.TOP;
        int r49 = ((ViewGroup.MarginLayoutParams) r20).bottomMargin;
        int r50 = r20.goneBottomMargin;
    L88:
        r19.immediateConnect(r47, r46, r48, r49, r50);
    L89:
        int r51 = r20.baselineToBaseline;
        if (r51 == (-1)) goto L93;
        ConstraintAnchor.Type r52 = ConstraintAnchor.Type.BASELINE;
    L92:
        setWidgetBaseline(r19, r20, r21, r51, r52);
    L100:
        if (r110 < 0.0f) goto L102;
        r19.setHorizontalBiasPercent(r110);
    L102:
        float r53 = r20.verticalBias;
        if (r53 < 0.0f) goto L105;
        r19.setVerticalBiasPercent(r53);
        goto L105
    L93:
        r51 = r20.baselineToTop;
        if (r51 == (-1)) goto L96;
        r52 = ConstraintAnchor.Type.TOP;
        goto L92
    L96:
        r51 = r20.baselineToBottom;
        if (r51 == (-1)) goto L100;
        r52 = ConstraintAnchor.Type.BOTTOM;
        goto L92
    L83:
        int r54 = r20.bottomToBottom;
        if (r54 == (-1)) goto L89;
        r46 = r21.get(r54);
        if (r46 == null) goto L89;
        r48 = ConstraintAnchor.Type.BOTTOM;
        r49 = ((ViewGroup.MarginLayoutParams) r20).bottomMargin;
        r50 = r20.goneBottomMargin;
        r47 = r48;
        goto L88
    L72:
        int r55 = r20.topToBottom;
        if (r55 == (-1)) goto L78;
        r40 = r21.get(r55);
        if (r40 == null) goto L78;
        r44 = ConstraintAnchor.Type.TOP;
        r41 = ConstraintAnchor.Type.BOTTOM;
        r42 = ((ViewGroup.MarginLayoutParams) r20).topMargin;
        r43 = r20.goneTopMargin;
        goto L77
    L62:
        if (r115 == (-1)) goto L67;
        r35 = r21.get(r115);
        if (r35 == null) goto L67;
        r37 = ConstraintAnchor.Type.RIGHT;
        r38 = ((ViewGroup.MarginLayoutParams) r20).rightMargin;
        r36 = r37;
        goto L66
    L53:
        if (r6 == (-1)) goto L58;
        r31 = r21.get(r6);
        if (r31 == null) goto L58;
        r34 = ConstraintAnchor.Type.LEFT;
        r32 = ConstraintAnchor.Type.RIGHT;
        r33 = ((ViewGroup.MarginLayoutParams) r20).leftMargin;
    L41:
        r115 = r11;
    L40:
        r113 = r10;
        goto L41
    L43:
        r110 = r14;
        r16 = r13;
        r115 = r8;
        r15 = r12;
        r113 = r7;
        goto L44
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return r1 instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r21) {
        ArrayList<ConstraintHelper> r1 = this.mConstraintHelpers;
        if (r1 == null) goto L9;
        int r2 = r1.size();
        if (r2 <= 0) goto L9;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L9;
        this.mConstraintHelpers.get(r3).updatePreDraw(this);
        r3 = r3 + 1;
    L9:
        super.dispatchDraw(r21);
        if (isInEditMode() == false) goto L24;
        float r4 = getWidth();
        float r5 = getHeight();
        int r6 = getChildCount();
        int r7 = 0;
    L12:
        if (r7 >= r6) goto L32;
        View r8 = getChildAt(r7);
        if (r8.getVisibility() == 8) goto L23;
        Object r9 = r8.getTag();
        if (r9 == null) goto L23;
        if ((r9 instanceof String) == false) goto L23;
        String[] r10 = ((String) r9).split(",");
        if (r10.length != 4) goto L23;
        int r11 = Integer.parseInt(r10[0]);
        int r12 = Integer.parseInt(r10[1]);
        int r13 = Integer.parseInt(r10[2]);
        int r14 = (int) ((r11 / 1080.0f) * r4);
        int r15 = (int) ((r12 / 1920.0f) * r5);
        int r16 = (int) ((Integer.parseInt(r10[3]) / 1920.0f) * r5);
        Paint r17 = new Paint();
        r17.setColor(SupportMenu.CATEGORY_MASK);
        float r18 = r14;
        float r19 = r15;
        float r20 = r14 + ((int) ((r13 / 1080.0f) * r4));
        r21.drawLine(r18, r19, r20, r19, r17);
        float r22 = r15 + r16;
        r21.drawLine(r20, r19, r20, r22, r17);
        r21.drawLine(r20, r22, r18, r22, r17);
        r21.drawLine(r18, r22, r18, r19, r17);
        r17.setColor(-16711936);
        r21.drawLine(r18, r19, r20, r22, r17);
        r21.drawLine(r18, r22, r20, r19, r17);
    L23:
        r7 = r7 + 1;
        goto L12
    L32:
        return;
    }

    public void fillMetrics(Metrics r1) {
        this.mMetrics = r1;
        this.mLayoutWidget.fillMetrics(r1);
    }

    @Override // android.view.View
    public void forceLayout() {
        markHierarchyDirty();
        super.forceLayout();
    }

    @Override // android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return new LayoutParams(r1);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r2) {
        return new LayoutParams(getContext(), r2);
    }

    public Object getDesignInformation(int r1, Object r2) {
        if (r1 == 0) goto L4;
        return null;
    L4:
        if ((r2 instanceof String) == false) goto L13;
        String r3 = (String) r2;
        HashMap<String, Integer> r4 = this.mDesignIds;
        if (r4 != null) goto L8;
        return null;
    L8:
        if (r4.containsKey(r3) == true) goto L10;
        return null;
    L10:
        return this.mDesignIds.get(r3);
    L13:
        return null;
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.getOptimizationLevel();
    }

    public String getSceneString() {
        StringBuilder r0 = new StringBuilder();
        if (this.mLayoutWidget.stringId != null) goto L9;
        int r1 = getId();
        if (r1 == (-1)) goto L7;
        this.mLayoutWidget.stringId = getContext().getResources().getResourceEntryName(r1);
        goto L9
    L7:
        this.mLayoutWidget.stringId = "parent";
    L9:
        if (this.mLayoutWidget.getDebugName() != null) goto L11;
        ConstraintWidgetContainer r2 = this.mLayoutWidget;
        r2.setDebugName(r2.stringId);
        Log.v(TAG, " setDebugName " + this.mLayoutWidget.getDebugName());
    L11:
        Iterator<ConstraintWidget> r3 = this.mLayoutWidget.getChildren().iterator();
    L13:
        if (r3.hasNext() == false) goto L24;
        ConstraintWidget r5 = r3.next();
        View r6 = (View) r5.getCompanionWidget();
        if (r6 == null) goto L13;
        if (r5.stringId != null) goto L22;
        int r7 = r6.getId();
        if (r7 == (-1)) goto L22;
        r5.stringId = getContext().getResources().getResourceEntryName(r7);
    L22:
        if (r5.getDebugName() != null) goto L13;
        r5.setDebugName(r5.stringId);
        Log.v(TAG, " setDebugName " + r5.getDebugName());
        goto L13
    L24:
        this.mLayoutWidget.getSceneString(r0);
        return r0.toString();
    }

    public View getViewById(int r1) {
        return this.mChildrenByIds.get(r1);
    }

    public final ConstraintWidget getViewWidget(View r2) {
        if (r2 == this) goto L4;
        if (r2 != null) goto L7;
        return null;
    L7:
        if ((r2.getLayoutParams() instanceof LayoutParams) == true) goto L9;
        r2.setLayoutParams(generateLayoutParams(r2.getLayoutParams()));
        if ((r2.getLayoutParams() instanceof LayoutParams) == true) goto L9;
        return null;
    L9:
        return ((LayoutParams) r2.getLayoutParams()).widget;
    L4:
        return this.mLayoutWidget;
    }

    protected boolean isRtl() {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        return false;
    L5:
        if ((getContext().getApplicationInfo().flags & 4194304) == 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        return false;
    L10:
        if (1 == getLayoutDirection()) goto L12;
        return false;
    L12:
        return true;
    L7:
        r0 = false;
        goto L8
    }

    public void loadLayoutDescription(int r4) {
        if (r4 != 0) goto L9;
    L6:
        this.mConstraintLayoutSpec = null;
        return;
    L9:
        this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, r4);     // Catch: Resources.NotFoundException -> L8
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r6, int r7, int r8, int r9, int r10) {
        int r11 = getChildCount();
        boolean r12 = isInEditMode();
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r14 >= r11) goto L23;
        View r15 = getChildAt(r14);
        LayoutParams r0 = (LayoutParams) r15.getLayoutParams();
        ConstraintWidget r1 = r0.widget;
        if (r15.getVisibility() != 8) goto L15;
        if (r0.isGuideline == true) goto L15;
        if (r0.isHelper == true) goto L15;
        if (r0.isVirtualGroup == true) goto L15;
        if (r12 == true) goto L15;
    L22:
        r14 = r14 + 1;
    L15:
        if (r0.isInPlaceholder == true) goto L22;
        int r2 = r1.getX();
        int r3 = r1.getY();
        int r4 = r1.getWidth() + r2;
        int r5 = r1.getHeight() + r3;
        r15.layout(r2, r3, r4, r5);
        if ((r15 instanceof Placeholder) == false) goto L22;
        View r16 = ((Placeholder) r15).getContent();
        if (r16 == null) goto L22;
        r16.setVisibility(0);
        r16.layout(r2, r3, r4, r5);
        goto L22
    L23:
        int r17 = this.mConstraintHelpers.size();
        if (r17 <= 0) goto L27;
    L25:
        if (r13 >= r17) goto L35;
        this.mConstraintHelpers.get(r13).updatePostLayout(this);
        r13 = r13 + 1;
        goto L25
    L35:
        return;
    }

    @Override // android.view.View
    protected void onMeasure(int r9, int r10) {
        if (this.mOnMeasureWidthMeasureSpec != r9) goto L6;
        int r0 = this.mOnMeasureHeightMeasureSpec;
    L6:
        if (this.mDirtyHierarchy == true) goto L13;
        int r1 = getChildCount();
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L13;
        if (getChildAt(r2).isLayoutRequested() == true) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        this.mDirtyHierarchy = true;
    L13:
        boolean r3 = this.mDirtyHierarchy;
        this.mOnMeasureWidthMeasureSpec = r9;
        this.mOnMeasureHeightMeasureSpec = r10;
        this.mLayoutWidget.setRtl(isRtl());
        if (this.mDirtyHierarchy == false) goto L18;
        this.mDirtyHierarchy = false;
        if (updateHierarchy() == false) goto L18;
        this.mLayoutWidget.updateHierarchy();
    L18:
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, r9, r10);
        resolveMeasuredDimension(r9, r10, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View r4) {
        super.onViewAdded(r4);
        ConstraintWidget r0 = getViewWidget(r4);
        if ((r4 instanceof Guideline) == false) goto L8;
        if ((r0 instanceof androidx.constraintlayout.core.widgets.Guideline) == true) goto L8;
        LayoutParams r1 = (LayoutParams) r4.getLayoutParams();
        androidx.constraintlayout.core.widgets.Guideline r2 = new androidx.constraintlayout.core.widgets.Guideline();
        r1.widget = r2;
        r1.isGuideline = true;
        r2.setOrientation(r1.orientation);
    L8:
        if ((r4 instanceof ConstraintHelper) == false) goto L12;
        ConstraintHelper r3 = (ConstraintHelper) r4;
        r3.validateParams();
        ((LayoutParams) r4.getLayoutParams()).isHelper = true;
        if (this.mConstraintHelpers.contains(r3) == true) goto L12;
        this.mConstraintHelpers.add(r3);
    L12:
        this.mChildrenByIds.put(r4.getId(), r4);
        this.mDirtyHierarchy = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View r3) {
        super.onViewRemoved(r3);
        this.mChildrenByIds.remove(r3.getId());
        ConstraintWidget r0 = getViewWidget(r3);
        this.mLayoutWidget.remove(r0);
        this.mConstraintHelpers.remove(r3);
        this.mDirtyHierarchy = true;
    }

    protected void parseLayoutDescription(int r3) {
        this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, r3);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        markHierarchyDirty();
        super.requestLayout();
    }

    protected void resolveMeasuredDimension(int r3, int r4, int r5, int r6, boolean r7, boolean r8) {
        Measurer r0 = this.mMeasurer;
        int r1 = r0.paddingHeight;
        int r9 = ViewGroup.resolveSizeAndState(r5 + r0.paddingWidth, r3, 0);
        int r10 = ViewGroup.resolveSizeAndState(r6 + r1, r4, 0);
        int r11 = r9 & ViewCompat.MEASURED_SIZE_MASK;
        int r12 = r10 & ViewCompat.MEASURED_SIZE_MASK;
        int r13 = Math.min(this.mMaxWidth, r11);
        int r14 = Math.min(this.mMaxHeight, r12);
        if (r7 == false) goto L5;
        r13 = r13 | 16777216;
    L5:
        if (r8 == false) goto L7;
        r14 = r14 | 16777216;
    L7:
        setMeasuredDimension(r13, r14);
        this.mLastMeasureWidth = r13;
        this.mLastMeasureHeight = r14;
    }

    protected void resolveSystem(ConstraintWidgetContainer r18, int r19, int r20, int r21) {
        int r7 = View.MeasureSpec.getMode(r20);
        int r0 = View.MeasureSpec.getSize(r20);
        int r8 = View.MeasureSpec.getMode(r21);
        int r1 = View.MeasureSpec.getSize(r21);
        int r16 = Math.max(0, getPaddingTop());
        int r13 = Math.max(0, getPaddingBottom());
        int r2 = r16 + r13;
        int r4 = getPaddingWidth();
        this.mMeasurer.captureLayoutInfo(r20, r21, r16, r13, r4, r2);
        if (Build.VERSION.SDK_INT < 17) goto L13;
        int r5 = Math.max(0, getPaddingStart());
        int r9 = Math.max(0, getPaddingEnd());
        if (r5 > 0) goto L10;
        if (r9 > 0) goto L10;
        r5 = Math.max(0, getPaddingLeft());
    L12:
        int r10 = r5;
    L14:
        int r11 = r0 - r4;
        int r12 = r1 - r2;
        setSelfDimensionBehaviour(r18, r7, r11, r8, r12);
        r18.measure(r19, r7, r11, r8, r12, this.mLastMeasureWidth, this.mLastMeasureHeight, r10, r16);
        return;
    L10:
        if (isRtl() == false) goto L12;
        r5 = r9;
        goto L12
    L13:
        r10 = Math.max(0, getPaddingLeft());
        goto L14
    }

    public void setConstraintSet(ConstraintSet r1) {
        this.mConstraintSet = r1;
    }

    public void setDesignInformation(int r2, Object r3, Object r4) {
        if (r2 == 0) goto L4;
        return;
    L4:
        if ((r3 instanceof String) == true) goto L6;
        return;
    L6:
        if ((r4 instanceof Integer) == true) goto L8;
        return;
    L8:
        if (this.mDesignIds != null) goto L10;
        this.mDesignIds = new HashMap();
    L10:
        String r5 = (String) r3;
        int r6 = r5.indexOf("/");
        if (r6 == (-1)) goto L13;
        r5 = r5.substring(r6 + 1);
    L13:
        int r7 = ((Integer) r4).intValue();
        this.mDesignIds.put(r5, Integer.valueOf(r7));
    }

    @Override // android.view.View
    public void setId(int r3) {
        this.mChildrenByIds.remove(getId());
        super.setId(r3);
        this.mChildrenByIds.put(getId(), this);
    }

    public void setMaxHeight(int r2) {
        if (r2 != this.mMaxHeight) goto L5;
        return;
    L5:
        this.mMaxHeight = r2;
        requestLayout();
    }

    public void setMaxWidth(int r2) {
        if (r2 != this.mMaxWidth) goto L5;
        return;
    L5:
        this.mMaxWidth = r2;
        requestLayout();
    }

    public void setMinHeight(int r2) {
        if (r2 != this.mMinHeight) goto L5;
        return;
    L5:
        this.mMinHeight = r2;
        requestLayout();
    }

    public void setMinWidth(int r2) {
        if (r2 != this.mMinWidth) goto L5;
        return;
    L5:
        this.mMinWidth = r2;
        requestLayout();
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener r1) {
        this.mConstraintsChangedListener = r1;
        ConstraintLayoutStates r0 = this.mConstraintLayoutSpec;
        if (r0 == null) goto L6;
        r0.setOnConstraintsChanged(r1);
        return;
    }

    public void setOptimizationLevel(int r1) {
        this.mOptimizationLevel = r1;
        this.mLayoutWidget.setOptimizationLevel(r1);
    }

    protected void setSelfDimensionBehaviour(ConstraintWidgetContainer r8, int r9, int r10, int r11, int r12) {
        Measurer r0 = this.mMeasurer;
        int r1 = r0.paddingHeight;
        int r2 = r0.paddingWidth;
        ConstraintWidget.DimensionBehaviour r3 = ConstraintWidget.DimensionBehaviour.FIXED;
        int r4 = getChildCount();
        if (r9 == Integer.MIN_VALUE) goto L12;
        if (r9 == 0) goto L9;
        if (r9 == 1073741824) goto L8;
        ConstraintWidget.DimensionBehaviour r13 = r3;
    L7:
        r10 = 0;
    L15:
        if (r11 == Integer.MIN_VALUE) goto L23;
        if (r11 == 0) goto L20;
        if (r11 == 1073741824) goto L19;
    L18:
        r12 = 0;
    L27:
        if (r10 == r8.getWidth()) goto L29;
    L30:
        r8.invalidateMeasures();
    L31:
        r8.setX(0);
        r8.setY(0);
        r8.setMaxWidth(this.mMaxWidth - r2);
        r8.setMaxHeight(this.mMaxHeight - r1);
        r8.setMinWidth(0);
        r8.setMinHeight(0);
        r8.setHorizontalDimensionBehaviour(r13);
        r8.setWidth(r10);
        r8.setVerticalDimensionBehaviour(r3);
        r8.setHeight(r12);
        r8.setMinWidth(this.mMinWidth - r2);
        r8.setMinHeight(this.mMinHeight - r1);
        return;
    L29:
        if (r12 == r8.getHeight()) goto L31;
    L19:
        r12 = Math.min(this.mMaxHeight - r1, r12);
        goto L27
    L20:
        r3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r4 != 0) goto L18;
    L25:
        r12 = Math.max(0, this.mMinHeight);
        goto L27
    L23:
        r3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r4 != 0) goto L27;
    L8:
        r10 = Math.min(this.mMaxWidth - r2, r10);
        r13 = r3;
        goto L15
    L9:
        r13 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r4 != 0) goto L7;
    L14:
        r10 = Math.max(0, this.mMinWidth);
        goto L15
    L12:
        r13 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r4 != 0) goto L15;
        goto L14
    }

    public void setState(int r1, int r2, int r3) {
        ConstraintLayoutStates r0 = this.mConstraintLayoutSpec;
        if (r0 == null) goto L6;
        r0.updateConstraints(r1, r2, r3);
        return;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
