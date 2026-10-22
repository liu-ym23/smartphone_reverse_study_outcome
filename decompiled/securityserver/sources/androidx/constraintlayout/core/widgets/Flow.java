package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class Flow extends VirtualLayout {
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_CHAIN_NEW = 3;
    public static final int WRAP_NONE = 0;
    private ConstraintWidget[] mAlignedBiggestElementsInCols;
    private ConstraintWidget[] mAlignedBiggestElementsInRows;
    private int[] mAlignedDimensions;
    private ArrayList<WidgetsList> mChainList;
    private ConstraintWidget[] mDisplayedWidgets;
    private int mDisplayedWidgetsCount;
    private float mFirstHorizontalBias;
    private int mFirstHorizontalStyle;
    private float mFirstVerticalBias;
    private int mFirstVerticalStyle;
    private int mHorizontalAlign;
    private float mHorizontalBias;
    private int mHorizontalGap;
    private int mHorizontalStyle;
    private float mLastHorizontalBias;
    private int mLastHorizontalStyle;
    private float mLastVerticalBias;
    private int mLastVerticalStyle;
    private int mMaxElementsWrap;
    private int mOrientation;
    private int mVerticalAlign;
    private float mVerticalBias;
    private int mVerticalGap;
    private int mVerticalStyle;
    private int mWrapMode;

    public class WidgetsList {
        private ConstraintWidget biggest;
        int biggestDimension;
        private ConstraintAnchor mBottom;
        private int mCount;
        private int mHeight;
        private ConstraintAnchor mLeft;
        private int mMax;
        private int mNbMatchConstraintsWidgets;
        private int mOrientation;
        private int mPaddingBottom;
        private int mPaddingLeft;
        private int mPaddingRight;
        private int mPaddingTop;
        private ConstraintAnchor mRight;
        private int mStartIndex;
        private ConstraintAnchor mTop;
        private int mWidth;
        final /* synthetic */ Flow this$0;

        public WidgetsList(Flow r2, int r3, ConstraintAnchor r4, ConstraintAnchor r5, ConstraintAnchor r6, ConstraintAnchor r7, int r8) {
            this.this$0 = r2;
            this.biggest = null;
            this.biggestDimension = 0;
            this.mPaddingLeft = 0;
            this.mPaddingTop = 0;
            this.mPaddingRight = 0;
            this.mPaddingBottom = 0;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mStartIndex = 0;
            this.mCount = 0;
            this.mNbMatchConstraintsWidgets = 0;
            this.mMax = 0;
            this.mOrientation = r3;
            this.mLeft = r4;
            this.mTop = r5;
            this.mRight = r6;
            this.mBottom = r7;
            this.mPaddingLeft = r2.getPaddingLeft();
            this.mPaddingTop = r2.getPaddingTop();
            this.mPaddingRight = r2.getPaddingRight();
            this.mPaddingBottom = r2.getPaddingBottom();
            this.mMax = r8;
        }

        public static /* synthetic */ ConstraintWidget access$2000(WidgetsList r0) {
            return r0.biggest;
        }

        private void recomputeDimensions() {
            this.mWidth = 0;
            this.mHeight = 0;
            this.biggest = null;
            this.biggestDimension = 0;
            int r1 = this.mCount;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L26;
            if ((this.mStartIndex + r2) >= Flow.access$400(this.this$0)) goto L33;
            ConstraintWidget r3 = Flow.access$500(this.this$0)[this.mStartIndex + r2];
            if (this.mOrientation != 0) goto L17;
            int r4 = r3.getWidth();
            int r6 = Flow.access$000(this.this$0);
            if (r3.getVisibility() != 8) goto L12;
            r6 = 0;
        L12:
            this.mWidth = (r4 + r6) + this.mWidth;
            int r5 = Flow.access$300(this.this$0, r3, this.mMax);
            if (this.biggest != null) goto L15;
        L16:
            this.biggest = r3;
            this.biggestDimension = r5;
            this.mHeight = r5;
        L25:
            r2 = r2 + 1;
            goto L3
        L15:
            if (this.biggestDimension >= r5) goto L25;
        L17:
            int r7 = Flow.access$200(this.this$0, r3, this.mMax);
            int r8 = Flow.access$300(this.this$0, r3, this.mMax);
            int r9 = Flow.access$100(this.this$0);
            if (r3.getVisibility() != 8) goto L20;
            r9 = 0;
        L20:
            this.mHeight = (r8 + r9) + this.mHeight;
            if (this.biggest != null) goto L23;
        L24:
            this.biggest = r3;
            this.biggestDimension = r7;
            this.mWidth = r7;
            goto L25
        L23:
            if (this.biggestDimension >= r7) goto L25;
        L33:
            return;
        }

        public void add(ConstraintWidget r7) {
            int r2 = 0;
            if (this.mOrientation != 0) goto L16;
            int r0 = Flow.access$200(this.this$0, r7, this.mMax);
            if (r7.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L7;
            this.mNbMatchConstraintsWidgets++;
            r0 = 0;
        L7:
            int r3 = Flow.access$000(this.this$0);
            if (r7.getVisibility() == 8) goto L11;
            r2 = r3;
        L11:
            this.mWidth = (r0 + r2) + this.mWidth;
            int r1 = Flow.access$300(this.this$0, r7, this.mMax);
            if (this.biggest != null) goto L14;
        L15:
            this.biggest = r7;
            this.biggestDimension = r1;
            this.mHeight = r1;
        L28:
            this.mCount++;
            return;
        L14:
            if (this.biggestDimension >= r1) goto L28;
        L16:
            int r4 = Flow.access$200(this.this$0, r7, this.mMax);
            int r5 = Flow.access$300(this.this$0, r7, this.mMax);
            if (r7.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L19;
            this.mNbMatchConstraintsWidgets++;
            r5 = 0;
        L19:
            int r6 = Flow.access$100(this.this$0);
            if (r7.getVisibility() == 8) goto L23;
            r2 = r6;
        L23:
            this.mHeight = (r5 + r2) + this.mHeight;
            if (this.biggest != null) goto L26;
        L27:
            this.biggest = r7;
            this.biggestDimension = r4;
            this.mWidth = r4;
            goto L28
        L26:
            if (this.biggestDimension >= r4) goto L28;
            goto L27
        }

        public void clear() {
            this.biggestDimension = 0;
            this.biggest = null;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mStartIndex = 0;
            this.mCount = 0;
            this.mNbMatchConstraintsWidgets = 0;
        }

        public void createConstraints(boolean r17, int r18, boolean r19) {
            int r1 = this.mCount;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L11;
            if ((this.mStartIndex + r3) >= Flow.access$400(this.this$0)) goto L11;
            ConstraintWidget r4 = Flow.access$500(this.this$0)[this.mStartIndex + r3];
            if (r4 == null) goto L10;
            r4.resetAnchors();
        L10:
            r3 = r3 + 1;
        L11:
            if (r1 != 0) goto L13;
            return;
        L13:
            if (this.biggest == null) goto L222;
            if (r19 == false) goto L18;
            if (r18 != 0) goto L18;
            boolean r5 = true;
        L19:
            int r6 = 0;
            int r7 = -1;
            int r8 = -1;
        L20:
            if (r6 >= r1) goto L35;
            if (r17 == false) goto L23;
            int r9 = (r1 - 1) - r6;
        L25:
            if ((this.mStartIndex + r9) >= Flow.access$400(this.this$0)) goto L35;
            ConstraintWidget r10 = Flow.access$500(this.this$0)[this.mStartIndex + r9];
            if (r10 == null) goto L34;
            if (r10.getVisibility() != 0) goto L34;
            if (r7 != (-1)) goto L33;
            r7 = r6;
        L33:
            r8 = r6;
        L34:
            r6 = r6 + 1;
            goto L20
        L23:
            r9 = r6;
        L35:
            ConstraintWidget r11 = null;
            if (this.mOrientation != 0) goto L127;
            ConstraintWidget r12 = this.biggest;
            r12.setVerticalChainStyle(Flow.access$600(this.this$0));
            int r13 = this.mPaddingTop;
            if (r18 <= 0) goto L40;
            r13 = r13 + Flow.access$100(this.this$0);
        L40:
            r12.mTop.connect(this.mTop, r13);
            if (r19 == false) goto L43;
            r12.mBottom.connect(this.mBottom, this.mPaddingBottom);
        L43:
            if (r18 <= 0) goto L45;
            this.mTop.mOwner.mBottom.connect(r12.mTop, 0);
        L45:
            char r14 = 3;
            if (Flow.access$700(this.this$0) == 3) goto L48;
        L61:
            ConstraintWidget r15 = r12;
        L62:
            int r16 = 0;
        L63:
            if (r16 >= r1) goto L223;
            if (r17 == false) goto L66;
            int r110 = (r1 - 1) - r16;
        L68:
            if ((this.mStartIndex + r110) >= Flow.access$400(this.this$0)) goto L224;
            ConstraintWidget r111 = Flow.access$500(this.this$0)[this.mStartIndex + r110];
            if (r111 != null) goto L73;
            r111 = r11;
            char r20 = r14;
        L126:
            r16 = r16 + 1;
            r14 = r20;
            r11 = r111;
            goto L63
        L73:
            if (r16 != 0) goto L75;
            r111.connect(r111.mLeft, this.mLeft, this.mPaddingLeft);
        L75:
            if (r110 != 0) goto L98;
            int r21 = Flow.access$800(this.this$0);
            float r112 = Flow.access$900(this.this$0);
            if (r17 == false) goto L80;
            r112 = 1.0f - r112;
        L80:
            if (this.mStartIndex == 0) goto L82;
        L89:
            if (r19 == true) goto L91;
        L96:
            r111.setHorizontalChainStyle(r21);
            r111.setHorizontalBiasPercent(r112);
            goto L98
        L91:
            if (Flow.access$1200(this.this$0) == (-1)) goto L96;
            r21 = Flow.access$1200(this.this$0);
            if (r17 == false) goto L95;
            float r113 = Flow.access$1300(this.this$0);
        L86:
            float r114 = 1.0f - r113;
        L87:
            r112 = r114;
            goto L96
        L95:
            r114 = Flow.access$1300(this.this$0);
            goto L87
        L82:
            if (Flow.access$1000(this.this$0) == (-1)) goto L89;
            r21 = Flow.access$1000(this.this$0);
            if (r17 == false) goto L88;
            r113 = Flow.access$1100(this.this$0);
            goto L86
        L88:
            r114 = Flow.access$1100(this.this$0);
        L98:
            if (r16 != (r1 - 1)) goto L100;
            r111.connect(r111.mRight, this.mRight, this.mPaddingRight);
        L100:
            if (r11 == null) goto L107;
            r111.mLeft.connect(r11.mRight, Flow.access$000(this.this$0));
            if (r16 != r7) goto L104;
            r111.mLeft.setGoneMargin(this.mPaddingLeft);
        L104:
            r11.mRight.connect(r111.mLeft, 0);
            if (r16 != (r8 + 1)) goto L107;
            r11.mRight.setGoneMargin(this.mPaddingRight);
        L107:
            if (r111 == r12) goto L125;
            r20 = 3;
            if (Flow.access$700(this.this$0) == 3) goto L111;
        L116:
            int r22 = Flow.access$700(this.this$0);
            if (r22 != 0) goto L119;
            r111.mTop.connect(r12.mTop, 0);
            goto L126
        L119:
            if (r22 == 1) goto L123;
            if (r5 == false) goto L122;
            r111.mTop.connect(this.mTop, this.mPaddingTop);
            r111.mBottom.connect(this.mBottom, this.mPaddingBottom);
            goto L126
        L122:
            r111.mTop.connect(r12.mTop, 0);
            r111.mBottom.connect(r12.mBottom, 0);
            goto L126
        L123:
            r111.mBottom.connect(r12.mBottom, 0);
            goto L126
        L111:
            if (r15.hasBaseline() == false) goto L116;
            if (r111 == r15) goto L116;
            if (r111.hasBaseline() == false) goto L116;
            r111.mBaseline.connect(r15.mBaseline, 0);
            goto L126
        L125:
            r20 = 3;
            goto L126
        L224:
            return;
        L66:
            r110 = r16;
            goto L68
        L223:
            return;
        L48:
            if (r12.hasBaseline() == true) goto L61;
            int r115 = 0;
        L50:
            if (r115 >= r1) goto L61;
            if (r17 == false) goto L53;
            int r116 = (r1 - 1) - r115;
        L55:
            if ((this.mStartIndex + r116) >= Flow.access$400(this.this$0)) goto L61;
            r15 = Flow.access$500(this.this$0)[this.mStartIndex + r116];
            if (r15.hasBaseline() == true) goto L62;
            r115 = r115 + 1;
            goto L50
        L53:
            r116 = r115;
            goto L55
        L127:
            ConstraintWidget r23 = this.biggest;
            r23.setHorizontalChainStyle(Flow.access$800(this.this$0));
            int r24 = this.mPaddingLeft;
            if (r18 <= 0) goto L130;
            r24 = r24 + Flow.access$000(this.this$0);
        L130:
            if (r17 == false) goto L136;
            r23.mRight.connect(this.mRight, r24);
            if (r19 == false) goto L134;
            r23.mLeft.connect(this.mLeft, this.mPaddingRight);
        L134:
            if (r18 <= 0) goto L141;
            this.mRight.mOwner.mLeft.connect(r23.mRight, 0);
        L141:
            int r25 = 0;
        L142:
            if (r25 >= r1) goto L225;
            if ((this.mStartIndex + r25) >= Flow.access$400(this.this$0)) goto L226;
            ConstraintWidget r117 = Flow.access$500(this.this$0)[this.mStartIndex + r25];
            if (r117 == null) goto L195;
            if (r25 != 0) goto L161;
            r117.connect(r117.mTop, this.mTop, this.mPaddingTop);
            int r118 = Flow.access$600(this.this$0);
            float r119 = Flow.access$1400(this.this$0);
            if (this.mStartIndex == 0) goto L153;
        L155:
            if (r19 == true) goto L157;
        L159:
            r117.setVerticalChainStyle(r118);
            r117.setVerticalBiasPercent(r119);
            goto L161
        L157:
            if (Flow.access$1700(this.this$0) == (-1)) goto L159;
            r118 = Flow.access$1700(this.this$0);
            r119 = Flow.access$1800(this.this$0);
            goto L159
        L153:
            if (Flow.access$1500(this.this$0) == (-1)) goto L155;
            r118 = Flow.access$1500(this.this$0);
            r119 = Flow.access$1600(this.this$0);
        L161:
            if (r25 != (r1 - 1)) goto L163;
            r117.connect(r117.mBottom, this.mBottom, this.mPaddingBottom);
        L163:
            if (r11 == null) goto L170;
            r117.mTop.connect(r11.mBottom, Flow.access$100(this.this$0));
            if (r25 != r7) goto L167;
            r117.mTop.setGoneMargin(this.mPaddingTop);
        L167:
            r11.mBottom.connect(r117.mTop, 0);
            if (r25 != (r8 + 1)) goto L170;
            r11.mBottom.setGoneMargin(this.mPaddingBottom);
        L170:
            if (r117 == r23) goto L194;
            if (r17 == false) goto L183;
            int r120 = Flow.access$1900(this.this$0);
            if (r120 != 0) goto L176;
            r117.mRight.connect(r23.mRight, 0);
            goto L194
        L176:
            if (r120 == 1) goto L180;
            if (r120 != 2) goto L194;
            r117.mLeft.connect(r23.mLeft, 0);
            r117.mRight.connect(r23.mRight, 0);
            goto L194
        L180:
            r117.mLeft.connect(r23.mLeft, 0);
            goto L194
        L183:
            int r121 = Flow.access$1900(this.this$0);
            if (r121 != 0) goto L186;
            r117.mLeft.connect(r23.mLeft, 0);
            goto L194
        L186:
            if (r121 == 1) goto L192;
            if (r121 != 2) goto L194;
            if (r5 == false) goto L191;
            r117.mLeft.connect(this.mLeft, this.mPaddingLeft);
            r117.mRight.connect(this.mRight, this.mPaddingRight);
            goto L194
        L191:
            r117.mLeft.connect(r23.mLeft, 0);
            r117.mRight.connect(r23.mRight, 0);
            goto L194
        L192:
            r117.mRight.connect(r23.mRight, 0);
        L194:
            r11 = r117;
        L195:
            r25 = r25 + 1;
            goto L142
        L226:
            return;
        L225:
            return;
        L136:
            r23.mLeft.connect(this.mLeft, r24);
            if (r19 == false) goto L139;
            r23.mRight.connect(this.mRight, this.mPaddingRight);
        L139:
            if (r18 <= 0) goto L141;
            this.mLeft.mOwner.mRight.connect(r23.mLeft, 0);
        L18:
            r5 = false;
            goto L19
        }

        public int getHeight() {
            if (this.mOrientation != 1) goto L7;
            return this.mHeight - Flow.access$100(this.this$0);
        L7:
            return this.mHeight;
        }

        public int getWidth() {
            if (this.mOrientation != 0) goto L7;
            return this.mWidth - Flow.access$000(this.this$0);
        L7:
            return this.mWidth;
        }

        public void measureMatchConstraints(int r9) {
            int r0 = this.mNbMatchConstraintsWidgets;
            if (r0 != 0) goto L5;
            return;
        L5:
            int r1 = this.mCount;
            int r10 = r9 / r0;
            int r2 = 0;
        L6:
            if (r2 >= r1) goto L25;
            if ((this.mStartIndex + r2) >= Flow.access$400(this.this$0)) goto L25;
            ConstraintWidget r3 = Flow.access$500(this.this$0)[this.mStartIndex + r2];
            if (this.mOrientation != 0) goto L18;
            if (r3 == null) goto L24;
            if (r3.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L24;
            if (r3.mMatchConstraintDefaultWidth != 0) goto L24;
            this.this$0.measure(r3, ConstraintWidget.DimensionBehaviour.FIXED, r10, r3.getVerticalDimensionBehaviour(), r3.getHeight());
        L24:
            r2 = r2 + 1;
            goto L6
        L18:
            if (r3 == null) goto L24;
            if (r3.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L24;
            if (r3.mMatchConstraintDefaultHeight != 0) goto L24;
            this.this$0.measure(r3, r3.getHorizontalDimensionBehaviour(), r3.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, r10);
        L25:
            recomputeDimensions();
        }

        public void setStartIndex(int r1) {
            this.mStartIndex = r1;
        }

        public void setup(int r1, ConstraintAnchor r2, ConstraintAnchor r3, ConstraintAnchor r4, ConstraintAnchor r5, int r6, int r7, int r8, int r9, int r10) {
            this.mOrientation = r1;
            this.mLeft = r2;
            this.mTop = r3;
            this.mRight = r4;
            this.mBottom = r5;
            this.mPaddingLeft = r6;
            this.mPaddingTop = r7;
            this.mPaddingRight = r8;
            this.mPaddingBottom = r9;
            this.mMax = r10;
        }
    }

    public Flow() {
        this.mHorizontalStyle = -1;
        this.mVerticalStyle = -1;
        this.mFirstHorizontalStyle = -1;
        this.mFirstVerticalStyle = -1;
        this.mLastHorizontalStyle = -1;
        this.mLastVerticalStyle = -1;
        this.mHorizontalBias = 0.5f;
        this.mVerticalBias = 0.5f;
        this.mFirstHorizontalBias = 0.5f;
        this.mFirstVerticalBias = 0.5f;
        this.mLastHorizontalBias = 0.5f;
        this.mLastVerticalBias = 0.5f;
        this.mHorizontalGap = 0;
        this.mVerticalGap = 0;
        this.mHorizontalAlign = 2;
        this.mVerticalAlign = 2;
        this.mWrapMode = 0;
        this.mMaxElementsWrap = -1;
        this.mOrientation = 0;
        this.mChainList = new ArrayList();
        this.mAlignedBiggestElementsInRows = null;
        this.mAlignedBiggestElementsInCols = null;
        this.mAlignedDimensions = null;
        this.mDisplayedWidgetsCount = 0;
    }

    public static /* synthetic */ int access$000(Flow r0) {
        return r0.mHorizontalGap;
    }

    public static /* synthetic */ int access$100(Flow r0) {
        return r0.mVerticalGap;
    }

    public static /* synthetic */ int access$1000(Flow r0) {
        return r0.mFirstHorizontalStyle;
    }

    public static /* synthetic */ float access$1100(Flow r0) {
        return r0.mFirstHorizontalBias;
    }

    public static /* synthetic */ int access$1200(Flow r0) {
        return r0.mLastHorizontalStyle;
    }

    public static /* synthetic */ float access$1300(Flow r0) {
        return r0.mLastHorizontalBias;
    }

    public static /* synthetic */ float access$1400(Flow r0) {
        return r0.mVerticalBias;
    }

    public static /* synthetic */ int access$1500(Flow r0) {
        return r0.mFirstVerticalStyle;
    }

    public static /* synthetic */ float access$1600(Flow r0) {
        return r0.mFirstVerticalBias;
    }

    public static /* synthetic */ int access$1700(Flow r0) {
        return r0.mLastVerticalStyle;
    }

    public static /* synthetic */ float access$1800(Flow r0) {
        return r0.mLastVerticalBias;
    }

    public static /* synthetic */ int access$1900(Flow r0) {
        return r0.mHorizontalAlign;
    }

    public static /* synthetic */ int access$200(Flow r0, ConstraintWidget r1, int r2) {
        return r0.getWidgetWidth(r1, r2);
    }

    public static /* synthetic */ int access$300(Flow r0, ConstraintWidget r1, int r2) {
        return r0.getWidgetHeight(r1, r2);
    }

    public static /* synthetic */ int access$400(Flow r0) {
        return r0.mDisplayedWidgetsCount;
    }

    public static /* synthetic */ ConstraintWidget[] access$500(Flow r0) {
        return r0.mDisplayedWidgets;
    }

    public static /* synthetic */ int access$600(Flow r0) {
        return r0.mVerticalStyle;
    }

    public static /* synthetic */ int access$700(Flow r0) {
        return r0.mVerticalAlign;
    }

    public static /* synthetic */ int access$800(Flow r0) {
        return r0.mHorizontalStyle;
    }

    public static /* synthetic */ float access$900(Flow r0) {
        return r0.mHorizontalBias;
    }

    private void createAlignedConstraints(boolean r12) {
        if (this.mAlignedDimensions != null) goto L5;
        return;
    L5:
        if (this.mAlignedBiggestElementsInCols != null) goto L7;
        return;
    L7:
        if (this.mAlignedBiggestElementsInRows == null) goto L91;
        int r1 = 0;
    L11:
        if (r1 >= this.mDisplayedWidgetsCount) goto L13;
        this.mDisplayedWidgets[r1].resetAnchors();
        r1 = r1 + 1;
        goto L11
    L13:
        int[] r2 = this.mAlignedDimensions;
        int r3 = r2[0];
        int r4 = r2[1];
        float r5 = this.mHorizontalBias;
        ConstraintWidget r6 = null;
        int r7 = 0;
    L15:
        if (r7 >= r3) goto L34;
        if (r12 == false) goto L18;
        int r8 = (r3 - r7) - 1;
        float r9 = 1.0f - this.mHorizontalBias;
    L19:
        ConstraintWidget r10 = this.mAlignedBiggestElementsInCols[r8];
        if (r10 == null) goto L33;
        if (r10.getVisibility() == 8) goto L33;
        if (r7 != 0) goto L27;
        r10.connect(r10.mLeft, this.mLeft, getPaddingLeft());
        r10.setHorizontalChainStyle(this.mHorizontalStyle);
        r10.setHorizontalBiasPercent(r9);
    L27:
        if (r7 != (r3 - 1)) goto L29;
        r10.connect(r10.mRight, this.mRight, getPaddingRight());
    L29:
        if (r7 <= 0) goto L32;
        if (r6 == null) goto L32;
        r10.connect(r10.mLeft, r6.mRight, this.mHorizontalGap);
        r6.connect(r6.mRight, r10.mLeft, 0);
    L32:
        r6 = r10;
    L33:
        r7 = r7 + 1;
        r5 = r9;
        goto L15
    L18:
        r9 = r5;
        r8 = r7;
        goto L19
    L34:
        int r13 = 0;
    L35:
        if (r13 >= r4) goto L51;
        ConstraintWidget r11 = this.mAlignedBiggestElementsInRows[r13];
        if (r11 == null) goto L50;
        if (r11.getVisibility() == 8) goto L50;
        if (r13 != 0) goto L44;
        r11.connect(r11.mTop, this.mTop, getPaddingTop());
        r11.setVerticalChainStyle(this.mVerticalStyle);
        r11.setVerticalBiasPercent(this.mVerticalBias);
    L44:
        if (r13 != (r4 - 1)) goto L46;
        r11.connect(r11.mBottom, this.mBottom, getPaddingBottom());
    L46:
        if (r13 <= 0) goto L49;
        if (r6 == null) goto L49;
        r11.connect(r11.mTop, r6.mBottom, this.mVerticalGap);
        r6.connect(r6.mBottom, r11.mTop, 0);
    L49:
        r6 = r11;
    L50:
        r13 = r13 + 1;
        goto L35
    L51:
        int r14 = 0;
    L52:
        if (r14 >= r3) goto L92;
        int r15 = 0;
    L54:
        if (r15 >= r4) goto L72;
        int r16 = (r15 * r3) + r14;
        if (this.mOrientation != 1) goto L58;
        r16 = (r14 * r4) + r15;
    L58:
        ConstraintWidget[] r17 = this.mDisplayedWidgets;
        if (r16 >= r17.length) goto L71;
        ConstraintWidget r18 = r17[r16];
        if (r18 == null) goto L71;
        if (r18.getVisibility() == 8) goto L71;
        ConstraintWidget r19 = this.mAlignedBiggestElementsInCols[r14];
        ConstraintWidget r20 = this.mAlignedBiggestElementsInRows[r15];
        if (r18 == r19) goto L69;
        r18.connect(r18.mLeft, r19.mLeft, 0);
        r18.connect(r18.mRight, r19.mRight, 0);
    L69:
        if (r18 == r20) goto L71;
        r18.connect(r18.mTop, r20.mTop, 0);
        r18.connect(r18.mBottom, r20.mBottom, 0);
    L71:
        r15 = r15 + 1;
        goto L54
    L72:
        r14 = r14 + 1;
        goto L52
    L92:
        return;
    }

    private final int getWidgetHeight(ConstraintWidget r10, int r11) {
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L24;
        int r1 = r10.mMatchConstraintDefaultHeight;
        if (r1 != 0) goto L11;
        return 0;
    L11:
        if (r1 != 2) goto L16;
        int r12 = (int) (r10.mMatchConstraintPercentHeight * r11);
        if (r12 == r10.getHeight()) goto L15;
        r10.setMeasureRequested(true);
        measure(r10, r10.getHorizontalDimensionBehaviour(), r10.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, r12);
    L15:
        return r12;
    L16:
        if (r1 != 1) goto L20;
        return r10.getHeight();
    L20:
        if (r1 != 3) goto L24;
        return (int) ((r10.getWidth() * r10.mDimensionRatio) + 0.5f);
    L24:
        return r10.getHeight();
    }

    private final int getWidgetWidth(ConstraintWidget r10, int r11) {
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L24;
        int r1 = r10.mMatchConstraintDefaultWidth;
        if (r1 != 0) goto L11;
        return 0;
    L11:
        if (r1 != 2) goto L16;
        int r12 = (int) (r10.mMatchConstraintPercentWidth * r11);
        if (r12 == r10.getWidth()) goto L15;
        r10.setMeasureRequested(true);
        measure(r10, ConstraintWidget.DimensionBehaviour.FIXED, r12, r10.getVerticalDimensionBehaviour(), r10.getHeight());
    L15:
        return r12;
    L16:
        if (r1 != 1) goto L20;
        return r10.getWidth();
    L20:
        if (r1 != 3) goto L24;
        return (int) ((r10.getHeight() * r10.mDimensionRatio) + 0.5f);
    L24:
        return r10.getWidth();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x010d -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x010f -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x0115 -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x0117 -> B:42:0x0059). Please report as a decompilation issue!!! */
    private void measureAligned(ConstraintWidget[] r11, int r12, int r13, int r14, int[] r15) {
        if (r13 != 0) goto L19;
        int r1 = this.mMaxElementsWrap;
        if (r1 > 0) goto L18;
        r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L7:
        if (r2 >= r12) goto L18;
        if (r2 <= 0) goto L10;
        r3 = r3 + this.mHorizontalGap;
    L10:
        ConstraintWidget r4 = r11[r2];
        if (r4 == null) goto L17;
        r3 = r3 + getWidgetWidth(r4, r14);
        if (r3 > r14) goto L18;
        r1 = r1 + 1;
    L17:
        r2 = r2 + 1;
    L18:
        int r5 = r1;
        int r6 = 0;
    L35:
        if (this.mAlignedDimensions != null) goto L38;
        this.mAlignedDimensions = new int[2];
    L38:
        if (r6 != 0) goto L40;
        if (r13 != 1) goto L40;
    L42:
        boolean r7 = true;
    L44:
        if (r7 == true) goto L111;
        if (r13 != 0) goto L47;
        r6 = (int) Math.ceil(r12 / r5);
    L48:
        ConstraintWidget[] r8 = this.mAlignedBiggestElementsInCols;
        if (r8 != null) goto L51;
    L54:
        this.mAlignedBiggestElementsInCols = new ConstraintWidget[r5];
    L55:
        ConstraintWidget[] r9 = this.mAlignedBiggestElementsInRows;
        if (r9 != null) goto L58;
    L61:
        this.mAlignedBiggestElementsInRows = new ConstraintWidget[r6];
    L62:
        int r10 = 0;
    L63:
        if (r10 >= r5) goto L87;
        int r16 = 0;
    L65:
        if (r16 >= r6) goto L86;
        int r17 = (r16 * r5) + r10;
        if (r13 != 1) goto L70;
        r17 = (r10 * r6) + r16;
    L70:
        if (r17 >= r11.length) goto L85;
        ConstraintWidget r18 = r11[r17];
        if (r18 == null) goto L85;
        int r19 = getWidgetWidth(r18, r14);
        ConstraintWidget r20 = this.mAlignedBiggestElementsInCols[r10];
        if (r20 != null) goto L78;
    L79:
        this.mAlignedBiggestElementsInCols[r10] = r18;
    L80:
        int r21 = getWidgetHeight(r18, r14);
        ConstraintWidget r22 = this.mAlignedBiggestElementsInRows[r16];
        if (r22 != null) goto L83;
    L84:
        this.mAlignedBiggestElementsInRows[r16] = r18;
        goto L85
    L83:
        if (r22.getHeight() >= r21) goto L85;
    L78:
        if (r20.getWidth() >= r19) goto L80;
    L85:
        r16 = r16 + 1;
        goto L65
    L86:
        r10 = r10 + 1;
        goto L63
    L87:
        int r23 = 0;
        int r24 = 0;
    L88:
        if (r23 >= r5) goto L95;
        ConstraintWidget r25 = this.mAlignedBiggestElementsInCols[r23];
        if (r25 == null) goto L94;
        if (r23 <= 0) goto L93;
        r24 = r24 + this.mHorizontalGap;
    L93:
        r24 = r24 + getWidgetWidth(r25, r14);
    L94:
        r23 = r23 + 1;
        goto L88
    L95:
        int r26 = 0;
        int r27 = 0;
    L96:
        if (r26 >= r6) goto L103;
        ConstraintWidget r28 = this.mAlignedBiggestElementsInRows[r26];
        if (r28 == null) goto L102;
        if (r26 <= 0) goto L101;
        r27 = r27 + this.mVerticalGap;
    L101:
        r27 = r27 + getWidgetHeight(r28, r14);
    L102:
        r26 = r26 + 1;
        goto L96
    L103:
        r15[0] = r24;
        r15[1] = r27;
        if (r13 == 0) goto L105;
        if (r27 <= r14) goto L42;
        if (r6 <= 1) goto L42;
        r6 = r6 - 1;
        goto L44
    L105:
        if (r24 <= r14) goto L42;
        if (r5 <= 1) goto L42;
        r5 = r5 - 1;
        goto L44
    L58:
        if (r9.length < r6) goto L61;
        Arrays.fill(r9, null);
        goto L62
    L51:
        if (r8.length < r5) goto L54;
        Arrays.fill(r8, null);
        goto L55
    L47:
        r5 = (int) Math.ceil(r12 / r6);
        goto L48
    L111:
        int[] r110 = this.mAlignedDimensions;
        r110[0] = r5;
        r110[1] = r6;
        return;
    L40:
        if (r5 != 0) goto L43;
        if (r13 == 0) goto L42;
    L43:
        r7 = false;
        goto L44
    L19:
        r6 = this.mMaxElementsWrap;
        if (r6 > 0) goto L33;
        r6 = 0;
        int r29 = 0;
        int r30 = 0;
    L22:
        if (r29 >= r12) goto L33;
        if (r29 <= 0) goto L25;
        r30 = r30 + this.mVerticalGap;
    L25:
        ConstraintWidget r31 = r11[r29];
        if (r31 == null) goto L32;
        r30 = r30 + getWidgetHeight(r31, r14);
        if (r30 > r14) goto L33;
        r6 = r6 + 1;
    L32:
        r29 = r29 + 1;
    L33:
        r5 = 0;
        goto L35
    }

    private void measureChainWrap(ConstraintWidget[] r29, int r30, int r31, int r32, int[] r33) {
        if (r30 != 0) goto L5;
        return;
    L5:
        this.mChainList.clear();
        WidgetsList r10 = new WidgetsList(this, r31, this.mLeft, this.mTop, this.mRight, this.mBottom, r32);
        this.mChainList.add(r10);
        if (r31 != 0) goto L33;
        int r0 = 0;
        int r1 = 0;
        int r11 = 0;
    L8:
        if (r11 >= r30) goto L59;
        ConstraintWidget r12 = r29[r11];
        int r13 = getWidgetWidth(r12, r32);
        if (r12.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L12;
        r0 = r0 + 1;
    L12:
        int r14 = r0;
        if (r1 == r32) goto L17;
        if (((this.mHorizontalGap + r1) + r13) > r32) goto L17;
    L19:
        boolean r2 = false;
    L20:
        if (r2 == true) goto L27;
        if (r11 <= 0) goto L27;
        int r3 = this.mMaxElementsWrap;
        if (r3 <= 0) goto L27;
        if ((r11 % r3) != 0) goto L27;
        r2 = true;
    L27:
        if (r2 == false) goto L30;
        r10 = new WidgetsList(this, r31, this.mLeft, this.mTop, this.mRight, this.mBottom, r32);
        r10.setStartIndex(r11);
        this.mChainList.add(r10);
    L29:
        r1 = r13;
    L32:
        r10.add(r12);
        r11 = r11 + 1;
        r0 = r14;
        goto L8
    L30:
        if (r11 <= 0) goto L29;
        r1 = (this.mHorizontalGap + r13) + r1;
    L17:
        if (WidgetsList.access$2000(r10) == null) goto L19;
        r2 = true;
    L59:
        int r4 = this.mChainList.size();
        ConstraintAnchor r5 = this.mLeft;
        ConstraintAnchor r6 = this.mTop;
        ConstraintAnchor r7 = this.mRight;
        ConstraintAnchor r8 = this.mBottom;
        int r9 = getPaddingLeft();
        int r15 = getPaddingTop();
        int r16 = getPaddingRight();
        int r17 = getPaddingBottom();
        ConstraintWidget.DimensionBehaviour r18 = getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r19 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r18 != r19) goto L62;
    L65:
        boolean r110 = true;
    L66:
        if (r0 <= 0) goto L75;
        if (r110 == false) goto L75;
        int r20 = 0;
    L69:
        if (r20 >= r4) goto L75;
        WidgetsList r111 = this.mChainList.get(r20);
        if (r31 != 0) goto L73;
        r111.measureMatchConstraints(r32 - r111.getWidth());
    L74:
        r20 = r20 + 1;
        goto L69
    L73:
        r111.measureMatchConstraints(r32 - r111.getHeight());
    L75:
        int r22 = r15;
        int r21 = r16;
        int r112 = 0;
        int r113 = 0;
        int r114 = 0;
        int r23 = r9;
        ConstraintAnchor r24 = r6;
        ConstraintAnchor r25 = r5;
        int r26 = r17;
    L76:
        if (r114 >= r4) goto L96;
        WidgetsList r27 = this.mChainList.get(r114);
        if (r31 == 0) goto L80;
        ConstraintAnchor r210 = r25;
        int r28 = r112;
        int r34 = r113;
        int r35 = r114;
        if (r35 >= (r4 - 1)) goto L90;
        ConstraintAnchor r211 = WidgetsList.access$2000(this.mChainList.get(r35 + 1)).mLeft;
        int r212 = 0;
    L91:
        ConstraintAnchor r115 = WidgetsList.access$2000(r27).mRight;
        r27.setup(r31, r210, r24, r211, r8, r23, r22, r212, r26, r32);
        r113 = r34 + r27.getWidth();
        int r36 = Math.max(r28, r27.getHeight());
        if (r35 <= 0) goto L94;
        r113 = r113 + this.mHorizontalGap;
    L94:
        r112 = r36;
        r23 = 0;
        r21 = r212;
        r25 = r115;
    L95:
        r114 = r35 + 1;
        r7 = r211;
        goto L76
    L90:
        r211 = this.mRight;
        r212 = getPaddingRight();
        goto L91
    L80:
        if (r114 >= (r4 - 1)) goto L82;
        ConstraintAnchor r37 = WidgetsList.access$2000(this.mChainList.get(r114 + 1)).mTop;
        int r38 = 0;
    L83:
        ConstraintAnchor r116 = WidgetsList.access$2000(r27).mBottom;
        ConstraintAnchor r117 = r25;
        ConstraintAnchor r213 = r25;
        int r39 = r112;
        ConstraintAnchor r118 = r24;
        int r40 = r113;
        ConstraintAnchor r119 = r7;
        ConstraintAnchor r310 = r7;
        r35 = r114;
        r27.setup(r31, r117, r118, r119, r37, r23, r22, r21, r38, r32);
        int r41 = Math.max(r40, r27.getWidth());
        r112 = r39 + r27.getHeight();
        if (r35 <= 0) goto L86;
        r112 = r112 + this.mVerticalGap;
    L86:
        r25 = r213;
        r113 = r41;
        r22 = 0;
        r24 = r116;
        r211 = r310;
        int r214 = r38;
        r8 = r37;
        r26 = r214;
        goto L95
    L82:
        r37 = this.mBottom;
        r38 = getPaddingBottom();
        goto L83
    L96:
        r33[0] = r113;
        r33[1] = r112;
        return;
    L62:
        if (getVerticalDimensionBehaviour() == r19) goto L65;
        r110 = false;
        goto L66
    L33:
        r0 = 0;
        int r42 = 0;
        int r120 = 0;
    L34:
        if (r120 >= r30) goto L59;
        ConstraintWidget r121 = r29[r120];
        int r122 = getWidgetHeight(r121, r32);
        if (r121.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L38;
        r0 = r0 + 1;
    L38:
        int r123 = r0;
        if (r42 == r32) goto L43;
        if (((this.mVerticalGap + r42) + r122) > r32) goto L43;
    L45:
        boolean r43 = false;
    L46:
        if (r43 == true) goto L53;
        if (r120 <= 0) goto L53;
        int r44 = this.mMaxElementsWrap;
        if (r44 <= 0) goto L53;
        if ((r120 % r44) != 0) goto L53;
        r43 = true;
    L53:
        if (r43 == false) goto L56;
        r10 = new WidgetsList(this, r31, this.mLeft, this.mTop, this.mRight, this.mBottom, r32);
        r10.setStartIndex(r120);
        this.mChainList.add(r10);
    L55:
        r42 = r122;
    L58:
        r10.add(r121);
        r120 = r120 + 1;
        r0 = r123;
        goto L34
    L56:
        if (r120 <= 0) goto L55;
        r42 = (this.mVerticalGap + r122) + r42;
    L43:
        if (WidgetsList.access$2000(r10) == null) goto L45;
        r43 = true;
        goto L46
    }

    private void measureChainWrap_new(ConstraintWidget[] r29, int r30, int r31, int r32, int[] r33) {
        if (r30 != 0) goto L5;
        return;
    L5:
        this.mChainList.clear();
        WidgetsList r10 = new WidgetsList(this, r31, this.mLeft, this.mTop, this.mRight, this.mBottom, r32);
        this.mChainList.add(r10);
        if (r31 != 0) goto L33;
        int r0 = 0;
        int r1 = 0;
        int r2 = 0;
        int r11 = 0;
    L8:
        if (r11 >= r30) goto L58;
        int r12 = r0 + 1;
        ConstraintWidget r13 = r29[r11];
        int r14 = getWidgetWidth(r13, r32);
        if (r13.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L12;
        r1 = r1 + 1;
    L12:
        int r16 = r1;
        if (r2 == r32) goto L17;
        if (((this.mHorizontalGap + r2) + r14) > r32) goto L17;
    L19:
        boolean r3 = false;
    L20:
        if (r3 == true) goto L26;
        if (r11 <= 0) goto L26;
        int r4 = this.mMaxElementsWrap;
        if (r4 <= 0) goto L26;
        if (r12 <= r4) goto L26;
        r3 = true;
    L26:
        if (r3 == false) goto L28;
        r10 = new WidgetsList(this, r31, this.mLeft, this.mTop, this.mRight, this.mBottom, r32);
        r10.setStartIndex(r11);
        this.mChainList.add(r10);
        r0 = r12;
        r2 = r14;
    L32:
        r10.add(r13);
        r11 = r11 + 1;
        r1 = r16;
        goto L8
    L28:
        if (r11 <= 0) goto L31;
        r2 = (this.mHorizontalGap + r14) + r2;
    L30:
        r0 = 0;
        goto L32
    L31:
        r2 = r14;
    L17:
        if (WidgetsList.access$2000(r10) == null) goto L19;
        r3 = true;
    L58:
        int r5 = this.mChainList.size();
        ConstraintAnchor r6 = this.mLeft;
        ConstraintAnchor r7 = this.mTop;
        ConstraintAnchor r8 = this.mRight;
        ConstraintAnchor r9 = this.mBottom;
        int r15 = getPaddingLeft();
        int r17 = getPaddingTop();
        int r18 = getPaddingRight();
        int r19 = getPaddingBottom();
        ConstraintWidget.DimensionBehaviour r110 = getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r111 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r110 != r111) goto L61;
    L64:
        boolean r112 = true;
    L65:
        if (r1 <= 0) goto L74;
        if (r112 == false) goto L74;
        int r20 = 0;
    L68:
        if (r20 >= r5) goto L74;
        WidgetsList r113 = this.mChainList.get(r20);
        if (r31 != 0) goto L72;
        r113.measureMatchConstraints(r32 - r113.getWidth());
    L73:
        r20 = r20 + 1;
        goto L68
    L72:
        r113.measureMatchConstraints(r32 - r113.getHeight());
    L74:
        int r22 = r17;
        int r21 = r18;
        int r114 = 0;
        int r115 = 0;
        int r116 = 0;
        int r23 = r15;
        ConstraintAnchor r24 = r7;
        ConstraintAnchor r25 = r6;
        int r26 = r19;
    L75:
        if (r116 >= r5) goto L95;
        WidgetsList r27 = this.mChainList.get(r116);
        if (r31 == 0) goto L79;
        ConstraintAnchor r210 = r25;
        int r28 = r114;
        int r34 = r115;
        int r35 = r116;
        if (r35 >= (r5 - 1)) goto L89;
        ConstraintAnchor r211 = WidgetsList.access$2000(this.mChainList.get(r35 + 1)).mLeft;
        int r212 = 0;
    L90:
        ConstraintAnchor r117 = WidgetsList.access$2000(r27).mRight;
        r27.setup(r31, r210, r24, r211, r9, r23, r22, r212, r26, r32);
        r115 = r34 + r27.getWidth();
        int r36 = Math.max(r28, r27.getHeight());
        if (r35 <= 0) goto L93;
        r115 = r115 + this.mHorizontalGap;
    L93:
        r114 = r36;
        r23 = 0;
        r21 = r212;
        r25 = r117;
    L94:
        r116 = r35 + 1;
        r8 = r211;
        goto L75
    L89:
        r211 = this.mRight;
        r212 = getPaddingRight();
        goto L90
    L79:
        if (r116 >= (r5 - 1)) goto L81;
        ConstraintAnchor r37 = WidgetsList.access$2000(this.mChainList.get(r116 + 1)).mTop;
        int r38 = 0;
    L82:
        ConstraintAnchor r118 = WidgetsList.access$2000(r27).mBottom;
        ConstraintAnchor r119 = r25;
        ConstraintAnchor r213 = r25;
        int r39 = r114;
        ConstraintAnchor r120 = r24;
        int r40 = r115;
        ConstraintAnchor r121 = r8;
        ConstraintAnchor r310 = r8;
        r35 = r116;
        r27.setup(r31, r119, r120, r121, r37, r23, r22, r21, r38, r32);
        int r41 = Math.max(r40, r27.getWidth());
        r114 = r39 + r27.getHeight();
        if (r35 <= 0) goto L85;
        r114 = r114 + this.mVerticalGap;
    L85:
        r25 = r213;
        r115 = r41;
        r22 = 0;
        r24 = r118;
        r211 = r310;
        int r214 = r38;
        r9 = r37;
        r26 = r214;
        goto L94
    L81:
        r37 = this.mBottom;
        r38 = getPaddingBottom();
        goto L82
    L95:
        r33[0] = r115;
        r33[1] = r114;
        return;
    L61:
        if (getVerticalDimensionBehaviour() == r111) goto L64;
        r112 = false;
        goto L65
    L33:
        int r42 = 0;
        r1 = 0;
        int r122 = 0;
    L34:
        if (r122 >= r30) goto L58;
        ConstraintWidget r123 = r29[r122];
        int r124 = getWidgetHeight(r123, r32);
        if (r123.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L38;
        r1 = r1 + 1;
    L38:
        int r125 = r1;
        if (r42 == r32) goto L43;
        if (((this.mVerticalGap + r42) + r124) > r32) goto L43;
    L45:
        boolean r43 = false;
    L46:
        if (r43 == true) goto L52;
        if (r122 <= 0) goto L52;
        int r44 = this.mMaxElementsWrap;
        if (r44 <= 0) goto L52;
        if (r44 >= 0) goto L52;
        r43 = true;
    L52:
        if (r43 == false) goto L55;
        r10 = new WidgetsList(this, r31, this.mLeft, this.mTop, this.mRight, this.mBottom, r32);
        r10.setStartIndex(r122);
        this.mChainList.add(r10);
    L54:
        r42 = r124;
    L57:
        r10.add(r123);
        r122 = r122 + 1;
        r1 = r125;
        goto L34
    L55:
        if (r122 <= 0) goto L54;
        r42 = (this.mVerticalGap + r124) + r42;
    L43:
        if (WidgetsList.access$2000(r10) == null) goto L45;
        r43 = true;
        goto L46
    }

    private void measureNoWrap(ConstraintWidget[] r23, int r24, int r25, int r26, int[] r27) {
        if (r24 != 0) goto L6;
        return;
    L6:
        if (this.mChainList.size() != 0) goto L8;
        WidgetsList r11 = new WidgetsList(this, r25, this.mLeft, this.mTop, this.mRight, this.mBottom, r26);
        this.mChainList.add(r11);
    L9:
        int r0 = 0;
    L10:
        if (r0 >= r24) goto L12;
        r11.add(r23[r0]);
        r0 = r0 + 1;
        goto L10
    L12:
        r27[0] = r11.getWidth();
        r27[1] = r11.getHeight();
        return;
    L8:
        WidgetsList r1 = this.mChainList.get(0);
        r1.clear();
        r11 = r1;
        r11.setup(r25, this.mLeft, this.mTop, this.mRight, this.mBottom, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom(), r26);
        goto L9
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(LinearSystem r6, boolean r7) {
        super.addToSolver(r6, r7);
        if (getParent() != null) goto L5;
    L7:
        boolean r8 = false;
    L8:
        int r1 = this.mWrapMode;
        if (r1 == 0) goto L32;
        if (r1 != 1) goto L12;
        int r2 = this.mChainList.size();
        int r3 = 0;
    L25:
        if (r3 >= r2) goto L34;
        WidgetsList r4 = this.mChainList.get(r3);
        if (r3 != (r2 - 1)) goto L29;
        boolean r5 = true;
    L30:
        r4.createConstraints(r8, r3, r5);
        r3 = r3 + 1;
        goto L25
    L29:
        r5 = false;
    L34:
        needsCallbackFromSolver(false);
        return;
    L12:
        if (r1 != 2) goto L14;
        createAlignedConstraints(r8);
        goto L34
    L14:
        if (r1 != 3) goto L34;
        int r9 = this.mChainList.size();
        int r10 = 0;
    L17:
        if (r10 >= r9) goto L34;
        WidgetsList r11 = this.mChainList.get(r10);
        if (r10 != (r9 - 1)) goto L21;
        boolean r12 = true;
    L22:
        r11.createConstraints(r8, r10, r12);
        r10 = r10 + 1;
        goto L17
    L21:
        r12 = false;
        goto L22
    L32:
        if (this.mChainList.size() <= 0) goto L34;
        this.mChainList.get(0).createConstraints(r8, 0, true);
        goto L34
    L5:
        if (((ConstraintWidgetContainer) getParent()).isRtl() == false) goto L7;
        r8 = true;
        goto L8
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void copy(ConstraintWidget r1, HashMap<ConstraintWidget, ConstraintWidget> r2) {
        super.copy(r1, r2);
        Flow r3 = (Flow) r1;
        this.mHorizontalStyle = r3.mHorizontalStyle;
        this.mVerticalStyle = r3.mVerticalStyle;
        this.mFirstHorizontalStyle = r3.mFirstHorizontalStyle;
        this.mFirstVerticalStyle = r3.mFirstVerticalStyle;
        this.mLastHorizontalStyle = r3.mLastHorizontalStyle;
        this.mLastVerticalStyle = r3.mLastVerticalStyle;
        this.mHorizontalBias = r3.mHorizontalBias;
        this.mVerticalBias = r3.mVerticalBias;
        this.mFirstHorizontalBias = r3.mFirstHorizontalBias;
        this.mFirstVerticalBias = r3.mFirstVerticalBias;
        this.mLastHorizontalBias = r3.mLastHorizontalBias;
        this.mLastVerticalBias = r3.mLastVerticalBias;
        this.mHorizontalGap = r3.mHorizontalGap;
        this.mVerticalGap = r3.mVerticalGap;
        this.mHorizontalAlign = r3.mHorizontalAlign;
        this.mVerticalAlign = r3.mVerticalAlign;
        this.mWrapMode = r3.mWrapMode;
        this.mMaxElementsWrap = r3.mMaxElementsWrap;
        this.mOrientation = r3.mOrientation;
    }

    public float getMaxElementsWrap() {
        return this.mMaxElementsWrap;
    }

    @Override // androidx.constraintlayout.core.widgets.VirtualLayout
    public void measure(int r19, int r20, int r21, int r22) {
        if (this.mWidgetsCount > 0) goto L5;
    L8:
        int r12 = getPaddingLeft();
        int r13 = getPaddingRight();
        int r14 = getPaddingTop();
        int r15 = getPaddingBottom();
        int[] r5 = new int[2];
        int r1 = (r20 - r12) - r13;
        int r2 = this.mOrientation;
        if (r2 != 1) goto L11;
        r1 = (r22 - r14) - r15;
    L11:
        int r16 = r1;
        if (r2 != 0) goto L20;
        if (this.mHorizontalStyle != (-1)) goto L17;
        this.mHorizontalStyle = 0;
    L17:
        if (this.mVerticalStyle != (-1)) goto L25;
        this.mVerticalStyle = 0;
    L25:
        ConstraintWidget[] r3 = this.mWidgets;
        int r4 = 0;
        int r6 = 0;
    L26:
        int r11 = this.mWidgetsCount;
        if (r4 >= r11) goto L32;
        if (this.mWidgets[r4].getVisibility() != 8) goto L31;
        r6 = r6 + 1;
    L31:
        r4 = r4 + 1;
        goto L26
    L32:
        if (r6 <= 0) goto L41;
        r3 = new ConstraintWidget[r11 - r6];
        int r7 = 0;
        int r8 = 0;
    L35:
        if (r7 >= this.mWidgetsCount) goto L40;
        ConstraintWidget r17 = this.mWidgets[r7];
        if (r17.getVisibility() == 8) goto L39;
        r3[r8] = r17;
        r8 = r8 + 1;
    L39:
        r7 = r7 + 1;
        goto L35
    L40:
        int r9 = r8;
    L42:
        this.mDisplayedWidgets = r3;
        this.mDisplayedWidgetsCount = r9;
        int r0 = this.mWrapMode;
        if (r0 != 0) goto L45;
        boolean r18 = true;
        measureNoWrap(r3, r9, this.mOrientation, r16, r5);
    L56:
        int r10 = (r5[0] + r12) + r13;
        int r23 = (r5[r18 ? 1 : 0] + r14) + r15;
        if (r19 != 1073741824) goto L59;
        r10 = r20;
    L64:
        if (r21 != 1073741824) goto L66;
        r23 = r22;
    L71:
        setMeasure(r10, r23);
        setWidth(r10);
        setHeight(r23);
        if (this.mWidgetsCount > 0) goto L75;
        r18 = false;
    L75:
        needsCallbackFromSolver(r18);
        return;
    L66:
        if (r21 != Integer.MIN_VALUE) goto L68;
        r23 = Math.min(r23, r22);
        goto L71
    L68:
        if (r21 == 0) goto L71;
        r23 = 0;
        goto L71
    L59:
        if (r19 != Integer.MIN_VALUE) goto L61;
        r10 = Math.min(r10, r20);
        goto L64
    L61:
        if (r19 == 0) goto L64;
        r10 = 0;
        goto L64
    L45:
        if (r0 != 1) goto L47;
        r18 = true;
        measureChainWrap(r3, r9, this.mOrientation, r16, r5);
        goto L56
    L47:
        if (r0 != 2) goto L49;
        r18 = true;
        measureAligned(r3, r9, this.mOrientation, r16, r5);
        goto L56
    L49:
        if (r0 == 3) goto L52;
        r18 = true;
        goto L56
    L52:
        r18 = true;
        measureChainWrap_new(r3, r9, this.mOrientation, r16, r5);
        goto L56
    L41:
        r9 = r11;
        goto L42
    L20:
        if (this.mHorizontalStyle != (-1)) goto L23;
        this.mHorizontalStyle = 0;
    L23:
        if (this.mVerticalStyle != (-1)) goto L25;
        this.mVerticalStyle = 0;
        goto L25
    L5:
        if (measureChildren() == true) goto L8;
        setMeasure(0, 0);
        needsCallbackFromSolver(false);
    }

    public void setFirstHorizontalBias(float r1) {
        this.mFirstHorizontalBias = r1;
    }

    public void setFirstHorizontalStyle(int r1) {
        this.mFirstHorizontalStyle = r1;
    }

    public void setFirstVerticalBias(float r1) {
        this.mFirstVerticalBias = r1;
    }

    public void setFirstVerticalStyle(int r1) {
        this.mFirstVerticalStyle = r1;
    }

    public void setHorizontalAlign(int r1) {
        this.mHorizontalAlign = r1;
    }

    public void setHorizontalBias(float r1) {
        this.mHorizontalBias = r1;
    }

    public void setHorizontalGap(int r1) {
        this.mHorizontalGap = r1;
    }

    public void setHorizontalStyle(int r1) {
        this.mHorizontalStyle = r1;
    }

    public void setLastHorizontalBias(float r1) {
        this.mLastHorizontalBias = r1;
    }

    public void setLastHorizontalStyle(int r1) {
        this.mLastHorizontalStyle = r1;
    }

    public void setLastVerticalBias(float r1) {
        this.mLastVerticalBias = r1;
    }

    public void setLastVerticalStyle(int r1) {
        this.mLastVerticalStyle = r1;
    }

    public void setMaxElementsWrap(int r1) {
        this.mMaxElementsWrap = r1;
    }

    public void setOrientation(int r1) {
        this.mOrientation = r1;
    }

    public void setVerticalAlign(int r1) {
        this.mVerticalAlign = r1;
    }

    public void setVerticalBias(float r1) {
        this.mVerticalBias = r1;
    }

    public void setVerticalGap(int r1) {
        this.mVerticalGap = r1;
    }

    public void setVerticalStyle(int r1) {
        this.mVerticalStyle = r1;
    }

    public void setWrapMode(int r1) {
        this.mWrapMode = r1;
    }
}
