package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Optimizer;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.internal.view.SupportMenu;
import com.bytedance.librarian.LibrarianImpl;
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

            private Table() {
            }

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
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_constraintTag, 51);
                r0.append(R.styleable.ConstraintLayout_Layout_layout_wrapBehaviorInParent, 66);
            }
        }

        public ConstraintWidget getConstraintWidget() {
            return this.widget;
        }

        public void setWidgetDebugName(String text) {
            this.widget.setDebugName(text);
        }

        public void reset() {
            ConstraintWidget r0 = this.widget;
            if (r0 == null) goto L6;
            r0.reset();
            return;
        }

        public LayoutParams(LayoutParams source) {
            super(source);
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
            this.guideBegin = source.guideBegin;
            this.guideEnd = source.guideEnd;
            this.guidePercent = source.guidePercent;
            this.guidelineUseRtl = source.guidelineUseRtl;
            this.leftToLeft = source.leftToLeft;
            this.leftToRight = source.leftToRight;
            this.rightToLeft = source.rightToLeft;
            this.rightToRight = source.rightToRight;
            this.topToTop = source.topToTop;
            this.topToBottom = source.topToBottom;
            this.bottomToTop = source.bottomToTop;
            this.bottomToBottom = source.bottomToBottom;
            this.baselineToBaseline = source.baselineToBaseline;
            this.baselineToTop = source.baselineToTop;
            this.baselineToBottom = source.baselineToBottom;
            this.circleConstraint = source.circleConstraint;
            this.circleRadius = source.circleRadius;
            this.circleAngle = source.circleAngle;
            this.startToEnd = source.startToEnd;
            this.startToStart = source.startToStart;
            this.endToStart = source.endToStart;
            this.endToEnd = source.endToEnd;
            this.goneLeftMargin = source.goneLeftMargin;
            this.goneTopMargin = source.goneTopMargin;
            this.goneRightMargin = source.goneRightMargin;
            this.goneBottomMargin = source.goneBottomMargin;
            this.goneStartMargin = source.goneStartMargin;
            this.goneEndMargin = source.goneEndMargin;
            this.goneBaselineMargin = source.goneBaselineMargin;
            this.baselineMargin = source.baselineMargin;
            this.horizontalBias = source.horizontalBias;
            this.verticalBias = source.verticalBias;
            this.dimensionRatio = source.dimensionRatio;
            this.dimensionRatioValue = source.dimensionRatioValue;
            this.dimensionRatioSide = source.dimensionRatioSide;
            this.horizontalWeight = source.horizontalWeight;
            this.verticalWeight = source.verticalWeight;
            this.horizontalChainStyle = source.horizontalChainStyle;
            this.verticalChainStyle = source.verticalChainStyle;
            this.constrainedWidth = source.constrainedWidth;
            this.constrainedHeight = source.constrainedHeight;
            this.matchConstraintDefaultWidth = source.matchConstraintDefaultWidth;
            this.matchConstraintDefaultHeight = source.matchConstraintDefaultHeight;
            this.matchConstraintMinWidth = source.matchConstraintMinWidth;
            this.matchConstraintMaxWidth = source.matchConstraintMaxWidth;
            this.matchConstraintMinHeight = source.matchConstraintMinHeight;
            this.matchConstraintMaxHeight = source.matchConstraintMaxHeight;
            this.matchConstraintPercentWidth = source.matchConstraintPercentWidth;
            this.matchConstraintPercentHeight = source.matchConstraintPercentHeight;
            this.editorAbsoluteX = source.editorAbsoluteX;
            this.editorAbsoluteY = source.editorAbsoluteY;
            this.orientation = source.orientation;
            this.horizontalDimensionFixed = source.horizontalDimensionFixed;
            this.verticalDimensionFixed = source.verticalDimensionFixed;
            this.needsBaseline = source.needsBaseline;
            this.isGuideline = source.isGuideline;
            this.resolvedLeftToLeft = source.resolvedLeftToLeft;
            this.resolvedLeftToRight = source.resolvedLeftToRight;
            this.resolvedRightToLeft = source.resolvedRightToLeft;
            this.resolvedRightToRight = source.resolvedRightToRight;
            this.resolveGoneLeftMargin = source.resolveGoneLeftMargin;
            this.resolveGoneRightMargin = source.resolveGoneRightMargin;
            this.resolvedHorizontalBias = source.resolvedHorizontalBias;
            this.constraintTag = source.constraintTag;
            this.wrapBehaviorInParent = source.wrapBehaviorInParent;
            this.widget = source.widget;
            this.widthSet = source.widthSet;
            this.heightSet = source.heightSet;
        }

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
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
            TypedArray r11 = c.obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_Layout);
            int r12 = r11.getIndexCount();
            int r1 = 0;
        L3:
            if (r1 >= r12) goto L118;
            int r5 = r11.getIndex(r1);
            int r6 = Table.map.get(r5);
            switch(r6) {
                case 1: goto L116;
                case 2: goto L113;
                case 3: goto L112;
                case 4: goto L109;
                case 5: goto L108;
                case 6: goto L107;
                case 7: goto L106;
                case 8: goto L103;
                case 9: goto L100;
                case 10: goto L97;
                case 11: goto L94;
                case 12: goto L91;
                case 13: goto L88;
                case 14: goto L85;
                case 15: goto L82;
                case 16: goto L79;
                case 17: goto L76;
                case 18: goto L73;
                case 19: goto L70;
                case 20: goto L67;
                case 21: goto L66;
                case 22: goto L65;
                case 23: goto L64;
                case 24: goto L63;
                case 25: goto L62;
                case 26: goto L61;
                case 27: goto L60;
                case 28: goto L59;
                case 29: goto L58;
                case 30: goto L57;
                case 31: goto L54;
                case 32: goto L51;
                case 33: goto L122;
                case 34: goto L126;
                case 35: goto L40;
                case 36: goto L120;
                case 37: goto L124;
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
                default: goto L117;
            };
        L9:
            this.guidelineUseRtl = r11.getBoolean(r5, this.guidelineUseRtl);
            goto L117
        L10:
            this.wrapBehaviorInParent = r11.getInt(r5, this.wrapBehaviorInParent);
            goto L117
        L11:
            ConstraintSet.parseDimensionConstraints(this, r11, r5, 1);
            this.heightSet = true;
            goto L117
        L12:
            ConstraintSet.parseDimensionConstraints(this, r11, r5, 0);
            this.widthSet = true;
        L117:
            r1 = r1 + 1;
            goto L3
        L13:
            this.goneBaselineMargin = r11.getDimensionPixelSize(r5, this.goneBaselineMargin);
            goto L117
        L14:
            this.baselineMargin = r11.getDimensionPixelSize(r5, this.baselineMargin);
            goto L117
        L15:
            int r7 = r11.getResourceId(r5, this.baselineToBottom);
            this.baselineToBottom = r7;
            if (r7 != (-1)) goto L117;
            this.baselineToBottom = r11.getInt(r5, -1);
            goto L117
        L18:
            int r8 = r11.getResourceId(r5, this.baselineToTop);
            this.baselineToTop = r8;
            if (r8 != (-1)) goto L117;
            this.baselineToTop = r11.getInt(r5, -1);
            goto L117
        L21:
            this.constraintTag = r11.getString(r5);
            goto L117
        L22:
            this.editorAbsoluteY = r11.getDimensionPixelOffset(r5, this.editorAbsoluteY);
            goto L117
        L23:
            this.editorAbsoluteX = r11.getDimensionPixelOffset(r5, this.editorAbsoluteX);
            goto L117
        L24:
            this.verticalChainStyle = r11.getInt(r5, 0);
            goto L117
        L25:
            this.horizontalChainStyle = r11.getInt(r5, 0);
            goto L117
        L26:
            this.verticalWeight = r11.getFloat(r5, this.verticalWeight);
            goto L117
        L27:
            this.horizontalWeight = r11.getFloat(r5, this.horizontalWeight);
            goto L117
        L28:
            ConstraintSet.parseDimensionRatioString(this, r11.getString(r5));
            goto L117
        L29:
            this.matchConstraintPercentHeight = Math.max(0.0f, r11.getFloat(r5, this.matchConstraintPercentHeight));
            this.matchConstraintDefaultHeight = 2;
            goto L117
        L40:
            this.matchConstraintPercentWidth = Math.max(0.0f, r11.getFloat(r5, this.matchConstraintPercentWidth));
            this.matchConstraintDefaultWidth = 2;
            goto L117
        L51:
            int r9 = r11.getInt(r5, 0);
            this.matchConstraintDefaultHeight = r9;
            if (r9 != 1) goto L117;
            Log.e(ConstraintLayout.TAG, "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
            goto L117
        L54:
            int r10 = r11.getInt(r5, 0);
            this.matchConstraintDefaultWidth = r10;
            if (r10 != 1) goto L117;
            Log.e(ConstraintLayout.TAG, "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
            goto L117
        L57:
            this.verticalBias = r11.getFloat(r5, this.verticalBias);
            goto L117
        L58:
            this.horizontalBias = r11.getFloat(r5, this.horizontalBias);
            goto L117
        L59:
            this.constrainedHeight = r11.getBoolean(r5, this.constrainedHeight);
            goto L117
        L60:
            this.constrainedWidth = r11.getBoolean(r5, this.constrainedWidth);
            goto L117
        L61:
            this.goneEndMargin = r11.getDimensionPixelSize(r5, this.goneEndMargin);
            goto L117
        L62:
            this.goneStartMargin = r11.getDimensionPixelSize(r5, this.goneStartMargin);
            goto L117
        L63:
            this.goneBottomMargin = r11.getDimensionPixelSize(r5, this.goneBottomMargin);
            goto L117
        L64:
            this.goneRightMargin = r11.getDimensionPixelSize(r5, this.goneRightMargin);
            goto L117
        L65:
            this.goneTopMargin = r11.getDimensionPixelSize(r5, this.goneTopMargin);
            goto L117
        L66:
            this.goneLeftMargin = r11.getDimensionPixelSize(r5, this.goneLeftMargin);
            goto L117
        L67:
            int r13 = r11.getResourceId(r5, this.endToEnd);
            this.endToEnd = r13;
            if (r13 != (-1)) goto L117;
            this.endToEnd = r11.getInt(r5, -1);
            goto L117
        L70:
            int r14 = r11.getResourceId(r5, this.endToStart);
            this.endToStart = r14;
            if (r14 != (-1)) goto L117;
            this.endToStart = r11.getInt(r5, -1);
            goto L117
        L73:
            int r15 = r11.getResourceId(r5, this.startToStart);
            this.startToStart = r15;
            if (r15 != (-1)) goto L117;
            this.startToStart = r11.getInt(r5, -1);
            goto L117
        L76:
            int r16 = r11.getResourceId(r5, this.startToEnd);
            this.startToEnd = r16;
            if (r16 != (-1)) goto L117;
            this.startToEnd = r11.getInt(r5, -1);
            goto L117
        L79:
            int r17 = r11.getResourceId(r5, this.baselineToBaseline);
            this.baselineToBaseline = r17;
            if (r17 != (-1)) goto L117;
            this.baselineToBaseline = r11.getInt(r5, -1);
            goto L117
        L82:
            int r18 = r11.getResourceId(r5, this.bottomToBottom);
            this.bottomToBottom = r18;
            if (r18 != (-1)) goto L117;
            this.bottomToBottom = r11.getInt(r5, -1);
            goto L117
        L85:
            int r19 = r11.getResourceId(r5, this.bottomToTop);
            this.bottomToTop = r19;
            if (r19 != (-1)) goto L117;
            this.bottomToTop = r11.getInt(r5, -1);
            goto L117
        L88:
            int r20 = r11.getResourceId(r5, this.topToBottom);
            this.topToBottom = r20;
            if (r20 != (-1)) goto L117;
            this.topToBottom = r11.getInt(r5, -1);
            goto L117
        L91:
            int r21 = r11.getResourceId(r5, this.topToTop);
            this.topToTop = r21;
            if (r21 != (-1)) goto L117;
            this.topToTop = r11.getInt(r5, -1);
            goto L117
        L94:
            int r22 = r11.getResourceId(r5, this.rightToRight);
            this.rightToRight = r22;
            if (r22 != (-1)) goto L117;
            this.rightToRight = r11.getInt(r5, -1);
            goto L117
        L97:
            int r23 = r11.getResourceId(r5, this.rightToLeft);
            this.rightToLeft = r23;
            if (r23 != (-1)) goto L117;
            this.rightToLeft = r11.getInt(r5, -1);
            goto L117
        L100:
            int r24 = r11.getResourceId(r5, this.leftToRight);
            this.leftToRight = r24;
            if (r24 != (-1)) goto L117;
            this.leftToRight = r11.getInt(r5, -1);
            goto L117
        L103:
            int r25 = r11.getResourceId(r5, this.leftToLeft);
            this.leftToLeft = r25;
            if (r25 != (-1)) goto L117;
            this.leftToLeft = r11.getInt(r5, -1);
            goto L117
        L106:
            this.guidePercent = r11.getFloat(r5, this.guidePercent);
            goto L117
        L107:
            this.guideEnd = r11.getDimensionPixelOffset(r5, this.guideEnd);
            goto L117
        L108:
            this.guideBegin = r11.getDimensionPixelOffset(r5, this.guideBegin);
            goto L117
        L109:
            float r26 = r11.getFloat(r5, this.circleAngle) % 360.0f;
            this.circleAngle = r26;
            if (r26 >= 0.0f) goto L117;
            this.circleAngle = (360.0f - r26) % 360.0f;
            goto L117
        L112:
            this.circleRadius = r11.getDimensionPixelSize(r5, this.circleRadius);
            goto L117
        L113:
            int r27 = r11.getResourceId(r5, this.circleConstraint);
            this.circleConstraint = r27;
            if (r27 != (-1)) goto L117;
            this.circleConstraint = r11.getInt(r5, -1);
            goto L117
        L116:
            this.orientation = r11.getInt(r5, this.orientation);
            goto L117
        L120:
            this.matchConstraintMinHeight = r11.getDimensionPixelSize(r5, this.matchConstraintMinHeight);     // Catch: Exception -> L37
        L38:
            if (r11.getInt(r5, this.matchConstraintMinHeight) != (-2)) goto L117;
            this.matchConstraintMinHeight = -2;
            goto L117
        L122:
            this.matchConstraintMinWidth = r11.getDimensionPixelSize(r5, this.matchConstraintMinWidth);     // Catch: Exception -> L48
        L49:
            if (r11.getInt(r5, this.matchConstraintMinWidth) != (-2)) goto L117;
            this.matchConstraintMinWidth = -2;
            goto L117
        L124:
            this.matchConstraintMaxHeight = r11.getDimensionPixelSize(r5, this.matchConstraintMaxHeight);     // Catch: Exception -> L32
        L33:
            if (r11.getInt(r5, this.matchConstraintMaxHeight) != (-2)) goto L117;
            this.matchConstraintMaxHeight = -2;
            goto L117
        L126:
            this.matchConstraintMaxWidth = r11.getDimensionPixelSize(r5, this.matchConstraintMaxWidth);     // Catch: Exception -> L43
        L44:
            if (r11.getInt(r5, this.matchConstraintMaxWidth) != (-2)) goto L117;
            this.matchConstraintMaxWidth = -2;
            goto L117
        L118:
            r11.recycle();
            validate();
        }

        public void validate() {
            this.isGuideline = false;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            if (this.width != (-2)) goto L10;
            if (this.constrainedWidth == false) goto L10;
            this.horizontalDimensionFixed = false;
            if (this.matchConstraintDefaultWidth != 0) goto L10;
            this.matchConstraintDefaultWidth = 1;
        L10:
            if (this.height != (-2)) goto L17;
            if (this.constrainedHeight == false) goto L17;
            this.verticalDimensionFixed = false;
            if (this.matchConstraintDefaultHeight != 0) goto L17;
            this.matchConstraintDefaultHeight = 1;
        L17:
            if (this.width != 0) goto L19;
        L20:
            this.horizontalDimensionFixed = false;
            if (this.width == 0) goto L23;
        L26:
            if (this.height != 0) goto L28;
        L29:
            this.verticalDimensionFixed = false;
            if (this.height == 0) goto L32;
        L35:
            if (this.guidePercent == (-1.0f)) goto L37;
        L40:
            this.isGuideline = true;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            if ((this.widget instanceof androidx.constraintlayout.core.widgets.Guideline) == true) goto L43;
            this.widget = new androidx.constraintlayout.core.widgets.Guideline();
        L43:
            ((androidx.constraintlayout.core.widgets.Guideline) this.widget).setOrientation(this.orientation);
            return;
        L37:
            if (this.guideBegin != (-1)) goto L40;
            if (this.guideEnd != (-1)) goto L40;
            return;
        L32:
            if (this.matchConstraintDefaultHeight != 1) goto L35;
            this.height = -2;
            this.constrainedHeight = true;
            goto L35
        L28:
            if (this.height != (-1)) goto L35;
        L23:
            if (this.matchConstraintDefaultWidth != 1) goto L26;
            this.width = -2;
            this.constrainedWidth = true;
            goto L26
        L19:
            if (this.width != (-1)) goto L26;
            goto L20
        }

        public LayoutParams(int width, int height) {
            super(width, height);
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

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
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

        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        public void resolveLayoutDirection(int layoutDirection) {
            int r0 = this.leftMargin;
            int r1 = this.rightMargin;
            super.resolveLayoutDirection(layoutDirection);
            boolean r2 = false;
            if (1 != getLayoutDirection()) goto L5;
            boolean r11 = true;
        L6:
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
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
            if (r11 == false) goto L43;
            int r12 = this.startToEnd;
            if (r12 == (-1)) goto L12;
            this.resolvedRightToLeft = r12;
        L11:
            r2 = true;
        L15:
            int r13 = this.endToStart;
            if (r13 == (-1)) goto L18;
            this.resolvedLeftToRight = r13;
            r2 = true;
        L18:
            int r14 = this.endToEnd;
            if (r14 == (-1)) goto L21;
            this.resolvedLeftToLeft = r14;
            r2 = true;
        L21:
            int r15 = this.goneStartMargin;
            if (r15 == Integer.MIN_VALUE) goto L24;
            this.resolveGoneRightMargin = r15;
        L24:
            int r16 = this.goneEndMargin;
            if (r16 == Integer.MIN_VALUE) goto L28;
            this.resolveGoneLeftMargin = r16;
        L28:
            if (r2 == false) goto L31;
            this.resolvedHorizontalBias = 1.0f - r5;
        L31:
            if (this.isGuideline == false) goto L62;
            if (this.orientation != 1) goto L62;
            if (this.guidelineUseRtl == false) goto L62;
            if (r8 == (-1.0f)) goto L39;
            this.resolvedGuidePercent = 1.0f - r8;
            this.resolvedGuideBegin = -1;
            this.resolvedGuideEnd = -1;
            goto L62
        L39:
            if (r6 == (-1)) goto L41;
            this.resolvedGuideEnd = r6;
            this.resolvedGuideBegin = -1;
            this.resolvedGuidePercent = -1.0f;
            goto L62
        L41:
            if (r7 == (-1)) goto L62;
            this.resolvedGuideBegin = r7;
            this.resolvedGuideEnd = -1;
            this.resolvedGuidePercent = -1.0f;
        L62:
            if (this.endToStart == (-1)) goto L64;
            return;
        L64:
            if (this.endToEnd == (-1)) goto L66;
            return;
        L66:
            if (this.startToStart == (-1)) goto L68;
            return;
        L68:
            if (this.startToEnd != (-1)) goto L97;
            int r17 = this.rightToLeft;
            if (r17 == (-1)) goto L75;
            this.resolvedRightToLeft = r17;
            if (this.rightMargin > 0) goto L81;
            if (r1 <= 0) goto L81;
            this.rightMargin = r1;
        L81:
            int r18 = this.leftToLeft;
            if (r18 == (-1)) goto L87;
            this.resolvedLeftToLeft = r18;
            if (this.leftMargin > 0) goto L98;
            if (r0 <= 0) goto L99;
            this.leftMargin = r0;
            return;
        L99:
            return;
        L98:
            return;
        L87:
            int r19 = this.leftToRight;
            if (r19 == (-1)) goto L101;
            this.resolvedLeftToRight = r19;
            if (this.leftMargin > 0) goto L102;
            if (r0 <= 0) goto L103;
            this.leftMargin = r0;
            return;
        L103:
            return;
        L102:
            return;
        L101:
            return;
        L75:
            int r110 = this.rightToRight;
            if (r110 == (-1)) goto L81;
            this.resolvedRightToRight = r110;
            if (this.rightMargin > 0) goto L81;
            if (r1 <= 0) goto L81;
            this.rightMargin = r1;
            goto L81
        L97:
            return;
        L12:
            int r111 = this.startToStart;
            if (r111 == (-1)) goto L15;
            this.resolvedRightToRight = r111;
            goto L11
        L43:
            int r112 = this.startToEnd;
            if (r112 == (-1)) goto L46;
            this.resolvedLeftToRight = r112;
        L46:
            int r113 = this.startToStart;
            if (r113 == (-1)) goto L49;
            this.resolvedLeftToLeft = r113;
        L49:
            int r114 = this.endToStart;
            if (r114 == (-1)) goto L52;
            this.resolvedRightToLeft = r114;
        L52:
            int r115 = this.endToEnd;
            if (r115 == (-1)) goto L55;
            this.resolvedRightToRight = r115;
        L55:
            int r116 = this.goneStartMargin;
            if (r116 == Integer.MIN_VALUE) goto L58;
            this.resolveGoneLeftMargin = r116;
        L58:
            int r117 = this.goneEndMargin;
            if (r117 == Integer.MIN_VALUE) goto L62;
            this.resolveGoneRightMargin = r117;
            goto L62
        L5:
            r11 = false;
            goto L6
        }

        public String getConstraintTag() {
            return this.constraintTag;
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

        public void captureLayoutInfo(int widthSpec, int heightSpec, int top, int bottom, int width, int height) {
            this.paddingTop = top;
            this.paddingBottom = bottom;
            this.paddingWidth = width;
            this.paddingHeight = height;
            this.layoutWidthSpec = widthSpec;
            this.layoutHeightSpec = heightSpec;
        }

        public Measurer(final ConstraintLayout this$0, ConstraintLayout l) {
            this.this$0 = this$0;
            this.layout = l;
        }

        @Override // androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer
        public final void measure(ConstraintWidget widget, BasicMeasure.Measure measure) {
            if (widget != null) goto L6;
            return;
        L6:
            if (widget.getVisibility() != 8) goto L12;
            if (widget.isInPlaceholder() == true) goto L12;
            measure.measuredWidth = 0;
            measure.measuredHeight = 0;
            measure.measuredBaseline = 0;
            return;
        L12:
            if (widget.getParent() != null) goto L14;
            return;
        L14:
            ConstraintWidget.DimensionBehaviour r3 = measure.horizontalBehavior;
            ConstraintWidget.DimensionBehaviour r4 = measure.verticalBehavior;
            int r6 = measure.horizontalDimension;
            int r7 = measure.verticalDimension;
            int r8 = this.paddingTop + this.paddingBottom;
            int r9 = this.paddingWidth;
            View r10 = (View) widget.getCompanionWidget();
            int r11 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[r3.ordinal()];
            if (r11 == 1) goto L48;
            if (r11 == 2) goto L47;
            if (r11 == 3) goto L46;
            if (r11 == 4) goto L20;
            int r12 = 0;
        L49:
            int r13 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[r4.ordinal()];
            if (r13 == 1) goto L85;
            if (r13 != 2) goto L53;
            int r5 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, r8, -2);
        L86:
            ConstraintWidgetContainer r14 = (ConstraintWidgetContainer) widget.getParent();
            if (r14 == null) goto L112;
            if (Optimizer.enabled(ConstraintLayout.access$000(this.this$0), 256) == false) goto L112;
            if (r10.getMeasuredWidth() != widget.getWidth()) goto L112;
            if (r10.getMeasuredWidth() >= r14.getWidth()) goto L112;
            if (r10.getMeasuredHeight() != widget.getHeight()) goto L112;
            if (r10.getMeasuredHeight() >= r14.getHeight()) goto L112;
            if (r10.getBaseline() != widget.getBaselineDistance()) goto L112;
            if (widget.isMeasureRequested() == true) goto L112;
            if (isSimilarSpec(widget.getLastHorizontalMeasureSpec(), r12, widget.getWidth()) == true) goto L105;
        L107:
            boolean r15 = false;
        L108:
            if (r15 == false) goto L112;
            measure.measuredWidth = widget.getWidth();
            measure.measuredHeight = widget.getHeight();
            measure.measuredBaseline = widget.getBaselineDistance();
            return;
        L105:
            if (isSimilarSpec(widget.getLastVerticalMeasureSpec(), r5, widget.getHeight()) == false) goto L107;
            r15 = true;
        L112:
            if (r3 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L114;
            boolean r16 = true;
        L116:
            if (r4 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L118;
            boolean r17 = true;
        L120:
            if (r4 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L122;
        L125:
            boolean r18 = true;
        L127:
            if (r3 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L129;
        L132:
            boolean r19 = true;
        L134:
            if (r16 == true) goto L136;
        L138:
            boolean r110 = false;
        L139:
            if (r17 == true) goto L141;
        L143:
            boolean r20 = false;
        L144:
            if (r10 != null) goto L146;
            return;
        L146:
            LayoutParams r111 = (LayoutParams) r10.getLayoutParams();
            if (measure.measureStrategy == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS) goto L159;
            if (measure.measureStrategy == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L159;
            if (r16 == false) goto L159;
            if (widget.mMatchConstraintDefaultWidth != 0) goto L159;
            if (r17 == false) goto L159;
            if (widget.mMatchConstraintDefaultHeight != 0) goto L159;
            int r0 = -1;
            int r112 = 0;
            int r113 = 0;
            int r114 = 0;
        L198:
            if (r112 == r0) goto L200;
            boolean r21 = true;
        L202:
            if (r113 == measure.horizontalDimension) goto L204;
        L207:
            boolean r1 = true;
        L208:
            measure.measuredNeedsSolverPass = r1;
            if (r111.needsBaseline == false) goto L211;
            r21 = true;
        L211:
            if (r21 == true) goto L213;
        L217:
            measure.measuredWidth = r113;
            measure.measuredHeight = r114;
            measure.measuredHasBaseline = r21;
            measure.measuredBaseline = r112;
            return;
        L213:
            if (r112 == (-1)) goto L217;
            if (widget.getBaselineDistance() == r112) goto L217;
            measure.measuredNeedsSolverPass = true;
            goto L217
        L204:
            if (r114 != measure.verticalDimension) goto L207;
            r1 = false;
            goto L208
        L200:
            r21 = false;
        L159:
            if ((r10 instanceof VirtualLayout) == true) goto L161;
        L163:
            r10.measure(r12, r5);
        L164:
            widget.setLastMeasureSpec(r12, r5);
            int r22 = r10.getMeasuredWidth();
            int r23 = r10.getMeasuredHeight();
            r112 = r10.getBaseline();
            if (widget.mMatchConstraintMinWidth <= 0) goto L167;
            r113 = Math.max(widget.mMatchConstraintMinWidth, r22);
        L169:
            if (widget.mMatchConstraintMaxWidth <= 0) goto L172;
            r113 = Math.min(widget.mMatchConstraintMaxWidth, r113);
        L172:
            if (widget.mMatchConstraintMinHeight <= 0) goto L174;
            r114 = Math.max(widget.mMatchConstraintMinHeight, r23);
        L176:
            if (widget.mMatchConstraintMaxHeight <= 0) goto L179;
            r114 = Math.min(widget.mMatchConstraintMaxHeight, r114);
        L179:
            if (Optimizer.enabled(ConstraintLayout.access$000(this.this$0), 1) == false) goto L181;
        L187:
            if (r22 != r113) goto L192;
            if (r23 != r114) goto L192;
        L190:
            r0 = -1;
        L192:
            if (r22 == r113) goto L194;
            r12 = View.MeasureSpec.makeMeasureSpec(r113, 1073741824);
        L194:
            if (r23 == r114) goto L196;
            int r24 = View.MeasureSpec.makeMeasureSpec(r114, 1073741824);
        L197:
            r10.measure(r12, r24);
            widget.setLastMeasureSpec(r12, r24);
            r113 = r10.getMeasuredWidth();
            r114 = r10.getMeasuredHeight();
            r112 = r10.getBaseline();
            goto L190
        L196:
            r24 = r5;
            goto L197
        L181:
            if (r110 == false) goto L184;
            if (r18 == false) goto L184;
            r113 = (int) ((r114 * widget.mDimensionRatio) + 0.5f);
        L184:
            if (r20 == false) goto L187;
            if (r19 == false) goto L187;
            r114 = (int) ((r113 / widget.mDimensionRatio) + 0.5f);
            goto L187
        L174:
            r114 = r23;
            goto L176
        L167:
            r113 = r22;
            goto L169
        L161:
            if ((widget instanceof androidx.constraintlayout.core.widgets.VirtualLayout) == false) goto L163;
            ((VirtualLayout) r10).onMeasure((androidx.constraintlayout.core.widgets.VirtualLayout) widget, r12, r5);
            goto L164
        L141:
            if (widget.mDimensionRatio <= 0.0f) goto L143;
            r20 = true;
            goto L144
        L136:
            if (widget.mDimensionRatio <= 0.0f) goto L138;
            r110 = true;
            goto L139
        L129:
            if (r3 == ConstraintWidget.DimensionBehaviour.FIXED) goto L132;
            r19 = false;
            goto L134
        L122:
            if (r4 == ConstraintWidget.DimensionBehaviour.FIXED) goto L125;
            r18 = false;
            goto L127
        L118:
            r17 = false;
            goto L120
        L114:
            r16 = false;
            goto L116
        L53:
            if (r13 != 3) goto L55;
            r5 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, r8 + widget.getVerticalMargin(), -1);
            goto L86
        L55:
            if (r13 == 4) goto L57;
            r5 = 0;
            goto L86
        L57:
            r5 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, r8, -2);
            if (widget.mMatchConstraintDefaultHeight != 1) goto L60;
            boolean r25 = true;
        L62:
            if (measure.measureStrategy == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS) goto L66;
            if (measure.measureStrategy != BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L86;
        L66:
            if (r10.getMeasuredWidth() != widget.getWidth()) goto L68;
            boolean r26 = true;
        L70:
            if (measure.measureStrategy == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L80;
            if (r25 == false) goto L80;
            if (r25 == false) goto L75;
            if (r26 == true) goto L80;
        L75:
            if ((r10 instanceof Placeholder) == true) goto L80;
            if (widget.isResolvedVertically() == true) goto L80;
            boolean r27 = false;
        L81:
            if (r27 == false) goto L86;
            r5 = View.MeasureSpec.makeMeasureSpec(widget.getHeight(), 1073741824);
        L80:
            r27 = true;
            goto L81
        L68:
            r26 = false;
            goto L70
        L60:
            r25 = false;
            goto L62
        L85:
            r5 = View.MeasureSpec.makeMeasureSpec(r7, 1073741824);
            goto L86
        L20:
            r12 = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, r9, -2);
            if (widget.mMatchConstraintDefaultWidth != 1) goto L23;
            boolean r28 = true;
        L25:
            if (measure.measureStrategy == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS) goto L29;
            if (measure.measureStrategy != BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L49;
        L29:
            if (r10.getMeasuredHeight() != widget.getHeight()) goto L31;
            boolean r115 = true;
        L33:
            if (measure.measureStrategy == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L43;
            if (r28 == false) goto L43;
            if (r28 == false) goto L38;
            if (r115 == true) goto L43;
        L38:
            if ((r10 instanceof Placeholder) == true) goto L43;
            if (widget.isResolvedHorizontally() == true) goto L43;
            boolean r29 = false;
        L44:
            if (r29 == false) goto L49;
            r12 = View.MeasureSpec.makeMeasureSpec(widget.getWidth(), 1073741824);
        L43:
            r29 = true;
            goto L44
        L31:
            r115 = false;
            goto L33
        L23:
            r28 = false;
            goto L25
        L46:
            r12 = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, r9 + widget.getHorizontalMargin(), -1);
            goto L49
        L47:
            r12 = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, r9, -2);
            goto L49
        L48:
            r12 = View.MeasureSpec.makeMeasureSpec(r6, 1073741824);
            goto L49
        }

        private boolean isSimilarSpec(int lastMeasureSpec, int spec, int widgetSize) {
            if (lastMeasureSpec != spec) goto L5;
            return true;
        L5:
            int r0 = View.MeasureSpec.getMode(lastMeasureSpec);
            View.MeasureSpec.getSize(lastMeasureSpec);
            int r3 = View.MeasureSpec.getMode(spec);
            int r4 = View.MeasureSpec.getSize(spec);
            if (r3 == 1073741824) goto L8;
            return false;
        L8:
            if (r0 == Integer.MIN_VALUE) goto L10;
            if (r0 == 0) goto L10;
            return false;
        L10:
            if (widgetSize != r4) goto L15;
            return true;
        L15:
            return false;
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
    }

    static {
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    static /* synthetic */ int access$000(ConstraintLayout r0) {
        return r0.mOptimizationLevel;
    }

    static /* synthetic */ ArrayList access$100(ConstraintLayout r0) {
        return r0.mConstraintHelpers;
    }

    @Override // android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return generateLayoutParams(attrs);
    }

    public static SharedValues getSharedValues() {
        if (sSharedValues != null) goto L6;
        sSharedValues = new SharedValues();
    L6:
        return sSharedValues;
    }

    public void setDesignInformation(int type, Object value1, Object value2) {
        if (type == 0) goto L4;
        return;
    L4:
        if ((value1 instanceof String) == true) goto L6;
        return;
    L6:
        if ((value2 instanceof Integer) == true) goto L8;
        return;
    L8:
        if (this.mDesignIds != null) goto L10;
        this.mDesignIds = new HashMap();
    L10:
        String r3 = (String) value1;
        int r2 = r3.indexOf(LibrarianImpl.Constants.SEPARATOR);
        if (r2 == (-1)) goto L13;
        r3 = r3.substring(r2 + 1);
    L13:
        int r4 = ((Integer) value2).intValue();
        this.mDesignIds.put(r3, Integer.valueOf(r4));
    }

    public Object getDesignInformation(int type, Object value) {
        if (type == 0) goto L4;
        return null;
    L4:
        if ((value instanceof String) == false) goto L13;
        String r2 = (String) value;
        HashMap<String, Integer> r1 = this.mDesignIds;
        if (r1 != null) goto L8;
        return null;
    L8:
        if (r1.containsKey(r2) == true) goto L10;
        return null;
    L10:
        return this.mDesignIds.get(r2);
    L13:
        return null;
    }

    public ConstraintLayout(Context context) {
        super(context);
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

    public ConstraintLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
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
        init(attrs, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
        init(attrs, defStyleAttr, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
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
        init(attrs, defStyleAttr, defStyleRes);
    }

    @Override // android.view.View
    public void setId(int id) {
        this.mChildrenByIds.remove(getId());
        super.setId(id);
        this.mChildrenByIds.put(getId(), this);
    }

    private void init(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.mLayoutWidget.setCompanionWidget(this);
        this.mLayoutWidget.setMeasurer(this.mMeasurer);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attrs == null) goto L37;
        TypedArray r6 = getContext().obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_Layout, defStyleAttr, defStyleRes);
        int r7 = r6.getIndexCount();
        int r1 = 0;
    L5:
        if (r1 >= r7) goto L36;
        int r2 = r6.getIndex(r1);
        if (r2 != R.styleable.ConstraintLayout_Layout_android_minWidth) goto L10;
        this.mMinWidth = r6.getDimensionPixelOffset(r2, this.mMinWidth);
    L35:
        r1 = r1 + 1;
        goto L5
    L10:
        if (r2 != R.styleable.ConstraintLayout_Layout_android_minHeight) goto L13;
        this.mMinHeight = r6.getDimensionPixelOffset(r2, this.mMinHeight);
        goto L35
    L13:
        if (r2 != R.styleable.ConstraintLayout_Layout_android_maxWidth) goto L16;
        this.mMaxWidth = r6.getDimensionPixelOffset(r2, this.mMaxWidth);
        goto L35
    L16:
        if (r2 != R.styleable.ConstraintLayout_Layout_android_maxHeight) goto L19;
        this.mMaxHeight = r6.getDimensionPixelOffset(r2, this.mMaxHeight);
        goto L35
    L19:
        if (r2 != R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) goto L22;
        this.mOptimizationLevel = r6.getInt(r2, this.mOptimizationLevel);
        goto L35
    L22:
        if (r2 != R.styleable.ConstraintLayout_Layout_layoutDescription) goto L29;
        int r3 = r6.getResourceId(r2, 0);
        if (r3 == 0) goto L35;
        parseLayoutDescription(r3);     // Catch: Resources.NotFoundException -> L27
    L27:
        this.mConstraintLayoutSpec = null;
        goto L35
    L29:
        if (r2 != R.styleable.ConstraintLayout_Layout_constraintSet) goto L35;
        int r4 = r6.getResourceId(r2, 0);
        ConstraintSet r5 = new ConstraintSet();     // Catch: Resources.NotFoundException -> L33
        this.mConstraintSet = r5;     // Catch: Resources.NotFoundException -> L33
        r5.load(getContext(), r4);     // Catch: Resources.NotFoundException -> L33
    L34:
        this.mConstraintSetId = r4;
    L33:
        this.mConstraintSet = null;
        goto L34
    L36:
        r6.recycle();
    L37:
        this.mLayoutWidget.setOptimizationLevel(this.mOptimizationLevel);
    }

    protected void parseLayoutDescription(int id) {
        this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, id);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        ConstraintWidget r0 = getViewWidget(view);
        if ((view instanceof Guideline) == false) goto L8;
        if ((r0 instanceof androidx.constraintlayout.core.widgets.Guideline) == true) goto L8;
        LayoutParams r1 = (LayoutParams) view.getLayoutParams();
        r1.widget = new androidx.constraintlayout.core.widgets.Guideline();
        r1.isGuideline = true;
        ((androidx.constraintlayout.core.widgets.Guideline) r1.widget).setOrientation(r1.orientation);
    L8:
        if ((view instanceof ConstraintHelper) == false) goto L12;
        ConstraintHelper r2 = (ConstraintHelper) view;
        r2.validateParams();
        ((LayoutParams) view.getLayoutParams()).isHelper = true;
        if (this.mConstraintHelpers.contains(r2) == true) goto L12;
        this.mConstraintHelpers.add(r2);
    L12:
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.mChildrenByIds.remove(view.getId());
        ConstraintWidget r0 = getViewWidget(view);
        this.mLayoutWidget.remove(r0);
        this.mConstraintHelpers.remove(view);
        this.mDirtyHierarchy = true;
    }

    public void setMinWidth(int value) {
        if (value != this.mMinWidth) goto L5;
        return;
    L5:
        this.mMinWidth = value;
        requestLayout();
    }

    public void setMinHeight(int value) {
        if (value != this.mMinHeight) goto L5;
        return;
    L5:
        this.mMinHeight = value;
        requestLayout();
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public void setMaxWidth(int value) {
        if (value != this.mMaxWidth) goto L5;
        return;
    L5:
        this.mMaxWidth = value;
        requestLayout();
    }

    public void setMaxHeight(int value) {
        if (value != this.mMaxHeight) goto L5;
        return;
    L5:
        this.mMaxHeight = value;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
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

    protected void applyConstraintsFromLayoutParams(boolean isInEditMode, View child, ConstraintWidget widget, LayoutParams layoutParams, SparseArray<ConstraintWidget> idToWidget) {
        layoutParams.validate();
        layoutParams.helped = false;
        widget.setVisibility(child.getVisibility());
        if (layoutParams.isInPlaceholder == false) goto L5;
        widget.setInPlaceholder(true);
        widget.setVisibility(8);
    L5:
        widget.setCompanionWidget(child);
        if ((child instanceof ConstraintHelper) == false) goto L10;
        ((ConstraintHelper) child).resolveRtl(widget, this.mLayoutWidget.isRtl());
    L10:
        if (layoutParams.isGuideline == false) goto L18;
        androidx.constraintlayout.core.widgets.Guideline r0 = (androidx.constraintlayout.core.widgets.Guideline) widget;
        int r1 = layoutParams.resolvedGuideBegin;
        int r2 = layoutParams.resolvedGuideEnd;
        float r3 = layoutParams.resolvedGuidePercent;
        if (r3 == (-1.0f)) goto L14;
        r0.setGuidePercent(r3);
        return;
    L14:
        if (r1 == (-1)) goto L16;
        r0.setGuideBegin(r1);
        return;
    L16:
        if (r2 == (-1)) goto L110;
        r0.setGuideEnd(r2);
        return;
    L110:
        return;
    L18:
        int r4 = layoutParams.resolvedLeftToLeft;
        int r5 = layoutParams.resolvedLeftToRight;
        int r12 = layoutParams.resolvedRightToLeft;
        int r13 = layoutParams.resolvedRightToRight;
        int r6 = layoutParams.resolveGoneLeftMargin;
        int r14 = layoutParams.resolveGoneRightMargin;
        float r15 = layoutParams.resolvedHorizontalBias;
        if (layoutParams.circleConstraint == (-1)) goto L23;
        ConstraintWidget r7 = idToWidget.get(layoutParams.circleConstraint);
        if (r7 == null) goto L74;
        widget.connectCircularConstraint(r7, layoutParams.circleAngle, layoutParams.circleRadius);
    L74:
        if (isInEditMode == false) goto L81;
        if (layoutParams.editorAbsoluteX == (-1)) goto L78;
    L79:
        widget.setOrigin(layoutParams.editorAbsoluteX, layoutParams.editorAbsoluteY);
        goto L81
    L78:
        if (layoutParams.editorAbsoluteY != (-1)) goto L79;
    L81:
        if (layoutParams.horizontalDimensionFixed == false) goto L83;
        widget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        widget.setWidth(layoutParams.width);
        if (layoutParams.width != (-2)) goto L94;
        widget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
    L94:
        if (layoutParams.verticalDimensionFixed == false) goto L96;
        widget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        widget.setHeight(layoutParams.height);
        if (layoutParams.height != (-2)) goto L106;
        widget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
    L106:
        widget.setDimensionRatio(layoutParams.dimensionRatio);
        widget.setHorizontalWeight(layoutParams.horizontalWeight);
        widget.setVerticalWeight(layoutParams.verticalWeight);
        widget.setHorizontalChainStyle(layoutParams.horizontalChainStyle);
        widget.setVerticalChainStyle(layoutParams.verticalChainStyle);
        widget.setWrapBehaviorInParent(layoutParams.wrapBehaviorInParent);
        widget.setHorizontalMatchStyle(layoutParams.matchConstraintDefaultWidth, layoutParams.matchConstraintMinWidth, layoutParams.matchConstraintMaxWidth, layoutParams.matchConstraintPercentWidth);
        widget.setVerticalMatchStyle(layoutParams.matchConstraintDefaultHeight, layoutParams.matchConstraintMinHeight, layoutParams.matchConstraintMaxHeight, layoutParams.matchConstraintPercentHeight);
        return;
    L96:
        if (layoutParams.height == (-1)) goto L98;
        widget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        widget.setHeight(0);
        goto L106
    L98:
        if (layoutParams.constrainedHeight == false) goto L100;
        widget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
    L101:
        ConstraintAnchor r8 = widget.getAnchor(ConstraintAnchor.Type.TOP);
        r8.mMargin = layoutParams.topMargin;
        ConstraintAnchor r9 = widget.getAnchor(ConstraintAnchor.Type.BOTTOM);
        r9.mMargin = layoutParams.bottomMargin;
        goto L106
    L100:
        widget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
        goto L101
    L83:
        if (layoutParams.width == (-1)) goto L85;
        widget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        widget.setWidth(0);
        goto L94
    L85:
        if (layoutParams.constrainedWidth == false) goto L87;
        widget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
    L88:
        ConstraintAnchor r10 = widget.getAnchor(ConstraintAnchor.Type.LEFT);
        r10.mMargin = layoutParams.leftMargin;
        ConstraintAnchor r11 = widget.getAnchor(ConstraintAnchor.Type.RIGHT);
        r11.mMargin = layoutParams.rightMargin;
        goto L94
    L87:
        widget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
        goto L88
    L23:
        if (r4 == (-1)) goto L27;
        ConstraintWidget r16 = idToWidget.get(r4);
        if (r16 == null) goto L31;
        widget.immediateConnect(ConstraintAnchor.Type.LEFT, r16, ConstraintAnchor.Type.LEFT, layoutParams.leftMargin, r6);
    L31:
        if (r12 == (-1)) goto L35;
        ConstraintWidget r17 = idToWidget.get(r12);
        if (r17 == null) goto L40;
        widget.immediateConnect(ConstraintAnchor.Type.RIGHT, r17, ConstraintAnchor.Type.LEFT, layoutParams.rightMargin, r14);
    L40:
        if (layoutParams.topToTop == (-1)) goto L45;
        ConstraintWidget r18 = idToWidget.get(layoutParams.topToTop);
        if (r18 == null) goto L50;
        widget.immediateConnect(ConstraintAnchor.Type.TOP, r18, ConstraintAnchor.Type.TOP, layoutParams.topMargin, layoutParams.goneTopMargin);
    L50:
        if (layoutParams.bottomToTop == (-1)) goto L55;
        ConstraintWidget r19 = idToWidget.get(layoutParams.bottomToTop);
        if (r19 == null) goto L60;
        widget.immediateConnect(ConstraintAnchor.Type.BOTTOM, r19, ConstraintAnchor.Type.TOP, layoutParams.bottomMargin, layoutParams.goneBottomMargin);
    L60:
        if (layoutParams.baselineToBaseline == (-1)) goto L63;
        setWidgetBaseline(widget, layoutParams, idToWidget, layoutParams.baselineToBaseline, ConstraintAnchor.Type.BASELINE);
    L69:
        if (r15 < 0.0f) goto L72;
        widget.setHorizontalBiasPercent(r15);
    L72:
        if (layoutParams.verticalBias < 0.0f) goto L74;
        widget.setVerticalBiasPercent(layoutParams.verticalBias);
        goto L74
    L63:
        if (layoutParams.baselineToTop == (-1)) goto L66;
        setWidgetBaseline(widget, layoutParams, idToWidget, layoutParams.baselineToTop, ConstraintAnchor.Type.TOP);
        goto L69
    L66:
        if (layoutParams.baselineToBottom == (-1)) goto L69;
        setWidgetBaseline(widget, layoutParams, idToWidget, layoutParams.baselineToBottom, ConstraintAnchor.Type.BOTTOM);
        goto L69
    L55:
        if (layoutParams.bottomToBottom == (-1)) goto L60;
        ConstraintWidget r20 = idToWidget.get(layoutParams.bottomToBottom);
        if (r20 == null) goto L60;
        widget.immediateConnect(ConstraintAnchor.Type.BOTTOM, r20, ConstraintAnchor.Type.BOTTOM, layoutParams.bottomMargin, layoutParams.goneBottomMargin);
        goto L60
    L45:
        if (layoutParams.topToBottom == (-1)) goto L50;
        ConstraintWidget r21 = idToWidget.get(layoutParams.topToBottom);
        if (r21 == null) goto L50;
        widget.immediateConnect(ConstraintAnchor.Type.TOP, r21, ConstraintAnchor.Type.BOTTOM, layoutParams.topMargin, layoutParams.goneTopMargin);
        goto L50
    L35:
        if (r13 == (-1)) goto L40;
        ConstraintWidget r22 = idToWidget.get(r13);
        if (r22 == null) goto L40;
        widget.immediateConnect(ConstraintAnchor.Type.RIGHT, r22, ConstraintAnchor.Type.RIGHT, layoutParams.rightMargin, r14);
        goto L40
    L27:
        if (r5 == (-1)) goto L31;
        ConstraintWidget r23 = idToWidget.get(r5);
        if (r23 == null) goto L31;
        widget.immediateConnect(ConstraintAnchor.Type.LEFT, r23, ConstraintAnchor.Type.RIGHT, layoutParams.leftMargin, r6);
        goto L31
    }

    private void setWidgetBaseline(ConstraintWidget widget, LayoutParams layoutParams, SparseArray<ConstraintWidget> idToWidget, int baselineTarget, ConstraintAnchor.Type type) {
        View r1 = this.mChildrenByIds.get(baselineTarget);
        ConstraintWidget r4 = idToWidget.get(baselineTarget);
        if (r4 == null) goto L12;
        if (r1 != null) goto L6;
        return;
    L6:
        if ((r1.getLayoutParams() instanceof LayoutParams) == false) goto L14;
        layoutParams.needsBaseline = true;
        if (type != ConstraintAnchor.Type.BASELINE) goto L10;
        LayoutParams r2 = (LayoutParams) r1.getLayoutParams();
        r2.needsBaseline = true;
        r2.widget.setHasBaseline(true);
    L10:
        widget.getAnchor(ConstraintAnchor.Type.BASELINE).connect(r4.getAnchor(type), layoutParams.baselineMargin, layoutParams.goneBaselineMargin, true);
        widget.setHasBaseline(true);
        widget.getAnchor(ConstraintAnchor.Type.TOP).reset();
        widget.getAnchor(ConstraintAnchor.Type.BOTTOM).reset();
        return;
    L14:
        return;
    }

    private final ConstraintWidget getTargetWidget(int id) {
        if (id == 0) goto L4;
        View r0 = this.mChildrenByIds.get(id);
        if (r0 != null) goto L13;
        r0 = findViewById(id);
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

    public final ConstraintWidget getViewWidget(View view) {
        if (view == this) goto L4;
        if (view != null) goto L7;
        return null;
    L7:
        if ((view.getLayoutParams() instanceof LayoutParams) == true) goto L9;
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if ((view.getLayoutParams() instanceof LayoutParams) == true) goto L13;
        return null;
    L13:
        return ((LayoutParams) view.getLayoutParams()).widget;
    L9:
        return ((LayoutParams) view.getLayoutParams()).widget;
    L4:
        return this.mLayoutWidget;
    }

    public void fillMetrics(Metrics metrics) {
        this.mMetrics = metrics;
        this.mLayoutWidget.fillMetrics(metrics);
    }

    protected void resolveSystem(ConstraintWidgetContainer layout, int optimizationLevel, int widthMeasureSpec, int heightMeasureSpec) {
        int r7 = View.MeasureSpec.getMode(widthMeasureSpec);
        int r0 = View.MeasureSpec.getSize(widthMeasureSpec);
        int r8 = View.MeasureSpec.getMode(heightMeasureSpec);
        int r1 = View.MeasureSpec.getSize(heightMeasureSpec);
        int r16 = Math.max(0, getPaddingTop());
        int r13 = Math.max(0, getPaddingBottom());
        int r2 = r16 + r13;
        int r4 = getPaddingWidth();
        this.mMeasurer.captureLayoutInfo(widthMeasureSpec, heightMeasureSpec, r16, r13, r4, r2);
        int r5 = Math.max(0, getPaddingStart());
        int r9 = Math.max(0, getPaddingEnd());
        if (r5 > 0) goto L8;
        if (r9 > 0) goto L8;
        r9 = Math.max(0, getPaddingLeft());
    L11:
        int r10 = r0 - r4;
        int r11 = r1 - r2;
        setSelfDimensionBehaviour(layout, r7, r10, r8, r11);
        layout.measure(optimizationLevel, r7, r10, r8, r11, this.mLastMeasureWidth, this.mLastMeasureHeight, r9, r16);
        return;
    L8:
        if (isRtl() == true) goto L11;
        r9 = r5;
        goto L11
    }

    protected void resolveMeasuredDimension(int widthMeasureSpec, int heightMeasureSpec, int measuredWidth, int measuredHeight, boolean isWidthMeasuredTooSmall, boolean isHeightMeasuredTooSmall) {
        int r0 = this.mMeasurer.paddingHeight;
        int r3 = resolveSizeAndState(measuredWidth + this.mMeasurer.paddingWidth, widthMeasureSpec, 0);
        int r4 = resolveSizeAndState(measuredHeight + r0, heightMeasureSpec, 0) & 16777215;
        int r5 = this.mMaxWidth;
        int r6 = Math.min(r5, r3 & 16777215);
        int r7 = Math.min(this.mMaxHeight, r4);
        if (isWidthMeasuredTooSmall == false) goto L5;
        r6 = r6 | 16777216;
    L5:
        if (isHeightMeasuredTooSmall == false) goto L7;
        r7 = r7 | 16777216;
    L7:
        setMeasuredDimension(r6, r7);
        this.mLastMeasureWidth = r6;
        this.mLastMeasureHeight = r7;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.mOnMeasureWidthMeasureSpec != widthMeasureSpec) goto L6;
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
        this.mOnMeasureWidthMeasureSpec = widthMeasureSpec;
        this.mOnMeasureHeightMeasureSpec = heightMeasureSpec;
        this.mLayoutWidget.setRtl(isRtl());
        if (this.mDirtyHierarchy == false) goto L18;
        this.mDirtyHierarchy = false;
        if (updateHierarchy() == false) goto L18;
        this.mLayoutWidget.updateHierarchy();
    L18:
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, widthMeasureSpec, heightMeasureSpec);
        resolveMeasuredDimension(widthMeasureSpec, heightMeasureSpec, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
    }

    protected boolean isRtl() {
        if ((getContext().getApplicationInfo().flags & 4194304) == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return false;
    L8:
        if (1 == getLayoutDirection()) goto L10;
        return false;
    L10:
        return true;
    L5:
        r0 = false;
        goto L6
    }

    private int getPaddingWidth() {
        int r0 = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int r2 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        if (r2 > 0) goto L5;
        return r0;
    L5:
        return r2;
    }

    protected void setSelfDimensionBehaviour(ConstraintWidgetContainer layout, int widthMode, int widthSize, int heightMode, int heightSize) {
        int r0 = this.mMeasurer.paddingHeight;
        int r1 = this.mMeasurer.paddingWidth;
        ConstraintWidget.DimensionBehaviour r2 = ConstraintWidget.DimensionBehaviour.FIXED;
        ConstraintWidget.DimensionBehaviour r3 = ConstraintWidget.DimensionBehaviour.FIXED;
        int r4 = getChildCount();
        if (widthMode == Integer.MIN_VALUE) goto L11;
        if (widthMode == 0) goto L8;
        if (widthMode == 1073741824) goto L7;
    L6:
        widthSize = 0;
    L14:
        if (heightMode == Integer.MIN_VALUE) goto L22;
        if (heightMode == 0) goto L19;
        if (heightMode == 1073741824) goto L18;
    L17:
        heightSize = 0;
    L26:
        if (widthSize == layout.getWidth()) goto L28;
    L29:
        layout.invalidateMeasures();
    L30:
        layout.setX(0);
        layout.setY(0);
        layout.setMaxWidth(this.mMaxWidth - r1);
        layout.setMaxHeight(this.mMaxHeight - r0);
        layout.setMinWidth(0);
        layout.setMinHeight(0);
        layout.setHorizontalDimensionBehaviour(r2);
        layout.setWidth(widthSize);
        layout.setVerticalDimensionBehaviour(r3);
        layout.setHeight(heightSize);
        layout.setMinWidth(this.mMinWidth - r1);
        layout.setMinHeight(this.mMinHeight - r0);
        return;
    L28:
        if (heightSize == layout.getHeight()) goto L30;
    L18:
        heightSize = Math.min(this.mMaxHeight - r0, heightSize);
        goto L26
    L19:
        r3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r4 != 0) goto L17;
        heightSize = Math.max(0, this.mMinHeight);
        goto L26
    L22:
        r3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r4 != 0) goto L26;
        heightSize = Math.max(0, this.mMinHeight);
        goto L26
    L7:
        widthSize = Math.min(this.mMaxWidth - r1, widthSize);
        goto L14
    L8:
        r2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r4 != 0) goto L6;
        widthSize = Math.max(0, this.mMinWidth);
        goto L14
    L11:
        r2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r4 != 0) goto L14;
        widthSize = Math.max(0, this.mMinWidth);
        goto L14
    }

    public void setState(int id, int screenWidth, int screenHeight) {
        ConstraintLayoutStates r0 = this.mConstraintLayoutSpec;
        if (r0 == null) goto L6;
        r0.updateConstraints(id, screenWidth, screenHeight);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int r6 = getChildCount();
        boolean r7 = isInEditMode();
        int r8 = 0;
        int r9 = 0;
    L3:
        if (r9 >= r6) goto L23;
        View r10 = getChildAt(r9);
        LayoutParams r0 = (LayoutParams) r10.getLayoutParams();
        ConstraintWidget r1 = r0.widget;
        if (r10.getVisibility() != 8) goto L15;
        if (r0.isGuideline == true) goto L15;
        if (r0.isHelper == true) goto L15;
        if (r0.isVirtualGroup == true) goto L15;
        if (r7 == true) goto L15;
    L22:
        r9 = r9 + 1;
    L15:
        if (r0.isInPlaceholder == true) goto L22;
        int r2 = r1.getX();
        int r3 = r1.getY();
        int r4 = r1.getWidth() + r2;
        int r5 = r1.getHeight() + r3;
        r10.layout(r2, r3, r4, r5);
        if ((r10 instanceof Placeholder) == false) goto L22;
        View r11 = ((Placeholder) r10).getContent();
        if (r11 == null) goto L22;
        r11.setVisibility(0);
        r11.layout(r2, r3, r4, r5);
        goto L22
    L23:
        int r12 = this.mConstraintHelpers.size();
        if (r12 <= 0) goto L27;
    L25:
        if (r8 >= r12) goto L35;
        this.mConstraintHelpers.get(r8).updatePostLayout(this);
        r8 = r8 + 1;
        goto L25
    L35:
        return;
    }

    public void setOptimizationLevel(int level) {
        this.mOptimizationLevel = level;
        this.mLayoutWidget.setOptimizationLevel(level);
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.getOptimizationLevel();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    @Override // android.view.ViewGroup
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return new LayoutParams(p);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof LayoutParams;
    }

    public void setConstraintSet(ConstraintSet set) {
        this.mConstraintSet = set;
    }

    public View getViewById(int id) {
        return this.mChildrenByIds.get(id);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
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
        super.dispatchDraw(canvas);
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
        canvas.drawLine(r18, r19, r20, r19, r17);
        float r21 = r15 + r16;
        canvas.drawLine(r20, r19, r20, r21, r17);
        canvas.drawLine(r20, r21, r18, r21, r17);
        canvas.drawLine(r18, r21, r18, r19, r17);
        r17.setColor(-16711936);
        canvas.drawLine(r18, r19, r20, r21, r17);
        canvas.drawLine(r18, r21, r20, r19, r17);
    L23:
        r7 = r7 + 1;
        goto L12
    L32:
        return;
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
        ConstraintLayoutStates r0 = this.mConstraintLayoutSpec;
        if (r0 == null) goto L6;
        r0.setOnConstraintsChanged(constraintsChangedListener);
        return;
    }

    public void loadLayoutDescription(int layoutDescription) {
        if (layoutDescription != 0) goto L9;
        this.mConstraintLayoutSpec = null;
        return;
    L9:
        this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, layoutDescription);     // Catch: Resources.NotFoundException -> L6
        return;
    L6:
        this.mConstraintLayoutSpec = null;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        markHierarchyDirty();
        super.requestLayout();
    }

    @Override // android.view.View
    public void forceLayout() {
        markHierarchyDirty();
        super.forceLayout();
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
}
