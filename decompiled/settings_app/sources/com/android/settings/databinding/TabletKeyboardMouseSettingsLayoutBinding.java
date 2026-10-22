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
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class TabletKeyboardMouseSettingsLayoutBinding implements ViewBinding {
    public final SettingItemText idKeyboard;
    public final SettingItemText idKeyboardMouse;
    public final SettingItemText idMouse;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private TabletKeyboardMouseSettingsLayoutBinding(RelativeLayout r1, SettingItemText r2, SettingItemText r3, SettingItemText r4, LinearLayout r5, OScrollView r6, OFloatingTitleBar r7) {
        this.rootView = r1;
        this.idKeyboard = r2;
        this.idKeyboardMouse = r3;
        this.idMouse = r4;
        this.pageContainer = r5;
        this.pageScrollview = r6;
        this.viewTitle = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static TabletKeyboardMouseSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static TabletKeyboardMouseSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.tablet_keyboard_mouse_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static TabletKeyboardMouseSettingsLayoutBinding bind(View r10) {
        int r0 = R.id.id_keyboard;
        SettingItemText r4 = (SettingItemText) ViewBindings.findChildViewById(r10, R.id.id_keyboard);
        if (r4 == null) goto L17;
        r0 = R.id.id_keyboard_mouse;
        SettingItemText r5 = (SettingItemText) ViewBindings.findChildViewById(r10, R.id.id_keyboard_mouse);
        if (r5 == null) goto L17;
        r0 = R.id.id_mouse;
        SettingItemText r6 = (SettingItemText) ViewBindings.findChildViewById(r10, R.id.id_mouse);
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
        return new TabletKeyboardMouseSettingsLayoutBinding((RelativeLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
