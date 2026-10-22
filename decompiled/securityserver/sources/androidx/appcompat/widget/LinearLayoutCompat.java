package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.badge.BadgeDrawable;
import com.ss.android.common.ApiConstants;
import com.ttnet.org.chromium.net.NetError;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.widget.LinearLayoutCompat";
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface DividerMode {
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity;
        public float weight;

        public LayoutParams(Context r3, AttributeSet r4) {
            super(r3, r4);
            this.gravity = -1;
            TypedArray r5 = r3.obtainStyledAttributes(r4, R.styleable.LinearLayoutCompat_Layout);
            this.weight = r5.getFloat(R.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.gravity = r5.getInt(R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            r5.recycle();
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.gravity = -1;
            this.weight = 0.0f;
        }

        public LayoutParams(int r1, int r2, float r3) {
            super(r1, r2);
            this.gravity = -1;
            this.weight = r3;
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
            this.gravity = -1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r1) {
            super(r1);
            this.gravity = -1;
        }

        public LayoutParams(LayoutParams r2) {
            super(r2);
            this.gravity = -1;
            this.weight = r2.weight;
            this.gravity = r2.gravity;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(@NonNull Context r2) {
        this(r2, null);
    }

    private void forceUniformHeight(int r11, int r12) {
        int r0 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), BasicMeasure.EXACTLY);
        int r1 = 0;
    L3:
        if (r1 >= r11) goto L10;
        View r3 = getVirtualChildAt(r1);
        if (r3.getVisibility() == 8) goto L9;
        LayoutParams r8 = (LayoutParams) r3.getLayoutParams();
        if (((ViewGroup.MarginLayoutParams) r8).height != (-1)) goto L9;
        int r9 = ((ViewGroup.MarginLayoutParams) r8).width;
        ((ViewGroup.MarginLayoutParams) r8).width = r3.getMeasuredWidth();
        measureChildWithMargins(r3, r12, 0, r0, 0);
        ((ViewGroup.MarginLayoutParams) r8).width = r9;
    L9:
        r1 = r1 + 1;
        goto L3
    }

    private void forceUniformWidth(int r11, int r12) {
        int r0 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), BasicMeasure.EXACTLY);
        int r1 = 0;
    L3:
        if (r1 >= r11) goto L10;
        View r3 = getVirtualChildAt(r1);
        if (r3.getVisibility() == 8) goto L9;
        LayoutParams r8 = (LayoutParams) r3.getLayoutParams();
        if (((ViewGroup.MarginLayoutParams) r8).width != (-1)) goto L9;
        int r9 = ((ViewGroup.MarginLayoutParams) r8).height;
        ((ViewGroup.MarginLayoutParams) r8).height = r3.getMeasuredHeight();
        measureChildWithMargins(r3, r0, 0, r12, 0);
        ((ViewGroup.MarginLayoutParams) r8).height = r9;
    L9:
        r1 = r1 + 1;
        goto L3
    }

    private void setChildFrame(View r1, int r2, int r3, int r4, int r5) {
        r1.layout(r2, r3, r4 + r2, r5 + r3);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return r1 instanceof LayoutParams;
    }

    public void drawDividersHorizontal(Canvas r7) {
        int r0 = getVirtualChildCount();
        boolean r1 = ViewUtils.isLayoutRtl(this);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L17;
        View r3 = getVirtualChildAt(r2);
        if (r3 == null) goto L15;
        if (r3.getVisibility() == 8) goto L15;
        if (hasDividerBeforeChildAt(r2) == false) goto L15;
        LayoutParams r4 = (LayoutParams) r3.getLayoutParams();
        if (r1 == false) goto L13;
        int r5 = r3.getRight() + ((ViewGroup.MarginLayoutParams) r4).rightMargin;
    L14:
        drawVerticalDivider(r7, r5);
        goto L15
    L13:
        r5 = (r3.getLeft() - ((ViewGroup.MarginLayoutParams) r4).leftMargin) - this.mDividerWidth;
    L15:
        r2 = r2 + 1;
        goto L3
    L17:
        if (hasDividerBeforeChildAt(r0) == false) goto L35;
        View r6 = getVirtualChildAt(r0 - 1);
        if (r6 != null) goto L24;
        if (r1 == false) goto L22;
        int r8 = getPaddingLeft();
    L28:
        drawVerticalDivider(r7, r8);
        return;
    L22:
        int r9 = getWidth() - getPaddingRight();
        int r10 = this.mDividerWidth;
    L23:
        r8 = r9 - r10;
        goto L28
    L24:
        LayoutParams r11 = (LayoutParams) r6.getLayoutParams();
        if (r1 == false) goto L27;
        r9 = r6.getLeft() - ((ViewGroup.MarginLayoutParams) r11).leftMargin;
        r10 = this.mDividerWidth;
        goto L23
    L27:
        r8 = r6.getRight() + ((ViewGroup.MarginLayoutParams) r11).rightMargin;
        goto L28
    }

    public void drawDividersVertical(Canvas r6) {
        int r0 = getVirtualChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L13;
        View r2 = getVirtualChildAt(r1);
        if (r2 == null) goto L11;
        if (r2.getVisibility() == 8) goto L11;
        if (hasDividerBeforeChildAt(r1) == false) goto L11;
        drawHorizontalDivider(r6, (r2.getTop() - ((ViewGroup.MarginLayoutParams) ((LayoutParams) r2.getLayoutParams())).topMargin) - this.mDividerHeight);
    L11:
        r1 = r1 + 1;
        goto L3
    L13:
        if (hasDividerBeforeChildAt(r0) == false) goto L25;
        View r3 = getVirtualChildAt(r0 - 1);
        if (r3 != null) goto L17;
        int r4 = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
    L18:
        drawHorizontalDivider(r6, r4);
        return;
    L17:
        r4 = r3.getBottom() + ((ViewGroup.MarginLayoutParams) ((LayoutParams) r3.getLayoutParams())).bottomMargin;
        goto L18
    }

    public void drawHorizontalDivider(Canvas r5, int r6) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, r6, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + r6);
        this.mDivider.draw(r5);
    }

    public void drawVerticalDivider(Canvas r6, int r7) {
        this.mDivider.setBounds(r7, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + r7, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(r6);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    @Override // android.view.View
    public int getBaseline() {
        if (this.mBaselineAlignedChildIndex < 0) goto L5;
        int r0 = getChildCount();
        int r1 = this.mBaselineAlignedChildIndex;
        if (r0 <= r1) goto L29;
        View r2 = getChildAt(r1);
        int r3 = r2.getBaseline();
        if (r3 == (-1)) goto L11;
        int r4 = this.mBaselineChildTop;
        if (this.mOrientation != 1) goto L27;
        int r5 = this.mGravity & ApiConstants.OP_ERROR_UGC_POST_TOO_FAST;
        if (r5 == 48) goto L27;
        if (r5 != 16) goto L22;
        r4 = r4 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2);
        goto L27
    L22:
        if (r5 != 80) goto L27;
        r4 = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
    L27:
        return (r4 + ((ViewGroup.MarginLayoutParams) ((LayoutParams) r2.getLayoutParams())).topMargin) + r3;
    L11:
        if (this.mBaselineAlignedChildIndex != 0) goto L14;
        return -1;
    L14:
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
    L29:
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
    L5:
        return super.getBaseline();
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    public int getChildrenSkipCount(View r1, int r2) {
        return 0;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    public int getGravity() {
        return this.mGravity;
    }

    public int getLocationOffset(View r1) {
        return 0;
    }

    public int getNextLocationOffset(View r1) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    public View getVirtualChildAt(int r1) {
        return getChildAt(r1);
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean hasDividerBeforeChildAt(int r5) {
        if (r5 != 0) goto L9;
        if ((this.mShowDividers & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    L9:
        if (r5 != getChildCount()) goto L15;
        if ((this.mShowDividers & 4) != 0) goto L13;
        return false;
    L13:
        return true;
    L15:
        if ((this.mShowDividers & 2) == 0) goto L22;
        int r6 = r5 - 1;
    L17:
        if (r6 < 0) goto L28;
        if (getChildAt(r6).getVisibility() != 8) goto L27;
        r6 = r6 - 1;
        goto L17
    L27:
        return true;
    L28:
        return false;
    L22:
        return false;
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    public void layoutHorizontal(int r25, int r26, int r27, int r28) {
        boolean r0 = ViewUtils.isLayoutRtl(this);
        int r7 = getPaddingTop();
        int r1 = r28 - r26;
        int r8 = r1 - getPaddingBottom();
        int r9 = (r1 - r7) - getPaddingBottom();
        int r10 = getVirtualChildCount();
        int r2 = this.mGravity;
        int r11 = r2 & ApiConstants.OP_ERROR_UGC_POST_TOO_FAST;
        boolean r12 = this.mBaselineAligned;
        int[] r13 = this.mMaxAscent;
        int[] r14 = this.mMaxDescent;
        int r3 = GravityCompat.getAbsoluteGravity(8388615 & r2, ViewCompat.getLayoutDirection(this));
        boolean r5 = true;
        if (r3 != 1) goto L5;
        int r4 = getPaddingLeft() + (((r27 - r25) - this.mTotalLength) / 2);
    L10:
        if (r0 == false) goto L12;
        int r16 = r10 - 1;
        int r17 = -1;
    L13:
        int r6 = 0;
    L14:
        if (r6 >= r10) goto L52;
        int r15 = (r17 * r6) + r16;
        View r18 = getVirtualChildAt(r15);
        if (r18 != null) goto L20;
        r4 = measureNullChild(r15) + r4;
        boolean r21 = r5;
    L51:
        r6 = r6 + 1;
        r10 = r10;
        r11 = r11;
        r5 = r21;
        r7 = r7;
        goto L14
    L20:
        if (r18.getVisibility() == 8) goto L50;
        int r19 = r18.getMeasuredWidth();
        int r20 = r18.getMeasuredHeight();
        LayoutParams r22 = (LayoutParams) r18.getLayoutParams();
        int r110 = r6;
        if (r12 == false) goto L26;
        r10 = r10;
        if (((ViewGroup.MarginLayoutParams) r22).height == (-1)) goto L27;
        int r111 = r18.getBaseline();
    L28:
        int r23 = r22.gravity;
        if (r23 >= 0) goto L31;
        r23 = r11;
    L31:
        int r24 = r23 & ApiConstants.OP_ERROR_UGC_POST_TOO_FAST;
        r11 = r11;
        if (r24 != 16) goto L34;
        r21 = true;
        int r29 = ((((r9 - r20) / 2) + r7) + ((ViewGroup.MarginLayoutParams) r22).topMargin) - ((ViewGroup.MarginLayoutParams) r22).bottomMargin;
    L47:
        if (hasDividerBeforeChildAt(r15) == false) goto L49;
        r4 = r4 + this.mDividerWidth;
    L49:
        int r112 = ((ViewGroup.MarginLayoutParams) r22).leftMargin + r4;
        r7 = r7;
        setChildFrame(r18, getLocationOffset(r18) + r112, r29, r19, r20);
        r4 = (getNextLocationOffset(r18) + (r19 + ((ViewGroup.MarginLayoutParams) r22).rightMargin)) + r112;
        r6 = getChildrenSkipCount(r18, r15) + r110;
        goto L51
    L34:
        if (r24 != 48) goto L36;
        r29 = ((ViewGroup.MarginLayoutParams) r22).topMargin + r7;
        if (r111 != (-1)) goto L44;
    L38:
        r21 = true;
        goto L47
    L44:
        r21 = true;
        r29 = (r13[1] - r111) + r29;
        goto L47
    L36:
        if (r24 == 80) goto L39;
        r29 = r7;
        goto L38
    L39:
        r29 = (r8 - r20) - ((ViewGroup.MarginLayoutParams) r22).bottomMargin;
        if (r111 == (-1)) goto L38;
        r29 = r29 - (r14[2] - (r18.getMeasuredHeight() - r111));
    L27:
        r111 = -1;
        goto L28
    L26:
        r10 = r10;
        goto L27
    L50:
        r21 = true;
        goto L51
    L52:
        return;
    L12:
        r16 = 0;
        r17 = 1;
        goto L13
    L5:
        if (r3 == 5) goto L7;
        r4 = getPaddingLeft();
        goto L10
    L7:
        r4 = ((getPaddingLeft() + r27) - r25) - this.mTotalLength;
        goto L10
    }

    public void layoutVertical(int r18, int r19, int r20, int r21) {
        int r7 = getPaddingLeft();
        int r0 = r20 - r18;
        int r8 = r0 - getPaddingRight();
        int r9 = (r0 - r7) - getPaddingRight();
        int r10 = getVirtualChildCount();
        int r1 = this.mGravity;
        int r2 = r1 & ApiConstants.OP_ERROR_UGC_POST_TOO_FAST;
        int r11 = r1 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (r2 != 16) goto L5;
        int r3 = getPaddingTop() + (((r21 - r19) - this.mTotalLength) / 2);
    L9:
        int r12 = 0;
    L10:
        if (r12 >= r10) goto L34;
        View r13 = getVirtualChildAt(r12);
        if (r13 != null) goto L16;
        r3 = measureNullChild(r12) + r3;
    L14:
        int r4 = 1;
    L33:
        r12 = r12 + r4;
        goto L10
    L16:
        if (r13.getVisibility() == 8) goto L14;
        int r5 = r13.getMeasuredWidth();
        int r15 = r13.getMeasuredHeight();
        LayoutParams r6 = (LayoutParams) r13.getLayoutParams();
        int r14 = r6.gravity;
        if (r14 >= 0) goto L20;
        r14 = r11;
    L20:
        int r16 = GravityCompat.getAbsoluteGravity(r14, ViewCompat.getLayoutDirection(this)) & 7;
        if (r16 != 1) goto L23;
        int r17 = (((r9 - r5) / 2) + r7) + ((ViewGroup.MarginLayoutParams) r6).leftMargin;
        int r22 = ((ViewGroup.MarginLayoutParams) r6).rightMargin;
    L27:
        int r23 = r17 - r22;
    L25:
        int r24 = r23;
        if (hasDividerBeforeChildAt(r12) == false) goto L32;
        r3 = r3 + this.mDividerHeight;
    L32:
        int r110 = r3 + ((ViewGroup.MarginLayoutParams) r6).topMargin;
        setChildFrame(r13, r24, getLocationOffset(r13) + r110, r5, r15);
        r3 = (getNextLocationOffset(r13) + (r15 + ((ViewGroup.MarginLayoutParams) r6).bottomMargin)) + r110;
        r12 = r12 + getChildrenSkipCount(r13, r12);
        r4 = 1;
        goto L33
    L23:
        if (r16 == 5) goto L26;
        r23 = ((ViewGroup.MarginLayoutParams) r6).leftMargin + r7;
        goto L25
    L26:
        r17 = r8 - r5;
        r22 = ((ViewGroup.MarginLayoutParams) r6).rightMargin;
        goto L27
    L34:
        return;
    L5:
        if (r2 == 80) goto L7;
        r3 = getPaddingTop();
        goto L9
    L7:
        r3 = ((getPaddingTop() + r21) - r19) - this.mTotalLength;
        goto L9
    }

    public void measureChildBeforeLayout(View r7, int r8, int r9, int r10, int r11, int r12) {
        measureChildWithMargins(r7, r9, r10, r11, r12);
    }

    public void measureHorizontal(int r40, int r41) {
        this.mTotalLength = 0;
        int r11 = getVirtualChildCount();
        int r12 = View.MeasureSpec.getMode(r40);
        int r13 = View.MeasureSpec.getMode(r41);
        if (this.mMaxAscent != null) goto L5;
    L6:
        this.mMaxAscent = new int[4];
        this.mMaxDescent = new int[4];
    L7:
        int[] r15 = this.mMaxAscent;
        int[] r6 = this.mMaxDescent;
        r15[3] = -1;
        r15[2] = -1;
        r15[1] = -1;
        r15[0] = -1;
        r6[3] = -1;
        r6[2] = -1;
        r6[1] = -1;
        r6[0] = -1;
        boolean r4 = this.mBaselineAligned;
        boolean r3 = this.mUseLargestChild;
        int r2 = BasicMeasure.EXACTLY;
        if (r12 != 1073741824) goto L10;
        boolean r19 = true;
    L11:
        int r1 = 0;
        int r14 = 0;
        int r21 = 0;
        int r22 = 0;
        int r23 = 0;
        boolean r24 = false;
        int r25 = 0;
        boolean r27 = false;
        boolean r26 = true;
        float r0 = 0.0f;
    L12:
        int[] r28 = r6;
        if (r1 >= r11) goto L89;
        View r7 = getVirtualChildAt(r1);
        if (r7 != null) goto L19;
        this.mTotalLength = measureNullChild(r1) + this.mTotalLength;
    L17:
        boolean r33 = r3;
        boolean r37 = r4;
        int r38 = r2;
        int r5 = r1;
        int r8 = r38;
    L88:
        int r9 = r5 + 1;
        r6 = r28;
        r3 = r33;
        r4 = r37;
        r2 = r8;
        r1 = r9;
        goto L12
    L19:
        if (r7.getVisibility() != 8) goto L22;
        r1 = r1 + getChildrenSkipCount(r7, r1);
        goto L17
    L22:
        if (hasDividerBeforeChildAt(r1) == false) goto L24;
        this.mTotalLength += this.mDividerWidth;
    L24:
        LayoutParams r10 = (LayoutParams) r7.getLayoutParams();
        float r16 = r10.weight;
        float r32 = r0 + r16;
        if (r12 != r2) goto L37;
        if (((ViewGroup.MarginLayoutParams) r10).width != 0) goto L37;
        if (r16 <= 0.0f) goto L37;
        if (r19 == false) goto L32;
        this.mTotalLength = (((ViewGroup.MarginLayoutParams) r10).leftMargin + ((ViewGroup.MarginLayoutParams) r10).rightMargin) + this.mTotalLength;
    L33:
        if (r4 == false) goto L35;
        int r17 = View.MeasureSpec.makeMeasureSpec(0, 0);
        r7.measure(r17, r17);
        int r35 = r1;
        r33 = r3;
        r37 = r4;
        View r18 = r7;
    L55:
        r8 = BasicMeasure.EXACTLY;
    L56:
        if (r13 != r8) goto L58;
    L60:
        boolean r20 = false;
    L61:
        int r29 = ((ViewGroup.MarginLayoutParams) r10).topMargin + ((ViewGroup.MarginLayoutParams) r10).bottomMargin;
        int r30 = r18.getMeasuredHeight() + r29;
        r25 = View.combineMeasuredStates(r25, r18.getMeasuredState());
        if (r37 == false) goto L69;
        int r31 = r18.getBaseline();
        if (r31 == (-1)) goto L69;
        int r34 = r10.gravity;
        if (r34 >= 0) goto L68;
        r34 = this.mGravity;
    L68:
        int r36 = (((r34 & ApiConstants.OP_ERROR_UGC_POST_TOO_FAST) >> 4) & (-2)) >> 1;
        r15[r36] = Math.max(r15[r36], r31);
        r28[r36] = Math.max(r28[r36], r30 - r31);
    L69:
        r21 = Math.max(r21, r30);
        if (r26 == true) goto L72;
    L74:
        r26 = false;
    L76:
        if (r10.weight <= 0.0f) goto L82;
        if (r20 == true) goto L80;
        r29 = r30;
    L80:
        r23 = Math.max(r23, r29);
    L81:
        int r110 = r35;
        r5 = getChildrenSkipCount(r18, r110) + r110;
        r0 = r32;
        goto L88
    L82:
        int r111 = r23;
        if (r20 == true) goto L86;
        r29 = r30;
    L86:
        r22 = Math.max(r22, r29);
        r23 = r111;
        goto L81
    L72:
        if (((ViewGroup.MarginLayoutParams) r10).height != (-1)) goto L74;
        r26 = true;
        goto L76
    L58:
        if (((ViewGroup.MarginLayoutParams) r10).height != (-1)) goto L60;
        r20 = true;
        r27 = true;
        goto L61
    L35:
        r35 = r1;
        r33 = r3;
        r37 = r4;
        r18 = r7;
        r24 = true;
        r8 = BasicMeasure.EXACTLY;
        goto L56
    L32:
        int r39 = this.mTotalLength;
        this.mTotalLength = Math.max(r39, (((ViewGroup.MarginLayoutParams) r10).leftMargin + r39) + ((ViewGroup.MarginLayoutParams) r10).rightMargin);
    L37:
        if (((ViewGroup.MarginLayoutParams) r10).width == 0) goto L39;
    L41:
        byte r42 = -2;
        int r43 = Integer.MIN_VALUE;
    L43:
        if (r32 != 0.0f) goto L45;
        int r210 = this.mTotalLength;
    L46:
        r35 = r1;
        int r310 = r43;
        r33 = r3;
        r37 = r4;
        measureChildBeforeLayout(r7, r35, r40, r210, r41, 0);
        if (r310 == Integer.MIN_VALUE) goto L49;
        ((ViewGroup.MarginLayoutParams) r10).width = r310;
    L49:
        int r44 = r7.getMeasuredWidth();
        if (r19 == false) goto L52;
        r18 = r7;
        this.mTotalLength = (getNextLocationOffset(r18) + ((((ViewGroup.MarginLayoutParams) r10).leftMargin + r44) + ((ViewGroup.MarginLayoutParams) r10).rightMargin)) + this.mTotalLength;
    L53:
        if (r33 == false) goto L55;
        r14 = Math.max(r44, r14);
        goto L55
    L52:
        r18 = r7;
        int r45 = this.mTotalLength;
        this.mTotalLength = Math.max(r45, getNextLocationOffset(r18) + (((r45 + r44) + ((ViewGroup.MarginLayoutParams) r10).leftMargin) + ((ViewGroup.MarginLayoutParams) r10).rightMargin));
        goto L53
    L45:
        r210 = 0;
        goto L46
    L39:
        if (r16 <= 0.0f) goto L41;
        r42 = -2;
        ((ViewGroup.MarginLayoutParams) r10).width = -2;
        r43 = 0;
        goto L43
    L89:
        boolean r311 = r3;
        boolean r312 = r4;
        int r46 = r21;
        int r47 = r22;
        int r112 = r23;
        int r48 = r25;
        if (this.mTotalLength > 0) goto L92;
    L94:
        int r49 = r15[1];
        if (r49 == (-1)) goto L97;
    L104:
        int r50 = Math.max(r46, Math.max(r28[3], Math.max(r28[0], Math.max(r28[1], r28[2]))) + Math.max(r15[3], Math.max(r15[0], Math.max(r49, r15[2]))));
    L105:
        if (r311 == true) goto L107;
    L110:
        int r211 = r50;
        int r51 = (getPaddingRight() + getPaddingLeft()) + this.mTotalLength;
        this.mTotalLength = r51;
        int r52 = View.resolveSizeAndState(Math.max(r51, getSuggestedMinimumWidth()), r40, 0);
        int r53 = (16777215 & r52) - this.mTotalLength;
        if (r24 == true) goto L147;
        if (r53 != 0) goto L129;
    L131:
        int r54 = Math.max(r47, r112);
        if (r311 == true) goto L134;
    L146:
        int r212 = r11;
        int r55 = r48;
    L216:
        if (r26 == false) goto L218;
    L220:
        r54 = r211;
    L221:
        setMeasuredDimension(r52 | ((-16777216) & r55), View.resolveSizeAndState(Math.max((getPaddingBottom() + getPaddingTop()) + r54, getSuggestedMinimumHeight()), r41, r55 << 16));
        if (r27 == false) goto L239;
        forceUniformHeight(r212, r40);
        return;
    L239:
        return;
    L218:
        if (r13 == 1073741824) goto L220;
    L134:
        if (r12 == 1073741824) goto L146;
        int r113 = 0;
    L136:
        if (r113 >= r11) goto L146;
        View r56 = getVirtualChildAt(r113);
        if (r56 == null) goto L145;
        if (r56.getVisibility() == 8) goto L145;
        if (((LayoutParams) r56.getLayoutParams()).weight <= 0.0f) goto L145;
        r56.measure(View.MeasureSpec.makeMeasureSpec(r14, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(r56.getMeasuredHeight(), BasicMeasure.EXACTLY));
    L145:
        r113 = r113 + 1;
        goto L136
    L129:
        if (r0 <= 0.0f) goto L131;
    L147:
        float r57 = this.mWeightSum;
        if (r57 <= 0.0f) goto L150;
        r0 = r57;
    L150:
        r15[3] = -1;
        r15[2] = -1;
        r15[1] = -1;
        r15[0] = -1;
        r28[3] = -1;
        r28[2] = -1;
        r28[1] = -1;
        r28[0] = -1;
        this.mTotalLength = 0;
        int r58 = r47;
        int r59 = -1;
        r55 = r48;
        int r114 = 0;
    L151:
        if (r114 >= r11) goto L204;
        View r115 = getVirtualChildAt(r114);
        if (r115 != null) goto L155;
    L156:
        int r60 = r53;
        r11 = r11;
    L203:
        r114 = r114 + 1;
        r53 = r60;
        r11 = r11;
        goto L151
    L155:
        if (r115.getVisibility() == 8) goto L156;
        LayoutParams r61 = (LayoutParams) r115.getLayoutParams();
        float r62 = r61.weight;
        if (r62 <= 0.0f) goto L174;
        int r63 = (int) ((r53 * r62) / r0);
        float r64 = r0 - r62;
        int r65 = r53 - r63;
        int r66 = ViewGroup.getChildMeasureSpec(r41, ((getPaddingBottom() + getPaddingTop()) + ((ViewGroup.MarginLayoutParams) r61).topMargin) + ((ViewGroup.MarginLayoutParams) r61).bottomMargin, ((ViewGroup.MarginLayoutParams) r61).height);
        if (((ViewGroup.MarginLayoutParams) r61).width != 0) goto L168;
        int r67 = BasicMeasure.EXACTLY;
        if (r12 != 1073741824) goto L169;
        if (r63 > 0) goto L167;
        r63 = 0;
    L167:
        r115.measure(View.MeasureSpec.makeMeasureSpec(r63, BasicMeasure.EXACTLY), r66);
    L173:
        r55 = View.combineMeasuredStates(r55, r115.getMeasuredState() & ViewCompat.MEASURED_STATE_MASK);
        r0 = r64;
        r60 = r65;
    L175:
        if (r19 == false) goto L178;
        this.mTotalLength = (getNextLocationOffset(r115) + ((r115.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) r61).leftMargin) + ((ViewGroup.MarginLayoutParams) r61).rightMargin)) + this.mTotalLength;
    L179:
        if (r13 != 1073741824) goto L181;
    L183:
        boolean r68 = false;
    L184:
        int r69 = ((ViewGroup.MarginLayoutParams) r61).topMargin + ((ViewGroup.MarginLayoutParams) r61).bottomMargin;
        int r116 = r115.getMeasuredHeight() + r69;
        r59 = Math.max(r59, r116);
        if (r68 == true) goto L188;
        r69 = r116;
    L188:
        int r70 = Math.max(r58, r69);
        if (r26 == false) goto L193;
        int r71 = -1;
        if (((ViewGroup.MarginLayoutParams) r61).height != (-1)) goto L194;
        boolean r72 = true;
    L195:
        if (r312 == false) goto L202;
        int r117 = r115.getBaseline();
        if (r117 == r71) goto L202;
        int r73 = r61.gravity;
        if (r73 >= 0) goto L201;
        r73 = this.mGravity;
    L201:
        int r74 = (((r73 & ApiConstants.OP_ERROR_UGC_POST_TOO_FAST) >> 4) & (-2)) >> 1;
        r15[r74] = Math.max(r15[r74], r117);
        r28[r74] = Math.max(r28[r74], r116 - r117);
    L202:
        r26 = r72;
        r58 = r70;
        r0 = r0;
    L194:
        r72 = false;
        goto L195
    L193:
        r71 = -1;
        goto L194
    L181:
        if (((ViewGroup.MarginLayoutParams) r61).height != (-1)) goto L183;
        r68 = true;
        goto L184
    L178:
        int r75 = this.mTotalLength;
        this.mTotalLength = Math.max(r75, getNextLocationOffset(r115) + (((r115.getMeasuredWidth() + r75) + ((ViewGroup.MarginLayoutParams) r61).leftMargin) + ((ViewGroup.MarginLayoutParams) r61).rightMargin));
    L169:
        int r76 = r115.getMeasuredWidth() + r63;
        if (r76 >= 0) goto L172;
        r76 = 0;
    L172:
        r115.measure(View.MeasureSpec.makeMeasureSpec(r76, r67), r66);
        goto L173
    L168:
        r67 = BasicMeasure.EXACTLY;
        goto L169
    L174:
        r60 = r53;
        goto L175
    L204:
        r212 = r11;
        this.mTotalLength = (getPaddingRight() + getPaddingLeft()) + this.mTotalLength;
        int r77 = r15[1];
        if (r77 == (-1)) goto L207;
    L214:
        int r78 = Math.max(r59, Math.max(r28[3], Math.max(r28[0], Math.max(r28[1], r28[2]))) + Math.max(r15[3], Math.max(r15[0], Math.max(r77, r15[2]))));
    L215:
        r211 = r78;
        r54 = r58;
        goto L216
    L207:
        if (r15[0] != (-1)) goto L214;
        if (r15[2] != (-1)) goto L214;
        if (r15[3] != (-1)) goto L214;
        r78 = r59;
        goto L215
    L107:
        if (r12 == Integer.MIN_VALUE) goto L111;
        if (r12 != 0) goto L110;
    L111:
        this.mTotalLength = 0;
        int r79 = 0;
    L112:
        if (r79 >= r11) goto L110;
        View r80 = getVirtualChildAt(r79);
        if (r80 != null) goto L117;
        this.mTotalLength = measureNullChild(r79) + this.mTotalLength;
    L124:
        r79 = r79 + 1;
        r50 = r50;
        goto L112
    L117:
        if (r80.getVisibility() != 8) goto L120;
        r79 = r79 + getChildrenSkipCount(r80, r79);
        goto L124
    L120:
        LayoutParams r81 = (LayoutParams) r80.getLayoutParams();
        if (r19 == false) goto L123;
        this.mTotalLength = (getNextLocationOffset(r80) + ((((ViewGroup.MarginLayoutParams) r81).leftMargin + r14) + ((ViewGroup.MarginLayoutParams) r81).rightMargin)) + this.mTotalLength;
        goto L124
    L123:
        int r82 = this.mTotalLength;
        this.mTotalLength = Math.max(r82, getNextLocationOffset(r80) + (((r82 + r14) + ((ViewGroup.MarginLayoutParams) r81).leftMargin) + ((ViewGroup.MarginLayoutParams) r81).rightMargin));
        goto L124
    L97:
        if (r15[0] != (-1)) goto L104;
        if (r15[2] != (-1)) goto L104;
        if (r15[3] != (-1)) goto L104;
        r50 = r46;
        goto L105
    L92:
        if (hasDividerBeforeChildAt(r11) == false) goto L94;
        this.mTotalLength += this.mDividerWidth;
        goto L94
    L10:
        r19 = false;
        goto L11
    L5:
        if (this.mMaxDescent != null) goto L7;
        goto L6
    }

    public int measureNullChild(int r1) {
        return 0;
    }

    public void measureVertical(int r34, int r35) {
        this.mTotalLength = 0;
        int r11 = getVirtualChildCount();
        int r12 = View.MeasureSpec.getMode(r34);
        int r13 = View.MeasureSpec.getMode(r35);
        int r14 = this.mBaselineAlignedChildIndex;
        boolean r15 = this.mUseLargestChild;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
        boolean r18 = false;
        boolean r20 = false;
        boolean r19 = true;
        float r0 = 0.0f;
    L3:
        int r10 = 8;
        int r22 = r4;
        if (r6 >= r11) goto L71;
        View r7 = getVirtualChildAt(r6);
        if (r7 != null) goto L8;
        this.mTotalLength = measureNullChild(r6) + this.mTotalLength;
        int r24 = r13;
        r4 = r22;
        int r23 = r11;
    L70:
        r6 = r6 + 1;
        r11 = r23;
        r13 = r24;
        goto L3
    L8:
        int r25 = r1;
        if (r7.getVisibility() != 8) goto L12;
        r6 = r6 + getChildrenSkipCount(r7, r6);
        r4 = r22;
        r1 = r25;
        r23 = r11;
        r24 = r13;
        goto L70
    L12:
        if (hasDividerBeforeChildAt(r6) == false) goto L14;
        this.mTotalLength += this.mDividerHeight;
    L14:
        LayoutParams r16 = (LayoutParams) r7.getLayoutParams();
        float r8 = r16.weight;
        float r26 = r0 + r8;
        if (r13 == 1073741824) goto L17;
    L21:
        int r27 = r2;
        if (((ViewGroup.MarginLayoutParams) r16).height == 0) goto L24;
    L26:
        int r9 = Integer.MIN_VALUE;
    L28:
        if (r26 != 0.0f) goto L30;
        int r28 = this.mTotalLength;
    L31:
        int r17 = r25;
        int r30 = r9;
        int r29 = r27;
        int r21 = r3;
        r24 = r13;
        int r110 = r22;
        r23 = r11;
        int r31 = r5;
        int r111 = r6;
        measureChildBeforeLayout(r7, r6, r34, 0, r35, r28);
        if (r30 == Integer.MIN_VALUE) goto L34;
        ((ViewGroup.MarginLayoutParams) r16).height = r30;
    L34:
        int r32 = r7.getMeasuredHeight();
        int r33 = this.mTotalLength;
        View r36 = r7;
        this.mTotalLength = Math.max(r33, getNextLocationOffset(r36) + (((r33 + r32) + ((ViewGroup.MarginLayoutParams) r16).topMargin) + ((ViewGroup.MarginLayoutParams) r16).bottomMargin));
        if (r15 == false) goto L37;
        int r37 = Math.max(r32, r21);
    L38:
        if (r14 >= 0) goto L40;
    L42:
        if (r111 >= r14) goto L48;
        if (r16.weight <= 0.0f) goto L48;
        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
    L48:
        if (r12 != 1073741824) goto L50;
    L52:
        boolean r38 = false;
    L53:
        int r39 = ((ViewGroup.MarginLayoutParams) r16).leftMargin + ((ViewGroup.MarginLayoutParams) r16).rightMargin;
        int r40 = r36.getMeasuredWidth() + r39;
        int r41 = Math.max(r29, r40);
        int r42 = View.combineMeasuredStates(r17, r36.getMeasuredState());
        if (r19 == true) goto L56;
    L58:
        r19 = false;
    L60:
        if (r16.weight <= 0.0f) goto L65;
        if (r38 == true) goto L64;
        r39 = r40;
    L64:
        r4 = Math.max(r110, r39);
    L69:
        int r43 = getChildrenSkipCount(r36, r111) + r111;
        r3 = r37;
        r2 = r41;
        r0 = r26;
        r5 = r31;
        r6 = r43;
        r1 = r42;
        goto L70
    L65:
        if (r38 == true) goto L68;
        r39 = r40;
    L68:
        r31 = Math.max(r31, r39);
        r4 = r110;
        goto L69
    L56:
        if (((ViewGroup.MarginLayoutParams) r16).width != (-1)) goto L58;
        r19 = true;
        goto L60
    L50:
        if (((ViewGroup.MarginLayoutParams) r16).width != (-1)) goto L52;
        r38 = true;
        r20 = true;
        goto L53
    L40:
        if (r14 != (r111 + 1)) goto L42;
        this.mBaselineChildTop = this.mTotalLength;
        goto L42
    L37:
        r37 = r21;
        goto L38
    L30:
        r28 = 0;
        goto L31
    L24:
        if (r8 <= 0.0f) goto L26;
        ((ViewGroup.MarginLayoutParams) r16).height = -2;
        r9 = 0;
        goto L28
    L17:
        if (((ViewGroup.MarginLayoutParams) r16).height != 0) goto L21;
        if (r8 <= 0.0f) goto L21;
        int r44 = this.mTotalLength;
        this.mTotalLength = Math.max(r44, (((ViewGroup.MarginLayoutParams) r16).topMargin + r44) + ((ViewGroup.MarginLayoutParams) r16).bottomMargin);
        r37 = r3;
        r36 = r7;
        r31 = r5;
        r18 = true;
        r17 = r25;
        r29 = r2;
        r24 = r13;
        r110 = r22;
        r23 = r11;
        r111 = r6;
        goto L38
    L71:
        int r45 = r1;
        int r46 = r3;
        int r47 = r5;
        int r210 = r13;
        int r48 = r2;
        int r211 = r11;
        if (this.mTotalLength <= 0) goto L76;
        int r49 = r211;
        if (hasDividerBeforeChildAt(r49) == false) goto L78;
        this.mTotalLength += this.mDividerHeight;
    L78:
        if (r15 == true) goto L80;
    L92:
        int r112 = (getPaddingBottom() + getPaddingTop()) + this.mTotalLength;
        this.mTotalLength = r112;
        int r50 = View.resolveSizeAndState(Math.max(r112, getSuggestedMinimumHeight()), r35, 0);
        int r51 = (16777215 & r50) - this.mTotalLength;
        if (r18 == true) goto L114;
        if (r51 != 0) goto L96;
    L98:
        int r52 = Math.max(r47, r22);
        if (r15 == true) goto L101;
    L113:
        int r53 = r45;
    L156:
        if (r19 == false) goto L158;
    L160:
        r52 = r48;
    L161:
        setMeasuredDimension(View.resolveSizeAndState(Math.max((getPaddingRight() + getPaddingLeft()) + r52, getSuggestedMinimumWidth()), r34, r53), r50);
        if (r20 == false) goto L182;
        forceUniformWidth(r49, r35);
        return;
    L182:
        return;
    L158:
        if (r12 == 1073741824) goto L160;
    L101:
        if (r210 == 1073741824) goto L113;
        int r54 = 0;
    L103:
        if (r54 >= r49) goto L113;
        View r55 = getVirtualChildAt(r54);
        if (r55 == null) goto L112;
        if (r55.getVisibility() == 8) goto L112;
        if (((LayoutParams) r55.getLayoutParams()).weight <= 0.0f) goto L112;
        r55.measure(View.MeasureSpec.makeMeasureSpec(r55.getMeasuredWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(r46, BasicMeasure.EXACTLY));
    L112:
        r54 = r54 + 1;
        goto L103
    L96:
        if (r0 <= 0.0f) goto L98;
    L114:
        float r113 = this.mWeightSum;
        if (r113 <= 0.0f) goto L117;
        r0 = r113;
    L117:
        this.mTotalLength = 0;
        int r114 = r51;
        int r56 = r47;
        r53 = r45;
        int r57 = 0;
    L118:
        if (r57 >= r49) goto L155;
        View r115 = getVirtualChildAt(r57);
        if (r115.getVisibility() != 8) goto L122;
        int r212 = r114;
    L154:
        r57 = r57 + 1;
        r114 = r212;
        goto L118
    L122:
        LayoutParams r116 = (LayoutParams) r115.getLayoutParams();
        float r117 = r116.weight;
        if (r117 <= 0.0f) goto L139;
        int r118 = (int) ((r114 * r117) / r0);
        float r58 = r0 - r117;
        r212 = r114 - r118;
        int r59 = ViewGroup.getChildMeasureSpec(r34, ((getPaddingRight() + getPaddingLeft()) + ((ViewGroup.MarginLayoutParams) r116).leftMargin) + ((ViewGroup.MarginLayoutParams) r116).rightMargin, ((ViewGroup.MarginLayoutParams) r116).width);
        if (((ViewGroup.MarginLayoutParams) r116).height != 0) goto L133;
        int r119 = BasicMeasure.EXACTLY;
        if (r210 != 1073741824) goto L134;
        if (r118 > 0) goto L132;
        r118 = 0;
    L132:
        r115.measure(r59, View.MeasureSpec.makeMeasureSpec(r118, BasicMeasure.EXACTLY));
    L138:
        r53 = View.combineMeasuredStates(r53, r115.getMeasuredState() & InputDeviceCompat.SOURCE_ANY);
        r0 = r58;
    L140:
        int r120 = ((ViewGroup.MarginLayoutParams) r116).leftMargin + ((ViewGroup.MarginLayoutParams) r116).rightMargin;
        int r121 = r115.getMeasuredWidth() + r120;
        r48 = Math.max(r48, r121);
        float r122 = r0;
        if (r12 == 1073741824) goto L145;
        int r213 = r53;
        int r60 = -1;
        if (((ViewGroup.MarginLayoutParams) r116).width == (-1)) goto L147;
    L146:
        r120 = r121;
    L147:
        int r61 = Math.max(r56, r120);
        if (r19 == true) goto L150;
    L152:
        boolean r62 = false;
    L153:
        int r123 = this.mTotalLength;
        this.mTotalLength = Math.max(r123, getNextLocationOffset(r115) + (((r115.getMeasuredHeight() + r123) + ((ViewGroup.MarginLayoutParams) r116).topMargin) + ((ViewGroup.MarginLayoutParams) r116).bottomMargin));
        r19 = r62;
        r53 = r213;
        r56 = r61;
        r0 = r122;
        goto L154
    L150:
        if (((ViewGroup.MarginLayoutParams) r116).width != r60) goto L152;
        r62 = true;
        goto L153
    L145:
        r213 = r53;
        r60 = -1;
    L134:
        int r124 = r115.getMeasuredHeight() + r118;
        if (r124 >= 0) goto L137;
        r124 = 0;
    L137:
        r115.measure(r59, View.MeasureSpec.makeMeasureSpec(r124, r119));
        goto L138
    L133:
        r119 = BasicMeasure.EXACTLY;
        goto L134
    L139:
        r212 = r114;
        goto L140
    L155:
        this.mTotalLength = (getPaddingBottom() + getPaddingTop()) + this.mTotalLength;
        r52 = r56;
        goto L156
    L80:
        if (r210 == Integer.MIN_VALUE) goto L82;
        if (r210 != 0) goto L92;
    L82:
        this.mTotalLength = 0;
        int r63 = 0;
    L83:
        if (r63 >= r49) goto L92;
        View r64 = getVirtualChildAt(r63);
        if (r64 != null) goto L88;
        this.mTotalLength = measureNullChild(r63) + this.mTotalLength;
    L91:
        r63 = r63 + 1;
        r10 = 8;
        goto L83
    L88:
        if (r64.getVisibility() != r10) goto L90;
        r63 = r63 + getChildrenSkipCount(r64, r63);
        goto L91
    L90:
        LayoutParams r125 = (LayoutParams) r64.getLayoutParams();
        int r126 = this.mTotalLength;
        this.mTotalLength = Math.max(r126, getNextLocationOffset(r64) + (((r126 + r46) + ((ViewGroup.MarginLayoutParams) r125).topMargin) + ((ViewGroup.MarginLayoutParams) r125).bottomMargin));
        goto L91
    L76:
        r49 = r211;
        goto L78
    }

    @Override // android.view.View
    public void onDraw(Canvas r3) {
        if (this.mDivider != null) goto L6;
        return;
    L6:
        if (this.mOrientation != 1) goto L8;
        drawDividersVertical(r3);
        return;
    L8:
        drawDividersHorizontal(r3);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r1) {
        super.onInitializeAccessibilityEvent(r1);
        r1.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r1) {
        super.onInitializeAccessibilityNodeInfo(r1);
        r1.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        if (this.mOrientation != 1) goto L5;
        layoutVertical(r3, r4, r5, r6);
        return;
    L5:
        layoutHorizontal(r3, r4, r5, r6);
    }

    @Override // android.view.View
    public void onMeasure(int r3, int r4) {
        if (this.mOrientation != 1) goto L5;
        measureVertical(r3, r4);
        return;
    L5:
        measureHorizontal(r3, r4);
    }

    public void setBaselineAligned(boolean r1) {
        this.mBaselineAligned = r1;
    }

    public void setBaselineAlignedChildIndex(int r3) {
        if (r3 < 0) goto L8;
        if (r3 >= getChildCount()) goto L8;
        this.mBaselineAlignedChildIndex = r3;
        return;
    L8:
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable r3) {
        if (r3 != this.mDivider) goto L5;
        return;
    L5:
        this.mDivider = r3;
        boolean r0 = false;
        if (r3 == null) goto L8;
        this.mDividerWidth = r3.getIntrinsicWidth();
        this.mDividerHeight = r3.getIntrinsicHeight();
    L9:
        if (r3 != null) goto L11;
        r0 = true;
    L11:
        setWillNotDraw(r0);
        requestLayout();
        return;
    L8:
        this.mDividerWidth = 0;
        this.mDividerHeight = 0;
        goto L9
    }

    public void setDividerPadding(int r1) {
        this.mDividerPadding = r1;
    }

    public void setGravity(int r2) {
        if (this.mGravity != r2) goto L5;
        return;
    L5:
        if ((8388615 & r2) != 0) goto L8;
        r2 = r2 | GravityCompat.START;
    L8:
        if ((r2 & ApiConstants.OP_ERROR_UGC_POST_TOO_FAST) != 0) goto L10;
        r2 = r2 | 48;
    L10:
        this.mGravity = r2;
        requestLayout();
    }

    public void setHorizontalGravity(int r3) {
        int r4 = r3 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int r1 = this.mGravity;
        if ((8388615 & r1) == r4) goto L6;
        this.mGravity = r4 | ((-8388616) & r1);
        requestLayout();
        return;
    }

    public void setMeasureWithLargestChildEnabled(boolean r1) {
        this.mUseLargestChild = r1;
    }

    public void setOrientation(int r2) {
        if (this.mOrientation == r2) goto L6;
        this.mOrientation = r2;
        requestLayout();
        return;
    }

    public void setShowDividers(int r2) {
        if (r2 == this.mShowDividers) goto L5;
        requestLayout();
    L5:
        this.mShowDividers = r2;
    }

    public void setVerticalGravity(int r3) {
        int r4 = r3 & ApiConstants.OP_ERROR_UGC_POST_TOO_FAST;
        int r0 = this.mGravity;
        if ((r0 & ApiConstants.OP_ERROR_UGC_POST_TOO_FAST) == r4) goto L6;
        this.mGravity = r4 | (r0 & NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH);
        requestLayout();
        return;
    }

    public void setWeightSum(float r2) {
        this.mWeightSum = Math.max(0.0f, r2);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        int r2 = this.mOrientation;
        if (r2 != 0) goto L7;
        return new LayoutParams(-2, -2);
    L7:
        if (r2 == 1) goto L9;
        return null;
    L9:
        return new LayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateLayoutParams(r1);
    }

    public LinearLayoutCompat(@NonNull Context r12, @Nullable AttributeSet r13, int r14) {
        super(r12, r13, r14);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = BadgeDrawable.TOP_START;
        TintTypedArray r3 = TintTypedArray.obtainStyledAttributes(r12, r13, R.styleable.LinearLayoutCompat, r14, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r12, R.styleable.LinearLayoutCompat, r13, r3.getWrappedTypeArray(), r14, 0);
        int r15 = r3.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (r15 < 0) goto L5;
        setOrientation(r15);
    L5:
        int r16 = r3.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (r16 < 0) goto L8;
        setGravity(r16);
    L8:
        boolean r17 = r3.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (r17 == true) goto L11;
        setBaselineAligned(r17);
    L11:
        this.mWeightSum = r3.getFloat(R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = r3.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = r3.getBoolean(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(r3.getDrawable(R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = r3.getInt(R.styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = r3.getDimensionPixelSize(R.styleable.LinearLayoutCompat_dividerPadding, 0);
        r3.recycle();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r2) {
        return new LayoutParams(getContext(), r2);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return new LayoutParams(r1);
    }
}
