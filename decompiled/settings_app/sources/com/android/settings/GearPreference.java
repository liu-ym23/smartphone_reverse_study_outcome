package com.android.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.preference.PreferenceViewHolder;
import com.android.settingslib.RestrictedPreference;

/* JADX INFO: loaded from: classes2.dex */
public class GearPreference extends RestrictedPreference implements View.OnClickListener {
    private OnGearClickListener mOnGearClickListener;

    public interface OnGearClickListener {
        void onGearClick(GearPreference r1);
    }

    public GearPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
        setWidgetLayoutResource(R.layout.preference_widget_settings);
    }

    public void setOnGearClickListener(OnGearClickListener r1) {
        this.mOnGearClickListener = r1;
        notifyChanged();
    }

    @Override // com.android.settingslib.RestrictedPreference, com.android.settingslib.widget.TwoTargetPreference, androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r2) {
        super.onBindViewHolder(r2);
        View r3 = r2.findViewById(R.id.settings_button);
        r3.setOnClickListener(this);
        r3.setEnabled(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2.getId() != R.id.settings_button) goto L8;
        OnGearClickListener r3 = this.mOnGearClickListener;
        if (r3 == null) goto L9;
        r3.onGearClick(this);
        return;
    L9:
        return;
    }
}
