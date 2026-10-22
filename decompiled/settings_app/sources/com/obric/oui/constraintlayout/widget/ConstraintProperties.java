package com.obric.oui.constraintlayout.widget;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.apm.constant.TraceStatsConsts;

/* JADX INFO: loaded from: classes4.dex */
public class ConstraintProperties {
    public static final int BASELINE = 5;
    public static final int BOTTOM = 4;
    public static final int END = 7;
    public static final int LEFT = 1;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int PARENT_ID = 0;
    public static final int RIGHT = 2;
    public static final int START = 6;
    public static final int TOP = 3;
    public static final int UNSET = -1;
    public static final int WRAP_CONTENT = -2;
    ConstraintLayout.LayoutParams mParams;
    View mView;

    private String sideToString(int r1) {
        switch(r1) {
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            case 7: goto L5;
            default: goto L3;
        };
    L3:
        return "undefined";
    L5:
        return TraceStatsConsts.STATS_KEY_END;
    L7:
        return "start";
    L9:
        return "baseline";
    L11:
        return "bottom";
    L13:
        return "top";
    L15:
        return "right";
    L17:
        return "left";
    }

    public void apply() {
    }

    public ConstraintProperties scaleY(float r1) {
        return this;
    }

    public ConstraintProperties center(int r3, int r4, int r5, int r6, int r7, int r8, float r9) {
        if (r5 < 0) goto L26;
        if (r8 < 0) goto L24;
        if (r9 <= 0.0f) goto L22;
        if (r9 > 1.0f) goto L22;
        if (r4 == 1) goto L19;
        if (r4 == 2) goto L19;
        if (r4 == 6) goto L18;
        if (r4 == 7) goto L18;
        connect(3, r3, r4, r5);
        connect(4, r6, r7, r8);
        this.mParams.verticalBias = r9;
    L20:
        return this;
    L18:
        connect(6, r3, r4, r5);
        connect(7, r6, r7, r8);
        this.mParams.horizontalBias = r9;
    L19:
        connect(1, r3, r4, r5);
        connect(2, r6, r7, r8);
        this.mParams.horizontalBias = r9;
    L22:
        throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
    L24:
        throw new IllegalArgumentException("margin must be > 0");
    L26:
        throw new IllegalArgumentException("margin must be > 0");
    }

    public ConstraintProperties centerHorizontally(int r2, int r3, int r4, int r5, int r6, int r7, float r8) {
        connect(1, r2, r3, r4);
        connect(2, r5, r6, r7);
        this.mParams.horizontalBias = r8;
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int r2, int r3, int r4, int r5, int r6, int r7, float r8) {
        connect(6, r2, r3, r4);
        connect(7, r5, r6, r7);
        this.mParams.horizontalBias = r8;
        return this;
    }

    public ConstraintProperties centerVertically(int r2, int r3, int r4, int r5, int r6, int r7, float r8) {
        connect(3, r2, r3, r4);
        connect(4, r5, r6, r7);
        this.mParams.verticalBias = r8;
        return this;
    }

    public ConstraintProperties centerHorizontally(int r9) {
        if (r9 != 0) goto L4;
        center(0, 1, 0, 0, 2, 0, 0.5f);
    L5:
        return this;
    L4:
        center(r9, 2, 0, r9, 1, 0, 0.5f);
        goto L5
    }

    public ConstraintProperties centerHorizontallyRtl(int r9) {
        if (r9 != 0) goto L4;
        center(0, 6, 0, 0, 7, 0, 0.5f);
    L5:
        return this;
    L4:
        center(r9, 7, 0, r9, 6, 0, 0.5f);
        goto L5
    }

    public ConstraintProperties centerVertically(int r9) {
        if (r9 != 0) goto L4;
        center(0, 3, 0, 0, 4, 0, 0.5f);
    L5:
        return this;
    L4:
        center(r9, 4, 0, r9, 3, 0, 0.5f);
        goto L5
    }

