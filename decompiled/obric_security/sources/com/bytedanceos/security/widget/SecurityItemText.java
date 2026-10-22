package com.bytedanceos.security.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.obric.security.R;
import obric.widget.ListContentItem;
import obric.widget.SwitchEx;

/* JADX INFO: loaded from: classes2.dex */
public class SecurityItemText extends ListContentItem {
    public static final int RIGHT_LAYOUT_MODE_BUTTON = 2;
    public static final int RIGHT_LAYOUT_MODE_CHECKBOX = 3;
    public static final int RIGHT_LAYOUT_MODE_TEXT_WITH_ARROW = 1;
    private View mArrow;
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener;
    private View mRightBtn;
    protected TextView mRightBtnText;
    protected View mRightButtonContainer;
    protected View mRightCheckBoxContainer;
    protected TextView mRightText;
    protected View mRightTextContainer;
    private View mRightWarnView;
    private SwitchEx mSwitch;
    protected TextView mWarnText;

    @Override // obric.widget.ListContentItem
    protected int getDefaultLeftLayout() {
        return R.layout.security_item_text_left_layout;
    }

    @Override // obric.widget.ListContentItem
    protected int getDefaultMidLayout() {
        return R.layout.security_item_text_mid_layout;
    }

    @Override // obric.widget.ListContentItem
    protected int getDefaultRightLayout() {
        return R.layout.security_item_text_right_layout;
    }

    static /* synthetic */ CompoundButton.OnCheckedChangeListener access$000(SecurityItemText r0) {
        return r0.mOnCheckedChangeListener;
    }

    public SecurityItemText(Context context) {
        this(context, null);
    }

    public SecurityItemText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SecurityItemText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray r4 = context.obtainStyledAttributes(attrs, R.styleable.SecurityItemText, defStyleAttr, 0);
        String r5 = r4.getString(5);
        boolean r6 = r4.getBoolean(4, false);
        int r0 = r4.getInt(2, 1);
        String r1 = r4.getString(0);
        String r2 = r4.getString(1);
        r4.recycle();
        showBtnWarnImg(r6);
        setWarnText(r5);
        setBtnText(r1);
        setRightLayout(r0);
        setDescText(r2);
        SwitchEx r7 = this.mSwitch;
        if (r7 == null) goto L6;
        r7.setOnCheckedChangeListener(new AnonymousClass1(this));
        return;
    }

    public void setDescText(String text) {
        if (this.mRightText != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(text) == true) goto L10;
        this.mRightText.setText(text);
        return;
    }

    public String getDescText() {
        TextView r0 = this.mRightText;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getText().toString();
    }

    public void setTitleTextColor(int color) {
        if (this.mTitle == null) goto L6;
        this.mTitle.setTextColor(color);
        return;
    }

    public void setSummaryTextColor(int color) {
        if (this.mSummary == null) goto L6;
        this.mSummary.setTextColor(color);
        return;
    }

    public void setRightLayout(int layoutMode) {
        this.mRightTextContainer.setVisibility(8);
        this.mRightButtonContainer.setVisibility(8);
        View r0 = this.mRightCheckBoxContainer;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
    L6:
        if (layoutMode != 1) goto L9;
        this.mRightTextContainer.setVisibility(0);
        return;
    L9:
        if (layoutMode != 2) goto L12;
        this.mRightButtonContainer.setVisibility(0);
        return;
    L12:
        if (layoutMode != 3) goto L19;
        View r2 = this.mRightCheckBoxContainer;
        if (r2 == null) goto L20;
        r2.setVisibility(0);
        return;
    L20:
        return;
    }

    public void setBtnClickListener(View.OnClickListener listener) {
        View r0 = this.mRightButtonContainer;
        if (r0 == null) goto L6;
        r0.setOnClickListener(listener);
        return;
    }

    public void setBtnBackgroudResource(int resid) {
        View r0 = this.mRightBtn;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setBackgroundResource(resid);
    }

    public void setBtnText(String message) {
        TextView r0 = this.mRightBtnText;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setText(message);
    }

    public void setBtnTextColor(int color) {
        TextView r0 = this.mRightBtnText;
        if (r0 == null) goto L6;
        r0.setTextColor(color);
        return;
    }

    public void setWarnText(String message) {
        if (this.mWarnText != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(message) == false) goto L8;
        return;
    L8:
        if (this.mWarnText.getVisibility() != 8) goto L10;
        this.mWarnText.setVisibility(0);
    L10:
        this.mWarnText.setText(message);
    }

    public void showWarnText(boolean show) {
        TextView r0 = this.mWarnText;
        if (r0 != null) goto L5;
        return;
    L5:
        if (show == false) goto L7;
        int r1 = 0;
    L8:
        r0.setVisibility(r1);
        return;
    L7:
        r1 = 8;
        goto L8
    }

    public void showBtnWarnImg(boolean show) {
        View r0 = this.mRightWarnView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (show == false) goto L7;
        int r1 = 0;
    L8:
        r0.setVisibility(r1);
        return;
    L7:
        r1 = 8;
        goto L8
    }

    public void setArrowVisible(boolean show) {
        View r0 = this.mArrow;
        if (r0 != null) goto L5;
        return;
    L5:
        if (show == false) goto L7;
        int r1 = 0;
    L8:
        r0.setVisibility(r1);
        return;
    L7:
        r1 = 8;
        goto L8
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener listener) {
        this.mOnCheckedChangeListener = listener;
    }

    public void setChecked(boolean isChecked) {
        SwitchEx r0 = this.mSwitch;
        if (r0 != null) goto L5;
        return;
    L5:
        CompoundButton.OnCheckedChangeListener r1 = this.mOnCheckedChangeListener;
        this.mOnCheckedChangeListener = null;
        r0.setChecked(isChecked);
        this.mOnCheckedChangeListener = r1;
    }

    public SwitchEx getSwitch() {
        return this.mSwitch;
    }

    @Override // obric.widget.ListContentItem
    protected void initMidWidget() {
        super.initMidWidget();
        this.mWarnText = (TextView) findViewById(R.id.item_warning);
    }

    @Override // obric.widget.ListContentItem
    protected void initRightWidget() {
        this.mRightText = (TextView) findViewById(R.id.right_text);
        this.mRightBtnText = (TextView) findViewById(R.id.right_btn_text);
        this.mRightWarnView = findViewById(R.id.right_btn_warn);
        this.mRightBtn = findViewById(R.id.right_btn);
        this.mRightTextContainer = findViewById(R.id.right_text_container);
        this.mRightButtonContainer = findViewById(R.id.right_btn_container);
        this.mRightCheckBoxContainer = findViewById(R.id.right_checkbox_container);
        this.mArrow = findViewById(R.id.arrow);
        this.mSwitch = (SwitchEx) findViewById(R.id.switchex);
    }
}
