package com.qihoo360.mobilesafe.common.ui.dialog;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qihoo360.mobilesafe.common.ui.R;
import com.qihoo360.mobilesafe.common.ui.base.CommonDialogBase;
import com.qihoo360.mobilesafe.common.ui.base.NotSupportMethodException;
import com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog;
import com.qihoo360.mobilesafe.common.ui.utils.CommonUtils;

/* JADX INFO: loaded from: classes4.dex */
public class CommonDialogNoticeBase extends CommonDialogBase implements IDialog.IDialogNoticeTitle, IDialog.IDialogNoticeButton, IDialog.IDialogNoticeCenterView, IDialog.IDialogCenterText {
    protected int _13dp;
    protected int _16dp;
    protected int _20dp;
    protected int _24dp;
    protected View mBottomDivider;
    private LinearLayout mButtonView;
    private final View.OnClickListener mDefaultDismiss;
    protected TextView mRemindRow;
    protected View mRightTopCloseBtn;
    private LinearLayout mRootView;
    private RelativeLayout mTitleLayout;
    protected TextView mTitleText;
    protected TextView mUILeftBtn;
    protected TextView mUIRightBtn;
    protected TextView mUISingleBtn;

    /* JADX INFO: renamed from: com.qihoo360.mobilesafe.common.ui.dialog.CommonDialogNoticeBase$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$qihoo360$mobilesafe$common$ui$dialog$CommonDialogNoticeBase$ButtonStyle = null;
        static final /* synthetic */ int[] $SwitchMap$com$qihoo360$mobilesafe$common$ui$dialog$CommonDialogNoticeBase$TitleStyle = null;

