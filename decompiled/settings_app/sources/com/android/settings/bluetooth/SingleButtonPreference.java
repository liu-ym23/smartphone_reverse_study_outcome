package com.android.settings.bluetooth;

import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class SingleButtonPreference extends Preference {
    public SingleButtonPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
        setLayoutResource(R.layout.single_button_preference);
    }

    public SingleButtonPreference(Context r1) {
        super(r1);
        setLayoutResource(R.layout.single_button_preference);
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r1) {
        super.onBindViewHolder(r1);
        r1.itemView.setBackgroundResource(R.drawable.selector_setting_sub_item_bg_single);
    }
}
