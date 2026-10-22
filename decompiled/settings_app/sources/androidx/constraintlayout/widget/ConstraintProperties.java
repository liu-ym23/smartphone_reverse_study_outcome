package androidx.constraintlayout.widget;

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

    private String sideToString(int side) {
        switch(side) {
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

    public ConstraintProperties scaleY(float scaleY) {
        return this;
    }

    public ConstraintProperties center(int firstID, int firstSide, int firstMargin, int secondId, int secondSide, int secondMargin, float bias) {
        if (firstMargin < 0) goto L26;
        if (secondMargin < 0) goto L24;
        if (bias <= 0.0f) goto L22;
        if (bias > 1.0f) goto L22;
        if (firstSide == 1) goto L19;
        if (firstSide == 2) goto L19;
        if (firstSide == 6) goto L18;
        if (firstSide == 7) goto L18;
        connect(3, firstID, firstSide, firstMargin);
        connect(4, secondId, secondSide, secondMargin);
        this.mParams.verticalBias = bias;
    L20:
        return this;
    L18:
        connect(6, firstID, firstSide, firstMargin);
        connect(7, secondId, secondSide, secondMargin);
        this.mParams.horizontalBias = bias;
    L19:
        connect(1, firstID, firstSide, firstMargin);
        connect(2, secondId, secondSide, secondMargin);
        this.mParams.horizontalBias = bias;
    L22:
        throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
    L24:
        throw new IllegalArgumentException("margin must be > 0");
    L26:
        throw new IllegalArgumentException("margin must be > 0");
    }

    public ConstraintProperties centerHorizontally(int leftId, int leftSide, int leftMargin, int rightId, int rightSide, int rightMargin, float bias) {
        connect(1, leftId, leftSide, leftMargin);
        connect(2, rightId, rightSide, rightMargin);
        this.mParams.horizontalBias = bias;
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int startId, int startSide, int startMargin, int endId, int endSide, int endMargin, float bias) {
        connect(6, startId, startSide, startMargin);
        connect(7, endId, endSide, endMargin);
        this.mParams.horizontalBias = bias;
        return this;
    }

    public ConstraintProperties centerVertically(int topId, int topSide, int topMargin, int bottomId, int bottomSide, int bottomMargin, float bias) {
        connect(3, topId, topSide, topMargin);
        connect(4, bottomId, bottomSide, bottomMargin);
        this.mParams.verticalBias = bias;
        return this;
    }

    public ConstraintProperties centerHorizontally(int toView) {
        if (toView != 0) goto L4;
        center(0, 1, 0, 0, 2, 0, 0.5f);
    L5:
        return this;
    L4:
        center(toView, 2, 0, toView, 1, 0, 0.5f);
        goto L5
    }

    public ConstraintProperties centerHorizontallyRtl(int toView) {
        if (toView != 0) goto L4;
        center(0, 6, 0, 0, 7, 0, 0.5f);
    L5:
        return this;
    L4:
        center(toView, 7, 0, toView, 6, 0, 0.5f);
        goto L5
    }

    public ConstraintProperties centerVertically(int toView) {
        if (toView != 0) goto L4;
        center(0, 3, 0, 0, 4, 0, 0.5f);
    L5:
        return this;
    L4:
        center(toView, 4, 0, toView, 3, 0, 0.5f);
        goto L5
    }

    public ConstraintProperties removeConstraints(int anchor) {
        switch(anchor) {
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

    public ConstraintProperties margin(int anchor, int value) {
        switch(anchor) {
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
        this.mParams.setMarginEnd(value);
    L13:
        return this;
    L6:
        this.mParams.setMarginStart(value);
        goto L13
    L9:
        this.mParams.bottomMargin = value;
        goto L13
    L10:
        this.mParams.topMargin = value;
        goto L13
    L11:
        this.mParams.rightMargin = value;
        goto L13
    L12:
        this.mParams.leftMargin = value;
        goto L13
    L4:
        throw new IllegalArgumentException("unknown constraint");
    L8:
        throw new IllegalArgumentException("baseline does not support margins");
    }

    public ConstraintProperties goneMargin(int anchor, int value) {
        switch(anchor) {
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
        this.mParams.goneEndMargin = value;
    L13:
        return this;
    L6:
        this.mParams.goneStartMargin = value;
        goto L13
    L9:
        this.mParams.goneBottomMargin = value;
        goto L13
    L10:
        this.mParams.goneTopMargin = value;
        goto L13
    L11:
        this.mParams.goneRightMargin = value;
        goto L13
    L12:
        this.mParams.goneLeftMargin = value;
        goto L13
    L4:
        throw new IllegalArgumentException("unknown constraint");
    L8:
        throw new IllegalArgumentException("baseline does not support margins");
    }

    public ConstraintProperties horizontalBias(float bias) {
        this.mParams.horizontalBias = bias;
        return this;
    }

    public ConstraintProperties verticalBias(float bias) {
        this.mParams.verticalBias = bias;
        return this;
    }

    public ConstraintProperties dimensionRatio(String ratio) {
        this.mParams.dimensionRatio = ratio;
        return this;
    }

    public ConstraintProperties visibility(int visibility) {
        this.mView.setVisibility(visibility);
        return this;
    }

    public ConstraintProperties alpha(float alpha) {
        this.mView.setAlpha(alpha);
        return this;
    }

    public ConstraintProperties elevation(float elevation) {
        this.mView.setElevation(elevation);
        return this;
    }

    public ConstraintProperties rotation(float rotation) {
        this.mView.setRotation(rotation);
        return this;
    }

    public ConstraintProperties rotationX(float rotationX) {
        this.mView.setRotationX(rotationX);
        return this;
    }

    public ConstraintProperties rotationY(float rotationY) {
        this.mView.setRotationY(rotationY);
        return this;
    }

    public ConstraintProperties scaleX(float scaleX) {
        this.mView.setScaleY(scaleX);
        return this;
    }

    public ConstraintProperties transformPivotX(float transformPivotX) {
        this.mView.setPivotX(transformPivotX);
        return this;
    }

    public ConstraintProperties transformPivotY(float transformPivotY) {
        this.mView.setPivotY(transformPivotY);
        return this;
    }

    public ConstraintProperties transformPivot(float transformPivotX, float transformPivotY) {
        this.mView.setPivotX(transformPivotX);
        this.mView.setPivotY(transformPivotY);
        return this;
    }

    public ConstraintProperties translationX(float translationX) {
        this.mView.setTranslationX(translationX);
        return this;
    }

    public ConstraintProperties translationY(float translationY) {
        this.mView.setTranslationY(translationY);
        return this;
    }

    public ConstraintProperties translation(float translationX, float translationY) {
        this.mView.setTranslationX(translationX);
        this.mView.setTranslationY(translationY);
        return this;
    }

    public ConstraintProperties translationZ(float translationZ) {
        this.mView.setTranslationZ(translationZ);
        return this;
    }

    public ConstraintProperties constrainHeight(int height) {
        this.mParams.height = height;
        return this;
    }

    public ConstraintProperties constrainWidth(int width) {
        this.mParams.width = width;
        return this;
    }

    public ConstraintProperties constrainMaxHeight(int height) {
        this.mParams.matchConstraintMaxHeight = height;
        return this;
    }

    public ConstraintProperties constrainMaxWidth(int width) {
        this.mParams.matchConstraintMaxWidth = width;
        return this;
    }

    public ConstraintProperties constrainMinHeight(int height) {
        this.mParams.matchConstraintMinHeight = height;
        return this;
    }

    public ConstraintProperties constrainMinWidth(int width) {
        this.mParams.matchConstraintMinWidth = width;
        return this;
    }

    public ConstraintProperties constrainDefaultHeight(int height) {
        this.mParams.matchConstraintDefaultHeight = height;
        return this;
    }

    public ConstraintProperties constrainDefaultWidth(int width) {
        this.mParams.matchConstraintDefaultWidth = width;
        return this;
    }

    public ConstraintProperties horizontalWeight(float weight) {
        this.mParams.horizontalWeight = weight;
        return this;
    }

    public ConstraintProperties verticalWeight(float weight) {
        this.mParams.verticalWeight = weight;
        return this;
    }

    public ConstraintProperties horizontalChainStyle(int chainStyle) {
        this.mParams.horizontalChainStyle = chainStyle;
        return this;
    }

    public ConstraintProperties verticalChainStyle(int chainStyle) {
        this.mParams.verticalChainStyle = chainStyle;
        return this;
    }

    public ConstraintProperties addToHorizontalChain(int leftId, int rightId) {
        if (leftId != 0) goto L5;
        int r2 = 1;
    L6:
        connect(1, leftId, r2, 0);
        if (rightId != 0) goto L9;
        int r3 = 2;
    L10:
        connect(2, rightId, r3, 0);
        if (leftId == 0) goto L13;
        new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(leftId)).connect(2, this.mView.getId(), 1, 0);
    L13:
        if (rightId == 0) goto L15;
        new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(rightId)).connect(1, this.mView.getId(), 2, 0);
    L15:
        return this;
    L9:
        r3 = 1;
        goto L10
    L5:
        r2 = 2;
        goto L6
    }

    public ConstraintProperties addToHorizontalChainRTL(int leftId, int rightId) {
        if (leftId != 0) goto L5;
        int r2 = 6;
    L6:
        connect(6, leftId, r2, 0);
        if (rightId != 0) goto L9;
        int r3 = 7;
    L10:
        connect(7, rightId, r3, 0);
        if (leftId == 0) goto L13;
        new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(leftId)).connect(7, this.mView.getId(), 6, 0);
    L13:
        if (rightId == 0) goto L15;
        new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(rightId)).connect(6, this.mView.getId(), 7, 0);
    L15:
        return this;
    L9:
        r3 = 6;
        goto L10
    L5:
        r2 = 7;
        goto L6
    }

    public ConstraintProperties addToVerticalChain(int topId, int bottomId) {
        if (topId != 0) goto L5;
        int r2 = 3;
    L6:
        connect(3, topId, r2, 0);
        if (bottomId != 0) goto L9;
        int r3 = 4;
    L10:
        connect(4, bottomId, r3, 0);
        if (topId == 0) goto L13;
        new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(topId)).connect(4, this.mView.getId(), 3, 0);
    L13:
        if (bottomId == 0) goto L15;
        new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(bottomId)).connect(3, this.mView.getId(), 4, 0);
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

    public ConstraintProperties connect(int startSide, int endID, int endSide, int margin) {
        switch(startSide) {
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
        if (endSide != 7) goto L8;
        this.mParams.endToEnd = endID;
        this.mParams.endToStart = -1;
    L10:
        this.mParams.setMarginEnd(margin);
    L56:
        return this;
    L8:
        if (endSide != 6) goto L12;
        this.mParams.endToStart = endID;
        this.mParams.endToEnd = -1;
        goto L10
    L12:
        throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
    L13:
        if (endSide != 6) goto L15;
        this.mParams.startToStart = endID;
        this.mParams.startToEnd = -1;
    L17:
        this.mParams.setMarginStart(margin);
        goto L56
    L15:
        if (endSide != 7) goto L19;
        this.mParams.startToEnd = endID;
        this.mParams.startToStart = -1;
        goto L17
    L19:
        throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
    L30:
        if (endSide != 4) goto L32;
        this.mParams.bottomToBottom = endID;
        this.mParams.bottomToTop = -1;
        this.mParams.baselineToBaseline = -1;
        this.mParams.baselineToTop = -1;
        this.mParams.baselineToBottom = -1;
    L34:
        this.mParams.bottomMargin = margin;
        goto L56
    L32:
        if (endSide != 3) goto L36;
        this.mParams.bottomToTop = endID;
        this.mParams.bottomToBottom = -1;
        this.mParams.baselineToBaseline = -1;
        this.mParams.baselineToTop = -1;
        this.mParams.baselineToBottom = -1;
        goto L34
    L36:
        throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
    L37:
        if (endSide != 3) goto L39;
        this.mParams.topToTop = endID;
        this.mParams.topToBottom = -1;
        this.mParams.baselineToBaseline = -1;
        this.mParams.baselineToTop = -1;
        this.mParams.baselineToBottom = -1;
    L41:
        this.mParams.topMargin = margin;
        goto L56
    L39:
        if (endSide != 4) goto L43;
        this.mParams.topToBottom = endID;
        this.mParams.topToTop = -1;
        this.mParams.baselineToBaseline = -1;
        this.mParams.baselineToTop = -1;
        this.mParams.baselineToBottom = -1;
        goto L41
    L43:
        throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
    L44:
        if (endSide != 1) goto L46;
        this.mParams.rightToLeft = endID;
        this.mParams.rightToRight = -1;
    L48:
        this.mParams.rightMargin = margin;
        goto L56
    L46:
        if (endSide != 2) goto L50;
        this.mParams.rightToRight = endID;
        this.mParams.rightToLeft = -1;
        goto L48
    L50:
        throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
    L51:
        if (endSide != 1) goto L53;
        this.mParams.leftToLeft = endID;
        this.mParams.leftToRight = -1;
    L55:
        this.mParams.leftMargin = margin;
        goto L56
    L53:
        if (endSide != 2) goto L58;
        this.mParams.leftToRight = endID;
        this.mParams.leftToLeft = -1;
        goto L55
    L58:
        throw new IllegalArgumentException("Left to " + sideToString(endSide) + " undefined");
    L5:
        throw new IllegalArgumentException(sideToString(startSide) + " to " + sideToString(endSide) + " unknown");
    L21:
        if (endSide != 5) goto L23;
        this.mParams.baselineToBaseline = endID;
        this.mParams.bottomToBottom = -1;
        this.mParams.bottomToTop = -1;
        this.mParams.topToTop = -1;
        this.mParams.topToBottom = -1;
    L23:
        if (endSide != 3) goto L25;
        this.mParams.baselineToTop = endID;
        this.mParams.bottomToBottom = -1;
        this.mParams.bottomToTop = -1;
        this.mParams.topToTop = -1;
        this.mParams.topToBottom = -1;
    L27:
        this.mParams.baselineMargin = margin;
        goto L56
    L25:
        if (endSide != 4) goto L29;
        this.mParams.baselineToBottom = endID;
        this.mParams.bottomToBottom = -1;
        this.mParams.bottomToTop = -1;
        this.mParams.topToTop = -1;
        this.mParams.topToBottom = -1;
        goto L27
    L29:
        throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
    }

    public ConstraintProperties(View view) {
        ViewGroup.LayoutParams r0 = view.getLayoutParams();
        if ((r0 instanceof ConstraintLayout.LayoutParams) == false) goto L7;
        this.mParams = (ConstraintLayout.LayoutParams) r0;
        this.mView = view;
        return;
    L7:
        throw new RuntimeException("Only children of ConstraintLayout.LayoutParams supported");
    }
}
