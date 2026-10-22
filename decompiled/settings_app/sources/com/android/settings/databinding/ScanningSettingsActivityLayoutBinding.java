package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class ScanningSettingsActivityLayoutBinding implements ViewBinding {
    public final FrameLayout fragmentContainerView;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ScanningSettingsActivityLayoutBinding(RelativeLayout r1, FrameLayout r2) {
        this.rootView = r1;
        this.fragmentContainerView = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ScanningSettingsActivityLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ScanningSettingsActivityLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.scanning_settings_activity_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ScanningSettingsActivityLayoutBinding bind(View r2) {
        FrameLayout r1 = (FrameLayout) ViewBindings.findChildViewById(r2, R.id.fragment_container_view);
        if (r1 == null) goto L7;
        return new ScanningSettingsActivityLayoutBinding((RelativeLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.fragment_container_view)));
    }
}
