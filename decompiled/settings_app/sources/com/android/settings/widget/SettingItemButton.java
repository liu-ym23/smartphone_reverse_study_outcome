package com.android.settings.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.android.settings.R;
import obric.widget.ListContentItemText;

/* JADX INFO: loaded from: classes.dex */
public class SettingItemButton extends ListContentItemText {
    private TextView mMiddleTitle;

    @Override // obric.widget.ListContentItem
    protected int getDefaultMidLayout() {
        return R.layout.mid_text;
    }

    public SettingItemButton(Context r2) {
        this(r2, null);
    }

    public SettingItemButton(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public SettingItemButton(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        TypedArray r6 = r3.obtainStyledAttributes(r4, R.styleable.SettingItemButton, r5, 0);
        String r7 = r6.getString(1);
        if (TextUtils.isEmpty(r7) == false) goto L5;
        r7 = r6.getString(0);
    L5:
        r6.recycle();
        if (TextUtils.isEmpty(r7) == true) goto L8;
        setTitle(r7);
    L8:
        setArrowVisible(false);
    }

    @Override // obric.widget.ListContentItem
    protected void initMidWidget() {
        this.mMiddleTitle = (TextView) findViewById(R.id.middle_text);
    }

    @Override // obric.widget.ListContentItemText, obric.widget.ListContentItem
    public void setTitle(CharSequence r1) {
        this.mMiddleTitle.setText(r1);
    }

    public void setText(int r1) {
        setTitle(r1);
    }

    public void setText(CharSequence r1) {
        setTitle(r1);
    }

    @Override // obric.widget.ListContentItem
    public TextView getTitleView() {
        return this.mMiddleTitle;
    }
}
