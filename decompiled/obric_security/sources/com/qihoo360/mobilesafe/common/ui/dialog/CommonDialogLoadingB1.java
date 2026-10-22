package com.qihoo360.mobilesafe.common.ui.dialog;

import android.content.Context;
import android.widget.TextView;
import com.qihoo360.mobilesafe.common.ui.R;
import com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog;
import com.qihoo360.mobilesafe.common.ui.loading.CommonHorizonLoading;

/* JADX INFO: loaded from: classes4.dex */
public class CommonDialogLoadingB1 extends CommonDialogNoticeBase implements IDialog.IDialogLoading {
    private TextView mCenterText;
    private CommonHorizonLoading mLoadingView;

    public CommonDialogLoadingB1(Context r1) {
        super(r1);
    }

    public CommonDialogLoadingB1(Context r1, CommonDialogNoticeBase.TitleStyle r2) {
        super(r1);
        setUIDialogTitleStyle(r2);
        setUIDialogButtonStyle(CommonDialogNoticeBase.ButtonStyle.BTN_STYLE_TYPE_NONE);
    }

    public CommonDialogLoadingB1(Context r1, CommonDialogNoticeBase.TitleStyle r2, CommonDialogNoticeBase.ButtonStyle r3) {
        super(r1);
        setUIDialogTitleStyle(r2);
        setUIDialogButtonStyle(r3);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.dialog.CommonDialogNoticeBase
    public void initView() {
        super.initView();
        setUIDialogCenterView(R.layout.inner_common_dialog_loading_b1);
        this.mCenterText = (TextView) findViewById(R.id.common_dialog_center_text);
        this.mLoadingView = (CommonHorizonLoading) findViewById(R.id.common_dialog_b1_loading_bar);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.dialog.CommonDialogNoticeBase, com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogCenterText
    public void setUIDialogCenterText(int r2) {
        setUIDialogCenterText(getContext().getString(r2));
    }

    @Override // com.qihoo360.mobilesafe.common.ui.dialog.CommonDialogNoticeBase, com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogCenterText
    public void setUIDialogCenterText(CharSequence r1) {
        this.mCenterText.setText(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogLoading
    public void setUIDialogLoading(boolean r1) {
        CommonHorizonLoading r0 = this.mLoadingView;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean r1) {
        super.onWindowFocusChanged(r1);
        setUIDialogLoading(r1);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        CommonHorizonLoading r0 = this.mLoadingView;
        if (r0 == null) goto L5;
        r0.clearAnimation();
    L5:
        super.onDetachedFromWindow();
    }
}
