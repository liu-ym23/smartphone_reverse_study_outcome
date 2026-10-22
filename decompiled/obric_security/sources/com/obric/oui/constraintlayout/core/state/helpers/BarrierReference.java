package com.obric.oui.constraintlayout.core.state.helpers;

import com.obric.oui.constraintlayout.core.state.ConstraintReference;
import com.obric.oui.constraintlayout.core.state.HelperReference;
import com.obric.oui.constraintlayout.core.state.State;
import com.obric.oui.constraintlayout.core.widgets.Barrier;
import com.obric.oui.constraintlayout.core.widgets.HelperWidget;

/* JADX INFO: loaded from: classes3.dex */
public class BarrierReference extends HelperReference {
    private Barrier mBarrierWidget;
    private State.Direction mDirection;
    private int mMargin;

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.core.state.helpers.BarrierReference$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$oui$constraintlayout$core$state$State$Direction = null;

        static {
            int[] r0 = new int[State.Direction.values().length];
            $SwitchMap$com$obric$oui$constraintlayout$core$state$State$Direction = r0;
            r0[State.Direction.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$com$obric$oui$constraintlayout$core$state$State$Direction[State.Direction.START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$com$obric$oui$constraintlayout$core$state$State$Direction[State.Direction.RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$com$obric$oui$constraintlayout$core$state$State$Direction[State.Direction.END.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$com$obric$oui$constraintlayout$core$state$State$Direction[State.Direction.TOP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$com$obric$oui$constraintlayout$core$state$State$Direction[State.Direction.BOTTOM.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public BarrierReference(State r2) {
        super(r2, State.Helper.BARRIER);
    }

    public void setBarrierDirection(State.Direction r1) {
        this.mDirection = r1;
    }

    @Override // com.obric.oui.constraintlayout.core.state.ConstraintReference
    public ConstraintReference margin(Object r2) {
        margin(this.mHelperState.convertDimension(r2));
        return this;
    }

    @Override // com.obric.oui.constraintlayout.core.state.ConstraintReference
    public ConstraintReference margin(int r1) {
        this.mMargin = r1;
        return this;
    }

    @Override // com.obric.oui.constraintlayout.core.state.HelperReference
    public HelperWidget getHelperWidget() {
        if (this.mBarrierWidget != null) goto L6;
        this.mBarrierWidget = new Barrier();
    L6:
        return this.mBarrierWidget;
    }

    @Override // com.obric.oui.constraintlayout.core.state.HelperReference, com.obric.oui.constraintlayout.core.state.ConstraintReference, com.obric.oui.constraintlayout.core.state.Reference
    public void apply() {
        getHelperWidget();
        int r0 = AnonymousClass1.$SwitchMap$com$obric$oui$constraintlayout$core$state$State$Direction[this.mDirection.ordinal()];
        int r1 = 3;
        if (r0 != 3) goto L5;
    L12:
        r1 = 1;
    L13:
        this.mBarrierWidget.setBarrierType(r1);
        this.mBarrierWidget.setMargin(this.mMargin);
        return;
    L5:
        if (r0 == 4) goto L12;
        if (r0 != 5) goto L9;
        r1 = 2;
        goto L13
    L9:
        if (r0 == 6) goto L13;
        r1 = 0;
        goto L13
    }
}
