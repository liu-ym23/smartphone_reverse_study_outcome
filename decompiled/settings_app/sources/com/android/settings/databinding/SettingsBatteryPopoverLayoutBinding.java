package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;

/* JADX INFO: loaded from: classes2.dex */
public final class SettingsBatteryPopoverLayoutBinding implements ViewBinding {
    public final OCardListItem neverBtn;
    private final LinearLayout rootView;
    public final OCardListItem screenOffBtn;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SettingsBatteryPopoverLayoutBinding(LinearLayout r1, OCardListItem r2, OCardListItem r3) {
        this.rootView = r1;
        this.neverBtn = r2;
        this.screenOffBtn = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SettingsBatteryPopoverLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SettingsBatteryPopoverLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.settings_battery_popover_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SettingsBatteryPopoverLayoutBinding bind(View r3) {
        int r0 = R.id.never_btn;
        OCardListItem r1 = (OCardListItem) ViewBindings.findChildViewById(r3, R.id.never_btn);
        if (r1 == null) goto L9;
        r0 = R.id.screen_off_btn;
        OCardListItem r2 = (OCardListItem) ViewBindings.findChildViewById(r3, R.id.screen_off_btn);
        if (r2 == null) goto L9;
        return new SettingsBatteryPopoverLayoutBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
