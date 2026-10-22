package com.obric.oui.constraintlayout.core.state.helpers;

import com.obric.oui.constraintlayout.core.state.HelperReference;
import com.obric.oui.constraintlayout.core.state.State;
import com.obric.oui.constraintlayout.core.widgets.Flow;
import com.obric.oui.constraintlayout.core.widgets.HelperWidget;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class FlowReference extends HelperReference {
    protected float mFirstHorizontalBias;
    protected int mFirstHorizontalStyle;
    protected float mFirstVerticalBias;
    protected int mFirstVerticalStyle;
    protected Flow mFlow;
    protected int mHorizontalAlign;
    protected int mHorizontalGap;
    protected int mHorizontalStyle;
    protected float mLastHorizontalBias;
    protected int mLastHorizontalStyle;
    protected float mLastVerticalBias;
    protected int mLastVerticalStyle;
    protected HashMap<String, Float> mMapPostMargin;
    protected HashMap<String, Float> mMapPreMargin;
    protected HashMap<String, Float> mMapWeights;
    protected int mMaxElementsWrap;
    protected int mOrientation;
    protected int mPaddingBottom;
    protected int mPaddingLeft;
    protected int mPaddingRight;
    protected int mPaddingTop;
    protected int mVerticalAlign;
    protected int mVerticalGap;
    protected int mVerticalStyle;
    protected int mWrapMode;

    public FlowReference(State r3, State.Helper r4) {
        super(r3, r4);
        this.mWrapMode = 0;
        this.mVerticalStyle = -1;
        this.mFirstVerticalStyle = -1;
        this.mLastVerticalStyle = -1;
        this.mHorizontalStyle = -1;
        this.mFirstHorizontalStyle = -1;
        this.mLastHorizontalStyle = -1;
        this.mVerticalAlign = 2;
        this.mHorizontalAlign = 2;
        this.mVerticalGap = 0;
        this.mHorizontalGap = 0;
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mMaxElementsWrap = -1;
        this.mOrientation = 0;
        this.mFirstVerticalBias = 0.5f;
        this.mLastVerticalBias = 0.5f;
        this.mFirstHorizontalBias = 0.5f;
        this.mLastHorizontalBias = 0.5f;
        if (r4 != State.Helper.VERTICAL_FLOW) goto L6;
        this.mOrientation = 1;
        return;
    }

    public void addFlowElement(String r3, float r4, float r5, float r6) {
        super.add(new Object[]{r3});
        if (Float.isNaN(r4) == true) goto L9;
        if (this.mMapWeights != null) goto L7;
        this.mMapWeights = new HashMap();
    L7:
        this.mMapWeights.put(r3, Float.valueOf(r4));
    L9:
        if (Float.isNaN(r5) == true) goto L15;
        if (this.mMapPreMargin != null) goto L13;
        this.mMapPreMargin = new HashMap();
    L13:
        this.mMapPreMargin.put(r3, Float.valueOf(r5));
    L15:
        if (Float.isNaN(r6) == false) goto L17;
        return;
    L17:
        if (this.mMapPostMargin != null) goto L19;
        this.mMapPostMargin = new HashMap();
    L19:
        this.mMapPostMargin.put(r3, Float.valueOf(r6));
    }

    protected float getWeight(String r3) {
        HashMap<String, Float> r0 = this.mMapWeights;
        if (r0 != null) goto L6;
        return -1.0f;
    L6:
        if (r0.containsKey(r3) == true) goto L8;
        return -1.0f;
    L8:
        return this.mMapWeights.get(r3).floatValue();
    }

    protected float getPostMargin(String r2) {
        HashMap<String, Float> r0 = this.mMapPreMargin;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (r0.containsKey(r2) == true) goto L7;
        return 0.0f;
    L7:
        return this.mMapPreMargin.get(r2).floatValue();
    }

    protected float getPreMargin(String r2) {
        HashMap<String, Float> r0 = this.mMapPostMargin;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (r0.containsKey(r2) == true) goto L7;
        return 0.0f;
    L7:
        return this.mMapPostMargin.get(r2).floatValue();
    }

    public int getWrapMode() {
        return this.mWrapMode;
    }

    public void setWrapMode(int r1) {
        this.mWrapMode = r1;
    }

    public int getPaddingLeft() {
        return this.mPaddingLeft;
    }

    public void setPaddingLeft(int r1) {
        this.mPaddingLeft = r1;
    }

    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    public void setPaddingTop(int r1) {
        this.mPaddingTop = r1;
    }

    public int getPaddingRight() {
        return this.mPaddingRight;
    }

    public void setPaddingRight(int r1) {
        this.mPaddingRight = r1;
    }

    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public void setPaddingBottom(int r1) {
        this.mPaddingBottom = r1;
    }

    public int getVerticalStyle() {
        return this.mVerticalStyle;
    }

    public void setVerticalStyle(int r1) {
        this.mVerticalStyle = r1;
    }

    public int getFirstVerticalStyle() {
        return this.mFirstVerticalStyle;
    }

    public void setFirstVerticalStyle(int r1) {
        this.mFirstVerticalStyle = r1;
    }

    public int getLastVerticalStyle() {
        return this.mLastVerticalStyle;
    }

    public void setLastVerticalStyle(int r1) {
        this.mLastVerticalStyle = r1;
    }

    public int getHorizontalStyle() {
        return this.mHorizontalStyle;
    }

    public void setHorizontalStyle(int r1) {
        this.mHorizontalStyle = r1;
    }

    public int getFirstHorizontalStyle() {
        return this.mFirstHorizontalStyle;
    }

    public void setFirstHorizontalStyle(int r1) {
        this.mFirstHorizontalStyle = r1;
    }

    public int getLastHorizontalStyle() {
        return this.mLastHorizontalStyle;
    }

    public void setLastHorizontalStyle(int r1) {
        this.mLastHorizontalStyle = r1;
    }

    public int getVerticalAlign() {
        return this.mVerticalAlign;
    }

    public void setVerticalAlign(int r1) {
        this.mVerticalAlign = r1;
    }

    public int getHorizontalAlign() {
        return this.mHorizontalAlign;
    }

    public void setHorizontalAlign(int r1) {
        this.mHorizontalAlign = r1;
    }

    public int getVerticalGap() {
        return this.mVerticalGap;
    }

    public void setVerticalGap(int r1) {
        this.mVerticalGap = r1;
    }

    public int getHorizontalGap() {
        return this.mHorizontalGap;
    }

    public void setHorizontalGap(int r1) {
        this.mHorizontalGap = r1;
    }

    public int getMaxElementsWrap() {
        return this.mMaxElementsWrap;
    }

    public void setMaxElementsWrap(int r1) {
        this.mMaxElementsWrap = r1;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int r1) {
        this.mOrientation = r1;
    }

    public float getVerticalBias() {
        return this.mVerticalBias;
    }

    public float getFirstVerticalBias() {
        return this.mFirstVerticalBias;
    }

    public void setFirstVerticalBias(float r1) {
        this.mFirstVerticalBias = r1;
    }

    public float getLastVerticalBias() {
        return this.mLastVerticalBias;
    }

    public void setLastVerticalBias(float r1) {
        this.mLastVerticalBias = r1;
    }

    public float getHorizontalBias() {
        return this.mHorizontalBias;
    }

    public float getFirstHorizontalBias() {
        return this.mFirstHorizontalBias;
    }

    public void setFirstHorizontalBias(float r1) {
        this.mFirstHorizontalBias = r1;
    }

    public float getLastHorizontalBias() {
        return this.mLastHorizontalBias;
    }

    public void setLastHorizontalBias(float r1) {
        this.mLastHorizontalBias = r1;
    }

    @Override // com.obric.oui.constraintlayout.core.state.HelperReference
    public HelperWidget getHelperWidget() {
        if (this.mFlow != null) goto L6;
        this.mFlow = new Flow();
    L6:
        return this.mFlow;
    }

    @Override // com.obric.oui.constraintlayout.core.state.HelperReference
    public void setHelperWidget(HelperWidget r2) {
        if ((r2 instanceof Flow) == false) goto L5;
        this.mFlow = (Flow) r2;
        return;
    L5:
        this.mFlow = null;
    }

    @Override // com.obric.oui.constraintlayout.core.state.HelperReference, com.obric.oui.constraintlayout.core.state.ConstraintReference, com.obric.oui.constraintlayout.core.state.Reference
    public void apply() {
        getHelperWidget();
        setConstraintWidget(this.mFlow);
        this.mFlow.setOrientation(this.mOrientation);
        this.mFlow.setWrapMode(this.mWrapMode);
        int r0 = this.mMaxElementsWrap;
        if (r0 == (-1)) goto L5;
        this.mFlow.setMaxElementsWrap(r0);
    L5:
        int r1 = this.mPaddingLeft;
        if (r1 == 0) goto L8;
        this.mFlow.setPaddingLeft(r1);
    L8:
        int r2 = this.mPaddingTop;
        if (r2 == 0) goto L11;
        this.mFlow.setPaddingTop(r2);
    L11:
        int r3 = this.mPaddingRight;
        if (r3 == 0) goto L14;
        this.mFlow.setPaddingRight(r3);
    L14:
        int r4 = this.mPaddingBottom;
        if (r4 == 0) goto L17;
        this.mFlow.setPaddingBottom(r4);
    L17:
        int r5 = this.mHorizontalGap;
        if (r5 == 0) goto L20;
        this.mFlow.setHorizontalGap(r5);
    L20:
        int r6 = this.mVerticalGap;
        if (r6 == 0) goto L24;
        this.mFlow.setVerticalGap(r6);
    L24:
        if (this.mHorizontalBias == 0.5f) goto L26;
        this.mFlow.setHorizontalBias(this.mHorizontalBias);
    L26:
        float r7 = this.mFirstHorizontalBias;
        if (r7 == 0.5f) goto L29;
        this.mFlow.setFirstHorizontalBias(r7);
    L29:
        float r8 = this.mLastHorizontalBias;
        if (r8 == 0.5f) goto L33;
        this.mFlow.setLastHorizontalBias(r8);
    L33:
        if (this.mVerticalBias == 0.5f) goto L35;
        this.mFlow.setVerticalBias(this.mVerticalBias);
    L35:
        float r9 = this.mFirstVerticalBias;
        if (r9 == 0.5f) goto L38;
        this.mFlow.setFirstVerticalBias(r9);
    L38:
        float r10 = this.mLastVerticalBias;
        if (r10 == 0.5f) goto L41;
        this.mFlow.setLastVerticalBias(r10);
    L41:
        int r11 = this.mHorizontalAlign;
        if (r11 == 2) goto L44;
        this.mFlow.setHorizontalAlign(r11);
    L44:
        int r12 = this.mVerticalAlign;
        if (r12 == 2) goto L47;
        this.mFlow.setVerticalAlign(r12);
    L47:
        int r13 = this.mVerticalStyle;
        if (r13 == (-1)) goto L50;
        this.mFlow.setVerticalStyle(r13);
    L50:
        int r14 = this.mFirstVerticalStyle;
        if (r14 == (-1)) goto L53;
        this.mFlow.setFirstVerticalStyle(r14);
    L53:
        int r15 = this.mLastVerticalStyle;
        if (r15 == (-1)) goto L56;
        this.mFlow.setLastVerticalStyle(r15);
    L56:
        int r16 = this.mHorizontalStyle;
        if (r16 == (-1)) goto L59;
        this.mFlow.setHorizontalStyle(r16);
    L59:
        int r17 = this.mFirstHorizontalStyle;
        if (r17 == (-1)) goto L62;
        this.mFlow.setFirstHorizontalStyle(r17);
    L62:
        int r18 = this.mLastHorizontalStyle;
        if (r18 == (-1)) goto L65;
        this.mFlow.setLastHorizontalStyle(r18);
    L65:
        applyBase();
    }
}
