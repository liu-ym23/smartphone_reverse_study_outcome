package com.qihoo360.mobilesafe.common.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.qihoo360.mobilesafe.common.ui.R;
import com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow;
import com.qihoo360.mobilesafe.common.ui.env.ViewTAG;
import com.qihoo360.mobilesafe.common.ui.ripple.CommonRippleButton;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CommonBtnBase extends RelativeLayout implements IBtnRow {
    private Paint debugPaint;
    protected CommonRippleButton mUILeftBtn;
    protected CommonRippleButton mUIRightBtn;
    protected ImageView mUISelectedView;

    protected abstract int getLayoutResId();

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public Object getUILeftButtonTag(int r1) throws NotSupportMethodException {
        return null;
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public Object getUIRightButtonTag(int r1) throws NotSupportMethodException {
        return null;
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public boolean isUIRightChecked() throws NotSupportMethodException {
        return false;
    }

    @Override // android.view.View
    @Deprecated
    public void setOnClickListener(View.OnClickListener r1) {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public void setUIBackGroundColor(int r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public void setUILeftBtnStyle(int r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public void setUILeftButtonClickListener(View.OnClickListener r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public void setUILeftButtonEnabled(boolean r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public void setUILeftButtonTag(int r1, Object r2) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public void setUILeftButtonText(int r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public void setUILeftButtonText(CharSequence r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public void setUILeftButtonVisible(boolean r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public void setUIRightBtnStyle(int r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public void setUIRightButtonClickListener(View.OnClickListener r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public void setUIRightButtonEnabled(boolean r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public void setUIRightButtonTag(int r1, Object r2) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public void setUIRightButtonText(int r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public void setUIRightButtonText(CharSequence r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public void setUIRightChecked(boolean r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public void setUIRightSelectedListener(View.OnClickListener r1) throws NotSupportMethodException {
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public void setUIRightSelectedVisible(boolean r1) throws NotSupportMethodException {
    }

    public CommonBtnBase(Context r1) {
        super(r1);
        init();
    }

    public CommonBtnBase(Context r1, AttributeSet r2) {
        super(r1, r2);
        init();
    }

    public CommonBtnBase(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        init();
    }

    private void init() {
        setBackgroundResource(R.color.inner_common_bg_color_2);
        int r0 = getLayoutResId();
        if (r0 != 0) goto L5;
        return;
    L5:
        inflate(getContext(), r0, this);
        ViewTAG.ROW_BTN_TAG r1 = ViewTAG.getRowBtnTag(getContext());
        this.mUILeftBtn = (CommonRippleButton) findViewWithTag(r1.ROW_BTN_TAG_LEFT_BTN);
        this.mUIRightBtn = (CommonRippleButton) findViewWithTag(r1.ROW_BTN_TAG_RIGHT_BTN);
        this.mUISelectedView = (ImageView) findViewWithTag(r1.ROW_BTN_TAG_SELECT_VIEW);
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        CommonRippleButton r0 = this.mUILeftBtn;
        if (r0 == null) goto L5;
        r0.setEnabled(r2);
    L5:
        CommonRippleButton r1 = this.mUIRightBtn;
        if (r1 == null) goto L8;
        r1.setEnabled(r2);
    L8:
        ImageView r3 = this.mUISelectedView;
        if (r3 == null) goto L12;
        r3.setEnabled(r2);
        return;
    }

    protected void parseStyleToButton(Button r4, int r5) {
        TypedArray r3 = getContext().obtainStyledAttributes(r5, R.styleable.Btn);
        r4.setBackgroundDrawable(r3.getDrawable(R.styleable.Btn_btnBackground));
        r4.setTextColor(r3.getColorStateList(R.styleable.Btn_btnTextColor));
        r4.setPadding(r3.getDimensionPixelOffset(R.styleable.Btn_btnPaddingLeft, r4.getPaddingLeft()), r4.getPaddingTop(), r3.getDimensionPixelOffset(R.styleable.Btn_btnPaddingRight, r4.getPaddingRight()), r4.getPaddingBottom());
        r3.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r1) {
        super.dispatchDraw(r1);
    }
}
