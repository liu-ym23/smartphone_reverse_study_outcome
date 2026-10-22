package com.android.settings;

import android.os.Bundle;
import androidx.preference.PreferenceFragmentCompat;
import com.android.internal.logging.MetricsLogger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class InstrumentedFragment extends PreferenceFragmentCompat {
    public static final int PREFERENCE_ACTIVITY_FRAGMENT = 100001;
    public static final int UNDECLARED = 100000;

    protected int getMetricsCategory() {
        return 1;
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle r1, String r2) {
    }

    public InstrumentedFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        MetricsLogger.visible(getActivity(), getMetricsCategory());
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        MetricsLogger.hidden(getActivity(), getMetricsCategory());
    }
}
