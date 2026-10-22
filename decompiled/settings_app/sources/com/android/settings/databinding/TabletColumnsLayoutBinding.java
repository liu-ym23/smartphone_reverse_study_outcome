package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.tablet.navigationlist.NavigationListView;
import obric.tablet.widget.SearchBar;

/* JADX INFO: loaded from: classes2.dex */
public final class TabletColumnsLayoutBinding implements ViewBinding {
    public final RelativeLayout firstColumn;
    public final ImageView firstColumnShadowIv;
    public final View firstDivider;
    public final RelativeLayout fragmentContainerView;
    public final NavigationListView navigationList;
    private final View rootView;
    public final SearchBar searchBar;
    public final LinearLayout secondColumn;
    public final View secondDivider;
    public final ViewStub settingBarStub;
    public final RelativeLayout thirdColumn;

    private TabletColumnsLayoutBinding(View r1, RelativeLayout r2, ImageView r3, View r4, RelativeLayout r5, NavigationListView r6, SearchBar r7, LinearLayout r8, View r9, ViewStub r10, RelativeLayout r11) {
        this.rootView = r1;
        this.firstColumn = r2;
        this.firstColumnShadowIv = r3;
        this.firstDivider = r4;
        this.fragmentContainerView = r5;
        this.navigationList = r6;
        this.searchBar = r7;
        this.secondColumn = r8;
        this.secondDivider = r9;
        this.settingBarStub = r10;
        this.thirdColumn = r11;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static TabletColumnsLayoutBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.tablet_columns_layout, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static TabletColumnsLayoutBinding bind(View r14) {
        int r0 = R.id.first_column;
        RelativeLayout r4 = (RelativeLayout) ViewBindings.findChildViewById(r14, R.id.first_column);
        if (r4 == null) goto L25;
        r0 = R.id.first_column_shadow_iv;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r14, R.id.first_column_shadow_iv);
        if (r5 == null) goto L25;
        r0 = R.id.first_divider;
        View r6 = ViewBindings.findChildViewById(r14, R.id.first_divider);
        if (r6 == null) goto L25;
        r0 = R.id.fragment_container_view;
        RelativeLayout r7 = (RelativeLayout) ViewBindings.findChildViewById(r14, R.id.fragment_container_view);
        if (r7 == null) goto L25;
        r0 = R.id.navigation_list;
        NavigationListView r8 = (NavigationListView) ViewBindings.findChildViewById(r14, R.id.navigation_list);
        if (r8 == null) goto L25;
        r0 = R.id.search_bar;
        SearchBar r9 = (SearchBar) ViewBindings.findChildViewById(r14, R.id.search_bar);
        if (r9 == null) goto L25;
        r0 = R.id.second_column;
        LinearLayout r10 = (LinearLayout) ViewBindings.findChildViewById(r14, R.id.second_column);
        if (r10 == null) goto L25;
        r0 = R.id.second_divider;
        View r11 = ViewBindings.findChildViewById(r14, R.id.second_divider);
        if (r11 == null) goto L25;
        r0 = R.id.setting_bar_stub;
        ViewStub r12 = (ViewStub) ViewBindings.findChildViewById(r14, R.id.setting_bar_stub);
        if (r12 == null) goto L25;
        r0 = R.id.third_column;
        RelativeLayout r13 = (RelativeLayout) ViewBindings.findChildViewById(r14, R.id.third_column);
        if (r13 == null) goto L25;
        return new TabletColumnsLayoutBinding(r14, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r0)));
    }
}
