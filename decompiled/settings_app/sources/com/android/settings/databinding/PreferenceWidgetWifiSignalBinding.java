package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class PreferenceWidgetWifiSignalBinding implements ViewBinding {
    private final ImageView rootView;
    public final ImageView signal;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PreferenceWidgetWifiSignalBinding(ImageView r1, ImageView r2) {
        this.rootView = r1;
        this.signal = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ImageView getRoot() {
        return this.rootView;
    }

    public static PreferenceWidgetWifiSignalBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PreferenceWidgetWifiSignalBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.preference_widget_wifi_signal, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PreferenceWidgetWifiSignalBinding bind(View r1) {
        if (r1 == null) goto L6;
        ImageView r2 = (ImageView) r1;
        return new PreferenceWidgetWifiSignalBinding(r2, r2);
    L6:
        throw new NullPointerException("rootView");
    }
}
