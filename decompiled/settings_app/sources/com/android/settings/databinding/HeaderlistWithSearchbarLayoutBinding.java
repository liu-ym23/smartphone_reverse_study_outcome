package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.SearchBarEx;
import com.android.settings.widget.SlideListView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.QuickBar;

/* JADX INFO: loaded from: classes2.dex */
public final class HeaderlistWithSearchbarLayoutBinding implements ViewBinding {
    public final SlideListView listView;
    public final QuickBar quickbar;
    private final RelativeLayout rootView;
    public final ImageView searchBarShadow;
    public final FrameLayout searchOrOptionBar;
    public final SearchBarEx searchbar;
    public final TextView viewEmpty;
    public final OFloatingTitleBar viewTitle;
    public final RelativeLayout wholeView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private HeaderlistWithSearchbarLayoutBinding(RelativeLayout r1, SlideListView r2, QuickBar r3, ImageView r4, FrameLayout r5, SearchBarEx r6, TextView r7, OFloatingTitleBar r8, RelativeLayout r9) {
        this.rootView = r1;
        this.listView = r2;
        this.quickbar = r3;
        this.searchBarShadow = r4;
        this.searchOrOptionBar = r5;
        this.searchbar = r6;
        this.viewEmpty = r7;
        this.viewTitle = r8;
        this.wholeView = r9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static HeaderlistWithSearchbarLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static HeaderlistWithSearchbarLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.headerlist_with_searchbar_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static HeaderlistWithSearchbarLayoutBinding bind(View r12) {
        int r0 = R.id.listView;
        SlideListView r4 = (SlideListView) ViewBindings.findChildViewById(r12, R.id.listView);
        if (r4 == null) goto L19;
        r0 = R.id.quickbar;
        QuickBar r5 = (QuickBar) ViewBindings.findChildViewById(r12, R.id.quickbar);
        if (r5 == null) goto L19;
        r0 = R.id.search_bar_shadow;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r12, R.id.search_bar_shadow);
        if (r6 == null) goto L19;
        r0 = R.id.search_or_option_bar;
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(r12, R.id.search_or_option_bar);
        if (r7 == null) goto L19;
        r0 = R.id.searchbar;
        SearchBarEx r8 = (SearchBarEx) ViewBindings.findChildViewById(r12, R.id.searchbar);
        if (r8 == null) goto L19;
        r0 = R.id.view_empty;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r12, R.id.view_empty);
        if (r9 == null) goto L19;
        r0 = R.id.view_title;
        OFloatingTitleBar r10 = (OFloatingTitleBar) ViewBindings.findChildViewById(r12, R.id.view_title);
        if (r10 == null) goto L19;
        RelativeLayout r11 = (RelativeLayout) r12;
        return new HeaderlistWithSearchbarLayoutBinding(r11, r4, r5, r6, r7, r8, r9, r10, r11);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }
}
