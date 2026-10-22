package com.android.settings.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.RemotableViewMethod;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewHierarchyEncoder;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import com.android.internal.R;
import com.android.vcard.VCardConstants;
import com.ttnet.org.chromium.net.NetError;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes.dex */
public class MatchParentShrinkingLinearLayout extends ViewGroup {
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

    @ViewDebug.ExportedProperty(category = "layout")
    private boolean mBaselineAligned;

    @ViewDebug.ExportedProperty(category = "layout")
    private int mBaselineAlignedChildIndex;

    @ViewDebug.ExportedProperty(category = "measurement")
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;

    @ViewDebug.ExportedProperty(category = "measurement", flagMapping = {@ViewDebug.FlagToString(equals = -1, mask = -1, name = "NONE"), @ViewDebug.FlagToString(equals = 0, mask = 0, name = "NONE"), @ViewDebug.FlagToString(equals = 48, mask = 48, name = "TOP"), @ViewDebug.FlagToString(equals = 80, mask = 80, name = "BOTTOM"), @ViewDebug.FlagToString(equals = 3, mask = 3, name = "LEFT"), @ViewDebug.FlagToString(equals = 5, mask = 5, name = "RIGHT"), @ViewDebug.FlagToString(equals = GravityCompat.START, mask = GravityCompat.START, name = "START"), @ViewDebug.FlagToString(equals = GravityCompat.END, mask = GravityCompat.END, name = VCardConstants.PROPERTY_END), @ViewDebug.FlagToString(equals = 16, mask = 16, name = "CENTER_VERTICAL"), @ViewDebug.FlagToString(equals = 112, mask = 112, name = "FILL_VERTICAL"), @ViewDebug.FlagToString(equals = 1, mask = 1, name = "CENTER_HORIZONTAL"), @ViewDebug.FlagToString(equals = 7, mask = 7, name = "FILL_HORIZONTAL"), @ViewDebug.FlagToString(equals = 17, mask = 17, name = "CENTER"), @ViewDebug.FlagToString(equals = 119, mask = 119, name = "FILL"), @ViewDebug.FlagToString(equals = 8388608, mask = 8388608, name = "RELATIVE")}, formatToHexString = true)
    private int mGravity;
    private int mLayoutDirection;
    private int[] mMaxAscent;
    private int[] mMaxDescent;

    @ViewDebug.ExportedProperty(category = "measurement")
    private int mOrientation;
    private int mShowDividers;

    @ViewDebug.ExportedProperty(category = "measurement")
    private int mTotalLength;

    @ViewDebug.ExportedProperty(category = "layout")
    private boolean mUseLargestChild;

