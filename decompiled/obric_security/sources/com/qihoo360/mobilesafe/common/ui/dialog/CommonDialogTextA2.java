package com.qihoo360.mobilesafe.common.ui.dialog;

import android.content.Context;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qihoo360.mobilesafe.common.ui.R;
import com.qihoo360.mobilesafe.common.ui.textview.CommonCheckBoxTextView;

/* JADX INFO: loaded from: classes4.dex */
public class CommonDialogTextA2 extends CommonDialogNoticeBase {
    private TextView mCenterText;
    private CommonCheckBoxTextView mCheckBox;
    private TextView mFirstLineSummary;
    private TextView mSecondLineSummary;
    private LinearLayout mSummary;

    public CommonDialogTextA2(Context r1) {
        super(r1);
    }

    public CommonDialogTextA2(Context r1, CommonDialogNoticeBase.TitleStyle r2) {
        super(r1);
        setUIDialogTitleStyle(r2);
        setUIDialogButtonStyle(CommonDialogNoticeBase.ButtonStyle.BTN_STYLE_TYPE_NONE);
    }

    public CommonDialogTextA2(Context r1, CommonDialogNoticeBase.TitleStyle r2, CommonDialogNoticeBase.ButtonStyle r3) {
        super(r1);
        setUIDialogTitleStyle(r2);
        setUIDialogButtonStyle(r3);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.dialog.CommonDialogNoticeBase
    public void initView() {
        super.initView();
        setUIDialogCenterView(R.layout.inner_common_dialog_text_a2);
        this.mCenterText = (TextView) findViewById(R.id.common_dialog_center_text);
        this.mSummary = (LinearLayout) findViewById(R.id.common_dialog_style_2_summary);
        this.mFirstLineSummary = (TextView) findViewById(R.id.common_dialog_style_2_first_line);
        this.mSecondLineSummary = (TextView) findViewById(R.id.common_dialog_style_2_second_line);
        this.mCheckBox = (CommonCheckBoxTextView) findViewById(R.id.common_dialog_style_2_check_box);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.dialog.CommonDialogNoticeBase, com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogCenterText
    public void setUIDialogCenterText(int r2) {
        setUIDialogCenterText(getContext().getString(r2));
    }

    @Override // com.qihoo360.mobilesafe.common.ui.dialog.CommonDialogNoticeBase, com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogCenterText
    public void setUIDialogCenterText(CharSequence r2) {
        this.mCenterText.setText(r2);
        this.mCenterText.setContentDescription(r2);
        if ((r2 instanceof Spanned) == false) goto L5;
        this.mCenterText.setClickable(true);
        this.mCenterText.setMovementMethod(LinkMovementMethod.getInstance());
        return;
    L5:
        this.mCenterText.setClickable(false);
        this.mCenterText.setMovementMethod(null);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.dialog.CommonDialogNoticeBase, com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogCenterText
    public void setUIDialogCenterTextVisibility(int r1) {
        this.mCenterText.setVisibility(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.dialog.CommonDialogNoticeBase, com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeCenterView
    public void setUIDialogCenterSummaryFirstLineText(int r2) {
        setUIDialogCenterSummaryFirstLineText(getContext().getString(r2));
    }

    @Override // com.qihoo360.mobilesafe.common.ui.dialog.CommonDialogNoticeBase, com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeCenterView
    public void setUIDialogCenterSummaryFirstLineText(CharSequence r3) {
        this.mSummary.setVisibility(0);
        this.mFirstLineSummary.setVisibility(0);
        this.mFirstLineSummary.setText(r3);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.dialog.CommonDialogNoticeBase, com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeCenterView
    public void setUIDialogCenterSummarySecondLineText(int r2) {
        setUIDialogCenterSummarySecondLineText(getContext().getString(r2));
    }

    @Override // com.qihoo360.mobilesafe.common.ui.dialog.CommonDialogNoticeBase, com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeCenterView
    public void setUIDialogCenterSummarySecondLineText(CharSequence r3) {
        this.mSummary.setVisibility(0);
        this.mSecondLineSummary.setVisibility(0);
        this.mSecondLineSummary.setText(r3);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.dialog.CommonDialogNoticeBase, com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeCenterView
    public void setUIDialogCenterSecondLineSummaryTextClickListener(View.OnClickListener r1) {
        this.mSecondLineSummary.setOnClickListener(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.dialog.CommonDialogNoticeBase, com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeCenterView
    public void setUIDialogCenterSuggestText(int r2) {
        setUIDialogCenterSuggestText(getContext().getString(r2));
    }

    @Override // com.qihoo360.mobilesafe.common.ui.dialog.CommonDialogNoticeBase, com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeCenterView
    public void setUIDialogCenterSuggestText(CharSequence r1) {
        this.mCheckBox.setUICheckBoxCheckedText(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.dialog.CommonDialogNoticeBase, com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeCenterView
    public void setUIDialogCenterSuggestTextVisibility(int r1) {
        this.mCheckBox.setVisibility(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.dialog.CommonDialogNoticeBase, com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeCenterView
    public void setUIDialogCenterSuggestCheckBoxClickListener(View.OnClickListener r1) {
        this.mCheckBox.setOnClickListener(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.dialog.CommonDialogNoticeBase, com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeCenterView
    public void setUIDialogCenterSuggestCheckBoxSelected(boolean r1) {
        this.mCheckBox.setUICheckBoxChecked(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.dialog.CommonDialogNoticeBase, com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeCenterView
    public boolean isUIDialogCenterSuggestCheckBoxSelected() {
        return this.mCheckBox.isUICheckBoxChecked();
    }
}
