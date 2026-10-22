package com.qihoo360.mobilesafe.common.ui.textview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qihoo360.mobilesafe.common.ui.R;
import com.qihoo360.mobilesafe.common.ui.checkbox.CommonCheckBox;
import com.qihoo360.mobilesafe.common.ui.utils.CommonUtils;

/* JADX INFO: loaded from: classes4.dex */
public class CommonCheckBoxTextView extends LinearLayout {
    private CommonCheckBox mCheckBox;
    private boolean mCheckBoxVisible;
    private TextView mTextView;

    public CommonCheckBoxTextView(Context r2) {
        this(r2, null);
    }

    public CommonCheckBoxTextView(Context r7, AttributeSet r8) {
        super(r7, r8);
        setOrientation(0);
        TypedArray r9 = r7.obtainStyledAttributes(r8, R.styleable.CommonCheckBoxTextView);
        this.mCheckBoxVisible = r9.getBoolean(R.styleable.CommonCheckBoxTextView_checkBoxVisible, true);
        boolean r1 = r9.getBoolean(R.styleable.CommonCheckBoxTextView_checked_pref, true);
        int r2 = r9.getResourceId(R.styleable.CommonCheckBoxTextView_checkBoxTextColor, R.color.inner_common_text_color_2);
        int r3 = r9.getResourceId(R.styleable.CommonCheckBoxTextView_checkText, 0);
        r9.recycle();
        if (this.mCheckBoxVisible == false) goto L5;
        CommonCheckBox r10 = new CommonCheckBox(r7);
        this.mCheckBox = r10;
        r10.setUICheckBoxStyle(CommonCheckBox.CheckBoxStyle.CHECK_BOX_STYLE_1);
        LinearLayout.LayoutParams r11 = new LinearLayout.LayoutParams(-2, -2);
        r11.gravity = 16;
        this.mCheckBox.setLayoutParams(r11);
        setUICheckBoxChecked(r1);
        addView(this.mCheckBox);
    L5:
        TextView r12 = new TextView(getContext());
        this.mTextView = r12;
        if (r3 == 0) goto L8;
        r12.setText(r3);
    L8:
        this.mTextView.setTextSize(0, getResources().getDimension(R.dimen.inner_common_font_size_f));
        this.mTextView.setTextColor(getResources().getColor(r2));
        LinearLayout.LayoutParams r13 = new LinearLayout.LayoutParams(-2, -2);
        r13.gravity = 16;
        if (this.mCheckBoxVisible == false) goto L11;
        r13.leftMargin = CommonUtils.dip2px(getContext(), 10.0f);
    L11:
        addView(this.mTextView, r13);
    }

    public void setUICheckBoxStyle(CommonCheckBox.CheckBoxStyle r1) {
        this.mCheckBox.setUICheckBoxStyle(r1);
    }

    public void setUICheckBoxClickListener(View.OnClickListener r2) {
        if (this.mCheckBoxVisible == false) goto L6;
        this.mCheckBox.setUICheckBoxClickListener(r2);
        return;
    }

    public void setUICheckBoxChecked(boolean r2) {
        if (this.mCheckBoxVisible == false) goto L6;
        this.mCheckBox.setUICheckBoxChecked(r2);
        return;
    }

    public boolean isUICheckBoxChecked() {
        return this.mCheckBox.isUICheckBoxChecked();
    }

    public void setUICheckBoxCheckedText(CharSequence r1) {
        this.mTextView.setText(r1);
    }

    public void setUICheckBoxCheckedTextColor(int r2) {
        this.mTextView.setTextColor(getResources().getColor(r2));
    }
}
