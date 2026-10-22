package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.button.OButton;

/* JADX INFO: loaded from: classes2.dex */
public final class AccountSyncSettingsFooterViewBinding implements ViewBinding {
    public final OButton buttonDelete;
    public final OButton buttonSync;
    private final LinearLayout rootView;
    public final LinearLayout syncBtnLayout;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AccountSyncSettingsFooterViewBinding(LinearLayout r1, OButton r2, OButton r3, LinearLayout r4) {
        this.rootView = r1;
        this.buttonDelete = r2;
        this.buttonSync = r3;
        this.syncBtnLayout = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AccountSyncSettingsFooterViewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AccountSyncSettingsFooterViewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.account_sync_settings_footer_view, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AccountSyncSettingsFooterViewBinding bind(View r4) {
        int r0 = R.id.button_delete;
        OButton r1 = (OButton) ViewBindings.findChildViewById(r4, R.id.button_delete);
        if (r1 == null) goto L11;
        r0 = R.id.button_sync;
        OButton r2 = (OButton) ViewBindings.findChildViewById(r4, R.id.button_sync);
        if (r2 == null) goto L11;
        r0 = R.id.sync_btn_layout;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(r4, R.id.sync_btn_layout);
        if (r3 == null) goto L11;
        return new AccountSyncSettingsFooterViewBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
