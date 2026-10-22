package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.setupwizardlib.view.NavigationBar;

/* JADX INFO: loaded from: classes2.dex */
public final class AccessibilitySettingsForSuwBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final FrameLayout suwMainContent;
    public final NavigationBar suwNavigationBar;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AccessibilitySettingsForSuwBinding(LinearLayout r1, FrameLayout r2, NavigationBar r3) {
        this.rootView = r1;
        this.suwMainContent = r2;
        this.suwNavigationBar = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AccessibilitySettingsForSuwBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AccessibilitySettingsForSuwBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.accessibility_settings_for_suw, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AccessibilitySettingsForSuwBinding bind(View r3) {
        int r0 = R.id.suw_main_content;
        FrameLayout r1 = (FrameLayout) ViewBindings.findChildViewById(r3, R.id.suw_main_content);
        if (r1 == null) goto L9;
        r0 = R.id.suw_navigation_bar;
        NavigationBar r2 = (NavigationBar) ViewBindings.findChildViewById(r3, R.id.suw_navigation_bar);
        if (r2 == null) goto L9;
        return new AccessibilitySettingsForSuwBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
