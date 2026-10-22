package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;

/* JADX INFO: loaded from: classes2.dex */
public final class WifiWpsDialogBinding implements ViewBinding {
    private final OScrollView rootView;
    public final Button wpsDialogBtn;
    public final TextView wpsDialogTxt;
    public final ProgressBar wpsProgressBar;
    public final ProgressBar wpsTimeoutBar;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private WifiWpsDialogBinding(OScrollView r1, Button r2, TextView r3, ProgressBar r4, ProgressBar r5) {
        this.rootView = r1;
        this.wpsDialogBtn = r2;
        this.wpsDialogTxt = r3;
        this.wpsProgressBar = r4;
        this.wpsTimeoutBar = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public OScrollView getRoot() {
        return this.rootView;
    }

    public static WifiWpsDialogBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static WifiWpsDialogBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.wifi_wps_dialog, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static WifiWpsDialogBinding bind(View r8) {
        int r0 = R.id.wps_dialog_btn;
        Button r4 = (Button) ViewBindings.findChildViewById(r8, R.id.wps_dialog_btn);
        if (r4 == null) goto L13;
        r0 = R.id.wps_dialog_txt;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r8, R.id.wps_dialog_txt);
        if (r5 == null) goto L13;
        r0 = R.id.wps_progress_bar;
        ProgressBar r6 = (ProgressBar) ViewBindings.findChildViewById(r8, R.id.wps_progress_bar);
        if (r6 == null) goto L13;
        r0 = R.id.wps_timeout_bar;
        ProgressBar r7 = (ProgressBar) ViewBindings.findChildViewById(r8, R.id.wps_timeout_bar);
        if (r7 == null) goto L13;
        return new WifiWpsDialogBinding((OScrollView) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
