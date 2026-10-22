package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;

/* JADX INFO: loaded from: classes.dex */
public class CardView extends FrameLayout {
    private static final int[] COLOR_BACKGROUND_ATTR = null;
    private static final CardViewImpl IMPL = null;
    private final CardViewDelegate mCardViewDelegate;
    private boolean mCompatPadding;
    final Rect mContentPadding;
    private boolean mPreventCornerOverlap;
    final Rect mShadowBounds;
    int mUserSetMinHeight;
    int mUserSetMinWidth;

    static {
        COLOR_BACKGROUND_ATTR = new int[]{R.attr.colorBackground};
        CardViewApi21Impl r0 = new CardViewApi21Impl();
        IMPL = r0;
        r0.initStatic();
    }

    public CardView(@NonNull Context r2) {
        this(r2, null);
    }

    public static /* synthetic */ void access$001(CardView r0, int r1, int r2, int r3, int r4) {
        super.setPadding(r1, r2, r3, r4);
    }

    public static /* synthetic */ void access$101(CardView r0, int r1) {
        super.setMinimumWidth(r1);
    }

    public static /* synthetic */ void access$201(CardView r0, int r1) {
        super.setMinimumHeight(r1);
    }

    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return IMPL.getBackgroundColor(this.mCardViewDelegate);
    }

    public float getCardElevation() {
        return IMPL.getElevation(this.mCardViewDelegate);
    }

    @Px
    public int getContentPaddingBottom() {
        return this.mContentPadding.bottom;
    }

    @Px
    public int getContentPaddingLeft() {
        return this.mContentPadding.left;
    }

    @Px
    public int getContentPaddingRight() {
        return this.mContentPadding.right;
    }

    @Px
    public int getContentPaddingTop() {
        return this.mContentPadding.top;
    }

    public float getMaxCardElevation() {
        return IMPL.getMaxElevation(this.mCardViewDelegate);
    }

    public boolean getPreventCornerOverlap() {
        return this.mPreventCornerOverlap;
    }

    public float getRadius() {
        return IMPL.getRadius(this.mCardViewDelegate);
    }

    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r7, int r8) {
        CardViewImpl r0 = IMPL;
        if ((r0 instanceof CardViewApi21Impl) == true) goto L15;
        int r1 = View.MeasureSpec.getMode(r7);
        if (r1 == Integer.MIN_VALUE) goto L8;
        if (r1 == 1073741824) goto L8;
    L9:
        int r2 = View.MeasureSpec.getMode(r8);
        if (r2 == Integer.MIN_VALUE) goto L13;
        if (r2 == 1073741824) goto L13;
    L14:
        super.onMeasure(r7, r8);
        return;
    L13:
        r8 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.getMinHeight(this.mCardViewDelegate)), View.MeasureSpec.getSize(r8)), r2);
    L8:
        r7 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.getMinWidth(this.mCardViewDelegate)), View.MeasureSpec.getSize(r7)), r1);
        goto L9
    L15:
        super.onMeasure(r7, r8);
    }

    public void setCardBackgroundColor(@ColorInt int r2) {
        IMPL.setBackgroundColor(this.mCardViewDelegate, ColorStateList.valueOf(r2));
    }

    public void setCardElevation(float r2) {
        IMPL.setElevation(this.mCardViewDelegate, r2);
    }

    public void setContentPadding(@Px int r2, @Px int r3, @Px int r4, @Px int r5) {
        this.mContentPadding.set(r2, r3, r4, r5);
        IMPL.updatePadding(this.mCardViewDelegate);
    }

    public void setMaxCardElevation(float r2) {
        IMPL.setMaxElevation(this.mCardViewDelegate, r2);
    }

    @Override // android.view.View
    public void setMinimumHeight(int r1) {
        this.mUserSetMinHeight = r1;
        super.setMinimumHeight(r1);
    }

    @Override // android.view.View
    public void setMinimumWidth(int r1) {
        this.mUserSetMinWidth = r1;
        super.setMinimumWidth(r1);
    }

    @Override // android.view.View
    public void setPadding(int r1, int r2, int r3, int r4) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int r1, int r2, int r3, int r4) {
    }

    public void setPreventCornerOverlap(boolean r2) {
        if (r2 == this.mPreventCornerOverlap) goto L6;
        this.mPreventCornerOverlap = r2;
        IMPL.onPreventCornerOverlapChanged(this.mCardViewDelegate);
        return;
    }

    public void setRadius(float r2) {
        IMPL.setRadius(this.mCardViewDelegate, r2);
    }

    public void setUseCompatPadding(boolean r2) {
        if (this.mCompatPadding == r2) goto L6;
        this.mCompatPadding = r2;
        IMPL.onCompatPaddingChanged(this.mCardViewDelegate);
        return;
    }

    public CardView(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, androidx.cardview.R.attr.cardViewStyle);
    }

    public void setCardBackgroundColor(@Nullable ColorStateList r2) {
        IMPL.setBackgroundColor(this.mCardViewDelegate, r2);
    }

    public CardView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        Rect r0 = new Rect();
        this.mContentPadding = r0;
        this.mShadowBounds = new Rect();
        CardViewDelegate r3 = new AnonymousClass1(this);
        this.mCardViewDelegate = r3;
        TypedArray r13 = r10.obtainStyledAttributes(r11, androidx.cardview.R.styleable.CardView, r12, androidx.cardview.R.style.CardView);
        if (r13.hasValue(androidx.cardview.R.styleable.CardView_cardBackgroundColor) == false) goto L6;
        ColorStateList r14 = r13.getColorStateList(androidx.cardview.R.styleable.CardView_cardBackgroundColor);
    L5:
        ColorStateList r5 = r14;
        float r6 = r13.getDimension(androidx.cardview.R.styleable.CardView_cardCornerRadius, 0.0f);
        float r7 = r13.getDimension(androidx.cardview.R.styleable.CardView_cardElevation, 0.0f);
        float r15 = r13.getDimension(androidx.cardview.R.styleable.CardView_cardMaxElevation, 0.0f);
        this.mCompatPadding = r13.getBoolean(androidx.cardview.R.styleable.CardView_cardUseCompatPadding, false);
        this.mPreventCornerOverlap = r13.getBoolean(androidx.cardview.R.styleable.CardView_cardPreventCornerOverlap, true);
        int r2 = r13.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPadding, 0);
        r0.left = r13.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingLeft, r2);
        r0.top = r13.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingTop, r2);
        r0.right = r13.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingRight, r2);
        r0.bottom = r13.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingBottom, r2);
        if (r7 <= r15) goto L14;
        float r8 = r7;
    L15:
        this.mUserSetMinWidth = r13.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_android_minWidth, 0);
        this.mUserSetMinHeight = r13.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_android_minHeight, 0);
        r13.recycle();
        IMPL.initialize(r3, r10, r5, r6, r7, r8);
        return;
    L14:
        r8 = r15;
        goto L15
    L6:
        TypedArray r16 = getContext().obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
        int r4 = r16.getColor(0, 0);
        r16.recycle();
        float[] r17 = new float[3];
        Color.colorToHSV(r4, r17);
        if (r17[2] <= 0.5f) goto L9;
        int r18 = getResources().getColor(androidx.cardview.R.color.cardview_light_background);
    L10:
        r14 = ColorStateList.valueOf(r18);
        goto L5
    L9:
        r18 = getResources().getColor(androidx.cardview.R.color.cardview_dark_background);
        goto L10
    }
}
