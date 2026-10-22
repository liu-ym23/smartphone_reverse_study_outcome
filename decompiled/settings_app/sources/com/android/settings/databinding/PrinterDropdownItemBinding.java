package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class PrinterDropdownItemBinding implements ViewBinding {
    public final ImageView icon;
    public final LinearLayout moreInfo;
    private final LinearLayout rootView;
    public final TextView subtitle;
    public final TextView title;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PrinterDropdownItemBinding(LinearLayout r1, ImageView r2, LinearLayout r3, TextView r4, TextView r5) {
        this.rootView = r1;
        this.icon = r2;
        this.moreInfo = r3;
        this.subtitle = r4;
        this.title = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PrinterDropdownItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PrinterDropdownItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.printer_dropdown_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PrinterDropdownItemBinding bind(View r8) {
        int r0 = R.id.icon;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r8, R.id.icon);
        if (r4 == null) goto L13;
        r0 = R.id.more_info;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r8, R.id.more_info);
        if (r5 == null) goto L13;
        r0 = R.id.subtitle;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r8, R.id.subtitle);
        if (r6 == null) goto L13;
        r0 = R.id.title;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r8, R.id.title);
        if (r7 == null) goto L13;
        return new PrinterDropdownItemBinding((LinearLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
