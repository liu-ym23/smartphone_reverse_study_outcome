package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.VerticalOptionsCheckView;
import obric.widget.PreviewOptionsCheckView;

/* JADX INFO: loaded from: classes2.dex */
public final class SidekeySettingsHeaderLayoutBinding implements ViewBinding {
    public final TextView headerText;
    private final LinearLayout rootView;
    public final VerticalOptionsCheckView volumeChooserSettings;
    public final PreviewOptionsCheckView volumeKeyChooser;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SidekeySettingsHeaderLayoutBinding(LinearLayout r1, TextView r2, VerticalOptionsCheckView r3, PreviewOptionsCheckView r4) {
        this.rootView = r1;
        this.headerText = r2;
        this.volumeChooserSettings = r3;
        this.volumeKeyChooser = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SidekeySettingsHeaderLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SidekeySettingsHeaderLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.sidekey_settings_header_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SidekeySettingsHeaderLayoutBinding bind(View r4) {
        int r0 = R.id.header_text;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r4, R.id.header_text);
        if (r1 == null) goto L11;
        r0 = R.id.volume_chooser_settings;
        VerticalOptionsCheckView r2 = (VerticalOptionsCheckView) ViewBindings.findChildViewById(r4, R.id.volume_chooser_settings);
        if (r2 == null) goto L11;
        r0 = R.id.volume_key_chooser;
        PreviewOptionsCheckView r3 = (PreviewOptionsCheckView) ViewBindings.findChildViewById(r4, R.id.volume_key_chooser);
        if (r3 == null) goto L11;
        return new SidekeySettingsHeaderLayoutBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
