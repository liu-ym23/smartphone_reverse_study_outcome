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

    private class WidgetsList {
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

        public WidgetsList(Flow r3, int r4, ConstraintAnchor r5, ConstraintAnchor r6, ConstraintAnchor r7, ConstraintAnchor r8, int r9) {
            this.this$0 = r3;
            this.mOrientation = 0;
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
            this.mOrientation = r4;
            this.mLeft = r5;
            this.mTop = r6;
            this.mRight = r7;
            this.mBottom = r8;
            this.mPaddingLeft = r3.getPaddingLeft();
            this.mPaddingTop = r3.getPaddingTop();
            this.mPaddingRight = r3.getPaddingRight();
            this.mPaddingBottom = r3.getPaddingBottom();
            this.mMax = r9;
        }

        static /* synthetic */ ConstraintWidget access$2000(WidgetsList r0) {
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
            this.mWidth += r4 + r6;
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
            this.mHeight += r8 + r9;
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
            this.mWidth += r0 + r2;
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
            this.mHeight += r5 + r2;
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
            if (this.biggest == null) goto L223;
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
            if (this.mOrientation != 0) goto L129;
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
            if (r16 >= r1) goto L224;
            if (r17 == false) goto L66;
            int r110 = (r1 - 1) - r16;
        L68:
            if ((this.mStartIndex + r110) >= Flow.access$400(this.this$0)) goto L225;
            ConstraintWidget r111 = Flow.access$500(this.this$0)[this.mStartIndex + r110];
            if (r111 != null) goto L73;
            r111 = r11;
            char r20 = r14;
        L128:
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
        L88:
            r112 = r114;
            goto L96
        L95:
            r114 = Flow.access$1300(this.this$0);
            goto L88
        L82:
            if (Flow.access$1000(this.this$0) == (-1)) goto L89;
            r21 = Flow.access$1000(this.this$0);
            if (r17 == false) goto L87;
            r113 = Flow.access$1100(this.this$0);
            goto L86
        L87:
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
            if (r111 == r12) goto L127;
            r20 = 3;
            if (Flow.access$700(this.this$0) == 3) goto L111;
        L116:
            int r22 = Flow.access$700(this.this$0);
            if (r22 != 0) goto L119;
            ConstraintAnchor r23 = r111.mTop;
            ConstraintAnchor r115 = r12.mTop;
        L126:
            r23.connect(r115, 0);
            goto L128
        L119:
            if (r22 == 1) goto L124;
            ConstraintAnchor r24 = r111.mTop;
            if (r5 == false) goto L123;
            r24.connect(this.mTop, this.mPaddingTop);
            r111.mBottom.connect(this.mBottom, this.mPaddingBottom);
            goto L128
        L123:
            r24.connect(r12.mTop, 0);
        L124:
            r23 = r111.mBottom;
            r115 = r12.mBottom;
            goto L126
        L111:
            if (r15.hasBaseline() == false) goto L116;
            if (r111 == r15) goto L116;
            if (r111.hasBaseline() == false) goto L116;
            r23 = r111.mBaseline;
            r115 = r15.mBaseline;
            goto L126
        L127:
            r20 = 3;
            goto L128
        L225:
            return;
        L66:
            r110 = r16;
            goto L68
        L224:
            return;
        L48:
            if (r12.hasBaseline() == true) goto L61;
            int r116 = 0;
        L50:
            if (r116 >= r1) goto L61;
            if (r17 == false) goto L53;
            int r117 = (r1 - 1) - r116;
        L55:
            if ((this.mStartIndex + r117) >= Flow.access$400(this.this$0)) goto L61;
            r15 = Flow.access$500(this.this$0)[this.mStartIndex + r117];
            if (r15.hasBaseline() == true) goto L62;
            r116 = r116 + 1;
            goto L50
        L53:
            r117 = r116;
            goto L55
        L129:
            ConstraintWidget r25 = this.biggest;
            r25.setHorizontalChainStyle(Flow.access$800(this.this$0));
            int r26 = this.mPaddingLeft;
            if (r18 <= 0) goto L132;
            r26 = r26 + Flow.access$000(this.this$0);
        L132:
            if (r17 == false) goto L138;
            r25.mRight.connect(this.mRight, r26);
            if (r19 == false) goto L136;
            r25.mLeft.connect(this.mLeft, this.mPaddingRight);
        L136:
            if (r18 <= 0) goto L144;
            ConstraintAnchor r27 = this.mRight.mOwner.mLeft;
            ConstraintAnchor r118 = r25.mRight;
        L143:
            r27.connect(r118, 0);
        L144:
            int r28 = 0;
        L145:
            if (r28 >= r1) goto L226;
            if ((this.mStartIndex + r28) >= Flow.access$400(this.this$0)) goto L227;
            ConstraintWidget r119 = Flow.access$500(this.this$0)[this.mStartIndex + r28];
            if (r119 == null) goto L199;
            if (r28 != 0) goto L164;
            r119.connect(r119.mTop, this.mTop, this.mPaddingTop);
            int r120 = Flow.access$600(this.this$0);
            float r121 = Flow.access$1400(this.this$0);
            if (this.mStartIndex == 0) goto L156;
        L158:
            if (r19 == true) goto L160;
        L162:
            r119.setVerticalChainStyle(r120);
            r119.setVerticalBiasPercent(r121);
            goto L164
        L160:
            if (Flow.access$1700(this.this$0) == (-1)) goto L162;
            r120 = Flow.access$1700(this.this$0);
            r121 = Flow.access$1800(this.this$0);
            goto L162
        L156:
            if (Flow.access$1500(this.this$0) == (-1)) goto L158;
            r120 = Flow.access$1500(this.this$0);
            r121 = Flow.access$1600(this.this$0);
        L164:
            if (r28 != (r1 - 1)) goto L166;
            r119.connect(r119.mBottom, this.mBottom, this.mPaddingBottom);
        L166:
            if (r11 == null) goto L173;
            r119.mTop.connect(r11.mBottom, Flow.access$100(this.this$0));
            if (r28 != r7) goto L170;
            r119.mTop.setGoneMargin(this.mPaddingTop);
        L170:
            r11.mBottom.connect(r119.mTop, 0);
            if (r28 != (r8 + 1)) goto L173;
            r11.mBottom.setGoneMargin(this.mPaddingBottom);
        L173:
            if (r119 == r25) goto L198;
            int r122 = Flow.access$1900(this.this$0);
            if (r17 == false) goto L186;
            if (r122 != 0) goto L178;
        L183:
            ConstraintAnchor r29 = r119.mRight;
            ConstraintAnchor r123 = r25.mRight;
        L184:
            r29.connect(r123, 0);
            goto L198
        L178:
            if (r122 == 1) goto L182;
            if (r122 != 2) goto L198;
            r119.mLeft.connect(r25.mLeft, 0);
            goto L183
        L182:
            r29 = r119.mLeft;
            r123 = r25.mLeft;
            goto L184
        L186:
            if (r122 == 0) goto L195;
            if (r122 == 1) goto L194;
            if (r122 != 2) goto L198;
            ConstraintAnchor r30 = r119.mLeft;
            if (r5 == false) goto L193;
            r30.connect(this.mLeft, this.mPaddingLeft);
            r119.mRight.connect(this.mRight, this.mPaddingRight);
            goto L198
        L193:
            r30.connect(r25.mLeft, 0);
        L194:
            ConstraintAnchor r31 = r119.mRight;
            ConstraintAnchor r124 = r25.mRight;
        L196:
            r31.connect(r124, 0);
            goto L198
        L195:
            r31 = r119.mLeft;
            r124 = r25.mLeft;
        L198:
            r11 = r119;
        L199:
            r28 = r28 + 1;
            goto L145
        L227:
            return;
        L226:
            return;
        L138:
            r25.mLeft.connect(this.mLeft, r26);
            if (r19 == false) goto L141;
            r25.mRight.connect(this.mRight, this.mPaddingRight);
        L141:
            if (r18 <= 0) goto L144;
            r27 = this.mLeft.mOwner.mRight;
            r118 = r25.mLeft;
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
            if (r2 >= r1) goto L26;
            if ((this.mStartIndex + r2) >= Flow.access$400(this.this$0)) goto L26;
            ConstraintWidget r3 = Flow.access$500(this.this$0)[this.mStartIndex + r2];
            if (this.mOrientation != 0) goto L18;
            if (r3 == null) goto L25;
            if (r3.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L25;
            if (r3.mMatchConstraintDefaultWidth != 0) goto L25;
            Flow r4 = this.this$0;
            ConstraintWidget.DimensionBehaviour r5 = ConstraintWidget.DimensionBehaviour.FIXED;
            ConstraintWidget.DimensionBehaviour r6 = r3.getVerticalDimensionBehaviour();
            int r7 = r3.getHeight();
            int r8 = r10;
        L24:
            r4.measure(r3, r5, r8, r6, r7);
        L25:
            r2 = r2 + 1;
            goto L6
        L18:
            if (r3 == null) goto L25;
            if (r3.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L25;
            if (r3.mMatchConstraintDefaultHeight != 0) goto L25;
            r4 = this.this$0;
            r5 = r3.getHorizontalDimensionBehaviour();
            r8 = r3.getWidth();
            r6 = ConstraintWidget.DimensionBehaviour.FIXED;
            r7 = r10;
        L26:
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

    static /* synthetic */ int access$000(Flow r0) {
        return r0.mHorizontalGap;
    }

    static /* synthetic */ int access$100(Flow r0) {
        return r0.mVerticalGap;
    }

    static /* synthetic */ int access$1000(Flow r0) {
        return r0.mFirstHorizontalStyle;
    }

    static /* synthetic */ float access$1100(Flow r0) {
        return r0.mFirstHorizontalBias;
    }

    static /* synthetic */ int access$1200(Flow r0) {
        return r0.mLastHorizontalStyle;
    }

    static /* synthetic */ float access$1300(Flow r0) {
        return r0.mLastHorizontalBias;
    }

    static /* synthetic */ float access$1400(Flow r0) {
        return r0.mVerticalBias;
    }

    static /* synthetic */ int access$1500(Flow r0) {
        return r0.mFirstVerticalStyle;
    }

    static /* synthetic */ float access$1600(Flow r0) {
        return r0.mFirstVerticalBias;
    }

    static /* synthetic */ int access$1700(Flow r0) {
        return r0.mLastVerticalStyle;
    }

    static /* synthetic */ float access$1800(Flow r0) {
        return r0.mLastVerticalBias;
    }

    static /* synthetic */ int access$1900(Flow r0) {
        return r0.mHorizontalAlign;
    }

    static /* synthetic */ int access$200(Flow r0, ConstraintWidget r1, int r2) {
        return r0.getWidgetWidth(r1, r2);
    }

    static /* synthetic */ int access$300(Flow r0, ConstraintWidget r1, int r2) {
        return r0.getWidgetHeight(r1, r2);
    }

    static /* synthetic */ int access$400(Flow r0) {
        return r0.mDisplayedWidgetsCount;
    }

    static /* synthetic */ ConstraintWidget[] access$500(Flow r0) {
        return r0.mDisplayedWidgets;
    }

    static /* synthetic */ int access$600(Flow r0) {
        return r0.mVerticalStyle;
    }

    static /* synthetic */ int access$700(Flow r0) {
        return r0.mVerticalAlign;
    }

    static /* synthetic */ int access$800(Flow r0) {
        return r0.mHorizontalStyle;
    }

    static /* synthetic */ float access$900(Flow r0) {
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
        ConstraintWidget r5 = null;
        float r6 = this.mHorizontalBias;
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
        if (r5 == null) goto L32;
        r10.connect(r10.mLeft, r5.mRight, this.mHorizontalGap);
        r5.connect(r5.mRight, r10.mLeft, 0);
    L32:
        r5 = r10;
    L33:
        r7 = r7 + 1;
        r6 = r9;
        goto L15
    L18:
        r9 = r6;
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
        if (r5 == null) goto L49;
        r11.connect(r11.mTop, r5.mBottom, this.mVerticalGap);
        r5.connect(r5.mBottom, r11.mTop, 0);
    L49:
        r5 = r11;
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

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:103:0x0119 -> B:40:0x0061). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:104:0x011b -> B:40:0x0061). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x0121 -> B:40:0x0061). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:107:0x0123 -> B:40:0x0061). Please report as a decompilation issue!!! */
    private void measureAligned(ConstraintWidget[] r17, int r18, int r19, int r20, int[] r21) {
        int r6 = this.mMaxElementsWrap;
        if (r19 != 0) goto L18;
        if (r6 > 0) goto L17;
        r6 = 0;
        int r7 = 0;
        int r8 = 0;
    L6:
        if (r7 >= r18) goto L17;
        if (r7 <= 0) goto L9;
        r8 = r8 + this.mHorizontalGap;
    L9:
        ConstraintWidget r9 = r17[r7];
        if (r9 == null) goto L16;
        r8 = r8 + getWidgetWidth(r9, r20);
        if (r8 > r20) goto L17;
        r6 = r6 + 1;
    L16:
        r7 = r7 + 1;
    L17:
        int r10 = r6;
        r6 = 0;
    L33:
        if (this.mAlignedDimensions != null) goto L36;
        this.mAlignedDimensions = new int[2];
    L36:
        if (r6 != 0) goto L38;
        if (r19 != 1) goto L38;
    L40:
        boolean r11 = true;
    L42:
        if (r11 == true) goto L109;
        if (r19 != 0) goto L45;
        r6 = (int) Math.ceil(r18 / r10);
    L46:
        ConstraintWidget[] r12 = this.mAlignedBiggestElementsInCols;
        if (r12 != null) goto L49;
    L52:
        this.mAlignedBiggestElementsInCols = new ConstraintWidget[r10];
    L53:
        ConstraintWidget[] r13 = this.mAlignedBiggestElementsInRows;
        if (r13 != null) goto L56;
    L59:
        this.mAlignedBiggestElementsInRows = new ConstraintWidget[r6];
    L60:
        int r14 = 0;
    L61:
        if (r14 >= r10) goto L85;
        int r15 = 0;
    L63:
        if (r15 >= r6) goto L84;
        int r16 = (r15 * r10) + r14;
        if (r19 != 1) goto L68;
        r16 = (r14 * r6) + r15;
    L68:
        if (r16 >= r17.length) goto L83;
        ConstraintWidget r110 = r17[r16];
        if (r110 == null) goto L83;
        int r111 = getWidgetWidth(r110, r20);
        ConstraintWidget[] r112 = this.mAlignedBiggestElementsInCols;
        if (r112[r14] != null) goto L76;
    L77:
        this.mAlignedBiggestElementsInCols[r14] = r110;
    L78:
        int r113 = getWidgetHeight(r110, r20);
        ConstraintWidget[] r114 = this.mAlignedBiggestElementsInRows;
        if (r114[r15] != null) goto L81;
    L82:
        this.mAlignedBiggestElementsInRows[r15] = r110;
        goto L83
    L81:
        if (r114[r15].getHeight() >= r113) goto L83;
    L76:
        if (r112[r14].getWidth() >= r111) goto L78;
    L83:
        r15 = r15 + 1;
        goto L63
    L84:
        r14 = r14 + 1;
        goto L61
    L85:
        int r115 = 0;
        int r116 = 0;
    L86:
        if (r115 >= r10) goto L93;
        ConstraintWidget r117 = this.mAlignedBiggestElementsInCols[r115];
        if (r117 == null) goto L92;
        if (r115 <= 0) goto L91;
        r116 = r116 + this.mHorizontalGap;
    L91:
        r116 = r116 + getWidgetWidth(r117, r20);
    L92:
        r115 = r115 + 1;
        goto L86
    L93:
        int r118 = 0;
        int r119 = 0;
    L94:
        if (r118 >= r6) goto L101;
        ConstraintWidget r120 = this.mAlignedBiggestElementsInRows[r118];
        if (r120 == null) goto L100;
        if (r118 <= 0) goto L99;
        r119 = r119 + this.mVerticalGap;
    L99:
        r119 = r119 + getWidgetHeight(r120, r20);
    L100:
        r118 = r118 + 1;
        goto L94
    L101:
        r21[0] = r116;
        r21[1] = r119;
        if (r19 == 0) goto L103;
        if (r119 <= r20) goto L40;
        if (r6 <= 1) goto L40;
        r6 = r6 - 1;
        goto L42
    L103:
        if (r116 <= r20) goto L40;
        if (r10 <= 1) goto L40;
        r10 = r10 - 1;
        goto L42
    L56:
        if (r13.length < r6) goto L59;
        Arrays.fill(r13, null);
        goto L60
    L49:
        if (r12.length < r10) goto L52;
        Arrays.fill(r12, null);
        goto L53
    L45:
        r10 = (int) Math.ceil(r18 / r6);
        goto L46
    L109:
        int[] r0 = this.mAlignedDimensions;
        r0[0] = r10;
        r0[1] = r6;
        return;
    L38:
        if (r10 != 0) goto L41;
        if (r19 == 0) goto L40;
    L41:
        r11 = false;
        goto L42
    L18:
        if (r6 > 0) goto L31;
        r6 = 0;
        int r22 = 0;
        int r23 = 0;
    L20:
        if (r22 >= r18) goto L31;
        if (r22 <= 0) goto L23;
        r23 = r23 + this.mVerticalGap;
    L23:
        ConstraintWidget r24 = r17[r22];
        if (r24 == null) goto L30;
        r23 = r23 + getWidgetHeight(r24, r20);
        if (r23 > r20) goto L31;
        r6 = r6 + 1;
    L30:
        r22 = r22 + 1;
    L31:
        r10 = 0;
        goto L33
    }

    private void measureChainWrap(ConstraintWidget[] r29, int r30, int r31, int r32, int[] r33) {
        if (r30 != 0) goto L5;
        return;
    L5:
        this.mChainList.clear();
        WidgetsList r10 = new WidgetsList(this, r31, this.mLeft, this.mTop, this.mRight, this.mBottom, r32);
        this.mChainList.add(r10);
        int r0 = 0;
        int r1 = 0;
        int r11 = 0;
        if (r31 != 0) goto L32;
    L7:
        if (r11 >= r30) goto L57;
        ConstraintWidget r12 = r29[r11];
        int r13 = getWidgetWidth(r12, r32);
        if (r12.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L11;
        r0 = r0 + 1;
    L11:
        int r14 = r0;
        if (r1 == r32) goto L16;
        if (((this.mHorizontalGap + r1) + r13) > r32) goto L16;
    L18:
        boolean r2 = false;
    L19:
        if (r2 == true) goto L26;
        if (r11 <= 0) goto L26;
        int r3 = this.mMaxElementsWrap;
        if (r3 <= 0) goto L26;
        if ((r11 % r3) != 0) goto L26;
        r2 = true;
    L26:
        if (r2 == false) goto L29;
        r10 = new WidgetsList(this, r31, this.mLeft, this.mTop, this.mRight, this.mBottom, r32);
        r10.setStartIndex(r11);
        this.mChainList.add(r10);
    L28:
        r1 = r13;
    L31:
        r10.add(r12);
        r11 = r11 + 1;
        r0 = r14;
        goto L7
    L29:
        if (r11 <= 0) goto L28;
        r1 = r1 + (this.mHorizontalGap + r13);
    L16:
        if (WidgetsList.access$2000(r10) == null) goto L18;
        r2 = true;
    L57:
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
        if (r18 != r19) goto L60;
    L63:
        boolean r110 = true;
    L64:
        if (r0 <= 0) goto L73;
        if (r110 == false) goto L73;
        int r20 = 0;
    L67:
        if (r20 >= r4) goto L73;
        WidgetsList r111 = this.mChainList.get(r20);
        if (r31 != 0) goto L71;
        int r112 = r111.getWidth();
    L72:
        r111.measureMatchConstraints(r32 - r112);
        r20 = r20 + 1;
        goto L67
    L71:
        r112 = r111.getHeight();
    L73:
        int r22 = r15;
        int r21 = r16;
        int r113 = 0;
        int r114 = 0;
        int r115 = 0;
        int r23 = r9;
        ConstraintAnchor r24 = r6;
        ConstraintAnchor r25 = r5;
        int r26 = r17;
    L74:
        if (r115 >= r4) goto L94;
        WidgetsList r27 = this.mChainList.get(r115);
        if (r31 == 0) goto L78;
        ConstraintAnchor r210 = r25;
        int r28 = r113;
        int r34 = r114;
        int r35 = r115;
        if (r35 >= (r4 - 1)) goto L88;
        ConstraintAnchor r211 = WidgetsList.access$2000(this.mChainList.get(r35 + 1)).mLeft;
        int r212 = 0;
    L89:
        ConstraintAnchor r116 = WidgetsList.access$2000(r27).mRight;
        r27.setup(r31, r210, r24, r211, r8, r23, r22, r212, r26, r32);
        r114 = r34 + r27.getWidth();
        int r36 = Math.max(r28, r27.getHeight());
        if (r35 <= 0) goto L92;
        r114 = r114 + this.mHorizontalGap;
    L92:
        r113 = r36;
        r23 = 0;
        r21 = r212;
        r25 = r116;
    L93:
        r115 = r35 + 1;
        r7 = r211;
        goto L74
    L88:
        r211 = this.mRight;
        r212 = getPaddingRight();
        goto L89
    L78:
        if (r115 >= (r4 - 1)) goto L80;
        ConstraintAnchor r37 = WidgetsList.access$2000(this.mChainList.get(r115 + 1)).mTop;
        int r38 = 0;
    L81:
        ConstraintAnchor r117 = WidgetsList.access$2000(r27).mBottom;
        ConstraintAnchor r118 = r25;
        ConstraintAnchor r213 = r25;
        int r39 = r113;
        ConstraintAnchor r119 = r24;
        int r40 = r114;
        ConstraintAnchor r120 = r7;
        ConstraintAnchor r310 = r7;
        r35 = r115;
        r27.setup(r31, r118, r119, r120, r37, r23, r22, r21, r38, r32);
        int r41 = Math.max(r40, r27.getWidth());
        r113 = r39 + r27.getHeight();
        if (r35 <= 0) goto L84;
        r113 = r113 + this.mVerticalGap;
    L84:
        r25 = r213;
        r114 = r41;
        r22 = 0;
        r24 = r117;
        r211 = r310;
        int r214 = r38;
        r8 = r37;
        r26 = r214;
        goto L93
    L80:
        r37 = this.mBottom;
        r38 = getPaddingBottom();
        goto L81
    L94:
        r33[0] = r114;
        r33[1] = r113;
        return;
    L60:
        if (getVerticalDimensionBehaviour() == r19) goto L63;
        r110 = false;
    L32:
        if (r11 >= r30) goto L57;
        ConstraintWidget r121 = r29[r11];
        int r122 = getWidgetHeight(r121, r32);
        if (r121.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L36;
        r0 = r0 + 1;
    L36:
        int r123 = r0;
        if (r1 == r32) goto L41;
        if (((this.mVerticalGap + r1) + r122) > r32) goto L41;
    L43:
        boolean r42 = false;
    L44:
        if (r42 == true) goto L51;
        if (r11 <= 0) goto L51;
        int r43 = this.mMaxElementsWrap;
        if (r43 <= 0) goto L51;
        if ((r11 % r43) != 0) goto L51;
        r42 = true;
    L51:
        if (r42 == false) goto L54;
        r10 = new WidgetsList(this, r31, this.mLeft, this.mTop, this.mRight, this.mBottom, r32);
        r10.setStartIndex(r11);
        this.mChainList.add(r10);
    L53:
        r1 = r122;
    L56:
        r10.add(r121);
        r11 = r11 + 1;
        r0 = r123;
        goto L32
    L54:
        if (r11 <= 0) goto L53;
        r1 = r1 + (this.mVerticalGap + r122);
    L41:
        if (WidgetsList.access$2000(r10) == null) goto L43;
        r42 = true;
        goto L44
    }

    private void measureChainWrap_new(ConstraintWidget[] r29, int r30, int r31, int r32, int[] r33) {
        if (r30 != 0) goto L5;
        return;
    L5:
        this.mChainList.clear();
        WidgetsList r10 = new WidgetsList(this, r31, this.mLeft, this.mTop, this.mRight, this.mBottom, r32);
        this.mChainList.add(r10);
        int r0 = 0;
        int r1 = 0;
        if (r31 != 0) goto L33;
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
        if (r11 <= 0) goto L30;
        r2 = r2 + (this.mHorizontalGap + r14);
    L31:
        r0 = 0;
        goto L32
    L30:
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
        int r114 = r113.getWidth();
    L73:
        r113.measureMatchConstraints(r32 - r114);
        r20 = r20 + 1;
        goto L68
    L72:
        r114 = r113.getHeight();
    L74:
        int r22 = r17;
        int r21 = r18;
        int r115 = 0;
        int r116 = 0;
        int r117 = 0;
        int r23 = r15;
        ConstraintAnchor r24 = r7;
        ConstraintAnchor r25 = r6;
        int r26 = r19;
    L75:
        if (r117 >= r5) goto L95;
        WidgetsList r27 = this.mChainList.get(r117);
        if (r31 == 0) goto L79;
        ConstraintAnchor r210 = r25;
        int r28 = r115;
        int r34 = r116;
        int r35 = r117;
        if (r35 >= (r5 - 1)) goto L89;
        ConstraintAnchor r211 = WidgetsList.access$2000(this.mChainList.get(r35 + 1)).mLeft;
        int r212 = 0;
    L90:
        ConstraintAnchor r118 = WidgetsList.access$2000(r27).mRight;
        r27.setup(r31, r210, r24, r211, r9, r23, r22, r212, r26, r32);
        r116 = r34 + r27.getWidth();
        int r36 = Math.max(r28, r27.getHeight());
        if (r35 <= 0) goto L93;
        r116 = r116 + this.mHorizontalGap;
    L93:
        r115 = r36;
        r23 = 0;
        r21 = r212;
        r25 = r118;
    L94:
        r117 = r35 + 1;
        r8 = r211;
        goto L75
    L89:
        r211 = this.mRight;
        r212 = getPaddingRight();
        goto L90
    L79:
        if (r117 >= (r5 - 1)) goto L81;
        ConstraintAnchor r37 = WidgetsList.access$2000(this.mChainList.get(r117 + 1)).mTop;
        int r38 = 0;
    L82:
        ConstraintAnchor r119 = WidgetsList.access$2000(r27).mBottom;
        ConstraintAnchor r120 = r25;
        ConstraintAnchor r213 = r25;
        int r39 = r115;
        ConstraintAnchor r121 = r24;
        int r40 = r116;
        ConstraintAnchor r122 = r8;
        ConstraintAnchor r310 = r8;
        r35 = r117;
        r27.setup(r31, r120, r121, r122, r37, r23, r22, r21, r38, r32);
        int r41 = Math.max(r40, r27.getWidth());
        r115 = r39 + r27.getHeight();
        if (r35 <= 0) goto L85;
        r115 = r115 + this.mVerticalGap;
    L85:
        r25 = r213;
        r116 = r41;
        r22 = 0;
        r24 = r119;
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
        r33[0] = r116;
        r33[1] = r115;
        return;
    L61:
        if (getVerticalDimensionBehaviour() == r111) goto L64;
        r112 = false;
        goto L65
    L33:
        int r123 = 0;
    L34:
        if (r123 >= r30) goto L58;
        ConstraintWidget r124 = r29[r123];
        int r125 = getWidgetHeight(r124, r32);
        if (r124.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L38;
        r1 = r1 + 1;
    L38:
        int r126 = r1;
        if (r0 == r32) goto L43;
        if (((this.mVerticalGap + r0) + r125) > r32) goto L43;
    L45:
        boolean r42 = false;
    L46:
        if (r42 == true) goto L52;
        if (r123 <= 0) goto L52;
        int r43 = this.mMaxElementsWrap;
        if (r43 <= 0) goto L52;
        if (r43 >= 0) goto L52;
        r42 = true;
    L52:
        if (r42 == false) goto L55;
        r10 = new WidgetsList(this, r31, this.mLeft, this.mTop, this.mRight, this.mBottom, r32);
        r10.setStartIndex(r123);
        this.mChainList.add(r10);
    L54:
        r0 = r125;
    L57:
        r10.add(r124);
        r123 = r123 + 1;
        r1 = r126;
        goto L34
    L55:
        if (r123 <= 0) goto L54;
        r0 = r0 + (this.mVerticalGap + r125);
    L43:
        if (WidgetsList.access$2000(r10) == null) goto L45;
        r42 = true;
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
        if (this.mVerticalStyle == (-1)) goto L24;
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
    L24:
        this.mVerticalStyle = 0;
        goto L25
    L20:
        if (this.mHorizontalStyle != (-1)) goto L23;
        this.mHorizontalStyle = 0;
    L23:
        if (this.mVerticalStyle != (-1)) goto L25;
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
