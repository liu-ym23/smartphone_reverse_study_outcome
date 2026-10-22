package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
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

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class OButtonTitleBar extends OTitleBar implements View.OnClickListener {
    private static final float DEFAULT_END_BUTTON_SIZE = 17.0f;
    public static final int END_BUTTON_TYPE_ACTION = 1;
    public static final int END_BUTTON_TYPE_NORMAL = 0;
    private int endButtonType;
    private TextView mEndBtn;
    private Drawable mEndButtonBackgroundDrawable;
    private View mLine;
    private int mLineColor;
    private OnTitleBarClickListener mOnTitleBarClickListener;
    private ImageView mStartBtn;

    public OButtonTitleBar(Context r2) {
        this(r2, null);
    }

    public OButtonTitleBar(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public OButtonTitleBar(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.endButtonType = 0;
        init(r1);
        if (r2 == null) goto L6;
        initAttrs(r1, r2);
        return;
    }

    private void initAttrs(Context r9, AttributeSet r10) {
        TypedArray r11 = r9.obtainStyledAttributes(r10, R.styleable.OButtonTitleBar);
        String r0 = r11.getString(R.styleable.OButtonTitleBar_oui_centerText);
        float r1 = r11.getDimension(R.styleable.OButtonTitleBar_oui_centerTextSize, OUnitExtensionKt.dp2px(17));
        int r2 = r11.getColor(R.styleable.OButtonTitleBar_oui_centerTextColor, ContextCompat.getColor(r9, R.color.TextPrimary));
        this.mTitleView.setText(r0);
        int r3 = 0;
        this.mTitleView.setTextSize(0, r1);
        this.mTitleView.setTextColor(r2);
        String r4 = r11.getString(R.styleable.OButtonTitleBar_oui_rightButtonText);
        int r5 = r11.getInt(R.styleable.OButtonTitleBar_oui_rightButtonType, 1);
        float r6 = r11.getDimension(R.styleable.OButtonTitleBar_oui_rightButtonTextSize, OUnitExtensionKt.dp2px(DEFAULT_END_BUTTON_SIZE));
        int r7 = r11.getColor(R.styleable.OButtonTitleBar_oui_rightButtonTextColor, 0);
        this.mEndButtonBackgroundDrawable = r11.getDrawable(R.styleable.OButtonTitleBar_oui_rightButtonTextBackground);
        int r8 = r11.getInt(R.styleable.OButtonTitleBar_oui_rightButtonVisible, 0);
        this.mEndBtn.setText(r4);
        this.endButtonType = r5;
        if (r5 != 1) goto L5;
        this.mEndBtn.setTypeface(Typeface.defaultFromStyle(1));
        this.mEndBtn.setTextColor(ContextCompat.getColor(r9, R.color.Primary));
    L6:
        this.mEndBtn.setTextSize(0, r6);
        if (r7 == 0) goto L9;
        this.mEndBtn.setTextColor(r7);
    L9:
        Drawable r12 = this.mEndButtonBackgroundDrawable;
        if (r12 == null) goto L12;
        this.mEndBtn.setBackground(r12);
    L12:
        this.mEndBtn.setVisibility(r8);
        boolean r13 = r11.getBoolean(R.styleable.OButtonTitleBar_oui_dividerVisible, false);
        View r14 = this.mLine;
        if (r13 == true) goto L16;
        r3 = 4;
    L16:
        r14.setVisibility(r3);
        int r15 = r11.getColor(R.styleable.OButtonTitleBar_oui_dividerColor, ContextCompat.getColor(r9, R.color.LinePrimary));
        this.mLineColor = r15;
        this.mLine.setBackgroundColor(r15);
        r11.recycle();
        return;
    L5:
        this.mEndBtn.setTypeface(Typeface.defaultFromStyle(0));
        this.mEndBtn.setTextColor(ContextCompat.getColor(r9, R.color.TextPrimary));
        goto L6
    }

    private void init(Context r3) {
        inflate(r3, R.layout.o_view_button_title_bar, this);
        this.mStartBtn = (ImageView) findViewById(R.id.back_btn);
        this.mTitleView = (TextView) findViewById(R.id.title);
        this.mEndBtn = (TextView) findViewById(R.id.right_btn);
        this.mLine = findViewById(R.id.line);
        this.mStartBtn.setOnClickListener(this);
        this.mEndBtn.setOnClickListener(this);
        ClickEffectTouchListener r4 = new ClickEffectTouchListener(0.5f, 1.0f);
        this.mStartBtn.setOnTouchListener(r4);
        this.mEndBtn.setOnTouchListener(r4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        if (this.mOnTitleBarClickListener != null) goto L5;
        return;
    L5:
        if (r3.getId() != R.id.back_btn) goto L8;
        this.mOnTitleBarClickListener.onBackClick(r3);
        return;
    L8:
        if (r3.getId() != R.id.right_btn) goto L13;
        this.mOnTitleBarClickListener.onEndBtnClick(r3);
        return;
    }

    public void setOnTitleBarClickListener(OnTitleBarClickListener r1) {
        this.mOnTitleBarClickListener = r1;
    }

    public TextView getEndBtn() {
        return this.mEndBtn;
    }

    public ImageView getStartBtn() {
        return this.mStartBtn;
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

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getStartBtn() == null) goto L6;
        ViewExtensionsKt.expandTouchArea(getStartBtn(), OUnitExtensionKt.dp2px(44), OUnitExtensionKt.dp2px(44), false);
    L6:
        if (getEndBtn() == null) goto L9;
        ViewExtensionsKt.expandTouchArea(getEndBtn(), OUnitExtensionKt.dp2px(44), OUnitExtensionKt.dp2px(44), false);
        return;
    }

    public int getEndButtonType() {
        return this.endButtonType;
    }
}
