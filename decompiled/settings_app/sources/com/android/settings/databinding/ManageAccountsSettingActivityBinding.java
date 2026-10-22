package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class ManageAccountsSettingActivityBinding implements ViewBinding {
    public final View fakeStatusBar;
    public final FragmentContainerView manageAccountFragment;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ManageAccountsSettingActivityBinding(RelativeLayout r1, View r2, FragmentContainerView r3, OFloatingTitleBar r4) {
        this.rootView = r1;
        this.fakeStatusBar = r2;
        this.manageAccountFragment = r3;
        this.viewTitle = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ManageAccountsSettingActivityBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ManageAccountsSettingActivityBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.manage_accounts_setting_activity, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ManageAccountsSettingActivityBinding bind(View r4) {
        int r0 = R.id.fake_status_bar;
        View r1 = ViewBindings.findChildViewById(r4, R.id.fake_status_bar);
        if (r1 == null) goto L11;
        r0 = R.id.manage_account_fragment;
        FragmentContainerView r2 = (FragmentContainerView) ViewBindings.findChildViewById(r4, R.id.manage_account_fragment);
        if (r2 == null) goto L11;
        r0 = R.id.view_title;
        OFloatingTitleBar r3 = (OFloatingTitleBar) ViewBindings.findChildViewById(r4, R.id.view_title);
        if (r3 == null) goto L11;
        return new ManageAccountsSettingActivityBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
