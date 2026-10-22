package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OListView;

/* JADX INFO: loaded from: classes2.dex */
public final class ManageApplicationsAppsBinding implements ViewBinding {
    public final TextView empty;
    public final OListView list;
    public final LinearLayout listContainer;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ManageApplicationsAppsBinding(LinearLayout r1, TextView r2, OListView r3, LinearLayout r4) {
        this.rootView = r1;
        this.empty = r2;
        this.list = r3;
        this.listContainer = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ManageApplicationsAppsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ManageApplicationsAppsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.manage_applications_apps, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ManageApplicationsAppsBinding bind(View r4) {
        int r0 = android.R.id.empty;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r4, android.R.id.empty);
        if (r1 == null) goto L11;
        r0 = android.R.id.list;
        OListView r2 = (OListView) ViewBindings.findChildViewById(r4, android.R.id.list);
        if (r2 == null) goto L11;
        r0 = R.id.list_container;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(r4, R.id.list_container);
        if (r3 == null) goto L11;
        return new ManageApplicationsAppsBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
