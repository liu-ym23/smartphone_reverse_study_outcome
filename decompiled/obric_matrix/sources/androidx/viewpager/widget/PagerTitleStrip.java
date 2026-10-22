package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@ViewPager.DecorView
public class PagerTitleStrip extends ViewGroup {
    private static final int[] ATTRS = null;
    private static final float SIDE_ALPHA = 0.6f;
    private static final int[] TEXT_ATTRS = null;
    private static final int TEXT_SPACING = 16;
    TextView mCurrText;
    private int mGravity;
    private int mLastKnownCurrentPage;
    float mLastKnownPositionOffset;
    TextView mNextText;
    private int mNonPrimaryAlpha;
    private final PageListener mPageListener;
    ViewPager mPager;
    TextView mPrevText;
    private int mScaledTextSpacing;
    int mTextColor;
    private boolean mUpdatingPositions;
    private boolean mUpdatingText;
    private WeakReference<PagerAdapter> mWatchingAdapter;

    private class PageListener extends DataSetObserver implements ViewPager.OnPageChangeListener, ViewPager.OnAdapterChangeListener {
        private int mScrollState;
        final /* synthetic */ PagerTitleStrip this$0;

        PageListener(PagerTitleStrip r1) {
            this.this$0 = r1;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(ViewPager r1, PagerAdapter r2, PagerAdapter r3) {
            this.this$0.updateAdapter(r2, r3);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PagerTitleStrip r0 = this.this$0;
            r0.updateText(r0.mPager.getCurrentItem(), this.this$0.mPager.getAdapter());
            PagerTitleStrip r3 = this.this$0;
            float r1 = r3.mLastKnownPositionOffset;
            if (r1 >= 0.0f) goto L6;
            r1 = 0.0f;
        L6:
            r3.updateTextPositions(r3.mPager.getCurrentItem(), r1, true);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int r1) {
            this.mScrollState = r1;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int r1, float r2, int r3) {
            if (r2 <= 0.5f) goto L5;
            r1 = r1 + 1;
        L5:
            this.this$0.updateTextPositions(r1, r2, false);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r3) {
            if (this.mScrollState != 0) goto L10;
            PagerTitleStrip r4 = this.this$0;
            r4.updateText(r4.mPager.getCurrentItem(), this.this$0.mPager.getAdapter());
            PagerTitleStrip r2 = this.this$0;
            float r5 = r2.mLastKnownPositionOffset;
            if (r5 >= 0.0f) goto L8;
            r5 = 0.0f;
        L8:
            r2.updateTextPositions(r2.mPager.getCurrentItem(), r5, true);
            return;
        }
    }

    private static class SingleLineAllCapsTransform extends SingleLineTransformationMethod {
        private Locale mLocale;

        SingleLineAllCapsTransform(Context r1) {
            this.mLocale = r1.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence r1, View r2) {
            CharSequence r3 = super.getTransformation(r1, r2);
            if (r3 != null) goto L7;
            return null;
        L7:
            return r3.toString().toUpperCase(this.mLocale);
        }
    }

    static {
        ATTRS = new int[]{R.attr.textAppearance, R.attr.textSize, R.attr.textColor, R.attr.gravity};
        TEXT_ATTRS = new int[]{R.attr.textAllCaps};
    }

    public PagerTitleStrip(@NonNull Context r2) {
        this(r2, null);
    }

    public PagerTitleStrip(@NonNull Context r5, @Nullable AttributeSet r6) {
        super(r5, r6);
        this.mLastKnownCurrentPage = -1;
        this.mLastKnownPositionOffset = -1.0f;
        this.mPageListener = new PageListener(this);
        TextView r0 = new TextView(r5);
        this.mPrevText = r0;
        addView(r0);
        TextView r1 = new TextView(r5);
        this.mCurrText = r1;
        addView(r1);
        TextView r2 = new TextView(r5);
        this.mNextText = r2;
        addView(r2);
        TypedArray r7 = r5.obtainStyledAttributes(r6, ATTRS);
        boolean r3 = false;
        int r4 = r7.getResourceId(0, 0);
        if (r4 == 0) goto L5;
        TextViewCompat.setTextAppearance(this.mPrevText, r4);
        TextViewCompat.setTextAppearance(this.mCurrText, r4);
        TextViewCompat.setTextAppearance(this.mNextText, r4);
    L5:
        int r8 = r7.getDimensionPixelSize(1, 0);
        if (r8 == 0) goto L9;
        setTextSize(0, r8);
    L9:
        if (r7.hasValue(2) == false) goto L11;
        int r9 = r7.getColor(2, 0);
        this.mPrevText.setTextColor(r9);
        this.mCurrText.setTextColor(r9);
        this.mNextText.setTextColor(r9);
    L11:
        this.mGravity = r7.getInteger(3, 80);
        r7.recycle();
        this.mTextColor = this.mCurrText.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(SIDE_ALPHA);
        this.mPrevText.setEllipsize(TextUtils.TruncateAt.END);
        this.mCurrText.setEllipsize(TextUtils.TruncateAt.END);
        this.mNextText.setEllipsize(TextUtils.TruncateAt.END);
        if (r4 == 0) goto L14;
        TypedArray r10 = r5.obtainStyledAttributes(r4, TEXT_ATTRS);
        r3 = r10.getBoolean(0, false);
        r10.recycle();
    L14:
        TextView r11 = this.mPrevText;
        if (r3 == false) goto L17;
        setSingleLineAllCaps(r11);
        setSingleLineAllCaps(this.mCurrText);
        setSingleLineAllCaps(this.mNextText);
    L18:
        this.mScaledTextSpacing = (int) (r5.getResources().getDisplayMetrics().density * 16.0f);
        return;
    L17:
        r11.setSingleLine();
        this.mCurrText.setSingleLine();
        this.mNextText.setSingleLine();
        goto L18
    }

