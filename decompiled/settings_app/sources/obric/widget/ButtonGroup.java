package obric.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes5.dex */
public class ButtonGroup extends LinearLayout {
    private static final int DEFAULT_BTN_COUNT = 3;
    private static final float MAX_FONT_SCALE_WITH_TEXT = 0.93f;
    private int mBtnCount;
    private ShadowButton[] mBtns;
    private LinearLayout mContainer;
    private boolean mHasBtnGap;
    private float mMaxFontSize;
    private ShadowComponent mShadowComponent;
    private ImageView mShadowView;
    private boolean mSupportLayout;
    private boolean mUseMaxFontSize;

    public ButtonGroup(Context context) {
        this(context, null);
    }

    public ButtonGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ButtonGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.obric_button_group_layout, this);
        this.mContainer = (LinearLayout) findViewById(R.id.ll_group_button_container);
        this.mShadowView = (ImageView) findViewById(R.id.obric_iv_btn_group_shadow);
        TypedArray r4 = context.obtainStyledAttributes(attrs, R.styleable.ButtonGroup, defStyleAttr, 0);
        this.mBtnCount = r4.getInt(R.styleable.ButtonGroup_button_count, 3);
        this.mHasBtnGap = r4.getBoolean(R.styleable.ButtonGroup_has_button_gap, true);
        this.mSupportLayout = r4.getBoolean(R.styleable.ButtonGroup_support_layout, true);
        r4.recycle();
        verifyButtonCount(this.mBtnCount);
        setupButtons();
        initShadowView(attrs, defStyleAttr);
    }

    public void setButtonGroupBackground(int resId) {
        this.mContainer.setBackgroundResource(resId);
    }

    public void setButtonGroupBackground(Drawable drawable) {
        this.mContainer.setBackground(drawable);
    }

    public void setButtonGroupBackgroundColor(int color) {
        this.mContainer.setBackgroundColor(color);
    }

    public void setButtonGroupShadowVisibility(boolean visible) {
        if (this.mSupportLayout == false) goto L5;
        this.mShadowComponent.setShadowVisible(visible);
        return;
    L5:
        ImageView r1 = this.mShadowView;
        if (visible == false) goto L8;
        int r2 = 0;
    L9:
        r1.setVisibility(r2);
        return;
    L8:
        r2 = 8;
        goto L9
    }

    public void setShadowDrawable(int resId) {
        if (this.mSupportLayout == false) goto L5;
        this.mShadowComponent.setShadowDrawable(resId);
        return;
    L5:
        this.mShadowView.setBackgroundResource(resId);
    }

    private void initShadowView(final AttributeSet attrs, final int defStyle) {
        if (this.mSupportLayout == true) goto L6;
        this.mShadowView.setVisibility(0);
        return;
    L6:
        this.mShadowComponent = new AnonymousClass1(this, this, attrs, defStyle);
    }

    private void setupButtons() {
        if (this.mHasBtnGap == true) goto L5;
        int r0 = getResources().getDimensionPixelSize(R.dimen.button_group_left_right_padding);
        this.mContainer.setPadding(r0, getPaddingTop(), r0, getPaddingBottom());
    L5:
        this.mBtns = new ShadowButton[this.mBtnCount];
        int r1 = getResources().getDimensionPixelSize(R.dimen.button_group_btn_gap);
        int r2 = 0;
    L7:
        if (r2 >= this.mBtnCount) goto L13;
        this.mBtns[r2] = new ShadowButton(getContext());
        LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(0, -2);
        r3.weight = 1.0f;
        if (this.mHasBtnGap == false) goto L12;
        if (r2 == 0) goto L12;
        r3.leftMargin = -r1;
    L12:
        this.mBtns[r2].setLayoutParams(r3);
        this.mContainer.addView(this.mBtns[r2]);
        r2 = r2 + 1;
        goto L7
    L13:
        setButtonsAppearance();
    }

    private void setButtonTextSize(TextView tv) {
        if (tv != null) goto L5;
        return;
    L5:
        if (this.mMaxFontSize != 0.0f) goto L10;
        Configuration r0 = getResources().getConfiguration();
        this.mMaxFontSize = (tv.getTextSize() / r0.fontScale) * MAX_FONT_SCALE_WITH_TEXT;
        if ((tv.getTextSize() / r0.fontScale) <= this.mMaxFontSize) goto L10;
        this.mUseMaxFontSize = true;
    L10:
        if (this.mUseMaxFontSize == false) goto L13;
        tv.setTextSize(0, this.mMaxFontSize);
        return;
    }

    private void verifyButtonCount(int count) {
        if (count <= 0) goto L5;
        return;
    L5:
        throw new IllegalArgumentException("the count must be a positive value, but count=" + count);
    }

    public void setButtonCount(int count, boolean hasBtnGap) {
        verifyButtonCount(count);
        this.mBtnCount = count;
        this.mHasBtnGap = hasBtnGap;
        setupButtons();
    }

    public int getButtonCount() {
        return this.mBtnCount;
    }

    private void setButtonsAppearance() {
        int r0 = 0;
    L3:
        int r1 = this.mBtnCount;
        if (r0 >= r1) goto L18;
        if (this.mHasBtnGap == true) goto L16;
        if (r1 <= 1) goto L16;
        this.mBtns[r0].setTextAppearance(getContext(), R.style.SmallButton_Filter);
        if (r0 != 0) goto L12;
        this.mBtns[r0].setBackgroundResource(R.drawable.selector_small_btn_filter_left);
    L15:
        int r2 = R.color.filter_button_text_shadow_colors;
        ColorStateList r3 = getResources().getColorStateList(r2);
        this.mBtns[r0].setShadowColors(r3, 0.1f, 0.0f, -2.0f);
        setButtonTextSize(this.mBtns[r0]);
    L17:
        this.mBtns[r0].setEllipsize(TextUtils.TruncateAt.END);
        this.mBtns[r0].setMaxLines(1);
        r0 = r0 + 1;
        goto L3
    L12:
        if (r0 != (this.mBtnCount - 1)) goto L14;
        this.mBtns[r0].setBackgroundResource(R.drawable.selector_small_btn_filter_right);
        goto L15
    L14:
        this.mBtns[r0].setBackgroundResource(R.drawable.selector_small_btn_filter_middle);
    L16:
        this.mBtns[r0].setTextAppearance(getContext(), R.style.SmallButton_Standard);
        this.mBtns[r0].setBackgroundResource(R.drawable.selector_small_btn_standard);
        goto L17
    }

    public void setButtonText(int index, CharSequence s) {
        this.mBtns[index].setText(s);
    }

    public void setButtonText(int index, int resId) {
        setButtonText(index, getResources().getString(resId));
    }

    public ShadowButton getButton(int index) {
        return this.mBtns[index];
    }

    public void setButtonActivated(int index) {
        int r1 = 0;
    L4:
        if (r1 >= this.mBtnCount) goto L10;
        ShadowButton r2 = this.mBtns[r1];
        if (r1 != index) goto L8;
        boolean r3 = true;
    L9:
        r2.setActivated(r3);
        r1 = r1 + 1;
        goto L4
    L8:
        r3 = false;
        goto L9
    }
}
