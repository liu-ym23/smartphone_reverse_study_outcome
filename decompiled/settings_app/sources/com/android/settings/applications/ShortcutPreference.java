package com.android.settings.applications;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.preference.Preference;
import com.android.settings.SettingsActivity;
import com.android.settings.Utils;

/* JADX INFO: loaded from: classes2.dex */
public class ShortcutPreference extends Preference {
    private final String mPrefKey;
    private final Class mTarget;
    private final int mTitle;

    public ShortcutPreference(Context r1, Class r2, String r3, int r4, int r5) {
        super(r1);
        this.mTarget = r2;
        this.mPrefKey = r3;
        this.mTitle = r5;
        setTitle(r4);
        setKey(r3);
    }

    @Override // androidx.preference.Preference
    public void performClick() {
        super.performClick();
        Bundle r2 = new Bundle();
        r2.putString(SettingsActivity.EXTRA_FRAGMENT_ARG_KEY, this.mPrefKey);
        Fragment r4 = (Fragment) null;
        Utils.startWithFragment(getContext(), this.mTarget.getName(), r2, null, 0, this.mTitle, null);
    }
}
