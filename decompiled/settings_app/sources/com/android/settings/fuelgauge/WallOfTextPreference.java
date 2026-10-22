package com.android.settings.fuelgauge;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.DividerPreference;

/* JADX INFO: loaded from: classes2.dex */
public class WallOfTextPreference extends DividerPreference {
    private static final int MAX_LINES = 20;

    public WallOfTextPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // com.android.settings.DividerPreference, androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r1) {
        super.onBindViewHolder(r1);
        TextView r0 = (TextView) r1.findViewById(R.id.summary);
        if (r0 == null) goto L6;
        r0.setMaxLines(20);
        return;
    }
}
