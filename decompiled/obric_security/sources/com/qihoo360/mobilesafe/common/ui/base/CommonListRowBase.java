package com.qihoo360.mobilesafe.common.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qihoo360.mobilesafe.common.ui.R;
import com.qihoo360.mobilesafe.common.ui.badge.CommonBadgeView;
import com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowBadge;
import com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowClicker;
import com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowDivider;
import com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowMarker;
import com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowProgress;
import com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowRes;
import com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowSelected;
import com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowTag;
import com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowText;
import com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowVisible;
import com.qihoo360.mobilesafe.common.ui.env.ViewTAG;
import com.qihoo360.mobilesafe.common.ui.other.CommonProgressBar;
import com.qihoo360.mobilesafe.common.ui.ripple.CommonRippleLinearLayout;
import com.qihoo360.mobilesafe.common.ui.textview.CommonRoundTextView;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CommonListRowBase extends LinearLayout implements IListRowClicker, IListRowBadge, IListRowDivider, IListRowRes, IListRowSelected, IListRowText, IListRowVisible, IListRowTag, IListRowProgress, IListRowMarker {
    private Paint debugPaint;
    private CommonListRowDivider mBottomDivider;
    private CommonRippleLinearLayout mRippleRow;
    protected ImageView mUIArrowView;
    protected TextView mUIFirstLineTextView;
    protected ImageView mUIFlagImageView;
    protected ImageView mUIIconImageView;
    protected ImageView mUILoadingView;
    protected CommonRoundTextView mUIMarkTextView;
    protected CommonProgressBar mUIProgressView;
    protected CommonBadgeView mUIRightBadge;
    protected Button mUIRightBtn;
    protected TextView mUIRightTextView;
    protected TextView mUISecondLineTextView;
    protected ImageView mUISelectedView;
    protected TextView mUIThirdLineTextView;

    protected abstract int getLayoutResId();

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowRes
    public ImageView getUILeftIcon() throws NotSupportMethodException {
        return null;
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowSelected
    public boolean isUIArrowExpand() throws NotSupportMethodException {
        return false;
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowBadge
    public boolean isUIBadgeShown() throws NotSupportMethodException {
        return false;
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowSelected
    public boolean isUIRightChecked() throws NotSupportMethodException {
        return false;
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowSelected
    public void setUIArrowExpand(boolean r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowSelected
    public void setUIArrowVisible(boolean r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowBadge
    public void setUIBadgeColor(int r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowBadge
    public void setUIBadgeContent(String r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowBadge
    public void setUIBadgeShown(boolean r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowText
    public void setUIFirstLineText(int r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowText
    public void setUIFirstLineText(CharSequence r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowText
    public void setUIFirstLineTextColor(int r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowClicker
    public void setUILeftIconClickListener(View.OnClickListener r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowVisible
    public void setUILeftIconVisible(boolean r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowRes
    public void setUILeftImageDrawable(Drawable r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowRes
    public void setUILeftImageResource(int r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowVisible
    public void setUILoading(boolean r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowMarker
    public void setUIMarkColor(int r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowMarker
    public void setUIMarkDrawable(int r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowMarker
    public void setUIMarkDrawable(Drawable r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowMarker
    public void setUIMarkText(int r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowMarker
    public void setUIMarkText(CharSequence r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowMarker
    public void setUIMarkTextVisible(boolean r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowProgress
    public void setUIProgress(int r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowProgress
    public void setUIProgressColor(int r1, int r2, int r3, int r4) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowProgress
    public void setUIProgressVisible(boolean r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowClicker
    public void setUIRightButtonClickListener(View.OnClickListener r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowText
    public void setUIRightButtonText(int r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowText
    public void setUIRightButtonText(CharSequence r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowSelected
    public void setUIRightChecked(boolean r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowRes
    public void setUIRightCheckedRes(int r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowRes
    public void setUIRightCheckedSwitchStyle(CommonSwitch.Style r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowSelected
    public void setUIRightSelectEnable(boolean r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowTag
    public void setUIRightSelectTag(int r1, Object r2) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowVisible
    public void setUIRightSelectVisible(boolean r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowClicker
    public void setUIRightSelectedListener(View.OnClickListener r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowText
    public void setUIRightText(int r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowText
    public void setUIRightText(CharSequence r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowText
    public void setUIRightTextColor(int r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowSelected
    public void setUIRowEnable(boolean r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowText
    public void setUISecondLineText(int r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowText
    public void setUISecondLineText(CharSequence r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowText
    public void setUISecondLineTextColor(int r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowVisible
    public void setUISecondLineVisible(boolean r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowText
    public void setUIThirdLineText(CharSequence r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowProgress
    public void startUIProgress() throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowProgress
    public void stopUIProgress() throws NotSupportMethodException {
    }

    public CommonListRowBase(Context r2) {
        super(r2);
        init(r2, null);
    }

    public CommonListRowBase(Context r1, AttributeSet r2) {
        super(r1, r2);
        init(r1, r2);
    }

    public CommonListRowBase(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        init(r1, r2);
    }

    private void init(Context r4, AttributeSet r5) {
        setOrientation(1);
        int r0 = getLayoutResId();
        if (r0 != 0) goto L5;
        return;
    L5:
        View r1 = inflate(r4, r0, this);
        ViewTAG.ROW_TAG r2 = ViewTAG.getRowTag(r4);
        this.mRippleRow = (CommonRippleLinearLayout) r1.findViewWithTag(r2.ROW_TAG_ROOT);
        this.mUIIconImageView = (ImageView) findViewWithTag(r2.ROW_TAG_LEFT_ICON_IMAGE);
        this.mUIFlagImageView = (ImageView) findViewWithTag(r2.ROW_TAG_LEFT_FLAG_IMAGE);
        this.mUIMarkTextView = (CommonRoundTextView) findViewWithTag(r2.ROW_TAG_MARK_TEXT);
        this.mUIFirstLineTextView = (TextView) findViewWithTag(r2.ROW_TAG_FIRST_LINE_TEXT);
        this.mUISecondLineTextView = (TextView) findViewWithTag(r2.ROW_TAG_SECOND_LINE_TEXT);
        this.mUIThirdLineTextView = (TextView) findViewWithTag(r2.ROW_TAG_THIRD_LINE_TEXT);
        this.mUIProgressView = (CommonProgressBar) findViewWithTag(r2.ROW_TAG_PROGRESS_VIEW);
        this.mUIRightTextView = (TextView) findViewWithTag(r2.ROW_TAG_RIGHT_TEXT);
        this.mUIRightBadge = (CommonBadgeView) findViewWithTag(r2.ROW_TAG_RIGHT_BADGE);
        this.mUIRightBtn = (Button) findViewWithTag(r2.ROW_TAG_RIGHT_BTN);
        this.mUISelectedView = (ImageView) findViewWithTag(r2.ROW_TAG_SELECT_VIEW);
        this.mUILoadingView = (ImageView) findViewWithTag(r2.ROW_TAG_LOADING_VIEW);
        this.mUIArrowView = (ImageView) findViewWithTag(r2.ROW_TAG_ARROW_VIEW);
        CommonListRowDivider r3 = new CommonListRowDivider(getContext());
        this.mBottomDivider = r3;
        r3.setPaddingDrawable(this.mRippleRow.getPaddingLeft(), this.mRippleRow.getBackground());
        addView(this.mBottomDivider, -1, -2);
        TypedArray r6 = r4.obtainStyledAttributes(r5, R.styleable.inner_common_pref);
        if (this.mUIIconImageView == null) goto L9;
        Drawable r7 = r6.getDrawable(R.styleable.inner_common_pref_ui_icon);
        this.mUIIconImageView.setImageDrawable(r7);
    L9:
        if (this.mUIFirstLineTextView == null) goto L12;
        String r8 = r6.getString(R.styleable.inner_common_pref_ui_first_text);
        this.mUIFirstLineTextView.setText(r8);
    L12:
        if (this.mUISecondLineTextView == null) goto L15;
        String r9 = r6.getString(R.styleable.inner_common_pref_ui_second_text);
        this.mUISecondLineTextView.setText(r9);
    L15:
        if (this.mUIThirdLineTextView == null) goto L18;
        String r10 = r6.getString(R.styleable.inner_common_pref_ui_third_text);
        this.mUIThirdLineTextView.setText(r10);
    L18:
        if (this.mUIRightTextView == null) goto L21;
        String r11 = r6.getString(R.styleable.inner_common_pref_ui_right_text);
        this.mUIRightTextView.setText(r11);
    L21:
        if (this.mUIRightBtn == null) goto L24;
        String r12 = r6.getString(R.styleable.inner_common_pref_ui_right_btn_text);
        this.mUIRightBtn.setText(r12);
    L24:
        if (this.mUISelectedView == null) goto L28;
        boolean r13 = r6.getBoolean(R.styleable.inner_common_pref_ui_enable_checkbox, false);
        this.mUISelectedView.setSelected(r13);
        TextView r14 = this.mUIRightTextView;
        if (r14 == null) goto L28;
        r14.setSelected(r13);
    L28:
        r6.recycle();
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowDivider
    public final void setUIDividerType(CommonListRowDivider.DIVIDER_TYPE r1) {
        this.mBottomDivider.setDividerType(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowDivider
    public final void setUIDividerVisible(boolean r1) {
        CommonListRowDivider r0 = this.mBottomDivider;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    @Override // android.view.View
    @Deprecated
    public void setOnClickListener(View.OnClickListener r1) {
        setUIRowClickListener(r1);
    }

    @Override // android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        this.mRippleRow.setEnabled(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowClicker
    public final void setUIRowClickListener(final View.OnClickListener r2) {
        View.OnClickListener r0 = new AnonymousClass1(this, r2);
        this.mRippleRow.setOnClickListener(r0);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowVisible
    public final void setUIDisableRipple() {
        this.mRippleRow.disableRipple();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r2, int r3) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r2), 1073741824), r3);
    }

    public void setInnerBackgroundResource(int r1) {
        this.mRippleRow.setBackgroundResource(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r1) {
        super.dispatchDraw(r1);
    }
}
