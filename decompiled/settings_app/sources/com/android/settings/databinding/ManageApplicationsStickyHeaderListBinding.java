package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.SlideListView;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OButtonGroup;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.indexscrollbar.OIndexScrollbar;
import com.obric.oui.searchbar.v2.OSearchBar;
import com.obric.oui.segmentedtab.OTabSegmentedLayout;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class ManageApplicationsStickyHeaderListBinding implements ViewBinding {
    public final OButton cancelButton;
    public final OCheckBox checkboxSelectAll;
    public final OIndexScrollbar indexScrollbar;
    public final SlideListView listView;
    public final FrameLayout mainPage;
    public final OFloatingTitleBar ocSearchbarContainer;
    public final RelativeLayout optionBar;
    public final TextView optionTitle;
    public final FrameLayout pageContainer;
    public final OTabSegmentedLayout profileTabs;
    public final LinearLayout profileTabsContainer;
    private final RelativeLayout rootView;
    public final LinearLayout searchBarContainer;
    public final OButtonGroup searchCancelButton;
    public final OSearchBar searchFieldBar;
    public final FrameLayout searchOrOptionBar;
    public final TextView viewEmpty;
    public final OFloatingTitleBar viewTitle;
    public final FrameLayout viewTitleContainer;
    public final RelativeLayout wholeView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ManageApplicationsStickyHeaderListBinding(RelativeLayout r3, OButton r4, OCheckBox r5, OIndexScrollbar r6, SlideListView r7, FrameLayout r8, OFloatingTitleBar r9, RelativeLayout r10, TextView r11, FrameLayout r12, OTabSegmentedLayout r13, LinearLayout r14, LinearLayout r15, OButtonGroup r16, OSearchBar r17, FrameLayout r18, TextView r19, OFloatingTitleBar r20, FrameLayout r21, RelativeLayout r22) {
        this.rootView = r3;
        this.cancelButton = r4;
        this.checkboxSelectAll = r5;
        this.indexScrollbar = r6;
        this.listView = r7;
        this.mainPage = r8;
        this.ocSearchbarContainer = r9;
        this.optionBar = r10;
        this.optionTitle = r11;
        this.pageContainer = r12;
        this.profileTabs = r13;
        this.profileTabsContainer = r14;
        this.searchBarContainer = r15;
        this.searchCancelButton = r16;
        this.searchFieldBar = r17;
        this.searchOrOptionBar = r18;
        this.viewEmpty = r19;
        this.viewTitle = r20;
        this.viewTitleContainer = r21;
        this.wholeView = r22;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ManageApplicationsStickyHeaderListBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ManageApplicationsStickyHeaderListBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.manage_applications_sticky_header_list, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ManageApplicationsStickyHeaderListBinding bind(View r24) {
        int r1 = R.id.cancel_button;
        OButton r5 = (OButton) ViewBindings.findChildViewById(r24, R.id.cancel_button);
        if (r5 == null) goto L41;
        r1 = R.id.checkbox_select_all;
        OCheckBox r6 = (OCheckBox) ViewBindings.findChildViewById(r24, R.id.checkbox_select_all);
        if (r6 == null) goto L41;
        r1 = R.id.index_scrollbar;
        OIndexScrollbar r7 = (OIndexScrollbar) ViewBindings.findChildViewById(r24, R.id.index_scrollbar);
        if (r7 == null) goto L41;
        r1 = R.id.listView;
        SlideListView r8 = (SlideListView) ViewBindings.findChildViewById(r24, R.id.listView);
        if (r8 == null) goto L41;
        r1 = R.id.main_page;
        FrameLayout r9 = (FrameLayout) ViewBindings.findChildViewById(r24, R.id.main_page);
        if (r9 == null) goto L41;
        r1 = R.id.oc_searchbar_container;
        OFloatingTitleBar r10 = (OFloatingTitleBar) ViewBindings.findChildViewById(r24, R.id.oc_searchbar_container);
        if (r10 == null) goto L41;
        r1 = R.id.option_bar;
        RelativeLayout r11 = (RelativeLayout) ViewBindings.findChildViewById(r24, R.id.option_bar);
        if (r11 == null) goto L41;
        r1 = R.id.option_title;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r24, R.id.option_title);
        if (r12 == null) goto L41;
        r1 = R.id.page_container;
        FrameLayout r13 = (FrameLayout) ViewBindings.findChildViewById(r24, R.id.page_container);
        if (r13 == null) goto L41;
        r1 = R.id.profile_tabs;
        OTabSegmentedLayout r14 = (OTabSegmentedLayout) ViewBindings.findChildViewById(r24, R.id.profile_tabs);
        if (r14 == null) goto L41;
        r1 = R.id.profile_tabs_container;
        LinearLayout r15 = (LinearLayout) ViewBindings.findChildViewById(r24, R.id.profile_tabs_container);
        if (r15 == null) goto L41;
        r1 = R.id.search_bar_container;
        LinearLayout r16 = (LinearLayout) ViewBindings.findChildViewById(r24, R.id.search_bar_container);
        if (r16 == null) goto L41;
        r1 = R.id.search_cancel_button;
        OButtonGroup r17 = (OButtonGroup) ViewBindings.findChildViewById(r24, R.id.search_cancel_button);
        if (r17 == null) goto L41;
        r1 = R.id.search_field_bar;
        OSearchBar r18 = (OSearchBar) ViewBindings.findChildViewById(r24, R.id.search_field_bar);
        if (r18 == null) goto L41;
        r1 = R.id.search_or_option_bar;
        FrameLayout r19 = (FrameLayout) ViewBindings.findChildViewById(r24, R.id.search_or_option_bar);
        if (r19 == null) goto L41;
        r1 = R.id.view_empty;
        TextView r20 = (TextView) ViewBindings.findChildViewById(r24, R.id.view_empty);
        if (r20 == null) goto L41;
        r1 = R.id.view_title;
        OFloatingTitleBar r21 = (OFloatingTitleBar) ViewBindings.findChildViewById(r24, R.id.view_title);
        if (r21 == null) goto L41;
        r1 = R.id.view_title_container;
        FrameLayout r22 = (FrameLayout) ViewBindings.findChildViewById(r24, R.id.view_title_container);
        if (r22 == null) goto L41;
        RelativeLayout r23 = (RelativeLayout) r24;
        return new ManageApplicationsStickyHeaderListBinding(r23, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23);
    L41:
        throw new NullPointerException("Missing required view with ID: ".concat(r24.getResources().getResourceName(r1)));
    }
}
