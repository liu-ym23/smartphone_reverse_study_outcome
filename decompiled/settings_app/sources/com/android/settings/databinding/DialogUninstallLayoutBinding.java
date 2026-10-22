package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class DialogUninstallLayoutBinding implements ViewBinding {
    public final TextView idDlgMsgTv;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DialogUninstallLayoutBinding(LinearLayout r1, TextView r2) {
        this.rootView = r1;
        this.idDlgMsgTv = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogUninstallLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DialogUninstallLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.dialog_uninstall_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DialogUninstallLayoutBinding bind(View r2) {
        TextView r1 = (TextView) ViewBindings.findChildViewById(r2, R.id.id_dlg_msg_tv);
        if (r1 == null) goto L7;
        return new DialogUninstallLayoutBinding((LinearLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.id_dlg_msg_tv)));
    }
}
