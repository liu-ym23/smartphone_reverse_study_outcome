package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.actionbar.v2.OBottomActionBarNormalVertical;
import com.obric.oui.bouncelayout.OListView;

/* JADX INFO: loaded from: classes2.dex */
public final class AccountSyncScreenBinding implements ViewBinding {
    public final OBottomActionBarNormalVertical bottomActionBar;
    public final LinearLayout listContent;
    private final LinearLayout rootView;
    public final TextView syncSettingsErrorInfo;
    public final OListView viewList;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AccountSyncScreenBinding(LinearLayout r1, OBottomActionBarNormalVertical r2, LinearLayout r3, TextView r4, OListView r5) {
        this.rootView = r1;
        this.bottomActionBar = r2;
        this.listContent = r3;
        this.syncSettingsErrorInfo = r4;
        this.viewList = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AccountSyncScreenBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AccountSyncScreenBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.account_sync_screen, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AccountSyncScreenBinding bind(View r8) {
        int r0 = R.id.bottom_action_bar;
        OBottomActionBarNormalVertical r4 = (OBottomActionBarNormalVertical) ViewBindings.findChildViewById(r8, R.id.bottom_action_bar);
        if (r4 == null) goto L11;
        LinearLayout r5 = (LinearLayout) r8;
        r0 = R.id.sync_settings_error_info;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r8, R.id.sync_settings_error_info);
        if (r6 == null) goto L11;
        r0 = R.id.view_list;
        OListView r7 = (OListView) ViewBindings.findChildViewById(r8, R.id.view_list);
        if (r7 == null) goto L11;
        return new AccountSyncScreenBinding(r5, r4, r5, r6, r7);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