    public ConstraintProperties removeConstraints(int r3) {
        switch(r3) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        this.mParams.endToStart = -1;
        this.mParams.endToEnd = -1;
        this.mParams.setMarginEnd(-1);
        this.mParams.goneEndMargin = Integer.MIN_VALUE;
    L13:
        return this;
    L7:
        this.mParams.startToEnd = -1;
        this.mParams.startToStart = -1;
        this.mParams.setMarginStart(-1);
        this.mParams.goneStartMargin = Integer.MIN_VALUE;
        goto L13
    L8:
        this.mParams.baselineToBaseline = -1;
        goto L13
    L9:
        this.mParams.bottomToTop = -1;
        this.mParams.bottomToBottom = -1;
        this.mParams.bottomMargin = -1;
        this.mParams.goneBottomMargin = Integer.MIN_VALUE;
        goto L13
    L10:
        this.mParams.topToBottom = -1;
        this.mParams.topToTop = -1;
        this.mParams.topMargin = -1;
        this.mParams.goneTopMargin = Integer.MIN_VALUE;
        goto L13
    L11:
        this.mParams.rightToRight = -1;
        this.mParams.rightToLeft = -1;
        this.mParams.rightMargin = -1;
        this.mParams.goneRightMargin = Integer.MIN_VALUE;
        goto L13
    L12:
        this.mParams.leftToRight = -1;
        this.mParams.leftToLeft = -1;
        this.mParams.leftMargin = -1;
        this.mParams.goneLeftMargin = Integer.MIN_VALUE;
        goto L13
    L5:
        throw new IllegalArgumentException("unknown constraint");
    }

    public ConstraintProperties margin(int r1, int r2) {
        switch(r1) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L5:
        this.mParams.setMarginEnd(r2);
    L13:
        return this;
    L6:
        this.mParams.setMarginStart(r2);
        goto L13
    L9:
        this.mParams.bottomMargin = r2;
        goto L13
    L10:
        this.mParams.topMargin = r2;
        goto L13
    L11:
        this.mParams.rightMargin = r2;
        goto L13
    L12:
        this.mParams.leftMargin = r2;
        goto L13
    L4:
        throw new IllegalArgumentException("unknown constraint");
    L8:
        throw new IllegalArgumentException("baseline does not support margins");
    }

    public ConstraintProperties goneMargin(int r1, int r2) {
        switch(r1) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L5:
        this.mParams.goneEndMargin = r2;
    L13:
        return this;
    L6:
        this.mParams.goneStartMargin = r2;
        goto L13
    L9:
        this.mParams.goneBottomMargin = r2;
        goto L13
    L10:
        this.mParams.goneTopMargin = r2;
        goto L13
    L11:
        this.mParams.goneRightMargin = r2;
        goto L13
    L12:
        this.mParams.goneLeftMargin = r2;
        goto L13
    L4:
        throw new IllegalArgumentException("unknown constraint");
    L8:
        throw new IllegalArgumentException("baseline does not support margins");
    }

    public ConstraintProperties horizontalBias(float r2) {
        this.mParams.horizontalBias = r2;
        return this;
    }

    public ConstraintProperties verticalBias(float r2) {
        this.mParams.verticalBias = r2;
        return this;
    }

    public ConstraintProperties dimensionRatio(String r2) {
        this.mParams.dimensionRatio = r2;
        return this;
    }

    public ConstraintProperties visibility(int r2) {
        this.mView.setVisibility(r2);
        return this;
    }

    public ConstraintProperties alpha(float r2) {
        this.mView.setAlpha(r2);
        return this;
    }

    public ConstraintProperties elevation(float r2) {
        this.mView.setElevation(r2);
        return this;
    }

    public ConstraintProperties rotation(float r2) {
        this.mView.setRotation(r2);
        return this;
    }

    public ConstraintProperties rotationX(float r2) {
        this.mView.setRotationX(r2);
        return this;
    }

    public ConstraintProperties rotationY(float r2) {
        this.mView.setRotationY(r2);
        return this;
    }

    public ConstraintProperties scaleX(float r2) {
        this.mView.setScaleY(r2);
        return this;
    }

    public ConstraintProperties transformPivotX(float r2) {
        this.mView.setPivotX(r2);
        return this;
    }

    public ConstraintProperties transformPivotY(float r2) {
        this.mView.setPivotY(r2);
        return this;
    }

    public ConstraintProperties transformPivot(float r2, float r3) {
        this.mView.setPivotX(r2);
        this.mView.setPivotY(r3);
        return this;
    }

    public ConstraintProperties translationX(float r2) {
        this.mView.setTranslationX(r2);
        return this;
    }

