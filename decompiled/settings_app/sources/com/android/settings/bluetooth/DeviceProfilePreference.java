package com.android.settings.bluetooth;

import android.content.Context;
import android.preference.CheckBoxPreference;
import android.util.AttributeSet;
import android.view.View;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceProfilePreference extends CheckBoxPreference {
    public DeviceProfilePreference(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public DeviceProfilePreference(Context r1) {
        super(r1);
    }

    @Override // android.preference.CheckBoxPreference, android.preference.Preference
    protected void onBindView(View r1) {
        super.onBindView(r1);
        r1.setBackgroundResource(R.drawable.selector_setting_sub_item_bg_middle);
    }
}
