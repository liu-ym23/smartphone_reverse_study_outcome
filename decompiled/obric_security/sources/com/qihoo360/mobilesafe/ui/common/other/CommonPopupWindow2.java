package com.qihoo360.mobilesafe.ui.common.other;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qihoo360.mobilesafe.common.ui.R;
import com.qihoo360.mobilesafe.common.ui.utils.CommonUtils;

/* JADX INFO: loaded from: classes4.dex */
public class CommonPopupWindow2 extends CommonPopupWindow {
    protected int checkBgId;
    protected int checkMargin;
    protected boolean[] checkVisiblePos;
    protected int mDefaultTextColor;
    protected int mItemHeight;
    protected boolean mLeftCheck;
    protected int mLeftMarginOfText;
    protected int mMarginOfDivider;
    protected boolean mNoBkg;
    protected boolean mPaddingSet;
    protected int mSelTextColor;
    protected float mTextFontDimen;
    protected float mTextSize;
    protected boolean mUseSelTextColor;

    /* JADX INFO: renamed from: com.qihoo360.mobilesafe.ui.common.other.CommonPopupWindow2$2, reason: invalid class name */
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

    public CommonPopupWindow2(Context r3) {
        super(r3);
        this.checkMargin = -1;
        this.checkBgId = -1;
        this.mPaddingSet = true;
        this.mLeftCheck = false;
        this.mUseSelTextColor = false;
        this.mSelTextColor = 0;
        this.mDefaultTextColor = -1;
        this.mTextSize = 0.0f;
        this.mLeftMarginOfText = 0;
        this.mMarginOfDivider = 0;
        this.mNoBkg = false;
        init(r3, null);
    }

    public CommonPopupWindow2(Context r3, String[] r4) {
        super(r3);
        this.checkMargin = -1;
        this.checkBgId = -1;
        this.mPaddingSet = true;
        this.mLeftCheck = false;
        this.mUseSelTextColor = false;
        this.mSelTextColor = 0;
        this.mDefaultTextColor = -1;
        this.mTextSize = 0.0f;
        this.mLeftMarginOfText = 0;
        this.mMarginOfDivider = 0;
        this.mNoBkg = false;
        init(r3, r4);
    }

    private void init(Context r3, String[] r4) {
        setFocusable(true);
        setOutsideTouchable(true);
        setClippingEnabled(false);
        if (r3 == null) goto L5;
        setBackgroundDrawable(r3.getResources().getDrawable(R.drawable.popup_frame));
    L5:
        this.mContext = r3;
        this.mItems = r4;
    }

    public void setBgDrawable(Context r1, int r2) {
        if (r1 == null) goto L5;
        setBackgroundDrawable(r1.getResources().getDrawable(r2));
        return;
    }

    public void setSelTextColor(int r2) {
        this.mUseSelTextColor = true;
        this.mSelTextColor = r2;
    }

    public void setDefaultTextColor(int r1) {
        this.mDefaultTextColor = r1;
    }

    public void setTextSize(float r1) {
        this.mTextSize = r1;
    }

    public void setLeftCheckStyle(boolean r1) {
        this.mLeftCheck = r1;
    }

    public void setCheckMargin(int r1) {
        this.checkMargin = r1;
    }

    public void setCheckBg(int r1) {
        this.checkBgId = r1;
    }

    public void setCheckVisiblePos(boolean[] r1) {
        this.checkVisiblePos = r1;
    }

    public void setTextFontsize(float r1) {
        this.mTextFontDimen = r1;
    }

    public void setLayoutPadding(boolean r1) {
        this.mPaddingSet = r1;
    }

