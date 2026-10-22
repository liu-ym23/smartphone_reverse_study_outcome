package com.obric.oui.constraintlayout.core.state.helpers;

import com.obric.oui.constraintlayout.core.state.ConstraintReference;
import com.obric.oui.constraintlayout.core.state.State;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class VerticalChainReference extends ChainReference {

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.core.state.helpers.VerticalChainReference$1, reason: invalid class name */
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

    public VerticalChainReference(State r2) {
        super(r2, State.Helper.VERTICAL_CHAIN);
    }

    @Override // com.obric.oui.constraintlayout.core.state.HelperReference, com.obric.oui.constraintlayout.core.state.ConstraintReference, com.obric.oui.constraintlayout.core.state.Reference
    public void apply() {
        Iterator<Object> r0 = this.mReferences.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        this.mHelperState.constraints(r0.next()).clearVertical();
        goto L4
    L6:
        Iterator<Object> r1 = this.mReferences.iterator();
        ConstraintReference r2 = null;
        ConstraintReference r3 = null;
    L8:
        if (r1.hasNext() == false) goto L25;
        Object r4 = r1.next();
        ConstraintReference r5 = this.mHelperState.constraints(r4);
        if (r3 == null) goto L12;
    L19:
        if (r2 == null) goto L21;
        String r6 = r2.getKey().toString();
        String r7 = r5.getKey().toString();
        r2.bottomToTop(r5.getKey()).margin(Float.valueOf(getPostMargin(r6))).marginGone(Float.valueOf(getPostGoneMargin(r6)));
        r5.topToBottom(r2.getKey()).margin(Float.valueOf(getPreMargin(r7))).marginGone(Float.valueOf(getPreGoneMargin(r7)));
    L21:
        float r8 = getWeight(r4.toString());
        if (r8 == (-1.0f)) goto L24;
        r5.setVerticalChainWeight(r8);
    L24:
        r2 = r5;
        goto L8
    L12:
        if (this.mTopToTop == null) goto L15;
        r5.topToTop(this.mTopToTop).margin(this.mMarginTop).marginGone(this.mMarginTopGone);
    L18:
        r3 = r5;
        goto L19
    L15:
        if (this.mTopToBottom == null) goto L17;
        r5.topToBottom(this.mTopToBottom).margin(this.mMarginTop).marginGone(this.mMarginTopGone);
        goto L18
    L17:
        String r9 = r5.getKey().toString();
        r5.topToTop(State.PARENT).margin(Float.valueOf(getPreMargin(r9))).marginGone(Float.valueOf(getPreGoneMargin(r9)));
        goto L18
    L25:
        if (r2 != null) goto L27;
    L33:
        if (r3 != null) goto L36;
        return;
    L36:
        if (this.mBias == 0.5f) goto L38;
        r3.verticalBias(this.mBias);
    L38:
        int r10 = AnonymousClass1.$SwitchMap$com$obric$oui$constraintlayout$core$state$State$Chain[this.mStyle.ordinal()];
        if (r10 != 1) goto L41;
        r3.setVerticalChainStyle(0);
        return;
    L41:
        if (r10 != 2) goto L43;
        r3.setVerticalChainStyle(1);
        return;
    L43:
        if (r10 != 3) goto L55;
        r3.setVerticalChainStyle(2);
        return;
    L55:
        return;
    L27:
        if (this.mBottomToTop == null) goto L30;
        r2.bottomToTop(this.mBottomToTop).margin(this.mMarginBottom).marginGone(this.mMarginBottomGone);
        goto L33
    L30:
        if (this.mBottomToBottom == null) goto L32;
        r2.bottomToBottom(this.mBottomToBottom).margin(this.mMarginBottom).marginGone(this.mMarginBottomGone);
        goto L33
    L32:
        String r11 = r2.getKey().toString();
        r2.bottomToBottom(State.PARENT).margin(Float.valueOf(getPostMargin(r11))).marginGone(Float.valueOf(getPostGoneMargin(r11)));
        goto L33
    }
}
