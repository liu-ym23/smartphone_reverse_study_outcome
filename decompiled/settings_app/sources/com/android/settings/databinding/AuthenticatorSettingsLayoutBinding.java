package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.button.OButton;

/* JADX INFO: loaded from: classes2.dex */
public final class AuthenticatorSettingsLayoutBinding implements ViewBinding {
    public final LinearLayout authenticatorContainer;
    public final FrameLayout btnLayout;
    private final LinearLayout rootView;
    public final OButton syncBtn;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AuthenticatorSettingsLayoutBinding(LinearLayout r1, LinearLayout r2, FrameLayout r3, OButton r4) {
        this.rootView = r1;
        this.authenticatorContainer = r2;
        this.btnLayout = r3;
        this.syncBtn = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AuthenticatorSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AuthenticatorSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.authenticator_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AuthenticatorSettingsLayoutBinding bind(View r4) {
        int r0 = R.id.authenticator_container;
        LinearLayout r1 = (LinearLayout) ViewBindings.findChildViewById(r4, R.id.authenticator_container);
        if (r1 == null) goto L11;
        r0 = R.id.btnLayout;
        FrameLayout r2 = (FrameLayout) ViewBindings.findChildViewById(r4, R.id.btnLayout);
        if (r2 == null) goto L11;
        r0 = R.id.sync_btn;
        OButton r3 = (OButton) ViewBindings.findChildViewById(r4, R.id.sync_btn);
        if (r3 == null) goto L11;
        return new AuthenticatorSettingsLayoutBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
