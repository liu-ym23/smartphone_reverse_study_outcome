package androidx.constraintlayout.widget;

import a.a;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.apm.constant.TraceStatsConsts;

/* JADX INFO: loaded from: classes.dex */
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

    public ConstraintProperties(View r3) {
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if ((r0 instanceof ConstraintLayout.LayoutParams) == false) goto L7;
        this.mParams = (ConstraintLayout.LayoutParams) r0;
        this.mView = r3;
        return;
    L7:
        throw new RuntimeException("Only children of ConstraintLayout.LayoutParams supported");
    }

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

    public ConstraintProperties alpha(float r2) {
        this.mView.setAlpha(r2);
        return this;
    }

    public void apply() {
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

    public ConstraintProperties connect(int r10, int r11, int r12, int r13) {
        switch(r10) {
            case 1: goto L51;
            case 2: goto L44;
            case 3: goto L37;
            case 4: goto L30;
            case 5: goto L21;
            case 6: goto L13;
            case 7: goto L6;
            default: goto L4;
        };
    L4:
        StringBuilder r14 = new StringBuilder();
        r14.append(sideToString(r10));
        r14.append(" to ");
        throw new IllegalArgumentException(a.o(r14, sideToString(r12), " unknown"));
    L6:
        if (r12 != 7) goto L8;
        ConstraintLayout.LayoutParams r15 = this.mParams;
        r15.endToEnd = r11;
        r15.endToStart = -1;
    L10:
        this.mParams.setMarginEnd(r13);
    L56:
        return this;
    L8:
        if (r12 != 6) goto L12;
        ConstraintLayout.LayoutParams r16 = this.mParams;
        r16.endToStart = r11;
        r16.endToEnd = -1;
        goto L10
    L12:
        throw new IllegalArgumentException(a.o(new StringBuilder("right to "), sideToString(r12), " undefined"));
    L13:
        if (r12 != 6) goto L15;
        ConstraintLayout.LayoutParams r17 = this.mParams;
        r17.startToStart = r11;
        r17.startToEnd = -1;
    L17:
        this.mParams.setMarginStart(r13);
        goto L56
    L15:
        if (r12 != 7) goto L19;
        ConstraintLayout.LayoutParams r18 = this.mParams;
        r18.startToEnd = r11;
        r18.startToStart = -1;
        goto L17
    L19:
        throw new IllegalArgumentException(a.o(new StringBuilder("right to "), sideToString(r12), " undefined"));
    L30:
        if (r12 != 4) goto L32;
        ConstraintLayout.LayoutParams r19 = this.mParams;
        r19.bottomToBottom = r11;
        r19.bottomToTop = -1;
        r19.baselineToBaseline = -1;
        r19.baselineToTop = -1;
        r19.baselineToBottom = -1;
    L34:
        ((ViewGroup.MarginLayoutParams) this.mParams).bottomMargin = r13;
        goto L56
    L32:
        if (r12 != 3) goto L36;
        ConstraintLayout.LayoutParams r110 = this.mParams;
        r110.bottomToTop = r11;
        r110.bottomToBottom = -1;
        r110.baselineToBaseline = -1;
        r110.baselineToTop = -1;
        r110.baselineToBottom = -1;
        goto L34
    L36:
        throw new IllegalArgumentException(a.o(new StringBuilder("right to "), sideToString(r12), " undefined"));
    L37:
        if (r12 != 3) goto L39;
        ConstraintLayout.LayoutParams r111 = this.mParams;
        r111.topToTop = r11;
        r111.topToBottom = -1;
        r111.baselineToBaseline = -1;
        r111.baselineToTop = -1;
        r111.baselineToBottom = -1;
    L41:
        ((ViewGroup.MarginLayoutParams) this.mParams).topMargin = r13;
        goto L56
    L39:
        if (r12 != 4) goto L43;
        ConstraintLayout.LayoutParams r112 = this.mParams;
        r112.topToBottom = r11;
        r112.topToTop = -1;
        r112.baselineToBaseline = -1;
        r112.baselineToTop = -1;
        r112.baselineToBottom = -1;
        goto L41
    L43:
        throw new IllegalArgumentException(a.o(new StringBuilder("right to "), sideToString(r12), " undefined"));
    L44:
        if (r12 != 1) goto L46;
        ConstraintLayout.LayoutParams r113 = this.mParams;
        r113.rightToLeft = r11;
        r113.rightToRight = -1;
    L48:
        ((ViewGroup.MarginLayoutParams) this.mParams).rightMargin = r13;
        goto L56
    L46:
        if (r12 != 2) goto L50;
        ConstraintLayout.LayoutParams r114 = this.mParams;
        r114.rightToRight = r11;
        r114.rightToLeft = -1;
        goto L48
    L50:
        throw new IllegalArgumentException(a.o(new StringBuilder("right to "), sideToString(r12), " undefined"));
    L51:
        if (r12 != 1) goto L53;
        ConstraintLayout.LayoutParams r115 = this.mParams;
        r115.leftToLeft = r11;
        r115.leftToRight = -1;
    L55:
        ((ViewGroup.MarginLayoutParams) this.mParams).leftMargin = r13;
        goto L56
    L53:
        if (r12 != 2) goto L58;
        ConstraintLayout.LayoutParams r116 = this.mParams;
        r116.leftToRight = r11;
        r116.leftToLeft = -1;
        goto L55
    L58:
        throw new IllegalArgumentException(a.o(new StringBuilder("Left to "), sideToString(r12), " undefined"));
    L21:
        if (r12 != 5) goto L23;
        ConstraintLayout.LayoutParams r117 = this.mParams;
        r117.baselineToBaseline = r11;
        r117.bottomToBottom = -1;
        r117.bottomToTop = -1;
        r117.topToTop = -1;
        r117.topToBottom = -1;
    L23:
        if (r12 != 3) goto L25;
        ConstraintLayout.LayoutParams r118 = this.mParams;
        r118.baselineToTop = r11;
        r118.bottomToBottom = -1;
        r118.bottomToTop = -1;
        r118.topToTop = -1;
        r118.topToBottom = -1;
    L27:
        this.mParams.baselineMargin = r13;
        goto L56
    L25:
        if (r12 != 4) goto L29;
        ConstraintLayout.LayoutParams r119 = this.mParams;
        r119.baselineToBottom = r11;
        r119.bottomToBottom = -1;
        r119.bottomToTop = -1;
        r119.topToTop = -1;
        r119.topToBottom = -1;
        goto L27
    L29:
        throw new IllegalArgumentException(a.o(new StringBuilder("right to "), sideToString(r12), " undefined"));
    }

    public ConstraintProperties constrainDefaultHeight(int r2) {
        this.mParams.matchConstraintDefaultHeight = r2;
        return this;
    }

    public ConstraintProperties constrainDefaultWidth(int r2) {
        this.mParams.matchConstraintDefaultWidth = r2;
        return this;
    }

    public ConstraintProperties constrainHeight(int r2) {
        ((ViewGroup.MarginLayoutParams) this.mParams).height = r2;
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

    public ConstraintProperties constrainWidth(int r2) {
        ((ViewGroup.MarginLayoutParams) this.mParams).width = r2;
        return this;
    }

    public ConstraintProperties dimensionRatio(String r2) {
        this.mParams.dimensionRatio = r2;
        return this;
    }

    public ConstraintProperties elevation(float r2) {
        this.mView.setElevation(r2);
        return this;
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

    public ConstraintProperties horizontalChainStyle(int r2) {
        this.mParams.horizontalChainStyle = r2;
        return this;
    }

    public ConstraintProperties horizontalWeight(float r2) {
        this.mParams.horizontalWeight = r2;
        return this;
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
        ((ViewGroup.MarginLayoutParams) this.mParams).bottomMargin = r2;
        goto L13
    L10:
        ((ViewGroup.MarginLayoutParams) this.mParams).topMargin = r2;
        goto L13
    L11:
        ((ViewGroup.MarginLayoutParams) this.mParams).rightMargin = r2;
        goto L13
    L12:
        ((ViewGroup.MarginLayoutParams) this.mParams).leftMargin = r2;
        goto L13
    L4:
        throw new IllegalArgumentException("unknown constraint");
    L8:
        throw new IllegalArgumentException("baseline does not support margins");
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
        ConstraintLayout.LayoutParams r4 = this.mParams;
        r4.endToStart = -1;
        r4.endToEnd = -1;
        r4.setMarginEnd(-1);
        this.mParams.goneEndMargin = Integer.MIN_VALUE;
    L13:
        return this;
    L7:
        ConstraintLayout.LayoutParams r5 = this.mParams;
        r5.startToEnd = -1;
        r5.startToStart = -1;
        r5.setMarginStart(-1);
        this.mParams.goneStartMargin = Integer.MIN_VALUE;
        goto L13
    L8:
        this.mParams.baselineToBaseline = -1;
        goto L13
    L9:
        ConstraintLayout.LayoutParams r6 = this.mParams;
        r6.bottomToTop = -1;
        r6.bottomToBottom = -1;
        ((ViewGroup.MarginLayoutParams) r6).bottomMargin = -1;
        r6.goneBottomMargin = Integer.MIN_VALUE;
        goto L13
    L10:
        ConstraintLayout.LayoutParams r7 = this.mParams;
        r7.topToBottom = -1;
        r7.topToTop = -1;
        ((ViewGroup.MarginLayoutParams) r7).topMargin = -1;
        r7.goneTopMargin = Integer.MIN_VALUE;
        goto L13
    L11:
        ConstraintLayout.LayoutParams r8 = this.mParams;
        r8.rightToRight = -1;
        r8.rightToLeft = -1;
        ((ViewGroup.MarginLayoutParams) r8).rightMargin = -1;
        r8.goneRightMargin = Integer.MIN_VALUE;
        goto L13
    L12:
        ConstraintLayout.LayoutParams r9 = this.mParams;
        r9.leftToRight = -1;
        r9.leftToLeft = -1;
        ((ViewGroup.MarginLayoutParams) r9).leftMargin = -1;
        r9.goneLeftMargin = Integer.MIN_VALUE;
        goto L13
    L5:
        throw new IllegalArgumentException("unknown constraint");
    }

    public ConstraintProperties removeFromHorizontalChain() {
        ConstraintLayout.LayoutParams r0 = this.mParams;
        int r1 = r0.leftToRight;
        int r2 = r0.rightToLeft;
        if (r1 != (-1)) goto L22;
        if (r2 != (-1)) goto L22;
        int r3 = r0.startToEnd;
        int r4 = r0.endToStart;
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
        r9.connect(6, r1, 7, 0);
    L13:
        if (r1 != (-1)) goto L15;
        if (r4 == (-1)) goto L21;
    L15:
        int r5 = r7.rightToRight;
        if (r5 == (-1)) goto L18;
        r8.connect(7, r5, 7, 0);
        goto L21
    L18:
        int r6 = r7.leftToLeft;
        if (r6 == (-1)) goto L21;
        r9.connect(6, r6, 6, 0);
    L22:
        ConstraintProperties r10 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r1));
        ConstraintProperties r11 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r2));
        ConstraintLayout.LayoutParams r12 = this.mParams;
        if (r1 == (-1)) goto L26;
        if (r2 == (-1)) goto L26;
        r10.connect(2, r2, 1, 0);
        r11.connect(1, r1, 2, 0);
    L34:
        removeConstraints(1);
        removeConstraints(2);
    L26:
        if (r1 != (-1)) goto L28;
        if (r2 == (-1)) goto L34;
    L28:
        int r13 = r12.rightToRight;
        if (r13 == (-1)) goto L31;
        r10.connect(2, r13, 2, 0);
        goto L34
    L31:
        int r14 = r12.leftToLeft;
        if (r14 == (-1)) goto L34;
        r11.connect(1, r14, 1, 0);
        goto L34
    }

    public ConstraintProperties removeFromVerticalChain() {
        ConstraintLayout.LayoutParams r0 = this.mParams;
        int r1 = r0.topToBottom;
        int r2 = r0.bottomToTop;
        if (r1 != (-1)) goto L5;
        if (r2 != (-1)) goto L5;
    L17:
        removeConstraints(3);
        removeConstraints(4);
        return this;
    L5:
        ConstraintProperties r6 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r1));
        ConstraintProperties r7 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r2));
        ConstraintLayout.LayoutParams r5 = this.mParams;
        if (r1 == (-1)) goto L9;
        if (r2 == (-1)) goto L9;
        r6.connect(4, r2, 3, 0);
        r7.connect(3, r1, 4, 0);
    L9:
        if (r1 != (-1)) goto L11;
        if (r2 == (-1)) goto L17;
    L11:
        int r3 = r5.bottomToBottom;
        if (r3 == (-1)) goto L14;
        r6.connect(4, r3, 4, 0);
        goto L17
    L14:
        int r4 = r5.topToTop;
        if (r4 == (-1)) goto L17;
        r7.connect(3, r4, 3, 0);
        goto L17
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

    public ConstraintProperties scaleY(float r1) {
        return this;
    }

    public ConstraintProperties transformPivot(float r2, float r3) {
        this.mView.setPivotX(r2);
        this.mView.setPivotY(r3);
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

    public ConstraintProperties translation(float r2, float r3) {
        this.mView.setTranslationX(r2);
        this.mView.setTranslationY(r3);
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

    public ConstraintProperties translationZ(float r2) {
        this.mView.setTranslationZ(r2);
        return this;
    }

    public ConstraintProperties verticalBias(float r2) {
        this.mParams.verticalBias = r2;
        return this;
    }

    public ConstraintProperties verticalChainStyle(int r2) {
        this.mParams.verticalChainStyle = r2;
        return this;
    }

    public ConstraintProperties verticalWeight(float r2) {
        this.mParams.verticalWeight = r2;
        return this;
    }

    public ConstraintProperties visibility(int r2) {
        this.mView.setVisibility(r2);
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
}
