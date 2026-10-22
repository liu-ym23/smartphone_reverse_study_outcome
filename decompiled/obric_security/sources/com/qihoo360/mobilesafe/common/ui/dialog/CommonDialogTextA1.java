package com.qihoo360.mobilesafe.common.ui.dialog;

import android.content.Context;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qihoo360.mobilesafe.common.ui.R;

/* JADX INFO: loaded from: classes4.dex */
public class CommonDialogTextA1 extends CommonDialogNoticeBase {
    private TextView mCenterText;

    public CommonDialogTextA1(Context r1) {
        super(r1);
    }

    public CommonDialogTextA1(Context r1, CommonDialogNoticeBase.TitleStyle r2) {
        super(r1);
        setUIDialogTitleStyle(r2);
        setUIDialogButtonStyle(CommonDialogNoticeBase.ButtonStyle.BTN_STYLE_TYPE_NONE);
    }

    public CommonDialogTextA1(Context r1, CommonDialogNoticeBase.TitleStyle r2, CommonDialogNoticeBase.ButtonStyle r3) {
        super(r1);
        setUIDialogTitleStyle(r2);
        setUIDialogButtonStyle(r3);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.dialog.CommonDialogNoticeBase
    public void initView() {
        super.initView();
        TextView r0 = new TextView(getContext());
        this.mCenterText = r0;
        r0.setTextColor(getContext().getResources().getColor(R.color.inner_common_dialog_base_content_text_color_summary_gray));
        this.mCenterText.setTextSize(0, getContext().getResources().getDimensionPixelSize(R.dimen.inner_common_dialog_base_content_summary_size));
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-1, -2);
        r1.topMargin = this._16dp;
        r1.leftMargin = this._24dp;
        r1.rightMargin = this._24dp;
        r1.bottomMargin = this._13dp;
        this.mCenterText.setLayoutParams(r1);
        setUIDialogCenterView(this.mCenterText);
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
}
