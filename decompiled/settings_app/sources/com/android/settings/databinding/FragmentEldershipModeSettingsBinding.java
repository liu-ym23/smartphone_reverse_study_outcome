package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class FragmentEldershipModeSettingsBinding implements ViewBinding {
    public final ImageView bottomLine;
    public final OButton btnOk;
    public final LinearLayout llContainer;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FragmentEldershipModeSettingsBinding(RelativeLayout r1, ImageView r2, OButton r3, LinearLayout r4, OFloatingTitleBar r5) {
        this.rootView = r1;
        this.bottomLine = r2;
        this.btnOk = r3;
        this.llContainer = r4;
        this.viewTitle = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentEldershipModeSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FragmentEldershipModeSettingsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.fragment_eldership_mode_settings, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FragmentEldershipModeSettingsBinding bind(View r8) {
        int r0 = R.id.bottom_line;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r8, R.id.bottom_line);
        if (r4 == null) goto L13;
        r0 = R.id.btn_ok;
        OButton r5 = (OButton) ViewBindings.findChildViewById(r8, R.id.btn_ok);
        if (r5 == null) goto L13;
        r0 = R.id.ll_container;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r8, R.id.ll_container);
        if (r6 == null) goto L13;
        r0 = R.id.view_title;
        OFloatingTitleBar r7 = (OFloatingTitleBar) ViewBindings.findChildViewById(r8, R.id.view_title);
        if (r7 == null) goto L13;
        return new FragmentEldershipModeSettingsBinding((RelativeLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
