package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class ManageApplicationsApps2Binding implements ViewBinding {
    public final RecyclerView appsList;
    public final LinearLayout contentLayout;
    public final FrameLayout ctsItemContainer;
    public final OSwitch ctsItemSwitch;
    public final TextView ctsItemTv;
    public final FrameLayout emptyContainer;
    public final OPageStatus managerStatusLoading;
    public final FrameLayout pinnedHeader;
    private final ConstraintLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ManageApplicationsApps2Binding(ConstraintLayout r1, RecyclerView r2, LinearLayout r3, FrameLayout r4, OSwitch r5, TextView r6, FrameLayout r7, OPageStatus r8, FrameLayout r9, OFloatingTitleBar r10) {
        this.rootView = r1;
        this.appsList = r2;
        this.contentLayout = r3;
        this.ctsItemContainer = r4;
        this.ctsItemSwitch = r5;
        this.ctsItemTv = r6;
        this.emptyContainer = r7;
        this.managerStatusLoading = r8;
        this.pinnedHeader = r9;
        this.viewTitle = r10;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ManageApplicationsApps2Binding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ManageApplicationsApps2Binding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.manage_applications_apps2, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ManageApplicationsApps2Binding bind(View r13) {
        int r0 = R.id.apps_list;
        RecyclerView r4 = (RecyclerView) ViewBindings.findChildViewById(r13, R.id.apps_list);
        if (r4 == null) goto L23;
        r0 = R.id.content_layout;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r13, R.id.content_layout);
        if (r5 == null) goto L23;
        r0 = R.id.cts_item_container;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r13, R.id.cts_item_container);
        if (r6 == null) goto L23;
        r0 = R.id.cts_item_switch;
        OSwitch r7 = (OSwitch) ViewBindings.findChildViewById(r13, R.id.cts_item_switch);
        if (r7 == null) goto L23;
        r0 = R.id.cts_item_tv;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r13, R.id.cts_item_tv);
        if (r8 == null) goto L23;
        r0 = R.id.empty_container;
        FrameLayout r9 = (FrameLayout) ViewBindings.findChildViewById(r13, R.id.empty_container);
        if (r9 == null) goto L23;
        r0 = R.id.manager_status_loading;
        OPageStatus r10 = (OPageStatus) ViewBindings.findChildViewById(r13, R.id.manager_status_loading);
        if (r10 == null) goto L23;
        r0 = R.id.pinned_header;
        FrameLayout r11 = (FrameLayout) ViewBindings.findChildViewById(r13, R.id.pinned_header);
        if (r11 == null) goto L23;
        r0 = R.id.view_title;
        OFloatingTitleBar r12 = (OFloatingTitleBar) ViewBindings.findChildViewById(r13, R.id.view_title);
        if (r12 == null) goto L23;
        return new ManageApplicationsApps2Binding((ConstraintLayout) r13, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r0)));
    }
}
