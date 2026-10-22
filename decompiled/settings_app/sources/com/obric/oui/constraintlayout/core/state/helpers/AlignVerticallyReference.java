package com.obric.oui.constraintlayout.core.state.helpers;

import com.obric.oui.constraintlayout.core.state.ConstraintReference;
import com.obric.oui.constraintlayout.core.state.HelperReference;
import com.obric.oui.constraintlayout.core.state.State;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class AlignVerticallyReference extends HelperReference {
    private float mBias;

    public AlignVerticallyReference(State r2) {
        super(r2, State.Helper.ALIGN_VERTICALLY);
        this.mBias = 0.5f;
    }

    @Override // com.obric.oui.constraintlayout.core.state.HelperReference, com.obric.oui.constraintlayout.core.state.ConstraintReference, com.obric.oui.constraintlayout.core.state.Reference
    public void apply() {
        Iterator<Object> r0 = this.mReferences.iterator();
    L4:
        if (r0.hasNext() == false) goto L22;
        Object r1 = r0.next();
        ConstraintReference r2 = this.mHelperState.constraints(r1);
        r2.clearVertical();
        if (this.mTopToTop == null) goto L9;
        r2.topToTop(this.mTopToTop);
    L13:
        if (this.mBottomToTop == null) goto L16;
        r2.bottomToTop(this.mBottomToTop);
    L19:
        float r3 = this.mBias;
        if (r3 == 0.5f) goto L4;
        r2.verticalBias(r3);
        goto L4
    L16:
        if (this.mBottomToBottom == null) goto L18;
        r2.bottomToBottom(this.mBottomToBottom);
        goto L19
    L18:
        r2.bottomToBottom(State.PARENT);
        goto L19
    L9:
        if (this.mTopToBottom == null) goto L11;
        r2.topToBottom(this.mTopToBottom);
        goto L13
    L11:
        r2.topToTop(State.PARENT);
        goto L13
    }
}
