package com.android.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.preference.PreferenceViewHolder;

/* JADX INFO: loaded from: classes2.dex */
public class AppProgressPreference extends TintablePreference {
    private int mProgress;

    public AppProgressPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
        setLayoutResource(R.layout.preference_app);
        setWidgetLayoutResource(R.layout.widget_progress_bar);
    }

    public void setProgress(int r1) {
        this.mProgress = r1;
        notifyChanged();
    }

    @Override // com.android.settings.TintablePreference, androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r2) {
        super.onBindViewHolder(r2);
        ((ProgressBar) r2.findViewById(android.R.id.progress)).setProgress(this.mProgress);
    }
}
