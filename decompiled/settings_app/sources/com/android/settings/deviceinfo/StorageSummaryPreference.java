package com.android.settings.deviceinfo;

import android.content.Context;
import android.graphics.Color;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class StorageSummaryPreference extends Preference {
    private int mPercent;

    public StorageSummaryPreference(Context r1) {
        super(r1);
        this.mPercent = -1;
        setLayoutResource(R.layout.storage_summary);
        setEnabled(false);
    }

    public void setPercent(int r1) {
        this.mPercent = r1;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r4) {
        ProgressBar r0 = (ProgressBar) r4.findViewById(android.R.id.progress);
        if (this.mPercent == (-1)) goto L5;
        r0.setVisibility(0);
        r0.setProgress(this.mPercent);
    L6:
        ((TextView) r4.findViewById(android.R.id.summary)).setTextColor(Color.parseColor("#8a000000"));
        super.onBindViewHolder(r4);
        return;
    L5:
        r0.setVisibility(8);
        goto L6
    }
}
