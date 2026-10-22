package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.state.helpers.Facade;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintReference implements Reference {
    private Object key;
    float mAlpha;
    Object mBaselineToBaseline;
    Object mBaselineToBottom;
    Object mBaselineToTop;
    protected Object mBottomToBottom;
    protected Object mBottomToTop;
    private float mCircularAngle;
    Object mCircularConstraint;
    private float mCircularDistance;
    private ConstraintWidget mConstraintWidget;
    private HashMap<String, Integer> mCustomColors;
    private HashMap<String, Float> mCustomFloats;
    protected Object mEndToEnd;
    protected Object mEndToStart;
    Facade mFacade;
    float mHorizontalBias;
    int mHorizontalChainStyle;
    float mHorizontalChainWeight;
    Dimension mHorizontalDimension;
    State.Constraint mLast;
    protected Object mLeftToLeft;
    protected Object mLeftToRight;
    int mMarginBaseline;
    int mMarginBaselineGone;
    protected int mMarginBottom;
    protected int mMarginBottomGone;
    protected int mMarginEnd;
    protected int mMarginEndGone;
    protected int mMarginLeft;
    protected int mMarginLeftGone;
    protected int mMarginRight;
    protected int mMarginRightGone;
    protected int mMarginStart;
    protected int mMarginStartGone;
    protected int mMarginTop;
    protected int mMarginTopGone;
    float mPivotX;
    float mPivotY;
    protected Object mRightToLeft;
    protected Object mRightToRight;
    float mRotationX;
    float mRotationY;
    float mRotationZ;
    float mScaleX;
    float mScaleY;
    protected Object mStartToEnd;
    protected Object mStartToStart;
    final State mState;
    String mTag;
    protected Object mTopToBottom;
    protected Object mTopToTop;
    float mTranslationX;
    float mTranslationY;
    float mTranslationZ;
    float mVerticalBias;
    int mVerticalChainStyle;
    float mVerticalChainWeight;
    Dimension mVerticalDimension;
    private Object mView;
    int mVisibility;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.state.ConstraintReference$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$state$State$Constraint = null;

        static {
            int[] r0 = new int[State.Constraint.values().length];
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint = r0;
            r0[State.Constraint.LEFT_TO_LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L62:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.LEFT_TO_RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L46:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.RIGHT_TO_LEFT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L58:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.RIGHT_TO_RIGHT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L64:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.START_TO_START.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L48:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.START_TO_END.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
        L52:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.END_TO_START.ordinal()] = 7;     // Catch: NoSuchFieldError -> L28
        L74:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.END_TO_END.ordinal()] = 8;     // Catch: NoSuchFieldError -> L29
        L42:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.TOP_TO_TOP.ordinal()] = 9;     // Catch: NoSuchFieldError -> L30
        L68:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.TOP_TO_BOTTOM.ordinal()] = 10;     // Catch: NoSuchFieldError -> L31
        L70:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.BOTTOM_TO_TOP.ordinal()] = 11;     // Catch: NoSuchFieldError -> L32
        L54:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.BOTTOM_TO_BOTTOM.ordinal()] = 12;     // Catch: NoSuchFieldError -> L33
        L60:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.BASELINE_TO_BOTTOM.ordinal()] = 13;     // Catch: NoSuchFieldError -> L34
        L44:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.BASELINE_TO_TOP.ordinal()] = 14;     // Catch: NoSuchFieldError -> L35
        L50:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.BASELINE_TO_BASELINE.ordinal()] = 15;     // Catch: NoSuchFieldError -> L36
        L72:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.CIRCULAR_CONSTRAINT.ordinal()] = 16;     // Catch: NoSuchFieldError -> L37
        L40:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.CENTER_HORIZONTALLY.ordinal()] = 17;     // Catch: NoSuchFieldError -> L38
        L66:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.CENTER_VERTICALLY.ordinal()] = 18;     // Catch: NoSuchFieldError -> L39
            return;
        }
    }

    public interface ConstraintReferenceFactory {
        ConstraintReference create(State r1);
    }

    static class IncorrectConstraintException extends Exception {
        private final ArrayList<String> mErrors;

        public IncorrectConstraintException(ArrayList<String> r1) {
            this.mErrors = r1;
        }

        public ArrayList<String> getErrors() {
            return this.mErrors;
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "IncorrectConstraintException: " + this.mErrors.toString();
        }
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public void setKey(Object r1) {
        this.key = r1;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public Object getKey() {
        return this.key;
    }

    public void setTag(String r1) {
        this.mTag = r1;
    }

    public String getTag() {
        return this.mTag;
    }

    public void setView(Object r1) {
        this.mView = r1;
        ConstraintWidget r0 = this.mConstraintWidget;
        if (r0 == null) goto L6;
        r0.setCompanionWidget(r1);
        return;
    }

    public Object getView() {
        return this.mView;
    }

    public void setFacade(Facade r1) {
        this.mFacade = r1;
        if (r1 == null) goto L6;
        setConstraintWidget(r1.getConstraintWidget());
        return;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public Facade getFacade() {
        return this.mFacade;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public void setConstraintWidget(ConstraintWidget r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.mConstraintWidget = r1;
        r1.setCompanionWidget(this.mView);
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public ConstraintWidget getConstraintWidget() {
        if (this.mConstraintWidget != null) goto L6;
        ConstraintWidget r0 = createConstraintWidget();
        this.mConstraintWidget = r0;
        r0.setCompanionWidget(this.mView);
    L6:
        return this.mConstraintWidget;
    }

    public ConstraintWidget createConstraintWidget() {
        return new ConstraintWidget(getWidth().getValue(), getHeight().getValue());
    }

    public void validate() throws IncorrectConstraintException {
        ArrayList r0 = new ArrayList();
        if (this.mLeftToLeft == null) goto L8;
        if (this.mLeftToRight == null) goto L8;
        r0.add("LeftToLeft and LeftToRight both defined");
    L8:
        if (this.mRightToLeft == null) goto L13;
        if (this.mRightToRight == null) goto L13;
        r0.add("RightToLeft and RightToRight both defined");
    L13:
        if (this.mStartToStart == null) goto L18;
        if (this.mStartToEnd == null) goto L18;
        r0.add("StartToStart and StartToEnd both defined");
    L18:
        if (this.mEndToStart == null) goto L23;
        if (this.mEndToEnd == null) goto L23;
        r0.add("EndToStart and EndToEnd both defined");
    L23:
        if (this.mLeftToLeft != null) goto L31;
        if (this.mLeftToRight != null) goto L31;
        if (this.mRightToLeft != null) goto L31;
        if (this.mRightToRight != null) goto L31;
    L40:
        if (r0.size() > 0) goto L43;
        return;
    L43:
        throw new IncorrectConstraintException(r0);
    L31:
        if (this.mStartToStart == null) goto L33;
    L38:
        r0.add("Both left/right and start/end constraints defined");
        goto L40
    L33:
        if (this.mStartToEnd != null) goto L38;
        if (this.mEndToStart != null) goto L38;
        if (this.mEndToEnd == null) goto L40;
        goto L38
    }

    private Object get(Object r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if ((r2 instanceof ConstraintReference) == false) goto L8;
        return r2;
    L8:
        return this.mState.reference(r2);
    }

    public ConstraintReference(State r4) {
        this.mTag = null;
        this.mFacade = null;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainWeight = -1.0f;
        this.mVerticalChainWeight = -1.0f;
        this.mHorizontalBias = 0.5f;
        this.mVerticalBias = 0.5f;
        this.mMarginLeft = 0;
        this.mMarginRight = 0;
        this.mMarginStart = 0;
        this.mMarginEnd = 0;
        this.mMarginTop = 0;
        this.mMarginBottom = 0;
        this.mMarginLeftGone = 0;
        this.mMarginRightGone = 0;
        this.mMarginStartGone = 0;
        this.mMarginEndGone = 0;
        this.mMarginTopGone = 0;
        this.mMarginBottomGone = 0;
        this.mMarginBaseline = 0;
        this.mMarginBaselineGone = 0;
        this.mPivotX = Float.NaN;
        this.mPivotY = Float.NaN;
        this.mRotationX = Float.NaN;
        this.mRotationY = Float.NaN;
        this.mRotationZ = Float.NaN;
        this.mTranslationX = Float.NaN;
        this.mTranslationY = Float.NaN;
        this.mTranslationZ = Float.NaN;
        this.mAlpha = Float.NaN;
        this.mScaleX = Float.NaN;
        this.mScaleY = Float.NaN;
        this.mVisibility = 0;
        this.mLeftToLeft = null;
        this.mLeftToRight = null;
        this.mRightToLeft = null;
        this.mRightToRight = null;
        this.mStartToStart = null;
        this.mStartToEnd = null;
        this.mEndToStart = null;
        this.mEndToEnd = null;
        this.mTopToTop = null;
        this.mTopToBottom = null;
        this.mBottomToTop = null;
        this.mBottomToBottom = null;
        this.mBaselineToBaseline = null;
        this.mBaselineToTop = null;
        this.mBaselineToBottom = null;
        this.mCircularConstraint = null;
        this.mLast = null;
        this.mHorizontalDimension = Dimension.Fixed(Dimension.WRAP_DIMENSION);
        this.mVerticalDimension = Dimension.Fixed(Dimension.WRAP_DIMENSION);
        this.mCustomColors = new HashMap();
        this.mCustomFloats = new HashMap();
        this.mState = r4;
    }

    public void setHorizontalChainStyle(int r1) {
        this.mHorizontalChainStyle = r1;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public void setVerticalChainStyle(int r1) {
        this.mVerticalChainStyle = r1;
    }

    public int getVerticalChainStyle(int r1) {
        return this.mVerticalChainStyle;
    }

    public float getHorizontalChainWeight() {
        return this.mHorizontalChainWeight;
    }

    public void setHorizontalChainWeight(float r1) {
        this.mHorizontalChainWeight = r1;
    }

    public float getVerticalChainWeight() {
        return this.mVerticalChainWeight;
    }

    public void setVerticalChainWeight(float r1) {
        this.mVerticalChainWeight = r1;
    }

    public ConstraintReference clearVertical() {
        top().clear();
        baseline().clear();
        bottom().clear();
        return this;
    }

    public ConstraintReference clearHorizontal() {
        start().clear();
        end().clear();
        left().clear();
        right().clear();
        return this;
    }

    public float getTranslationX() {
        return this.mTranslationX;
    }

    public float getTranslationY() {
        return this.mTranslationY;
    }

    public float getTranslationZ() {
        return this.mTranslationZ;
    }

    public float getScaleX() {
        return this.mScaleX;
    }

    public float getScaleY() {
        return this.mScaleY;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public float getPivotX() {
        return this.mPivotX;
    }

    public float getPivotY() {
        return this.mPivotY;
    }

    public float getRotationX() {
        return this.mRotationX;
    }

    public float getRotationY() {
        return this.mRotationY;
    }

    public float getRotationZ() {
        return this.mRotationZ;
    }

    public ConstraintReference pivotX(float r1) {
        this.mPivotX = r1;
        return this;
    }

    public ConstraintReference pivotY(float r1) {
        this.mPivotY = r1;
        return this;
    }

    public ConstraintReference rotationX(float r1) {
        this.mRotationX = r1;
        return this;
    }

    public ConstraintReference rotationY(float r1) {
        this.mRotationY = r1;
        return this;
    }

    public ConstraintReference rotationZ(float r1) {
        this.mRotationZ = r1;
        return this;
    }

    public ConstraintReference translationX(float r1) {
        this.mTranslationX = r1;
        return this;
    }

    public ConstraintReference translationY(float r1) {
        this.mTranslationY = r1;
        return this;
    }

    public ConstraintReference translationZ(float r1) {
        this.mTranslationZ = r1;
        return this;
    }

    public ConstraintReference scaleX(float r1) {
        this.mScaleX = r1;
        return this;
    }

    public ConstraintReference scaleY(float r1) {
        this.mScaleY = r1;
        return this;
    }

    public ConstraintReference alpha(float r1) {
        this.mAlpha = r1;
        return this;
    }

    public ConstraintReference visibility(int r1) {
        this.mVisibility = r1;
        return this;
    }

    public ConstraintReference left() {
        if (this.mLeftToLeft == null) goto L5;
        this.mLast = State.Constraint.LEFT_TO_LEFT;
    L6:
        return this;
    L5:
        this.mLast = State.Constraint.LEFT_TO_RIGHT;
        goto L6
    }

    public ConstraintReference right() {
        if (this.mRightToLeft == null) goto L5;
        this.mLast = State.Constraint.RIGHT_TO_LEFT;
    L6:
        return this;
    L5:
        this.mLast = State.Constraint.RIGHT_TO_RIGHT;
        goto L6
    }

    public ConstraintReference start() {
        if (this.mStartToStart == null) goto L5;
        this.mLast = State.Constraint.START_TO_START;
    L6:
        return this;
    L5:
        this.mLast = State.Constraint.START_TO_END;
        goto L6
    }

    public ConstraintReference end() {
        if (this.mEndToStart == null) goto L5;
        this.mLast = State.Constraint.END_TO_START;
    L6:
        return this;
    L5:
        this.mLast = State.Constraint.END_TO_END;
        goto L6
    }

    public ConstraintReference top() {
        if (this.mTopToTop == null) goto L5;
        this.mLast = State.Constraint.TOP_TO_TOP;
    L6:
        return this;
    L5:
        this.mLast = State.Constraint.TOP_TO_BOTTOM;
        goto L6
    }

    public ConstraintReference bottom() {
        if (this.mBottomToTop == null) goto L5;
        this.mLast = State.Constraint.BOTTOM_TO_TOP;
    L6:
        return this;
    L5:
        this.mLast = State.Constraint.BOTTOM_TO_BOTTOM;
        goto L6
    }

    public ConstraintReference baseline() {
        this.mLast = State.Constraint.BASELINE_TO_BASELINE;
        return this;
    }

    public void addCustomColor(String r1, int r2) {
        this.mCustomColors.put(r1, Integer.valueOf(r2));
    }

    public void addCustomFloat(String r2, float r3) {
        if (this.mCustomFloats != null) goto L5;
        this.mCustomFloats = new HashMap();
    L5:
        this.mCustomFloats.put(r2, Float.valueOf(r3));
    }

    private void dereference() {
        this.mLeftToLeft = get(this.mLeftToLeft);
        this.mLeftToRight = get(this.mLeftToRight);
        this.mRightToLeft = get(this.mRightToLeft);
        this.mRightToRight = get(this.mRightToRight);
        this.mStartToStart = get(this.mStartToStart);
        this.mStartToEnd = get(this.mStartToEnd);
        this.mEndToStart = get(this.mEndToStart);
        this.mEndToEnd = get(this.mEndToEnd);
        this.mTopToTop = get(this.mTopToTop);
        this.mTopToBottom = get(this.mTopToBottom);
        this.mBottomToTop = get(this.mBottomToTop);
        this.mBottomToBottom = get(this.mBottomToBottom);
        this.mBaselineToBaseline = get(this.mBaselineToBaseline);
        this.mBaselineToTop = get(this.mBaselineToTop);
        this.mBaselineToBottom = get(this.mBaselineToBottom);
    }

    public ConstraintReference leftToLeft(Object r2) {
        this.mLast = State.Constraint.LEFT_TO_LEFT;
        this.mLeftToLeft = r2;
        return this;
    }

    public ConstraintReference leftToRight(Object r2) {
        this.mLast = State.Constraint.LEFT_TO_RIGHT;
        this.mLeftToRight = r2;
        return this;
    }

    public ConstraintReference rightToLeft(Object r2) {
        this.mLast = State.Constraint.RIGHT_TO_LEFT;
        this.mRightToLeft = r2;
        return this;
    }

    public ConstraintReference rightToRight(Object r2) {
        this.mLast = State.Constraint.RIGHT_TO_RIGHT;
        this.mRightToRight = r2;
        return this;
    }

    public ConstraintReference startToStart(Object r2) {
        this.mLast = State.Constraint.START_TO_START;
        this.mStartToStart = r2;
        return this;
    }

    public ConstraintReference startToEnd(Object r2) {
        this.mLast = State.Constraint.START_TO_END;
        this.mStartToEnd = r2;
        return this;
    }

    public ConstraintReference endToStart(Object r2) {
        this.mLast = State.Constraint.END_TO_START;
        this.mEndToStart = r2;
        return this;
    }

    public ConstraintReference endToEnd(Object r2) {
        this.mLast = State.Constraint.END_TO_END;
        this.mEndToEnd = r2;
        return this;
    }

    public ConstraintReference topToTop(Object r2) {
        this.mLast = State.Constraint.TOP_TO_TOP;
        this.mTopToTop = r2;
        return this;
    }

    public ConstraintReference topToBottom(Object r2) {
        this.mLast = State.Constraint.TOP_TO_BOTTOM;
        this.mTopToBottom = r2;
        return this;
    }

    public ConstraintReference bottomToTop(Object r2) {
        this.mLast = State.Constraint.BOTTOM_TO_TOP;
        this.mBottomToTop = r2;
        return this;
    }

    public ConstraintReference bottomToBottom(Object r2) {
        this.mLast = State.Constraint.BOTTOM_TO_BOTTOM;
        this.mBottomToBottom = r2;
        return this;
    }

    public ConstraintReference baselineToBaseline(Object r2) {
        this.mLast = State.Constraint.BASELINE_TO_BASELINE;
        this.mBaselineToBaseline = r2;
        return this;
    }

    public ConstraintReference baselineToTop(Object r2) {
        this.mLast = State.Constraint.BASELINE_TO_TOP;
        this.mBaselineToTop = r2;
        return this;
    }

    public ConstraintReference baselineToBottom(Object r2) {
        this.mLast = State.Constraint.BASELINE_TO_BOTTOM;
        this.mBaselineToBottom = r2;
        return this;
    }

    public ConstraintReference centerHorizontally(Object r1) {
        Object r2 = get(r1);
        this.mStartToStart = r2;
        this.mEndToEnd = r2;
        this.mLast = State.Constraint.CENTER_HORIZONTALLY;
        this.mHorizontalBias = 0.5f;
        return this;
    }

    public ConstraintReference centerVertically(Object r1) {
        Object r2 = get(r1);
        this.mTopToTop = r2;
        this.mBottomToBottom = r2;
        this.mLast = State.Constraint.CENTER_VERTICALLY;
        this.mVerticalBias = 0.5f;
        return this;
    }

    public ConstraintReference circularConstraint(Object r1, float r2, float r3) {
        this.mCircularConstraint = get(r1);
        this.mCircularAngle = r2;
        this.mCircularDistance = r3;
        this.mLast = State.Constraint.CIRCULAR_CONSTRAINT;
        return this;
    }

    public ConstraintReference width(Dimension r1) {
        return setWidth(r1);
    }

    public ConstraintReference height(Dimension r1) {
        return setHeight(r1);
    }

    public Dimension getWidth() {
        return this.mHorizontalDimension;
    }

    public ConstraintReference setWidth(Dimension r1) {
        this.mHorizontalDimension = r1;
        return this;
    }

    public Dimension getHeight() {
        return this.mVerticalDimension;
    }

    public ConstraintReference setHeight(Dimension r1) {
        this.mVerticalDimension = r1;
        return this;
    }

    public ConstraintReference margin(Object r2) {
        return margin(this.mState.convertDimension(r2));
    }

    public ConstraintReference marginGone(Object r2) {
        return marginGone(this.mState.convertDimension(r2));
    }

    public ConstraintReference margin(int r3) {
        if (this.mLast != null) goto L5;
        this.mMarginLeft = r3;
        this.mMarginRight = r3;
        this.mMarginStart = r3;
        this.mMarginEnd = r3;
        this.mMarginTop = r3;
        this.mMarginBottom = r3;
    L16:
        return this;
    L5:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$state$State$Constraint[this.mLast.ordinal()]) {
            case 1: goto L14;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L10;
            case 11: goto L9;
            case 12: goto L9;
            case 13: goto L8;
            case 14: goto L8;
            case 15: goto L8;
            case 16: goto L7;
            default: goto L16;
        };
    L7:
        this.mCircularDistance = r3;
        goto L16
    L8:
        this.mMarginBaseline = r3;
        goto L16
    L9:
        this.mMarginBottom = r3;
        goto L16
    L10:
        this.mMarginTop = r3;
        goto L16
    L11:
        this.mMarginEnd = r3;
        goto L16
    L12:
        this.mMarginStart = r3;
        goto L16
    L13:
        this.mMarginRight = r3;
        goto L16
    L14:
        this.mMarginLeft = r3;
        goto L16
    }

    public ConstraintReference marginGone(int r3) {
        if (this.mLast != null) goto L5;
        this.mMarginLeftGone = r3;
        this.mMarginRightGone = r3;
        this.mMarginStartGone = r3;
        this.mMarginEndGone = r3;
        this.mMarginTopGone = r3;
        this.mMarginBottomGone = r3;
    L15:
        return this;
    L5:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$state$State$Constraint[this.mLast.ordinal()]) {
            case 1: goto L13;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L8;
            case 13: goto L7;
            case 14: goto L7;
            case 15: goto L7;
            default: goto L15;
        };
    L7:
        this.mMarginBaselineGone = r3;
        goto L15
    L8:
        this.mMarginBottomGone = r3;
        goto L15
    L9:
        this.mMarginTopGone = r3;
        goto L15
    L10:
        this.mMarginEndGone = r3;
        goto L15
    L11:
        this.mMarginStartGone = r3;
        goto L15
    L12:
        this.mMarginRightGone = r3;
        goto L15
    L13:
        this.mMarginLeftGone = r3;
        goto L15
    }

    public ConstraintReference horizontalBias(float r1) {
        this.mHorizontalBias = r1;
        return this;
    }

    public ConstraintReference verticalBias(float r1) {
        this.mVerticalBias = r1;
        return this;
    }

    public ConstraintReference bias(float r3) {
        if (this.mLast != null) goto L5;
        return this;
    L5:
        int r0 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$state$State$Constraint[this.mLast.ordinal()];
        if (r0 != 17) goto L8;
    L12:
        this.mHorizontalBias = r3;
    L13:
        return this;
    L8:
        if (r0 == 18) goto L11;
        switch(r0) {
            case 1: goto L12;
            case 2: goto L12;
            case 3: goto L12;
            case 4: goto L12;
            case 5: goto L12;
            case 6: goto L12;
            case 7: goto L12;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L11;
            case 11: goto L11;
            case 12: goto L11;
            default: goto L13;
        };
    L11:
        this.mVerticalBias = r3;
        goto L13
    }

    public ConstraintReference clear() {
        if (this.mLast != null) goto L5;
        this.mLeftToLeft = null;
        this.mLeftToRight = null;
        this.mMarginLeft = 0;
        this.mRightToLeft = null;
        this.mRightToRight = null;
        this.mMarginRight = 0;
        this.mStartToStart = null;
        this.mStartToEnd = null;
        this.mMarginStart = 0;
        this.mEndToStart = null;
        this.mEndToEnd = null;
        this.mMarginEnd = 0;
        this.mTopToTop = null;
        this.mTopToBottom = null;
        this.mMarginTop = 0;
        this.mBottomToTop = null;
        this.mBottomToBottom = null;
        this.mMarginBottom = 0;
        this.mBaselineToBaseline = null;
        this.mCircularConstraint = null;
        this.mHorizontalBias = 0.5f;
        this.mVerticalBias = 0.5f;
        this.mMarginLeftGone = 0;
        this.mMarginRightGone = 0;
        this.mMarginStartGone = 0;
        this.mMarginEndGone = 0;
        this.mMarginTopGone = 0;
        this.mMarginBottomGone = 0;
    L16:
        return this;
    L5:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$state$State$Constraint[this.mLast.ordinal()]) {
            case 1: goto L14;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L10;
            case 11: goto L9;
            case 12: goto L9;
            case 13: goto L16;
            case 14: goto L16;
            case 15: goto L8;
            case 16: goto L7;
            default: goto L16;
        };
    L7:
        this.mCircularConstraint = null;
        goto L16
    L8:
        this.mBaselineToBaseline = null;
        goto L16
    L9:
        this.mBottomToTop = null;
        this.mBottomToBottom = null;
        this.mMarginBottom = 0;
        this.mMarginBottomGone = 0;
        goto L16
    L10:
        this.mTopToTop = null;
        this.mTopToBottom = null;
        this.mMarginTop = 0;
        this.mMarginTopGone = 0;
        goto L16
    L11:
        this.mEndToStart = null;
        this.mEndToEnd = null;
        this.mMarginEnd = 0;
        this.mMarginEndGone = 0;
        goto L16
    L12:
        this.mStartToStart = null;
        this.mStartToEnd = null;
        this.mMarginStart = 0;
        this.mMarginStartGone = 0;
        goto L16
    L13:
        this.mRightToLeft = null;
        this.mRightToRight = null;
        this.mMarginRight = 0;
        this.mMarginRightGone = 0;
        goto L16
    L14:
        this.mLeftToLeft = null;
        this.mLeftToRight = null;
        this.mMarginLeft = 0;
        this.mMarginLeftGone = 0;
        goto L16
    }

    private ConstraintWidget getTarget(Object r1) {
        if ((r1 instanceof Reference) == true) goto L5;
        return null;
    L5:
        return ((Reference) r1).getConstraintWidget();
    }

    private void applyConnection(ConstraintWidget r7, Object r8, State.Constraint r9) {
        ConstraintWidget r2 = getTarget(r8);
        if (r2 != null) goto L5;
        return;
    L5:
        int r10 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$state$State$Constraint[r9.ordinal()];
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$state$State$Constraint[r9.ordinal()]) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            case 8: goto L16;
            case 9: goto L15;
            case 10: goto L14;
            case 11: goto L13;
            case 12: goto L12;
            case 13: goto L11;
            case 14: goto L10;
            case 15: goto L9;
            case 16: goto L8;
            default: goto L40;
        };
    L8:
        r7.connectCircularConstraint(r2, this.mCircularAngle, (int) this.mCircularDistance);
        return;
    L9:
        r7.immediateConnect(ConstraintAnchor.Type.BASELINE, r2, ConstraintAnchor.Type.BASELINE, this.mMarginBaseline, this.mMarginBaselineGone);
        return;
    L10:
        r7.immediateConnect(ConstraintAnchor.Type.BASELINE, r2, ConstraintAnchor.Type.TOP, this.mMarginBaseline, this.mMarginBaselineGone);
        return;
    L11:
        r7.immediateConnect(ConstraintAnchor.Type.BASELINE, r2, ConstraintAnchor.Type.BOTTOM, this.mMarginBaseline, this.mMarginBaselineGone);
        return;
    L12:
        r7.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(r2.getAnchor(ConstraintAnchor.Type.BOTTOM), this.mMarginBottom, this.mMarginBottomGone, false);
        return;
    L13:
        r7.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(r2.getAnchor(ConstraintAnchor.Type.TOP), this.mMarginBottom, this.mMarginBottomGone, false);
        return;
    L14:
        r7.getAnchor(ConstraintAnchor.Type.TOP).connect(r2.getAnchor(ConstraintAnchor.Type.BOTTOM), this.mMarginTop, this.mMarginTopGone, false);
        return;
    L15:
        r7.getAnchor(ConstraintAnchor.Type.TOP).connect(r2.getAnchor(ConstraintAnchor.Type.TOP), this.mMarginTop, this.mMarginTopGone, false);
        return;
    L16:
        r7.getAnchor(ConstraintAnchor.Type.RIGHT).connect(r2.getAnchor(ConstraintAnchor.Type.RIGHT), this.mMarginEnd, this.mMarginEndGone, false);
        return;
    L17:
        r7.getAnchor(ConstraintAnchor.Type.RIGHT).connect(r2.getAnchor(ConstraintAnchor.Type.LEFT), this.mMarginEnd, this.mMarginEndGone, false);
        return;
    L18:
        r7.getAnchor(ConstraintAnchor.Type.LEFT).connect(r2.getAnchor(ConstraintAnchor.Type.RIGHT), this.mMarginStart, this.mMarginStartGone, false);
        return;
    L19:
        r7.getAnchor(ConstraintAnchor.Type.LEFT).connect(r2.getAnchor(ConstraintAnchor.Type.LEFT), this.mMarginStart, this.mMarginStartGone, false);
        return;
    L20:
        r7.getAnchor(ConstraintAnchor.Type.RIGHT).connect(r2.getAnchor(ConstraintAnchor.Type.RIGHT), this.mMarginRight, this.mMarginRightGone, false);
        return;
    L21:
        r7.getAnchor(ConstraintAnchor.Type.RIGHT).connect(r2.getAnchor(ConstraintAnchor.Type.LEFT), this.mMarginRight, this.mMarginRightGone, false);
        return;
    L22:
        r7.getAnchor(ConstraintAnchor.Type.LEFT).connect(r2.getAnchor(ConstraintAnchor.Type.RIGHT), this.mMarginLeft, this.mMarginLeftGone, false);
        return;
    L23:
        r7.getAnchor(ConstraintAnchor.Type.LEFT).connect(r2.getAnchor(ConstraintAnchor.Type.LEFT), this.mMarginLeft, this.mMarginLeftGone, false);
        return;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public void apply() {
        if (this.mConstraintWidget != null) goto L5;
        return;
    L5:
        Facade r0 = this.mFacade;
        if (r0 == null) goto L8;
        r0.apply();
    L8:
        this.mHorizontalDimension.apply(this.mState, this.mConstraintWidget, 0);
        this.mVerticalDimension.apply(this.mState, this.mConstraintWidget, 1);
        dereference();
        applyConnection(this.mConstraintWidget, this.mLeftToLeft, State.Constraint.LEFT_TO_LEFT);
        applyConnection(this.mConstraintWidget, this.mLeftToRight, State.Constraint.LEFT_TO_RIGHT);
        applyConnection(this.mConstraintWidget, this.mRightToLeft, State.Constraint.RIGHT_TO_LEFT);
        applyConnection(this.mConstraintWidget, this.mRightToRight, State.Constraint.RIGHT_TO_RIGHT);
        applyConnection(this.mConstraintWidget, this.mStartToStart, State.Constraint.START_TO_START);
        applyConnection(this.mConstraintWidget, this.mStartToEnd, State.Constraint.START_TO_END);
        applyConnection(this.mConstraintWidget, this.mEndToStart, State.Constraint.END_TO_START);
        applyConnection(this.mConstraintWidget, this.mEndToEnd, State.Constraint.END_TO_END);
        applyConnection(this.mConstraintWidget, this.mTopToTop, State.Constraint.TOP_TO_TOP);
        applyConnection(this.mConstraintWidget, this.mTopToBottom, State.Constraint.TOP_TO_BOTTOM);
        applyConnection(this.mConstraintWidget, this.mBottomToTop, State.Constraint.BOTTOM_TO_TOP);
        applyConnection(this.mConstraintWidget, this.mBottomToBottom, State.Constraint.BOTTOM_TO_BOTTOM);
        applyConnection(this.mConstraintWidget, this.mBaselineToBaseline, State.Constraint.BASELINE_TO_BASELINE);
        applyConnection(this.mConstraintWidget, this.mBaselineToTop, State.Constraint.BASELINE_TO_TOP);
        applyConnection(this.mConstraintWidget, this.mBaselineToBottom, State.Constraint.BASELINE_TO_BOTTOM);
        applyConnection(this.mConstraintWidget, this.mCircularConstraint, State.Constraint.CIRCULAR_CONSTRAINT);
        int r1 = this.mHorizontalChainStyle;
        if (r1 == 0) goto L11;
        this.mConstraintWidget.setHorizontalChainStyle(r1);
    L11:
        int r2 = this.mVerticalChainStyle;
        if (r2 == 0) goto L14;
        this.mConstraintWidget.setVerticalChainStyle(r2);
    L14:
        float r3 = this.mHorizontalChainWeight;
        if (r3 == (-1.0f)) goto L17;
        this.mConstraintWidget.setHorizontalWeight(r3);
    L17:
        float r4 = this.mVerticalChainWeight;
        if (r4 == (-1.0f)) goto L20;
        this.mConstraintWidget.setVerticalWeight(r4);
    L20:
        this.mConstraintWidget.setHorizontalBiasPercent(this.mHorizontalBias);
        this.mConstraintWidget.setVerticalBiasPercent(this.mVerticalBias);
        WidgetFrame r5 = this.mConstraintWidget.frame;
        r5.pivotX = this.mPivotX;
        WidgetFrame r6 = this.mConstraintWidget.frame;
        r6.pivotY = this.mPivotY;
        WidgetFrame r7 = this.mConstraintWidget.frame;
        r7.rotationX = this.mRotationX;
        WidgetFrame r8 = this.mConstraintWidget.frame;
        r8.rotationY = this.mRotationY;
        WidgetFrame r9 = this.mConstraintWidget.frame;
        r9.rotationZ = this.mRotationZ;
        WidgetFrame r10 = this.mConstraintWidget.frame;
        r10.translationX = this.mTranslationX;
        WidgetFrame r11 = this.mConstraintWidget.frame;
        r11.translationY = this.mTranslationY;
        WidgetFrame r12 = this.mConstraintWidget.frame;
        r12.translationZ = this.mTranslationZ;
        WidgetFrame r13 = this.mConstraintWidget.frame;
        r13.scaleX = this.mScaleX;
        WidgetFrame r14 = this.mConstraintWidget.frame;
        r14.scaleY = this.mScaleY;
        WidgetFrame r15 = this.mConstraintWidget.frame;
        r15.alpha = this.mAlpha;
        WidgetFrame r16 = this.mConstraintWidget.frame;
        r16.visibility = this.mVisibility;
        this.mConstraintWidget.setVisibility(this.mVisibility);
        HashMap<String, Integer> r17 = this.mCustomColors;
        if (r17 == null) goto L26;
        Iterator<String> r18 = r17.keySet().iterator();
    L24:
        if (r18.hasNext() == false) goto L26;
        String r19 = r18.next();
        Integer r20 = this.mCustomColors.get(r19);
        this.mConstraintWidget.frame.setCustomAttribute(r19, 902, r20.intValue());
    L26:
        HashMap<String, Float> r21 = this.mCustomFloats;
        if (r21 == null) goto L32;
        Iterator<String> r22 = r21.keySet().iterator();
    L30:
        if (r22.hasNext() == false) goto L35;
        String r23 = r22.next();
        float r24 = this.mCustomFloats.get(r23).floatValue();
        this.mConstraintWidget.frame.setCustomAttribute(r23, 901, r24);
        goto L30
    L35:
        return;
    }
}
