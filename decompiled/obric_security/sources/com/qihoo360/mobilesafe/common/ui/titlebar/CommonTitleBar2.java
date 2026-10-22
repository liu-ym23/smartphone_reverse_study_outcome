package com.qihoo360.mobilesafe.common.ui.titlebar;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qihoo360.mobilesafe.common.ui.R;
import com.qihoo360.mobilesafe.common.ui.btn.CommonButton;
import com.qihoo360.mobilesafe.common.ui.utils.CommonUtils;

/* JADX INFO: loaded from: classes4.dex */
public class CommonTitleBar2 extends RelativeLayout implements View.OnClickListener {
    private ImageView mBack;
    private TitleIcon mRightIcon0;
    private TitleIcon mRightIcon1;
    private TitleIcon mRightIcon2;
    private CommonButton mRightIcon3;
    private TextView mTitle;

    static class TitleIcon extends FrameLayout {
        ImageView icon;
        TextView textIcon;
        boolean useTextIcon;

        public TitleIcon(Context r1) {
            super(r1);
            this.useTextIcon = false;
            init();
        }

        public TitleIcon(Context r1, boolean r2) {
            super(r1);
            this.useTextIcon = r2;
            init();
        }

        public void setIconDescription(CharSequence r1) {
            ImageView r0 = this.icon;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.setContentDescription(r1);
        }

        public void setImageDrawable(Drawable r1) {
            ImageView r0 = this.icon;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.setImageDrawable(r1);
        }

        public void setTextIconText(String r1) {
            TextView r0 = this.textIcon;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.setText(r1);
        }

        public void setTextIconTextSize(int r2) {
            TextView r1 = this.textIcon;
            if (r1 != null) goto L5;
            return;
        L5:
            r1.setTextSize(0, r2);
        }

        public void setTextIconTextColor(int r1) {
            TextView r0 = this.textIcon;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.setTextColor(r1);
        }

