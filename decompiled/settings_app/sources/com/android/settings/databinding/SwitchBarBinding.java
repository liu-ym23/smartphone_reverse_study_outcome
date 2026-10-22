package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.ToggleSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class SwitchBarBinding implements ViewBinding {
    public final ImageView restrictedIcon;
    private final View rootView;
    public final TextView switchText;
    public final ToggleSwitch switchWidget;

    private SwitchBarBinding(View r1, ImageView r2, TextView r3, ToggleSwitch r4) {
        this.rootView = r1;
        this.restrictedIcon = r2;
        this.switchText = r3;
        this.switchWidget = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static SwitchBarBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.switch_bar, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static SwitchBarBinding bind(View r4) {
        int r0 = R.id.restricted_icon;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r4, R.id.restricted_icon);
        if (r1 == null) goto L11;
        r0 = R.id.switch_text;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r4, R.id.switch_text);
        if (r2 == null) goto L11;
        r0 = R.id.switch_widget;
        ToggleSwitch r3 = (ToggleSwitch) ViewBindings.findChildViewById(r4, R.id.switch_widget);
        if (r3 == null) goto L11;
        return new SwitchBarBinding(r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
