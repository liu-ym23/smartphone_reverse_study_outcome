package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.ListContentItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public final class KeyboardDefaultLocationSettingsBinding implements ViewBinding {
    public final ListContentItemCheck defaultLocationSettingDefault;
    public final ListContentItemCheck defaultLocationSettingLeft;
    public final ListContentItemCheck defaultLocationSettingRight;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private KeyboardDefaultLocationSettingsBinding(RelativeLayout r1, ListContentItemCheck r2, ListContentItemCheck r3, ListContentItemCheck r4, LinearLayout r5, OScrollView r6, OFloatingTitleBar r7) {
        this.rootView = r1;
        this.defaultLocationSettingDefault = r2;
        this.defaultLocationSettingLeft = r3;
        this.defaultLocationSettingRight = r4;
        this.pageContainer = r5;
        this.pageScrollview = r6;
        this.viewTitle = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static KeyboardDefaultLocationSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static KeyboardDefaultLocationSettingsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.keyboard_default_location_settings, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static KeyboardDefaultLocationSettingsBinding bind(View r10) {
        int r0 = R.id.default_location_setting_default;
        ListContentItemCheck r4 = (ListContentItemCheck) ViewBindings.findChildViewById(r10, R.id.default_location_setting_default);
        if (r4 == null) goto L17;
        r0 = R.id.default_location_setting_left;
        ListContentItemCheck r5 = (ListContentItemCheck) ViewBindings.findChildViewById(r10, R.id.default_location_setting_left);
        if (r5 == null) goto L17;
        r0 = R.id.default_location_setting_right;
        ListContentItemCheck r6 = (ListContentItemCheck) ViewBindings.findChildViewById(r10, R.id.default_location_setting_right);
        if (r6 == null) goto L17;
        r0 = R.id.page_container;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r10, R.id.page_container);
        if (r7 == null) goto L17;
        r0 = R.id.page_scrollview;
        OScrollView r8 = (OScrollView) ViewBindings.findChildViewById(r10, R.id.page_scrollview);
        if (r8 == null) goto L17;
        r0 = R.id.view_title;
        OFloatingTitleBar r9 = (OFloatingTitleBar) ViewBindings.findChildViewById(r10, R.id.view_title);
        if (r9 == null) goto L17;
        return new KeyboardDefaultLocationSettingsBinding((RelativeLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
