package com.android.settings;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.preference.PreferenceViewHolder;
import com.android.settingslib.RestrictedPreference;

/* JADX INFO: loaded from: classes2.dex */
public class SingleLineSummaryPreference extends RestrictedPreference {
    public SingleLineSummaryPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // com.android.settingslib.RestrictedPreference, com.android.settingslib.widget.TwoTargetPreference, androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r1) {
        super.onBindViewHolder(r1);
        TextView r0 = (TextView) r1.findViewById(android.R.id.summary);
        r0.setSingleLine();
        r0.setEllipsize(TextUtils.TruncateAt.END);
    }
}
