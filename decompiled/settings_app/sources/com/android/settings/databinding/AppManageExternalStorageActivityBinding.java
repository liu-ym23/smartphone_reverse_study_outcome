package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OListItemSwitch;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class AppManageExternalStorageActivityBinding implements ViewBinding {
    public final OListItemSwitch itemSwitch;
    public final LinearLayout loadingContainer;
    private final LinearLayout rootView;
    public final TextView tvDesc;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AppManageExternalStorageActivityBinding(LinearLayout r1, OListItemSwitch r2, LinearLayout r3, TextView r4, OFloatingTitleBar r5) {
        this.rootView = r1;
        this.itemSwitch = r2;
        this.loadingContainer = r3;
        this.tvDesc = r4;
        this.viewTitle = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AppManageExternalStorageActivityBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AppManageExternalStorageActivityBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.app_manage_external_storage_activity, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AppManageExternalStorageActivityBinding bind(View r8) {
        int r0 = R.id.item_switch;
        OListItemSwitch r4 = (OListItemSwitch) ViewBindings.findChildViewById(r8, R.id.item_switch);
        if (r4 == null) goto L13;
        r0 = R.id.loading_container;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r8, R.id.loading_container);
        if (r5 == null) goto L13;
        r0 = R.id.tv_desc;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r8, R.id.tv_desc);
        if (r6 == null) goto L13;
        r0 = R.id.view_title;
        OFloatingTitleBar r7 = (OFloatingTitleBar) ViewBindings.findChildViewById(r8, R.id.view_title);
        if (r7 == null) goto L13;
        return new AppManageExternalStorageActivityBinding((LinearLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
