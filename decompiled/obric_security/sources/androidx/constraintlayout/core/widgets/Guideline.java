package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class Guideline extends ConstraintWidget {
    public static final int HORIZONTAL = 0;
    public static final int RELATIVE_BEGIN = 1;
    public static final int RELATIVE_END = 2;
    public static final int RELATIVE_PERCENT = 0;
    public static final int RELATIVE_UNKNOWN = -1;
    public static final int VERTICAL = 1;
    protected boolean guidelineUseRtl;
    private ConstraintAnchor mAnchor;
    private int mMinimumPosition;
    private int mOrientation;
    protected int mRelativeBegin;
    protected int mRelativeEnd;
    protected float mRelativePercent;
    private boolean resolved;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.widgets.Guideline$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type = null;

        static {
            int[] r0 = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type = r0;
            r0[ConstraintAnchor.Type.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.NONE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public String getType() {
        return "Guideline";
    }

    public Guideline() {
        this.mRelativePercent = -1.0f;
        this.mRelativeBegin = -1;
        this.mRelativeEnd = -1;
        this.guidelineUseRtl = true;
        this.mAnchor = this.mTop;
        int r0 = 0;
        this.mOrientation = 0;
        this.mMinimumPosition = 0;
        this.mAnchors.clear();
        this.mAnchors.add(this.mAnchor);
        int r1 = this.mListAnchors.length;
    L3:
        if (r0 >= r1) goto L5;
        this.mListAnchors[r0] = this.mAnchor;
        r0 = r0 + 1;
        goto L3
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void copy(ConstraintWidget r1, HashMap<ConstraintWidget, ConstraintWidget> r2) {
        super.copy(r1, r2);
        Guideline r3 = (Guideline) r1;
        this.mRelativePercent = r3.mRelativePercent;
        this.mRelativeBegin = r3.mRelativeBegin;
        this.mRelativeEnd = r3.mRelativeEnd;
        this.guidelineUseRtl = r3.guidelineUseRtl;
        setOrientation(r3.mOrientation);
    }

    public int getRelativeBehaviour() {
        if (this.mRelativePercent == (-1.0f)) goto L7;
        return 0;
    L7:
        if (this.mRelativeBegin == (-1)) goto L11;
        return 1;
    L11:
        if (this.mRelativeEnd == (-1)) goto L14;
        return 2;
    L14:
        return -1;
    }

    public void setOrientation(int r4) {
        if (this.mOrientation != r4) goto L5;
        return;
    L5:
        this.mOrientation = r4;
        this.mAnchors.clear();
        if (this.mOrientation != 1) goto L8;
        this.mAnchor = this.mLeft;
    L9:
        this.mAnchors.add(this.mAnchor);
        int r5 = this.mListAnchors.length;
        int r0 = 0;
    L10:
        if (r0 >= r5) goto L12;
        this.mListAnchors[r0] = this.mAnchor;
        r0 = r0 + 1;
        goto L10
    L12:
        return;
    L8:
        this.mAnchor = this.mTop;
        goto L9
    }

    public ConstraintAnchor getAnchor() {
        return this.mAnchor;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setMinimumPosition(int r1) {
        this.mMinimumPosition = r1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public ConstraintAnchor getAnchor(ConstraintAnchor.Type r3) {
        int r4 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[r3.ordinal()];
        if (r4 == 1) goto L16;
        if (r4 == 2) goto L16;
        if (r4 == 3) goto L12;
        if (r4 == 4) goto L12;
        return null;
    L12:
        if (this.mOrientation == 0) goto L14;
        return null;
    L14:
        return this.mAnchor;
    L16:
        if (this.mOrientation == 1) goto L18;
        return null;
    L18:
        return this.mAnchor;
    }

    public void setGuidePercent(int r2) {
        setGuidePercent(r2 / 100.0f);
    }

    public void setGuidePercent(float r2) {
        if (r2 <= (-1.0f)) goto L6;
        this.mRelativePercent = r2;
        this.mRelativeBegin = -1;
        this.mRelativeEnd = -1;
        return;
    }

    public void setGuideBegin(int r3) {
        if (r3 <= (-1)) goto L6;
        this.mRelativePercent = -1.0f;
        this.mRelativeBegin = r3;
        this.mRelativeEnd = -1;
        return;
    }

    public void setGuideEnd(int r3) {
        if (r3 <= (-1)) goto L6;
        this.mRelativePercent = -1.0f;
        this.mRelativeBegin = -1;
        this.mRelativeEnd = r3;
        return;
    }

    public float getRelativePercent() {
        return this.mRelativePercent;
    }

    public int getRelativeBegin() {
        return this.mRelativeBegin;
    }

    public int getRelativeEnd() {
        return this.mRelativeEnd;
    }

    public void setFinalValue(int r2) {
        this.mAnchor.setFinalValue(r2);
        this.resolved = true;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean isResolvedHorizontally() {
        return this.resolved;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean isResolvedVertically() {
        return this.resolved;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(LinearSystem r8, boolean r9) {
        ConstraintWidgetContainer r10 = (ConstraintWidgetContainer) getParent();
        if (r10 != null) goto L5;
        return;
    L5:
        ConstraintAnchor r0 = r10.getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor r1 = r10.getAnchor(ConstraintAnchor.Type.RIGHT);
        boolean r3 = true;
        if (this.mParent != null) goto L8;
    L10:
        boolean r2 = false;
    L12:
        if (this.mOrientation != 0) goto L21;
        r0 = r10.getAnchor(ConstraintAnchor.Type.TOP);
        r1 = r10.getAnchor(ConstraintAnchor.Type.BOTTOM);
        if (this.mParent != null) goto L16;
    L18:
        r3 = false;
    L19:
        r2 = r3;
        goto L21
    L16:
        if (this.mParent.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L18;
    L21:
        if (this.resolved == false) goto L35;
        if (this.mAnchor.hasFinalValue() == false) goto L35;
        SolverVariable r11 = r8.createObjectVariable(this.mAnchor);
        r8.addEquality(r11, this.mAnchor.getFinalValue());
        if (this.mRelativeBegin == (-1)) goto L29;
        if (r2 == false) goto L32;
        r8.addGreaterThan(r8.createObjectVariable(r1), r11, 0, 5);
    L32:
        this.resolved = false;
        return;
    L29:
        if (this.mRelativeEnd == (-1)) goto L32;
        if (r2 == false) goto L32;
        SolverVariable r4 = r8.createObjectVariable(r1);
        r8.addGreaterThan(r11, r8.createObjectVariable(r0), 0, 5);
        r8.addGreaterThan(r4, r11, 0, 5);
    L35:
        if (this.mRelativeBegin == (-1)) goto L40;
        SolverVariable r12 = r8.createObjectVariable(this.mAnchor);
        r8.addEquality(r12, r8.createObjectVariable(r0), this.mRelativeBegin, 8);
        if (r2 == false) goto L48;
        r8.addGreaterThan(r8.createObjectVariable(r1), r12, 0, 5);
        return;
    L48:
        return;
    L40:
        if (this.mRelativeEnd == (-1)) goto L45;
        SolverVariable r13 = r8.createObjectVariable(this.mAnchor);
        SolverVariable r5 = r8.createObjectVariable(r1);
        r8.addEquality(r13, r5, -this.mRelativeEnd, 8);
        if (r2 == false) goto L50;
        r8.addGreaterThan(r13, r8.createObjectVariable(r0), 0, 5);
        r8.addGreaterThan(r5, r13, 0, 5);
        return;
    L50:
        return;
    L45:
        if (this.mRelativePercent == (-1.0f)) goto L52;
        r8.addConstraint(LinearSystem.createRowDimensionPercent(r8, r8.createObjectVariable(this.mAnchor), r8.createObjectVariable(r1), this.mRelativePercent));
        return;
    L52:
        return;
    L8:
        if (this.mParent.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L10;
        r2 = true;
        goto L12
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void updateFromSolver(LinearSystem r3, boolean r4) {
        if (getParent() != null) goto L5;
        return;
    L5:
        int r5 = r3.getObjectVariableValue(this.mAnchor);
        if (this.mOrientation != 1) goto L8;
        setX(r5);
        setY(0);
        setHeight(getParent().getHeight());
        setWidth(0);
        return;
    L8:
        setX(0);
        setY(r5);
        setWidth(getParent().getWidth());
        setHeight(0);
    }

    void inferRelativePercentPosition() {
        float r0 = getX() / getParent().getWidth();
        if (this.mOrientation != 0) goto L5;
        r0 = getY() / getParent().getHeight();
    L5:
        setGuidePercent(r0);
    }

    void inferRelativeBeginPosition() {
        int r0 = getX();
        if (this.mOrientation != 0) goto L5;
        r0 = getY();
    L5:
        setGuideBegin(r0);
    }

    void inferRelativeEndPosition() {
        int r0 = getParent().getWidth() - getX();
        if (this.mOrientation != 0) goto L5;
        r0 = getParent().getHeight() - getY();
    L5:
        setGuideEnd(r0);
    }

    public void cyclePosition() {
        if (this.mRelativeBegin == (-1)) goto L6;
        inferRelativePercentPosition();
        return;
    L6:
        if (this.mRelativePercent == (-1.0f)) goto L9;
        inferRelativeEndPosition();
        return;
    L9:
        if (this.mRelativeEnd == (-1)) goto L14;
        inferRelativeBeginPosition();
        return;
    }

    public boolean isPercent() {
        if (this.mRelativePercent != (-1.0f)) goto L5;
    L9:
        return false;
    L5:
        if (this.mRelativeBegin != (-1)) goto L9;
        if (this.mRelativeEnd != (-1)) goto L9;
        return true;
    }
}
