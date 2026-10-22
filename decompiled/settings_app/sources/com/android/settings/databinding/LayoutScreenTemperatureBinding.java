package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.display.color.ScreenColorTemperatureEditView;
import com.obric.oui.tab.OTabLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class LayoutScreenTemperatureBinding implements ViewBinding {
    public final ScreenColorTemperatureEditView colorTemperatureEditView;
    public final OTabLayout ouiTabLayout;
    private final View rootView;

    private LayoutScreenTemperatureBinding(View r1, ScreenColorTemperatureEditView r2, OTabLayout r3) {
        this.rootView = r1;
        this.colorTemperatureEditView = r2;
        this.ouiTabLayout = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static LayoutScreenTemperatureBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.layout_screen_temperature, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static LayoutScreenTemperatureBinding bind(View r3) {
        int r0 = R.id.color_temperature_edit_view;
        ScreenColorTemperatureEditView r1 = (ScreenColorTemperatureEditView) ViewBindings.findChildViewById(r3, R.id.color_temperature_edit_view);
        if (r1 == null) goto L9;
        r0 = R.id.oui_tab_layout;
        OTabLayout r2 = (OTabLayout) ViewBindings.findChildViewById(r3, R.id.oui_tab_layout);
        if (r2 == null) goto L9;
        return new LayoutScreenTemperatureBinding(r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