        static {
            int[] r0 = new int[ButtonStyle.values().length];
            $SwitchMap$com$qihoo360$mobilesafe$common$ui$dialog$CommonDialogNoticeBase$ButtonStyle = r0;
            r0[ButtonStyle.BTN_STYLE_TYPE_LEFT_GRAY_RIGHT_BLUE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L31:
            $SwitchMap$com$qihoo360$mobilesafe$common$ui$dialog$CommonDialogNoticeBase$ButtonStyle[ButtonStyle.BTN_STYLE_TYPE_LEFT_BLUE_RIGHT_GRAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L37:
            $SwitchMap$com$qihoo360$mobilesafe$common$ui$dialog$CommonDialogNoticeBase$ButtonStyle[ButtonStyle.BTN_STYLE_TYPE_SINGLE_GRAY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L47:
            $SwitchMap$com$qihoo360$mobilesafe$common$ui$dialog$CommonDialogNoticeBase$ButtonStyle[ButtonStyle.BTN_STYLE_TYPE_SINGLE_BLUE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L33:
            $SwitchMap$com$qihoo360$mobilesafe$common$ui$dialog$CommonDialogNoticeBase$ButtonStyle[ButtonStyle.BTN_STYLE_TYPE_NONE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L23
        L12:
            int[] r5 = new int[TitleStyle.values().length];
            $SwitchMap$com$qihoo360$mobilesafe$common$ui$dialog$CommonDialogNoticeBase$TitleStyle = r5;
            r5[TitleStyle.TITLE_STYLE_TYPE_BLUE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L39:
            $SwitchMap$com$qihoo360$mobilesafe$common$ui$dialog$CommonDialogNoticeBase$TitleStyle[TitleStyle.TITLE_STYLE_TYPE_RED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L45:
            $SwitchMap$com$qihoo360$mobilesafe$common$ui$dialog$CommonDialogNoticeBase$TitleStyle[TitleStyle.TITLE_STYLE_TYPE_BLUE_CLOSABLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L29:
            $SwitchMap$com$qihoo360$mobilesafe$common$ui$dialog$CommonDialogNoticeBase$TitleStyle[TitleStyle.TITLE_STYLE_TYPE_RED_CLOSABLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
        L41:
            $SwitchMap$com$qihoo360$mobilesafe$common$ui$dialog$CommonDialogNoticeBase$TitleStyle[TitleStyle.TITLE_STYLE_TYPE_NONE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L28
            return;
        }
    }

    public static final enum ButtonStyle extends Enum<ButtonStyle> {
        private static final /* synthetic */ ButtonStyle[] $VALUES = null;
        public static final ButtonStyle BTN_STYLE_TYPE_LEFT_BLUE_RIGHT_GRAY = null;
        public static final ButtonStyle BTN_STYLE_TYPE_LEFT_GRAY_RIGHT_BLUE = null;
        public static final ButtonStyle BTN_STYLE_TYPE_NONE = null;
        public static final ButtonStyle BTN_STYLE_TYPE_SINGLE_BLUE = null;
        public static final ButtonStyle BTN_STYLE_TYPE_SINGLE_GRAY = null;

        private ButtonStyle(String r1, int r2) {
            super(r1, r2);
        }

        public static ButtonStyle valueOf(String r1) {
            return (ButtonStyle) Enum.valueOf(ButtonStyle.class, r1);
        }

        public static ButtonStyle[] values() {
            return (ButtonStyle[]) $VALUES.clone();
        }

        static {
            ButtonStyle r0 = new ButtonStyle("BTN_STYLE_TYPE_LEFT_GRAY_RIGHT_BLUE", 0);
            BTN_STYLE_TYPE_LEFT_GRAY_RIGHT_BLUE = r0;
            ButtonStyle r1 = new ButtonStyle("BTN_STYLE_TYPE_LEFT_BLUE_RIGHT_GRAY", 1);
            BTN_STYLE_TYPE_LEFT_BLUE_RIGHT_GRAY = r1;
            ButtonStyle r3 = new ButtonStyle("BTN_STYLE_TYPE_SINGLE_GRAY", 2);
            BTN_STYLE_TYPE_SINGLE_GRAY = r3;
            ButtonStyle r5 = new ButtonStyle("BTN_STYLE_TYPE_SINGLE_BLUE", 3);
            BTN_STYLE_TYPE_SINGLE_BLUE = r5;
            ButtonStyle r7 = new ButtonStyle("BTN_STYLE_TYPE_NONE", 4);
            BTN_STYLE_TYPE_NONE = r7;
            $VALUES = new ButtonStyle[]{r0, r1, r3, r5, r7};
        }
    }

    public static final enum TitleStyle extends Enum<TitleStyle> {
        private static final /* synthetic */ TitleStyle[] $VALUES = null;
        public static final TitleStyle TITLE_STYLE_TYPE_BLUE = null;
        public static final TitleStyle TITLE_STYLE_TYPE_BLUE_CLOSABLE = null;
        public static final TitleStyle TITLE_STYLE_TYPE_NONE = null;
        public static final TitleStyle TITLE_STYLE_TYPE_RED = null;
        public static final TitleStyle TITLE_STYLE_TYPE_RED_CLOSABLE = null;

        private TitleStyle(String r1, int r2) {
            super(r1, r2);
        }

        public static TitleStyle valueOf(String r1) {
            return (TitleStyle) Enum.valueOf(TitleStyle.class, r1);
        }

        public static TitleStyle[] values() {
            return (TitleStyle[]) $VALUES.clone();
        }

        static {
            TitleStyle r0 = new TitleStyle("TITLE_STYLE_TYPE_BLUE_CLOSABLE", 0);
            TITLE_STYLE_TYPE_BLUE_CLOSABLE = r0;
            TitleStyle r1 = new TitleStyle("TITLE_STYLE_TYPE_RED_CLOSABLE", 1);
            TITLE_STYLE_TYPE_RED_CLOSABLE = r1;
            TitleStyle r3 = new TitleStyle("TITLE_STYLE_TYPE_BLUE", 2);
            TITLE_STYLE_TYPE_BLUE = r3;
            TitleStyle r5 = new TitleStyle("TITLE_STYLE_TYPE_RED", 3);
            TITLE_STYLE_TYPE_RED = r5;
            TitleStyle r7 = new TitleStyle("TITLE_STYLE_TYPE_NONE", 4);
            TITLE_STYLE_TYPE_NONE = r7;
            $VALUES = new TitleStyle[]{r0, r1, r3, r5, r7};
        }
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeCenterView
    public boolean isUIDialogCenterSuggestCheckBoxSelected() throws NotSupportMethodException {
        return false;
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogGuideButton
    public void setUIDialogButtonLeftEnabled(boolean r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogGuideButton
    public void setUIDialogButtonRightEnabled(boolean r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogGuideButton
    public void setUIDialogButtonSingleEnabled(boolean r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogGuideButton
    public void setUIDialogCenterContentImageVisibility(boolean r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeCenterView
    public void setUIDialogCenterSecondLineSummaryTextClickListener(View.OnClickListener r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeCenterView
    public void setUIDialogCenterSuggestCheckBoxClickListener(View.OnClickListener r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeCenterView
    public void setUIDialogCenterSuggestCheckBoxSelected(boolean r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeCenterView
    public void setUIDialogCenterSuggestText(int r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeCenterView
    public void setUIDialogCenterSuggestText(CharSequence r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeCenterView
    public void setUIDialogCenterSuggestTextVisibility(int r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeCenterView
    public void setUIDialogCenterSummaryFirstLineText(int r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeCenterView
    public void setUIDialogCenterSummaryFirstLineText(CharSequence r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeCenterView
    public void setUIDialogCenterSummaryFirstLineTextVisibility(int r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeCenterView
    public void setUIDialogCenterSummarySecondLineText(int r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeCenterView
    public void setUIDialogCenterSummarySecondLineText(CharSequence r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeCenterView
    public void setUIDialogCenterSummarySecondLineTextVisibility(int r1) throws NotSupportMethodException {
    }

    public void setUIDialogCenterText(int r1) throws NotSupportMethodException {
    }

    public void setUIDialogCenterText(CharSequence r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogCenterText
    public void setUIDialogCenterTextVisibility(int r1) throws NotSupportMethodException {
    }

    public CommonDialogNoticeBase(Context r2) {
        super(r2, R.style.common_dialog);
        this.mDefaultDismiss = new AnonymousClass1(this);
        setCanceledOnTouchOutside(true);
        initView();
        setUIDialogTitleStyle(TitleStyle.TITLE_STYLE_TYPE_BLUE);
        setUIDialogButtonStyle(ButtonStyle.BTN_STYLE_TYPE_LEFT_GRAY_RIGHT_BLUE);
    }

    public CommonDialogNoticeBase(Context r2, TitleStyle r3, ButtonStyle r4) {
        super(r2, R.style.common_dialog);
        this.mDefaultDismiss = new AnonymousClass1(this);
        setCanceledOnTouchOutside(true);
        initView();
        setUIDialogTitleStyle(r3);
        setUIDialogButtonStyle(r4);
    }

    protected void initView() {
        setContentView(R.layout.inner_common_dialog_notice_base);
        this.mRootView = (LinearLayout) findViewById(R.id.common_dialog_root);
        this.mTitleLayout = (RelativeLayout) findViewById(R.id.common_dialog_title);
        this.mTitleText = (TextView) findViewById(R.id.common_dialog_title_text);
        View r0 = findViewById(R.id.common_dialog_title_right_top_close);
        this.mRightTopCloseBtn = r0;
        r0.setOnClickListener(this.mDefaultDismiss);
        this.mRemindRow = (TextView) findViewById(R.id.common_dialog_remind_row);
        this.mButtonView = (LinearLayout) findViewById(R.id.common_dialog_button);
        TextView r1 = (TextView) findViewById(R.id.common_dialog_button_left);
        this.mUILeftBtn = r1;
        r1.setOnClickListener(this.mDefaultDismiss);
        this.mBottomDivider = findViewById(R.id.common_dialog_button_center_divider);
        TextView r2 = (TextView) findViewById(R.id.common_dialog_button_right);
        this.mUIRightBtn = r2;
        r2.setOnClickListener(this.mDefaultDismiss);
        this.mUISingleBtn = this.mUIRightBtn;
        this._13dp = CommonUtils.dip2px(getContext(), 13.0f);
        this._16dp = CommonUtils.dip2px(getContext(), 16.0f);
        this._20dp = CommonUtils.dip2px(getContext(), 20.0f);
        this._24dp = CommonUtils.dip2px(getContext(), 24.0f);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeCenterView
    public void setUIDialogCenterView(View r2) {
        this.mRootView.addView(r2, 1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeCenterView
    public void setUIDialogCenterView(int r3) {
        View r4 = getLayoutInflater().inflate(r3, null);
        this.mRootView.addView(r4, 1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeTitle
    public void setUIDialogTitleStyle(TitleStyle r3) {
        int r4 = AnonymousClass2.$SwitchMap$com$qihoo360$mobilesafe$common$ui$dialog$CommonDialogNoticeBase$TitleStyle[r3.ordinal()];
        if (r4 != 1) goto L5;
        this.mTitleText.setTextColor(getContext().getResources().getColor(R.color.inner_common_dialog_base_title_text_color_blue));
        return;
    L5:
        if (r4 != 2) goto L7;
        this.mTitleText.setTextColor(getContext().getResources().getColor(R.color.inner_common_dialog_base_title_text_color_red));
        return;
    L7:
        if (r4 != 3) goto L9;
        this.mRightTopCloseBtn.setVisibility(0);
        this.mTitleText.setTextColor(getContext().getResources().getColor(R.color.inner_common_dialog_base_title_text_color_blue));
        return;
    L9:
        if (r4 != 4) goto L11;
        this.mRightTopCloseBtn.setVisibility(0);
        this.mTitleText.setTextColor(getContext().getResources().getColor(R.color.inner_common_dialog_base_title_text_color_red));
        return;
    L11:
        if (r4 != 5) goto L23;
        this.mTitleLayout.setVisibility(8);
        return;
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeButton
    public void setUIDialogButtonStyle(ButtonStyle r3) {
        int r4 = AnonymousClass2.$SwitchMap$com$qihoo360$mobilesafe$common$ui$dialog$CommonDialogNoticeBase$ButtonStyle[r3.ordinal()];
        if (r4 != 1) goto L5;
        this.mUILeftBtn.setTextColor(getContext().getResources().getColor(R.color.inner_common_dialog_base_button_text_color_gray));
        this.mUIRightBtn.setTextColor(getContext().getResources().getColor(R.color.inner_common_dialog_base_title_text_color_blue));
        return;
    L5:
        if (r4 != 2) goto L7;
        this.mUILeftBtn.setTextColor(getContext().getResources().getColor(R.color.inner_common_dialog_base_title_text_color_blue));
        this.mUIRightBtn.setTextColor(getContext().getResources().getColor(R.color.inner_common_dialog_base_button_text_color_gray));
        return;
    L7:
        if (r4 != 3) goto L9;
        this.mUILeftBtn.setVisibility(8);
        this.mBottomDivider.setVisibility(8);
        this.mUISingleBtn.setTextColor(getContext().getResources().getColor(R.color.inner_common_dialog_base_button_text_color_gray));
        return;
    L9:
        if (r4 != 4) goto L11;
        this.mUILeftBtn.setVisibility(8);
        this.mBottomDivider.setVisibility(8);
        this.mUISingleBtn.setTextColor(getContext().getResources().getColor(R.color.inner_common_dialog_base_title_text_color_blue));
        return;
    L11:
        if (r4 != 5) goto L23;
        this.mButtonView.setVisibility(8);
        return;
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogGuideTitle
    public void setUIDialogTitleText(int r2) {
        setUIDialogTitleText(getContext().getString(r2));
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogGuideTitle
    public void setUIDialogTitleText(CharSequence r1) {
        this.mTitleText.setText(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogGuideTitle
    public void setUIDialogTitleVisibility(boolean r1) {
        RelativeLayout r0 = this.mTitleLayout;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogGuideTitle
    public void setUIDialogCloseVisibility(boolean r1) {
        View r0 = this.mRightTopCloseBtn;
        if (r0 == null) goto L9;
        if (r1 == false) goto L6;
        int r2 = 0;
    L7:
        r0.setVisibility(r2);
        return;
    L6:
        r2 = 8;
        goto L7
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogGuideTitle
    public void setUITitleTextVisibility(boolean r1) {
        TextView r0 = this.mTitleText;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeTitle
    public void setUIDialogTitleRemindRowText(int r2) {
        setUIDialogTitleRemindRowText(getContext().getString(r2));
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeTitle
    public void setUIDialogTitleRemindRowText(CharSequence r1) {
        this.mRemindRow.setText(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeTitle
    public void setUIDialogTitleRightTopCloseVisible(int r1) {
        this.mRightTopCloseBtn.setVisibility(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeTitle
    public void setUIDialogTitleRemindRowVisible(int r1) {
        if (r1 == 0) goto L4;
        r1 = 4;
    L4:
        this.mRemindRow.setVisibility(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogGuideButton
    public void setUIDialogButtonLeftText(int r2) {
        setUIDialogButtonLeftText(getContext().getString(r2));
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogGuideButton
    public void setUIDialogButtonLeftText(CharSequence r1) {
        this.mUILeftBtn.setText(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogGuideButton
    public void setUIDialogButtonRightText(int r2) {
        setUIDialogButtonRightText(getContext().getString(r2));
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogGuideButton
    public void setUIDialogButtonRightText(CharSequence r1) {
        this.mUIRightBtn.setText(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogGuideButton
    public void setUIDialogButtonSingleText(int r2) {
        setUIDialogButtonSingleText(getContext().getString(r2));
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogGuideButton
    public void setUIDialogButtonSingleText(CharSequence r1) {
        this.mUISingleBtn.setText(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeButton
    public void hideUIDialogButtonLeft(boolean r5) {
        TextView r0 = this.mUILeftBtn;
        int r1 = 8;
        if (r5 == false) goto L5;
        int r3 = 8;
    L6:
        r0.setVisibility(r3);
        View r4 = this.mBottomDivider;
        if (r5 == true) goto L10;
        r1 = 0;
    L10:
        r4.setVisibility(r1);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeButton
    public void hideUIDialogButtonRight(boolean r5) {
        TextView r0 = this.mUIRightBtn;
        int r1 = 8;
        if (r5 == false) goto L5;
        int r3 = 8;
    L6:
        r0.setVisibility(r3);
        View r4 = this.mBottomDivider;
        if (r5 == true) goto L10;
        r1 = 0;
    L10:
        r4.setVisibility(r1);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeButton
    public void setUIDialogButtonLeftColor(int r2) {
        this.mUILeftBtn.setTextColor(getContext().getResources().getColor(r2));
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogNoticeButton
    public void setUIDialogButtonRightColor(int r2) {
        this.mUIRightBtn.setTextColor(getContext().getResources().getColor(r2));
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogGuideButton
    public void setUIDialogButtonLeftClickListener(View.OnClickListener r1) {
        this.mUILeftBtn.setOnClickListener(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogGuideButton
    public void setUIDialogButtonRightClickListener(View.OnClickListener r1) {
        this.mUIRightBtn.setOnClickListener(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogGuideButton
    public void setUIDialogButtonSingleClickListener(View.OnClickListener r1) {
        this.mUISingleBtn.setOnClickListener(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogGuideButton
    public void setUIDialogTopRightButtonClickListener(View.OnClickListener r1) throws NotSupportMethodException {
        View r0 = this.mRightTopCloseBtn;
        if (r0 == null) goto L7;
        if (r1 == null) goto L8;
        r0.setOnClickListener(r1);
        return;
    L8:
        return;
    }
}
