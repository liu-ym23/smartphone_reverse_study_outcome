package com.android.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;

/* JADX INFO: loaded from: classes2.dex */
public class HotspotPreference extends Preference implements CompoundButton.OnCheckedChangeListener {
    private Context mContext;
    private TextView mSubSummary;
    private Switch mSwitch;
    private boolean mSwitchEnabled;

    public HotspotPreference(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mContext = r1;
    }

    public HotspotPreference(Context r2, AttributeSet r3) {
        this(r2, r3, android.R.attr.switchPreferenceStyle);
        this.mContext = r2;
    }

    public HotspotPreference(Context r2) {
        this(r2, null);
        this.mContext = r2;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r3) {
        super.onBindViewHolder(r3);
        TextView r0 = (TextView) r3.findViewById(R.id.subsummary);
        this.mSubSummary = r0;
        r0.setVisibility(8);
        Switch r4 = (Switch) r3.findViewById(R.id.switchWidget);
        this.mSwitch = r4;
        r4.setOnCheckedChangeListener(this);
        setChecked(this.mSwitchEnabled);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r1, boolean r2) {
        callChangeListener(Boolean.valueOf(r2));
        this.mSwitchEnabled = r2;
    }

    @Override // androidx.preference.Preference
    public void setSummary(CharSequence r3) {
        TextView r0 = this.mSubSummary;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 == null) goto L7;
        int r1 = 0;
    L8:
        r0.setVisibility(r1);
        this.mSubSummary.setText(r3);
        return;
    L7:
        r1 = 8;
        goto L8
    }

    public void setChecked(boolean r3) {
        Switch r0 = this.mSwitch;
        if (r0 == null) goto L5;
        r0.setOnCheckedChangeListener(null);
        this.mSwitch.setChecked(r3);
        this.mSwitch.setOnCheckedChangeListener(this);
    L5:
        this.mSwitchEnabled = r3;
    }
}
