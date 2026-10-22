package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OListItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class SpecialAccessCommonPermissionDetailsBinding implements ViewBinding {
    public final OListItemSwitch itemSwitch;
    public final LinearLayout loadingContainer;
    private final RelativeLayout rootView;
    public final TextView tvDesc;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SpecialAccessCommonPermissionDetailsBinding(RelativeLayout r1, OListItemSwitch r2, LinearLayout r3, TextView r4) {
        this.rootView = r1;
        this.itemSwitch = r2;
        this.loadingContainer = r3;
        this.tvDesc = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SpecialAccessCommonPermissionDetailsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SpecialAccessCommonPermissionDetailsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.special_access_common_permission_details, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SpecialAccessCommonPermissionDetailsBinding bind(View r4) {
        int r0 = R.id.item_switch;
        OListItemSwitch r1 = (OListItemSwitch) ViewBindings.findChildViewById(r4, R.id.item_switch);
        if (r1 == null) goto L11;
        r0 = R.id.loading_container;
        LinearLayout r2 = (LinearLayout) ViewBindings.findChildViewById(r4, R.id.loading_container);
        if (r2 == null) goto L11;
        r0 = R.id.tv_desc;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r4, R.id.tv_desc);
        if (r3 == null) goto L11;
        return new SpecialAccessCommonPermissionDetailsBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
