package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.SettingItemButton;

/* JADX INFO: loaded from: classes2.dex */
public final class PreferredActivityDetailsFooterBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final TextView textView1;
    public final SettingItemButton textView2;
    public final TextView textView3;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PreferredActivityDetailsFooterBinding(RelativeLayout r1, TextView r2, SettingItemButton r3, TextView r4) {
        this.rootView = r1;
        this.textView1 = r2;
        this.textView2 = r3;
        this.textView3 = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static PreferredActivityDetailsFooterBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PreferredActivityDetailsFooterBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.preferred_activity_details_footer, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PreferredActivityDetailsFooterBinding bind(View r4) {
        int r0 = R.id.textView1;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r4, R.id.textView1);
        if (r1 == null) goto L11;
        r0 = R.id.textView2;
        SettingItemButton r2 = (SettingItemButton) ViewBindings.findChildViewById(r4, R.id.textView2);
        if (r2 == null) goto L11;
        r0 = R.id.textView3;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r4, R.id.textView3);
        if (r3 == null) goto L11;
        return new PreferredActivityDetailsFooterBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
