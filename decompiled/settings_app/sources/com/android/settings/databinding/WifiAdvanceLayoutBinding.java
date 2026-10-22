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
public final class WifiAdvanceLayoutBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView summary;
    public final TextView title;
    public final LinearLayout widgetFrame;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private WifiAdvanceLayoutBinding(LinearLayout r1, TextView r2, TextView r3, LinearLayout r4) {
        this.rootView = r1;
        this.summary = r2;
        this.title = r3;
        this.widgetFrame = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static WifiAdvanceLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static WifiAdvanceLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.wifi_advance_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static WifiAdvanceLayoutBinding bind(View r4) {
        int r0 = android.R.id.summary;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r4, android.R.id.summary);
        if (r1 == null) goto L11;
        r0 = android.R.id.title;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r4, android.R.id.title);
        if (r2 == null) goto L11;
        r0 = android.R.id.widget_frame;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(r4, android.R.id.widget_frame);
        if (r3 == null) goto L11;
        return new WifiAdvanceLayoutBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
