package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class MainSettingsLayoutCtsBinding implements ViewBinding {
    public final Button done;
    public final FrameLayout fragmentContainerView;
    public final TextView panelTitle;
    private final RelativeLayout rootView;
    public final Button seeMore;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private MainSettingsLayoutCtsBinding(RelativeLayout r1, Button r2, FrameLayout r3, TextView r4, Button r5) {
        this.rootView = r1;
        this.done = r2;
        this.fragmentContainerView = r3;
        this.panelTitle = r4;
        this.seeMore = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MainSettingsLayoutCtsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static MainSettingsLayoutCtsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.main_settings_layout_cts, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static MainSettingsLayoutCtsBinding bind(View r8) {
        int r0 = R.id.done;
        Button r4 = (Button) ViewBindings.findChildViewById(r8, R.id.done);
        if (r4 == null) goto L13;
        r0 = R.id.fragment_container_view;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r8, R.id.fragment_container_view);
        if (r5 == null) goto L13;
        r0 = R.id.panel_title;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r8, R.id.panel_title);
        if (r6 == null) goto L13;
        r0 = R.id.see_more;
        Button r7 = (Button) ViewBindings.findChildViewById(r8, R.id.see_more);
        if (r7 == null) goto L13;
        return new MainSettingsLayoutCtsBinding((RelativeLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
