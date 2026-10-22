package com.qihoo360.mobilesafe.ui.common.other;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qihoo360.mobilesafe.common.ui.R;
import com.qihoo360.mobilesafe.common.ui.utils.CommonUtils;

/* JADX INFO: loaded from: classes4.dex */
public class CommonPopupWindow extends PopupWindow {
    protected View mAnchorView;
    protected boolean mCheckVisible;
    protected Context mContext;
    protected LayoutInflater mInflater;
    protected String[] mItems;
    protected AdapterView.OnItemClickListener mOnItemClick;
    protected int mSelectedIdx;
    protected TextUtils.TruncateAt mTextEllipsize;
    protected int mWindowWidth;

    /* JADX INFO: renamed from: com.qihoo360.mobilesafe.ui.common.other.CommonPopupWindow$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$android$text$TextUtils$TruncateAt = null;

        static {
            int[] r0 = new int[TextUtils.TruncateAt.values().length];
            $SwitchMap$android$text$TextUtils$TruncateAt = r0;
            r0[TextUtils.TruncateAt.MIDDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$android$text$TextUtils$TruncateAt[TextUtils.TruncateAt.END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$android$text$TextUtils$TruncateAt[TextUtils.TruncateAt.START.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public CommonPopupWindow(Context r3) {
        super(r3);
        this.mSelectedIdx = -1;
        this.mCheckVisible = true;
        this.mWindowWidth = -1;
        this.mTextEllipsize = TextUtils.TruncateAt.START;
        init(r3, null);
    }

    public CommonPopupWindow(Context r3, String[] r4) {
        super(r3);
        this.mSelectedIdx = -1;
        this.mCheckVisible = true;
        this.mWindowWidth = -1;
        this.mTextEllipsize = TextUtils.TruncateAt.START;
        init(r3, r4);
    }

    private void init(Context r3, String[] r4) {
        setFocusable(true);
        setOutsideTouchable(true);
        setClippingEnabled(false);
        if (r3 == null) goto L5;
        setBackgroundDrawable(r3.getResources().getDrawable(R.drawable.common_popup_bg));
    L5:
        this.mContext = r3;
        this.mItems = r4;
        this.mInflater = (LayoutInflater) r3.getSystemService("layout_inflater");
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener r1) {
        this.mOnItemClick = r1;
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View r1) {
        this.mAnchorView = r1;
        refreshView();
        super.showAsDropDown(r1);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View r1, int r2, int r3) {
        this.mAnchorView = r1;
        refreshView();
        super.showAsDropDown(r1, r2, r3);
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View r2, int r3, int r4, int r5) {
        this.mAnchorView = null;
        refreshView();
        super.showAtLocation(r2, r3, r4, r5);
    }

    public void setItems(String[] r1) {
        this.mItems = r1;
        if (isShowing() == false) goto L6;
        refreshView();
        return;
    }

    public void setSelectedIdx(int r2) {
        if (r2 >= this.mItems.length) goto L9;
        if (r2 < 0) goto L10;
        this.mSelectedIdx = r2;
        if (isShowing() == false) goto L11;
        refreshView();
        return;
    L11:
        return;
    L10:
        return;
    }

    public String getTextAt(int r2) {
        String[] r1 = this.mItems;
        if (r2 >= r1.length) goto L7;
        if (r2 >= 0) goto L6;
        return null;
    L6:
        return r1[r2];
    L7:
        return null;
    }

    public int getSelectedIdx() {
        return this.mSelectedIdx;
    }

    public void setCheckVisible(boolean r1) {
        this.mCheckVisible = r1;
    }

    public void setWindowWidth(int r1) {
        this.mWindowWidth = r1;
    }

    public void setTextEllipsize(TextUtils.TruncateAt r1) {
        this.mTextEllipsize = r1;
    }

    protected void refreshView() {
        String[] r0 = this.mItems;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length != 0) goto L7;
        return;
    L7:
        if (this.mContext != null) goto L9;
        return;
    L9:
        if (this.mAnchorView == null) goto L46;
        View r1 = getContentView();
        if (r1 != null) goto L14;
        LinearLayout r2 = new LinearLayout(this.mContext);
        r2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r2.setOrientation(1);
        setContentView(r2);
    L15:
        r2.removeAllViews();
        int r3 = CommonUtils.dip2px(this.mContext, 10.0f);
        int r4 = CommonUtils.dip2px(this.mContext, 40.0f);
        int r5 = (int) this.mContext.getResources().getDimension(R.dimen.common_divider_width);
        int r6 = r3 + 0;
        int r8 = this.mWindowWidth;
        if (r8 != (-1)) goto L18;
        r8 = this.mAnchorView.getWidth();
    L18:
        ViewGroup.LayoutParams r7 = new ViewGroup.LayoutParams(r8, r4);
        final int r9 = 0;
    L20:
        if (r9 >= this.mItems.length) goto L38;
        View r10 = this.mInflater.inflate(R.layout.inner_common_popup_window_1, null);
        TextView r11 = (TextView) r10.findViewById(R.id.common_row_title);
        RelativeLayout.LayoutParams r12 = (RelativeLayout.LayoutParams) r11.getLayoutParams();
        int r13 = AnonymousClass2.$SwitchMap$android$text$TextUtils$TruncateAt[this.mTextEllipsize.ordinal()];
        if (r13 != 1) goto L24;
        r12.addRule(14);
    L28:
        r11.setLayoutParams(r12);
        r11.setText(this.mItems[r9]);
        r11.setContentDescription(this.mItems[r9]);
        ImageView r14 = (ImageView) r10.findViewById(R.id.common_row_img);
        if (this.mCheckVisible == true) goto L31;
    L33:
        int r15 = 8;
    L34:
        r14.setVisibility(r15);
        r10.setOnClickListener(new AnonymousClass1(this, r9));
        r2.addView(r10, r7);
        if (r9 == (this.mItems.length - 1)) goto L37;
        View r16 = new View(this.mContext);
        r16.setBackgroundColor(this.mContext.getResources().getColor(R.color.common_bg_color_7));
        r16.setLayoutParams(new ViewGroup.LayoutParams(-1, 1));
        r2.addView(r16);
        r6 = r6 + r5;
    L37:
        r6 = r6 + r4;
        r9 = r9 + 1;
        goto L20
    L31:
        if (this.mSelectedIdx != r9) goto L33;
        r15 = 0;
        goto L34
    L24:
        if (r13 == 2) goto L26;
        r12.addRule(9);
        goto L28
    L26:
        r12.addRule(11);
        goto L28
    L38:
        setWidth(-2);
        setHeight(r6);
        return;
    L14:
        r2 = (LinearLayout) r1;
        goto L15
    }
}
