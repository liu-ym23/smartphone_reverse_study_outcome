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
public final class ManageAccountsScreenBinding implements ViewBinding {
    public final OListView list;
    private final LinearLayout rootView;
    public final TextView syncSettingsErrorInfo;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ManageAccountsScreenBinding(LinearLayout r1, OListView r2, TextView r3) {
        this.rootView = r1;
        this.list = r2;
        this.syncSettingsErrorInfo = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ManageAccountsScreenBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ManageAccountsScreenBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.manage_accounts_screen, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ManageAccountsScreenBinding bind(View r3) {
        int r0 = android.R.id.list;
        OListView r1 = (OListView) ViewBindings.findChildViewById(r3, android.R.id.list);
        if (r1 == null) goto L9;
        r0 = R.id.sync_settings_error_info;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r3, R.id.sync_settings_error_info);
        if (r2 == null) goto L9;
        return new ManageAccountsScreenBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
