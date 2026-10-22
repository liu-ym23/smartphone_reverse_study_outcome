package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class PagerTabStrip extends PagerTitleStrip {
    private static final int FULL_UNDERLINE_HEIGHT = 1;
    private static final int INDICATOR_HEIGHT = 3;
    private static final int MIN_PADDING_BOTTOM = 6;
    private static final int MIN_STRIP_HEIGHT = 32;
    private static final int MIN_TEXT_SPACING = 64;
    private static final int TAB_PADDING = 16;
    private static final int TAB_SPACING = 32;
    private static final String TAG = "PagerTabStrip";
    private boolean mDrawFullUnderline;
    private boolean mDrawFullUnderlineSet;
    private int mFullUnderlineHeight;
    private boolean mIgnoreTap;
    private int mIndicatorColor;
    private int mIndicatorHeight;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private int mMinPaddingBottom;
    private int mMinStripHeight;
    private int mMinTextSpacing;
    private int mTabAlpha;
    private int mTabPadding;
    private final Paint mTabPaint;
    private final Rect mTempRect;
    private int mTouchSlop;

    public PagerTabStrip(@NonNull Context r2) {
        this(r2, null);
    }

    public PagerTabStrip(@NonNull Context r4, @Nullable AttributeSet r5) {
        super(r4, r5);
        Paint r6 = new Paint();
        this.mTabPaint = r6;
        this.mTempRect = new Rect();
        this.mTabAlpha = 255;
        this.mDrawFullUnderline = false;
        this.mDrawFullUnderlineSet = false;
        int r1 = this.mTextColor;
        this.mIndicatorColor = r1;
        r6.setColor(r1);
        float r7 = r4.getResources().getDisplayMetrics().density;
        this.mIndicatorHeight = (int) ((3.0f * r7) + 0.5f);
        this.mMinPaddingBottom = (int) ((6.0f * r7) + 0.5f);
        this.mMinTextSpacing = (int) (64.0f * r7);
        this.mTabPadding = (int) ((16.0f * r7) + 0.5f);
        this.mFullUnderlineHeight = (int) ((1.0f * r7) + 0.5f);
        this.mMinStripHeight = (int) ((r7 * 32.0f) + 0.5f);
        this.mTouchSlop = ViewConfiguration.get(r4).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.mPrevText.setFocusable(true);
        this.mPrevText.setOnClickListener(new AnonymousClass1(this));
        this.mNextText.setFocusable(true);
        this.mNextText.setOnClickListener(new AnonymousClass2(this));
        if (getBackground() != null) goto L6;
        this.mDrawFullUnderline = true;
        return;
    }

    public boolean getDrawFullUnderline() {
        return this.mDrawFullUnderline;
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    int getMinHeight() {
        return Math.max(super.getMinHeight(), this.mMinStripHeight);
    }

    @ColorInt
    public int getTabIndicatorColor() {
        return this.mIndicatorColor;
    }

    @Override // android.view.View
    protected void onDraw(Canvas r15) {
        super.onDraw(r15);
        int r0 = getHeight();
        int r1 = this.mCurrText.getLeft() - this.mTabPadding;
        int r2 = this.mCurrText.getRight() + this.mTabPadding;
        int r3 = r0 - this.mIndicatorHeight;
        this.mTabPaint.setColor((this.mTabAlpha << 24) | (this.mIndicatorColor & ViewCompat.MEASURED_SIZE_MASK));
        float r5 = r0;
        r15.drawRect(r1, r3, r2, r5, this.mTabPaint);
        if (this.mDrawFullUnderline == false) goto L6;
        this.mTabPaint.setColor((-16777216) | (this.mIndicatorColor & ViewCompat.MEASURED_SIZE_MASK));
        r15.drawRect(getPaddingLeft(), r0 - this.mFullUnderlineHeight, getWidth() - getPaddingRight(), r5, this.mTabPaint);
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        int r0 = r5.getAction();
        if (r0 != 0) goto L5;
    L7:
        float r2 = r5.getX();
        float r6 = r5.getY();
        if (r0 == 0) goto L25;
        if (r0 == 1) goto L19;
        if (r0 == 2) goto L14;
    L26:
        return true;
    L14:
        if (Math.abs(r2 - this.mInitialMotionX) <= this.mTouchSlop) goto L16;
    L17:
        this.mIgnoreTap = true;
        goto L26
    L16:
        if (Math.abs(r6 - this.mInitialMotionY) <= this.mTouchSlop) goto L26;
    L19:
        if (r2 >= (this.mCurrText.getLeft() - this.mTabPadding)) goto L23;
        ViewPager r4 = this.mPager;
        int r7 = r4.getCurrentItem() - 1;
    L21:
        r4.setCurrentItem(r7);
        goto L26
    L23:
        if (r2 <= (this.mCurrText.getRight() + this.mTabPadding)) goto L26;
        r4 = this.mPager;
        r7 = r4.getCurrentItem() + 1;
        goto L21
    L25:
        this.mInitialMotionX = r2;
        this.mInitialMotionY = r6;
        this.mIgnoreTap = false;
        goto L26
    L5:
        if (this.mIgnoreTap == false) goto L7;
        return false;
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int r2) {
        super.setBackgroundColor(r2);
        if (this.mDrawFullUnderlineSet == false) goto L5;
        return;
    L5:
        if ((r2 & ViewCompat.MEASURED_STATE_MASK) != 0) goto L7;
        boolean r3 = true;
    L8:
        this.mDrawFullUnderline = r3;
        return;
    L7:
        r3 = false;
        goto L8
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r2) {
        super.setBackgroundDrawable(r2);
        if (this.mDrawFullUnderlineSet == true) goto L9;
        if (r2 != null) goto L6;
        boolean r3 = true;
    L7:
        this.mDrawFullUnderline = r3;
        return;
    L6:
        r3 = false;
        goto L7
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int r2) {
        super.setBackgroundResource(r2);
        if (this.mDrawFullUnderlineSet == true) goto L9;
        if (r2 != 0) goto L6;
        boolean r3 = true;
    L7:
        this.mDrawFullUnderline = r3;
        return;
    L6:
        r3 = false;
        goto L7
    }

    public void setDrawFullUnderline(boolean r1) {
        this.mDrawFullUnderline = r1;
        this.mDrawFullUnderlineSet = true;
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int r2, int r3, int r4, int r5) {
        int r0 = this.mMinPaddingBottom;
        if (r5 >= r0) goto L5;
        r5 = r0;
    L5:
        super.setPadding(r2, r3, r4, r5);
    }

    public void setTabIndicatorColor(@ColorInt int r2) {
        this.mIndicatorColor = r2;
        this.mTabPaint.setColor(r2);
        invalidate();
    }

    public void setTabIndicatorColorResource(@ColorRes int r2) {
        setTabIndicatorColor(ContextCompat.getColor(getContext(), r2));
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void setTextSpacing(int r2) {
        int r0 = this.mMinTextSpacing;
        if (r2 >= r0) goto L5;
        r2 = r0;
    L5:
        super.setTextSpacing(r2);
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    void updateTextPositions(int r6, float r7, boolean r8) {
        Rect r0 = this.mTempRect;
        int r1 = getHeight();
        int r2 = this.mCurrText.getLeft() - this.mTabPadding;
        int r3 = this.mCurrText.getRight() + this.mTabPadding;
        int r4 = r1 - this.mIndicatorHeight;
        r0.set(r2, r4, r3, r1);
        super.updateTextPositions(r6, r7, r8);
        this.mTabAlpha = (int) ((Math.abs(r7 - 0.5f) * 2.0f) * 255.0f);
        r0.union(this.mCurrText.getLeft() - this.mTabPadding, r4, this.mCurrText.getRight() + this.mTabPadding, r1);
        invalidate(r0);
    }
}
