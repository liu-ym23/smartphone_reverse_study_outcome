package com.obric.oui.constraintlayout.core.state.helpers;

import com.obric.oui.constraintlayout.core.state.ConstraintReference;
import com.obric.oui.constraintlayout.core.state.State;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class HorizontalChainReference extends ChainReference {

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.core.state.helpers.HorizontalChainReference$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$oui$constraintlayout$core$state$State$Chain = null;

        static {
            int[] r0 = new int[State.Chain.values().length];
            $SwitchMap$com$obric$oui$constraintlayout$core$state$State$Chain = r0;
            r0[State.Chain.SPREAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$obric$oui$constraintlayout$core$state$State$Chain[State.Chain.SPREAD_INSIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$obric$oui$constraintlayout$core$state$State$Chain[State.Chain.PACKED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public HorizontalChainReference(State r2) {
        super(r2, State.Helper.HORIZONTAL_CHAIN);
    }

    @Override // com.obric.oui.constraintlayout.core.state.HelperReference, com.obric.oui.constraintlayout.core.state.ConstraintReference, com.obric.oui.constraintlayout.core.state.Reference
    public void apply() {
        Iterator<Object> r0 = this.mReferences.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        this.mHelperState.constraints(r0.next()).clearHorizontal();
        goto L4
    L6:
        Iterator<Object> r1 = this.mReferences.iterator();
        ConstraintReference r2 = null;
        ConstraintReference r3 = null;
    L8:
        if (r1.hasNext() == false) goto L31;
        Object r4 = r1.next();
        ConstraintReference r5 = this.mHelperState.constraints(r4);
        if (r3 == null) goto L12;
    L25:
        if (r2 == null) goto L27;
        String r6 = r2.getKey().toString();
        String r7 = r5.getKey().toString();
        r2.endToStart(r5.getKey()).margin(Float.valueOf(getPostMargin(r6))).marginGone(Float.valueOf(getPostGoneMargin(r6)));
        r5.startToEnd(r2.getKey()).margin(Float.valueOf(getPreMargin(r7))).marginGone(Float.valueOf(getPreGoneMargin(r7)));
    L27:
        float r8 = getWeight(r4.toString());
        if (r8 == (-1.0f)) goto L30;
        r5.setHorizontalChainWeight(r8);
    L30:
        r2 = r5;
        goto L8
    L12:
        if (this.mStartToStart == null) goto L15;
        r5.startToStart(this.mStartToStart).margin(this.mMarginStart).marginGone(this.mMarginStartGone);
    L24:
        r3 = r5;
        goto L25
    L15:
        if (this.mStartToEnd == null) goto L18;
        r5.startToEnd(this.mStartToEnd).margin(this.mMarginStart).marginGone(this.mMarginStartGone);
        goto L24
    L18:
        if (this.mLeftToLeft == null) goto L21;
        r5.startToStart(this.mLeftToLeft).margin(this.mMarginLeft).marginGone(this.mMarginLeftGone);
        goto L24
    L21:
        if (this.mLeftToRight == null) goto L23;
        r5.startToEnd(this.mLeftToRight).margin(this.mMarginLeft).marginGone(this.mMarginLeftGone);
        goto L24
    L23:
        String r9 = r5.getKey().toString();
        r5.startToStart(State.PARENT).margin(Float.valueOf(getPreMargin(r9))).marginGone(Float.valueOf(getPreGoneMargin(r9)));
        goto L24
    L31:
        if (r2 != null) goto L33;
    L45:
        if (r3 != null) goto L48;
        return;
    L48:
        if (this.mBias == 0.5f) goto L50;
        r3.horizontalBias(this.mBias);
    L50:
        int r10 = AnonymousClass1.$SwitchMap$com$obric$oui$constraintlayout$core$state$State$Chain[this.mStyle.ordinal()];
        if (r10 != 1) goto L53;
        r3.setHorizontalChainStyle(0);
        return;
    L53:
        if (r10 != 2) goto L55;
        r3.setHorizontalChainStyle(1);
        return;
    L55:
        if (r10 != 3) goto L67;
        r3.setHorizontalChainStyle(2);
        return;
    L67:
        return;
    L33:
        if (this.mEndToStart == null) goto L36;
        r2.endToStart(this.mEndToStart).margin(this.mMarginEnd).marginGone(this.mMarginEndGone);
        goto L45
    L36:
        if (this.mEndToEnd == null) goto L39;
        r2.endToEnd(this.mEndToEnd).margin(this.mMarginEnd).marginGone(this.mMarginEndGone);
        goto L45
    L39:
        if (this.mRightToLeft == null) goto L42;
        r2.endToStart(this.mRightToLeft).margin(this.mMarginRight).marginGone(this.mMarginRightGone);
        goto L45
    L42:
        if (this.mRightToRight == null) goto L44;
        r2.endToEnd(this.mRightToRight).margin(this.mMarginRight).marginGone(this.mMarginRightGone);
        goto L45
    L44:
        String r11 = r2.getKey().toString();
        r2.endToEnd(State.PARENT).margin(Float.valueOf(getPostMargin(r11))).marginGone(Float.valueOf(getPostGoneMargin(r11)));
        goto L45
    }
}
