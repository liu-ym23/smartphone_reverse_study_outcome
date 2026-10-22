package com.obric.oui.constraintlayout.core.state.helpers;

import com.obric.oui.constraintlayout.core.state.ConstraintReference;
import com.obric.oui.constraintlayout.core.state.HelperReference;
import com.obric.oui.constraintlayout.core.state.State;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class ChainReference extends HelperReference {
    protected float mBias;
    private HashMap<String, Float> mMapPostGoneMargin;

    @Deprecated
    protected HashMap<String, Float> mMapPostMargin;
    private HashMap<String, Float> mMapPreGoneMargin;

    @Deprecated
    protected HashMap<String, Float> mMapPreMargin;

    @Deprecated
    protected HashMap<String, Float> mMapWeights;
    protected State.Chain mStyle;

    @Override // com.obric.oui.constraintlayout.core.state.ConstraintReference
    public /* bridge */ /* synthetic */ ConstraintReference bias(float r1) {
        return bias(r1);
    }

    public ChainReference(State r1, State.Helper r2) {
        super(r1, r2);
        this.mBias = 0.5f;
        this.mMapWeights = new HashMap();
        this.mMapPreMargin = new HashMap();
        this.mMapPostMargin = new HashMap();
        this.mStyle = State.Chain.SPREAD;
    }

    public State.Chain getStyle() {
        return State.Chain.SPREAD;
    }

    public ChainReference style(State.Chain r1) {
        this.mStyle = r1;
        return this;
    }

    public void addChainElement(String r8, float r9, float r10, float r11) {
        addChainElement(r8, r9, r10, r11, 0.0f, 0.0f);
    }

    public void addChainElement(Object r3, float r4, float r5, float r6, float r7, float r8) {
        super.add(new Object[]{r3});
        String r9 = r3.toString();
        if (Float.isNaN(r4) == true) goto L6;
        this.mMapWeights.put(r9, Float.valueOf(r4));
    L6:
        if (Float.isNaN(r5) == true) goto L9;
        this.mMapPreMargin.put(r9, Float.valueOf(r5));
    L9:
        if (Float.isNaN(r6) == true) goto L12;
        this.mMapPostMargin.put(r9, Float.valueOf(r6));
    L12:
        if (Float.isNaN(r7) == true) goto L18;
        if (this.mMapPreGoneMargin != null) goto L16;
        this.mMapPreGoneMargin = new HashMap();
    L16:
        this.mMapPreGoneMargin.put(r9, Float.valueOf(r7));
    L18:
        if (Float.isNaN(r8) == false) goto L20;
        return;
    L20:
        if (this.mMapPostGoneMargin != null) goto L22;
        this.mMapPostGoneMargin = new HashMap();
    L22:
        this.mMapPostGoneMargin.put(r9, Float.valueOf(r8));
    }

    protected float getWeight(String r2) {
        if (this.mMapWeights.containsKey(r2) == true) goto L5;
        return -1.0f;
    L5:
        return this.mMapWeights.get(r2).floatValue();
    }

    protected float getPostMargin(String r2) {
        if (this.mMapPostMargin.containsKey(r2) == true) goto L5;
        return 0.0f;
    L5:
        return this.mMapPostMargin.get(r2).floatValue();
    }

    protected float getPreMargin(String r2) {
        if (this.mMapPreMargin.containsKey(r2) == true) goto L5;
        return 0.0f;
    L5:
        return this.mMapPreMargin.get(r2).floatValue();
    }

    float getPostGoneMargin(String r2) {
        HashMap<String, Float> r0 = this.mMapPostGoneMargin;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (r0.containsKey(r2) == true) goto L7;
        return 0.0f;
    L7:
        return this.mMapPostGoneMargin.get(r2).floatValue();
    }

    float getPreGoneMargin(String r2) {
        HashMap<String, Float> r0 = this.mMapPreGoneMargin;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (r0.containsKey(r2) == true) goto L7;
        return 0.0f;
    L7:
        return this.mMapPreGoneMargin.get(r2).floatValue();
    }

    public float getBias() {
        return this.mBias;
    }

    @Override // com.obric.oui.constraintlayout.core.state.ConstraintReference
    public ChainReference bias(float r1) {
        this.mBias = r1;
        return this;
    }
}