        private void init() {
            FrameLayout r0 = new FrameLayout(getContext());
            int r1 = CommonUtils.dip2px(getContext(), 40.0f);
            int r2 = CommonUtils.dip2px(getContext(), 4.0f);
            FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(-2, -2);
            r3.gravity = 17;
            if (this.useTextIcon == false) goto L5;
            FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(-2, -2);
            r4.gravity = 17;
            TextView r5 = new TextView(getContext());
            this.textIcon = r5;
            r5.setTextSize(0, getResources().getDimension(R.dimen.inner_common_font_size_e));
            r0.addView(this.textIcon, r3);
        L6:
            ShapeDrawable r6 = new ShapeDrawable(new OvalShape());
            r6.getPaint().setColor(855638016);
            StateListDrawable r7 = new StateListDrawable();
            r7.addState(new int[]{android.R.attr.state_pressed}, r6);
            r0.setBackgroundDrawable(r7);
            r0.setPadding(r2, 0, r2, 0);
            addView(r0, r4);
            return;
        L5:
            FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(r1, r1);
            r8.gravity = 17;
            ImageView r9 = new ImageView(getContext());
            this.icon = r9;
            r0.addView(r9, r3);
            r4 = r8;
            goto L6
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int r2, int r3) {
            if (this.useTextIcon == true) goto L5;
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(CommonUtils.dip2px(getContext(), 48.0f), 1073741824), r3);
            return;
        L5:
            super.onMeasure(r2, r3);
        }
    }

    public CommonTitleBar2(Context r2) {
        this(r2, null);
    }

    public CommonTitleBar2(Context r1, AttributeSet r2) {
        super(r1, r2);
        init(r2);
    }

    public void setTitle(CharSequence r2) {
        this.mTitle.setText(r2);
        this.mTitle.setContentDescription(r2);
    }

    public void setTitleViewCompoundDrawables(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        this.mTitle.setCompoundDrawablesWithIntrinsicBounds(r1, r2, r3, r4);
    }

    public void setBackOnClickListener(View.OnClickListener r1) {
        this.mBack.setOnClickListener(r1);
    }

    public void setIcon0Drawable(Drawable r1) {
        this.mRightIcon0.setImageDrawable(r1);
    }

    public void setIcon0Description(CharSequence r1) {
        this.mRightIcon0.setIconDescription(r1);
    }

    public void setIcon1Drawable(Drawable r1) {
        this.mRightIcon1.setImageDrawable(r1);
    }

    public void setIcon1DesCription(CharSequence r1) {
        this.mRightIcon1.setIconDescription(r1);
    }

    public View getIcon0View() {
        return this.mRightIcon0;
    }

    public View getIcon1View() {
        return this.mRightIcon1;
    }

    public View getIcon2View() {
        return this.mRightIcon2;
    }

    public View getIcon3View() {
        return this.mRightIcon3;
    }

    public void setIcon2Drawable(Drawable r1) {
        this.mRightIcon2.setImageDrawable(r1);
    }

    public void setTextIcon2Text(String r1) {
        this.mRightIcon2.setTextIconText(r1);
    }

    public void setTextIcon2TextSize(int r1) {
        this.mRightIcon2.setTextIconTextSize(r1);
    }

    public void setTextIcon2TextColor(int r1) {
        this.mRightIcon2.setTextIconTextColor(r1);
    }

    public void setTextIcon1Text(String r1) {
        this.mRightIcon1.setTextIconText(r1);
    }

    public void setTextIcon1TextSize(int r1) {
        this.mRightIcon1.setTextIconTextSize(r1);
    }

    public void setTextIcon1TextColor(int r1) {
        this.mRightIcon1.setTextIconTextColor(r1);
    }

    public void setTextIcon0Text(String r1) {
        this.mRightIcon0.setTextIconText(r1);
    }

    public void setTextIcon0TextSize(int r1) {
        this.mRightIcon0.setTextIconTextSize(r1);
    }

    public void setTextIcon0TextColor(int r1) {
        this.mRightIcon0.setTextIconTextColor(r1);
    }

    public void setIcon2DesCription(CharSequence r1) {
        this.mRightIcon2.setIconDescription(r1);
    }

    public void setIcon0OnClickListener(View.OnClickListener r1) {
        this.mRightIcon0.setOnClickListener(r1);
    }

    public void setIcon1OnClickListener(View.OnClickListener r1) {
        this.mRightIcon1.setOnClickListener(r1);
    }

    public void setIcon2OnClickListener(View.OnClickListener r1) {
        this.mRightIcon2.setOnClickListener(r1);
    }

    public void setIcon3OnClickListener(View.OnClickListener r1) {
        this.mRightIcon3.setOnClickListener(r1);
    }

    public void setRightIcon0Visible(boolean r1) {
        TitleIcon r0 = this.mRightIcon0;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 4;
        goto L6
    }

    public void setRightIcon1Visible(boolean r1) {
        TitleIcon r0 = this.mRightIcon1;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 4;
        goto L6
    }

    public void setRightIcon2Visible(boolean r1) {
        TitleIcon r0 = this.mRightIcon2;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 4;
        goto L6
    }

    public void setRightIcon3Visible(boolean r1) {
        CommonButton r0 = this.mRightIcon3;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 4;
        goto L6
    }

    public void setRightIcon3(CommonButton.BtnStyle r3) {
        this.mRightIcon3.setUIButtonStyle(r3);
        this.mRightIcon3.setId(R.id.common_title_button);
        RelativeLayout.LayoutParams r4 = getIconLayoutParams();
        r4.rightMargin = getResources().getDimensionPixelOffset(R.dimen.inner_common_dimen_18dp);
        r4.height = getResources().getDimensionPixelOffset(R.dimen.inner_common_dimen_30dp);
        r4.addRule(11);
        r4.addRule(15);
        addView(this.mRightIcon3, r4);
    }

    public void setRightIcon3Text(CharSequence r1) {
        this.mRightIcon3.setText(r1);
    }

    public void setRightIcon3Enable(boolean r1) {
        this.mRightIcon3.setUIButtonEnable(r1);
    }

    public void setOnBackListener(View.OnClickListener r1) {
        this.mBack.setOnClickListener(r1);
    }

    public void setBackgroundTransparent() {
        setBackgroundColor(getResources().getColor(R.color.inner_common_transparent));
    }

    public void setLeftIconVisible(boolean r4) {
        ImageView r0 = this.mBack;
        if (r4 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        if (r4 == false) goto L9;
        this.mTitle.setPadding(0, 0, CommonUtils.dip2px(getContext(), 48.0f), 0);
        return;
    L9:
        this.mTitle.setPadding(CommonUtils.dip2px(getContext(), 10.0f), 0, 0, 0);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    private void init(AttributeSet r9) {
        setGravity(16);
        setBackgroundResource(R.color.inner_common_bg_color_3);
        TypedArray r0 = getContext().obtainStyledAttributes(r9, R.styleable.inner_common_pref);
        ImageView r1 = new ImageView(getContext());
        this.mBack = r1;
        r1.setContentDescription(getResources().getString(R.string.inner_common_return));
        this.mBack.setPadding(CommonUtils.dip2px(getContext(), 15.0f), 0, CommonUtils.dip2px(getContext(), 2.0f), 0);
        Drawable r2 = getResources().getDrawable(R.drawable.inner_common_icon_back_normal);
        Drawable r3 = getResources().getDrawable(R.drawable.inner_common_icon_back_normal);
        if (r2 == null) goto L6;
        if (r3 == null) goto L6;
        Drawable r4 = r3.mutate();
        r4.setAlpha(127);
        StateListDrawable r5 = new StateListDrawable();
        r5.addState(new int[]{android.R.attr.state_pressed}, r4);
        r5.addState(new int[]{0}, r2);
        this.mBack.setImageDrawable(r5);
    L6:
        this.mBack.setOnClickListener(this);
        this.mBack.setId(R.id.common_ll_left);
        RelativeLayout.LayoutParams r6 = getIconLayoutParams();
        r6.addRule(9);
        r6.addRule(15);
        addView(this.mBack, r6);
        TextView r7 = new TextView(getContext());
        this.mTitle = r7;
        r7.setId(R.id.common_ll_middle);
        this.mTitle.setGravity(19);
        this.mTitle.setTextColor(getResources().getColor(R.color.inner_common_text_color_10));
        this.mTitle.setTextSize(0, getResources().getDimension(R.dimen.inner_common_font_size_d));
        this.mTitle.setSingleLine();
        this.mTitle.setIncludeFontPadding(false);
        this.mTitle.setPadding(0, 0, CommonUtils.dip2px(getContext(), 48.0f), 0);
        RelativeLayout.LayoutParams r8 = new RelativeLayout.LayoutParams(-2, -2);
        r8.addRule(1, this.mBack.getId());
        r8.addRule(15);
        addView(this.mTitle, r8);
        boolean r10 = r0.getBoolean(R.styleable.inner_common_pref_ui_first_icon_use_text, false);
        boolean r11 = r0.getBoolean(R.styleable.inner_common_pref_ui_second_icon_use_text, false);
        boolean r12 = r0.getBoolean(R.styleable.inner_common_pref_ui_third_icon_use_text, false);
        this.mRightIcon0 = new TitleIcon(getContext(), r10);
        TitleIcon r13 = new TitleIcon(getContext(), r11);
        this.mRightIcon1 = r13;
        r13.setId(R.id.common_ll_right_icon1);
        TitleIcon r14 = new TitleIcon(getContext(), r12);
        this.mRightIcon2 = r14;
        r14.setId(R.id.common_ll_right);
        this.mRightIcon3 = new CommonButton(getContext());
        RelativeLayout.LayoutParams r15 = getIconLayoutParams();
        r15.addRule(11);
        r15.addRule(15);
        addView(this.mRightIcon2, r15);
        RelativeLayout.LayoutParams r16 = getIconLayoutParams();
        r16.addRule(0, this.mRightIcon2.getId());
        r16.addRule(15);
        addView(this.mRightIcon1, r16);
        RelativeLayout.LayoutParams r17 = getIconLayoutParams();
        r17.addRule(0, this.mRightIcon1.getId());
        r17.addRule(15);
        addView(this.mRightIcon0, r17);
        Drawable r18 = r0.getDrawable(R.styleable.inner_common_pref_ui_right_icon1);
        Drawable r19 = r0.getDrawable(R.styleable.inner_common_pref_ui_right_icon2);
        CharSequence r20 = CommonUtils.getTextFromAttrs(getContext(), r9);
        if (TextUtils.isEmpty(r20) == true) goto L9;
        setTitle(r20);
    L9:
        setIcon1Drawable(r18);
        setIcon2Drawable(r19);
        r0.recycle();
    }

    private RelativeLayout.LayoutParams getIconLayoutParams() {
        return new RelativeLayout.LayoutParams(-2, -1);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int r2, int r3) {
        super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(getResources().getDimensionPixelSize(R.dimen.inner_common_dimen_56dp), 1073741824));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r1) {
        Context r0 = getContext();
        if ((r0 instanceof Activity) == false) goto L6;
        ((Activity) r0).finish();
        return;
    }
}
