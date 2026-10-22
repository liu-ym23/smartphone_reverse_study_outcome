package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class RevoneWifiInputPasswordBinding implements ViewBinding {
    public final Button btnBack;
    public final Button btnContinue;
    public final CheckBox checkboxShowPwd;
    public final FrameLayout layoutParent;
    private final FrameLayout rootView;
    public final TextView viewTitle;
    public final EditText wifiPwd;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RevoneWifiInputPasswordBinding(FrameLayout r1, Button r2, Button r3, CheckBox r4, FrameLayout r5, TextView r6, EditText r7) {
        this.rootView = r1;
        this.btnBack = r2;
        this.btnContinue = r3;
        this.checkboxShowPwd = r4;
        this.layoutParent = r5;
        this.viewTitle = r6;
        this.wifiPwd = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static RevoneWifiInputPasswordBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RevoneWifiInputPasswordBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.revone_wifi_input_password, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RevoneWifiInputPasswordBinding bind(View r10) {
        int r0 = R.id.btn_back;
        Button r4 = (Button) ViewBindings.findChildViewById(r10, R.id.btn_back);
        if (r4 == null) goto L15;
        r0 = R.id.btn_continue;
        Button r5 = (Button) ViewBindings.findChildViewById(r10, R.id.btn_continue);
        if (r5 == null) goto L15;
        r0 = R.id.checkbox_show_pwd;
        CheckBox r6 = (CheckBox) ViewBindings.findChildViewById(r10, R.id.checkbox_show_pwd);
        if (r6 == null) goto L15;
        FrameLayout r7 = (FrameLayout) r10;
        r0 = R.id.view_title;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r10, R.id.view_title);
        if (r8 == null) goto L15;
        r0 = R.id.wifi_pwd;
        EditText r9 = (EditText) ViewBindings.findChildViewById(r10, R.id.wifi_pwd);
        if (r9 == null) goto L15;
        return new RevoneWifiInputPasswordBinding(r7, r4, r5, r6, r7, r8, r9);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
