package com.obric.oui.constraintlayout.core.state;

import com.obric.oui.constraintlayout.core.state.helpers.Facade;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.HelperWidget;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public class HelperReference extends ConstraintReference implements Facade {
    protected final State mHelperState;
    private HelperWidget mHelperWidget;
    protected ArrayList<Object> mReferences;
    final State.Helper mType;

    @Override // com.obric.oui.constraintlayout.core.state.ConstraintReference, com.obric.oui.constraintlayout.core.state.Reference
    public void apply() {
    }

    public HelperReference(State r2, State.Helper r3) {
        super(r2);
        this.mReferences = new ArrayList();
        this.mHelperState = r2;
        this.mType = r3;
    }

    public State.Helper getType() {
        return this.mType;
    }

    public HelperReference add(Object... r2) {
        Collections.addAll(this.mReferences, r2);
        return this;
    }

    public void setHelperWidget(HelperWidget r1) {
        this.mHelperWidget = r1;
    }

    public HelperWidget getHelperWidget() {
        return this.mHelperWidget;
    }

    @Override // com.obric.oui.constraintlayout.core.state.ConstraintReference, com.obric.oui.constraintlayout.core.state.Reference
    public ConstraintWidget getConstraintWidget() {
        return getHelperWidget();
    }

    public void applyBase() {
        super.apply();
    }
}
