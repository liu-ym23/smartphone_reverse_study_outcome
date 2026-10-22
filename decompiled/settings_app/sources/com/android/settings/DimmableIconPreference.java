package com.android.settings;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.preference.PreferenceViewHolder;
import com.android.settingslib.RestrictedPreference;

/* JADX INFO: loaded from: classes2.dex */
public class DimmableIconPreference extends RestrictedPreference {
    private static final int ICON_ALPHA_DISABLED = 102;
    private static final int ICON_ALPHA_ENABLED = 255;
    private final CharSequence mContentDescription;

    public DimmableIconPreference(Context r3) {
        AttributeSet r1 = (AttributeSet) null;
        this(r3, null);
    }

    public DimmableIconPreference(Context r1, AttributeSet r2, int r3, CharSequence r4) {
        super(r1, r2, r3);
        this.mContentDescription = r4;
    }

    public DimmableIconPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mContentDescription = null;
        useAdminDisabledSummary(true);
    }

    public DimmableIconPreference(Context r1, CharSequence r2) {
        super(r1);
        this.mContentDescription = r2;
        useAdminDisabledSummary(true);
    }

    protected void dimIcon(boolean r3) {
        Drawable r0 = getIcon();
        if (r0 == null) goto L10;
        Drawable r1 = r0.mutate();
        if (r3 == false) goto L7;
        int r4 = 102;
    L8:
        r1.setAlpha(r4);
        setIcon(r0);
        return;
    L7:
        r4 = 255;
        goto L8
    }

    @Override // com.android.settingslib.RestrictedPreference, com.android.settingslib.widget.TwoTargetPreference, androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r2) {
        super.onBindViewHolder(r2);
        if (TextUtils.isEmpty(this.mContentDescription) == true) goto L5;
        ((TextView) r2.findViewById(android.R.id.title)).setContentDescription(this.mContentDescription);
    L5:
        dimIcon(!isEnabled());
    }
}
