package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;

/* JADX INFO: loaded from: classes2.dex */
public final class WifiApDialogBinding implements ViewBinding {
    public final Spinner chooseChannel;
    public final TextView hint;
    public final LinearLayout info;
    public final EditText password;
    private final OScrollView rootView;
    public final Spinner security;
    public final CheckBox showPassword;
    public final EditText ssid;
    public final LinearLayout type;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private WifiApDialogBinding(OScrollView r1, Spinner r2, TextView r3, LinearLayout r4, EditText r5, Spinner r6, CheckBox r7, EditText r8, LinearLayout r9) {
        this.rootView = r1;
        this.chooseChannel = r2;
        this.hint = r3;
        this.info = r4;
        this.password = r5;
        this.security = r6;
        this.showPassword = r7;
        this.ssid = r8;
        this.type = r9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public OScrollView getRoot() {
        return this.rootView;
    }

    public static WifiApDialogBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static WifiApDialogBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.wifi_ap_dialog, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static WifiApDialogBinding bind(View r12) {
        int r0 = R.id.choose_channel;
        Spinner r4 = (Spinner) ViewBindings.findChildViewById(r12, R.id.choose_channel);
        if (r4 == null) goto L21;
        r0 = R.id.hint;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r12, R.id.hint);
        if (r5 == null) goto L21;
        r0 = R.id.info;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r12, R.id.info);
        if (r6 == null) goto L21;
        r0 = R.id.password;
        EditText r7 = (EditText) ViewBindings.findChildViewById(r12, R.id.password);
        if (r7 == null) goto L21;
        r0 = R.id.security;
        Spinner r8 = (Spinner) ViewBindings.findChildViewById(r12, R.id.security);
        if (r8 == null) goto L21;
        r0 = R.id.show_password;
        CheckBox r9 = (CheckBox) ViewBindings.findChildViewById(r12, R.id.show_password);
        if (r9 == null) goto L21;
        r0 = R.id.ssid;
        EditText r10 = (EditText) ViewBindings.findChildViewById(r12, R.id.ssid);
        if (r10 == null) goto L21;
        r0 = R.id.type;
        LinearLayout r11 = (LinearLayout) ViewBindings.findChildViewById(r12, R.id.type);
        if (r11 == null) goto L21;
        return new WifiApDialogBinding((OScrollView) r12, r4, r5, r6, r7, r8, r9, r10, r11);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }
}
