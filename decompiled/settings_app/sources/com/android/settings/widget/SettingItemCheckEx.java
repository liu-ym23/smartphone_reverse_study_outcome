package com.android.settings.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes.dex */
public class SettingItemCheckEx extends RelativeLayout {
    private CheckBox mCheckbox;
    private TextView mSummaryView;
    private TextView mTitleView;

    public SettingItemCheckEx(Context r2) {
        this(r2, null);
    }

    public SettingItemCheckEx(Context r2, AttributeSet r3) {
        this(r2, r3, -1);
    }

    public SettingItemCheckEx(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        View r4 = LayoutInflater.from(r1).inflate(R.layout.setting_item_check_ex, this, true);
        this.mTitleView = (TextView) r4.findViewById(R.id.title);
        this.mSummaryView = (TextView) r4.findViewById(R.id.summary);
        this.mCheckbox = (CheckBox) r4.findViewById(R.id.checkbox);
    }

    public boolean isChecked() {
        return this.mCheckbox.isChecked();
    }

    public void setChecked(boolean r1) {
        this.mCheckbox.setChecked(r1);
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener r1) {
        this.mCheckbox.setOnCheckedChangeListener(r1);
    }

    public void setTitle(CharSequence r1) {
        TextView r0 = this.mTitleView;
        if (r0 == null) goto L6;
        r0.setText(r1);
        return;
    }

    public void setTitle(int r2) {
        setTitle(getContext().getString(r2));
    }

    public void setSummary(CharSequence r2) {
        TextView r0 = this.mSummaryView;
        if (r0 == null) goto L10;
        r0.setText(r2);
        TextView r1 = this.mSummaryView;
        if (TextUtils.isEmpty(r2) == false) goto L7;
        int r3 = 8;
    L8:
        r1.setVisibility(r3);
        return;
    L7:
        r3 = 0;
        goto L8
    }

    public void setSummary(int r2) {
        setSummary(getContext().getString(r2));
    }

    public void setCheckboxEnabled(boolean r1) {
        this.mCheckbox.setEnabled(r1);
    }
}