    private static void setSingleLineAllCaps(TextView r2) {
        r2.setTransformationMethod(new SingleLineAllCapsTransform(r2.getContext()));
    }

    int getMinHeight() {
        Drawable r0 = getBackground();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getIntrinsicHeight();
    }

    public int getTextSpacing() {
        return this.mScaledTextSpacing;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent r0 = getParent();
        if ((r0 instanceof ViewPager) == false) goto L11;
        ViewPager r1 = (ViewPager) r0;
        PagerAdapter r2 = r1.getAdapter();
        r1.setInternalPageChangeListener(this.mPageListener);
        r1.addOnAdapterChangeListener(this.mPageListener);
        this.mPager = r1;
        WeakReference<PagerAdapter> r3 = this.mWatchingAdapter;
        if (r3 == null) goto L7;
        PagerAdapter r4 = r3.get();
    L8:
        updateAdapter(r4, r2);
        return;
    L7:
        r4 = null;
        goto L8
    L11:
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager r0 = this.mPager;
        if (r0 == null) goto L6;
        updateAdapter(r0.getAdapter(), null);
        this.mPager.setInternalPageChangeListener(null);
        this.mPager.removeOnAdapterChangeListener(this.mPageListener);
        this.mPager = null;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        if (this.mPager == null) goto L10;
        float r6 = this.mLastKnownPositionOffset;
        if (r6 >= 0.0f) goto L8;
        r6 = 0.0f;
    L8:
        updateTextPositions(this.mLastKnownCurrentPage, r6, true);
        return;
    }

    @Override // android.view.View
    protected void onMeasure(int r8, int r9) {
        if (View.MeasureSpec.getMode(r8) != 1073741824) goto L11;
        int r0 = getPaddingTop() + getPaddingBottom();
        int r3 = ViewGroup.getChildMeasureSpec(r9, r0, -2);
        int r4 = View.MeasureSpec.getSize(r8);
        int r10 = ViewGroup.getChildMeasureSpec(r8, (int) (r4 * 0.2f), -2);
        this.mPrevText.measure(r10, r3);
        this.mCurrText.measure(r10, r3);
        this.mNextText.measure(r10, r3);
        if (View.MeasureSpec.getMode(r9) != 1073741824) goto L7;
        int r11 = View.MeasureSpec.getSize(r9);
    L8:
        setMeasuredDimension(r4, View.resolveSizeAndState(r11, r9, this.mCurrText.getMeasuredState() << 16));
        return;
    L7:
        r11 = Math.max(getMinHeight(), this.mCurrText.getMeasuredHeight() + r0);
        goto L8
    L11:
        throw new IllegalStateException("Must measure with an exact width");
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mUpdatingText == true) goto L6;
        super.requestLayout();
        return;
    }

    public void setGravity(int r1) {
        this.mGravity = r1;
        requestLayout();
    }

    public void setNonPrimaryAlpha(@FloatRange(from = 0.0d, to = 1.0d) float r3) {
        int r4 = ((int) (r3 * 255.0f)) & 255;
        this.mNonPrimaryAlpha = r4;
        int r5 = (r4 << 24) | (this.mTextColor & ViewCompat.MEASURED_SIZE_MASK);
        this.mPrevText.setTextColor(r5);
        this.mNextText.setTextColor(r5);
    }

    public void setTextColor(@ColorInt int r3) {
        this.mTextColor = r3;
        this.mCurrText.setTextColor(r3);
        int r4 = (this.mNonPrimaryAlpha << 24) | (this.mTextColor & ViewCompat.MEASURED_SIZE_MASK);
        this.mPrevText.setTextColor(r4);
        this.mNextText.setTextColor(r4);
    }

    public void setTextSize(int r2, float r3) {
        this.mPrevText.setTextSize(r2, r3);
        this.mCurrText.setTextSize(r2, r3);
        this.mNextText.setTextSize(r2, r3);
    }

    public void setTextSpacing(int r1) {
        this.mScaledTextSpacing = r1;
        requestLayout();
    }

