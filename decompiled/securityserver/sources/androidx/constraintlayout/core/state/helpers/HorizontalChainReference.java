package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.State;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class HorizontalChainReference extends ChainReference {

    /* JADX INFO: renamed from: androidx.constraintlayout.core.state.helpers.HorizontalChainReference$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
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
        if (r1.hasNext() == false) goto L28;
        ConstraintReference r4 = this.mState.constraints(r1.next());
        if (r3 != null) goto L25;
        Object r5 = this.mStartToStart;
        if (r5 == null) goto L14;
        r4.startToStart(r5).margin(this.mMarginStart).marginGone(this.mMarginStartGone);
    L24:
        r3 = r4;
        goto L25
    L14:
        Object r6 = this.mStartToEnd;
        if (r6 == null) goto L17;
        r4.startToEnd(r6).margin(this.mMarginStart).marginGone(this.mMarginStartGone);
        goto L24
    L17:
        Object r7 = this.mLeftToLeft;
        if (r7 == null) goto L20;
        r4.startToStart(r7).margin(this.mMarginLeft).marginGone(this.mMarginLeftGone);
        goto L24
    L20:
        Object r8 = this.mLeftToRight;
        if (r8 == null) goto L23;
        r4.startToEnd(r8).margin(this.mMarginLeft).marginGone(this.mMarginLeftGone);
        goto L24
    L23:
        r4.startToStart(State.PARENT);
    L25:
        if (r2 == null) goto L27;
        r2.endToStart(r4.getKey());
        r4.startToEnd(r2.getKey());
    L27:
        r2 = r4;
        goto L8
    L28:
        if (r2 == null) goto L42;
        Object r9 = this.mEndToStart;
        if (r9 == null) goto L32;
        r2.endToStart(r9).margin(this.mMarginEnd).marginGone(this.mMarginEndGone);
        goto L42
    L32:
        Object r10 = this.mEndToEnd;
        if (r10 == null) goto L35;
        r2.endToEnd(r10).margin(this.mMarginEnd).marginGone(this.mMarginEndGone);
        goto L42
    L35:
        Object r11 = this.mRightToLeft;
        if (r11 == null) goto L38;
        r2.endToStart(r11).margin(this.mMarginRight).marginGone(this.mMarginRightGone);
        goto L42
    L38:
        Object r12 = this.mRightToRight;
        if (r12 == null) goto L41;
        r2.endToEnd(r12).margin(this.mMarginRight).marginGone(this.mMarginRightGone);
        goto L42
    L41:
        r2.endToEnd(State.PARENT);
    L42:
        if (r3 != null) goto L44;
        return;
    L44:
        float r13 = this.mBias;
        if (r13 == 0.5f) goto L47;
        r3.horizontalBias(r13);
    L47:
        int r14 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$state$State$Chain[this.mStyle.ordinal()];
        if (r14 != 1) goto L50;
        r3.setHorizontalChainStyle(0);
        return;
    L50:
        if (r14 != 2) goto L52;
        r3.setHorizontalChainStyle(1);
        return;
    L52:
        if (r14 != 3) goto L64;
        r3.setHorizontalChainStyle(2);
        return;
    }
}
