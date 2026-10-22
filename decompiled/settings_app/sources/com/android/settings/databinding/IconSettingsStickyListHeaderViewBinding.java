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
public final class IconSettingsStickyListHeaderViewBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final View shadow;
    public final TextView stickyHeader;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private IconSettingsStickyListHeaderViewBinding(LinearLayout r1, View r2, TextView r3) {
        this.rootView = r1;
        this.shadow = r2;
        this.stickyHeader = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static IconSettingsStickyListHeaderViewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static IconSettingsStickyListHeaderViewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.icon_settings_sticky_list_header_view, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static IconSettingsStickyListHeaderViewBinding bind(View r3) {
        int r0 = R.id.shadow;
        View r1 = ViewBindings.findChildViewById(r3, R.id.shadow);
        if (r1 == null) goto L9;
        r0 = R.id.sticky_header;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r3, R.id.sticky_header);
        if (r2 == null) goto L9;
        return new IconSettingsStickyListHeaderViewBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
