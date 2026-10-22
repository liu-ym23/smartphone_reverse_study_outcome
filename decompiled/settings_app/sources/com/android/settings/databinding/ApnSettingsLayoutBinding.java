package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OListView;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class ApnSettingsLayoutBinding implements ViewBinding {
    public final OButton itemApnReset;
    private final RelativeLayout rootView;
    public final OListView viewList;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ApnSettingsLayoutBinding(RelativeLayout r1, OButton r2, OListView r3, OFloatingTitleBar r4) {
        this.rootView = r1;
        this.itemApnReset = r2;
        this.viewList = r3;
        this.viewTitle = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ApnSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ApnSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.apn_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ApnSettingsLayoutBinding bind(View r4) {
        int r0 = R.id.item_apn_reset;
        OButton r1 = (OButton) ViewBindings.findChildViewById(r4, R.id.item_apn_reset);
        if (r1 == null) goto L11;
        r0 = R.id.view_list;
        OListView r2 = (OListView) ViewBindings.findChildViewById(r4, R.id.view_list);
        if (r2 == null) goto L11;
        r0 = R.id.view_title;
        OFloatingTitleBar r3 = (OFloatingTitleBar) ViewBindings.findChildViewById(r4, R.id.view_title);
        if (r3 == null) goto L11;
        return new ApnSettingsLayoutBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
