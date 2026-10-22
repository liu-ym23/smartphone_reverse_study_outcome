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
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class LayoutResolutionSettingsBinding implements ViewBinding {
    public final OCardListItem autoItem;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OSectionTitleBar title;
    public final OCardListItem uhdItem;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private LayoutResolutionSettingsBinding(RelativeLayout r1, OCardListItem r2, LinearLayout r3, OScrollView r4, OSectionTitleBar r5, OCardListItem r6, OFloatingTitleBar r7) {
        this.rootView = r1;
        this.autoItem = r2;
        this.pageContainer = r3;
        this.pageScrollview = r4;
        this.title = r5;
        this.uhdItem = r6;
        this.viewTitle = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LayoutResolutionSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LayoutResolutionSettingsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.layout_resolution_settings, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static LayoutResolutionSettingsBinding bind(View r10) {
        int r0 = R.id.auto_item;
        OCardListItem r4 = (OCardListItem) ViewBindings.findChildViewById(r10, R.id.auto_item);
        if (r4 == null) goto L17;
        r0 = R.id.page_container;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r10, R.id.page_container);
        if (r5 == null) goto L17;
        r0 = R.id.page_scrollview;
        OScrollView r6 = (OScrollView) ViewBindings.findChildViewById(r10, R.id.page_scrollview);
        if (r6 == null) goto L17;
        r0 = R.id.title;
        OSectionTitleBar r7 = (OSectionTitleBar) ViewBindings.findChildViewById(r10, R.id.title);
        if (r7 == null) goto L17;
        r0 = R.id.uhd_item;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r10, R.id.uhd_item);
        if (r8 == null) goto L17;
        r0 = R.id.view_title;
        OFloatingTitleBar r9 = (OFloatingTitleBar) ViewBindings.findChildViewById(r10, R.id.view_title);
        if (r9 == null) goto L17;
        return new LayoutResolutionSettingsBinding((RelativeLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
