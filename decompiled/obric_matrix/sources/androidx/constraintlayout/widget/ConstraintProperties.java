package androidx.constraintlayout.widget;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

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
        return "end";
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
        if (r5 < 0) goto L25;
        if (r8 < 0) goto L23;
        if (r9 <= 0.0f) goto L21;
        if (r9 > 1.0f) goto L21;
        int r0 = 2;
        int r1 = 1;
        if (r4 == 1) goto L18;
        if (r4 == 2) goto L18;
        r0 = 7;
        r1 = 6;
        if (r4 == 6) goto L18;
        if (r4 == 7) goto L18;
        connect(3, r3, r4, r5);
        connect(4, r6, r7, r8);
        this.mParams.verticalBias = r9;
    L19:
        return this;
    L18:
        connect(r1, r3, r4, r5);
        connect(r0, r6, r7, r8);
        this.mParams.horizontalBias = r9;
    L21:
        throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
    L23:
        throw new IllegalArgumentException("margin must be > 0");
    L25:
        throw new IllegalArgumentException("margin must be > 0");
    }

    public ConstraintProperties centerHorizontally(int r9) {
        if (r9 != 0) goto L4;
        int r1 = 0;
        int r2 = 1;
        int r3 = 0;
        int r4 = 0;
        int r5 = 2;
        int r6 = 0;
        float r7 = 0.5f;
    L5:
        center(r1, r2, r3, r4, r5, r6, r7);
        return this;
    L4:
        r2 = 2;
        r3 = 0;
        r5 = 1;
        r6 = 0;
        r7 = 0.5f;
        r1 = r9;
        r4 = r9;
        goto L5
    }

    public ConstraintProperties centerHorizontally(int r2, int r3, int r4, int r5, int r6, int r7, float r8) {
        connect(1, r2, r3, r4);
        connect(2, r5, r6, r7);
        this.mParams.horizontalBias = r8;
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int r9) {
        if (r9 != 0) goto L4;
        int r1 = 0;
        int r2 = 6;
        int r3 = 0;
        int r4 = 0;
        int r5 = 7;
        int r6 = 0;
        float r7 = 0.5f;
    L5:
        center(r1, r2, r3, r4, r5, r6, r7);
        return this;
    L4:
        r2 = 7;
        r3 = 0;
        r5 = 6;
        r6 = 0;
        r7 = 0.5f;
        r1 = r9;
        r4 = r9;
        goto L5
    }

    public ConstraintProperties centerHorizontallyRtl(int r2, int r3, int r4, int r5, int r6, int r7, float r8) {
        connect(6, r2, r3, r4);
        connect(7, r5, r6, r7);
        this.mParams.horizontalBias = r8;
        return this;
    }

    public ConstraintProperties centerVertically(int r9) {
        if (r9 != 0) goto L4;
        int r1 = 0;
        int r2 = 3;
        int r3 = 0;
        int r4 = 0;
        int r5 = 4;
        int r6 = 0;
        float r7 = 0.5f;
    L5:
        center(r1, r2, r3, r4, r5, r6, r7);
        return this;
    L4:
        r2 = 4;
        r3 = 0;
        r5 = 3;
        r6 = 0;
        r7 = 0.5f;
        r1 = r9;
        r4 = r9;
        goto L5
    }

    public ConstraintProperties centerVertically(int r2, int r3, int r4, int r5, int r6, int r7, float r8) {
        connect(3, r2, r3, r4);
        connect(4, r5, r6, r7);
        this.mParams.verticalBias = r8;
        return this;
    }

    public ConstraintProperties connect(int r12, int r13, int r14, int r15) {
        int r0 = Build.VERSION.SDK_INT;
        switch(r12) {
            case 1: goto L56;
            case 2: goto L49;
            case 3: goto L41;
            case 4: goto L33;
            case 5: goto L23;
            case 6: goto L14;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        if (r14 != 7) goto L8;
        ConstraintLayout.LayoutParams r16 = this.mParams;
        r16.endToEnd = r13;
        r16.endToStart = -1;
    L10:
        if (r0 < 17) goto L61;
        this.mParams.setMarginEnd(r15);
    L61:
        return this;
    L8:
        if (r14 != 6) goto L13;
        ConstraintLayout.LayoutParams r17 = this.mParams;
        r17.endToStart = r13;
        r17.endToEnd = -1;
        goto L10
    L13:
        throw new IllegalArgumentException("right to " + sideToString(r14) + " undefined");
    L14:
        if (r14 != 6) goto L16;
        ConstraintLayout.LayoutParams r18 = this.mParams;
        r18.startToStart = r13;
        r18.startToEnd = -1;
    L18:
        if (r0 < 17) goto L61;
        this.mParams.setMarginStart(r15);
        goto L61
    L16:
        if (r14 != 7) goto L21;
        ConstraintLayout.LayoutParams r19 = this.mParams;
        r19.startToEnd = r13;
        r19.startToStart = -1;
        goto L18
    L21:
        throw new IllegalArgumentException("right to " + sideToString(r14) + " undefined");
    L33:
        if (r14 != 4) goto L36;
        ConstraintLayout.LayoutParams r110 = this.mParams;
        r110.bottomToBottom = r13;
        r110.bottomToTop = -1;
    L35:
        r110.baselineToBaseline = -1;
        r110.baselineToTop = -1;
        r110.baselineToBottom = -1;
        ((ViewGroup.MarginLayoutParams) this.mParams).bottomMargin = r15;
        goto L61
    L36:
        if (r14 != 3) goto L40;
        r110 = this.mParams;
        r110.bottomToTop = r13;
        r110.bottomToBottom = -1;
        goto L35
    L40:
        throw new IllegalArgumentException("right to " + sideToString(r14) + " undefined");
    L41:
        if (r14 != 3) goto L44;
        ConstraintLayout.LayoutParams r111 = this.mParams;
        r111.topToTop = r13;
        r111.topToBottom = -1;
    L43:
        r111.baselineToBaseline = -1;
        r111.baselineToTop = -1;
        r111.baselineToBottom = -1;
        ((ViewGroup.MarginLayoutParams) this.mParams).topMargin = r15;
        goto L61
    L44:
        if (r14 != 4) goto L48;
        r111 = this.mParams;
        r111.topToBottom = r13;
        r111.topToTop = -1;
        goto L43
    L48:
        throw new IllegalArgumentException("right to " + sideToString(r14) + " undefined");
    L49:
        if (r14 != 1) goto L51;
        ConstraintLayout.LayoutParams r112 = this.mParams;
        r112.rightToLeft = r13;
        r112.rightToRight = -1;
    L53:
        ((ViewGroup.MarginLayoutParams) this.mParams).rightMargin = r15;
        goto L61
    L51:
        if (r14 != 2) goto L55;
        ConstraintLayout.LayoutParams r113 = this.mParams;
        r113.rightToRight = r13;
        r113.rightToLeft = -1;
        goto L53
    L55:
        throw new IllegalArgumentException("right to " + sideToString(r14) + " undefined");
    L56:
        if (r14 != 1) goto L58;
        ConstraintLayout.LayoutParams r114 = this.mParams;
        r114.leftToLeft = r13;
        r114.leftToRight = -1;
    L60:
        ((ViewGroup.MarginLayoutParams) this.mParams).leftMargin = r15;
        goto L61
    L58:
        if (r14 != 2) goto L63;
        ConstraintLayout.LayoutParams r115 = this.mParams;
        r115.leftToRight = r13;
        r115.leftToLeft = -1;
        goto L60
    L63:
        throw new IllegalArgumentException("Left to " + sideToString(r14) + " undefined");
    L5:
        throw new IllegalArgumentException(sideToString(r12) + " to " + sideToString(r14) + " unknown");
    L23:
        if (r14 != 5) goto L25;
        ConstraintLayout.LayoutParams r116 = this.mParams;
        r116.baselineToBaseline = r13;
        r116.bottomToBottom = -1;
        r116.bottomToTop = -1;
        r116.topToTop = -1;
        r116.topToBottom = -1;
    L25:
        if (r14 != 3) goto L28;
        ConstraintLayout.LayoutParams r117 = this.mParams;
        r117.baselineToTop = r13;
    L27:
        r117.bottomToBottom = -1;
        r117.bottomToTop = -1;
        r117.topToTop = -1;
        r117.topToBottom = -1;
        this.mParams.baselineMargin = r15;
        goto L61
    L28:
        if (r14 != 4) goto L32;
        r117 = this.mParams;
        r117.baselineToBottom = r13;
        goto L27
    L32:
        throw new IllegalArgumentException("right to " + sideToString(r14) + " undefined");
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

    public ConstraintProperties elevation(float r3) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        this.mView.setElevation(r3);
    L5:
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

    public ConstraintProperties translationZ(float r3) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        this.mView.setTranslationZ(r3);
    L5:
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
}
