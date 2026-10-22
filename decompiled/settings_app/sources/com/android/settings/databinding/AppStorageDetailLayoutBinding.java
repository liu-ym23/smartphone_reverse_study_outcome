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
public final class AppStorageDetailLayoutBinding implements ViewBinding {
    public final ManageApplicationsItemBinding appSnippet;
    public final OCardListItem applicationSize;
    public final OCardListItem cacheSize;
    public final OCardListItem clearCacheButton;
    public final OCardListItem externalCodeSize;
    public final OCardListItem externalDataSizePrefix;
    public final OCardListItem infoSize;
    public final OCardListItem leftButton;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final OCardListItem rightButton;
    private final RelativeLayout rootView;
    public final OCardListItem totalSize;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AppStorageDetailLayoutBinding(RelativeLayout r1, ManageApplicationsItemBinding r2, OCardListItem r3, OCardListItem r4, OCardListItem r5, OCardListItem r6, OCardListItem r7, OCardListItem r8, OCardListItem r9, LinearLayout r10, OScrollView r11, OCardListItem r12, OCardListItem r13, OFloatingTitleBar r14) {
        this.rootView = r1;
        this.appSnippet = r2;
        this.applicationSize = r3;
        this.cacheSize = r4;
        this.clearCacheButton = r5;
        this.externalCodeSize = r6;
        this.externalDataSizePrefix = r7;
        this.infoSize = r8;
        this.leftButton = r9;
        this.pageContainer = r10;
        this.pageScrollview = r11;
        this.rightButton = r12;
        this.totalSize = r13;
        this.viewTitle = r14;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AppStorageDetailLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AppStorageDetailLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.app_storage_detail_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AppStorageDetailLayoutBinding bind(View r18) {
        int r1 = R.id.app_snippet;
        View r2 = ViewBindings.findChildViewById(r18, R.id.app_snippet);
        if (r2 == null) goto L31;
        ManageApplicationsItemBinding r5 = ManageApplicationsItemBinding.bind(r2);
        r1 = R.id.application_size;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.application_size);
        if (r6 == null) goto L31;
        r1 = R.id.cache_size;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.cache_size);
        if (r7 == null) goto L31;
        r1 = R.id.clear_cache_button;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.clear_cache_button);
        if (r8 == null) goto L31;
        r1 = R.id.external_code_size;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.external_code_size);
        if (r9 == null) goto L31;
        r1 = R.id.external_data_size_prefix;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.external_data_size_prefix);
        if (r10 == null) goto L31;
        r1 = R.id.info_size;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.info_size);
        if (r11 == null) goto L31;
        r1 = R.id.left_button;
        OCardListItem r12 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.left_button);
        if (r12 == null) goto L31;
        r1 = R.id.page_container;
        LinearLayout r13 = (LinearLayout) ViewBindings.findChildViewById(r18, R.id.page_container);
        if (r13 == null) goto L31;
        r1 = R.id.page_scrollview;
        OScrollView r14 = (OScrollView) ViewBindings.findChildViewById(r18, R.id.page_scrollview);
        if (r14 == null) goto L31;
        r1 = R.id.right_button;
        OCardListItem r15 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.right_button);
        if (r15 == null) goto L31;
        r1 = R.id.total_size;
        OCardListItem r16 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.total_size);
        if (r16 == null) goto L31;
        r1 = R.id.view_title;
        OFloatingTitleBar r17 = (OFloatingTitleBar) ViewBindings.findChildViewById(r18, R.id.view_title);
        if (r17 == null) goto L31;
        return new AppStorageDetailLayoutBinding((RelativeLayout) r18, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    L31:
        throw new NullPointerException("Missing required view with ID: ".concat(r18.getResources().getResourceName(r1)));
    }
}
