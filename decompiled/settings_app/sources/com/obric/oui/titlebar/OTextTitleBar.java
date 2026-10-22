package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.common.widget.ClickEffectTouchListener;
import com.obric.oui.titlebar.listener.OnTitleBarClickListener;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class OTextTitleBar extends OTitleBar implements View.OnClickListener {
    public static final int END_BUTTON_TYPE_ACTION = 1;
    public static final int END_BUTTON_TYPE_NORMAL = 0;
    private int endButtonType;
    private ImageView mBackBtn;
    private TextView mEndText;
    private View mLine;
    private OnTitleBarClickListener mOnTitleBarClickListener;
    private TextView mStartText;
    private boolean mUseBackIcon;
    private boolean mUseCloseIcon;

    public OTextTitleBar(Context r2) {
        this(r2, null);
    }

    public OTextTitleBar(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public OTextTitleBar(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.endButtonType = 0;
        init(r1);
        if (r2 == null) goto L6;
        initAttrs(r1, r2);
        return;
    }

    private void initAttrs(Context r8, AttributeSet r9) {
        TypedArray r10 = r8.obtainStyledAttributes(r9, R.styleable.OTextTitleBar);
        String r0 = r10.getString(R.styleable.OTextTitleBar_oui_centerText);
        float r1 = r10.getDimension(R.styleable.OTextTitleBar_oui_centerTextSize, OUnitExtensionKt.dp2px(17));
        int r2 = r10.getColor(R.styleable.OTextTitleBar_oui_centerTextColor, ContextCompat.getColor(r8, R.color.TextPrimary));
        this.mTitleView.setText(r0);
        this.mTitleView.setTextSize(0, r1);
        this.mTitleView.setTextColor(r2);
        this.mUseBackIcon = r10.getBoolean(R.styleable.OTextTitleBar_oui_useBackIcon, false);
        boolean r3 = r10.getBoolean(R.styleable.OTextTitleBar_oui_useCloseIcon, false);
        this.mUseCloseIcon = r3;
        if (this.mUseBackIcon == false) goto L5;
        this.mBackBtn.setVisibility(0);
        this.mStartText.setVisibility(8);
        this.mBackBtn.setContentDescription(r8.getString(R.string.oui_iv_back_desc));
    L8:
        int r4 = r10.getInt(R.styleable.OTextTitleBar_oui_rightButtonType, 1);
        this.endButtonType = r4;
        if (r4 != 1) goto L11;
        this.mEndText.setTextColor(ContextCompat.getColor(r8, R.color.Primary));
    L12:
        String r5 = r10.getString(R.styleable.OTextTitleBar_oui_rightButtonText);
        float r6 = r10.getDimension(R.styleable.OTextTitleBar_oui_rightTextSize, OUnitExtensionKt.dp2px(15));
        int r7 = r10.getColor(R.styleable.OTextTitleBar_oui_rightTextColor, ContextCompat.getColor(r8, R.color.TextPrimary));
        int r11 = r10.getInt(R.styleable.OTextTitleBar_oui_rightTextVisible, 0);
        this.mEndText.setText(r5);
        this.mEndText.setTextSize(0, r6);
        if (r10.hasValue(R.styleable.OTextTitleBar_oui_rightTextColor) == false) goto L15;
        this.mEndText.setTextColor(r7);
    L15:
        this.mEndText.setVisibility(r11);
        this.mLine.setVisibility(r10.getInt(R.styleable.OTextTitleBar_oui_dividerVisible, 0));
        this.mLine.setBackgroundColor(r10.getColor(R.styleable.OTextTitleBar_oui_dividerColor, ContextCompat.getColor(r8, R.color.LinePrimary)));
        r10.recycle();
        return;
    L11:
        this.mEndText.setTextColor(ContextCompat.getColor(r8, R.color.TextPrimary));
        goto L12
    L5:
        if (r3 == false) goto L7;
        this.mBackBtn.setVisibility(0);
        this.mBackBtn.setImageResource(R.drawable.o_ic_titlebar_close);
        this.mStartText.setVisibility(8);
        this.mBackBtn.setContentDescription(r8.getString(R.string.oui_iv_close_desc));
        goto L8
    L7:
        String r12 = r10.getString(R.styleable.OTextTitleBar_oui_leftButtonText);
        float r13 = r10.getDimension(R.styleable.OTextTitleBar_oui_leftTextSize, OUnitExtensionKt.dp2px(15));
        int r14 = r10.getColor(R.styleable.OTextTitleBar_oui_leftTextColor, ContextCompat.getColor(r8, R.color.TextPrimary));
        this.mBackBtn.setVisibility(8);
        this.mStartText.setVisibility(0);
        this.mStartText.setText(r12);
        this.mStartText.setTextSize(0, r13);
        this.mStartText.setTextColor(r14);
        goto L8
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int r0 = OUnitExtensionKt.getScreenWidth(getContext());
        int r1 = ((r0 / 2) - Math.max(this.mStartText.getMeasuredWidth(), this.mEndText.getMeasuredWidth())) * 2;
        this.mTitleView.setMaxWidth(Math.max(r1, OUnitExtensionKt.dp2px(112)));
    }

    private void init(Context r3) {
        inflate(r3, R.layout.o_view_text_title_bar, this);
        this.mStartText = (TextView) findViewById(R.id.text_left);
        this.mTitleView = (TextView) findViewById(R.id.title);
        this.mEndText = (TextView) findViewById(R.id.text_right);
        this.mBackBtn = (ImageView) findViewById(R.id.back_btn);
        this.mLine = findViewById(R.id.line);
        this.mBackBtn.setOnClickListener(this);
        this.mStartText.setOnClickListener(this);
        this.mEndText.setOnClickListener(this);
        ClickEffectTouchListener r4 = new ClickEffectTouchListener(0.5f, 1.0f);
        this.mBackBtn.setOnTouchListener(r4);
        this.mStartText.setOnTouchListener(r4);
        this.mEndText.setOnTouchListener(r4);
    }

    public void setStartText(CharSequence r1) {
        this.mStartText.setText(r1);
    }

    public void setStartText(int r1) {
        this.mStartText.setText(r1);
    }

    public void setStartTextColor(int r1) {
        this.mStartText.setTextColor(r1);
    }

    public void setStartTextSize(float r1) {
        this.mStartText.setTextSize(r1);
    }

    public void setEndText(CharSequence r1) {
        this.mEndText.setText(r1);
    }

    public void setEndText(int r1) {
        this.mEndText.setText(r1);
    }

    public void setEndTextColor(int r1) {
        this.mEndText.setTextColor(r1);
    }

    public void setEndTextSize(float r1) {
        this.mEndText.setTextSize(r1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        if (this.mOnTitleBarClickListener != null) goto L5;
        return;
    L5:
        if (r3.getId() != R.id.back_btn) goto L7;
    L12:
        this.mOnTitleBarClickListener.onBackClick(r3);
        return;
    L7:
        if (r3.getId() == R.id.text_left) goto L12;
        if (r3.getId() != R.id.text_right) goto L15;
        this.mOnTitleBarClickListener.onEndBtnClick(r3);
        return;
    }

    public void setOnTitleBarClickListener(OnTitleBarClickListener r1) {
        this.mOnTitleBarClickListener = r1;
    }

    public TextView getStartText() {
        return this.mStartText;
    }

    public TextView getEndText() {
        return this.mEndText;
    }

    public ImageView getBackBtn() {
        return this.mBackBtn;
    }

    public boolean isUseBackIcon() {
        return this.mUseBackIcon;
    }

    public boolean isUseCloseIcon() {
        return this.mUseCloseIcon;
    }

    public void setUseBackIcon(boolean r4) {
        if (this.mUseBackIcon == r4) goto L13;
        this.mUseBackIcon = r4;
        ImageView r0 = this.mBackBtn;
        int r1 = 0;
        if (r4 == false) goto L7;
        int r5 = 0;
    L8:
        r0.setVisibility(r5);
        this.mBackBtn.setImageResource(R.drawable.o_ic_titlebar_back);
        TextView r6 = this.mStartText;
        if (this.mUseBackIcon == false) goto L11;
        r1 = 8;
    L11:
        r6.setVisibility(r1);
        this.mBackBtn.setContentDescription(getContext().getString(R.string.oui_iv_back_desc));
        return;
    L7:
        r5 = 8;
        goto L8
    }

    public void setUseCloseIcon(boolean r4) {
        if (this.mUseCloseIcon == r4) goto L13;
        this.mUseCloseIcon = r4;
        ImageView r0 = this.mBackBtn;
        int r1 = 0;
        if (r4 == false) goto L7;
        int r5 = 0;
    L8:
        r0.setVisibility(r5);
        this.mBackBtn.setImageResource(R.drawable.o_ic_titlebar_close);
        TextView r6 = this.mStartText;
        if (this.mUseCloseIcon == false) goto L11;
        r1 = 8;
    L11:
        r6.setVisibility(r1);
        this.mBackBtn.setContentDescription(getContext().getString(R.string.oui_iv_close_desc));
        return;
    L7:
        r5 = 8;
        goto L8
    }

    public void showLine(boolean r1) {
        View r0 = this.mLine;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void showDividerLine(boolean r1) {
        View r0 = this.mLine;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(int r1) {
        this.mLine.setBackgroundColor(r1);
    }

    public void setLineBackground(int r1) {
        this.mLine.setBackgroundColor(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextView r0 = this.mStartText;
        if (r0 == null) goto L5;
        ViewExtensionsKt.expandTouchArea(r0, OUnitExtensionKt.dp2px(44), OUnitExtensionKt.dp2px(44), false);
    L5:
        TextView r5 = this.mEndText;
        if (r5 == null) goto L9;
        ViewExtensionsKt.expandTouchArea(r5, OUnitExtensionKt.dp2px(44), OUnitExtensionKt.dp2px(44), false);
        return;
    }

    public int getEndButtonType() {
        return this.endButtonType;
    }
}
