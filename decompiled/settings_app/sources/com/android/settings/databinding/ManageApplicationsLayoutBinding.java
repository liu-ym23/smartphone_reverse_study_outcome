package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.SettingsListView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class ManageApplicationsLayoutBinding implements ViewBinding {
    public final TextView emptyTitle;
    public final SettingsListView listView;
    public final RelativeLayout preferredEmpty;
    private final RelativeLayout rootView;
    public final TextView viewEmpty;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ManageApplicationsLayoutBinding(RelativeLayout r1, TextView r2, SettingsListView r3, RelativeLayout r4, TextView r5, OFloatingTitleBar r6) {
        this.rootView = r1;
        this.emptyTitle = r2;
        this.listView = r3;
        this.preferredEmpty = r4;
        this.viewEmpty = r5;
        this.viewTitle = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ManageApplicationsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ManageApplicationsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.manage_applications_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ManageApplicationsLayoutBinding bind(View r9) {
        int r0 = R.id.empty_title;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r9, R.id.empty_title);
        if (r4 == null) goto L15;
        r0 = R.id.listView;
        SettingsListView r5 = (SettingsListView) ViewBindings.findChildViewById(r9, R.id.listView);
        if (r5 == null) goto L15;
        r0 = R.id.preferred_empty;
        RelativeLayout r6 = (RelativeLayout) ViewBindings.findChildViewById(r9, R.id.preferred_empty);
        if (r6 == null) goto L15;
        r0 = R.id.view_empty;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r9, R.id.view_empty);
        if (r7 == null) goto L15;
        r0 = R.id.view_title;
        OFloatingTitleBar r8 = (OFloatingTitleBar) ViewBindings.findChildViewById(r9, R.id.view_title);
        if (r8 == null) goto L15;
        return new ManageApplicationsLayoutBinding((RelativeLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
