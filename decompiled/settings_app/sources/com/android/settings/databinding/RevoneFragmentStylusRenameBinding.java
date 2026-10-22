package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.SettingItemButton;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class RevoneFragmentStylusRenameBinding implements ViewBinding {
    public final SettingItemButton btnUnpair;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final SettingItemText stylusRename;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RevoneFragmentStylusRenameBinding(RelativeLayout r1, SettingItemButton r2, LinearLayout r3, OScrollView r4, SettingItemText r5, OFloatingTitleBar r6) {
        this.rootView = r1;
        this.btnUnpair = r2;
        this.pageContainer = r3;
        this.pageScrollview = r4;
        this.stylusRename = r5;
        this.viewTitle = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static RevoneFragmentStylusRenameBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RevoneFragmentStylusRenameBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.revone_fragment_stylus_rename, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RevoneFragmentStylusRenameBinding bind(View r9) {
        int r0 = R.id.btn_unpair;
        SettingItemButton r4 = (SettingItemButton) ViewBindings.findChildViewById(r9, R.id.btn_unpair);
        if (r4 == null) goto L15;
        r0 = R.id.page_container;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r9, R.id.page_container);
        if (r5 == null) goto L15;
        r0 = R.id.page_scrollview;
        OScrollView r6 = (OScrollView) ViewBindings.findChildViewById(r9, R.id.page_scrollview);
        if (r6 == null) goto L15;
        r0 = R.id.stylus_rename;
        SettingItemText r7 = (SettingItemText) ViewBindings.findChildViewById(r9, R.id.stylus_rename);
        if (r7 == null) goto L15;
        r0 = R.id.view_title;
        OFloatingTitleBar r8 = (OFloatingTitleBar) ViewBindings.findChildViewById(r9, R.id.view_title);
        if (r8 == null) goto L15;
        return new RevoneFragmentStylusRenameBinding((RelativeLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