    public ConstraintProperties translationY(float r2) {
        this.mView.setTranslationY(r2);
        return this;
    }

    public ConstraintProperties translation(float r2, float r3) {
        this.mView.setTranslationX(r2);
        this.mView.setTranslationY(r3);
        return this;
    }

    public ConstraintProperties translationZ(float r2) {
        this.mView.setTranslationZ(r2);
        return this;
    }

    public ConstraintProperties constrainHeight(int r2) {
        this.mParams.height = r2;
        return this;
    }

    public ConstraintProperties constrainWidth(int r2) {
        this.mParams.width = r2;
        return this;
    }

    public ConstraintProperties constrainMaxHeight(int r2) {
        this.mParams.matchConstraintMaxHeight = r2;
        return this;
    }

    public ConstraintProperties constrainMaxWidth(int r2) {
        this.mParams.matchConstraintMaxWidth = r2;
        return this;
    }

    public ConstraintProperties constrainMinHeight(int r2) {
        this.mParams.matchConstraintMinHeight = r2;
        return this;
    }

    public ConstraintProperties constrainMinWidth(int r2) {
        this.mParams.matchConstraintMinWidth = r2;
        return this;
    }

    public ConstraintProperties constrainDefaultHeight(int r2) {
        this.mParams.matchConstraintDefaultHeight = r2;
        return this;
    }

    public ConstraintProperties constrainDefaultWidth(int r2) {
        this.mParams.matchConstraintDefaultWidth = r2;
        return this;
    }

    public ConstraintProperties horizontalWeight(float r2) {
        this.mParams.horizontalWeight = r2;
        return this;
    }

    public ConstraintProperties verticalWeight(float r2) {
        this.mParams.verticalWeight = r2;
        return this;
    }

    public ConstraintProperties horizontalChainStyle(int r2) {
        this.mParams.horizontalChainStyle = r2;
        return this;
    }

    public ConstraintProperties verticalChainStyle(int r2) {
        this.mParams.verticalChainStyle = r2;
        return this;
    }

