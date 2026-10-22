package com.android.settings.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.utils.NullSafe;
import obric.util.Utils;
import obric.widget.SettingItemCheck;

/* JADX INFO: loaded from: classes.dex */
public class SettingItemCheckbox extends SettingItemCheck implements Checkable {
    private ImageView mArrow;
    private CheckBox mCheckbox;
    private LinearLayout mRightSlotView;
    private TextView mSubtitle;

    @Override // obric.widget.ListContentItem
    protected int getDefaultLeftLayout() {
        return R.layout.setting_item_checkbox_left_layout;
    }

    @Override // obric.widget.ListContentItemCheck, obric.widget.ListContentItem
    protected int getDefaultRightLayout() {
        return R.layout.list_content_right_subtitle_arrow;
    }

    public SettingItemCheckbox(Context r2) {
        this(r2, null);
    }

    public SettingItemCheckbox(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public SettingItemCheckbox(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        TypedArray r6 = r3.obtainStyledAttributes(r4, R.styleable.SettingItemCheckbox, r5, 0);
        CharSequence r7 = r6.getText(5);
        if (TextUtils.isEmpty(r7) == true) goto L5;
        setTitle(r7);
    L5:
        setSubtitle(r6.getText(3));
        boolean r8 = r6.getBoolean(1, true);
        setClickable(r8);
        setEnabled(r8);
        setArrowVisible(r6.getBoolean(2, false));
        Drawable r9 = r6.getDrawable(0);
        if (r9 == null) goto L8;
        setArrowDrawable(r9);
    L8:
        setSummary(r6.getText(4));
        setOnClickListener(new AnonymousClass1(this));
        r6.recycle();
        this.mArrow.setDuplicateParentStateEnabled(false);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r1) {
        super.setOnClickListener(r1);
    }

    @Override // obric.widget.ListContentItem
    public void setIcon(int r1) {
        super.setIcon(1);
    }

    @Override // obric.widget.ListContentItem
    public void setIcon(Drawable r1) {
        super.setIcon(1);
    }

    public void setCheckboxDrawable(Drawable r1) {
        this.mCheckbox.setButtonDrawable(r1);
    }

    public void setCheckboxDrawable(int r1) {
        this.mCheckbox.setButtonDrawable(r1);
    }

    @Override // obric.widget.ListContentItem
    protected void initLeftWidget() {
        this.mCheckbox = (CheckBox) findViewById(R.id.item_checkbox_real);
    }

    @Override // obric.widget.ListContentItemCheck, obric.widget.ListContentItem
    protected void initRightWidget() {
        this.mSubtitle = (TextView) NullSafe.nonNull(findViewById(R.id.subtitle));
        this.mSummary = (TextView) NullSafe.nonNull(findViewById(R.id.item_summary));
        this.mArrow = (ImageView) NullSafe.nonNull(findViewById(R.id.arrow));
        this.mRightSlotView = (LinearLayout) NullSafe.nonNull(findViewById(R.id.rightExpandView));
        this.mSubtitle.setMaxWidth(getResources().getDimensionPixelSize(R.dimen.sub_title_max_width));
        setArrowDrawableResource(R.drawable.selector_arrow_button);
    }

    public void setArrowVisible(boolean r1) {
        ImageView r0 = this.mArrow;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    public void setArrowOnClickListener(View.OnClickListener r1) {
        this.mArrow.setOnClickListener(r1);
    }

    public void setArrowDrawable(Drawable r1) {
        this.mArrow.setImageDrawable(r1);
    }

    public void setArrowDrawableResource(int r1) {
        this.mArrow.setImageResource(r1);
    }

    public View getArrowView() {
        return this.mArrow;
    }

    public void setSubtitle(CharSequence r3) {
        if (this.mIsCustomRightView == false) goto L5;
        return;
    L5:
        TextView r0 = this.mSubtitle;
        if (r0 != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r3) == false) goto L10;
        int r1 = 8;
    L11:
        r0.setVisibility(r1);
        this.mSubtitle.setText(r3);
        return;
    L10:
        r1 = 0;
        goto L11
    }

    public void setRightExpandView(View r2) {
        if (this.mIsCustomRightView == false) goto L5;
        return;
    L5:
        this.mRightSlotView.removeAllViews();
        if (r2 == null) goto L8;
        this.mRightSlotView.addView(r2);
        this.mRightSlotView.setVisibility(0);
        return;
    L8:
        if (this.mRightSlotView.getVisibility() == 8) goto L12;
        this.mRightSlotView.setVisibility(8);
        return;
    }

    @Override // obric.widget.ListContentItem
    public void setTitle(CharSequence r1) {
        super.setTitle(r1);
    }

    public CheckBox getCheckBox() {
        return this.mCheckbox;
    }

    public TextView getSubtitleView() {
        return this.mSubtitle;
    }

    @Override // obric.widget.ListContentItemCheck, android.widget.Checkable
    public void setChecked(boolean r1) {
        this.mCheckbox.setChecked(r1);
    }

    @Override // obric.widget.ListContentItemCheck, android.widget.Checkable
    public boolean isChecked() {
        return this.mCheckbox.isChecked();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.mCheckbox.setChecked(!isChecked());
    }

    @Override // obric.widget.ListContentItem, android.view.View
    public void setPressed(boolean r2) {
        super.setPressed(r2);
        if (this.mPressable == false) goto L6;
        this.mCheckbox.setPressed(r2);
        return;
    }

    @Override // android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        setCheckboxEnabled(r1);
        this.mArrow.setEnabled(r1);
    }

    public void setCheckboxEnabled(boolean r1) {
        this.mCheckbox.setEnabled(r1);
    }

    public boolean isCheckboxEnabled() {
        return this.mCheckbox.isEnabled();
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener r1) {
        this.mCheckbox.setOnCheckedChangeListener(r1);
    }

    private void adjustTitleTextSizeIfNeeded() {
        if (this.mTitle != null) goto L5;
        return;
    L5:
        Utils.resetTextViewFontSizeAttr(getContext(), this.mTitle, R.dimen.settings_item_title_size);
        if (0.0f <= calculateMaxTitleWidth()) goto L8;
        return;
    L8:
        if (this.mTitle.getMaxWidth() <= 0) goto L12;
        this.mTitle.getMaxWidth();
        return;
    }

    private int calculateMaxTitleWidth() {
        DisplayMetrics r0 = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(r0);
        int r1 = getResources().getDimensionPixelOffset(R.dimen.input_method_item_checkbox_left_margin);
        int r2 = getResources().getDimensionPixelOffset(R.dimen.settings_checkbox_size);
        int r3 = getResources().getDimensionPixelOffset(R.dimen.input_method_item_title_left_margin);
        int r5 = getResources().getDimensionPixelOffset(R.dimen.common_horizontal_padding);
        return (((r0.widthPixels - r1) - r2) - r3) - r5;
    }
}
