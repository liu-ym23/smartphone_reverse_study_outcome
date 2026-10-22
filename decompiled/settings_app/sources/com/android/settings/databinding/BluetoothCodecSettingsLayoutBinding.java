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
public final class BluetoothCodecSettingsLayoutBinding implements ViewBinding {
    public final LinearLayout pageContainer;
    private final RelativeLayout rootView;
    public final OScrollView scrollView;
    public final OFloatingTitleBar titleBar;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private BluetoothCodecSettingsLayoutBinding(RelativeLayout r1, LinearLayout r2, OScrollView r3, OFloatingTitleBar r4) {
        this.rootView = r1;
        this.pageContainer = r2;
        this.scrollView = r3;
        this.titleBar = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BluetoothCodecSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static BluetoothCodecSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.bluetooth_codec_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static BluetoothCodecSettingsLayoutBinding bind(View r4) {
        int r0 = R.id.page_container;
        LinearLayout r1 = (LinearLayout) ViewBindings.findChildViewById(r4, R.id.page_container);
        if (r1 == null) goto L11;
        r0 = R.id.scroll_view;
        OScrollView r2 = (OScrollView) ViewBindings.findChildViewById(r4, R.id.scroll_view);
        if (r2 == null) goto L11;
        r0 = R.id.title_bar;
        OFloatingTitleBar r3 = (OFloatingTitleBar) ViewBindings.findChildViewById(r4, R.id.title_bar);
        if (r3 == null) goto L11;
        return new BluetoothCodecSettingsLayoutBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