    @Override // com.qihoo360.mobilesafe.ui.common.other.CommonPopupWindow
    protected void refreshView() {
        if (this.mItems != null) goto L5;
        return;
    L5:
        if (this.mItems.length != 0) goto L7;
        return;
    L7:
        if (this.mContext != null) goto L9;
        return;
    L9:
        if (this.mAnchorView == null) goto L96;
        View r1 = getContentView();
        int r2 = 1;
        if (r1 != null) goto L17;
        LinearLayout r3 = new LinearLayout(this.mContext);
        if (this.mPaddingSet == false) goto L16;
        int r4 = CommonUtils.dip2px(this.mContext, 8.0f);
        int r5 = CommonUtils.dip2px(this.mContext, 12.0f);
        r3.setPadding(r4, r5, r4, r5);
    L16:
        r3.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r3.setOrientation(1);
        setContentView(r3);
    L18:
        r3.removeAllViews();
        int r6 = CommonUtils.dip2px(this.mContext, 48.0f);
        if (this.mItemHeight <= 0) goto L21;
        r6 = CommonUtils.dip2px(this.mContext, this.mItemHeight);
    L21:
        int r7 = (int) this.mContext.getResources().getDimension(R.dimen.common_divider_width);
        if (this.mWindowWidth != (-1)) goto L24;
        int r8 = this.mAnchorView.getWidth();
    L25:
        LinearLayout.LayoutParams r9 = new LinearLayout.LayoutParams(r8, r6);
        LinearLayout.LayoutParams r10 = new LinearLayout.LayoutParams(-1, r7);
        int r11 = this.mMarginOfDivider;
        if (r11 == 0) goto L28;
        r10.setMargins(r11, 0, r11, 0);
    L28:
        int r12 = this.mContext.getResources().getColor(R.color.inner_common_bg_color_10_a19);
        final int r13 = 0;
    L30:
        if (r13 >= this.mItems.length) goto L88;
        View r14 = this.mInflater.inflate(R.layout.inner_common_popup_window_2, null);
        if (r13 != 0) goto L35;
        r14.setBackgroundResource(R.drawable.popup_menu_item_bg_top);
    L37:
        TextView r15 = (TextView) r14.findViewById(R.id.common_row_title);
        RelativeLayout.LayoutParams r16 = (RelativeLayout.LayoutParams) r15.getLayoutParams();
        int r17 = AnonymousClass2.$SwitchMap$android$text$TextUtils$TruncateAt[this.mTextEllipsize.ordinal()];
        if (r17 != r2) goto L40;
        r16.addRule(14);
    L44:
        r15.setLayoutParams(r16);
        r15.setText(this.mItems[r13]);
        r15.setContentDescription(this.mItems[r13]);
        if (Math.abs(this.mTextSize) < 1.0E-5d) goto L47;
        r15.setTextSize(0, this.mTextSize);
    L47:
        int r18 = this.mDefaultTextColor;
        if (r18 == (-1)) goto L51;
        r15.setTextColor(r18);
    L51:
        if (this.mUseSelTextColor == true) goto L53;
    L55:
        int r19 = 8;
        if (this.mLeftCheck == false) goto L59;
        RelativeLayout.LayoutParams r20 = (RelativeLayout.LayoutParams) r15.getLayoutParams();
        r20.width = -2;
        r20.addRule(14);
        r20.addRule(15);
        r15.requestLayout();
        ((ImageView) r14.findViewById(R.id.common_row_img)).setVisibility(8);
        ImageView r21 = (ImageView) r14.findViewById(R.id.common_row_leftimg);
        r21.setVisibility(0);
    L62:
        boolean[] r110 = this.checkVisiblePos;
        if (r110 == null) goto L73;
        if (r110.length > 0) goto L67;
    L78:
        int r111 = this.checkBgId;
        if (r111 <= (-1)) goto L82;
        r21.setImageResource(r111);
    L82:
        if (this.checkMargin <= (-1)) goto L84;
        RelativeLayout.LayoutParams r112 = new RelativeLayout.LayoutParams(-2, -2);
        r112.addRule(13);
        r112.addRule(11);
        r112.rightMargin = this.checkMargin;
        r21.setLayoutParams(r112);
    L84:
        r14.setOnClickListener(new AnonymousClass1(this, r13));
        r3.addView(r14, r9);
        if (r13 == (this.mItems.length - 1)) goto L87;
        View r22 = new View(this.mContext);
        r22.setBackgroundColor(r12);
        r3.addView(r22, r10);
    L87:
        r13 = r13 + 1;
        r2 = 1;
        goto L30
    L67:
        if (this.mCheckVisible == true) goto L69;
    L71:
        r21.setVisibility(r19);
        goto L78
    L69:
        if (this.checkVisiblePos[r13] == false) goto L71;
        r19 = 0;
        goto L71
    L73:
        if (this.mCheckVisible == true) goto L75;
    L77:
        r21.setVisibility(r19);
        goto L78
    L75:
        if (this.mSelectedIdx != r13) goto L77;
        r19 = 0;
        goto L77
    L59:
        if (this.mLeftMarginOfText == 0) goto L61;
        ((RelativeLayout.LayoutParams) r15.getLayoutParams()).leftMargin = this.mLeftMarginOfText;
    L61:
        r21 = (ImageView) r14.findViewById(R.id.common_row_img);
        goto L62
    L53:
        if (this.mSelectedIdx != r13) goto L55;
        r15.setTextColor(this.mSelTextColor);
        goto L55
    L40:
        if (r17 == 2) goto L42;
        r16.addRule(9);
        goto L44
    L42:
        r16.addRule(11);
        goto L44
    L35:
        if (r13 != (this.mItems.length - r2)) goto L37;
        r14.setBackgroundResource(R.drawable.popup_menu_item_bg_bottom);
        goto L37
    L88:
        setWidth(-2);
        setHeight(-2);
        return;
    L24:
        r8 = this.mWindowWidth;
        goto L25
    L17:
        r3 = (LinearLayout) r1;
        goto L18
    }

    public void setItemHeight(int r1) {
        this.mItemHeight = r1;
    }

    public void setLeftMarginOfText(int r1) {
        this.mLeftMarginOfText = r1;
    }

    public void setMarginOfDivider(int r1) {
        this.mMarginOfDivider = r1;
    }

    public void setNoBkgFlag(boolean r2) {
        this.mNoBkg = r2;
        if (r2 == false) goto L5;
        setBackgroundDrawable(new ColorDrawable(-1));
        return;
    L5:
        setBackgroundDrawable(getContentView().getContext().getResources().getDrawable(R.drawable.common_popup_bg));
    }
}
