package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class SettingsLayoutOuiBinding implements ViewBinding {
    public final OFloatingTitleBar appBar;
    public final FrameLayout mainContent;
    public final RecyclerView mainContentScrollableContainer;
    private final RelativeLayout rootView;
    public final RelativeLayout settingsHomepageContainer;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SettingsLayoutOuiBinding(RelativeLayout r1, OFloatingTitleBar r2, FrameLayout r3, RecyclerView r4, RelativeLayout r5) {
        this.rootView = r1;
        this.appBar = r2;
        this.mainContent = r3;
        this.mainContentScrollableContainer = r4;
        this.settingsHomepageContainer = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SettingsLayoutOuiBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SettingsLayoutOuiBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.settings_layout_oui, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SettingsLayoutOuiBinding bind(View r8) {
        int r0 = R.id.app_bar;
        OFloatingTitleBar r4 = (OFloatingTitleBar) ViewBindings.findChildViewById(r8, R.id.app_bar);
        if (r4 == null) goto L11;
        r0 = R.id.main_content;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r8, R.id.main_content);
        if (r5 == null) goto L11;
        r0 = R.id.main_content_scrollable_container;
        RecyclerView r6 = (RecyclerView) ViewBindings.findChildViewById(r8, R.id.main_content_scrollable_container);
        if (r6 == null) goto L11;
        RelativeLayout r7 = (RelativeLayout) r8;
        return new SettingsLayoutOuiBinding(r7, r4, r5, r6, r7);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
