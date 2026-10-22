package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class ManageApplicationsAppsUnsupportedBinding implements ViewBinding {
    public final TextView emptyBody;
    public final TextView emptyHeader;
    public final FrameLayout pinnedHeader;
    private final CoordinatorLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ManageApplicationsAppsUnsupportedBinding(CoordinatorLayout r1, TextView r2, TextView r3, FrameLayout r4) {
        this.rootView = r1;
        this.emptyBody = r2;
        this.emptyHeader = r3;
        this.pinnedHeader = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    public static ManageApplicationsAppsUnsupportedBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ManageApplicationsAppsUnsupportedBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.manage_applications_apps_unsupported, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ManageApplicationsAppsUnsupportedBinding bind(View r4) {
        int r0 = R.id.empty_body;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r4, R.id.empty_body);
        if (r1 == null) goto L11;
        r0 = R.id.empty_header;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r4, R.id.empty_header);
        if (r2 == null) goto L11;
        r0 = R.id.pinned_header;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(r4, R.id.pinned_header);
        if (r3 == null) goto L11;
        return new ManageApplicationsAppsUnsupportedBinding((CoordinatorLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
