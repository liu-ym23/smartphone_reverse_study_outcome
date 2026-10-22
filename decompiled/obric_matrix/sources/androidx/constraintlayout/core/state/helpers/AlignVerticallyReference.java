package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class AlignVerticallyReference extends HelperReference {
    private float mBias;

    public AlignVerticallyReference(State r2) {
        super(r2, State.Helper.ALIGN_VERTICALLY);
        this.mBias = 0.5f;
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        Iterator<Object> r0 = this.mReferences.iterator();
    L4:
        if (r0.hasNext() == false) goto L23;
        Object r1 = r0.next();
        ConstraintReference r2 = this.mState.constraints(r1);
        r2.clearVertical();
        Object r3 = this.mTopToTop;
        if (r3 == null) goto L8;
    L7:
        r2.topToTop(r3);
    L12:
        Object r4 = this.mBottomToTop;
        if (r4 == null) goto L15;
        r2.bottomToTop(r4);
    L20:
        float r5 = this.mBias;
        if (r5 == 0.5f) goto L4;
        r2.verticalBias(r5);
        goto L4
    L15:
        Object r6 = this.mBottomToBottom;
        if (r6 != null) goto L19;
        r6 = State.PARENT;
    L19:
        r2.bottomToBottom(r6);
        goto L20
    L8:
        Object r7 = this.mTopToBottom;
        if (r7 == null) goto L11;
        r2.topToBottom(r7);
        goto L12
    L11:
        r3 = State.PARENT;
        goto L7
    }
}
