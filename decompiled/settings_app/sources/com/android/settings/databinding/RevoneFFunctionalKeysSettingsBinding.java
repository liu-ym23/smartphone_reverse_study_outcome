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
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class RevoneFFunctionalKeysSettingsBinding implements ViewBinding {
    public final SettingItemText btnF1;
    public final SettingItemText btnF10;
    public final SettingItemText btnF11;
    public final SettingItemText btnF12;
    public final SettingItemText btnF2;
    public final SettingItemText btnF3;
    public final SettingItemText btnF4;
    public final SettingItemText btnF5;
    public final SettingItemText btnF6;
    public final SettingItemText btnF7;
    public final SettingItemText btnF8;
    public final SettingItemText btnF9;
    public final SettingItemSwitch fFunctionalKeys;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RevoneFFunctionalKeysSettingsBinding(RelativeLayout r3, SettingItemText r4, SettingItemText r5, SettingItemText r6, SettingItemText r7, SettingItemText r8, SettingItemText r9, SettingItemText r10, SettingItemText r11, SettingItemText r12, SettingItemText r13, SettingItemText r14, SettingItemText r15, SettingItemSwitch r16, LinearLayout r17, OScrollView r18, OFloatingTitleBar r19) {
        this.rootView = r3;
        this.btnF1 = r4;
        this.btnF10 = r5;
        this.btnF11 = r6;
        this.btnF12 = r7;
        this.btnF2 = r8;
        this.btnF3 = r9;
        this.btnF4 = r10;
        this.btnF5 = r11;
        this.btnF6 = r12;
        this.btnF7 = r13;
        this.btnF8 = r14;
        this.btnF9 = r15;
        this.fFunctionalKeys = r16;
        this.pageContainer = r17;
        this.pageScrollview = r18;
        this.viewTitle = r19;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static RevoneFFunctionalKeysSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RevoneFFunctionalKeysSettingsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.revone_f_functional_keys_settings, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RevoneFFunctionalKeysSettingsBinding bind(View r21) {
        int r1 = R.id.btn_f1;
        SettingItemText r5 = (SettingItemText) ViewBindings.findChildViewById(r21, R.id.btn_f1);
        if (r5 == null) goto L37;
        r1 = R.id.btn_f10;
        SettingItemText r6 = (SettingItemText) ViewBindings.findChildViewById(r21, R.id.btn_f10);
        if (r6 == null) goto L37;
        r1 = R.id.btn_f11;
        SettingItemText r7 = (SettingItemText) ViewBindings.findChildViewById(r21, R.id.btn_f11);
        if (r7 == null) goto L37;
        r1 = R.id.btn_f12;
        SettingItemText r8 = (SettingItemText) ViewBindings.findChildViewById(r21, R.id.btn_f12);
        if (r8 == null) goto L37;
        r1 = R.id.btn_f2;
        SettingItemText r9 = (SettingItemText) ViewBindings.findChildViewById(r21, R.id.btn_f2);
        if (r9 == null) goto L37;
        r1 = R.id.btn_f3;
        SettingItemText r10 = (SettingItemText) ViewBindings.findChildViewById(r21, R.id.btn_f3);
        if (r10 == null) goto L37;
        r1 = R.id.btn_f4;
        SettingItemText r11 = (SettingItemText) ViewBindings.findChildViewById(r21, R.id.btn_f4);
        if (r11 == null) goto L37;
        r1 = R.id.btn_f5;
        SettingItemText r12 = (SettingItemText) ViewBindings.findChildViewById(r21, R.id.btn_f5);
        if (r12 == null) goto L37;
        r1 = R.id.btn_f6;
        SettingItemText r13 = (SettingItemText) ViewBindings.findChildViewById(r21, R.id.btn_f6);
        if (r13 == null) goto L37;
        r1 = R.id.btn_f7;
        SettingItemText r14 = (SettingItemText) ViewBindings.findChildViewById(r21, R.id.btn_f7);
        if (r14 == null) goto L37;
        r1 = R.id.btn_f8;
        SettingItemText r15 = (SettingItemText) ViewBindings.findChildViewById(r21, R.id.btn_f8);
        if (r15 == null) goto L37;
        r1 = R.id.btn_f9;
        SettingItemText r16 = (SettingItemText) ViewBindings.findChildViewById(r21, R.id.btn_f9);
        if (r16 == null) goto L37;
        r1 = R.id.f_functional_keys;
        SettingItemSwitch r17 = (SettingItemSwitch) ViewBindings.findChildViewById(r21, R.id.f_functional_keys);
        if (r17 == null) goto L37;
        r1 = R.id.page_container;
        LinearLayout r18 = (LinearLayout) ViewBindings.findChildViewById(r21, R.id.page_container);
        if (r18 == null) goto L37;
        r1 = R.id.page_scrollview;
        OScrollView r19 = (OScrollView) ViewBindings.findChildViewById(r21, R.id.page_scrollview);
        if (r19 == null) goto L37;
        r1 = R.id.view_title;
        OFloatingTitleBar r20 = (OFloatingTitleBar) ViewBindings.findChildViewById(r21, R.id.view_title);
        if (r20 == null) goto L37;
        return new RevoneFFunctionalKeysSettingsBinding((RelativeLayout) r21, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
    L37:
        throw new NullPointerException("Missing required view with ID: ".concat(r21.getResources().getResourceName(r1)));
    }
}
