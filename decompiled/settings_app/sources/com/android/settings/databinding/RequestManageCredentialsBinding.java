package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.button.OButton;

/* JADX INFO: loaded from: classes2.dex */
public final class RequestManageCredentialsBinding implements ViewBinding {
    public final Button allowButton;
    public final RecyclerView appsList;
    public final LinearLayout buttonPanel;
    public final Button dontAllowButton;
    public final OButton extendedFab;
    private final CoordinatorLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RequestManageCredentialsBinding(CoordinatorLayout r1, Button r2, RecyclerView r3, LinearLayout r4, Button r5, OButton r6) {
        this.rootView = r1;
        this.allowButton = r2;
        this.appsList = r3;
        this.buttonPanel = r4;
        this.dontAllowButton = r5;
        this.extendedFab = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    public static RequestManageCredentialsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RequestManageCredentialsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.request_manage_credentials, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RequestManageCredentialsBinding bind(View r9) {
        int r0 = R.id.allow_button;
        Button r4 = (Button) ViewBindings.findChildViewById(r9, R.id.allow_button);
        if (r4 == null) goto L15;
        r0 = R.id.apps_list;
        RecyclerView r5 = (RecyclerView) ViewBindings.findChildViewById(r9, R.id.apps_list);
        if (r5 == null) goto L15;
        r0 = R.id.button_panel;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r9, R.id.button_panel);
        if (r6 == null) goto L15;
        r0 = R.id.dont_allow_button;
        Button r7 = (Button) ViewBindings.findChildViewById(r9, R.id.dont_allow_button);
        if (r7 == null) goto L15;
        r0 = R.id.extended_fab;
        OButton r8 = (OButton) ViewBindings.findChildViewById(r9, R.id.extended_fab);
        if (r8 == null) goto L15;
        return new RequestManageCredentialsBinding((CoordinatorLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
