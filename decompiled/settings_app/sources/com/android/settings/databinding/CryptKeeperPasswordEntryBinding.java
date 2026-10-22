package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class CryptKeeperPasswordEntryBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final CryptKeeperStatusBinding statusLayout;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private CryptKeeperPasswordEntryBinding(RelativeLayout r1, CryptKeeperStatusBinding r2, OFloatingTitleBar r3) {
        this.rootView = r1;
        this.statusLayout = r2;
        this.viewTitle = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static CryptKeeperPasswordEntryBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static CryptKeeperPasswordEntryBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.crypt_keeper_password_entry, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static CryptKeeperPasswordEntryBinding bind(View r3) {
        int r0 = R.id.status_layout;
        View r1 = ViewBindings.findChildViewById(r3, R.id.status_layout);
        if (r1 == null) goto L10;
        CryptKeeperStatusBinding r2 = CryptKeeperStatusBinding.bind(r1);
        OFloatingTitleBar r4 = (OFloatingTitleBar) ViewBindings.findChildViewById(r3, R.id.view_title);
        if (r4 != null) goto L7;
        r0 = R.id.view_title;
        goto L10
    L7:
        return new CryptKeeperPasswordEntryBinding((RelativeLayout) r3, r2, r4);
    L10:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
