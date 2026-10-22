package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.android.settings.utils.HanziToPinyin;
import com.obric.oui.constraintlayout.core.LinearSystem;
import com.obric.oui.constraintlayout.core.widgets.Chain;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class WidgetGroup {
    private static final boolean DEBUG = false;
    static int sCount;
    boolean mAuthoritative;
    int mId;
    private int mMoveTo;
    int mOrientation;
    ArrayList<MeasureResult> mResults;
    ArrayList<ConstraintWidget> mWidgets;

    static class MeasureResult {
        int mBaseline;
        int mBottom;
        int mLeft;
        int mOrientation;
        int mRight;
        int mTop;
        WeakReference<ConstraintWidget> mWidgetRef;

        MeasureResult(ConstraintWidget r2, LinearSystem r3, int r4) {
            this.mWidgetRef = new WeakReference(r2);
            this.mLeft = r3.getObjectVariableValue(r2.mLeft);
            this.mTop = r3.getObjectVariableValue(r2.mTop);
            this.mRight = r3.getObjectVariableValue(r2.mRight);
            this.mBottom = r3.getObjectVariableValue(r2.mBottom);
            this.mBaseline = r3.getObjectVariableValue(r2.mBaseline);
            this.mOrientation = r4;
        }

        public void apply() {
            ConstraintWidget r1 = this.mWidgetRef.get();
            if (r1 == null) goto L6;
            r1.setFinalFrame(this.mLeft, this.mTop, this.mRight, this.mBottom, this.mBaseline, this.mOrientation);
            return;
        }
    }

    static {
    }

    public WidgetGroup(int r3) {
        this.mWidgets = new ArrayList();
        this.mAuthoritative = false;
        this.mResults = null;
        this.mMoveTo = -1;
        int r0 = sCount;
        sCount = r0 + 1;
        this.mId = r0;
        this.mOrientation = r3;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getId() {
        return this.mId;
    }

    public boolean add(ConstraintWidget r2) {
        if (this.mWidgets.contains(r2) == false) goto L6;
        return false;
    L6:
        this.mWidgets.add(r2);
        return true;
    }

    public void setAuthoritative(boolean r1) {
        this.mAuthoritative = r1;
    }

    public boolean isAuthoritative() {
        return this.mAuthoritative;
    }

    private String getOrientationString() {
        int r1 = this.mOrientation;
        if (r1 != 0) goto L7;
        return "Horizontal";
    L7:
        if (r1 != 1) goto L11;
        return "Vertical";
    L11:
        if (r1 != 2) goto L14;
        return "Both";
    L14:
        return "Unknown";
    }

    public String toString() {
        String r0 = getOrientationString() + " [" + this.mId + "] <";
        Iterator<ConstraintWidget> r3 = this.mWidgets.iterator();
    L4:
        if (r3.hasNext() == false) goto L7;
        r0 = r0 + HanziToPinyin.Token.SEPARATOR + r3.next().getDebugName();
        goto L4
    L7:
        return r0 + " >";
    }

    public void moveTo(int r4, WidgetGroup r5) {
        Iterator<ConstraintWidget> r0 = this.mWidgets.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        ConstraintWidget r1 = r0.next();
        r5.add(r1);
        if (r4 == 0) goto L7;
        r1.verticalGroup = r5.getId();
        goto L4
    L7:
        r1.horizontalGroup = r5.getId();
        goto L4
    L9:
        this.mMoveTo = r5.mId;
    }

    public void clear() {
        this.mWidgets.clear();
    }

    private int measureWrap(int r2, ConstraintWidget r3) {
        ConstraintWidget.DimensionBehaviour r1 = r3.getDimensionBehaviour(r2);
        if (r1 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L5;
    L11:
        if (r2 != 0) goto L14;
        return r3.getWidth();
    L14:
        return r3.getHeight();
    L5:
        if (r1 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L11;
        if (r1 == ConstraintWidget.DimensionBehaviour.FIXED) goto L11;
        return -1;
    }

    public int measureWrap(LinearSystem r2, int r3) {
        if (this.mWidgets.size() != 0) goto L7;
        return 0;
    L7:
        return solverMeasure(r2, this.mWidgets, r3);
    }

    private int solverMeasure(LinearSystem r8, ArrayList<ConstraintWidget> r9, int r10) {
        int r0 = 0;
        ConstraintWidgetContainer r1 = (ConstraintWidgetContainer) r9.get(0).getParent();
        r8.reset();
        r1.addToSolver(r8, false);
        int r2 = 0;
    L4:
        if (r2 >= r9.size()) goto L6;
        r9.get(r2).addToSolver(r8, false);
        r2 = r2 + 1;
        goto L4
    L6:
        if (r10 != 0) goto L11;
        if (r1.mHorizontalChainsSize <= 0) goto L11;
        Chain.applyChainConstraints(r1, r8, r9, 0);
    L11:
        if (r10 == 1) goto L13;
    L28:
        r8.minimize();     // Catch: Exception -> L17
    L19:
        this.mResults = new ArrayList();
    L21:
        if (r0 >= r9.size()) goto L23;
        this.mResults.add(new MeasureResult(r9.get(r0), r8, r10));
        r0 = r0 + 1;
        goto L21
    L23:
        if (r10 != 0) goto L27;
        int r7 = r8.getObjectVariableValue(r1.mLeft);
        int r11 = r8.getObjectVariableValue(r1.mRight);
        r8.reset();
    L26:
        return r11 - r7;
    L27:
        r7 = r8.getObjectVariableValue(r1.mTop);
        r11 = r8.getObjectVariableValue(r1.mBottom);
        r8.reset();
    L17:
        e = move-exception;
        System.err.println(e.toString() + "\n" + Arrays.toString(e.getStackTrace()).replace("[", "   at ").replace(",", "\n   at").replace("]", ""));
        goto L19
    L13:
        if (r1.mVerticalChainsSize <= 0) goto L28;
        Chain.applyChainConstraints(r1, r8, r9, 1);
        goto L28
    }

    public void setOrientation(int r1) {
        this.mOrientation = r1;
    }

    public void apply() {
        if (this.mResults != null) goto L6;
        return;
    L6:
        if (this.mAuthoritative == true) goto L8;
        return;
    L8:
        int r0 = 0;
    L10:
        if (r0 >= this.mResults.size()) goto L12;
        this.mResults.get(r0).apply();
        r0 = r0 + 1;
        goto L10
    }

    public boolean intersectWith(WidgetGroup r4) {
        int r1 = 0;
    L4:
        if (r1 >= this.mWidgets.size()) goto L10;
        if (r4.contains(this.mWidgets.get(r1)) == true) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    private boolean contains(ConstraintWidget r1) {
        return this.mWidgets.contains(r1);
    }

    public int size() {
        return this.mWidgets.size();
    }

    public void cleanup(ArrayList<WidgetGroup> r6) {
        int r0 = this.mWidgets.size();
        if (this.mMoveTo == (-1)) goto L12;
        if (r0 <= 0) goto L12;
        int r1 = 0;
    L7:
        if (r1 >= r6.size()) goto L12;
        WidgetGroup r2 = r6.get(r1);
        if (this.mMoveTo != r2.mId) goto L11;
        moveTo(this.mOrientation, r2);
    L11:
        r1 = r1 + 1;
    L12:
        if (r0 != 0) goto L18;
        r6.remove(this);
        return;
    }
}
