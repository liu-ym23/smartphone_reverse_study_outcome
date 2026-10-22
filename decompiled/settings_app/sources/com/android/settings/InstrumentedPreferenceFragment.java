package com.android.settings;

import android.content.Intent;
import android.os.Bundle;
import androidx.preference.PreferenceFragmentCompat;
import com.android.internal.logging.MetricsLogger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class InstrumentedPreferenceFragment extends PreferenceFragmentCompat {
    public int getMetricsCategory() {
        return 1;
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle r1, String r2) {
    }

    public InstrumentedPreferenceFragment() {
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

    @Override // androidx.fragment.app.Fragment
    public void startActivity(Intent r3) {
        r3.putExtra(Constants.EXTRA_OUTER, false);
        super.startActivity(r3);
    }

    @Override // androidx.fragment.app.Fragment
    public void startActivityForResult(Intent r3, int r4) {
        r3.putExtra(Constants.EXTRA_OUTER, false);
        super.startActivityForResult(r3, r4);
    }
}
