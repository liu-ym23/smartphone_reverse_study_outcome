package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.stickylistheaders.StickyListHeadersListView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SearchBar;
import obric.widget.letters.QuickBarEx;

/* JADX INFO: loaded from: classes2.dex */
public final class DisplayAreaAppsFragmentLayoutBinding implements ViewBinding {
    public final StickyListHeadersListView idAppList;
    public final SearchBar idSearchBar;
    public final QuickBarEx quickbar;
    private final RelativeLayout rootView;
    public final TitleSecondaryBarShadowBinding searchBarShadow;
    public final TextView viewEmpty;
    public final OFloatingTitleBar viewTitle;
    public final RelativeLayout wholeView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DisplayAreaAppsFragmentLayoutBinding(RelativeLayout r1, StickyListHeadersListView r2, SearchBar r3, QuickBarEx r4, TitleSecondaryBarShadowBinding r5, TextView r6, OFloatingTitleBar r7, RelativeLayout r8) {
        this.rootView = r1;
        this.idAppList = r2;
        this.idSearchBar = r3;
        this.quickbar = r4;
        this.searchBarShadow = r5;
        this.viewEmpty = r6;
        this.viewTitle = r7;
        this.wholeView = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DisplayAreaAppsFragmentLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DisplayAreaAppsFragmentLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.display_area_apps_fragment_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DisplayAreaAppsFragmentLayoutBinding bind(View r11) {
        int r0 = R.id.id_app_list;
        StickyListHeadersListView r4 = (StickyListHeadersListView) ViewBindings.findChildViewById(r11, R.id.id_app_list);
        if (r4 == null) goto L17;
        r0 = R.id.id_search_bar;
        SearchBar r5 = (SearchBar) ViewBindings.findChildViewById(r11, R.id.id_search_bar);
        if (r5 == null) goto L17;
        r0 = R.id.quickbar;
        QuickBarEx r6 = (QuickBarEx) ViewBindings.findChildViewById(r11, R.id.quickbar);
        if (r6 == null) goto L17;
        r0 = R.id.search_bar_shadow;
        View r1 = ViewBindings.findChildViewById(r11, R.id.search_bar_shadow);
        if (r1 == null) goto L17;
        TitleSecondaryBarShadowBinding r7 = TitleSecondaryBarShadowBinding.bind(r1);
        r0 = R.id.view_empty;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r11, R.id.view_empty);
        if (r8 == null) goto L17;
        r0 = R.id.view_title;
        OFloatingTitleBar r9 = (OFloatingTitleBar) ViewBindings.findChildViewById(r11, R.id.view_title);
        if (r9 == null) goto L17;
        RelativeLayout r10 = (RelativeLayout) r11;
        return new DisplayAreaAppsFragmentLayoutBinding(r10, r4, r5, r6, r7, r8, r9, r10);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
