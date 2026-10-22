package com.android.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.settings.base.BaseFragment;

/* JADX INFO: loaded from: classes2.dex */
public class EmptyFragment extends BaseFragment {
    public EmptyFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.empty_fragment_layout, r3, false);
        return this.mRootView;
    }
}
