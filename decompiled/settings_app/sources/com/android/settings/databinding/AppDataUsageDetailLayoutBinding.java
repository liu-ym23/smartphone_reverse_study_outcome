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
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class AppDataUsageDetailLayoutBinding implements ViewBinding {
    public final ManageApplicationsItemBinding appSnippet;
    public final OCardListItem idDataPermision;
    public final LinearLayout idPermSettingsContainer;
    public final OCardListItem idUseDataBackground;
    public final OCardListItem month;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OCardListItem today;
    public final OFloatingTitleBar viewTitle;
    public final OCardListItem week;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AppDataUsageDetailLayoutBinding(RelativeLayout r1, ManageApplicationsItemBinding r2, OCardListItem r3, LinearLayout r4, OCardListItem r5, OCardListItem r6, LinearLayout r7, OScrollView r8, OCardListItem r9, OFloatingTitleBar r10, OCardListItem r11) {
        this.rootView = r1;
        this.appSnippet = r2;
        this.idDataPermision = r3;
        this.idPermSettingsContainer = r4;
        this.idUseDataBackground = r5;
        this.month = r6;
        this.pageContainer = r7;
        this.pageScrollview = r8;
        this.today = r9;
        this.viewTitle = r10;
        this.week = r11;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AppDataUsageDetailLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AppDataUsageDetailLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.app_data_usage_detail_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AppDataUsageDetailLayoutBinding bind(View r14) {
        int r0 = R.id.app_snippet;
        View r1 = ViewBindings.findChildViewById(r14, R.id.app_snippet);
        if (r1 == null) goto L25;
        ManageApplicationsItemBinding r4 = ManageApplicationsItemBinding.bind(r1);
        r0 = R.id.id_data_permision;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r14, R.id.id_data_permision);
        if (r5 == null) goto L25;
        r0 = R.id.id_perm_settings_container;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r14, R.id.id_perm_settings_container);
        if (r6 == null) goto L25;
        r0 = R.id.id_use_data_background;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r14, R.id.id_use_data_background);
        if (r7 == null) goto L25;
        r0 = R.id.month;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r14, R.id.month);
        if (r8 == null) goto L25;
        r0 = R.id.page_container;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r14, R.id.page_container);
        if (r9 == null) goto L25;
        r0 = R.id.page_scrollview;
        OScrollView r10 = (OScrollView) ViewBindings.findChildViewById(r14, R.id.page_scrollview);
        if (r10 == null) goto L25;
        r0 = R.id.today;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r14, R.id.today);
        if (r11 == null) goto L25;
        r0 = R.id.view_title;
        OFloatingTitleBar r12 = (OFloatingTitleBar) ViewBindings.findChildViewById(r14, R.id.view_title);
        if (r12 == null) goto L25;
        r0 = R.id.week;
        OCardListItem r13 = (OCardListItem) ViewBindings.findChildViewById(r14, R.id.week);
        if (r13 == null) goto L25;
        return new AppDataUsageDetailLayoutBinding((RelativeLayout) r14, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r0)));
    }
}
