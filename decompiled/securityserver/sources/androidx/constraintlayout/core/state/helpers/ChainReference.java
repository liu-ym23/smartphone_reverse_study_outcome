package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;

/* JADX INFO: loaded from: classes.dex */
public class ChainReference extends HelperReference {
    protected float mBias;
    protected State.Chain mStyle;

    public ChainReference(State r1, State.Helper r2) {
        super(r1, r2);
        this.mBias = 0.5f;
        this.mStyle = State.Chain.SPREAD;
    }

    @Override // androidx.constraintlayout.core.state.ConstraintReference
    public /* bridge */ /* synthetic */ ConstraintReference bias(float r1) {
        return bias(r1);
    }

    public float getBias() {
        return this.mBias;
    }

    public State.Chain getStyle() {
        return State.Chain.SPREAD;
    }

    public ChainReference style(State.Chain r1) {
        this.mStyle = r1;
        return this;
    }

    @Override // androidx.constraintlayout.core.state.ConstraintReference
    public ChainReference bias(float r1) {
        this.mBias = r1;
        return this;
    }
}
