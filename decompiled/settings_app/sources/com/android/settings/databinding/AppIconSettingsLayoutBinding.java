package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.stickylistheaders.StickyListHeadersListView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class AppIconSettingsLayoutBinding implements ViewBinding {
    public final TextView emptyView;
    public final StickyListHeadersListView iconsListView;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AppIconSettingsLayoutBinding(RelativeLayout r1, TextView r2, StickyListHeadersListView r3, OFloatingTitleBar r4) {
        this.rootView = r1;
        this.emptyView = r2;
        this.iconsListView = r3;
        this.viewTitle = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AppIconSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AppIconSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.app_icon_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AppIconSettingsLayoutBinding bind(View r4) {
        int r0 = R.id.empty_view;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r4, R.id.empty_view);
        if (r1 == null) goto L11;
        r0 = R.id.icons_list_view;
        StickyListHeadersListView r2 = (StickyListHeadersListView) ViewBindings.findChildViewById(r4, R.id.icons_list_view);
        if (r2 == null) goto L11;
        r0 = R.id.view_title;
        OFloatingTitleBar r3 = (OFloatingTitleBar) ViewBindings.findChildViewById(r4, R.id.view_title);
        if (r3 == null) goto L11;
        return new AppIconSettingsLayoutBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
