package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OListItemSettings;

/* JADX INFO: loaded from: classes2.dex */
public final class EyesProtectionCloseItemBinding implements ViewBinding {
    public final OListItemSettings closeToday;
    public final OListItemSettings closeTotally;
    public final LinearLayout pageContainer;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private EyesProtectionCloseItemBinding(RelativeLayout r1, OListItemSettings r2, OListItemSettings r3, LinearLayout r4) {
        this.rootView = r1;
        this.closeToday = r2;
        this.closeTotally = r3;
        this.pageContainer = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static EyesProtectionCloseItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static EyesProtectionCloseItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.eyes_protection_close_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static EyesProtectionCloseItemBinding bind(View r4) {
        int r0 = R.id.close_today;
        OListItemSettings r1 = (OListItemSettings) ViewBindings.findChildViewById(r4, R.id.close_today);
        if (r1 == null) goto L11;
        r0 = R.id.close_totally;
        OListItemSettings r2 = (OListItemSettings) ViewBindings.findChildViewById(r4, R.id.close_totally);
        if (r2 == null) goto L11;
        r0 = R.id.page_container;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(r4, R.id.page_container);
        if (r3 == null) goto L11;
        return new EyesProtectionCloseItemBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
