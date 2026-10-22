package com.obric.oui.constraintlayout.widget;

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
import androidx.core.internal.view.SupportMenu;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.oui.constraintlayout.core.Metrics;
import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidgetContainer;
import com.obric.oui.constraintlayout.core.widgets.Optimizer;
import com.obric.oui.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class ConstraintLayout extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final boolean OPTIMIZE_HEIGHT_CHANGE = false;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.2.0-alpha04";
    private static SharedValues sSharedValues;
    SparseArray<View> mChildrenByIds;
    private ArrayList<ConstraintHelper> mConstraintHelpers;
    protected ConstraintLayoutStates mConstraintLayoutSpec;
    private ConstraintSet mConstraintSet;
    private int mConstraintSetId;
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
    private ArrayList<ValueModifier> mModifiers;
    private int mOnMeasureHeightMeasureSpec;
    private int mOnMeasureWidthMeasureSpec;
    private int mOptimizationLevel;
    private SparseArray<ConstraintWidget> mTempMapIdToWidget;

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.widget.ConstraintLayout$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$oui$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour = null;

        static {
            int[] r0 = new int[ConstraintWidget.DimensionBehaviour.values().length];
            $SwitchMap$com$obric$oui$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour = r0;
            r0[ConstraintWidget.DimensionBehaviour.FIXED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$obric$oui$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[ConstraintWidget.DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$obric$oui$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[ConstraintWidget.DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$obric$oui$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
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
        public boolean helped;
        public float horizontalBias;
        public int horizontalChainStyle;
        public float horizontalWeight;
        public int leftToLeft;
        public int leftToRight;
        int mDimensionRatioSide;
        float mDimensionRatioValue;
        boolean mHeightSet;
        boolean mHorizontalDimensionFixed;
        boolean mIsGuideline;
        boolean mIsHelper;
        boolean mIsInPlaceholder;
        boolean mIsVirtualGroup;
        boolean mNeedsBaseline;
        int mResolveGoneLeftMargin;
        int mResolveGoneRightMargin;
        int mResolvedGuideBegin;
        int mResolvedGuideEnd;
        float mResolvedGuidePercent;
        float mResolvedHorizontalBias;
        int mResolvedLeftToLeft;
        int mResolvedLeftToRight;
        int mResolvedRightToLeft;
        int mResolvedRightToRight;
        boolean mVerticalDimensionFixed;
        ConstraintWidget mWidget;
        boolean mWidthSet;
        public int matchConstraintDefaultHeight;
        public int matchConstraintDefaultWidth;
        public int matchConstraintMaxHeight;
        public int matchConstraintMaxWidth;
        public int matchConstraintMinHeight;
        public int matchConstraintMinWidth;
        public float matchConstraintPercentHeight;
        public float matchConstraintPercentWidth;
        public int orientation;
        public int rightToLeft;
        public int rightToRight;
        public int startToEnd;
        public int startToStart;
        public int topToBottom;
        public int topToTop;
        public float verticalBias;
        public int verticalChainStyle;
        public float verticalWeight;
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
            public static final SparseIntArray sMap = null;

            private Table() {
            }

            static {
                SparseIntArray r0 = new SparseIntArray();
                sMap = r0;
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
            return this.mWidget;
        }

        public void setWidgetDebugName(String r1) {
            this.mWidget.setDebugName(r1);
        }

        public void reset() {
            ConstraintWidget r0 = this.mWidget;
            if (r0 == null) goto L6;
            r0.reset();
            return;
        }

        public LayoutParams(ViewGroup.LayoutParams r9) {
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
            this.mWidthSet = true;
            this.mHeightSet = true;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.mDimensionRatioValue = 0.0f;
            this.mDimensionRatioSide = 1;
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
            this.mHorizontalDimensionFixed = true;
            this.mVerticalDimensionFixed = true;
            this.mNeedsBaseline = false;
            this.mIsGuideline = false;
            this.mIsHelper = false;
            this.mIsInPlaceholder = false;
            this.mIsVirtualGroup = false;
            this.mResolvedLeftToLeft = -1;
            this.mResolvedLeftToRight = -1;
            this.mResolvedRightToLeft = -1;
            this.mResolvedRightToRight = -1;
            this.mResolveGoneLeftMargin = Integer.MIN_VALUE;
            this.mResolveGoneRightMargin = Integer.MIN_VALUE;
            this.mResolvedHorizontalBias = 0.5f;
            this.mWidget = new ConstraintWidget();
            this.helped = false;
            if ((r9 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
            ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) r9;
            this.leftMargin = r0.leftMargin;
            this.rightMargin = r0.rightMargin;
            this.topMargin = r0.topMargin;
            this.bottomMargin = r0.bottomMargin;
            setMarginStart(r0.getMarginStart());
            setMarginEnd(r0.getMarginEnd());
        L6:
            if ((r9 instanceof LayoutParams) == true) goto L8;
            return;
        L8:
            LayoutParams r10 = (LayoutParams) r9;
            this.guideBegin = r10.guideBegin;
            this.guideEnd = r10.guideEnd;
            this.guidePercent = r10.guidePercent;
            this.guidelineUseRtl = r10.guidelineUseRtl;
            this.leftToLeft = r10.leftToLeft;
            this.leftToRight = r10.leftToRight;
            this.rightToLeft = r10.rightToLeft;
            this.rightToRight = r10.rightToRight;
            this.topToTop = r10.topToTop;
            this.topToBottom = r10.topToBottom;
            this.bottomToTop = r10.bottomToTop;
            this.bottomToBottom = r10.bottomToBottom;
            this.baselineToBaseline = r10.baselineToBaseline;
            this.baselineToTop = r10.baselineToTop;
            this.baselineToBottom = r10.baselineToBottom;
            this.circleConstraint = r10.circleConstraint;
            this.circleRadius = r10.circleRadius;
            this.circleAngle = r10.circleAngle;
            this.startToEnd = r10.startToEnd;
            this.startToStart = r10.startToStart;
            this.endToStart = r10.endToStart;
            this.endToEnd = r10.endToEnd;
            this.goneLeftMargin = r10.goneLeftMargin;
            this.goneTopMargin = r10.goneTopMargin;
            this.goneRightMargin = r10.goneRightMargin;
            this.goneBottomMargin = r10.goneBottomMargin;
            this.goneStartMargin = r10.goneStartMargin;
            this.goneEndMargin = r10.goneEndMargin;
            this.goneBaselineMargin = r10.goneBaselineMargin;
            this.baselineMargin = r10.baselineMargin;
            this.horizontalBias = r10.horizontalBias;
            this.verticalBias = r10.verticalBias;
            this.dimensionRatio = r10.dimensionRatio;
            this.mDimensionRatioValue = r10.mDimensionRatioValue;
            this.mDimensionRatioSide = r10.mDimensionRatioSide;
            this.horizontalWeight = r10.horizontalWeight;
            this.verticalWeight = r10.verticalWeight;
            this.horizontalChainStyle = r10.horizontalChainStyle;
            this.verticalChainStyle = r10.verticalChainStyle;
            this.constrainedWidth = r10.constrainedWidth;
            this.constrainedHeight = r10.constrainedHeight;
            this.matchConstraintDefaultWidth = r10.matchConstraintDefaultWidth;
            this.matchConstraintDefaultHeight = r10.matchConstraintDefaultHeight;
            this.matchConstraintMinWidth = r10.matchConstraintMinWidth;
            this.matchConstraintMaxWidth = r10.matchConstraintMaxWidth;
            this.matchConstraintMinHeight = r10.matchConstraintMinHeight;
            this.matchConstraintMaxHeight = r10.matchConstraintMaxHeight;
            this.matchConstraintPercentWidth = r10.matchConstraintPercentWidth;
            this.matchConstraintPercentHeight = r10.matchConstraintPercentHeight;
            this.editorAbsoluteX = r10.editorAbsoluteX;
            this.editorAbsoluteY = r10.editorAbsoluteY;
            this.orientation = r10.orientation;
            this.mHorizontalDimensionFixed = r10.mHorizontalDimensionFixed;
            this.mVerticalDimensionFixed = r10.mVerticalDimensionFixed;
            this.mNeedsBaseline = r10.mNeedsBaseline;
            this.mIsGuideline = r10.mIsGuideline;
            this.mResolvedLeftToLeft = r10.mResolvedLeftToLeft;
            this.mResolvedLeftToRight = r10.mResolvedLeftToRight;
            this.mResolvedRightToLeft = r10.mResolvedRightToLeft;
            this.mResolvedRightToRight = r10.mResolvedRightToRight;
            this.mResolveGoneLeftMargin = r10.mResolveGoneLeftMargin;
            this.mResolveGoneRightMargin = r10.mResolveGoneRightMargin;
            this.mResolvedHorizontalBias = r10.mResolvedHorizontalBias;
            this.constraintTag = r10.constraintTag;
            this.wrapBehaviorInParent = r10.wrapBehaviorInParent;
            this.mWidget = r10.mWidget;
            this.mWidthSet = r10.mWidthSet;
            this.mHeightSet = r10.mHeightSet;
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
            this.mWidthSet = true;
            this.mHeightSet = true;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.mDimensionRatioValue = 0.0f;
            this.mDimensionRatioSide = 1;
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
            this.mHorizontalDimensionFixed = true;
            this.mVerticalDimensionFixed = true;
            this.mNeedsBaseline = false;
            this.mIsGuideline = false;
            this.mIsHelper = false;
            this.mIsInPlaceholder = false;
            this.mIsVirtualGroup = false;
            this.mResolvedLeftToLeft = -1;
            this.mResolvedLeftToRight = -1;
            this.mResolvedRightToLeft = -1;
            this.mResolvedRightToRight = -1;
            this.mResolveGoneLeftMargin = Integer.MIN_VALUE;
            this.mResolveGoneRightMargin = Integer.MIN_VALUE;
            this.mResolvedHorizontalBias = 0.5f;
            this.mWidget = new ConstraintWidget();
            this.helped = false;
            TypedArray r13 = r11.obtainStyledAttributes(r12, R.styleable.ConstraintLayout_Layout);
            int r14 = r13.getIndexCount();
            int r1 = 0;
        L3:
            if (r1 >= r14) goto L118;
            int r5 = r13.getIndex(r1);
            int r6 = Table.sMap.get(r5);
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
            this.guidelineUseRtl = r13.getBoolean(r5, this.guidelineUseRtl);
            goto L117
        L10:
            this.wrapBehaviorInParent = r13.getInt(r5, this.wrapBehaviorInParent);
            goto L117
        L11:
            ConstraintSet.parseDimensionConstraints(this, r13, r5, 1);
            this.mHeightSet = true;
            goto L117
        L12:
            ConstraintSet.parseDimensionConstraints(this, r13, r5, 0);
            this.mWidthSet = true;
        L117:
            r1 = r1 + 1;
            goto L3
        L13:
            this.goneBaselineMargin = r13.getDimensionPixelSize(r5, this.goneBaselineMargin);
            goto L117
        L14:
            this.baselineMargin = r13.getDimensionPixelSize(r5, this.baselineMargin);
            goto L117
        L15:
            int r7 = r13.getResourceId(r5, this.baselineToBottom);
            this.baselineToBottom = r7;
            if (r7 != (-1)) goto L117;
            this.baselineToBottom = r13.getInt(r5, -1);
            goto L117
        L18:
            int r8 = r13.getResourceId(r5, this.baselineToTop);
            this.baselineToTop = r8;
            if (r8 != (-1)) goto L117;
            this.baselineToTop = r13.getInt(r5, -1);
            goto L117
        L21:
            this.constraintTag = r13.getString(r5);
            goto L117
        L22:
            this.editorAbsoluteY = r13.getDimensionPixelOffset(r5, this.editorAbsoluteY);
            goto L117
        L23:
            this.editorAbsoluteX = r13.getDimensionPixelOffset(r5, this.editorAbsoluteX);
            goto L117
        L24:
            this.verticalChainStyle = r13.getInt(r5, 0);
            goto L117
        L25:
            this.horizontalChainStyle = r13.getInt(r5, 0);
            goto L117
        L26:
            this.verticalWeight = r13.getFloat(r5, this.verticalWeight);
            goto L117
        L27:
            this.horizontalWeight = r13.getFloat(r5, this.horizontalWeight);
            goto L117
        L28:
            ConstraintSet.parseDimensionRatioString(this, r13.getString(r5));
            goto L117
        L29:
            this.matchConstraintPercentHeight = Math.max(0.0f, r13.getFloat(r5, this.matchConstraintPercentHeight));
            this.matchConstraintDefaultHeight = 2;
            goto L117
        L40:
            this.matchConstraintPercentWidth = Math.max(0.0f, r13.getFloat(r5, this.matchConstraintPercentWidth));
            this.matchConstraintDefaultWidth = 2;
            goto L117
        L51:
            int r9 = r13.getInt(r5, 0);
            this.matchConstraintDefaultHeight = r9;
            if (r9 != 1) goto L117;
            Log.e(ConstraintLayout.TAG, "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
            goto L117
        L54:
            int r10 = r13.getInt(r5, 0);
            this.matchConstraintDefaultWidth = r10;
            if (r10 != 1) goto L117;
            Log.e(ConstraintLayout.TAG, "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
            goto L117
        L57:
            this.verticalBias = r13.getFloat(r5, this.verticalBias);
            goto L117
        L58:
            this.horizontalBias = r13.getFloat(r5, this.horizontalBias);
            goto L117
        L59:
            this.constrainedHeight = r13.getBoolean(r5, this.constrainedHeight);
            goto L117
        L60:
            this.constrainedWidth = r13.getBoolean(r5, this.constrainedWidth);
            goto L117
        L61:
            this.goneEndMargin = r13.getDimensionPixelSize(r5, this.goneEndMargin);
            goto L117
        L62:
            this.goneStartMargin = r13.getDimensionPixelSize(r5, this.goneStartMargin);
            goto L117
        L63:
            this.goneBottomMargin = r13.getDimensionPixelSize(r5, this.goneBottomMargin);
            goto L117
        L64:
            this.goneRightMargin = r13.getDimensionPixelSize(r5, this.goneRightMargin);
            goto L117
        L65:
            this.goneTopMargin = r13.getDimensionPixelSize(r5, this.goneTopMargin);
            goto L117
        L66:
            this.goneLeftMargin = r13.getDimensionPixelSize(r5, this.goneLeftMargin);
            goto L117
        L67:
            int r15 = r13.getResourceId(r5, this.endToEnd);
            this.endToEnd = r15;
            if (r15 != (-1)) goto L117;
            this.endToEnd = r13.getInt(r5, -1);
            goto L117
        L70:
            int r16 = r13.getResourceId(r5, this.endToStart);
            this.endToStart = r16;
            if (r16 != (-1)) goto L117;
            this.endToStart = r13.getInt(r5, -1);
            goto L117
        L73:
            int r17 = r13.getResourceId(r5, this.startToStart);
            this.startToStart = r17;
            if (r17 != (-1)) goto L117;
            this.startToStart = r13.getInt(r5, -1);
            goto L117
        L76:
            int r18 = r13.getResourceId(r5, this.startToEnd);
            this.startToEnd = r18;
            if (r18 != (-1)) goto L117;
            this.startToEnd = r13.getInt(r5, -1);
            goto L117
        L79:
            int r19 = r13.getResourceId(r5, this.baselineToBaseline);
            this.baselineToBaseline = r19;
            if (r19 != (-1)) goto L117;
            this.baselineToBaseline = r13.getInt(r5, -1);
            goto L117
        L82:
            int r20 = r13.getResourceId(r5, this.bottomToBottom);
            this.bottomToBottom = r20;
            if (r20 != (-1)) goto L117;
            this.bottomToBottom = r13.getInt(r5, -1);
            goto L117
        L85:
            int r21 = r13.getResourceId(r5, this.bottomToTop);
            this.bottomToTop = r21;
            if (r21 != (-1)) goto L117;
            this.bottomToTop = r13.getInt(r5, -1);
            goto L117
        L88:
            int r22 = r13.getResourceId(r5, this.topToBottom);
            this.topToBottom = r22;
            if (r22 != (-1)) goto L117;
            this.topToBottom = r13.getInt(r5, -1);
            goto L117
        L91:
            int r23 = r13.getResourceId(r5, this.topToTop);
            this.topToTop = r23;
            if (r23 != (-1)) goto L117;
            this.topToTop = r13.getInt(r5, -1);
            goto L117
        L94:
            int r24 = r13.getResourceId(r5, this.rightToRight);
            this.rightToRight = r24;
            if (r24 != (-1)) goto L117;
            this.rightToRight = r13.getInt(r5, -1);
            goto L117
        L97:
            int r25 = r13.getResourceId(r5, this.rightToLeft);
            this.rightToLeft = r25;
            if (r25 != (-1)) goto L117;
            this.rightToLeft = r13.getInt(r5, -1);
            goto L117
        L100:
            int r26 = r13.getResourceId(r5, this.leftToRight);
            this.leftToRight = r26;
            if (r26 != (-1)) goto L117;
            this.leftToRight = r13.getInt(r5, -1);
            goto L117
        L103:
            int r27 = r13.getResourceId(r5, this.leftToLeft);
            this.leftToLeft = r27;
            if (r27 != (-1)) goto L117;
            this.leftToLeft = r13.getInt(r5, -1);
            goto L117
        L106:
            this.guidePercent = r13.getFloat(r5, this.guidePercent);
            goto L117
        L107:
            this.guideEnd = r13.getDimensionPixelOffset(r5, this.guideEnd);
            goto L117
        L108:
            this.guideBegin = r13.getDimensionPixelOffset(r5, this.guideBegin);
            goto L117
        L109:
            float r28 = r13.getFloat(r5, this.circleAngle) % 360.0f;
            this.circleAngle = r28;
            if (r28 >= 0.0f) goto L117;
            this.circleAngle = (360.0f - r28) % 360.0f;
            goto L117
        L112:
            this.circleRadius = r13.getDimensionPixelSize(r5, this.circleRadius);
            goto L117
        L113:
            int r29 = r13.getResourceId(r5, this.circleConstraint);
            this.circleConstraint = r29;
            if (r29 != (-1)) goto L117;
            this.circleConstraint = r13.getInt(r5, -1);
            goto L117
        L116:
            this.orientation = r13.getInt(r5, this.orientation);
            goto L117
        L120:
            this.matchConstraintMinHeight = r13.getDimensionPixelSize(r5, this.matchConstraintMinHeight);     // Catch: Exception -> L37
        L38:
            if (r13.getInt(r5, this.matchConstraintMinHeight) != (-2)) goto L117;
            this.matchConstraintMinHeight = -2;
            goto L117
        L122:
            this.matchConstraintMinWidth = r13.getDimensionPixelSize(r5, this.matchConstraintMinWidth);     // Catch: Exception -> L48
        L49:
            if (r13.getInt(r5, this.matchConstraintMinWidth) != (-2)) goto L117;
            this.matchConstraintMinWidth = -2;
            goto L117
        L124:
            this.matchConstraintMaxHeight = r13.getDimensionPixelSize(r5, this.matchConstraintMaxHeight);     // Catch: Exception -> L32
        L33:
            if (r13.getInt(r5, this.matchConstraintMaxHeight) != (-2)) goto L117;
            this.matchConstraintMaxHeight = -2;
            goto L117
        L126:
            this.matchConstraintMaxWidth = r13.getDimensionPixelSize(r5, this.matchConstraintMaxWidth);     // Catch: Exception -> L43
        L44:
            if (r13.getInt(r5, this.matchConstraintMaxWidth) != (-2)) goto L117;
            this.matchConstraintMaxWidth = -2;
            goto L117
        L118:
            r13.recycle();
            validate();
        }

        public void validate() {
            this.mIsGuideline = false;
            this.mHorizontalDimensionFixed = true;
            this.mVerticalDimensionFixed = true;
            if (this.width != (-2)) goto L10;
            if (this.constrainedWidth == false) goto L10;
            this.mHorizontalDimensionFixed = false;
            if (this.matchConstraintDefaultWidth != 0) goto L10;
            this.matchConstraintDefaultWidth = 1;
        L10:
            if (this.height != (-2)) goto L17;
            if (this.constrainedHeight == false) goto L17;
            this.mVerticalDimensionFixed = false;
            if (this.matchConstraintDefaultHeight != 0) goto L17;
            this.matchConstraintDefaultHeight = 1;
        L17:
            if (this.width != 0) goto L19;
        L20:
            this.mHorizontalDimensionFixed = false;
            if (this.width == 0) goto L23;
        L26:
            if (this.height != 0) goto L28;
        L29:
            this.mVerticalDimensionFixed = false;
            if (this.height == 0) goto L32;
        L35:
            if (this.guidePercent == (-1.0f)) goto L37;
        L40:
            this.mIsGuideline = true;
            this.mHorizontalDimensionFixed = true;
            this.mVerticalDimensionFixed = true;
            if ((this.mWidget instanceof com.obric.oui.constraintlayout.core.widgets.Guideline) == true) goto L43;
            this.mWidget = new com.obric.oui.constraintlayout.core.widgets.Guideline();
        L43:
            ((com.obric.oui.constraintlayout.core.widgets.Guideline) this.mWidget).setOrientation(this.orientation);
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
            this.mWidthSet = true;
            this.mHeightSet = true;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.mDimensionRatioValue = 0.0f;
            this.mDimensionRatioSide = 1;
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
            this.mHorizontalDimensionFixed = true;
            this.mVerticalDimensionFixed = true;
            this.mNeedsBaseline = false;
            this.mIsGuideline = false;
            this.mIsHelper = false;
            this.mIsInPlaceholder = false;
            this.mIsVirtualGroup = false;
            this.mResolvedLeftToLeft = -1;
            this.mResolvedLeftToRight = -1;
            this.mResolvedRightToLeft = -1;
            this.mResolvedRightToRight = -1;
            this.mResolveGoneLeftMargin = Integer.MIN_VALUE;
            this.mResolveGoneRightMargin = Integer.MIN_VALUE;
            this.mResolvedHorizontalBias = 0.5f;
            this.mWidget = new ConstraintWidget();
            this.helped = false;
        }

        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        public void resolveLayoutDirection(int r11) {
            int r0 = this.leftMargin;
            int r1 = this.rightMargin;
            super.resolveLayoutDirection(r11);
            boolean r2 = false;
            if (1 != getLayoutDirection()) goto L5;
            boolean r12 = true;
        L6:
            this.mResolvedRightToLeft = -1;
            this.mResolvedRightToRight = -1;
            this.mResolvedLeftToLeft = -1;
            this.mResolvedLeftToRight = -1;
            this.mResolveGoneLeftMargin = this.goneLeftMargin;
            this.mResolveGoneRightMargin = this.goneRightMargin;
            float r5 = this.horizontalBias;
            this.mResolvedHorizontalBias = r5;
            int r6 = this.guideBegin;
            this.mResolvedGuideBegin = r6;
            int r7 = this.guideEnd;
            this.mResolvedGuideEnd = r7;
            float r8 = this.guidePercent;
            this.mResolvedGuidePercent = r8;
            if (r12 == false) goto L43;
            int r13 = this.startToEnd;
            if (r13 == (-1)) goto L12;
            this.mResolvedRightToLeft = r13;
        L11:
            r2 = true;
        L15:
            int r14 = this.endToStart;
            if (r14 == (-1)) goto L18;
            this.mResolvedLeftToRight = r14;
            r2 = true;
        L18:
            int r15 = this.endToEnd;
            if (r15 == (-1)) goto L21;
            this.mResolvedLeftToLeft = r15;
            r2 = true;
        L21:
            int r16 = this.goneStartMargin;
            if (r16 == Integer.MIN_VALUE) goto L24;
            this.mResolveGoneRightMargin = r16;
        L24:
            int r17 = this.goneEndMargin;
            if (r17 == Integer.MIN_VALUE) goto L28;
            this.mResolveGoneLeftMargin = r17;
        L28:
            if (r2 == false) goto L31;
            this.mResolvedHorizontalBias = 1.0f - r5;
        L31:
            if (this.mIsGuideline == false) goto L62;
            if (this.orientation != 1) goto L62;
            if (this.guidelineUseRtl == false) goto L62;
            if (r8 == (-1.0f)) goto L39;
            this.mResolvedGuidePercent = 1.0f - r8;
            this.mResolvedGuideBegin = -1;
            this.mResolvedGuideEnd = -1;
            goto L62
        L39:
            if (r6 == (-1)) goto L41;
            this.mResolvedGuideEnd = r6;
            this.mResolvedGuideBegin = -1;
            this.mResolvedGuidePercent = -1.0f;
            goto L62
        L41:
            if (r7 == (-1)) goto L62;
            this.mResolvedGuideBegin = r7;
            this.mResolvedGuideEnd = -1;
            this.mResolvedGuidePercent = -1.0f;
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
            int r18 = this.rightToLeft;
            if (r18 == (-1)) goto L75;
            this.mResolvedRightToLeft = r18;
            if (this.rightMargin > 0) goto L81;
            if (r1 <= 0) goto L81;
            this.rightMargin = r1;
        L81:
            int r19 = this.leftToLeft;
            if (r19 == (-1)) goto L87;
            this.mResolvedLeftToLeft = r19;
            if (this.leftMargin > 0) goto L98;
            if (r0 <= 0) goto L99;
            this.leftMargin = r0;
            return;
        L99:
            return;
        L98:
            return;
        L87:
            int r110 = this.leftToRight;
            if (r110 == (-1)) goto L101;
            this.mResolvedLeftToRight = r110;
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
            int r111 = this.rightToRight;
            if (r111 == (-1)) goto L81;
            this.mResolvedRightToRight = r111;
            if (this.rightMargin > 0) goto L81;
            if (r1 <= 0) goto L81;
            this.rightMargin = r1;
            goto L81
        L97:
            return;
        L12:
            int r112 = this.startToStart;
            if (r112 == (-1)) goto L15;
            this.mResolvedRightToRight = r112;
            goto L11
        L43:
            int r113 = this.startToEnd;
            if (r113 == (-1)) goto L46;
            this.mResolvedLeftToRight = r113;
        L46:
            int r114 = this.startToStart;
            if (r114 == (-1)) goto L49;
            this.mResolvedLeftToLeft = r114;
        L49:
            int r115 = this.endToStart;
            if (r115 == (-1)) goto L52;
            this.mResolvedRightToLeft = r115;
        L52:
            int r116 = this.endToEnd;
            if (r116 == (-1)) goto L55;
            this.mResolvedRightToRight = r116;
        L55:
            int r117 = this.goneStartMargin;
            if (r117 == Integer.MIN_VALUE) goto L58;
            this.mResolveGoneLeftMargin = r117;
        L58:
            int r118 = this.goneEndMargin;
            if (r118 == Integer.MIN_VALUE) goto L62;
            this.mResolveGoneRightMargin = r118;
            goto L62
        L5:
            r12 = false;
            goto L6
        }

        public String getConstraintTag() {
            return this.constraintTag;
        }
    }

    class Measurer implements BasicMeasure.Measurer {
        ConstraintLayout mLayout;
        int mLayoutHeightSpec;
        int mLayoutWidthSpec;
        int mPaddingBottom;
        int mPaddingHeight;
        int mPaddingTop;
        int mPaddingWidth;
        final /* synthetic */ ConstraintLayout this$0;

        public void captureLayoutInfo(int r1, int r2, int r3, int r4, int r5, int r6) {
            this.mPaddingTop = r3;
            this.mPaddingBottom = r4;
            this.mPaddingWidth = r5;
            this.mPaddingHeight = r6;
            this.mLayoutWidthSpec = r1;
            this.mLayoutHeightSpec = r2;
        }

        Measurer(ConstraintLayout r1, ConstraintLayout r2) {
            this.this$0 = r1;
            this.mLayout = r2;
        }

        @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer
        public final void measure(ConstraintWidget r21, BasicMeasure.Measure r22) {
            if (r21 != null) goto L6;
            return;
        L6:
            if (r21.getVisibility() != 8) goto L12;
            if (r21.isInPlaceholder() == true) goto L12;
            r22.measuredWidth = 0;
            r22.measuredHeight = 0;
            r22.measuredBaseline = 0;
            return;
        L12:
            if (r21.getParent() != null) goto L15;
            return;
        L15:
            if (ConstraintLayout.access$000(this.this$0) == null) goto L17;
            ConstraintLayout.access$000(this.this$0).mNumberOfMeasures++;
            long r6 = System.nanoTime();
        L18:
            ConstraintWidget.DimensionBehaviour r3 = r22.horizontalBehavior;
            ConstraintWidget.DimensionBehaviour r8 = r22.verticalBehavior;
            int r9 = r22.horizontalDimension;
            int r10 = r22.verticalDimension;
            int r11 = this.mPaddingTop + this.mPaddingBottom;
            int r12 = this.mPaddingWidth;
            View r13 = (View) r21.getCompanionWidget();
            int r14 = AnonymousClass1.$SwitchMap$com$obric$oui$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[r3.ordinal()];
            if (r14 == 1) goto L55;
            if (r14 != 2) goto L22;
            int r4 = ViewGroup.getChildMeasureSpec(this.mLayoutWidthSpec, r12, -2);
        L54:
            int r15 = r4;
        L56:
            int r5 = AnonymousClass1.$SwitchMap$com$obric$oui$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[r8.ordinal()];
            if (r5 != 1) goto L59;
            int r7 = View.MeasureSpec.makeMeasureSpec(r10, 1073741824);
        L94:
            ConstraintWidgetContainer r16 = (ConstraintWidgetContainer) r21.getParent();
            if (r16 == null) goto L120;
            if (Optimizer.enabled(ConstraintLayout.access$100(this.this$0), 256) == false) goto L120;
            if (r13.getMeasuredWidth() != r21.getWidth()) goto L120;
            if (r13.getMeasuredWidth() >= r16.getWidth()) goto L120;
            if (r13.getMeasuredHeight() != r21.getHeight()) goto L120;
            if (r13.getMeasuredHeight() >= r16.getHeight()) goto L120;
            if (r13.getBaseline() != r21.getBaselineDistance()) goto L120;
            if (r21.isMeasureRequested() == true) goto L120;
            if (isSimilarSpec(r21.getLastHorizontalMeasureSpec(), r15, r21.getWidth()) == true) goto L113;
        L115:
            boolean r17 = false;
        L116:
            if (r17 == false) goto L120;
            r22.measuredWidth = r21.getWidth();
            r22.measuredHeight = r21.getHeight();
            r22.measuredBaseline = r21.getBaselineDistance();
            return;
        L113:
            if (isSimilarSpec(r21.getLastVerticalMeasureSpec(), r7, r21.getHeight()) == false) goto L115;
            r17 = true;
        L120:
            if (r3 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L122;
            boolean r18 = true;
        L124:
            if (r8 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L126;
            boolean r19 = true;
        L128:
            if (r8 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L130;
        L133:
            boolean r110 = true;
        L135:
            if (r3 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L137;
        L140:
            boolean r20 = true;
        L142:
            if (r18 == true) goto L144;
        L146:
            boolean r111 = false;
        L147:
            if (r19 == true) goto L149;
        L151:
            boolean r23 = false;
        L152:
            if (r13 != null) goto L154;
            return;
        L154:
            LayoutParams r112 = (LayoutParams) r13.getLayoutParams();
            long r113 = r6;
            if (r22.measureStrategy == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS) goto L167;
            if (r22.measureStrategy == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L167;
            if (r18 == false) goto L167;
            if (r21.mMatchConstraintDefaultWidth != 0) goto L167;
            if (r19 == false) goto L167;
            if (r21.mMatchConstraintDefaultHeight != 0) goto L167;
            int r24 = -1;
            int r25 = 0;
            int r114 = 0;
            int r115 = 0;
        L207:
            if (r25 == r24) goto L209;
            boolean r116 = true;
        L211:
            if (r114 == r22.horizontalDimension) goto L213;
        L216:
            boolean r26 = true;
        L217:
            r22.measuredNeedsSolverPass = r26;
            if (r112.mNeedsBaseline == false) goto L220;
            r116 = true;
        L220:
            if (r116 == true) goto L222;
        L226:
            r22.measuredWidth = r114;
            r22.measuredHeight = r115;
            r22.measuredHasBaseline = r116;
            r22.measuredBaseline = r25;
            if (ConstraintLayout.access$000(this.this$0) == null) goto L230;
            long r1 = System.nanoTime();
            ConstraintLayout.access$000(this.this$0).measuresWidgetsDuration += r1 - r113;
            return;
        L230:
            return;
        L222:
            if (r25 == (-1)) goto L226;
            if (r21.getBaselineDistance() == r25) goto L226;
            r22.measuredNeedsSolverPass = true;
            goto L226
        L213:
            if (r115 != r22.verticalDimension) goto L216;
            r26 = false;
            goto L217
        L209:
            r116 = false;
        L167:
            if ((r13 instanceof VirtualLayout) == true) goto L169;
        L171:
            r13.measure(r15, r7);
        L172:
            r21.setLastMeasureSpec(r15, r7);
            int r27 = r13.getMeasuredWidth();
            int r28 = r13.getMeasuredHeight();
            int r29 = r13.getBaseline();
            if (r21.mMatchConstraintMinWidth <= 0) goto L175;
            r114 = Math.max(r21.mMatchConstraintMinWidth, r27);
        L177:
            if (r21.mMatchConstraintMaxWidth <= 0) goto L180;
            r114 = Math.min(r21.mMatchConstraintMaxWidth, r114);
        L180:
            if (r21.mMatchConstraintMinHeight <= 0) goto L182;
            r115 = Math.max(r21.mMatchConstraintMinHeight, r28);
        L184:
            if (r21.mMatchConstraintMaxHeight <= 0) goto L187;
            r115 = Math.min(r21.mMatchConstraintMaxHeight, r115);
        L187:
            if (Optimizer.enabled(ConstraintLayout.access$100(this.this$0), 1) == false) goto L189;
        L195:
            if (r27 != r114) goto L201;
            if (r28 != r115) goto L201;
            r25 = r29;
        L199:
            r24 = -1;
        L201:
            if (r27 == r114) goto L203;
            r15 = View.MeasureSpec.makeMeasureSpec(r114, 1073741824);
        L203:
            if (r28 == r115) goto L205;
            int r30 = View.MeasureSpec.makeMeasureSpec(r115, 1073741824);
        L206:
            r13.measure(r15, r30);
            r21.setLastMeasureSpec(r15, r30);
            r114 = r13.getMeasuredWidth();
            r115 = r13.getMeasuredHeight();
            r25 = r13.getBaseline();
            goto L199
        L205:
            r30 = r7;
            goto L206
        L189:
            if (r111 == false) goto L192;
            if (r110 == false) goto L192;
            r114 = (int) ((r115 * r21.mDimensionRatio) + 0.5f);
        L192:
            if (r23 == false) goto L195;
            if (r20 == false) goto L195;
            r115 = (int) ((r114 / r21.mDimensionRatio) + 0.5f);
            goto L195
        L182:
            r115 = r28;
            goto L184
        L175:
            r114 = r27;
            goto L177
        L169:
            if ((r21 instanceof com.obric.oui.constraintlayout.core.widgets.VirtualLayout) == false) goto L171;
            ((VirtualLayout) r13).onMeasure((com.obric.oui.constraintlayout.core.widgets.VirtualLayout) r21, r15, r7);
            goto L172
        L149:
            if (r21.mDimensionRatio <= 0.0f) goto L151;
            r23 = true;
            goto L152
        L144:
            if (r21.mDimensionRatio <= 0.0f) goto L146;
            r111 = true;
            goto L147
        L137:
            if (r3 == ConstraintWidget.DimensionBehaviour.FIXED) goto L140;
            r20 = false;
            goto L142
        L130:
            if (r8 == ConstraintWidget.DimensionBehaviour.FIXED) goto L133;
            r110 = false;
            goto L135
        L126:
            r19 = false;
            goto L128
        L122:
            r18 = false;
            goto L124
        L59:
            if (r5 != 2) goto L61;
            r7 = ViewGroup.getChildMeasureSpec(this.mLayoutHeightSpec, r11, -2);
            goto L94
        L61:
            if (r5 != 3) goto L63;
            r7 = ViewGroup.getChildMeasureSpec(this.mLayoutHeightSpec, r11 + r21.getVerticalMargin(), -1);
            goto L94
        L63:
            if (r5 == 4) goto L65;
            r7 = 0;
            goto L94
        L65:
            r7 = ViewGroup.getChildMeasureSpec(this.mLayoutHeightSpec, r11, -2);
            if (r21.mMatchConstraintDefaultHeight != 1) goto L68;
            boolean r117 = true;
        L70:
            if (r22.measureStrategy == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS) goto L74;
            if (r22.measureStrategy != BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L94;
        L74:
            if (r13.getMeasuredWidth() != r21.getWidth()) goto L76;
            boolean r118 = true;
        L78:
            if (r22.measureStrategy == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L88;
            if (r117 == false) goto L88;
            if (r117 == false) goto L83;
            if (r118 == true) goto L88;
        L83:
            if ((r13 instanceof Placeholder) == true) goto L88;
            if (r21.isResolvedVertically() == true) goto L88;
            boolean r119 = false;
        L89:
            if (r119 == false) goto L94;
            r7 = View.MeasureSpec.makeMeasureSpec(r21.getHeight(), 1073741824);
        L88:
            r119 = true;
            goto L89
        L76:
            r118 = false;
            goto L78
        L68:
            r117 = false;
            goto L70
        L22:
            if (r14 != 3) goto L24;
            r4 = ViewGroup.getChildMeasureSpec(this.mLayoutWidthSpec, r12 + r21.getHorizontalMargin(), -1);
            goto L54
        L24:
            if (r14 == 4) goto L26;
            r15 = 0;
            goto L56
        L26:
            r15 = ViewGroup.getChildMeasureSpec(this.mLayoutWidthSpec, r12, -2);
            if (r21.mMatchConstraintDefaultWidth != 1) goto L29;
            boolean r120 = true;
        L31:
            if (r22.measureStrategy == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS) goto L35;
            if (r22.measureStrategy != BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L56;
        L35:
            if (r13.getMeasuredHeight() != r21.getHeight()) goto L37;
            boolean r121 = true;
        L39:
            if (r22.measureStrategy == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L49;
            if (r120 == false) goto L49;
            if (r120 == false) goto L44;
            if (r121 == true) goto L49;
        L44:
            if ((r13 instanceof Placeholder) == true) goto L49;
            if (r21.isResolvedHorizontally() == true) goto L49;
            boolean r31 = false;
        L50:
            if (r31 == false) goto L56;
            r15 = View.MeasureSpec.makeMeasureSpec(r21.getWidth(), 1073741824);
        L49:
            r31 = true;
            goto L50
        L37:
            r121 = false;
            goto L39
        L29:
            r120 = false;
            goto L31
        L55:
            r15 = View.MeasureSpec.makeMeasureSpec(r9, 1073741824);
            goto L56
        L17:
            r6 = 0;
            goto L18
        }

        private boolean isSimilarSpec(int r3, int r4, int r5) {
            if (r3 != r4) goto L5;
            return true;
        L5:
            int r6 = View.MeasureSpec.getMode(r3);
            int r0 = View.MeasureSpec.getMode(r4);
            int r7 = View.MeasureSpec.getSize(r4);
            if (r0 == 1073741824) goto L8;
        L12:
            return false;
        L8:
            if (r6 == Integer.MIN_VALUE) goto L10;
            if (r6 != 0) goto L12;
        L10:
            if (r5 != r7) goto L12;
            return true;
        }

        @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer
        public final void didMeasures() {
            int r0 = this.mLayout.getChildCount();
            int r1 = 0;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L8;
            View r3 = this.mLayout.getChildAt(r2);
            if ((r3 instanceof Placeholder) == false) goto L7;
            ((Placeholder) r3).updatePostMeasure(this.mLayout);
        L7:
            r2 = r2 + 1;
            goto L3
        L8:
            int r4 = ConstraintLayout.access$200(this.mLayout).size();
            if (r4 <= 0) goto L12;
        L10:
            if (r1 >= r4) goto L17;
            ((ConstraintHelper) ConstraintLayout.access$200(this.mLayout).get(r1)).updatePostMeasure(this.mLayout);
            r1 = r1 + 1;
            goto L10
        L17:
            return;
        }
    }

    public interface ValueModifier {
        boolean update(int r1, int r2, int r3, View r4, LayoutParams r5);
    }

    static {
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    static /* synthetic */ Metrics access$000(ConstraintLayout r0) {
        return r0.mMetrics;
    }

    static /* synthetic */ int access$100(ConstraintLayout r0) {
        return r0.mOptimizationLevel;
    }

    static /* synthetic */ ArrayList access$200(ConstraintLayout r0) {
        return r0.mConstraintHelpers;
    }

    @Override // android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    public static SharedValues getSharedValues() {
        if (sSharedValues != null) goto L6;
        sSharedValues = new SharedValues();
    L6:
        return sSharedValues;
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
        int r6 = r5.indexOf(LibrarianImpl.Constants.SEPARATOR);
        if (r6 == (-1)) goto L13;
        r5 = r5.substring(r6 + 1);
    L13:
        int r7 = ((Integer) r4).intValue();
        this.mDesignIds.put(r5, Integer.valueOf(r7));
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

    public ConstraintLayout(Context r4) {
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

    public ConstraintLayout(Context r3, AttributeSet r4) {
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

    public ConstraintLayout(Context r3, AttributeSet r4, int r5) {
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

    public ConstraintLayout(Context r3, AttributeSet r4, int r5, int r6) {
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

    @Override // android.view.View
    public void setId(int r3) {
        this.mChildrenByIds.remove(getId());
        super.setId(r3);
        this.mChildrenByIds.put(getId(), this);
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

    protected void parseLayoutDescription(int r3) {
        this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, r3);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View r4) {
        super.onViewAdded(r4);
        ConstraintWidget r0 = getViewWidget(r4);
        if ((r4 instanceof Guideline) == false) goto L8;
        if ((r0 instanceof com.obric.oui.constraintlayout.core.widgets.Guideline) == true) goto L8;
        LayoutParams r1 = (LayoutParams) r4.getLayoutParams();
        r1.mWidget = new com.obric.oui.constraintlayout.core.widgets.Guideline();
        r1.mIsGuideline = true;
        ((com.obric.oui.constraintlayout.core.widgets.Guideline) r1.mWidget).setOrientation(r1.orientation);
    L8:
        if ((r4 instanceof ConstraintHelper) == false) goto L12;
        ConstraintHelper r2 = (ConstraintHelper) r4;
        r2.validateParams();
        ((LayoutParams) r4.getLayoutParams()).mIsHelper = true;
        if (this.mConstraintHelpers.contains(r2) == true) goto L12;
        this.mConstraintHelpers.add(r2);
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

    public void setMinWidth(int r2) {
        if (r2 != this.mMinWidth) goto L5;
        return;
    L5:
        this.mMinWidth = r2;
        requestLayout();
    }

    public void setMinHeight(int r2) {
        if (r2 != this.mMinHeight) goto L5;
        return;
    L5:
        this.mMinHeight = r2;
        requestLayout();
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public void setMaxWidth(int r2) {
        if (r2 != this.mMaxWidth) goto L5;
        return;
    L5:
        this.mMaxWidth = r2;
        requestLayout();
    }

    public void setMaxHeight(int r2) {
        if (r2 != this.mMaxHeight) goto L5;
        return;
    L5:
        this.mMaxHeight = r2;
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

    protected void applyConstraintsFromLayoutParams(boolean r17, View r18, ConstraintWidget r19, LayoutParams r20, SparseArray<ConstraintWidget> r21) {
        r20.validate();
        r20.helped = false;
        r19.setVisibility(r18.getVisibility());
        if (r20.mIsInPlaceholder == false) goto L5;
        r19.setInPlaceholder(true);
        r19.setVisibility(8);
    L5:
        r19.setCompanionWidget(r18);
        if ((r18 instanceof ConstraintHelper) == false) goto L10;
        ((ConstraintHelper) r18).resolveRtl(r19, this.mLayoutWidget.isRtl());
    L10:
        if (r20.mIsGuideline == false) goto L18;
        com.obric.oui.constraintlayout.core.widgets.Guideline r0 = (com.obric.oui.constraintlayout.core.widgets.Guideline) r19;
        int r1 = r20.mResolvedGuideBegin;
        int r2 = r20.mResolvedGuideEnd;
        float r3 = r20.mResolvedGuidePercent;
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
        int r4 = r20.mResolvedLeftToLeft;
        int r5 = r20.mResolvedLeftToRight;
        int r12 = r20.mResolvedRightToLeft;
        int r13 = r20.mResolvedRightToRight;
        int r6 = r20.mResolveGoneLeftMargin;
        int r14 = r20.mResolveGoneRightMargin;
        float r15 = r20.mResolvedHorizontalBias;
        if (r20.circleConstraint == (-1)) goto L23;
        ConstraintWidget r7 = r21.get(r20.circleConstraint);
        if (r7 == null) goto L74;
        r19.connectCircularConstraint(r7, r20.circleAngle, r20.circleRadius);
    L74:
        if (r17 == false) goto L81;
        if (r20.editorAbsoluteX == (-1)) goto L78;
    L79:
        r19.setOrigin(r20.editorAbsoluteX, r20.editorAbsoluteY);
        goto L81
    L78:
        if (r20.editorAbsoluteY != (-1)) goto L79;
    L81:
        if (r20.mHorizontalDimensionFixed == false) goto L83;
        r19.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        r19.setWidth(r20.width);
        if (r20.width != (-2)) goto L94;
        r19.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
    L94:
        if (r20.mVerticalDimensionFixed == false) goto L96;
        r19.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        r19.setHeight(r20.height);
        if (r20.height != (-2)) goto L106;
        r19.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
    L106:
        r19.setDimensionRatio(r20.dimensionRatio);
        r19.setHorizontalWeight(r20.horizontalWeight);
        r19.setVerticalWeight(r20.verticalWeight);
        r19.setHorizontalChainStyle(r20.horizontalChainStyle);
        r19.setVerticalChainStyle(r20.verticalChainStyle);
        r19.setWrapBehaviorInParent(r20.wrapBehaviorInParent);
        r19.setHorizontalMatchStyle(r20.matchConstraintDefaultWidth, r20.matchConstraintMinWidth, r20.matchConstraintMaxWidth, r20.matchConstraintPercentWidth);
        r19.setVerticalMatchStyle(r20.matchConstraintDefaultHeight, r20.matchConstraintMinHeight, r20.matchConstraintMaxHeight, r20.matchConstraintPercentHeight);
        return;
    L96:
        if (r20.height == (-1)) goto L98;
        r19.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        r19.setHeight(0);
        goto L106
    L98:
        if (r20.constrainedHeight == false) goto L100;
        r19.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
    L101:
        ConstraintAnchor r8 = r19.getAnchor(ConstraintAnchor.Type.TOP);
        r8.mMargin = r20.topMargin;
        ConstraintAnchor r9 = r19.getAnchor(ConstraintAnchor.Type.BOTTOM);
        r9.mMargin = r20.bottomMargin;
        goto L106
    L100:
        r19.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
        goto L101
    L83:
        if (r20.width == (-1)) goto L85;
        r19.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        r19.setWidth(0);
        goto L94
    L85:
        if (r20.constrainedWidth == false) goto L87;
        r19.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
    L88:
        ConstraintAnchor r10 = r19.getAnchor(ConstraintAnchor.Type.LEFT);
        r10.mMargin = r20.leftMargin;
        ConstraintAnchor r11 = r19.getAnchor(ConstraintAnchor.Type.RIGHT);
        r11.mMargin = r20.rightMargin;
        goto L94
    L87:
        r19.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
        goto L88
    L23:
        if (r4 == (-1)) goto L27;
        ConstraintWidget r16 = r21.get(r4);
        if (r16 == null) goto L31;
        r19.immediateConnect(ConstraintAnchor.Type.LEFT, r16, ConstraintAnchor.Type.LEFT, r20.leftMargin, r6);
    L31:
        if (r12 == (-1)) goto L35;
        ConstraintWidget r22 = r21.get(r12);
        if (r22 == null) goto L40;
        r19.immediateConnect(ConstraintAnchor.Type.RIGHT, r22, ConstraintAnchor.Type.LEFT, r20.rightMargin, r14);
    L40:
        if (r20.topToTop == (-1)) goto L45;
        ConstraintWidget r23 = r21.get(r20.topToTop);
        if (r23 == null) goto L50;
        r19.immediateConnect(ConstraintAnchor.Type.TOP, r23, ConstraintAnchor.Type.TOP, r20.topMargin, r20.goneTopMargin);
    L50:
        if (r20.bottomToTop == (-1)) goto L55;
        ConstraintWidget r24 = r21.get(r20.bottomToTop);
        if (r24 == null) goto L60;
        r19.immediateConnect(ConstraintAnchor.Type.BOTTOM, r24, ConstraintAnchor.Type.TOP, r20.bottomMargin, r20.goneBottomMargin);
    L60:
        if (r20.baselineToBaseline == (-1)) goto L63;
        setWidgetBaseline(r19, r20, r21, r20.baselineToBaseline, ConstraintAnchor.Type.BASELINE);
    L69:
        if (r15 < 0.0f) goto L72;
        r19.setHorizontalBiasPercent(r15);
    L72:
        if (r20.verticalBias < 0.0f) goto L74;
        r19.setVerticalBiasPercent(r20.verticalBias);
        goto L74
    L63:
        if (r20.baselineToTop == (-1)) goto L66;
        setWidgetBaseline(r19, r20, r21, r20.baselineToTop, ConstraintAnchor.Type.TOP);
        goto L69
    L66:
        if (r20.baselineToBottom == (-1)) goto L69;
        setWidgetBaseline(r19, r20, r21, r20.baselineToBottom, ConstraintAnchor.Type.BOTTOM);
        goto L69
    L55:
        if (r20.bottomToBottom == (-1)) goto L60;
        ConstraintWidget r25 = r21.get(r20.bottomToBottom);
        if (r25 == null) goto L60;
        r19.immediateConnect(ConstraintAnchor.Type.BOTTOM, r25, ConstraintAnchor.Type.BOTTOM, r20.bottomMargin, r20.goneBottomMargin);
        goto L60
    L45:
        if (r20.topToBottom == (-1)) goto L50;
        ConstraintWidget r26 = r21.get(r20.topToBottom);
        if (r26 == null) goto L50;
        r19.immediateConnect(ConstraintAnchor.Type.TOP, r26, ConstraintAnchor.Type.BOTTOM, r20.topMargin, r20.goneTopMargin);
        goto L50
    L35:
        if (r13 == (-1)) goto L40;
        ConstraintWidget r27 = r21.get(r13);
        if (r27 == null) goto L40;
        r19.immediateConnect(ConstraintAnchor.Type.RIGHT, r27, ConstraintAnchor.Type.RIGHT, r20.rightMargin, r14);
        goto L40
    L27:
        if (r5 == (-1)) goto L31;
        ConstraintWidget r28 = r21.get(r5);
        if (r28 == null) goto L31;
        r19.immediateConnect(ConstraintAnchor.Type.LEFT, r28, ConstraintAnchor.Type.RIGHT, r20.leftMargin, r6);
        goto L31
    }

    private void setWidgetBaseline(ConstraintWidget r2, LayoutParams r3, SparseArray<ConstraintWidget> r4, int r5, ConstraintAnchor.Type r6) {
        View r1 = this.mChildrenByIds.get(r5);
        ConstraintWidget r7 = r4.get(r5);
        if (r7 == null) goto L12;
        if (r1 != null) goto L6;
        return;
    L6:
        if ((r1.getLayoutParams() instanceof LayoutParams) == false) goto L14;
        r3.mNeedsBaseline = true;
        if (r6 != ConstraintAnchor.Type.BASELINE) goto L10;
        LayoutParams r8 = (LayoutParams) r1.getLayoutParams();
        r8.mNeedsBaseline = true;
        r8.mWidget.setHasBaseline(true);
    L10:
        r2.getAnchor(ConstraintAnchor.Type.BASELINE).connect(r7.getAnchor(r6), r3.baselineMargin, r3.goneBaselineMargin, true);
        r2.setHasBaseline(true);
        r2.getAnchor(ConstraintAnchor.Type.TOP).reset();
        r2.getAnchor(ConstraintAnchor.Type.BOTTOM).reset();
        return;
    L14:
        return;
    }

    private ConstraintWidget getTargetWidget(int r2) {
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
        return ((LayoutParams) r0.getLayoutParams()).mWidget;
    L15:
        return this.mLayoutWidget;
    L4:
        return this.mLayoutWidget;
    }

    public final ConstraintWidget getViewWidget(View r2) {
        if (r2 == this) goto L4;
        if (r2 != null) goto L7;
        return null;
    L7:
        if ((r2.getLayoutParams() instanceof LayoutParams) == true) goto L9;
        r2.setLayoutParams(generateLayoutParams(r2.getLayoutParams()));
        if ((r2.getLayoutParams() instanceof LayoutParams) == true) goto L13;
        return null;
    L13:
        return ((LayoutParams) r2.getLayoutParams()).mWidget;
    L9:
        return ((LayoutParams) r2.getLayoutParams()).mWidget;
    L4:
        return this.mLayoutWidget;
    }

    public void fillMetrics(Metrics r1) {
        this.mMetrics = r1;
        this.mLayoutWidget.fillMetrics(r1);
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
        int r5 = Math.max(0, getPaddingStart());
        int r9 = Math.max(0, getPaddingEnd());
        if (r5 > 0) goto L8;
        if (r9 > 0) goto L8;
        r9 = Math.max(0, getPaddingLeft());
    L11:
        int r10 = r0 - r4;
        int r11 = r1 - r2;
        setSelfDimensionBehaviour(r18, r7, r10, r8, r11);
        r18.measure(r19, r7, r10, r8, r11, this.mLastMeasureWidth, this.mLastMeasureHeight, r9, r16);
        return;
    L8:
        if (isRtl() == true) goto L11;
        r9 = r5;
        goto L11
    }

    protected void resolveMeasuredDimension(int r3, int r4, int r5, int r6, boolean r7, boolean r8) {
        int r0 = this.mMeasurer.mPaddingHeight;
        int r9 = resolveSizeAndState(r5 + this.mMeasurer.mPaddingWidth, r3, 0);
        int r10 = resolveSizeAndState(r6 + r0, r4, 0) & 16777215;
        int r11 = this.mMaxWidth;
        int r12 = Math.min(r11, r9 & 16777215);
        int r13 = Math.min(this.mMaxHeight, r10);
        if (r7 == false) goto L5;
        r12 = r12 | 16777216;
    L5:
        if (r8 == false) goto L7;
        r13 = r13 | 16777216;
    L7:
        setMeasuredDimension(r12, r13);
        this.mLastMeasureWidth = r12;
        this.mLastMeasureHeight = r13;
    }

    @Override // android.view.View
    protected void onMeasure(int r11, int r12) {
        if (this.mMetrics == null) goto L5;
        long r0 = System.nanoTime();
        this.mMetrics.mChildCount = getChildCount();
        this.mMetrics.mMeasureCalls++;
    L6:
        boolean r2 = this.mDirtyHierarchy | dynamicUpdateConstraints(r11, r12);
        this.mDirtyHierarchy = r2;
        if (r2 == true) goto L14;
        int r3 = getChildCount();
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L14;
        if (getChildAt(r4).isLayoutRequested() == true) goto L12;
        r4 = r4 + 1;
        goto L9
    L12:
        this.mDirtyHierarchy = true;
    L14:
        boolean r5 = this.mDirtyHierarchy;
        this.mOnMeasureWidthMeasureSpec = r11;
        this.mOnMeasureHeightMeasureSpec = r12;
        this.mLayoutWidget.setRtl(isRtl());
        if (this.mDirtyHierarchy == false) goto L19;
        this.mDirtyHierarchy = false;
        if (updateHierarchy() == false) goto L19;
        this.mLayoutWidget.updateHierarchy();
    L19:
        this.mLayoutWidget.fillMetrics(this.mMetrics);
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, r11, r12);
        resolveMeasuredDimension(r11, r12, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
        Metrics r10 = this.mMetrics;
        if (r10 == null) goto L25;
        r10.mMeasureDuration += System.nanoTime() - r0;
        return;
    L25:
        return;
    L5:
        r0 = 0;
        goto L6
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

    protected void setSelfDimensionBehaviour(ConstraintWidgetContainer r9, int r10, int r11, int r12, int r13) {
        int r0 = this.mMeasurer.mPaddingHeight;
        int r1 = this.mMeasurer.mPaddingWidth;
        ConstraintWidget.DimensionBehaviour r2 = ConstraintWidget.DimensionBehaviour.FIXED;
        ConstraintWidget.DimensionBehaviour r3 = ConstraintWidget.DimensionBehaviour.FIXED;
        int r4 = getChildCount();
        if (r10 == Integer.MIN_VALUE) goto L11;
        if (r10 == 0) goto L8;
        if (r10 == 1073741824) goto L7;
    L6:
        r11 = 0;
    L14:
        if (r12 == Integer.MIN_VALUE) goto L22;
        if (r12 == 0) goto L19;
        if (r12 == 1073741824) goto L18;
    L17:
        r13 = 0;
    L26:
        if (r11 == r9.getWidth()) goto L28;
    L29:
        r9.invalidateMeasures();
    L30:
        r9.setX(0);
        r9.setY(0);
        r9.setMaxWidth(this.mMaxWidth - r1);
        r9.setMaxHeight(this.mMaxHeight - r0);
        r9.setMinWidth(0);
        r9.setMinHeight(0);
        r9.setHorizontalDimensionBehaviour(r2);
        r9.setWidth(r11);
        r9.setVerticalDimensionBehaviour(r3);
        r9.setHeight(r13);
        r9.setMinWidth(this.mMinWidth - r1);
        r9.setMinHeight(this.mMinHeight - r0);
        return;
    L28:
        if (r13 == r9.getHeight()) goto L30;
    L18:
        r13 = Math.min(this.mMaxHeight - r0, r13);
        goto L26
    L19:
        r3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r4 != 0) goto L17;
        r13 = Math.max(0, this.mMinHeight);
        goto L26
    L22:
        r3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r4 != 0) goto L26;
        r13 = Math.max(0, this.mMinHeight);
        goto L26
    L7:
        r11 = Math.min(this.mMaxWidth - r1, r11);
        goto L14
    L8:
        r2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r4 != 0) goto L6;
        r11 = Math.max(0, this.mMinWidth);
        goto L14
    L11:
        r2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r4 != 0) goto L14;
        r11 = Math.max(0, this.mMinWidth);
        goto L14
    }

    public void setState(int r1, int r2, int r3) {
        ConstraintLayoutStates r0 = this.mConstraintLayoutSpec;
        if (r0 == null) goto L6;
        r0.updateConstraints(r1, r2, r3);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r6, int r7, int r8, int r9, int r10) {
        Metrics r11 = this.mMetrics;
        if (r11 == null) goto L5;
        r11.mNumberOfLayouts++;
    L5:
        int r12 = getChildCount();
        boolean r13 = isInEditMode();
        int r14 = 0;
        int r15 = 0;
    L6:
        if (r15 >= r12) goto L26;
        View r16 = getChildAt(r15);
        LayoutParams r0 = (LayoutParams) r16.getLayoutParams();
        ConstraintWidget r1 = r0.mWidget;
        if (r16.getVisibility() != 8) goto L18;
        if (r0.mIsGuideline == true) goto L18;
        if (r0.mIsHelper == true) goto L18;
        if (r0.mIsVirtualGroup == true) goto L18;
        if (r13 == true) goto L18;
    L25:
        r15 = r15 + 1;
    L18:
        if (r0.mIsInPlaceholder == true) goto L25;
        int r2 = r1.getX();
        int r3 = r1.getY();
        int r4 = r1.getWidth() + r2;
        int r5 = r1.getHeight() + r3;
        r16.layout(r2, r3, r4, r5);
        if ((r16 instanceof Placeholder) == false) goto L25;
        View r17 = ((Placeholder) r16).getContent();
        if (r17 == null) goto L25;
        r17.setVisibility(0);
        r17.layout(r2, r3, r4, r5);
        goto L25
    L26:
        int r18 = this.mConstraintHelpers.size();
        if (r18 <= 0) goto L30;
    L28:
        if (r14 >= r18) goto L38;
        this.mConstraintHelpers.get(r14).updatePostLayout(this);
        r14 = r14 + 1;
        goto L28
    L38:
        return;
    }

    public void setOptimizationLevel(int r1) {
        this.mOptimizationLevel = r1;
        this.mLayoutWidget.setOptimizationLevel(r1);
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.getOptimizationLevel();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r2) {
        return new LayoutParams(getContext(), r2);
    }

    @Override // android.view.ViewGroup
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return new LayoutParams(r1);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return r1 instanceof LayoutParams;
    }

    public void setConstraintSet(ConstraintSet r1) {
        this.mConstraintSet = r1;
    }

    public View getViewById(int r1) {
        return this.mChildrenByIds.get(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r19) {
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
        super.dispatchDraw(r19);
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
        float r110 = r15;
        float r20 = r14 + ((int) ((r13 / 1080.0f) * r4));
        r19.drawLine(r18, r110, r20, r110, r17);
        float r21 = r15 + r16;
        r19.drawLine(r20, r110, r20, r21, r17);
        r19.drawLine(r20, r21, r18, r21, r17);
        r19.drawLine(r18, r21, r18, r110, r17);
        r17.setColor(-16711936);
        r19.drawLine(r18, r110, r20, r21, r17);
        r19.drawLine(r18, r21, r20, r110, r17);
    L23:
        r7 = r7 + 1;
        goto L12
    L32:
        return;
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener r1) {
        ConstraintLayoutStates r0 = this.mConstraintLayoutSpec;
        if (r0 == null) goto L6;
        r0.setOnConstraintsChanged(r1);
        return;
    }

    public void loadLayoutDescription(int r4) {
        if (r4 != 0) goto L9;
        this.mConstraintLayoutSpec = null;
        return;
    L9:
        this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, r4);     // Catch: Resources.NotFoundException -> L6
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

    public void addValueModifier(ValueModifier r2) {
        if (this.mModifiers != null) goto L5;
        this.mModifiers = new ArrayList();
    L5:
        this.mModifiers.add(r2);
    }

    void removeValueModifier(ValueModifier r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.mModifiers.remove(r1);
    }

    protected boolean dynamicUpdateConstraints(int r11, int r12) {
        boolean r1 = false;
        if (this.mModifiers != null) goto L5;
        return false;
    L5:
        int r13 = View.MeasureSpec.getSize(r11);
        int r14 = View.MeasureSpec.getSize(r12);
        Iterator<ValueModifier> r0 = this.mModifiers.iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        ValueModifier r8 = r0.next();
        Iterator<ConstraintWidget> r9 = this.mLayoutWidget.getChildren().iterator();
    L10:
        if (r9.hasNext() == false) goto L7;
        View r6 = (View) r9.next().getCompanionWidget();
        r1 = r1 | r8.update(r13, r14, r6.getId(), r6, (LayoutParams) r6.getLayoutParams());
        goto L10
    L12:
        return r1;
    }
}
