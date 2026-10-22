package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.annotation.GravityInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.badge.BadgeDrawable;
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

    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(int r1, int r2) {
            super(r1, r2);
        }

        public LayoutParams(int r1, int r2, float r3) {
            super(r1, r2, r3);
        }

        public LayoutParams(Context r1, AttributeSet r2) {
            super(r1, r2);
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r1) {
            super(r1);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(@NonNull Context r2) {
        this(r2, null);
    }

    public LinearLayoutCompat(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, 0);
    }

    public LinearLayoutCompat(@NonNull Context r12, @Nullable AttributeSet r13, int r14) {
        super(r12, r13, r14);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = BadgeDrawable.TOP_START;
        int[] r6 = R.styleable.LinearLayoutCompat;
        TintTypedArray r3 = TintTypedArray.obtainStyledAttributes(r12, r13, r6, r14, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r12, r6, r13, r3.getWrappedTypeArray(), r14, 0);
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

    private void forceUniformHeight(int r11, int r12) {
        int r0 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), BasicMeasure.EXACTLY);
        int r1 = 0;
    L3:
        if (r1 >= r11) goto L10;
        View r3 = getVirtualChildAt(r1);
        if (r3.getVisibility() == 8) goto L9;
        LayoutParams r8 = (LayoutParams) r3.getLayoutParams();
        if (((LinearLayout.LayoutParams) r8).height != (-1)) goto L9;
        int r9 = ((LinearLayout.LayoutParams) r8).width;
        ((LinearLayout.LayoutParams) r8).width = r3.getMeasuredWidth();
        measureChildWithMargins(r3, r12, 0, r0, 0);
        ((LinearLayout.LayoutParams) r8).width = r9;
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
        if (((LinearLayout.LayoutParams) r8).width != (-1)) goto L9;
        int r9 = ((LinearLayout.LayoutParams) r8).height;
        ((LinearLayout.LayoutParams) r8).height = r3.getMeasuredHeight();
        measureChildWithMargins(r3, r0, 0, r12, 0);
        ((LinearLayout.LayoutParams) r8).height = r9;
    L9:
        r1 = r1 + 1;
        goto L3
    }

    private void setChildFrame(View r1, int r2, int r3, int r4, int r5) {
        r1.layout(r2, r3, r4 + r2, r5 + r3);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return r1 instanceof LayoutParams;
    }

    void drawDividersHorizontal(Canvas r7) {
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
        int r5 = r3.getRight() + ((LinearLayout.LayoutParams) r4).rightMargin;
    L14:
        drawVerticalDivider(r7, r5);
        goto L15
    L13:
        r5 = (r3.getLeft() - ((LinearLayout.LayoutParams) r4).leftMargin) - this.mDividerWidth;
    L15:
        r2 = r2 + 1;
        goto L3
    L17:
        if (hasDividerBeforeChildAt(r0) == false) goto L35;
        View r6 = getVirtualChildAt(r0 - 1);
        if (r6 != null) goto L23;
        if (r1 == false) goto L22;
        int r8 = getPaddingLeft();
    L28:
        drawVerticalDivider(r7, r8);
        return;
    L22:
        int r9 = getWidth();
        int r10 = getPaddingRight();
    L26:
        r8 = (r9 - r10) - this.mDividerWidth;
        goto L28
    L23:
        LayoutParams r11 = (LayoutParams) r6.getLayoutParams();
        if (r1 == false) goto L27;
        r9 = r6.getLeft();
        r10 = ((LinearLayout.LayoutParams) r11).leftMargin;
        goto L26
    L27:
        r8 = r6.getRight() + ((LinearLayout.LayoutParams) r11).rightMargin;
        goto L28
    }

    void drawDividersVertical(Canvas r6) {
        int r0 = getVirtualChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L13;
        View r2 = getVirtualChildAt(r1);
        if (r2 == null) goto L11;
        if (r2.getVisibility() == 8) goto L11;
        if (hasDividerBeforeChildAt(r1) == false) goto L11;
        drawHorizontalDivider(r6, (r2.getTop() - ((LinearLayout.LayoutParams) ((LayoutParams) r2.getLayoutParams())).topMargin) - this.mDividerHeight);
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
        r4 = r3.getBottom() + ((LinearLayout.LayoutParams) ((LayoutParams) r3.getLayoutParams())).bottomMargin;
        goto L18
    }

    void drawHorizontalDivider(Canvas r5, int r6) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, r6, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + r6);
        this.mDivider.draw(r5);
    }

    void drawVerticalDivider(Canvas r6, int r7) {
        this.mDivider.setBounds(r7, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + r7, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(r6);
    }

    @Override // android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected LayoutParams generateDefaultLayoutParams() {
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
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    @Override // android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateLayoutParams(r1);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r2) {
        return new LayoutParams(getContext(), r2);
    }

    @Override // android.view.ViewGroup
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return new LayoutParams(r1);
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
        int r5 = this.mGravity & 112;
        if (r5 == 48) goto L27;
        if (r5 != 16) goto L22;
        r4 = r4 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2);
        goto L27
    L22:
        if (r5 != 80) goto L27;
        r4 = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
    L27:
        return (r4 + ((LinearLayout.LayoutParams) ((LayoutParams) r2.getLayoutParams())).topMargin) + r3;
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

    int getChildrenSkipCount(View r1, int r2) {
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

    @GravityInt
    public int getGravity() {
        return this.mGravity;
    }

    int getLocationOffset(View r1) {
        return 0;
    }

    int getNextLocationOffset(View r1) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    View getVirtualChildAt(int r1) {
        return getChildAt(r1);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    protected boolean hasDividerBeforeChildAt(int r5) {
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

    void layoutHorizontal(int r25, int r26, int r27, int r28) {
        boolean r0 = ViewUtils.isLayoutRtl(this);
        int r7 = getPaddingTop();
        int r1 = r28 - r26;
        int r8 = r1 - getPaddingBottom();
        int r9 = (r1 - r7) - getPaddingBottom();
        int r10 = getVirtualChildCount();
        int r2 = this.mGravity;
        int r11 = r2 & 112;
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
        int r15 = r16 + (r17 * r6);
        View r18 = getVirtualChildAt(r15);
        if (r18 != null) goto L19;
        r4 = r4 + measureNullChild(r15);
        boolean r21 = r5;
    L51:
        r6 = r6 + 1;
        r10 = r10;
        r11 = r11;
        r5 = r21;
        r7 = r7;
        goto L14
    L19:
        if (r18.getVisibility() == 8) goto L49;
        int r19 = r18.getMeasuredWidth();
        int r20 = r18.getMeasuredHeight();
        LayoutParams r22 = (LayoutParams) r18.getLayoutParams();
        int r110 = r6;
        if (r12 == false) goto L25;
        r10 = r10;
        if (((LinearLayout.LayoutParams) r22).height == (-1)) goto L26;
        int r111 = r18.getBaseline();
    L27:
        int r23 = ((LinearLayout.LayoutParams) r22).gravity;
        if (r23 >= 0) goto L30;
        r23 = r11;
    L30:
        int r24 = r23 & 112;
        r11 = r11;
        if (r24 != 16) goto L33;
        r21 = true;
        int r29 = ((((r9 - r20) / 2) + r7) + ((LinearLayout.LayoutParams) r22).topMargin) - ((LinearLayout.LayoutParams) r22).bottomMargin;
    L46:
        if (hasDividerBeforeChildAt(r15) == false) goto L48;
        r4 = r4 + this.mDividerWidth;
    L48:
        int r112 = ((LinearLayout.LayoutParams) r22).leftMargin + r4;
        r7 = r7;
        setChildFrame(r18, r112 + getLocationOffset(r18), r29, r19, r20);
        int r113 = r112 + ((r19 + ((LinearLayout.LayoutParams) r22).rightMargin) + getNextLocationOffset(r18));
        r6 = r110 + getChildrenSkipCount(r18, r15);
        r4 = r113;
        goto L51
    L33:
        if (r24 != 48) goto L35;
        r29 = ((LinearLayout.LayoutParams) r22).topMargin + r7;
        if (r111 == (-1)) goto L43;
        r21 = true;
        r29 = r29 + (r13[1] - r111);
    L43:
        r21 = true;
        goto L46
    L35:
        if (r24 == 80) goto L37;
        r29 = r7;
        goto L43
    L37:
        r29 = (r8 - r20) - ((LinearLayout.LayoutParams) r22).bottomMargin;
        if (r111 == (-1)) goto L43;
        r29 = r29 - (r14[2] - (r18.getMeasuredHeight() - r111));
    L26:
        r111 = -1;
        goto L27
    L25:
        r10 = r10;
        goto L26
    L49:
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

    void layoutVertical(int r18, int r19, int r20, int r21) {
        int r7 = getPaddingLeft();
        int r0 = r20 - r18;
        int r8 = r0 - getPaddingRight();
        int r9 = (r0 - r7) - getPaddingRight();
        int r10 = getVirtualChildCount();
        int r1 = this.mGravity;
        int r2 = r1 & 112;
        int r11 = r1 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (r2 != 16) goto L5;
        int r3 = getPaddingTop() + (((r21 - r19) - this.mTotalLength) / 2);
    L9:
        int r12 = 0;
    L10:
        if (r12 >= r10) goto L33;
        View r13 = getVirtualChildAt(r12);
        if (r13 != null) goto L15;
        r3 = r3 + measureNullChild(r12);
    L31:
        int r4 = 1;
    L32:
        r12 = r12 + r4;
        goto L10
    L15:
        if (r13.getVisibility() == 8) goto L31;
        int r5 = r13.getMeasuredWidth();
        int r15 = r13.getMeasuredHeight();
        LayoutParams r6 = (LayoutParams) r13.getLayoutParams();
        int r14 = ((LinearLayout.LayoutParams) r6).gravity;
        if (r14 >= 0) goto L19;
        r14 = r11;
    L19:
        int r16 = GravityCompat.getAbsoluteGravity(r14, ViewCompat.getLayoutDirection(this)) & 7;
        if (r16 != 1) goto L22;
        int r17 = (((r9 - r5) / 2) + r7) + ((LinearLayout.LayoutParams) r6).leftMargin;
    L26:
        int r22 = r17 - ((LinearLayout.LayoutParams) r6).rightMargin;
    L27:
        int r23 = r22;
        if (hasDividerBeforeChildAt(r12) == false) goto L30;
        r3 = r3 + this.mDividerHeight;
    L30:
        int r110 = r3 + ((LinearLayout.LayoutParams) r6).topMargin;
        setChildFrame(r13, r23, r110 + getLocationOffset(r13), r5, r15);
        int r111 = r110 + ((r15 + ((LinearLayout.LayoutParams) r6).bottomMargin) + getNextLocationOffset(r13));
        r12 = r12 + getChildrenSkipCount(r13, r12);
        r3 = r111;
        r4 = 1;
        goto L32
    L22:
        if (r16 == 5) goto L24;
        r22 = ((LinearLayout.LayoutParams) r6).leftMargin + r7;
        goto L27
    L24:
        r17 = r8 - r5;
        goto L26
    L33:
        return;
    L5:
        if (r2 == 80) goto L7;
        r3 = getPaddingTop();
        goto L9
    L7:
        r3 = ((getPaddingTop() + r21) - r19) - this.mTotalLength;
        goto L9
    }

    void measureChildBeforeLayout(View r7, int r8, int r9, int r10, int r11, int r12) {
        measureChildWithMargins(r7, r9, r10, r11, r12);
    }

    void measureHorizontal(int r39, int r40) {
        this.mTotalLength = 0;
        int r11 = getVirtualChildCount();
        int r12 = View.MeasureSpec.getMode(r39);
        int r13 = View.MeasureSpec.getMode(r40);
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
        if (r1 >= r11) goto L91;
        View r7 = getVirtualChildAt(r1);
        if (r7 != null) goto L19;
        this.mTotalLength += measureNullChild(r1);
    L17:
        boolean r32 = r3;
        boolean r36 = r4;
        int r37 = r2;
        int r5 = r1;
        int r8 = r37;
    L90:
        int r9 = r5 + 1;
        r6 = r28;
        r3 = r32;
        r4 = r36;
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
        float r16 = ((LinearLayout.LayoutParams) r10).weight;
        float r31 = r0 + r16;
        if (r12 != r2) goto L39;
        if (((LinearLayout.LayoutParams) r10).width != 0) goto L39;
        if (r16 <= 0.0f) goto L39;
        int r17 = this.mTotalLength;
        if (r19 == false) goto L33;
        int r18 = r17 + (((LinearLayout.LayoutParams) r10).leftMargin + ((LinearLayout.LayoutParams) r10).rightMargin);
    L34:
        this.mTotalLength = r18;
        if (r4 == false) goto L37;
        int r20 = View.MeasureSpec.makeMeasureSpec(0, 0);
        r7.measure(r20, r20);
        int r34 = r1;
        r32 = r3;
        r36 = r4;
        View r29 = r7;
    L58:
        r8 = BasicMeasure.EXACTLY;
    L59:
        if (r13 != r8) goto L61;
    L63:
        boolean r30 = false;
    L64:
        int r33 = ((LinearLayout.LayoutParams) r10).topMargin + ((LinearLayout.LayoutParams) r10).bottomMargin;
        int r35 = r29.getMeasuredHeight() + r33;
        r25 = View.combineMeasuredStates(r25, r29.getMeasuredState());
        if (r36 == false) goto L72;
        int r38 = r29.getBaseline();
        if (r38 == (-1)) goto L72;
        int r41 = ((LinearLayout.LayoutParams) r10).gravity;
        if (r41 >= 0) goto L71;
        r41 = this.mGravity;
    L71:
        int r42 = (((r41 & 112) >> 4) & (-2)) >> 1;
        r15[r42] = Math.max(r15[r42], r38);
        r28[r42] = Math.max(r28[r42], r35 - r38);
    L72:
        r21 = Math.max(r21, r35);
        if (r26 == true) goto L75;
    L77:
        r26 = false;
    L79:
        if (((LinearLayout.LayoutParams) r10).weight <= 0.0f) goto L84;
        if (r30 == true) goto L83;
        r33 = r35;
    L83:
        r23 = Math.max(r23, r33);
    L89:
        int r110 = r34;
        r5 = getChildrenSkipCount(r29, r110) + r110;
        r0 = r31;
        goto L90
    L84:
        int r111 = r23;
        if (r30 == true) goto L88;
        r33 = r35;
    L88:
        r22 = Math.max(r22, r33);
        r23 = r111;
        goto L89
    L75:
        if (((LinearLayout.LayoutParams) r10).height != (-1)) goto L77;
        r26 = true;
        goto L79
    L61:
        if (((LinearLayout.LayoutParams) r10).height != (-1)) goto L63;
        r30 = true;
        r27 = true;
        goto L64
    L37:
        r34 = r1;
        r32 = r3;
        r36 = r4;
        r29 = r7;
        r24 = true;
        r8 = BasicMeasure.EXACTLY;
        goto L59
    L33:
        r18 = Math.max(r17, (((LinearLayout.LayoutParams) r10).leftMargin + r17) + ((LinearLayout.LayoutParams) r10).rightMargin);
    L39:
        if (((LinearLayout.LayoutParams) r10).width == 0) goto L41;
    L43:
        byte r43 = -2;
        int r44 = Integer.MIN_VALUE;
    L45:
        if (r31 != 0.0f) goto L47;
        int r210 = this.mTotalLength;
    L48:
        r34 = r1;
        int r310 = r44;
        r32 = r3;
        r36 = r4;
        measureChildBeforeLayout(r7, r34, r39, r210, r40, 0);
        if (r310 == Integer.MIN_VALUE) goto L51;
        ((LinearLayout.LayoutParams) r10).width = r310;
    L51:
        int r45 = r7.getMeasuredWidth();
        if (r19 == false) goto L54;
        r29 = r7;
        int r46 = this.mTotalLength + (((((LinearLayout.LayoutParams) r10).leftMargin + r45) + ((LinearLayout.LayoutParams) r10).rightMargin) + getNextLocationOffset(r29));
    L55:
        this.mTotalLength = r46;
        if (r32 == false) goto L58;
        r14 = Math.max(r45, r14);
        goto L58
    L54:
        r29 = r7;
        int r47 = this.mTotalLength;
        r46 = Math.max(r47, (((r47 + r45) + ((LinearLayout.LayoutParams) r10).leftMargin) + ((LinearLayout.LayoutParams) r10).rightMargin) + getNextLocationOffset(r29));
        goto L55
    L47:
        r210 = 0;
        goto L48
    L41:
        if (r16 <= 0.0f) goto L43;
        r43 = -2;
        ((LinearLayout.LayoutParams) r10).width = -2;
        r44 = 0;
        goto L45
    L91:
        boolean r311 = r3;
        boolean r312 = r4;
        int r48 = r21;
        int r49 = r22;
        int r112 = r23;
        int r50 = r25;
        if (this.mTotalLength <= 0) goto L97;
        if (hasDividerBeforeChildAt(r11) == false) goto L97;
        this.mTotalLength += this.mDividerWidth;
    L97:
        if (r15[1] == (-1)) goto L99;
    L106:
        int r51 = Math.max(r48, Math.max(r15[3], Math.max(r15[0], Math.max(r15[1], r15[2]))) + Math.max(r28[3], Math.max(r28[0], Math.max(r28[1], r28[2]))));
    L107:
        if (r311 == true) goto L109;
    L125:
        int r211 = r51;
        int r52 = this.mTotalLength + (getPaddingLeft() + getPaddingRight());
        this.mTotalLength = r52;
        int r53 = View.resolveSizeAndState(Math.max(r52, getSuggestedMinimumWidth()), r39, 0);
        int r54 = (16777215 & r53) - this.mTotalLength;
        if (r24 == true) goto L147;
        if (r54 != 0) goto L129;
    L131:
        int r55 = Math.max(r49, r112);
        if (r311 == true) goto L134;
    L146:
        int r212 = r11;
        int r56 = r211;
    L215:
        if (r26 == false) goto L217;
    L219:
        r55 = r56;
    L220:
        setMeasuredDimension(r53 | (r50 & ViewCompat.MEASURED_STATE_MASK), View.resolveSizeAndState(Math.max(r55 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), r40, r50 << 16));
        if (r27 == false) goto L238;
        forceUniformHeight(r212, r39);
        return;
    L238:
        return;
    L217:
        if (r13 == 1073741824) goto L219;
    L134:
        if (r12 == 1073741824) goto L146;
        int r113 = 0;
    L136:
        if (r113 >= r11) goto L146;
        View r57 = getVirtualChildAt(r113);
        if (r57 == null) goto L145;
        if (r57.getVisibility() == 8) goto L145;
        if (((LinearLayout.LayoutParams) ((LayoutParams) r57.getLayoutParams())).weight <= 0.0f) goto L145;
        r57.measure(View.MeasureSpec.makeMeasureSpec(r14, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(r57.getMeasuredHeight(), BasicMeasure.EXACTLY));
    L145:
        r113 = r113 + 1;
        goto L136
    L129:
        if (r0 <= 0.0f) goto L131;
    L147:
        float r58 = this.mWeightSum;
        if (r58 <= 0.0f) goto L150;
        r0 = r58;
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
        int r59 = r49;
        int r60 = -1;
        int r61 = r50;
        int r114 = 0;
    L151:
        if (r114 >= r11) goto L203;
        View r115 = getVirtualChildAt(r114);
        if (r115 != null) goto L155;
    L201:
        int r62 = r54;
        r11 = r11;
    L202:
        r114 = r114 + 1;
        r54 = r62;
        r11 = r11;
        goto L151
    L155:
        if (r115.getVisibility() == 8) goto L201;
        LayoutParams r63 = (LayoutParams) r115.getLayoutParams();
        float r64 = ((LinearLayout.LayoutParams) r63).weight;
        if (r64 <= 0.0f) goto L171;
        int r65 = (int) ((r54 * r64) / r0);
        float r66 = r0 - r64;
        int r67 = r54 - r65;
        int r68 = ViewGroup.getChildMeasureSpec(r40, ((getPaddingTop() + getPaddingBottom()) + ((LinearLayout.LayoutParams) r63).topMargin) + ((LinearLayout.LayoutParams) r63).bottomMargin, ((LinearLayout.LayoutParams) r63).height);
        if (((LinearLayout.LayoutParams) r63).width != 0) goto L166;
        int r69 = BasicMeasure.EXACTLY;
        if (r12 != 1073741824) goto L167;
        if (r65 > 0) goto L170;
    L169:
        r65 = 0;
    L170:
        r115.measure(View.MeasureSpec.makeMeasureSpec(r65, r69), r68);
        r61 = View.combineMeasuredStates(r61, r115.getMeasuredState() & ViewCompat.MEASURED_STATE_MASK);
        r0 = r66;
        r62 = r67;
    L172:
        int r70 = this.mTotalLength;
        if (r19 == false) goto L175;
        this.mTotalLength = r70 + (((r115.getMeasuredWidth() + ((LinearLayout.LayoutParams) r63).leftMargin) + ((LinearLayout.LayoutParams) r63).rightMargin) + getNextLocationOffset(r115));
    L177:
        if (r13 != 1073741824) goto L179;
    L181:
        boolean r71 = false;
    L182:
        int r72 = ((LinearLayout.LayoutParams) r63).topMargin + ((LinearLayout.LayoutParams) r63).bottomMargin;
        int r116 = r115.getMeasuredHeight() + r72;
        r60 = Math.max(r60, r116);
        if (r71 == true) goto L186;
        r72 = r116;
    L186:
        int r73 = Math.max(r59, r72);
        if (r26 == false) goto L191;
        int r74 = -1;
        if (((LinearLayout.LayoutParams) r63).height != (-1)) goto L192;
        boolean r75 = true;
    L193:
        if (r312 == false) goto L200;
        int r117 = r115.getBaseline();
        if (r117 == r74) goto L200;
        int r76 = ((LinearLayout.LayoutParams) r63).gravity;
        if (r76 >= 0) goto L199;
        r76 = this.mGravity;
    L199:
        int r77 = (((r76 & 112) >> 4) & (-2)) >> 1;
        r15[r77] = Math.max(r15[r77], r117);
        r28[r77] = Math.max(r28[r77], r116 - r117);
    L200:
        r26 = r75;
        r59 = r73;
        r0 = r0;
    L192:
        r75 = false;
        goto L193
    L191:
        r74 = -1;
        goto L192
    L179:
        if (((LinearLayout.LayoutParams) r63).height != (-1)) goto L181;
        r71 = true;
        goto L182
    L175:
        this.mTotalLength = Math.max(r70, (((r115.getMeasuredWidth() + r70) + ((LinearLayout.LayoutParams) r63).leftMargin) + ((LinearLayout.LayoutParams) r63).rightMargin) + getNextLocationOffset(r115));
    L167:
        r65 = r115.getMeasuredWidth() + r65;
        if (r65 >= 0) goto L170;
    L166:
        r69 = BasicMeasure.EXACTLY;
        goto L167
    L171:
        r62 = r54;
        goto L172
    L203:
        r212 = r11;
        this.mTotalLength += getPaddingLeft() + getPaddingRight();
        if (r15[1] == (-1)) goto L206;
    L213:
        int r78 = Math.max(r60, Math.max(r15[3], Math.max(r15[0], Math.max(r15[1], r15[2]))) + Math.max(r28[3], Math.max(r28[0], Math.max(r28[1], r28[2]))));
    L214:
        r56 = r78;
        r55 = r59;
        r50 = r61;
        goto L215
    L206:
        if (r15[0] != (-1)) goto L213;
        if (r15[2] != (-1)) goto L213;
        if (r15[3] != (-1)) goto L213;
        r78 = r60;
        goto L214
    L109:
        if (r12 == Integer.MIN_VALUE) goto L111;
        if (r12 != 0) goto L125;
    L111:
        this.mTotalLength = 0;
        int r79 = 0;
    L112:
        if (r79 >= r11) goto L125;
        View r80 = getVirtualChildAt(r79);
        if (r80 != null) goto L117;
        this.mTotalLength += measureNullChild(r79);
    L124:
        r79 = r79 + 1;
        r51 = r51;
        goto L112
    L117:
        if (r80.getVisibility() != 8) goto L120;
        r79 = r79 + getChildrenSkipCount(r80, r79);
        goto L124
    L120:
        LayoutParams r81 = (LayoutParams) r80.getLayoutParams();
        int r82 = this.mTotalLength;
        if (r19 == false) goto L123;
        this.mTotalLength = r82 + (((((LinearLayout.LayoutParams) r81).leftMargin + r14) + ((LinearLayout.LayoutParams) r81).rightMargin) + getNextLocationOffset(r80));
        goto L124
    L123:
        this.mTotalLength = Math.max(r82, (((r82 + r14) + ((LinearLayout.LayoutParams) r81).leftMargin) + ((LinearLayout.LayoutParams) r81).rightMargin) + getNextLocationOffset(r80));
        goto L124
    L99:
        if (r15[0] != (-1)) goto L106;
        if (r15[2] != (-1)) goto L106;
        if (r15[3] != (-1)) goto L106;
        r51 = r48;
        goto L107
    L10:
        r19 = false;
        goto L11
    L5:
        if (this.mMaxDescent != null) goto L7;
        goto L6
    }

    int measureNullChild(int r1) {
        return 0;
    }

    void measureVertical(int r34, int r35) {
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
        float r0 = 0.0f;
        boolean r19 = true;
    L3:
        int r10 = 8;
        int r22 = r4;
        if (r6 >= r11) goto L72;
        View r7 = getVirtualChildAt(r6);
        if (r7 != null) goto L8;
        this.mTotalLength += measureNullChild(r6);
        int r26 = r11;
        int r24 = r13;
        r4 = r22;
    L71:
        r6 = r6 + 1;
        r13 = r24;
        r11 = r26;
        goto L3
    L8:
        int r25 = r1;
        if (r7.getVisibility() != 8) goto L12;
        r6 = r6 + getChildrenSkipCount(r7, r6);
        r26 = r11;
        r4 = r22;
        r1 = r25;
        r24 = r13;
        goto L71
    L12:
        if (hasDividerBeforeChildAt(r6) == false) goto L14;
        this.mTotalLength += this.mDividerHeight;
    L14:
        LayoutParams r16 = (LayoutParams) r7.getLayoutParams();
        float r8 = ((LinearLayout.LayoutParams) r16).weight;
        float r27 = r0 + r8;
        if (r13 == 1073741824) goto L17;
    L21:
        int r28 = r2;
        if (((LinearLayout.LayoutParams) r16).height == 0) goto L24;
    L26:
        int r9 = Integer.MIN_VALUE;
    L28:
        if (r27 != 0.0f) goto L30;
        int r23 = this.mTotalLength;
    L31:
        int r17 = r25;
        int r30 = r9;
        int r29 = r28;
        int r21 = r3;
        r26 = r11;
        r24 = r13;
        int r110 = r22;
        int r31 = r5;
        int r111 = r6;
        measureChildBeforeLayout(r7, r6, r34, 0, r35, r23);
        if (r30 == Integer.MIN_VALUE) goto L34;
        ((LinearLayout.LayoutParams) r16).height = r30;
    L34:
        int r32 = r7.getMeasuredHeight();
        int r33 = this.mTotalLength;
        View r36 = r7;
        this.mTotalLength = Math.max(r33, (((r33 + r32) + ((LinearLayout.LayoutParams) r16).topMargin) + ((LinearLayout.LayoutParams) r16).bottomMargin) + getNextLocationOffset(r36));
        if (r15 == false) goto L37;
        int r37 = Math.max(r32, r21);
    L38:
        if (r14 >= 0) goto L40;
    L42:
        if (r111 >= r14) goto L49;
        if (((LinearLayout.LayoutParams) r16).weight <= 0.0f) goto L49;
        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
    L49:
        if (r12 != 1073741824) goto L51;
    L53:
        boolean r38 = false;
    L54:
        int r39 = ((LinearLayout.LayoutParams) r16).leftMargin + ((LinearLayout.LayoutParams) r16).rightMargin;
        int r40 = r36.getMeasuredWidth() + r39;
        int r41 = Math.max(r29, r40);
        int r42 = View.combineMeasuredStates(r17, r36.getMeasuredState());
        if (r19 == true) goto L57;
    L59:
        r19 = false;
    L61:
        if (((LinearLayout.LayoutParams) r16).weight <= 0.0f) goto L66;
        if (r38 == true) goto L65;
        r39 = r40;
    L65:
        r4 = Math.max(r110, r39);
        int r43 = r31;
    L70:
        int r44 = getChildrenSkipCount(r36, r111) + r111;
        r3 = r37;
        r0 = r27;
        r5 = r43;
        r1 = r42;
        r6 = r44;
        r2 = r41;
        goto L71
    L66:
        if (r38 == true) goto L69;
        r39 = r40;
    L69:
        r43 = Math.max(r31, r39);
        r4 = r110;
        goto L70
    L57:
        if (((LinearLayout.LayoutParams) r16).width != (-1)) goto L59;
        r19 = true;
        goto L61
    L51:
        if (((LinearLayout.LayoutParams) r16).width != (-1)) goto L53;
        r38 = true;
        r20 = true;
        goto L54
    L40:
        if (r14 != (r111 + 1)) goto L42;
        this.mBaselineChildTop = this.mTotalLength;
        goto L42
    L37:
        r37 = r21;
        goto L38
    L30:
        r23 = 0;
        goto L31
    L24:
        if (r8 <= 0.0f) goto L26;
        ((LinearLayout.LayoutParams) r16).height = -2;
        r9 = 0;
        goto L28
    L17:
        if (((LinearLayout.LayoutParams) r16).height != 0) goto L21;
        if (r8 <= 0.0f) goto L21;
        int r45 = this.mTotalLength;
        this.mTotalLength = Math.max(r45, (((LinearLayout.LayoutParams) r16).topMargin + r45) + ((LinearLayout.LayoutParams) r16).bottomMargin);
        r37 = r3;
        r36 = r7;
        r31 = r5;
        r18 = true;
        r17 = r25;
        r29 = r2;
        r26 = r11;
        r24 = r13;
        r110 = r22;
        r111 = r6;
        goto L38
    L72:
        int r46 = r1;
        int r47 = r3;
        int r48 = r5;
        int r210 = r11;
        int r211 = r13;
        int r49 = r2;
        if (this.mTotalLength <= 0) goto L77;
        int r50 = r210;
        if (hasDividerBeforeChildAt(r50) == false) goto L79;
        this.mTotalLength += this.mDividerHeight;
    L79:
        if (r15 == true) goto L81;
    L94:
        int r51 = this.mTotalLength + (getPaddingTop() + getPaddingBottom());
        this.mTotalLength = r51;
        int r52 = View.resolveSizeAndState(Math.max(r51, getSuggestedMinimumHeight()), r35, 0);
        int r53 = (16777215 & r52) - this.mTotalLength;
        if (r18 == true) goto L116;
        if (r53 != 0) goto L98;
    L100:
        int r54 = Math.max(r48, r22);
        if (r15 == true) goto L103;
    L115:
        int r55 = r46;
    L158:
        if (r19 == false) goto L160;
    L162:
        r54 = r49;
    L163:
        setMeasuredDimension(View.resolveSizeAndState(Math.max(r54 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), r34, r55), r52);
        if (r20 == false) goto L183;
        forceUniformWidth(r50, r35);
        return;
    L183:
        return;
    L160:
        if (r12 == 1073741824) goto L162;
    L103:
        if (r211 == 1073741824) goto L115;
        int r56 = 0;
    L105:
        if (r56 >= r50) goto L115;
        View r57 = getVirtualChildAt(r56);
        if (r57 == null) goto L114;
        if (r57.getVisibility() == 8) goto L114;
        if (((LinearLayout.LayoutParams) ((LayoutParams) r57.getLayoutParams())).weight <= 0.0f) goto L114;
        r57.measure(View.MeasureSpec.makeMeasureSpec(r57.getMeasuredWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(r47, BasicMeasure.EXACTLY));
    L114:
        r56 = r56 + 1;
        goto L105
    L98:
        if (r0 <= 0.0f) goto L100;
    L116:
        float r112 = this.mWeightSum;
        if (r112 <= 0.0f) goto L119;
        r0 = r112;
    L119:
        this.mTotalLength = 0;
        int r113 = r53;
        int r58 = r48;
        r55 = r46;
        int r59 = 0;
    L120:
        if (r59 >= r50) goto L157;
        View r114 = getVirtualChildAt(r59);
        if (r114.getVisibility() != 8) goto L124;
        int r212 = r113;
    L156:
        r59 = r59 + 1;
        r113 = r212;
        goto L120
    L124:
        LayoutParams r115 = (LayoutParams) r114.getLayoutParams();
        float r116 = ((LinearLayout.LayoutParams) r115).weight;
        if (r116 <= 0.0f) goto L138;
        int r117 = (int) ((r113 * r116) / r0);
        float r60 = r0 - r116;
        r212 = r113 - r117;
        int r61 = ViewGroup.getChildMeasureSpec(r34, ((getPaddingLeft() + getPaddingRight()) + ((LinearLayout.LayoutParams) r115).leftMargin) + ((LinearLayout.LayoutParams) r115).rightMargin, ((LinearLayout.LayoutParams) r115).width);
        if (((LinearLayout.LayoutParams) r115).height != 0) goto L133;
        int r118 = BasicMeasure.EXACTLY;
        if (r211 != 1073741824) goto L134;
        if (r117 > 0) goto L137;
    L136:
        r117 = 0;
    L137:
        r114.measure(r61, View.MeasureSpec.makeMeasureSpec(r117, r118));
        r55 = View.combineMeasuredStates(r55, r114.getMeasuredState() & InputDeviceCompat.SOURCE_ANY);
        r0 = r60;
    L139:
        int r119 = ((LinearLayout.LayoutParams) r115).leftMargin + ((LinearLayout.LayoutParams) r115).rightMargin;
        int r120 = r114.getMeasuredWidth() + r119;
        r49 = Math.max(r49, r120);
        float r121 = r0;
        if (r12 == 1073741824) goto L144;
        int r213 = r55;
        int r62 = -1;
        if (((LinearLayout.LayoutParams) r115).width != (-1)) goto L145;
        boolean r63 = true;
    L146:
        if (r63 == true) goto L149;
        r119 = r120;
    L149:
        int r64 = Math.max(r58, r119);
        if (r19 == true) goto L152;
    L154:
        boolean r65 = false;
    L155:
        int r122 = this.mTotalLength;
        this.mTotalLength = Math.max(r122, (((r114.getMeasuredHeight() + r122) + ((LinearLayout.LayoutParams) r115).topMargin) + ((LinearLayout.LayoutParams) r115).bottomMargin) + getNextLocationOffset(r114));
        r19 = r65;
        r55 = r213;
        r58 = r64;
        r0 = r121;
        goto L156
    L152:
        if (((LinearLayout.LayoutParams) r115).width != r62) goto L154;
        r65 = true;
    L145:
        r63 = false;
        goto L146
    L144:
        r213 = r55;
        r62 = -1;
    L134:
        r117 = r114.getMeasuredHeight() + r117;
        if (r117 >= 0) goto L137;
    L133:
        r118 = BasicMeasure.EXACTLY;
        goto L134
    L138:
        r212 = r113;
        goto L139
    L157:
        this.mTotalLength += getPaddingTop() + getPaddingBottom();
        r54 = r58;
        goto L158
    L81:
        if (r211 == Integer.MIN_VALUE) goto L83;
        if (r211 != 0) goto L94;
    L83:
        this.mTotalLength = 0;
        int r66 = 0;
    L84:
        if (r66 >= r50) goto L94;
        View r67 = getVirtualChildAt(r66);
        if (r67 != null) goto L90;
        int r68 = this.mTotalLength + measureNullChild(r66);
    L88:
        this.mTotalLength = r68;
    L93:
        r66 = r66 + 1;
        r10 = 8;
        goto L84
    L90:
        if (r67.getVisibility() != r10) goto L92;
        r66 = r66 + getChildrenSkipCount(r67, r66);
        goto L93
    L92:
        LayoutParams r123 = (LayoutParams) r67.getLayoutParams();
        int r124 = this.mTotalLength;
        r68 = Math.max(r124, (((r124 + r47) + ((LinearLayout.LayoutParams) r123).topMargin) + ((LinearLayout.LayoutParams) r123).bottomMargin) + getNextLocationOffset(r67));
        goto L88
    L77:
        r50 = r210;
        goto L79
    }

    @Override // android.view.View
    protected void onDraw(Canvas r3) {
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
    protected void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        if (this.mOrientation != 1) goto L5;
        layoutVertical(r3, r4, r5, r6);
        return;
    L5:
        layoutHorizontal(r3, r4, r5, r6);
    }

    @Override // android.view.View
    protected void onMeasure(int r3, int r4) {
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

    public void setGravity(@GravityInt int r2) {
        if (this.mGravity != r2) goto L5;
        return;
    L5:
        if ((8388615 & r2) != 0) goto L8;
        r2 = r2 | GravityCompat.START;
    L8:
        if ((r2 & 112) != 0) goto L10;
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
        int r4 = r3 & 112;
        int r0 = this.mGravity;
        if ((r0 & 112) == r4) goto L6;
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
}