    @ViewDebug.ExportedProperty(category = "layout")
    private float mWeightSum;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DividerMode {
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        @ViewDebug.ExportedProperty(category = "layout", mapping = {@ViewDebug.IntToString(from = -1, to = "NONE"), @ViewDebug.IntToString(from = 0, to = "NONE"), @ViewDebug.IntToString(from = 48, to = "TOP"), @ViewDebug.IntToString(from = 80, to = "BOTTOM"), @ViewDebug.IntToString(from = 3, to = "LEFT"), @ViewDebug.IntToString(from = 5, to = "RIGHT"), @ViewDebug.IntToString(from = GravityCompat.START, to = "START"), @ViewDebug.IntToString(from = GravityCompat.END, to = VCardConstants.PROPERTY_END), @ViewDebug.IntToString(from = 16, to = "CENTER_VERTICAL"), @ViewDebug.IntToString(from = 112, to = "FILL_VERTICAL"), @ViewDebug.IntToString(from = 1, to = "CENTER_HORIZONTAL"), @ViewDebug.IntToString(from = 7, to = "FILL_HORIZONTAL"), @ViewDebug.IntToString(from = 17, to = "CENTER"), @ViewDebug.IntToString(from = 119, to = "FILL")})
        public int gravity;

        @ViewDebug.ExportedProperty(category = "layout")
        public float weight;

        public LayoutParams(Context r3, AttributeSet r4) {
            super(r3, r4);
            this.gravity = -1;
            TypedArray r5 = r3.obtainStyledAttributes(r4, R.styleable.LinearLayout_Layout);
            this.weight = r5.getFloat(3, 0.0f);
            this.gravity = r5.getInt(0, -1);
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

        public String debug(String r2) {
            return r2 + "MatchParentShrinkingLinearLayout.LayoutParams={width=" + sizeToString(this.width) + ", height=" + sizeToString(this.height) + " weight=" + this.weight + VectorFormat.DEFAULT_SUFFIX;
        }

        protected void encodeProperties(ViewHierarchyEncoder r3) {
            super.encodeProperties(r3);
            r3.addProperty("layout:weight", this.weight);
            r3.addProperty("layout:gravity", this.gravity);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OrientationMode {
    }

    int getChildrenSkipCount(View r1, int r2) {
        return 0;
    }

    int getLocationOffset(View r1) {
        return 0;
    }

    int getNextLocationOffset(View r1) {
        return 0;
    }

    int measureNullChild(int r1) {
        return 0;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    @Override // android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateLayoutParams(r1);
    }

    public MatchParentShrinkingLinearLayout(Context r2) {
        this(r2, null);
    }

    public MatchParentShrinkingLinearLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public MatchParentShrinkingLinearLayout(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public MatchParentShrinkingLinearLayout(Context r5, AttributeSet r6, int r7, int r8) {
        super(r5, r6, r7, r8);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        this.mLayoutDirection = -1;
        TypedArray r9 = r5.obtainStyledAttributes(r6, R.styleable.LinearLayout, r7, r8);
        int r10 = r9.getInt(1, -1);
        if (r10 < 0) goto L5;
        setOrientation(r10);
    L5:
        int r11 = r9.getInt(0, -1);
        if (r11 < 0) goto L8;
        setGravity(r11);
    L8:
        boolean r12 = r9.getBoolean(2, true);
        if (r12 == true) goto L11;
        setBaselineAligned(r12);
    L11:
        this.mWeightSum = r9.getFloat(4, -1.0f);
        this.mBaselineAlignedChildIndex = r9.getInt(3, -1);
        this.mUseLargestChild = r9.getBoolean(6, false);
        setDividerDrawable(r9.getDrawable(5));
        this.mShowDividers = r9.getInt(7, 0);
        this.mDividerPadding = r9.getDimensionPixelSize(8, 0);
        r9.recycle();
    }

    public void setShowDividers(int r2) {
        if (r2 == this.mShowDividers) goto L5;
        requestLayout();
    L5:
        this.mShowDividers = r2;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
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

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
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

    void drawDividersVertical(Canvas r6) {
        int r0 = getVirtualChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L13;
        View r2 = getVirtualChildAt(r1);
        if (r2 == null) goto L11;
        if (r2.getVisibility() == 8) goto L11;
        if (hasDividerBeforeChildAt(r1) == false) goto L11;
        drawHorizontalDivider(r6, (r2.getTop() - ((LayoutParams) r2.getLayoutParams()).topMargin) - this.mDividerHeight);
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
        r4 = r3.getBottom() + ((LayoutParams) r3.getLayoutParams()).bottomMargin;
        goto L18
    }

    void drawDividersHorizontal(Canvas r7) {
        int r0 = getVirtualChildCount();
        boolean r1 = isLayoutRtl();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L17;
        View r3 = getVirtualChildAt(r2);
        if (r3 == null) goto L15;
        if (r3.getVisibility() == 8) goto L15;
        if (hasDividerBeforeChildAt(r2) == false) goto L15;
        LayoutParams r4 = (LayoutParams) r3.getLayoutParams();
        if (r1 == false) goto L13;
        int r5 = r3.getRight() + r4.rightMargin;
    L14:
        drawVerticalDivider(r7, r5);
        goto L15
    L13:
        r5 = (r3.getLeft() - r4.leftMargin) - this.mDividerWidth;
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
        int r9 = getWidth() - getPaddingRight();
        int r10 = this.mDividerWidth;
    L26:
        r8 = r9 - r10;
        goto L28
    L23:
        LayoutParams r11 = (LayoutParams) r6.getLayoutParams();
        if (r1 == false) goto L27;
        r9 = r6.getLeft() - r11.leftMargin;
        r10 = this.mDividerWidth;
        goto L26
    L27:
        r8 = r6.getRight() + r11.rightMargin;
        goto L28
    }

    void drawHorizontalDivider(Canvas r5, int r6) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, r6, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + r6);
        this.mDivider.draw(r5);
    }

    void drawVerticalDivider(Canvas r6, int r7) {
        this.mDivider.setBounds(r7, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + r7, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(r6);
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    @RemotableViewMethod
    public void setBaselineAligned(boolean r1) {
        this.mBaselineAligned = r1;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    @RemotableViewMethod
    public void setMeasureWithLargestChildEnabled(boolean r1) {
        this.mUseLargestChild = r1;
    }

    @Override // android.view.View
    public int getBaseline() {
        if (this.mBaselineAlignedChildIndex < 0) goto L5;
        int r0 = getChildCount();
        int r1 = this.mBaselineAlignedChildIndex;
        if (r0 <= r1) goto L33;
        View r2 = getChildAt(r1);
        if (r2 == null) goto L11;
        int r3 = r2.getBaseline();
        if (r3 == (-1)) goto L15;
        int r4 = this.mBaselineChildTop;
        if (this.mOrientation != 1) goto L31;
        int r5 = this.mGravity & 112;
        if (r5 == 48) goto L31;
        if (r5 != 16) goto L26;
        r4 = r4 + (((((this.mBottom - this.mTop) - this.mPaddingTop) - this.mPaddingBottom) - this.mTotalLength) / 2);
        goto L31
    L26:
        if (r5 != 80) goto L31;
        r4 = ((this.mBottom - this.mTop) - this.mPaddingBottom) - this.mTotalLength;
    L31:
        return (r4 + ((LayoutParams) r2.getLayoutParams()).topMargin) + r3;
    L15:
        if (this.mBaselineAlignedChildIndex != 0) goto L18;
        return -1;
    L18:
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
    L11:
        return super.getBaseline();
    L33:
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
    L5:
        return super.getBaseline();
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    @RemotableViewMethod
    public void setBaselineAlignedChildIndex(int r3) {
        if (r3 < 0) goto L8;
        if (r3 >= getChildCount()) goto L8;
        this.mBaselineAlignedChildIndex = r3;
        return;
    L8:
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
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

    @RemotableViewMethod
    public void setWeightSum(float r2) {
        this.mWeightSum = Math.max(0.0f, r2);
    }

    @Override // android.view.View
    protected void onMeasure(int r3, int r4) {
        if (this.mOrientation != 1) goto L5;
        measureVertical(r3, r4);
        return;
    L5:
        measureHorizontal(r3, r4);
    }

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
        if ((this.mShowDividers & 2) == 0) goto L24;
        int r6 = r5 - 1;
    L17:
        if (r6 < 0) goto L32;
        View r2 = getChildAt(r6);
        if (r2 == null) goto L23;
        if (r2.getVisibility() == 8) goto L23;
        return true;
    L23:
        r6 = r6 - 1;
        goto L17
    L32:
        return false;
    L24:
        return false;
    }

    void measureVertical(int r33, int r34) {
        int r10 = 0;
        this.mTotalLength = 0;
        int r11 = getVirtualChildCount();
        int r12 = View.MeasureSpec.getMode(r33);
        int r13 = View.MeasureSpec.getMode(r34);
        int r14 = this.mBaselineAlignedChildIndex;
        boolean r15 = this.mUseLargestChild;
        int r1 = 0;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        boolean r18 = false;
        boolean r20 = false;
        boolean r19 = true;
        float r0 = 0.0f;
        int r2 = Integer.MIN_VALUE;
    L3:
        int r6 = 8;
        int r22 = r4;
        if (r5 >= r11) goto L73;
        View r7 = getVirtualChildAt(r5);
        if (r7 != null) goto L8;
        this.mTotalLength += measureNullChild(r5);
        int r23 = r11;
        int r25 = r13;
        r4 = r22;
    L72:
        r5 = r5 + 1;
        r11 = r23;
        r13 = r25;
        goto L3
    L8:
        int r26 = r1;
        if (r7.getVisibility() != 8) goto L12;
        r5 = r5 + getChildrenSkipCount(r7, r5);
        r23 = r11;
        r4 = r22;
        r1 = r26;
        r25 = r13;
        goto L72
    L12:
        if (hasDividerBeforeChildAt(r5) == false) goto L14;
        this.mTotalLength += this.mDividerHeight;
    L14:
        LayoutParams r8 = (LayoutParams) r7.getLayoutParams();
        float r27 = r0 + r8.weight;
        if (r13 == 1073741824) goto L17;
    L21:
        int r28 = r2;
        if (r8.height == 0) goto L24;
    L26:
        int r9 = Integer.MIN_VALUE;
    L28:
        if (r27 != 0.0f) goto L30;
        int r29 = this.mTotalLength;
    L31:
        int r16 = r26;
        int r31 = r9;
        r23 = r11;
        r25 = r13;
        int r17 = r5;
        int r21 = r3;
        int r210 = r22;
        LayoutParams r110 = r8;
        measureChildBeforeLayout(r7, r5, r33, 0, r34, r29);
        if (r31 == Integer.MIN_VALUE) goto L34;
        r110.height = r31;
    L34:
        int r24 = r7.getMeasuredHeight();
        int r30 = this.mTotalLength;
        View r32 = r7;
        this.mTotalLength = Math.max(r30, (((r30 + r24) + r110.topMargin) + r110.bottomMargin) + getNextLocationOffset(r32));
        if (r15 == false) goto L37;
        r2 = Math.max(r24, r28);
    L38:
        if (r14 >= 0) goto L40;
    L42:
        if (r17 >= r14) goto L49;
        if (r110.weight <= 0.0f) goto L49;
        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
    L49:
        if (r12 != 1073741824) goto L51;
    L53:
        boolean r35 = false;
    L54:
        int r36 = r110.leftMargin + r110.rightMargin;
        int r37 = r32.getMeasuredWidth() + r36;
        int r38 = Math.max(r16, r37);
        int r39 = combineMeasuredStates(r10, r32.getMeasuredState());
        if (r19 == true) goto L57;
    L59:
        boolean r40 = false;
    L61:
        if (r110.weight <= 0.0f) goto L66;
        if (r35 == true) goto L65;
        r36 = r37;
    L65:
        int r111 = Math.max(r21, r36);
        r4 = r210;
    L71:
        int r41 = getChildrenSkipCount(r32, r17) + r17;
        r1 = r38;
        r10 = r39;
        r19 = r40;
        r3 = r111;
        r5 = r41;
        r0 = r27;
        goto L72
    L66:
        r111 = r21;
        if (r35 == true) goto L70;
        r36 = r37;
    L70:
        r4 = Math.max(r210, r36);
        goto L71
    L57:
        if (r110.width != (-1)) goto L59;
        r40 = true;
        goto L61
    L51:
        if (r110.width != (-1)) goto L53;
        r35 = true;
        r20 = true;
        goto L54
    L40:
        if (r14 != (r17 + 1)) goto L42;
        this.mBaselineChildTop = this.mTotalLength;
        goto L42
    L37:
        r2 = r28;
        goto L38
    L30:
        r29 = 0;
        goto L31
    L24:
        if (r8.weight <= 0.0f) goto L26;
        r8.height = -2;
        r9 = 0;
        goto L28
    L17:
        if (r8.height != 0) goto L21;
        if (r8.weight <= 0.0f) goto L21;
        int r42 = this.mTotalLength;
        this.mTotalLength = Math.max(r42, (r8.topMargin + r42) + r8.bottomMargin);
        r21 = r3;
        r32 = r7;
        r23 = r11;
        r18 = true;
        r210 = r22;
        r16 = r26;
        r2 = r2;
        r17 = r5;
        r25 = r13;
        r110 = r8;
        goto L38
    L73:
        int r43 = r1;
        int r44 = r2;
        int r211 = r11;
        int r212 = r13;
        int r45 = r22;
        int r112 = r3;
        if (this.mTotalLength <= 0) goto L78;
        int r46 = r211;
        if (hasDividerBeforeChildAt(r46) == false) goto L80;
        this.mTotalLength += this.mDividerHeight;
    L80:
        if (r15 == false) goto L93;
        if (r212 == Integer.MIN_VALUE) goto L83;
        if (r212 != 0) goto L93;
    L83:
        this.mTotalLength = 0;
        int r47 = 0;
    L84:
        if (r47 >= r46) goto L93;
        View r48 = getVirtualChildAt(r47);
        if (r48 != null) goto L89;
        this.mTotalLength += measureNullChild(r47);
    L92:
        r47 = r47 + 1;
        r6 = 8;
        goto L84
    L89:
        if (r48.getVisibility() != r6) goto L91;
        r47 = r47 + getChildrenSkipCount(r48, r47);
        goto L92
    L91:
        LayoutParams r113 = (LayoutParams) r48.getLayoutParams();
        int r114 = this.mTotalLength;
        this.mTotalLength = Math.max(r114, (((r114 + r44) + r113.topMargin) + r113.bottomMargin) + getNextLocationOffset(r48));
    L93:
        int r49 = this.mTotalLength + (this.mPaddingTop + this.mPaddingBottom);
        this.mTotalLength = r49;
        int r50 = resolveSizeAndState(Math.max(r49, getSuggestedMinimumHeight()), r34, 0);
        int r115 = (16777215 & r50) - this.mTotalLength;
        if (r18 == true) goto L115;
        if (r115 != 0) goto L97;
    L99:
        int r51 = Math.max(r45, r112);
        if (r15 == true) goto L102;
    L114:
        int r213 = r46;
        int r52 = r43;
    L171:
        if (r19 == false) goto L173;
    L175:
        r51 = r52;
    L176:
        setMeasuredDimension(resolveSizeAndState(Math.max(r51 + (this.mPaddingLeft + this.mPaddingRight), getSuggestedMinimumWidth()), r33, r10), r50);
        if (r20 == false) goto L197;
        forceUniformWidth(r213, r34);
        return;
    L197:
        return;
    L173:
        if (r12 == 1073741824) goto L175;
    L102:
        if (r212 == 1073741824) goto L114;
        int r53 = 0;
    L104:
        if (r53 >= r46) goto L114;
        View r54 = getVirtualChildAt(r53);
        if (r54 == null) goto L113;
        if (r54.getVisibility() == 8) goto L113;
        if (((LayoutParams) r54.getLayoutParams()).weight <= 0.0f) goto L113;
        r54.measure(View.MeasureSpec.makeMeasureSpec(r54.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r44, 1073741824));
    L113:
        r53 = r53 + 1;
        goto L104
    L97:
        if (r0 <= 0.0f) goto L99;
    L115:
        float r55 = this.mWeightSum;
        if (r55 <= 0.0f) goto L118;
        r0 = r55;
    L118:
        this.mTotalLength = 0;
        int r56 = 0;
    L119:
        if (r56 >= r46) goto L170;
        View r116 = getVirtualChildAt(r56);
        if (r116 != null) goto L123;
    L168:
        float r117 = r0;
        int r214 = r46;
    L169:
        r0 = r117;
        r56 = r56 + 1;
        r46 = r214;
        goto L119
    L123:
        if (r116.getVisibility() == 8) goto L168;
        LayoutParams r118 = (LayoutParams) r116.getLayoutParams();
        float r57 = r118.weight;
        if (r57 <= 0.0f) goto L143;
        if (r115 <= 0) goto L143;
        int r119 = (int) ((r115 * r57) / r0);
        r115 = r115 - r119;
        float r120 = r0 - r57;
        r214 = r46;
        int r58 = getChildMeasureSpec(r33, ((this.mPaddingLeft + this.mPaddingRight) + r118.leftMargin) + r118.rightMargin, r118.width);
        if (r118.height != 0) goto L137;
        int r59 = 1073741824;
        if (r212 != 1073741824) goto L138;
        if (r119 > 0) goto L136;
        r119 = 0;
    L136:
        r116.measure(r58, View.MeasureSpec.makeMeasureSpec(r119, 1073741824));
    L142:
        r10 = combineMeasuredStates(r10, r116.getMeasuredState() & InputDeviceCompat.SOURCE_ANY);
    L152:
        int r60 = r118.leftMargin + r118.rightMargin;
        int r121 = r116.getMeasuredWidth() + r60;
        r43 = Math.max(r43, r121);
        r117 = r120;
        if (r12 == 1073741824) goto L157;
        int r215 = r60;
        int r61 = -1;
        if (r118.width != (-1)) goto L158;
        boolean r62 = true;
    L159:
        if (r62 == false) goto L161;
        r121 = r215;
    L161:
        int r63 = Math.max(r45, r121);
        if (r19 == true) goto L164;
    L166:
        boolean r64 = false;
    L167:
        int r122 = this.mTotalLength;
        this.mTotalLength = Math.max(r122, (((r122 + r116.getMeasuredHeight()) + r118.topMargin) + r118.bottomMargin) + getNextLocationOffset(r116));
        r19 = r64;
        r45 = r63;
        goto L169
    L164:
        if (r118.width != r61) goto L166;
        r64 = true;
    L158:
        r62 = false;
        goto L159
    L157:
        r215 = r60;
        r61 = -1;
    L138:
        int r123 = r116.getMeasuredHeight() + r119;
        if (r123 >= 0) goto L141;
        r123 = 0;
    L141:
        r116.measure(r58, View.MeasureSpec.makeMeasureSpec(r123, r59));
        goto L142
    L137:
        r59 = 1073741824;
    L143:
        r214 = r46;
        if (r115 < 0) goto L146;
    L151:
        r120 = r0;
        goto L152
    L146:
        if (r118.height != (-1)) goto L151;
        int r65 = getChildMeasureSpec(r33, ((this.mPaddingLeft + this.mPaddingRight) + r118.leftMargin) + r118.rightMargin, r118.width);
        int r124 = r116.getMeasuredHeight() + r115;
        if (r124 >= 0) goto L150;
        r124 = 0;
    L150:
        r115 = r115 - (r124 - r116.getMeasuredHeight());
        r120 = r0;
        r116.measure(r65, View.MeasureSpec.makeMeasureSpec(r124, 1073741824));
        r10 = combineMeasuredStates(r10, r116.getMeasuredState() & InputDeviceCompat.SOURCE_ANY);
        goto L152
    L170:
        r213 = r46;
        this.mTotalLength += this.mPaddingTop + this.mPaddingBottom;
        r51 = r45;
        r52 = r43;
        goto L171
    L78:
        r46 = r211;
        goto L80
    }

    private void forceUniformWidth(int r11, int r12) {
        int r0 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        int r1 = 0;
    L3:
        if (r1 >= r11) goto L10;
        View r3 = getVirtualChildAt(r1);
        if (r3.getVisibility() == 8) goto L9;
        LayoutParams r8 = (LayoutParams) r3.getLayoutParams();
        if (r8.width != (-1)) goto L9;
        int r9 = r8.height;
        r8.height = r3.getMeasuredHeight();
        measureChildWithMargins(r3, r0, 0, r12, 0);
        r8.height = r9;
    L9:
        r1 = r1 + 1;
        goto L3
    }

    void measureHorizontal(int r1, int r2) {
        throw new IllegalStateException("horizontal mode not supported.");
    }

    private void forceUniformHeight(int r11, int r12) {
        int r0 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        int r1 = 0;
    L3:
        if (r1 >= r11) goto L13;
        View r3 = getVirtualChildAt(r1);
        if (r3 == null) goto L12;
        if (r3.getVisibility() == 8) goto L12;
        LayoutParams r8 = (LayoutParams) r3.getLayoutParams();
        if (r8.height != (-1)) goto L12;
        int r9 = r8.width;
        r8.width = r3.getMeasuredWidth();
        measureChildWithMargins(r3, r12, 0, r0, 0);
        r8.width = r9;
    L12:
        r1 = r1 + 1;
        goto L3
    }

    void measureChildBeforeLayout(View r7, int r8, int r9, int r10, int r11, int r12) {
        measureChildWithMargins(r7, r9, r10, r11, r12);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        if (this.mOrientation != 1) goto L5;
        layoutVertical(r3, r4, r5, r6);
        return;
    L5:
        layoutHorizontal(r3, r4, r5, r6);
    }

    void layoutVertical(int r18, int r19, int r20, int r21) {
        int r7 = this.mPaddingLeft;
        int r0 = r20 - r18;
        int r8 = r0 - this.mPaddingRight;
        int r9 = (r0 - r7) - this.mPaddingRight;
        int r10 = getVirtualChildCount();
        int r1 = this.mGravity;
        int r2 = r1 & 112;
        int r11 = r1 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (r2 != 16) goto L5;
        int r3 = this.mPaddingTop + (((r21 - r19) - this.mTotalLength) / 2);
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
        int r14 = r6.gravity;
        if (r14 >= 0) goto L19;
        r14 = r11;
    L19:
        int r16 = Gravity.getAbsoluteGravity(r14, getLayoutDirection()) & 7;
        if (r16 != 1) goto L22;
        int r17 = (((r9 - r5) / 2) + r7) + r6.leftMargin;
        int r22 = r6.rightMargin;
    L26:
        int r23 = r17 - r22;
    L27:
        int r24 = r23;
        if (hasDividerBeforeChildAt(r12) == false) goto L30;
        r3 = r3 + this.mDividerHeight;
    L30:
        int r110 = r3 + r6.topMargin;
        setChildFrame(r13, r24, r110 + getLocationOffset(r13), r5, r15);
        int r111 = r110 + ((r15 + r6.bottomMargin) + getNextLocationOffset(r13));
        r12 = r12 + getChildrenSkipCount(r13, r12);
        r3 = r111;
        r4 = 1;
        goto L32
    L22:
        if (r16 == 5) goto L24;
        r23 = r6.leftMargin + r7;
        goto L27
    L24:
        r17 = r8 - r5;
        r22 = r6.rightMargin;
        goto L26
    L33:
        return;
    L5:
        if (r2 == 80) goto L7;
        r3 = this.mPaddingTop;
        goto L9
    L7:
        r3 = ((this.mPaddingTop + r21) - r19) - this.mTotalLength;
        goto L9
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int r2) {
        super.onRtlPropertiesChanged(r2);
        if (r2 == this.mLayoutDirection) goto L8;
        this.mLayoutDirection = r2;
        if (this.mOrientation != 0) goto L9;
        requestLayout();
        return;
    L9:
        return;
    }

    void layoutHorizontal(int r25, int r26, int r27, int r28) {
        boolean r0 = isLayoutRtl();
        int r7 = this.mPaddingTop;
        int r1 = r28 - r26;
        int r8 = r1 - this.mPaddingBottom;
        int r9 = (r1 - r7) - this.mPaddingBottom;
        int r10 = getVirtualChildCount();
        int r2 = this.mGravity;
        int r11 = r2 & 112;
        boolean r12 = this.mBaselineAligned;
        int[] r13 = this.mMaxAscent;
        int[] r14 = this.mMaxDescent;
        int r3 = Gravity.getAbsoluteGravity(8388615 & r2, getLayoutDirection());
        boolean r5 = true;
        if (r3 != 1) goto L5;
        int r4 = this.mPaddingLeft + (((r27 - r25) - this.mTotalLength) / 2);
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
        if (r22.height == (-1)) goto L26;
        int r111 = r18.getBaseline();
    L27:
        int r23 = r22.gravity;
        if (r23 >= 0) goto L30;
        r23 = r11;
    L30:
        int r24 = r23 & 112;
        r11 = r11;
        if (r24 != 16) goto L33;
        r21 = true;
        int r29 = ((((r9 - r20) / 2) + r7) + r22.topMargin) - r22.bottomMargin;
    L46:
        if (hasDividerBeforeChildAt(r15) == false) goto L48;
        r4 = r4 + this.mDividerWidth;
    L48:
        int r112 = r22.leftMargin + r4;
        r7 = r7;
        setChildFrame(r18, r112 + getLocationOffset(r18), r29, r19, r20);
        int r113 = r112 + ((r19 + r22.rightMargin) + getNextLocationOffset(r18));
        r6 = r110 + getChildrenSkipCount(r18, r15);
        r4 = r113;
        goto L51
    L33:
        if (r24 != 48) goto L35;
        r29 = r22.topMargin + r7;
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
        r29 = (r8 - r20) - r22.bottomMargin;
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
        r4 = this.mPaddingLeft;
        goto L10
    L7:
        r4 = ((this.mPaddingLeft + r27) - r25) - this.mTotalLength;
        goto L10
    }

    private void setChildFrame(View r1, int r2, int r3, int r4, int r5) {
        r1.layout(r2, r3, r4 + r2, r5 + r3);
    }

    public void setOrientation(int r2) {
        if (this.mOrientation == r2) goto L6;
        this.mOrientation = r2;
        requestLayout();
        return;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    @RemotableViewMethod
    public void setGravity(int r2) {
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

    @RemotableViewMethod
    public void setHorizontalGravity(int r3) {
        int r4 = r3 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int r1 = this.mGravity;
        if ((8388615 & r1) == r4) goto L6;
        this.mGravity = r4 | ((-8388616) & r1);
        requestLayout();
        return;
    }

    @RemotableViewMethod
    public void setVerticalGravity(int r3) {
        int r4 = r3 & 112;
        int r0 = this.mGravity;
        if ((r0 & 112) == r4) goto L6;
        this.mGravity = r4 | (r0 & NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH);
        requestLayout();
        return;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r2) {
        return new LayoutParams(getContext(), r2);
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
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return new LayoutParams(r1);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return r1 instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return MatchParentShrinkingLinearLayout.class.getName();
    }

    protected void encodeProperties(ViewHierarchyEncoder r3) {
        super.encodeProperties(r3);
        r3.addProperty("layout:baselineAligned", this.mBaselineAligned);
        r3.addProperty("layout:baselineAlignedChildIndex", this.mBaselineAlignedChildIndex);
        r3.addProperty("measurement:baselineChildTop", this.mBaselineChildTop);
        r3.addProperty("measurement:orientation", this.mOrientation);
        r3.addProperty("measurement:gravity", this.mGravity);
        r3.addProperty("measurement:totalLength", this.mTotalLength);
        r3.addProperty("layout:totalLength", this.mTotalLength);
        r3.addProperty("layout:useLargestChild", this.mUseLargestChild);
    }
}
