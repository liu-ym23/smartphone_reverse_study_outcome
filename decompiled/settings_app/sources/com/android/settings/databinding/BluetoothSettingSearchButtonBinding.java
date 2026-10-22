package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OListItemSettings;

/* JADX INFO: loaded from: classes2.dex */
public final class BluetoothSettingSearchButtonBinding implements ViewBinding {
    public final OListItemSettings btnShowHiddenDevices;
    private final RelativeLayout rootView;
    public final OButton searchView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private BluetoothSettingSearchButtonBinding(RelativeLayout r1, OListItemSettings r2, OButton r3) {
        this.rootView = r1;
        this.btnShowHiddenDevices = r2;
        this.searchView = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BluetoothSettingSearchButtonBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static BluetoothSettingSearchButtonBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.bluetooth_setting_search_button, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static BluetoothSettingSearchButtonBinding bind(View r3) {
        int r0 = R.id.btn_show_hidden_devices;
        OListItemSettings r1 = (OListItemSettings) ViewBindings.findChildViewById(r3, R.id.btn_show_hidden_devices);
        if (r1 == null) goto L9;
        r0 = R.id.search_view;
        OButton r2 = (OButton) ViewBindings.findChildViewById(r3, R.id.search_view);
        if (r2 == null) goto L9;
        return new BluetoothSettingSearchButtonBinding((RelativeLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
