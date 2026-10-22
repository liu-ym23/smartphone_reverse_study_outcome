package com.android.settings;

import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public abstract class OptionsMenuFragment extends InstrumentedFragment {
    public OptionsMenuFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r1) {
        super.onActivityCreated(r1);
        setHasOptionsMenu(true);
    }
}
