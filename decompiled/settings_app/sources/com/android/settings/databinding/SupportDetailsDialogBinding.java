package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class SupportDetailsDialogBinding implements ViewBinding {
    public final TextView adminSupportDialogTitle;
    public final ImageView adminSupportIcon;
    public final TextView adminSupportMsg;
    public final Button button1;
    public final Button button2;
    public final Button button3;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SupportDetailsDialogBinding(LinearLayout r1, TextView r2, ImageView r3, TextView r4, Button r5, Button r6, Button r7) {
        this.rootView = r1;
        this.adminSupportDialogTitle = r2;
        this.adminSupportIcon = r3;
        this.adminSupportMsg = r4;
        this.button1 = r5;
        this.button2 = r6;
        this.button3 = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SupportDetailsDialogBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SupportDetailsDialogBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.support_details_dialog, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SupportDetailsDialogBinding bind(View r10) {
        int r0 = R.id.admin_support_dialog_title;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r10, R.id.admin_support_dialog_title);
        if (r4 == null) goto L17;
        r0 = R.id.admin_support_icon;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r10, R.id.admin_support_icon);
        if (r5 == null) goto L17;
        r0 = R.id.admin_support_msg;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r10, R.id.admin_support_msg);
        if (r6 == null) goto L17;
        r0 = android.R.id.button1;
        Button r7 = (Button) ViewBindings.findChildViewById(r10, android.R.id.button1);
        if (r7 == null) goto L17;
        r0 = android.R.id.button2;
        Button r8 = (Button) ViewBindings.findChildViewById(r10, android.R.id.button2);
        if (r8 == null) goto L17;
        r0 = android.R.id.button3;
        Button r9 = (Button) ViewBindings.findChildViewById(r10, android.R.id.button3);
        if (r9 == null) goto L17;
        return new SupportDetailsDialogBinding((LinearLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
