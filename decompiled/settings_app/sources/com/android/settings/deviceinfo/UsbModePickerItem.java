package com.android.settings.deviceinfo;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class UsbModePickerItem extends LinearLayout {
    private RadioButton mRadioBtn;
    private TextView mSummary;
    private TextView mTitle;

    public UsbModePickerItem(Context r4, AttributeSet r5, int r6) {
        super(r4, r5, r6);
        View r0 = LayoutInflater.from(r4).inflate(R.layout.usb_mode_picker_item, this, true);
        this.mRadioBtn = (RadioButton) r0.findViewById(R.id.radio);
        this.mTitle = (TextView) r0.findViewById(R.id.title);
        this.mSummary = (TextView) r0.findViewById(R.id.summary);
        TypedArray r7 = r4.obtainStyledAttributes(r5, R.styleable.UsbModePickerItem, r6, 0);
        CharSequence r8 = r7.getText(1);
        if (r8 == null) goto L5;
        this.mTitle.setText(r8);
    L5:
        CharSequence r9 = r7.getText(0);
        if (r9 == null) goto L8;
        this.mSummary.setText(r9);
    L8:
        r7.recycle();
    }

    public UsbModePickerItem(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public UsbModePickerItem(Context r2) {
        this(r2, null);
    }

    public void setChecked(boolean r1) {
        this.mRadioBtn.setChecked(r1);
    }

    public void setTitle(String r1) {
        this.mTitle.setText(r1);
    }

    public void setSummary(String r1) {
        this.mSummary.setText(r1);
    }
}
