package com.bytedanceos.preventdisturb.widget;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedanceos.numberassistant.xysdk.XySdkParserItem;

/* JADX INFO: loaded from: classes2.dex */
public class MyURLSpan extends ClickableSpan {
    private boolean mEnable;
    private boolean mIsPressed;
    private int mLinkColor;
    private OnClickListener mListener;
    private int mPressedBgColor;
    private String mSpan;
    private XySdkParserItem.UrlItem mUrlItem;

    public interface OnClickListener {
        boolean onClick(MyURLSpan span);
    }

    public MyURLSpan(String span, OnClickListener listener) {
        this.mEnable = true;
        this.mIsPressed = false;
        this.mLinkColor = 0;
        this.mSpan = span;
        this.mListener = listener;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint ds) {
        if (this.mIsPressed == false) goto L5;
        int r0 = this.mPressedBgColor;
    L6:
        ds.bgColor = r0;
        int r1 = this.mLinkColor;
        if (r1 <= 0) goto L9;
        ds.linkColor = r1;
    L9:
        super.updateDrawState(ds);
        return;
    L5:
        r0 = 0;
        goto L6
    }

    public void setLinkColor(int linkColor) {
        this.mLinkColor = linkColor;
    }

    public void setPressed(boolean isPressed, int pressedBgColor) {
        this.mIsPressed = isPressed;
        this.mPressedBgColor = pressedBgColor;
    }

    public void setEnable(boolean enable) {
        this.mEnable = enable;
    }

    public void setUrlItem(XySdkParserItem.UrlItem urlItem) {
        this.mUrlItem = urlItem;
    }

    public XySdkParserItem.UrlItem getUrlItem() {
        return this.mUrlItem;
    }

    public String getSpanString() {
        return this.mSpan;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View v) {
        if (this.mEnable == false) goto L9;
        OnClickListener r0 = this.mListener;
        if (r0 == null) goto L9;
        if (r0.onClick(this) == false) goto L9;
        return;
    L9:
        if (v != null) goto L11;
        return;
    L11:
        if (v.isEnabled() == true) goto L13;
        return;
    L13:
        if (v.isClickable() == false) goto L18;
        v.performClick();
        return;
    }
}
