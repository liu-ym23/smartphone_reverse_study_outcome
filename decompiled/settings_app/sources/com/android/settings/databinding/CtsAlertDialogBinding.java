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
public final class CtsAlertDialogBinding implements ViewBinding {
    public final TextView message;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private CtsAlertDialogBinding(LinearLayout r1, TextView r2) {
        this.rootView = r1;
        this.message = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CtsAlertDialogBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static CtsAlertDialogBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.cts_alert_dialog, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static CtsAlertDialogBinding bind(View r2) {
        TextView r1 = (TextView) ViewBindings.findChildViewById(r2, android.R.id.message);
        if (r1 == null) goto L7;
        return new CtsAlertDialogBinding((LinearLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(android.R.id.message)));
    }
}