    void updateAdapter(PagerAdapter r2, PagerAdapter r3) {
        if (r2 == null) goto L4;
        r2.unregisterDataSetObserver(this.mPageListener);
        this.mWatchingAdapter = null;
    L4:
        if (r3 == null) goto L6;
        r3.registerDataSetObserver(this.mPageListener);
        this.mWatchingAdapter = new WeakReference(r3);
    L6:
        ViewPager r4 = this.mPager;
        if (r4 == null) goto L10;
        this.mLastKnownCurrentPage = -1;
        this.mLastKnownPositionOffset = -1.0f;
        updateText(r4.getCurrentItem(), r3);
        requestLayout();
        return;
    }

    void updateText(int r6, PagerAdapter r7) {
        if (r7 == null) goto L5;
        int r1 = r7.getCount();
    L6:
        this.mUpdatingText = true;
        CharSequence r3 = null;
        if (r6 < 1) goto L10;
        if (r7 == null) goto L10;
        CharSequence r2 = r7.getPageTitle(r6 - 1);
    L11:
        this.mPrevText.setText(r2);
        TextView r4 = this.mCurrText;
        if (r7 == null) goto L15;
        if (r6 >= r1) goto L15;
        CharSequence r5 = r7.getPageTitle(r6);
    L16:
        r4.setText(r5);
        int r8 = r6 + 1;
        if (r8 >= r1) goto L20;
        if (r7 == null) goto L20;
        r3 = r7.getPageTitle(r8);
    L20:
        this.mNextText.setText(r3);
        int r9 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
        int r10 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.mPrevText.measure(r9, r10);
        this.mCurrText.measure(r9, r10);
        this.mNextText.measure(r9, r10);
        this.mLastKnownCurrentPage = r6;
        if (this.mUpdatingPositions == true) goto L23;
        updateTextPositions(r6, this.mLastKnownPositionOffset, false);
    L23:
        this.mUpdatingText = false;
        return;
    L15:
        r5 = null;
    L10:
        r2 = null;
        goto L11
    L5:
        r1 = 0;
        goto L6
    }

    void updateTextPositions(int r18, float r19, boolean r20) {
        if (r18 == this.mLastKnownCurrentPage) goto L5;
        updateText(r18, this.mPager.getAdapter());
    L9:
        this.mUpdatingPositions = true;
        int r1 = this.mPrevText.getMeasuredWidth();
        int r3 = this.mCurrText.getMeasuredWidth();
        int r4 = this.mNextText.getMeasuredWidth();
        int r5 = r3 / 2;
        int r6 = getWidth();
        int r7 = getHeight();
        int r8 = getPaddingLeft();
        int r9 = getPaddingRight();
        int r10 = getPaddingTop();
        int r11 = getPaddingBottom();
        int r13 = r9 + r5;
        int r12 = (r6 - (r8 + r5)) - r13;
        float r14 = 0.5f + r19;
        if (r14 <= 1.0f) goto L12;
        r14 = r14 - 1.0f;
    L12:
        int r15 = ((r6 - r13) - ((int) (r12 * r14))) - r5;
        int r16 = r3 + r15;
        int r17 = this.mPrevText.getBaseline();
        int r110 = this.mCurrText.getBaseline();
        int r111 = this.mNextText.getBaseline();
        int r112 = Math.max(Math.max(r17, r110), r111);
        int r21 = r112 - r17;
        int r113 = r112 - r110;
        int r114 = r112 - r111;
        int r115 = this.mPrevText.getMeasuredHeight() + r21;
        int r2 = this.mCurrText.getMeasuredHeight() + r113;
        int r22 = Math.max(Math.max(r115, r2), this.mNextText.getMeasuredHeight() + r114);
        int r23 = this.mGravity & 112;
        if (r23 != 16) goto L15;
        int r24 = (((r7 - r10) - r11) - r22) / 2;
    L19:
        int r25 = r21 + r24;
        int r116 = r113 + r24;
        int r117 = r24 + r114;
    L20:
        TextView r26 = this.mCurrText;
        r26.layout(r15, r116, r16, r26.getMeasuredHeight() + r116);
        int r27 = Math.min(r8, (r15 - this.mScaledTextSpacing) - r1);
        TextView r28 = this.mPrevText;
        r28.layout(r27, r25, r1 + r27, r28.getMeasuredHeight() + r25);
        int r29 = Math.max((r6 - r9) - r4, r16 + this.mScaledTextSpacing);
        TextView r30 = this.mNextText;
        r30.layout(r29, r117, r29 + r4, r30.getMeasuredHeight() + r117);
        this.mLastKnownPositionOffset = r19;
        this.mUpdatingPositions = false;
        return;
    L15:
        if (r23 == 80) goto L17;
        r25 = r21 + r10;
        r116 = r113 + r10;
        r117 = r10 + r114;
        goto L20
    L17:
        r24 = (r7 - r11) - r22;
        goto L19
    L5:
        if (r20 == true) goto L9;
        if (r19 != this.mLastKnownPositionOffset) goto L9;
    }
}