    public ConstraintProperties addToHorizontalChain(int r5, int r6) {
        if (r5 != 0) goto L5;
        int r2 = 1;
    L6:
        connect(1, r5, r2, 0);
        if (r6 != 0) goto L9;
        int r3 = 2;
    L10:
        connect(2, r6, r3, 0);
        if (r5 == 0) goto L13;
        new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r5)).connect(2, this.mView.getId(), 1, 0);
    L13:
        if (r6 == 0) goto L15;
        new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r6)).connect(1, this.mView.getId(), 2, 0);
    L15:
        return this;
    L9:
        r3 = 1;
        goto L10
    L5:
        r2 = 2;
        goto L6
    }

    public ConstraintProperties addToHorizontalChainRTL(int r5, int r6) {
        if (r5 != 0) goto L5;
        int r2 = 6;
    L6:
        connect(6, r5, r2, 0);
        if (r6 != 0) goto L9;
        int r3 = 7;
    L10:
        connect(7, r6, r3, 0);
        if (r5 == 0) goto L13;
        new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r5)).connect(7, this.mView.getId(), 6, 0);
    L13:
        if (r6 == 0) goto L15;
        new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r6)).connect(6, this.mView.getId(), 7, 0);
    L15:
        return this;
    L9:
        r3 = 6;
        goto L10
    L5:
        r2 = 7;
        goto L6
    }

    public ConstraintProperties addToVerticalChain(int r5, int r6) {
        if (r5 != 0) goto L5;
        int r2 = 3;
    L6:
        connect(3, r5, r2, 0);
        if (r6 != 0) goto L9;
        int r3 = 4;
    L10:
        connect(4, r6, r3, 0);
        if (r5 == 0) goto L13;
        new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r5)).connect(4, this.mView.getId(), 3, 0);
    L13:
        if (r6 == 0) goto L15;
        new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r6)).connect(3, this.mView.getId(), 4, 0);
    L15:
        return this;
    L9:
        r3 = 3;
        goto L10
    L5:
        r2 = 4;
        goto L6
    }

    public ConstraintProperties removeFromVerticalChain() {
        int r0 = this.mParams.topToBottom;
        int r1 = this.mParams.bottomToTop;
        if (r0 != (-1)) goto L5;
        if (r1 != (-1)) goto L5;
    L17:
        removeConstraints(3);
        removeConstraints(4);
        return this;
    L5:
        ConstraintProperties r6 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r0));
        ConstraintProperties r7 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r1));
        ConstraintLayout.LayoutParams r5 = this.mParams;
        if (r0 == (-1)) goto L9;
        if (r1 == (-1)) goto L9;
        r6.connect(4, r1, 3, 0);
        r7.connect(3, r0, 4, 0);
    L9:
        if (r0 != (-1)) goto L11;
        if (r1 == (-1)) goto L17;
    L11:
        int r2 = r5.bottomToBottom;
        ConstraintLayout.LayoutParams r3 = this.mParams;
        if (r2 == (-1)) goto L14;
        r6.connect(4, r3.bottomToBottom, 4, 0);
        goto L17
    L14:
        int r4 = r3.topToTop;
        ConstraintLayout.LayoutParams r8 = this.mParams;
        if (r4 == (-1)) goto L17;
        r7.connect(3, r8.topToTop, 3, 0);
        goto L17
    }

    public ConstraintProperties removeFromHorizontalChain() {
        int r0 = this.mParams.leftToRight;
        int r1 = this.mParams.rightToLeft;
        ConstraintLayout.LayoutParams r2 = this.mParams;
        if (r0 != (-1)) goto L22;
        if (r1 != (-1)) goto L22;
        int r3 = r2.startToEnd;
        int r4 = this.mParams.endToStart;
        if (r3 != (-1)) goto L9;
        if (r4 != (-1)) goto L9;
    L21:
        removeConstraints(6);
        removeConstraints(7);
    L35:
        return this;
    L9:
        ConstraintProperties r8 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r3));
        ConstraintProperties r9 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r4));
        ConstraintLayout.LayoutParams r7 = this.mParams;
        if (r3 == (-1)) goto L13;
        if (r4 == (-1)) goto L13;
        r8.connect(7, r4, 6, 0);
        r9.connect(6, r0, 7, 0);
    L13:
        if (r0 != (-1)) goto L15;
        if (r4 == (-1)) goto L21;
    L15:
        int r5 = r7.rightToRight;
        ConstraintLayout.LayoutParams r6 = this.mParams;
        if (r5 == (-1)) goto L18;
        r8.connect(7, r6.rightToRight, 7, 0);
        goto L21
    L18:
        int r10 = r6.leftToLeft;
        ConstraintLayout.LayoutParams r11 = this.mParams;
        if (r10 == (-1)) goto L21;
        r9.connect(6, r11.leftToLeft, 6, 0);
    L22:
        ConstraintProperties r12 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r0));
        ConstraintProperties r13 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r1));
        ConstraintLayout.LayoutParams r14 = this.mParams;
        if (r0 == (-1)) goto L26;
        if (r1 == (-1)) goto L26;
        r12.connect(2, r1, 1, 0);
        r13.connect(1, r0, 2, 0);
    L34:
        removeConstraints(1);
        removeConstraints(2);
    L26:
        if (r0 != (-1)) goto L28;
        if (r1 == (-1)) goto L34;
    L28:
        int r15 = r14.rightToRight;
        ConstraintLayout.LayoutParams r16 = this.mParams;
        if (r15 == (-1)) goto L31;
        r12.connect(2, r16.rightToRight, 2, 0);
        goto L34
    L31:
        int r17 = r16.leftToLeft;
        ConstraintLayout.LayoutParams r18 = this.mParams;
        if (r17 == (-1)) goto L34;
        r13.connect(1, r18.leftToLeft, 1, 0);
        goto L34
    }

    public ConstraintProperties connect(int r10, int r11, int r12, int r13) {
        switch(r10) {
            case 1: goto L51;
            case 2: goto L44;
            case 3: goto L37;
            case 4: goto L30;
            case 5: goto L21;
            case 6: goto L13;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        if (r12 != 7) goto L8;
        this.mParams.endToEnd = r11;
        this.mParams.endToStart = -1;
    L10:
        this.mParams.setMarginEnd(r13);
    L56:
        return this;
    L8:
        if (r12 != 6) goto L12;
        this.mParams.endToStart = r11;
        this.mParams.endToEnd = -1;
        goto L10
    L12:
        throw new IllegalArgumentException("right to " + sideToString(r12) + " undefined");
    L13:
        if (r12 != 6) goto L15;
        this.mParams.startToStart = r11;
        this.mParams.startToEnd = -1;
    L17:
        this.mParams.setMarginStart(r13);
        goto L56
    L15:
        if (r12 != 7) goto L19;
        this.mParams.startToEnd = r11;
        this.mParams.startToStart = -1;
        goto L17
    L19:
        throw new IllegalArgumentException("right to " + sideToString(r12) + " undefined");
    L30:
        if (r12 != 4) goto L32;
        this.mParams.bottomToBottom = r11;
        this.mParams.bottomToTop = -1;
        this.mParams.baselineToBaseline = -1;
        this.mParams.baselineToTop = -1;
        this.mParams.baselineToBottom = -1;
    L34:
        this.mParams.bottomMargin = r13;
        goto L56
    L32:
        if (r12 != 3) goto L36;
        this.mParams.bottomToTop = r11;
        this.mParams.bottomToBottom = -1;
        this.mParams.baselineToBaseline = -1;
        this.mParams.baselineToTop = -1;
        this.mParams.baselineToBottom = -1;
        goto L34
    L36:
        throw new IllegalArgumentException("right to " + sideToString(r12) + " undefined");
    L37:
        if (r12 != 3) goto L39;
        this.mParams.topToTop = r11;
        this.mParams.topToBottom = -1;
        this.mParams.baselineToBaseline = -1;
        this.mParams.baselineToTop = -1;
        this.mParams.baselineToBottom = -1;
    L41:
        this.mParams.topMargin = r13;
        goto L56
    L39:
        if (r12 != 4) goto L43;
        this.mParams.topToBottom = r11;
        this.mParams.topToTop = -1;
        this.mParams.baselineToBaseline = -1;
        this.mParams.baselineToTop = -1;
        this.mParams.baselineToBottom = -1;
        goto L41
    L43:
        throw new IllegalArgumentException("right to " + sideToString(r12) + " undefined");
    L44:
        if (r12 != 1) goto L46;
        this.mParams.rightToLeft = r11;
        this.mParams.rightToRight = -1;
    L48:
        this.mParams.rightMargin = r13;
        goto L56
    L46:
        if (r12 != 2) goto L50;
        this.mParams.rightToRight = r11;
        this.mParams.rightToLeft = -1;
        goto L48
    L50:
        throw new IllegalArgumentException("right to " + sideToString(r12) + " undefined");
    L51:
        if (r12 != 1) goto L53;
        this.mParams.leftToLeft = r11;
        this.mParams.leftToRight = -1;
    L55:
        this.mParams.leftMargin = r13;
        goto L56
    L53:
        if (r12 != 2) goto L58;
        this.mParams.leftToRight = r11;
        this.mParams.leftToLeft = -1;
        goto L55
    L58:
        throw new IllegalArgumentException("Left to " + sideToString(r12) + " undefined");
    L5:
        throw new IllegalArgumentException(sideToString(r10) + " to " + sideToString(r12) + " unknown");
    L21:
        if (r12 != 5) goto L23;
        this.mParams.baselineToBaseline = r11;
        this.mParams.bottomToBottom = -1;
        this.mParams.bottomToTop = -1;
        this.mParams.topToTop = -1;
        this.mParams.topToBottom = -1;
    L27:
        this.mParams.baselineMargin = r13;
        goto L56
    L23:
        if (r12 != 3) goto L25;
        this.mParams.baselineToTop = r11;
        this.mParams.bottomToBottom = -1;
        this.mParams.bottomToTop = -1;
        this.mParams.topToTop = -1;
        this.mParams.topToBottom = -1;
        goto L27
    L25:
        if (r12 != 4) goto L29;
        this.mParams.baselineToBottom = r11;
        this.mParams.bottomToBottom = -1;
        this.mParams.bottomToTop = -1;
        this.mParams.topToTop = -1;
        this.mParams.topToBottom = -1;
        goto L27
    L29:
        throw new IllegalArgumentException("right to " + sideToString(r12) + " undefined");
    }

    public ConstraintProperties(View r3) {
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if ((r0 instanceof ConstraintLayout.LayoutParams) == false) goto L7;
        this.mParams = (ConstraintLayout.LayoutParams) r0;
        this.mView = r3;
        return;
    L7:
        throw new RuntimeException("Only children of ConstraintLayout.LayoutParams supported");
    }
}
