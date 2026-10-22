package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.CustomExpandableLinearLayout;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class PhoneCaseShortcutSettingsLayoutBinding implements ViewBinding {
    public final CustomExpandableLinearLayout idShortcutAccessibility;
    public final CustomExpandableLinearLayout idShortcutApplication;
    public final CustomExpandableLinearLayout idShortcutOption;
    public final CustomExpandableLinearLayout idShortcutTool;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PhoneCaseShortcutSettingsLayoutBinding(RelativeLayout r1, CustomExpandableLinearLayout r2, CustomExpandableLinearLayout r3, CustomExpandableLinearLayout r4, CustomExpandableLinearLayout r5, OFloatingTitleBar r6) {
        this.rootView = r1;
        this.idShortcutAccessibility = r2;
        this.idShortcutApplication = r3;
        this.idShortcutOption = r4;
        this.idShortcutTool = r5;
        this.viewTitle = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static PhoneCaseShortcutSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PhoneCaseShortcutSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.phone_case_shortcut_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PhoneCaseShortcutSettingsLayoutBinding bind(View r9) {
        int r0 = R.id.id_shortcut_accessibility;
        CustomExpandableLinearLayout r4 = (CustomExpandableLinearLayout) ViewBindings.findChildViewById(r9, R.id.id_shortcut_accessibility);
        if (r4 == null) goto L15;
        r0 = R.id.id_shortcut_application;
        CustomExpandableLinearLayout r5 = (CustomExpandableLinearLayout) ViewBindings.findChildViewById(r9, R.id.id_shortcut_application);
        if (r5 == null) goto L15;
        r0 = R.id.id_shortcut_option;
        CustomExpandableLinearLayout r6 = (CustomExpandableLinearLayout) ViewBindings.findChildViewById(r9, R.id.id_shortcut_option);
        if (r6 == null) goto L15;
        r0 = R.id.id_shortcut_tool;
        CustomExpandableLinearLayout r7 = (CustomExpandableLinearLayout) ViewBindings.findChildViewById(r9, R.id.id_shortcut_tool);
        if (r7 == null) goto L15;
        r0 = R.id.view_title;
        OFloatingTitleBar r8 = (OFloatingTitleBar) ViewBindings.findChildViewById(r9, R.id.view_title);
        if (r8 == null) goto L15;
        return new PhoneCaseShortcutSettingsLayoutBinding((RelativeLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
