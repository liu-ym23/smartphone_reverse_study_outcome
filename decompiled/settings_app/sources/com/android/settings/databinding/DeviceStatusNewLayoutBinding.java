package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class DeviceStatusNewLayoutBinding implements ViewBinding {
    public final LinearLayout constraintRootView;
    public final RelativeLayout deviceStatusRootView;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DeviceStatusNewLayoutBinding(RelativeLayout r1, LinearLayout r2, RelativeLayout r3, OScrollView r4, OFloatingTitleBar r5) {
        this.rootView = r1;
        this.constraintRootView = r2;
        this.deviceStatusRootView = r3;
        this.pageScrollview = r4;
        this.viewTitle = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DeviceStatusNewLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DeviceStatusNewLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.device_status_new_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DeviceStatusNewLayoutBinding bind(View r8) {
        int r0 = R.id.constraint_root_view;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r8, R.id.constraint_root_view);
        if (r4 == null) goto L11;
        RelativeLayout r5 = (RelativeLayout) r8;
        r0 = R.id.page_scrollview;
        OScrollView r6 = (OScrollView) ViewBindings.findChildViewById(r8, R.id.page_scrollview);
        if (r6 == null) goto L11;
        r0 = R.id.view_title;
        OFloatingTitleBar r7 = (OFloatingTitleBar) ViewBindings.findChildViewById(r8, R.id.view_title);
        if (r7 == null) goto L11;
        return new DeviceStatusNewLayoutBinding(r5, r4, r5, r6, r7);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
