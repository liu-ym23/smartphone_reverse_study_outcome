package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.internal.widget.LinearLayoutWithDefaultTouchRecepient;
import com.android.settings.R;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class CryptKeeperPatternEntryBinding implements ViewBinding {
    public final TextView footerText;
    private final RelativeLayout rootView;
    public final TextView status;
    public final LinearLayoutWithDefaultTouchRecepient topLayout;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private CryptKeeperPatternEntryBinding(RelativeLayout r1, TextView r2, TextView r3, LinearLayoutWithDefaultTouchRecepient r4, OFloatingTitleBar r5) {
        this.rootView = r1;
        this.footerText = r2;
        this.status = r3;
        this.topLayout = r4;
        this.viewTitle = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static CryptKeeperPatternEntryBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static CryptKeeperPatternEntryBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.crypt_keeper_pattern_entry, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static CryptKeeperPatternEntryBinding bind(View r8) {
        int r0 = R.id.footerText;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r8, R.id.footerText);
        if (r4 == null) goto L13;
        r0 = R.id.status;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r8, R.id.status);
        if (r5 == null) goto L13;
        r0 = R.id.topLayout;
        LinearLayoutWithDefaultTouchRecepient r6 = ViewBindings.findChildViewById(r8, R.id.topLayout);
        if (r6 == null) goto L13;
        r0 = R.id.view_title;
        OFloatingTitleBar r7 = (OFloatingTitleBar) ViewBindings.findChildViewById(r8, R.id.view_title);
        if (r7 == null) goto L13;
        return new CryptKeeperPatternEntryBinding((RelativeLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
