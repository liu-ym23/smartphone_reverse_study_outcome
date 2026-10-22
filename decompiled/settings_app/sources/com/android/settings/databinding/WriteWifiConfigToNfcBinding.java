package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class WriteWifiConfigToNfcBinding implements ViewBinding {
    public final EditText password;
    public final TextView passwordLabel;
    public final LinearLayout passwordLayout;
    public final ProgressBar progressBar;
    private final LinearLayout rootView;
    public final CheckBox showPassword;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private WriteWifiConfigToNfcBinding(LinearLayout r1, EditText r2, TextView r3, LinearLayout r4, ProgressBar r5, CheckBox r6) {
        this.rootView = r1;
        this.password = r2;
        this.passwordLabel = r3;
        this.passwordLayout = r4;
        this.progressBar = r5;
        this.showPassword = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static WriteWifiConfigToNfcBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static WriteWifiConfigToNfcBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.write_wifi_config_to_nfc, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static WriteWifiConfigToNfcBinding bind(View r9) {
        int r0 = R.id.password;
        EditText r4 = (EditText) ViewBindings.findChildViewById(r9, R.id.password);
        if (r4 == null) goto L15;
        r0 = R.id.password_label;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r9, R.id.password_label);
        if (r5 == null) goto L15;
        r0 = R.id.password_layout;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r9, R.id.password_layout);
        if (r6 == null) goto L15;
        r0 = R.id.progress_bar;
        ProgressBar r7 = (ProgressBar) ViewBindings.findChildViewById(r9, R.id.progress_bar);
        if (r7 == null) goto L15;
        r0 = R.id.show_password;
        CheckBox r8 = (CheckBox) ViewBindings.findChildViewById(r9, R.id.show_password);
        if (r8 == null) goto L15;
        return new WriteWifiConfigToNfcBinding((LinearLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
