package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class ManageApplicationsZenaccessBinding implements ViewBinding {
    public final RecyclerView appsList;
    public final LinearLayout contentLayout;
    public final FrameLayout emptyContainer;
    private final ConstraintLayout rootView;
    public final ConstraintLayout rootViewContainer;
    public final OFloatingTitleBar viewTitle;
    public final OPageStatus zenStatusLoading;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ManageApplicationsZenaccessBinding(ConstraintLayout r1, RecyclerView r2, LinearLayout r3, FrameLayout r4, ConstraintLayout r5, OFloatingTitleBar r6, OPageStatus r7) {
        this.rootView = r1;
        this.appsList = r2;
        this.contentLayout = r3;
        this.emptyContainer = r4;
        this.rootViewContainer = r5;
        this.viewTitle = r6;
        this.zenStatusLoading = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ManageApplicationsZenaccessBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ManageApplicationsZenaccessBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.manage_applications_zenaccess, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ManageApplicationsZenaccessBinding bind(View r10) {
        int r0 = R.id.apps_list;
        RecyclerView r4 = (RecyclerView) ViewBindings.findChildViewById(r10, R.id.apps_list);
        if (r4 == null) goto L15;
        r0 = R.id.content_layout;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r10, R.id.content_layout);
        if (r5 == null) goto L15;
        r0 = R.id.empty_container;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r10, R.id.empty_container);
        if (r6 == null) goto L15;
        ConstraintLayout r7 = (ConstraintLayout) r10;
        r0 = R.id.view_title;
        OFloatingTitleBar r8 = (OFloatingTitleBar) ViewBindings.findChildViewById(r10, R.id.view_title);
        if (r8 == null) goto L15;
        r0 = R.id.zen_status_loading;
        OPageStatus r9 = (OPageStatus) ViewBindings.findChildViewById(r10, R.id.zen_status_loading);
        if (r9 == null) goto L15;
        return new ManageApplicationsZenaccessBinding(r7, r4, r5, r6, r7, r8, r9);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
