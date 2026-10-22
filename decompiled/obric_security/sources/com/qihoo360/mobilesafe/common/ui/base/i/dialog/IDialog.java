package com.qihoo360.mobilesafe.common.ui.base.i.dialog;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.qihoo360.mobilesafe.common.ui.base.NotSupportMethodException;
import com.qihoo360.mobilesafe.common.ui.dialog.CommonDialogNoticeBase;

/* JADX INFO: loaded from: classes4.dex */
public interface IDialog {

    public interface IDialogCenterText {
        void setUIDialogCenterText(int r1) throws NotSupportMethodException;

        void setUIDialogCenterText(CharSequence r1) throws NotSupportMethodException;

        void setUIDialogCenterTextVisibility(int r1) throws NotSupportMethodException;
    }

    public interface IDialogGuideButton {
        void setUIDialogButtonLeftClickListener(View.OnClickListener r1) throws NotSupportMethodException;

        void setUIDialogButtonLeftEnabled(boolean r1) throws NotSupportMethodException;

        void setUIDialogButtonLeftText(int r1) throws NotSupportMethodException;

        void setUIDialogButtonLeftText(CharSequence r1) throws NotSupportMethodException;

        void setUIDialogButtonRightClickListener(View.OnClickListener r1) throws NotSupportMethodException;

        void setUIDialogButtonRightEnabled(boolean r1) throws NotSupportMethodException;

        void setUIDialogButtonRightText(int r1) throws NotSupportMethodException;

        void setUIDialogButtonRightText(CharSequence r1) throws NotSupportMethodException;

        void setUIDialogButtonSingleClickListener(View.OnClickListener r1) throws NotSupportMethodException;

        void setUIDialogButtonSingleEnabled(boolean r1) throws NotSupportMethodException;

        void setUIDialogButtonSingleText(int r1) throws NotSupportMethodException;

        void setUIDialogButtonSingleText(CharSequence r1) throws NotSupportMethodException;

        void setUIDialogCenterContentImageVisibility(boolean r1) throws NotSupportMethodException;

        void setUIDialogTopRightButtonClickListener(View.OnClickListener r1) throws NotSupportMethodException;
    }

    public interface IDialogGuideCenter extends IDialogCenterText {
        boolean isUIDialogCenterSuggestCheckBoxSelected() throws NotSupportMethodException;

        void setUIDialogCenterContentImage(int r1) throws NotSupportMethodException;

        void setUIDialogCenterContentImage(Drawable r1) throws NotSupportMethodException;

        void setUIDialogCenterSuggestCheckBoxSelected(boolean r1) throws NotSupportMethodException;

        void setUIDialogCenterSuggestClickListener(View.OnClickListener r1) throws NotSupportMethodException;

        void setUIDialogCenterSuggestText(int r1) throws NotSupportMethodException;

        void setUIDialogCenterSuggestText(CharSequence r1) throws NotSupportMethodException;

        void setUIDialogCenterSuggestTextColor(int r1) throws NotSupportMethodException;

        void setUIDialogCenterSuggestTextVisibility(int r1) throws NotSupportMethodException;

        void setUIDialogCenterWarningText(int r1) throws NotSupportMethodException;

        void setUIDialogCenterWarningText(CharSequence r1) throws NotSupportMethodException;

        void setUIDialogCenterWarningTextColor(int r1) throws NotSupportMethodException;
    }

    public interface IDialogGuideTitle {
        void setUIDialogCloseVisibility(boolean r1) throws NotSupportMethodException;

        void setUIDialogTitleText(int r1) throws NotSupportMethodException;

        void setUIDialogTitleText(CharSequence r1) throws NotSupportMethodException;

        void setUIDialogTitleVisibility(boolean r1) throws NotSupportMethodException;

        void setUITitleTextVisibility(boolean r1) throws NotSupportMethodException;
    }

    public interface IDialogList {
        void setUIDialogListItems(String[] r1) throws NotSupportMethodException;

        void setUIDialogListItemsWithImage(String[] r1, int[] r2) throws NotSupportMethodException;

        void setUIDialogListOnItemClickListener(AdapterView.OnItemClickListener r1) throws NotSupportMethodException;

        void setUIDialogListRightCheckVisible(boolean r1) throws NotSupportMethodException;

        void setUIDialogListSelectItem(int r1) throws NotSupportMethodException;

        void setUIDialogListTextEllipsize(TextUtils.TruncateAt r1) throws NotSupportMethodException;
    }

    public interface IDialogLoading {
        void setUIDialogLoading(boolean r1) throws NotSupportMethodException;
    }

    public interface IDialogNoticeButton extends IDialogGuideButton {
        void hideUIDialogButtonLeft(boolean r1) throws NotSupportMethodException;

        void hideUIDialogButtonRight(boolean r1) throws NotSupportMethodException;

        void setUIDialogButtonLeftColor(int r1) throws NotSupportMethodException;

        void setUIDialogButtonRightColor(int r1) throws NotSupportMethodException;

        void setUIDialogButtonStyle(CommonDialogNoticeBase.ButtonStyle r1) throws NotSupportMethodException;
    }

    public interface IDialogNoticeCenterView {
        boolean isUIDialogCenterSuggestCheckBoxSelected() throws NotSupportMethodException;

        void setUIDialogCenterSecondLineSummaryTextClickListener(View.OnClickListener r1) throws NotSupportMethodException;

        void setUIDialogCenterSuggestCheckBoxClickListener(View.OnClickListener r1) throws NotSupportMethodException;

        void setUIDialogCenterSuggestCheckBoxSelected(boolean r1) throws NotSupportMethodException;

        void setUIDialogCenterSuggestText(int r1) throws NotSupportMethodException;

        void setUIDialogCenterSuggestText(CharSequence r1) throws NotSupportMethodException;

        void setUIDialogCenterSuggestTextVisibility(int r1) throws NotSupportMethodException;

        void setUIDialogCenterSummaryFirstLineText(int r1) throws NotSupportMethodException;

        void setUIDialogCenterSummaryFirstLineText(CharSequence r1) throws NotSupportMethodException;

        void setUIDialogCenterSummaryFirstLineTextVisibility(int r1) throws NotSupportMethodException;

        void setUIDialogCenterSummarySecondLineText(int r1) throws NotSupportMethodException;

        void setUIDialogCenterSummarySecondLineText(CharSequence r1) throws NotSupportMethodException;

        void setUIDialogCenterSummarySecondLineTextVisibility(int r1) throws NotSupportMethodException;

        void setUIDialogCenterView(int r1) throws NotSupportMethodException;

        void setUIDialogCenterView(View r1) throws NotSupportMethodException;
    }

    public interface IDialogNoticeTitle extends IDialogGuideTitle {
        void setUIDialogTitleRemindRowText(int r1) throws NotSupportMethodException;

        void setUIDialogTitleRemindRowText(CharSequence r1) throws NotSupportMethodException;

        void setUIDialogTitleRemindRowVisible(int r1) throws NotSupportMethodException;

        void setUIDialogTitleRightTopCloseVisible(int r1) throws NotSupportMethodException;

        void setUIDialogTitleStyle(CommonDialogNoticeBase.TitleStyle r1) throws NotSupportMethodException;
    }

    public interface IDialogProgress {
        void setUIDialogProgress(int r1) throws NotSupportMethodException;

        void setUIDialogProgressVisibility(boolean r1) throws NotSupportMethodException;
    }
}
