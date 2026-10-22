package com.obric.oui.constraintlayout.core.dsl;

import com.bytedance.apm.constant.TraceStatsConsts;

/* JADX INFO: loaded from: classes4.dex */
public class HChain extends Chain {
    private HAnchor mEnd;
    private HAnchor mLeft;
    private HAnchor mRight;
    private HAnchor mStart;

    public class HAnchor extends Chain.Anchor {
        final /* synthetic */ HChain this$0;

        HAnchor(HChain r1, Constraint.HSide r2) {
            this.this$0 = r1;
            super(r1, Constraint.Side.valueOf(r2.name()));
        }
    }

    public HChain(String r3) {
        super(r3);
        this.mLeft = new HAnchor(this, Constraint.HSide.LEFT);
        this.mRight = new HAnchor(this, Constraint.HSide.RIGHT);
        this.mStart = new HAnchor(this, Constraint.HSide.START);
        this.mEnd = new HAnchor(this, Constraint.HSide.END);
        this.type = new Helper.HelperType(typeMap.get(Helper.Type.HORIZONTAL_CHAIN));
    }

    public HChain(String r2, String r3) {
        super(r2);
        this.mLeft = new HAnchor(this, Constraint.HSide.LEFT);
        this.mRight = new HAnchor(this, Constraint.HSide.RIGHT);
        this.mStart = new HAnchor(this, Constraint.HSide.START);
        this.mEnd = new HAnchor(this, Constraint.HSide.END);
        this.config = r3;
        this.type = new Helper.HelperType(typeMap.get(Helper.Type.HORIZONTAL_CHAIN));
        this.configMap = convertConfigToMap();
        if (this.configMap.containsKey("contains") == false) goto L6;
        Ref.addStringToReferences(this.configMap.get("contains"), this.references);
        return;
    }

    public HAnchor getLeft() {
        return this.mLeft;
    }

    public void linkToLeft(Constraint.HAnchor r2) {
        linkToLeft(r2, 0);
    }

    public void linkToLeft(Constraint.HAnchor r2, int r3) {
        linkToLeft(r2, r3, Integer.MIN_VALUE);
    }

    public void linkToLeft(Constraint.HAnchor r2, int r3, int r4) {
        this.mLeft.mConnection = r2;
        this.mLeft.mMargin = r3;
        this.mLeft.mGoneMargin = r4;
        this.configMap.put("left", this.mLeft.toString());
    }

    public HAnchor getRight() {
        return this.mRight;
    }

    public void linkToRight(Constraint.HAnchor r2) {
        linkToRight(r2, 0);
    }

    public void linkToRight(Constraint.HAnchor r2, int r3) {
        linkToRight(r2, r3, Integer.MIN_VALUE);
    }

    public void linkToRight(Constraint.HAnchor r2, int r3, int r4) {
        this.mRight.mConnection = r2;
        this.mRight.mMargin = r3;
        this.mRight.mGoneMargin = r4;
        this.configMap.put("right", this.mRight.toString());
    }

    public HAnchor getStart() {
        return this.mStart;
    }

    public void linkToStart(Constraint.HAnchor r2) {
        linkToStart(r2, 0);
    }

    public void linkToStart(Constraint.HAnchor r2, int r3) {
        linkToStart(r2, r3, Integer.MIN_VALUE);
    }

    public void linkToStart(Constraint.HAnchor r2, int r3, int r4) {
        this.mStart.mConnection = r2;
        this.mStart.mMargin = r3;
        this.mStart.mGoneMargin = r4;
        this.configMap.put("start", this.mStart.toString());
    }

    public HAnchor getEnd() {
        return this.mEnd;
    }

    public void linkToEnd(Constraint.HAnchor r2) {
        linkToEnd(r2, 0);
    }

    public void linkToEnd(Constraint.HAnchor r2, int r3) {
        linkToEnd(r2, r3, Integer.MIN_VALUE);
    }

    public void linkToEnd(Constraint.HAnchor r2, int r3, int r4) {
        this.mEnd.mConnection = r2;
        this.mEnd.mMargin = r3;
        this.mEnd.mGoneMargin = r4;
        this.configMap.put(TraceStatsConsts.STATS_KEY_END, this.mEnd.toString());
    }
}
