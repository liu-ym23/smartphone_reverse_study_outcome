package com.qihoo360.mobilesafe.ui.common.row;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qihoo360.mobilesafe.common.ui.R;
import com.qihoo360.mobilesafe.common.ui.utils.CommonUtils;

/* JADX INFO: loaded from: classes4.dex */
public class CommonListTitleIcon extends RelativeLayout {
    private ImageView mIcon;
    private TextView mRightText;
    private TextView mTitle;

    public CommonListTitleIcon(Context r2) {
        this(r2, null);
    }

    public CommonListTitleIcon(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public CommonListTitleIcon(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        init(r2);
    }

    public void setTitle(CharSequence r2) {
        this.mTitle.setText(r2);
        this.mTitle.setContentDescription(r2);
    }

    public void setTitleColor(int r2) {
        this.mTitle.setTextColor(getResources().getColor(r2));
    }

    public void setIcon(int r1) {
        this.mIcon.setImageResource(r1);
    }

    public void setRightText(CharSequence r2) {
        this.mRightText.setText(r2);
        this.mRightText.setContentDescription(r2);
    }

    public void setRightTextColor(int r2) {
        this.mRightText.setTextColor(getResources().getColor(r2));
    }

    public void setRightTextVisible(boolean r1) {
        TextView r0 = this.mRightText;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    public void setRightClickListener(View.OnClickListener r1) {
        this.mRightText.setOnClickListener(r1);
    }

    private void init(AttributeSet r10) {
        setBackgroundColor(getResources().getColor(R.color.inner_common_bg_color_1));
        ImageView r0 = new ImageView(getContext());
        this.mIcon = r0;
        r0.setId(R.id.common_list_title_icon);
        int r1 = CommonUtils.dip2px(getContext(), 4.0f);
        int r2 = CommonUtils.dip2px(getContext(), 6.0f);
        int r3 = CommonUtils.dip2px(getContext(), 12.0f);
        int r4 = CommonUtils.dip2px(getContext(), 15.0f);
        int r5 = CommonUtils.dip2px(getContext(), 18.0f);
        RelativeLayout.LayoutParams r6 = new RelativeLayout.LayoutParams(-2, -2);
        r6.topMargin = r3;
        r6.leftMargin = r4;
        r6.rightMargin = r2;
        addView(this.mIcon, r6);
        TextView r7 = new TextView(getContext());
        this.mTitle = r7;
        r7.setId(R.id.common_list_title_text);
        RelativeLayout.LayoutParams r8 = new RelativeLayout.LayoutParams(-2, -2);
        r8.addRule(1, R.id.common_list_title_icon);
        r8.rightMargin = r4;
        this.mTitle.setPadding(0, r3, 0, r3 - 1);
        this.mTitle.setGravity(51);
        this.mTitle.setTextColor(getResources().getColor(R.color.inner_common_text_color_1));
        this.mTitle.setTextSize(0, getResources().getDimension(R.dimen.inner_common_font_size_f));
        float r9 = r1;
        this.mTitle.setLineSpacing(r9, 1.0f);
        addView(this.mTitle, r8);
        TextView r11 = new TextView(getContext());
        this.mRightText = r11;
        r11.setId(R.id.common_list_right_text);
        RelativeLayout.LayoutParams r12 = new RelativeLayout.LayoutParams(-2, -2);
        r12.addRule(11);
        r12.addRule(15);
        r12.rightMargin = r5;
        this.mRightText.setGravity(21);
        this.mRightText.setTextColor(getResources().getColor(R.color.inner_common_text_color_5));
        this.mRightText.setTextSize(0, getResources().getDimension(R.dimen.inner_common_font_size_f));
        this.mRightText.getPaint().setFlags(8);
        this.mRightText.getPaint().setAntiAlias(true);
        this.mRightText.setLineSpacing(r9, 1.0f);
        addView(this.mRightText, r12);
        this.mRightText.setVisibility(8);
        View r13 = new View(getContext());
        r13.setBackgroundResource(R.color.inner_common_bg_color_7);
        RelativeLayout.LayoutParams r14 = new RelativeLayout.LayoutParams(-1, 1);
        r14.addRule(3, R.id.common_list_title_text);
        addView(r13, r14);
        CharSequence r15 = CommonUtils.getTextFromAttrs(getContext(), r10);
        if (TextUtils.isEmpty(r15) == true) goto L6;
        setTitle(r15);
        return;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }
}
