package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.State;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class HorizontalChainReference extends ChainReference {

    /* JADX INFO: renamed from: androidx.constraintlayout.core.state.helpers.HorizontalChainReference$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$state$State$Chain = null;

        static {
            int[] r0 = new int[State.Chain.values().length];
            $SwitchMap$androidx$constraintlayout$core$state$State$Chain = r0;
            r0[State.Chain.SPREAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$androidx$constraintlayout$core$state$State$Chain[State.Chain.SPREAD_INSIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$androidx$constraintlayout$core$state$State$Chain[State.Chain.PACKED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public HorizontalChainReference(State r2) {
        super(r2, State.Helper.HORIZONTAL_CHAIN);
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        Iterator<Object> r0 = this.mReferences.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        this.mState.constraints(r0.next()).clearHorizontal();
        goto L4
    L6:
        Iterator<Object> r1 = this.mReferences.iterator();
        ConstraintReference r2 = null;
        ConstraintReference r3 = null;
    L8:
        if (r1.hasNext() == false) goto L31;
        ConstraintReference r4 = this.mState.constraints(r1.next());
        if (r3 != null) goto L28;
        Object r5 = this.mStartToStart;
        if (r5 == null) goto L16;
        ConstraintReference r6 = r4.startToStart(r5);
    L14:
        ConstraintReference r7 = r6.margin(this.mMarginStart);
        int r8 = this.mMarginStartGone;
    L15:
        r7.marginGone(r8);
    L27:
        r3 = r4;
        goto L28
    L16:
        Object r9 = this.mStartToEnd;
        if (r9 == null) goto L19;
        r6 = r4.startToEnd(r9);
        goto L14
    L19:
        Object r10 = this.mLeftToLeft;
        if (r10 == null) goto L23;
        ConstraintReference r11 = r4.startToStart(r10);
    L22:
        r7 = r11.margin(this.mMarginLeft);
        r8 = this.mMarginLeftGone;
        goto L15
    L23:
        Object r12 = this.mLeftToRight;
        if (r12 == null) goto L26;
        r11 = r4.startToEnd(r12);
        goto L22
    L26:
        r4.startToStart(State.PARENT);
    L28:
        if (r2 == null) goto L30;
        r2.endToStart(r4.getKey());
        r4.startToEnd(r2.getKey());
    L30:
        r2 = r4;
        goto L8
    L31:
        if (r2 == null) goto L48;
        Object r13 = this.mEndToStart;
        if (r13 == null) goto L37;
        ConstraintReference r14 = r2.endToStart(r13);
    L35:
        ConstraintReference r15 = r14.margin(this.mMarginEnd);
        int r16 = this.mMarginEndGone;
    L36:
        r15.marginGone(r16);
        goto L48
    L37:
        Object r17 = this.mEndToEnd;
        if (r17 == null) goto L40;
        r14 = r2.endToEnd(r17);
        goto L35
    L40:
        Object r18 = this.mRightToLeft;
        if (r18 == null) goto L44;
        ConstraintReference r19 = r2.endToStart(r18);
    L43:
        r15 = r19.margin(this.mMarginRight);
        r16 = this.mMarginRightGone;
        goto L36
    L44:
        Object r20 = this.mRightToRight;
        if (r20 == null) goto L47;
        r19 = r2.endToEnd(r20);
        goto L43
    L47:
        r2.endToEnd(State.PARENT);
    L48:
        if (r3 != null) goto L50;
        return;
    L50:
        float r21 = this.mBias;
        if (r21 == 0.5f) goto L53;
        r3.horizontalBias(r21);
    L53:
        int r22 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$state$State$Chain[this.mStyle.ordinal()];
        if (r22 != 1) goto L56;
        r3.setHorizontalChainStyle(0);
        return;
    L56:
        if (r22 != 2) goto L58;
        r3.setHorizontalChainStyle(1);
        return;
    L58:
        if (r22 != 3) goto L70;
        r3.setHorizontalChainStyle(2);
        return;
    }
}
