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
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class FragmentStylusSearchBinding implements ViewBinding {
    public final SettingItemSwitch bluetoothSwitch;
    public final TextView btTips;
    public final LinearLayout pageContainer;
    private final RelativeLayout rootView;
    public final OScrollView scrollView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FragmentStylusSearchBinding(RelativeLayout r1, SettingItemSwitch r2, TextView r3, LinearLayout r4, OScrollView r5, OFloatingTitleBar r6) {
        this.rootView = r1;
        this.bluetoothSwitch = r2;
        this.btTips = r3;
        this.pageContainer = r4;
        this.scrollView = r5;
        this.viewTitle = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentStylusSearchBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FragmentStylusSearchBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.fragment_stylus_search, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FragmentStylusSearchBinding bind(View r9) {
        int r0 = R.id.bluetooth_switch;
        SettingItemSwitch r4 = (SettingItemSwitch) ViewBindings.findChildViewById(r9, R.id.bluetooth_switch);
        if (r4 == null) goto L15;
        r0 = R.id.bt_tips;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r9, R.id.bt_tips);
        if (r5 == null) goto L15;
        r0 = R.id.page_container;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r9, R.id.page_container);
        if (r6 == null) goto L15;
        r0 = R.id.scroll_view;
        OScrollView r7 = (OScrollView) ViewBindings.findChildViewById(r9, R.id.scroll_view);
        if (r7 == null) goto L15;
        r0 = R.id.view_title;
        OFloatingTitleBar r8 = (OFloatingTitleBar) ViewBindings.findChildViewById(r9, R.id.view_title);
        if (r8 == null) goto L15;
        return new FragmentStylusSearchBinding((RelativeLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
