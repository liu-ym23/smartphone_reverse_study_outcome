package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.Cache;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.analyzer.Grouping;
import androidx.constraintlayout.core.widgets.analyzer.WidgetGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintAnchor {
    private static final boolean ALLOW_BINARY = false;
    private static final int UNSET_GONE_MARGIN = Integer.MIN_VALUE;
    private HashSet<ConstraintAnchor> mDependents;
    private int mFinalValue;
    int mGoneMargin;
    private boolean mHasFinalValue;
    public int mMargin;
    public final ConstraintWidget mOwner;
    SolverVariable mSolverVariable;
    public ConstraintAnchor mTarget;
    public final Type mType;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.widgets.ConstraintAnchor$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type = null;

        static {
            int[] r0 = new int[Type.values().length];
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type = r0;
            r0[Type.CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[Type.LEFT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[Type.RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[Type.TOP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[Type.BOTTOM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[Type.BASELINE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[Type.CENTER_X.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[Type.CENTER_Y.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[Type.NONE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type BASELINE = null;
        public static final Type BOTTOM = null;
        public static final Type CENTER = null;
        public static final Type CENTER_X = null;
        public static final Type CENTER_Y = null;
        public static final Type LEFT = null;
        public static final Type NONE = null;
        public static final Type RIGHT = null;
        public static final Type TOP = null;

        static {
            Type r0 = new Type("NONE", 0);
            NONE = r0;
            Type r1 = new Type("LEFT", 1);
            LEFT = r1;
            Type r3 = new Type("TOP", 2);
            TOP = r3;
            Type r5 = new Type("RIGHT", 3);
            RIGHT = r5;
            Type r7 = new Type("BOTTOM", 4);
            BOTTOM = r7;
            Type r9 = new Type("BASELINE", 5);
            BASELINE = r9;
            Type r11 = new Type("CENTER", 6);
            CENTER = r11;
            Type r13 = new Type("CENTER_X", 7);
            CENTER_X = r13;
            Type r15 = new Type("CENTER_Y", 8);
            CENTER_Y = r15;
            $VALUES = new Type[]{r0, r1, r3, r5, r7, r9, r11, r13, r15};
        }

        private Type(String r1, int r2) {
            super(r1, r2);
        }

        public static Type valueOf(String r1) {
            return (Type) Enum.valueOf(Type.class, r1);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    public void findDependents(int r2, ArrayList<WidgetGroup> r3, WidgetGroup r4) {
        HashSet<ConstraintAnchor> r1 = this.mDependents;
        if (r1 == null) goto L8;
        Iterator<ConstraintAnchor> r5 = r1.iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        Grouping.findDependents(r5.next().mOwner, r2, r3, r4);
        goto L6
    L10:
        return;
    }

    public HashSet<ConstraintAnchor> getDependents() {
        return this.mDependents;
    }

    public boolean hasDependents() {
        HashSet<ConstraintAnchor> r1 = this.mDependents;
        if (r1 != null) goto L6;
        return false;
    L6:
        if (r1.size() <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean hasCenteredDependents() {
        HashSet<ConstraintAnchor> r2 = this.mDependents;
        if (r2 != null) goto L5;
        return false;
    L5:
        Iterator<ConstraintAnchor> r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L12;
        if (r3.next().getOpposite().isConnected() == false) goto L7;
        return true;
    L12:
        return false;
    }

    public void setFinalValue(int r1) {
        this.mFinalValue = r1;
        this.mHasFinalValue = true;
    }

    public int getFinalValue() {
        if (this.mHasFinalValue == true) goto L7;
        return 0;
    L7:
        return this.mFinalValue;
    }

    public void resetFinalResolution() {
        this.mHasFinalValue = false;
        this.mFinalValue = 0;
    }

    public boolean hasFinalValue() {
        return this.mHasFinalValue;
    }

    public void copyFrom(ConstraintAnchor r3, HashMap<ConstraintWidget, ConstraintWidget> r4) {
        ConstraintAnchor r0 = this.mTarget;
        if (r0 == null) goto L7;
        HashSet<ConstraintAnchor> r1 = r0.mDependents;
        if (r1 == null) goto L7;
        r1.remove(this);
    L7:
        ConstraintAnchor r2 = r3.mTarget;
        if (r2 == null) goto L10;
        Type r5 = r2.getType();
        this.mTarget = r4.get(r3.mTarget.mOwner).getAnchor(r5);
    L11:
        ConstraintAnchor r6 = this.mTarget;
        if (r6 != null) goto L14;
    L17:
        this.mMargin = r3.mMargin;
        this.mGoneMargin = r3.mGoneMargin;
        return;
    L14:
        if (r6.mDependents != null) goto L16;
        r6.mDependents = new HashSet();
    L16:
        this.mTarget.mDependents.add(this);
        goto L17
    L10:
        this.mTarget = null;
        goto L11
    }

    public ConstraintAnchor(ConstraintWidget r2, Type r3) {
        this.mDependents = null;
        this.mMargin = 0;
        this.mGoneMargin = Integer.MIN_VALUE;
        this.mOwner = r2;
        this.mType = r3;
    }

    public SolverVariable getSolverVariable() {
        return this.mSolverVariable;
    }

    public void resetSolverVariable(Cache r3) {
        SolverVariable r4 = this.mSolverVariable;
        if (r4 != null) goto L5;
        this.mSolverVariable = new SolverVariable(SolverVariable.Type.UNRESTRICTED, null);
        return;
    L5:
        r4.reset();
    }

    public ConstraintWidget getOwner() {
        return this.mOwner;
    }

    public Type getType() {
        return this.mType;
    }

    public int getMargin() {
        if (this.mOwner.getVisibility() != 8) goto L7;
        return 0;
    L7:
        if (this.mGoneMargin == Integer.MIN_VALUE) goto L15;
        ConstraintAnchor r0 = this.mTarget;
        if (r0 == null) goto L15;
        if (r0.mOwner.getVisibility() != 8) goto L15;
        return this.mGoneMargin;
    L15:
        return this.mMargin;
    }

    public ConstraintAnchor getTarget() {
        return this.mTarget;
    }

    public void reset() {
        ConstraintAnchor r0 = this.mTarget;
        if (r0 == null) goto L9;
        HashSet<ConstraintAnchor> r1 = r0.mDependents;
        if (r1 == null) goto L9;
        r1.remove(this);
        if (this.mTarget.mDependents.size() != 0) goto L9;
        this.mTarget.mDependents = null;
    L9:
        this.mDependents = null;
        this.mTarget = null;
        this.mMargin = 0;
        this.mGoneMargin = Integer.MIN_VALUE;
        this.mHasFinalValue = false;
        this.mFinalValue = 0;
    }

    public boolean connect(ConstraintAnchor r2, int r3, int r4, boolean r5) {
        if (r2 != null) goto L6;
        reset();
        return true;
    L6:
        if (r5 == false) goto L8;
    L11:
        this.mTarget = r2;
        if (r2.mDependents != null) goto L14;
        r2.mDependents = new HashSet();
    L14:
        HashSet<ConstraintAnchor> r6 = this.mTarget.mDependents;
        if (r6 == null) goto L17;
        r6.add(this);
    L17:
        this.mMargin = r3;
        this.mGoneMargin = r4;
        return true;
    L8:
        if (isValidConnection(r2) == true) goto L11;
        return false;
    }

    public boolean connect(ConstraintAnchor r3, int r4) {
        return connect(r3, r4, Integer.MIN_VALUE, false);
    }

    public boolean isConnected() {
        if (this.mTarget == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isValidConnection(ConstraintAnchor r6) {
        boolean r0 = false;
        if (r6 != null) goto L5;
        return false;
    L5:
        Type r1 = r6.getType();
        Type r2 = this.mType;
        if (r1 != r2) goto L16;
        if (r2 == Type.BASELINE) goto L10;
    L14:
        return true;
    L10:
        if (r6.getOwner().hasBaseline() == true) goto L12;
    L13:
        return false;
    L12:
        if (getOwner().hasBaseline() == true) goto L14;
    L16:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
            case 1: goto L58;
            case 2: goto L43;
            case 3: goto L43;
            case 4: goto L28;
            case 5: goto L28;
            case 6: goto L21;
            case 7: goto L19;
            case 8: goto L19;
            case 9: goto L19;
            default: goto L18;
        };
    L19:
        return false;
    L18:
        throw new AssertionError(this.mType.name());
    L21:
        if (r1 != Type.LEFT) goto L23;
    L26:
        return false;
    L23:
        if (r1 == Type.RIGHT) goto L26;
        return true;
    L28:
        if (r1 != Type.TOP) goto L30;
    L33:
        boolean r5 = true;
    L35:
        if ((r6.getOwner() instanceof Guideline) == false) goto L65;
        if (r5 == false) goto L38;
    L39:
        r0 = true;
    L41:
        return r0;
    L38:
        if (r1 != Type.CENTER_Y) goto L41;
    L65:
        return r5;
    L30:
        if (r1 == Type.BOTTOM) goto L33;
        r5 = false;
        goto L35
    L43:
        if (r1 != Type.LEFT) goto L45;
    L48:
        boolean r7 = true;
    L50:
        if ((r6.getOwner() instanceof Guideline) == false) goto L66;
        if (r7 == false) goto L53;
    L54:
        r0 = true;
    L56:
        return r0;
    L53:
        if (r1 != Type.CENTER_X) goto L56;
    L66:
        return r7;
    L45:
        if (r1 == Type.RIGHT) goto L48;
        r7 = false;
        goto L50
    L58:
        if (r1 != Type.BASELINE) goto L60;
        return false;
    L60:
        if (r1 != Type.CENTER_X) goto L62;
        return false;
    L62:
        if (r1 != Type.CENTER_Y) goto L64;
        return false;
    L64:
        return true;
    }

    public boolean isSideAnchor() {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
            case 1: goto L8;
            case 2: goto L6;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L8;
            case 7: goto L8;
            case 8: goto L8;
            case 9: goto L8;
            default: goto L5;
        };
    L6:
        return true;
    L8:
        return false;
    L5:
        throw new AssertionError(this.mType.name());
    }

    public boolean isSimilarDimensionConnection(ConstraintAnchor r4) {
        Type r5 = r4.getType();
        if (r5 != this.mType) goto L6;
        return true;
    L6:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
            case 1: goto L31;
            case 2: goto L22;
            case 3: goto L22;
            case 4: goto L11;
            case 5: goto L11;
            case 6: goto L11;
            case 7: goto L22;
            case 8: goto L11;
            case 9: goto L9;
            default: goto L8;
        };
    L9:
        return false;
    L8:
        throw new AssertionError(this.mType.name());
    L11:
        if (r5 != Type.TOP) goto L13;
        return true;
    L13:
        if (r5 != Type.BOTTOM) goto L15;
        return true;
    L15:
        if (r5 != Type.CENTER_Y) goto L17;
        return true;
    L17:
        if (r5 != Type.BASELINE) goto L20;
        return true;
    L20:
        return false;
    L22:
        if (r5 != Type.LEFT) goto L24;
        return true;
    L24:
        if (r5 != Type.RIGHT) goto L26;
        return true;
    L26:
        if (r5 != Type.CENTER_X) goto L29;
        return true;
    L29:
        return false;
    L31:
        if (r5 == Type.BASELINE) goto L34;
        return true;
    L34:
        return false;
    }

    public void setMargin(int r2) {
        if (isConnected() == false) goto L6;
        this.mMargin = r2;
        return;
    }

    public void setGoneMargin(int r2) {
        if (isConnected() == false) goto L6;
        this.mGoneMargin = r2;
        return;
    }

    public boolean isVerticalAnchor() {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
            case 1: goto L8;
            case 2: goto L8;
            case 3: goto L8;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L6;
            case 7: goto L8;
            case 8: goto L6;
            case 9: goto L6;
            default: goto L5;
        };
    L6:
        return true;
    L8:
        return false;
    L5:
        throw new AssertionError(this.mType.name());
    }

    public String toString() {
        return this.mOwner.getDebugName() + ":" + this.mType.toString();
    }

    public boolean isConnectionAllowed(ConstraintWidget r1, ConstraintAnchor r2) {
        return isConnectionAllowed(r1);
    }

    public boolean isConnectionAllowed(ConstraintWidget r3) {
        if (isConnectionToMe(r3, new HashSet()) == false) goto L5;
        return false;
    L5:
        ConstraintWidget r2 = getOwner().getParent();
        if (r2 != r3) goto L9;
        return true;
    L9:
        if (r3.getParent() != r2) goto L11;
        return true;
    L11:
        return false;
    }

    private boolean isConnectionToMe(ConstraintWidget r7, HashSet<ConstraintWidget> r8) {
        if (r8.contains(r7) == false) goto L5;
        return false;
    L5:
        r8.add(r7);
        if (r7 != getOwner()) goto L8;
        return true;
    L8:
        ArrayList<ConstraintAnchor> r9 = r7.getAnchors();
        int r0 = r9.size();
        int r3 = 0;
    L9:
        if (r3 >= r0) goto L18;
        ConstraintAnchor r4 = r9.get(r3);
        if (r4.isSimilarDimensionConnection(this) == false) goto L17;
        if (r4.isConnected() == false) goto L17;
        if (isConnectionToMe(r4.getTarget().getOwner(), r8) == false) goto L17;
        return true;
    L17:
        r3 = r3 + 1;
        goto L9
    L18:
        return false;
    }

    public final ConstraintAnchor getOpposite() {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L14;
            case 7: goto L14;
            case 8: goto L14;
            case 9: goto L14;
            default: goto L5;
        };
    L14:
        return null;
    L5:
        throw new AssertionError(this.mType.name());
    L7:
        return this.mOwner.mTop;
    L9:
        return this.mOwner.mBottom;
    L11:
        return this.mOwner.mLeft;
    L13:
        return this.mOwner.mRight;
    }
}
