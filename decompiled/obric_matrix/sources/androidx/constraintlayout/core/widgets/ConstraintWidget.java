package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.ArrayRow;
import androidx.constraintlayout.core.Cache;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.analyzer.ChainRun;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintWidget {
    public static final int ANCHOR_BASELINE = 4;
    public static final int ANCHOR_BOTTOM = 3;
    public static final int ANCHOR_LEFT = 0;
    public static final int ANCHOR_RIGHT = 1;
    public static final int ANCHOR_TOP = 2;
    private static final boolean AUTOTAG_CENTER = false;
    public static final int BOTH = 2;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    static final int DIMENSION_HORIZONTAL = 0;
    static final int DIMENSION_VERTICAL = 1;
    protected static final int DIRECT = 2;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    protected static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    private static final boolean USE_WRAP_DIMENSION_FOR_SPREAD = false;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = -2;
    public static final int WRAP_BEHAVIOR_HORIZONTAL_ONLY = 1;
    public static final int WRAP_BEHAVIOR_INCLUDED = 0;
    public static final int WRAP_BEHAVIOR_SKIPPED = 3;
    public static final int WRAP_BEHAVIOR_VERTICAL_ONLY = 2;
    private boolean OPTIMIZE_WRAP;
    private boolean OPTIMIZE_WRAP_ON_RESOLVED;
    public WidgetFrame frame;
    private boolean hasBaseline;
    public ChainRun horizontalChainRun;
    public int horizontalGroup;
    public HorizontalWidgetRun horizontalRun;
    private boolean horizontalSolvingPass;
    private boolean inPlaceholder;
    public boolean[] isTerminalWidget;
    protected ArrayList<ConstraintAnchor> mAnchors;
    private boolean mAnimated;
    public ConstraintAnchor mBaseline;
    int mBaselineDistance;
    public ConstraintAnchor mBottom;
    boolean mBottomHasCentered;
    public ConstraintAnchor mCenter;
    ConstraintAnchor mCenterX;
    ConstraintAnchor mCenterY;
    private float mCircleConstraintAngle;
    private Object mCompanionWidget;
    private int mContainerItemSkip;
    private String mDebugName;
    public float mDimensionRatio;
    protected int mDimensionRatioSide;
    int mDistToBottom;
    int mDistToLeft;
    int mDistToRight;
    int mDistToTop;
    boolean mGroupsToSolver;
    int mHeight;
    private int mHeightOverride;
    float mHorizontalBiasPercent;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle;
    ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    boolean mHorizontalWrapVisited;
    private boolean mInVirtualLayout;
    public boolean mIsHeightWrapContent;
    private boolean[] mIsInBarrier;
    public boolean mIsWidthWrapContent;
    private int mLastHorizontalMeasureSpec;
    private int mLastVerticalMeasureSpec;
    public ConstraintAnchor mLeft;
    boolean mLeftHasCentered;
    public ConstraintAnchor[] mListAnchors;
    public DimensionBehaviour[] mListDimensionBehaviors;
    protected ConstraintWidget[] mListNextMatchConstraintsWidget;
    public int mMatchConstraintDefaultHeight;
    public int mMatchConstraintDefaultWidth;
    public int mMatchConstraintMaxHeight;
    public int mMatchConstraintMaxWidth;
    public int mMatchConstraintMinHeight;
    public int mMatchConstraintMinWidth;
    public float mMatchConstraintPercentHeight;
    public float mMatchConstraintPercentWidth;
    private int[] mMaxDimension;
    private boolean mMeasureRequested;
    protected int mMinHeight;
    protected int mMinWidth;
    protected ConstraintWidget[] mNextChainWidget;
    protected int mOffsetX;
    protected int mOffsetY;
    public ConstraintWidget mParent;
    int mRelX;
    int mRelY;
    float mResolvedDimensionRatio;
    int mResolvedDimensionRatioSide;
    boolean mResolvedHasRatio;
    public int[] mResolvedMatchConstraintDefault;
    public ConstraintAnchor mRight;
    boolean mRightHasCentered;
    public ConstraintAnchor mTop;
    boolean mTopHasCentered;
    private String mType;
    float mVerticalBiasPercent;
    boolean mVerticalChainFixedPosition;
    int mVerticalChainStyle;
    ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution;
    boolean mVerticalWrapVisited;
    private int mVisibility;
    public float[] mWeight;
    int mWidth;
    private int mWidthOverride;
    private int mWrapBehaviorInParent;
    protected int mX;
    protected int mY;
    public boolean measured;
    private boolean resolvedHorizontal;
    private boolean resolvedVertical;
    public WidgetRun[] run;
    public String stringId;
    public ChainRun verticalChainRun;
    public int verticalGroup;
    public VerticalWidgetRun verticalRun;
    private boolean verticalSolvingPass;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.widgets.ConstraintWidget$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type = null;
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour = null;

        static {
            int[] r0 = new int[DimensionBehaviour.values().length];
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour = r0;
            r0[DimensionBehaviour.FIXED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L36:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L46:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L58:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L10:
            int[] r4 = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type = r4;
            r4[ConstraintAnchor.Type.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L38:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L44:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L52:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
        L34:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L29
        L42:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L30
        L56:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;     // Catch: NoSuchFieldError -> L31
        L40:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;     // Catch: NoSuchFieldError -> L32
        L48:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.NONE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L33
            return;
        }
    }

    public static final enum DimensionBehaviour extends Enum<DimensionBehaviour> {
        private static final /* synthetic */ DimensionBehaviour[] $VALUES = null;
        public static final DimensionBehaviour FIXED = null;
        public static final DimensionBehaviour MATCH_CONSTRAINT = null;
        public static final DimensionBehaviour MATCH_PARENT = null;
        public static final DimensionBehaviour WRAP_CONTENT = null;

        static {
            DimensionBehaviour r0 = new DimensionBehaviour("FIXED", 0);
            FIXED = r0;
            DimensionBehaviour r1 = new DimensionBehaviour("WRAP_CONTENT", 1);
            WRAP_CONTENT = r1;
            DimensionBehaviour r3 = new DimensionBehaviour("MATCH_CONSTRAINT", 2);
            MATCH_CONSTRAINT = r3;
            DimensionBehaviour r5 = new DimensionBehaviour("MATCH_PARENT", 3);
            MATCH_PARENT = r5;
            $VALUES = new DimensionBehaviour[]{r0, r1, r3, r5};
        }

        private DimensionBehaviour(String r1, int r2) {
            super(r1, r2);
        }

        public static DimensionBehaviour valueOf(String r1) {
            return (DimensionBehaviour) Enum.valueOf(DimensionBehaviour.class, r1);
        }

        public static DimensionBehaviour[] values() {
            return (DimensionBehaviour[]) $VALUES.clone();
        }
    }

    static {
    }

    public ConstraintWidget() {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
        this.frame = new WidgetFrame(this);
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.horizontalSolvingPass = false;
        this.verticalSolvingPass = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mWrapBehaviorInParent = 0;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtualLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor r6 = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = r6;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, r6};
        this.mAnchors = new ArrayList();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour r7 = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{r7, r7};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float r5 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = r5;
        this.mVerticalBiasPercent = r5;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mAnimated = false;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        addAnchors();
    }

    public ConstraintWidget(int r2, int r3) {
        this(0, 0, r2, r3);
    }

    public ConstraintWidget(int r11, int r12, int r13, int r14) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
        this.frame = new WidgetFrame(this);
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.horizontalSolvingPass = false;
        this.verticalSolvingPass = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mWrapBehaviorInParent = 0;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtualLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor r6 = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = r6;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, r6};
        this.mAnchors = new ArrayList();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour r7 = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{r7, r7};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float r5 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = r5;
        this.mVerticalBiasPercent = r5;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mAnimated = false;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        this.mX = r11;
        this.mY = r12;
        this.mWidth = r13;
        this.mHeight = r14;
        addAnchors();
    }

    public ConstraintWidget(String r11) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
        this.frame = new WidgetFrame(this);
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.horizontalSolvingPass = false;
        this.verticalSolvingPass = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mWrapBehaviorInParent = 0;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtualLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor r6 = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = r6;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, r6};
        this.mAnchors = new ArrayList();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour r7 = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{r7, r7};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float r5 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = r5;
        this.mVerticalBiasPercent = r5;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mAnimated = false;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        addAnchors();
        setDebugName(r11);
    }

    public ConstraintWidget(String r1, int r2, int r3) {
        this(r2, r3);
        setDebugName(r1);
    }

    public ConstraintWidget(String r1, int r2, int r3, int r4, int r5) {
        this(r2, r3, r4, r5);
        setDebugName(r1);
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    private void applyConstraints(LinearSystem r32, boolean r33, boolean r34, boolean r35, boolean r36, SolverVariable r37, SolverVariable r38, DimensionBehaviour r39, boolean r40, ConstraintAnchor r41, ConstraintAnchor r42, int r43, int r44, int r45, int r46, float r47, boolean r48, boolean r49, boolean r50, boolean r51, boolean r52, int r53, int r54, int r55, int r56, float r57, boolean r58) {
        SolverVariable r9 = r32.createObjectVariable(r41);
        SolverVariable r8 = r32.createObjectVariable(r42);
        SolverVariable r7 = r32.createObjectVariable(r41.getTarget());
        SolverVariable r6 = r32.createObjectVariable(r42.getTarget());
        if (LinearSystem.getMetrics() == null) goto L5;
        LinearSystem.getMetrics().nonresolvedWidgets++;
    L5:
        boolean r11 = r41.isConnected();
        boolean r12 = r42.isConnected();
        boolean r16 = this.mCenter.isConnected();
        if (r12 == false) goto L8;
        int r5 = (r11 ? 1 : 0) + 1;
    L9:
        if (r16 == false) goto L11;
        r5 = r5 + 1;
    L11:
        if (r48 == false) goto L13;
        int r18 = 3;
    L14:
        int r2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[r39.ordinal()];
        if (r2 != 1) goto L17;
    L22:
        int r3 = r18;
    L23:
        boolean r19 = false;
    L27:
        int r14 = this.mWidthOverride;
        if (r14 == (-1)) goto L31;
        if (r33 == false) goto L31;
        this.mWidthOverride = -1;
        r19 = false;
    L32:
        int r10 = this.mHeightOverride;
        if (r10 == (-1)) goto L37;
        if (r33 == true) goto L37;
        this.mHeightOverride = -1;
        r14 = r10;
        r19 = false;
    L37:
        if (this.mVisibility != 8) goto L39;
        r14 = 0;
        r19 = false;
    L39:
        if (r58 == false) goto L47;
        if (r11 == true) goto L44;
        if (r12 == true) goto L44;
        if (r16 == true) goto L44;
        r32.addEquality(r9, r43);
    L44:
        if (r11 == false) goto L47;
        if (r12 == true) goto L47;
        r32.addEquality(r9, r7, r41.getMargin(), 8);
    L47:
        if (r19 == true) goto L58;
        if (r40 == false) goto L55;
        r32.addEquality(r8, r9, 0, 3);
        if (r45 <= 0) goto L53;
        r32.addGreaterThan(r8, r9, r45, 8);
    L53:
        if (r46 >= Integer.MAX_VALUE) goto L56;
        r32.addLowerThan(r8, r9, r46, 8);
    L56:
        int r1 = r56;
        int r410 = r5;
        boolean r23 = r19;
        boolean r110 = r36;
        int r21 = r55;
    L111:
        if (r58 == false) goto L348;
        if (r50 == false) goto L114;
        int r4 = 0;
        char r13 = 2;
    L349:
        if (r410 >= r13) goto L381;
        if (r34 == false) goto L382;
        if (r110 == false) goto L383;
        r32.addGreaterThan(r9, r37, r4, 8);
        if (r33 == false) goto L355;
    L358:
        int r15 = 1;
    L359:
        if (r33 == true) goto L370;
        ConstraintAnchor r0 = this.mBaseline.mTarget;
        if (r0 == null) goto L370;
        ConstraintWidget r17 = r0.mOwner;
        if (r17.mDimensionRatio == 0.0f) goto L369;
        DimensionBehaviour[] r20 = r17.mListDimensionBehaviors;
        DimensionBehaviour r22 = r20[r4];
        DimensionBehaviour r24 = DimensionBehaviour.MATCH_CONSTRAINT;
        if (r22 != r24) goto L369;
        if (r20[1] != r24) goto L369;
        int r111 = 1;
    L371:
        if (r111 == 0) goto L384;
        r32.addGreaterThan(r38, r8, r4, 8);
        return;
    L384:
        return;
    L369:
        r111 = r4;
    L370:
        r111 = r15;
        goto L371
    L355:
        if (this.mBaseline.mTarget == null) goto L358;
        r15 = r4;
        goto L359
    L383:
        return;
    L382:
        return;
    L381:
        return;
    L114:
        if (r11 == true) goto L118;
        if (r12 == true) goto L118;
        if (r16 == true) goto L118;
        int r25 = 5;
        int r26 = 0;
    L326:
        boolean r27 = r34;
    L327:
        int r28 = r25;
    L328:
        if (r27 == false) goto L378;
        if (r110 == true) goto L331;
        return;
    L331:
        if (r42.mTarget == null) goto L333;
        int r112 = r42.getMargin();
    L334:
        if (r6 != r38) goto L336;
        return;
    L336:
        if (this.OPTIMIZE_WRAP == true) goto L338;
    L346:
        r32.addGreaterThan(r38, r8, r112, r28);
        return;
    L338:
        if (r8.isFinalValue == false) goto L346;
        ConstraintWidget r29 = this.mParent;
        if (r29 == null) goto L346;
        ConstraintWidgetContainer r30 = (ConstraintWidgetContainer) r29;
        if (r33 == false) goto L344;
        r30.addHorizontalWrapMaxVariable(r42);
        return;
    L344:
        r30.addVerticalWrapMaxVariable(r42);
        return;
    L333:
        r112 = r26;
        goto L334
    L378:
        return;
    L118:
        if (r11 == false) goto L128;
        if (r12 == true) goto L128;
        ConstraintWidget r31 = r41.mTarget.mOwner;
        if (r34 == true) goto L123;
    L125:
        int r113 = 5;
    L126:
        r27 = r34;
        r26 = 0;
        r28 = r113;
        r8 = r8;
        goto L328
    L123:
        if ((r31 instanceof Barrier) == false) goto L125;
        r113 = 8;
    L128:
        if (r11 == true) goto L144;
        if (r12 == false) goto L144;
        r32.addEquality(r8, r6, -r42.getMargin(), 8);
        if (r34 == true) goto L133;
    L325:
        r26 = 0;
        r25 = 5;
        goto L326
    L133:
        if (this.OPTIMIZE_WRAP == true) goto L135;
    L142:
        r25 = 5;
        r32.addGreaterThan(r9, r37, 0, 5);
        r26 = 0;
        goto L326
    L135:
        if (r9.isFinalValue == false) goto L142;
        ConstraintWidget r59 = this.mParent;
        if (r59 == null) goto L142;
        ConstraintWidgetContainer r60 = (ConstraintWidgetContainer) r59;
        if (r33 == false) goto L141;
        r60.addHorizontalWrapMinVariable(r41);
        goto L325
    L141:
        r60.addVerticalWrapMinVariable(r41);
    L144:
        if (r11 == false) goto L325;
        if (r12 == false) goto L325;
        ConstraintWidget r114 = r41.mTarget.mOwner;
        ConstraintWidget r61 = r42.mTarget.mOwner;
        ConstraintWidget r62 = getParent();
        int r115 = 6;
        if (r23 == false) goto L218;
        if (r3 != 0) goto L167;
        if (r1 != 0) goto L158;
        if (r21 != 0) goto L158;
        if (r7.isFinalValue == true) goto L154;
    L157:
        boolean r116 = false;
        boolean r210 = false;
        int r63 = 8;
        int r64 = 8;
        boolean r211 = true;
    L160:
        if ((r114 instanceof Barrier) == false) goto L162;
    L166:
        r38 = r38;
        int r65 = r63;
        r115 = 6;
        boolean r212 = r211;
        boolean r213 = r116;
        int r117 = 4;
    L235:
        if (r210 == false) goto L239;
        if (r7 != r6) goto L239;
        if (r114 == r62) goto L239;
        r210 = false;
        boolean r214 = false;
    L240:
        if (r213 == false) goto L249;
        if (r23 == true) goto L247;
        if (r49 == true) goto L247;
        if (r51 == true) goto L247;
        if (r7 != r37) goto L247;
        if (r6 != r38) goto L247;
        r27 = false;
        int r215 = 8;
        int r216 = 8;
        boolean r217 = false;
    L248:
        int r310 = r3;
        ConstraintWidget r218 = r62;
        r32.addCentering(r9, r7, r41.getMargin(), r47, r6, r8, r42.getMargin(), r216);
        r65 = r215;
        r214 = r217;
    L251:
        if (this.mVisibility == 8) goto L253;
    L255:
        if (r210 == false) goto L265;
        if (r27 == false) goto L264;
        if (r7 == r6) goto L264;
        if (r23 == true) goto L264;
        if ((r114 instanceof Barrier) == false) goto L262;
    L263:
        r65 = 6;
        goto L264
    L262:
        if ((r61 instanceof Barrier) == true) goto L263;
    L264:
        r32.addGreaterThan(r9, r7, r41.getMargin(), r65);
        r8 = r8;
        r32.addLowerThan(r8, r6, -r42.getMargin(), r65);
    L266:
        if (r27 == false) goto L275;
        if (r52 == false) goto L275;
        if ((r114 instanceof Barrier) == true) goto L275;
        if ((r61 instanceof Barrier) == true) goto L275;
        ConstraintWidget r66 = r218;
        if (r61 == r66) goto L276;
        r65 = 6;
        int r67 = 6;
        r214 = true;
    L277:
        if (r214 == false) goto L308;
        if (r212 == false) goto L299;
        if (r51 == false) goto L281;
        if (r35 == false) goto L299;
    L281:
        if (r114 == r66) goto L285;
        if (r61 == r66) goto L285;
        int r68 = r67;
    L287:
        if ((r114 instanceof Guideline) == false) goto L289;
    L290:
        r68 = 5;
    L292:
        if ((r114 instanceof Barrier) == false) goto L294;
    L295:
        r68 = 5;
    L296:
        if (r51 == false) goto L298;
        r68 = 5;
    L298:
        r67 = Math.max(r68, r67);
        goto L299
    L294:
        if ((r61 instanceof Barrier) == false) goto L296;
    L289:
        if ((r61 instanceof Guideline) == false) goto L292;
    L285:
        r68 = 6;
    L299:
        if (r27 == false) goto L307;
        int r69 = Math.min(r65, r67);
        if (r48 == false) goto L306;
        if (r51 == true) goto L306;
        if (r114 == r66) goto L305;
        if (r61 != r66) goto L306;
    L305:
        r67 = 4;
    L306:
        r67 = r69;
    L307:
        r32.addEquality(r9, r7, r41.getMargin(), r67);
        r32.addEquality(r8, r6, -r42.getMargin(), r67);
    L308:
        if (r27 == true) goto L310;
    L315:
        if (r27 == false) goto L324;
        if (r23 == false) goto L324;
        if (r45 != 0) goto L324;
        if (r21 != 0) goto L324;
        if (r23 == true) goto L321;
    L323:
        r26 = 0;
        r25 = 5;
        r32.addGreaterThan(r8, r9, 0, 5);
        goto L327
    L321:
        if (r310 != 3) goto L323;
        r26 = 0;
        r32.addGreaterThan(r8, r9, 0, 8);
        r25 = 5;
    L324:
        r25 = 5;
        r26 = 0;
        goto L327
    L310:
        if (r37 != r7) goto L312;
        int r70 = r41.getMargin();
    L313:
        if (r7 == r37) goto L315;
        r32.addGreaterThan(r9, r37, r70, 5);
        goto L315
    L312:
        r70 = 0;
    L276:
        r67 = r117;
    L275:
        r66 = r218;
        goto L276
    L265:
        r8 = r8;
        goto L266
    L253:
        if (r42.hasDependents() == true) goto L255;
        return;
    L247:
        r27 = r34;
        r216 = r115;
        r217 = r214;
        r215 = r65;
        goto L248
    L249:
        r310 = r3;
        r218 = r62;
        r27 = r34;
    L239:
        r214 = true;
        goto L240
    L162:
        if ((r61 instanceof Barrier) == true) goto L166;
        r212 = r211;
        r213 = r116;
        r117 = r64;
    L165:
        r65 = r63;
        r115 = 6;
        goto L235
    L154:
        if (r6.isFinalValue == false) goto L157;
        r32.addEquality(r9, r7, r41.getMargin(), 8);
        r32.addEquality(r8, r6, -r42.getMargin(), 8);
        return;
    L158:
        r211 = false;
        r63 = 5;
        r64 = 5;
        r116 = true;
        r210 = true;
        goto L160
    L167:
        if (r3 != 2) goto L176;
        if ((r114 instanceof Barrier) == true) goto L231;
        if ((r61 instanceof Barrier) == true) goto L231;
        r38 = r38;
        r115 = 6;
        r65 = 5;
        r117 = 5;
    L233:
        r213 = true;
        r210 = true;
    L234:
        r212 = false;
    L231:
        r65 = 5;
    L232:
        r117 = 4;
        goto L233
    L176:
        if (r3 != 1) goto L179;
        r65 = 8;
        goto L232
    L179:
        if (r3 == 3) goto L181;
        r38 = r38;
        r115 = 6;
        r65 = 5;
        r117 = 4;
        r213 = false;
        r210 = false;
        goto L234
    L181:
        if (this.mResolvedDimensionRatioSide == (-1)) goto L183;
        if (r48 == true) goto L193;
        if (r1 <= 0) goto L205;
        r115 = 6;
        r65 = 5;
    L189:
        r117 = 5;
    L190:
        r213 = true;
        r210 = true;
        r212 = true;
        goto L235
    L205:
        if (r1 != 0) goto L214;
        if (r21 != 0) goto L214;
        if (r51 == true) goto L209;
        r38 = r38;
        r115 = 6;
        r65 = 5;
        r117 = 8;
        goto L190
    L209:
        if (r114 == r62) goto L212;
        if (r61 == r62) goto L212;
        int r71 = 4;
    L213:
        r65 = r71;
    L215:
        r117 = 4;
    L212:
        r71 = 5;
    L214:
        r65 = 5;
        goto L215
    L193:
        if (r54 != 2) goto L195;
    L198:
        boolean r72 = true;
    L199:
        if (r72 == true) goto L201;
        r63 = 8;
        int r73 = 5;
    L202:
        r117 = r73;
        r213 = true;
        r210 = true;
        r212 = true;
        goto L165
    L201:
        r63 = 5;
        r73 = 4;
        goto L202
    L195:
        if (r54 == 1) goto L198;
        r72 = false;
        goto L199
    L183:
        if (r51 == false) goto L187;
        if (r34 == false) goto L186;
        r115 = 5;
    L188:
        r65 = 8;
        goto L189
    L186:
        r115 = 4;
        goto L188
    L187:
        r115 = 8;
        goto L188
    L218:
        if (r7.isFinalValue == false) goto L231;
        if (r6.isFinalValue == false) goto L231;
        r32.addCentering(r9, r7, r41.getMargin(), r47, r6, r8, r42.getMargin(), 8);
        if (r34 == false) goto L374;
        if (r110 == true) goto L225;
        return;
    L225:
        if (r42.mTarget == null) goto L227;
        int r118 = r42.getMargin();
    L228:
        if (r6 == r38) goto L376;
        r32.addGreaterThan(r38, r8, r118, 5);
        return;
    L376:
        return;
    L227:
        r118 = 0;
        goto L228
    L374:
        return;
    L348:
        r4 = 0;
        r13 = 2;
        goto L349
    L55:
        r32.addEquality(r8, r9, r14, 8);
        goto L56
    L58:
        if (r5 == 2) goto L68;
        if (r48 == true) goto L68;
        if (r3 == 1) goto L63;
        if (r3 != 0) goto L68;
    L63:
        int r74 = Math.max(r55, r14);
        if (r56 <= 0) goto L66;
        r74 = Math.min(r56, r74);
    L66:
        r32.addEquality(r8, r9, r74, 8);
        r110 = r36;
        r1 = r56;
        r410 = r5;
        r23 = false;
        r21 = r55;
    L68:
        if (r55 != (-2)) goto L70;
        int r75 = r14;
    L71:
        if (r56 != (-2)) goto L73;
        r1 = r14;
    L74:
        if (r14 > 0) goto L76;
    L78:
        if (r75 <= 0) goto L80;
        r32.addGreaterThan(r8, r9, r75, 8);
        r14 = Math.max(r14, r75);
    L80:
        if (r1 <= 0) goto L90;
        if (r34 == true) goto L83;
    L85:
        boolean r76 = true;
    L86:
        if (r76 == false) goto L88;
        int r77 = 8;
        r32.addLowerThan(r8, r9, r1, 8);
    L89:
        r14 = Math.min(r14, r1);
    L92:
        if (r3 != 1) goto L98;
        if (r34 == false) goto L95;
        r32.addEquality(r8, r9, r14, r77);
    L96:
        r410 = r5;
        r23 = r19;
        r110 = r36;
        r21 = r75;
        goto L111
    L95:
        r32.addEquality(r8, r9, r14, 5);
        r32.addLowerThan(r8, r9, r14, r77);
        goto L96
    L98:
        if (r3 != 2) goto L110;
        ConstraintAnchor.Type r78 = r41.getType();
        ConstraintAnchor.Type r79 = ConstraintAnchor.Type.TOP;
        if (r78 != r79) goto L102;
    L105:
        SolverVariable r80 = r32.createObjectVariable(this.mParent.getAnchor(r79));
        ConstraintWidget r81 = this.mParent;
        ConstraintAnchor.Type r119 = ConstraintAnchor.Type.BOTTOM;
    L106:
        SolverVariable r82 = r32.createObjectVariable(r81.getAnchor(r119));
        SolverVariable r219 = r80;
        ArrayRow r83 = r32.createRow();
        r410 = r5 == true ? 1 : 0;
        r21 = r75;
        r32.addConstraint(r83.createRowDimensionRatio(r8, r9, r82, r219, r57));
        if (r34 == false) goto L109;
        r19 = false;
    L109:
        r23 = r19;
        r110 = r36;
        goto L111
    L102:
        if (r41.getType() == ConstraintAnchor.Type.BOTTOM) goto L105;
        r80 = r32.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.LEFT));
        r81 = this.mParent;
        r119 = ConstraintAnchor.Type.RIGHT;
        goto L106
    L110:
        r410 = r5;
        r21 = r75;
        r23 = r19;
        r110 = true;
        goto L111
    L88:
        r77 = 8;
        goto L89
    L83:
        if (r3 != 1) goto L85;
        r76 = false;
        goto L86
    L90:
        r77 = 8;
        goto L92
    L76:
        if (r3 == 1) goto L78;
        r14 = 0;
        goto L78
    L73:
        r1 = r56;
        goto L74
    L70:
        r75 = r55;
    L31:
        r14 = r44;
        goto L32
    L17:
        if (r2 == 2) goto L22;
        if (r2 == 3) goto L22;
        if (r2 != 4) goto L22;
        r3 = r18;
        if (r3 == 4) goto L23;
        r19 = true;
        goto L27
    L13:
        r18 = r53;
        goto L14
    L8:
        r5 = r11 ? 1 : 0;
        goto L9
    }

    private void getSceneString(StringBuilder r1, String r2, int r3, int r4, int r5, int r6, int r7, int r8, float r9, float r10) {
        r1.append(r2);
        r1.append(" :  {\n");
        serializeAttribute(r1, "      size", r3, 0);
        serializeAttribute(r1, "      min", r4, 0);
        serializeAttribute(r1, "      max", r5, Integer.MAX_VALUE);
        serializeAttribute(r1, "      matchMin", r7, 0);
        serializeAttribute(r1, "      matchDef", r8, 0);
        serializeAttribute(r1, "      matchPercent", r9, 1.0f);
        r1.append("    },\n");
    }

    private void getSceneString(StringBuilder r2, String r3, ConstraintAnchor r4) {
        if (r4.mTarget != null) goto L5;
        return;
    L5:
        r2.append("    ");
        r2.append(r3);
        r2.append(" : [ '");
        r2.append(r4.mTarget);
        r2.append("'");
        if (r4.mGoneMargin == Integer.MIN_VALUE) goto L8;
    L9:
        r2.append(",");
        r2.append(r4.mMargin);
        if (r4.mGoneMargin == Integer.MIN_VALUE) goto L12;
        r2.append(",");
        r2.append(r4.mGoneMargin);
        r2.append(",");
    L12:
        r2.append(" ] ,\n");
        return;
    L8:
        if (r4.mMargin == 0) goto L12;
        goto L9
    }

    private boolean isChainHead(int r4) {
        int r5 = r4 * 2;
        ConstraintAnchor[] r3 = this.mListAnchors;
        if (r3[r5].mTarget != null) goto L5;
    L11:
        return false;
    L5:
        if (r3[r5].mTarget.mTarget == r3[r5]) goto L11;
        int r6 = r5 + 1;
        if (r3[r6].mTarget == null) goto L11;
        if (r3[r6].mTarget.mTarget != r3[r6]) goto L11;
        return true;
    }

    private void serializeAnchor(StringBuilder r1, String r2, ConstraintAnchor r3) {
        if (r3.mTarget != null) goto L5;
        return;
    L5:
        r1.append(r2);
        r1.append(" : [ '");
        r1.append(r3.mTarget);
        r1.append("',");
        r1.append(r3.mMargin);
        r1.append(",");
        r1.append(r3.mGoneMargin);
        r1.append(",");
        r1.append(" ] ,\n");
    }

    private void serializeAttribute(StringBuilder r1, String r2, float r3, float r4) {
        if (r3 != r4) goto L5;
        return;
    L5:
        r1.append(r2);
        r1.append(" :   ");
        r1.append(r3);
        r1.append(",\n");
    }

    private void serializeAttribute(StringBuilder r1, String r2, int r3, int r4) {
        if (r3 != r4) goto L4;
        return;
    L4:
        r1.append(r2);
        r1.append(" :   ");
        r1.append(r3);
        r1.append(",\n");
    }

    private void serializeCircle(StringBuilder r1, ConstraintAnchor r2, float r3) {
        if (r2.mTarget != null) goto L5;
        return;
    L5:
        r1.append("circle : [ '");
        r1.append(r2.mTarget);
        r1.append("',");
        r1.append(r2.mMargin);
        r1.append(",");
        r1.append(r3);
        r1.append(",");
        r1.append(" ] ,\n");
    }

    private void serializeDimensionRatio(StringBuilder r1, String r2, float r3, int r4) {
        if (r3 != 0.0f) goto L5;
        return;
    L5:
        r1.append(r2);
        r1.append(" :  [");
        r1.append(r3);
        r1.append(",");
        r1.append(r4);
        r1.append("");
        r1.append("],\n");
    }

    private void serializeSize(StringBuilder r1, String r2, int r3, int r4, int r5, int r6, int r7, int r8, float r9, float r10) {
        r1.append(r2);
        r1.append(" :  {\n");
        serializeAttribute(r1, "size", r3, Integer.MIN_VALUE);
        serializeAttribute(r1, "min", r4, 0);
        serializeAttribute(r1, "max", r5, Integer.MAX_VALUE);
        serializeAttribute(r1, "matchMin", r7, 0);
        serializeAttribute(r1, "matchDef", r8, 0);
        serializeAttribute(r1, "matchPercent", r8, 1);
        r1.append("},\n");
    }

    public void addChildrenToSolverByDependency(ConstraintWidgetContainer r8, LinearSystem r9, HashSet<ConstraintWidget> r10, int r11, boolean r12) {
        if (r12 == true) goto L4;
    L7:
        if (r11 != 0) goto L20;
        HashSet<ConstraintAnchor> r13 = this.mLeft.getDependents();
        if (r13 == null) goto L14;
        Iterator<ConstraintAnchor> r14 = r13.iterator();
    L12:
        if (r14.hasNext() == false) goto L14;
        r14.next().mOwner.addChildrenToSolverByDependency(r8, r9, r10, r11, true);
    L14:
        HashSet<ConstraintAnchor> r7 = this.mRight.getDependents();
        if (r7 == null) goto L38;
        Iterator<ConstraintAnchor> r15 = r7.iterator();
    L18:
        if (r15.hasNext() == false) goto L45;
        r15.next().mOwner.addChildrenToSolverByDependency(r8, r9, r10, r11, true);
        goto L18
    L45:
        return;
    L38:
        return;
    L20:
        HashSet<ConstraintAnchor> r16 = this.mTop.getDependents();
        if (r16 == null) goto L26;
        Iterator<ConstraintAnchor> r17 = r16.iterator();
    L24:
        if (r17.hasNext() == false) goto L26;
        r17.next().mOwner.addChildrenToSolverByDependency(r8, r9, r10, r11, true);
    L26:
        HashSet<ConstraintAnchor> r18 = this.mBottom.getDependents();
        if (r18 == null) goto L32;
        Iterator<ConstraintAnchor> r19 = r18.iterator();
    L30:
        if (r19.hasNext() == false) goto L32;
        r19.next().mOwner.addChildrenToSolverByDependency(r8, r9, r10, r11, true);
    L32:
        HashSet<ConstraintAnchor> r20 = this.mBaseline.getDependents();
        if (r20 == null) goto L44;
        Iterator<ConstraintAnchor> r21 = r20.iterator();
    L36:
        if (r21.hasNext() == false) goto L46;
        r21.next().mOwner.addChildrenToSolverByDependency(r8, r9, r10, r11, true);
        goto L36
    L46:
        return;
    L44:
        return;
    L4:
        if (r10.contains(this) == true) goto L6;
        return;
    L6:
        Optimizer.checkMatchParent(r8, r9, this);
        r10.remove(this);
        addToSolver(r9, r8.optimizeFor(64));
        goto L7
    }

    boolean addFirst() {
        if ((this instanceof VirtualLayout) == false) goto L5;
    L8:
        return true;
    L5:
        if ((this instanceof Guideline) == true) goto L8;
        return false;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 15631. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public void addToSolver(androidx.constraintlayout.core.LinearSystem r54, boolean r55) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: IGET (r0v0 ?? I:androidx.constraintlayout.core.widgets.ConstraintAnchor) = (r53v0 'this' ?? I:androidx.constraintlayout.core.widgets.ConstraintWidget A[IMMUTABLE_TYPE, THIS]) A[DECLARE_VAR] androidx.constraintlayout.core.widgets.ConstraintWidget.mLeft androidx.constraintlayout.core.widgets.ConstraintAnchor in method: androidx.constraintlayout.core.widgets.ConstraintWidget.addToSolver(androidx.constraintlayout.core.LinearSystem, boolean):void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 1563
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.addToSolver(androidx.constraintlayout.core.LinearSystem, boolean):void");
    }

    public boolean allowedInBarrier() {
        if (this.mVisibility == 8) goto L5;
        return true;
    L5:
        return false;
    }

    public void connect(ConstraintAnchor.Type r2, ConstraintWidget r3, ConstraintAnchor.Type r4) {
        connect(r2, r3, r4, 0);
    }

    public void connect(ConstraintAnchor.Type r9, ConstraintWidget r10, ConstraintAnchor.Type r11, int r12) {
        ConstraintAnchor.Type r0 = ConstraintAnchor.Type.CENTER;
        if (r9 != r0) goto L44;
        ConstraintAnchor.Type r13 = ConstraintAnchor.Type.LEFT;
        if (r11 != r0) goto L31;
        ConstraintAnchor r14 = getAnchor(r13);
        ConstraintAnchor.Type r15 = ConstraintAnchor.Type.RIGHT;
        ConstraintAnchor r2 = getAnchor(r15);
        ConstraintAnchor.Type r3 = ConstraintAnchor.Type.TOP;
        ConstraintAnchor r4 = getAnchor(r3);
        ConstraintAnchor.Type r5 = ConstraintAnchor.Type.BOTTOM;
        ConstraintAnchor r6 = getAnchor(r5);
        boolean r7 = true;
        if (r14 != null) goto L9;
    L10:
        if (r2 != null) goto L12;
    L14:
        connect(r13, r10, r13, 0);
        connect(r15, r10, r15, 0);
        boolean r16 = true;
    L15:
        if (r4 != null) goto L17;
    L18:
        if (r6 != null) goto L20;
    L22:
        connect(r3, r10, r3, 0);
        connect(r5, r10, r5, 0);
    L23:
        if (r16 == false) goto L26;
        if (r7 == false) goto L26;
        ConstraintAnchor r8 = getAnchor(r0);
        ConstraintAnchor r17 = r10.getAnchor(r0);
    L43:
        r8.connect(r17, 0);
        return;
    L26:
        if (r16 == false) goto L29;
        ConstraintAnchor.Type r18 = ConstraintAnchor.Type.CENTER_X;
    L28:
        r8 = getAnchor(r18);
        r17 = r10.getAnchor(r18);
        goto L43
    L29:
        if (r7 == false) goto L100;
        r18 = ConstraintAnchor.Type.CENTER_Y;
        goto L28
    L100:
        return;
    L20:
        if (r6.isConnected() == false) goto L22;
    L21:
        r7 = false;
        goto L23
    L17:
        if (r4.isConnected() == true) goto L21;
    L12:
        if (r2.isConnected() == false) goto L14;
    L13:
        r16 = false;
        goto L15
    L9:
        if (r14.isConnected() == true) goto L13;
    L31:
        if (r11 != r13) goto L33;
    L40:
        connect(r13, r10, r11, 0);
        ConstraintAnchor.Type r19 = ConstraintAnchor.Type.RIGHT;
    L41:
        connect(r19, r10, r11, 0);
        r8 = getAnchor(r0);
    L42:
        r17 = r10.getAnchor(r11);
        goto L43
    L33:
        if (r11 == ConstraintAnchor.Type.RIGHT) goto L40;
        ConstraintAnchor.Type r20 = ConstraintAnchor.Type.TOP;
        if (r11 != r20) goto L38;
    L39:
        connect(r20, r10, r11, 0);
        r19 = ConstraintAnchor.Type.BOTTOM;
        goto L41
    L38:
        if (r11 == ConstraintAnchor.Type.BOTTOM) goto L39;
        return;
    L44:
        ConstraintAnchor.Type r21 = ConstraintAnchor.Type.CENTER_X;
        if (r9 != r21) goto L51;
        ConstraintAnchor.Type r22 = ConstraintAnchor.Type.LEFT;
        if (r11 != r22) goto L49;
    L50:
        ConstraintAnchor r23 = getAnchor(r22);
        ConstraintAnchor r110 = r10.getAnchor(r11);
        ConstraintAnchor r111 = getAnchor(ConstraintAnchor.Type.RIGHT);
        r23.connect(r110, 0);
        r111.connect(r110, 0);
        getAnchor(r21).connect(r110, 0);
        return;
    L49:
        if (r11 == ConstraintAnchor.Type.RIGHT) goto L50;
    L51:
        ConstraintAnchor.Type r24 = ConstraintAnchor.Type.CENTER_Y;
        if (r9 != r24) goto L58;
        ConstraintAnchor.Type r25 = ConstraintAnchor.Type.TOP;
        if (r11 != r25) goto L56;
    L57:
        r17 = r10.getAnchor(r11);
        getAnchor(r25).connect(r17, 0);
        getAnchor(ConstraintAnchor.Type.BOTTOM).connect(r17, 0);
        r8 = getAnchor(r24);
        goto L43
    L56:
        if (r11 == ConstraintAnchor.Type.BOTTOM) goto L57;
    L58:
        if (r9 != r21) goto L61;
        if (r11 != r21) goto L61;
        ConstraintAnchor.Type r26 = ConstraintAnchor.Type.LEFT;
        getAnchor(r26).connect(r10.getAnchor(r26), 0);
        ConstraintAnchor.Type r27 = ConstraintAnchor.Type.RIGHT;
        getAnchor(r27).connect(r10.getAnchor(r27), 0);
        r8 = getAnchor(r21);
    L61:
        if (r9 != r24) goto L64;
        if (r11 != r24) goto L64;
        ConstraintAnchor.Type r28 = ConstraintAnchor.Type.TOP;
        getAnchor(r28).connect(r10.getAnchor(r28), 0);
        ConstraintAnchor.Type r29 = ConstraintAnchor.Type.BOTTOM;
        getAnchor(r29).connect(r10.getAnchor(r29), 0);
        r8 = getAnchor(r24);
    L64:
        ConstraintAnchor r1 = getAnchor(r9);
        ConstraintAnchor r112 = r10.getAnchor(r11);
        if (r1.isValidConnection(r112) == false) goto L104;
        ConstraintAnchor.Type r113 = ConstraintAnchor.Type.BASELINE;
        if (r9 != r113) goto L74;
        ConstraintAnchor r30 = getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor r31 = getAnchor(ConstraintAnchor.Type.BOTTOM);
        if (r30 == null) goto L71;
        r30.reset();
    L71:
        if (r31 != null) goto L88;
    L98:
        r1.connect(r112, r12);
        return;
    L88:
        r31.reset();
        goto L98
    L74:
        if (r9 != ConstraintAnchor.Type.TOP) goto L76;
    L89:
        ConstraintAnchor r114 = getAnchor(r113);
        if (r114 == null) goto L92;
        r114.reset();
    L92:
        ConstraintAnchor r115 = getAnchor(r0);
        if (r115.getTarget() == r112) goto L95;
        r115.reset();
    L95:
        ConstraintAnchor r32 = getAnchor(r9).getOpposite();
        r31 = getAnchor(r24);
        if (r31.isConnected() == false) goto L98;
    L87:
        r32.reset();
        goto L88
    L76:
        if (r9 == ConstraintAnchor.Type.BOTTOM) goto L89;
        if (r9 != ConstraintAnchor.Type.LEFT) goto L81;
    L82:
        ConstraintAnchor r116 = getAnchor(r0);
        if (r116.getTarget() == r112) goto L85;
        r116.reset();
    L85:
        r32 = getAnchor(r9).getOpposite();
        r31 = getAnchor(r21);
        if (r31.isConnected() == false) goto L98;
    L81:
        if (r9 != ConstraintAnchor.Type.RIGHT) goto L98;
    }

    public void connect(ConstraintAnchor r2, ConstraintAnchor r3, int r4) {
        if (r2.getOwner() != this) goto L6;
        connect(r2.getType(), r3.getOwner(), r3.getType(), r4);
        return;
    }

    public void connectCircularConstraint(ConstraintWidget r7, float r8, int r9) {
        ConstraintAnchor.Type r3 = ConstraintAnchor.Type.CENTER;
        immediateConnect(r3, r7, r3, r9, 0);
        this.mCircleConstraintAngle = r8;
    }

    public void copy(ConstraintWidget r7, HashMap<ConstraintWidget, ConstraintWidget> r8) {
        this.mHorizontalResolution = r7.mHorizontalResolution;
        this.mVerticalResolution = r7.mVerticalResolution;
        this.mMatchConstraintDefaultWidth = r7.mMatchConstraintDefaultWidth;
        this.mMatchConstraintDefaultHeight = r7.mMatchConstraintDefaultHeight;
        int[] r0 = this.mResolvedMatchConstraintDefault;
        int[] r1 = r7.mResolvedMatchConstraintDefault;
        r0[0] = r1[0];
        r0[1] = r1[1];
        this.mMatchConstraintMinWidth = r7.mMatchConstraintMinWidth;
        this.mMatchConstraintMaxWidth = r7.mMatchConstraintMaxWidth;
        this.mMatchConstraintMinHeight = r7.mMatchConstraintMinHeight;
        this.mMatchConstraintMaxHeight = r7.mMatchConstraintMaxHeight;
        this.mMatchConstraintPercentHeight = r7.mMatchConstraintPercentHeight;
        this.mIsWidthWrapContent = r7.mIsWidthWrapContent;
        this.mIsHeightWrapContent = r7.mIsHeightWrapContent;
        this.mResolvedDimensionRatioSide = r7.mResolvedDimensionRatioSide;
        this.mResolvedDimensionRatio = r7.mResolvedDimensionRatio;
        int[] r2 = r7.mMaxDimension;
        this.mMaxDimension = Arrays.copyOf(r2, r2.length);
        this.mCircleConstraintAngle = r7.mCircleConstraintAngle;
        this.hasBaseline = r7.hasBaseline;
        this.inPlaceholder = r7.inPlaceholder;
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mListDimensionBehaviors = (DimensionBehaviour[]) Arrays.copyOf(this.mListDimensionBehaviors, 2);
        ConstraintWidget r3 = null;
        if (this.mParent != null) goto L5;
        ConstraintWidget r4 = null;
    L6:
        this.mParent = r4;
        this.mWidth = r7.mWidth;
        this.mHeight = r7.mHeight;
        this.mDimensionRatio = r7.mDimensionRatio;
        this.mDimensionRatioSide = r7.mDimensionRatioSide;
        this.mX = r7.mX;
        this.mY = r7.mY;
        this.mRelX = r7.mRelX;
        this.mRelY = r7.mRelY;
        this.mOffsetX = r7.mOffsetX;
        this.mOffsetY = r7.mOffsetY;
        this.mBaselineDistance = r7.mBaselineDistance;
        this.mMinWidth = r7.mMinWidth;
        this.mMinHeight = r7.mMinHeight;
        this.mHorizontalBiasPercent = r7.mHorizontalBiasPercent;
        this.mVerticalBiasPercent = r7.mVerticalBiasPercent;
        this.mCompanionWidget = r7.mCompanionWidget;
        this.mContainerItemSkip = r7.mContainerItemSkip;
        this.mVisibility = r7.mVisibility;
        this.mAnimated = r7.mAnimated;
        this.mDebugName = r7.mDebugName;
        this.mType = r7.mType;
        this.mDistToTop = r7.mDistToTop;
        this.mDistToLeft = r7.mDistToLeft;
        this.mDistToRight = r7.mDistToRight;
        this.mDistToBottom = r7.mDistToBottom;
        this.mLeftHasCentered = r7.mLeftHasCentered;
        this.mRightHasCentered = r7.mRightHasCentered;
        this.mTopHasCentered = r7.mTopHasCentered;
        this.mBottomHasCentered = r7.mBottomHasCentered;
        this.mHorizontalWrapVisited = r7.mHorizontalWrapVisited;
        this.mVerticalWrapVisited = r7.mVerticalWrapVisited;
        this.mHorizontalChainStyle = r7.mHorizontalChainStyle;
        this.mVerticalChainStyle = r7.mVerticalChainStyle;
        this.mHorizontalChainFixedPosition = r7.mHorizontalChainFixedPosition;
        this.mVerticalChainFixedPosition = r7.mVerticalChainFixedPosition;
        float[] r5 = this.mWeight;
        float[] r6 = r7.mWeight;
        r5[0] = r6[0];
        r5[1] = r6[1];
        ConstraintWidget[] r9 = this.mListNextMatchConstraintsWidget;
        ConstraintWidget[] r10 = r7.mListNextMatchConstraintsWidget;
        r9[0] = r10[0];
        r9[1] = r10[1];
        ConstraintWidget[] r11 = this.mNextChainWidget;
        ConstraintWidget[] r12 = r7.mNextChainWidget;
        r11[0] = r12[0];
        r11[1] = r12[1];
        ConstraintWidget r13 = r7.mHorizontalNextWidget;
        if (r13 != null) goto L9;
        ConstraintWidget r14 = null;
    L10:
        this.mHorizontalNextWidget = r14;
        ConstraintWidget r15 = r7.mVerticalNextWidget;
        if (r15 == null) goto L14;
        r3 = r8.get(r15);
    L14:
        this.mVerticalNextWidget = r3;
        return;
    L9:
        r14 = r8.get(r13);
        goto L10
    L5:
        r4 = r8.get(r7.mParent);
        goto L6
    }

    public void createObjectVariables(LinearSystem r2) {
        r2.createObjectVariable(this.mLeft);
        r2.createObjectVariable(this.mTop);
        r2.createObjectVariable(this.mRight);
        r2.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance <= 0) goto L6;
        r2.createObjectVariable(this.mBaseline);
        return;
    }

    public void ensureMeasureRequested() {
        this.mMeasureRequested = true;
    }

    public void ensureWidgetRuns() {
        if (this.horizontalRun != null) goto L6;
        this.horizontalRun = new HorizontalWidgetRun(this);
    L6:
        if (this.verticalRun != null) goto L9;
        this.verticalRun = new VerticalWidgetRun(this);
        return;
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type r3) {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[r3.ordinal()]) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L9;
            case 9: goto L6;
            default: goto L5;
        };
    L6:
        return null;
    L5:
        throw new AssertionError(r3.name());
    L9:
        return this.mCenterY;
    L11:
        return this.mCenterX;
    L13:
        return this.mCenter;
    L15:
        return this.mBaseline;
    L17:
        return this.mBottom;
    L19:
        return this.mRight;
    L21:
        return this.mTop;
    L23:
        return this.mLeft;
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public float getBiasPercent(int r2) {
        if (r2 != 0) goto L6;
        return this.mHorizontalBiasPercent;
    L6:
        if (r2 == 1) goto L8;
        return -1.0f;
    L8:
        return this.mVerticalBiasPercent;
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public DimensionBehaviour getDimensionBehaviour(int r2) {
        if (r2 != 0) goto L6;
        return getHorizontalDimensionBehaviour();
    L6:
        if (r2 == 1) goto L8;
        return null;
    L8:
        return getVerticalDimensionBehaviour();
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public boolean getHasBaseline() {
        return this.hasBaseline;
    }

    public int getHeight() {
        if (this.mVisibility != 8) goto L7;
        return 0;
    L7:
        return this.mHeight;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        if (isInHorizontalChain() == false) goto L36;
        ConstraintWidget r2 = this;
        ConstraintWidget r0 = null;
    L5:
        if (r0 != null) goto L26;
        if (r2 == null) goto L26;
        ConstraintAnchor r3 = r2.getAnchor(ConstraintAnchor.Type.LEFT);
        if (r3 != null) goto L10;
        ConstraintAnchor r4 = null;
    L11:
        if (r4 != null) goto L13;
        ConstraintWidget r5 = null;
    L15:
        if (r5 == getParent()) goto L37;
        if (r5 != null) goto L19;
        ConstraintAnchor r6 = null;
    L20:
        if (r6 == null) goto L24;
        if (r6.getOwner() == r2) goto L24;
        r0 = r2;
    L24:
        r2 = r5;
        goto L5
    L19:
        r6 = r5.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
        goto L20
    L37:
        return r2;
    L13:
        r5 = r4.getOwner();
        goto L15
    L10:
        r4 = r3.getTarget();
    L26:
        return r0;
    L36:
        return null;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public int getHorizontalMargin() {
        ConstraintAnchor r0 = this.mLeft;
        int r1 = 0;
        if (r0 == null) goto L5;
        r1 = 0 + r0.mMargin;
    L5:
        ConstraintAnchor r2 = this.mRight;
        if (r2 != null) goto L8;
        return r1;
    L8:
        return r1 + r2.mMargin;
    }

    public int getLastHorizontalMeasureSpec() {
        return this.mLastHorizontalMeasureSpec;
    }

    public int getLastVerticalMeasureSpec() {
        return this.mLastVerticalMeasureSpec;
    }

    public int getLeft() {
        return getX();
    }

    public int getLength(int r2) {
        if (r2 != 0) goto L6;
        return getWidth();
    L6:
        if (r2 == 1) goto L8;
        return 0;
    L8:
        return getHeight();
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public ConstraintWidget getNextChainMember(int r2) {
        if (r2 != 0) goto L10;
        ConstraintAnchor r1 = this.mRight;
        ConstraintAnchor r3 = r1.mTarget;
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.mTarget == r1) goto L8;
        return null;
    L8:
        return r3.mOwner;
    L10:
        if (r2 != 1) goto L20;
        ConstraintAnchor r4 = this.mBottom;
        ConstraintAnchor r5 = r4.mTarget;
        if (r5 != null) goto L14;
        return null;
    L14:
        if (r5.mTarget == r4) goto L16;
        return null;
    L16:
        return r5.mOwner;
    L20:
        return null;
    }

    public int getOptimizerWrapHeight() {
        int r0 = this.mHeight;
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) goto L5;
        return r0;
    L5:
        if (this.mMatchConstraintDefaultHeight != 1) goto L7;
        int r1 = Math.max(this.mMatchConstraintMinHeight, r0);
    L11:
        int r4 = this.mMatchConstraintMaxHeight;
        if (r4 <= 0) goto L17;
        if (r4 < r1) goto L15;
        return r1;
    L15:
        return r4;
    L17:
        return r1;
    L7:
        r1 = this.mMatchConstraintMinHeight;
        if (r1 <= 0) goto L10;
        this.mHeight = r1;
        goto L11
    L10:
        r1 = 0;
        goto L11
    }

    public int getOptimizerWrapWidth() {
        int r0 = this.mWidth;
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT) goto L5;
        return r0;
    L5:
        if (this.mMatchConstraintDefaultWidth != 1) goto L7;
        int r1 = Math.max(this.mMatchConstraintMinWidth, r0);
    L11:
        int r4 = this.mMatchConstraintMaxWidth;
        if (r4 <= 0) goto L17;
        if (r4 < r1) goto L15;
        return r1;
    L15:
        return r4;
    L17:
        return r1;
    L7:
        r1 = this.mMatchConstraintMinWidth;
        if (r1 <= 0) goto L10;
        this.mWidth = r1;
        goto L11
    L10:
        r1 = 0;
        goto L11
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public ConstraintWidget getPreviousChainMember(int r2) {
        if (r2 != 0) goto L10;
        ConstraintAnchor r1 = this.mLeft;
        ConstraintAnchor r3 = r1.mTarget;
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.mTarget == r1) goto L8;
        return null;
    L8:
        return r3.mOwner;
    L10:
        if (r2 != 1) goto L20;
        ConstraintAnchor r4 = this.mTop;
        ConstraintAnchor r5 = r4.mTarget;
        if (r5 != null) goto L14;
        return null;
    L14:
        if (r5.mTarget == r4) goto L16;
        return null;
    L16:
        return r5.mOwner;
    L20:
        return null;
    }

    int getRelativePositioning(int r2) {
        if (r2 != 0) goto L6;
        return this.mRelX;
    L6:
        if (r2 == 1) goto L8;
        return 0;
    L8:
        return this.mRelY;
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    protected int getRootX() {
        return this.mX + this.mOffsetX;
    }

    protected int getRootY() {
        return this.mY + this.mOffsetY;
    }

    public WidgetRun getRun(int r2) {
        if (r2 != 0) goto L6;
        return this.horizontalRun;
    L6:
        if (r2 == 1) goto L8;
        return null;
    L8:
        return this.verticalRun;
    }

    public void getSceneString(StringBuilder r13) {
        r13.append("  " + this.stringId + ":{\n");
        StringBuilder r0 = new StringBuilder();
        r0.append("    actualWidth:");
        r0.append(this.mWidth);
        r13.append(r0.toString());
        r13.append("\n");
        r13.append("    actualHeight:" + this.mHeight);
        r13.append("\n");
        r13.append("    actualLeft:" + this.mX);
        r13.append("\n");
        r13.append("    actualTop:" + this.mY);
        r13.append("\n");
        getSceneString(r13, "left", this.mLeft);
        getSceneString(r13, "top", this.mTop);
        getSceneString(r13, "right", this.mRight);
        getSceneString(r13, "bottom", this.mBottom);
        getSceneString(r13, "baseline", this.mBaseline);
        getSceneString(r13, "centerX", this.mCenterX);
        getSceneString(r13, "centerY", this.mCenterY);
        getSceneString(r13, "    width", this.mWidth, this.mMinWidth, this.mMaxDimension[0], this.mWidthOverride, this.mMatchConstraintMinWidth, this.mMatchConstraintDefaultWidth, this.mMatchConstraintPercentWidth, this.mWeight[0]);
        getSceneString(r13, "    height", this.mHeight, this.mMinHeight, this.mMaxDimension[1], this.mHeightOverride, this.mMatchConstraintMinHeight, this.mMatchConstraintDefaultHeight, this.mMatchConstraintPercentHeight, this.mWeight[1]);
        serializeDimensionRatio(r13, "    dimensionRatio", this.mDimensionRatio, this.mDimensionRatioSide);
        serializeAttribute(r13, "    horizontalBias", this.mHorizontalBiasPercent, DEFAULT_BIAS);
        serializeAttribute(r13, "    verticalBias", this.mVerticalBiasPercent, DEFAULT_BIAS);
        serializeAttribute(r13, "    horizontalChainStyle", this.mHorizontalChainStyle, 0);
        serializeAttribute(r13, "    verticalChainStyle", this.mVerticalChainStyle, 0);
        r13.append("  }");
    }

    public int getTop() {
        return getY();
    }

    public String getType() {
        return this.mType;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        if (isInVerticalChain() == false) goto L36;
        ConstraintWidget r2 = this;
        ConstraintWidget r0 = null;
    L5:
        if (r0 != null) goto L26;
        if (r2 == null) goto L26;
        ConstraintAnchor r3 = r2.getAnchor(ConstraintAnchor.Type.TOP);
        if (r3 != null) goto L10;
        ConstraintAnchor r4 = null;
    L11:
        if (r4 != null) goto L13;
        ConstraintWidget r5 = null;
    L15:
        if (r5 == getParent()) goto L37;
        if (r5 != null) goto L19;
        ConstraintAnchor r6 = null;
    L20:
        if (r6 == null) goto L24;
        if (r6.getOwner() == r2) goto L24;
        r0 = r2;
    L24:
        r2 = r5;
        goto L5
    L19:
        r6 = r5.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
        goto L20
    L37:
        return r2;
    L13:
        r5 = r4.getOwner();
        goto L15
    L10:
        r4 = r3.getTarget();
    L26:
        return r0;
    L36:
        return null;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public int getVerticalMargin() {
        int r1 = 0;
        if (this.mLeft == null) goto L6;
        r1 = 0 + this.mTop.mMargin;
    L6:
        if (this.mRight != null) goto L8;
        return r1;
    L8:
        return r1 + this.mBottom.mMargin;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public int getWidth() {
        if (this.mVisibility != 8) goto L7;
        return 0;
    L7:
        return this.mWidth;
    }

    public int getWrapBehaviorInParent() {
        return this.mWrapBehaviorInParent;
    }

    public int getX() {
        ConstraintWidget r0 = this.mParent;
        if (r0 == null) goto L9;
        if ((r0 instanceof ConstraintWidgetContainer) == false) goto L9;
        return ((ConstraintWidgetContainer) r0).mPaddingLeft + this.mX;
    L9:
        return this.mX;
    }

    public int getY() {
        ConstraintWidget r0 = this.mParent;
        if (r0 == null) goto L9;
        if ((r0 instanceof ConstraintWidgetContainer) == false) goto L9;
        return ((ConstraintWidgetContainer) r0).mPaddingTop + this.mY;
    L9:
        return this.mY;
    }

    public boolean hasBaseline() {
        return this.hasBaseline;
    }

    public boolean hasDanglingDimension(int r5) {
        if (r5 != 0) goto L18;
        if (this.mLeft.mTarget == null) goto L7;
        int r6 = 1;
    L9:
        if (this.mRight.mTarget == null) goto L11;
        int r4 = 1;
    L13:
        if ((r6 + r4) >= 2) goto L16;
        return true;
    L16:
        return false;
    L11:
        r4 = 0;
        goto L13
    L7:
        r6 = 0;
        goto L9
    L18:
        if (this.mTop.mTarget == null) goto L20;
        int r7 = 1;
    L22:
        if (this.mBottom.mTarget == null) goto L24;
        int r3 = 1;
    L25:
        int r8 = r7 + r3;
        if (this.mBaseline.mTarget == null) goto L28;
        int r9 = 1;
    L30:
        if ((r8 + r9) >= 2) goto L33;
        return true;
    L33:
        return false;
    L28:
        r9 = 0;
        goto L30
    L24:
        r3 = 0;
        goto L25
    L20:
        r7 = 0;
        goto L22
    }

    public boolean hasDependencies() {
        int r0 = this.mAnchors.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (this.mAnchors.get(r2).hasDependents() == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public boolean hasDimensionOverride() {
        if (this.mWidthOverride == (-1)) goto L5;
    L8:
        return true;
    L5:
        if (this.mHeightOverride != (-1)) goto L8;
        return false;
    }

    public boolean hasResolvedTargets(int r4, int r5) {
        if (r4 != 0) goto L17;
        ConstraintAnchor r6 = this.mLeft.mTarget;
        if (r6 != null) goto L7;
    L30:
        return false;
    L7:
        if (r6.hasFinalValue() == false) goto L30;
        ConstraintAnchor r7 = this.mRight.mTarget;
        if (r7 == null) goto L30;
        if (r7.hasFinalValue() == false) goto L30;
        if (((this.mRight.mTarget.getFinalValue() - this.mRight.getMargin()) - (this.mLeft.mTarget.getFinalValue() + this.mLeft.getMargin())) < r5) goto L16;
        return true;
    L16:
        return false;
    L17:
        ConstraintAnchor r8 = this.mTop.mTarget;
        if (r8 == null) goto L30;
        if (r8.hasFinalValue() == false) goto L30;
        ConstraintAnchor r9 = this.mBottom.mTarget;
        if (r9 == null) goto L30;
        if (r9.hasFinalValue() == false) goto L30;
        if (((this.mBottom.mTarget.getFinalValue() - this.mBottom.getMargin()) - (this.mTop.mTarget.getFinalValue() + this.mTop.getMargin())) < r5) goto L29;
        return true;
    L29:
        return false;
    }

    public void immediateConnect(ConstraintAnchor.Type r1, ConstraintWidget r2, ConstraintAnchor.Type r3, int r4, int r5) {
        getAnchor(r1).connect(r2.getAnchor(r3), r4, r5, true);
    }

    public boolean isAnimated() {
        return this.mAnimated;
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public boolean isHorizontalSolvingPassDone() {
        return this.horizontalSolvingPass;
    }

    public boolean isInBarrier(int r1) {
        return this.mIsInBarrier[r1];
    }

    public boolean isInHorizontalChain() {
        ConstraintAnchor r0 = this.mLeft;
        ConstraintAnchor r1 = r0.mTarget;
        if (r1 != null) goto L5;
    L6:
        ConstraintAnchor r2 = this.mRight;
        ConstraintAnchor r3 = r2.mTarget;
        if (r3 != null) goto L9;
        return false;
    L9:
        if (r3.mTarget != r2) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (r1.mTarget != r0) goto L6;
        return true;
    }

    public boolean isInPlaceholder() {
        return this.inPlaceholder;
    }

    public boolean isInVerticalChain() {
        ConstraintAnchor r0 = this.mTop;
        ConstraintAnchor r1 = r0.mTarget;
        if (r1 != null) goto L5;
    L6:
        ConstraintAnchor r2 = this.mBottom;
        ConstraintAnchor r3 = r2.mTarget;
        if (r3 != null) goto L9;
        return false;
    L9:
        if (r3.mTarget != r2) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (r1.mTarget != r0) goto L6;
        return true;
    }

    public boolean isInVirtualLayout() {
        return this.mInVirtualLayout;
    }

    public boolean isMeasureRequested() {
        if (this.mMeasureRequested == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mVisibility == 8) goto L7;
        return true;
    }

    public boolean isResolvedHorizontally() {
        if (this.resolvedHorizontal == false) goto L5;
    L10:
        return true;
    L5:
        if (this.mLeft.hasFinalValue() == true) goto L7;
    L9:
        return false;
    L7:
        if (this.mRight.hasFinalValue() == false) goto L9;
        goto L9
    }

    public boolean isResolvedVertically() {
        if (this.resolvedVertical == false) goto L5;
    L10:
        return true;
    L5:
        if (this.mTop.hasFinalValue() == true) goto L7;
    L9:
        return false;
    L7:
        if (this.mBottom.hasFinalValue() == false) goto L9;
        goto L9
    }

    public boolean isRoot() {
        if (this.mParent != null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSpreadHeight() {
        if (this.mMatchConstraintDefaultHeight == 0) goto L5;
    L13:
        return false;
    L5:
        if (this.mDimensionRatio != 0.0f) goto L13;
        if (this.mMatchConstraintMinHeight != 0) goto L13;
        if (this.mMatchConstraintMaxHeight != 0) goto L13;
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) goto L13;
        return true;
    }

    public boolean isSpreadWidth() {
        if (this.mMatchConstraintDefaultWidth == 0) goto L5;
        return false;
    L5:
        if (this.mDimensionRatio == 0.0f) goto L7;
        return false;
    L7:
        if (this.mMatchConstraintMinWidth == 0) goto L9;
        return false;
    L9:
        if (this.mMatchConstraintMaxWidth == 0) goto L11;
        return false;
    L11:
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) goto L18;
        return true;
    L18:
        return false;
    }

    public boolean isVerticalSolvingPassDone() {
        return this.verticalSolvingPass;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public void markHorizontalSolvingPassDone() {
        this.horizontalSolvingPass = true;
    }

    public void markVerticalSolvingPassDone() {
        this.verticalSolvingPass = true;
    }

    public boolean oppositeDimensionDependsOn(int r4) {
        if (r4 != 0) goto L5;
        char r2 = 1;
    L6:
        DimensionBehaviour[] r3 = this.mListDimensionBehaviors;
        DimensionBehaviour r5 = r3[r4];
        DimensionBehaviour r6 = r3[r2];
        DimensionBehaviour r7 = DimensionBehaviour.MATCH_CONSTRAINT;
        if (r5 != r7) goto L11;
        if (r6 != r7) goto L11;
        return true;
    L11:
        return false;
    L5:
        r2 = 0;
        goto L6
    }

    public boolean oppositeDimensionsTied() {
        DimensionBehaviour[] r4 = this.mListDimensionBehaviors;
        DimensionBehaviour r1 = r4[0];
        DimensionBehaviour r2 = DimensionBehaviour.MATCH_CONSTRAINT;
        if (r1 == r2) goto L5;
        return false;
    L5:
        if (r4[1] == r2) goto L7;
        return false;
    L7:
        return true;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        float r3 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = r3;
        this.mVerticalBiasPercent = r3;
        DimensionBehaviour[] r4 = this.mListDimensionBehaviors;
        DimensionBehaviour r5 = DimensionBehaviour.FIXED;
        r4[0] = r5;
        r4[1] = r5;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        float[] r0 = this.mWeight;
        r0[0] = -1.0f;
        r0[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] r1 = this.mMaxDimension;
        r1[0] = Integer.MAX_VALUE;
        r1[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedHasRatio = false;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mGroupsToSolver = false;
        boolean[] r2 = this.isTerminalWidget;
        r2[0] = true;
        r2[1] = true;
        this.mInVirtualLayout = false;
        boolean[] r6 = this.mIsInBarrier;
        r6[0] = false;
        r6[1] = false;
        this.mMeasureRequested = true;
        int[] r7 = this.mResolvedMatchConstraintDefault;
        r7[0] = 0;
        r7[1] = 0;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
    }

    public void resetAnchor(ConstraintAnchor r9) {
        if (getParent() != null) goto L5;
    L9:
        ConstraintAnchor r0 = getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor r1 = getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintAnchor r2 = getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor r3 = getAnchor(ConstraintAnchor.Type.BOTTOM);
        ConstraintAnchor r4 = getAnchor(ConstraintAnchor.Type.CENTER);
        ConstraintAnchor r5 = getAnchor(ConstraintAnchor.Type.CENTER_X);
        ConstraintAnchor r6 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
        if (r9 == r4) goto L12;
        if (r9 == r5) goto L29;
        if (r9 == r6) goto L38;
        if (r9 == r0) goto L55;
        if (r9 == r1) goto L55;
        if (r9 == r2) goto L50;
        if (r9 == r3) goto L50;
    L59:
        r9.reset();
        return;
    L50:
        if (r2.isConnected() == false) goto L59;
        if (r2.getTarget() != r3.getTarget()) goto L59;
    L58:
        r4.reset();
    L55:
        if (r0.isConnected() == false) goto L59;
        if (r0.getTarget() != r1.getTarget()) goto L59;
    L38:
        if (r2.isConnected() == true) goto L40;
    L26:
        this.mVerticalBiasPercent = 0.5f;
        goto L59
    L40:
        if (r3.isConnected() == false) goto L26;
        if (r2.getTarget().getOwner() != r3.getTarget().getOwner()) goto L26;
        r2.reset();
        r3.reset();
        goto L26
    L29:
        if (r0.isConnected() == true) goto L31;
    L35:
        this.mHorizontalBiasPercent = 0.5f;
        goto L59
    L31:
        if (r1.isConnected() == false) goto L35;
        if (r0.getTarget().getOwner() != r1.getTarget().getOwner()) goto L35;
        r0.reset();
        r1.reset();
        goto L35
    L12:
        if (r0.isConnected() == false) goto L19;
        if (r1.isConnected() == false) goto L19;
        if (r0.getTarget() != r1.getTarget()) goto L19;
        r0.reset();
        r1.reset();
    L19:
        if (r2.isConnected() == true) goto L21;
    L25:
        this.mHorizontalBiasPercent = 0.5f;
        goto L26
    L21:
        if (r3.isConnected() == false) goto L25;
        if (r2.getTarget() != r3.getTarget()) goto L25;
        r2.reset();
        r3.reset();
        goto L25
    L5:
        if ((getParent() instanceof ConstraintWidgetContainer) == false) goto L9;
        if (((ConstraintWidgetContainer) getParent()).handlesInternalConstraints() == false) goto L9;
    }

    public void resetAnchors() {
        ConstraintWidget r0 = getParent();
        if (r0 != null) goto L5;
    L9:
        int r1 = 0;
        int r2 = this.mAnchors.size();
    L10:
        if (r1 >= r2) goto L12;
        this.mAnchors.get(r1).reset();
        r1 = r1 + 1;
        goto L10
    L12:
        return;
    L5:
        if ((r0 instanceof ConstraintWidgetContainer) == false) goto L9;
        if (((ConstraintWidgetContainer) getParent()).handlesInternalConstraints() == false) goto L9;
    }

    public void resetFinalResolution() {
        int r0 = 0;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.horizontalSolvingPass = false;
        this.verticalSolvingPass = false;
        int r1 = this.mAnchors.size();
    L3:
        if (r0 >= r1) goto L5;
        this.mAnchors.get(r0).resetFinalResolution();
        r0 = r0 + 1;
        goto L3
    }

    public void resetSolverVariables(Cache r2) {
        this.mLeft.resetSolverVariable(r2);
        this.mTop.resetSolverVariable(r2);
        this.mRight.resetSolverVariable(r2);
        this.mBottom.resetSolverVariable(r2);
        this.mBaseline.resetSolverVariable(r2);
        this.mCenter.resetSolverVariable(r2);
        this.mCenterX.resetSolverVariable(r2);
        this.mCenterY.resetSolverVariable(r2);
    }

    public void resetSolvingPassFlag() {
        this.horizontalSolvingPass = false;
        this.verticalSolvingPass = false;
    }

    public StringBuilder serialize(StringBuilder r12) {
        r12.append("{\n");
        serializeAnchor(r12, "left", this.mLeft);
        serializeAnchor(r12, "top", this.mTop);
        serializeAnchor(r12, "right", this.mRight);
        serializeAnchor(r12, "bottom", this.mBottom);
        serializeAnchor(r12, "baseline", this.mBaseline);
        serializeAnchor(r12, "centerX", this.mCenterX);
        serializeAnchor(r12, "centerY", this.mCenterY);
        serializeCircle(r12, this.mCenter, this.mCircleConstraintAngle);
        serializeSize(r12, "width", this.mWidth, this.mMinWidth, this.mMaxDimension[0], this.mWidthOverride, this.mMatchConstraintMinWidth, this.mMatchConstraintDefaultWidth, this.mMatchConstraintPercentWidth, this.mWeight[0]);
        serializeSize(r12, "height", this.mHeight, this.mMinHeight, this.mMaxDimension[1], this.mHeightOverride, this.mMatchConstraintMinHeight, this.mMatchConstraintDefaultHeight, this.mMatchConstraintPercentHeight, this.mWeight[1]);
        serializeDimensionRatio(r12, "dimensionRatio", this.mDimensionRatio, this.mDimensionRatioSide);
        serializeAttribute(r12, "horizontalBias", this.mHorizontalBiasPercent, DEFAULT_BIAS);
        serializeAttribute(r12, "verticalBias", this.mVerticalBiasPercent, DEFAULT_BIAS);
        r12.append("}\n");
        return r12;
    }

    public void setAnimated(boolean r1) {
        this.mAnimated = r1;
    }

    public void setBaselineDistance(int r1) {
        this.mBaselineDistance = r1;
        if (r1 <= 0) goto L5;
        boolean r2 = true;
    L6:
        this.hasBaseline = r2;
        return;
    L5:
        r2 = false;
        goto L6
    }

    public void setCompanionWidget(Object r1) {
        this.mCompanionWidget = r1;
    }

    public void setContainerItemSkip(int r1) {
        if (r1 >= 0) goto L5;
        r1 = 0;
    L5:
        this.mContainerItemSkip = r1;
    }

    public void setDebugName(String r1) {
        this.mDebugName = r1;
    }

    public void setDebugSolverName(LinearSystem r7, String r8) {
        this.mDebugName = r8;
        SolverVariable r0 = r7.createObjectVariable(this.mLeft);
        SolverVariable r1 = r7.createObjectVariable(this.mTop);
        SolverVariable r2 = r7.createObjectVariable(this.mRight);
        SolverVariable r3 = r7.createObjectVariable(this.mBottom);
        r0.setName(r8 + ".left");
        r1.setName(r8 + ".top");
        r2.setName(r8 + ".right");
        r3.setName(r8 + ".bottom");
        r7.createObjectVariable(this.mBaseline).setName(r8 + ".baseline");
    }

    public void setDimension(int r2, int r3) {
        this.mWidth = r2;
        int r0 = this.mMinWidth;
        if (r2 >= r0) goto L5;
        this.mWidth = r0;
    L5:
        this.mHeight = r3;
        int r4 = this.mMinHeight;
        if (r3 >= r4) goto L9;
        this.mHeight = r4;
        return;
    }

    public void setDimensionRatio(float r1, int r2) {
        this.mDimensionRatio = r1;
        this.mDimensionRatioSide = r2;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0084 -> B:39:0x0085). Please report as a decompilation issue!!! */
    public void setDimensionRatio(String r9) {
        int r0 = 0;
        if (r9 != null) goto L5;
    L43:
        this.mDimensionRatio = 0.0f;
        return;
    L5:
        if (r9.length() == 0) goto L43;
        int r1 = -1;
        int r2 = r9.length();
        int r3 = r9.indexOf(44);
        int r4 = 0;
        if (r3 > 0) goto L10;
    L18:
        int r5 = r9.indexOf(58);
        if (r5 >= 0) goto L21;
    L34:
        String r10 = r9.substring(r4);
        if (r10.length() <= 0) goto L38;
        float r11 = Float.parseFloat(r10);     // Catch: NumberFormatException -> L45
    L39:
        r0 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1));
        if (r0 <= 0) goto L48;
        this.mDimensionRatio = r11;
        this.mDimensionRatioSide = r1;
        return;
    L48:
        return;
    L21:
        if (r5 >= (r2 - 1)) goto L34;
        String r6 = r9.substring(r4, r5);
        String r12 = r9.substring(r5 + 1);
        if (r6.length() <= 0) goto L38;
        if (r12.length() <= 0) goto L38;
        float r7 = Float.parseFloat(r6);     // Catch: NumberFormatException -> L45
        float r13 = Float.parseFloat(r12);     // Catch: NumberFormatException -> L45
        if (r7 <= 0.0f) goto L38;
        if (r13 <= 0.0f) goto L38;
        if (r1 != 1) goto L32;
        r11 = Math.abs(r13 / r7);     // Catch: NumberFormatException -> L45
        goto L39
    L32:
        r11 = Math.abs(r7 / r13);     // Catch: NumberFormatException -> L45
    L38:
        r11 = r0;
        goto L39
    L10:
        if (r3 >= (r2 - 1)) goto L18;
        String r8 = r9.substring(0, r3);
        if (r8.equalsIgnoreCase("W") == false) goto L15;
        r1 = 0;
    L17:
        r4 = r3 + 1;
        goto L18
    L15:
        if (r8.equalsIgnoreCase("H") == false) goto L17;
        r1 = 1;
        goto L17
    }

    public void setFinalBaseline(int r4) {
        if (this.hasBaseline == true) goto L5;
        return;
    L5:
        int r0 = r4 - this.mBaselineDistance;
        int r1 = this.mHeight + r0;
        this.mY = r0;
        this.mTop.setFinalValue(r0);
        this.mBottom.setFinalValue(r1);
        this.mBaseline.setFinalValue(r4);
        this.resolvedVertical = true;
    }

    public void setFinalFrame(int r1, int r2, int r3, int r4, int r5, int r6) {
        setFrame(r1, r2, r3, r4);
        setBaselineDistance(r5);
        if (r6 != 0) goto L6;
        this.resolvedHorizontal = true;
    L5:
        this.resolvedVertical = false;
        return;
    L6:
        if (r6 != 1) goto L10;
        this.resolvedHorizontal = false;
    L8:
        this.resolvedVertical = true;
        return;
    L10:
        if (r6 != 2) goto L12;
        this.resolvedHorizontal = true;
        goto L8
    L12:
        this.resolvedHorizontal = false;
        goto L5
    }

    public void setFinalHorizontal(int r2, int r3) {
        if (this.resolvedHorizontal == false) goto L5;
        return;
    L5:
        this.mLeft.setFinalValue(r2);
        this.mRight.setFinalValue(r3);
        this.mX = r2;
        this.mWidth = r3 - r2;
        this.resolvedHorizontal = true;
    }

    public void setFinalLeft(int r2) {
        this.mLeft.setFinalValue(r2);
        this.mX = r2;
    }

    public void setFinalTop(int r2) {
        this.mTop.setFinalValue(r2);
        this.mY = r2;
    }

    public void setFinalVertical(int r2, int r3) {
        if (this.resolvedVertical == false) goto L5;
        return;
    L5:
        this.mTop.setFinalValue(r2);
        this.mBottom.setFinalValue(r3);
        this.mY = r2;
        this.mHeight = r3 - r2;
        if (this.hasBaseline == false) goto L8;
        this.mBaseline.setFinalValue(r2 + this.mBaselineDistance);
    L8:
        this.resolvedVertical = true;
    }

    public void setFrame(int r2, int r3, int r4) {
        if (r4 != 0) goto L5;
        setHorizontalDimension(r2, r3);
        return;
    L5:
        if (r4 != 1) goto L9;
        setVerticalDimension(r2, r3);
        return;
    }

    public void setFrame(int r4, int r5, int r6, int r7) {
        int r8 = r6 - r4;
        int r9 = r7 - r5;
        this.mX = r4;
        this.mY = r5;
        if (this.mVisibility != 8) goto L6;
        this.mWidth = 0;
        this.mHeight = 0;
        return;
    L6:
        DimensionBehaviour[] r10 = this.mListDimensionBehaviors;
        DimensionBehaviour r0 = r10[0];
        DimensionBehaviour r1 = DimensionBehaviour.FIXED;
        if (r0 != r1) goto L12;
        int r2 = this.mWidth;
        if (r8 >= r2) goto L12;
        r8 = r2;
    L12:
        if (r10[1] != r1) goto L16;
        int r3 = this.mHeight;
        if (r9 >= r3) goto L16;
        r9 = r3;
    L16:
        this.mWidth = r8;
        this.mHeight = r9;
        int r11 = this.mMinHeight;
        if (r9 >= r11) goto L19;
        this.mHeight = r11;
    L19:
        int r12 = this.mMinWidth;
        if (r8 >= r12) goto L22;
        this.mWidth = r12;
    L22:
        int r13 = this.mMatchConstraintMaxWidth;
        if (r13 > 0) goto L25;
    L27:
        int r14 = this.mMatchConstraintMaxHeight;
        if (r14 > 0) goto L30;
    L32:
        int r15 = this.mWidth;
        if (r8 == r15) goto L35;
        this.mWidthOverride = r15;
    L35:
        int r16 = this.mHeight;
        if (r9 == r16) goto L39;
        this.mHeightOverride = r16;
        return;
    L39:
        return;
    L30:
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) goto L32;
        this.mHeight = Math.min(this.mHeight, r14);
        goto L32
    L25:
        if (r10[0] != DimensionBehaviour.MATCH_CONSTRAINT) goto L27;
        this.mWidth = Math.min(this.mWidth, r13);
        goto L27
    }

    public void setGoneMargin(ConstraintAnchor.Type r2, int r3) {
        int r4 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[r2.ordinal()];
        if (r4 != 1) goto L5;
        ConstraintAnchor r1 = this.mLeft;
    L18:
        r1.mGoneMargin = r3;
        return;
    L5:
        if (r4 != 2) goto L7;
        r1 = this.mTop;
        goto L18
    L7:
        if (r4 != 3) goto L9;
        r1 = this.mRight;
        goto L18
    L9:
        if (r4 != 4) goto L11;
        r1 = this.mBottom;
        goto L18
    L11:
        if (r4 != 5) goto L20;
        r1 = this.mBaseline;
        goto L18
    }

    public void setHasBaseline(boolean r1) {
        this.hasBaseline = r1;
    }

    public void setHeight(int r2) {
        this.mHeight = r2;
        int r0 = this.mMinHeight;
        if (r2 >= r0) goto L6;
        this.mHeight = r0;
        return;
    }

    public void setHeightWrapContent(boolean r1) {
        this.mIsHeightWrapContent = r1;
    }

    public void setHorizontalBiasPercent(float r1) {
        this.mHorizontalBiasPercent = r1;
    }

    public void setHorizontalChainStyle(int r1) {
        this.mHorizontalChainStyle = r1;
    }

    public void setHorizontalDimension(int r1, int r2) {
        this.mX = r1;
        int r3 = r2 - r1;
        this.mWidth = r3;
        int r4 = this.mMinWidth;
        if (r3 >= r4) goto L6;
        this.mWidth = r4;
        return;
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour r2) {
        this.mListDimensionBehaviors[0] = r2;
    }

    public void setHorizontalMatchStyle(int r1, int r2, int r3, float r4) {
        this.mMatchConstraintDefaultWidth = r1;
        this.mMatchConstraintMinWidth = r2;
        if (r3 != Integer.MAX_VALUE) goto L5;
        r3 = 0;
    L5:
        this.mMatchConstraintMaxWidth = r3;
        this.mMatchConstraintPercentWidth = r4;
        if (r4 > 0.0f) goto L8;
        return;
    L8:
        if (r4 >= 1.0f) goto L13;
        if (r1 != 0) goto L14;
        this.mMatchConstraintDefaultWidth = 2;
        return;
    L14:
        return;
    }

    public void setHorizontalWeight(float r2) {
        this.mWeight[0] = r2;
    }

    protected void setInBarrier(int r1, boolean r2) {
        this.mIsInBarrier[r1] = r2;
    }

    public void setInPlaceholder(boolean r1) {
        this.inPlaceholder = r1;
    }

    public void setInVirtualLayout(boolean r1) {
        this.mInVirtualLayout = r1;
    }

    public void setLastMeasureSpec(int r1, int r2) {
        this.mLastHorizontalMeasureSpec = r1;
        this.mLastVerticalMeasureSpec = r2;
        setMeasureRequested(false);
    }

    public void setLength(int r2, int r3) {
        if (r3 != 0) goto L5;
        setWidth(r2);
        return;
    L5:
        if (r3 != 1) goto L9;
        setHeight(r2);
        return;
    }

    public void setMaxHeight(int r2) {
        this.mMaxDimension[1] = r2;
    }

    public void setMaxWidth(int r2) {
        this.mMaxDimension[0] = r2;
    }

    public void setMeasureRequested(boolean r1) {
        this.mMeasureRequested = r1;
    }

    public void setMinHeight(int r1) {
        if (r1 >= 0) goto L4;
        r1 = 0;
    L4:
        this.mMinHeight = r1;
    }

    public void setMinWidth(int r1) {
        if (r1 >= 0) goto L4;
        r1 = 0;
    L4:
        this.mMinWidth = r1;
    }

    public void setOffset(int r1, int r2) {
        this.mOffsetX = r1;
        this.mOffsetY = r2;
    }

    public void setOrigin(int r1, int r2) {
        this.mX = r1;
        this.mY = r2;
    }

    public void setParent(ConstraintWidget r1) {
        this.mParent = r1;
    }

    void setRelativePositioning(int r2, int r3) {
        if (r3 != 0) goto L5;
        this.mRelX = r2;
        return;
    L5:
        if (r3 != 1) goto L9;
        this.mRelY = r2;
        return;
    }

    public void setType(String r1) {
        this.mType = r1;
    }

    public void setVerticalBiasPercent(float r1) {
        this.mVerticalBiasPercent = r1;
    }

    public void setVerticalChainStyle(int r1) {
        this.mVerticalChainStyle = r1;
    }

    public void setVerticalDimension(int r1, int r2) {
        this.mY = r1;
        int r3 = r2 - r1;
        this.mHeight = r3;
        int r4 = this.mMinHeight;
        if (r3 >= r4) goto L6;
        this.mHeight = r4;
        return;
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour r2) {
        this.mListDimensionBehaviors[1] = r2;
    }

    public void setVerticalMatchStyle(int r1, int r2, int r3, float r4) {
        this.mMatchConstraintDefaultHeight = r1;
        this.mMatchConstraintMinHeight = r2;
        if (r3 != Integer.MAX_VALUE) goto L5;
        r3 = 0;
    L5:
        this.mMatchConstraintMaxHeight = r3;
        this.mMatchConstraintPercentHeight = r4;
        if (r4 > 0.0f) goto L8;
        return;
    L8:
        if (r4 >= 1.0f) goto L13;
        if (r1 != 0) goto L14;
        this.mMatchConstraintDefaultHeight = 2;
        return;
    L14:
        return;
    }

    public void setVerticalWeight(float r2) {
        this.mWeight[1] = r2;
    }

    public void setVisibility(int r1) {
        this.mVisibility = r1;
    }

    public void setWidth(int r2) {
        this.mWidth = r2;
        int r0 = this.mMinWidth;
        if (r2 >= r0) goto L6;
        this.mWidth = r0;
        return;
    }

    public void setWidthWrapContent(boolean r1) {
        this.mIsWidthWrapContent = r1;
    }

    public void setWrapBehaviorInParent(int r2) {
        if (r2 >= 0) goto L4;
        return;
    L4:
        if (r2 > 3) goto L8;
        this.mWrapBehaviorInParent = r2;
        return;
    }

    public void setX(int r1) {
        this.mX = r1;
    }

    public void setY(int r1) {
        this.mY = r1;
    }

    public void setupDimensionRatio(boolean r4, boolean r5, boolean r6, boolean r7) {
        if (this.mResolvedDimensionRatioSide != (-1)) goto L13;
        if (r6 == false) goto L7;
        if (r7 == true) goto L7;
        this.mResolvedDimensionRatioSide = 0;
    L7:
        if (r6 == true) goto L13;
        if (r7 == false) goto L13;
        this.mResolvedDimensionRatioSide = 1;
        if (this.mDimensionRatioSide != (-1)) goto L13;
        this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
    L13:
        if (this.mResolvedDimensionRatioSide != 0) goto L20;
        if (this.mTop.isConnected() == true) goto L17;
    L18:
        this.mResolvedDimensionRatioSide = 1;
    L27:
        if (this.mResolvedDimensionRatioSide != (-1)) goto L47;
        if (this.mTop.isConnected() == false) goto L37;
        if (this.mBottom.isConnected() == false) goto L37;
        if (this.mLeft.isConnected() == false) goto L37;
        if (this.mRight.isConnected() == true) goto L47;
    L37:
        if (this.mTop.isConnected() == false) goto L42;
        if (this.mBottom.isConnected() == false) goto L42;
        this.mResolvedDimensionRatioSide = 0;
    L42:
        if (this.mLeft.isConnected() == false) goto L47;
        if (this.mRight.isConnected() == false) goto L47;
        this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
        this.mResolvedDimensionRatioSide = 1;
    L47:
        if (this.mResolvedDimensionRatioSide != (-1)) goto L58;
        int r8 = this.mMatchConstraintMinWidth;
        if (r8 > 0) goto L51;
    L53:
        if (r8 == 0) goto L55;
        return;
    L55:
        if (this.mMatchConstraintMinHeight <= 0) goto L61;
        this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
        this.mResolvedDimensionRatioSide = 1;
        return;
    L61:
        return;
    L51:
        if (this.mMatchConstraintMinHeight != 0) goto L53;
        this.mResolvedDimensionRatioSide = 0;
        return;
    L58:
        return;
    L17:
        if (this.mBottom.isConnected() == false) goto L18;
    L20:
        if (this.mResolvedDimensionRatioSide != 1) goto L27;
        if (this.mLeft.isConnected() == true) goto L24;
    L25:
        this.mResolvedDimensionRatioSide = 0;
        goto L27
    L24:
        if (this.mRight.isConnected() == true) goto L27;
        goto L25
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        String r3 = "";
        if (this.mType == null) goto L5;
        String r1 = "type: " + this.mType + " ";
    L6:
        r0.append(r1);
        if (this.mDebugName == null) goto L9;
        r3 = "id: " + this.mDebugName + " ";
    L9:
        r0.append(r3);
        r0.append("(");
        r0.append(this.mX);
        r0.append(", ");
        r0.append(this.mY);
        r0.append(") - (");
        r0.append(this.mWidth);
        r0.append(" x ");
        r0.append(this.mHeight);
        r0.append(")");
        return r0.toString();
    L5:
        r1 = "";
        goto L6
    }

    public void updateFromRuns(boolean r8, boolean r9) {
        boolean r10 = r8 & this.horizontalRun.isResolved();
        boolean r11 = r9 & this.verticalRun.isResolved();
        HorizontalWidgetRun r0 = this.horizontalRun;
        int r1 = r0.start.value;
        VerticalWidgetRun r2 = this.verticalRun;
        int r3 = r2.start.value;
        int r4 = r0.end.value;
        int r5 = r2.end.value;
        int r6 = r5 - r3;
        if ((r4 - r1) < 0) goto L15;
        if (r6 < 0) goto L15;
        if (r1 == Integer.MIN_VALUE) goto L15;
        if (r1 == Integer.MAX_VALUE) goto L15;
        if (r3 == Integer.MIN_VALUE) goto L15;
        if (r3 == Integer.MAX_VALUE) goto L15;
        if (r4 == Integer.MIN_VALUE) goto L15;
        if (r4 == Integer.MAX_VALUE) goto L15;
        if (r5 == Integer.MIN_VALUE) goto L15;
        if (r5 == Integer.MAX_VALUE) goto L15;
    L16:
        int r7 = r4 - r1;
        int r12 = r5 - r3;
        if (r10 == false) goto L19;
        this.mX = r1;
    L19:
        if (r11 == false) goto L22;
        this.mY = r3;
    L22:
        if (this.mVisibility != 8) goto L25;
        this.mWidth = 0;
        this.mHeight = 0;
        return;
    L25:
        if (r10 == true) goto L27;
    L34:
        if (r11 == true) goto L36;
        return;
    L36:
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.FIXED) goto L40;
        int r13 = this.mHeight;
        if (r12 >= r13) goto L40;
        r12 = r13;
    L40:
        this.mHeight = r12;
        int r14 = this.mMinHeight;
        if (r12 >= r14) goto L45;
        this.mHeight = r14;
        return;
    L45:
        return;
    L27:
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.FIXED) goto L31;
        int r15 = this.mWidth;
        if (r7 >= r15) goto L31;
        r7 = r15;
    L31:
        this.mWidth = r7;
        int r16 = this.mMinWidth;
        if (r7 >= r16) goto L34;
        this.mWidth = r16;
    L15:
        r4 = 0;
        r1 = 0;
        r5 = 0;
        r3 = 0;
        goto L16
    }

    public void updateFromSolver(LinearSystem r7, boolean r8) {
        int r0 = r7.getObjectVariableValue(this.mLeft);
        int r1 = r7.getObjectVariableValue(this.mTop);
        int r2 = r7.getObjectVariableValue(this.mRight);
        int r9 = r7.getObjectVariableValue(this.mBottom);
        if (r8 == false) goto L11;
        HorizontalWidgetRun r3 = this.horizontalRun;
        if (r3 == null) goto L11;
        DependencyNode r4 = r3.start;
        if (r4.resolved == false) goto L11;
        DependencyNode r5 = r3.end;
        if (r5.resolved == false) goto L11;
        r0 = r4.value;
        r2 = r5.value;
    L11:
        if (r8 == false) goto L19;
        VerticalWidgetRun r10 = this.verticalRun;
        if (r10 == null) goto L19;
        DependencyNode r6 = r10.start;
        if (r6.resolved == false) goto L19;
        DependencyNode r11 = r10.end;
        if (r11.resolved == false) goto L19;
        r1 = r6.value;
        r9 = r11.value;
    L19:
        int r12 = r9 - r1;
        if ((r2 - r0) < 0) goto L32;
        if (r12 < 0) goto L32;
        if (r0 == Integer.MIN_VALUE) goto L32;
        if (r0 == Integer.MAX_VALUE) goto L32;
        if (r1 == Integer.MIN_VALUE) goto L32;
        if (r1 == Integer.MAX_VALUE) goto L32;
        if (r2 == Integer.MIN_VALUE) goto L32;
        if (r2 == Integer.MAX_VALUE) goto L32;
        if (r9 == Integer.MIN_VALUE) goto L32;
        if (r9 == Integer.MAX_VALUE) goto L32;
    L33:
        setFrame(r0, r1, r2, r9);
        return;
    L32:
        r9 = 0;
        r0 = 0;
        r1 = 0;
        r2 = 0;
        goto L33
    }
}
